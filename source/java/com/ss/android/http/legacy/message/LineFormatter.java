package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.Header;

@Deprecated
/* loaded from: classes7.dex */
public interface LineFormatter {
    CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer, Header header);
}
