package org.firstinspires.ftc.teamcode.ST.constants;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

public class ThreeWheelIMUConstants {

    public double forwardTicksToInches;
    public double strafeTicksToInches;
    public double turnTicksToInches;

    public double leftPodY;
    public double rightPodY;
    public double strafePodX;

    public String leftEncoderName;
    public String rightEncoderName;
    public String strafeEncoderName;

    public String imuName;

    public RevHubOrientationOnRobot imuOrientation;

    public ThreeWheelIMUConstants forwardTicksToInches(double v){
        this.forwardTicksToInches = v;
        return this;
    }

    public ThreeWheelIMUConstants strafeTicksToInches(double v){
        this.strafeTicksToInches = v;
        return this;
    }

    public ThreeWheelIMUConstants turnTicksToInches(double v){
        this.turnTicksToInches = v;
        return this;
    }

    public ThreeWheelIMUConstants leftPodY(double v){
        this.leftPodY = v;
        return this;
    }

    public ThreeWheelIMUConstants rightPodY(double v){
        this.rightPodY = v;
        return this;
    }

    public ThreeWheelIMUConstants strafePodX(double v){
        this.strafePodX = v;
        return this;
    }

    public ThreeWheelIMUConstants leftEncoderName(String name){
        this.leftEncoderName = name;
        return this;
    }

    public ThreeWheelIMUConstants rightEncoderName(String name){
        this.rightEncoderName = name;
        return this;
    }

    public ThreeWheelIMUConstants strafeEncoderName(String name){
        this.strafeEncoderName = name;
        return this;
    }

    public ThreeWheelIMUConstants imuName(String name){
        this.imuName = name;
        return this;
    }

    public ThreeWheelIMUConstants imuOrientation(RevHubOrientationOnRobot orientation){
        this.imuOrientation = orientation;
        return this;
    }
}