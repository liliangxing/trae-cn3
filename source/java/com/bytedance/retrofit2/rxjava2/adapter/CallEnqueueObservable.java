package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class CallEnqueueObservable<T> extends Observable<SsResponse<T>> {
    private final Call<T> originalCall;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    protected void subscribeActual(Observer<? super SsResponse<T>> observer) {
        Call<T> clone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(clone, observer);
        observer.onSubscribe(callCallback);
        clone.enqueue(callCallback);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class CallCallback<T> implements Disposable, Callback<T> {
        private final Call<?> call;
        private final Observer<? super SsResponse<T>> observer;
        boolean terminated = false;

        CallCallback(Call<?> call, Observer<? super SsResponse<T>> observer) {
            this.call = call;
            this.observer = observer;
        }

        @Override // com.bytedance.retrofit2.Callback
        public void onResponse(Call<T> call, SsResponse<T> ssResponse) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onNext(ssResponse);
                if (call.isCanceled()) {
                    return;
                }
                this.terminated = true;
                this.observer.onComplete();
            } catch (Throwable th) {
                if (this.terminated) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                if (call.isCanceled()) {
                    return;
                }
                try {
                    this.observer.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th2}));
                }
            }
        }

        @Override // com.bytedance.retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onError(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th2}));
            }
        }

        public void dispose() {
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }
}
