package com.bytedance.common.wschannel.converter;

/* loaded from: classes3.dex */
public class MsgConverterFactory {
    private static MsgConverter DEFAULT;
    private static MsgConverter sConverter;

    static {
        WireConverter wireConverter = new WireConverter();
        DEFAULT = wireConverter;
        sConverter = wireConverter;
    }

    public static MsgConverter getConverter() {
        return sConverter;
    }

    public static void setConverter(MsgConverter msgConverter) {
        if (msgConverter == null) {
            return;
        }
        sConverter = msgConverter;
    }
}
