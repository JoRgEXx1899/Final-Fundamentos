package datos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Cliente;


import util.CaException;
import util.ServiceLocator;
public class ClienteDAO {
    private Cliente cliente;

    public ClienteDAO() {
        cliente= new Cliente();
    }
    /**
     * Incluye una nueva fila en la tabla Cliente.
     *
     * @throws CaException
     */
    public void incluirCliente() throws CaException {
        try {

            String strSQL = "INSERT INTO Cliente (K_Cc, N_Nombre, K_Telefono, Correo,K_NumCont) VALUES(?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, cliente.getK_Cc());
            prepStmt.setString(2, cliente.getN_Nombre());
            prepStmt.setString(3, cliente.getK_Telefono());
            prepStmt.setString(4, cliente.getCorreo());
            prepStmt.setInt(5, cliente.getK_NumCont());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No pudo crear el cliente" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarCliente() throws CaException{
        try {

            String strSQL = "UPDATE Cliente SET N_Nombre=?, K_Telefono=?, Correo=?, K_NumCont=? WHERE k_Cc=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setString(1,cliente.getN_Nombre());
            prepStmt.setString(2,cliente.getK_Telefono());
            prepStmt.setString(3,cliente.getCorreo());
            prepStmt.setInt(4, cliente.getK_NumCont());
            prepStmt.setLong(5, cliente.getK_Cc());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo actualizar el Cliente" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarCliente() throws CaException{
        try {

            String strSQL = "DELETE FROM Cliente WHERE k_Cc=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, cliente.getK_Cc());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No se pudo eliminar el cliente" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarCliente() throws CaException {
        try {
            String strSQL = "SELECT K_Cc,N_Nombre,K_Telefono,Correo,K_NumCont FROM Cliente WHERE K_Cc = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, cliente.getK_Cc());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                cliente.setK_Cc(rs.getInt(1));
                cliente.setN_Nombre(rs.getString(2));
                cliente.setK_Telefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setK_NumCont(rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "No pudo recuperar el cliente " + e.getMessage());
        }

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
