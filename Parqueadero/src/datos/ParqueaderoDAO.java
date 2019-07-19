package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Parqueadero;


import util.CaException;
import util.ServiceLocator;

public class ParqueaderoDAO {
    private Parqueadero pq;

    public ParqueaderoDAO() {
        pq=new Parqueadero();
    }
    /**
     * Incluye una nueva fila en la tabla Parqueadero.
     *
     * @throws CaException
     */
    public void incluirParqueadero() throws CaException {
        try {

            String strSQL = "INSERT INTO Parqueadero (K_Id, N_Zona, N_Tipo,K_IdA,K_IdT) VALUES(?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, pq.getK_Id());
            prepStmt.setString(2, pq.getN_Zona());
            prepStmt.setInt(3, pq.getN_Tipo());
            prepStmt.setInt(4, pq.getK_IdA());
            prepStmt.setInt(5, pq.getK_IdT());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No pudo crear el Parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarParqueadero() throws CaException{
        try {

            String strSQL = "UPDATE Parqueadero SET N_Zona=?,N_tipo=?,K_IdA=?,K_IdT=? WHERE k_Id=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setString(1,pq.getN_Zona());
            prepStmt.setInt(2,pq.getN_Tipo());
            prepStmt.setInt(3,pq.getK_IdA());
            prepStmt.setInt(4,pq.getK_IdT());
            prepStmt.setInt(5, pq.getK_Id());
       
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se pudo actualizar el Parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarParqueadero() throws CaException{
        try {

            String strSQL = "DELETE FROM Parqueadero WHERE k_Id=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, pq.getK_Id());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se pudo eliminar el Parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarParqueadero() throws CaException {
        try {
            String strSQL = "SELECT K_Id,N_Zona,N_Tipo,K_IdA,K_IdT FROM Parqueadero WHERE K_Id = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, pq.getK_Id());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                pq.setK_Id(rs.getInt(1));
                pq.setN_Zona(rs.getString(2));
                pq.setN_Tipo(rs.getInt(3));  
                pq.setK_IdA(rs.getInt(4));
                pq.setK_IdT(rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No pudo recuperar el Parqueadero " + e.getMessage());
        }

    }

    public Parqueadero getPq() {
        return pq;
    }

    public void setPq(Parqueadero pq) {
        this.pq = pq;
    }
    
}
