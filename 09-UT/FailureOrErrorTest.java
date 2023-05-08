package put.io.testing.junit;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailureOrErrorTest {

    @Test
    void test1(){
        assertEquals(1, 2);
    }

    @Test
    void test2(){
        throw new ExceptionInInitializerError();
    }

    @Test
    void test3(){
        try{
            assertEquals(1, 2);
        }catch (AssertionError asr){
            asr.printStackTrace();
        }
    }
}
