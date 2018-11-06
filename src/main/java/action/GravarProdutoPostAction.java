
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.UsuarioRestaurante;
import persistence.ProdutoDAO;
import persistence.RestauranteDAO;
import persistence.UsuarioDAO;

/**
 *
 * @author Rian Alves
 */
public class GravarProdutoPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            String[] values = request.getParameterValues("selecionados");
            String nome = request.getParameter("nome");
            String tipo = request.getParameter("tipo");
            Double preco = Double.parseDouble(request.getParameter("preco").replace(",", "."));
            UsuarioRestaurante restaurante = UsuarioDAO.getInstance().getUsuarioRestauranteByID((int)request.getSession().getAttribute("usuarioID"));
            Produto produto = new Produto();
            produto.setPreco(preco).setDescricao(nome).setRestaurante(restaurante);
            if(tipo.equals("PFINAL")){
                produto.setIngrediente(false);
            } else if(tipo.equals("INGREDIENTE")){
                produto.setIngrediente(true);
            }
            ProdutoDAO dao = ProdutoDAO.getINSTANCE();
            Integer idProduto = dao.adicionar(produto, restaurante.getIdUsuario());
            
            for(String value : values){
                Integer idIngrediente = Integer.parseInt(value);
                ProdutoDAO.getINSTANCE().adicionarIngrediente(idProduto, idIngrediente);
            }
            response.sendRedirect("CadastroProduto.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(GravarProdutoPostAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
