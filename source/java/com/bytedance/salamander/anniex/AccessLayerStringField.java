package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* compiled from: AnniexMonitorCoreSLAnnieXMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/salamander/anniex/AccessLayerStringField;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "CoreViewType", "Biz", "ClientComponent", "Schema", "TemplateResType", "ViewType", "ContainerType", "SdkVersion", "NativePage", "LynxVersion", "WebViewType", "WebEngineVersion", "Url", "GeckoId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum AccessLayerStringField {
    CoreViewType(0),
    Biz(1),
    ClientComponent(2),
    Schema(3),
    TemplateResType(4),
    ViewType(5),
    ContainerType(6),
    SdkVersion(7),
    NativePage(8),
    LynxVersion(9),
    WebViewType(10),
    WebEngineVersion(11),
    Url(12),
    GeckoId(13);

    private final long value;

    AccessLayerStringField(long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }
}
