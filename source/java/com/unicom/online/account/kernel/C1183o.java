package com.unicom.online.account.kernel;

/* renamed from: com.unicom.online.account.kernel.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1183o extends Exception {

    /* renamed from: a */
    private final int f288a;

    /* renamed from: b */
    private final String f289b;

    public C1183o(EnumC1178j enumC1178j) {
        super(enumC1178j.f283A);
        this.f288a = Integer.parseInt(enumC1178j.f284z);
        this.f289b = enumC1178j.f283A;
    }

    public C1183o(EnumC1178j enumC1178j, Exception exc) {
        super(enumC1178j.f283A);
        this.f288a = Integer.parseInt(enumC1178j.f284z);
        this.f289b = enumC1178j.f283A + " case by : " + exc.getMessage();
    }
}
