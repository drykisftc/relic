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
                    state ++;
                }
                break;
            case 1:
                if (System.currentTimeMillis() - lastTimeStamp < 6000) {
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 180);
                } else {
                    wheelState =0;
                    state ++ ;
                }
                break;
            case 2:
                if (System.currentTimeMillis() - lastTimeStamp < 8000){
                    armPosition1();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else {
                    wheelState =0;
                    state ++ ;
                }
                break;
            case 3:
                if (System.currentTimeMillis() - lastTimeStamp < 12000){
                    armPosition2();
                } else {
                    state ++;
                }
                break;
            case 4:
                if (System.currentTimeMillis() - lastTimeStamp < 16000){
                    armPosition3();
                } else {
                    state++;
                }
                break;
            case 5:
                if (System.currentTimeMillis() - lastTimeStamp < 18000){
                    armPosition0();
                }else {
                    state++;
                }
                break;
            case 6:
                if (System.currentTimeMillis() - lastTimeStamp < 19000){
                    armPosition4();
            } else{
                    state++;
                }
                break;
            case 7:
                if (System.currentTimeMillis() - lastTimeStamp <20000){
                    armPosition6();
                } else{
                    state++;
                }
                break;
            case 8:
                if (System.currentTimeMillis() - lastTimeStamp < 22000){
                    armPosition7();
                } else{
                    state++;
                }
                break;
            case 9:
                if (System.currentTimeMillis() - lastTimeStamp <24000){
                    armPosition6();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else{
                    wheelState =0;
                    state++;
                }
                break;
            case 10:
                if (System.currentTimeMillis() - lastTimeStamp <26000){
                    armPosition0();
                    if (wheelState ==0) wheelMove(0.5, -300);
                } else{
                    wheelState =0;
                    state++;
                }
                break;
            case 11:
                if (System.currentTimeMillis() - lastTimeStamp <28000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 275);
                } else{
                    wheelState =0;
                    state++;
                }
                break;
            case 12:
                if (System.currentTimeMillis() - lastTimeStamp <32000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state++;
                }
                break;
            case 13:
                if (System.currentTimeMillis() - lastTimeStamp <34000){
                    armPosition1(); //the complicated one
                    if (wheelState ==0) wheelTurn(0.0, 180);
                } else{
                    wheelState =0;
                    state++;
                }
                break;
            case 14:
                if (System.currentTimeMillis() - lastTimeStamp <36000){
                    armPosition0();
                    if (wheelState ==0) wheelTurn(0.0, 0);
                } else{
                    wheelState =0;
                    state++;
                }
                break;
            case 15:
                if (System.currentTimeMillis() - lastTimeStamp <38000){
                    armPosition1(); //the complicated one
                } else{
                    state++;
                }
                break;
            case 16:
                if (System.currentTimeMillis() - lastTimeStamp <39000){
                    armPosition9();
                } else{
                    state++;
                }
                break;
            case 17:
                if (System.currentTimeMillis() - lastTimeStamp <4000){
                    armPosition8();
                } else{
                    state++;
                }
                break;
            case 18:
                if (System.currentTimeMillis() - lastTimeStamp <41000){
                    armPosition11();
                } else{
                    state++;
                }
                break;
            case 19:
                if (System.currentTimeMillis() - lastTimeStamp <42000){
                    armPosition10();
                } else{
                    state++;
                }
                break;
            case 20:
                if (System.currentTimeMillis() - lastTimeStamp <43000){
                    armPosition4();
                } else{
                    state++;
                }
                break;
            case 21:
                if (System.currentTimeMillis() - lastTimeStamp <44000){
                    armPosition6();
                } else{
                    state++;
                }
                break;
            case 22:
                if (System.currentTimeMillis() - lastTimeStamp <45000){
                    armPosition5();
                } else{
                    state++;
                }
                break;
            case 23:
                if (System.currentTimeMillis() - lastTimeStamp <46000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 24:
                if (System.currentTimeMillis() - lastTimeStamp <47000){
                    armPosition4();
                } else{
                    state++;
                }
                break;
            case 25:
                if (System.currentTimeMillis() - lastTimeStamp <48000){
                    armPosition6();
                } else{
                    state++;
                }
                break;
            case 26:
                if (System.currentTimeMillis() - lastTimeStamp <49000){
                    armPosition1();
                } else{
                    state++;
                }
                break;
            case 27:
                if (System.currentTimeMillis() - lastTimeStamp <50000){
                    armPosition7();
                } else{
                    state++;
                }
                break;
            case 28:
                if (System.currentTimeMillis() - lastTimeStamp <52000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 29:
                if (System.currentTimeMillis() - lastTimeStamp <54000){
                    armPosition1();
                    if (wheelState ==0) wheelMove(0.5, -300);
                } else{
                    wheelState =0;
                    state++;
                }
                break;
            case 30:
                if (System.currentTimeMillis() - lastTimeStamp <56000){
                    armPosition0();
                    if (wheelState ==0) wheelMove(0.5, 300);
                } else{
                    wheelState =0;
                    state++;
                }
                break;
            case 31:
                if (System.currentTimeMillis() - lastTimeStamp <58000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 32:
                if (System.currentTimeMillis() - lastTimeStamp <60000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 33:
                if (System.currentTimeMillis() - lastTimeStamp <62000){
                    armPosition1(); //the complicated one
                } else{
                    state++;
                }
                break;
            case 34:
                if (System.currentTimeMillis() - lastTimeStamp <64000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 35:
                if (System.currentTimeMillis() - lastTimeStamp <66000){
                    armPosition1(); //the complicated one
                } else{
                    state++;
                }
                break;
            case 36:
                if (System.currentTimeMillis() - lastTimeStamp <70000){
                    armPosition7(); //the really complicated one
                } else{
                    state++;
                }
                break;
            case 37:
                if (System.currentTimeMillis() - lastTimeStamp <72000){
                    armPosition7();
                } else{
                    state++;
                }
                break;
            case 38:
                if (System.currentTimeMillis() - lastTimeStamp <74000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 39:
                if (System.currentTimeMillis() - lastTimeStamp <78000){
                    armPosition5();
                } else{
                    state++;
                }
                break;
            case 40:
                if (System.currentTimeMillis() - lastTimeStamp <82000){
                    armPosition4();
                    particleShooter.moveArmToFirePosition();
                } else{
                    state++;
                }
                break;
            case 41:
                if (System.currentTimeMillis() - lastTimeStamp <84000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 42:
                if (System.currentTimeMillis() - lastTimeStamp <85000){
                    armPosition11();
                } else{
                    state++;
                }
                break;
            case 43:
                if (System.currentTimeMillis() - lastTimeStamp <86000){
                    armPosition10();
                    particleShooter.cock();
                } else{
                    state++;
                }
                break;
            case 44:
                if (System.currentTimeMillis() - lastTimeStamp <90000){
                    armPosition7(); //the really complicated one
                } else{
                    state++;
                    elevatorPosition = robot.motorRightArm.getCurrentPosition();
                }
                break;
            case 45:
                if (System.currentTimeMillis() - lastTimeStamp <92000){
                    armPosition0();
                    if (Math.abs(robot.motorRightArm.getCurrentPosition() - elevatorPosition) < fireworkPosition) {
                        robot.motorRightArm.setPower(0.2);
                    } else {
                        robot.motorRightArm.setPower(0.0);
                    }
                } else{
                    state++;
                }
                break;
            case 46:
                if (System.currentTimeMillis() - lastTimeStamp <94000){
                    armPosition0(); //extend forklift & pop confetti
                    if (Math.abs(robot.motorRightArm.getCurrentPosition() - elevatorPosition) < fireworkPosition) {
                        robot.motorRightArm.setPower(0.2);
                    } else {
                        robot.motorRightArm.setPower(0.0);
                    }
                } else{
                    state++;
                }
                break;
            case 47:
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
