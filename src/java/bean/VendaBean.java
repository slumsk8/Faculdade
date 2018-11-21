package bean;

import dao.GenericDao;
import entidade.Cliente;
import entidade.Produto;
import entidade.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class VendaBean {
    /* instanciei os DAOs da entidade Cliente, Produto e Venda afim de listar os dados
    instanciei um obejto cliente e outro produto pra compor a lista e iniciar na minha bean venda */
    private GenericDao<Cliente> daoC = new GenericDao<>();
    private GenericDao<Produto> daoP = new GenericDao<>();
    private GenericDao<Venda> daoV = new GenericDao<>();
    private Cliente cliente = new Cliente();
    private Produto produto = new Produto();
    private Venda venda = new Venda();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();
    private Float vt;
    
    @PostConstruct
    public void init(){
        /* Aqui eu seto as "fk" das entidades cliente e produto na entidade venda e listo os objetos
        para resgatar no selectOneMenu na página jsf */
        venda.setCliente(cliente); 
        venda.setProduto(produto); 
        vendas = daoV.listar(venda);
        clientes = daoC.listar(cliente);
        produtos = daoP.listar(produto);
    }
    
    public String inserirVenda(){
        /* Verifico o id da venda se eu já tiver no banco eu faço um update se 
        não tiver eu crio um novo registro */
        if(venda.getIdvenda() == null){
            daoV.salvar(venda);
        }else{
            daoV.alterar(venda);
        }
        vendas = daoV.listar(venda);
        return "efetuarvenda.xhtml?faces-redirect=true";
    }

    public GenericDao<Cliente> getDaoC() {
        return daoC;
    }

    public void setDaoC(GenericDao<Cliente> daoC) {
        this.daoC = daoC;
    }

    public GenericDao<Produto> getDaoP() {
        return daoP;
    }

    public void setDaoP(GenericDao<Produto> daoP) {
        this.daoP = daoP;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public GenericDao<Venda> getDaoV() {
        return daoV;
    }

    public void setDaoV(GenericDao<Venda> daoV) {
        this.daoV = daoV;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Float getVt() {
        return vt;
    }

    public void setVt(Float vt) {
        this.vt = vt;
    }

}
