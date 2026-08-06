package com.bytedance.sdk.xbridge.cn.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeInject.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/XBridgeInject;", "", "()V", "logger", "Lcom/bytedance/sdk/xbridge/cn/utils/Logger;", "getLogger", "()Lcom/bytedance/sdk/xbridge/cn/utils/Logger;", "setLogger", "(Lcom/bytedance/sdk/xbridge/cn/utils/Logger;)V", "inject", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class XBridgeInject {
    public static final XBridgeInject INSTANCE = new XBridgeInject();
    private static Logger logger = new DefaultBulletLogger();

    private XBridgeInject() {
    }

    public final Logger getLogger() {
        return logger;
    }

    public final void setLogger(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "<set-?>");
        logger = logger2;
    }

    public final void inject(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        logger = logger2;
    }
}
