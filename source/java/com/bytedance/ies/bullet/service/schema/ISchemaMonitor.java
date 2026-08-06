package com.bytedance.ies.bullet.service.schema;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: ISchemaMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JX\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;", "", "log", "", "message", "", "report", "event", "Lcom/bytedance/ies/bullet/service/schema/SchemaMonitorEvent;", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "info", "", "error", "metrics", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISchemaMonitor {
    void log(String message);

    void report(SchemaMonitorEvent event, ISchemaData schemaData, Map<String, String> info, Map<String, String> error, Map<String, Long> metrics);
}
