package com.bytedance.ies.bullet.service.sdk;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaMonitor;
import com.bytedance.ies.bullet.service.schema.SchemaMonitorEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultSchemaMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016JX\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/DefaultSchemaMonitor;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;", "()V", "log", "", "message", "", "report", "event", "Lcom/bytedance/ies/bullet/service/schema/SchemaMonitorEvent;", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "info", "", "error", "metrics", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultSchemaMonitor implements ISchemaMonitor {
    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMonitor
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMonitor
    public void report(SchemaMonitorEvent event, ISchemaData schemaData, Map<String, String> info, Map<String, String> error, Map<String, Long> metrics) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        Intrinsics.checkNotNullParameter(info, "info");
    }
}
