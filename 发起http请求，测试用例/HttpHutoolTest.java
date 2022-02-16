package com.lsd.test;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;

/**
 * 基于hutool的发起的http请求，测试用例
 */
public class HttpHutoolTest {


    @Test
    public void testGet() {
        // 自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result1 = HttpUtil.get("https://www.baidu.com");
        System.out.println(result1);
        // 当无法识别页面编码的时候，可以自定义请求页面的编码
        String result2 = HttpUtil.get("https://www.baidu.com", CharsetUtil.CHARSET_UTF_8);
        System.out.println(result2);
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String result3 = HttpUtil.get("https://www.baidu.com", paramMap);
        System.out.println(result3);
    }

    @Test
    public void testPost() {
        String body = "{\n" +
                "\"username\":\"测试0\",\n" +
                "\"password\":\"zhou123\"\n" +
                "\n" +
                "}";
        String result = HttpUtil.post("http://8.131.253.252:8000/home/login", body);
        System.out.println(result);
    }


}
