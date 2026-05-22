package agenda_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reglas")
public class ReglasController {

    @GetMapping("/validar")
    public boolean validar(
            @RequestParam String fecha,
            @RequestParam String hora,
            @RequestParam String servicio
    ) {

        // 🔥 aquí simulas lógica de Haskell
        if (hora.equals("16:00")) {
            return false; // ocupado
        }

        return true; // disponible
    }
}