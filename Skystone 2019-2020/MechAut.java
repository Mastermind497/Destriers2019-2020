
/*
 * The Auton code for the Destriers
 * Created by Team Member Josh Faber
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;

import static org.firstinspires.ftc.teamcode.Mech.Driving;
/*import static org.firstinspires.ftc.teamcode.Mech.FLBR;
import static org.firstinspires.ftc.teamcode.Mech.FR BL;*/
import static org.firstinspires.ftc.teamcode.Mech.Turning;
import static org.firstinspires.ftc.teamcode.RobotGeneral.*;

@Autonomous(name="MechAut", group="Auton")

public class MechAut extends LinearOpMode {

    /* Declare OpMode members. */
    //public static final double SERVO_INIT_POS = 0.5;//This is the initial position of a servo and what you will send it back to
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeftMotor;
    private DcMotor backLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backRightMotor;
    private Servo clawServo;
    private ColorSensor rightColor;
    RobotGeneral Robot = new RobotGeneral(frontRightMotor, frontLeftMotor, backRightMotor, backLeftMotor, clawServo, rightColor);


    @Override
    public void runOpMode() throws InterruptedException {


        Robot.init(hardwareMap);
        telemetry.addData("Status", "Auton has been Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive() && (runtime.seconds() < 3)) {
            Robot.set(0.8, 0.8);
        }
        Robot.set(0,0);
        Robot.setClawServo(1);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3)) {
            Robot.set(-0.8, -0.8);
        }
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) {
            Robot.set(0, 0);
        }
        rightColor.enableLed(true);
        double threshold = 150;
        boolean yellow = (rightColor.green() > threshold && rightColor.red() > threshold);
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 3 && yellow) {
            Robot.move(0.8,0);
        }
        Robot.set(0,0);
    }
}






