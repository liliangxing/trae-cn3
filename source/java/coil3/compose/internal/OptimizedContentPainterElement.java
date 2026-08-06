package coil3.compose.internal;

import androidx.compose.p001ui.node.DrawModifierNodeKt;
import androidx.compose.p001ui.node.LayoutModifierNodeKt;
import androidx.compose.p001ui.node.ModifierNodeElement;
import androidx.compose.p001ui.node.SemanticsModifierNodeKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.layout.ContentScale;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.AsyncImagePreviewHandler;
import coil3.compose.EqualityDelegate;
import coil3.request.ImageRequest;
import coil3.size.SizeResolver;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0002H\u0016J\f\u0010$\u001a\u00020\r*\u00020%H\u0016J\t\u0010&\u001a\u00020\u0004HÂ\u0003J\t\u0010'\u001a\u00020\u0006HÂ\u0003J\t\u0010(\u001a\u00020\bHÂ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nHÂ\u0003J\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÂ\u0003J\u0010\u0010+\u001a\u00020\u000fHÂ\u0003¢\u0006\u0004\b,\u0010-J\t\u0010.\u001a\u00020\u0011HÂ\u0003J\t\u0010/\u001a\u00020\u0013HÂ\u0003J\t\u00100\u001a\u00020\u0015HÂ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0017HÂ\u0003J\t\u00102\u001a\u00020\u0019HÂ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u001bHÂ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u001dHÂ\u0003J²\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÇ\u0001¢\u0006\u0004\b6\u00107J\u0013\u00108\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010:H×\u0003J\t\u0010;\u001a\u00020<H×\u0001J\t\u0010=\u001a\u00020\u001dH×\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcoil3/compose/internal/OptimizedContentPainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcoil3/compose/internal/OptimizedContentPainterNode;", "request", "Lcoil3/request/ImageRequest;", "imageLoader", "Lcoil3/ImageLoader;", "modelEqualityDelegate", "Lcoil3/compose/EqualityDelegate;", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "previewHandler", "Lcoil3/compose/AsyncImagePreviewHandler;", "contentDescription", "", "<init>", "(Lcoil3/request/ImageRequest;Lcoil3/ImageLoader;Lcoil3/compose/EqualityDelegate;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLcoil3/compose/AsyncImagePreviewHandler;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", SettingV2Monitor.REPORT_TYPE_UPDATE, "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component6-f-v9h1I", "()I", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "copy-3ECvelE", "(Lcoil3/request/ImageRequest;Lcoil3/ImageLoader;Lcoil3/compose/EqualityDelegate;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLcoil3/compose/AsyncImagePreviewHandler;Ljava/lang/String;)Lcoil3/compose/internal/OptimizedContentPainterElement;", "equals", "other", "", "hashCode", "", "toString", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final /* data */ class OptimizedContentPainterElement extends ModifierNodeElement<OptimizedContentPainterNode> {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final float alpha;
    private final boolean clipToBounds;
    private final ColorFilter colorFilter;
    private final String contentDescription;
    private final ContentScale contentScale;
    private final int filterQuality;
    private final ImageLoader imageLoader;
    private final EqualityDelegate modelEqualityDelegate;
    private final Function1<AsyncImagePainter.State, Unit> onState;
    private final AsyncImagePreviewHandler previewHandler;
    private final ImageRequest request;
    private final Function1<AsyncImagePainter.State, AsyncImagePainter.State> transform;

    public /* synthetic */ OptimizedContentPainterElement(ImageRequest imageRequest, ImageLoader imageLoader, EqualityDelegate equalityDelegate, Function1 function1, Function1 function12, int i, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, AsyncImagePreviewHandler asyncImagePreviewHandler, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageRequest, imageLoader, equalityDelegate, function1, function12, i, alignment, contentScale, f, colorFilter, z, asyncImagePreviewHandler, str);
    }

    /* renamed from: component1, reason: from getter */
    private final ImageRequest getRequest() {
        return this.request;
    }

    /* renamed from: component10, reason: from getter */
    private final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* renamed from: component11, reason: from getter */
    private final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    /* renamed from: component12, reason: from getter */
    private final AsyncImagePreviewHandler getPreviewHandler() {
        return this.previewHandler;
    }

    /* renamed from: component13, reason: from getter */
    private final String getContentDescription() {
        return this.contentDescription;
    }

    /* renamed from: component2, reason: from getter */
    private final ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    /* renamed from: component3, reason: from getter */
    private final EqualityDelegate getModelEqualityDelegate() {
        return this.modelEqualityDelegate;
    }

    private final Function1<AsyncImagePainter.State, AsyncImagePainter.State> component4() {
        return this.transform;
    }

    private final Function1<AsyncImagePainter.State, Unit> component5() {
        return this.onState;
    }

    /* renamed from: component6-f-v9h1I, reason: not valid java name and from getter */
    private final int getFilterQuality() {
        return this.filterQuality;
    }

    /* renamed from: component7, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: component8, reason: from getter */
    private final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* renamed from: component9, reason: from getter */
    private final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: copy-3ECvelE, reason: not valid java name */
    public final OptimizedContentPainterElement m3225copy3ECvelE(ImageRequest request, ImageLoader imageLoader, EqualityDelegate modelEqualityDelegate, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> transform, Function1<? super AsyncImagePainter.State, Unit> onState, int filterQuality, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, boolean clipToBounds, AsyncImagePreviewHandler previewHandler, String contentDescription) {
        return new OptimizedContentPainterElement(request, imageLoader, modelEqualityDelegate, transform, onState, filterQuality, alignment, contentScale, alpha, colorFilter, clipToBounds, previewHandler, contentDescription, null);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptimizedContentPainterElement)) {
            return false;
        }
        OptimizedContentPainterElement optimizedContentPainterElement = (OptimizedContentPainterElement) other;
        return Intrinsics.areEqual(this.request, optimizedContentPainterElement.request) && Intrinsics.areEqual(this.imageLoader, optimizedContentPainterElement.imageLoader) && Intrinsics.areEqual(this.modelEqualityDelegate, optimizedContentPainterElement.modelEqualityDelegate) && Intrinsics.areEqual(this.transform, optimizedContentPainterElement.transform) && Intrinsics.areEqual(this.onState, optimizedContentPainterElement.onState) && FilterQuality.equals-impl0(this.filterQuality, optimizedContentPainterElement.filterQuality) && Intrinsics.areEqual(this.alignment, optimizedContentPainterElement.alignment) && Intrinsics.areEqual(this.contentScale, optimizedContentPainterElement.contentScale) && Float.compare(this.alpha, optimizedContentPainterElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, optimizedContentPainterElement.colorFilter) && this.clipToBounds == optimizedContentPainterElement.clipToBounds && Intrinsics.areEqual(this.previewHandler, optimizedContentPainterElement.previewHandler) && Intrinsics.areEqual(this.contentDescription, optimizedContentPainterElement.contentDescription);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public int hashCode() {
        int hashCode = ((((((this.request.hashCode() * 31) + this.imageLoader.hashCode()) * 31) + this.modelEqualityDelegate.hashCode()) * 31) + this.transform.hashCode()) * 31;
        Function1<AsyncImagePainter.State, Unit> function1 = this.onState;
        int hashCode2 = (((((((((hashCode + (function1 == null ? 0 : function1.hashCode())) * 31) + FilterQuality.hashCode-impl(this.filterQuality)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        int hashCode3 = (((hashCode2 + (colorFilter == null ? 0 : colorFilter.hashCode())) * 31) + Boolean.hashCode(this.clipToBounds)) * 31;
        AsyncImagePreviewHandler asyncImagePreviewHandler = this.previewHandler;
        int hashCode4 = (hashCode3 + (asyncImagePreviewHandler == null ? 0 : asyncImagePreviewHandler.hashCode())) * 31;
        String str = this.contentDescription;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OptimizedContentPainterElement(request=");
        sb.append(this.request).append(", imageLoader=").append(this.imageLoader).append(", modelEqualityDelegate=").append(this.modelEqualityDelegate).append(", transform=").append(this.transform).append(", onState=").append(this.onState).append(", filterQuality=").append((Object) FilterQuality.toString-impl(this.filterQuality)).append(", alignment=").append(this.alignment).append(", contentScale=").append(this.contentScale).append(", alpha=").append(this.alpha).append(", colorFilter=").append(this.colorFilter).append(", clipToBounds=").append(this.clipToBounds).append(", previewHandler=");
        sb.append(this.previewHandler).append(", contentDescription=").append(this.contentDescription).append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private OptimizedContentPainterElement(ImageRequest imageRequest, ImageLoader imageLoader, EqualityDelegate equalityDelegate, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, int i, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, AsyncImagePreviewHandler asyncImagePreviewHandler, String str) {
        this.request = imageRequest;
        this.imageLoader = imageLoader;
        this.modelEqualityDelegate = equalityDelegate;
        this.transform = function1;
        this.onState = function12;
        this.filterQuality = i;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.clipToBounds = z;
        this.previewHandler = asyncImagePreviewHandler;
        this.contentDescription = str;
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    /* renamed from: create, reason: avoid collision after fix types in other method */
    public OptimizedContentPainterNode getNode() {
        AsyncImagePainter.Input input = new AsyncImagePainter.Input(this.imageLoader, this.request, this.modelEqualityDelegate);
        SizeResolver sizeResolver = this.request.getSizeResolver();
        ConstraintsSizeResolver constraintsSizeResolver = sizeResolver instanceof ConstraintsSizeResolver ? (ConstraintsSizeResolver) sizeResolver : null;
        AsyncImagePainter asyncImagePainter = new AsyncImagePainter(input);
        asyncImagePainter.setTransform$coil_compose_core_release(this.transform);
        asyncImagePainter.setOnState$coil_compose_core_release(this.onState);
        asyncImagePainter.setContentScale$coil_compose_core_release(this.contentScale);
        asyncImagePainter.m3187setFilterQualityvDHp3xo$coil_compose_core_release(this.filterQuality);
        asyncImagePainter.setPreviewHandler$coil_compose_core_release(this.previewHandler);
        asyncImagePainter.set_input$coil_compose_core_release(input);
        return new OptimizedContentPainterNode(asyncImagePainter, this.alignment, this.contentScale, this.alpha, this.colorFilter, this.clipToBounds, this.contentDescription, constraintsSizeResolver);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void update(OptimizedContentPainterNode node) {
        long m3186getIntrinsicSizeNHjbRc = node.getPainter().m3186getIntrinsicSizeNHjbRc();
        ConstraintsSizeResolver constraintSizeResolver = node.getConstraintSizeResolver();
        AsyncImagePainter.Input input = new AsyncImagePainter.Input(this.imageLoader, this.request, this.modelEqualityDelegate);
        AsyncImagePainter painter = node.getPainter();
        painter.setTransform$coil_compose_core_release(this.transform);
        painter.setOnState$coil_compose_core_release(this.onState);
        painter.setContentScale$coil_compose_core_release(this.contentScale);
        painter.m3187setFilterQualityvDHp3xo$coil_compose_core_release(this.filterQuality);
        painter.setPreviewHandler$coil_compose_core_release(this.previewHandler);
        painter.set_input$coil_compose_core_release(input);
        boolean z = !Size.equals-impl0(m3186getIntrinsicSizeNHjbRc, painter.m3186getIntrinsicSizeNHjbRc());
        node.setAlignment(this.alignment);
        SizeResolver sizeResolver = this.request.getSizeResolver();
        node.setConstraintSizeResolver(sizeResolver instanceof ConstraintsSizeResolver ? (ConstraintsSizeResolver) sizeResolver : null);
        node.setContentScale(this.contentScale);
        node.setAlpha(this.alpha);
        node.setColorFilter(this.colorFilter);
        node.setClipToBounds(this.clipToBounds);
        if (!Intrinsics.areEqual(node.getContentDescription(), this.contentDescription)) {
            node.setContentDescription(this.contentDescription);
            SemanticsModifierNodeKt.invalidateSemantics(node);
        }
        boolean z2 = !Intrinsics.areEqual(constraintSizeResolver, node.getConstraintSizeResolver());
        if (z || z2) {
            LayoutModifierNodeKt.invalidateMeasurement(node);
        }
        DrawModifierNodeKt.invalidateDraw(node);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName(StrategyConstants.CONTENT);
        inspectorInfo.getProperties().set("request", this.request);
        inspectorInfo.getProperties().set("imageLoader", this.imageLoader);
        inspectorInfo.getProperties().set("modelEqualityDelegate", this.modelEqualityDelegate);
        inspectorInfo.getProperties().set("transform", this.transform);
        inspectorInfo.getProperties().set("onState", this.onState);
        inspectorInfo.getProperties().set("filterQuality", FilterQuality.box-impl(this.filterQuality));
        inspectorInfo.getProperties().set("alignment", this.alignment);
        inspectorInfo.getProperties().set("contentScale", this.contentScale);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
        inspectorInfo.getProperties().set("clipToBounds", Boolean.valueOf(this.clipToBounds));
        inspectorInfo.getProperties().set("previewHandler", this.previewHandler);
        inspectorInfo.getProperties().set("contentDescription", this.contentDescription);
    }
}
