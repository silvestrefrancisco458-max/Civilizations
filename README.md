# Civilizations

Proyecto final DAW - Civilizations

## Descripción

Civilizations es un juego de estrategia desarrollado en Java donde el jugador puede:

- Crear edificios
- Generar recursos
- Crear unidades militares
- Simular batallas
- Mejorar tecnologías
- Guardar y cargar datos desde MySQL
- Visualizar información desde una página web Node.js

---

# Tecnologías utilizadas

## M02 - Base de datos
- MySQL
- MariaDB
- JDBC

## M03 - Programación
- Java
- Programación orientada a objetos
- Excepciones
- Arrays y ArrayList

## M04 - Página web
- Node.js
- Express
- EJS
- PM2
- Proxmox

---

# Estructura del proyecto

```bash
Civilizations/
│
├── M02_BaseDatos/
│   └── script_civilizations.sql
│
├── M03_Programación/
│   └── src/
│       └── ArrawTower.java
│       └── attackUnit.java
│       └── Battle.java
│       └── BuildingException.java
│       └── Cannon.java
│       └── Catapult.java
│       └── Civilization.java
│       └── Crossbow.java
│       └── DatabaseManager.java
│       └── DefenseUnit.java
│       └── Magician.java
│       └── Main.java
│       └── MilitaryUnit.java
│       └── Priest.java
│       └── ResourceException.java
│       └── RocketLauncher.java
│       └── Spearman.java
│       └── Swordsman.java
│       └── Variable.java
│
├── M04_Página_web/
│   └── datebase/
│   └── db/
│   └── public/
│       └── css/
│           └── style.css
│       └── img/
│   └── views/
│       └── partials/
│           └── footer.ejs
│           └── header.ejs
│       └── batalles.ejs
│       └── civilitzacio.ejs
│       └── index.ejs
│       └── informe.ejs
│       └── programadors.ejs
│   └── .env
│   └── app.js
│   └── package.json
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

Proyecto DAW - Civilizations