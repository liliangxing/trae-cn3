package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TracingGet implements PiaMethod.ICall<Params, Result> {
    public static final String NAME = "pia.internal.tracing.get";
    public static final PiaMethod<Params, Result> METHOD = new PiaMethod<>(NAME, PiaMethod.Scope.All, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.TracingGet$$ExternalSyntheticLambda0
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final Object create() {
            return new TracingGet();
        }
    });

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Params {

        @SerializedName("resetBuffer")
        public boolean resetBuffer = false;
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        iConsumer.accept(new Result(((PiaContext) iPiaBridge.getContext()).getTrace().consume(params.resetBuffer)));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Result {

        @SerializedName("tracing")
        public final JsonArray tracing;

        public Result(JsonArray jsonArray) {
            this.tracing = jsonArray;
        }
    }
}
