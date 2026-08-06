package com.bytedance.ies.xbridge;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: XCollections.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/xbridge/XReadableMap;", "", "get", "Lcom/bytedance/ies/xbridge/XDynamic;", "name", "", "getArray", "Lcom/bytedance/ies/xbridge/XReadableArray;", "getBoolean", "", "getDouble", "", "getInt", "", "getMap", "getString", "getType", "Lcom/bytedance/ies/xbridge/XReadableType;", "hasKey", "isNull", "keyIterator", "Lcom/bytedance/ies/xbridge/XKeyIterator;", "toMap", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface XReadableMap {
    XDynamic get(String name);

    XReadableArray getArray(String name);

    boolean getBoolean(String name);

    double getDouble(String name);

    int getInt(String name);

    XReadableMap getMap(String name);

    String getString(String name);

    XReadableType getType(String name);

    boolean hasKey(String name);

    boolean isNull(String name);

    XKeyIterator keyIterator();

    Map<String, Object> toMap();
}
