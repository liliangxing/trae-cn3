package com.ss.android.http.legacy;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;

@Deprecated
/* loaded from: classes7.dex */
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
