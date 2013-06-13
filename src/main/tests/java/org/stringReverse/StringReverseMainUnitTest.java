package org.stringReverse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Rurik
 * Date: 13.06.13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="file:src/main/tests/resources/unittest-context.xml")
public class StringReverseMainUnitTest  {

    private final Map<String, String> testData = new HashMap<String, String>();


    @Autowired
    private StringReverseService stringReverseService;


    public StringReverseService getStringReverseService() {
        return stringReverseService;
    }

    public void setStringReverseService(StringReverseService stringReverseService) {
        this.stringReverseService = stringReverseService;
    }


    @Before
    public void setUpStringReverseTestData() {
        testData.put("a","a");
        testData.put("ab","ba");
        testData.put("abc","cba");
        testData.put("aaa","aaa");
        testData.put("aaa  ","  aaa");
        testData.put("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1","1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        testData.put("","");
        testData.put("{]]}","}]]{");
    }


    @Test
    public void testStringReverse() {

        for (Map.Entry<String, String> entry : testData.entrySet()) {

            String input = entry.getKey();

            String actualOutput = getStringReverseService().getOutput(input);

            String expectedOutput = entry.getValue();

            Assert.assertEquals(expectedOutput, actualOutput);

        }

    }


    @After
    public void clearStringReverseTestData() {
        testData.clear();
    }


}
