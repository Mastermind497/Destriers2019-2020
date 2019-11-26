/*
 * The Specific Robot Class for FIRE
 * Created by Shourya Bansal
 */
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RobotGeneral {
    //Creates DcMotors
    private DcMotor frontRightMotor;
    private DcMotor frontLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor backLeftMotor;

    //Creates Corresponding Wheels
    private Wheel frontRightWheel;
    private Wheel frontLeftWheel;
    private Wheel backRightWheel;
    private Wheel backLeftWheel;

    //Creates Sensor to Direct
    private ColorSensor leftColor;
    private ColorSensor rightColor;

    //Creates Servos which are being used
    private Servo clawServo;

    //Creates an array to store the robot's position after every movement
    double[] position = new double[2];

    //Creates a timer to calculate elapsed time
    ElapsedTime runtime = new ElapsedTime();

    //Constructors to create the Robot


    public RobotGeneral(DcMotor frontRightMotor, DcMotor frontLeftMotor, DcMotor backRightMotor, DcMotor backleftMotor, Wheel frontRightWheel, Wheel frontLeftWheel, Wheel backRightWheel, Wheel backLeftWheel, ColorSensor leftColor, ColorSensor rightColor, Servo clawServo) {
        this.frontRightMotor = frontRightMotor;
        this.frontLeftMotor = frontLeftMotor;
        this.backRightMotor = backRightMotor;
        this.backLeftMotor = backleftMotor;
        this.frontRightWheel = frontRightWheel;
        this.frontLeftWheel = frontLeftWheel;
        this.backRightWheel = backRightWheel;
        this.backLeftWheel = backLeftWheel;
        this.leftColor = leftColor;
        this.rightColor = rightColor;
        this.clawServo = clawServo;
    }

    public RobotGeneral(DcMotor frontRightMotor, DcMotor frontLeftMotor, DcMotor backRightMotor, DcMotor backleftMotor) {
        this.frontRightMotor = frontRightMotor;
        this.frontLeftMotor = frontLeftMotor;
        this.backRightMotor = backRightMotor;
        this.backLeftMotor = backleftMotor;
    }

    //Setters for Motor Power
    public void setMotorPower(DcMotor motor, double power) {
        motor.setPower(power);
    }
    public void setForwardPower(double power) {
        frontRightMotor.setPower(power);
        frontLeftMotor.setPower(power);
        backRightMotor.setPower(power);
        backLeftMotor.setPower(power);
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

    public double[] Driving (double x, double y)
    {
        double firstBasis = x + y;
        double secondBasis = y - x;
        firstBasis = firstBasis/java.lang.Math.sqrt(2);
        secondBasis = secondBasis/java.lang.Math.sqrt(2);
        double [] drivingPower = {firstBasis, secondBasis};
        return drivingPower;
    }




    public void move (double x, double y)
    {
        double firstBasis = x + y;
        double secondBasis = y - x;
        firstBasis = firstBasis/java.lang.Math.sqrt(2);
        secondBasis = secondBasis/java.lang.Math.sqrt(2);
        set(firstBasis, secondBasis);

    }

    public void set (double FLBR, double FRBL)
    {
        frontLeftMotor.setPower(FLBR);
        backRightMotor.setPower(FLBR);
        frontRightMotor.setPower(FRBL);
        backLeftMotor.setPower(FRBL);
    }


    public void set (double left, double right, String larry)
    {
        frontLeftMotor.setPower(left);
        frontRightMotor.setPower(right);
        backLeftMotor.setPower(left);
        backRightMotor.setPower(right);
    }



    public double[] Turning (int CW, double power)
    {
        double leftPower = -CW * power;
        double rightPower = CW * power;
        double [] turningPower = {leftPower, rightPower};
        return turningPower;
    }



    public void turn (int CW, double power)
    {
        double leftPower = -CW * power;
        double rightPower = CW * power;
        set(leftPower,rightPower,"turn");
    }











    public HardwareMap hardwareMap;


    public void init(HardwareMap aHardwareMap) {
        hardwareMap = aHardwareMap;

        //Initializing Motors
        frontLeftMotor = hardwareMap.get(DcMotor.class, "Front Left Motor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "Front Right Motor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "Back Left Motor");
        backRightMotor = hardwareMap.get(DcMotor.class, "Back Right Motor");
        //clawMotor = hardwareMap.get(DcMotor.class, "Claw Motor");

        //Set Directions
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors

        //clawMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors


        //Set Motor Power to Zero
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        //clawMotor.setPower(0);

        //Run with Encoders. If we don't use Encoders, change "RUN_USING_ENCODERS" to "RUN_WITHOUT_ENCODERS"
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //clawMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Brakes the Motors when the power is at Zero
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //clawMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Define and Initialize Servos
        //clawServo = hardwareMap.get(Servo.class, "Claw Servo");
        //servoTwo = hardwareMap.get(Servo.class, "<Servo Two Name>");
        //clawServo.setPosition(SERVO_INIT_POS);
        //servoTwo.setPosition(SERVO_INIT_POS);

        //Define a Color Sensor
        //Used https://ftc-tricks.com/overview-color-sensor/ to initialize and use Color Sensor
        //colorSensor = hardwareMap.get(ColorSensor.class, "Lego Detector");

        //Define Gyro Sensor
        //gyroSensor = hardwareMap.get(GyroSensor.class, "Gyro Sensor");

        //Define Distance Sensor
        //distanceSensor = hardwareMap.get(DistanceSensor.class, "Distance Sensor");
    }
}
