const express = require("express");
const path = require("path");
const db = require("./db/database");

const app = express();

app.set("view engine", "ejs");
app.set("views", path.join(__dirname, "views"));

app.use(express.static(path.join(__dirname, "public")));

app.get("/", async (req, res) => {
  const [batalles] = await db.query(
    "SELECT * FROM batalles ORDER BY data DESC LIMIT 2"
  );

  res.render("index", { batalles });
});

app.get("/batalles", async (req, res) => {
  const [batalles] = await db.query(
    "SELECT * FROM batalles ORDER BY data DESC"
  );

  const [total] = await db.query(
    "SELECT COUNT(*) AS total FROM batalles"
  );

  res.render("batalles", {
    batalles,
    total: total[0].total
  });
});

app.get("/informe", async (req, res) => {
  const id = req.query.informe;

  const [batalla] = await db.query(
    "SELECT * FROM batalles WHERE id = ?",
    [id]
  );

  res.render("informe", { batalla: batalla[0] });
});

app.get("/civilitzacio", async (req, res) => {
  const [recursos] = await db.query(
    "SELECT * FROM recursos"
  );

  res.render("civilitzacio", { recursos });
});

app.get("/programadors", (req, res) => {
  res.render("programadors");
});

app.listen(3000, () => {
  console.log("Servidor iniciat al port 3000");
});