'use strict';
angular.module('webstore-app',['ngRoute', 'ngAnimate', 'ngResource',  'ngCookies', 'moment-picker','datatables','datatables.scroller','datatables.select','angular.morris','ng-fusioncharts'])
  .run(function($rootScope, $location) {
    $rootScope.$on('$routeChangeStart', function(event, next, current) {
      if (sessionStorage.length != 4) {
        if(next.templateUrl == 'pages/administrador.tplt.html'
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
      .otherwise({
        redirectTo: '/'
      });
  });
