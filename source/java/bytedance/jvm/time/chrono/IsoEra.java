package bytedance.jvm.time.chrono;

import bytedance.jvm.time.DateTimeException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public enum IsoEra implements Era {
    BCE,
    CE;

    /* renamed from: of */
    public static IsoEra m124of(int i) {
        if (i == 0) {
            return BCE;
        }
        if (i == 1) {
            return CE;
        }
        throw new DateTimeException("Invalid era: " + i);
    }

    @Override // bytedance.jvm.time.chrono.Era
    public int getValue() {
        return ordinal();
    }
}
