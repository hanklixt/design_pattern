//package com.hank.test;
//
///**
// * @Author: lxt
// * @Date: 2020/7/15 16:23
// */
//import com.artofsolving.jodconverter.DocumentConverter;
//import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
//import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
//import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
//import org.apache.poi.xwpf.converter.pdf.PdfConverter;
//import org.apache.poi.xwpf.converter.pdf.PdfOptions;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//
//import java.io.*;
//
//
//public class XMLToDoc {
//
//        /**
//         * 生成pdf
//         */
//        public static String makePdfByXcode(String docx) {
//            String filename = null;
//            File outFile = null;
//            try {
//                //    document.setParagraph(new Pa );
//                if (docx.contains(".docx")) {
//                    XWPFDocument document=new XWPFDocument(new FileInputStream(new File(docx)));
//                    outFile=new File(docx.replace(".docx",".pdf"));
//                    filename=docx.replace(".docx",".pdf");
//                    outFile.getParentFile().mkdirs();
//                    OutputStream out=new FileOutputStream(outFile);
//                    //    IFontProvider fontProvider = new AbstractFontRegistry();
//                    PdfOptions options= PdfOptions.create();  //gb2312
//                    PdfConverter.getInstance().convert(document,out,options);
//
//                } else {
//                    File inputFile = new File(docx);
//                    outFile = new File(docx.replace(".doc", ".pdf"));
//                    filename = docx.replace(".doc", ".pdf");
//                    outFile.getParentFile().mkdirs();
//
//                    OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
//                    connection.connect();
//
//                    // convert
//                    DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
//                    converter.convert(inputFile, outFile);
//
//                    // close the connection
//                    connection.disconnect();
//                }
//            }catch (IllegalArgumentException e){
//                System.err.println("未知文件格式");
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//            return filename;
//        }
//
//
//    public static void main(String[] args) {
//        makePdfByXcode("C:\\Users\\HASEE\\Desktop\\2019-2020学年观山湖区外国语实验中学3数学.docx");
//
//    }
//
//
//    }
//
