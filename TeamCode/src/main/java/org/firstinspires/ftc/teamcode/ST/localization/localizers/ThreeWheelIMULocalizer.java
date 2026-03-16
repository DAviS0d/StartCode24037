package org.firstinspires.ftc.teamcode.ST.localization.localizers;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.ST.constants.ThreeWheelIMUConstants;
import org.firstinspires.ftc.teamcode.ST.localization.EncoderIMUData;
import org.firstinspires.ftc.teamcode.ST.localization.Localizer;
import org.firstinspires.ftc.teamcode.ST.localization.Pose;
import org.firstinspires.ftc.teamcode.ST.localization.ThreeWheelIMU;

public class ThreeWheelIMULocalizer implements Localizer {

    private Pose pose = new Pose();
    private final ThreeWheelIMU threeWheelIMU;
    private final ThreeWheelIMUConstants c = Constants.localizerConstants;
    private double lastHeading;
    private double lastTime;

    // Velocities
    private double vx = 0, vy = 0, omega = 0;

    public ThreeWheelIMULocalizer(HardwareMap hardwareMap) {
        threeWheelIMU = new ThreeWheelIMU(hardwareMap);

        EncoderIMUData init = threeWheelIMU.getTicksIMU();
        lastHeading = init.IMUValues.getYaw(AngleUnit.RADIANS);
        pose.heading = lastHeading;

        lastTime = System.nanoTime() / 1e9;
    }

    /**
     * Set the robot's starting position on the field.
     * The origin (0,0) is the bottom-left corner of the field.
     *
     * @param xField X position in inches from bottom-left corner
     * @param yField Y position in inches from bottom-left corner
     * @param headingField Initial heading in radians (0 = forward along field Y)
     */
    public void setFieldStartingPose(double xField, double yField, double headingField) {
        this.pose = new Pose(xField, yField, headingField);
        this.lastHeading = headingField;
    }

    @Override
    public void update() {
        EncoderIMUData ticks = threeWheelIMU.getTicksIMU();
        double heading = ticks.IMUValues.getYaw(AngleUnit.RADIANS);
        double dTheta = heading - lastHeading;
        lastHeading = heading;

        double dL = ticks.ver1 * c.forwardTicksToInches;
        double dR = ticks.ver2 * c.forwardTicksToInches;
        double dP = ticks.par * c.strafeTicksToInches;

        double dx = (dL + dR) / 2.0;
        double dy = dP - c.strafePodX * dTheta;

        double dxRobot, dyRobot;
        if (Math.abs(dTheta) < 1e-6) {
            dxRobot = dx;
            dyRobot = dy;
        } else {
            double r = dx / dTheta;
            dxRobot = r * Math.sin(dTheta);
            dyRobot = r * (1 - Math.cos(dTheta)) + dy;
        }

        double midHeading = pose.heading + dTheta / 2.0;
        double cos = Math.cos(midHeading);
        double sin = Math.sin(midHeading);

        pose.x += dxRobot * cos - dyRobot * sin;
        pose.y += dxRobot * sin + dyRobot * cos;
        pose.heading = normalize(heading);

        double currentTime = System.nanoTime() / 1e9;
        double dt = currentTime - lastTime;
        lastTime = currentTime;

        if (dt > 0) {
            vx = (dxRobot * Math.cos(pose.heading) - dyRobot * Math.sin(pose.heading)) / dt;
            vy = (dxRobot * Math.sin(pose.heading) + dyRobot * Math.cos(pose.heading)) / dt;
            omega = dTheta / dt;
        }
    }

    @Override
    public Pose getPose() {
        return pose;
    }

    @Override
    public void setPose(Pose pose) {
        this.pose = pose;
        this.lastHeading = pose.heading;
    }

    public void reset(Pose pose) {
        this.pose = pose;
        this.lastHeading = pose.heading;
    }

    private double normalize(double angle) {
        while (angle > Math.PI) angle -= 2 * Math.PI;
        while (angle < -Math.PI) angle += 2 * Math.PI;
        return angle;
    }

    // Velocity getters
    public double getVx() { return vx; }
    public double getVy() { return vy; }
    public double getOmega() { return omega; }
}