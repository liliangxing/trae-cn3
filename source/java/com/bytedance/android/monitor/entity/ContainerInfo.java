package com.bytedance.android.monitor.entity;

import com.bytedance.android.monitor.base.BaseMonitorData;
import com.bytedance.android.monitor.util.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u001f\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\b¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitor/entity/ContainerInfo;", "Lcom/bytedance/android/monitor/base/BaseMonitorData;", "containerInfoMap", "", "", "", "(Ljava/util/Map;)V", "containerInfoMapList", "", "(Ljava/util/List;)V", "getContainerInfoMapList", "()Ljava/util/List;", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "toSingleMap", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public class ContainerInfo extends BaseMonitorData {
    private final List<Map<String, Object>> containerInfoMapList;

    public ContainerInfo(List<Map<String, Object>> containerInfoMapList) {
        Intrinsics.checkParameterIsNotNull(containerInfoMapList, "containerInfoMapList");
        this.containerInfoMapList = containerInfoMapList;
    }

    public final List<Map<String, Object>> getContainerInfoMapList() {
        return this.containerInfoMapList;
    }

    public ContainerInfo(Map<String, ? extends Object> map) {
        this(new ArrayList());
        if (map != null) {
            this.containerInfoMapList.add(map);
        }
    }

    public final Map<String, Object> toSingleMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = this.containerInfoMapList.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : ((Map) it.next()).entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @Override // com.bytedance.android.monitor.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
        Iterator<T> it = this.containerInfoMapList.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : ((Map) it.next()).entrySet()) {
                JsonUtils.safePut(jsonObject, (String) entry.getKey(), entry.getValue());
            }
        }
    }
}
