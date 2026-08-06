package androidx.compose.p001ui.precompose;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;

/* compiled from: Delegates.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/precompose/LifecycleOwnerDelegate;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "realLifecycleOwner", "realLifecycleReachStart", "", "bindRealLifecycleOwner", "", "lifecycleOwner", "onStateChanged", "source", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LifecycleOwnerDelegate implements LifecycleOwner, LifecycleEventObserver {
    public static final int $stable = 8;
    private final LifecycleRegistry lifecycle;
    private final LifecycleRegistry lifecycleRegistry;
    private LifecycleOwner realLifecycleOwner;
    private boolean realLifecycleReachStart;

    public LifecycleOwnerDelegate() {
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.lifecycleRegistry = lifecycleRegistry;
        this.lifecycle = lifecycleRegistry;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        return this.lifecycle;
    }

    public final void bindRealLifecycleOwner(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2 = this.realLifecycleOwner;
        if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        this.realLifecycleOwner = lifecycleOwner;
        this.realLifecycleReachStart = false;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Lifecycle lifecycle;
        if (this.realLifecycleReachStart) {
            this.lifecycleRegistry.handleLifecycleEvent(event);
        }
        if (event.getTargetState().isAtLeast(Lifecycle.State.STARTED)) {
            this.realLifecycleReachStart = true;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            LifecycleOwner lifecycleOwner = this.realLifecycleOwner;
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            this.realLifecycleOwner = null;
            this.realLifecycleReachStart = false;
        }
    }
}
