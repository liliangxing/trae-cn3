package io.noties.markwon.ext.onetex;

import android.content.Context;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManager;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReuseTexIconPool.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\tJ\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ)\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0016J\f\u0010\u0017\u001a\u00020\f*\u00020\u0011H\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/ext/onetex/ReuseTexIconPool;", "", "()V", "lastCreateIsDarkMode", "", "Ljava/lang/Boolean;", "pool", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "clear", "", "getSize", "obtain", "", "context", "Landroid/content/Context;", "latex", "recycle", "index", "icon", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/edu/onetex/latex/icon/LaTeXIcon;)V", "updateCacheStatus", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ReuseTexIconPool {
    private Boolean lastCreateIsDarkMode;
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, LaTeXIcon>> pool = new ConcurrentHashMap<>();

    public final void recycle(String latex, Integer index, LaTeXIcon icon) {
        ConcurrentHashMap<Integer, LaTeXIcon> putIfAbsent;
        if (latex == null || index == null || icon == null) {
            return;
        }
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, LaTeXIcon>> concurrentHashMap = this.pool;
        ConcurrentHashMap<Integer, LaTeXIcon> concurrentHashMap2 = concurrentHashMap.get(latex);
        if (concurrentHashMap2 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(latex, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
            concurrentHashMap2 = putIfAbsent;
        }
        ConcurrentHashMap<Integer, LaTeXIcon> concurrentHashMap3 = concurrentHashMap2;
        Intrinsics.checkNotNullExpressionValue(concurrentHashMap3, "map");
        concurrentHashMap3.put(index, icon);
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

    public final List<LaTeXIcon> obtain(Context context, String latex) {
        Set<Map.Entry<Integer, LaTeXIcon>> entrySet;
        List sortedWith;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(latex, "latex");
        try {
            updateCacheStatus(context);
            ConcurrentHashMap<Integer, LaTeXIcon> concurrentHashMap = this.pool.get(latex);
            if (concurrentHashMap == null || (entrySet = concurrentHashMap.entrySet()) == null || (sortedWith = CollectionsKt.sortedWith(entrySet, new Comparator<T>() { // from class: io.noties.markwon.ext.onetex.ReuseTexIconPool$obtain$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) ((Map.Entry) t).getKey(), (Integer) ((Map.Entry) t2).getKey());
                }
            })) == null) {
                return null;
            }
            List list = sortedWith;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((LaTeXIcon) ((Map.Entry) it.next()).getValue());
            }
            return arrayList;
        } catch (Exception e) {
            IMarkdownEnsureManager markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate();
            if (markdownEnsureManagerDelegate != null) {
                markdownEnsureManagerDelegate.ensureNotReachHere(e, "ReuseDrawablePoolNew obtain exception");
            }
            return null;
        }
    }

    public final int getSize() {
        return this.pool.size();
    }
}
