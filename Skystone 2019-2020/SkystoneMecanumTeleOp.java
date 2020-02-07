/*
 * The Driver-Controlled code for the Destriers
 * Created by Team Member Joshua Faber
 */


package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.*;




/*import static org.firstinspires.ftc.teamcode.Mech.FLBR;
import static org.firstinspires.ftc.teamcode.Mech.FRBL;*/

@TeleOp(name = "Skystone Mecanum TeleOp", group = "TeleOp")

public class SkystoneMecanumTeleOp extends LinearOpMode {

    public static final double SERVO_INIT_POS = 0.5;//This is the initial position of a servo and what you will send it back to
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeftMotor;
    private DcMotor backLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backRightMotor;
    private Servo clawServo;
    //private Servo clampServo;
    //private DcMotor pulleyMotor;

    RobotGeneral Robot = new RobotGeneral(frontRightMotor, frontLeftMotor, backRightMotor, backLeftMotor, clawServo, this, this.telemetry);

    //Runs while init is pressed and before play
    /*public void init() {
        Robot.init(hardwareMap);
        telemetry.addData("Status", "TeleOp has been Initialized");

        Robot.setMotorModeusing();
        //Robot.clawServo.setPosition(SERVO_INIT_POS);
    }

    public void init_loop() {
        telemetry.addData("Status", "Waiting for Start");
    }

    //runs only once when the driver hits play
    public void start() {
        runtime.reset();
        telemetry.addData("Status", "Driver Controlled Started");
    }*/

    //loops after TeleOp Starts
    @Override
    public void runOpMode() throws InterruptedException {
        Robot.init(hardwareMap);
        while (opModeIsActive()) {
            //The Joystick:
            //Gamepad 1
            double G1rightStickY = -gamepad1.right_stick_y;
            double G1leftStickY = -gamepad1.left_stick_y;
            double G1rightStickX = -gamepad1.right_stick_x;
            double G1leftStickX = gamepad1.left_stick_x;

            //Gamepad 2
            double G2rightStickY = -gamepad2.right_stick_y;
            double G2leftStickY = -gamepad2.left_stick_y;
            double G2rightStickX = -gamepad2.right_stick_x;
            double G2leftStickX = -gamepad2.left_stick_x;

            //The Bumpers:
            //Gamepad 1
            boolean G1rightBumper = gamepad1.right_bumper;
            boolean G1leftBumper = gamepad1.left_bumper;

            //Gamepad 2
            boolean G2rightBumper = gamepad2.right_bumper;
            boolean G2leftBumper = gamepad2.left_bumper;

            //The Buttons:
            //Gamepad 1
            boolean G1a = gamepad1.a;
            boolean G1b = gamepad1.b;
            boolean G1x = gamepad1.x;
            boolean G1y = gamepad1.y;
            boolean G1dpadUp = gamepad1.dpad_up;
            boolean G1dpadDown = gamepad1.dpad_down;
            boolean G1dpadLeft = gamepad1.dpad_left;
            boolean G1dpadRight = gamepad1.dpad_right;

            //Gamepad 2
            boolean G2a = gamepad2.a;
            boolean G2b = gamepad2.b;
            boolean G2x = gamepad2.x;
            boolean G2y = gamepad2.y;
            boolean G2dpadUp = gamepad2.dpad_up;
            boolean G2dpadDown = gamepad2.dpad_down;
            boolean G2dpadLeft = gamepad2.dpad_left;
            boolean G2dpadRight = gamepad2.dpad_right;

        /*double FRBLpow = FRBL(G1leftStickX, G1leftStickY);
        double FLBRpow = FLBR(G1leftStickX, G1leftStickY);
        Robot.frontRightMotor.setPower(FRBLpow);
        Robot.frontLeftMotor.setPower(FLBRpow);
        Robot.backRightMotor.setPower(FLBRpow);
        Robot.backLeftMotor.setPower(FRBLpow);*/


            if (Math.abs(G1leftStickX) > 0.1 || Math.abs(G1leftStickY) > 0.1) {
                Robot.move(G1leftStickX, G1leftStickY);
            } else if (G1rightStickX > 0.2) {
                Robot.turn(1, G1rightStickX);
            } else if (G1rightStickX < -0.2) {
                Robot.turn(-1, -G1rightStickX);
            } else {
                Robot.setMove(0, 0);
            }

            if (G1a) {
                Robot.setClawServo(1);
            }
            if (G1b) {
                Robot.setClawServo(0);
            }



           /* if (G1x) {
                Robot.movePulley(1);
            } else if (G1y) {
                Robot.movePulley(-1);
            } else {
                Robot.movePulley(0);
            }*/


        }

    }
}

