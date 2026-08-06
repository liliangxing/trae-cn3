package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;
import com.ss.android.http.legacy.ParseException;

@Deprecated
/* loaded from: classes7.dex */
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;
}
