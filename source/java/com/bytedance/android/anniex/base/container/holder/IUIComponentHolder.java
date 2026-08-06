package com.bytedance.android.anniex.base.container.holder;

import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IUIComponentHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\u001c\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\fH&J\u001c\u0010\r\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\fH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/base/container/holder/IUIComponentHolder;", "", "loadSchema", "", "schema", "", "preloadSchema", "sendEvent", "event", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "updateData", "data", "", "updateGlobalProps", "globalProps", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IUIComponentHolder {
    void loadSchema(String schema);

    void preloadSchema(String schema);

    void sendEvent(IEvent event);

    void updateData(String data);

    void updateData(Map<String, ? extends Object> data);

    void updateGlobalProps(Map<String, ? extends Object> globalProps);
}
