package eu.sample.java.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextSample {
    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4, 30, 30, 40, 50);
        PdfWriter.getInstance(document, new FileOutputStream("sample.pdf"));
        BaseFont baseFont = BaseFont.createFont("HeiseiKakuGo-W5",
                "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED);

        Font font = new Font(baseFont, 12);
        document.open();
        document.add(new Phrase("あいうえおあ", font));
        document.close();
    }
}