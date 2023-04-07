package com.store.storeservice.utils;

import java.io.File;

public class ToolFile {
    public final static String classPath;
    /**
     * 获取的是classpath路径，适用于读取resources下资源
     */
    static {
        classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    private static String RootPath(String u_path) {
        String rootPath = "";
        //windows下
        if ("\\".equals(File.separator)) {
            //System.out.println(classPath);
            rootPath = classPath + u_path;
            rootPath = rootPath.replaceAll("/", "\\\\");
            if (rootPath.substring(0, 1).equals("\\")) {
                rootPath = rootPath.substring(1);
            }
        }
        //linux下
        if ("/".equals(File.separator)) {
            //System.out.println(classPath);
            rootPath = classPath + u_path;
            rootPath = rootPath.replaceAll("\\\\", "/");
        }
        return rootPath;
    }
}
