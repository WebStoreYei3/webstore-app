'use strict';
angular.module('webstore-app')
  .factory('LoginServ',function ($resource) {
    var auth = {
      autentificar: $resource('/clienteLogin', {}, {
          clienteLogin: {method: 'POST', params:{usuario: "@usuario", contrasenia: "@contrasenia", fUltSesion: "@fUltSesion"}}
      })
    };
    return auth;
});


