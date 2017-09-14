'use strict';
angular.module('webstore-app')
    .controller('ProductoCtrl', function ($scope, $location, $log,$routeParams,ProductoServ,PublicServ) {
        $scope.myInterval = 5000;
        $scope.carrito = {
            productos:[]
        };
        $scope.cantidadProducto = 1;

        $scope.comprar = function () {
            $scope.anadirCarrito();
            $location.path('/direccion');
        };
        $scope.anadirCarrito = function () {
            if(sessionStorage.getItem('carrito')!==null){
                $scope.carrito = JSON.parse(sessionStorage.getItem('carrito'));
                PublicServ.productos = JSON.parse(sessionStorage.getItem('carrito'));
            }
            $scope.producto.cantidadProducto = $scope.cantidadProducto;
            $scope.carrito.productos[$scope.carrito.productos.length] = $scope.producto;
            PublicServ.productos = $scope.carrito.productos;
            sessionStorage.setItem('carrito',JSON.stringify($scope.carrito));
            PublicServ.ret = $scope.carrito;
            PublicServ.check="open"
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

        $scope.botonMas = function () {
            if($scope.cantidadProducto<=99) {
                $scope.cantidadProducto = $scope.cantidadProducto + 1;
            }
        };

        $scope.botonMenos = function () {
            if($scope.cantidadProducto>=1) {
                $scope.cantidadProducto = $scope.cantidadProducto - 1;
            }
        };
    });
