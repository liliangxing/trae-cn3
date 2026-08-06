package com.bytedance.timon.clipboard.suite;

import android.app.Application;
import com.bytedance.timon.clipboard.suite.config.CertConfigManager;
import com.bytedance.timon.clipboard.suite.config.ClipboardCertConfig;
import com.bytedance.timonbase.ITMLifecycleService;
import com.bytedance.timonbase.TMInitialExtra;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.TimonConstantKt;
import com.bytedance.timonbase.config.TMConfigService;
import com.bytedance.timonbase.utils.EnumUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMClipboardLifecycleServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/TMClipboardLifecycleServiceImpl;", "Lcom/bytedance/timonbase/ITMLifecycleService;", "()V", "configKey", "", "init", "", "appId", "", "channelId", "deviceIdGetter", "Lkotlin/Function0;", "context", "Landroid/app/Application;", "initExtra", "Lcom/bytedance/timonbase/TMInitialExtra;", "onConfigUpdate", "release", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMClipboardLifecycleServiceImpl implements ITMLifecycleService {
    @Override // com.bytedance.timonbase.ITMLifecycleService
    public String configKey() {
        return TimonConstantKt.TIMON_CLIPBOARD_SUITE;
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void release() {
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public EnumUtils.WorkType defaultWorkType() {
        return ITMLifecycleService.DefaultImpls.defaultWorkType(this);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void delayAsyncInit() {
        ITMLifecycleService.DefaultImpls.delayAsyncInit(this);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public boolean enable() {
        return ITMLifecycleService.DefaultImpls.enable(this);
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
    public void init(int appId, String channelId, Function0<String> deviceIdGetter, Application context, TMInitialExtra initExtra) {
        Intrinsics.checkParameterIsNotNull(channelId, "channelId");
        Intrinsics.checkParameterIsNotNull(deviceIdGetter, "deviceIdGetter");
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (TimonClipboardSuite.INSTANCE.getInit()) {
            TMLogger.INSTANCE.m224v(TimonClipboardSuite.TAG, "start initAfterTimonInit after timon init");
            CertConfigManager.INSTANCE.updateTimonConfig();
        }
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void onConfigUpdate() {
        JsonElement jsonElement;
        ClipboardCertConfig parsecConfig$clipboard_suite_release = CertConfigManager.INSTANCE.parsecConfig$clipboard_suite_release(CertConfigManager.INSTANCE.fetchFromConfigProvider$clipboard_suite_release());
        if (parsecConfig$clipboard_suite_release == null) {
            parsecConfig$clipboard_suite_release = CertConfigManager.INSTANCE.parsecConfig$clipboard_suite_release(CertConfigManager.INSTANCE.fetchFromTMConfig$clipboard_suite_release());
        }
        boolean z = true;
        try {
            JsonObject configJson = TMConfigService.INSTANCE.getConfigJson(TimonConstantKt.CERTS_CONFIG);
            if (configJson != null && (jsonElement = configJson.get("dynamic_update")) != null) {
                z = jsonElement.getAsBoolean();
            }
        } catch (Exception unused) {
        }
        if (parsecConfig$clipboard_suite_release == null || !z) {
            return;
        }
        CertConfigManager.INSTANCE.setConfig$clipboard_suite_release(parsecConfig$clipboard_suite_release);
    }
}
