'use strict';
angular.module('gem-app-final')
  .factory('SubdisServ',function ($resource) {
    var factory = {
        generarCliente: $resource('/generarClienteSubdis', {}, {
        findClientes: {method: 'POST', params:{
          idSubdis : "@idSubdis"}
        }
      })
    };
    return factory;
  });
