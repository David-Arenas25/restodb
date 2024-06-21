package com.restaurante.app.repositorio;


public interface PagoPedido {
    float pagar(int idPedido, float nuevoTotal);
}
