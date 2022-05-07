/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhx
 * @version Main.java, v 0.1 2018-07-18 上午 10:19
 */
public class Main {
    //运行方法一
    public static void main(String[] args) {
        args = new String[] { "-configfile", "/Users/chenhx/Desktop/github/generator-demo/generator-demo-dao/src/main/resources/generatorConfig.xml", "-overwrite" };
        ShellRunner.main(args);
    }

    //运行方法二
//    public static void main(String[] args) throws Exception {
//        File configFile = new File("/Users/chenhx/Desktop/github/generator-demo/generator-demo-dao/src/main/resources/generatorConfig.xml");
//        List<String> warnings = new ArrayList<String>();
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(true);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
//    }

}
