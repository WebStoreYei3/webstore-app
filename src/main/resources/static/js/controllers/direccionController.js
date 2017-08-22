'use strict';
angular.module('webstore-app')
    .controller('DireccionCtrl',function ($scope, $location,$log) {
        $scope.aplicar = function () {
            sessionStorage.setItem('direccionEntrega',$scope.direecionEntrega);
            $location.path('/cheackout');
        };
    });
