
/*
 * The Auton code for the Destriers
 * Created by Team Member Josh Faber
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;


/*import static org.firstinspires.ftc.teamcode.Mech.FLBR;
import static org.firstinspires.ftc.teamcode.Mech.FR BL;*/

@Autonomous(name="SkyWSensors", group="Auton")

public class SkyWSensors extends LinearOpMode {

    /* Declare OpMode members. */
    //public static final double SERVO_INIT_POS = 0.5;//This is the initial position of a servo and what you will send it back to
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeftMotor;
    private DcMotor backLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backRightMotor;
    private Servo clawServo;
    private Servo clampServo;
    private ColorSensor frontColor;
    private DistanceSensor distanceSensor;
    private RobotGeneral Robot = new RobotGeneral(frontRightMotor, frontLeftMotor, backRightMotor, backLeftMotor, clawServo, clampServo, frontColor, distanceSensor);


    @Override
    public void runOpMode() throws InterruptedException {


        Robot.init(hardwareMap);
        telemetry.addData("Status", "Auton has been Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.5) && Robot.getDistance()>12) {
            Robot.setMove(0.35, 0.35);
        }
        runtime.reset();


        while (opModeIsActive() && runtime.seconds()<1){
            Robot.setMove(0,0);
        }
        runtime.reset();



        Robot.setFrontColor(true);
        while (opModeIsActive() && runtime.seconds() < 10 && Robot.getFrontColorAlpha() > 195){
            Robot.move(0.35,0);
            telemetry.addData("green", Robot.getFrontColorGreen());
            telemetry.addData("red", Robot.getFrontColorRed());
            telemetry.addData("blue",Robot.getFrontColorBlue());
            telemetry.addData("alpha",Robot.getFrontColorAlpha());
            telemetry.update();
        }

        runtime.reset();

        while (opModeIsActive() && runtime.seconds()<1){
            Robot.setMove(0,0);
            Robot.setClawServo(1);
        }
        runtime.reset();


        while (opModeIsActive() && (runtime.seconds() < 1)) {
            Robot.setMove(-0.35, -0.35);
        }
        runtime.reset();



        while (opModeIsActive() && runtime.seconds() <5){
            Robot.move(-0.35,0);
        }


        runtime.reset();
        while (opModeIsActive()) {
            Robot.setMove(0, 0);
        }



        /*Robot.setRightColor(true);
        double threshold = 150;
        boolean yellow = (Robot.getRightColorGreen()> threshold && Robot.getRightColorRed() > threshold);
        //runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 10 && yellow) {
            Robot.move(0.8,0);
        }
        while (opModeIsActive()) {
            Robot.setMove(0, 0);
            telemetry.addData("Green:",Robot.getRightColorGreen());
            telemetry.addData("Red:", Robot.getRightColorRed());
            telemetry.update();*/
    }

}






