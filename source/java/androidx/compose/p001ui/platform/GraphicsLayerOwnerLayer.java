package androidx.compose.p001ui.platform;

import android.os.Build;
import androidx.compose.p001ui.node.OwnedLayer;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DensityKt;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.ui.FrameRateCategory;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphicsLayerOwnerLayer.android.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00128\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010&\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0010H\u0002J\b\u0010=\u001a\u00020\u0010H\u0002J\u0017\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00102\u0006\u0010?\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\bH\u0010FJ\u001a\u0010J\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010K\u001a\u00020\u0010H\u0016J\b\u0010P\u001a\u00020\u0010H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\u001f\u0010R\u001a\u00020@2\u0006\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\u0019H\u0016¢\u0006\u0004\bU\u0010VJ\u0018\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020Y2\u0006\u0010T\u001a\u00020\u0019H\u0016JP\u0010Z\u001a\u00020\u001028\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0017\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u001bH\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u001bH\u0016¢\u0006\u0004\b`\u0010^J\u000f\u0010g\u001a\u00020\u001bH\u0002¢\u0006\u0004\bh\u0010iJ\u0011\u0010l\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\bm\u0010iJ\b\u0010n\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u001e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010!R\u000e\u0010I\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010L\u001a\u0013\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00100M¢\u0006\u0002\bOX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\u00020b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0014\u0010j\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010i¨\u0006o"}, d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "context", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", StrategyConstants.NAME, "canvas", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "isDestroyed", "", "matrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "inverseMatrixCache", StrategyConstants.VALUE, "isDirty", "setDirty", "(Z)V", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "mutatedFields", "", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "outline", "Landroidx/compose/ui/graphics/Outline;", "isMatrixDirty", "isInverseMatrixDirty", "isIdentity", "frameRate", "", "getFrameRate", "()F", "setFrameRate", "(F)V", "isFrameRateFromParent", "()Z", "setFrameRateFromParent", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "triggerRepaint", "updateOutline", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "drawnWithEnabledZ", "drawLayer", "updateDisplayList", "recordLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "invalidate", "destroy", "mapOffset", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "reuseLayer", "transform", "matrix", "transform-58bKbWc", "([F)V", "inverseTransform", "inverseTransform-58bKbWc", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "getMatrix", "getMatrix-sQKQjiQ", "()[F", "underlyingMatrix", "getUnderlyingMatrix-sQKQjiQ", "getInverseMatrix", "getInverseMatrix-3i98HWw", "updateMatrix", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    private final GraphicsContext context;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;
    private float frameRate;
    private GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private boolean isFrameRateFromParent;
    private boolean isInverseMatrixDirty;
    private boolean isMatrixDirty;
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private long size;
    private final float[] matrixCache = Matrix.constructor-impl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
    private boolean isIdentity = true;
    private final Function1<DrawScope, Unit> recordLambda = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(DrawScope drawScope) {
            Function2 function2;
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = GraphicsLayerOwnerLayer.this;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            function2 = graphicsLayerOwnerLayer.drawBlock;
            if (function2 != null) {
                function2.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
            }
        }
    };

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        long j = Integer.MAX_VALUE;
        this.size = IntSize.m2846constructorimpl((j & 4294967295L) | (j << 32));
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public float getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void setFrameRate(float f) {
        this.frameRate = f;
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* renamed from: isFrameRateFromParent, reason: from getter */
    public boolean getIsFrameRateFromParent() {
        return this.isFrameRateFromParent;
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void setFrameRateFromParent(boolean z) {
        this.isFrameRateFromParent = z;
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        int i;
        Function0<Unit> function0;
        int mutatedFields$ui_release = scope.getMutatedFields$ui_release() | this.mutatedFields;
        this.layoutDirection = scope.getLayoutDirection$ui_release();
        this.density = scope.getGraphicsDensity$ui_release();
        int i2 = mutatedFields$ui_release & 4096;
        if (i2 != 0) {
            this.transformOrigin = scope.getTransformOrigin-SzJe1aQ();
        }
        if ((mutatedFields$ui_release & 1) != 0) {
            this.graphicsLayer.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields$ui_release & 2) != 0) {
            this.graphicsLayer.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields$ui_release & 4) != 0) {
            this.graphicsLayer.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields$ui_release & 8) != 0) {
            this.graphicsLayer.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields$ui_release & 16) != 0) {
            this.graphicsLayer.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields$ui_release & 32) != 0) {
            this.graphicsLayer.setShadowElevation(scope.getShadowElevation());
            if (scope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
        if ((mutatedFields$ui_release & 64) != 0) {
            this.graphicsLayer.setAmbientShadowColor-8_81llA(scope.getAmbientShadowColor-0d7_KjU());
        }
        if ((mutatedFields$ui_release & 128) != 0) {
            this.graphicsLayer.setSpotShadowColor-8_81llA(scope.getSpotShadowColor-0d7_KjU());
        }
        if ((mutatedFields$ui_release & 1024) != 0) {
            this.graphicsLayer.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields$ui_release & 256) != 0) {
            this.graphicsLayer.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields$ui_release & 512) != 0) {
            this.graphicsLayer.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields$ui_release & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(scope.getCameraDistance());
        }
        if (i2 != 0) {
            if (TransformOrigin.equals-impl0(this.transformOrigin, TransformOrigin.Companion.getCenter-SzJe1aQ())) {
                this.graphicsLayer.setPivotOffset-k-4lQ0M(Offset.Companion.getUnspecified-F1C5BW0());
            } else {
                GraphicsLayer graphicsLayer = this.graphicsLayer;
                float f = TransformOrigin.getPivotFractionX-impl(this.transformOrigin) * ((int) (this.size >> 32));
                graphicsLayer.setPivotOffset-k-4lQ0M(Offset.constructor-impl((Float.floatToRawIntBits(TransformOrigin.getPivotFractionY-impl(this.transformOrigin) * ((int) (this.size & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
            }
        }
        if ((mutatedFields$ui_release & 16384) != 0) {
            this.graphicsLayer.setClip(scope.getClip());
        }
        if ((131072 & mutatedFields$ui_release) != 0) {
            this.graphicsLayer.setRenderEffect(scope.getRenderEffect());
        }
        if ((262144 & mutatedFields$ui_release) != 0) {
            this.graphicsLayer.setColorFilter(scope.getColorFilter());
        }
        if ((524288 & mutatedFields$ui_release) != 0) {
            this.graphicsLayer.setBlendMode-s9anfk8(scope.getBlendMode-0nO6VwU());
        }
        if ((32768 & mutatedFields$ui_release) != 0) {
            GraphicsLayer graphicsLayer2 = this.graphicsLayer;
            int i3 = scope.getCompositingStrategy--NrFUSI();
            if (CompositingStrategy.equals-impl0(i3, CompositingStrategy.Companion.getAuto--NrFUSI())) {
                i = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.getAuto-ke2Ky5w();
            } else if (CompositingStrategy.equals-impl0(i3, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
                i = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.getOffscreen-ke2Ky5w();
            } else {
                if (!CompositingStrategy.equals-impl0(i3, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                i = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w();
            }
            graphicsLayer2.setCompositingStrategy-Wpw9cng(i);
        }
        boolean z = true;
        if ((mutatedFields$ui_release & 7963) != 0) {
            this.isMatrixDirty = true;
            this.isInverseMatrixDirty = true;
        }
        if (Intrinsics.areEqual(this.outline, scope.getOutline$ui_release())) {
            z = false;
        } else {
            this.outline = scope.getOutline$ui_release();
            updateOutline();
        }
        this.mutatedFields = scope.getMutatedFields$ui_release();
        if (mutatedFields$ui_release != 0 || z) {
            triggerRepaint();
            if (this.ownerView.getIsArrEnabled()) {
                this.ownerView.voteFrameRate(getFrameRate());
            }
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    private final void updateOutline() {
        Function0<Unit> function0;
        Outline outline = this.outline;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
        if (!(outline instanceof Outline.Generic) || Build.VERSION.SDK_INT >= 33 || (function0 = this.invalidateParentLayer) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo1622movegyyYBs(long position) {
        if (this.ownerView.getIsArrEnabled()) {
            this.ownerView.voteFrameRate(FrameRateCategory.Companion.getHigh-NSsRyOo());
        }
        this.graphicsLayer.setTopLeft--gyyYBs(position);
        triggerRepaint();
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo1623resizeozmzZPI(long size) {
        if (IntSize.m2849equalsimpl0(size, this.size)) {
            return;
        }
        if (this.ownerView.getIsArrEnabled()) {
            this.ownerView.voteFrameRate(FrameRateCategory.Companion.getHigh-NSsRyOo());
        }
        this.size = size;
        invalidate();
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        updateDisplayList();
        this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
        DrawContext drawContext = this.scope.getDrawContext();
        drawContext.setCanvas(canvas);
        drawContext.setGraphicsLayer(parentLayer);
        GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.ownerView.getIsArrEnabled()) {
            if (!(getFrameRate() == 0.0f)) {
                this.ownerView.voteFrameRate(getFrameRate());
            }
        }
        if (this.isDirty) {
            if (!TransformOrigin.equals-impl0(this.transformOrigin, TransformOrigin.Companion.getCenter-SzJe1aQ()) && !IntSize.m2849equalsimpl0(this.graphicsLayer.getSize-YbymL2g(), this.size)) {
                GraphicsLayer graphicsLayer = this.graphicsLayer;
                float f = TransformOrigin.getPivotFractionX-impl(this.transformOrigin) * ((int) (this.size >> 32));
                graphicsLayer.setPivotOffset-k-4lQ0M(Offset.constructor-impl((Float.floatToRawIntBits(TransformOrigin.getPivotFractionY-impl(this.transformOrigin) * ((int) (this.size & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
            }
            this.graphicsLayer.record-mL-hObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void destroy() {
        setFrameRate(0.0f);
        setFrameRateFromParent(false);
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui_release(this);
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo1621mapOffset8S9VItk(long point, boolean inverse) {
        float[] m1769getMatrixsQKQjiQ;
        if (inverse) {
            m1769getMatrixsQKQjiQ = m1768getInverseMatrix3i98HWw();
            if (m1769getMatrixsQKQjiQ == null) {
                return Offset.Companion.getInfinite-F1C5BW0();
            }
        } else {
            m1769getMatrixsQKQjiQ = m1769getMatrixsQKQjiQ();
        }
        return this.isIdentity ? point : Matrix.map-MK-Hz9U(m1769getMatrixsQKQjiQ, point);
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        float[] m1768getInverseMatrix3i98HWw = inverse ? m1768getInverseMatrix3i98HWw() : m1769getMatrixsQKQjiQ();
        if (this.isIdentity) {
            return;
        }
        if (m1768getInverseMatrix3i98HWw == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.map-impl(m1768getInverseMatrix3i98HWw, rect);
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            if (!this.graphicsLayer.isReleased()) {
                InlineClassHelperKt.throwIllegalArgumentException("layer should have been released before reuse");
            }
            this.graphicsLayer = graphicsContext.createGraphicsLayer();
            this.isDestroyed = false;
            this.drawBlock = drawBlock;
            this.invalidateParentLayer = invalidateParentLayer;
            this.isMatrixDirty = false;
            this.isInverseMatrixDirty = false;
            this.isIdentity = true;
            Matrix.reset-impl(this.matrixCache);
            float[] fArr = this.inverseMatrixCache;
            if (fArr != null) {
                Matrix.reset-impl(fArr);
            }
            this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
            this.drawnWithEnabledZ = false;
            long j = Integer.MAX_VALUE;
            this.size = IntSize.m2846constructorimpl((j & 4294967295L) | (j << 32));
            this.outline = null;
            this.mutatedFields = 0;
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("currently reuse is only supported when we manage the layer lifecycle");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo1624transform58bKbWc(float[] matrix) {
        Matrix.timesAssign-58bKbWc(matrix, m1769getMatrixsQKQjiQ());
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo1619inverseTransform58bKbWc(float[] matrix) {
        float[] m1768getInverseMatrix3i98HWw = m1768getInverseMatrix3i98HWw();
        if (m1768getInverseMatrix3i98HWw != null) {
            Matrix.timesAssign-58bKbWc(matrix, m1768getInverseMatrix3i98HWw);
        }
    }

    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    /* renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m1769getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo1618getUnderlyingMatrixsQKQjiQ() {
        return m1769getMatrixsQKQjiQ();
    }

    /* renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    private final float[] m1768getInverseMatrix3i98HWw() {
        float[] fArr = this.inverseMatrixCache;
        if (fArr == null) {
            fArr = Matrix.constructor-impl$default((float[]) null, 1, (DefaultConstructorMarker) null);
            this.inverseMatrixCache = fArr;
        }
        if (!this.isInverseMatrixDirty) {
            if (Float.isNaN(fArr[0])) {
                return null;
            }
            return fArr;
        }
        this.isInverseMatrixDirty = false;
        float[] m1769getMatrixsQKQjiQ = m1769getMatrixsQKQjiQ();
        if (this.isIdentity) {
            return m1769getMatrixsQKQjiQ;
        }
        if (InvertMatrixKt.m1771invertToJiSxe2E(m1769getMatrixsQKQjiQ, fArr)) {
            return fArr;
        }
        fArr[0] = Float.NaN;
        return null;
    }

    private final void updateMatrix() {
        long j;
        if (this.isMatrixDirty) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            if ((graphicsLayer.getPivotOffset-F1C5BW0() & 9223372034707292159L) == 9205357640488583168L) {
                j = SizeKt.getCenter-uvyYCjk(IntSizeKt.m2863toSizeozmzZPI(this.size));
            } else {
                j = graphicsLayer.getPivotOffset-F1C5BW0();
            }
            Matrix.resetToPivotedTransform-impl(this.matrixCache, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), 1.0f, graphicsLayer.getRotationX(), graphicsLayer.getRotationY(), graphicsLayer.getRotationZ(), graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), 1.0f);
            this.isMatrixDirty = false;
            this.isIdentity = MatrixKt.isIdentity-58bKbWc(this.matrixCache);
        }
    }

    @Override // androidx.compose.p001ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo1620isInLayerk4lQ0M(long position) {
        float intBitsToFloat = Float.intBitsToFloat((int) (position >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (position & 4294967295L));
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), intBitsToFloat, intBitsToFloat2, null, null, 24, null);
        }
        return true;
    }
}
