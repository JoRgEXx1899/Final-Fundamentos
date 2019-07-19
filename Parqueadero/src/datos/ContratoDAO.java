package datos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Contrato;


import util.CaException;
import util.ServiceLocator;
public class ContratoDAO {
    private Contrato contrato;

    public ContratoDAO() {
        contrato=new Contrato();
    }
    /**
     * Incluye una nueva fila en la tabla Contrato.
     *
     * @throws CaException
     */
    public void incluirContrato() throws CaException {
        try {

            String strSQL = "INSERT INTO Contrato (K_NumCont, TipoV, F_Inicio, F_Final,Valor) VALUES(?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, contrato.getK_NumCont());
            prepStmt.setString(2, contrato.getTipoV());
            prepStmt.setString(3, contrato.getF_Inicio());
            prepStmt.setString(4, contrato.getF_Final());
            prepStmt.setInt(5, contrato.getValor());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ContratoDAO", "No pudo crear el contrato" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarContrato() throws CaException{
        try {

            String strSQL = "UPDATE Contrato SET TipoV=?, F_Inicio=?, F_Final=?, Valor=? WHERE k_NumCont=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setString(1,contrato.getTipoV());
            prepStmt.setString(2,contrato.getF_Inicio());
            prepStmt.setString(3,contrato.getF_Final());
            prepStmt.setInt(4, contrato.getValor());
            prepStmt.setLong(5, contrato.getK_NumCont());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ContratoDAO", "No se pudo actualizar el Contrato" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarContrato() throws CaException{
        try {

            String strSQL = "DELETE FROM Contrato WHERE k_NumCont=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, contrato.getK_NumCont());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ContratoDAO", "No se pudo eliminar el contrato" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarContrato() throws CaException {
        try {
            String strSQL = "SELECT K_Cc,N_Nombre,K_Telefono,Correo,K_NumCont FROM Contrato WHERE K_NumCont = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, contrato.getK_NumCont());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                contrato.setK_NumCont(rs.getInt(1));
                contrato.setTipoV(rs.getString(2));
                contrato.setF_Inicio(rs.getString(3));
                contrato.setF_Final(rs.getString(4));
                contrato.setValor(rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new CaException("ContratoDAO", "No pudo recuperar el contrato " + e.getMessage());
        }

    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
}
