package negocio;

import java.util.Date;

public class Registro {
    private int K_CONSECUTIVO;
    private String F_HEntrada;
    java.util.Date fechaActual= new java.util.Date();
    private String F_HSalida;
    private int Total;
    private String K_placa;

    public int getK_CONSECUTIVO() {
        return K_CONSECUTIVO;
    }

    public void setK_CONSECUTIVO(int K_CONSECUTIVO) {
        this.K_CONSECUTIVO = K_CONSECUTIVO;
    }

    public String getF_HEntrada() {
        return F_HEntrada;
    }

    public void setF_HEntrada(String F_HEntrada) {
        this.F_HEntrada = F_HEntrada;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getF_HSalida() {
        return F_HSalida;
    }

    public void setF_HSalida(String F_HSalida) {
        this.F_HSalida = F_HSalida;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public String getK_Placa() {
        return K_placa;
    }

    public void setK_Placa(String K_placa) {
        this.K_placa = K_placa;
    }
}
