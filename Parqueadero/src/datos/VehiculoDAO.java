package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Vehiculo;


import util.CaException;
import util.ServiceLocator;

public class VehiculoDAO {
    private Vehiculo vehiculo;

    public VehiculoDAO() {
        vehiculo = new Vehiculo();
    }
    /**
     * Incluye una nueva fila en la tabla Vehiculo.
     *
     * @throws CaException
     */
    public void incluirVehiculo() throws CaException {
        try {

            String strSQL = "INSERT StringO Vehiculo (K_Placa,N_Marca, N_Modelo,TipoVeh) VALUES(?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, vehiculo.getK_Placa());
            prepStmt.setString(2, vehiculo.getN_Marca());
            prepStmt.setString(3, vehiculo.getN_Modelo());
            prepStmt.setString(4, vehiculo.getTipoVeh());
            
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("VehiculoDAO", "No pudo crear el Vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarVehiculo() throws CaException{
        try {

            String strSQL = "UPDATE Vehiculo SET N_Marca=?,N_Modelo=?,TipoVeh=? WHERE K_Placa=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setString(1,vehiculo.getN_Marca());
            prepStmt.setString(2,vehiculo.getN_Modelo());
            prepStmt.setString(3,vehiculo.getTipoVeh());
            prepStmt.setString(4,vehiculo.getK_Placa());
            
       
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("VehiculoDAO", "No se pudo actualizar el Vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarVehiculo() throws CaException{
        try {

            String strSQL = "DELETE FROM Vehiculo WHERE K_Placa=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, vehiculo.getK_Placa());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("VehiculoDAO", "No se pudo eliminar el Vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarVehiculo() throws CaException {
        try {
            String strSQL = "SELECT K_Placa,N_Marca,N_Modelo,TipoVeh FROM Vehiculo WHERE K_Placa = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, vehiculo.getK_Placa());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                vehiculo.setK_Placa(rs.getString(1));
                vehiculo.setN_Marca(rs.getString(2));
                vehiculo.setN_Modelo(rs.getString(3));  
                vehiculo.setTipoVeh(rs.getString(4));
                
            }
        } catch (SQLException e) {
            throw new CaException("VehiculoDAO", "No pudo recuperar el Vehiculo " + e.getMessage());
        }

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
