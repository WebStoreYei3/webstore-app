'use strict';
angular.module('webstore-app')
    .factory('ProductoServ',function ($resource) {
        var factory = {
            obtenerProductosLimit: $resource('/obtenerProductos', {}, {
                a: {method: 'GET', params:{
                    cantidad : "@cantidad"
                },isArray:true}
            }),
            obtenerProductoById: $resource('/obtenerProductoById', {}, {
                b: {method: 'GET', params:{
                    id : "@id"
                },isArray:false}
            }),
            buscarProductos: $resource('/buscarProductos', {}, {
                c: {method: 'GET', params:{
                    cadena : "@cadena"
                },isArray:true}
            })
        };
        return factory;
    });
