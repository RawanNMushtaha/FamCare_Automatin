/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import driver.ClientDriver;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Quit {

    @Test
    public void quit() {
        try {
            ClientDriver.driver.quit();
            System.out.println("Quit driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
