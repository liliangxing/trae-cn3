package com.bytedance.crash.dumper.tools;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class JsonDumper extends StringDumper {
    public JsonDumper(String str) {
        super(str);
    }

    public JsonDumper objectBegin() {
        append(AbstractJsonLexerKt.BEGIN_OBJ);
        return this;
    }

    public JsonDumper objectEnd() {
        append(AbstractJsonLexerKt.END_OBJ);
        return this;
    }

    public JsonDumper arrayBegin() {
        append(AbstractJsonLexerKt.BEGIN_LIST);
        return this;
    }

    public JsonDumper arrayEnd() {
        append(AbstractJsonLexerKt.END_LIST);
        return this;
    }

    public JsonDumper next() {
        append(',');
        return this;
    }

    public JsonDumper key(String str) {
        append('\"').append(str).append('\"').append(AbstractJsonLexerKt.COLON).append(' ');
        return this;
    }

    public JsonDumper value(boolean z) {
        append(z);
        return this;
    }

    public JsonDumper value(long j) {
        append(j);
        return this;
    }

    public JsonDumper value(int i) {
        append(i);
        return this;
    }

    public JsonDumper value(char c) {
        append(c);
        return this;
    }

    public JsonDumper value(String str) {
        append('\"');
        int length = str == null ? 0 : str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                append("\\f");
            } else if (charAt == '\r') {
                append("\\r");
            } else if (charAt == '\"' || charAt == '\\') {
                append(AbstractJsonLexerKt.STRING_ESC);
                append(charAt);
            } else if (charAt != 8232 && charAt != 8233) {
                switch (charAt) {
                    case '\b':
                        append("\\b");
                        break;
                    case '\t':
                        append("\\t");
                        break;
                    case '\n':
                        append("\\n");
                        break;
                    default:
                        if (charAt <= 31) {
                            append(String.format("\\u%04x", Integer.valueOf(charAt)));
                            break;
                        } else {
                            append(charAt);
                            break;
                        }
                }
            } else {
                append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
        }
        append('\"');
        return this;
    }
}
