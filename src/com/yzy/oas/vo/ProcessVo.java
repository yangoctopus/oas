package com.yzy.oas.vo;

import java.io.File;

public class ProcessVo {
    private File zip;
    private String zipFileName;
    private String zipFileContentType;

    public File getZip() {
        return zip;
    }

    public void setZip(File zip) {
        this.zip = zip;
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    public String getZipFileContentType() {
        return zipFileContentType;
    }

    public void setZipFileContentType(String zipFileContentType) {
        this.zipFileContentType = zipFileContentType;
    }
}
