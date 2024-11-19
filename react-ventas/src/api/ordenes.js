import axios from 'axios';

const url = "https://tu-servidor.com/ordenes";

// Obtener todas las órdenes
export const getOrdenes = () => {
    return axios.get(url);
}

// Obtener una orden por su ID
export const getOrdenById = (id) => {
    return axios.get(`${url}/${id}`);
}

// Obtener órdenes por ID de cliente
export const getOrdenesByClienteId = (clienteId) => {
    return axios.get(`${url}/cliente/${clienteId}`);
}

// Obtener órdenes dentro de un rango de fechas
export const getOrdenesByFechas = (fechaInicio, fechaFin) => {
    return axios.get(`${url}/fechas/${fechaInicio}/${fechaFin}`);
}
