package com.unicom.online.account.kernel;

/* loaded from: classes7.dex */
public final class o extends Exception {
    private final int a;
    private final String b;

    public o(j jVar) {
        super(jVar.A);
        this.a = Integer.parseInt(jVar.z);
        this.b = jVar.A;
    }

    public o(j jVar, Exception exc) {
        super(jVar.A);
        this.a = Integer.parseInt(jVar.z);
        this.b = jVar.A + " case by : " + exc.getMessage();
    }
}
