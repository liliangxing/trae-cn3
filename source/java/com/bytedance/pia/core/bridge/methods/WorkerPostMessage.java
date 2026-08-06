package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.worker.Worker;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WorkerPostMessage implements PiaMethod.ICall<Params, Void> {
    public static final String NAME = "pia.internal.worker.postMessage";
    public static final PiaMethod<Params, Void> METHOD = new PiaMethod<>(NAME, PiaMethod.Scope.Render, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.WorkerPostMessage$$ExternalSyntheticLambda0
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final Object create() {
            return new WorkerPostMessage();
        }
    });

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Void> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Params {

        @SerializedName("message")
        private JsonElement message;

        @SerializedName(ErrorType.WORKER)
        private String worker;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge iPiaBridge, Params params, IConsumer<Void> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        if (params.message == null || !params.message.isJsonObject()) {
            iConsumer2.accept(new PiaMethod.InvalidParamsError("Parameter 'message' is required!"));
            return;
        }
        IPiaContext context = iPiaBridge.getContext();
        Object obj = context.get(params.worker);
        Worker worker = obj instanceof Worker ? (Worker) obj : null;
        if (worker != null && worker.isRunning()) {
            worker.sendMessage(params.message.getAsJsonObject());
            iConsumer.accept(null);
        } else {
            iConsumer2.accept(new PiaMethod.Error(ErrorCode.WORKER_NULL_OBJECT_ERROR));
            context.remove(params.worker);
        }
    }
}
