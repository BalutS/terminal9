package org.unimag.dto;

public class PasajeroDto {
    
    private int idPasajero;
    private String nombrePasajero;
    private Short edadPasajero;
    private Boolean generoPasajero;
    private String nombreImagenPublicoPasajero;
    private String nombreImagenPrivadoPasajero;

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public void setEdadPasajero(Short edadPasajero) {
        this.edadPasajero = edadPasajero;
    }

    public void setGeneroPasajero(Boolean generoPasajero) {
        this.generoPasajero = generoPasajero;
    }

    public void setNombreImagenPublicoPasajero(String nombreImagenPublicoPasajero) {
        this.nombreImagenPublicoPasajero = nombreImagenPublicoPasajero;
    }

    public void setNombreImagenPrivadoPasajero(String nombreImagenPrivadoPasajero) {
        this.nombreImagenPrivadoPasajero = nombreImagenPrivadoPasajero;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public Short getEdadPasajero() {
        return edadPasajero;
    }

    public Boolean getGeneroPasajero() {
        return generoPasajero;
    }

    public String getNombreImagenPublicoPasajero() {
        return nombreImagenPublicoPasajero;
    }

    public String getNombreImagenPrivadoPasajero() {
        return nombreImagenPrivadoPasajero;
    }

    public PasajeroDto() {
    }

    public PasajeroDto(int cedulaPasajero, String nombrePasajero, Short edadPasajero, Boolean generoPasajero, String nombreImagenPublicoPasajero, String nombreImagenPrivadoPasajero) {
        this.idPasajero = cedulaPasajero;
        this.nombrePasajero = nombrePasajero;
        this.edadPasajero = edadPasajero;
        this.generoPasajero = generoPasajero;
        this.nombreImagenPublicoPasajero = nombreImagenPublicoPasajero;
        this.nombreImagenPrivadoPasajero = nombreImagenPrivadoPasajero;
    }

    @Override 
    public String toString() {
        if (idPasajero == 0) {
            return "Seleccione el Pasajero";
        }
        return "Nombre=" + nombrePasajero + "\nCedula=" +idPasajero;
    }
}
