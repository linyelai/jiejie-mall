package com.jiejie.mall.web.controller.file;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.web.util.CommonUtil;
import com.jiejie.mall.web.util.UploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author linseven
 * @Date 2020/5/13
 */
@RestController
public class ImageController {

    @Value("d:/images/")
     private String imagesPath;
    @PostMapping("/upload")
    public Response<String> unload(@RequestParam MultipartFile file){
        Response<String> response = new Response<>();
        String oldFileName = file.getOriginalFilename();
        String fileName = CommonUtil.generateImageName()+oldFileName.substring(oldFileName.lastIndexOf('.'));
        try {
            UploadUtil.uploadLocal(file.getInputStream(), imagesPath, fileName);
            response.setData(fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping("/images/{imageName}")
    public void unload(@PathVariable(value="imageName") String imageName, HttpServletResponse response){

        InputStream in = null;
        OutputStream out = null;
        if(imageName!=null){
            try {
                out = response.getOutputStream();
                in = new FileInputStream(imagesPath + imageName);
                int len  =0;
                byte[] buf = new byte[1024];
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            } finally{

                try{
                    in.close();
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }


    @PostMapping("OneController/getFileToHDFS")
    public void getFileToHDFS(@RequestParam("file") MultipartFile file){
        /*try {
            if (file != null) {
                File hh = CommonUtil.MultipartFileToFile(file);
                HDFSCommon.copyfileToHdfs(new Configuration(),"hdfs://10.0.0.194:9000",hh);
            }
        }
        catch(Exception io)
        {
            io.printStackTrace();
        }*/
    }



}
