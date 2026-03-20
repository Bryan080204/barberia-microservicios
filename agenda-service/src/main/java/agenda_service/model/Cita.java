package agenda_service.model;

public class Cita {

    private Long id;
    private String clienteNombre;
    private String servicio;
    private String fecha;
    private String hora;
    private String estilista;
    private String estado;

    public Cita() {}

    public Cita(Long id, String clienteNombre, String servicio, String fecha, String hora, String estilista, String estado) {
        this.id = id;
        this.clienteNombre = clienteNombre;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
        this.estilista = estilista;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstilista() {
        return estilista;
    }

    public void setEstilista(String estilista) {
        this.estilista = estilista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}