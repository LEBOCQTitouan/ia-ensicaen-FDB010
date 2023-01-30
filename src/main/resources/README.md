# Projet IA - Colonisation

# Présentation du projet

Ce projet simule la préparation d'un terrain par des robots avant l'arrivée des humains. Le terrain est la planète
LV-223, qui réagit en fonction des evènements qui se passent à sa surface.
Pour cela un binôme va s'occuper de la création des robots, des agents réactifs qui auront plusieurs rôles en fonction
de leur type. Certains vont prélever de l'eau ou du minerai, provoquant des ondes et possiblement des métamorphoses sur
la planète.
L'autre binôme va quant à lui, créer la planète, un agent réactif qui réagira aux prélèvements fait par les robots. Elle
créera des métamorphose et verra son état de santé se dégrader au fur et à mesure que les robots effectuent des
interactions.

## La planète

Chaque tour, si un prélèvement d'eau et une extraction de minerai ont été réalisées, alors une onde définie par une
amplitude et une vitesse, sera propagée depuis le point d'origine vers les points de l'exosquelette qui répercuteront
cela sur les cellules métamorphosables
Un système de logique floue a été mis en place afin de définir différents types de métamorphoses en fonction du niveau
de prélèvement d'eau et d'extraction de minerai. Ces types de métamorphoses vont donc modifier la planète, en fonction
de probabilités de métamorphose définies pour chaque type de case.

## Les robots

L'objectif des robots est de récolter un maximum de ressources et de les rapporter à la base. Pour cela, différents
types de robots vont agir sur la planète. Les explorateurs vont permettre aux autres robots de connaître le terrain, les
ouvriers vont récolter les ressources et les rapporter à la base, et les agriculteurs vont créer de la nourriture en
cultivant des prairies avec un volume d'eau requis.

## Comment lancer la simulation?

- Ouvrir le projet avec IntelliJ
- Créer une application avec edu.ensicaen.iacolonisation.Main et un JDK Java11 ou +
- Avant de lancer la simulation, il est possible de choisir le nombre de tour à simuler
- Cliquer sur Simulation



