package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CacheUpdateManifestMethod implements PiaMethod.ICall<Params, Void> {
    public static final String NAME = "pia.internal.cache.updateManifest";
    public static final PiaMethod<Params, Void> METHOD = new PiaMethod<>(NAME, PiaMethod.Scope.All, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.CacheUpdateManifestMethod$$ExternalSyntheticLambda0
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final Object create() {
            return new CacheUpdateManifestMethod();
        }
    });

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Params {

        @SerializedName(ErrorType.MANIFEST)
        public JsonObject manifest = null;
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Void> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge iPiaBridge, Params params, IConsumer<Void> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        if (params.manifest == null) {
            iConsumer2.accept(new PiaMethod.InvalidParamsError("'manifest' must bu not null!"));
        } else {
            ((PiaRuntime) iPiaBridge.getContext()).getPageStorage().put(ErrorType.MANIFEST, params.manifest);
            iConsumer.accept(null);
        }
    }
}
