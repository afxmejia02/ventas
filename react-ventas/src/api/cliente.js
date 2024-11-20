import axios from 'axios';

const url = "https://manifest-emblem-437615-g9.rj.r.appspot.com/clientes";

// Obtener todos los clientes
export const getClientes = () => {
    return axios.get(url);
}

// Obtener un cliente por su ID
export const getClienteById = (id) => {
    return axios.get(`${url}/${id}`);
}

// Obtener clientes por nombre
export const getClientesByNombre = (nombre) => {
    return axios.get(`${url}/nombre/${nombre}`);
}

// Autenticar un usuario por nombre y contraseña
export const ingresarUsuario = (nombre, contrasena) => {
    return axios.get(`${url}/ingresar`, {
        params: { nombre, contrasena }
    });
}

// Crear un nuevo cliente
export const createCliente = (cliente, tipodocumento, contrasena) => {
    return axios.post(`${url}/create`, cliente, {
        params: { tipodocumento_String: tipodocumento, contrasena }
    });
}

// Actualizar un cliente por ID
export const updateClienteById = (id, cliente, tipodocumento) => {
    return axios.put(`${url}/update/${id}`, cliente, {
        params: { tipodocumento_String: tipodocumento }
    });
}

// Actualizar la contraseña de un cliente
export const updateClientePassword = (id, contrasena, nuevoContrasena) => {
    return axios.put(`${url}/update-password/${id}`, null, {
        params: { contrasena, nuevoContrasena }
    });
}

// Eliminar un cliente por ID
export const deleteClienteById = (id) => {
    return axios.delete(`${url}/delete/${id}`);
}
