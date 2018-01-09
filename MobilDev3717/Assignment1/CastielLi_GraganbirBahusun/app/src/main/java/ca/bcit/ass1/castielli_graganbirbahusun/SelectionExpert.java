package ca.bcit.ass1.castielli_graganbirbahusun;

public class SelectionExpert {
    double getOutput(String inputType, double speed) {
        double speedAfterConvert = 0;
        switch (inputType) {
            case "Kilometers per hour to Miles per hour":
                speedAfterConvert = speed * 0.6213712;
                break;
            case "キロメートル/時間/マイル/時":
                speedAfterConvert = speed * 0.6213712;
                break;
            case "Miles per hour to Kilometers per hour":
                speedAfterConvert = speed * 1.609344;
                break;
            case "時間あたりのマイル数/キロメートル/時":
                speedAfterConvert = speed * 1.609344;
                break;
            case "Meters per second to Miles per hour":
                speedAfterConvert = speed * 2.236936;
                break;
            case "時間あたりのメーター/マイル/時":
                speedAfterConvert = speed * 2.236936;
                break;
            case "Miles per hour to Meters per second":
                speedAfterConvert = speed * 0.44704;
                break;
            case "時間あたりのマイル数/秒":
                speedAfterConvert = speed * 0.44704;
                break;
            case "Meters per second to Kilometers per hour":
                speedAfterConvert = speed * 3.6;
                break;
            case "秒あたりのメーター/キロメートル/時":
                speedAfterConvert = speed * 3.6;
                break;
            case "Kilometers per hour to Meters per second":
                speedAfterConvert = speed * 0.2777778;
                break;
            case "キロメートル/メートル/秒":
                speedAfterConvert = speed * 0.2777778;
                break;
        }
        return  speedAfterConvert;
    }
}

