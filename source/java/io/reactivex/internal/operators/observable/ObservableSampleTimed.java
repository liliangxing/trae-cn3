package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.period = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.emitLast = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.emitLast) {
            this.source.subscribe(new SampleTimedEmitLast(serializedObserver, this.period, this.unit, this.scheduler));
        } else {
            this.source.subscribe(new SampleTimedNoLast(serializedObserver, this.period, this.unit, this.scheduler));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> downstream;
        final long period;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final TimeUnit unit;
        Disposable upstream;

        abstract void complete();

        SampleTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.downstream = observer;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                Scheduler scheduler = this.scheduler;
                long j = this.period;
                DisposableHelper.replace(this.timer, scheduler.schedulePeriodicallyDirect(this, j, j, this.unit));
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            cancelTimer();
            this.downstream.onError(th);
        }

        public void onComplete() {
            cancelTimer();
            complete();
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }
}
