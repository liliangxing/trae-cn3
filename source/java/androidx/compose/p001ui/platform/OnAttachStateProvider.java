package androidx.compose.p001ui.platform;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/OnAttachStateProvider;", "Landroid/view/View$OnAttachStateChangeListener;", "<init>", "()V", "listeners", "", "addOnAttachStateChangeListener", "", "listener", "removeOnAttachStateChangeListener", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class OnAttachStateProvider implements View.OnAttachStateChangeListener {
    public static final int $stable = 8;
    private final List<View.OnAttachStateChangeListener> listeners = new ArrayList();

    public final void addOnAttachStateChangeListener(View.OnAttachStateChangeListener listener) {
        if (this.listeners.contains(listener)) {
            return;
        }
        this.listeners.add(listener);
    }

    public final void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener listener) {
        this.listeners.remove(listener);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        Iterator it = CollectionsKt.toList(this.listeners).iterator();
        while (it.hasNext()) {
            ((View.OnAttachStateChangeListener) it.next()).onViewAttachedToWindow(v);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        Iterator it = CollectionsKt.toList(this.listeners).iterator();
        while (it.hasNext()) {
            ((View.OnAttachStateChangeListener) it.next()).onViewDetachedFromWindow(v);
        }
    }
}
