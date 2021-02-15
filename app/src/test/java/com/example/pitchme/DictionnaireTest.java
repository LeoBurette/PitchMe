package com.example.pitchme;

import com.example.pitchme.word.Dictionnaire;

import org.junit.Test;
import static org.junit.Assert.*;

public class DictionnaireTest {
    @Test
    public void testNoSpecialCaractere(){
        Boolean ok = true;
        Dictionnaire dictionnaire = Dictionnaire.getInstance();
        for(int i = 0; i < dictionnaire.getNumberWord(); i++){
            String s = dictionnaire.getRandomWord();
            System.out.printf(s);
            if(s.contains("\\|")){
                ok = false;
            }
        }
        assertTrue(ok);
    }
}
