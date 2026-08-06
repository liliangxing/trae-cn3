package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.base.BaseMonitorData;
import com.bytedance.android.monitorV2.standard.ContainerStandardConst;
import com.bytedance.android.monitorV2.util.JsonUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ContainerBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u001f\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u0004R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "Lcom/bytedance/android/monitorV2/base/BaseMonitorData;", "containerBaseMap", "", "", "", "(Ljava/util/Map;)V", "containerBaseMapList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "getSchema", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerBase extends BaseMonitorData {
    private final CopyOnWriteArrayList<Map<String, Object>> containerBaseMapList;

    public ContainerBase(CopyOnWriteArrayList<Map<String, Object>> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "containerBaseMapList");
        this.containerBaseMapList = copyOnWriteArrayList;
    }

    public ContainerBase(Map<String, ? extends Object> map) {
        this((CopyOnWriteArrayList<Map<String, Object>>) new CopyOnWriteArrayList());
        if (map != null) {
            this.containerBaseMapList.add(map);
        }
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.containerBaseMapList.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : ((Map) it.next()).entrySet()) {
                if (Intrinsics.areEqual(entry.getKey(), ContainerStandardConst.FIELD_CONTAINER_ID)) {
                    Object value = entry.getValue();
                    String str = value instanceof String ? (String) value : null;
                    if (str != null) {
                        arrayList.add(str);
                    }
                } else {
                    JsonUtils.safePut(jsonObject, (String) entry.getKey(), entry.getValue());
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            JsonUtils.safePut(jsonObject, ContainerStandardConst.FIELD_CONTAINER_IDS, new JSONArray((Collection) arrayList2));
        }
    }

    public final String getSchema() {
        Iterator<T> it = this.containerBaseMapList.iterator();
        String str = "";
        while (it.hasNext()) {
            Map map = (Map) it.next();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (Intrinsics.areEqual(str2, "schema")) {
                    String str3 = value instanceof String ? (String) value : null;
                    str = str3 == null ? "" : str3;
                    if (!StringsKt.isBlank(str)) {
                        break;
                    }
                }
            }
        }
        return str;
    }
}
