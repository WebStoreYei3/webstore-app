'use strict';
angular.module('webstore-app')
    .controller('CheckOutCtrl',function ($scope,$window, $location,$log,CheckOutServ,PublicServ) {
        $scope.carrito = null;
        $scope.total = 0;
        $scope.obtenerArmarCampos = function () {
            var log = [];
            $scope.direccionEntrega = sessionStorage.getItem('direccionEntrega');
            $scope.carrito = JSON.parse(sessionStorage.getItem('carrito'));
            $scope.total = 0;
            angular.forEach($scope.carrito.productos, function(value) {
                $scope.total = $scope.total + (value.dPrecioPublico*value.cantidadProducto);
            }, log);
        };
        $scope.borrarProducto = function (index) {
            $scope.carrito = JSON.parse(sessionStorage.getItem('carrito'));
            delete $scope.carrito.productos.splice(index,1);
            sessionStorage.setItem('carrito',JSON.stringify($scope.carrito));
            $scope.obtenerArmarCampos();
        };
        $scope.obtenerArmarCampos();
        $scope.generarPago = function() {
            CheckOutServ.generar.pago({
                direccion:$scope.direccionEntrega,
                filas:$scope.carrito.productos,
                usuarioId:$scope.usuarioId,
                nombre:$scope.nombre,
                apePat:$scope.apePat,
                apeMat:$scope.apeMat,
                email:$scope.email,
                tel:$scope.tel,
                numeroInt:$scope.numeroInt,
                instEspeciales:$scope.instEspeciales
            })
                .$promise.then(function(key) {
                $window.location.href = key.link;
                sessionStorage.removeItem('carrito');
            });
        };
    });
