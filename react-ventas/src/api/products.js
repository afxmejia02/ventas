import axios from 'axios';

const url="https://manifest-emblem-437615-g9.rj.r.appspot.com/productos";


export const getProducts = () => {
    return axios.get(url);
}

export const getProduct = (id) => {
    return axios.get(`${url}/${id}`);
}

export const getProductoByGenero = (genero) => {
    return axios.get(`${url}/genero/${genero}`);
}

export const getProductoByCategoria = (categoria) => {
    return axios.get(`${url}/categoria/${categoria}`);
}

export const getProductoByNombre = (nombre) => {
    return axios.get(`${url}/nombre/${nombre}`);
}

export const getProductoByTalla = (talla) => {
    return axios.get(`${url}/talla/${talla}`);
}

export const getProductoByGeneroTalla = (talla) => {
    return axios.get(`${url}/talla/${talla}`);
}


export const createProduct = (product,talla) => {
    return axios.post(`${url}/create?talla=${talla}`, product);
}

export const updateProduct = (id, product, talla) => {
    return axios.put(`${url}/update/${id}?talla=${talla}`, product);
}

export const deleteProduct = (id) => {
    return axios.delete(`${url}/delete/${id}`);
}

