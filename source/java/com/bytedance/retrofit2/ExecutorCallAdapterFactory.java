package com.bytedance.retrofit2;

import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ExecutorCallAdapterFactory extends CallAdapter.Factory {
    final Executor callbackExecutor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        final Type callResponseType = Utils.getCallResponseType(type);
        final Executor executor = Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class) ? null : this.callbackExecutor;
        return new CallAdapter<Object, Call<?>>() { // from class: com.bytedance.retrofit2.ExecutorCallAdapterFactory.1
            @Override // com.bytedance.retrofit2.CallAdapter
            public Type responseType() {
                return callResponseType;
            }

            @Override // com.bytedance.retrofit2.CallAdapter
            /* renamed from: adapt */
            public Call<?> adapt2(Call<Object> call) {
                return executor == null ? call : new ExecutorCallbackCall(executor, call);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class ExecutorCallbackCall<T> implements Call<T>, IMetricsCollect {
        final Executor callbackExecutor;
        final Call<T> delegate;

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // com.bytedance.retrofit2.Call
        public void enqueue(@Nullable final Callback<T> callback) {
            Utils.checkNotNull(callback, "callback == null");
            this.delegate.enqueue(new ExpandCallback<T>() { // from class: com.bytedance.retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1
                @Override // com.bytedance.retrofit2.ExpandCallback
                public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                    Callback callback2 = callback;
                    if (callback2 instanceof ExpandCallback) {
                        ((ExpandCallback) callback2).onAsyncPreRequest(requestBuilder);
                    }
                }

                @Override // com.bytedance.retrofit2.Callback
                public void onResponse(Call<T> call, final SsResponse<T> ssResponse) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() { // from class: com.bytedance.retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                                callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                            } else {
                                callback.onResponse(ExecutorCallbackCall.this, ssResponse);
                            }
                        }
                    });
                }

                @Override // com.bytedance.retrofit2.ExpandCallback
                public void onAsyncResponse(Call<T> call, SsResponse<T> ssResponse) {
                    Callback callback2 = callback;
                    if (callback2 instanceof ExpandCallback) {
                        ((ExpandCallback) callback2).onAsyncResponse(call, ssResponse);
                    }
                }

                @Override // com.bytedance.retrofit2.Callback
                public void onFailure(Call<T> call, final Throwable th) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() { // from class: com.bytedance.retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onFailure(ExecutorCallbackCall.this, th);
                        }
                    });
                }
            });
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // com.bytedance.retrofit2.Call
        @Deprecated
        public SsResponse execute() throws Exception {
            return this.delegate.execute();
        }

        @Override // com.bytedance.retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // com.bytedance.retrofit2.Call
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Call<T> m812clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.m812clone());
        }

        @Override // com.bytedance.retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // com.bytedance.retrofit2.IMetricsCollect
        public void doCollect() {
            Call<T> call = this.delegate;
            if (call instanceof IMetricsCollect) {
                ((IMetricsCollect) call).doCollect();
            }
        }

        public boolean setThrottleNetSpeed(long j) {
            Call<T> call = this.delegate;
            if (call instanceof SsHttpCall) {
                return ((SsHttpCall) call).setThrottleNetSpeed(j);
            }
            return false;
        }
    }
}
