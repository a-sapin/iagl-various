#include <stdio.h>
#include <stdlib.h>

// Structure d'un noeud de l'AVL
typedef struct Noeud {
    int valeur;
    struct Noeud* gauche;
    struct Noeud* droite;
    int hauteur;
} Noeud;

// Fonction pour cr�er un nouveau noeud
Noeud* creerNoeud(int valeur) {
    Noeud* nouveauNoeud = (Noeud*)malloc(sizeof(Noeud));
    if (nouveauNoeud == NULL) {
        fprintf(stderr, "Erreur d'allocation de m�moire\n");
        exit(EXIT_FAILURE);
    }
    nouveauNoeud->valeur = valeur;
    nouveauNoeud->gauche = NULL;
    nouveauNoeud->droite = NULL;
    nouveauNoeud->hauteur = 1;
    return nouveauNoeud;
}

// Fonction pour calculer la hauteur d'un noeud
int hauteur(Noeud* N) {
    if (N == NULL)
        return 0;
    return N->hauteur;
}

// Fonction pour calculer le maximum de deux entiers
// Fonction pour effectuer une rotation � droite simple
Noeud* faireSimpleRotationADroite(Noeud* y) {
    Noeud* x = y->gauche;
    Noeud* T2 = x->droite;

    // Effectuer la rotation
    x->droite = y;
    y->gauche = T2;

    // Mettre � jour les hauteurs
    y->hauteur = sMax(hauteur(y->gauche), hauteur(y->droite)) + 1;
    x->hauteur = sMax(hauteur(x->gauche), hauteur(x->droite)) + 1;

    return x;
}

// Fonction pour effectuer une rotation � gauche simple
Noeud* faireSimpleRotationAGauche(Noeud* x) {
    Noeud* y = x->droite;
    Noeud* T2 = y->gauche;

    // Effectuer la rotation
    y->gauche = x;
    x->droite = T2;

    // Mettre � jour les hauteurs
    x->hauteur = sMax(hauteur(x->gauche), hauteur(x->droite)) + 1;
    y->hauteur = sMax(hauteur(y->gauche), hauteur(y->droite)) + 1;

    return y;
}

// Fonction pour effectuer une rotation � droite double
Noeud* faireDoubleRotationADroite(Noeud* z) {
    z->gauche = faireSimpleRotationAGauche(z->gauche);
    return faireSimpleRotationADroite(z);
}

// Fonction pour effectuer une rotation � gauche double
Noeud* faireDoubleRotationAGauche(Noeud* z) {
    z->droite = faireSimpleRotationADroite(z->droite);
    return faireSimpleRotationAGauche(z);
}

// Fonction pour �quilibrer un arbre AVL apr�s une insertion
Noeud* equilibrerArbre(Noeud* racine, int valeur) {
    int equilibre = hauteur(racine->gauche) - hauteur(racine->droite);

    // Rotation � droite simple
    if (equilibre > 1 && valeur < racine->gauche->valeur)
        return faireSimpleRotationADroite(racine);

    // Rotation � gauche simple
    if (equilibre < -1 && valeur > racine->droite->valeur)
        return faireSimpleRotationAGauche(racine);

    // Rotation � droite double
    if (equilibre > 1 && valeur > racine->gauche->valeur) {
        racine->gauche = faireSimpleRotationAGauche(racine->gauche);
        return faireSimpleRotationADroite(racine);
    }

    // Rotation � gauche double
    if (equilibre < -1 && valeur < racine->droite->valeur) {
        racine->droite = faireSimpleRotationADroite(racine->droite);
        return faireSimpleRotationAGauche(racine);
    }

    return racine;
}

// Fonction pour ins�rer une valeur dans l'arbre AVL
Noeud* inserer(Noeud* racine, int valeur) {
    if (racine == NULL)
        return creerNoeud(valeur);

    if (valeur < racine->valeur)
        racine->gauche = inserer(racine->gauche, valeur);
    else if (valeur > racine->valeur)
        racine->droite = inserer(racine->droite, valeur);
    else // Les valeurs �gales ne sont pas autoris�es
        return racine;

    // Mettre � jour la hauteur du noeud actuel
    racine->hauteur = 1 + sMax(hauteur(racine->gauche), hauteur(racine->droite));

    // �quilibrer l'arbre
    return equilibrerArbre(racine, valeur);
}

// Fonction pour trouver le successeur d'un noeud
Noeud* trouverSuccesseur(Noeud* racine) {
    Noeud* courant = racine;
    while (courant->gauche != NULL)
        courant = courant->gauche;
    return courant;
}

// Fonction pour supprimer un noeud de l'arbre AVL
Noeud* supprimer(Noeud* racine, int valeur) {
    // �tape de suppression normale comme dans un arbre binaire de recherche
    if (racine == NULL)
        return racine;

    if (valeur < racine->valeur)
        racine->gauche = supprimer(racine->gauche, valeur);
    else if (valeur > racine->valeur)
        racine->droite = supprimer(racine->droite, valeur);
    else {
        // Noeud avec un seul enfant ou sans enfant
        if (racine->gauche = NULL || racine->droite == NULL) {
            Noeud* temp = (racine->gauche) ? racine->gauche : racine->droite;

            // Aucun enfant
            if (temp == NULL) {
                temp = racine;
                racine = NULL;
            }
            else // Un enfant
                *racine = *temp; // Copier le contenu du noeud non vide

            free(temp);
        }
        else {
            // Noeud avec deux enfants
            Noeud* temp = trouverSuccesseur(racine->droite);
            racine->valeur = temp->valeur;
            racine->droite = supprimer(racine->droite, temp->valeur);
        }
    }

    // Si l'arbre avait un seul noeud, le retourner
    if (racine == NULL)
        return racine;

    // Mettre � jour la hauteur du noeud actuel
    racine->hauteur = 1 + sMax(hauteur(racine->gauche), hauteur(racine->droite));

    // �quilibrer l'arbre
    return equilibrerArbre(racine, valeur);
}

// Fonction pour afficher l'arbre AVL de mani�re r�cursive
void afficherArbre(Noeud* racine, int espace) {
    if (racine == NULL)
        return;

    espace += 10;

    afficherArbre(racine->droite, espace);

    printf("\n");
    for (int i = 10; i < espace; i++)
        printf(" ");
    printf("%d\n", racine->valeur);

    afficherArbre(racine->gauche, espace);
}

// Fonction pour lib�rer la m�moire utilis�e par l'arbre AVL
void libererMemoire(Noeud* racine) {
    if (racine == NULL)
        return;

    libererMemoire(racine->gauche);
    libererMemoire(racine->droite);

    free(racine);
}

int sMax(int a, int b) {
    return (a > b) ? a : b;
}

void goFurther(Noeud* racisme)
{
    printf(racisme->hauteur);
    printf(racisme->valeur);
    printf(" and then >");
    if (racisme->droite != NULL)
    {
        goFurther(racisme->droite);
    }

    if (racisme->gauche != NULL)
    {
        goFurther(racisme->gauche);
    }
}


