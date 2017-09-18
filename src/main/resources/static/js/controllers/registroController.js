'use strict';
angular.module('webstore-app')
    .controller('RegistroCtrl', function ($scope, RegistroServ,$location) {
        $scope.error = {};

        $scope.registrarUsuario = function() {
            $scope.error.yaexiste=false;
            $scope.error.completar=false;
            if(
                $scope.email!==null &&
                $scope.nombre!==null &&
                $scope.apePat!==null &&
                $scope.tel!==null &&
                $scope.contrasenia!==null &&
                $scope.email === $scope.confMail &&
                $scope.contrasenia === $scope.contraseniaConf
            ){
                RegistroServ.registro.cliente({
                    email : $scope.email,
                    nombre : $scope.nombre,
                    apellidoPat : $scope.apePat,
                    apellidoMat : $scope.apeMat,
                    telefono : $scope.tel,
                    contrasenia : $scope.contrasenia
                })
                    .$promise.then(function(key) {
                    $scope.error.usuario = false;
                    $scope.error.contrasenia = false;
                    if(key.error =='1'){
                        alert('Se enviara un mail a tu correo:'+ $scope.email+'  para confirmar la cuenta.')
                        $location.path('/index.html');

                    }else if(key.error =='4'){
                        $scope.error.yaexiste=true;
                    }else{
                    }
                })
            }
            $scope.error.completar=true;
        };
    });

