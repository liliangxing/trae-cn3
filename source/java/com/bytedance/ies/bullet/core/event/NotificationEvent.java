package com.bytedance.ies.bullet.core.event;

import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: NotificationEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/core/event/NotificationEvent;", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "event", "", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "name", "getName", "()Ljava/lang/String;", "getParams", "()Lorg/json/JSONObject;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class NotificationEvent implements IEvent {
    public static final String NAME = "notification";
    private final String name;
    private final JSONObject params;

    public NotificationEvent(String event, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.name = "notification";
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(SchemaConstants.INNER_PARAM_EVENT_NAME, event);
        jSONObject2.put("data", jSONObject);
        this.params = jSONObject2;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
    public JSONObject getParams() {
        return this.params;
    }
}
