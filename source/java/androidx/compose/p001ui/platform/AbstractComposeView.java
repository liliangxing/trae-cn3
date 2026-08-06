package androidx.compose.p001ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.p001ui.node.Owner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ComposeView.android.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\fJ\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\r\u0010.\u001a\u00020\u001cH'¢\u0006\u0002\u0010/J\u0006\u00100\u001a\u00020\u001cJ\b\u00102\u001a\u00020\u001cH\u0002J\f\u00105\u001a\u00020\f*\u00020\fH\u0002J\b\u00106\u001a\u00020\fH\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\u0006\u0010:\u001a\u00020\u001cJ\b\u0010=\u001a\u00020\u001cH\u0014J\u0018\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0004J\u001d\u0010A\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0010¢\u0006\u0002\bBJ0\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0004J5\u0010I\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0010¢\u0006\u0002\bJJ\u0010\u0010K\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020\u0007H\u0016J\b\u0010N\u001a\u00020&H\u0016J\u0010\u0010O\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020&H\u0016J\u0012\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u001a\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u0007H\u0016J\"\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0016J\u001c\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J$\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J$\u0010X\u001a\u00020&2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J,\u0010X\u001a\u00020&2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020&H\u0014J\b\u0010Z\u001a\u00020&H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001fX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b \u0010!R\u0014\u0010%\u001a\u00020&8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R,\u0010)\u001a\u00020&2\u0006\u0010\r\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010!\u001a\u0004\b+\u0010(\"\u0004\b,\u0010-R\u000e\u00101\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00103\u001a\u00020&*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020&X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0011\u0010;\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b<\u0010(R\u000e\u0010M\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", StrategyConstants.VALUE, "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "composition", "Landroidx/compose/runtime/Composition;", "getComposition", "()Landroidx/compose/runtime/Composition;", "setComposition", "(Landroidx/compose/runtime/Composition;)V", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "setParentCompositionContext", "", "parent", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "getDisposeViewCompositionStrategy$annotations", "()V", "setViewCompositionStrategy", StrategyConstants.STRATEGY, "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldCreateCompositionOnAttachedToWindow", "", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createComposition", "creatingComposition", "checkAddView", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "cacheIfAlive", "resolveParentCompositionContext", "enablePausableComposition", "getEnablePausableComposition", "ensureCompositionCreated", "disposeComposition", "hasComposition", "getHasComposition", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure", "internalOnMeasure$ui_release", "onLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout", "internalOnLayout$ui_release", "onRtlPropertiesChanged", "layoutDirection", "isTransitionGroupSet", "isTransitionGroup", "setTransitionGroup", "addView", "child", "Landroid/view/View;", "index", "width", "height", "params", "Landroid/view/ViewGroup$LayoutParams;", "addViewInLayout", "preventRequestLayout", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    private Composition composition;
    private boolean creatingComposition;
    private Function0<Unit> disposeViewCompositionStrategy;
    private final boolean enablePausableComposition;
    private boolean isTransitionGroupSet;
    private CompositionContext parentContext;
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    public AbstractComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public abstract void Content(Composer composer, int i);

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.INSTANCE.getDefault().installFor(this);
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Composition getComposition() {
        return this.composition;
    }

    protected final void setComposition(Composition composition) {
        this.composition = composition;
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            Composition composition = this.composition;
            if (composition != null) {
                composition.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    public final void setParentCompositionContext(CompositionContext parent) {
        setParentContext(parent);
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy strategy) {
        Function0<Unit> function0 = this.disposeViewCompositionStrategy;
        if (function0 != null) {
            function0.invoke();
        }
        this.disposeViewCompositionStrategy = strategy.installFor(this);
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public final void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((Owner) childAt).setShowLayoutBounds(z);
        }
    }

    public final void createComposition() {
        if (!(this.parentContext != null || isAttachedToWindow())) {
            throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
        }
        ensureCompositionCreated();
    }

    private final void checkAddView() {
        if (!this.creatingComposition) {
            throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
        }
    }

    private final boolean isAlive(CompositionContext compositionContext) {
        return !(compositionContext instanceof Recomposer) || ((Recomposer.State) ((Recomposer) compositionContext).getCurrentState().getValue()).compareTo(Recomposer.State.ShuttingDown) > 0;
    }

    private final CompositionContext cacheIfAlive(CompositionContext compositionContext) {
        CompositionContext compositionContext2 = isAlive(compositionContext) ? compositionContext : null;
        if (compositionContext2 != null) {
            this.cachedViewTreeCompositionContext = new WeakReference<>(compositionContext2);
        }
        return compositionContext;
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext compositionContext;
        CompositionContext compositionContext2 = this.parentContext;
        if (compositionContext2 != null) {
            return compositionContext2;
        }
        AbstractComposeView abstractComposeView = this;
        CompositionContext findViewTreeCompositionContext = WindowRecomposer_androidKt.findViewTreeCompositionContext(abstractComposeView);
        CompositionContext compositionContext3 = null;
        CompositionContext cacheIfAlive = findViewTreeCompositionContext != null ? cacheIfAlive(findViewTreeCompositionContext) : null;
        if (cacheIfAlive != null) {
            return cacheIfAlive;
        }
        WeakReference<CompositionContext> weakReference = this.cachedViewTreeCompositionContext;
        if (weakReference != null && (compositionContext = weakReference.get()) != null && isAlive(compositionContext)) {
            compositionContext3 = compositionContext;
        }
        return compositionContext3 == null ? cacheIfAlive((CompositionContext) WindowRecomposer_androidKt.getWindowRecomposer(abstractComposeView)) : compositionContext3;
    }

    protected boolean getEnablePausableComposition() {
        return this.enablePausableComposition;
    }

    private final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                this.composition = Wrapper_androidKt.setContent(this, resolveParentCompositionContext(), getEnablePausableComposition(), ComposableLambdaKt.composableLambdaInstance(-1330213153, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C252@11289L9:ComposeView.android.kt#itgzvw");
                        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1330213153, i, -1, "androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous> (ComposeView.android.kt:252)");
                        }
                        AbstractComposeView.this.Content(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            } finally {
                this.creatingComposition = false;
            }
        }
    }

    public final void disposeComposition() {
        Composition composition = this.composition;
        if (composition != null) {
            composition.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            ensureCompositionCreated();
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ensureCompositionCreated();
        internalOnMeasure$ui_release(widthMeasureSpec, heightMeasureSpec);
    }

    public void internalOnMeasure$ui_release(int widthMeasureSpec, int heightMeasureSpec) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(widthMeasureSpec)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(heightMeasureSpec)));
        setMeasuredDimension(childAt.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), childAt.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        internalOnLayout$ui_release(changed, left, top, right, bottom);
    }

    public void internalOnLayout$ui_release(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (right - left) - getPaddingRight(), (bottom - top) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(layoutDirection);
        }
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean isTransitionGroup) {
        super.setTransitionGroup(isTransitionGroup);
        this.isTransitionGroupSet = true;
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        checkAddView();
        super.addView(child);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        checkAddView();
        super.addView(child, index);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        checkAddView();
        super.addView(child, width, height);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        checkAddView();
        return super.addViewInLayout(child, index, params);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        checkAddView();
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }
}
