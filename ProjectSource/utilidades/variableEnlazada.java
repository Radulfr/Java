package utilidades;
 
public class variableEnlazada<X> {
	private X valor;
	private variableEnlazada<X> enlace;

	public variableEnlazada(X nuevo) {
		valor = nuevo;
		enlace = null;
	}

	public variableEnlazada(X nuevo, variableEnlazada<X> nuevav) {
		valor = nuevo;
		enlace = nuevav;
	}

	public variableEnlazada() {
		valor = null;
		enlace = null;
	}

	public void setValor(X nuevo) {
		valor = nuevo;
	}

	public void setEnlace(variableEnlazada<X> v) {
		enlace = v;
	}

	public X getValor() {
		return valor;
	}

	public variableEnlazada<X> getEnlace() {
		return enlace;
	}

	@Override
	public String toString() {
		return valor.toString();
	}

	@Override
	public boolean equals(Object Ve) {
		boolean iguales = Ve instanceof variableEnlazada;
		if (iguales && this != Ve) {
			@SuppressWarnings("unchecked")
			variableEnlazada<X> ve = (variableEnlazada<X>) Ve;
			if ((valor == null && ve.valor != null)
					|| (valor != null && ve.valor == null))
				iguales = false;
			else
				iguales = (valor == null && ve.valor == null)
						|| getValor().equals(ve.getValor());
		}
		return iguales;
	}
}
