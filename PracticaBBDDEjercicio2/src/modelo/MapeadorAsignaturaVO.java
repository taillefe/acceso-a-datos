package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.entidades.*;
import vista.presentacion.*;

public class MapeadorAsignaturaVO{
	
	public Asignatura mapearAsignaturaVOAsignatura (AsignaturaVO asigVO) {
		
		Asignatura asig = new Asignatura();
		asig.setId(asigVO.getId());
		asig.setNombre(asigVO.getNombre());
		asig.setHorasSemanales(asigVO.getHorasSemanales());
		asig.setIdCiclo(asigVO.getIdCiclo());
		
		return asig;
	}
	
	public AsignaturaVO mapearAsignaturaAsignaturaVO (Asignatura asig) {
		
		AsignaturaVO asigVO = new AsignaturaVO();
		asigVO.setId(asig.getId());
		asigVO.setNombre(asig.getNombre());
		asigVO.setHorasSemanales(asig.getHorasSemanales());
		asigVO.setIdCiclo(asig.getIdCiclo());
		
		return asigVO;
	}
}