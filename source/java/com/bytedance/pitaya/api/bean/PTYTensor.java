package com.bytedance.pitaya.api.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYTensor.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYTensor;", "Lcom/bytedance/pitaya/api/bean/PTYClass;", "rawBytes", "", "rawFloats", "", "dataType", "", "dataFormat", "dims", "", "fraction", "name", "", "([B[FII[IILjava/lang/String;)V", "getDataFormat", "()I", "getDataType", "getDims", "()[I", "getFraction", "getName", "()Ljava/lang/String;", "getRawBytes", "()[B", "rawDataType", "getRawDataType$annotations", "()V", "getRawFloats", "()[F", "dataTypeSize", "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PTYTensor extends PTYClass {
    public static final int DATA_FORMAT_NCHW = 0;
    public static final int DATA_FORMAT_NHWC = 1;
    public static final int DATA_TYPE_Double = 22;
    public static final int DATA_TYPE_Float16 = 20;
    public static final int DATA_TYPE_Float32 = 21;
    public static final int DATA_TYPE_Int16 = 11;
    public static final int DATA_TYPE_Int32 = 12;
    public static final int DATA_TYPE_Int8 = 10;
    public static final int DATA_TYPE_U8 = 0;
    public static final int DATA_TYPE_UNKNOWN = 999;
    public static final int DATA_TYPE_Uint16 = 1;
    public static final int DATA_TYPE_Uint32 = 2;
    private final int dataFormat;
    private final int dataType;
    private final int[] dims;
    private final int fraction;
    private final String name;
    private final byte[] rawBytes;
    private final int rawDataType;
    private final float[] rawFloats;

    private final int dataTypeSize(int dataType) {
        if (dataType == 0) {
            return 1;
        }
        if (dataType != 1) {
            if (dataType != 2) {
                if (dataType != 20) {
                    if (dataType == 22) {
                        return 8;
                    }
                    switch (dataType) {
                        case 10:
                            return 1;
                        case 11:
                            break;
                        case 12:
                            break;
                        default:
                            return 0;
                    }
                }
            }
            return 4;
        }
        return 2;
    }

    private static /* synthetic */ void getRawDataType$annotations() {
    }

    public /* synthetic */ PTYTensor(byte[] bArr, float[] fArr, int i, int i2, int[] iArr, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : bArr, (i4 & 2) != 0 ? null : fArr, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, iArr, (i4 & 32) != 0 ? 0 : i3, str);
    }

    public final byte[] getRawBytes() {
        return this.rawBytes;
    }

    public final float[] getRawFloats() {
        return this.rawFloats;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final int getDataFormat() {
        return this.dataFormat;
    }

    public final int[] getDims() {
        return this.dims;
    }

    public final int getFraction() {
        return this.fraction;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PTYTensor(byte[] bArr, float[] fArr, int i, int i2, int[] iArr, int i3, String name) {
        super(0);
        int i4;
        Intrinsics.checkNotNullParameter(name, "name");
        this.rawBytes = bArr;
        this.rawFloats = fArr;
        this.dataType = i;
        this.dataFormat = i2;
        this.dims = iArr;
        this.fraction = i3;
        this.name = name;
        if (bArr != null) {
            i4 = 2;
        } else {
            if (fArr == null) {
                throw new IllegalArgumentException("Tensor has no data!");
            }
            i4 = 3;
        }
        this.rawDataType = i4;
    }
}
