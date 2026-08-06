package com.bytedance.ies.argus.api.interfaces.service;

import kotlin.Metadata;

/* compiled from: ArgusBaseSecureService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseSecureService;", "", "()V", "priority", "", "serviceName", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ArgusBaseSecureService {
    public int priority() {
        return 1;
    }

    public abstract String serviceName();
}
