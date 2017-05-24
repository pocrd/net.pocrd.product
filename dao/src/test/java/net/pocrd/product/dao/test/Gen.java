package net.pocrd.product.dao.test;

import org.mybatis.generator.api.ShellRunner;

/**
 * @author guankaiqiang
 * @date 2017/5/24
 */
public class Gen {
    public static void main(String[] args) {
        args = new String[3];
        args[0] = "-configfile";
        Gen.class.getResource("/");
        String configRootPath = Gen.class.getResource("/").getPath();
        args[1] = configRootPath + "gen.xml";
        args[2] = "-overwrite";
        ShellRunner.main(args);
    }
}
