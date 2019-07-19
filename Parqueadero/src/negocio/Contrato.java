package negocio;

public class Contrato {
    private int K_NumCont;
    private String TipoV;
    private String F_Inicio;
    private String F_Final;
    private int valor;

    public int getK_NumCont() {
        return K_NumCont;
    }

    public void setK_NumCont(int K_NumCont) {
        this.K_NumCont = K_NumCont;
    }

    public String getTipoV() {
        return TipoV;
    }

    public void setTipoV(String TipoV) {
        this.TipoV = TipoV;
    }

    public String getF_Inicio() {
        return F_Inicio;
    }

    public void setF_Inicio(String F_Inicio) {
        this.F_Inicio = F_Inicio;
    }

    public String getF_Final() {
        return F_Final;
    }

    public void setF_Final(String F_Final) {
        this.F_Final = F_Final;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
