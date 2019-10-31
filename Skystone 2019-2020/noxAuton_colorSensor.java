package org.firstinspires.ftc.teamcode;
/*
Alright so this code is currently set up so that once run, the color sensor will list values to telemetry. Find yellow, replace the variables down below as needed, and uncomment the kill line
Once uncommented, the robot should move forward till it see's yellow, then just fill in the blanks with the grabBlock because im not sure what your sevrvos are or how to turn them
good luck at the competition,
Heainz

*/
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name = "Nox_OpMode", group = "Nox Aeterna")

public class destriersTesting extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    public DcMotor frontRightMotor;
    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;
    public ColorSensor colorSensor;

    public void initHardware () {

        //Initializing Motors
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");

        //Init color sensor
        colorSensor = hardwareMap.colorSensor.get("colorSensor");
        colorSensor.enableLed(true);

        //Set Motor Power to Zero
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);

        //Run with Encoders. If we don't use Encoders, change "RUN_USING_ENCODERS" to "RUN_WITHOUT_ENCODERS"
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Brakes the Motors when the power is at Zero
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status:","Init Complete");
    }

    @Override
    public void runOpMode(){
        initHardware();
        //Step 1: Drive forward until yellow is found
        driveForward();
        waitForYellow();

        //Once we do find our block, grab it
        grabBlock();


        driveStop();
    }

    public void waitForSeconds(int seconds) {
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < seconds));
        runtime.reset();
    }

    public void spinRight () {
        frontLeftMotor.setPower(-0.8);
        backLeftMotor.setPower(-0.8);
        frontRightMotor.setPower(-0.8);
        backRightMotor.setPower(-0.8);
    }

    public void driveStop() {
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    public void driveForward() {
        frontLeftMotor.setPower(-0.8);
        backLeftMotor.setPower(-0.8);
        frontRightMotor.setPower(0.8);
        backRightMotor.setPower(0.8);
    }

    public void waitForYellow() {
        boolean foundBlock = false;
        //Loop until block is found
        do {
            int red = colorSensor.red();
            int blue = colorSensor.blue();
            int green = colorSensor.green();
            telemetry.addData("Red", String.valueOf(red));
            telemetry.addData("Blue", String.valueOf(blue));
            telemetry.addData("Red", String.valueOf(green));
            //Uncomment once we get actual values
            /*if ((red > 10 && red < 20 && green > 10 && green < 25 && blue > 20 && blue < 38)) {
                foundBlock = true;
            }*/

        } while (!foundBlock);
    }

    public void grabBlock () {

    }
}

