package com.example.pitchme;

import com.example.pitchme.word.DataSingleton;

import org.junit.Test;
import static org.junit.Assert.*;

public class DataSingletonTest {
    @Test
    public void testNoSpecialCaractere(){
        Boolean ok = true;
        DataSingleton dataSingleton = DataSingleton.getInstance();
        for(int i = 0; i < dataSingleton.getNumberWord(); i++){
            String s = dataSingleton.getRandomWord();
            System.out.printf(s);
            if(s.contains("\\|")){
                ok = false;
            }
        }
        assertTrue(ok);
    }
}
