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

## Partie réservée pour Charlies
### Fonctionnalités implémentées au cours de ce projet
    - Pivotement de la grille de jeu
    - Implémentation des bâtiments du jeu
    - Ajout de méthodes permettant de lier les bâtiments au joueur
    - Implémentation de la classe Reine qui est l'élément premier de notre jeu

### Plan de développement
    Temps de : 
        1.2. Réflexion et documentation, 1h
        3. Conception, 3-4h tout en effectuant des tests unitaires pour vérifier que tout est bien implémenté

### Conception
Afin de pouvoir créer nos premières unités (qui sont les ouvrières), il nous fallait générer une unité qui est la reine des Fourmis.
Ainsi, tou au cours de la partie, ce sera cette unité qui se chargera de créer nos ouvrières
LA classe Reine n'est pas composé de beaucoup d'éléments. En effet, dans notre jeu, la Reine des fourmis se chargera 
uniquement de générer nos fourmis ouvrières, donc il a été implémenté une méthode createOuvriere() qui se chargera de : 

    1)créer une ouvrière en un lapse de temps (si le joueur dispose d'assez de ressources pour la générer
    2)enlever le coût nécéssaire pour créer l'ouvrière des ressources du joueur
    3)affecter la fourmi comme étant une unité du joueur qui l'a conçu

**Remarque :**
    Afin d'avoir une meilleure lisibilité du code et des classes, j'ai pris l'initiative de réorganiser nos classes et 
de les insérer dans différents packages en fonction de leur rôle dans notre jeu.
Il y aura donc 5 packages :

    -Batiments (peut être réunis avec le package environnement)
    -Environnement
    -Joueurs
    -MVC
    -Unites

Concernant la suite des fonctionnalités implémentés dans le projet, il y a celles qui concernent les bâtiments de notre jeu.
En effet, au cours du jeu, nous pourrons implémenter différents types de bâtiments, nous permettant de générer différentes unités (et non plus uniquement des ouvrières).
C'est pour cela, que j'ai commencé par implémenter les bâtiments principaux de notre jeu, à savoir :
    
    - La fourmilière(lieu de vie des fourmis et qui servira de base pour chaque joueur)
    - La caserne(bâtiment servant à créer différentes troupes de fourmis)

#### La fourmilière
Véritable forteresse pour les fourmis, la fourmilière joue le rôle de base pour nos fourmis.
En effet, c'est là où sont stockés les ressources récoltées par nos ouvrières, ainsi que la reiine (qui servira à créer nos ouvrières)
Afin que cette fourmilière ne soit pas implémenté n'importe comment, j'ai décidé de l'associer à 3 éléments:

* la grille de jeu, car elle y sera implémenté graphiquement

* le joueur, car chaque joueur aura accès à sa propre fourmilière et non pas celle de l'adversaire 

* Une Reine, car elle y sera toujours présente (même si sa tâche au final se résume à créer des fourmis)


Dans cette classe, plusieurs méthodes utiles au développement du jeu ont étés implémentées:
* addFourmiAll(), qui se chargera d'ajouter la fourmi crée par la reine non seulement au joueur mais aussi à la fourmilière où elle a été crée
* remFourmiBat(), qui lorsqu'une fourmi sera déployé sur la grille de jeu quittera la fourmilière et sera associé à la carte
* createOuvriere(), qui sera associé au clic du joueur lorsqu'il appuiera sur la fourmilière, il pourra décider de quand créer la fourmi
* deploiementUnite(), qui en fonction du joueur, déploiera un certain nombre d'unité sur la grille de jeu

Pour l'instant, il n'y a que les ouvrières de disponible sur notre jeu (07/03), par la suite, il s'agira de créer d'autres types de fourmis dans un bâtiment différent, La Caserne

#### La Caserne
En ce qui concerne ce nouveau bâtiment, il s'agit de créer autre chose que des fourmis basique, on à décider de créer des fourmis pouvant être envoyé en même temps 
que les ouvrières (comme si c'était leurs gardes du corps) afin que ces dernières puissent être protégés lors de leur récolte de ressources

Là aussi, la classe Caserne est créé avec différents attributs :
* Joueur, car tout bâtiment construit sur la map, doit être relié à un joueur
* Timer, qui servira de chronomètre afin de créer nos unités en fonction de ce chrono(utilisation de la classe Timer)

Encore une fois, pour le moment, notre caserne ne peut générer que des ouvrières, mais il arrivera très bientôt d'autres unités de combat.

### Tâches restantes à effectuer :
- [ ] Implémentation graphique des unités deployés
- [ ] Implémentation graphique des bâtiments
- [ ] Gestion des actions possibles du joueur vis-à-vis des unités et des bâtiments
- [ ] Création d'autres unités de combats
- [X] Ajout sans partie graphique d'une Caserne (test unitaire)
- [X] Ajout sans partie graphique d'une Fourmilière (test unitaire)
