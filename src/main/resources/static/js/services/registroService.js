'use strict';
angular.module('webstore-app')
    .factory('RegistroServ',function ($resource) {
        var factory = {
            registro: $resource('/registrarse', {}, {
                cliente: {method: 'POST', params:{
                    email : "@email",
                    nombre : "@nombre",
                    apellidoPat : "@apellidoPat",
                    apellidoMat : "@apellidoMat",
                    telefono : "@telefono",
                    contrasenia : "@contrasenia"
                },isArray:false}
            })
        };
        return factory;
    });