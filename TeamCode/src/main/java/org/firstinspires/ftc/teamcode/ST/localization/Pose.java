package org.firstinspires.ftc.teamcode.ST.localization;

public class Pose {

    public double x;
    public double y;
    public double heading;

    public Pose() {
        this(0,0,0);
    }

    public Pose(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

}