'use strict';
angular.module('webstore-app')
  .controller('LoginCtrl', function ($scope, $q, LoginServ, $log,$location,WorkspaceServ) {
    $scope.usuario={};
    $scope.error={};
    $scope.error.usuario = false;
    $scope.error.contrasenia = false;
    $scope.name = sessionStorage.getItem('nombre');

    $scope.iniciarSesion = function() {
      LoginServ.autentificar.clienteLogin({
          usuario: $scope.usuario.usuario,
          contrasenia: $scope.usuario.contrasenia,
          fUltSesion: new Date().getTime()
      })
        .$promise.then(function(key) {
        $scope.error.usuario = false;
        $scope.error.contrasenia = false;
        if(key.error =='1'){
          sessionStorage.setItem('nombre',key.nombre);
          sessionStorage.setItem('usuarioId',key.id);
          sessionStorage.setItem('conectado',true);

          $log.info(sessionStorage.getItem('nombre'));
          $location.path('/index.html');

        }else if(key.error =='2'){
          $location.path('/login');
          $scope.error.usuario = true;
        }else{
          $location.path('/login');
          $scope.error.contrasenia = true;
        }
      })
    };
  });

