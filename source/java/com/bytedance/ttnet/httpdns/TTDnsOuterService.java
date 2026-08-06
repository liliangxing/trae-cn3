package com.bytedance.ttnet.httpdns;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class TTDnsOuterService {
    private static TTDnsOuterService sInstance;
    private Map<String, TTDnsQuery> queryMap = new ConcurrentHashMap();

    public static synchronized TTDnsOuterService getInstance() {
        TTDnsOuterService tTDnsOuterService;
        synchronized (TTDnsOuterService.class) {
            if (sInstance == null) {
                sInstance = new TTDnsOuterService();
            }
            tTDnsOuterService = sInstance;
        }
        return tTDnsOuterService;
    }

    public TTDnsResult TTDnsResolve(String str, int i, Map<String, String> map) throws Exception {
        TTDnsQuery tTDnsQuery = new TTDnsQuery(str, i, map);
        this.queryMap.put(tTDnsQuery.uuid(), tTDnsQuery);
        tTDnsQuery.doQuery();
        tTDnsQuery.await();
        this.queryMap.remove(tTDnsQuery.uuid());
        return tTDnsQuery.result();
    }

    public void HandleHttpdnsResult(String str, String str2, int i, int i2, int i3, List<String> list, String str3) {
        TTDnsQuery tTDnsQuery = this.queryMap.get(str);
        if (tTDnsQuery != null) {
            tTDnsQuery.setResult(new TTDnsResult(i, i2, i3, list, str3));
            tTDnsQuery.resume();
            this.queryMap.remove(str);
        }
    }
}
