package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.original.Model;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Lazy;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: Group.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J \u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH&J\b\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH&J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\bH&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/applog/priority/original/GroupInterface;", "", "clear", "", WebViewContainer.EVENT_destroy, "doWork", "header", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "runTimeSecs", "", "flush", "getEventCount", "", "groupId", "insertEvent", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "eventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "json", "interval", "isEmpty", "", "isTimeout", "match", "event", "paramJson", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GroupInterface {
    void clear();

    void destroy();

    void doWork(Lazy<? extends JSONObject> header, long runTimeSecs);

    void flush();

    int getEventCount();

    int groupId();

    Model.EventKey insertEvent(Model.EventType eventType, String eventName, JSONObject json);

    int interval();

    boolean isEmpty();

    boolean isTimeout(long runTimeSecs);

    boolean match(Model.EventType eventType, String event, JSONObject paramJson);
}
