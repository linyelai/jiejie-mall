import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.order.Application;
import com.jiejie.mall.order.model.OrderInfo;
import com.jiejie.mall.order.request.AddOrderRequest;
import com.jiejie.mall.order.service.OrderService;
import junit.framework.TestCase;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author linseven
 * @Date 2020/5/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})// 指定启动类
public class OrderTest {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.order",check = false)
    private  OrderService orderService;

    @Test
    public void testTwo(){
        //

    }

    @Before
    public void testBefore(){
        System.out.println("before");
    }

    @After
    public void testAfter(){
        System.out.println("after");
    }


}
