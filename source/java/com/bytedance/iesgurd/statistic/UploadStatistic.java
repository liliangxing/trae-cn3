package com.bytedance.iesgurd.statistic;

import com.bytedance.applog.server.Api;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.statistic.IStatisticMonitor;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UploadStatistic.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J*\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eJ,\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/iesgurd/statistic/UploadStatistic;", "", "()V", "assembleCommon", "", "jsonObject", "Lorg/json/JSONObject;", "uploadEvent", "subType", "Lcom/bytedance/iesgurd/core/EventSubType;", "msg", "", "extra", "duration", "", "accessKey", "channels", "uploadEventWithJson", "event", "json", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class UploadStatistic {
    public static final UploadStatistic INSTANCE = new UploadStatistic();

    private UploadStatistic() {
    }

    public final void uploadEventWithJson(String event, JSONObject json) {
        IStatisticMonitor statisticMonitor;
        Intrinsics.checkParameterIsNotNull(event, "event");
        Intrinsics.checkParameterIsNotNull(json, "json");
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        if (globalConfig == null || (statisticMonitor = globalConfig.getStatisticMonitor()) == null) {
            return;
        }
        assembleCommon(json);
        try {
            statisticMonitor.upload(event, json);
        } catch (Throwable th) {
            GeckoLogger.w("UploadStatistic.uploadEventWithJson", th);
        }
    }

    public final void uploadEvent(EventSubType subType, String msg, String extra, long duration) {
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        new EventMessageModel(subType, null, null, msg, extra, duration).upload();
    }

    public final void uploadEvent(EventSubType subType, String accessKey, String channels, String msg) {
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        new EventMessageModel(subType, accessKey, channels, msg, null, 0L).upload();
    }

    private final void assembleCommon(JSONObject jsonObject) {
        jsonObject.put("params_for_special", "gecko");
        jsonObject.put("os", 0);
        jsonObject.put("sdk_version", "5.2.4");
        long currentTimeMillis = System.currentTimeMillis();
        jsonObject.put(Api.KEY_LOCAL_TIME, currentTimeMillis);
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        if (globalConfig != null) {
            jsonObject.put("aid", globalConfig.getAppId());
            jsonObject.put("dur_from_cold_start", currentTimeMillis - globalConfig.getAppColdStartTime());
        }
    }
}
