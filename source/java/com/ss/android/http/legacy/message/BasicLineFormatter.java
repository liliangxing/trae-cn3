package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.FormattedHeader;
import com.ss.android.http.legacy.Header;

@Deprecated
/* loaded from: classes7.dex */
public class BasicLineFormatter implements LineFormatter {
    public static final BasicLineFormatter DEFAULT = new BasicLineFormatter();

    protected CharArrayBuffer initBuffer(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer != null) {
            charArrayBuffer.clear();
            return charArrayBuffer;
        }
        return new CharArrayBuffer(64);
    }

    public static final String formatHeader(Header header, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = DEFAULT;
        }
        return lineFormatter.formatHeader(null, header).toString();
    }

    @Override // com.ss.android.http.legacy.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer, Header header) {
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        }
        if (header instanceof FormattedHeader) {
            return ((FormattedHeader) header).getBuffer();
        }
        CharArrayBuffer initBuffer = initBuffer(charArrayBuffer);
        doFormatHeader(initBuffer, header);
        return initBuffer;
    }

    protected void doFormatHeader(CharArrayBuffer charArrayBuffer, Header header) {
        String name = header.getName();
        String value = header.getValue();
        int length = name.length() + 2;
        if (value != null) {
            length += value.length();
        }
        charArrayBuffer.ensureCapacity(length);
        charArrayBuffer.append(name);
        charArrayBuffer.append(": ");
        if (value != null) {
            charArrayBuffer.append(value);
        }
    }
}
