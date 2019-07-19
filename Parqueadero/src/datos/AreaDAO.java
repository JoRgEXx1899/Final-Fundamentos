package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Area;


import util.CaException;
import util.ServiceLocator;

public class AreaDAO {
    private Area area;

    public AreaDAO() {
        area=new Area();
    }
    
    /**
     * Incluye una nueva fila en la tabla Area.
     *
     * @throws CaException
     */
    public void incluirArea() throws CaException {
        try {

            String strSQL = "INSERT INTO Area (K_IdA, Cupo, N_Tipo, K_IdE) VALUES(?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, area.getK_IdA());
            prepStmt.setInt(2, area.getCupo());
            prepStmt.setString(3, area.getN_Tipo());
            prepStmt.setInt(4, area.getK_IdE());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("AreaDAO", "No pudo crear el area" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarArea() throws CaException{
        try {

            String strSQL = "UPDATE Area SET cupo=?, N_Tipo=?, K_IdE=? WHERE k_IdA=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1,area.getCupo());
            prepStmt.setString(2, area.getN_Tipo());
            prepStmt.setInt(3, area.getK_IdE());
            prepStmt.setLong(4, area.getK_IdA());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("AreaDAO", "No se pudo actualizar el area" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarArea() throws CaException{
        try {

            String strSQL = "DELETE FROM Area WHERE k_IdA=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, area.getK_IdA());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("AreaDAO", "No se pudo eliminar el area" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarArea() throws CaException {
        try {
            String strSQL = "SELECT K_IdA,cupo,N_Tipo,K_IdE FROM Area WHERE k_IdA = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, area.getK_IdA());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                area.setK_IdA(rs.getInt(1));
                area.setCupo(rs.getInt(2));
                area.setN_Tipo(rs.getString(3));
                area.setK_IdE(rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new CaException("AreaDAO", "No pudo recuperar el area " + e.getMessage());
        }

    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
}
