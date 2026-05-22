package agenda_service.controller;

import agenda_service.model.Cita;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private List<Cita> listaCitas = new ArrayList<>();

    @GetMapping
    public List<Cita> obtenerCitas() {
        return listaCitas;
    }

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {

        RestTemplate restTemplate = new RestTemplate();
        Boolean disponible;

        try {
            String url = "http://localhost:8082/reglas/validar?fecha="
                    + cita.getFecha()
                    + "&hora=" + cita.getHora()
                    + "&servicio=" + cita.getServicio();

            disponible = restTemplate.getForObject(url, Boolean.class);

        } catch (Exception e) {
            System.out.println("⚠️ Servicio de reglas no disponible");

            // 🔥 Fallback (sigue funcionando aunque falle el otro servicio)
            disponible = true;
        }

        if (!disponible) {
            throw new IllegalArgumentException("Horario no disponible");
        }

        cita.setId((long) (listaCitas.size() + 1));
        cita.setEstado("ACTIVA");
        listaCitas.add(cita);

        return cita;
    }

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

    // 🔥 VALIDACIÓN LOCAL (fallback opcional si quieres usarlo)
    private boolean validarHorario(Cita nuevaCita) {

        int duracionNueva = obtenerDuracion(nuevaCita.getServicio());

        for (Cita c : listaCitas) {

            if (c.getFecha().equals(nuevaCita.getFecha())) {

                int duracionExistente = obtenerDuracion(c.getServicio());

                int inicioExistente = convertirHoraAMinutos(c.getHora());
                int finExistente = inicioExistente + duracionExistente;

                int inicioNueva = convertirHoraAMinutos(nuevaCita.getHora());
                int finNueva = inicioNueva + duracionNueva;

                if (inicioNueva < finExistente && finNueva > inicioExistente) {
                    return false;
                }
            }
        }

        return true;
    }

    private int obtenerDuracion(String servicio) {
        switch (servicio.toLowerCase()) {
            case "corte":
                return 30;
            case "barba":
                return 20;
            case "corte + barba":
                return 45;
            default:
                return 30;
        }
    }

    private int convertirHoraAMinutos(String hora) {
        String[] partes = hora.split(":");
        int h = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);
        return h * 60 + m;
    }
}