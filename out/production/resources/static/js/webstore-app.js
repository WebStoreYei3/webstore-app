'use strict';
angular.module('webstore-app', ['ngRoute', 'ngAnimate', 'ngResource', 'ngCookies', 'moment-picker', 'datatables', 'datatables.scroller', 'datatables.select', 'angular.morris', 'ng-fusioncharts','ui.carousel'])
    .run(function ($rootScope, $location) {
        $rootScope.$on('$routeChangeStart', function (event, next, current) {
            if (sessionStorage.length != 3) {
                if (next.templateUrl == 'pages/administrador.tplt.html'
                    || next.templateUrl == 'pages/marketing.tplt.html'
                    || next.templateUrl == 'pages/cerrador.tplt.html') {
                    $location.path('/login');
                }
            }
        })
    })
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'pages/public.tplt.html',
                controller: ''
            })
            .when('/login', {
                templateUrl: 'pages/login.tplt.html',
                controller: 'LoginCtrl'
            })
            .when('/producto/:id', {
                templateUrl: 'pages/producto.tplt.html',
                controller: 'ProductoCtrl'
            })
            .when('/direccion', {
                templateUrl: 'pages/direccion.tplt.html',
                controller: 'DireccionCtrl'
            })
            .when('/cheackout', {
                templateUrl: 'pages/cheackout.tplt.html',
                controller: 'CheckOutCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
