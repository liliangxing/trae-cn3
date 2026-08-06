package com.bytedance.ttnet.httpdns;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public class TTDnsQuery {
    private Map<String, String> controlHeaders;
    private String host;
    private TTDnsResult result;
    private int sdkId;
    private String uuid = UUID.randomUUID().toString();
    private CountDownLatch latch = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public TTDnsQuery(String str, int i, Map<String, String> map) {
        this.host = str;
        this.sdkId = i;
        this.controlHeaders = map;
    }

    public String host() {
        return this.host;
    }

    public int sdkId() {
        return this.sdkId;
    }

    public String uuid() {
        return this.uuid;
    }

    public void await() throws InterruptedException {
        this.latch.await();
    }

    public void resume() {
        this.latch.countDown();
    }

    public TTDnsResult result() {
        return this.result;
    }

    public void setResult(TTDnsResult tTDnsResult) {
        this.result = tTDnsResult;
    }

    public void doQuery() throws Exception {
        SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext()).ttDnsResolve(this.host, this.sdkId, this.uuid, this.controlHeaders);
    }
}
