package com.karolina.cv_generator.Controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.karolina.cv_generator.Model.CVData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.karolina.cv_generator.Model.Education;
import com.karolina.cv_generator.Model.Experience;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@Controller
public class CvPdfController {

    @GetMapping("/cv/download")
    public ResponseEntity<byte[]> downloadPdf(@ModelAttribute("cv") CVData cv) {

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();

            Font headerFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
            Paragraph title = new Paragraph(cv.getFirstName() + " " + cv.getLastName() + " – " + cv.getTitle(), headerFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Email: " + cv.getEmail()));
            document.add(new Paragraph("Phone: " + cv.getPhone()));
            document.add(new Paragraph("Address: " + cv.getAddress() + ", " + cv.getCity() + " " + cv.getPostalCode()));
            document.add(new Paragraph("Website: " + cv.getWebsite()));
            document.add(new Paragraph("LinkedIn: " + cv.getLinkedin()));
            document.add(new Paragraph(" "));

            if (cv.getSummary() != null) {
                document.add(new Paragraph("About me", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                document.add(new Paragraph(cv.getSummary()));
                document.add(new Paragraph(" "));
            }

            if (cv.getSkills() != null && !cv.getSkills().isEmpty()) {
                document.add(new Paragraph("Skills", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                for (String skill : cv.getSkills()) {
                    document.add(new Paragraph("• " + skill));
                }
                document.add(new Paragraph(" "));
            }

            if (cv.getEducations() != null) {
                document.add(new Paragraph("Education", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                for (Education edu : cv.getEducations()) {
                    document.add(new Paragraph(edu.getInstitution() + ", " + edu.getDegree() + " (" + edu.getYear() + ")"));
                }
                document.add(new Paragraph(" "));
            }

            if (cv.getExpertises() != null) {
                document.add(new Paragraph("Work Experience", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                for (Experience exp : cv.getExpertises()) {
                    document.add(new Paragraph(exp.getCompany() + " – " + exp.getPosition() + " (" + exp.getDuration() + ")"));
                }
                document.add(new Paragraph(" "));
            }


            document.close();

            byte[] pdfBytes = baos.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "cv.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

