package com.xt.open.jmall.zuul;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZuulApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testDownloadFile(){
        ResponseEntity<MultipartFile> responseEntity = restTemplate.exchange("http://bkjk-private-dev-1256212241.cos.ap-beijing.myqcloud.com/lego-storage/Credit/credit-jupiter/2hVDwDTu.java?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKID96oFSPHVeXAWnsJJgneEYgY9UZOwBG4c%26q-sign-time%3D1561541242%3B1561541842%26q-key-time%3D1561541242%3B1561541842%26q-header-list%3D%26q-url-param-list%3Dresponse-cache-control%3Bresponse-content-disposition%3Bresponse-content-language%3Bresponse-content-type%3Bresponse-expires%26q-signature%3D5f46c072ccbeffc03c96036de32f82e9c2ba1273&response-cache-control=no-cache&response-content-disposition=inline%3Bfilename%2A%3Dutf-8%27zh_cn%27JackSonUtils.java&response-content-language=zh-CN&response-expires=Thu%2C%2027%20Jun%202019%2009%3A27%3A22%20GMT&response-content-type=application%2Foctet-stream", HttpMethod.GET, null, MultipartFile.class, new HashMap<>());

        System.out.println(responseEntity);
    }
}
