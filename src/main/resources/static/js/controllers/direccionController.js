'use strict';
angular.module('webstore-app')
    .controller('DireccionCtrl',function ($scope, $location,$log) {
        $scope.aplicar = function () {
            $location.path('/cheackout');
        };
    });
