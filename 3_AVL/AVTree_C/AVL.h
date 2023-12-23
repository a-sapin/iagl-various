
#ifndef AVL_H
#define AVL_H

#include <stdio.h>
#include <stdlib.h>

// Structure d'un noeud de l'AVL
typedef struct Noeud {
    int valeur;
    struct Noeud* gauche;
    struct Noeud* droite;
    int hauteur;
} Noeud;

// Declarations of functions
Noeud* creerNoeud(int valeur);
int hauteur(Noeud* N);
Noeud* faireSimpleRotationADroite(Noeud* y);
Noeud* faireSimpleRotationAGauche(Noeud* x);
Noeud* faireDoubleRotationADroite(Noeud* z);
Noeud* faireDoubleRotationAGauche(Noeud* z);
Noeud* equilibrerArbre(Noeud* racine, int valeur);
Noeud* inserer(Noeud* racine, int valeur);
Noeud* trouverSuccesseur(Noeud* racine);
Noeud* supprimer(Noeud* racine, int valeur);
void afficherArbre(Noeud* racine, int espace);
void libererMemoire(Noeud* racine);
int sMax(int a, int b);

#endif /* AVL_H */
