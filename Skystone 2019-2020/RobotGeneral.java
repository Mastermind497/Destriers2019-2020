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
    private DcMotor backleftMotor;

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


    public RobotGeneral(DcMotor frontRightMotor, DcMotor frontLeftMotor, DcMotor backRightMotor, DcMotor backleftMotor, Wheel frontRightWheel, Wheel frontLeftWheel, Wheel backRightWheel, Wheel backLeftWheel, ColorSensor leftColor, ColorSensor rightColor, Servo clawServo, double[] position, ElapsedTime runtime) {
        this.frontRightMotor = frontRightMotor;
        this.frontLeftMotor = frontLeftMotor;
        this.backRightMotor = backRightMotor;
        this.backleftMotor = backleftMotor;
        this.frontRightWheel = frontRightWheel;
        this.frontLeftWheel = frontLeftWheel;
        this.backRightWheel = backRightWheel;
        this.backLeftWheel = backLeftWheel;
        this.leftColor = leftColor;
        this.rightColor = rightColor;
        this.clawServo = clawServo;
        this.position = position;
        this.runtime = runtime;
    }

    public RobotGeneral(DcMotor frontRightMotor, DcMotor frontLeftMotor, DcMotor backRightMotor, DcMotor backleftMotor) {
        this.frontRightMotor = frontRightMotor;
        this.frontLeftMotor = frontLeftMotor;
        this.backRightMotor = backRightMotor;
        this.backleftMotor = backleftMotor;
    }

    //Setters for Motor Power
    public void setMotorPower(DcMotor motor, double power) {
        motor.setPower(power);
    }
    public void setForwardPower(double power) {
        frontRightMotor.setPower(power);
        frontLeftMotor.setPower(power);
        backRightMotor.setPower(power);
        backleftMotor.setPower(power);
    }
    public void turn(double power, String directionInp) {
        String direction = direction(directionInp);
        switch (direction) {
            case "f":
                setForwardPower(power);
                break;
            case "b":
                setForwardPower(-power);
                break;
            case "l":
                frontLeftMotor.setPower(power);
                frontRightMotor.setPower(-power);
                backleftMotor.setPower(power);
                backRightMotor.setPower(-power);
            case "r":
                frontLeftMotor.setPower(-power);
                frontRightMotor.setPower(power);
                backleftMotor.setPower(-power);
                backRightMotor.setPower(power);
            default:
                break;
        }
    }
    public void turnRight(double power) {
        turn(power, "r");
    }
    public void turnLeft(double power, String direction) {
        turn(power, "l");
    }

    //Deciphering methods:
    public String direction(String directionInput) {
        if (directionInput.equalsIgnoreCase("right") || directionInput.equalsIgnoreCase("r")){
            return "r";
        }
        else if (directionInput.equalsIgnoreCase("left") || directionInput.equalsIgnoreCase("l")) {
            return "l";
        }
        else if (directionInput.equalsIgnoreCase("back") || directionInput.equalsIgnoreCase("backwards")||directionInput.equalsIgnoreCase("b")) {
            return "b";
        }
        else if (directionInput.equalsIgnoreCase("forward") || directionInput.equalsIgnoreCase("front") || directionInput.equalsIgnoreCase("f")) {
            return "f";
        }
        else {
            throw new Error ("Your direction couldn't be found. Please try a different direction which is already programmed or add a new case");
        }
    }
}
