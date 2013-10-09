package utilidades;
import java.util.*;
public class leer {

	private static final Scanner teclado = new Scanner(System.in);

	/**
	 * Define el teclado como estático para que no haya que crear ningún objeto
	 * de la clase leer y así poder utilizar sus métodos
	 */

	public static int entero() throws Exception {
		return entero("");
	}

	public static int entero(String s) throws Exception {
		int res = 0;
		boolean vale = true;
		do {
			vale = true;
			System.out.println(s);
			try {
				res = teclado.nextInt();
			} catch (Exception e) {
				vale = false;
				teclado.next();
			}
		} while (!vale);
		teclado.nextLine();
		return res;
	}

	public static int entero(String s, int min, int max) throws Exception {
		int res = min - 1;
		while (res < min || res > max)
			res = entero(s + "[" + min + "," + max + "]");
		return res;
	}

	public static double real() throws Exception {
		return real("");
	}

	public static double real(String s) throws Exception {
		double res = 0;
		boolean vale = true;
		do {
			vale = true;
			System.out.println(s);
			try {
				res = teclado.nextDouble();
			} catch (Exception e) {
				vale = false;
				teclado.next();
			}
		} while (!vale);
		teclado.nextLine();
		return res;
	}

	public static double real(String s, int min, int max) throws Exception {
		double res = min - 1;
		while (res < min || res > max)
			res = real(s + "[" + min + "," + max + "]");
		return res;
	}

	public static float realLargo() throws Exception {
		return realLargo("");
	}

	public static float realLargo(String s) throws Exception {
		float res = 0;
		boolean vale = true;
		do {
			vale = true;
			System.out.println(s);
			try {
				res = teclado.nextFloat();
			} catch (Exception e) {
				vale = false;
				teclado.next();
			}
		} while (!vale);
		teclado.nextLine();
		return res;
	}

	public static float realLargo(String s, int min, int max) throws Exception {
		float res = min - 1;
		while (res < min || res > max)
			res = realLargo(s + "[" + min + "," + max + "]");
		return res;
	}

	public static String cadena() throws Exception {
		return cadena("");
	}

	public static String cadena(String s) throws Exception {
		String res = "";
		boolean vale = true;
		do {
			vale = true;
			System.out.println(s);
			try {
				res = teclado.nextLine();
			} catch (Exception e) {
				vale = false;
				teclado.next();
			}
		} while (!vale);
		teclado.nextLine();
		return res;
	}

	public static char caracter() throws Exception {
		return caracter("");

	}

	public static char caracter(String s) throws Exception {
		char res = ' ';
		boolean vale = true;
		do {
			vale = true;
			System.out.println(s);
			try {
				res = teclado.next().charAt(0);
			} catch (Exception e) {
				vale = false;
				teclado.next();
			}
		} while (!vale);
		teclado.nextLine();
		return res;
	}

	public static char caracter(String s, char min, char max) throws Exception {
		char res = ' ';
		while (res != min && res != max)
			res = caracter(s + "[" + min + "," + max + "]");
		return res;
	}
	public static String fecha(){ // M�todo que devuelve la fecha ya en formato para MySQL
		java.util.Date utilDate = new java.util.Date(); //fecha actual
		long lnMilisegundos = utilDate.getTime();
		java.sql.Date date = new java.sql.Date(lnMilisegundos);
		String sqlDate = date+""; 
		
		return sqlDate; 
	}

}
