package com.bytedance.sysoptimizer;

import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class Bean implements Serializable {
    String a;
    int b;
    float c;
    double d;
    boolean e;
    byte f;
    char g;
    short h;
    long i;

    public String toString() {
        return "Bean{a='" + this.a + "', b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + ((int) this.f) + ", g=" + this.g + ", h=" + ((int) this.h) + ", i=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
