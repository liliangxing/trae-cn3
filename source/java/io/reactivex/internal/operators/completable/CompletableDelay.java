package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.source = completableSource;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(completableObserver, this.delay, this.unit, this.scheduler, this.delayError));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
        private static final long serialVersionUID = 465972761105851022L;
        final long delay;
        final boolean delayError;
        final CompletableObserver downstream;
        Throwable error;
        final Scheduler scheduler;
        final TimeUnit unit;

        Delay(CompletableObserver completableObserver, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.downstream = completableObserver;
            this.delay = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.delayError = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this, this.delay, this.unit));
        }

        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this, this.delayError ? this.delay : 0L, this.unit));
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            this.error = null;
            if (th != null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onComplete();
            }
        }
    }
}
