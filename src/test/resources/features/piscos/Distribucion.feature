Feature: Buscar pedidos disponibles
Los distruidores deben poder encontrar que pedidos estàn disponibles para enviar

Scenario: Obtener distribuciones de pedidos disponibles
 Given El usuario quiere distribuir los pedidos disponibles
 When mira los pedidos disponibles
 Then el debe ver las distribuciones que están disponibles

Scenario: Obtener distribuciones de pedidos disponibles por su Id
  Given El usuario quiere distribuir los pedidos disponibles
  When mira los pedidos disponibes por su identificador
  Then el debe ver las distribuciones que estàn disponibles que coincide con esa identificacion