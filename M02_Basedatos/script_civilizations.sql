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

INSERT INTO civilizations (
    food, wood, iron, mana,
    farm, smithy, carpentry, 
    magic_tower, church,
    technology_attack, technology_defense
)
VALUES (
    50000, 50000, 50000, 0,
    1, 1, 1,
    1, 1,
    0, 0
);

INSERT INTO battle (
    winner, battle_report,
    waste_wood, waste_iron
)
VALUES (
    'Civilization',
    'Battle won against enemy army',
    5000,
    3000
);