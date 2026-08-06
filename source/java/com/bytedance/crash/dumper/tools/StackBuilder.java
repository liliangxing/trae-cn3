package com.bytedance.crash.dumper.tools;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes3.dex */
public class StackBuilder {
    private static final char[] NATIVE_METHOD = {'(', 'N', 'a', 't', 'i', 'v', 'e', ' ', 'M', 'e', 't', 'h', 'o', 'd', ')'};
    private static final char[] UNKOWN_SOURCE = {'(', Matrix.MATRIX_TYPE_RANDOM_UT, 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'S', 'o', AbstractJsonLexerKt.UNICODE_ESC, 'r', 'c', 'e', ')'};
    private static final char[] UNKOWN_SOURCE_COLON = {'(', Matrix.MATRIX_TYPE_RANDOM_UT, 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'S', 'o', AbstractJsonLexerKt.UNICODE_ESC, 'r', 'c', 'e', AbstractJsonLexerKt.COLON};
    private final StringDumper mStringDumper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackBuilder(StringDumper stringDumper) {
        this.mStringDumper = stringDumper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackBuilder append(int i) {
        this.mStringDumper.append(i);
        return this;
    }

    StackBuilder append(String str) {
        if (str.length() != 0) {
            this.mStringDumper.append(str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackBuilder append(char c) {
        this.mStringDumper.append(c);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackBuilder append(char[] cArr) {
        if (cArr.length != 0) {
            this.mStringDumper.append(cArr);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackBuilder append(Throwable th) {
        this.mStringDumper.append(th);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackBuilder append(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();
        boolean isNativeMethod = stackTraceElement.isNativeMethod();
        append(className).append('.').append(methodName);
        if (isNativeMethod) {
            append(NATIVE_METHOD);
        } else if (fileName != null) {
            if (stackTraceElement.getLineNumber() >= 0) {
                append('(').append(fileName).append(AbstractJsonLexerKt.COLON).append(lineNumber).append(')');
            } else {
                append('(').append(fileName).append(')');
            }
        } else if (lineNumber >= 0) {
            append(UNKOWN_SOURCE_COLON).append(lineNumber).append(')');
        } else {
            append(UNKOWN_SOURCE);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackBuilder appendTabs(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mStringDumper.append('\t');
        }
        return this;
    }
}
