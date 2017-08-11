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

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.SyncdDevice;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

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

@Autonomous(name="Dance2:", group="Dance2")
public class Dance2AutoOp extends VortexAutoOp {

    protected int headPositionA = 2500;
    protected int headPositionB = 2800;
    protected int headPositionC = 3000;
    int danceState = 0;
    int danceBeats = 556;
    double headPower = 0.4;
    double armSpeed = 2.0;
    long lastTimeStamp;


    @Override
    public void start() {
        super.start();

        lastTimeStamp = System.currentTimeMillis();
        danceState = 0;
        state = 0;

    }

    protected void dancePatternReset () {
        danceState = 0;
        lastTimeStamp = System.currentTimeMillis();
    }

    protected void armPosition0() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition1() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition2() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition3() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition4() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition5() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition6() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition7() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition8() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition9() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition10() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
    }

    protected void armPosition11() {
        leftBeaconArm.setPosition(0.9, 0.85);
        rightBeaconArm.setPosition(0.1,0.08);
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
                    //gyroTracker.turn(50)
                } else {
                    state ++;
                }
                break;
            case 1:
                if (System.currentTimeMillis() - lastTimeStamp < 6000) {
                    armPosition0();
                    //gyroTracker.goStraight() // meters
                } else {
                    state ++ ;
                }
                break;
            case 2:
                if (System.currentTimeMillis() - lastTimeStamp < 8000){
                    armPosition1();
                } else {
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
                } else{
                    state++;
                }
                break;
            case 10:
                if (System.currentTimeMillis() - lastTimeStamp <26000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 11:
                if (System.currentTimeMillis() - lastTimeStamp <28000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 12:
                if (System.currentTimeMillis() - lastTimeStamp <32000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 13:
                if (System.currentTimeMillis() - lastTimeStamp <34000){
                    armPosition1(); //the complicated one
                } else{
                    state++;
                }
                break;
            case 14:
                if (System.currentTimeMillis() - lastTimeStamp <36000){
                    armPosition0();
                } else{
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
                } else{
                    state++;
                }
                break;
            case 30:
                if (System.currentTimeMillis() - lastTimeStamp <56000){
                    armPosition0();
                } else{
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
                } else{
                    state++;
                }
                break;
            case 44:
                if (System.currentTimeMillis() - lastTimeStamp <90000){
                    armPosition7(); //the really complicated one
                } else{
                    state++;
                }
                break;
            case 45:
                if (System.currentTimeMillis() - lastTimeStamp <92000){
                    armPosition0();
                } else{
                    state++;
                }
                break;
            case 46:
                if (System.currentTimeMillis() - lastTimeStamp <94000){
                    armPosition0(); //extend forklift & pop confetti
                } else{
                    state++;
                }
                break;
            default:
                dancePatternReset();
                //state = 0; // repeat
                break;
        }
        lastTimeStamp = System.currentTimeMillis();
    }

    public void findEmptySpot () {
        // make circle to collect data

        // move to empty spot
    }

    public int beforeShootDance (int beatInterval, int startState, int endState) {
        telemetry.addData("Pre-shoot State:", "%02d", danceState);
        switch (danceState) {
            case 0:
                telemetry.addData("STATE", "%02d", danceState);
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval) {
                    armC(5.0);
                } else {
                    danceState = 1;
                }
                break;
            case 1:
                telemetry.addData("STATE", "%02d", danceState);
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*2) {

                } else {
                    danceState = 2;
                }
                break;
            case 2:
                telemetry.addData("STATE", "%02d", danceState);
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*3) {
                    armD(5.0);
                } else {
                    danceState = 3;
                }
                break;
            case 3:
                telemetry.addData("STATE", "%02d", danceState);
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*4) {
                } else {
                    danceState = 4;
                }
                break;
            case 4:
                telemetry.addData("STATE", "%02d", danceState);
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*5) {
                    armC(5.0);
                } else {
                    danceState = 5;
                }
                break;
            case 5:
                telemetry.addData("STATE", "%02d", danceState);
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*6) {
                    armD(5.0);
                } else {
                    danceState = 6;
                }
                break;
            case 6:
                telemetry.addData("STATE", "%02d", danceState);
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*7) {
                    armC(5.0);
                } else {
                    danceState = 7;
                }
                break;
            case 7:
                telemetry.addData("STATE", "%02d", danceState);
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*8) {
                    armD(5.0);
                } else {
                    danceState = 8;
                }
                break;
            default:
                return endState; // done
        }
        telemetry.addData("back to", "state", "0");
        return startState;
    }

    public int cowboyDance (int beatInterval, int startState, int endState) {
        telemetry.addData("Cowboy Dance State:", "%02d", danceState);
        switch (danceState) {
            case 0:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval) {
                    armB(2.0);
                    headA(headPower);
                } else {
                    danceState = 1;
                }
                break;
            case 1:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*2) {
                    armC(5.0);
                } else {
                    danceState = 2;
                }
                break;
            case 2:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*3) {
                    headC(headPower);
                    armD(5.0);
                } else {
                    danceState = 3;
                }
                break;
            case 3:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*4) {
                    armE();
                } else {
                    danceState = 4;
                }
                break;
            case 4:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*5) {
                    armF();
                    headB(headPower);
                } else {
                    danceState = 5;
                }
                break;
            case 5:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*6) {
                    armG();
                    headC(headPower);
                } else {
                    danceState = 6;
                }
                break;
            case 6:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*7) {
                    armH();
                    headB(headPower);
                } else {
                    danceState = 7;
                }
                break;
            case 7:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*8) {
                    armA();
                    headC(headPower);
                } else {
                    danceState = 8;
                }
                break;
            default:
                return endState; // done
        }
        return startState;
    }

    public int cowboyDance2 (int beatInterval, int startSate, int endState) {
        telemetry.addData("Cowboy Dance2 State:", "%02d", danceState);
        switch (danceState) {
            case 0:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval) {
                    armB(5.0);
                    headA(headPower);
                    wheelB(0.0,15);
                } else {
                    danceState = 1;
                }
                break;
            case 1:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*2) {
                    armC(5.0);
                } else {
                    danceState = 2;
                }
                break;
            case 2:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*3) {
                    headC(headPower);
                    armD(5.0);
                    wheelB(0.0,-15);
                } else {
                    danceState = 3;
                }
                break;
            case 3:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*4) {
                    armE();
                } else {
                    danceState = 4;
                }
                break;
            case 4:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*5) {
                    armC(5.0);
                    headB(headPower);
                    wheelB(0.0,15);
                } else {
                    danceState = 5;
                }
                break;
            case 5:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*6) {
                    armD(5.0);
                    headC(headPower);
                    wheelB(0.0,-15);
                } else {
                    danceState = 6;
                }
                break;
            case 6:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*7) {
                    armC(5.0);
                    headB(headPower);
                    wheelB(0.0,15);
                } else {
                    danceState = 7;
                }
                break;
            case 7:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*8) {
                    armD(5.0);
                    headC(headPower);
                    wheelB(0.0,-15);
                } else {
                    danceState = 8;
                }
                break;
            default:
                return endState; // done
        }
        return endState;
    }

    public int cowboyDance3 (int beatInterval, int startState, int endState) {
        telemetry.addData("Cowboy Dance3 State:", "%02d", danceState);
        switch (danceState) {
            case 0:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval) {
                    armB(5.0);
                    headA(headPower);
                    wheelB(0.0,15);
                } else {
                    danceState = 1;
                }
                break;
            case 1:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*2) {
                    armC(5.0);
                    wheelB(0.0,50);
                } else {
                    danceState = 2;
                }
                break;
            case 2:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*3) {
                    headC(headPower);
                    armD(5.0);
                    wheelB(0.0,90);
                } else {
                    danceState = 3;
                }
                break;
            case 3:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*4) {
                    armE();
                    wheelB(0.0,135);
                } else {
                    danceState = 4;
                }
                break;
            case 4:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*5) {
                    armG();
                    headB(headPower);
                    wheelB(0.0,180);
                } else {
                    danceState = 5;
                }
                break;
            case 5:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*6) {
                    armH();
                    headC(headPower);
                    wheelB(0.0,240);
                } else {
                    danceState = 6;
                }
                break;
            case 6:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*7) {
                    armG();
                    headB(headPower);
                    wheelB(0.0,290);
                } else {
                    danceState = 7;
                }
                break;
            case 7:
                if (System.currentTimeMillis() - lastTimeStamp < beatInterval*8) {
                    armH();
                    headC(headPower);
                    wheelB(0.0,0);
                } else {
                    danceState = 8;
                }
                break;
            default:
                return endState; // done
        }
        return startState;
    }

    // arm dance modes
    public void armA () {

    }

    public void armB (double speed) {

    }

    public void armC (double speed) {

    }

    public void armD (double speed) {

    }

    public void armE () {

    }

    public void armF () {

    }

    public void armG () {

    }

    public void armH () {

    }

    // wheel dance modes
    public void  wheelA (double power, int distance) {
        gyroTracker.goStraight (0, cruisingTurnGain, power,
                distance, 0,1);
    }

    public void wheelB (double turnPower, int heading) {
        gyroTracker.minTurnPower = 0.15;
        state = gyroTracker.turn(heading,
                inPlaceTurnGain,turnPower,0,0);
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
