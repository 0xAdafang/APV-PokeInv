CREATE DATABASE PokeINVDB;
USE PokeINVDB


CREATE TABLE Collection (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE Etat (
    name VARCHAR(50) PRIMARY KEY
);


CREATE TABLE TypeCarte (
    name VARCHAR(50) PRIMARY KEY
);


CREATE TABLE Rarete (
    name VARCHAR(50) PRIMARY KEY
);


CREATE TABLE GradePSA (
    name VARCHAR(50) PRIMARY KEY
);


CREATE TABLE Carte (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    collectionId BIGINT,
    price DECIMAL(10, 2),
    gradePsa VARCHAR(50),
    etatName VARCHAR(50),
    typeCarte VARCHAR(50),
    rareteName VARCHAR(50),
    image VARCHAR(255),
    FOREIGN KEY (collectionId) REFERENCES Collection(id),
    FOREIGN KEY (gradePsa) REFERENCES GradePSA(name),
    FOREIGN KEY (etatName) REFERENCES Etat(name),
    FOREIGN KEY (TypeCarte) REFERENCES TypeCarte(name),
    FOREIGN KEY (rareteName) REFERENCES Rarete(name)
);


CREATE TABLE Employe (
    id BIGINT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    hireDate DATE
);


CREATE TABLE Connexion (
    id BIGINT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    status VARCHAR(50),
    lastConnection TIMESTAMP,
    employeeId BIGINT,
    FOREIGN KEY (employeId) REFERENCES Employe(id)
);


INSERT INTO Etat (name) VALUES
    ('Mint'),
    ('NearMint'),
    ('Excellent'),
    ('Good'),
    ('LightlyPlayed'),
    ('Played'),
    ('Poor');


INSERT INTO TypeCarte (name) VALUES
    ('Grass'),
    ('Lightning'),
    ('Dark'),
    ('Fairy'),
    ('Psychic'),
    ('Fire'),
    ('Water'),
    ('Fighting'),
    ('Metal'),
    ('Colorless'),
    ('Dragon');


INSERT INTO Rarete (name) VALUES
    ('Common'),
    ('Uncommon'),
    ('Rare'),
    ('HoloRare'),
    ('UltraRare'),
    ('SecretRare'),
    ('SecretArtIllustration');


INSERT INTO GradePSA (name) VALUES
    ('PSA10'),
    ('PSA9'),
    ('PSA8'),
    ('PSA7'),
    ('PSA6'),
    ('PSA5'),
    ('PSA4'),
    ('PSA3'),
    ('PSA2'),
    ('PSA1');
