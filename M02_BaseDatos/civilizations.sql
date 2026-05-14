CREATE DATABASE civilizations;

USE civilizations;

CREATE TABLE civilization (
    id INT AUTO_INCREMENT PRIMARY KEY,
    food INT,
    wood INT,
    iron INT,
    mana INT,
    farm INT,
    smithy INT,
    carpentry INT,
    magic_tower INT,
    church INT,
    technology_attack INT,
    technology_defense INT
);

CREATE TABLE battle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    winner VARCHAR(50),
    battle_report TEXT,
    waste_wood INT,
    waste_iron INT
);