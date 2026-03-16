package org.firstinspires.ftc.teamcode.Robot;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.ST.constants.MecanumConstants;
import org.firstinspires.ftc.teamcode.ST.constants.ThreeWheelIMUConstants;

@Configurable
public class Constants {
    public static MecanumConstants mecanumConstants =
            new MecanumConstants()
                    .leftFrontDirection(DcMotor.Direction.FORWARD)
                    .leftRearDirection(DcMotor.Direction.FORWARD)
                    .rightFrontDirection(DcMotor.Direction.FORWARD)
                    .rightRearDirection(DcMotor.Direction.FORWARD)
                    .leftFrontZeroPower(DcMotor.ZeroPowerBehavior.BRAKE)
                    .rightFrontZeroPower(DcMotor.ZeroPowerBehavior.BRAKE)
                    .leftRearZeroPower(DcMotor.ZeroPowerBehavior.BRAKE)
                    .rightRearZeroPower(DcMotor.ZeroPowerBehavior.BRAKE)
                    .leftFrontName("leftFront")
                    .leftRearName("leftRear")
                    .rightFrontName("rightFront")
                    .rightRearName("rightRear");

    public static ThreeWheelIMUConstants localizerConstants =
            new ThreeWheelIMUConstants()
                    .forwardTicksToInches(-0.001966)
                    .strafeTicksToInches(-0.001988)
                    .turnTicksToInches(-0.001996)
                    .leftPodY(4.25)
                    .rightPodY(-4.25)
                    .strafePodX(-2.93)
                    .leftEncoderDirection(DcMotorSimple.Direction.FORWARD)
                    .rightEncoderDirection(DcMotorSimple.Direction.FORWARD)
                    .strafeEncoderDirection(DcMotorSimple.Direction.FORWARD)
                    .leftEncoderName("ver1")
                    .rightEncoderName("ver2")
                    .strafeEncoderName("par")
                    .imuName("imu")
                    .imuOrientation(
                            new RevHubOrientationOnRobot(
                                    RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                                    RevHubOrientationOnRobot.UsbFacingDirection.UP
                            )
                    );
}