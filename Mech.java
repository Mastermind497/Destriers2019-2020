/*
 * The Methods code for the Destriers
 * Created by Team Member Joshua Faber
 */


package org.firstinspires.ftc.teamcode;
import java.lang.*;
import java.util.*;
import java.lang.Math;

public class Mech {

    /*//find the power for the front right and back left motors
    public static double FRBL(double x, double y)
        {
            double theta;
            try {
                theta = java.lang.Math.atan(y / x);
                if (x < 0) {
                    theta = theta + Math.PI;
                }
            } catch (Exception e) {
                if (y < 0) {
                    theta=-Math.PI/2;
                } else {
                    theta=Math.PI/2;
                }
            }

            theta=theta-(Math.PI/4);
            double power=java.lang.Math.sin(theta)*0.8;

            return power;
        }


    //find the power for the front left and back right motors
    public static double FLBR (double x, double y)
    {
        double theta;
        try {
            theta = java.lang.Math.atan(y / x);
            if (x < 0) {
                theta = theta + Math.PI;
            }
        } catch (Exception e) {
            if (y < 0) {
                theta=-Math.PI/2;
            } else {
                theta=Math.PI/2;
            }
        }

        theta=theta-(Math.PI/4);
        double power=java.lang.Math.cos(theta) * 0.8;

        return power;
    }*/


    public static double[] Driving (double x, double y)
    {
        double firstBasis = x + y;
        double secondBasis = y - x;
        firstBasis = firstBasis/java.lang.Math.sqrt(2);
        secondBasis = secondBasis/java.lang.Math.sqrt(2);
        double [] drivingPower = {firstBasis, secondBasis};
        return drivingPower;
    }


    public static double[] Turning (int CW, double power)
    {
        double leftPower = -CW * power;
        double rightPower = CW * power;
        double [] turningPower = {leftPower, rightPower};
        return turningPower;
    }
}




