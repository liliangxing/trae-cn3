package com.bytedance.timon.foundation.impl;

import com.bytedance.timon.foundation.interfaces.IEventMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EventMonitorDowngradeImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J.\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J6\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/timon/foundation/impl/EventMonitorDowngradeImpl;", "Lcom/bytedance/timon/foundation/interfaces/IEventMonitor;", "()V", "monitorDuration", "", "serviceName", "", "duration", "Lorg/json/JSONObject;", "logExtra", "monitorEvent", "category", "metric", "monitorStatusAndDuration", "status", "", "monitorStatusAndEvent", "monitorStatusRate", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class EventMonitorDowngradeImpl implements IEventMonitor {
    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorDuration(String serviceName, JSONObject duration, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorStatusAndDuration(String serviceName, int status, JSONObject duration, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorStatusAndEvent(String serviceName, int status, JSONObject category, JSONObject metric, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
    }

    @Override // com.bytedance.timon.foundation.interfaces.IEventMonitor
    public void monitorStatusRate(String serviceName, int status, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
    }
}
