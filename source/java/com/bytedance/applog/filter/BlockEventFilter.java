package com.bytedance.applog.filter;

import com.bytedance.applog.AppLogInstance;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BlockEventFilter extends AbstractEventFilter {
    public BlockEventFilter(AppLogInstance appLogInstance, HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        super(appLogInstance, hashSet, hashMap);
    }

    @Override // com.bytedance.applog.filter.AbstractEventFilter
    protected boolean interceptEventName(String str) {
        return this.mEventSet != null && this.mEventSet.contains(str);
    }

    @Override // com.bytedance.applog.filter.AbstractEventFilter
    protected boolean interceptEventParam(HashSet<String> hashSet, String str) {
        return hashSet.contains(str);
    }

    @Override // com.bytedance.applog.filter.IEventFilter
    public boolean noFilter() {
        return (this.mEventSet == null || this.mEventSet.isEmpty()) && (this.mParamMap == null || this.mParamMap.isEmpty());
    }
}
