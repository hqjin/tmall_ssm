package com.hqjin.tmall.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisGenerator {
    public static void main(String args[]) throws Exception{
        String today="2018-10-06";//防止明后天误运行，覆盖掉了今天的成果。
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date now=simpleDateFormat.parse(today);//根据给定形式解析字串。
        Date d=new Date();
        if(d.getTime()>now.getTime()+24*60*60*1000){
            System.err.println("——未成功运行——");
            System.err.println("本程序有破坏作用，需修改today日期，如："+simpleDateFormat.format(new Date()));
            return;
        }
        List<String> warnings=new ArrayList<String>();
        boolean overwrite=true;
        InputStream is=MybatisGenerator.class.getClassLoader()
                .getResource("generatorConfig.xml").openStream();//打开XML源
        ConfigurationParser cp=new ConfigurationParser(warnings);
        Configuration config=cp.parseConfiguration(is);//对源is进行解析，警告交给warnings，结果交给config
        is.close();//关闭源
        DefaultShellCallback callback=new DefaultShellCallback(overwrite);
        //利用给定的config配置，callback，warnings，产生MyBatis.
        MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
        myBatisGenerator.generate(null);
        System.out.println("生成代码成功，只运行一次，以后会覆盖掉pojo，mapper，xml等文件");
    }
}
