package com.example.chintu.Gops.WEbService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;


public class DataMultiPart implements Serializable {
    private boolean isRetry = true;
    private String url, filePath, fileParam;
    private String fileDefaultPath;
    private Map<String, String> params;
    boolean isImage = false;
    private ArrayList<String> multiFilePath = new ArrayList<>();
    private ArrayList<String> multiFilePathKey = new ArrayList<>();

    public ArrayList<String> getMultiFilePathKey() {
        return multiFilePathKey;
    }

    public void setMultiFilePathKey(ArrayList<String> multiFilePathKey) {
        this.multiFilePathKey = multiFilePathKey;
    }

    public ArrayList<String> getMultiFilePath() {
        return multiFilePath;
    }

    public void setMultiFilePath(ArrayList<String> multiFilePath) {
        this.multiFilePath = multiFilePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileParam() {
        return fileParam;
    }

    public void setFileParam(String fileParam) {
        this.fileParam = fileParam;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public boolean isRetry() {
        return isRetry;
    }

    public void setRetry(boolean retry) {
        isRetry = retry;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }

    public String getFileDefaultPath() {
        return fileDefaultPath;
    }

    public void setFileDefaultPath(String fileDefaultPath) {
        this.fileDefaultPath = fileDefaultPath;
    }
}
