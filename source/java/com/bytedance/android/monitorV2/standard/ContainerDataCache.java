package com.bytedance.android.monitorV2.standard;

import android.view.View;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.ContainerInfo;
import com.bytedance.android.monitorV2.util.ContextUtils;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.bdturing.methods.JsCallParser;
import com.lynx.tasm.event.LynxImpressionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerDataCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0005J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\u001a\u001a\u00020\u000eJ\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0005J\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u000eJ\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u000eJ$\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020\u0005J\u001e\u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0001J\u001e\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0001J\u001e\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0001R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/android/monitorV2/standard/ContainerDataCache;", "", "()V", "containerBaseMap", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "containerContextMap", "Lorg/json/JSONObject;", "containerIdViewMap", "Lcom/bytedance/android/monitorV2/standard/ContainerType;", "containerInfoMap", "pendingIdQueries", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/bytedance/android/monitorV2/standard/ContainerDataCache$IdQueryCallback;", LynxImpressionEvent.EVENT_ATTACH, "", "monitorId", "ct", "clearDataById", "ensureContainerBase", "ensureContainerContext", "ensureContainerInfo", "getAttachedMonitorId", "", "view", "getAttachedMonitorIdAsync", JsCallParser.VALUE_CALLBACK, "getAttachedView", "getContainerBase", "getContainerBaseByView", "Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "getContainerInfo", "getContainerInfoByView", "Lcom/bytedance/android/monitorV2/entity/ContainerInfo;", "getInfoField", "field", "putContainerBase", "value", "putContainerContext", "putContainerInfo", "IdQueryCallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ContainerDataCache {
    public static final ContainerDataCache INSTANCE = new ContainerDataCache();
    private static final Map<String, ConcurrentHashMap<String, Object>> containerBaseMap;
    private static final Map<String, JSONObject> containerContextMap;
    private static final Map<String, ContainerType> containerIdViewMap;
    private static final Map<String, ConcurrentHashMap<String, Object>> containerInfoMap;
    private static final WeakHashMap<View, IdQueryCallback> pendingIdQueries;

    /* compiled from: ContainerDataCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/monitorV2/standard/ContainerDataCache$IdQueryCallback;", "", "onIdQueryFinished", "", "monitorId", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public interface IdQueryCallback {
        void onIdQueryFinished(String monitorId);
    }

    private ContainerDataCache() {
    }

    static {
        Map<String, ConcurrentHashMap<String, Object>> synchronizedMap = Collections.synchronizedMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(ConcurrentHashMap())");
        containerBaseMap = synchronizedMap;
        Map<String, ConcurrentHashMap<String, Object>> synchronizedMap2 = Collections.synchronizedMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap2, "synchronizedMap(ConcurrentHashMap())");
        containerInfoMap = synchronizedMap2;
        Map<String, JSONObject> synchronizedMap3 = Collections.synchronizedMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap3, "synchronizedMap(ConcurrentHashMap())");
        containerContextMap = synchronizedMap3;
        Map<String, ContainerType> synchronizedMap4 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap4, "synchronizedMap(LinkedHashMap())");
        containerIdViewMap = synchronizedMap4;
        pendingIdQueries = new WeakHashMap<>();
    }

    public final void putContainerBase(String monitorId, String field, Object value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        ensureContainerBase(monitorId).put(field, value);
    }

    public final void putContainerInfo(String monitorId, String field, Object value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        ensureContainerInfo(monitorId).put(field, value);
    }

    public final void putContainerContext(String monitorId, String field, Object value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonUtils.safePut(ensureContainerContext(monitorId), field, value);
    }

    public final Map<String, Object> getContainerBase(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        return ensureContainerBase(monitorId);
    }

    public final Map<String, Object> getContainerInfo(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        return ensureContainerInfo(monitorId);
    }

    public final void attach(String monitorId, ContainerType ct) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(ct, "ct");
        containerIdViewMap.put(monitorId, ct);
        try {
            WeakHashMap<View, IdQueryCallback> weakHashMap = pendingIdQueries;
            IdQueryCallback idQueryCallback = weakHashMap.get(ct.getContainer());
            if (idQueryCallback != null) {
                idQueryCallback.onIdQueryFinished(monitorId);
            }
            weakHashMap.remove(ct.getContainer());
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    public final ContainerType getAttachedView(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        return containerIdViewMap.get(monitorId);
    }

    public final void getAttachedMonitorIdAsync(View view, IdQueryCallback callback) {
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map<String, ContainerType> map = containerIdViewMap;
        synchronized (map) {
            z = false;
            for (Map.Entry<String, ContainerType> entry : map.entrySet()) {
                String key = entry.getKey();
                View container = entry.getValue().getContainer();
                if (container != null && container.equals(view)) {
                    callback.onIdQueryFinished(key);
                    z = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            return;
        }
        pendingIdQueries.put(view, callback);
    }

    public final List<String> getAttachedMonitorId(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        Map<String, ContainerType> map = containerIdViewMap;
        synchronized (map) {
            for (Map.Entry<String, ContainerType> entry : map.entrySet()) {
                View container = entry.getValue().getContainer();
                boolean z = false;
                if (container != null && container.equals(view)) {
                    z = true;
                }
                if (z) {
                    arrayList.add(entry.getKey());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return arrayList;
    }

    public final ContainerBase getContainerBaseByView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Iterator<T> it = getAttachedMonitorId(view).iterator();
        while (it.hasNext()) {
            copyOnWriteArrayList.add(INSTANCE.getContainerBase((String) it.next()));
        }
        return new ContainerBase((CopyOnWriteArrayList<Map<String, Object>>) copyOnWriteArrayList);
    }

    public final ContainerInfo getContainerInfoByView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Iterator<T> it = getAttachedMonitorId(view).iterator();
        while (it.hasNext()) {
            copyOnWriteArrayList.add(INSTANCE.getContainerInfo((String) it.next()));
        }
        return new ContainerInfo((CopyOnWriteArrayList<Map<String, Object>>) copyOnWriteArrayList);
    }

    public final String getInfoField(String monitorId, View view, String field) {
        Intrinsics.checkNotNullParameter(field, "field");
        String str = monitorId;
        if (!(str == null || str.length() == 0)) {
            Object obj = getContainerInfo(monitorId).get(field);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        if (view == null) {
            return null;
        }
        Object obj2 = INSTANCE.getContainerInfoByView(view).toSingleMap().get(field);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        return null;
    }

    public final void clearDataById(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        containerBaseMap.remove(monitorId);
        containerInfoMap.remove(monitorId);
        WeakHashMap<View, IdQueryCallback> weakHashMap = pendingIdQueries;
        ContainerType containerType = containerIdViewMap.get(monitorId);
        weakHashMap.remove(containerType != null ? containerType.getContainer() : null);
        containerContextMap.remove(monitorId);
    }

    public final ConcurrentHashMap<String, Object> ensureContainerBase(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Map<String, ConcurrentHashMap<String, Object>> map = containerBaseMap;
        if (map.get(monitorId) == null) {
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            ConcurrentHashMap<String, Object> concurrentHashMap2 = concurrentHashMap;
            concurrentHashMap2.put("context", INSTANCE.ensureContainerContext(monitorId));
            concurrentHashMap2.put("version", AnnieXMonitorConstants.ANNIEX_VERSION);
            map.put(monitorId, concurrentHashMap);
        }
        ConcurrentHashMap<String, Object> concurrentHashMap3 = map.get(monitorId);
        return concurrentHashMap3 == null ? new ConcurrentHashMap<>() : concurrentHashMap3;
    }

    public final ConcurrentHashMap<String, Object> ensureContainerInfo(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Map<String, ConcurrentHashMap<String, Object>> map = containerInfoMap;
        if (map.get(monitorId) == null) {
            map.put(monitorId, new ConcurrentHashMap<>());
        }
        ConcurrentHashMap<String, Object> concurrentHashMap = map.get(monitorId);
        return concurrentHashMap == null ? new ConcurrentHashMap<>() : concurrentHashMap;
    }

    private final JSONObject ensureContainerContext(String monitorId) {
        Map<String, JSONObject> map = containerContextMap;
        if (map.get(monitorId) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ContainerStandardConst.CONTEXT_IS_REINSTALL, ContextUtils.INSTANCE.isReinstall());
            jSONObject.put(ContainerStandardConst.CONTEXT_APP_RUNTIME, ContextUtils.INSTANCE.appRunTimeStep());
            map.put(monitorId, jSONObject);
        }
        JSONObject jSONObject2 = map.get(monitorId);
        return jSONObject2 == null ? new JSONObject() : jSONObject2;
    }
}
