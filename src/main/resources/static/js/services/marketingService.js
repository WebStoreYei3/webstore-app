'use strict';
angular.module('gem-app-final')
  .factory('MarketingServ',function ($resource) {
    var factory = {
        generarCliente: $resource('/generarCliente', {}, {
        findClientes: {method: 'POST', params:{
          idMarketing : "@idMarketing"}
        }
      }),
      generarCitas: $resource('/findAllCitas', {}, {
        findCitas: {method: 'GET', params:{},isArray:true}
      }),
      generarPorqueNo: $resource('/findAllPorqueNoGemobile', {}, {
        findPN: {method: 'GET', params:{}}
      }),
      generarPorqueCambio: $resource('/findAllPorqueCambio', {}, {
        findPC: {method: 'GET', params:{}}
      }),
      generarSatus: $resource('/findAllStatus', {}, {
        findEstados: {method: 'GET', params:{},isArray:true}
      }),
      actualizar: $resource('/actualizarStatusCliente', {}, {
        cliente: {method: 'POST', params:{
          clienteId : "@clienteId",
          idStatus : "@idStatus",
          idPorqueCambio : "@idPorqueCambio",
          idPorqueNoGemobile : "@idPorqueNoGemobile",
          cuando : "@cuando",
          idMarketing: "@idMarketing",
          idSubdis: "@idSubdis"}
        }
      }),
      agendar: $resource('/agendarCita', {}, {
        cita: {method: 'POST', params:{
          clienteId : "@clienteId",
          cUsuario : "@cUsuario",
          cNumContacto : "@cNumContacto",
          cDelegacion: "@cDelegacion",
          cCalle: "@cCalle",
          cColonia: "@cColonia",
          cNoExterior: "@cNoExterior",
          cNoInterior: "@cNoInterior",
          cEntCalle1: "@cEntCalle1",
          cEntCalle2: "@cEntCalle2",
          tObsDireccion: "@tObsDireccion",
          fCita: "@fCita",
          tObservaciones: "@tObservaciones",
          marketingId: "@marketingId"}
        }
      }),
      buscar: $resource('/findClienteByNumero',{} , {
        clientebyNumero: {method: 'POST', parms:{
          numero : "@numero",
          idMarketing: "@idMarketing",
          idSubdis: "@idSubdis"}
        }
      }),
      encontrar: $resource('/findAllMarketings',{} , {
        todos: {method: 'GET', parms: {}, isArray: true}
      })
    };
    return factory;
  });
