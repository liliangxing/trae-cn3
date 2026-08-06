package com.bytedance.dr;

import android.content.Context;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public interface OaidApi {

    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public boolean b;

        public String toString() {
            return com.bytedance.tobshadow.bdtracker.a.a("Result{oaid='").append(this.a).append('\'').append(", isTrackLimit=").append(this.b).append(AbstractJsonLexerKt.END_OBJ).toString();
        }
    }

    String getName();

    a getOaid(Context context);

    boolean support(Context context);
}
