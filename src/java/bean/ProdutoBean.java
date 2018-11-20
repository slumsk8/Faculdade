package bean;

import dao.GenericDao;
import entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class ProdutoBean {
    private GenericDao<Produto> dao = new GenericDao<>();
    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        produtos = dao.listar(produto);
        produto = new Produto();
    }

     // métodos de manipulção com a entidade
    public String inserir(){
        if(produto.getIdproduto()== null || produto.getIdproduto()==0){
            dao.salvar(produto);
        }
        else if(produto.getIdproduto()!=null || produto.getIdproduto()>0){
            dao.alterar(produto);
        }
        produtos = dao.listar(produto);
        return "cadproduto.xhtml?faces-redirect=true";
    }
    
    public void prepararAlteracao(Produto p){
        this.produto = p;
    }
    
    public String remover(Produto p){
        dao.deletar(p);
        produtos = dao.listar(produto);
        return "cadproduto.xhtml?faces-redirect=true";
    }
    
    public GenericDao<Produto> getDao() {
        return dao;
    }

    public void setDao(GenericDao<Produto> dao) {
        this.dao = dao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
