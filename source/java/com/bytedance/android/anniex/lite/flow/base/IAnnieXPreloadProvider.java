package com.bytedance.android.anniex.lite.flow.base;

import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.lynx.animax.monitor.AnimaXMonitorUtil;
import kotlin.Metadata;

/* compiled from: IAnnieXPreloadProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/IAnnieXPreloadProvider;", "", "getCurrentSessionId", "", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", AnimaXMonitorUtil.TRIGGER_ON_RELEASE, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXPreloadProvider {
    String getCurrentSessionId();

    KitType getKitType();

    void onRelease();
}
