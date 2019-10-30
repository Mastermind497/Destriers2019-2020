/*
 * The Auton code for the Destriers
 * Created by Team Members Aryan Bansal and Joshua Faber
 */

package org.firstinspires.ftc.robotcontroller.external.sam ples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous ;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMo de;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name="Auton", group="Auton")

public class Auton extends OpMode {

    /* Declare OpMode members. */
    public static final double SERVO_INIT_POS = 0.5;//This is the initial position of a servo and what you will send it back to
    private ElapsedTime runtime = new ElapsedTime();

    HardwareMap hardwareMap;

    public void runOpMode() throws InterruptedException {


        Robot.init(hardwareMap);
        telemetry.addData("Status", "Auton has been Initialized");

// Send telemetry message to signify robot waiting;
        public void init_loop() {
            telemetry.addData("Status", "Waiting for Start");
        }

        public void start() {
            runtime.reset();
            telemetry.addData("Status", "Driver Controlled Started");
        }

        @Override

// Wait for the game to start (driver presses PLAY)
        waitForStart();

// Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
// Step 1: Drive forward for 3 seconds


        while (opModeIsActive() && (runtime.seconds() < 3)) {
            frontLeftMotor.setPower(-0.8);
            backLeftMotor.setPower(-0.8);
            frontRightMotor.setPower(0.8);
            backRightMotor.setPower(0.8);
        }
        runtime.reset();

// Step 2: Spin right for 1 seconds

        while (opModeIsActive() && (runtime.seconds() < 1)) {
            frontLeftMotor.setPower(-0.8);
            backLeftMotor.setPower(-0.8);
            frontRightMotor.setPower(-0.8);
            backRightMotor.setPower(-0.8);
        }
        runtime.reset();

//Step 3: Drive forwards for 2 Second


        while (opModeIsActive() && (runtime.seconds() < 2)) {
            frontLeftMotor.setPower(-0.8);
            backLeftMotor.setPower(-0.8);
            frontRightMotor.setPower(0.8);
            backRightMotor.setPower(0.8);
        }
        runtime.reset();

//step 4: Spin Right for 1 seconds

            while (opModeIsActive() && (runtime.seconds() < 1)) {
                frontLeftMotor.setPower(-0.8);
                backLeftMotor.setPower(-0.8);
                frontRightMotor.setPower(-0.8);
                backRightMotor.setPower(-0.8);
            }
            runtime.reset();

            while (opModeIsActive() && (runtime.seconds() < 1.5)) {
                frontLeftMotor.setPower(-0.8);
                backLeftMotor.setPower(-0.8);
                frontRightMotor.setPower(0.8);
                backRightMotor.setPower(0.8);
            }
            runtime.reset();

            while (opModeIsActive() && (runtime.seconds() < 1)) {
                frontLeftMotor.setPower(-0.8);
                backLeftMotor.setPower(-0.8);
                frontRightMotor.setPower(-0.8);
                backRightMotor.setPower(-0.8);
            }
            runtime.reset();

            while (opModeIsActive() && (runtime.seconds() < 5)) {
                frontLeftMotor.setPower(-1);
                backLeftMotor.setPower(-1);
                frontRightMotor.setPower(1);
                backRightMotor.setPower(1);
            }
            runtime.reset();

            while (opModeIsActive() && (runtime.seconds() < 1)) {
                frontLeftMotor.setPower(0.8);
                backLeftMotor.setPower(0.8);
                frontRightMotor.setPower(-0.8);
                backRightMotor.setPower(-0.8);
            }
            runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 1)) {
            frontLeftMotor.setPower(0.8);
            backLeftMotor.setPower(0.8);
            frontRightMotor.setPower(0.8);
            backRightMotor.setPower(0.8);
        }
        runtime.reset();


            color_sensor = hardwareMap.colorSensor.get("color");
            color_sensor.enableLed(true);


            while (color_sensor.green()<100 || color_sensor.red()<100) {
                telemetry.addData(color_sensor.red());
                telemetry.addData(color_sensor.blue());
                telemetry.addData(color_sensor.green());
                frontLeftMotor.setPower(0.8);
                backLeftMotor.setPower(0.8);
                frontRightMotor.setPower(-0.8);
                backRightMotor.setPower(-0.8);
             }

            frontLeftMotor.setPower(0);
            backLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
            backRightMotor.setPower(0);

            int red = color_sensor.red();
            int blue = color_sensor.blue();
            int green = color_sensor.green();

            if (red > blue && red > green && red > 100) {
                frontLeftMotor.setPower(0);
                backLeftMotor.setPower(0);
                frontRightMotor.setPower(0);
                backRightMotor.setPower(0);
            }

            else {
                frontLeftMotor.setPower(0.8);
                backLeftMotor.setPower(0.8);
                frontRightMotor.setPower(-0.8);
                backRightMotor.setPower(-0.8);*/
            }
    }
}