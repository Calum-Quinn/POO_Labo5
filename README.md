# Labo 05: Matrices

Durée du laboratoire: 4 périodes

A rendre sur Cyberlearn (code source) ainsi qu'une version imprimée.
## Objectifs pédagogiques
- Concevoir des classes avec le principe d'encapsulation pour assurer l'intégrité des données et minimiser les dépendances
- Savoir lancer des exceptions en cas de paramètres non valides
- Modéliser des opérations arithmétiques avec une conception orientée-objet pour factoriser du code commun et pouvoir étendre les opérations facilement

## Description

Définir une classe permettant de représenter des matrices de taille quelconque (N × M) contenant des éléments entre 0 et n-1 pour un entier n (les entiers modulo n).

Il faut:
- être capable de créer une matrice soit en générant son contenu aléatoirement (une fois sa taille et son modulo connus), soit en passant ses valeurs en paramètre.
- être capable d'afficher le contenu de la matrice.
- être capable d'effectuer les opérations suivantes entre deux matrices: l'addition, la soustraction et le produit composante par composante. Les opérations doivent être effectuées modulo n.
- Le résultat C d'une multiplication composante par composante entre une matrice A et une matrice B est défini par Ci,j = Ai,j ⋅ Bi,j mod n.
- Dans le cas où l'on effectue une opération entre une matrice A de taille M1 × N1 et une matrice B de taille M2 × N2 et que les tailles ne correspondent pas, le résultat est une matrice de taille max(M1, M2) × max(N1, N2) où les Ai,j et Bi,j manquants ont été remplacés par des 0.
- Si les modules n des deux matrices ne correspondent pas, envoyez une RuntimeException.
- En cas de toute autre erreur, envoyez une RuntimeException.
- Les méthodes Math.floorMod(), Math.max() et Math.random() vous seront sûrement utiles.

1. Implémenter cette classe.
2. Ecrire un programme de test prenant en argument les tailles N1, M1, N2, M2 de deux matrices ainsi qu'un module n et effectuant les opérations sur une matrice N1 × M1 et N2 × M2 de manière à produire un résultat semblable à
The modulus is 5

one:

1 3 1 1 

3 2 4 2 

1 0 1 0 


two:

1 4 2 3 2 

0 1 0 4 2 

0 0 2 0 2 


one + two:

2 2 3 4 2 

3 3 4 1 2 

1 0 3 0 2 


one - two:

0 4 4 3 3 

3 1 4 3 3 

1 0 4 0 3 

one x two:

1 2 2 3 0 

0 2 0 3 0 

0 0 2 0 0 

3. Factoriser le code commun aux différentes opérations (addition, soustraction et multiplication) de manière à ce qu'il soit possible d'en ajouter de nouvelles ultérieurement. Définir des objets représentant l'opération à effectuer sur les éléments des matrices opérandes et ceci sans utiliser de structures de contrôle (ifs, switchs...).
4. N'hésitez pas à tester aussi les cas limites.
