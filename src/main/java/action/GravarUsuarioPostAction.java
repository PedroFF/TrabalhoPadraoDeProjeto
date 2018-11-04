
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Usuario;
import model.UsuarioCliente;
import model.UsuarioRestaurante;
import persistence.UsuarioDAO;

/**
 *
 * @author Rian Alves
 */
public class GravarUsuarioPostAction implements Action  {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Endereço 
        String rua = request.getParameter("rua"); 
        String numero = request.getParameter("numero"); 
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep"); 
        String cidade = request.getParameter("cidade"); 
        String estado = request.getParameter("selectEstado"); 
        
        Endereco endereco = new Endereco(rua,bairro,cep,cidade,estado,complemento,numero);
        
        String nome = request.getParameter("textNome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String documento = request.getParameter("documento"); 
        
           
        String tipo = request.getParameter("selectTipo");
        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            if(tipo.equals("CLIENTE"))
            {   try {
                UsuarioCliente usuario = new UsuarioCliente(0, email, senha, nome, tipo, endereco, tipo);
                UsuarioDAO.getInstance().adicionarUsuario(usuario);
                } catch (SQLException ex) {
                    Logger.getLogger(GravarUsuarioPostAction.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            else if(tipo.equals("RESTAURANTE"))
            {   try {
                UsuarioRestaurante usuario = new UsuarioRestaurante(0, email, senha, nome, tipo, endereco, 5.0);
                UsuarioDAO.getInstance().adicionarUsuario(usuario);
                } catch (SQLException ex) {
                    Logger.getLogger(GravarUsuarioPostAction.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            
            response.sendRedirect("contatoSucesso.jsp");
        }
    }
    
}
