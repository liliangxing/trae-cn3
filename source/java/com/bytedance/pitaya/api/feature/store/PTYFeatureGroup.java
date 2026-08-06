package com.bytedance.pitaya.api.feature.store;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: PTYFeatureGroup.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroup;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "getDescription", "", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureDescription;", "getGroupName", "", "getTrackEvents", "traceEvent", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "Lorg/json/JSONObject;", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PTYFeatureGroup implements ReflectionCall {
    public abstract List<PTYFeatureDescription> getDescription();

    public abstract String getGroupName();

    public abstract List<String> getTrackEvents();

    public abstract void traceEvent(String eventName, JSONObject params);

    private final void traceEvent(String eventName, String params) {
        try {
            traceEvent(eventName, new JSONObject(params));
        } catch (Throwable unused) {
        }
    }
}
