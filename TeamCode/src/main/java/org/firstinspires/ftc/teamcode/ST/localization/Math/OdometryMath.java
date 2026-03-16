package org.firstinspires.ftc.teamcode.ST.localization.Math;

public class OdometryMath {

    public static double[] robotDelta(
            double dL,
            double dR,
            double dP,
            double dTheta,
            double forwardOffset
    ){

        double dx = (dL + dR) / 2.0;
        double dy = dP - forwardOffset * dTheta;

        return new double[]{dx,dy};
    }
}