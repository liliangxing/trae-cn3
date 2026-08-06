package com.bytedance.forest.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.ForestConcurrentList.ForestListNode;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestConcurrentList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/forest/model/ForestConcurrentList;", ExifInterface.LONGITUDE_EAST, "Lcom/bytedance/forest/model/ForestConcurrentList$ForestListNode;", "", "()V", "head", "getFirst", "()Lcom/bytedance/forest/model/ForestConcurrentList$ForestListNode;", "insertToHead", "", "node", "ForestListNode", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class ForestConcurrentList<E extends ForestListNode> {
    private final ForestListNode head = new ForestListNode();

    /* compiled from: ForestConcurrentList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0000H\u0016J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\t\u001a\u00020\u0000R\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/forest/model/ForestConcurrentList$ForestListNode;", "", "()V", "next", "Ljava/util/concurrent/atomic/AtomicReference;", "getNext$forest_release", "()Ljava/util/concurrent/atomic/AtomicReference;", "getNext", "tryInsertToNext", "node", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static class ForestListNode {
        private final AtomicReference<ForestListNode> next = new AtomicReference<>(null);

        public final AtomicReference<ForestListNode> getNext$forest_release() {
            return this.next;
        }

        public ForestListNode getNext() {
            return this.next.get();
        }

        public final ForestListNode tryInsertToNext(ForestListNode node) {
            Intrinsics.checkParameterIsNotNull(node, "node");
            ForestListNode forestListNode = this.next.get();
            node.next.set(forestListNode);
            if (UByte$$ExternalSyntheticBackport0.m((AtomicReference) this.next, (Object) forestListNode, (Object) node)) {
                return null;
            }
            return getNext();
        }
    }

    public final void insertToHead(ForestListNode node) {
        ForestListNode next;
        Intrinsics.checkParameterIsNotNull(node, "node");
        node.getNext$forest_release().set(null);
        do {
            next = this.head.getNext();
            node.getNext$forest_release().set(next);
        } while (!UByte$$ExternalSyntheticBackport0.m((AtomicReference) this.head.getNext$forest_release(), (Object) next, (Object) node));
    }

    public final E getFirst() {
        E e = (E) this.head.getNext();
        if (e instanceof ForestListNode) {
            return e;
        }
        return null;
    }
}
