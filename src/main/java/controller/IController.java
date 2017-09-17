/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vitor
 */
public interface IController {
    
    public void inserir(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException;

    public void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException;

    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void editForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;

    public void deletar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException;
  
    public void atualizar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException;
}
