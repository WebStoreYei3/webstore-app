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

        $(document).ready(function(){

            var quantitiy=0;
            $('.quantity-right-plus').click(function(e){

                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity').val());

                // If is not undefined

                $('#quantity').val(quantity + 1);


                // Increment

            });

            $('.quantity-left-minus').click(function(e){
                // Stop acting like a button
                e.preventDefault();
                // Get the field name
                var quantity = parseInt($('#quantity').val());

                // If is not undefined

                // Increment
                if(quantity>0){
                    $('#quantity').val(quantity - 1);
                }
            });

        });
    });
