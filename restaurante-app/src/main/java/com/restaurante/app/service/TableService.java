package com.restaurante.app.service;

import com.restaurante.app.dto.Table;
import com.restaurante.app.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;
    public List<Table> getAll(){
        return this.tableRepository.getAll();

    }
}
