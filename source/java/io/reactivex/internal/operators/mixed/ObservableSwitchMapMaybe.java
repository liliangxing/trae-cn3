package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {
    final boolean delayErrors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final Observable<T> source;

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.source = observable;
        this.mapper = function;
        this.delayErrors = z;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.tryAsMaybe(this.source, this.mapper, observer)) {
            return;
        }
        this.source.subscribe(new SwitchMapMaybeMainObserver(observer, this.mapper, this.delayErrors));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        Disposable upstream;

        SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.dispose();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!UByte$$ExternalSyntheticBackport0.m37m((AtomicReference) this.inner, (Object) switchMapMaybeObserver, (Object) switchMapMaybeObserver3));
                maybeSource.subscribe(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                this.inner.getAndSet(INNER_DISPOSED);
                onError(th);
            }
        }

        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void disposeInner() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = INNER_DISPOSED;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.getAndSet(switchMapMaybeObserver);
            if (switchMapMaybeObserver2 == null || switchMapMaybeObserver2 == switchMapMaybeObserver) {
                return;
            }
            switchMapMaybeObserver2.dispose();
        }

        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (UByte$$ExternalSyntheticBackport0.m37m((AtomicReference) this.inner, (Object) switchMapMaybeObserver, (Object) null) && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    disposeInner();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (UByte$$ExternalSyntheticBackport0.m37m((AtomicReference) this.inner, (Object) switchMapMaybeObserver, (Object) null)) {
                drain();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            int i = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    observer.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z2 = switchMapMaybeObserver == null;
                if (z && z2) {
                    Throwable terminate = atomicThrowable.terminate();
                    if (terminate != null) {
                        observer.onError(terminate);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                if (!z2 && switchMapMaybeObserver.item != null) {
                    UByte$$ExternalSyntheticBackport0.m37m((AtomicReference) atomicReference, (Object) switchMapMaybeObserver, (Object) null);
                    observer.onNext(switchMapMaybeObserver.item);
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapMaybeMainObserver<?, R> parent;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.parent = switchMapMaybeMainObserver;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }

            public void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            public void onComplete() {
                this.parent.innerComplete(this);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
