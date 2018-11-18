package bean;

import dao.GenericDao;
import entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class ClienteBean {
    private GenericDao<Cliente> dao = new GenericDao<>();
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes = new ArrayList<>();

    @PostConstruct
    public void init(){
        clientes = dao.listar(cliente);
        cliente = new Cliente();
    }
    
    // métodos de manipulção com a entidade
    public String inserir(){
        if(cliente.getIdcliente()== null || cliente.getIdcliente()==0){
            dao.salvar(cliente);
        }
        else if(cliente.getIdcliente()!=null || cliente.getIdcliente()>0){
            dao.alterar(cliente);
        }
        clientes = dao.listar(cliente);
        return "cadcliente.xhtml?faces-redirect=true";
    }
    
    public void prepararAlteracao(Cliente c){
        this.cliente = c;
    }
    
    public String remover(Cliente c){
        dao.deletar(c);
        clientes = dao.listar(cliente);
        return "cadcliente.xhtml?faces-redirect=true";
    }
    
    
    
    // getters e setters
    public GenericDao<Cliente> getDao() {
        return dao;
    }

    public void setDao(GenericDao<Cliente> dao) {
        this.dao = dao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
}
