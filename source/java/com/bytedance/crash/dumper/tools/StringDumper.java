package com.bytedance.crash.dumper.tools;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class StringDumper {
    private final BaseStringDumper mDumper;
    private static final char[] CHARS_TRUE = {'t', 'r', AbstractJsonLexerKt.UNICODE_ESC, 'e'};
    private static final char[] CHARS_FALSE = {'f', 'a', 'l', 's', 'e'};

    public StringDumper(String str) {
        this.mDumper = createDumper(str);
    }

    private BaseStringDumper createDumper(String str) {
        try {
            return new CachedStringDumper(str);
        } catch (Throwable unused) {
            return new DirectStringDumper(str);
        }
    }

    public StringDumper append(boolean z) {
        if (z) {
            this.mDumper.append(CHARS_TRUE);
        } else {
            this.mDumper.append(CHARS_FALSE);
        }
        return this;
    }

    public StringDumper append(char c) {
        this.mDumper.append(c);
        return this;
    }

    public StringDumper append(int i) {
        this.mDumper.append(i);
        return this;
    }

    public StringDumper append(long j) {
        this.mDumper.append(j);
        return this;
    }

    public StringDumper append(char[] cArr) {
        this.mDumper.append(cArr);
        return this;
    }

    public StringDumper append(byte[] bArr) {
        this.mDumper.append(bArr);
        return this;
    }

    public StringDumper append(String str) {
        if (str != null) {
            this.mDumper.append(str);
        }
        return this;
    }

    public StringDumper append(Throwable th) {
        append(th.getClass().getName());
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            append(AbstractJsonLexerKt.COLON).append(' ').append(localizedMessage);
        }
        return this;
    }

    public StringDumper flush() {
        this.mDumper.flush();
        return this;
    }

    public StringDumper release() {
        this.mDumper.release();
        return this;
    }
}
