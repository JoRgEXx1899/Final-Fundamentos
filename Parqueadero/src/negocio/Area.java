package negocio;

public class Area {
    private int K_IdA;
    private int cupo;
    private String N_Tipo;
    private int K_IdE;

    public void ocuparCupo(){
        cupo=cupo-1;
    }
    public void liberarCupo(){
        cupo=cupo+1;
    }
    public int getK_IdA() {
        return K_IdA;
    }

    public void setK_IdA(int K_IdA) {
        this.K_IdA = K_IdA;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getN_Tipo() {
        return N_Tipo;
    }

    public void setN_Tipo(String N_Tipo) {
        this.N_Tipo = N_Tipo;
    }

    public int getK_IdE() {
        return K_IdE;
    }

    public void setK_IdE(int K_IdE) {
        this.K_IdE = K_IdE;
    }
    
}
