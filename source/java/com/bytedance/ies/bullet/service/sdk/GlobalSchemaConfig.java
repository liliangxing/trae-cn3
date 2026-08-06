package com.bytedance.ies.bullet.service.sdk;

import com.bytedance.ies.bullet.service.schema.ISchemaMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/GlobalSchemaConfig;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaConfig;", "monitor", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;)V", "getMonitor", "()Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;", "setMonitor", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class GlobalSchemaConfig extends SchemaConfig {
    private ISchemaMonitor monitor;

    public GlobalSchemaConfig(ISchemaMonitor monitor) {
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        this.monitor = monitor;
    }

    public final ISchemaMonitor getMonitor() {
        return this.monitor;
    }

    public final void setMonitor(ISchemaMonitor iSchemaMonitor) {
        Intrinsics.checkNotNullParameter(iSchemaMonitor, "<set-?>");
        this.monitor = iSchemaMonitor;
    }
}
