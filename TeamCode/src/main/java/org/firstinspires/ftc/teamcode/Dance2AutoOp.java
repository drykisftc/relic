/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * This file provides basic Telop driving for a Pushbot robot.
 * The code is structured as an Iterative OpMode
 *
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwareVortex class.
 *
 * This particular OpMode executes a basic Tank Drive Teleop for a PushBot
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="DanceClap:", group="Dance2")
public class Dance2AutoOp extends VortexAutoOp {

    protected int headPositionA = 2500;
    protected int headPositionB = 2800;
    protected int headPositionC = 3000;
    int danceState = 0;
    int danceBeats = 556;
    double headPower = 0.4;
    double armSpeed = 2.0;
    long lastTimeStamp;
    int wheelState  =0;
    int elevatorPosition = 0;
    int fireworkPosition = 4000;

    @Override
    public void start() {
        super.start();
        headB(0.35);
        lastTimeStamp = System.currentTimeMillis();
        danceState = 0;
        state = 0;
        wheelState = 0;

    }

    protected void dancePatternReset () {
        danceState = 0;
        lastTimeStamp = System.currentTimeMillis();
    }

    protected void armPosition0() {
        leftBeaconArm.setPosition(leftUpHomePosition, leftLowHomePosition);
        rightBeaconArm.setPosition(rightUpHomePosition, rightLowHomePosition);
    }

    protected void armPosition1() {
        leftBeaconArm.setPosition(0.25, 0.0);
        rightBeaconArm.setPosition(0.75, 1.0);
    }

    protected void armPosition2() {
        leftBeaconArm.setPosition(0.625, 0.0);
        rightBeaconArm.setPosition(1.0, 1.0);
    }

    protected void armPosition3() {
        leftBeaconArm.setPosition(0.2, 0.0);
        rightBeaconArm.setPosition(0.375, 1.0);
    }

    protected void armPosition4() {
        leftBeaconArm.setPosition(1.0, 1.0);
        rightBeaconArm.setPosition(0.375, 1.0);
    }

    protected void armPosition5() {
        leftBeaconArm.setPosition(0.625, 0.0);
        rightBeaconArm.setPosition(rightUpHomePosition, rightLowHomePosition);
    }

    protected void armPosition6() {
        leftBeaconArm.setPosition(0.625, 0.0);
        rightBeaconArm.setPosition(0.375, 1.0);
    }

    protected void armPosition7() {
        leftBeaconArm.setPosition(0.2, 0.0);
        rightBeaconArm.setPosition(1.0, 1.0);
    }

    protected void armPosition8() {
        leftBeaconArm.setPosition(0.2, 0.0);
        rightBeaconArm.setPosition(rightUpHomePosition, rightLowHomePosition);
    }

    protected void armPosition9() {
        leftBeaconArm.setPosition(leftUpHomePosition, leftLowHomePosition);
        rightBeaconArm.setPosition(1.0, 1.0);
    }

    protected void armPosition10() {
        leftBeaconArm.setPosition(0.625, 0.0);
        rightBeaconArm.setPosition(rightUpHomePosition, rightLowHomePosition);
    }

    protected void armPosition11() {
        leftBeaconArm.setPosition(leftUpHomePosition, leftLowHomePosition);
        rightBeaconArm.setPosition(0.75, 1.0);
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        telemetry.addData("State:", "%02d", state);
        telemetry.addData("DanceState:", "%02d", danceState);
        telemetry.addData("Current Time: ", "%02d", System.currentTimeMillis() - lastTimeStamp);
        switch (state) {
            case 0:
                if (System.currentTimeMillis() - lastTimeStamp < 4000) {
                    armPosition0();
                } else {
                    state+=100;
                }
                break;
            case 100:
                if (System.currentTimeMillis() - lastTimeStamp < 6000) {
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else {
                    wheelState =0;
                    state+=100 ;
                }
                break;
            case 200:
                if (System.currentTimeMillis() - lastTimeStamp < 8000){
                    armPosition1();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else {
                    wheelState =0;
                    state+=100 ;
                }
                break;
            case 300:
                if (System.currentTimeMillis() - lastTimeStamp < 12000){
                    armPosition2();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else {
                    wheelState =0;
                    state+=100;
                }
                break;
            case 400:
                if (System.currentTimeMillis() - lastTimeStamp < 16000){
                    armPosition3();
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else {
                    wheelState =0;
                    state+=100;
                }
                break;
            case 500:
                if (System.currentTimeMillis() - lastTimeStamp < 17500){
                    armPosition0();
                }else {
                    state+=100;
                }
                break;
            case 600:
                if (System.currentTimeMillis() - lastTimeStamp < 19000){
                    armPosition4();
                    if (wheelState ==0) wheelTurn(0.0, 135);
            } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 700:
                if (System.currentTimeMillis() - lastTimeStamp <20000){
                    armPosition6();
                    if (wheelState ==0) wheelTurn(0.0, 90);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 800:
                if (System.currentTimeMillis() - lastTimeStamp < 22000){
                    armPosition7();
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 900:
                if (System.currentTimeMillis() - lastTimeStamp <24000){
                    armPosition6();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 1000:
                if (System.currentTimeMillis() - lastTimeStamp <26000){
                    armPosition0();
                    if (wheelState ==0) wheelMove(0.5, -300);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 1100:
                if (System.currentTimeMillis() - lastTimeStamp <28000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, -135);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 1200:
                if (System.currentTimeMillis() - lastTimeStamp <32000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 1300: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <34000){
                    armPosition1(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else{
                    state+=1;
                }
                break;
            case 1301: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <34500){
                    armPosition7(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else{
                    state+=1;
                }
                break;
            case 1302: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <35000){
                    armPosition1(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else{
                    state+=1;
                }
                break;
            case 1303: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <35500){
                    armPosition7(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else{
                    wheelState = 0;
                    state=1400;
                }
                break;
            case 1400:  // to do: turn 360
                if (System.currentTimeMillis() - lastTimeStamp <36000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 1401:  // to do: turn 360
                if (System.currentTimeMillis() - lastTimeStamp <37000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, -175);
                } else{
                    wheelState =0;
                    state=1500;
                }
                break;
            case 1500: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <38000){
                    armPosition1(); //the complicated one
                } else{
                    state+=1;
                }
                break;
            case 1501: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <38500){
                    armPosition7(); //the complicated one
                } else{
                    state+=1;
                }
                break;
            case 1502: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <39000){
                    armPosition1(); //the complicated one
                } else{
                    state+=1;
                }
                break;
            case 1503: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <39500){
                    armPosition7(); //the complicated one
                } else{
                    state=1600;
                }
                break;
            case 1600:
                if (System.currentTimeMillis() - lastTimeStamp <39000){
                    armPosition9();
                } else{
                    state+=100;
                }
                break;
            case 1700:
                if (System.currentTimeMillis() - lastTimeStamp <40000){
                    armPosition8();
                } else{
                    state+=100;
                }
                break;
            case 1800:
                if (System.currentTimeMillis() - lastTimeStamp <41000){
                    armPosition11();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState = 0;
                    state+=100;
                }
                break;
            case 1900:
                if (System.currentTimeMillis() - lastTimeStamp <42000){
                    armPosition10();
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 2000:
                if (System.currentTimeMillis() - lastTimeStamp <43000){
                    armPosition4();
                    if (wheelState ==0) wheelTurn(0.0, 45);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 2100:
                if (System.currentTimeMillis() - lastTimeStamp <44000){
                    armPosition6();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 2200:
                if (System.currentTimeMillis() - lastTimeStamp <45000){
                    armPosition5();
                    if (wheelState ==0) wheelTurn(0.0, -45);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 2300:
                if (System.currentTimeMillis() - lastTimeStamp <46000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, -90);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 2400:
                if (System.currentTimeMillis() - lastTimeStamp <47000){
                    if (wheelState ==0) wheelTurn(0.0, -179);
                    armPosition4();
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 2500:
                if (System.currentTimeMillis() - lastTimeStamp <48000){
                    armPosition6();
                } else{
                    state+=100;
                }
                break;
            case 2600:
                if (System.currentTimeMillis() - lastTimeStamp <49000){
                    armPosition1();
                    if (wheelState ==0) wheelTurn(0.0, -90);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 2700:
                if (System.currentTimeMillis() - lastTimeStamp <50000){
                    armPosition7();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState = 0;
                    state+=100;
                }
                break;
            case 2800: // turn 360
                if (System.currentTimeMillis() - lastTimeStamp <52000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    state+=1;
                }
                break;
            case 2801: // turn 360
                if (System.currentTimeMillis() - lastTimeStamp <53000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, -179);
                } else{
                    state=2900;
                }
                break;
            case 2900:
                if (System.currentTimeMillis() - lastTimeStamp <54000){
                    armPosition1();
                    if (wheelState ==0) wheelMove(0.5, -300);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 3000:
                if (System.currentTimeMillis() - lastTimeStamp <56000){
                    armPosition0();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 3100:
                if (System.currentTimeMillis() - lastTimeStamp <58000){
                    if (wheelState ==0) wheelTurn(0.0, 135);
                    armPosition0();
                } else{
                    wheelState = 0;
                    state+=100;
                }
                break;
            case 3200:
                if (System.currentTimeMillis() - lastTimeStamp <60000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 175);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 3300: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <62000){
                    armPosition1(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 90);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 3301: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <62500){
                    armPosition7(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 90);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 3302: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <63000){
                    armPosition1(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 90);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 3303: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <63500){
                    armPosition7(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 90);
                } else{
                    wheelState =0;
                    state=3400;
                }
                break;
            case 3400: // turn 360
                if (System.currentTimeMillis() - lastTimeStamp <64000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 45);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 3401: // turn 360
                if (System.currentTimeMillis() - lastTimeStamp <65000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, -45);
                } else{
                    wheelState =0;
                    state=3500;
                }
                break;
            case 3500: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <66000){
                    armPosition7(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 3501: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <66500){
                    armPosition1(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 3502: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <67000){
                    armPosition7(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 3503: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <67500){
                    armPosition1(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state=3600;
                }
                break;
            case 3600: // turn 360
                if (System.currentTimeMillis() - lastTimeStamp <70000){
                    armPosition7(); //the really complicated one
                    if (wheelState ==0) wheelTurn(0.0, 45);
                } else{
                    wheelState =0;
                    state+=1;
                }
                break;
            case 3601: // turn 360
                if (System.currentTimeMillis() - lastTimeStamp <71000){
                    armPosition7(); //the really complicated one
                    if (wheelState ==0) wheelTurn(0.0, -45);
                } else{
                    wheelState =0;
                    state=3700;
                }
                break;
            case 3700: // turn360 right
                if (System.currentTimeMillis() - lastTimeStamp <72000){
                    if (wheelState ==0) wheelTurn(0.0, -90);
                    armPosition6();
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 3800: // turn 360 left
                if (System.currentTimeMillis() - lastTimeStamp <74000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, -45);
                } else{
                    wheelState= 0;
                    state+=100;
                }
                break;
            case 3900: // turn 360 right
                if (System.currentTimeMillis() - lastTimeStamp <78000){
                    armPosition2();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 4000: // turn 360 left
                if (System.currentTimeMillis() - lastTimeStamp <82000){
                    armPosition3();
                    particleShooter.moveArmToFirePosition();
                    if (wheelState ==0) wheelTurn(0.0, 45);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 4100:
                if (System.currentTimeMillis() - lastTimeStamp <84000){
                    armPosition0();
                } else{
                    state+=100;
                }
                break;
            case 4200:
                if (System.currentTimeMillis() - lastTimeStamp <85000){
                    armPosition11();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else{
                    wheelState = 0;
                    state+=100;
                }
                break;
            case 4300:
                if (System.currentTimeMillis() - lastTimeStamp <86000){
                    armPosition10();
                    particleShooter.cock();
                    if (wheelState ==0) wheelMove(0.5, -300);
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 4400: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <90000){
                    armPosition1(); //the really complicated one
                    if (wheelState ==0) wheelTurn(0.0, 180);
                } else{
                    state+=1;
                    elevatorPosition = robot.motorRightArm.getCurrentPosition();
                }
                break;
            case 4401: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <90500){
                    armPosition7(); //the really complicated one
                } else{
                    state+=1;
                    elevatorPosition = robot.motorRightArm.getCurrentPosition();
                }
                break;
            case 4402: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <91000){
                    armPosition1(); //the really complicated one
                } else{
                    state+=1;
                    elevatorPosition = robot.motorRightArm.getCurrentPosition();
                }
                break;
            case 4403: // clapping 2 times
                if (System.currentTimeMillis() - lastTimeStamp <91500){
                    armPosition7(); //the really complicated one
                } else{
                    state=4500;
                    wheelState =0;
                    elevatorPosition = robot.motorRightArm.getCurrentPosition();
                }
                break;
            case 4500:
                if (System.currentTimeMillis() - lastTimeStamp <92000){
                    armPosition0();
                    if (wheelState ==0) wheelMove(0.5, 300);
                    if (Math.abs(robot.motorRightArm.getCurrentPosition() - elevatorPosition) < fireworkPosition) {
                        robot.motorRightArm.setPower(0.3);
                    } else {
                        robot.motorRightArm.setPower(0.0);
                    }
                } else{
                    wheelState =0;
                    state+=100;
                }
                break;
            case 4600:
                if (System.currentTimeMillis() - lastTimeStamp <94000){
                    armPosition0(); //extend forklift & pop confetti
                    if (Math.abs(robot.motorRightArm.getCurrentPosition() - elevatorPosition) < fireworkPosition) {
                        robot.motorRightArm.setPower(0.3);
                    } else {
                        robot.motorRightArm.setPower(0.0);
                    }
                } else{
                    state+=100;
                }
                break;
            case 4700:
                state = particleShooter.loop(state, state + 1);
                break;
            default:
                dancePatternReset();
                robot.motorRightArm.setPower(0.0);
                robot.motorLeftWheel.setPower(0.0);
                robot.motorRightWheel.setPower(0.0);
                robot.motorLeftArm.setPower(0.0);
                robot.motorLeftHand.setPower(0.0);
                //state = 0; // repeat
                break;
        }
    }

    // wheel dance modes
    public void wheelMove(double power, int distance) {
        wheelState = gyroTracker.goStraight (0, cruisingTurnGain, power, distance, 0,1);
    }

    public void wheelTurn(double turnPower, int heading) {
        wheelState = gyroTracker.turn(heading, inPlaceTurnGain,turnPower,0,1);
    }

    // head dance mode
    public void headA ( double power) {
        VortexUtils.moveMotorByEncoder(robot.motorLeftArm, headPositionA, power);
    }

    public void headB ( double power) {
        VortexUtils.moveMotorByEncoder(robot.motorLeftArm, headPositionB, power);
    }

    public void headC ( double power) {
        VortexUtils.moveMotorByEncoder(robot.motorLeftArm, headPositionC, power);
    }
}
