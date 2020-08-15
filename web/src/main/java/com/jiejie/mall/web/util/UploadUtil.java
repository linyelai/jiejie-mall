package com.jiejie.mall.web.util;

import com.google.common.io.FileBackedOutputStream;

import java.io.*;

/**
 * @Author linseven
 * @Date 2020/5/13
 */
public class UploadUtil {

    public static void main(String [] args){

    }

    public static boolean uploadLocal(InputStream inputStream,String path,String fileName)throws FileNotFoundException{
        boolean flag = false;
        OutputStream out =null;
        try {
             out = new FileOutputStream(path + fileName);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                out.close();
                inputStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        flag = true;
        return flag;
    }
}
