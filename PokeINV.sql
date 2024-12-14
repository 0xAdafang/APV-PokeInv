CREATE DATABASE PokeINV;
USE PokeINV;


CREATE TABLE Collection (
    idCollection INT PRIMARY KEY AUTO_INCREMENT,
    nomCollection VARCHAR(255) NOT NULL
);


CREATE TABLE Rarete (
    idRarete INT PRIMARY KEY AUTO_INCREMENT,
    nomRarete ENUM('COMMON', 'UNCOMMON', 'RARE', 'HOLO_RARE', 'ULTRA_RARE', 'SECRET_RARE', 'SECRET_ART_ILLUSTRATION') NOT NULL
);

CREATE TABLE Qualite (
    idQualite INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL
);


CREATE TABLE Etat (
    idEtat INT PRIMARY KEY AUTO_INCREMENT,
    estDegradee BOOLEAN NOT NULL
);


CREATE TABLE TypeCarte (
    idTypeCarte INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255) NOT NULL
);


CREATE TABLE Carte (
    idCarte INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,
    collectionId INT,
    prix DECIMAL(10, 2) NOT NULL,
    qualiteId INT,
    etatId INT,
    typeCarteId INT,
    rareteId INT,
    FOREIGN KEY (collectionId) REFERENCES Collection(idCollection),
    FOREIGN KEY (qualiteId) REFERENCES Qualite(idQualite),
    FOREIGN KEY (etatId) REFERENCES Etat(idEtat),
    FOREIGN KEY (typeCarteId) REFERENCES TypeCarte(idTypeCarte),
    FOREIGN KEY (rareteId) REFERENCES Rarete(idRarete)
);


CREATE TABLE Inventaire (
    idInventaire INT PRIMARY KEY AUTO_INCREMENT,
    carteId INT NOT NULL,
    quantite INT DEFAULT 1,
    FOREIGN KEY (carteId) REFERENCES Carte(idCarte)
);


CREATE TABLE Transaction (
    idTransaction INT PRIMARY KEY AUTO_INCREMENT,
    dateTransaction DATE NOT NULL,
    montant DECIMAL(10, 2) NOT NULL,
    proprietaire VARCHAR(255) NOT NULL
);

CREATE TABLE Employe (
    idEmploye INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL, 
    prenom VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'STAFF') DEFAULT 'STAFF' NOT NULL, 
    dateEmbauche DATE NOT NULL 
);

CREATE TABLE Connexion (
    idConnexion INT PRIMARY KEY AUTO_INCREMENT,
    idEmploye INT NOT NULL,
    courriel VARCHAR(255) NOT NULL,
    motDePasse VARCHAR(255) NOT NULL,
    statut ENUM('A', 'I') DEFAULT 'A' NOT NULL,
    dateConnexion DATETIME NOT NULL,
    FOREIGN KEY (idEmploye) REFERENCES Employe(idEmploye) ON DELETE CASCADE
);
