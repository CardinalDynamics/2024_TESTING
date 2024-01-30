package frc.robot.subsystems;

import static frc.robot.Constants.IntakeConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    CANSparkMax topShooter;
    CANSparkMax bottomShooter;
    CANSparkMax feeder;

    // constructor
    public Intake () {
        topShooter = new CANSparkMax(kTopShooter, MotorType.kBrushless);
        bottomShooter = new CANSparkMax(kBottomShooter, MotorType.kBrushless);
        feeder = new CANSparkMax(kFeeder, MotorType.kBrushless);
        
        // bottomshooter follows top shooter
        bottomShooter.follow(topShooter);

        // Top and bottom shooter should both be going outwards given positive input. Feeder should intake.
        bottomShooter.setInverted(false);
        topShooter.setInverted(false);
        feeder.setInverted(false);
    }

    public void shootNote(double shooterSpeed) {
        topShooter.set(shooterSpeed);
        // maybe will have feeder run here to push the note into the shooter?
    }

    public void intakeNote() {
        // speed can be paramater later
        feeder.set(.5);
    }

}
