package com.bytedance.android.live.core.setting.p027v2.p028vo;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* compiled from: SettingCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/vo/SettingCallback;", "", "callBackSetting", "", "key", "", "time", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/reflect/Type;", StrategyConstants.VALUE, "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface SettingCallback {
    void callBackSetting(String key, long time, Type type, Object value);
}
