package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.tasm.behavior.PropertyIDConstants;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MapBufferUtils {
    public static ReadableMap convertStyleMapBufferToReadableMap(ReadableMapBuffer readableMapBuffer) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (readableMapBuffer != null) {
            Iterator<MapBuffer.Entry> it = readableMapBuffer.iterator();
            while (it.hasNext()) {
                MapBuffer.Entry next = it.next();
                int key = next.getKey();
                MapBuffer.DataType type = next.getType();
                String str = PropertyIDConstants.PROPERTY_CONSTANT[key];
                switch (C14631.$SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[type.ordinal()]) {
                    case 1:
                        javaOnlyMap.put(str, new ReadableMapBufferWrapper(next.getMapBuffer()));
                        break;
                    case 2:
                        javaOnlyMap.put(str, Integer.valueOf(next.getInt()));
                        break;
                    case 3:
                        javaOnlyMap.put(str, Boolean.valueOf(next.getBoolean()));
                        break;
                    case 4:
                        javaOnlyMap.put(str, Long.valueOf(next.getLong()));
                        break;
                    case 5:
                        javaOnlyMap.put(str, next.getString());
                        break;
                    case 6:
                        javaOnlyMap.put(str, Double.valueOf(next.getDouble()));
                        break;
                    case 7:
                        javaOnlyMap.put(str, null);
                        break;
                }
            }
        }
        return javaOnlyMap;
    }

    /* renamed from: com.lynx.react.bridge.mapbuffer.MapBufferUtils$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static /* synthetic */ class C14631 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType;

        static {
            int[] iArr = new int[MapBuffer.DataType.values().length];
            $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType = iArr;
            try {
                iArr[MapBuffer.DataType.ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.BOOL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.DOUBLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.NULL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
