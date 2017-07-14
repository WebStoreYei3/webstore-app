'use strict';
angular.module('gem-app-final')
  .controller('PublicCtrl',function ($scope, $location,WorkspaceServ,$log) {

    $scope.name = sessionStorage.getItem('nombre');
    $scope.estaConectado = function() {
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
