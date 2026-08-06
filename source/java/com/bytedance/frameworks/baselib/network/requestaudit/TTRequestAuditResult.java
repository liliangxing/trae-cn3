package com.bytedance.frameworks.baselib.network.requestaudit;

import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class TTRequestAuditResult {
    public Set<String> headerRmSet;
    public Map<String, String> queryAddMap;
    public Set<String> queryRmKeySet;

    public void setHeaderRmKeySet(Set<String> set) {
        this.headerRmSet = set;
    }

    public void setQueryRmKeySet(Set<String> set) {
        this.queryRmKeySet = set;
    }

    public void setQueryAddMap(Map<String, String> map) {
        this.queryAddMap = map;
    }
}
