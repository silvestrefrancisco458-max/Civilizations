const mysql = require("mysql2");

const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "tuclave",
  database: "civilizations"
});

db.connect(err => {
  if (err) {
    console.log("Error conectando a MySQL:", err.message);
  } else {
    console.log("Conectado a MySQL");
  }
});

module.exports = db;