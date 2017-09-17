'use strict';
angular.module('webstore-app')
    .controller('NuevaContraseniaCtrl', function ($scope, NuevaContraseniaServ,$routeParams,$location) {
        $scope.error={};
        $scope.dat = $routeParams.dat;

            $scope.setNuevaContrasenia = function() {
            NuevaContraseniaServ.setearNueva.contrasenia({
                key : $scope.dat,
                nuevaContrasenia : $scope.nuevaContrasenia
            })
                .$promise.then(function(key) {
                $scope.error.b = key.resultado;
                alert("Se ha guardado tu nueva contraseña");
                $location.path('/login');
            })
        };
    });

