package pro.games_box.hotello.data.entity;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by Tesla on 01.06.2017.
 */

@Getter
@Setter
@Accessors(prefix = "m")
public class HotelDetail {

    @SerializedName("id")
    public Integer mId;

    @SerializedName("name")
    public String mName;

    @SerializedName("address")
    public String mAddress;

    @SerializedName("stars")
    public Double mStars;

    @SerializedName("distance")
    public Double mDistance;

    @SerializedName("image")
    public String mImage;

    @SerializedName("suites_availability")
    public String mSuitesAvailability;

    @SerializedName("lat")
    public Double mLat;

    @SerializedName("lon")
    public Double mLon;
}
