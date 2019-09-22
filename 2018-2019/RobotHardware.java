package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

public class RobotHardware {
    //Instantiate Motors
    public DcMotor frontRightMotor;
    public DcMotor frontLeftMotor;
    public DcMotor backRightMotor;
    public DcMotor backLeftMotor;
    public DcMotor hangingMotor;
    public Servo markerServo;

    //Instasntiate Sensor
    
    
    public void init(HardwareMap hardwareMap) {
        
        //HardwareMap hardwareMap;
    
        // Define Motors and Servos
        frontRightMotor = hardwareMap.dcMotor.get("Front Right Motor");
        frontLeftMotor = hardwareMap.dcMotor.get("Front Left Motor");
        backRightMotor = hardwareMap.dcMotor.get("Back Right Motor");
        backLeftMotor = hardwareMap.dcMotor.get("Back Left Motor");
        hangingMotor = hardwareMap.dcMotor.get("Hanging Motor");
        markerServo = hardwareMap.servo.get("Marker Servo");

        // Set Motor Power
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        hangingMotor.setPower(0);
        
        markerServo.setPosition(0);


        //Set Motor Mode
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hangingMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Set Motor zeroPowerBehavior
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangingMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
 }
