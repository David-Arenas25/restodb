package com.restaurante.app.repository;

import com.restaurante.app.dto.Table;
import com.restaurante.app.mapper.TableMapper;
import com.restaurante.app.repositorio.MesaRepository;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableRepository {
    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private TableMapper tableMapper;


    public List<Table> getAll(){
        return tableMapper.toTables(mesaRepository.findAll());
    }
}
