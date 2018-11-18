package bean;

import dao.GenericDao;
import entidade.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;


@ManagedBean
public class VendaBean {
    private GenericDao<Venda> dao = new GenericDao<>();
    private Venda venda = new Venda();
    private List<Venda> vendas = new ArrayList<>();
    private Double valorTotal;

    @PostConstruct
    public void init(){
        dao.listar(venda);
        venda = new Venda();
    }
        
    public String inserir(){
        if(venda.getIdvenda()==null || venda.getIdvenda()==0){
            dao.salvar(venda);
        }
        else if(venda.getIdvenda()!=null || venda.getIdvenda()>0){
            dao.alterar(venda);
        }
        return "efetuarvenda.xhtml?faces-redirect=true";
    }
    
    public Double valorTotal(){
        valorTotal = (venda.getProduto().getValor())*venda.getQuantidade();
        return valorTotal;
    }
        
        
    public GenericDao<Venda> getDao() {
        return dao;
    }

    public void setDao(GenericDao<Venda> dao) {
        this.dao = dao;
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
            
    
}
