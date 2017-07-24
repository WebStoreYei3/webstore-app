+'use strict';
angular.module('webstore-app')
  .factory('LoginServ',function ($resource) {
    var auth = {
      autentificar: $resource('/login', {}, {
        usu: {method: 'POST', params:{username: "@username", password: "@password"}}
      })
    };
    return auth;
});


