/*-- AJOUT DES CLIENTS*/
INSERT INTO `tpformation`.`user` (`TYPE_ENTITE`, `id`, `address`, `dateDeb`, `email`, `login`, `mdp`, `numTel`, `prenom`, `nom`, `matricule`, `nbEnfant`, `situationMaritale`) VALUES ('CL', '1000', 'paris', '2018-02-13 00:00:00', 'client@gmail.com', 'c1', 'c1', '06235689', 'Adan', 'smith', NULL, '2', 'M');

/*-- Ajout DES COMPTES*/
INSERT INTO `tpformation`.`compte` (`TYPE_ENTITE`, `id`, `dateDeb`, `solde`, `dateDecouv`, `decouvert`, `dateRemun`) VALUES ('CM', '1', '2018-04-01 00:00:00', '500', NULL, NULL, NULL);

/*-- Ajout des liens entre Comptes et Clients */
INSERT INTO `tpformation`.`user_compte` (`user_id`, `listComptes_id`) VALUES ('1000', '1');
