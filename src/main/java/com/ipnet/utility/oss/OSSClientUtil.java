package com.ipnet.utility.oss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.ipnet.utility.oss.OSSClassConstant.bucketName;

@Service
public class OSSClientUtil{

    private ZipInputStream  zipIn;      //解压Zip
    private ZipEntry zipEntry;
    private byte[] buf;
    private int readedBytes;

    private static String ENDPOINT;
    private static String AccessKeyId;
    private static String AccessKeySecret;
    private static String BucketName;
    private static String FileSeparator;

    private OSSClient ossClient;

    static {
        ENDPOINT= OSSClassConstant.endpoint;
        AccessKeyId=OSSClassConstant.accessKeyId;
        AccessKeySecret=OSSClassConstant.accessKeySecret;
        BucketName=OSSClassConstant.bucketName;
        FileSeparator=File.separator;
    }

    public OSSClientUtil(){
        this.init();
    }

    /*
     * 初始化
     */
    public void init(){
        ossClient=new OSSClient(ENDPOINT,AccessKeyId,AccessKeySecret);
        this.buf=new  byte[512];
    }

    /**
     * 销毁
     */
    public void destroy(){
        ossClient.shutdown();
    }

    public String uploadPicture(String projectID,String filename,String base64){
        //截取出图片类型
        int end=base64.indexOf(";base64");
        String type=base64.substring(11,end);
        base64=base64.substring(end+8);
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes1 = decoder.decode(base64);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes1);
        int sepatator=filename.lastIndexOf(".");
        return this.uploadFile(inputStream,projectID+FileSeparator+filename.substring(0,sepatator)+"."+type);
    }




    /**
     * 上传到OSS服务器  如果同名文件会覆盖服务器上的
     * @param inputStream 文件流
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFile(InputStream inputStream, String fileName) {
        String ret = "";
        String url="";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(inputStream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getContentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            //上传文件
            PutObjectResult putResult = ossClient.putObject(BucketName,fileName, inputStream, objectMetadata);
            ret = putResult.getETag();
            url = BucketName+"."+ENDPOINT+"/"+fileName;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(ret.equals("")){
            return "上传失败";
        }else{
            return url;
        }
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     */
    private static String getContentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    public String upLoad(File file){


        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=format.format(new Date());

        // 判断文件
        if(file==null){
            return null;
        }
        OSSClient client=new OSSClient(this.ENDPOINT, this.AccessKeyId, this.AccessKeySecret);
        try {
            // 判断容器是否存在,不存在就创建
            if (!client.doesBucketExist(this.BucketName)) {
                client.createBucket(this.BucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(this.BucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                client.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = (file.getName());
            // 上传文件
            PutObjectResult result = client.putObject(new PutObjectRequest(this.BucketName, fileUrl, file));
            // 设置权限(公开读)
            client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if (result != null) {
                return "https:"+FileSeparator+BucketName+"."+ENDPOINT+FileSeparator+fileUrl;
            }
        } catch (OSSException oe){

    }catch (ClientException ce){

    }finally{
        if(client!=null){
            client.shutdown();
        }
    }
        return null;
    }
}
