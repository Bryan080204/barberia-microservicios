package agenda_service.controller;

import agenda_service.model.Cita;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private List<Cita> listaCitas = new ArrayList<>();

    // ✅ VER CITAS
    @GetMapping
    public List<Cita> obtenerCitas() {
        return listaCitas;
    }

    // ✅ CREAR CITA (con validación tipo Haskell)
    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {

        boolean disponible = validarHorario(cita);

        if (!disponible) {
            throw new RuntimeException("Horario no disponible");
        }

        cita.setId((long) (listaCitas.size() + 1));
        cita.setEstado("ACTIVA");
        listaCitas.add(cita);

        return cita;
    }

    // ✅ CANCELAR CITA
    @DeleteMapping("/{id}")
    public String cancelarCita(@PathVariable Long id) {
        for (Cita cita : listaCitas) {
            if (cita.getId().equals(id)) {
                cita.setEstado("CANCELADA");
                return "Cita cancelada correctamente";
            }
        }
        return "Cita no encontrada";
    }

    // 🔥 VALIDACIÓN (simulación microservicio Haskell)
    private boolean validarHorario(Cita nuevaCita) {

        for (Cita c : listaCitas) {
            if (c.getFecha().equals(nuevaCita.getFecha()) &&
                c.getHora().equals(nuevaCita.getHora())) {
                return false;
            }
        }

        return true;
    }
}