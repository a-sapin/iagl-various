#include "AVL.h"


int main() {
    Noeud* racine = NULL;

    // Inserting values into the AVL tree
    racine = inserer(racine, 10);
    racine = inserer(racine, 20);
    racine = inserer(racine, 30);
    racine = inserer(racine, 40);
    racine = inserer(racine, 50);
    racine = inserer(racine, 25);

    // Displaying the AVL tree
    printf("Affichage de l'arbre AVL:\n");
    afficherArbre(racine, 0);

    // Freeing the memory
    libererMemoire(racine);

    return 0;
}