package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;  // si es de otra clase es tipo clase
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);  // como fecha es un objeto mutable tenemos que crear uno nuevo
        this.horario = horario;
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        return new Fecha(fecha);  // objeto mutable
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(mensaje + " " + "@" + " " + fecha + " " + horario);
        return sBuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen = (otro == null);
        boolean cd = otro.getClass() != this.getClass();
        if (oen || cd ) {
            return false;
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro;

        return mensaje == otroRecordatorio.mensaje
        && fecha.equals(otroRecordatorio.fecha)
        && horario.equals(otroRecordatorio.horario);
    }

}
