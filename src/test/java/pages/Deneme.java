package pages;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import utilities.DatabaseUtility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Deneme {

    public static void main(String[] args) {

    }

    public static void createPdf(String filename, String title, int entry, String imagepath, List<List<Object>> list, List<String> header) {

        int len = header.size();

        // String[] headers = new String[]{header.get(0), header.get(1), header.get(2), header.get(3), header.get(4)};
        String[] headers = new String[len];
        for (int i = 0; i < len; i++) {
            headers[i] = header.get(i);

        }

        String[][] rows = new String[entry][len];
        for (int i = 0; i < entry; i++) {
            rows[i][0] = list.get(i).get(0).toString();
            rows[i][1] = list.get(i).get(1).toString();
            rows[i][2] = list.get(i).get(2).toString();
            rows[i][3] = list.get(i).get(3).toString();
            rows[i][4] = list.get(i).get(4).toString();


        }
        Document document = new Document(PageSize.LETTER.rotate());

        try {

            PdfWriter.getInstance(document,
                    new FileOutputStream(new File(filename)));
            document.open();
            Font fontTitle = new Font(Font.FontFamily.TIMES_ROMAN, 20);

            document.add(new Paragraph("                                               " + title.toUpperCase(), fontTitle));
            document.add(new Paragraph("          "));
            document.add(new LineSeparator());
            document.add(new Paragraph("          "));

            Font fontHeader = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font fontRow = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);

            PdfPTable table = new PdfPTable(headers.length);
            for (String head : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setGrayFill(0.9f);
                cell.setPhrase(new Phrase(head.toUpperCase(), fontHeader));
                table.addCell(cell);
            }
            table.completeRow();

            for (String[] row : rows) {
                for (String data : row) {
                    Phrase phrase = new Phrase(data, fontRow);
                    table.addCell(new PdfPCell(phrase));
                }
                table.completeRow();
            }

            document.addTitle("PDF Table ");
            document.add(table);
            document.add(new Paragraph("          "));
            document.add(new LineSeparator());
            document.add(Image.getInstance(imagepath));

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
