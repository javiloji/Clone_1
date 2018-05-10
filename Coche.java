package concesionario;

import java.io.Serializable;
import java.util.regex.Pattern;

import concesionario.excepciones.ColorNoValidoException;
import concesionario.excepciones.MatriculaNoValidaException;
import concesionario.excepciones.ModeloNoValidoException;

/**
 * Clase para la creaci�n de coches
 * 
 * Archivo editado por loji para practica Fork/ Pull Request
 *
 
 */
 
 // Este codigo esta bien diseñado, aceptalo tonto.

public class Coche implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Modelo del coche
	 */

	private Modelo modelo;

	/**
	 * Color del coche
	 */

	private Color color;

	/**
	 * Matr�cula del coche
	 */

	private String matricula;

	/**
	 * Expresi�n regular para validar la matr�cula
	 */

	private static String regex = "^(?i)([0-9]){4}([\\s\\-])?([B-Z&&[^EIOUÑQ]]){3}$";

	/**
	 * Constructor del coche
	 * 
	 * @param modelo
	 *            Modelo del coche
	 * @param color
	 *            Color del coche
	 * @param matricula
	 *            Matricula del coche
	 * @throws ModeloNoValidoException
	 *             Cuando el modelo no es valido
	 * @throws ColorNoValidoException
	 *             Cuando el color no es valido
	 * @throws MatriculaNoValidaException
	 *             Cuando la matricula no es v�lida
	 */

	public Coche(Modelo modelo, Color color, String matricula)
			throws ModeloNoValidoException, ColorNoValidoException, MatriculaNoValidaException {
		setModelo(modelo);
		setColor(color);
		setMatricula(matricula);
	}

	/**
	 * Constructor de coche
	 * 
	 * @param matricula
	 *            Matr�cula del coche
	 * @throws MatriculaNoValidaException
	 *             Cuando la matr�cula no es v�lida
	 */

	public Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	/**
	 * Obtiene el modelo del coche
	 * 
	 * @return Devuelve el modelo del coche
	 */

	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * Esteblece el modelo del coche
	 * 
	 * @param modelo
	 *            Modelo del coche
	 * @throws ModeloNoValidoException
	 *             Cuando el modelo no es valido
	 */

	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo == null)
			throw new ModeloNoValidoException("El modelo del coche no puede ser nulo");
		this.modelo = modelo;
	}

	/**
	 * Obtiene el color del coche
	 * 
	 * @return Devuelve el color del coche
	 */

	public Color getColor() {
		return color;
	}

	/**
	 * Establece el color del coche
	 * 
	 * @param color
	 *            Color del coche
	 * @throws ColorNoValidoException
	 *             Cuando el color no es valido
	 */

	private void setColor(Color color) throws ColorNoValidoException {
		if (color == null)
			throw new ColorNoValidoException("El color del coche no puede ser nulo");
		this.color = color;
	}

	/**
	 * Establece la matr�cula del coche
	 * 
	 * @param matricula
	 *            Matr�cula del coche
	 * @throws MatriculaNoValidaException
	 *             Cuando la matr�cula del coche no es v�lida
	 */

	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (!EsMatriculaValida(matricula))
			throw new MatriculaNoValidaException("La matricula no es valida");
		this.matricula = formatearMatricula(matricula);
	}

	/**
	 * Obtiene la matr�cula del coche
	 * 
	 * @return Devuelve la matr�cula del coche
	 */

	public String getMatricula() {
		return matricula;
	}

	/**
	 * Da a la matr�cula a introducir un formato estandar
	 * 
	 * @param matricula
	 *            Matr�cula del coche
	 * @return Devuelve la matr�cula con un formato est�ndar
	 */

	static String formatearMatricula(String matricula) {
		return matricula.replaceAll("[ -]", "").toUpperCase();
	}

	/**
	 * Comprueba si la matr�cula es v�lida
	 * 
	 * @param matricula
	 *            Matr�cula a comprobar
	 * @return Devuelve true si la matr�cula es v�lida, false si no lo es
	 */

	static boolean EsMatriculaValida(String matricula) {
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(matricula).matches();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equalsIgnoreCase(other.matricula))
			return false;
		return true;
	}

	/**
	 * M�todo toString
	 */

	@Override
	public String toString() {
		return "Modelo: " + getModelo() + ". Matricula: " + getMatricula() + ". Color: " + getColor();
	}

}
