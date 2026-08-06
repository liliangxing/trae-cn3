package com.bytedance.pitaya.api.util;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueue.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000eJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0086\u0002J\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0012J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/pitaya/api/util/FifoQueue;", "T", "", "maxSize", "", "(I)V", "queue", "Ljava/util/LinkedList;", "add", "", "item", "(Ljava/lang/Object;)V", "clear", "isEmpty", "", "iterator", "", "peek", "()Ljava/lang/Object;", "remove", "size", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FifoQueue<T> {
    private final int maxSize;
    private final LinkedList<T> queue = new LinkedList<>();

    public FifoQueue(int i) {
        this.maxSize = i;
    }

    public final void add(T item) {
        if (this.queue.size() >= this.maxSize) {
            this.queue.removeFirst();
        }
        this.queue.addLast(item);
    }

    public final T remove() {
        if (this.queue.isEmpty()) {
            return null;
        }
        return this.queue.removeFirst();
    }

    public final T peek() {
        return (T) CollectionsKt.firstOrNull(this.queue);
    }

    public final int size() {
        return this.queue.size();
    }

    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public final void clear() {
        this.queue.clear();
    }

    public final Iterator<T> iterator() {
        Iterator<T> it = this.queue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "queue.iterator()");
        return it;
    }
}
