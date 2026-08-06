package androidx.compose.p001ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.R;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0003\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002\u001a,\u0010\u0019\u001a\u00020\u0014*\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u001a\u000e\u0010 \u001a\u0004\u0018\u00010\u001f*\u00020\u0003H\u0002\",\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\" \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0010\u001a\u00020\u0003*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001e\u0010\u0013\u001a\u00020\u0014*\u00020\u00038@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {StrategyConstants.VALUE, "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroid/view/View;", "getCompositionContext", "(Landroid/view/View;)Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;)V", "findViewTreeCompositionContext", "animationScale", "", "Landroid/content/Context;", "Lkotlinx/coroutines/flow/StateFlow;", "", "getAnimationScaleFlowFor", "applicationContext", "contentChild", "getContentChild", "(Landroid/view/View;)Landroid/view/View;", "windowRecomposer", "Landroidx/compose/runtime/Recomposer;", "getWindowRecomposer$annotations", "(Landroid/view/View;)V", "getWindowRecomposer", "(Landroid/view/View;)Landroidx/compose/runtime/Recomposer;", "createLifecycleAwareWindowRecomposer", "onAttachStateProvider", "Landroidx/compose/ui/platform/OnAttachStateProvider;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "findLifecycleFromContext", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WindowRecomposer_androidKt {
    private static final Map<Context, StateFlow<Float>> animationScale = new LinkedHashMap();

    public static /* synthetic */ void getWindowRecomposer$annotations(View view) {
    }

    public static final CompositionContext getCompositionContext(View view) {
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }

    public static final void setCompositionContext(View view, CompositionContext compositionContext) {
        view.setTag(R.id.androidx_compose_ui_view_composition_context, compositionContext);
    }

    public static final CompositionContext findViewTreeCompositionContext(View view) {
        CompositionContext compositionContext = getCompositionContext(view);
        if (compositionContext != null) {
            return compositionContext;
        }
        Object parent = view.getParent();
        while (compositionContext == null && (parent instanceof View)) {
            View view2 = (View) parent;
            compositionContext = getCompositionContext(view2);
            parent = view2.getParent();
        }
        return compositionContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1] */
    public static final StateFlow<Float> getAnimationScaleFlowFor(Context context) {
        StateFlow<Float> stateFlow;
        Map<Context, StateFlow<Float>> map = animationScale;
        synchronized (map) {
            StateFlow<Float> stateFlow2 = map.get(context);
            if (stateFlow2 == null) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                final Channel Channel$default = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                final Handler createAsync = HandlerCompat.createAsync(Looper.getMainLooper());
                stateFlow2 = FlowKt.stateIn(FlowKt.flow(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(contentResolver, uriFor, new ContentObserver(createAsync) { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1
                    @Override // android.database.ContentObserver
                    public void onChange(boolean selfChange, Uri uri) {
                        Channel$default.trySend-JP2dKIU(Unit.INSTANCE);
                    }
                }, Channel$default, context, null)), CoroutineScopeKt.MainScope(), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, (Object) null), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                map.put(context, stateFlow2);
            }
            stateFlow = stateFlow2;
        }
        return stateFlow;
    }

    public static final View getContentChild(View view) {
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view;
            }
            parent = view2.getParent();
            view = view2;
        }
        return view;
    }

    public static final Recomposer getWindowRecomposer(View view) {
        if (!view.isAttachedToWindow()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot locate windowRecomposer; View " + view + " is not attached to a window");
        }
        View contentChild = getContentChild(view);
        Recomposer compositionContext = getCompositionContext(contentChild);
        if (compositionContext == null) {
            return WindowRecomposerPolicy.createAndInstallWindowRecomposer$ui_release$default(WindowRecomposerPolicy.INSTANCE, contentChild, null, 2, null);
        }
        if (compositionContext instanceof Recomposer) {
            return compositionContext;
        }
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
    }

    public static /* synthetic */ Recomposer createLifecycleAwareWindowRecomposer$default(View view, OnAttachStateProvider onAttachStateProvider, CoroutineContext coroutineContext, Lifecycle lifecycle, int i, Object obj) {
        if ((i & 1) != 0) {
            onAttachStateProvider = null;
        }
        if ((i & 2) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            lifecycle = null;
        }
        return createLifecycleAwareWindowRecomposer(view, onAttachStateProvider, coroutineContext, lifecycle);
    }

    public static final Recomposer createLifecycleAwareWindowRecomposer(final View view, final OnAttachStateProvider onAttachStateProvider, CoroutineContext coroutineContext, Lifecycle lifecycle) {
        final PausableMonotonicFrameClock pausableMonotonicFrameClock;
        if (coroutineContext.get(ContinuationInterceptor.Key) == null || coroutineContext.get(MonotonicFrameClock.Key) == null) {
            coroutineContext = AndroidUiDispatcher.INSTANCE.getCurrentThread().plus(coroutineContext);
        }
        MonotonicFrameClock monotonicFrameClock = coroutineContext.get(MonotonicFrameClock.Key);
        if (monotonicFrameClock != null) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = new PausableMonotonicFrameClock(monotonicFrameClock);
            pausableMonotonicFrameClock2.pause();
            pausableMonotonicFrameClock = pausableMonotonicFrameClock2;
        } else {
            pausableMonotonicFrameClock = null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        MotionDurationScaleImpl motionDurationScaleImpl = (MotionDurationScale) coroutineContext.get(MotionDurationScale.Key);
        if (motionDurationScaleImpl == null) {
            MotionDurationScaleImpl motionDurationScaleImpl2 = new MotionDurationScaleImpl();
            objectRef.element = motionDurationScaleImpl2;
            motionDurationScaleImpl = motionDurationScaleImpl2;
        }
        CoroutineContext plus = coroutineContext.plus(pausableMonotonicFrameClock != null ? (CoroutineContext) pausableMonotonicFrameClock : EmptyCoroutineContext.INSTANCE).plus(motionDurationScaleImpl);
        final Recomposer recomposer = new Recomposer(plus);
        recomposer.pauseCompositionFrameClock();
        final CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(plus);
        if (lifecycle == null) {
            LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
            lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
            if (lifecycle == null) {
                lifecycle = findLifecycleFromContext(view);
            }
        }
        if (lifecycle != null) {
            if (onAttachStateProvider != null) {
                onAttachStateProvider.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View v) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View v) {
                        OnAttachStateProvider.this.removeOnAttachStateChangeListener(this);
                        recomposer.cancel();
                    }
                });
            } else {
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View v) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View v) {
                        view.removeOnAttachStateChangeListener(this);
                        recomposer.cancel();
                    }
                });
            }
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$3

                /* compiled from: WindowRecomposer.android.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                /* renamed from: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$3$WhenMappings */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[Lifecycle.Event.values().length];
                        try {
                            iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                    switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                        case 1:
                            BuildersKt.launch$default(CoroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C0050xd92d6629(objectRef, recomposer, source, this, view, null), 1, (Object) null);
                            return;
                        case 2:
                            PausableMonotonicFrameClock pausableMonotonicFrameClock3 = pausableMonotonicFrameClock;
                            if (pausableMonotonicFrameClock3 != null) {
                                pausableMonotonicFrameClock3.resume();
                            }
                            recomposer.resumeCompositionFrameClock();
                            return;
                        case 3:
                            recomposer.pauseCompositionFrameClock();
                            return;
                        case 4:
                            recomposer.cancel();
                            return;
                        case 5:
                        case 6:
                        case 7:
                            return;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
            });
            return recomposer;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("ViewTreeLifecycleOwner not found from " + view);
        throw new KotlinNothingValueException();
    }

    private static final Lifecycle findLifecycleFromContext(View view) {
        Object context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof LifecycleOwner) {
                return ((LifecycleOwner) context).getLifecycle();
            }
            Object baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                break;
            }
            context = baseContext;
        }
        if (context instanceof LifecycleOwner) {
            return ((LifecycleOwner) context).getLifecycle();
        }
        return null;
    }
}
