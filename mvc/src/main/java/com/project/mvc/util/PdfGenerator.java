package com.project.mvc.util;

import com.project.mvc.DTO.AreaRequest;
import com.project.mvc.model.Medidas;
import com.project.mvc.response.AreaResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;

public class PdfGenerator {
    public  static  byte[] gerar(AreaRequest request, AreaResponse response) throws Exception {
        try (PDDocument doc = new PDDocument()){
            PDPage page = new PDPage(PDRectangle.A4);
            doc.addPage(page);

            PDPageContentStream content = new PDPageContentStream(doc, page);
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 20);
            content.newLineAtOffset(100,750);
            content.showText("RELATÓRIO DE ORÇAMENTO");
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA,12);
            content.newLineAtOffset(50,700);
            content.showText("Tipo de superficie escolhida: " + request.getTipoSuperficie());
            content.newLineAtOffset(0,-15);
            content.showText("Valor do M² - R$: " + String.format("%.2", request.getValorMetroQuadrado()));
            content.newLineAtOffset(0,-15);
            content.showText("Total de area: : " + request.getMedidas().size());

            for (int i=0; i< request.getMedidas().size();i++){
                Medidas m = request.getMedidas().get(i);
                content.newLineAtOffset(0,-15);
                content.showText("Parede : " + (i+1) + m.getLargura() + "m x " + m.getAltura() + "m");
            }
            content.newLineAtOffset(0,-30);
            content.setFont(PDType1Font.HELVETICA_BOLD,14);
            content.showText("Area com a margem de erro de 10%: " + String.format("%.2f", response.getAreaTotal() + " m²"));
            content.newLineAtOffset(0, -20);
            content.showText("Total de caixas: " + response.getTotalCaixas());
            content.newLineAtOffset(0, -20);
            content.showText("Custo total estimado: R$ " + String.format("%.2f", response.getCustoTotal()));

            content.endText();
            content.close();

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            doc.save(out);
            return out.toByteArray();
        }
    }
}
