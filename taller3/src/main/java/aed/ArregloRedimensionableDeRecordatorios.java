package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private Recordatorio[] arreglo;
    private int longitud;
    public ArregloRedimensionableDeRecordatorios() {
        longitud = 0;
        arreglo = new Recordatorio[]{};
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAtras(Recordatorio i) {
        if (arreglo.length != longitud) {
            arreglo[longitud] = i;
            longitud ++;
        }
        else {
            Recordatorio[] arreglo_nuevo = new Recordatorio[longitud + 1];
            for(int j = 0; j < arreglo.length; j++) {
                arreglo_nuevo[j] = arreglo[j];

            }
            arreglo_nuevo[longitud] = i;
            longitud ++;
            arreglo = arreglo_nuevo;
        }
    }

    public Recordatorio obtener(int i) {
        return arreglo[i];
    }

    public void quitarAtras() {
        arreglo[longitud] = null;
        longitud --;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        arreglo[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}
