package modelo;


import modelo.entidades.Ciclo;

import vista.presentacion.CicloVO;

public class MapeadorCicloVO {
	public Ciclo mapearCicloVOCiclo (CicloVO cicloVO) {
		
		Ciclo ciclo = new Ciclo();
		ciclo.setId(cicloVO.getId());
		ciclo.setNombre(cicloVO.getNombre());
		ciclo.setGrado(cicloVO.getGrado());
		return ciclo;
	}

	public CicloVO mapearCicloCicloVO (Ciclo ciclo) {
	
		CicloVO cicloVO = new CicloVO();
		cicloVO.setId(ciclo.getId());
		cicloVO.setNombre(ciclo.getNombre());
		cicloVO.setGrado(ciclo.getGrado());

		return cicloVO;
}

}
