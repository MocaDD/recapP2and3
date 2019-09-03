package P3;

import com.sun.istack.internal.NotNull;

import java.util.Random;

public class Car {

    private double gallons;
    private double milesDriven;
    private boolean brokenDown;
    private double milesPerGallon;

    public Car(@NotNull double gallons, @NotNull double milesDriven, @NotNull double milesPerGallon)    {
        this.gallons = gallons;
        this.milesDriven = milesDriven;
        this.brokenDown = false;
        this.milesPerGallon = milesPerGallon;
    }

    public boolean turnOnAndDrive(double milesToDrive) {

        Random random = new Random();

        if (brokenDown && gallons == 0) {
            return false;
        } else {
            if (milesToDrive <= 10000) {
                if (random.nextInt(10) == 0) {
                    brokenDown = true;
                    return false;
                } else {
                    return drive(milesToDrive);
                }
            }

            if (milesToDrive >= 10001 && milesToDrive <= 20000) {
                if (random.nextInt(20) == 0) {
                    brokenDown = true;
                    return false;
                } else {
                    return drive(milesToDrive);
                }
            }
        }
        return false;
    }

    private boolean drive(double milesToDrive) {
        double range = milesPerGallon * gallons;
        if (range >= milesToDrive) {
            gallons = gallons - (milesToDrive / milesPerGallon);
            milesDriven = milesDriven + milesToDrive;
            return true;
        } else {
            gallons = 0;
            milesDriven = milesDriven + range;
            return false;
        }
    }

    public void fillGas(double numberOfGallons) {
        gallons = numberOfGallons;
    }

    public boolean isBrokenDown()   {
        return brokenDown;
    }

    public double getMileage() {
        return milesDriven;
    }

    public void repair()    {
        brokenDown = false;
    }

    public double getGallons() {
        return gallons;
    }
}