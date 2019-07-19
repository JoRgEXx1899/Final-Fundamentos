package negocio;

public class Cliente {
    private int K_Cc;
    private String N_Nombre;
    private String K_Telefono;
    private String correo;
    private int K_NumCont;

    public int getK_Cc() {
        return K_Cc;
    }

    public void setK_Cc(int K_Cc) {
        this.K_Cc = K_Cc;
    }

    public String getN_Nombre() {
        return N_Nombre;
    }

    public void setN_Nombre(String N_Nombre) {
        this.N_Nombre = N_Nombre;
    }

    public String getK_Telefono() {
        return K_Telefono;
    }

    public void setK_Telefono(String K_Telefono) {
        this.K_Telefono = K_Telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getK_NumCont() {
        return K_NumCont;
    }

    public void setK_NumCont(int K_NumCont) {
        this.K_NumCont = K_NumCont;
    }
    
}
