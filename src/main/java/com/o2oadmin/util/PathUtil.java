package com.o2oadmin.util;

public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath() {

        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "E:/bishe/image";
        } else {
            basePath = "/home/bishe/image";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
        public static String getShopImagePath ( long shopId){
            String imagePath = "/upload/item/shop/" + shopId + "/";
            return imagePath.replace(" /", seperator);
        }
    public static String getUserImagePath ( long userId){
        String imagePath = "/upload/item/user/" + userId + "/";
        return imagePath.replace(" /", seperator);
    }
    public static String getlineImagePath (){
        String imagePath = "/upload/item/headline/";
        return imagePath.replace(" /", seperator);
    }

}

