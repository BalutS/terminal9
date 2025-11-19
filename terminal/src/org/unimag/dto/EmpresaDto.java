package org.unimag.dto;

public class EmpresaDto {
    
    private int idEmpresa;
    private String nombreEmpresa;
    private String nombreImagenPublicoEmpresa;
    private String nombreImagenPrivadoEmpresa;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombreImagenPublicoEmpresa() {
        return nombreImagenPublicoEmpresa;
    }

    public String getNombreImagenPrivadoEmpresa() {
        return nombreImagenPrivadoEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setNombreImagenPublicoEmpresa(String nombreImagenPublicoEmpresa) {
        this.nombreImagenPublicoEmpresa = nombreImagenPublicoEmpresa;
    }

    public void setNombreImagenPrivadoEmpresa(String nombreImagenPrivadoEmpresa) {
        this.nombreImagenPrivadoEmpresa = nombreImagenPrivadoEmpresa;
    }

    public EmpresaDto() {
    }

    public EmpresaDto(int idEmpresa, String nombreEmpresa, String nombreImagenPublicoEmpresa, String nombreImagenPrivadoEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreImagenPublicoEmpresa = nombreImagenPublicoEmpresa;
        this.nombreImagenPrivadoEmpresa = nombreImagenPrivadoEmpresa;
    }
    

    @Override
    public String toString() {
        return "" + nombreEmpresa;
    }
    
    
    
}
