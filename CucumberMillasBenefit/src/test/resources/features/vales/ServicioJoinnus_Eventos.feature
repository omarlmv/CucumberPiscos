Feature: Consultar Sincronizacion Eventos - Joinnus 

Scenario: Consultar Sincronizacion de Eventos
Given Usuario consulte el servicio de eventos de joinnus
When  pase una hora los eventos se actualizan 
Then  se visualizan la misma cantidad y los mismos eventos en el front