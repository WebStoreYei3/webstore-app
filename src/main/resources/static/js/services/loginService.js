'use strict';
angular.module('gem-app-final')
  .factory('LoginServ',function ($resource) {
    var auth = {
      autentificar: $resource('/login', {}, {
        usu: {method: 'POST', params:{username: "@username", password: "@password"}}
      })
    };
    return auth;
});


