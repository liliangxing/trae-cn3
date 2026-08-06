package com.bytedance.bdinstall;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public interface IOaidObserver {
    void onOaidLoaded(Oaid oaid);

    /* loaded from: classes3.dex */
    public static final class Oaid {
        public final String id;
        public final boolean maySupport;

        public Oaid(String str, boolean z) {
            this.id = str;
            this.maySupport = z;
        }

        public String toString() {
            return "Oaid{id='" + this.id + "', maySupport=" + this.maySupport + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
