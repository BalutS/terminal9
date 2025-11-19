package org.unimag.servicio;

import com.poo.persistence.NioFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.unimag.api.ApiOperacionBD;
import org.unimag.dto.BusDto;
import org.unimag.dto.EmpresaDto;
import org.unimag.modelo.Bus;
import org.unimag.modelo.Empresa;
import org.unimag.recurso.constante.Persistencia;
import org.unimag.recurso.utilidad.GestorImagen;

public class BusServicio implements ApiOperacionBD<BusDto, Integer> {

    private NioFile miArchivo;
    private String nombrePersistencia;

    public BusServicio() {
        nombrePersistencia = Persistencia.NOMBRE_BUS;
        try {
            miArchivo = new NioFile(nombrePersistencia);
        } catch (IOException ex) {
            Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSerial() {
        int id = 0;
        try {
            id = miArchivo.ultimoCodigo() + 1;
        } catch (IOException ex) {
            Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public BusDto inserInto(BusDto dto, String ruta) {
        Empresa objEmpresa = new Empresa(dto.getEmpresaBus().getIdEmpresa(),
                dto.getEmpresaBus().getNombreEmpresa(),
                "", ""
        );

        Bus objBus = new Bus();
        objBus.setIdBus(getSerial());
        objBus.setModeloBus(dto.getModeloBus());
        objBus.setEmpresaBus(objEmpresa);
        objBus.setNombreImagenPublicoBus(dto.getNombreImagenPublicoBus());
        objBus.setNombreImagenPrivadoBus(GestorImagen.grabarLaImagen(ruta));

        String filaGrabar = objBus.getIdBus() + Persistencia.SEPARADOR_COLUMNAS
                + objBus.getModeloBus() + Persistencia.SEPARADOR_COLUMNAS
                + objBus.getEmpresaBus().getIdEmpresa() + Persistencia.SEPARADOR_COLUMNAS
                + objBus.getNombreImagenPublicoBus() + Persistencia.SEPARADOR_COLUMNAS
                + objBus.getNombreImagenPrivadoBus();

        if (miArchivo.agregarRegistro(filaGrabar)) {
            dto.setIdBus(objBus.getIdBus());
            return dto;
        }

        return null;
    }

    //SE CAMBIARON LOS DOS METODOS PARA QUE NO TUVIERAN MAS CICLOS DENTRO DE CICLOS SINO Q USE MAP
    
    @Override
    public List<BusDto> selectFrom() {
    EmpresaServicio empresaServicio = new EmpresaServicio();
    List<EmpresaDto> arrEmpresas = empresaServicio.selectFrom();

    // **********************************************
    // Crear un MAP para evitar búsquedas en listas
    // **********************************************
        Map<Integer, EmpresaDto> mapEmpresas = new HashMap<>();
    for (EmpresaDto empresa : arrEmpresas) {
        mapEmpresas.put(empresa.getIdEmpresa(), empresa);
    }
    // **********************************************

    List<BusDto> arregloBusDtos = new ArrayList<>();
    List<String> arregloDatos = miArchivo.obtenerDatos();

    for (String cadena : arregloDatos) {
        try {
            cadena = cadena.replace("@", "");
            String[] columnas = cadena.split(Persistencia.SEPARADOR_COLUMNAS);

            int idBus = Integer.parseInt(columnas[0].trim());
            String modeloBus = columnas[1].trim();
            int idEmpBus = Integer.parseInt(columnas[2].trim());
            String imgPublica = columnas[3].trim();
            String imgPrivada = columnas[4].trim();

            // Obtener empresa directamente desde el MAP
            EmpresaDto empresaBus = mapEmpresas.getOrDefault(idEmpBus, null);

            BusDto objBusDto = new BusDto();
            objBusDto.setIdBus(idBus);
            objBusDto.setModeloBus(modeloBus);
            objBusDto.setEmpresaBus(empresaBus);
            objBusDto.setNombreImagenPublicoBus(imgPublica);
            objBusDto.setNombreImagenPrivadoBus(imgPrivada);

            arregloBusDtos.add(objBusDto);

        } catch (NumberFormatException error) {
            Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, error);
        }
    }
    return arregloBusDtos;
}


    @Override
    public int numRows() {
        int cantidad = 0;
        try {
            cantidad = miArchivo.cantidadFilas();
        } catch (IOException ex) {
            Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    @Override
    public Boolean deleteFrom(Integer codigo) {
        Boolean correcto = false;
        try {
            List<String> arreglo;

            arreglo = miArchivo.borrarFilaPosicion(codigo);
            if (!arreglo.isEmpty()) {
                correcto = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(BusServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    @Override
    public BusDto getOne(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BusDto updateSet(Integer codigo, BusDto objeto, String ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
