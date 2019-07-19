package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Espacio;


import util.CaException;
import util.ServiceLocator;

public class EspacioDAO {
    private Espacio espacio;

    public EspacioDAO() {
        espacio = new Espacio();
    }
    /**
     * Incluye una nueva fila en la tabla Espacio.
     *
     * @throws CaException
     */
    public void incluirEspacio() throws CaException {
        try {

            String strSQL = "INSERT INTO Espacio (K_IdE, disponible, K_NumCont,conse_Reg) VALUES(?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, espacio.getK_IdE());
            prepStmt.setInt(2, espacio.getDisponible());
            prepStmt.setInt(3, espacio.getK_NumCont());
            prepStmt.setInt(4, espacio.getConse_Reg());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EspacioDAO", "No pudo crear el espacio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarEspacio() throws CaException{
        try {

            String strSQL = "UPDATE Espacio SET disponible=?,K_NumCont=?,conse_Reg=? WHERE k_IdE=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1,espacio.getDisponible());
            prepStmt.setInt(2,espacio.getK_NumCont());
            prepStmt.setInt(3,espacio.getConse_Reg());
            prepStmt.setInt(4,espacio.getK_IdE());
       
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EspacioDAO", "No se pudo actualizar el espacio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarEspacio() throws CaException{
        try {

            String strSQL = "DELETE FROM Espacio WHERE k_IdE=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, espacio.getK_IdE());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EspacioDAO", "No se pudo eliminar el espacio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarEspacio() throws CaException {
        try {
            String strSQL = "SELECT K_IdE,disponible,K_NumCont,conse_Reg FROM Espacio WHERE K_IdE = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, espacio.getK_IdE());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                espacio.setK_IdE(rs.getInt(1));
                espacio.setDisponible(rs.getInt(2));
                espacio.setK_NumCont(rs.getInt(3));  
                espacio.setConse_Reg(rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new CaException("EspacioDAO", "No pudo recuperar el espacio " + e.getMessage());
        }

    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }
    
}
