package org.firstinspires.ftc.teamcode;

/**
 * Created by hfu on 5/20/17.
 */

public class PIDOptimizer {

    protected double prevError = 0.0;
    protected double integral = 0.0;
    protected long lastTimeStamp = 0;

    protected double factorP = 0;
    protected double factorI = 0;
    protected double factorD = 0;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    public void setSensitivity(double p, double i, double d) {
        factorP = p;
        factorI = i;
        factorD = d;
    }

    public void start(double startError) {
        lastTimeStamp = System.currentTimeMillis();
        prevError = startError;
    }

    public double loop (double errorV) {
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - lastTimeStamp;
        lastTimeStamp = currentTime;

        integral += errorV * deltaTime;
        double derivative = (errorV - prevError) / deltaTime;
        return factorP*errorV + factorI*integral + factorD*derivative;
    }
}
