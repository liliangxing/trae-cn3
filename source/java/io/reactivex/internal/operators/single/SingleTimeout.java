package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class SingleTimeout<T> extends Single<T> {
    final SingleSource<? extends T> other;
    final Scheduler scheduler;
    final SingleSource<T> source;
    final long timeout;
    final TimeUnit unit;

    public SingleTimeout(SingleSource<T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.source = singleSource;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = singleSource2;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.other, this.timeout, this.unit);
        singleObserver.onSubscribe(timeoutMainObserver);
        DisposableHelper.replace(timeoutMainObserver.task, this.scheduler.scheduleDirect(timeoutMainObserver, this.timeout, this.unit));
        this.source.subscribe(timeoutMainObserver);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        private static final long serialVersionUID = 37497744973048446L;
        final SingleObserver<? super T> downstream;
        final TimeoutFallbackObserver<T> fallback;
        SingleSource<? extends T> other;
        final AtomicReference<Disposable> task = new AtomicReference<>();
        final long timeout;
        final TimeUnit unit;

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final SingleObserver<? super T> downstream;

            TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
                this.downstream = singleObserver;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t) {
                this.downstream.onSuccess(t);
            }

            public void onError(Throwable th) {
                this.downstream.onError(th);
            }
        }

        TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit) {
            this.downstream = singleObserver;
            this.other = singleSource;
            this.timeout = j;
            this.unit = timeUnit;
            if (singleSource != null) {
                this.fallback = new TimeoutFallbackObserver<>(singleObserver);
            } else {
                this.fallback = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            DisposableHelper disposableHelper = (Disposable) get();
            if (disposableHelper == DisposableHelper.DISPOSED || !compareAndSet(disposableHelper, DisposableHelper.DISPOSED)) {
                return;
            }
            if (disposableHelper != null) {
                disposableHelper.dispose();
            }
            SingleSource<? extends T> singleSource = this.other;
            if (singleSource == null) {
                this.downstream.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.timeout, this.unit)));
            } else {
                this.other = null;
                singleSource.subscribe(this.fallback);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t) {
            DisposableHelper disposableHelper = (Disposable) get();
            if (disposableHelper == DisposableHelper.DISPOSED || !compareAndSet(disposableHelper, DisposableHelper.DISPOSED)) {
                return;
            }
            DisposableHelper.dispose(this.task);
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            DisposableHelper disposableHelper = (Disposable) get();
            if (disposableHelper != DisposableHelper.DISPOSED && compareAndSet(disposableHelper, DisposableHelper.DISPOSED)) {
                DisposableHelper.dispose(this.task);
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.dispose(timeoutFallbackObserver);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}
