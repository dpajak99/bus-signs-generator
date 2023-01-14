package com.tarbus.builders;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import com.tarbus.models.TimetablePdfBuilderResult;
import com.tarbus.models.TimetableDocumentStructure;
import com.tarbus.models.TimetablePageStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TimetablePdfBuilder {
    final String inputDirectory = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/input";
    final String outputDirectory = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/output";
    
    public List<TimetablePdfBuilderResult> saveAll(List<TimetableDocumentStructure> documents, String directory) throws IOException {
        List<TimetablePdfBuilderResult> results = new ArrayList<>();
        for(TimetableDocumentStructure document : documents) {
            results.add(save(document, directory));
        }
        return results;
    }

    public TimetablePdfBuilderResult save(TimetableDocumentStructure timetableDocumentStructure, String directory) throws IOException {
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(inputDirectory);
        String outputFile = outputDirectory + "/"+directory+"/" +timetableDocumentStructure.getFileName() + ".pdf";
        PdfWriter pdfWriter = new PdfWriter(outputFile);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        PdfMerger pdfMerger = new PdfMerger(pdfDocument);
        for (TimetablePageStructure timetablePageStructure : timetableDocumentStructure.getPages()) {
            ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            PdfDocument pdfPageDocument = new PdfDocument(new PdfWriter(pdfOutputStream));
            String html = timetablePageStructure.buildHtml();
            HtmlConverter.convertToPdf(html, pdfPageDocument, converterProperties);
            pdfPageDocument = new PdfDocument(new PdfReader(new ByteArrayInputStream(pdfOutputStream.toByteArray())));
            pdfMerger.merge(pdfPageDocument, 1, pdfPageDocument.getNumberOfPages());
            pdfPageDocument.close();
        }
        pdfDocument.close();
        TimetablePdfBuilderResult result = new TimetablePdfBuilderResult();
        result.setFileName(timetableDocumentStructure.getFileName());
        result.setPdfPath(outputFile);
        return result;
    }
}
