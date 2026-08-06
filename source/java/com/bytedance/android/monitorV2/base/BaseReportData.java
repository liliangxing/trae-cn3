package com.bytedance.android.monitorV2.base;

import com.bytedance.android.monitorV2.entity.NativeCommon;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseReportData implements IReportData {
    private Map<String, Object> tagsMap = new HashMap();

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public abstract NativeCommon getNativeBase();

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public abstract BaseNativeInfo getNativeInfo();

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public Map<String, Object> getTags() {
        return this.tagsMap;
    }

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public void addTag(String str, Object obj) {
        this.tagsMap.put(str, obj);
    }
}
