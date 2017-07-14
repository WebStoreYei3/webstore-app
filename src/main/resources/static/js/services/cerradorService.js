'use strict';
angular.module('gem-app-final')
  .factory('CerradorServ',function ($resource) {
    var factory = {
      encontrar: $resource('/findCitasByCerrador', {}, {
        citasPorCerrador: {method: 'POST', params:{
          id : "@id"
        },isArray:true}
      })
    };
    return factory;
  });
