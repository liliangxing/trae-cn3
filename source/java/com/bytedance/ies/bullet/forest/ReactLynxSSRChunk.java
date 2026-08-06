package com.bytedance.ies.bullet.forest;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.forest.model.PreloadConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: lynx_ssr_processor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ReactLynxSSRChunk;", "", "type", "", ReportConst.ValidationReport.BODY, "", "(I[B)V", "getBody", "()[B", "getType", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ReactLynxSSRChunk {
    private final byte[] body;
    private final int type;

    public static /* synthetic */ ReactLynxSSRChunk copy$default(ReactLynxSSRChunk reactLynxSSRChunk, int i, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = reactLynxSSRChunk.type;
        }
        if ((i2 & 2) != 0) {
            bArr = reactLynxSSRChunk.body;
        }
        return reactLynxSSRChunk.copy(i, bArr);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final byte[] getBody() {
        return this.body;
    }

    public final ReactLynxSSRChunk copy(int type, byte[] body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new ReactLynxSSRChunk(type, body);
    }

    public String toString() {
        return "ReactLynxSSRChunk(type=" + this.type + ", body=" + Arrays.toString(this.body) + ')';
    }

    public ReactLynxSSRChunk(int i, byte[] body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.type = i;
        this.body = body;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final int getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bytedance.ies.bullet.forest.ReactLynxSSRChunk");
        ReactLynxSSRChunk reactLynxSSRChunk = (ReactLynxSSRChunk) other;
        return this.type == reactLynxSSRChunk.type && Arrays.equals(this.body, reactLynxSSRChunk.body);
    }

    public int hashCode() {
        return (this.type * 31) + Arrays.hashCode(this.body);
    }
}
