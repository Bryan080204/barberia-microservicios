package agenda_service.controller;

import agenda_service.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping
    public List<Cliente> obtenerClientes(){
        return clientes;
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente){

        cliente.setId((long)(clientes.size()+1));
        cliente.setPuntos(0);

        clientes.add(cliente);

        return cliente;
    }
}