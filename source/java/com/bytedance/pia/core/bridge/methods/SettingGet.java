package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingGet implements PiaMethod.ICall<Void, Result> {
    public static final String NAME = "pia.internal.setting.get";
    public static final PiaMethod<Void, Result> METHOD = new PiaMethod<>(NAME, PiaMethod.Scope.All, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.SettingGet$$ExternalSyntheticLambda0
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final Object create() {
            return new SettingGet();
        }
    });

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Void r2, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, r2, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Result {

        @SerializedName("base")
        Map<String, Boolean> base;

        @SerializedName("feature")
        Map<String, Boolean> feature;

        @SerializedName("pageSetting")
        Config pageSetting;

        public Result(Map<String, Boolean> map, Map<String, Boolean> map2, Config config) {
            this.base = map;
            this.feature = map2;
            this.pageSetting = config;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge iPiaBridge, Void r4, IConsumer<Result> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        try {
            iConsumer.accept(new Result(Settings.get().getBase(), Settings.get().getFeatures(), ((PiaRuntime) iPiaBridge.getContext()).getConfig()));
        } catch (Throwable th) {
            iConsumer2.accept(new PiaMethod.Error(th.toString()));
        }
    }
}
