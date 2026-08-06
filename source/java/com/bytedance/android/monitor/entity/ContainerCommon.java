package com.bytedance.android.monitor.entity;

import com.bytedance.android.monitor.base.BaseMonitorData;
import com.bytedance.android.monitor.util.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerCommon.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u001f\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\b¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/monitor/entity/ContainerCommon;", "Lcom/bytedance/android/monitor/base/BaseMonitorData;", "containerBaseMap", "", "", "", "(Ljava/util/Map;)V", "containerBaseMapList", "", "(Ljava/util/List;)V", "getContainerBaseMapList", "()Ljava/util/List;", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class ContainerCommon extends BaseMonitorData {
    private final List<Map<String, Object>> containerBaseMapList;

    public ContainerCommon(List<Map<String, Object>> containerBaseMapList) {
        Intrinsics.checkParameterIsNotNull(containerBaseMapList, "containerBaseMapList");
        this.containerBaseMapList = containerBaseMapList;
    }

    public final List<Map<String, Object>> getContainerBaseMapList() {
        return this.containerBaseMapList;
    }

    public ContainerCommon(Map<String, ? extends Object> map) {
        this(new ArrayList());
        if (map != null) {
            this.containerBaseMapList.add(map);
        }
    }

    @Override // com.bytedance.android.monitor.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
        Iterator<T> it = this.containerBaseMapList.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : ((Map) it.next()).entrySet()) {
                JsonUtils.safePut(jsonObject, (String) entry.getKey(), entry.getValue());
            }
        }
    }
}
