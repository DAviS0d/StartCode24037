package org.firstinspires.ftc.teamcode.ST.constants;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class ThreeWheelConstants {

    public double forwardTicksToInches;
    public double strafeTicksToInches;
    public double turnTicksToInches;

    public double leftPodY;
    public double rightPodY;
    public double strafePodX;

    public DcMotorEx.Direction leftEncoderDirection;
    public DcMotorEx.Direction rightEncoderDirection;
    public DcMotorEx.Direction strafeEncoderDirection;

    public String leftEncoderName;
    public String rightEncoderName;
    public String strafeEncoderName;

    public String imuName;

    public RevHubOrientationOnRobot imuOrientation;

    public ThreeWheelConstants forwardTicksToInches(double v){
        this.forwardTicksToInches = v;
        return this;
    }

    public ThreeWheelConstants strafeTicksToInches(double v){
        this.strafeTicksToInches = v;
        return this;
    }

    public ThreeWheelConstants turnTicksToInches(double v){
        this.turnTicksToInches = v;
        return this;
    }

    public ThreeWheelConstants leftPodY(double v){
        this.leftPodY = v;
        return this;
    }

    public ThreeWheelConstants rightPodY(double v){
        this.rightPodY = v;
        return this;
    }

    public ThreeWheelConstants strafePodX(double v){
        this.strafePodX = v;
        return this;
    }

    public ThreeWheelConstants leftEncoderDirection(DcMotorSimple.Direction d){
        this.leftEncoderDirection = d;
        return this;
    }

    public ThreeWheelConstants rightEncoderDirection(DcMotorSimple.Direction d){
        this.rightEncoderDirection = d;
        return this;
    }

    public ThreeWheelConstants strafeEncoderDirection(DcMotorSimple.Direction d){
        this.strafeEncoderDirection = d;
        return this;
    }

    public ThreeWheelConstants leftEncoderName(String name){
        this.leftEncoderName = name;
        return this;
    }

    public ThreeWheelConstants rightEncoderName(String name){
        this.rightEncoderName = name;
        return this;
    }

    public ThreeWheelConstants strafeEncoderName(String name){
        this.strafeEncoderName = name;
        return this;
    }

}