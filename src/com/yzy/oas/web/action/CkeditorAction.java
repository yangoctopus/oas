package com.yzy.oas.web.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

@Controller
@Scope("prototype")
public class CkeditorAction extends BaseAction{
    private File upload;
    private String uploadFileName;
    private String uploadFileContentType;

    private InputStream inputStream;

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String uploadFile(){
        String callback= ServletActionContext.getRequest().getParameter("CKEditorFuncNum");
        try{
            String ext=uploadFileName
                    .substring(uploadFileName.lastIndexOf("."));
            String newName= UUID.randomUUID()
                    .toString().replace("-","")+ext;

            //获得服务器上目录的绝对路径
            String path=ServletActionContext
                    .getServletContext().getRealPath("/upload");
            //创建File对象
            File file=new File(path,newName);
            //将上传的文件保存到服务器的目录下
            FileUtils.copyFile(upload,file);

            String uri="upload/"+newName;

            StringBuffer sb=new StringBuffer();
            sb.append("<script type=\"text/javascript\">");
            //sb.append("alert('xxxxxxxxxxxxxxxxx');");
            sb.append("window.parent.CKEDITOR.tools.callFunction("+callback+",'"+uri+"','');");
            sb.append("</script>");


            this.inputStream=new ByteArrayInputStream(sb.toString().getBytes());
            //ServletActionContext.getResponse().getWriter().write(sb.toString());

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return "ckeditor";
        //return null;
    }

}

