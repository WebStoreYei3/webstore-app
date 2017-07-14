'use strict';
angular.module('gem-app-final')
  .factory('TramitesServ',function ($resource) {
    var factory = {
      generar: $resource('/generarTramite', {}, {
        tramite: {method: 'POST', params:{
          cModalidad: "@cModalidad",
          dDiferencia : "@dDiferencia",
          cPlan: "@cPlan",
          iPlazo: "@iPlazo",
          cEquipo: "@cEquipo",
          cEmail: "@cEmail",
          cTelCasa: "@cTelCasa",
          cTelOficina: "@cTelOficina",
          cCelLocalizacion: "@cCelLocalizacion",
          dRenta: "@dRenta",
          cMin: "@cMin",
          cSms: "@cSms",
          cMegas: "@cMegas",
          cNumsPref: "@cNumsPref",
          cNomRef: "@cNomRef",
          cTelRef: "@cTelRef",
          cIfe: "@cIfe",
          cChip: "@cChip",
          cMensajeria: "@cMensajeria",
          cCostoChip: "@cCostoChip",
          cMsgPagado: "@cMsgPagado",
          cChipPagado: "@cChipPagado",
          tDireccionEntrega: "@tDireccionEntrega",
          tObservaciones: "@tObservaciones",
          idEmplTramites: "@idEmplTramites",
          idCita: "@idCita",
          tDireccionFactura: "@tDireccionFactura"}
        }
      }),
      obtener: $resource('/findAllTramitesSinProcesar', {}, {
        tramitesSinAsignar: {method: 'GET', params:{},isArray:true}
      }),
      cancelar: $resource('/cancelarTramite', {}, {
        tramites: {method: 'POST', params:{
          idTramite:"@idTramite"
        }}
      }),
      marcar: $resource('/marcarProcesado', {}, {
        procesado: {method: 'POST', params:{
          idTramite:"@idTramite",
          telefonoNuevo:"@telefonoNuevo"
        }}
      }),
      tramites: $resource('/findAllTramitesProcesados', {}, {
        asignados: {method: 'GET', params:{},isArray:true}
      }),
      tramitesby: $resource('/findTramiteByTelefono', {}, {
        telefono: {method: 'POST', params:{
          numero:"@numero"
        }}
      }),
      tramitar: $resource('/solicitarNuevaLinea', {}, {
        nuevaLinea: {method: 'POST',params:{
          cNombre : "@cNombre",
          cUsuario : "@cUsuario",
          cNumContacto : "@cNumContacto",
          cDelegacion: "@cDelegacion",
          cCalle: "@cCalle",
          cColonia: "@cColonia",
          cNoExterior: "@cNoExterior",
          cNoInterior: "@cNoInterior",
          cEntCalle1: "@cEntCalle1",
          cEntCalle2: "@cEntCalle2",
          idCerrador: "@idCerrador",
          cModalidad: "@cModalidad",
          dDiferencia : "@dDiferencia",
          cPlan: "@cPlan",
          iPlazo: "@iPlazo",
          cEquipo: "@cEquipo",
          cEmail: "@cEmail",
          cTelCasa: "@cTelCasa",
          cTelOficina: "@cTelOficina",
          cCelLocalizacion: "@cCelLocalizacion",
          dRenta: "@dRenta",
          cMin: "@cMin",
          cSms: "@cSms",
          cMegas: "@cMegas",
          cNumsPref: "@cNumsPref",
          cNomRef: "@cNomRef",
          cTelRef: "@cTelRef",
          cIfe: "@cIfe",
          cChip: "@cChip",
          cMensajeria: "@cMensajeria",
          cCostoChip: "@cCostoChip",
          cMsgPagado: "@cMsgPagado",
          cChipPagado: "@cChipPagado",
          tDireccionEntrega: "@tDireccionEntrega",
          tObservaciones: "@tObservaciones"}
        }
      })
    };
    return factory;
  });
