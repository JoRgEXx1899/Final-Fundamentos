package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Registro;


import util.CaException;
import util.ServiceLocator;

public class RegistroDAO {
    private Registro registro;

    public RegistroDAO() {
        registro = new Registro();
    }

    /**
     * Incluye una nueva fila en la tabla Registro.
     *
     * @throws CaException
     */
    public void incluirRegistro() throws CaException {
        try {

            String strSQL = "INSERT INTO Registro (K_CONSECUTIVO, F_HEntrada, F_HSalida,Total,K_placa) VALUES(?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, registro.getK_CONSECUTIVO());
            prepStmt.setString(2, registro.getF_HEntrada());
            prepStmt.setString(3, registro.getF_HSalida());
            prepStmt.setInt(4, registro.getTotal());
            prepStmt.setString(5, registro.getK_Placa());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("RegistroDAO", "No pudo crear el Registro" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarRegistro() throws CaException{
        try {

            String strSQL = "UPDATE Registro SET F_HEntrada=?,F_HSalida=?,Total=?,K_Placa=? WHERE k_CONSECUTIVO=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setString(1,registro.getF_HEntrada());
            prepStmt.setString(2,registro.getF_HSalida());
            prepStmt.setInt(3,registro.getTotal());
            prepStmt.setString(4,registro.getK_Placa());
            prepStmt.setInt(5,registro.getK_CONSECUTIVO());
       
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("RegistroDAO", "No se pudo actualizar el Registro" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarRegistro() throws CaException{
        try {

            String strSQL = "DELETE FROM Registro WHERE k_CONSECUTIVO=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, registro.getK_CONSECUTIVO());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("RegistroDAO", "No se pudo eliminar el Registro" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarRegistro() throws CaException {
        try {
            String strSQL = "SELECT K_CONSECUTIVO,F_HEntrada,F_HSalida,Total,K_Placa FROM Registro WHERE K_CONSECUTIVO = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, registro.getK_CONSECUTIVO());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                registro.setK_CONSECUTIVO(rs.getInt(1));
                registro.setF_HEntrada(rs.getString(2));
                registro.setF_HSalida(rs.getString(3));  
                registro.setTotal(rs.getInt(4));
                registro.setK_Placa(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new CaException("RegistroDAO", "No pudo recuperar el Registro " + e.getMessage());
        }

    }
    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
    
    
}
