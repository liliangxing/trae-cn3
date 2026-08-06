package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IPreRenderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J.\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IEventObserver;", "", "onClearAll", "", "extraInfo", "Lorg/json/JSONObject;", "onItemFetch", "event", "Lcom/bytedance/ies/bullet/service/base/Event;", "onItemPut", "onItemRemove", "evicted", "", "key", "", "oldValue", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "newValue", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IEventObserver {
    void onClearAll(JSONObject extraInfo);

    void onItemFetch(Event event);

    void onItemPut(Event event);

    void onItemRemove(Event event, JSONObject extraInfo);

    void onItemRemove(boolean evicted, String key, CacheItem oldValue, CacheItem newValue);
}
