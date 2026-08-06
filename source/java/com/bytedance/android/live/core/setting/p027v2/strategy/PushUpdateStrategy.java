package com.bytedance.android.live.core.setting.p027v2.strategy;

import com.bytedance.android.live.core.setting.p027v2.storage.SettingConfigConstant;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingReportMonitor;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushUpdateStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J@\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/strategy/PushUpdateStrategy;", "Lcom/bytedance/android/live/core/setting/v2/strategy/ColdUpdateStrategy;", "()V", "printLog", "", "deleteMap", "", "", "", "updateOrAdd", "printMonitor", "isSuccess", "", "isFull", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PushUpdateStrategy extends ColdUpdateStrategy {
    @Override // com.bytedance.android.live.core.setting.p027v2.strategy.ColdUpdateStrategy
    public void printLog(Map<String, ? extends Object> deleteMap, Map<String, ? extends Object> updateOrAdd) {
        SettingReportMonitor.INSTANCE.printLog("添加数据为：" + (updateOrAdd != null ? updateOrAdd.toString() : null) + "，删除数据长度为：" + (deleteMap != null ? Integer.valueOf(deleteMap.size()) : null));
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.strategy.ColdUpdateStrategy
    public void printMonitor(boolean isSuccess, boolean isFull, Map<String, ? extends Object> deleteMap, Map<String, ? extends Object> updateOrAdd) {
        Intrinsics.checkNotNullParameter(deleteMap, "deleteMap");
        Intrinsics.checkNotNullParameter(updateOrAdd, "updateOrAdd");
        SettingV2Monitor.localUpdateResult(!isSuccess ? 1 : 0, isFull ? "full" : "incr", SettingConfigConstant.SETTING_V2_SETTING_FRONTIER, SettingReportMonitor.INSTANCE.getTimeMonitor(SettingConfigConstant.SETTING_V2_SETTING_COLD_STRATEGY_GSON_TIME), updateOrAdd.size(), deleteMap.size(), "update数据");
    }
}
