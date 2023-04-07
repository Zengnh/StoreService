package com.store.storeservice.controller;

import com.store.storeservice.base.Result;
import com.store.storeservice.bean.db.Center;
import com.store.storeservice.bean.dto.DTOLogin;
import com.store.storeservice.bean.vo.*;
import com.store.storeservice.dao.CenterByTypeToMapper;
import com.store.storeservice.dao.UserMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "商城app接口")
@RestController
//@RequestMapping(value = "/api",produces="application/json;charset=UTF-8")
//@RequestMapping(value = "/api",produces="text/html; charset=UTF-8")
@RequestMapping(value = "/api")
public class AppApiController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CenterByTypeToMapper centerByTypeToMapper;



//    @ResponseBody 返回的是 Content-Type: application/json 類型
    //方法參數前設置@RequestBody 接收的是 Content-Type: application/json 若不加注释则默认是 x-www-form-urlencoded

    // application/json;charset=UTF-8
    @ApiOperation("登录接口")
    @ResponseBody
    @RequestMapping(value = {"/user/login"}, method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public Result<VOUserInfo> login(DTOLogin dto) {
        VOUserInfo login = new VOUserInfo();
        return Result.succeed(login);
    }

    @ApiOperation("登录接口")
    @ResponseBody
    @PostMapping(value = "/user/login4", produces = "application/json;charset=UTF-8")
    public Result<VOUserInfo> loginSecond(
            @RequestParam("mobile") String mobile,
            @RequestParam("password") String password,
            @RequestParam("type") String type
    ) {
        VOUserInfo login = new VOUserInfo();
        return Result.succeed(login);
    }

    @ResponseBody
    @GetMapping("/user/queryMessage")
    public Result<List<AppMessage>> queryMessage() {
        List<AppMessage> data = new ArrayList<>();
        data.add(new AppMessage(1, "系统信息", "08:35", "訂單已發貨，請留意的您的手機，保持暢通單已發貨 請留意的您的手單已發貨，請留意的您的手單已發貨 單已發貨，請留意的您的手單已發貨，請留意的您的 手，請留意的您的手"));
        data.add(new AppMessage(2, "活动消息", "昨天 12:00", "訂單已發貨，請留意的您的手機，保持暢通單已發貨 請留意的您的手單已發貨，請留意的您的手單已發貨 單已發貨，請留意的您的手單已發貨，請留意的您的 手，請留意的您的手"));
        data.add(new AppMessage(3, "物流信息", "2022-10-12 12:00", "訂單已發貨，請留意的您的手機，保持暢通單已發貨 請留意的您的手單已發貨，請留意的您的手單已發貨 單已發貨，請留意的您的手單已發貨，請留意的您的 手，請留意的您的手"));
        data.add(new AppMessage(2, "活动消息", "2022-09-12 12:00", "訂單已發貨，請留意的您的手機，保持暢通單已發貨 請留意的您的手單已發貨，請留意的您的手單已發貨 單已發貨，請留意的您的手單已發貨，請留意的您的 手，請留意的您的手"));
        return Result.succeed(data);
    }

    @ResponseBody
    @PostMapping("/index/category")
    public Result<List<Category>> queryCategory() {
        List<Category> data = new ArrayList<>();
        data.add(new Category("1", "吃", "https://img1.baidu.com/it/u=3070279919,1818701752&fm=253&fmt=auto&app=138&f=JPEG?w=253&h=253"));
        data.add(new Category("2", "穿", "https://img2.baidu.com/it/u=209564283,2938608337&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"));
        data.add(new Category("3", "住", "https://img1.baidu.com/it/u=2468489448,3857594685&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"));
        data.add(new Category("4", "行", "https://img0.baidu.com/it/u=3580594449,1837430210&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"));
        return Result.succeed(data);
    }

    //    @PathVariable("lng")
//    @RequestParam("lat")
//@RequestParam("lat") double lat,@RequestParam("lng") double lng, @RequestParam("category_id") String category_id
    @ResponseBody
    @GetMapping("/index/shops")
    public Result<List<Shops>> shops(@RequestParam("lat") double lat, @RequestParam("lng") double lng, @RequestParam("category_id") String category_i) {
        List<Shops> shopList = new ArrayList<>();
        shopList.add(new Shops("莲花中心", "厦门-湖里区-莲花站旁", "距离10000km", "九五折销售", "15060408223", "https://img2.baidu.com/it/u=3915004664,1688826080&fm=253&fmt=auto&app=138&f=JPG?w=500&h=500"));
        shopList.add(new Shops("宝龙中心", "厦门-湖里区-莲花站旁", "距离20000km", "八八折销售", "15060408223", "https://img0.baidu.com/it/u=2413436585,1583290513&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"));
        shopList.add(new Shops("阿罗海中心", "厦门-湖里区-莲花站旁", "距离10300km", "九折销售", "15060408223", "https://img1.baidu.com/it/u=3750288563,660898866&fm=253&fmt=auto&app=138&f=PNG?w=500&h=500"));
        shopList.add(new Shops("福州中心", "福州-鼓楼-软件园", "距离24000km", "五折销售", "15060408223", "https://img1.baidu.com/it/u=3960030623,2696329822&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"));
        shopList.add(new Shops("厦门中心", "厦门-湖里区-中心", "距离10005km", "四折销售", "15060408223", "https://img1.baidu.com/it/u=1333364903,2046576753&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"));
        shopList.add(new Shops("北京中心", "北京-中心-中心", "距离30303km", "七折销售", "15060408223", "https://img2.baidu.com/it/u=4123596257,3826547768&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=501"));
        return Result.succeed(shopList);
    }

    @ResponseBody
    @GetMapping("/user/getInfo/{id}")
    public Result<VOUserInfo> login(@PathVariable("id") Long id) {
        VOUserInfo login = new VOUserInfo();
        return Result.succeed(login);
    }

    @ResponseBody
    @GetMapping("/user/myCart")
    public Result<StoreCarRoot> myCart() {
        StoreCarRoot storeRoot=new StoreCarRoot();
        storeRoot.setList(new ArrayList<>());
        StoreCarList storeCarList=new StoreCarList();
        storeCarList.setShop_name("厦门中心");
        storeCarList.setShop_id("1111111");
        storeCarList.setList(new ArrayList<>());

        storeCarList.getList().add(new Cart());

        storeRoot.getList().add(storeCarList);
        return Result.succeed(storeRoot);
    }


    @ResponseBody
    @GetMapping("/textConnectDb")
    public Result<String> textConnectDb() throws SQLException {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConofig.class);
//        DataSource d = (DataSource) ac.getBean("dataSource");
//        Connection c = d.getConnection();
//        System.out.println("#####"+c.getClientInfo()+""+c.isClosed());
//        userMapper.countCenter();
//
//       第一种数据库查询完成
        List<Center> count = centerByTypeToMapper.getList();
        System.out.println("#######" + count.size());
        for (Center c : count) {
            System.out.println("centerName=" + c.name);
        }


//        第二种 xml 查询
//        List<Center> centerList = userMapper.selectList(null);
//
//        System.out.println("2#######" + centerList.size());

        int xmlcount = userMapper.countCenter();
        System.out.println("3#######" + xmlcount);
        return Result.succeed("");
    }

    @ApiOperation(value = "储备客户-批量导入保存客户")
    @ApiImplicitParam(value = "上传文件", name = "file", required = true, allowMultiple = true, dataType = "MultipartFile")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 99999, message = "失败")
    })
    @PostMapping(value = "/updateFile")
    @ResponseBody
    public void upFile(@RequestParam(required = false) MultipartFile file) throws IOException {
        // 获得文件名
        String filename = file.getOriginalFilename();
        InputStream input = file.getInputStream();
    }



    @ApiOperation(value = "下载生成图片")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 99999, message = "失败")
    })
    @ResponseBody
    @GetMapping("/testDemo2")
    public void test2(HttpServletResponse response) {
        //        测试字体库
        OutputStream os = null;
        InputStream is ;
        try {
            os = response.getOutputStream();
            is = new FileInputStream(drawableFile());

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

    private File drawableFile(){

        String resource = this.getClass().getClassLoader().getResource("").getPath();

        File emailFile = new File(resource + "/emailtemp/" + System.currentTimeMillis() + ".png");
        if (!emailFile.exists()) {
            try {
                File pathDir = new File(emailFile.getParent());
                if (!pathDir.exists()) {
                    pathDir.mkdirs();
                }
                emailFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int imageWidth = 1200;
        int imageHight = 600;


        BufferedImage bi = new BufferedImage(imageWidth, imageHight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) bi.getGraphics();//得到绘制环境，开始绘画
//        填充一个矩形
        g2.setColor(Color.white);
        g2.fillRect(0, 0, imageWidth, imageHight);
//        绘制图片边框
        g2.setColor(new Color(159, 207, 255));
        g2.drawRect(0, 0, imageWidth - 1, imageHight - 1);

        try {
            g2.setColor(Color.black);
            ClassPathResource fontResource=new ClassPathResource("static/simsun.ttc");

            Font ft=Font.createFont(Font.TRUETYPE_FONT,fontResource.getInputStream());
            ft=ft.deriveFont(Font.PLAIN,16);
            g2.setFont(ft);
            g2.drawString("测试字体abcd01234.k",40,40);
            g2.drawLine(50,50,200,200);
            ft=ft.deriveFont(Font.BOLD,12);
            g2.setFont(ft);
            g2.drawString("12号字体测试测试字体 abcd01234.!@#$%%^,.k",40,70);
            g2.drawString("12号字体测试测试字体2abcd01234.k",40,100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(bi, "PNG", emailFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return emailFile;
    }

}