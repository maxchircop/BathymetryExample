/**
 * Created by Maximilian Chircop.
 * Date: 30/03/2020
 * Brief: Hold info for a lat and long with an associated depth
 */
public class Data {
    double latitude;
    double longitude;
    double depth;

    public Data(double lattitude, double longitude, double depth){
        this.latitude=lattitude;
        this.longitude=longitude;
        this.depth=depth;
    }

    public String toString(){
        return "Latitude "+latitude+" & longitude "+longitude+" has a depth of "+depth+" meters";
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDepth() {
        return depth;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
