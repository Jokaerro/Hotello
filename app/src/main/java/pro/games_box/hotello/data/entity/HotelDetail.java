package pro.games_box.hotello.data.entity;

import com.google.gson.annotations.SerializedName;

import android.location.Location;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import pro.games_box.hotello.presentation.application.Config;

/**
 * Created by Tesla on 01.06.2017.
 */

@Getter
@Setter
@Accessors(prefix = "m")
public class HotelDetail extends Hotel implements Serializable {

    @SerializedName("image")
    public String mImage;
    public String getImage(){
        return "https://github.com/iMofas/ios-android-test/raw/master/" + mImage;
    }

    @SerializedName("lat")
    public Double mLat;

    @SerializedName("lon")
    public Double mLon;

    public int getDistanceInMetres() {
        float [] dist = new float[1];
        Location.distanceBetween(Config.centralParkNewYorkLat, Config.centralParkNewYorkLong, mLat, mLon, dist);
        return Math.round(dist[0]);
    }
}
