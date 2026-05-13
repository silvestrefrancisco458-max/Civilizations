const express = require("express");
const path = require("path");
const db = require("./db/database");

const app = express();
const port = 3000;

app.set("view engine", "hbs");
app.set("views", path.join(__dirname, "../views"));

app.use(express.static(path.join(__dirname, "../public")));

app.get("/", async (req, res) => {
  try {
    const [batalles] = await db.query(
      "SELECT * FROM batalles ORDER BY data DESC LIMIT 2"
    );

    res.render("index", { batalles });
  } catch (error) {
    res.send("Error en la página principal: " + error.message);
  }
});

app.get("/batalles", async (req, res) => {
  try {

    const [batalles] = await db.query(
      "SELECT * FROM batalles ORDER BY data DESC"
    );

    const batallesView = batalles.map(batalla => ({
      ...batalla,
      victoria: batalla.ganador === "Civilization"
    }));

    const totalFusta = batalles.reduce((total, batalla) => {
      return total + batalla.fusta;
    }, 0);

    const totalFerro = batalles.reduce((total, batalla) => {
      return total + batalla.ferro;
    }, 0);

    res.render("batalles", {
      batalles: batallesView,
      totalBatalles: batalles.length,
      totalFusta,
      totalFerro
    });

  } catch (error) {
    res.send("Error en batalles: " + error.message);
  }
});

app.get("/informe", async (req, res) => {
  try {
    const id = req.query.informe;

    const [batalla] = await db.query(
      "SELECT * FROM batalles WHERE id = ?",
      [id]
    );

    res.render("informe", { batalla: batalla[0] });
  } catch (error) {
    res.send("Error en informe: " + error.message);
  }
});

app.get("/civilitzacio", async (req, res) => {
  try {
    const [recursos] = await db.query(
      "SELECT * FROM recursos"
    );

    res.render("civilitzacio", { recursos });
  } catch (error) {
    res.send("Error en civilitzacio: " + error.message);
  }
});

app.get("/programadors", (req, res) => {
  res.render("programadors");
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