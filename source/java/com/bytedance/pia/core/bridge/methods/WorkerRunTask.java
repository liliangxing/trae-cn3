package com.bytedance.pia.core.bridge.methods;

import android.text.TextUtils;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.bridge.methods.WorkerRunTask;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.push.client.intelligence.FeatureConnectionConstant;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WorkerRunTask implements PiaMethod.ICall<Params, Result> {
    private static final long DEFAULT_TIME_LIMIT = 30;
    private static final long MAX_TIME_LIMIT = 600;
    private static final String POLYFILL = "!function(a){globalThis._pia_task_={params:a,callback:function(a){NativeModules.get(\"BaseModule\").terminateWithResult(a)}}}";
    public static final String NAME = "pia.internal.worker.runTask";
    public static final PiaMethod<Params, Result> METHOD = new PiaMethod<>(NAME, PiaMethod.Scope.Render, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.WorkerRunTask$$ExternalSyntheticLambda0
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final Object create() {
            return new WorkerRunTask();
        }
    });

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Params {

        @SerializedName("execute_time_limit")
        private Long executeTimeLimit;

        @SerializedName(FeatureConnectionConstant.LOCATION)
        private String location;

        @SerializedName("name")
        private String name;

        @SerializedName("params")
        private JsonElement params;

        @SerializedName("url")
        private String url;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Result {

        @SerializedName("result")
        private final JsonObject result;

        public Result(JsonObject jsonObject) {
            this.result = jsonObject;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge iPiaBridge, Params params, final IConsumer<Result> iConsumer, final IConsumer<PiaMethod.Error> iConsumer2) {
        long j;
        JsonObject jsonObject;
        if (params.url != null) {
            String str = !TextUtils.isEmpty(params.name) ? params.name : "RunTask";
            if (params.executeTimeLimit == null) {
                j = DEFAULT_TIME_LIMIT;
            } else if (params.executeTimeLimit.longValue() >= 0 && params.executeTimeLimit.longValue() <= MAX_TIME_LIMIT) {
                j = params.executeTimeLimit.longValue();
            } else {
                iConsumer2.accept(new PiaMethod.InvalidParamsError("Parameter 'execute_time_limit' should be in range 0~600!"));
                return;
            }
            if (params.params != null && !(params.params instanceof JsonNull)) {
                if (params.params instanceof JsonObject) {
                    jsonObject = (JsonObject) params.params;
                } else {
                    iConsumer2.accept(new PiaMethod.InvalidParamsError("Parameters 'params' must be an object!"));
                    return;
                }
            } else {
                jsonObject = new JsonObject();
            }
            PiaContext piaContext = (PiaContext) iPiaBridge.getContext();
            Worker.CreateParams build = new Worker.CreateParams.Builder().setContext(piaContext).setName(str).setLocation(params.location).setScriptUrl(params.url).setResultConsumer(new IConsumer() { // from class: com.bytedance.pia.core.bridge.methods.WorkerRunTask$$ExternalSyntheticLambda1
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Object obj) {
                    IConsumer.this.accept(new WorkerRunTask.Result((JsonObject) obj));
                }
            }).setGlobalProps(piaContext.getGlobalProps()).build();
            if (build == null) {
                iConsumer2.accept(new PiaMethod.Error(ErrorCode.WORKER_SYNTAX_ERROR));
                return;
            }
            Object obj = piaContext.get(build.scriptUrl);
            if (obj instanceof String) {
                Object obj2 = piaContext.get((String) obj);
                if ((obj2 instanceof Worker) && ((Worker) obj2).isRunning()) {
                    iConsumer2.accept(new PiaMethod.Error(ErrorCode.WORKER_REDUNDANT_ACTION_ERROR));
                    return;
                }
            }
            try {
                final Worker worker = new Worker(build);
                final String put = iPiaBridge.getContext().put(worker);
                iPiaBridge.getContext().put(put, worker.getScriptUrl());
                final WeakReference weakReference = new WeakReference(iPiaBridge.getContext());
                ThreadUtil.INSTANCE.getPiaHandler().postDelayed(new Runnable() { // from class: com.bytedance.pia.core.bridge.methods.WorkerRunTask$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        WorkerRunTask.lambda$invoke$1(weakReference, put, iConsumer2);
                    }
                }, j * 1000);
                worker.loadScript("!function(a){globalThis._pia_task_={params:a,callback:function(a){NativeModules.get(\"BaseModule\").terminateWithResult(a)}}}(" + jsonObject + ")");
                worker.start();
                worker.onMessage(new IConsumer() { // from class: com.bytedance.pia.core.bridge.methods.WorkerRunTask$$ExternalSyntheticLambda3
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(Object obj3) {
                        Logger.m181i("[RunTask] unhandled message: " + ((JsonObject) obj3));
                    }
                });
                worker.setErrorHandle(new IConsumer() { // from class: com.bytedance.pia.core.bridge.methods.WorkerRunTask$$ExternalSyntheticLambda4
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(Object obj3) {
                        WorkerRunTask.lambda$invoke$3(IConsumer.this, worker, (String) obj3);
                    }
                });
                return;
            } catch (Throwable th) {
                if (th instanceof PiaMethod.Error) {
                    iConsumer2.accept(th);
                    return;
                } else {
                    iConsumer2.accept(new PiaMethod.Error(th.toString()));
                    return;
                }
            }
        }
        iConsumer2.accept(new PiaMethod.InvalidParamsError("Parameter 'url' is required!"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$invoke$1(WeakReference weakReference, String str, IConsumer iConsumer) {
        IPiaContext iPiaContext = (IPiaContext) weakReference.get();
        if (iPiaContext == null) {
            return;
        }
        Object obj = iPiaContext.get(str);
        if (obj instanceof Worker) {
            Worker worker = (Worker) obj;
            if (worker.isRunning()) {
                iConsumer.accept(new PiaMethod.Error(ErrorCode.WORKER_TIMEOUT_ERROR));
                worker.terminate();
                iPiaContext.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$invoke$3(IConsumer iConsumer, Worker worker, String str) {
        iConsumer.accept(new PiaMethod.Error(ErrorCode.WORKER_EXECUTE_ERROR, str));
        worker.terminate();
    }
}
