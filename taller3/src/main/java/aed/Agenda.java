package aed;

public class Agenda {
    private Fecha fechaActual;
    private SecuanciaDeRecordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual);
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {
        String mensaje = this.fechaActual.toString() + "\n=====" + "\n";
        for (int i = 0; i < this.recordatorios.longitud(); i++) {
            Recordatorio recordatorio = recordatorios.obtener(i);
            if(recordatorio.fecha().equals(this.fechaActual)){
                mensaje += recordatorio.toString() + "\n";
            }
        }
        return mensaje;

    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();

    }

    public Fecha fechaActual() {
        retrun new Fecha(this.fechaActual);
    }

}
