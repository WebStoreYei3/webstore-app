'use strict';
angular.module('webstore-app')
    .factory('SolicitarCCServ',function ($resource) {
        var factory = {
            solicitar: $resource('/solicitarMailContrasenia', {}, {
                CC: {method: 'POST', params:{
                    correo: "@correo"
                },isArray:false}
            })
        };
        return factory;
    });