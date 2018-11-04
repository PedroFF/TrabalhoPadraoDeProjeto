
package model;

/**
 *
 * @author Rian Alves
 */
public abstract class FormaPagamento {
    private int id;
    private String descricao;
    
    public abstract String getDescricaoCompleta();
    
    public String getDadosPagamento()
    {
        return "Pagamento via : " + getDescricao() + " Não esqueça de : " + getDescricaoCompleta() ;
    }

    public FormaPagamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

   
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   
    public String getDescricao() {
        return descricao;
    }

   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
