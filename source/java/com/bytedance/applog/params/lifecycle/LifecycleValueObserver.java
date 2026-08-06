package com.bytedance.applog.params.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.params.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleValueObserver.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/params/lifecycle/LifecycleValueObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "Lkotlin/Function0;", "", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;)V", "loggerTag", "", "", "getOnDestroy", "()Lkotlin/jvm/functions/Function0;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "destroy", "onStateChanged", DBHelper.BATTERY_COL_SOURCE, "event", "Landroidx/lifecycle/Lifecycle$Event;", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LifecycleValueObserver implements LifecycleEventObserver {
    private final List<String> loggerTag;
    private final Function0<Unit> onDestroy;
    private final LifecycleOwner owner;

    public LifecycleValueObserver(LifecycleOwner lifecycleOwner, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function0, "onDestroy");
        this.owner = lifecycleOwner;
        this.onDestroy = function0;
        this.loggerTag = CollectionsKt.listOf("LifecycleValueObserver");
        UtilsKt.mainThreadRun(new Function0<Unit>() { // from class: com.bytedance.applog.params.lifecycle.LifecycleValueObserver.1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m426invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m426invoke() {
                if (LifecycleValueObserver.this.getOwner().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    LoggerImpl.global().error(LifecycleValueObserver.this.loggerTag, "params lifecycle added failed for state is destroyed!", new Object[0]);
                    LifecycleValueObserver.this.getOnDestroy().invoke();
                } else {
                    LifecycleValueObserver.this.getOwner().getLifecycle().addObserver(LifecycleValueObserver.this);
                    LoggerImpl.global().info(LifecycleValueObserver.this.loggerTag, "params with lifecycle owner added!", new Object[0]);
                }
            }
        });
    }

    public final Function0<Unit> getOnDestroy() {
        return this.onDestroy;
    }

    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            LoggerImpl.global().info(this.loggerTag, "params with lifecycle owner destroyed and onDestroy callback invoke start...", new Object[0]);
            this.onDestroy.invoke();
            destroy();
        }
    }

    public final void destroy() {
        UtilsKt.mainThreadRun(new Function0<Unit>() { // from class: com.bytedance.applog.params.lifecycle.LifecycleValueObserver$destroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m427invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m427invoke() {
                LifecycleValueObserver.this.getOwner().getLifecycle().removeObserver(LifecycleValueObserver.this);
            }
        });
    }
}
