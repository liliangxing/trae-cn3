package io.noties.markwon.pool;

import io.noties.markwon.image.AsyncDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReuseDrawablePool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/pool/ReuseDrawablePool;", "", "()V", "pool", "", "Lio/noties/markwon/image/AsyncDrawable;", "clear", "", "obtain", "predict", "Lkotlin/Function1;", "", "recycle", "drawable", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class ReuseDrawablePool {
    private final List<AsyncDrawable> pool = new ArrayList();

    public final void recycle(AsyncDrawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        this.pool.add(drawable);
    }

    public final void clear() {
        this.pool.clear();
    }

    public final AsyncDrawable obtain(Function1<? super AsyncDrawable, Boolean> predict) {
        Intrinsics.checkParameterIsNotNull(predict, "predict");
        Iterator<AsyncDrawable> it = this.pool.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (predict.invoke(it.next()).booleanValue()) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return this.pool.remove(i);
        }
        return null;
    }
}
