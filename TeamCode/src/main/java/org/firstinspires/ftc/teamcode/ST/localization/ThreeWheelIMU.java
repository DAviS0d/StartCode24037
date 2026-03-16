package org.firstinspires.ftc.teamcode.ST.localization;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.ST.constants.ThreeWheelIMUConstants;

public class ThreeWheelIMU {

    private final DcMotorEx leftEncoder;
    private final DcMotorEx rightEncoder;
    private final DcMotorEx strafeEncoder;
    private final IMU imu;

    private int lastLeftEncoder;
    private int lastRightEncoder;
    private int lastStrafeEncoder;

    public ThreeWheelIMU(HardwareMap hardwareMap) {

        ThreeWheelIMUConstants c = Constants.localizerConstants;

        leftEncoder = hardwareMap.get(DcMotorEx.class, c.leftEncoderName);
        rightEncoder = hardwareMap.get(DcMotorEx.class, c.rightEncoderName);
        strafeEncoder = hardwareMap.get(DcMotorEx.class, c.strafeEncoderName);

        leftEncoder.setDirection(c.leftEncoderDirection);
        rightEncoder.setDirection(c.rightEncoderDirection);
        strafeEncoder.setDirection(c.strafeEncoderDirection);

        imu = hardwareMap.get(IMU.class, c.imuName);
        imu.initialize(new IMU.Parameters(c.imuOrientation));

        lastLeftEncoder = leftEncoder.getCurrentPosition();
        lastRightEncoder = rightEncoder.getCurrentPosition();
        lastStrafeEncoder = strafeEncoder.getCurrentPosition();
    }

    public EncoderIMUData getTicksIMU() {

        int currentVer1 = leftEncoder.getCurrentPosition();
        int currentVer2 = rightEncoder.getCurrentPosition();
        int currentPar = strafeEncoder.getCurrentPosition();
        YawPitchRollAngles imuValues = imu.getRobotYawPitchRollAngles();

        int deltaVer1 = currentVer1 - lastLeftEncoder;
        int deltaVer2 = currentVer2 - lastRightEncoder;
        int deltaPar = currentPar - lastStrafeEncoder;

        lastLeftEncoder = currentVer1;
        lastRightEncoder = currentVer2;
        lastStrafeEncoder = currentPar;

        return new EncoderIMUData(deltaVer1, deltaVer2, deltaPar, imuValues);
    }
}