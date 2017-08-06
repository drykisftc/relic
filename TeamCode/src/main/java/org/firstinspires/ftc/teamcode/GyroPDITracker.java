package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class GyroPDITracker extends Tracker {

    ModernRoboticsI2cGyro gyro = null;

    private DcMotor leftWheel = null;
    private DcMotor rightWheel = null;

    private PIDOptimizer pid = null;

    private double targetHeading =0;

    private int landMarkPosition = 0;
    private int landMarkAngle = 0;

    public GyroPDITracker(ModernRoboticsI2cGyro leftO,
                          DcMotor leftW,
                          DcMotor rightW,
                          double pFactor,
                          double iFactor,
                          double dFactor){
        gyro = leftO;
        leftWheel = leftW;
        rightWheel = rightW;
        pid = new PIDOptimizer();
        pid.setSensitivity(pFactor,iFactor,dFactor);
    }

    /*
     * Code to run ONCE when the driver hits INIT
     */
    public void init() {
        if (reporter != null) {
            reporter.addData("GyroTracker", "init....");
        }
        gyro.calibrate();
        state =0;
    }

    @Override
    public void start (int state ) {
        super.start(state);
        int lD = leftWheel.getCurrentPosition();
        int rD = rightWheel.getCurrentPosition();
        landMarkPosition = Math.min(lD, rD);
        landMarkAngle = gyro.getHeading();
        pid.start(0.0d);
    }

    public void setLandMarkAngle (int angle) {
        landMarkAngle = angle;
    }

    public void setLandMarkPosition ( int position) {
        landMarkPosition = position;
    }

    /**
     *
     * @param target heading
     * @param power moving power
     * @return true if no heading correction
     */
    public boolean maintainHeading(double target, double power) {

        boolean boolNoTurning = false;

        targetHeading = VortexUtils.normalizeHeading(target);
        int heading = gyro.getHeading();
        double delta = VortexUtils.getAngleError(targetHeading, heading);

        // compute power delta
        double deltaPower = pid.loop(delta);
        leftWheel.setPower(Range.clip(power - deltaPower, -1, 1));
        rightWheel.setPower(Range.clip(power + deltaPower, -1, 1));

        // move motor
        if ( deltaPower  ==  0.0) {
            boolNoTurning = true;
        }

        if (reporter != null) {
            reporter.addData("Heading angle       =", "%3d", heading);
            reporter.addData("Heading target      =", "%.3f", targetHeading);
            reporter.addData("Heading delta       =", "%.2f", delta);
            reporter.addData("Heading tolerance   =", "%.2f", skewTolerance);
            reporter.addData("Heading power       =", "%.2f", power);
            reporter.addData("Heading delta power =", "%.2f", deltaPower);
            reporter.addData("Heading gain        =", "%.2f", skewPowerGain);
            reporter.addData("Minimum turn power  =", "%.2f", minTurnPower);
        }

        return boolNoTurning;
    }

    public int goStraight ( double heading, double gain, double power,
                            int deltaDistance,
                            int startState, int endState) {
        // get motor distance
        int lD = leftWheel.getCurrentPosition();
        int rD = rightWheel.getCurrentPosition();
        int d = Math.min(lD, rD);

        if ( d - landMarkPosition < deltaDistance) {
            skewPowerGain = gain;
            maintainHeading(heading, power);
            return startState;
        }
        // go to next state
        landMarkPosition = d;
        leftWheel.setPower(0.0);
        rightWheel.setPower(0.0);
        return endState;
    }

    public int turn ( double heading, double sensitivity, double power,
                      int startState, int endState) {
        skewPowerGain = sensitivity;
        if (maintainHeading(heading, power) != true) {
            return startState;
        }
        /* got to next state */
        leftWheel.setPower(0.0);
        rightWheel.setPower(0.0);
        int lD = leftWheel.getCurrentPosition();
        int rD = rightWheel.getCurrentPosition();
        landMarkPosition = Math.min(lD, rD);
        return endState;
    }

    public int getWheelLandmarkOdometer () {
        int lD = leftWheel.getCurrentPosition();
        int rD = rightWheel.getCurrentPosition();
        int d = Math.min(lD, rD);
        return d- landMarkPosition;
    }

    public void setWheelLandmark () {
        int lD = leftWheel.getCurrentPosition();
        int rD = rightWheel.getCurrentPosition();
        int d = Math.min(lD, rD);
        landMarkPosition = d;
    }


}
