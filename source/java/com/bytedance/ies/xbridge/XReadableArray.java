package com.bytedance.ies.xbridge;

import java.util.List;
import kotlin.Metadata;

/* compiled from: XCollections.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/xbridge/XReadableArray;", "", "get", "Lcom/bytedance/ies/xbridge/XDynamic;", "index", "", "getArray", "getBoolean", "", "getDouble", "", "getInt", "getMap", "Lcom/bytedance/ies/xbridge/XReadableMap;", "getString", "", "getType", "Lcom/bytedance/ies/xbridge/XReadableType;", "isNull", "size", "toList", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface XReadableArray {
    XDynamic get(int index);

    XReadableArray getArray(int index);

    boolean getBoolean(int index);

    double getDouble(int index);

    int getInt(int index);

    XReadableMap getMap(int index);

    String getString(int index);

    XReadableType getType(int index);

    boolean isNull(int index);

    int size();

    List<Object> toList();
}
