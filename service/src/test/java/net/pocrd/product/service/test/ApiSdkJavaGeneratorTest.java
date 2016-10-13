package net.pocrd.product.service.test;

import net.pocrd.product.api.DemoMockService;
import net.pocrd.product.api.DemoService;
import net.pocrd.product.mock.MockServiceImpl;
import net.pocrd.product.service.http.DemoServiceImpl;
import net.pocrd.core.ApiManager;
import net.pocrd.core.generator.ApiSdkJavaGenerator;
import net.pocrd.entity.ApiMethodInfo;
import org.junit.Test;

import java.util.List;

/**
 * Created by guankaiqiang521 on 2014/9/29.
 */
public class ApiSdkJavaGeneratorTest {
    @Test
    public void testJavaGenertor() {
        List<ApiMethodInfo> infoList = ApiManager.parseApi(DemoService.class, new DemoServiceImpl());
        infoList.addAll(ApiManager.parseApi(DemoMockService.class, new MockServiceImpl()));

        new ApiSdkJavaGenerator.Builder().setPackagePrefix("net.pocrd.m.app.client")
                .setOutputPath("/home/admin/autogen")
                .build().generateViaApiMethodInfo(infoList);
    }
}
