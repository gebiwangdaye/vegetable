package com.gbwdy.vegetable.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class UploadUtil {

    private static String SOPT = ".";
    public static String getRandomFileName(String fileName){
        String[] names = fileName.split("\\.");
        String contentType = names[names.length-1];
        Random random = new Random();
        String newFileName = System.currentTimeMillis()+"_"+random.nextInt(100) + SOPT + contentType;
        return newFileName;
    }

    public static String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        System.out.println(fileName);
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return "/imgupload/"+fileName;
    }

    public static boolean deleteFile(String fileName){
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
}
