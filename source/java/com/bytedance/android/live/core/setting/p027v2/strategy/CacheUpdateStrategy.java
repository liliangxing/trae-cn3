package com.bytedance.android.live.core.setting.p027v2.strategy;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.cache.CacheManger;
import com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.p027v2.p028vo.CacheSettingVo;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import com.bytedance.android.live.core.setting.p027v2.update.SettingIncStrategy;
import com.google.gson.JsonObject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: CacheUpdateStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/strategy/CacheUpdateStrategy;", "Lcom/bytedance/android/live/core/setting/v2/strategy/IUpdateStrategy;", "()V", SettingV2Monitor.REPORT_TYPE_UPDATE, "", "settings", "Lcom/google/gson/JsonObject;", StrategyConstants.EXTRA, "cacheSettingVo", "Lcom/bytedance/android/live/core/setting/v2/vo/CacheSettingVo;", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class CacheUpdateStrategy implements IUpdateStrategy {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SettingIncStrategy.IncScene.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[SettingIncStrategy.IncScene.STICK.ordinal()] = 1;
            iArr[SettingIncStrategy.IncScene.OBJECT.ordinal()] = 2;
        }
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.strategy.IUpdateStrategy
    public boolean update(JsonObject settings, JsonObject extra, CacheSettingVo cacheSettingVo) {
        if (cacheSettingVo == null) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[cacheSettingVo.getScene().ordinal()];
        if (i == 1) {
            CacheManger mCacheManger = SettingIncStrategy.INSTANCE.getMCacheManger();
            ICacheManger.CacheType cacheType = ICacheManger.CacheType.STICKY;
            ICacheManger.Operation operation = ICacheManger.Operation.PLUS;
            HashMap hashMap = new HashMap();
            hashMap.put(cacheSettingVo.getKey(), cacheSettingVo.getValue());
            Unit unit = Unit.INSTANCE;
            return mCacheManger.update(cacheType, operation, hashMap);
        }
        if (i != 2) {
            return false;
        }
        CacheManger mCacheManger2 = SettingIncStrategy.INSTANCE.getMCacheManger();
        ICacheManger.CacheType cacheType2 = ICacheManger.CacheType.OBJECT;
        ICacheManger.Operation operation2 = ICacheManger.Operation.PLUS;
        HashMap hashMap2 = new HashMap();
        hashMap2.put(cacheSettingVo.getKey(), cacheSettingVo.getValue());
        Unit unit2 = Unit.INSTANCE;
        return mCacheManger2.update(cacheType2, operation2, hashMap2);
    }
}
