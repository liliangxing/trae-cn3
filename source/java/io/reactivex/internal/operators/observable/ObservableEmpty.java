package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {
    public static final Observable<Object> INSTANCE = new ObservableEmpty();

    public Object call() {
        return null;
    }

    private ObservableEmpty() {
    }

    protected void subscribeActual(Observer<? super Object> observer) {
        EmptyDisposable.complete(observer);
    }
}
