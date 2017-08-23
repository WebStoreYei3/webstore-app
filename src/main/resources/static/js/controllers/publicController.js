'use strict';
angular.module('webstore-app')
    .controller('PublicCtrl',function ($scope, $location,WorkspaceServ, ProductoServ,$log,PublicServ) {
        $scope.myInterval = 5000;
        $scope.productos = PublicServ.productos;
        $scope.total = PublicServ.total;

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
        };

        $scope.cargarPagina();

        $scope.selectItem = function (id) {
            sessionStorage.setItem('itemSelect',id);
        }

    });
