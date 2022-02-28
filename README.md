# ProjectPCII 
#### README complété au fur et à mesure par les membres du groupe.

##Partie réservée pour Thomas







##Partie réservée pour Arsène

Fonctionnalités implémenter :

-création et placement des ressources sur la grille de jeu.

Plan de développement : 

Temps : 1 à 2h pour la conception, réflexion et documentation.

Conception :  

J’ai implémenté toute la class Ressource.java, la méthode dessineRessource() dans la class Affichage.java et la méthode initRessource() dans Etat.java.

La class ressource.java contient : 
- enum typeRessource avec deux valeus possibles : bois et nourriture.
- 2 attributs : tR pour le type de ressouce et position pour avoir la position.
- 2 méthodes : initialiseRessource() qui va initialise une ressource avec une position aléatoire dans la grille sauf les cases (1, 9) et (9, 1) car il y aura par la suite les fourmilières, et la méthode getPosition().

La méthode initRessource() va prendre un entier entre 1 et 10 de maniéré aléatoire , ce qui va déterminer le nombre de ressources a placer dans la grille et les ressources cree seront dans l’attribut listRessource(arrayList) de Etat.java.

La méthode dessineRessource() va prendre chaque ressource de listRessources et affiche un petit cercle rempli en bleu, si la ressource est de type « bois » sinon en cyan pour le type de ressource « nourriture ». 










##Partie réservée pour Charlies
