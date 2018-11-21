package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "venda")
@NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v ORDER BY v.cliente")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvenda")
    private Long idvenda;
    
    /* Geramos as FK instanciando a classe Cliente e Produto.
    Um cliente pode fazer várias vendas, assim como um venda contém muitos produtos 
    JoinColumn criará a coluna FK na tabela venda */
    
    @ManyToOne 
    @JoinColumn(name = "fk_id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_produto")
    private Produto produto;

        
    public Long getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Long idvenda) {
        this.idvenda = idvenda;
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
    
    
}
