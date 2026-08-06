package com.facebook.net;

import com.bytedance.common.utility.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class TTCallerContext {
    private final Map<String, String> extraMap;
    private Object mExtr;
    private final HashMap<String, Integer> mUrlIndex;

    public TTCallerContext() {
        this.mUrlIndex = new HashMap<>();
        this.extraMap = new HashMap();
    }

    public TTCallerContext(Map<String, String> map) {
        this.mUrlIndex = new HashMap<>();
        this.extraMap = map;
    }

    public void setUrlIndex(String str, int i) {
        if (StringUtils.isEmpty(str) || i <= 0) {
            return;
        }
        this.mUrlIndex.put(str, Integer.valueOf(i));
    }

    public int getUrlIndex(String str) {
        if (!StringUtils.isEmpty(str) && this.mUrlIndex.containsKey(str)) {
            return this.mUrlIndex.get(str).intValue();
        }
        return -1;
    }

    public void setExtrObject(Object obj) {
        this.mExtr = obj;
    }

    public Object getExtrObject() {
        return this.mExtr;
    }

    public TTCallerContext addExtra(String str, String str2) {
        this.extraMap.put(str, str2);
        return this;
    }

    public String getExtra(String str) {
        return this.extraMap.get(str);
    }

    public Map<String, String> getExtraMap() {
        return this.extraMap;
    }
}
