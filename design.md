# Structuration du projet

## Adaptation du sujet

Tout d'abord il faut savoir que je n'ai pas totallement respecté le sujet qui a été donné au départ, j'ai dû faire certaines simplifications afin de faire une architecture simple mais qui marche.

## Coté Backend

J'ai utilisé undertow afin de faire mon API Rest, cette API permet d'effectuer des requêtes CRUD pour tous les objets métier(Région,Départment,Ville,Sport). Les requètes Rest envoyées à l'API vont ensuite être traduites vers des DAO qui vont aller effectuer des traitements sur la base de donnée grâce à Hibernate. Les DAO vont parfois renvoyer des objets métier (lors des requètes Get par exemple) dans ce cas les objets métier sont passés dans des Mapper afin d'être transformé en DTO et être envoyé au format JSON, pour les requètes Post et Put un mapper est aussi appelé avant d'utiliser la DAO. Les objets métiers sont tous des entités JPA afin qu'Hibernate puisse les gérer.

## Coté Frontend
Le Frontend a été développé avec Angular (avec un tout petit peu de bootstrap pour la forme). Il permet d'accéder à tous les services fournis par l'API. Ce projet Angular possède quatre composants principaux : un pour chaque type de requêtes. Chacun de ces composant a des composants fils correspondant au classes métiers. Mais tous les composants fils ne vont pas être affichés en même temps : par exemple afin de sélectionner une ville il faut tout d'abord sélectioner sa région puis son département. Lors de la sélection d'un élément (par exemple un département) on accède à un composant montrant différentes information, chaque information étant donnée avec un lien vers l'élément concerné : l'élément parent si il existe (la région pour le département), les élément enfant si il y en a (les villes pour le département), il y a aussi des liens permettant d'aller modifier ou supprimer l'élément affiché. Pour accéder à certains services (Put, Post, Delete) il faut d'avoir cliqué sur le bouton d'authentfication (cette méthode d'authenfication est vraiment la plus faible possible mais c'était juste un moyen de s'entrainer avec les guard sur les routes d'Angular). Des services permettent d'effectuer les requêtes vers le serveur backend, les services sont injectés dans les différents composants qui en ont besoin. Les deux autres services existant sont le service d'authentification et de guardien de routes.

## Bug connus
Il y a certaines fonctionnalités qui ont néammoins certains défault dans le pdf TodoList les élément qui ne sont pas coché avec des croix indiquent la présence de bug dans certaines condition. Le problème le plus notables est celui des villes qui ne peuvent pas être supprimées tant qu'elles contiennent des sports.