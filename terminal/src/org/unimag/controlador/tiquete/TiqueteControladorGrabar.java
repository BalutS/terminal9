package org.unimag.controlador.tiquete;

import org.unimag.dto.TiqueteDto;
import org.unimag.servicio.TiqueteServicio;


public class TiqueteControladorGrabar {
    public static Boolean crearTiquete(TiqueteDto dto,String rutaDeLaImagen) {

            Boolean correcto = false;
            TiqueteServicio tiqueteServicio = new TiqueteServicio();
            TiqueteDto dtoRespuesta;
            dtoRespuesta = tiqueteServicio.inserInto(dto, rutaDeLaImagen);

            if (dtoRespuesta != null) {
                correcto = true;
            }

            return correcto;
    }
}
