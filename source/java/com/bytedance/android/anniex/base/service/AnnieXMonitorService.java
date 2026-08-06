package com.bytedance.android.anniex.base.service;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXMonitorService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXMonitorService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "()V", "createMonitorListener", "Lcom/bytedance/android/anniex/base/service/AnnieXMonitorService$MonitorListener;", "MonitorListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class AnnieXMonitorService extends BaseBulletService {

    /* compiled from: AnnieXMonitorService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXMonitorService$MonitorListener;", "", "()V", "onEvent", "", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", NotificationCompat.CATEGORY_EVENT, "", "", StrategyConstants.EXTRA, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class MonitorListener {
        public void onEvent(IContainer container, Map<String, String> event, Map<String, String> extra) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        }
    }

    public MonitorListener createMonitorListener() {
        AnnieXMonitorService annieXMonitorService = ServiceCenter.Companion.instance().get(AnnieXMonitorService.class);
        if (annieXMonitorService != null) {
            return annieXMonitorService.createMonitorListener();
        }
        return null;
    }
}
