#include "AVL.h" // Assurez-vous d'inclure le fichier d'en-t�te

int main() {
    Noeud* racine1 = NULL;
    Noeud* racine2 = NULL;

    // Ins�rer des valeurs dans le premier arbre AVL
    racine1 = inserer(racine1, 10);
    racine1 = inserer(racine1, 20);
    racine1 = inserer(racine1, 30);
    racine1 = inserer(racine1, 40);
    racine1 = inserer(racine1, 50);
    racine1 = inserer(racine1, 25);

    // Affichage du premier arbre AVL
    printf("Affichage du premier arbre AVL :\n");
    afficherArbre(racine1, 0);

    // Ins�rer des valeurs dans le deuxi�me arbre AVL
    racine2 = inserer(racine2, 15);
    racine2 = inserer(racine2, 25);
    racine2 = inserer(racine2, 35);
    racine2 = inserer(racine2, 45);
    racine2 = inserer(racine2, 55);
    racine2 = inserer(racine2, 65);
    racine2 = inserer(racine2, 15);
    racine2 = inserer(racine2, 55);
    racine2 = inserer(racine2, 75);


    

    // Affichage du deuxi�me arbre AVL
    printf("\nAffichage du deuxi�me arbre AVL :\n");
    afficherArbre(racine2, 0);

    goFurther(racine2);


    // Lib�ration de la m�moire
    libererMemoire(racine1);
    libererMemoire(racine2);

    return 0;
}