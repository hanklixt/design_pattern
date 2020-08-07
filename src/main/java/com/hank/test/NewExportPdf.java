//package com.hank.test;
//
//import org.apache.poi.xwpf.converter.pdf.PdfConverter;
//import org.apache.poi.xwpf.converter.pdf.PdfOptions;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//
///**
// * @Author: lxt
// * @Date: 2020/7/15 16:48
// */
//public class NewExportPdf {
//
//    /**
//     * word转pdf
//     * @param wordPath word的路径
//     */
//    public static boolean wordToPdf(String wordPath){
//
//        boolean result = false;
//        try {
//            XWPFDocument document=new XWPFDocument(new FileInputStream(new File(wordPath)));
//            File outFile=new File(wordPath);
//            outFile.getParentFile().mkdirs();
//            OutputStream out=new FileOutputStream(outFile);
//            PdfOptions options= PdfOptions.create();
//            PdfConverter.getInstance().convert(document,out,options);
//            System.out.println(("word转pdf成功"));
//            result = true;
//        }
//        catch (  Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        wordToPdf("C:\\Users\\HASEE\\Desktop\\2019-2020学年观山湖区外国语实验中学3数学.docx");
//    }
//
//
//}
