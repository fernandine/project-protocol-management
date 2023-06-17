package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.JasperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class JasperController {

    @Autowired
    private JasperService service;


    @GetMapping("/relatorio/pdf/jr1")
    public void exibirRelatorio(@RequestParam("code") String code,
                                @RequestParam("acao") String acao,
                                HttpServletResponse response) throws IOException {
        byte[] bytes = service.exportarPDF(code);
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        if (acao.equals("v")) {
            response.setHeader("Content-disposition", "inline; filename=relatorio-" + code + ".pdf");
        } else {
            response.setHeader("Content-disposition", "attachment; filename=relatorio-" + code + ".pdf");
        }
        response.getOutputStream().write(bytes);
    }
}
