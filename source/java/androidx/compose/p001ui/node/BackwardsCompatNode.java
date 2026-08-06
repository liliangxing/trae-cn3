package androidx.compose.p001ui.node;

import androidx.compose.p001ui.node.Owner;
import androidx.compose.p001ui.semantics.SemanticsConfiguration;
import androidx.compose.p001ui.semantics.SemanticsModifier;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrder;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackwardsCompatNode.kt */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000fB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0002J\r\u0010.\u001a\u00020\u0019H\u0000¢\u0006\u0002\b/J\u0006\u0010B\u001a\u00020\u0019J\u0014\u0010C\u001a\u00020\u00192\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030DH\u0002J#\u0010G\u001a\u00020H*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0016¢\u0006\u0004\bN\u0010OJ\u001c\u0010P\u001a\u00020Q*\u00020R2\u0006\u0010J\u001a\u00020S2\u0006\u0010T\u001a\u00020QH\u0016J\u001c\u0010U\u001a\u00020Q*\u00020R2\u0006\u0010J\u001a\u00020S2\u0006\u0010V\u001a\u00020QH\u0016J\u001c\u0010W\u001a\u00020Q*\u00020R2\u0006\u0010J\u001a\u00020S2\u0006\u0010T\u001a\u00020QH\u0016J\u001c\u0010X\u001a\u00020Q*\u00020R2\u0006\u0010J\u001a\u00020S2\u0006\u0010V\u001a\u00020QH\u0016J\f\u0010Y\u001a\u00020\u0019*\u00020ZH\u0016J\f\u0010[\u001a\u00020\u0019*\u00020\\H\u0016J'\u0010]\u001a\u00020\u00192\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0016¢\u0006\u0004\bd\u0010eJ\b\u0010f\u001a\u00020\u0019H\u0016J\b\u0010g\u001a\u00020\u0019H\u0016J\b\u0010h\u001a\u00020\u001eH\u0016J\b\u0010i\u001a\u00020\u001eH\u0016J\u0018\u0010j\u001a\u0004\u0018\u00010k*\u00020 2\b\u0010l\u001a\u0004\u0018\u00010kH\u0016J\u0010\u0010m\u001a\u00020\u00192\u0006\u0010n\u001a\u00020oH\u0016J\u0017\u0010p\u001a\u00020\u00192\u0006\u0010'\u001a\u00020cH\u0016¢\u0006\u0004\bq\u0010rJ\u0010\u0010t\u001a\u00020\u00192\u0006\u0010n\u001a\u00020oH\u0016J\u0010\u0010u\u001a\u00020\u00192\u0006\u0010v\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020\u00192\u0006\u0010y\u001a\u00020zH\u0016J\b\u0010{\u001a\u00020|H\u0016R$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R2\u00102\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030403j\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304`5X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R$\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?*\b\u0012\u0004\u0012\u0002H?048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0010\u0010s\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "<init>", "(Landroidx/compose/ui/Modifier$Element;)V", StrategyConstants.VALUE, "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "onAttach", "", "onDetach", "unInitializeModifier", "initializeModifier", "duringAttach", "", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "invalidateCache", "onMeasureResultChanged", "updateDrawCache", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui_release", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", ExifInterface.GPS_DIRECTION_TRUE, "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "isValidOwnerScope", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onDensityChange", "onCancelPointerInput", "sharePointerInputWithSiblings", "interceptOutOfBoundsChildEvents", "modifyParentData", "", "parentData", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "lastOnPlacedCoordinates", "onPlaced", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalModifierNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, OwnerScope, BuildDrawCacheParams {
    public static final int $stable = 8;
    private BackwardsCompatLocalMap _providedValues;
    private Modifier.Element element;
    private boolean invalidateCache;
    private LayoutCoordinates lastOnPlacedCoordinates;
    private HashSet<ModifierLocal<?>> readValues;

    public BackwardsCompatNode(Modifier.Element element) {
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element));
        this.element = element;
        this.invalidateCache = true;
        this.readValues = new HashSet<>();
    }

    public final Modifier.Element getElement() {
        return this.element;
    }

    public final void setElement(Modifier.Element element) {
        if (isAttached()) {
            unInitializeModifier();
        }
        this.element = element;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element));
        if (isAttached()) {
            initializeModifier(false);
        }
    }

    public void onAttach() {
        initializeModifier(true);
    }

    public void onDetach() {
        unInitializeModifier();
    }

    private final void unInitializeModifier() {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("unInitializeModifier called on unattached node");
        }
        ModifierLocalProvider modifierLocalProvider = this.element;
        BackwardsCompatNode backwardsCompatNode = this;
        if ((NodeKind.m1562constructorimpl(32) & backwardsCompatNode.getKindSet$ui_release()) != 0) {
            if (modifierLocalProvider instanceof ModifierLocalProvider) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, modifierLocalProvider.getKey());
            }
            if (modifierLocalProvider instanceof ModifierLocalConsumer) {
                ((ModifierLocalConsumer) modifierLocalProvider).onModifierLocalsUpdated(BackwardsCompatNodeKt.access$getDetachedModifierLocalReadScope$p());
            }
        }
        if ((backwardsCompatNode.getKindSet$ui_release() & NodeKind.m1562constructorimpl(8)) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
        if (modifierLocalProvider instanceof FocusRequesterModifier) {
            ((FocusRequesterModifier) modifierLocalProvider).getFocusRequester().getFocusRequesterNodes$ui_release().remove(this);
        }
    }

    private final void initializeModifier(boolean duringAttach) {
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("initializeModifier called on unattached node");
        }
        RemeasurementModifier remeasurementModifier = this.element;
        BackwardsCompatNode backwardsCompatNode = this;
        if ((NodeKind.m1562constructorimpl(32) & backwardsCompatNode.getKindSet$ui_release()) != 0) {
            if (remeasurementModifier instanceof ModifierLocalConsumer) {
                sideEffect(new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1322invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1322invoke() {
                        BackwardsCompatNode.this.updateModifierLocalConsumer();
                    }
                });
            }
            if (remeasurementModifier instanceof ModifierLocalProvider) {
                updateModifierLocalProvider((ModifierLocalProvider) remeasurementModifier);
            }
        }
        if ((NodeKind.m1562constructorimpl(4) & backwardsCompatNode.getKindSet$ui_release()) != 0) {
            if (remeasurementModifier instanceof DrawCacheModifier) {
                this.invalidateCache = true;
            }
            if (!duringAttach) {
                LayoutModifierNodeKt.invalidateLayer(this);
            }
        }
        if ((NodeKind.m1562constructorimpl(2) & backwardsCompatNode.getKindSet$ui_release()) != 0) {
            if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                NodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
                Intrinsics.checkNotNull(coordinator$ui_release);
                ((LayoutModifierNodeCoordinator) coordinator$ui_release).setLayoutModifierNode$ui_release(this);
                coordinator$ui_release.onLayoutModifierNodeChanged();
            }
            if (!duringAttach) {
                LayoutModifierNodeKt.invalidateLayer(this);
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
        }
        if (remeasurementModifier instanceof RemeasurementModifier) {
            remeasurementModifier.onRemeasurementAvailable(DelegatableNodeKt.requireLayoutNode(this));
        }
        if ((NodeKind.m1562constructorimpl(128) & backwardsCompatNode.getKindSet$ui_release()) != 0) {
            if ((remeasurementModifier instanceof OnRemeasuredModifier) && BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if (remeasurementModifier instanceof OnPlacedModifier) {
                this.lastOnPlacedCoordinates = null;
                if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                    DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new Owner.OnLayoutCompletedListener() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$3
                        @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
                        public void onLayoutComplete() {
                            LayoutCoordinates layoutCoordinates;
                            layoutCoordinates = BackwardsCompatNode.this.lastOnPlacedCoordinates;
                            if (layoutCoordinates == null) {
                                BackwardsCompatNode backwardsCompatNode2 = BackwardsCompatNode.this;
                                backwardsCompatNode2.onPlaced(DelegatableNodeKt.m1341requireCoordinator64DMado(backwardsCompatNode2, NodeKind.m1562constructorimpl(128)));
                            }
                        }
                    });
                }
            }
        }
        if (((NodeKind.m1562constructorimpl(256) & backwardsCompatNode.getKindSet$ui_release()) != 0) && (remeasurementModifier instanceof OnGloballyPositionedModifier) && BackwardsCompatNodeKt.access$isChainUpdate(this)) {
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
        }
        if (remeasurementModifier instanceof FocusRequesterModifier) {
            ((FocusRequesterModifier) remeasurementModifier).getFocusRequester().getFocusRequesterNodes$ui_release().add(this);
        }
        if (((NodeKind.m1562constructorimpl(16) & backwardsCompatNode.getKindSet$ui_release()) != 0) && (remeasurementModifier instanceof PointerInputModifier)) {
            ((PointerInputModifier) remeasurementModifier).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator$ui_release());
        }
        if ((NodeKind.m1562constructorimpl(8) & backwardsCompatNode.getKindSet$ui_release()) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
    }

    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public long m1318getSizeNHjbRc() {
        return IntSizeKt.m2863toSizeozmzZPI(DelegatableNodeKt.m1341requireCoordinator64DMado(this, NodeKind.m1562constructorimpl(128)).m1533getSizeYbymL2g());
    }

    @Override // androidx.compose.p001ui.node.DrawModifierNode
    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final void updateDrawCache() {
        final Modifier.Element element = this.element;
        if (element instanceof DrawCacheModifier) {
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.access$getOnDrawCacheReadsChanged$p(), new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateDrawCache$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1323invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1323invoke() {
                    element.onBuildCache(this);
                }
            });
        }
        this.invalidateCache = false;
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    public final void setReadValues(HashSet<ModifierLocal<?>> hashSet) {
        this.readValues = hashSet;
    }

    public ModifierLocalMap getProvidedValues() {
        ModifierLocalMap modifierLocalMap = this._providedValues;
        return modifierLocalMap != null ? modifierLocalMap : ModifierLocalModifierNodeKt.modifierLocalMapOf();
    }

    public <T> T getCurrent(ModifierLocal<T> modifierLocal) {
        NodeChain nodes;
        this.readValues.add(modifierLocal);
        BackwardsCompatNode backwardsCompatNode = this;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(32);
        if (!backwardsCompatNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = backwardsCompatNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(backwardsCompatNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        Modifier.Node node = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof ModifierLocalModifierNode) {
                                ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) node;
                                if (modifierLocalModifierNode.getProvidedValues().contains$ui_release(modifierLocal)) {
                                    return (T) modifierLocalModifierNode.getProvidedValues().get$ui_release(modifierLocal);
                                }
                            } else if (((node.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return (T) modifierLocal.getDefaultFactory$ui_release().invoke();
    }

    public final void updateModifierLocalConsumer() {
        if (isAttached()) {
            this.readValues.clear();
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.access$getUpdateModifierLocalConsumer$p(), new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateModifierLocalConsumer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1324invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1324invoke() {
                    ModifierLocalConsumer element = BackwardsCompatNode.this.getElement();
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                    element.onModifierLocalsUpdated(BackwardsCompatNode.this);
                }
            });
        }
    }

    private final void updateModifierLocalProvider(ModifierLocalProvider<?> element) {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        if (backwardsCompatLocalMap != null && backwardsCompatLocalMap.contains$ui_release(element.getKey())) {
            backwardsCompatLocalMap.setElement(element);
            DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, element.getKey());
        } else {
            this._providedValues = new BackwardsCompatLocalMap(element);
            if (BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().insertedProvider(this, element.getKey());
            }
        }
    }

    @Override // androidx.compose.p001ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo1319measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.measure-3p2s80s(measureScope, measurable, j);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p001ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        DrawModifier drawModifier = this.element;
        Intrinsics.checkNotNull(drawModifier, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier drawModifier2 = drawModifier;
        if (this.invalidateCache && (drawModifier instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        drawModifier2.draw(contentDrawScope);
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        SemanticsConfiguration semanticsConfiguration = ((SemanticsModifier) element).getSemanticsConfiguration();
        Intrinsics.checkNotNull(semanticsPropertyReceiver, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        ((SemanticsConfiguration) semanticsPropertyReceiver).collapsePeer$ui_release(semanticsConfiguration);
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo1320onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        PointerInputModifier pointerInputModifier = this.element;
        Intrinsics.checkNotNull(pointerInputModifier, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        pointerInputModifier.getPointerInputFilter().onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.p001ui.node.DelegatableNode, androidx.compose.p001ui.node.PointerInputModifierNode
    public void onDensityChange() {
        if (this.element instanceof PointerInputModifier) {
            onCancelPointerInput();
        }
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        PointerInputModifier pointerInputModifier = this.element;
        Intrinsics.checkNotNull(pointerInputModifier, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        pointerInputModifier.getPointerInputFilter().onCancel();
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public boolean sharePointerInputWithSiblings() {
        PointerInputModifier pointerInputModifier = this.element;
        Intrinsics.checkNotNull(pointerInputModifier, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return pointerInputModifier.getPointerInputFilter().getShareWithSiblings();
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public boolean interceptOutOfBoundsChildEvents() {
        PointerInputModifier pointerInputModifier = this.element;
        Intrinsics.checkNotNull(pointerInputModifier, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return pointerInputModifier.getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    @Override // androidx.compose.p001ui.node.ParentDataModifierNode
    public Object modifyParentData(Density density, Object obj) {
        ParentDataModifier parentDataModifier = this.element;
        Intrinsics.checkNotNull(parentDataModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return parentDataModifier.modifyParentData(density, obj);
    }

    @Override // androidx.compose.p001ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        OnGloballyPositionedModifier onGloballyPositionedModifier = this.element;
        Intrinsics.checkNotNull(onGloballyPositionedModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        onGloballyPositionedModifier.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.p001ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo1321onRemeasuredozmzZPI(long size) {
        OnRemeasuredModifier onRemeasuredModifier = this.element;
        if (onRemeasuredModifier instanceof OnRemeasuredModifier) {
            onRemeasuredModifier.onRemeasured-ozmzZPI(size);
        }
    }

    @Override // androidx.compose.p001ui.node.LayoutAwareModifierNode
    public void onPlaced(LayoutCoordinates coordinates) {
        this.lastOnPlacedCoordinates = coordinates;
        OnPlacedModifier onPlacedModifier = this.element;
        if (onPlacedModifier instanceof OnPlacedModifier) {
            onPlacedModifier.onPlaced(coordinates);
        }
    }

    public void onFocusEvent(FocusState focusState) {
        FocusEventModifier focusEventModifier = this.element;
        if (!(focusEventModifier instanceof FocusEventModifier)) {
            InlineClassHelperKt.throwIllegalStateException("onFocusEvent called on wrong node");
        }
        focusEventModifier.onFocusEvent(focusState);
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        FocusOrderModifier focusOrderModifier = this.element;
        if (!(focusOrderModifier instanceof FocusOrderModifier)) {
            InlineClassHelperKt.throwIllegalStateException("applyFocusProperties called on wrong node");
        }
        focusOrderModifier.populateFocusOrder(new FocusOrder(focusProperties));
    }

    public String toString() {
        return this.element.toString();
    }
}
