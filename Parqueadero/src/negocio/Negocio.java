package negocio;

import datos.AreaDAO;
import datos.ClienteDAO;
import datos.ContratoDAO;
import datos.EmpresaDAO;
import datos.EspacioDAO;
import datos.ParqueaderoDAO;
import datos.RegistroDAO;
import datos.TarifaDAO;
import datos.VehiculoDAO;

import util.CaException;

/**
 * Clase controladora de la aplicaci�n
 * @author JORGE GOMEZ
 */

public class Negocio {
    private AreaDAO areaDAO;
    private ClienteDAO clienteDAO;
    private ContratoDAO contratoDAO;
    private EmpresaDAO empresaDAO;
    private EspacioDAO espacioDAO;
    private ParqueaderoDAO parqueaderoDAO;
    private RegistroDAO registroDAO;
    private TarifaDAO tarifaDAO;
    private VehiculoDAO vehiculoDAO;

    public Negocio() {
        areaDAO = new AreaDAO();
        clienteDAO= new ClienteDAO();
        contratoDAO=new ContratoDAO();
        empresaDAO=new EmpresaDAO();
        espacioDAO=new EspacioDAO();
        parqueaderoDAO=new ParqueaderoDAO();
        registroDAO=new RegistroDAO();
        tarifaDAO=new TarifaDAO();
        vehiculoDAO=new VehiculoDAO();
    }
    
    /* +++ METODOS DE  +++*/
    public void incluirArea() throws CaException {
      areaDAO.incluirArea();
    }
    public void modificarArea() throws CaException {
      areaDAO.modificarArea();
    }
    public void eliminarArea() throws CaException {
      areaDAO.incluirArea();
    }
    public void buscarArea() throws CaException {
      areaDAO.incluirArea();
    }
    
    /* +++ METODOS DE CLIENTE +++*/
    public void incluirCliente() throws CaException {
      clienteDAO.incluirCliente();
    }
    public void modificarCliente() throws CaException {
      clienteDAO.modificarCliente();
    }
    public void eliminarCliente() throws CaException {
      clienteDAO.eliminarCliente();
    }
    public void buscarCliente() throws CaException {
      clienteDAO.buscarCliente();
    }
    
    /* +++ METODOS DE CONTRATO +++*/
    public void incluirContrato() throws CaException {
      contratoDAO.incluirContrato();
    }
    public void modificarContrato() throws CaException {
      contratoDAO.modificarContrato();
    }
    public void eliminarContrato() throws CaException {
      contratoDAO.eliminarContrato();
    }
    public void buscarContrato() throws CaException {
      contratoDAO.buscarContrato();
    }
    
    /* +++ METODOS DE EMPRESA +++*/
    public void incluirEmpresa() throws CaException {
      empresaDAO.incluirEmpresa();
    }
    public void modificarEmpresa() throws CaException {
      empresaDAO.modificarEmpresa();
    }
    public void eliminarEmpresa() throws CaException {
      empresaDAO.eliminarEmpresa();
    }
    public void buscarEmpresa() throws CaException {
      empresaDAO.buscarEmpresa();
    }
    
    /* +++ METODOS DE ESPACIO +++*/
    public void incluirEspacio() throws CaException {
      espacioDAO.incluirEspacio();
    }
    public void modificarEspacio() throws CaException {
      espacioDAO.modificarEspacio();
    }
    public void eliminarEspacio() throws CaException {
      espacioDAO.eliminarEspacio();
    }
    public void buscarEspacio() throws CaException {
      espacioDAO.buscarEspacio();
    }
    
    /* +++ METODOS DE PARQUEADERO +++*/
    public void incluirParqueadero() throws CaException {
      parqueaderoDAO.incluirParqueadero();
    }
    public void modificarParqueadero() throws CaException {
      parqueaderoDAO.modificarParqueadero();
    }
    public void eliminarParqueadero() throws CaException {
      parqueaderoDAO.eliminarParqueadero();
    }
    public void buscarParqueadero() throws CaException {
      parqueaderoDAO.buscarParqueadero();
    }
    
    /* +++ METODOS DE REGISTRO +++*/
    public void incluirRegistro() throws CaException {
      registroDAO.incluirRegistro();
    }
    public void modificarRegistro() throws CaException {
      registroDAO.modificarRegistro();
    }
    public void eliminarRegistro() throws CaException {
      registroDAO.eliminarRegistro();
    }
    public void buscarRegistro() throws CaException {
      registroDAO.buscarRegistro();
    }
    
    /* +++ METODOS DE TARIFA +++*/
    public void incluirTarifa() throws CaException {
      tarifaDAO.incluirTarifa();
    }
    public void modificarTarifa() throws CaException {
      tarifaDAO.modificarTarifa();
    }
    public void eliminarTarifa() throws CaException {
      tarifaDAO.eliminarTarifa();
    }
    public void buscarTarifa() throws CaException {
      tarifaDAO.buscarTarifa();
    }
    
    /* +++ METODOS DE VEHICULO +++*/
    public void incluirVehiculo() throws CaException {
      vehiculoDAO.incluirVehiculo();
    }
    public void modificarVehiculo() throws CaException {
      vehiculoDAO.modificarVehiculo();
    }
    public void eliminarVehiculo() throws CaException {
      vehiculoDAO.eliminarVehiculo();
    }
    public void buscarrVehiculo() throws CaException {
      vehiculoDAO.buscarVehiculo();
    }

    /*+++GETTERS+++*/
    public AreaDAO getAreaDAO() {
        return areaDAO;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public ContratoDAO getContratoDAO() {
        return contratoDAO;
    }

    public EmpresaDAO getEmpresaDAO() {
        return empresaDAO;
    }

    public EspacioDAO getEspacioDAO() {
        return espacioDAO;
    }

    public ParqueaderoDAO getParqueaderoDAO() {
        return parqueaderoDAO;
    }

    public RegistroDAO getRegistroDAO() {
        return registroDAO;
    }

    public TarifaDAO getTarifaDAO() {
        return tarifaDAO;
    }

    public VehiculoDAO getVehiculoDAO() {
        return vehiculoDAO;
    }
    
    
}
