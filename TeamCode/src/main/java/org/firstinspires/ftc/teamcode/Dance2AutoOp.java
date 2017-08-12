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
    int fireworkPosition = 1000;

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
        leftBeaconArm.setPosition(0.0, 0.0);
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
        leftBeaconArm.setPosition(0.0, 0.0);
        rightBeaconArm.setPosition(1.0, 1.0);
    }

    protected void armPosition8() {
        leftBeaconArm.setPosition(0.0, 0.0);
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
                    if (wheelState ==0) wheelTurn(0.0, 180);
                } else {
                    state +=10;
                    dancePatternReset();
                }
                break;
            case 10:
                if (System.currentTimeMillis() - lastTimeStamp < 2000) {
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 180);
                } else {
                    wheelState =0;
                    state ++ ;
                    dancePatternReset();
                }
                break;
            case 20:
                if (System.currentTimeMillis() - lastTimeStamp < 2000){
                    armPosition1();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else {
                    wheelState =0;
                    state ++ ;
                    dancePatternReset();
                }
                break;
            case 30:
                if (System.currentTimeMillis() - lastTimeStamp < 4000){
                    armPosition2();
                } else {
                    state ++;
                    dancePatternReset();
                }
                break;
            case 40:
                if (System.currentTimeMillis() - lastTimeStamp < 4000){
                    armPosition3();
                } else {
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 50:
                if (System.currentTimeMillis() - lastTimeStamp < 2000){
                    armPosition0();
                }else {
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 60:
                if (System.currentTimeMillis() - lastTimeStamp < 1000){
                    armPosition4();
            } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 70:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition6();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 80:
                if (System.currentTimeMillis() - lastTimeStamp < 2000){
                    armPosition7();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 90:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition6();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else{
                    wheelState =0;
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 100:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                    if (wheelState ==0) wheelMove(0.5, -300);
                } else{
                    wheelState =0;
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 110:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 275);
                } else{
                    wheelState =0;
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 120:
                if (System.currentTimeMillis() - lastTimeStamp <4000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 130:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition1(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 180);
                } else{
                    wheelState =0;
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 140:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 150:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition1(); //the complicated one
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 160:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition9();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 170:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition8();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 180:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition11();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 190:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition10();
                } else{
                    state+=10;
                }
                break;
            case 200:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition4();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 210:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition6();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 220:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition5();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 230:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition0();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 240:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition4();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 250:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition6();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 260:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition1();
                } else{
                    state+=10;

                    dancePatternReset();
                }
                break;
            case 270:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition7();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 280:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 290:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition1();
                    if (wheelState ==0) wheelMove(0.5, -300);
                } else{
                    wheelState =0;
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 300:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else{
                    wheelState =0;
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 310:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 320:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 330:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition1(); //the complicated one
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 340:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 350:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition1(); //the complicated one
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 360:
                if (System.currentTimeMillis() - lastTimeStamp <4000){
                    armPosition7(); //the really complicated one
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 370:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition7();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 380:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 390:
                if (System.currentTimeMillis() - lastTimeStamp <4000){
                    armPosition5();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 400:
                if (System.currentTimeMillis() - lastTimeStamp <4000){
                    armPosition4();
                    particleShooter.moveArmToFirePosition();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 410:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 420:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition11();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 430:
                if (System.currentTimeMillis() - lastTimeStamp <1000){
                    armPosition10();
                    particleShooter.cock();
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 440:
                if (System.currentTimeMillis() - lastTimeStamp <4000){
                    armPosition7(); //the really complicated one
                } else{
                    state+=10;
                    dancePatternReset();
                    elevatorPosition = robot.motorRightArm.getCurrentPosition();
                }
                break;
            case 450:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0();
                    if (Math.abs(robot.motorRightArm.getCurrentPosition() - elevatorPosition) < fireworkPosition) {
                        robot.motorRightArm.setPower(0.2);
                    } else {
                        robot.motorRightArm.setPower(0.0);
                    }
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 460:
                if (System.currentTimeMillis() - lastTimeStamp <2000){
                    armPosition0(); //extend forklift & pop confetti
                    if (Math.abs(robot.motorRightArm.getCurrentPosition() - elevatorPosition) < fireworkPosition) {
                        robot.motorRightArm.setPower(0.2);
                    } else {
                        robot.motorRightArm.setPower(0.0);
                    }
                } else{
                    state+=10;
                    dancePatternReset();
                }
                break;
            case 470:
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
