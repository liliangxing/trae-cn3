package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class SingleFromUnsafeSource<T> extends Single<T> {
    final SingleSource<T> source;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(singleObserver);
    }
}
