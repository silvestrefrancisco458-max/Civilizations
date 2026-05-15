# Civilizations

Proyecto final DAW — Civilizations

---

# Descripción

Civilizations es un videojuego de estrategia medieval desarrollado en Java con conexión a MySQL y visualización web mediante Node.js.

El jugador puede:

- Gestionar recursos
- Construir edificios
- Crear unidades militares
- Defender la civilización
- Simular batallas automáticas
- Mejorar tecnologías
- Guardar datos en MySQL
- Consultar estadísticas desde una página web

---

# Tecnologías utilizadas

## M02 — Base de Datos
- MySQL
- MariaDB
- JDBC

## M03 — Programación
- Java
- Java Swing
- Programación Orientada a Objetos
- Excepciones
- Herencia y polimorfismo
- Arrays y ArrayList
- TimerTask

## M04 — Página Web
- Node.js
- Express.js
- Handlebars (HBS)
- HTML5
- CSS3
- PM2
- Proxmox

---

# Estructura del proyecto

```bash
Civilizations/
│
├── M02_BaseDatos/
│   └── civilization.sql
│
├── M03_Java/
│   └── src/
│       ├── core/
│       │   ├── DatabaseManager.java
│       │   ├── DatabaseTest.java
│       │   ├── Empire.java
│       │   ├── GameSettings.java
│       │   ├── Main.java
│       │   └── War.java
│       │
│       ├── errors/
│       │   ├── BuildingError.java
│       │   └── ResourceError.java
│       │
│       ├── fighters/
│       │   └── CombatUnit.java
│       │
│       ├── fighters.defensive/
│       │   ├── ArrowTower.java
│       │   ├── Catapult.java
│       │   ├── DefensiveUnit.java
│       │   └── RocketTower.java
│       │
│       ├── fighters.mystic/
│       │   ├── MysticUnit.java
│       │   ├── Priest.java
│       │   └── Wizard.java
│       │
│       ├── fighters.offensive/
│       │   ├── Archer.java
│       │   ├── Cannon.java
│       │   ├── Knight.java
│       │   ├── Lancer.java
│       │   └── OffensiveUnit.java
│       │
│       ├── images/
│       │
│       └── Interfacegame/
│           ├── AlertPanel.java
│           ├── ArmyPanel.java
│           ├── BuildingsPanel.java
│           ├── EmpirePanel.java
│           ├── EmpireWindow.java
│           ├── MenuPanel.java
│           ├── ResourcesPanel.java
│           ├── StatisticsPanel.java
│           ├── TechnologyPanel.java
│           └── WarPanel.java
│
├── M04_Web/
│   ├── db/
│   │   └── database.js
│   │
│   ├── public/
│   │   ├── css/
│   │   │   └── style.css
│   │   └── images/
│   │
│   ├── views/
│   │   ├── battles.hbs
│   │   ├── civilization.hbs
│   │   ├── index.hbs
│   │   ├── informe.hbs
│   │   └── programmers.hbs
│   │
│   ├── app.js
│   ├── package.json
│   └── package-lock.json
│
├── nodejs_server/
│
└── README.md
```

---

# Clases principales

## Civilization
Gestiona:
- recursos
- edificios
- ejército
- tecnologías
- batallas

## Battle
Simula combates entre civilización y enemigo.

## MilitaryUnit
Clase base de todas las unidades militares.

## AttackUnit
Clase base de unidades ofensivas.

## DefenseUnit
Clase base de unidades defensivas.

## DatabaseManager
Gestiona:
- conexión MySQL
- guardar civilización
- cargar civilización

---

# Funcionalidades

## Recursos
- Food
- Wood
- Iron
- Mana

## Edificios
- Farm
- Smithy
- Carpentry
- Magic Tower
- Church

## Unidades
- Swordsman
- Spearman
- Crossbow
- Cannon
- ArrowTower
- Catapult
- RocketLauncher
- Magician
- Priest

## Tecnologías
- Technology Attack
- Technology Defense

---

# Base de datos

## Tabla civilization

Guarda:
- recursos
- edificios
- tecnologías

## Tabla battle

Guarda:
- ganador
- reporte de batalla
- residuos generados

---

# Cómo ejecutar Java

## Compilar

```bash
javac *.java
```

## Ejecutar

```bash
java -cp .:/usr/share/java/mariadb-java-client.jar Main
```

---

# Cómo ejecutar Node.js

## Instalar dependencias

```bash
npm install
```

## Ejecutar servidor

```bash
npm run start
```

---

# Deploy Proxmox

## Ejecutar deploy

```bash
./proxmoxDeploy.sh
```

## Ver PM2

```bash
pm2 status
```

---

# Página web

Disponible en:

```text
https://civil3.ieti.site
```

---

# Autor

Francisco Alberto Silvestre Ramírez
Luis Portero
Oscar Fernandez

Proyecto DAW - Civilizations