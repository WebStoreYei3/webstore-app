'use strict';
angular.module('webstore-app',['ngRoute', 'ngAnimate', 'ngResource',  'ngCookies', 'moment-picker','datatables','datatables.scroller','datatables.select','angular.morris','ng-fusioncharts'])
  .run(function($rootScope, $location) {
    $rootScope.$on('$routeChangeStart', function(event, next, current) {
      if (sessionStorage.length != 3) {
        if(next.templateUrl == 'pages/administrador.tplt.html'
          || next.templateUrl == 'pages/marketing.tplt.html'
          || next.templateUrl == 'pages/cerrador.tplt.html') {
          $location.path('/login');
        }
      }
    })
      $(function() {
          $('#side-menu').metisMenu();
      });
      $(function() {
          $(window).bind("load resize", function() {
              var topOffset = 50;
              var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
              if (width < 768) {
                  $('div.navbar-collapse').addClass('collapse');
                  topOffset = 100; // 2-row-menu
              } else {
                  $('div.navbar-collapse').removeClass('collapse');
              }

              var height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
              height = height - topOffset;
              if (height < 1) height = 1;
              if (height > topOffset) {
                  $("#page-wrapper").css("min-height", (height) + "px");
              }
          });

          var url = window.location;
          // var element = $('ul.nav a').filter(function() {
          //     return this.href == url;
          // }).addClass('active').parent().parent().addClass('in').parent();
          var element = $('ul.nav a').filter(function() {
              return this.href == url;
          }).addClass('active').parent();

          while (true) {
              if (element.is('li')) {
                  element = element.parent().addClass('in').parent();
              } else {
                  break;
              }
          }
      });
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
