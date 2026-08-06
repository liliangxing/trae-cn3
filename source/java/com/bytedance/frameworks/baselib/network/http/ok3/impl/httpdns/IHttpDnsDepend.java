package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;

/* loaded from: classes2.dex */
public interface IHttpDnsDepend {
    String getAppId();

    Context getContext();

    String[] getHardCodeIps();

    String getHttpDnsDomain();

    String[] getPreloadDomains();
}
