package com.bytedance.ies.bullet.schema.param;

import androidx.core.view.GravityCompat;
import kotlin.Metadata;

/* compiled from: GravityParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/schema/param/GravityType;", "", "value", "", "clientValue", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getClientValue", "()I", "getValue", "()Ljava/lang/String;", "CENTER", "BOTTOM", "RIGHT", "END", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum GravityType {
    CENTER("center", 17),
    BOTTOM("bottom", 80),
    RIGHT("right", 5),
    END("end", GravityCompat.END);

    private final int clientValue;
    private final String value;

    GravityType(String str, int i) {
        this.value = str;
        this.clientValue = i;
    }

    public final int getClientValue() {
        return this.clientValue;
    }

    public final String getValue() {
        return this.value;
    }
}
