'use strict';
angular.module('webstore-app')
    .controller('PublicCtrl',function ($scope, $location,WorkspaceServ, ProductoServ,$log,PublicServ,LoginServ) {
        $scope.myInterval = 5000;
        PublicServ.carrito;
        $scope.total = PublicServ.total;
        $scope.busqueda = "";
        PublicServ.check = "";
        $scope.check = PublicServ.check;
        $scope.imagenesSlide1=["http://68.cdn.pagina.mx/css-files/templates/847/green_bimage.jpg",
            "https://sc01.alicdn.com/kf/HTB1DpB4OVXXXXcxXXXX760XFXXXP/229809243/HTB1DpB4OVXXXXcxXXXX760XFXXXP.png",
            "http://www.familydog.com.mx/images/slider_pic2.jpg"]

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


        $scope.cargarPagina = function () {
            ProductoServ.obtenerProductosLimit.a({
                cantidad:9
            })
                .$promise.then(function(key) {
                $scope.productos = key;
            })
            var log = [];
            if(JSON.parse(sessionStorage.getItem('carrito'))!==null) {
                $scope.productosA = JSON.parse(sessionStorage.getItem('carrito')).productos;
                $scope.total = 0;
                angular.forEach($scope.productosA, function (value) {
                    $scope.total = $scope.total + (value.dPrecioPublico * value.cantidadProducto);
                }, log);
            }
        };


        $scope.buscarProductosIndex = function (){
            if($scope.busqueda!==null&&$scope.busqueda!=="") {
                ProductoServ.buscarProductos.c({
                    cadena: $scope.busqueda
                })
                    .$promise.then(function (key) {
                    $scope.productos = key;
                })
            }else{
                ProductoServ.obtenerProductosLimit.a({
                    cantidad:9
                })
                    .$promise.then(function(key) {
                    $scope.productos = key;
                })
            }
        };

        $scope.cargarPagina();

        $scope.reloadRoute = function() {
            $window.location.reload();
        }

        $scope.selectItem = function (id) {
            sessionStorage.setItem('itemSelect',id);
        }

        $scope.cerrarSesion = function () {
            LoginServ.cliente.logOut({
                id:sessionStorage.getItem('usuarioId')
            })
                .$promise.then(function(key) {
                alert("Nos vemos" + $scope.name);
                $scope.name="";
                sessionStorage.clear();
                $location.path('/');
            })
        }

    });
