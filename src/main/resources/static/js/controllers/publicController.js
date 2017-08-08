'use strict';
angular.module('webstore-app')
  .controller('PublicCtrl',function ($scope, $location,WorkspaceServ,$log) {


    $scope.estaConectado = function() {
      $scope.name = sessionStorage.getItem('nombre');
      if(sessionStorage.getItem('conectado')!='true'){
        return false;
      }else{
        return true;
      }
    };
    $scope.salir = function() {
      sessionStorage.clear();
      alert('Nos vemos!');
      $location.path('/');
    };

    $scope.workS = function () {
      $location.path(WorkspaceServ.work());
      $log.info(WorkspaceServ.work());
    };

  });
