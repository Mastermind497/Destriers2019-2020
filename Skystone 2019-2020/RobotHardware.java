/*
 * The Robot Hardware code for the Destriers/FIRE Team
 * Created by Team Member Shourya Bansal
 */
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotHardware {
    //Declaring the specific hardware for our robot
    //The DC Motors:
    public DcMotor frontRightMotor;
    public DcMotor frontLeftMotor;

    public DcMotor clawMotor;
    //Add more DC Motors when you use them

    //The Servos
    public Servo clawServo;
    public Servo servoTwo;

    //The Color Sensors
    public ColorSensor colorSensor;

    //The Gyro Sensor
    public GyroSensor gyroSensor;

    //Distance Sensor
    public DistanceSensor distanceSensor;

    public static final double SERVO_INIT_POS = 0.5;//This is the initial position of a servo and what you will send it back to
    public static final double SERVO_OPEN_POS = 45;

    HardwareMap hardwareMap;


    public void init(HardwareMap aHardwareMap) {
        hardwareMap = aHardwareMap;

        //Initializing Motors
        frontLeftMotor = hardwareMap.get(DcMotor.class, "Front Left Motor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "Front Right Motor");
        clawMotor = hardwareMap.get(DcMotor.class, "Claw Motor");

        //Set Directions
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        clawMotor.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors


        //Set Motor Power to Zero
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        clawMotor.setPower(0);

        //Run with Encoders. If we don't use Encoders, change "RUN_USING_ENCODERS" to "RUN_WITHOUT_ENCODERS"
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        clawMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Brakes the Motors when the power is at Zero
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        clawMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Define and Initialize Servos
        clawServo = hardwareMap.get(Servo.class, "<Servo One Name>");
        servoTwo = hardwareMap.get(Servo.class, "<Servo Two Name>");
        clawServo.setPosition(SERVO_INIT_POS);
        servoTwo.setPosition(SERVO_INIT_POS);

        //Define a Color Sensor
        //Used https://ftc-tricks.com/overview-color-sensor/ to initialize and use Color Sensor
        colorSensor = hardwareMap.get(ColorSensor.class, "Lego Detector");

        //Define Gyro Sensor
        gyroSensor = hardwareMap.get(GyroSensor.class, "Gyro Sensor");

        //Define Distance Sensor
        distanceSensor = hardwareMap.get(DistanceSensor.class, "Distance Sensor");
    }
}
