package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.Usuario;
import persistence.ProdutoDAO;
import persistence.UsuarioDAO;

public class ListarProdutoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            int idRestaurante = (int)request.getSession().getAttribute("usuarioID");
            List<Produto> produtos = ProdutoDAO.getINSTANCE().getAllProdutos(idRestaurante);
            request.setAttribute("produtos", produtos);
            request.getRequestDispatcher("listaProdutos.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
