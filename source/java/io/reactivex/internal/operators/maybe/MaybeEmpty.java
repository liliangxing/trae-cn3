package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class MaybeEmpty extends Maybe<Object> implements ScalarCallable<Object> {
    public static final MaybeEmpty INSTANCE = new MaybeEmpty();

    public Object call() {
        return null;
    }

    protected void subscribeActual(MaybeObserver<? super Object> maybeObserver) {
        EmptyDisposable.complete(maybeObserver);
    }
}
