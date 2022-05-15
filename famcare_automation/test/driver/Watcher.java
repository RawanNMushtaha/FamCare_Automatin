package driver;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ibrahim
 */
public class Watcher extends TestWatcher {

    private final Shot shot;

    public Watcher(WebDriver driver) {
        shot = new Shot(driver);
//        JFrame frame = new JFrame();
//        frame.setSize(600, 400);
//        frame.show();
    }

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
        System.out.print(" -> **Failed**");
        // highlight element
        shot.setDescription(description);
        shot.snapError();

    }

    @Override
    protected void finished(Description description) {
        super.finished(description);
        System.out.println(" -> Finished");
    }

    @Override
    protected void succeeded(Description description) {
        super.succeeded(description);
        System.out.print(" -> Succeeded");
    }

    @Override
    protected void starting(Description description) {
        super.starting(description);
        System.out.print(description.getClassName() + "." + description.getMethodName() + " Started");
    }

}
