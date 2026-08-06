package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxContextWrapper;", "Landroid/content/ContextWrapper;", TraceStatsConsts.STATS_BASE_MODULE, "Landroid/content/Context;", "(Landroid/content/Context;)V", "eventEmitterWrapper", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/EventEmitterWrapper;", "getEventEmitterWrapper", "()Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/EventEmitterWrapper;", "setEventEmitterWrapper", "(Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/EventEmitterWrapper;)V", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public class LynxContextWrapper extends ContextWrapper {
    private EventEmitterWrapper eventEmitterWrapper;

    public LynxContextWrapper(Context context) {
        super(context);
        this.eventEmitterWrapper = new EventEmitterWrapper();
    }

    public final EventEmitterWrapper getEventEmitterWrapper() {
        return this.eventEmitterWrapper;
    }

    public final void setEventEmitterWrapper(EventEmitterWrapper eventEmitterWrapper) {
        Intrinsics.checkParameterIsNotNull(eventEmitterWrapper, "<set-?>");
        this.eventEmitterWrapper = eventEmitterWrapper;
    }
}
