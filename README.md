# ProjectPCII 
#### README complété au fur et à mesure par les membres du groupe.

##Partie réservée pour Thomas

Fonctionnalités à implémenter pour la suite:
Evènement quand un joueur clique sur une de ses unités pour pour déclencher un mécanisme qui permet d'abord son déplacement puis par la suite différentes actions selon le type de l'unité.

Conception :
J'ai codé en premier lieu l'espace de travail notamment avec les classes abstraites et les classes respectant le MVC. Cela nous permet de facilement construire le projet avec les autres membres du groupe. Ces classes sont complétées au fur et à mesure du besoin notamment pour relier l'ensemble des autres classes (par exemple dans l'affichage on améliorera la partie graphique). 
Par la suite, je me suis occupé de créer une première version de l'IA qui pour l'instant  ne fait que se déplacer dans notre grille de jeu tout en respectant les bornes de la grille.
La classe Joueurs.AIPlayer hérite de Thread ce qui permet à l'IA de tourner en temps réel avec le reste du programme. En attribut, la classe possède comme un joueur une liste de bâtiments et d'unités, pour le moment et pour les essais, on a seulement ajouté une unité (ouvrière).
Pour relier l'AI a l'ensemble des autres classes, on lui donne un accès à la classe MVC.Controle dont le lien est fait lors de l'initialisation de l'AI.
La méthode principale de cette classe est Run(), pour le moment elle est définie comme suit : 
pour chaque unité de l'AI, on génère un nouveau point alétoire (on utilise une valeur et selon sa valeur, cela définie un déplacement)  qui se situe autour de l'unité, vers lequel l'unité va se déplacer, si la nouvelle case est dehors des bornes alors on recommence le processus.
Et entre chaque déplacement il y a 2 secondes. L'ensemble des méthodes sont simplement des getters et des setters pour simplifier l'accès aux éléments de L'AI.

##Partie réservée pour Arsène

Fonctionnalités implémenter :

-création et placement des ressources sur la grille de jeu.

Plan de développement : 

Temps : 1 à 2h pour la conception, réflexion et documentation.

Conception :  

J’ai implémenté toute la class Environnement.Ressource.java, la méthode dessineRessource() dans la class MVC.Affichage.java et la méthode initRessource() dans MVC.Etat.java.

La class ressource.java contient : 
- enum Environnement.typeRessource avec deux valeus possibles : bois et nourriture.
- 2 attributs : tR pour le type de ressouce et position pour avoir la position.
- 2 méthodes : initialiseRessource() qui va initialise une ressource avec une position aléatoire dans la grille sauf les cases (1, 9) et (9, 1) car il y aura par la suite les fourmilières, et la méthode getPosition().

La méthode initRessource() va prendre un entier entre 1 et 10 de maniéré aléatoire , ce qui va déterminer le nombre de ressources a placer dans la grille et les ressources cree seront dans l’attribut listRessource(arrayList) de MVC.Etat.java.

La méthode dessineRessource() va prendre chaque ressource de listRessources et affiche un petit cercle rempli en bleu, si la ressource est de type « bois » sinon en cyan pour le type de ressource « nourriture ». 

##Partie réservée pour Charlies
