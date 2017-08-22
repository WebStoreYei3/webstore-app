'use strict';
angular.module('webstore-app')
    .factory('PublicServ',function () {
        var ret = {};
        var log = [];
        ret.productos = JSON.parse(sessionStorage.getItem('carrito'));
        ret.total = angular.forEach(ret.productos, function(value) {
            alert(value.dPrecioPublico);
            ret.total = ret.total + (value.dPrecioPublico*value.cantidadProducto);
        }, log);
        return ret;
    });
