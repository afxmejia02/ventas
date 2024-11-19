import axios from 'axios';

const url="https://manifest-emblem-437615-g9.rj.r.appspot.com/admin";


export const getAdmins = () => {
    return axios.get(url);
}

export const getAdmin = (id) => {
    return axios.get(`${url}/${id}`);
}

export const getAdminByNombre = (nombre) => {
    return axios.get(`${url}/nombre/${nombre}`);
}


export const ingresarUsuario = (nombre, contrasena) => {
    return axios.get(`${url}/ingresar`, {
        params: { nombre, contrasena }
    });
}

export const createAdmin = (adminData, contrasena) => {
    return axios.post(`${url}/create`, adminData, {
        params: { contrasena }
    });
}

export const updateAdmin = (id, adminData) => {
    return axios.put(`${url}/update/${id}`, adminData);
}

export const updateAdminPassword = (id, contrasena, nuevoContrasena) => {
    return axios.put(`${url}/update-password/${id}`, null, {
        params: { contrasena, nuevoContrasena }
    });
}


export const deleteAdmin = (id) => {
    return axios.delete(`${url}/delete/${id}`);
}
