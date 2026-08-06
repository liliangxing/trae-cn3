package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class CompletableNever extends Completable {
    public static final Completable INSTANCE = new CompletableNever();

    private CompletableNever() {
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
