# Quiz App

Bienvenue dans l'application Quiz ! Cette application permet à un joueur de s'enregistrer, de choisir un domaine, de répondre à une série de questions dans un temps limité et d'obtenir son score à la fin du quiz.

## Fonctionnalités

- **Enregistrement du joueur** : Le joueur peut entrer son nom au début du jeu.
- **Choix du domaine** : Le joueur choisit un domaine parmi une liste de six domaines disponibles (par exemple, Science, Histoire, Géographie, etc.).
- **Questions aléatoires** : Les questions sont sélectionnées aléatoirement pour chaque quiz. Chaque question a quatre options et une bonne réponse.
- **Limite de temps** : Le joueur a 10 secondes pour répondre à chaque question.
- **Évaluation** : À la fin du quiz, le score du joueur est affiché. Si le score est supérieur ou égal à 5, il a réussi, sinon il a échoué et peut choisir de recommencer.
- **Structure Clean Architecture** : Le projet suit la Clean Architecture, avec des dossiers distincts pour les entités, les interfaces, les adaptateurs, les cas d'utilisation et un point d'entrée principal.

## Dossiers du projet

1. **Entities** : Contient les entités du jeu (ex. `Question`, `Quiz`, `Player`).
2. **Interfaces** : Contient les interfaces utilisées dans le projet (ex. `QuizRepository`, `PlayerRepository`).
3. **Adapters** : Contient les implémentations des interfaces, comme l'accès aux fichiers ou la gestion de l'interface utilisateur.
4. **Repositories** : Contient les classes qui interagissent avec les données (ex. lecture/écriture dans un fichier).
5. **UseCases** : Contient la logique métier pour chaque fonctionnalité du quiz (ex. démarrer un quiz, valider les réponses).
6. **Main** : Point d'entrée de l'application, où le jeu commence.

## Prérequis

Pour exécuter ce projet, vous devez avoir installé :
- **JDK 11 ou supérieur**
- **Kotlin**
