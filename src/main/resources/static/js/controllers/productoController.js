'use strict';
angular.module('webstore-app')
    .controller('ProductoCtrl', function ($scope, $location, $log,$routeParams,ProductoServ) {
        $scope.producto = {};
        $scope.myInterval = 5000;

        $scope.comprar = function () {
            $location.path('/direccion');
        };

        $scope.cargarPaginaProducto = function (){
            ProductoServ.obtenerProductoById.b({
                id:$routeParams.id
            })
                .$promise.then(function (key) {
                $scope.producto = key;
            })
        };

        $scope.cargarPaginaProducto();
    });
