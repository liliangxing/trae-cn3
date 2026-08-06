package com.bytedance.timon.upc.upc_adapter_impl;

import android.app.Application;
import com.bytedance.timonbase.ITMLifecycleService;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInitialExtra;
import com.bytedance.timonbase.config.TMConfigService;
import com.bytedance.timonbase.config.TMInitConfigService;
import com.bytedance.timonbase.report.TMDataCollector;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.EnumUtils;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IDeviceGetter;
import com.bytedance.upc.IUpcMonitorAndEventService;
import com.bytedance.upc.Upc;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpcLifecycleServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/timon/upc/upc_adapter_impl/UpcLifecycleServiceImpl;", "Lcom/bytedance/timonbase/ITMLifecycleService;", "()V", "configKey", "", "defaultWorkType", "Lcom/bytedance/timonbase/utils/EnumUtils$WorkType;", "enable", "", "init", "", "appId", "", "channelId", "deviceIdGetter", "Lkotlin/Function0;", "context", "Landroid/app/Application;", "initExtra", "Lcom/bytedance/timonbase/TMInitialExtra;", "onConfigUpdate", "release", "upc-adapter-impl_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UpcLifecycleServiceImpl implements ITMLifecycleService {
    @Override // com.bytedance.timonbase.ITMLifecycleService
    public String configKey() {
        return "upc";
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void release() {
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void delayAsyncInit() {
        ITMLifecycleService.DefaultImpls.delayAsyncInit(this);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public EnumUtils.Priority priority() {
        return ITMLifecycleService.DefaultImpls.priority(this);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public EnumUtils.WorkType type() {
        return ITMLifecycleService.DefaultImpls.type(this);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void updateInitConfig() {
        ITMLifecycleService.DefaultImpls.updateInitConfig(this);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public boolean enable() {
        if (TMEnv.INSTANCE.isInitOpt()) {
            return TMInitConfigService.INSTANCE.getBoolean(TMInitConfigService.UPC_ENABLE, true);
        }
        return ITMLifecycleService.DefaultImpls.enable(this);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void init(int appId, String channelId, Function0<String> deviceIdGetter, Application context, TMInitialExtra initExtra) {
        Configuration upcConfig;
        Intrinsics.checkParameterIsNotNull(channelId, "channelId");
        Intrinsics.checkParameterIsNotNull(deviceIdGetter, "deviceIdGetter");
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (initExtra == null || (upcConfig = initExtra.getUpcConfig()) == null) {
            return;
        }
        upcConfig.mAppInfo = new Configuration.AppInfo();
        upcConfig.mAid = String.valueOf(TMEnv.INSTANCE.getAppId());
        upcConfig.mIDeviceGetter = new IDeviceGetter() { // from class: com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl$init$2
            public String getDeviceId() {
                return (String) TMEnv.INSTANCE.getDidGetter().invoke();
            }
        };
        upcConfig.mUpcMonitorAndEventService = new IUpcMonitorAndEventService() { // from class: com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl$init$3
            public void event(String eventName, JSONObject param) {
                Intrinsics.checkParameterIsNotNull(eventName, "eventName");
                TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, eventName, param, false, null, 12, null);
            }

            public void monitor(String serviceName, JSONObject category, JSONObject metric, JSONObject logExtra) {
                Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
                TMDataCollector.reportMonitorEvent$default(TMDataCollector.INSTANCE, serviceName, category, metric, logExtra, 0, false, 48, null);
            }
        };
        Upc.inst().init(context, upcConfig);
        if (ScenesDetector.INSTANCE.getAgreedPrivacyReferee() == null) {
            ScenesDetector.INSTANCE.setAgreedPrivacyReferee(new Function0<Boolean>() { // from class: com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl$init$4
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Boolean.valueOf(m1042invoke());
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final boolean m1042invoke() {
                    return Intrinsics.areEqual(Upc.privacy().getPrivacyStatus("key_upc_privacy_agreement_status", (String) null), "on");
                }
            });
        }
        if (ScenesDetector.INSTANCE.getTeenModeReferee() == null && (!Intrinsics.areEqual(Upc.privacy().getPrivacyStatus("key_upc_privacy_teen_mode_status", "unknown"), "unknown"))) {
            ScenesDetector.INSTANCE.setTeenModeReferee(new Function0<Boolean>() { // from class: com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl$init$5
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Boolean.valueOf(m1043invoke());
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final boolean m1043invoke() {
                    return Intrinsics.areEqual(Upc.privacy().getPrivacyStatus("key_upc_privacy_teen_mode_status", (String) null), "on");
                }
            });
        }
        if (ScenesDetector.INSTANCE.getBasicModeReferee() == null) {
            ScenesDetector.INSTANCE.setBasicModeReferee(new Function0<Boolean>() { // from class: com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl$init$6
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Boolean.valueOf(m1044invoke());
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final boolean m1044invoke() {
                    return Intrinsics.areEqual(Upc.privacy().getPrivacyStatus("40", (String) null), "on");
                }
            });
        }
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public EnumUtils.WorkType defaultWorkType() {
        return EnumUtils.WorkType.MAIN;
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void onConfigUpdate() {
        JsonObject configJson = TMConfigService.INSTANCE.getConfigJson(configKey());
        if (configJson != null) {
            Upc.inst().updateSettings(configJson.toString());
        }
    }
}
