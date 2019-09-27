/*
 * The Driver-Controlled code for the Destriers/FIRE Team
 * Created by Team Member Shourya Bansal
 */
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import static org.firstinspires.ftc.teamcode.RobotHardware.*;

@TeleOp(name="Dual Motor TeleOp", group="TeleOp")
@Disabled
public class DualMotorTeleOp extends OpMode {

    public static final double SERVO_INIT_POS = 0.5;//This is the initial position of a servo and what you will send it back to
    private ElapsedTime runtime = new ElapsedTime();

    RobotHardware Robot = new RobotHardware();

    //Runs while init is pressed and before play
    public void init() {
        Robot.init(hardwareMap);
        telemetry.addData("Status", "TeleOp has been Initialized");
    }
    public void init_loop() {
        telemetry.addData("Status", "Waiting for Start");
    }

    //runs only once when the driver hits play
    public void start() {
        runtime.reset();
        telemetry.addData("Status", "Driver Controlled Started");
    }

    //loops after TeleOp Starts
    @Override
    public void loop(){
        //The Joystick:
            //Gamepad 1
            double G1rightStickY = -gamepad1.right_stick_y;
            double G1leftStickY = -gamepad1.left_stick_y;
            double G1rightStickX = -gamepad1.right_stick_x;
            double G1leftStickX = -gamepad1.left_stick_x;

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
            boolean G2dpadDown= gamepad2.dpad_down;
            boolean G2dpadLeft = gamepad2.dpad_left;
            boolean G2dpadRight = gamepad2.dpad_right;

        Robot.frontRightMotor.setPower(-G1leftStickX-G1leftStickY);//replace left stick y with right stick y if you want more control
        Robot.frontLeftMotor.setPower(-G1leftStickX+G1leftStickY);//replace left stick y with right stick y if you want more control

        /*
        //For One Controller
        Robot.clawMotor.setPower(G1rightStickX)

        if (G1rightBumper) {
            Robot.clawServo.setPosition(SERVO_OPEN_POS);
        }
        else if (G1leftBumper) {
            Robot.clawServo.setPosition(SERVO_INIT_POS);
        }
        */

        /*
        //For Two Controllers:
        Robot.clawMotor.setPower(G2leftStickX);
        if (G2rightBumper) {
            Robot.clawServo.setPosition(SERVO_OPEN_POS);
        }
        else if (G2leftBumper) {
            Robot.clawServo.setPosition(SERVO_INIT_POS);
        }
        */

        //Add more as more things are made; some sensors and extra motors have already been initialized.
    }
}
