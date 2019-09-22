package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Mobama", group="TeleOp")

public class DriverControlled extends OpMode{

    //Declare OpMode members.
    RobotHardware robot = new RobotHardware();
    
    //Constants
    
   //Run once on init()
    @Override
    public void init() {
        //robot.init(hardwareMap);
        robot.init(hardwareMap);
        telemetry.addData("STATUS", "Initialized");
    }
    
    //Loop on init()
    @Override
    public void init_loop() {
    }
    //Run Once on start()
    @Override

    public void start() {
    }

    //Loop on start()
    @Override
    public void loop() {
        //The Joystick
        double G1rightStickY = -gamepad1.right_stick_y;
        double G1leftStickY = -gamepad1.left_stick_y;
        double G1rightStickX = -gamepad1.right_stick_x;
        double G1leftStickX = -gamepad1.left_stick_x;
        
        int pleftStickX = (int) (G1leftStickX + 0.9999);
        int nleftStickX = (int) (G1leftStickX - 0.9999);
        
        //The Bumpers
        boolean G1rightBumper = gamepad1.right_bumper;
        boolean G1leftBumper = gamepad1.left_bumper;
        
        //The Buttons
        boolean G1a = gamepad1.a;
        boolean G1b = gamepad1.b;
        boolean G1x = gamepad1.x;
        boolean G1y = gamepad1.y;
        boolean G1dpadUp = gamepad1.dpad_up;
        boolean G1dpadDown = gamepad1.dpad_down;
        boolean G1dpadLeft = gamepad1.dpad_left;
        boolean G1dpadRight = gamepad1.dpad_right;

        if (G1dpadRight) {
            robot.frontRightMotor.setPower(0.6);
            robot.frontLeftMotor.setPower(0.6);
            robot.backRightMotor.setPower(0.6);
            robot.backLeftMotor.setPower(0.6);
        
        }
        else if (G1dpadLeft) {
            robot.frontRightMotor.setPower(-0.6);
            robot.frontLeftMotor.setPower(-0.6);
            robot.backRightMotor.setPower(-0.6);
            robot.backLeftMotor.setPower(-0.6);
        }
        else if (G1x) {
            robot.hangingMotor.setPower(0.02);
        }
        else if (G1y) {
            robot.hangingMotor.setPower(-0.02);
        }
        
        else if (G1a) {
            robot.markerServo.setPosition(90);
        }
        else if (G1b) {
            robot.markerServo.setPosition(0);
        }
        
        else if (G1rightBumper) {
            robot.frontRightMotor.setPower(-0.6);
            robot.frontLeftMotor.setPower(-0.6);
            robot.backRightMotor.setPower(0.6);
            robot.backLeftMotor.setPower(0.6);
        }
        else if (G1leftBumper) {
            robot.frontRightMotor.setPower(0.6);
            robot.frontLeftMotor.setPower(0.6);
            robot.backRightMotor.setPower(-0.6);
            robot.backLeftMotor.setPower(-0.6);
        }
        //else if (G1dpadUp) {
            //robot.collectionServo.setPosition(1);
        //}
        //else if (G1dpadDown) {
            //robot.collectionServo.setPosition(0);
        //}
        else {
          robot.frontRightMotor.setPower(-G1leftStickY);
          robot.frontLeftMotor.setPower(G1leftStickY);
          robot.backRightMotor.setPower(-G1leftStickY);
          robot.backLeftMotor.setPower(G1leftStickY);  
          robot.hangingMotor.setPower(0);
        }
        
  } 
}
