/* 
 * The Robot Hardware code for the Destriers
 * Created by Team Member Shourya Bansal
 */

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RobotHardware {
    //Declaring the specific hardware for our robot
    //The DC Motors:
    public DcMotor rightMotor;
    public DcMotor leftMotor;
    //Add more DC Motors when you use them

    //The Servos
    public Servo servoOne;
    public Servo servoTwo;

    //The Color Sensors
    public ColorSensor colorSensor;

    //The Gyro Sensor
    public GyroSensor gyroSensor;

    //Distance Sensor
    public DistanceSensor distanceSensor;

    public static final double SERVO_INIT_POS = 0.5;//This is the initial position of a servo and what you will send it back to

    HardwareMap hardwareMap;


    public void init(HardwareMap aHardwareMap) {
        hardwareMap = aHardwareMap;

        //Initializing Motors
        leftMotor = hardwareMap.get(DcMotor.class, "Front Left Motor");
        rightMotor = hardwareMap.get(DcMotor.class, "Front Right Motor");

        //Set Directions
        leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        //Set Motor Power to Zero
        leftMotor.setPower(0);
        rightMotor.setPower(0);

        //Run with Encoders. If we don't use Encoders, change "RUN_USING_ENCODERS" to "RUN_WITHOUT_ENCODERS"
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Brakes the Motors when the power is at Zero
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Define and Initialize Servos
        servoOne = hardwareMap.get(Servo.class, "<Servo One Name>");
        servoTwo = hardwareMap.get(Servo.class, "<Servo Two Name>");
        servoOne.setPosition(SERVO_INIT_POS);
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
