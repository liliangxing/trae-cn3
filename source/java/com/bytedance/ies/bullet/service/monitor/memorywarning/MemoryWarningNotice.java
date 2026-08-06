package com.bytedance.ies.bullet.service.monitor.memorywarning;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryWarningNotice.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/memorywarning/MemoryWarningNotice;", "", "()V", "TAG", "", "listenerMaps", "", "Lcom/bytedance/ies/bullet/service/monitor/memorywarning/IMemoryWaringListener;", "notify", "", "level", "", "registerListener", "containerId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unRegisterListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class MemoryWarningNotice {
    private static final String TAG = "MemoryWarningNotice";
    public static final MemoryWarningNotice INSTANCE = new MemoryWarningNotice();
    private static final Map<String, IMemoryWaringListener> listenerMaps = new LinkedHashMap();

    private MemoryWarningNotice() {
    }

    public final void notify(int level) {
        Map<String, IMemoryWaringListener> map = listenerMaps;
        synchronized (map) {
            Iterator<Map.Entry<String, IMemoryWaringListener>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onTrimMemory(level);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void registerListener(String containerId, IMemoryWaringListener listener) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Map<String, IMemoryWaringListener> map = listenerMaps;
        synchronized (map) {
            if (!map.containsKey(containerId)) {
                map.put(containerId, listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void unRegisterListener(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Map<String, IMemoryWaringListener> map = listenerMaps;
        synchronized (map) {
            map.remove(containerId);
        }
    }
}
