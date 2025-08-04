package com.project.mvc.controller;

import com.project.mvc.DTO.AreaRequest;
import com.project.mvc.response.AreaResponse;
import com.project.mvc.service.CalculoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {
    private final CalculoService service;

    public CalculoService(CalculoService service) {
        this.service = service;
    }

    @PostMapping("/calcular")
    public ResponseEntity<AreaResponse> calcular(@RequestBody AreaRequest request) {
        AreaResponse response = service.calcular(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/gerar-pdf")
    public ResponseEntity<byte[]> gerarPdf(@RequestBody AreaRequest request) throws Exception {
        AreaResponse response = service.calcular(request);
        byte[] pdf = service.gerarPdf(request, response);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("relatorio-ceramica.pdf").build());

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }

}
