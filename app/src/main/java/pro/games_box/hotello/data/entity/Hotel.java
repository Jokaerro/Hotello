package pro.games_box.hotello.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tesla on 01.06.2017.
 */

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m")
public class Hotel implements Serializable {
    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("address")
    private String mAddress;

    @SerializedName("stars")
    private int mStars;

    @SerializedName("distance")
    private Double mDistance;

    @SerializedName("suites_availability")
    private String mSuitesAvailability;

    public int getFreeRoomsCount(){
        return mSuitesAvailability.split(":").length;
    }

    public int getDistance(){
        return mDistance.intValue();
    }
}
