Feature: Buscar productos disponibles
Los clientes deben poder encontrar que productos estàn disponibles para comprar

Scenario: Obtener productos disponibles
 Given El usuario quiere saber los productos disponibles
 When mira los productos disponibles
 Then el debe ver los productos que están disponibles
