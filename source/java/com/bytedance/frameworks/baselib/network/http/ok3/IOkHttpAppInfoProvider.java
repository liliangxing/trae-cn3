package com.bytedance.frameworks.baselib.network.http.ok3;

import java.util.List;

/* loaded from: classes2.dex */
public interface IOkHttpAppInfoProvider {
    List<String> getAbSdkVersion();

    int getAid();

    String getHttpDnsDomain();

    String[] getHttpDnsDomainHardCodeIps();

    String[] getHttpDnsPreloadDomains();

    void sendAppMonitorEvent(String str, String str2);
}
