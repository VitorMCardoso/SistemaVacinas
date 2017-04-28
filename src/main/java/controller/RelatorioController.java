/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author vitor
 */
public class RelatorioController {

    public void gerarRelatorio(String nomeRelatorio, HashMap paramRel, List listaRel) throws Exception {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        ServletContext sc = (ServletContext) context.getExternalContext().getContext();
        String relPath = sc.getRealPath("/");
        String imagemLogo = relPath + "resources/imagens/logo_mmo.jpg";
        paramRel.put("imagemLogo", imagemLogo);
        paramRel.put("nmSistema","NOme");
        paramRel.put("REPORT_LOCALE", new Locale("pt", "BR"));
        JasperPrint print = null;

        JRBeanCollectionDataSource rel = new JRBeanCollectionDataSource(listaRel);
        print = JasperFillManager.fillReport(relPath + "relatorios/" + nomeRelatorio + ".jasper", paramRel, rel);

        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename =\"" + nomeRelatorio + ".pdf\"");
        JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());

        ServletOutputStream responseStream = response.getOutputStream();
        responseStream.flush();
        responseStream.close();
        FacesContext.getCurrentInstance().renderResponse();
        FacesContext.getCurrentInstance().responseComplete();
    }
}
