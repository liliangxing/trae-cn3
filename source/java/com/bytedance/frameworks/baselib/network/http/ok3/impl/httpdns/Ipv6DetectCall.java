package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class Ipv6DetectCall implements Callable<Void> {
    @Override // java.util.concurrent.Callable
    public Void call() {
        Ipv6ConnectionManager.detectIpv6Reachable();
        return null;
    }
}
