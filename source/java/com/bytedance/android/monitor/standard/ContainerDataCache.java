package com.bytedance.android.monitor.standard;

import android.view.View;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.android.monitor.entity.ContainerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerDataCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0001J\u001e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0001R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/monitor/standard/ContainerDataCache;", "", "()V", "containerBaseMap", "", "", "containerIdViewMap", "Lcom/bytedance/android/monitor/standard/ContainerType;", "containerInfoMap", "attach", "", "monitorId", "ct", "clearDataById", "ensureContainerBase", "ensureContainerInfo", "getAttachedMonitorId", "", "view", "Landroid/view/View;", "getAttachedView", "getContainerBase", "getContainerCommonByView", "Lcom/bytedance/android/monitor/entity/ContainerCommon;", "getContainerInfo", "getContainerInfoByView", "Lcom/bytedance/android/monitor/entity/ContainerInfo;", "putContainerBase", "field", "value", "putContainerInfo", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerDataCache {
    public static final ContainerDataCache INSTANCE = new ContainerDataCache();
    private static final Map<String, Map<String, Object>> containerBaseMap = new LinkedHashMap();
    private static final Map<String, Map<String, Object>> containerInfoMap = new LinkedHashMap();
    private static final Map<String, ContainerType> containerIdViewMap = new LinkedHashMap();

    private ContainerDataCache() {
    }

    public final void putContainerBase(String monitorId, String field, Object value) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(field, "field");
        Intrinsics.checkParameterIsNotNull(value, "value");
        ensureContainerBase(monitorId).put(field, value);
    }

    public final void putContainerInfo(String monitorId, String field, Object value) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(field, "field");
        Intrinsics.checkParameterIsNotNull(value, "value");
        ensureContainerInfo(monitorId).put(field, value);
    }

    public final Map<String, Object> getContainerBase(String monitorId) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        return ensureContainerBase(monitorId);
    }

    public final Map<String, Object> getContainerInfo(String monitorId) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        return ensureContainerInfo(monitorId);
    }

    public final void attach(String monitorId, ContainerType ct) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        Intrinsics.checkParameterIsNotNull(ct, "ct");
        containerIdViewMap.put(monitorId, ct);
    }

    public final ContainerType getAttachedView(String monitorId) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        return containerIdViewMap.get(monitorId);
    }

    public final List<String> getAttachedMonitorId(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ContainerType> entry : containerIdViewMap.entrySet()) {
            View container = entry.getValue().getContainer();
            if (container != null && container.equals(view)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public final ContainerCommon getContainerCommonByView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = getAttachedMonitorId(view).iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.getContainerBase((String) it.next()));
        }
        return new ContainerCommon(arrayList);
    }

    public final ContainerInfo getContainerInfoByView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = getAttachedMonitorId(view).iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.getContainerInfo((String) it.next()));
        }
        return new ContainerInfo(arrayList);
    }

    public final void clearDataById(String monitorId) {
        Intrinsics.checkParameterIsNotNull(monitorId, "monitorId");
        containerBaseMap.remove(monitorId);
        containerInfoMap.remove(monitorId);
    }

    private final Map<String, Object> ensureContainerBase(String monitorId) {
        Map<String, Map<String, Object>> map = containerBaseMap;
        if (map.get(monitorId) == null) {
            map.put(monitorId, new LinkedHashMap());
        }
        Map<String, Object> map2 = map.get(monitorId);
        if (map2 == null) {
            Intrinsics.throwNpe();
        }
        return map2;
    }

    private final Map<String, Object> ensureContainerInfo(String monitorId) {
        Map<String, Map<String, Object>> map = containerInfoMap;
        if (map.get(monitorId) == null) {
            map.put(monitorId, new LinkedHashMap());
        }
        Map<String, Object> map2 = map.get(monitorId);
        if (map2 == null) {
            Intrinsics.throwNpe();
        }
        return map2;
    }
}
