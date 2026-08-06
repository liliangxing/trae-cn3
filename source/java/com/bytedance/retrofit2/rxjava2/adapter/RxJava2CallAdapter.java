package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class RxJava2CallAdapter implements CallAdapter<Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;

    @Nullable
    private final Scheduler scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxJava2CallAdapter(Type type, @Nullable Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.responseType = type;
        this.scheduler = scheduler;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isFlowable = z4;
        this.isSingle = z5;
        this.isMaybe = z6;
        this.isCompletable = z7;
    }

    @Override // com.bytedance.retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // com.bytedance.retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object adapt(Call<R> call) {
        Observable bodyObservable;
        Scheduler scheduler;
        Observable callEnqueueObservable = this.isAsync ? new CallEnqueueObservable(call) : new CallExecuteObservable(call);
        if (this.isResult) {
            bodyObservable = new ResultObservable(callEnqueueObservable);
        } else {
            if (this.isBody) {
                bodyObservable = new BodyObservable(callEnqueueObservable);
            }
            scheduler = this.scheduler;
            if (scheduler != null) {
                callEnqueueObservable = callEnqueueObservable.subscribeOn(scheduler);
            }
            if (!this.isFlowable) {
                return callEnqueueObservable.toFlowable(BackpressureStrategy.LATEST);
            }
            if (this.isSingle) {
                return callEnqueueObservable.singleOrError();
            }
            if (this.isMaybe) {
                return callEnqueueObservable.singleElement();
            }
            return this.isCompletable ? callEnqueueObservable.ignoreElements() : callEnqueueObservable;
        }
        callEnqueueObservable = bodyObservable;
        scheduler = this.scheduler;
        if (scheduler != null) {
        }
        if (!this.isFlowable) {
        }
    }
}
