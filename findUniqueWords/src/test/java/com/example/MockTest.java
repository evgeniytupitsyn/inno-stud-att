package com.example;

import com.example.streams.StreamReader;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.cglib.proxy.InvocationHandler;
import org.mockito.cglib.proxy.Proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by evgeniytupitsyn on 11/11/2016.
 */
public class MockTest {

    private com.example.streams.Mock mock;

    @Before
    public void resetFields(){
        this.mock = new com.example.streams.Mock();
        /*this.mock.setStreamReader(new StreamReader() {
            @Override
            public String read(long id) {
                if(id == 5)
                    return "Object";
                throw new RuntimeException();
            }
        });*/

        /*this.mock.setStreamReader((StreamReader) Proxy.newProxyInstance(this.mock.getClass().getClassLoader(),
                new Class[]{StreamReader.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if((long) args[0] == 5) {
                            return "Object";
                        }
                        throw new RuntimeException();
                    }
                }));*/

        StreamReader streamReader = mock(StreamReader.class);
        when(streamReader.read(5)).thenReturn("Object");
        this.mock.setStreamReader(streamReader);
    }
   // @Ignore
    @Test
    public void testCalculate(){

        String result = this.mock.calculate(5l);
        assertEquals(result, "calculated Object");
    }
}