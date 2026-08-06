package com.bytedance.ies.bullet.core.event;

import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UpdateTemplateDataEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/core/event/UpdateTemplateDataEvent;", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "params", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "(Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;)V", "name", "", "getName", "()Ljava/lang/String;", "getParams", "()Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class UpdateTemplateDataEvent implements IEvent {
    public static final String EVENT_NAME_UPDATE_TEMPLATE_DATA = "__updateTemplateData";
    private final LynxInitDataWrapper params;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateTemplateDataEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
    public String getName() {
        return EVENT_NAME_UPDATE_TEMPLATE_DATA;
    }

    public UpdateTemplateDataEvent(LynxInitDataWrapper lynxInitDataWrapper) {
        this.params = lynxInitDataWrapper;
    }

    public /* synthetic */ UpdateTemplateDataEvent(LynxInitDataWrapper lynxInitDataWrapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lynxInitDataWrapper);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IEvent
    public LynxInitDataWrapper getParams() {
        return this.params;
    }
}
