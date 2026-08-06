package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class HostResolveJob implements Serializable, Comparable<HostResolveJob> {
    private long mCreatedTime = System.currentTimeMillis();
    private String mHost;
    public IHttpDnsCallback mHttpDnsCallback;
    private boolean mIsLocalDnsExpired;

    public HostResolveJob(String str, IHttpDnsCallback iHttpDnsCallback, boolean z) {
        this.mHost = str;
        this.mHttpDnsCallback = iHttpDnsCallback;
        this.mIsLocalDnsExpired = z;
    }

    @Override // java.lang.Comparable
    public int compareTo(HostResolveJob hostResolveJob) {
        long j = hostResolveJob.mCreatedTime;
        long j2 = this.mCreatedTime;
        if (j == j2) {
            return 0;
        }
        return j < j2 ? -1 : 1;
    }

    public String getHost() {
        return this.mHost;
    }

    public boolean isLocalDnsExpired() {
        return this.mIsLocalDnsExpired;
    }
}
