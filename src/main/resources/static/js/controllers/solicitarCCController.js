'use strict';
angular.module('webstore-app')
    .controller('SolicitarCCCtrl', function ($scope, SolicitarCCServ,$location) {
        $scope.noexiste=false;

        $scope.solicitarCC = function() {
            SolicitarCCServ.solicitar.CC({
                correo : $scope.correoCC
            })
                .$promise.then(function(key) {
                $scope.noexiste = key.resultado;
                if(!key.resultado) {
                    alert("Se ha enviado un mail a su bandeja de entrada, revise su bandeja de entrada y correo no deseado");
                    $location.path('/');
                }
            })
        };
    });

