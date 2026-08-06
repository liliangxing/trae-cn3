package com.bytedance.ies.xbridge;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadableMapImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/KeyIteratorImpl;", "Lcom/bytedance/ies/xbridge/XKeyIterator;", "origin", "", "", "(Ljava/util/Iterator;)V", "hasNextKey", "", "nextKey", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class KeyIteratorImpl implements XKeyIterator {
    private final Iterator<String> origin;

    public KeyIteratorImpl(Iterator<String> origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.origin = origin;
    }

    @Override // com.bytedance.ies.xbridge.XKeyIterator
    public boolean hasNextKey() {
        return this.origin.hasNext();
    }

    @Override // com.bytedance.ies.xbridge.XKeyIterator
    public String nextKey() {
        return this.origin.next();
    }
}
