package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.UsuarioDAO;

public class LoginPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            String user = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            String tipo = request.getParameter("tipo");
            Usuario usuario = new Usuario();
            usuario.setEmail(user)
                    .setSenha(senha)
                    .setTipo(tipo);
            UsuarioDAO dao = UsuarioDAO.getInstance(); 
            Usuario usuarioTeste = dao.getUsuario(usuario);
            if (usuarioTeste == null) {
                response.sendRedirect("UaiFat?action=Login&erroLogin=true");
            } else {

                request.getSession().setAttribute("usuarioTipo", usuarioTeste.getTipo());
                request.getSession().setAttribute("usuarioID", usuarioTeste.getIdUsuario());
                if (usuarioTeste.getTipo().equals("RESTAURANTE")) {
                    IndexRestauranteAction comando = new IndexRestauranteAction();
                    comando.execute(request, response);
                } else if(usuarioTeste.getTipo().equals("CLIENTE")){
                    IndexAction comando = new IndexAction();
                    comando.execute(request, response);
                }
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginPostAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
