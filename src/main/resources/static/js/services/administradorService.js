'use strict';
angular.module('gem-app-final')
  .factory('AdministradorServ',function ($resource) {
    var factory = {
      encontrarCitas: $resource('/findCitasSinAsignar', {}, {
        sinAsignar: {method: 'GET', params:{},isArray:true}
      }),
      encontrarTodos: $resource('/findAllCerradores', {}, {
        losCerradores: {method: 'GET', params:{},isArray:true}
      }),
      asignar: $resource('/asignarCita', {}, {
        cita: {method: 'POST', params:{
          idCerrador: "@idCerrador",
          idCita: "@idCita"
        }}
      }),
      encontrarPorCerrador: $resource('/findCitasByCerrador', {}, {
        citas: {method: 'POST', params:{
          id: "@id"
        },isArray:true}
      }),
      re: $resource('/reagendarCita', {}, {
        agendarcita: {method: 'POST', params:{
          fechaNueva: "@fechaNueva",
          idCita: "@idCita"
        }}
      }),
      des: $resource('/desasignarCita', {}, {
        asignarCit: {method: 'POST', params:{
          idCita: "@idCita"
        }}
      }),
      cancelar: $resource('/cancelarCita', {}, {
        Cit: {method: 'POST', params:{
          idCita: "@idCita",
          observaciones: "@observaciones"
        }}
      }),
      obtener: $resource('/obtenerResultados', {}, {
        resultados: {method: 'POST', params:{
          fechaDesde: "@fechaDesde",
          fechaHasta: "@fechaHasta",
          rol : "@rol"
        },isArray:true}
      }),
      obtenerT: $resource('/obtenerResultadosTramitados', {}, {
        resultadosT: {method: 'POST', params:{
          fechaDesde: "@fechaDesde",
          fechaHasta: "@fechaHasta",
          rol : "@rol"
        },isArray:true}
      }),
      obtenerE: $resource('/obtenerEfectividadMarketing', {}, {
        resultadosE: {method: 'POST', params:{
          fechaDesde: "@fechaDesde",
          fechaHasta: "@fechaHasta"
        },isArray:true}
      }),
      crear:$resource('/crearCuenta', {}, {
        cuenta: {method: 'POST', params:{
          username: "@username",
          password: "@password",
          rol: "@rol",
          nombre: "@nombre",
          telefono: "@telefono"
        }}
      }),
      eliminar:$resource('/eliminarCuenta', {}, {
        cuenta: {method: 'POST', params:{
          id: "@id",
          rol : "@rol"
        }}
      }),
      modificar:$resource('/modificarCuenta', {}, {
        cuenta: {method: 'POST', params:{
          id: "@id",
          rol: "@rol",
          nombre: "@nombre",
          telefono: "@telefono",
          password: "@password"
        }}
      }),
      modificarLa:$resource('/modificarCita', {}, {
        cita: {method: 'POST', params:{
          cUsuario : "@cUsuario",
          cNumContacto : "@cNumContacto",
          cDelegacion: "@cDelegacion",
          cCalle: "@cCalle",
          cColonia: "@cColonia",
          cNoExterior: "@cNoExterior",
          cNoInterior: "@cNoInterior",
          cEntCalle1: "@cEntCalle1",
          cEntCalle2: "@cEntCalle2",
          tObservaciones: "@tObservaciones",
          id: "@id"
        }}
      }),
      cencontrarProgram: $resource('/findCitasProgramadas', {}, {
        adas: {method: 'GET', params:{},isArray:true}
      }),
      encontrarCan: $resource('/citasByCanceladaFDesdeFHasta', {}, {
        celadas: {method: 'POST', params:{
          fDesde : "@fDesde",
          fHasta : "@fHasta"
        },isArray:true}
      })
    };
    return factory;
  });
