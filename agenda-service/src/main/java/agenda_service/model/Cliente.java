package agenda_service.model;

public class Cliente {

    private Long id;
    private String nombre;
    private String telefono;
    private String servicioFavorito;
    private int puntos;

    public Cliente(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getServicioFavorito() {
        return servicioFavorito;
    }

    public void setServicioFavorito(String servicioFavorito) {
        this.servicioFavorito = servicioFavorito;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}