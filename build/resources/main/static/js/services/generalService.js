'use strict';
angular.module('webstore-app')
  .factory('WorkspaceServ',function () {
    var WorkspaceServ = {work : function(){
      var aux = {};
      if(sessionStorage.rol == 'A'){
        aux = '/administrador'
      }
      if (sessionStorage.rol == 'M') {
        aux = '/marketing';
      }
      if (sessionStorage.rol == 'C') {
        aux = '/cerrador';
      }
      if (sessionStorage.rol == 'T') {
        aux = '/tramites';
      }
      if (sessionStorage.rol == 'S') {
        aux = '/subdis';
      }
      return aux;
      }

  }
    return WorkspaceServ;
  });
