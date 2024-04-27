package aed;

public class Fecha {
    private int dia;
    private int mes;
    //constructor
    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    public String toString() {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(dia + "/" + mes);
        return sBuffer.toString();
    }

    @Override
    public boolean equals(Object otra) {
        boolean oen = (otra == null);
        boolean cd = otra.getClass() != this.getClass();
        if (oen || cd ) {
            return false;
        }
        Fecha otraFecha = (Fecha) otra;

        return dia == otraFecha.dia
        && mes == otraFecha.mes;
    }

    public void incrementarDia() {
        if (dia < diasEnMes(mes)) {
            dia ++;
        }
        else {
            dia =1;
            if (mes < 12){
            mes ++;
        }
        else {
            mes = 1;
        }        
        }
        
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
