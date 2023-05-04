package imcweb.service;

import java.util.List;

import imcweb.model.RegistroIMC;

/**
 * AQUÍ, DEFINOMOS LOS MÉTODOS QUE REFLEJAN LA FUNCIONALIDAD DE MI APP WEB
 * QUÉ MI HACE MI APP
 * 
 * @author valer
 *
 */
public interface IMCWebService {
	
	//QUÉ NOMBRE
	//QUÉ DATOS RECIBO INPUT
	//QUÉ DEVUELVO
	
	List<RegistroIMC> conusltarRegistrosIMCPorRangoPeso (float pesomin, float pesomax) throws Exception;

}
