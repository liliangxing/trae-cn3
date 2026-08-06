package com.lynx.tasm.behavior.p000ui.utils;

import android.renderscript.Matrix4f;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TransformRaw {

    /* renamed from: p0 */
    private final float f17p0;
    private final int p0Unit;

    /* renamed from: p1 */
    private final float f18p1;
    private final int p1Unit;

    /* renamed from: p2 */
    private final float f19p2;
    private final int p2Unit;
    private final PlatformLength platformLengthP0;
    private final PlatformLength platformLengthP1;
    private final PlatformLength platformLengthP2;
    private final float[] transformRawData;
    private final int transformType;

    private TransformRaw(int i, float f, int i2, float f2, int i3, float f3, int i4) {
        this.transformType = i;
        this.platformLengthP0 = new PlatformLength(0.0f, 0);
        this.f17p0 = f;
        this.p0Unit = i2;
        this.platformLengthP1 = new PlatformLength(0.0f, 0);
        this.f18p1 = f2;
        this.p1Unit = i3;
        this.platformLengthP2 = new PlatformLength(0.0f, 0);
        this.f19p2 = f3;
        this.p2Unit = i4;
        this.transformRawData = new Matrix4f().getArray();
    }

    private TransformRaw(int i, PlatformLength platformLength, int i2, PlatformLength platformLength2, int i3, PlatformLength platformLength3, int i4) {
        this.transformType = i;
        this.platformLengthP0 = platformLength;
        this.f17p0 = 0.0f;
        this.p0Unit = i2;
        this.platformLengthP1 = platformLength2;
        this.f18p1 = 0.0f;
        this.p1Unit = i3;
        this.platformLengthP2 = platformLength3;
        this.f19p2 = 0.0f;
        this.p2Unit = i4;
        this.transformRawData = new Matrix4f().getArray();
    }

    private TransformRaw(int i, float[] fArr) {
        this.transformType = i;
        this.platformLengthP0 = new PlatformLength(0.0f, 0);
        this.f17p0 = 0.0f;
        this.p0Unit = 0;
        this.platformLengthP1 = new PlatformLength(0.0f, 0);
        this.f18p1 = 0.0f;
        this.p1Unit = 0;
        this.platformLengthP2 = new PlatformLength(0.0f, 0);
        this.f19p2 = 0.0f;
        this.p2Unit = 0;
        this.transformRawData = fArr;
    }

    public int getTransformType() {
        return this.transformType;
    }

    public float getP0() {
        return this.f17p0;
    }

    public PlatformLength getPlatformLengthP0() {
        return this.platformLengthP0;
    }

    public boolean isP0Percent() {
        return this.p0Unit == 1;
    }

    public float getP1() {
        return this.f18p1;
    }

    public PlatformLength getPlatformLengthP1() {
        return this.platformLengthP1;
    }

    public boolean isP1Percent() {
        return this.p1Unit == 1;
    }

    public float getP2() {
        return this.f19p2;
    }

    public PlatformLength getPlatformLengthP2() {
        return this.platformLengthP2;
    }

    public boolean isP2Percent() {
        return this.p2Unit == 1;
    }

    public boolean hasPercent() {
        return isP0Percent() || isP1Percent() || isP2Percent();
    }

    public float[] getTransformRawData() {
        return this.transformRawData;
    }

    public static TransformRaw createTransformRaw(int i, float f, int i2, float f2, int i3, float f3, int i4) {
        return new TransformRaw(i, f, i2, f2, i3, f3, i4);
    }

    public static TransformRaw createTransformRaw(int i, PlatformLength platformLength, int i2, PlatformLength platformLength2, int i3, PlatformLength platformLength3, int i4) {
        return new TransformRaw(i, platformLength, i2, platformLength2, i3, platformLength3, i4);
    }

    public static List<TransformRaw> toTransformRaw(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableArray array = readableArray.getArray(i);
            if (array.size() < 7) {
                LLog.DTHROW(new IllegalArgumentException("transform params is error."));
            } else {
                int i2 = array.getInt(0);
                if (i2 == 32768 || i2 == 65536) {
                    float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f};
                    int i3 = 0;
                    while (i3 < 16) {
                        int i4 = i3 + 1;
                        fArr[i3] = (float) array.getDouble(i4);
                        i3 = i4;
                    }
                    arrayList.add(new TransformRaw(i2, fArr));
                } else {
                    int i5 = array.getInt(2);
                    int i6 = array.getInt(4);
                    int i7 = array.getInt(6);
                    if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 8 || i2 == 16) {
                        arrayList.add(new TransformRaw(i2, new PlatformLength(array.getDynamic(1), i5), i5, new PlatformLength(array.getDynamic(3), i6), i6, new PlatformLength(array.getDynamic(5), i7), i7));
                    } else {
                        arrayList.add(new TransformRaw(i2, (float) array.getDouble(1), i5, (float) array.getDouble(3), i6, (float) array.getDouble(5), i7));
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean hasPercent(List<TransformRaw> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<TransformRaw> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().hasPercent()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float hasZValue(List<TransformRaw> list) {
        float f = 0.0f;
        if (list != null && !list.isEmpty()) {
            for (TransformRaw transformRaw : list) {
                int i = transformRaw.transformType;
                if (i == 8) {
                    f = transformRaw.platformLengthP0.asNumber();
                } else if (i == 16) {
                    f = transformRaw.platformLengthP2.asNumber();
                }
            }
        }
        return f;
    }

    public static float hasXValue(List<TransformRaw> list) {
        float f = 0.0f;
        if (list != null && !list.isEmpty()) {
            for (TransformRaw transformRaw : list) {
                int i = transformRaw.transformType;
                if (i == 2 || i == 16) {
                    f = transformRaw.platformLengthP0.asNumber();
                }
            }
        }
        return f;
    }

    public static float hasYValue(List<TransformRaw> list) {
        float f = 0.0f;
        if (list != null && !list.isEmpty()) {
            for (TransformRaw transformRaw : list) {
                int i = transformRaw.transformType;
                if (i == 4) {
                    f = transformRaw.platformLengthP0.asNumber();
                } else if (i == 16) {
                    f = transformRaw.platformLengthP1.asNumber();
                }
            }
        }
        return f;
    }
}
