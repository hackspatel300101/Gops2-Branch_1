package com.example.chintu.Gops.WEbService;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by KEYURN on 24-Jun-18.
 */

public class Utils {


    //Find File Name
    public String findName(String fileName) {
        String filenameArray[] = fileName.split("/");
        return filenameArray[filenameArray.length - 1];
    }


    public String getMIMEType(String filePath) {
        if (filePath.toString().contains(".doc") || filePath.toString().contains(".docx")) {
            // Word document
            return "application/msword";
        } else if (filePath.toString().contains(".pdf")) {
            // PDF file
            return "application/pdf";
        } else if (filePath.toString().contains(".ppt") || filePath.toString().contains(".pptx")) {
            // Powerpoint file
            return "application/vnd.ms-powerpoint";
        } else if (filePath.toString().contains(".xls") || filePath.toString().contains(".xlsx")) {
            // Excel file
            return "application/vnd.ms-excel";
        } else if (filePath.toString().contains(".zip") || filePath.toString().contains(".rar")) {
            // WAV audio file
            return "application/x-wav";
        } else if (filePath.toString().contains(".rtf")) {
            // RTF file
            return "application/rtf";
        } else if (filePath.toString().contains(".wav") || filePath.toString().contains(".mp3")) {
            // WAV audio file
            return "audio/x-wav";
        } else if (filePath.toString().contains(".gif")) {
            // GIF file
            return "image/gif";
        } else if (filePath.toString().contains(".jpg")) {
            return "image/jpg";
        } else if (filePath.toString().contains(".jpeg")) {
            // JPG file
            return "image/jpeg";
        } else if (filePath.toString().contains(".png")) {
            return "image/png";
        } else if (filePath.toString().contains(".txt")) {
            // Text file
            return "text/plain";
        } else if (filePath.toString().contains(".3gp") || filePath.toString().contains(".mpg") || filePath.toString().contains(".mpeg") || filePath.toString().contains(".mpe") || filePath.toString().contains(".mp4") || filePath.toString().contains(".avi")) {
            // Video files
            return "video/*";
        } else {
            //if you want you can also define the intent type for any other file

            //additionally use else clause below, to manage other unknown extensions
            //in this case, Android will show all applications installed on the device
            //so you can choose which application to use
            return Consts.MIME_DEFAULT;
        }

    }

    public boolean isValidString(String checkString) {
        return checkString != null && !checkString.isEmpty();
    }

    public String findNameRig(String fileName) {
        /*String fileExtensionArray[] = fileName.split("\\.");
        String extension = fileExtensionArray[fileExtensionArray.length-1];
        System.out.println(extension);*/


        String filenameArray[] = fileName.split("/");
        String name = filenameArray[filenameArray.length - 1];
        String filExtension[] = name.split("\\.");

        Bitmap bitmap = BitmapFactory.decodeFile(fileName);
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        bitmap.recycle();
        name = "FILE_" + width + "_" + height;
        //name=name+"."+extension;
        name += "." + filExtension[filExtension.length - 1];
        return name;
    }

}
