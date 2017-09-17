'use strict';
angular.module('webstore-app')
    .factory('NuevaContraseniaServ',function ($resource) {
        var factory = {
            setearNueva: $resource('/setearNuevaContrasenia', {}, {
                contrasenia: {method: 'POST', params:{
                    key: "@key",
                    nuevaContrasenia:"@nuevaContrasenia"
                }}
            })
        };
        return factory;
    });