package com.bytedance.android.live.core.setting.v2.strategy;

import com.bytedance.android.live.core.setting.v2.vo.CacheSettingVo;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* compiled from: IUpdateStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/strategy/IUpdateStrategy;", "", "update", "", "settings", "Lcom/google/gson/JsonObject;", "extra", "cacheSettingVo", "Lcom/bytedance/android/live/core/setting/v2/vo/CacheSettingVo;", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public interface IUpdateStrategy {
    boolean update(JsonObject settings, JsonObject extra, CacheSettingVo cacheSettingVo);

    /* compiled from: IUpdateStrategy.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean update$default(IUpdateStrategy iUpdateStrategy, JsonObject jsonObject, JsonObject jsonObject2, CacheSettingVo cacheSettingVo, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
            }
            if ((i & 1) != 0) {
                jsonObject = null;
            }
            if ((i & 2) != 0) {
                jsonObject2 = null;
            }
            if ((i & 4) != 0) {
                cacheSettingVo = null;
            }
            return iUpdateStrategy.update(jsonObject, jsonObject2, cacheSettingVo);
        }
    }
}
