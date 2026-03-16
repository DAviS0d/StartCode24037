package org.firstinspires.ftc.teamcode.ST.constants;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MecanumConstants {

    public String leftFrontName, leftRearName, rightFrontName, rightRearName;
    public DcMotor.Direction leftFrontDirection, leftRearDirection, rightFrontDirection, rightRearDirection;
    public DcMotor.ZeroPowerBehavior leftFrontZeroPower, leftRearZeroPower,rightFrontZeroPower,rightRearZeroPower;

    public MecanumConstants leftFrontZeroPower(DcMotor.ZeroPowerBehavior leftFrontZeroPower){
        this.leftFrontZeroPower = leftFrontZeroPower;
        return this;
    }
    public MecanumConstants leftRearZeroPower(DcMotor.ZeroPowerBehavior leftRearZeroPower){
        this.leftRearZeroPower = leftRearZeroPower;
        return this;
    }
    public MecanumConstants rightFrontZeroPower(DcMotor.ZeroPowerBehavior rightFrontZeroPower){
        this.rightFrontZeroPower = rightFrontZeroPower;
        return this;
    }
    public MecanumConstants rightRearZeroPower(DcMotor.ZeroPowerBehavior rightRearZeroPower){
        this.rightRearZeroPower = rightRearZeroPower;
        return this;
    }

    public MecanumConstants leftFrontName(String name){
        this.leftFrontName = name;
        return this;
    }

    public MecanumConstants rightFrontName(String name){
        this.rightFrontName = name;
        return this;
    }

    public MecanumConstants leftRearName(String name){
        this.leftRearName = name;
        return this;
    }

    public MecanumConstants rightRearName(String name){
        this.rightRearName = name;
        return this;
    }

    public MecanumConstants leftFrontDirection(DcMotor.Direction direction){
        this.leftFrontDirection = direction;
        return this;
    }
    public MecanumConstants rightFrontDirection(DcMotor.Direction direction){
        this.rightFrontDirection = direction;
        return this;
    }
    public MecanumConstants leftRearDirection(DcMotor.Direction direction){
        this.leftRearDirection = direction;
        return this;
    }
    public MecanumConstants rightRearDirection(DcMotor.Direction direction){
        this.rightRearDirection = direction;
        return this;
    }
}