package com.ss.android.common.applog.filter;

import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes7.dex */
public class BlockEventFilter extends AbstractEventFilter {
    public BlockEventFilter(HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        super(hashSet, hashMap);
    }

    @Override // com.ss.android.common.applog.filter.AbstractEventFilter
    protected boolean interceptEventName(String str) {
        return this.mEventSet.contains(str);
    }

    @Override // com.ss.android.common.applog.filter.AbstractEventFilter
    protected boolean interceptEventParam(HashSet<String> hashSet, String str) {
        return hashSet.contains(str);
    }
}
