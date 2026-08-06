package com.bytedance.pitaya.media;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* compiled from: GraphicByte.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/pitaya/media/GraphicByte;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "byteArr", "", "getByteArr", "()[B", "setByteArr", "([B)V", "format", "", "getFormat", "()I", "setFormat", "(I)V", "height", "getHeight", "setHeight", "width", "getWidth", "setWidth", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class GraphicByte implements ReflectionCall {
    private byte[] byteArr;
    private int format;
    private int height;
    private int width;

    public final byte[] getByteArr() {
        return this.byteArr;
    }

    public final void setByteArr(byte[] bArr) {
        this.byteArr = bArr;
    }

    public final int getFormat() {
        return this.format;
    }

    public final void setFormat(int i) {
        this.format = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }
}
