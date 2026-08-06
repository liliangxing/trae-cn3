package com.bytedance.timon.foundation.interfaces;

import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IEventMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J4\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J0\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J<\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/timon/foundation/interfaces/IEventMonitor;", "", "monitorDuration", "", "serviceName", "", "duration", "Lorg/json/JSONObject;", "logExtra", "monitorEvent", "category", "metric", "monitorStatusAndDuration", "status", "", "monitorStatusAndEvent", "monitorStatusRate", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface IEventMonitor {
    void monitorDuration(String serviceName, JSONObject duration, JSONObject logExtra);

    void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject logExtra);

    void monitorStatusAndDuration(String serviceName, int status, JSONObject duration, JSONObject logExtra);

    void monitorStatusAndEvent(String serviceName, int status, JSONObject category, JSONObject metric, JSONObject logExtra);

    void monitorStatusRate(String serviceName, int status, JSONObject logExtra);

    /* compiled from: IEventMonitor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void monitorDuration$default(IEventMonitor iEventMonitor, String str, JSONObject jSONObject, JSONObject jSONObject2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitorDuration");
            }
            if ((i & 2) != 0) {
                jSONObject = null;
            }
            if ((i & 4) != 0) {
                jSONObject2 = null;
            }
            iEventMonitor.monitorDuration(str, jSONObject, jSONObject2);
        }

        public static /* synthetic */ void monitorStatusAndDuration$default(IEventMonitor iEventMonitor, String str, int i, JSONObject jSONObject, JSONObject jSONObject2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitorStatusAndDuration");
            }
            if ((i2 & 4) != 0) {
                jSONObject = null;
            }
            if ((i2 & 8) != 0) {
                jSONObject2 = null;
            }
            iEventMonitor.monitorStatusAndDuration(str, i, jSONObject, jSONObject2);
        }

        public static /* synthetic */ void monitorStatusRate$default(IEventMonitor iEventMonitor, String str, int i, JSONObject jSONObject, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitorStatusRate");
            }
            if ((i2 & 4) != 0) {
                jSONObject = null;
            }
            iEventMonitor.monitorStatusRate(str, i, jSONObject);
        }

        public static /* synthetic */ void monitorEvent$default(IEventMonitor iEventMonitor, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitorEvent");
            }
            if ((i & 2) != 0) {
                jSONObject = null;
            }
            if ((i & 4) != 0) {
                jSONObject2 = null;
            }
            if ((i & 8) != 0) {
                jSONObject3 = null;
            }
            iEventMonitor.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }

        public static /* synthetic */ void monitorStatusAndEvent$default(IEventMonitor iEventMonitor, String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i2, Object obj) {
            JSONObject jSONObject4;
            JSONObject jSONObject5;
            JSONObject jSONObject6;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitorStatusAndEvent");
            }
            if ((i2 & 4) != 0) {
                jSONObject4 = null;
            } else {
                jSONObject4 = jSONObject;
            }
            if ((i2 & 8) != 0) {
                jSONObject5 = null;
            } else {
                jSONObject5 = jSONObject2;
            }
            if ((i2 & 16) != 0) {
                jSONObject6 = null;
            } else {
                jSONObject6 = jSONObject3;
            }
            iEventMonitor.monitorStatusAndEvent(str, i, jSONObject4, jSONObject5, jSONObject6);
        }
    }
}
