# application java qui permet de gerer un catalogue de produits


une application java qui permet de gérer un catalogue de produits. Ce catalogue est formé par des produits classés par 
catégorie qui sont stockés dans une base de données MYSQL.
Une catégorie est définie par :
- Un code de type INT, clé primaire, Auto_Increment
- Le nom de catégorie de type VARCHAR de taille 30.
Un produit appartenant à une catégorie est défini par :
- Une référence de type int, clé primaire
- Le nom du produit
- Le prix du produit
- La quantité en stock
L’application à développer la séparation des couches Dao, métier et présentation. Elle doit permettre de :
- Ajouter une nouvelle catégorie
- Ajouter un nouveau produit appartenant à une catégorie
- Consulter toutes les catégories.
- Consulter tous les produits
- Consulter les produits sachant le code catégorie
