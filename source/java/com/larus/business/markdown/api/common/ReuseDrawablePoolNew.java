package com.larus.business.markdown.api.common;

import android.content.Context;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManager;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import io.noties.markwon.image.AsyncDrawable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReuseDrawablePoolNew.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ$\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u000fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bJ\f\u0010\u0012\u001a\u00020\n*\u00020\rH\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "", "()V", "lastCreateIsDarkMode", "", "Ljava/lang/Boolean;", "pool", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lio/noties/markwon/image/AsyncDrawable;", "clear", "", "obtain", "context", "Landroid/content/Context;", "predict", "Lkotlin/Function1;", "recycle", "drawable", "updateCacheStatus", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ReuseDrawablePoolNew {
    private Boolean lastCreateIsDarkMode;
    private final CopyOnWriteArrayList<AsyncDrawable> pool = new CopyOnWriteArrayList<>();

    public final void recycle(AsyncDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.pool.add(drawable);
    }

    public final void clear() {
        this.pool.clear();
    }

    private final void updateCacheStatus(Context context) {
        boolean z = (context.getResources().getConfiguration().uiMode & 48) == 32;
        if (Intrinsics.areEqual(Boolean.valueOf(z), this.lastCreateIsDarkMode)) {
            return;
        }
        this.pool.clear();
        this.lastCreateIsDarkMode = Boolean.valueOf(z);
    }

    public final AsyncDrawable obtain(Context context, Function1<? super AsyncDrawable, Boolean> predict) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(predict, "predict");
        try {
            updateCacheStatus(context);
            Iterator<AsyncDrawable> it = this.pool.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (((Boolean) predict.invoke(it.next())).booleanValue()) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                return this.pool.get(i);
            }
            return null;
        } catch (Exception e) {
            IMarkdownEnsureManager markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate();
            if (markdownEnsureManagerDelegate != null) {
                markdownEnsureManagerDelegate.ensureNotReachHere(e, "ReuseDrawablePoolNew obtain exception");
            }
            return null;
        }
    }
}
