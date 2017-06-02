package pro.games_box.hotello.domain.executer;

import io.reactivex.Scheduler;

/**
 * Created by Tesla on 02.06.2017.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
