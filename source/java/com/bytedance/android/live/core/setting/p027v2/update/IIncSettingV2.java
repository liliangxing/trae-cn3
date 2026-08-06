package com.bytedance.android.live.core.setting.p027v2.update;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.update.SettingIncStrategy;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* compiled from: IIncSettingV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H&J$\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/update/IIncSettingV2;", "", "addUpdateListener", "", "updateListener", "Lcom/bytedance/android/live/core/setting/v2/update/IIncSettingV2$ISettingUpdateListener;", "cacheUpdate", "", "scene", "Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy$IncScene;", "key", "", StrategyConstants.VALUE, "incUpdate", "settings", "Lcom/google/gson/JsonObject;", StrategyConstants.EXTRA, "isIncUpdate", "removeUpdateListener", "ISettingUpdateListener", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IIncSettingV2 {

    /* compiled from: IIncSettingV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/update/IIncSettingV2$ISettingUpdateListener;", "", "onSuccess", "", "mode", "", "live-setting_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ISettingUpdateListener {
        void onSuccess(int mode);
    }

    void addUpdateListener(ISettingUpdateListener updateListener);

    boolean cacheUpdate(SettingIncStrategy.IncScene scene, String key, Object value);

    boolean incUpdate(SettingIncStrategy.IncScene scene, JsonObject settings, JsonObject extra);

    boolean isIncUpdate();

    void removeUpdateListener(ISettingUpdateListener updateListener);
}
