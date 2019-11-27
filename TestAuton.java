
/*
 * The Auton code for the Destriers
 * Created by Team Member Aryan Bansal
 */

package org.firstinspires.ftc.robotcontroller.external.sam ples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous ;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMo de;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;

import static org.firstinspires.ftc.teamcode.Mech.Driving;
/*import static org.firstinspires.ftc.teamcode.Mech.FLBR;
import static org.firstinspires.ftc.teamcode.Mech.FRBL;*/
import static org.firstinspires.ftc.teamcode.Mech.Turning;
import static org.firstinspires.ftc.teamcode.RobotHardware.*;

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

        while (opModeIsActive() && (runtime.seconds() < 1)) {
            frontLeftMotor.setPower(-0.8);
            backLeftMotor.setPower(-0.8);
            frontRightMotor.setPower(0.8);
            backRightMotor.setPower(0.8);
        }
