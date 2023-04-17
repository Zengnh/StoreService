package com.store.storeservice.controller;

import com.store.storeservice.base.Result;
import com.store.storeservice.utils.QRCodeUtil;
import com.store.storeservice.utils.ToolFile;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.util.Enumeration;

@Api(tags = "系统相关内容")
@RestController
//@RequestMapping(value = "/api",produces="application/json;charset=UTF-8")
//@RequestMapping(value = "/api",produces="text/html; charset=UTF-8")
@RequestMapping(value = "/system")
public class SystemController {
    private static String qrCode = "";

    static {
        try {
            String parent = ToolFile.classPath + "/static/image/ipQrCodePath/";
            File file = new File(parent);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] files = file.listFiles();
            for (File sub : files) {
                sub.delete();
            }
            String hostAddress = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8082";
            String qrCodeName = QRCodeUtil.encode(hostAddress, ToolFile.classPath + "/static/image/ipQrCodePath", false);
            qrCode = parent + qrCodeName;

            File fileRename = new File(qrCode);
            File fileNew = new File(parent + "storeIpName.jpg");
            boolean succ = fileRename.renameTo(fileNew);
            if (succ) {
                qrCode = fileNew.getPath();
            }
        } catch (UnknownHostException e) {
            System.out.println("msg:" + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("msg:" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public SystemController() {
//        String text = "你好";
//        int width = 100;
//        int height = 100;
//        String format = "png";
//        Hashtable hints= new Hashtable();
//        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
//        File outputFile = new File("new.png");
//        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

    }

    @ApiOperation("获取ip地址跟端口号")
    @ResponseBody
    @GetMapping(value = {"/ipConfig"}, produces = "application/json;charset=UTF-8")
    public Result<String> getServiceIpConfig() throws UnknownHostException {
        String hostAddress = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8082";
        System.out.println(hostAddress);//192.168.1.55
        return Result.succeed(hostAddress);
    }

    @ApiOperation("获取图片Image")
    @ResponseBody
    @GetMapping(value = {"/imageView"}, produces = "application/json;charset=UTF-8")
    public void getServiceImage(HttpServletResponse response) throws Exception {

//        File file = new File(ToolFile.classPath + "/static/image/ipImage.png");
        File file = new File(qrCode);
        //        测试字体库
        OutputStream os = null;
        InputStream is;
        try {
            os = response.getOutputStream();
            is = new FileInputStream(file);

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) > 0) {
                os.write(bytes, 0, len);
//                os.write("发送完成".getBytes());
            }
            is.close();
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * This method is used to get ip address by network interface's name.
     *
     * @param networkInterfaceName network interface's name
     * @return return true if get ip address successfully,
     * otherwise return false.
     */
    public static boolean getIpAddrByName(String networkInterfaceName) {
        try {
            //get network interface by name
            NetworkInterface networkInterface = NetworkInterface.getByName(networkInterfaceName);
            if (networkInterface == null) {
                return false;
            }
            System.out.println("network interface: " + networkInterface.getDisplayName());
            InetAddress ipAddress = null;
            //get all ip addresses band to this interface
            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ipAddress = addresses.nextElement();
                if (ipAddress != null && ipAddress instanceof Inet4Address) {
                    System.out.println("ip address: " + ipAddress.getHostAddress());
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return true;
    }// end method getIpAddrByName

}