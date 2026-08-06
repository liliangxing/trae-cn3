package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.plugins.BootPlugin;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BootGet implements PiaMethod.ICall<Void, Result> {
    public static final String NAME = "pia.internal.boot.get";
    public static final PiaMethod<Void, Result> METHOD = new PiaMethod<>(NAME, PiaMethod.Scope.All, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.BootGet$$ExternalSyntheticLambda0
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final Object create() {
            return new BootGet();
        }
    });

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Void r2, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, r2, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge iPiaBridge, Void r5, IConsumer<Result> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        try {
            PiaRuntime piaRuntime = (PiaRuntime) iPiaBridge.getContext();
            PiaPlugin plugin = piaRuntime.getPlugin(ErrorType.BOOT);
            if (plugin instanceof BootPlugin) {
                piaRuntime.getOnlineTrace().updatePrefetchProcess(0);
                iConsumer.accept(new Result(((BootPlugin) plugin).getBootResult()));
            } else {
                piaRuntime.getOnlineTrace().updatePrefetchStatus(4);
                iConsumer2.accept(new PiaMethod.Error());
            }
        } catch (Throwable th) {
            if (iPiaBridge != null && (iPiaBridge.getContext() instanceof PiaRuntime)) {
                ((PiaRuntime) iPiaBridge.getContext()).getOnlineTrace().updatePrefetchStatus(4);
            }
            iConsumer2.accept(new PiaMethod.Error(th.toString()));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Result {

        @SerializedName("results")
        JsonArray results;

        public Result(JsonArray jsonArray) {
            this.results = jsonArray;
        }
    }
}
