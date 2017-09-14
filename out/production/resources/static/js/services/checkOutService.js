'use strict';
angular.module('webstore-app')
    .factory('CheckOutServ',function ($resource) {
        var auth = {
            generar: $resource('/generarPago', {}, {
                pago: {method: 'POST', params:{
                    direccion: "@direccion",
                    filas: "@filas",
                    usuarioId: "@usuarioId",
                    nombre: "@nombre",
                    apePat: "@apePat",
                    apeMat: "@apeMat",
                    email: "@email",
                    tel: "@tel",
                    numeroInt: "@numeroInt",
                    instEspeciales: "@instEspeciales"
                }}
            })
        };
        return auth;
    });