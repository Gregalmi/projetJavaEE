# projetJavaEE
Application distribuée Java EE

Application réalisé en 10 jours à 2. 

Je vous invite à lire le dossier de conception aini que le code. 

## Enoncé

L’objectif de ce projet est de concevoir le prototype de l’application Web Good Cesi.
Good Cesi est une application semblable au Bon Coin. L’application permet à des internautes d’acheter des produits d’occasion vendus par des particuliers.
Conseil :
Ce projet étant un projet de développement web, les efforts doivent être portés sur la conception, la réalisation.
 Il ne faut pas perdre de temps sur l’aspect graphique et l’ergonomie.

#### Exigences fonctionnelles

**Utilisateurs :  

 Les internautes : utilisateurs non authentifiés.
 Les acheteurs : utilisateurs ayant créé un compte de type acheteur.
 Les vendeurs : utilisateurs ayant créé un compte de type vendeur.
 Les acheteurs/vendeurs : utilisateurs qui cumule les rôles acheteur et vendeur.
 Les administrateurs : utilisateurs dont le compte est créé soit par un fichier de configuration soit à l’initialisation de l’application (dans le code).  

L’application doit permettre :  

**Aux internautes de :  

 Visualiser dans le catalogue des produits en vente sur la plateforme.
 Afficher les détails d’un produit
 Créer un compte utilisateur de type acheteur, vendeur ou acheteur et vendeur
**Aux acheteurs de :  

 Commander un article (un seul à la fois => pas de panier). Au moment de la commande, l’acheteur doit renseigner ses coordonnées bancaires et l’application doit valider que le n° de CB contient « 10 chiffres ».
 Lister les articles commandés.  

**Aux vendeur de :  

 Ajouter un article sur le site qui aura l’état « disponible » pour qu’il soit référencé comme étant en vente
 Gérer ses commandes (lister les commandes de ses produits, pourvoir les validées (état « valider ») et les envoyées (état « envoyer »)
 Gérer ses articles : ajouter un article. Supprimer et modifier s’ils ne sont pas vendus.  

**Aux administrateur de :  

 Créer des catégories d’articles
