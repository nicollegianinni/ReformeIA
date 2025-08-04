package com.project.mvc.service;

import com.project.mvc.DTO.AreaRequest;
import com.project.mvc.response.AreaResponse;
import com.project.mvc.util.PdfGenerator;
import org.springframework.stereotype.Service;

//classe Service onde esta a regra de negocio
@Service
public class CalculoService {

    private static final double MARGEM_SEGURANÇA = 0.1;
    private static final double AREA_CAIXA = 2.0;

    public AreaResponse calcular(AreaRequest request) {
        double areaTotal = request.getMedidas().stream()
                .mapToDouble(m -> m.getAltura() * m.getLargura())
                .sum();

        areaTotal += areaTotal * MARGEM_SEGURANÇA;
        int totalCaixas = (int) Math.ceil(areaTotal / AREA_CAIXA);
        double custoTotal = areaTotal * request.getValorMetroQuadrado();

        return new AreaResponse(areaTotal, custoTotal, totalCaixas);
    }

    public byte[] gerarPdf(AreaRequest request, AreaResponse response) throws Exception {
        return PdfGenerator.gerar(request, response);
    }
}
