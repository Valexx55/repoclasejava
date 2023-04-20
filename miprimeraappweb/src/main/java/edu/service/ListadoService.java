package edu.service;

import java.nio.file.Path;
import java.util.List;

import edu.servlet.Dni;

public interface ListadoService {
	
	List<Dni> obtenerListaDnis (Path path);

}
