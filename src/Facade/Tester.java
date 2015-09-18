/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Andreas
 */
public class Tester {

    public static void main(String[] args) throws ParseException {
        Facade f = new Facade();
        f.createPerson("Hans","Hansen","01-01-1990",25,false);
        f.createStudent(11,"10-10-1991","Anders","Andersen","1985",30,false);
    }
}
