package com.bytedance.pitaya.api.bean.py;

import com.bytedance.pitaya.api.bean.PTYClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PTYMemoryViewBuffer.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\b\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bB?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/pitaya/api/bean/py/PTYMemoryViewBuffer;", "Lcom/bytedance/pitaya/api/bean/PTYClass;", "rawBytes", "", "rawFloats", "", "readOnly", "", "shape", "", "customInfo", "([B[FZLjava/lang/String;Ljava/lang/String;)V", "", "Lorg/json/JSONObject;", "([B[FZ[ILorg/json/JSONObject;)V", "customInfoStr", "getCustomInfoStr", "()Ljava/lang/String;", "getRawBytes", "()[B", "rawDataType", "", "getRawDataType$annotations", "()V", "getRawFloats", "()[F", "getReadOnly", "()Z", "getShape", "()[I", "size", "", "getSize", "()J", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PTYMemoryViewBuffer extends PTYClass {
    private final String customInfoStr;
    private final byte[] rawBytes;
    private final int rawDataType;
    private final float[] rawFloats;
    private final boolean readOnly;
    private final int[] shape;
    private final long size;

    public PTYMemoryViewBuffer() {
        this((byte[]) null, (float[]) null, false, (int[]) null, (JSONObject) null, 31, (DefaultConstructorMarker) null);
    }

    private static /* synthetic */ void getRawDataType$annotations() {
    }

    public /* synthetic */ PTYMemoryViewBuffer(byte[] bArr, float[] fArr, boolean z, int[] iArr, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr, (i & 2) != 0 ? null : fArr, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : iArr, (i & 16) != 0 ? null : jSONObject);
    }

    public final byte[] getRawBytes() {
        return this.rawBytes;
    }

    public final float[] getRawFloats() {
        return this.rawFloats;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final int[] getShape() {
        return this.shape;
    }

    public PTYMemoryViewBuffer(byte[] bArr, float[] fArr, boolean z, int[] iArr, JSONObject jSONObject) {
        super(1);
        long length;
        int i;
        this.rawBytes = bArr;
        this.rawFloats = fArr;
        this.readOnly = z;
        this.shape = iArr;
        if (bArr != null) {
            length = bArr.length;
        } else {
            length = fArr != null ? fArr.length * 4 : 0L;
        }
        this.size = length;
        this.customInfoStr = jSONObject != null ? jSONObject.toString() : null;
        if (z) {
            if (bArr != null) {
                i = 2;
            } else {
                if (fArr == null) {
                    throw new IllegalArgumentException("Tensor has no data!");
                }
                i = 3;
            }
            this.rawDataType = i;
            return;
        }
        throw new IllegalArgumentException("Only READ_ONLY MemoryViewBuffer is supported since Pitaya 2.7,More information please contact with mabenteng");
    }

    public final long getSize() {
        return this.size;
    }

    public final String getCustomInfoStr() {
        return this.customInfoStr;
    }

    /* synthetic */ PTYMemoryViewBuffer(byte[] bArr, float[] fArr, boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, fArr, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PTYMemoryViewBuffer(byte[] bArr, float[] fArr, boolean z, String str, String str2) {
        this(bArr, fArr, z, r7, r0);
        int[] iArr;
        int[] iArr2;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                iArr = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr[i] = jSONArray.getInt(i);
                }
            } catch (Exception unused) {
                iArr = null;
            }
            iArr2 = iArr;
        } else {
            iArr2 = null;
        }
        if (str2 != null) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Exception unused2) {
            }
        }
    }
}
