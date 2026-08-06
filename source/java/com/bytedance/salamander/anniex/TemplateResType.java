package com.bytedance.salamander.anniex;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.lynx.tasm.TemplateBundle;
import kotlin.Metadata;

/* compiled from: AnniexMonitorEventTypingsBaseContainerBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/salamander/anniex/TemplateResType;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "Gecko", "GeckoUpdate", CDNLoader.PIPELINE_VALUE, "CDNCache", "BuiltIn", "Offline", TemplateBundle.TAG, "BinaryData", "Unknown", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum TemplateResType {
    Gecko(0),
    GeckoUpdate(1),
    CDN(2),
    CDNCache(3),
    BuiltIn(4),
    Offline(5),
    TemplateBundle(6),
    BinaryData(7),
    Unknown(8);

    private final long value;

    TemplateResType(long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }
}
