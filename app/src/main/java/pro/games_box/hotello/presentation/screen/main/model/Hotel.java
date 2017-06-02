package pro.games_box.hotello.presentation.screen.main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by Tesla on 01.06.2017.
 */

@Getter
@Setter
@Accessors(prefix = "m")
public class Hotel {
    private int mId;
    private String mName;
    private String mAddress;
    private int mStars;
    private Double mDistance;
    private String mSuitesAvailability;
    private String mImage;

    public Hotel(){

    }
}
