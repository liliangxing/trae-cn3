package com.bytedance.timonbase.scene;

import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.bytedance.tracing.log.Fields;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessBackgroundReferee.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/timonbase/scene/ProcessBackgroundReferee;", "Lcom/bytedance/timon/foundation/interfaces/TimonBackgroundReferee;", "Landroidx/lifecycle/LifecycleEventObserver;", "()V", "_isAppBackground", "", "enterBackgroundPts", "", "stateChangedListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "addStatusChangeListener", "listener", "enterBackground", "enterBackgroundTimeStamp", "enterForeground", "forceUpdate", "isAppBackground", "onStateChanged", TimonPipeline.KEY_SOURCE, "Landroidx/lifecycle/LifecycleOwner;", Fields.EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "removeStatusChangeListener", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ProcessBackgroundReferee implements TimonBackgroundReferee, LifecycleEventObserver {
    private long enterBackgroundPts;
    private boolean _isAppBackground = true;
    private final CopyOnWriteArrayList<Function1<Boolean, Unit>> stateChangedListener = new CopyOnWriteArrayList<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
        }
    }

    public ProcessBackgroundReferee() {
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkExpressionValueIsNotNull(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().addObserver((LifecycleObserver) this);
        TMThreadUtils.INSTANCE.main(new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.ProcessBackgroundReferee.1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1069invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1069invoke() {
                LifecycleOwner lifecycleOwner2 = ProcessLifecycleOwner.get();
                Intrinsics.checkExpressionValueIsNotNull(lifecycleOwner2, "ProcessLifecycleOwner.get()");
                Lifecycle lifecycle = lifecycleOwner2.getLifecycle();
                Intrinsics.checkExpressionValueIsNotNull(lifecycle, "ProcessLifecycleOwner.get().lifecycle");
                if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    ProcessBackgroundReferee.enterForeground$default(ProcessBackgroundReferee.this, false, 1, null);
                }
            }
        });
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkParameterIsNotNull(source, TimonPipeline.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(event, Fields.EVENT);
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            enterForeground(true);
        } else if (i == 2) {
            enterForeground$default(this, false, 1, null);
        } else {
            if (i != 3) {
                return;
            }
            enterBackground();
        }
    }

    private final void enterBackground() {
        this._isAppBackground = true;
        this.enterBackgroundPts = SystemClock.elapsedRealtime();
        Iterator<T> it = this.stateChangedListener.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(Boolean.valueOf(this._isAppBackground));
        }
    }

    static /* synthetic */ void enterForeground$default(ProcessBackgroundReferee processBackgroundReferee, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        processBackgroundReferee.enterForeground(z);
    }

    private final void enterForeground(boolean forceUpdate) {
        if (forceUpdate || this._isAppBackground) {
            this._isAppBackground = false;
            this.enterBackgroundPts = 0L;
            Iterator<T> it = this.stateChangedListener.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(Boolean.valueOf(this._isAppBackground));
            }
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee
    /* renamed from: isAppBackground, reason: from getter */
    public boolean get_isAppBackground() {
        return this._isAppBackground;
    }

    @Override // com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee
    /* renamed from: enterBackgroundTimeStamp, reason: from getter */
    public long getEnterBackgroundPts() {
        return this.enterBackgroundPts;
    }

    @Override // com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee
    public void addStatusChangeListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.stateChangedListener.add(listener);
    }

    @Override // com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee
    public void removeStatusChangeListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.stateChangedListener.add(listener);
    }
}
