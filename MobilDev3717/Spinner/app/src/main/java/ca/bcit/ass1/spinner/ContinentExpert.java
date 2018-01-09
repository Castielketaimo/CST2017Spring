package ca.bcit.ass1.spinner;

/**
 * Created by castiel on 2017-09-19.
 */

public class ContinentExpert {
    double getInput(String inputType, double speed) {
        double speedAfterConvert = 0;
        switch (inputType) {
            case "Kilometers per hour to Miles per hour":
                speedAfterConvert = speed * 0.6213712;
                break;
            case "Miles per hour to Kilometers per hour":
                speedAfterConvert = speed * 1.609344;
                break;
            case "Meters per second to Miles per hour":
                speedAfterConvert = speed * 2.236936;
                break;
            case "Miles per hour to Meters per second":
                speedAfterConvert = speed * 0.44704;
                break;
            case "Meters per second to Kilometers per hour":
                speedAfterConvert = speed * 3.6;
                break;
            case "Kilometers per hour to Meters per second":
                speedAfterConvert = speed * 0.2777778;
                break;
        }
        return  speedAfterConvert;
    }
}

