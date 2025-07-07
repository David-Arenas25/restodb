package com.restaurante.app.service;

import com.restaurante.app.entity.Mesa;
import com.restaurante.app.dto.Table;
import com.restaurante.app.mapper.TableMapper;
import com.restaurante.app.repositorio.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TableService {
    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private TableMapper tableMapper;

    public List<Table> getAll() {
        return tableMapper.toTables(mesaRepository.findAll());
    }

}
