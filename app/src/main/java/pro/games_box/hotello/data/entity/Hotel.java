package pro.games_box.hotello.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tesla on 01.06.2017.
 */

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m")
public class Hotel {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("address")
    private String mAddress;

    @SerializedName("stars")
    private Integer mStars;

    @SerializedName("distance")
    private Double mDistance;

    @SerializedName("suites_availability")
    private String mSuitesAvailability;
}
