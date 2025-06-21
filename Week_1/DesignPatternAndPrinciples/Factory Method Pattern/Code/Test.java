public class Test {
    public static void main(String[] args) {

        DocumentFactory word = new WordDocumentFactory();
        Document wordDoc = word.createDocument();
        wordDoc.open();
        DocumentFactory pdf = new PdfDocumentFactory();
        Document pdfDoc = pdf.createDocument();
        pdfDoc.open();
        DocumentFactory excel = new ExcelDocumentFactory();
        Document excelDoc = excel.createDocument();
        excelDoc.open();
        }
    }
