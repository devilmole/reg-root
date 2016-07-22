package test.reg.http;

import com.devilmole.reg.http.HttpTool;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/22 0022.
 */

public class HttpToolTest {

    @Test
    public void defaultHttpGetTest(){
        System.out.println("TEST");
        HttpTool.defaultHttpGet("https://www.baidu.com/");
    }
}
