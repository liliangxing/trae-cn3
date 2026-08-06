package com.bytedance.android.live.core.setting.p027v2.strategy;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.p028vo.CacheSettingVo;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/strategy/ContextStrategy;", "", "updateStrategy", "Lcom/bytedance/android/live/core/setting/v2/strategy/IUpdateStrategy;", "(Lcom/bytedance/android/live/core/setting/v2/strategy/IUpdateStrategy;)V", "mUpdateStrategy", SettingV2Monitor.REPORT_TYPE_UPDATE, "", "settings", "Lcom/google/gson/JsonObject;", StrategyConstants.EXTRA, "cacheSettingVo", "Lcom/bytedance/android/live/core/setting/v2/vo/CacheSettingVo;", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ContextStrategy {
    private IUpdateStrategy mUpdateStrategy;

    public ContextStrategy(IUpdateStrategy iUpdateStrategy) {
        Intrinsics.checkNotNullParameter(iUpdateStrategy, "updateStrategy");
        this.mUpdateStrategy = iUpdateStrategy;
    }

    public static /* synthetic */ boolean update$default(ContextStrategy contextStrategy, JsonObject jsonObject, JsonObject jsonObject2, CacheSettingVo cacheSettingVo, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonObject = null;
        }
        if ((i & 2) != 0) {
            jsonObject2 = null;
        }
        if ((i & 4) != 0) {
            cacheSettingVo = null;
        }
        return contextStrategy.update(jsonObject, jsonObject2, cacheSettingVo);
    }

    public final boolean update(JsonObject settings, JsonObject extra, CacheSettingVo cacheSettingVo) {
        return this.mUpdateStrategy.update(settings, extra, cacheSettingVo);
    }
}
