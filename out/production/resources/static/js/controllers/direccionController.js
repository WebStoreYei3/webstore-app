'use strict';
angular.module('webstore-app')
    .controller('DireccionCtrl',function ($scope, $location,$log) {
        $scope.direecionEntrega = "";
        $scope.aplicar = function () {
            $scope.direecionEntrega = document.getElementById('location-text-box').value;
            sessionStorage.setItem('direccionEntrega',$scope.direecionEntrega);
            $location.path('/cheackout');
        };
    });
