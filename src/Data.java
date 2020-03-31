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
        return latitude+" & "+longitude+" has a depth of "+depth;
    }
}
