package com.bytedance.ies.xbridge;

import kotlin.Metadata;

/* compiled from: XCollections.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/xbridge/XDynamic;", "", "asArray", "Lcom/bytedance/ies/xbridge/XReadableArray;", "asBoolean", "", "asDouble", "", "asInt", "", "asMap", "Lcom/bytedance/ies/xbridge/XReadableMap;", "asString", "", "getType", "Lcom/bytedance/ies/xbridge/XReadableType;", "isNull", "recycle", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface XDynamic {
    XReadableArray asArray();

    boolean asBoolean();

    double asDouble();

    int asInt();

    XReadableMap asMap();

    String asString();

    XReadableType getType();

    boolean isNull();

    void recycle();
}
