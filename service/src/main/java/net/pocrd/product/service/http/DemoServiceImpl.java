package net.pocrd.product.service.http;

import net.pocrd.define.Evaluater;
import net.pocrd.dubboext.DubboExtProperty;
import net.pocrd.entity.ApiReturnCode;
import net.pocrd.entity.ServiceException;
import net.pocrd.entity.ServiceRuntimeException;
import net.pocrd.product.api.DemoService;
import net.pocrd.product.dao.entity.DemoDTO;
import net.pocrd.product.entity.DemoEntity;
import net.pocrd.product.entity.DemoEnum;
import net.pocrd.util.EvaluaterProvider;
import net.pocrd.util.RawString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServiceImpl implements DemoService {
    private static final Logger    logger    = LoggerFactory.getLogger(DemoServiceImpl.class);
    private static final Evaluater evaluater = EvaluaterProvider.getEvaluater(DemoEntity.class, DemoDTO.class);
    //@Autowired
    //private DemoDTOMapper demoDTOMapper;

    /**
     * 边界异常处理
     *
     * @param name
     *
     * @throws ServiceException
     */
    @Override
    public DemoEntity sayHello(String name) {
        DemoEntity result = null;
        result = new DemoEntity();
        result.id = 1;
        result.name = name;
        return result;
    }

    @Override
    public DemoEntity testMock(String name) {
        return null;
    }

    @Override
    public DemoEntity testShortCircuit(String name) {
        return null;
    }

    @Override
    public DemoEntity tryError(String in) {
        throw new ServiceRuntimeException(ApiReturnCode.API_UPGRADE, "try error!");
    }

    @Override
    public String testRegistedDevice() throws ServiceException {
        return "testRegistedDevice";
    }

    @Override
    public String testUserLogin() {
        DubboExtProperty.ClientCaller caller = DubboExtProperty.getClientCallerFromAttachment();
        System.out.println("deviceId:" + caller.deviceId + ", userId:" + caller.userId);
        return "deviceId:" + caller.deviceId + ", userId:" + caller.userId;
    }

    @Override
    public String getResByThirdPartyId(String thirdPartyId, String something) {
        System.out.println("something:" + something);
        return something;
    }

    @Override
    public RawString testRedirect(DemoEnum something, String other) {
        DubboExtProperty.setRedirectUrl("http://www.fengqu.com/info.api");
        return new RawString("testRedirect");
    }

    @Override
    public String testIgnoreParameterForSecurity(String something) {
        System.out.println("something:" + something);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
