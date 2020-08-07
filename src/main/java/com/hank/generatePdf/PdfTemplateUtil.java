package com.hank.generatePdf;



/**
 * @Auther: admin
 * @Date: 2019/8/10 12:59
 * @Description:
 */

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.*;

import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;


public class PdfTemplateUtil {


    //构造器私有，防止别人通过new对象调用
    private PdfTemplateUtil() {
    }

    /**
     * @param data             模板数据
     * @param templateFileName freemarker模板文件名
     * @return : java.io.ByteArrayOutputStream
     * @auther : $Mr. Liu$
     * @date : 2019/8/9 14:45
     * @description : 通过模板导出pdf文件(有返回值)
     **/

    public static ByteArrayOutputStream createPDF(Map<String, Object> data, String templateFileName) throws Exception {
//        // 创建一个FreeMarker实例, 负责管理FreeMarker模板的Configuration实例
//        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
//        // 指定FreeMarker模板文件的位置
//        configuration.setClassForTemplateLoading(PdfTemplateUtil.class, "/templates");
        ITextRenderer renderer = new ITextRenderer();
        OutputStream out = new ByteArrayOutputStream();
        StringWriter writer = new StringWriter();


        try {
            // 设置 css中 的字体样式（暂时仅支持宋体和黑体） 必须，不然中文不显示
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont("C:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            fontResolver.addFont("C:/Windows/Fonts/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            fontResolver.addFont("C:/Windows/Fonts/simkai.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

//            // 设置模板的编码格式
//            configuration.setEncoding(Locale.CHINA, "UTF-8");
//            // 获取模板文件
//            Template template = configuration.getTemplate(templateFileName, "UTF-8");
            // 将数据输出到html中
//            template.process(data, writer);
            writer.flush();
            String html = writer.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<!DOCTYPE html [\n" +
                    "<!ENTITY nbsp \"&#160;\"> \n" +
                    "]>");
            FileUtil.readToBuffer(stringBuffer,"C:\\Users\\HASEE\\Desktop\\2019-2020学年观山湖区外国语实验中学3数学.htm");
            // 把html代码传入渲染器中
            renderer.setDocumentFromString(stringBuffer.toString());
            // 设置模板中的图片路径 （这里的images在resources目录下） 模板中img标签src路径需要相对路径加图片名 如<img src="images/xh.jpg"/>
//            String url = PdfTemplateUtil.class.getClassLoader().getResource("static/images").toURI().toString();
//            renderer.getSharedContext().setBaseURL(url);
            renderer.layout();
            renderer.createPDF(out, false);
            renderer.finishPDF();
            out.flush();
            return (ByteArrayOutputStream) out;
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * @param data             模板数据
     * @param templateFileName freemarker模板文件名
     * @auther : $Mr. Liu$
     * @date : 2019/8/9 14:45
     * @description : 通过模板导出pdf文件(改进后无返回值)
     **/

    public static void createPDF(Map<String, Object> data, String templateFileName, String fileName) throws Exception {
        // 创建一个FreeMarker实例, 负责管理FreeMarker模板的Configuration实例
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        // 指定FreeMarker模板文件的位置
        configuration.setClassForTemplateLoading(PdfTemplateUtil.class, "/templates");
        ITextRenderer renderer = new ITextRenderer();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StringWriter writer = new StringWriter();

        try {
            // 设置 css中 的字体样式（暂时仅支持宋体和黑体） 必须，不然中文不显示
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont("C:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            fontResolver.addFont("C:/Windows/Fonts/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            fontResolver.addFont("C:/Windows/Fonts/simkai.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 设置模板的编码格式
            configuration.setEncoding(Locale.CHINA, "UTF-8");
            String url = PdfTemplateUtil.class.getClassLoader().getResource("static/images").toURI().toString();
            // 获取模板文件
            Template template = configuration.getTemplate(templateFileName, "UTF-8");
            // 将数据输出到html中
            template.process(data, writer);
            writer.flush();
            String html = writer.toString();
            // 把html代码传入渲染器中
            renderer.setDocumentFromString(html);

            // 设置模板中的图片路径 （这里的images在resources目录下） 模板中img标签src路径需要相对路径加图片名 如<img src="images/xh.jpg"/>
//            String url = PdfTemplateUtil.class.getClassLoader().getResource("static/images").toURI().toString();
            renderer.getSharedContext().setBaseURL(url);
            renderer.layout();
            renderer.createPDF(out, false);
            out.flush();
            renderer.finishPDF();
//            response.setContentType("application/x-msdownload");
//            // 告诉浏览器，当前响应数据要求用户干预保存到文件中，以及文件名是什么 如果文件名有中文，必须URL编码
//            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//            out.writeTo(response.getOutputStream());


            FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/HASEE/Desktop/文本.pdf");
            fileOutputStream.write(out.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }


    public static void createPDFV2(String fileName) throws Exception {
        ITextRenderer renderer = new ITextRenderer();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            // 设置 css中 的字体样式（暂时仅支持宋体和黑体） 必须，不然中文不显示
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont("C:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            fontResolver.addFont("C:/Windows/Fonts/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            fontResolver.addFont("C:/Windows/Fonts/simkai.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 将数据输出到html中
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<!DOCTYPE html [\n" +
                    "<!ENTITY nbsp \"&#160; \"> \n" +
                     "<!ENTITY ldquo \"&#8220; \">"+
                    "<!ENTITY rdquo \"&#8221; \">"+
                    "<!ENTITY ne \"&#8800; \">"+
                    "<!ENTITY perp \"&#8800; \">"+
                    "<!ENTITY ang \"&#8736; \">"+
                    "<!ENTITY deg \"&#176; \">"+
                    "<!ENTITY ge \"&#8805; \">"+
                    "<!ENTITY plusmn \"&#177; \">"+
                    "<!ENTITY le \"&#8804; \">"+
                    "<!ENTITY rarr \"&#8594; \">"+
                    "]>");
            FileUtil.readToBuffer(stringBuffer,"C:\\Users\\HASEE\\Desktop\\2019-2020学年观山湖区外国语实验中学3数学.htm");
            // 把html代码传入渲染器中
            String s = stringBuffer.toString();

            renderer.setDocumentFromString(stringBuffer.toString());
            renderer.layout();
            renderer.createPDF(out, false);
            out.flush();
            renderer.finishPDF();
            FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/HASEE/Desktop/文本.pdf");
            fileOutputStream.write(out.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static Map<String, Object> getStringObjectMap() {
        // 模板中的数据，实际运用从数据库中查询
        Map<String, Object> data = new HashMap<>();
        data.put("curr", 1);
        data.put("one", 2);
        data.put("two", 1);
        data.put("three", 6);
        List<PdfDataTest> detailList = new ArrayList<>();
        detailList.add(new PdfDataTest(123456, "测试", "测试", "测试", "测试"));
        detailList.add(new PdfDataTest(111111, "测试", "测试", "测试", "测试"));
        detailList.add(new PdfDataTest(222222, "测试", "测试", "测试", "测试"));
        data.put("detailList", detailList);
        return data;
    }

    public static void main(String[] args) {
        Map<String, Object> stringObjectMap = getStringObjectMap();
        try {
            createPDFV2("test.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}