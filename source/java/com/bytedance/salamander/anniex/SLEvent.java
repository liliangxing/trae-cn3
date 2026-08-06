package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/salamander/anniex/SLEvent;", "", "()V", "container_base", "Lcom/bytedance/salamander/anniex/ContainerBase;", "getContainer_base", "()Lcom/bytedance/salamander/anniex/ContainerBase;", "setContainer_base", "(Lcom/bytedance/salamander/anniex/ContainerBase;)V", "js_base", "Lcom/bytedance/salamander/anniex/JsBase;", "getJs_base", "()Lcom/bytedance/salamander/anniex/JsBase;", "setJs_base", "(Lcom/bytedance/salamander/anniex/JsBase;)V", "eventType", "Lcom/bytedance/salamander/anniex/SLEventType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SLEvent {
    private ContainerBase container_base = new ContainerBase();
    private JsBase js_base = new JsBase();

    public ContainerBase getContainer_base() {
        return this.container_base;
    }

    public void setContainer_base(ContainerBase containerBase) {
        Intrinsics.checkNotNullParameter(containerBase, "<set-?>");
        this.container_base = containerBase;
    }

    public JsBase getJs_base() {
        return this.js_base;
    }

    public void setJs_base(JsBase jsBase) {
        Intrinsics.checkNotNullParameter(jsBase, "<set-?>");
        this.js_base = jsBase;
    }

    public SLEventType eventType() {
        return SLEventType.PV;
    }
}
