package com.jiejie.mall.web.util;

import java.io.File;

/**
 * @Author linseven
 * @Date 2020/5/13
 */
public class HDFSCommon {

   /* static public void copyfileToHdfs(Configuration config, String url, File file)
    {
        try {
            FileSystem fs = FileSystem.get(URI.create(url), config);
            Path src = new Path(file.getPath());
            // 要上传到hdfs的目标路径
            Path dst = new Path(url+"/test");
            fs.copyFromLocalFile(src, dst);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/
}
