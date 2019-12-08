package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name = "Vuforia")
public class Vuforia extends LinearOpMode {

    VuforiaLocalizer vuforiaLocalizer;
    VuforiaLocalizer.Parameters parameters;
    VuforiaTrackables visionTarget;
    VuforiaTrackable target;
    VuforiaTrackableDefaultListener listener;

    OpenGLMatrix lastKnownLocation;
    OpenGLMatrix phoneLocation;

    public static final String VUFORIA_KEY = "AYQaCa3/////AAABmaeB4twmEUBwvLrWs+GMOF9/0Yu5HacDnkgGZFrxUsRhBIt56LjXixk66VTY7+2KZqHCsAWIV4oQfwIjBNDBdaXd0hwFIAhdOEkOLXt/cSe/svNN4IVXI6ApvHM/kQv9gqO2DKbLEfPHWU7fv9YHmFJMOW3dOR3//qvm2J7Vys+gsudvIbfl6hjU8FTcSb0JJAlEhZmIm/tGYj/2i3dUUlvkqVI/15B2Uqlj+3Qv6QPWzTgjyETUpCSbLnRqX8oxMwq6cx7g+xALisxGfhlD2q0AIesJbquO4pCfywC5VMwWhS/84vou0pHNpss329nqwvTgXdqkpx8UbQHEu+3ral5cuaTbs5SKxZupCXRmQ1jn";

    public void runOpMode() throws InterruptedException{

        waitForStart();

        while(opModeIsActive()){



            telemetry.update();
            idle();
        }
    }

    public void setupVuforia(){
        parameters = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforiaLocalizer = ClassFactory.createVuforiaLocalizer(parameters); //TODO?

        visionTarget = vuforiaLocalizer.loadTrackablesFromAsset("Skystone"); //TODO find the right image

        target = visionTarget.get(0); //TODO
        target.setName("Skystone Target");
        //target.setLocation(createMatrix());


    }


    //public OpenGLMatrix createMatrix(float)
}
