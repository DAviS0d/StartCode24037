package org.firstinspires.ftc.teamcode.Robot;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

import org.firstinspires.ftc.teamcode.ST.constants.ThreeWheelIMUConstants;

@Configurable
public class Constants {

    public static ThreeWheelIMUConstants localizerConstants =
            new ThreeWheelIMUConstants()
                    .forwardTicksToInches(-0.001966)
                    .strafeTicksToInches(-0.001988)
                    .turnTicksToInches(-0.001996)
                    .leftPodY(4.25)
                    .rightPodY(-4.25)
                    .strafePodX(-2.93)
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