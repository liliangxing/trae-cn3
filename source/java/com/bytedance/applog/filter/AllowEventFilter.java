package com.bytedance.applog.filter;

import com.bytedance.applog.AppLogInstance;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AllowEventFilter extends AbstractEventFilter {
    @Override // com.bytedance.applog.filter.IEventFilter
    public boolean noFilter() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AllowEventFilter(AppLogInstance appLogInstance, HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        super(appLogInstance, hashSet, hashMap);
    }

    @Override // com.bytedance.applog.filter.AbstractEventFilter
    protected boolean interceptEventName(String str) {
        return !this.mEventSet.contains(str);
    }

    @Override // com.bytedance.applog.filter.AbstractEventFilter
    protected boolean interceptEventParam(HashSet<String> hashSet, String str) {
        return !hashSet.contains(str);
    }
}
