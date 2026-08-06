package com.bytedance.sysoptimizer;

import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class IDSerializable implements Serializable {
    public static final int VAL_NULL = -1;
    public static final int VAL_SERIALIZABLE = 21;
    public static final int VAL_STRING = 0;
    public String id;
    public int valType;

    public IDSerializable(String str, int i) {
        this.id = str;
        this.valType = i;
    }

    public String toString() {
        return "IDSerializable{id='" + this.id + "', valType=" + this.valType + AbstractJsonLexerKt.END_OBJ;
    }
}
