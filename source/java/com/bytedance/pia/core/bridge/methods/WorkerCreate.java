package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.bridge.methods.WorkerOnError;
import com.bytedance.pia.core.bridge.methods.WorkerOnMessage;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.push.client.intelligence.FeatureConnectionConstant;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WorkerCreate implements PiaMethod.ICall<Params, Result> {
    public static final String NAME = "pia.internal.worker.create";
    public static final PiaMethod<Params, Result> METHOD = new PiaMethod<>(NAME, PiaMethod.Scope.Render, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.WorkerCreate$$ExternalSyntheticLambda2
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final Object create() {
            return new WorkerCreate();
        }
    });

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Params {

        @SerializedName(FeatureConnectionConstant.LOCATION)
        private String location;

        @SerializedName("name")
        private String name;

        @SerializedName("url")
        private String url;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Result {

        @SerializedName(ErrorType.WORKER)
        private final String worker;

        public Result(String str) {
            this.worker = str;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(final IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        if (params.url == null) {
            iConsumer2.accept(new PiaMethod.InvalidParamsError("Parameter 'url' is required!"));
            return;
        }
        final PiaRuntime piaRuntime = (PiaRuntime) iPiaBridge.getContext();
        Worker.CreateParams build = new Worker.CreateParams.Builder().setContext(piaRuntime).setName(params.name).setLocation(params.location).setScriptUrl(params.url).setGlobalProps(piaRuntime.getGlobalProps()).setSensitiveHeaders(piaRuntime.getSensitiveHeaders()).setSecurityDelegate(piaRuntime.getSecurityDelegate()).build();
        if (build == null) {
            iConsumer2.accept(new PiaMethod.Error(ErrorCode.WORKER_SYNTAX_ERROR));
            return;
        }
        try {
            Worker worker = new Worker(build);
            worker.start();
            final String put = piaRuntime.put(worker);
            if (put == null) {
                iConsumer2.accept(new PiaMethod.Error(ErrorCode.WORKER_NO_JS_RUNTIME_ERROR));
                return;
            }
            worker.onMessage(new IConsumer() { // from class: com.bytedance.pia.core.bridge.methods.WorkerCreate$$ExternalSyntheticLambda0
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Object obj) {
                    WorkerCreate.lambda$invoke$0(PiaRuntime.this, iPiaBridge, put, (JsonObject) obj);
                }
            });
            worker.setErrorHandle(new IConsumer() { // from class: com.bytedance.pia.core.bridge.methods.WorkerCreate$$ExternalSyntheticLambda1
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Object obj) {
                    WorkerCreate.lambda$invoke$1(PiaRuntime.this, iPiaBridge, put, (String) obj);
                }
            });
            iConsumer.accept(new Result(put));
        } catch (Throwable th) {
            if (th instanceof PiaMethod.Error) {
                iConsumer2.accept(th);
            } else {
                iConsumer2.accept(new PiaMethod.Error(ErrorCode.WORKER_NO_JS_RUNTIME_ERROR, th.toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$invoke$0(PiaRuntime piaRuntime, IPiaBridge iPiaBridge, String str, JsonObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        piaRuntime.getOnlineTrace().handlerWorkerMessage(jsonObject);
        iPiaBridge.send(WorkerOnMessage.NAME, new WorkerOnMessage.Params(str, jsonObject));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$invoke$1(PiaRuntime piaRuntime, IPiaBridge iPiaBridge, String str, String str2) {
        if (str2 == null) {
            return;
        }
        piaRuntime.getOnlineTrace().updatePrefetchStatus(2);
        iPiaBridge.send(WorkerOnError.NAME, new WorkerOnError.Params(str, str2));
    }
}
