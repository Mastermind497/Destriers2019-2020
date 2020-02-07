/*
 * The Specific Robot Class for Destriers
 * Created by Shourya Bansal and Joshua Faber
 */
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class RobotGeneral {
    //Creates DcMotors
    private DcMotor frontRightMotor;
    private DcMotor frontLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor backLeftMotor;


    //private DcMotor pulleyMotor;



    //Creates Sensor to Direct
    //private ColorSensor leftColor;
    //private ColorSensor rightColor;
    //private ColorSensor frontColor;
    //private DistanceSensor distanceSensor;


    //Creates Servos which are being used
    private Servo clawServo;
    //private Servo clampServo;

    //Creates an array to store the robot's position after every movement
    double[] position = new double[2];

    //Creates a timer to calculate elapsed time
    ElapsedTime runtime = new ElapsedTime();
    
    //Robot Hardwaremap
    private HardwareMap hardwareMap;

    private LinearOpMode linearOpMode;









    //THIS IS THE ONE THAT IS ACTUALLY USED
    public RobotGeneral(DcMotor frontRightMotor, DcMotor frontLeftMotor, DcMotor backRightMotor, DcMotor backleftMotor,
                        Servo clawServo, LinearOpMode linearOpMode) {
        this.frontRightMotor = frontRightMotor;
        this.frontLeftMotor = frontLeftMotor;
        this.backRightMotor = backRightMotor;
        this.backLeftMotor = backleftMotor;
        //this.pulleyMotor = pulleyMotor;
        this.clawServo = clawServo;
        this.linearOpMode = linearOpMode;
    }













    public void setMotorModeWithout() {
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setMotorModeToPosition() {
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void stopAndResetEncoders() {
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void setMotorModeusing() {
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }









    //TeleOp movement

    public void move (double x, double y)
    {
        //while (linearOpMode.opModeIsActive()) {
            double firstBasis = x + y;
            double secondBasis = y - x;
            firstBasis = firstBasis / java.lang.Math.sqrt(2);
            secondBasis = secondBasis / java.lang.Math.sqrt(2);
            setMove(firstBasis, secondBasis);
        //}

    }

    public void setMove(double FLBR, double FRBL) //for moving
    {
        //while (linearOpMode.opModeIsActive()) {
            frontLeftMotor.setPower(FLBR);
            backRightMotor.setPower(FLBR);
            frontRightMotor.setPower(FRBL);
            backLeftMotor.setPower(FRBL);
        //}
    }

    public void turn (int CW, double power)
    {
        //while (linearOpMode.opModeIsActive()) {
            double leftPower = CW * power;
            double rightPower = -CW * power;
            setTurn(leftPower, rightPower);
        //}
    }


    public void setTurn(double left, double right) //for turning
    {
        //while (linearOpMode.opModeIsActive()) {
            frontLeftMotor.setPower(left);
            frontRightMotor.setPower(right);
            backLeftMotor.setPower(left);
            backRightMotor.setPower(right);
        //}
    }





    //auton movement


    private double circumference = 2*Math.PI*2;
    private int ticks = 1680;



    public void moveAuton (double x, double y)
    {
        //while(linearOpMode.opModeIsActive()) {
            double distance = java.lang.Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            distance /= circumference;
            distance *= ticks;
            double firstBasis = x + y;
            double secondBasis = y - x;
            firstBasis = firstBasis / java.lang.Math.sqrt(2);
            secondBasis = secondBasis / java.lang.Math.sqrt(2);
            setAuton((int) Math.round(firstBasis * distance), (int) Math.round(secondBasis * distance));
        //}

    }

    public void setAuton (int FLBR, int FRBL)
    {
        //while(linearOpMode.opModeIsActive()) {
            frontLeftMotor.setTargetPosition(FLBR);
            frontRightMotor.setTargetPosition(FRBL);
            backLeftMotor.setTargetPosition(FRBL);
            backRightMotor.setTargetPosition(FLBR);
            setMotorModeToPosition();
            stopAndResetEncoders();
            while((backLeftMotor.isBusy() || backRightMotor.isBusy() || frontRightMotor.isBusy() || frontLeftMotor.isBusy()) 
                  && linearOpMode.opModeIsActive()){
                //waiting
            }
        //}
    }








   /* public void movePulley (double direction){
        direction *= 0.3;
        pulleyMotor.setPower(direction);
    }*/



    public void setClawServo (double position)
    {
        clawServo.setPosition(position);
        runtime.reset();
        while(runtime.seconds()<1 && linearOpMode.opModeIsActive()){
            setMove(0,0);
        }
    }
    //public void setClampServo (double position) {clampServo.setPosition(position);}




    /*public void setRightColor (boolean on) {
        rightColor.enableLed(on);
    }
    public double getRightColorGreen () {
        return rightColor.green();
    }
    public double getRightColorRed ()  {
        return rightColor.red();
    }

    public void setFrontColor (boolean on) {frontColor.enableLed(on);}
    public double getFrontColorGreen() {return frontColor.green();}
    public double getFrontColorRed() {return frontColor.red();}
    public double getFrontColorBlue() {return frontColor.blue();}
    public double getFrontColorAlpha() {return frontColor.alpha();}


    public double getDistance() {return distanceSensor.getDistance(DistanceUnit.CM);}*/












    //Initializes Robot
    public void init(HardwareMap hardwareMap) {
        //Initializing Motors
        frontLeftMotor = hardwareMap.get(DcMotor.class, "Front Left Motor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "Front Right Motor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "Back Left Motor");
        backRightMotor = hardwareMap.get(DcMotor.class, "Back Right Motor");
        //pulleyMotor = hardwareMap.get(DcMotor.class, "Pulley Motor");
        //clawMotor = hardwareMap.get(DcMotor.class, "Claw Motor");

        //Set Directions
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        //pulleyMotor.setDirection(DcMotor.Direction.FORWARD);

        //clawMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors


        //Set Motor Power to Zero
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        //pulleyMotor.setPower(0);
        //clawMotor.setPower(0);

        //Run with Encoders. If we don't use Encoders, change "RUN_USING_ENCODERS" to "RUN_WITHOUT_ENCODERS"
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //pulleyMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //clawMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Brakes the Motors when the power is at Zero
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //pulleyMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //clawMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Define and Initialize Servos
        clawServo = hardwareMap.get(Servo.class, "Claw Servo");
        //servoTwo = hardwareMap.get(Servo.class, "<Servo Two Name>");
        clawServo.setPosition(0);
        //clampServo = hardwareMap.get(Servo.class, "Clamp Servo");
        //clampServo.setPosition(0);
        //servoTwo.setPosition(SERVO_INIT_POS);

        //Define a Color Sensor
        //Used https://ftc-tricks.com/overview-color-sensor/ to initialize and use Color Sensor
        //colorSensor = hardwareMap.get(ColorSensor.class, "Lego Detector");
        //rightColor = hardwareMap.get(ColorSensor.class, "Right Color");
        //frontColor = hardwareMap.get(ColorSensor.class, "Front Color");
        //frontColor.enableLed(false);


        //Define Gyro Sensor
        //gyroSensor = hardwareMap.get(GyroSensor.class, "Gyro Sensor");

        //Define Distance Sensor
        //distanceSensor = hardwareMap.get(DistanceSensor.class, "Distance Sensor");
    }
}
