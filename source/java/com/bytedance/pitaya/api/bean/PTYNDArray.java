package com.bytedance.pitaya.api.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYNDArray.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0019\u0018\u0000  2\u00020\u0001:\u0002 !Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011¨\u0006\""}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYNDArray;", "Lcom/bytedance/pitaya/api/bean/PTYClass;", "index", "", "rawBytes", "", "rawFloats", "", "shapes", "", "type", "bits", "lanes", "deviceID", "deviceType", "(I[B[F[IIIIII)V", "getBits", "()I", "getDeviceID", "getDeviceType", "getIndex", "getLanes", "getRawBytes", "()[B", "rawDataType", "getRawDataType$annotations", "()V", "getRawFloats", "()[F", "getShapes", "()[I", "getType", "Companion", "DLDataType", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PTYNDArray extends PTYClass {
    public static final int DL_B_FLOAT = 4;
    public static final int DL_COMPLEX = 5;
    public static final int DL_FLOAT = 2;
    public static final int DL_INT = 0;
    public static final int DL_OPAQUE_HANDLE = 3;
    public static final int DL_U_INT = 1;
    private final int bits;
    private final int deviceID;
    private final int deviceType;
    private final int index;
    private final int lanes;
    private final byte[] rawBytes;
    private final int rawDataType;
    private final float[] rawFloats;
    private final int[] shapes;
    private final int type;

    /* compiled from: PTYNDArray.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYNDArray$DLDataType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public @interface DLDataType {
    }

    private static /* synthetic */ void getRawDataType$annotations() {
    }

    public /* synthetic */ PTYNDArray(int i, byte[] bArr, float[] fArr, int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? -1 : i, (i7 & 2) != 0 ? null : bArr, (i7 & 4) != 0 ? null : fArr, (i7 & 8) != 0 ? new int[0] : iArr, i2, i3, (i7 & 64) != 0 ? 1 : i4, (i7 & 128) != 0 ? 0 : i5, (i7 & 256) != 0 ? 1 : i6);
    }

    public final int getIndex() {
        return this.index;
    }

    public final byte[] getRawBytes() {
        return this.rawBytes;
    }

    public final float[] getRawFloats() {
        return this.rawFloats;
    }

    public final int[] getShapes() {
        return this.shapes;
    }

    public final int getType() {
        return this.type;
    }

    public final int getBits() {
        return this.bits;
    }

    public final int getLanes() {
        return this.lanes;
    }

    public final int getDeviceID() {
        return this.deviceID;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PTYNDArray(int i, byte[] bArr, float[] fArr, int[] shapes, @DLDataType int i2, int i3, int i4, int i5, int i6) {
        super(3);
        Intrinsics.checkNotNullParameter(shapes, "shapes");
        int i7 = 3;
        this.index = i;
        this.rawBytes = bArr;
        this.rawFloats = fArr;
        this.shapes = shapes;
        this.type = i2;
        this.bits = i3;
        this.lanes = i4;
        this.deviceID = i5;
        this.deviceType = i6;
        if (bArr != null) {
            i7 = 2;
        } else if (fArr == null) {
            throw new IllegalArgumentException("NDArray has no data!");
        }
        this.rawDataType = i7;
    }
}
