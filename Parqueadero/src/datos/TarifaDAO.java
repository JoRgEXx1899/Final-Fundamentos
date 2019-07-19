package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Tarifa;


import util.CaException;
import util.ServiceLocator;

public class TarifaDAO {
    private Tarifa tarifa;

    public TarifaDAO() {
        tarifa = new Tarifa();
    }
    
    /**
     * Incluye una nueva fila en la tabla Tarifa.
     *
     * @throws CaException
     */
    public void incluirTarifa() throws CaException {
        try {

            String strSQL = "INSERT INTO Tarifa (K_IdT, valor) VALUES(?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, tarifa.getK_IdT());
            prepStmt.setDouble(2, tarifa.getValor());
                        
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("TarifaDAO", "No pudo crear el Tarifa" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarTarifa() throws CaException{
        try {

            String strSQL = "UPDATE Tarifa SET valor=? WHERE k_IdT=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setDouble(1,tarifa.getValor());
            prepStmt.setInt(2,tarifa.getK_IdT());
            
       
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("TarifaDAO", "No se pudo actualizar la Tarifa" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarTarifa() throws CaException{
        try {

            String strSQL = "DELETE FROM Tarifa WHERE k_IdT=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, tarifa.getK_IdT());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("TarifaDAO", "No se pudo eliminar el Tarifa" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarTarifa() throws CaException {
        try {
            String strSQL = "SELECT K_IdT,valor FROM Tarifa WHERE K_IdT = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, tarifa.getK_IdT());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                tarifa.setK_IdT(rs.getInt(1));
                tarifa.setValor(rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new CaException("TarifaDAO", "No pudo recuperar el Tarifa " + e.getMessage());
        }

    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
    
}
