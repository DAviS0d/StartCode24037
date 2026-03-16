package org.firstinspires.ftc.teamcode.ST.localization;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class EncoderIMUData {

    public double ver1;
    public double ver2;
    public double par;
    public YawPitchRollAngles IMUValues;

    public EncoderIMUData(double ver1, double ver2, double par, YawPitchRollAngles IMUValues) {
        this.ver1 = ver1;
        this.ver2 = ver2;
        this.par = par;
        this.IMUValues = IMUValues;
    }
}