
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

@Autonomous(name="AutSkystone", group="Auton")

public class AutSkystone extends LinearOpMode {

    /* Declare OpMode members. */
    //public static final double SERVO_INIT_POS = 0.5;//This is the initial position of a servo and what you will send it back to
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeftMotor;
    private DcMotor backLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backRightMotor;
    private Servo clawServo;
    private Servo clampServo;
    //private ColorSensor rightColor;
    private RobotGeneral Robot = new RobotGeneral(frontRightMotor, frontLeftMotor, backRightMotor, backLeftMotor, clawServo, clampServo);


    @Override
    public void runOpMode() throws InterruptedException {


        Robot.init(hardwareMap);
        telemetry.addData("Status", "Auton has been Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 3)) {
            Robot.set(0.35, 0.35);
        }
        runtime.reset();


        while (opModeIsActive() && runtime.seconds()<1){
            Robot.set(0,0);
            Robot.setClampServo(1);
        }
        runtime.reset();


        while (opModeIsActive() && (runtime.seconds() < 4)) {
            Robot.set(-0.35, -0.35);
        }
        runtime.reset();


        while (opModeIsActive()) {
            Robot.set(0, 0);
        }
        /*Robot.setRightColor(true);
        double threshold = 150;
        boolean yellow = (Robot.getRightColorGreen()> threshold && Robot.getRightColorRed() > threshold);
        //runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 10 && yellow) {
            Robot.move(0.8,0);
        }
        while (opModeIsActive()) {
            Robot.set(0, 0);
            telemetry.addData("Green:",Robot.getRightColorGreen());
            telemetry.addData("Red:", Robot.getRightColorRed());
            telemetry.update();*/
    }

}






