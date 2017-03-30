/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autorizacaoAcesso;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PerfilAcesso;
import model.Usuario;

/**
 *
 * @author vitor
 */
public class AcesoAdministrativo implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        //recuperar a sessao
        HttpSession sessaoUsuario = ((HttpServletRequest)request).getSession();
        Usuario usuario = (Usuario) sessaoUsuario.getAttribute("usuarioAUtenticado");
        
        if(usuario!=null && usuario.getPerfil().equals(PerfilAcesso.ADMINISTRADOR)){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse)response).sendRedirect("../acessoNegado.jsp");
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
