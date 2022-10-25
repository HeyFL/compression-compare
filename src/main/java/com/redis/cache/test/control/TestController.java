package com.redis.cache.test.control;

import com.redis.cache.test.serializer.TestSerizlizer;
import com.redis.cache.test.serializer.mydto.OperationWaybill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.ScreenUpdateManager;

import java.io.IOException;

@RestController
public class TestController {
    @Autowired
    private TestSerizlizer testSerizlizer;
    private static int SUM = 10000;

    @PostMapping("/testFst")
    public boolean testFst(@RequestBody OperationWaybill operationWaybill) {
        testSerizlizer.testFst(operationWaybill);
        return true;
    }
    @PostMapping("/testSnappy")
    public boolean testSnappy(@RequestBody OperationWaybill operationWaybill) {
        try {
            testSerizlizer.testSnappy(operationWaybill);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    @PostMapping("/testKryo")
    public boolean testKryo(@RequestBody OperationWaybill operationWaybill) {
        testSerizlizer.testKryo(operationWaybill);
        return true;
    }
    @PostMapping("/sourceJSON")
    public boolean sourceJSON(@RequestBody OperationWaybill operationWaybill) {
        testSerizlizer.sourceJSON(operationWaybill);
        return true;
    }
    @PostMapping("/testFstWithOutRedis")
    public boolean testFstWithOutRedis() {

        testSerizlizer.testFstWithOutRedis();
        return true;
    }
    @PostMapping("/testSnappyWithOutRedis")
    public boolean testSnappyWithOutRedis(@RequestBody OperationWaybill operationWaybill) {
        try {

                testSerizlizer.testSnappyWithOutRedis();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @PostMapping("/sourceJSONWithOutRedis")
    public boolean sourceJSONWithOutRedis(@RequestBody OperationWaybill operationWaybill) {

            testSerizlizer.sourceJSONWithOutRedis();
        return true;
    }
    @PostMapping("/emptyRedis2")
    public boolean emptyRedis2() {
        testSerizlizer.emptyRedis2();
        return true;
    }
}
