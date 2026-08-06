package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class MaybeCreate<T> extends Maybe<T> {
    final MaybeOnSubscribe<T> source;

    public MaybeCreate(MaybeOnSubscribe<T> maybeOnSubscribe) {
        this.source = maybeOnSubscribe;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Emitter emitter = new Emitter(maybeObserver);
        maybeObserver.onSubscribe(emitter);
        try {
            this.source.subscribe(emitter);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            emitter.onError(th);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    static final class Emitter<T> extends AtomicReference<Disposable> implements MaybeEmitter<T>, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;
        final MaybeObserver<? super T> downstream;

        Emitter(MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        public void onSuccess(T t) {
            DisposableHelper disposableHelper;
            if (get() == DisposableHelper.DISPOSED || (disposableHelper = (Disposable) getAndSet(DisposableHelper.DISPOSED)) == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                if (t == null) {
                    this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.downstream.onSuccess(t);
                }
                if (disposableHelper != null) {
                    disposableHelper.dispose();
                }
            } catch (Throwable th) {
                if (disposableHelper != null) {
                    disposableHelper.dispose();
                }
                throw th;
            }
        }

        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public boolean tryOnError(Throwable th) {
            DisposableHelper disposableHelper;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (get() == DisposableHelper.DISPOSED || (disposableHelper = (Disposable) getAndSet(DisposableHelper.DISPOSED)) == DisposableHelper.DISPOSED) {
                return false;
            }
            try {
                this.downstream.onError(th);
            } finally {
                if (disposableHelper != null) {
                    disposableHelper.dispose();
                }
            }
        }

        public void onComplete() {
            DisposableHelper disposableHelper;
            if (get() == DisposableHelper.DISPOSED || (disposableHelper = (Disposable) getAndSet(DisposableHelper.DISPOSED)) == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                if (disposableHelper != null) {
                    disposableHelper.dispose();
                }
            }
        }

        public void setDisposable(Disposable disposable) {
            DisposableHelper.set(this, disposable);
        }

        public void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }
}
