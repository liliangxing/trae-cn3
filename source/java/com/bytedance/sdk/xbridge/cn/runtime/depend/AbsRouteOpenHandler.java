package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AbsRouteOpenHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u0014\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/AbsRouteOpenHandler;", "", "()V", "<set-?>", "exceptionHandler", "getExceptionHandler", "()Lcom/bytedance/sdk/xbridge/cn/runtime/depend/AbsRouteOpenHandler;", "nextHandler", "getNextHandler", "openSchema", "", "schema", "", "extraInfo", "", "context", "Landroid/content/Context;", "setExceptionHandler", "", "handler", "setNextHandler", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbsRouteOpenHandler {
    private AbsRouteOpenHandler exceptionHandler;
    private AbsRouteOpenHandler nextHandler;

    public abstract boolean openSchema(String schema, Map<String, ? extends Object> extraInfo, Context context);

    public final AbsRouteOpenHandler getNextHandler() {
        return this.nextHandler;
    }

    public final AbsRouteOpenHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public final void setNextHandler(AbsRouteOpenHandler handler) {
        this.nextHandler = handler;
    }

    public final void setExceptionHandler(AbsRouteOpenHandler handler) {
        this.exceptionHandler = handler;
    }
}
