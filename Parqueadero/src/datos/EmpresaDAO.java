package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Empresa;


import util.CaException;
import util.ServiceLocator;

public class EmpresaDAO {
    private Empresa empresa;

    public EmpresaDAO() {
        empresa = new Empresa();
    }
    /**
     * Incluye una nueva fila en la tabla Empresa.
     *
     * @throws CaException
     */
    public void incluirEmpresa() throws CaException {
        try {

            String strSQL = "INSERT INTO Empresa (K_Nit, RSocial, K_IdP) VALUES(?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, empresa.getK_Nit());
            prepStmt.setString(2, empresa.getRSocial());
            prepStmt.setInt(3, empresa.getK_IdP());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EmpresaDAO", "No pudo crear la empresa" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void modificarEmpresa() throws CaException{
        try {

            String strSQL = "UPDATE Empresa SET RSocial=?,K_IdP=? WHERE k_Nit=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setString(1,empresa.getRSocial());
            prepStmt.setInt(2,empresa.getK_IdP());
            prepStmt.setInt(3,empresa.getK_Nit());
       
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EmpresaDAO", "No se pudo actualizar la empresa" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
     public void eliminarEmpresa() throws CaException{
        try {

            String strSQL = "DELETE FROM Empresa WHERE k_Nit=?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, empresa.getK_Nit());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EmpresaDAO", "No se pudo eliminar el empresa" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarEmpresa() throws CaException {
        try {
            String strSQL = "SELECT K_Nit,RSocial,K_IdP FROM Empresa WHERE K_Nit = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, empresa.getK_Nit());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                empresa.setK_Nit(rs.getInt(1));
                empresa.setRSocial(rs.getString(2));
                empresa.setK_IdP(rs.getInt(3));                
            }
        } catch (SQLException e) {
            throw new CaException("EmpresaDAO", "No pudo recuperar el empresa " + e.getMessage());
        }

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
