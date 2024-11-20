import React from "react";
import TestAPI from "./components/TestAPI";
import "./App.css" // Ajusta la ruta según tu estructura

const App = () => {
  return (
    <div className="container mt-5">
      <h1 className="text-center text-primary mb-4">Prueba de API</h1>
      <div className="card shadow p-4">
        <TestAPI />
      </div>
    </div>
  );
};

export default App;
