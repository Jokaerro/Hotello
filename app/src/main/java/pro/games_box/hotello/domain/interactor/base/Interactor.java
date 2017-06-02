package pro.games_box.hotello.domain.interactor.base;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import pro.games_box.hotello.domain.executer.PostExecutionThread;
import pro.games_box.hotello.domain.executer.ThreadExecutor;

/**
 * Created by Tesla on 02.06.2017.
 */

public abstract class Interactor<T, Params> {
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private final CompositeDisposable disposables;

    protected Interactor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    protected abstract Observable<T> buildObservable(Params params);

    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = this.buildObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
