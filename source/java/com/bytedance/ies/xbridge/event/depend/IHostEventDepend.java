package com.bytedance.ies.xbridge.event.depend;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IHostEventDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/event/depend/IHostEventDepend;", "", "broadcastEvent", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "eventParams", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostEventDepend {
    void broadcastEvent(String eventName, Map<String, ? extends Object> eventParams);
}
