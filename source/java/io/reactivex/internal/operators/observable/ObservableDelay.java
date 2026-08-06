package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableDelay(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DelayObserver(this.delayError ? observer : new SerializedObserver(observer), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final long delay;
        final boolean delayError;
        final Observer<? super T> downstream;
        final TimeUnit unit;
        Disposable upstream;

        /* renamed from: w */
        final Scheduler.Worker f41w;

        DelayObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.downstream = observer;
            this.delay = j;
            this.unit = timeUnit;
            this.f41w = worker;
            this.delayError = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41w.schedule(new OnNext(t), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            this.f41w.schedule(new OnError(th), this.delayError ? this.delay : 0L, this.unit);
        }

        public void onComplete() {
            this.f41w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void dispose() {
            this.upstream.dispose();
            this.f41w.dispose();
        }

        public boolean isDisposed() {
            return this.f41w.isDisposed();
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        final class OnNext implements Runnable {

            /* renamed from: t */
            private final T f42t;

            OnNext(T t) {
                this.f42t = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelayObserver.this.downstream.onNext(this.f42t);
            }
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        final class OnError implements Runnable {
            private final Throwable throwable;

            OnError(Throwable th) {
                this.throwable = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.downstream.onError(this.throwable);
                } finally {
                    DelayObserver.this.f41w.dispose();
                }
            }
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.downstream.onComplete();
                } finally {
                    DelayObserver.this.f41w.dispose();
                }
            }
        }
    }
}
