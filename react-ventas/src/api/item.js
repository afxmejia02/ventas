import axios from 'axios';

const url = "https://tu-servidor.com/items";

// Obtener todos los ítems
export const getItems = () => {
    return axios.get(url);
}

// Obtener un ítem por su ID
export const getItemById = (id) => {
    return axios.get(`${url}/${id}`);
}

// Obtener ítems por ID de carrito
export const getItemsByCarritoId = (carritoId) => {
    return axios.get(`${url}/carrito/${carritoId}`);
}

// Obtener ítems por estado de compra del carrito
export const getItemsByCarritoComprado = (carritoComprado) => {
    return axios.get(`${url}/carrito/comprado/${carritoComprado}`);
}

// Obtener ítems por ID de producto
export const getItemsByProductoId = (productoId) => {
    return axios.get(`${url}/producto/${productoId}`);
}

// Crear un nuevo ítem
export const createItem = (unidades, producto_id, carrito_id) => {
    return axios.post(`${url}/create`, null, {
        params: { unidades, producto_id, carrito_id }
    });
}

// Actualizar un ítem por ID
export const updateItemById = (id, unidades, producto_id, carrito_id) => {
    return axios.put(`${url}/update/${id}`, null, {
        params: { unidades, producto_id, carrito_id }
    });
}

// Eliminar un ítem por ID
export const deleteItemById = (id) => {
    return axios.delete(`${url}/delete/${id}`);
}