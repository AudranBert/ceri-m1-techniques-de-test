# UCE Génie Logiciel Avancé : Techniques de tests

Nom: BERT

Prénom: Audran

Groupe: ILSEN-CLA-GR2


[![codecov](https://codecov.io/gh/AudranBert/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=XMT8AS337Q)](https://codecov.io/gh/AudranBert/ceri-m1-techniques-de-test)
[![CircleCI](https://circleci.com/gh/AudranBert/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://circleci.com/gh/AudranBert/ceri-m1-techniques-de-test/tree/master)
![CheckStyle](target/site/badges/checkstyle-result.svg)


## Rapport TP6

J'ai trois tests qui ne sont pas passés: testGetAttack, testCreatePokemonBadIndexMetadata et testCreatePokemonNegativeIndexMetadata.

Le test testCreatePokemonBadIndexMetadata teste si lorsqu'on envoie un index de metadata qui n'est pas bon cela renvoie bien rien du tout.
Or, dans l'implémentation de la team Rocket, si l'index n'est pas valide il renvoie le pokemon avec l'index de metadata de 0.

De même, pour testCreatePokemonNegativeIndexMetadata, l'index fourni est négatif et devrait donc toujours lancer une exception et return un pokemon null.
L'index -1 devrait être toujours invalide sauf que, ici à l'index -1 il y a un pokémon "Ash's Pikachu" qui fait que ca renvoie un pokémon au lieu de null.

Le test testGetAttack qui verifie si l'attaque du pokémon est bien comprise entre la valeur de base de la metadata et +15 comme c'est demandé dans le sujet.

Au niveau des performances, j'ai remarqué que pour générer un nombre aléatoire ils font une boucle qui va jusqu'à 1000000.
Faire une aussi grosse boucle alors que c'est pas nécessaire dégrade les performances de l'application.

J'ai remarqué aussi que l'iv était fixé au lieu de correspondre à la formule donnée.