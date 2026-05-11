const express = require("express");
const path = require("path");
const db = require("../db/database");

const app = express();
const port = 3000;

app.set("view engine", "ejs");
app.set("views", path.join(__dirname, "../views"));

app.use(express.static(path.join(__dirname, "../public")));

app.get("/", async (req, res) => {
  try {
    const [battles] = await db.query(
      "SELECT * FROM battle ORDER BY id DESC LIMIT 2"
    );

    const [civilization] = await db.query(
      "SELECT * FROM civilization ORDER BY id DESC LIMIT 1"
    );

    res.render("index", {
      battles,
      civilization: civilization[0]
    });
  } catch (error) {
    res.send("Error en la página principal: " + error.message);
  }
});

app.get("/battles", async (req, res) => {
  try {
    const [battles] = await db.query(
      "SELECT * FROM battle ORDER BY id DESC"
    );

    const [total] = await db.query(
      "SELECT COUNT(*) AS total FROM battle"
    );

    res.render("battles", {
      battles,
      total: total[0].total
    });
  } catch (error) {
    res.send("Error en battles: " + error.message);
  }
});

app.get("/informe", async (req, res) => {
  try {
    const id = req.query.informe;

    const [battle] = await db.query(
      "SELECT * FROM battle WHERE id = ?",
      [id]
    );

    res.render("informe", {
      battle: battle[0]
    });
  } catch (error) {
    res.send("Error en informe: " + error.message);
  }
});

app.get("/civilization", async (req, res) => {
  try {
    const [civilization] = await db.query(
      "SELECT * FROM civilization ORDER BY id DESC LIMIT 1"
    );

    res.render("civilization", {
      civilization: civilization[0]
    });
  } catch (error) {
    res.send("Error en civilization: " + error.message);
  }
});

app.get("/programmers", (req, res) => {
  res.render("programmers");
});

const httpServer = app.listen(port, () => {
  console.log(`Servidor iniciado en: http://localhost:${port}`);
});

process.on("SIGTERM", shutDown);
process.on("SIGINT", shutDown);

function shutDown() {
  console.log("Servidor apagado correctamente");
  httpServer.close();
  process.exit(0);
}