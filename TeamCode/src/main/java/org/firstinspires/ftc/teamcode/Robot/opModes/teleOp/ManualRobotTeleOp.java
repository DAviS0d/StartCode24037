package org.firstinspires.ftc.teamcode.Robot.opModes.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ST.follower.Follower;
import org.firstinspires.ftc.teamcode.ST.localization.Localizer;
import org.firstinspires.ftc.teamcode.ST.localization.ThreeWheelIMU;
import org.firstinspires.ftc.teamcode.ST.localization.localizers.ThreeWheelIMULocalizer;

@TeleOp(name = "ManualRobotTeleOp", group = "use")
public class ManualRobotTeleOp extends OpMode {
    ThreeWheelIMULocalizer threeWheelIMULocalizer = new ThreeWheelIMULocalizer(hardwareMap);
    Follower follower = new Follower(hardwareMap, threeWheelIMULocalizer);
    private double forward = 0.0, strafe = 0.0, rotation = 0.0;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        follower.setTeleOpDrive(
                forward,
                strafe,
                rotation,
                true
        );
        telemetry.addData("x", threeWheelIMULocalizer.getPose().x);
        telemetry.addData("y", threeWheelIMULocalizer.getPose().y);
        telemetry.addData("heading", Math.toDegrees(threeWheelIMULocalizer.getPose().heading));
    }
}
