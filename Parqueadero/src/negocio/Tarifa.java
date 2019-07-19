package negocio;
import javax.swing.JOptionPane;
import negocio.Vehiculo;
import negocio.Parqueadero;

public class Tarifa {
    private int K_IdT;
    private double valor;
    private int cmpm=105;
    Parqueadero p= new Parqueadero();
    Vehiculo v=new Vehiculo();
    private double tarifa (){
        String N_Zona=p.getN_Zona();
        int N_Tipo=p.getN_Tipo();
        String TipoVeh=v.getTipoVeh();
        double fdz=0,fns=0,ftv=0;
        if (("Usaquén".equals(N_Zona))||
                ("Chapinero".equals(N_Zona))||
                ("Santa Fe".equals(N_Zona))||
                ("Usaquén".equals(N_Zona))||
                ("Suba".equals(N_Zona))||
                ("Barrios Unidos".equals(N_Zona))||
                ("Teusaquillo".equals(N_Zona))||
                ("Los Mártires".equals(N_Zona))||
                ("Antonio Nariño".equals(N_Zona))||
                ("Candelaria".equals(N_Zona))
                ){
            fdz=1;           
        }else if (("San Cristóbal".equals(N_Zona))||
                ("Usme".equals(N_Zona))||
                ("Tunjuelito".equals(N_Zona))||
                ("Bosa".equals(N_Zona))||
                ("Kennedy".equals(N_Zona))||
                ("Fontibón".equals(N_Zona))||
                ("Engativá".equals(N_Zona))||
                ("Puente Aranda".equals(N_Zona))||
                ("Rafael Uribe Uribe".equals(N_Zona))||
                ("Ciudad Bolivar".equals(N_Zona))||
                ("Sumapaz".equals(N_Zona))
                ){
            fdz=0.8;
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, revise lo que ingresa. Cheque la gramática.");
        }
        switch (N_Tipo){
            case 1:
                fns=1;
            break;
            case 2:
                fns=0.9;
            break;
            case 3:
                fns=0.8;
            break;
            case 4:
                fns=0.7;
            break;
            case 5:
                fns=0.6;
            break;
            case 6:
                fns=0.5;
            break;
        }
        if("Automovil".equals(TipoVeh)){
            ftv=1;
        }else if ("Moto".equals(TipoVeh)){
            ftv=0.7;
        }
        valor=ftv*fns*fdz*cmpm;
        return valor;
    }

    public int getK_IdT() {
        return K_IdT;
    }

    public void setK_IdT(int K_IdT) {
        this.K_IdT = K_IdT;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
