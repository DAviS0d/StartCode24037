package org.firstinspires.ftc.teamcode.ST.follower;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.ST.constants.MecanumConstants;
import org.firstinspires.ftc.teamcode.ST.constants.ThreeWheelIMUConstants;
import org.firstinspires.ftc.teamcode.ST.localization.Localizer;

public class MecanumDrive {

    private final DcMotorEx lf, lr, rf, rr;
    private final Localizer localizer;

    public MecanumDrive(HardwareMap hardwareMap, Localizer localizer) {
        MecanumConstants c = Constants.mecanumConstants;

        this.localizer = localizer;

        lf = hardwareMap.get(DcMotorEx.class, c.leftFrontName);
        lr = hardwareMap.get(DcMotorEx.class, c.leftRearName);
        rf = hardwareMap.get(DcMotorEx.class, c.rightFrontName);
        rr = hardwareMap.get(DcMotorEx.class, c.rightRearName);

        lf.setDirection(c.leftFrontDirection);
        lr.setDirection(c.leftRearDirection);
        rf.setDirection(c.rightFrontDirection);
        rr.setDirection(c.rightRearDirection);

        // Set zero power behavior
        lf.setZeroPowerBehavior(c.leftFrontZeroPower);
        lr.setZeroPowerBehavior(c.leftRearZeroPower);
        rf.setZeroPowerBehavior(c.rightFrontZeroPower);
        rr.setZeroPowerBehavior(c.rightRearZeroPower);
    }

    /**
     * TeleOp control for mecanum drive using Pedro Pathing denominator normalization
     *
     * @param forward forward/backward input (-1 to 1)
     * @param strafe left/right input (-1 to 1)
     * @param rotation rotation input (-1 to 1)
     * @param fieldCentric whether to use field-centric control
     */
    public void setTeleOpDrive(double forward, double strafe, double rotation, boolean fieldCentric) {
        if (fieldCentric) {
            double heading = localizer.getPose().heading;
            double temp = forward * Math.cos(heading) + strafe * Math.sin(heading);
            strafe = -forward * Math.sin(heading) + strafe * Math.cos(heading);
            forward = temp;
        }

        // Pedro Pathing denominator normalization
        double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(rotation), 1.0);
        double lfPower = (forward + strafe + rotation) / denominator;
        double lrPower = (forward - strafe + rotation) / denominator;
        double rfPower = (forward - strafe - rotation) / denominator;
        double rrPower = (forward + strafe - rotation) / denominator;

        lf.setPower(lfPower);
        lr.setPower(lrPower);
        rf.setPower(rfPower);
        rr.setPower(rrPower);
    }
}