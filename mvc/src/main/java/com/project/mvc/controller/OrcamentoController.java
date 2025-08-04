package com.project.mvc.controller;

import ch.qos.logback.core.model.Model;
import com.project.mvc.DTO.AreaRequest;
import com.project.mvc.model.Medidas;
import com.project.mvc.response.AreaResponse;
import com.project.mvc.service.CalculoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {
    private final CalculoService service;

    public OrcamentoController (CalculoService service) {
        this.service = service;
    }

//    @GetMapping("/form")
//    public String exibirFormulario(Model model) {
//        // Inicializa o formulário com uma medida vazia para renderizar o input
//        AreaRequest areaRequest = new AreaRequest();
//        areaRequest.setMedidas(new ArrayList<>());
//        areaRequest.getMedidas().add(new Medidas());
//
//        model.addAttribute("areaRequest", areaRequest);
//        return "form-orcamento";
//    }
    @PostMapping("/calcular")
    public ResponseEntity<AreaResponse> calcular(@Valid @RequestBody AreaRequest request) {
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
