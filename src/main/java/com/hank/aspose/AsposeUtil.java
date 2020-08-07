package com.hank.aspose;


import com.aspose.words.Document;
import com.aspose.words.License;

import java.io.InputStream;

/**
 * @Author MixCG
 * @Name
 * @Desc Created by MixCG on 2018-09-04.
 */


public class AsposeUtil {

    private static InputStream inputStream = null;


    /**
     * 获取License的输入流
     *
     * @return
     */
    private static InputStream getLicenseInput() {
        if (inputStream == null) {
            ClassLoader contextClassLoader =AsposeUtil.class.getClassLoader();
            try {

                inputStream =contextClassLoader.getResourceAsStream("listence\\license.xml");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("license not found!");
            }
        }
        return inputStream;
    }

    /**
     * 设置License
     *
     * @return true表示已成功设置License, false表示失败
     */
    public static boolean setWordsLicense() {
        InputStream licenseInput = getLicenseInput();
        if (licenseInput != null) {
            try {
                com.aspose.words.License aposeLic = new com.aspose.words.License();
                aposeLic.setLicense(licenseInput);
                return aposeLic.getIsLicensed();
            } catch (Exception e) {
            }
        }
        return false;
    }

    /**
     * 设置License
     *
     * @return true表示已成功设置License, false表示失败
     */
    public static boolean setCellsLicense() {
        InputStream licenseInput = getLicenseInput();
        if (licenseInput != null) {
            try {
                License aposeLic = new License();
                aposeLic.setLicense(licenseInput);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    /**
     * 设置License
     *
     * @return true表示已成功设置License, false表示失败
     */
    public static boolean setSlidesLicense() {
        InputStream licenseInput = getLicenseInput();
        if (licenseInput != null) {
            try {
               License aposeLic = new License();
                aposeLic.setLicense(licenseInput);
                return aposeLic.isLicensed();
            } catch (Exception e) {
            }
        }
        return false;
    }
    /**
     * 设置Aspose PDF的license
     * @return true表示设置成功，false表示设置失败
     */
    public static boolean setPdfLicense() {
        InputStream licenseInput = getLicenseInput();
        if (licenseInput != null) {
            try {
                com.aspose.pdf.License aposeLic = new com.aspose.pdf.License();
                aposeLic.setLicense(licenseInput);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }
    public static void main(String[] args) {
        boolean b = setPdfLicense();
        if (!b){
            return;
        }
        try {
            Document nodes = new Document("C:\\Users\\HASEE\\Desktop\\2019-2020学年观山湖区外国语实验中学3数学.docx");
            nodes.save("C:\\Users\\HASEE\\Desktop\\数学考试.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
