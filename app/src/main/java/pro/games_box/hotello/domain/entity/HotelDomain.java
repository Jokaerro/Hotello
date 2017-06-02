package pro.games_box.hotello.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by Tesla on 02.06.2017.
 */

@Getter
@Setter
@Accessors(prefix = "m")
public class HotelDomain {
    private int mId;
    private String mName;
    private String mAddress;
    private int mStars;
    private Double mDistance;
    private String mSuitesAvailability;
    private String mImage;

    private HotelDetailDomain mDetails;
}
