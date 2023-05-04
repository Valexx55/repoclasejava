package imcweb.service;

import java.util.List;

import imcweb.model.RegistroIMC;
import imcweb.repository.RepositorioIMC;

public class IMCWebServiceImpl implements IMCWebService {

	@Override
	public List<RegistroIMC> conusltarRegistrosIMCPorRangoPeso(float pesomin, float pesomax) throws Exception {
		List<RegistroIMC> lista_dev = null;
			
			RepositorioIMC repositorioIMC = new RepositorioIMC();
			lista_dev =  repositorioIMC.leerRegistrosPorRangoPeso(pesomin, pesomax);
			
		return lista_dev;
	}
	
}
