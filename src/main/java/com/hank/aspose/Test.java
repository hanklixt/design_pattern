package com.hank.aspose;

import com.aspose.words.*;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @Author: lxt
 * @Date: 2020/7/16 16:14
 */
public class Test {


    public static void main(String[] args) throws Exception {
        Document nodes = new Document("C:\\Users\\HASEE\\Desktop\\2019-2020学年观山湖区外国语实验中学3数学.docx");
        for(Run run : (Iterable<Run>) nodes.getChildNodes(NodeType.RUN, true))
        {
            run.getFont().setName("Microsoft YaHei");
        }
//                Font font = builder.getFont();
//                font.setName("宋体");
        nodes.save("C:\\Users\\HASEE\\Desktop\\新建文本文档.pdf", SaveFormat.PDF);
    }



    private void writeToLocal(String destination, InputStream input)
            throws IOException {
        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = input.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        input.close();
        downloadFile.close();

    }

}
