import axios from 'axios';

const url = "https://manifest-emblem-437615-g9.rj.r.appspot.com/carritos";

// Obtener todos los carritos
export const getCarritos = () => {
    return axios.get(url);
}

// Obtener un carrito por su ID
export const getCarritoById = (id) => {
    return axios.get(`${url}/${id}`);
}

// Obtener carritos por ID de cliente
export const getCarritosByClienteId = (clienteId) => {
    return axios.get(`${url}/cliente/${clienteId}`);
}

// Crear un nuevo carrito para un cliente
export const createCarrito = (clienteId) => {
    return axios.post(`${url}/create`, null, {
        params: { cliente_id: clienteId }
    });
}

// Actualizar un carrito existente con un nuevo ID de cliente
export const updateCarrito = (id, clienteId) => {
    return axios.put(`${url}/update`, null, {
        params: { id, cliente_id: clienteId }
    });
}

// Marcar un carrito como comprado
export const comprarCarrito = (id) => {
    return axios.put(`${url}/comprar`, null, {
        params: { id }
    });
}

// Eliminar un carrito por su ID
export const deleteCarrito = (id) => {
    return axios.delete(`${url}/delete/${id}`);
}
