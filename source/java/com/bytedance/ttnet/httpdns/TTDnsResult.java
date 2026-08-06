package com.bytedance.ttnet.httpdns;

import java.util.List;

/* loaded from: classes4.dex */
public class TTDnsResult {
    public int cache_source;
    public String detailed_info;
    public List<String> iplist;
    public int ret;
    public int source;

    public TTDnsResult(int i, int i2, int i3, List<String> list, String str) {
        this.ret = i;
        this.source = i2;
        this.cache_source = i3;
        this.iplist = list;
        this.detailed_info = str;
    }
}
