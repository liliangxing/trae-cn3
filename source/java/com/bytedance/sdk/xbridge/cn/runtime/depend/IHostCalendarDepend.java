package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;

/* compiled from: IHostCalendarDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarDepend;", "", "deleteEvent", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", b.k, "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarEventCallback;", "insertOrUpdate", "event", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/CalendarEventRecord;", "readEvent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostCalendarDepend {
    void deleteEvent(IBDXBridgeContext bridgeContext, String eventId, IHostCalendarEventCallback callback);

    void insertOrUpdate(IBDXBridgeContext bridgeContext, CalendarEventRecord event, IHostCalendarEventCallback callback);

    CalendarEventRecord readEvent(IBDXBridgeContext bridgeContext, String eventId);
}
