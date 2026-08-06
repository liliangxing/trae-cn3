package com.bytedance.android.live.core.setting.p027v2.strategy;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.p027v2.helper.SettingGsonHelper;
import com.bytedance.android.live.core.setting.p027v2.p028vo.CacheSettingVo;
import com.bytedance.android.live.core.setting.p027v2.storage.SettingConfigConstant;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingReportMonitor;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import com.bytedance.android.live.core.setting.p027v2.update.SettingIncStrategy;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColdUpdateStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J@\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J&\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J2\u0010\u000e\u001a\u00020\f2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/strategy/ColdUpdateStrategy;", "Lcom/bytedance/android/live/core/setting/v2/strategy/IUpdateStrategy;", "()V", "printLog", "", "deleteMap", "", "", "", "updateOrAdd", "printMonitor", "isSuccess", "", "isFull", SettingV2Monitor.REPORT_TYPE_UPDATE, "settings", "Lcom/google/gson/JsonObject;", StrategyConstants.EXTRA, "cacheSettingVo", "Lcom/bytedance/android/live/core/setting/v2/vo/CacheSettingVo;", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class ColdUpdateStrategy implements IUpdateStrategy {
    public void printLog(Map<String, ? extends Object> deleteMap, Map<String, ? extends Object> updateOrAdd) {
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.android.live.core.setting.v2.strategy.ColdUpdateStrategy$update$1$1] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.bytedance.android.live.core.setting.v2.strategy.ColdUpdateStrategy$update$2$1$1] */
    @Override // com.bytedance.android.live.core.setting.p027v2.strategy.IUpdateStrategy
    public boolean update(JsonObject settings, JsonObject extra, CacheSettingVo cacheSettingVo) {
        JsonElement jsonElement;
        SettingReportMonitor.INSTANCE.startCostTimeMonitor(SettingConfigConstant.SETTING_V2_SETTING_COLD_STRATEGY_GSON_TIME);
        boolean areEqual = Intrinsics.areEqual((extra == null || (jsonElement = extra.get(SettingConfigConstant.SETTING_V2_SETTING_UPDATE_MODE)) == null) ? null : jsonElement.getAsString(), "full");
        if (areEqual) {
            SettingIncStrategy.INSTANCE.getMCacheManger().clearAll();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (settings != null) {
            Object fromJson = SettingGsonHelper.INSTANCE.getMGson().fromJson(settings.toString(), new TypeToken<HashMap<String, Object>>() { // from class: com.bytedance.android.live.core.setting.v2.strategy.ColdUpdateStrategy$update$1$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "SettingGsonHelper.mGson.…<String, Any>>() {}.type)");
            linkedHashMap = (Map) fromJson;
            linkedHashMap.remove(SettingConfigConstant.SETTING_V2_SETTING_EXTRA);
        }
        if (extra != null) {
            JsonObject asJsonObject = extra.getAsJsonObject(SettingConfigConstant.SETTING_V2_TO_DELETE_KEYS);
            String jsonObject = asJsonObject != null ? asJsonObject.toString() : null;
            if (jsonObject != null) {
                Object fromJson2 = SettingGsonHelper.INSTANCE.getMGson().fromJson(jsonObject, new TypeToken<HashMap<String, Object>>() { // from class: com.bytedance.android.live.core.setting.v2.strategy.ColdUpdateStrategy$update$2$1$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(fromJson2, "SettingGsonHelper.mGson.…<String, Any>>() {}.type)");
                linkedHashMap2 = (Map) fromJson2;
            }
        }
        SettingReportMonitor.INSTANCE.finishTimeMonitor(SettingConfigConstant.SETTING_V2_SETTING_COLD_STRATEGY_GSON_TIME);
        boolean update = update(linkedHashMap2, linkedHashMap);
        printMonitor(update, areEqual, linkedHashMap2, linkedHashMap);
        return update;
    }

    public final boolean update(Map<String, ? extends Object> deleteMap, Map<String, ? extends Object> updateOrAdd) {
        LinkedHashMap linkedHashMap;
        SettingReportMonitor.INSTANCE.startCostTimeMonitor("ColdStrategy_update_SP");
        printLog(deleteMap, updateOrAdd);
        LinkedHashMap linkedHashMap2 = null;
        if (deleteMap != null) {
            linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry : deleteMap.entrySet()) {
                if ((entry.getKey() == null || entry.getValue() == null) ? false : true) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        } else {
            linkedHashMap = null;
        }
        if (updateOrAdd != null) {
            linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry2 : updateOrAdd.entrySet()) {
                if ((entry2.getKey() == null || entry2.getValue() == null) ? false : true) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
        }
        boolean update = linkedHashMap != null ? SettingIncStrategy.INSTANCE.getMCacheManger().update(ICacheManger.CacheType.LOCAL_CACHE, ICacheManger.Operation.MINUS, linkedHashMap) : true;
        boolean update2 = linkedHashMap2 != null ? SettingIncStrategy.INSTANCE.getMCacheManger().update(ICacheManger.CacheType.LOCAL_CACHE, ICacheManger.Operation.PLUS, linkedHashMap2) : true;
        SettingReportMonitor.INSTANCE.finishTimeMonitor("ColdStrategy_update_SP");
        SettingReportMonitor.INSTANCE.startCostTimeMonitor("ColdStrategy_memory");
        if (linkedHashMap2 != null) {
            SettingIncStrategy.INSTANCE.getMCacheManger().update(ICacheManger.CacheType.OBJECT, ICacheManger.Operation.MINUS, linkedHashMap2);
            SettingIncStrategy.INSTANCE.getMCacheManger().update(ICacheManger.CacheType.TRANSIENT, ICacheManger.Operation.MINUS, linkedHashMap2);
            SettingIncStrategy.INSTANCE.getMCacheManger().update(ICacheManger.CacheType.PRELOAD_CACHE, ICacheManger.Operation.MINUS, linkedHashMap2);
        }
        if (linkedHashMap != null) {
            SettingIncStrategy.INSTANCE.getMCacheManger().update(ICacheManger.CacheType.OBJECT, ICacheManger.Operation.MINUS, linkedHashMap);
            SettingIncStrategy.INSTANCE.getMCacheManger().update(ICacheManger.CacheType.TRANSIENT, ICacheManger.Operation.MINUS, linkedHashMap);
            SettingIncStrategy.INSTANCE.getMCacheManger().update(ICacheManger.CacheType.PRELOAD_CACHE, ICacheManger.Operation.MINUS, linkedHashMap);
        }
        SettingReportMonitor.INSTANCE.finishTimeMonitor("ColdStrategy_memory");
        return update2 && update;
    }

    public void printMonitor(boolean isSuccess, boolean isFull, Map<String, ? extends Object> deleteMap, Map<String, ? extends Object> updateOrAdd) {
        Intrinsics.checkNotNullParameter(deleteMap, "deleteMap");
        Intrinsics.checkNotNullParameter(updateOrAdd, "updateOrAdd");
        SettingV2Monitor.localUpdateResult(!isSuccess ? 1 : 0, isFull ? "full" : "incr", SettingConfigConstant.SETTING_V2_SETTING_COLD, SettingReportMonitor.INSTANCE.getTimeMonitor(SettingConfigConstant.SETTING_V2_SETTING_COLD_STRATEGY_GSON_TIME), updateOrAdd.size(), deleteMap.size(), "update数据");
    }
}
