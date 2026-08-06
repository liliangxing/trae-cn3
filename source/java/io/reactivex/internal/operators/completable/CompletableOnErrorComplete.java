package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class CompletableOnErrorComplete extends Completable {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.source = completableSource;
        this.predicate = predicate;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new OnError(completableObserver));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    final class OnError implements CompletableObserver {
        private final CompletableObserver downstream;

        OnError(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.predicate.test(th)) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(new CompositeException(new Throwable[]{th, th2}));
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }
    }
}
