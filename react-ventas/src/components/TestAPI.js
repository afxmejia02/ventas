import React, { useEffect, useState } from "react";
import { getProducts } from "../api/products"; // Ajusta la ruta según tu estructura

const TestAPI = () => {
  const [products, setProducts] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await getProducts();
        setProducts(response.data); // Supone que la API devuelve los productos en `response.data`
      } catch (err) {
        console.error("Error al conectar con la API:", err);
        setError(err.message || "Error desconocido");
      }
    };

    fetchProducts();
  }, []);

  return (
    <div className="container mt-4">
      <h1 className="text-center mb-4">Lista de Productos</h1>
      {error && <p style={{ color: "red" }}>Error: {error}</p>}
      {products.length > 0 ? (
       <table border="1" className="table table-bordered table-striped table-hover">
       <thead className="table-dark">
           <tr>
               <th>Nombre</th>
               <th>Precio</th>
               <th>Categoría</th>
               <th>Género</th>
               <th>Talla</th>
               <th>Imagen</th>
               <th>Descripción</th>
               <th>Unidades</th>
               <th>Marca</th>
           </tr>
       </thead>
       <tbody>
           {products.map((product) => (
               <tr key={product.id}>
                   <td>{product.nombre}</td>
                   <td>{product.precio}</td>
                   <td>{product.categoria}</td>
                   <td>{product.genero}</td>
                   <td>{product.talla}</td>
                   <td>
                           {product.imagen}
                   </td>
                   <td>{product.descripcion}</td>
                   <td>{product.unidades}</td>
                   <td>{product.marca}</td>
               </tr>
           ))}
       </tbody>
   </table>
   
      ) : (
        !error && <p>Cargando productos...</p>
      )}
    </div>
  );
};

export default TestAPI;