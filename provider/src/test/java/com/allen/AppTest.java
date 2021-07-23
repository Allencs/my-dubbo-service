package com.allen;

import static org.junit.Assert.assertTrue;

import com.allen.model.PersonInfo;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );

        PersonInfo personInfo = new PersonInfo();
        personInfo.setCode(200);
        personInfo.setProtocol("Dubbo");
        personInfo.setMessage("This is Dubbo Service.");

        System.out.println(personInfo);
    }
}
