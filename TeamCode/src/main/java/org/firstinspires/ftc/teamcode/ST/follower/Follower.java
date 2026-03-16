package org.firstinspires.ftc.teamcode.ST.follower;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ST.follower.MecanumDrive;
import org.firstinspires.ftc.teamcode.ST.localization.Localizer;

public class Follower {

    private final MecanumDrive drive;
    private final Localizer localizer;

    public Follower(HardwareMap hardwareMap, Localizer localizer) {
        this.localizer = localizer;
        this.drive = new MecanumDrive(hardwareMap, localizer);
    }

    /**
     * TeleOp driving interface (Pedro Pathing style)
     *
     * @param forward forward/backward input (-1 to 1)
     * @param strafe left/right input (-1 to 1)
     * @param rotation rotation input (-1 to 1)
     * @param fieldCentric whether to use field-centric control
     */
    public void setTeleOpDrive(double forward, double strafe, double rotation, boolean fieldCentric) {
        drive.setTeleOpDrive(forward, strafe, rotation, fieldCentric);
    }

    // You can also add autonomous helper methods here, e.g.
    // followPath(), updateFollower(), etc.
}