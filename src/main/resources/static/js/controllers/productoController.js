'use strict';
angular.module('webstore-app')
    .controller('ProductoCtrl', function ($scope, $location, $log) {

        $scope.comprar = function () {
            $location.path('/direccion');
        };

    });
