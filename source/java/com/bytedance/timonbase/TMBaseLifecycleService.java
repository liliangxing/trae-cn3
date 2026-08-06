package com.bytedance.timonbase;

import android.app.Application;
import com.bytedance.timonbase.ITMLifecycleService;
import com.bytedance.timonbase.cache.TMCacheTaskManager;
import com.bytedance.timonbase.config.TMSettingFetcher;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.EnumUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMBaseLifecycleService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J8\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/timonbase/TMBaseLifecycleService;", "Lcom/bytedance/timonbase/ITMLifecycleService;", "()V", "configKey", "", "defaultWorkType", "Lcom/bytedance/timonbase/utils/EnumUtils$WorkType;", "delayAsyncInit", "", "enable", "", "init", "appId", "", "channelId", "deviceIdGetter", "Lkotlin/Function0;", "context", "Landroid/app/Application;", "initExtra", "Lcom/bytedance/timonbase/TMInitialExtra;", "onConfigUpdate", "release", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMBaseLifecycleService implements ITMLifecycleService {
    @Override // com.bytedance.timonbase.ITMLifecycleService
    public String configKey() {
        return "timon_base";
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public boolean enable() {
        return true;
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void release() {
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
        PageDataManager.INSTANCE.get().start(context);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void onConfigUpdate() {
        ScenesDetector.INSTANCE.updateThreshold();
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public void delayAsyncInit() {
        ScenesDetector.INSTANCE.setEnableTeenModeRead(true);
        ScenesDetector.INSTANCE.setTimonAppMode$timonbase_release(ScenesDetector.getAppMode$default(ScenesDetector.INSTANCE, false, false, false, false, false, false, 63, null));
        TMSettingFetcher.INSTANCE.getDelayInitTask().invoke();
        TMCacheTaskManager.INSTANCE.flushApiCallCache();
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public EnumUtils.WorkType defaultWorkType() {
        return EnumUtils.WorkType.MAIN;
    }
}
