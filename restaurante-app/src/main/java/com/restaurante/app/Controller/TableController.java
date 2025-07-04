package com.restaurante.app.Controller;

import com.restaurante.app.dto.Table;
import com.restaurante.app.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/all")
    public List<Table> getAll(){
        return tableService.getAll();
    }
}
