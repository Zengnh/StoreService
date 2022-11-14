package com.store.storeservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;


@EnableScheduling//定时任务
@Component
@MapperScan({"com.store.storeservice.dao"})//数据库dao 类，查询所有数据
@EnableTransactionManagement
@SpringBootApplication
public class StoreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreServiceApplication.class, args);
    }

    @Bean
    public Bride bride() {
        return new Bride();
    }

    public class Bride {
        private String name;
        public int count;
        public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : HH mm ss");

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }


//        域	是否必填	值以及范围	通配符
//       1 秒	是	0-59	, - * /
//       2 分	是	0-59	, - * /
//       3 时	是	0-23	, - * /
//       4 日	是	1-31	, - * ? / L W
//       5 月	是	1-12 或 JAN-DEC	, - * /
//       6 周	是	1-7 或 SUN-SAT	, - * ? / L #
//       7 年	否	1970-2099	, - * /

//        (2) 说明
//        描述：写在cron表达式的标识符位置用于表达特定意义的字符，如 例1 中的：0,2,*,？
//
//        阿拉伯数字：数值，出现在标识符位置的数字代表对应值，比如第一个2代表两点，第二个2代表二号
//
//* ：通配，语义相当于每… 比如第五个位置的 *就表示每月都会执行(相当于1-12)
//
//? ：忽略，语义相当于不管… 比如第六个位置的?就表示不管当前是周几就会执行。至于为什么会有这种用法，我觉得应该是因为它和其他的字符可能会冲突。如果用*的话表示周一到周日都会执行，此时其他语义就不明确了，所以如果用不上星期的话一般给它用一个?表示 not care。
//
//                / ：间隔，语义相当于每隔… 比如例2中的第三个位置的2/5就表示从2点开始每隔五小时
//
//- ：区间，语义相当于第…到…的每… 比如例2中的第二个位置的15-20就表示第15分钟到20分钟之间的每分钟
//
//, ：枚举，语义相当于第…和… 比如例2中的第一个位置的15,20,40就表示第15秒、20秒和40秒
//
//        L ：最后(last)，语义相当于最后一个 比如例2中的第四个位置的L就表示最后一天
//
//        W ：工作日，字面意思，就是工作日 比如例3中的第四个位置的15W表示15号附近最近的工作日，如果15号刚好是工作日那就15号触发，如果15号是周六那就14号触发，如果15号是周日那就16号触发。前面不带数字就是所有匹配的工作日。
//
//                # ：周定位，语义相当于每月的第几个周几 比如例4中的第六个位置的2#3就表示第三个周一。


        //        每5秒执行一次
        @Scheduled(cron = "0/5 * * * * ?")
        public void scheduleTime() {
//            System.out.println("###############执行定时任务##################");
        }
    }

}
