package com.restaurante.app.Controller;

import com.restaurante.app.dto.Table;
import com.restaurante.app.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/all")
    public List<Table> getAll(){
        return tableService.getAll();
    }

@PutMapping("/estado")
public void cambiarEstadoMesa(@RequestBody Map<String, Object> body) {
    int idMesa = (int) body.get("idMesa");
    String estado = (String) body.get("estado");
    tableService.cambiarEstadoMesa(idMesa, estado);
}
    


}
