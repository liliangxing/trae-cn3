package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.graphics.Outline;
import androidx.compose.p002ui.graphics.Path;
import androidx.compose.p002ui.graphics.Shadow;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.graphics.drawscope.DrawStyle;
import androidx.compose.p002ui.input.pointer.PointerIcon;
import androidx.compose.p002ui.input.pointer.PointerIconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TextLinkScope.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u001f\u001a\u00020 *\u00020 2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001e\u0010%\u001a\u00020 *\u00020 2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010'2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001c\u0010(\u001a\u0004\u0018\u00010)2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J0\u0010*\u001a\u0010\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0004\u0018\u0001`$2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$2\u0006\u0010\n\u001a\u00020\tH\u0002J\r\u0010+\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010,J\u001a\u0010-\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u0010!\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0002J\r\u00103\u001a\u00020\u0003H\u0000¢\u0006\u0002\b4J>\u00105\u001a\u00020\u00182\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000107\"\u0004\u0018\u00010\u00012\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u00109R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R/\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0005R%\u0010\u0014\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u00190\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006:"}, d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getInitialText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "text", "getText$foundation_release", "setText$foundation_release", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Lkotlin/ExtensionFunctionType;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "textRange", "Landroidx/compose/ui/Modifier;", "link", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/foundation/text/LinkRange;", "clipLink", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "calculateVisibleLinkRange", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "mergeOrUse", "Landroidx/compose/ui/text/SpanStyle;", "other", "handleLink", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "applyAnnotators", "applyAnnotators$foundation_release", "StyleAnnotation", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextLinkScope {
    public static final int $stable = 8;
    private final SnapshotStateList<Function1<TextAnnotatorScope, Unit>> annotators;
    private final AnnotatedString initialText;
    private AnnotatedString text;

    /* renamed from: textLayoutResult$delegate, reason: from kotlin metadata */
    private final MutableState textLayoutResult;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinksComposables$lambda$20(TextLinkScope textLinkScope, int i, Composer composer, int i2) {
        textLinkScope.LinksComposables(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyleAnnotation$lambda$25(TextLinkScope textLinkScope, Object[] objArr, Function1 function1, int i, Composer composer, int i2) {
        textLinkScope.StyleAnnotation(objArr, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public TextLinkScope(AnnotatedString annotatedString) {
        MutableState mutableStateOf$default;
        this.initialText = annotatedString;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.textLayoutResult = mutableStateOf$default;
        this.text = annotatedString.flatMapAnnotations(new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                List _init_$lambda$0;
                _init_$lambda$0 = TextLinkScope._init_$lambda$0((AnnotatedString.Range) obj);
                return _init_$lambda$0;
            }
        });
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    /* renamed from: getInitialText$foundation_release, reason: from getter */
    public final AnnotatedString getInitialText() {
        return this.initialText;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return (TextLayoutResult) this.textLayoutResult.getValue();
    }

    public final void setTextLayoutResult(TextLayoutResult textLayoutResult) {
        this.textLayoutResult.setValue(textLayoutResult);
    }

    /* renamed from: getText$foundation_release, reason: from getter */
    public final AnnotatedString getText() {
        return this.text;
    }

    public final void setText$foundation_release(AnnotatedString annotatedString) {
        this.text = annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _init_$lambda$0(AnnotatedString.Range range) {
        ArrayList arrayListOf;
        boolean isNullOrEmpty;
        SpanStyle spanStyle;
        if (range.getItem() instanceof LinkAnnotation) {
            Object item = range.getItem();
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
            isNullOrEmpty = TextLinkScopeKt.isNullOrEmpty(((LinkAnnotation) item).getStyles());
            if (!isNullOrEmpty) {
                AnnotatedString.Range[] rangeArr = new AnnotatedString.Range[2];
                rangeArr[0] = range;
                Object item2 = range.getItem();
                Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
                TextLinkStyles styles = ((LinkAnnotation) item2).getStyles();
                if (styles == null || (spanStyle = styles.getStyle()) == null) {
                    spanStyle = new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65535, (DefaultConstructorMarker) null);
                }
                rangeArr[1] = new AnnotatedString.Range(spanStyle, range.getStart(), range.getEnd());
                arrayListOf = CollectionsKt.arrayListOf(rangeArr);
                return arrayListOf;
            }
        }
        arrayListOf = CollectionsKt.arrayListOf(new AnnotatedString.Range[]{range});
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_shouldMeasureLinks_$lambda$1(TextLinkScope textLinkScope) {
        TextLayoutInput layoutInput;
        AnnotatedString annotatedString = textLinkScope.text;
        TextLayoutResult textLayoutResult = textLinkScope.getTextLayoutResult();
        return Intrinsics.areEqual(annotatedString, (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null) ? null : layoutInput.getText());
    }

    public final Function0<Boolean> getShouldMeasureLinks() {
        return new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda12
            public final Object invoke() {
                boolean _get_shouldMeasureLinks_$lambda$1;
                _get_shouldMeasureLinks_$lambda$1 = TextLinkScope._get_shouldMeasureLinks_$lambda$1(TextLinkScope.this);
                return Boolean.valueOf(_get_shouldMeasureLinks_$lambda$1);
            }
        };
    }

    private final Modifier textRange(Modifier modifier, final AnnotatedString.Range<LinkAnnotation> range) {
        return modifier.then(new TextRangeLayoutModifier(new TextRangeScopeMeasurePolicy() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda0
            @Override // androidx.compose.foundation.text.TextRangeScopeMeasurePolicy
            public final TextRangeLayoutMeasureResult measure(TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
                TextRangeLayoutMeasureResult textRange$lambda$5;
                textRange$lambda$5 = TextLinkScope.textRange$lambda$5(TextLinkScope.this, range, textRangeLayoutMeasureScope);
                return textRange$lambda$5;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRangeLayoutMeasureResult textRange$lambda$5(TextLinkScope textLinkScope, AnnotatedString.Range range, TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
        TextLayoutResult textLayoutResult = textLinkScope.getTextLayoutResult();
        if (textLayoutResult == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda1
                public final Object invoke() {
                    IntOffset textRange$lambda$5$lambda$2;
                    textRange$lambda$5$lambda$2 = TextLinkScope.textRange$lambda$5$lambda$2();
                    return textRange$lambda$5$lambda$2;
                }
            });
        }
        AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange = textLinkScope.calculateVisibleLinkRange(range, textLayoutResult);
        if (calculateVisibleLinkRange == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda2
                public final Object invoke() {
                    IntOffset textRange$lambda$5$lambda$3;
                    textRange$lambda$5$lambda$3 = TextLinkScope.textRange$lambda$5$lambda$3();
                    return textRange$lambda$5$lambda$3;
                }
            });
        }
        final IntRect roundToIntRect = IntRectKt.roundToIntRect(textLayoutResult.getPathForRange(calculateVisibleLinkRange.getStart(), calculateVisibleLinkRange.getEnd()).getBounds());
        return textRangeLayoutMeasureScope.layout(roundToIntRect.getWidth(), roundToIntRect.getHeight(), new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda3
            public final Object invoke() {
                IntOffset textRange$lambda$5$lambda$4;
                textRange$lambda$5$lambda$4 = TextLinkScope.textRange$lambda$5$lambda$4(roundToIntRect);
                return textRange$lambda$5$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset textRange$lambda$5$lambda$2() {
        return IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset textRange$lambda$5$lambda$3() {
        return IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset textRange$lambda$5$lambda$4(IntRect intRect) {
        return IntOffset.box-impl(intRect.getTopLeft-nOcc-ac());
    }

    private final Modifier clipLink(Modifier modifier, final AnnotatedString.Range<LinkAnnotation> range) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit clipLink$lambda$7;
                clipLink$lambda$7 = TextLinkScope.clipLink$lambda$7(TextLinkScope.this, range, (GraphicsLayerScope) obj);
                return clipLink$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clipLink$lambda$7(TextLinkScope textLinkScope, AnnotatedString.Range range, GraphicsLayerScope graphicsLayerScope) {
        Shape shapeForRange = textLinkScope.shapeForRange(range);
        if (shapeForRange != null) {
            graphicsLayerScope.setShape(shapeForRange);
            graphicsLayerScope.setClip(true);
        }
        return Unit.INSTANCE;
    }

    private final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> link) {
        final Path pathForRangeInRangeCoordinates = pathForRangeInRangeCoordinates(link);
        return pathForRangeInRangeCoordinates != null ? new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
            @Override // androidx.compose.p002ui.graphics.Shape
            /* renamed from: createOutline-Pq9zytI */
            public Outline mo469createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                return new Outline.Generic(Path.this);
            }
        } : null;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> link) {
        TextLayoutResult textLayoutResult;
        Path path = null;
        if (((Boolean) getShouldMeasureLinks().invoke()).booleanValue() && (textLayoutResult = getTextLayoutResult()) != null) {
            AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange = calculateVisibleLinkRange(link, textLayoutResult);
            if (calculateVisibleLinkRange == null) {
                return null;
            }
            path = textLayoutResult.getPathForRange(calculateVisibleLinkRange.getStart(), calculateVisibleLinkRange.getEnd());
            Rect boundingBox = textLayoutResult.getBoundingBox(calculateVisibleLinkRange.getStart());
            path.mo4730translatek4lQ0M(Offset.m4585constructorimpl(Offset.m4585constructorimpl((Float.floatToRawIntBits(textLayoutResult.getLineForOffset(calculateVisibleLinkRange.getStart()) == textLayoutResult.getLineForOffset(calculateVisibleLinkRange.getEnd() + (-1)) ? Math.min(textLayoutResult.getBoundingBox(calculateVisibleLinkRange.getEnd() - 1).getLeft(), boundingBox.getLeft()) : 0.0f) << 32) | (Float.floatToRawIntBits(boundingBox.getTop()) & 4294967295L)) ^ (-9223372034707292160L)));
        }
        return path;
    }

    private final AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange(AnnotatedString.Range<LinkAnnotation> link, TextLayoutResult textLayoutResult) {
        int lineEnd$default = TextLayoutResult.getLineEnd$default(textLayoutResult, textLayoutResult.getLineCount() - 1, false, 2, (Object) null);
        if (link.getStart() < lineEnd$default) {
            return AnnotatedString.Range.copy$default(link, (Object) null, 0, Math.min(link.getEnd(), lineEnd$default), (String) null, 11, (Object) null);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0115, code lost:
    
        if (r15 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void LinksComposables(Composer composer, final int i) {
        int i2;
        char c;
        int i3;
        Object obj;
        Modifier m445combinedClickableauXiCPI;
        boolean isNullOrEmpty;
        Composer startRestartGroup = composer.startRestartGroup(1154651354);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinksComposables)215@9182L7:TextLinkScope.kt#423gt5");
        char c2 = 2;
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i4 = 1;
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1154651354, i2, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:214)");
            }
            ProvidableCompositionLocal localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final UriHandler uriHandler = (UriHandler) consume;
            AnnotatedString annotatedString = this.text;
            List linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
            int size = linkAnnotations.size();
            int i5 = 0;
            while (i5 < size) {
                final AnnotatedString.Range<LinkAnnotation> range = (AnnotatedString.Range) linkAnnotations.get(i5);
                if (range.getStart() != range.getEnd()) {
                    startRestartGroup.startReplaceGroup(725478935);
                    ComposerKt.sourceInformation(startRestartGroup, "220@9372L39,224@9514L180,234@10047L38,222@9429L701");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 854684939, "CC(remember):TextLinkScope.kt#9igjgp");
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier clipLink = clipLink(Modifier.INSTANCE, range);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 854689624, "CC(remember):TextLinkScope.kt#9igjgp");
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj2) {
                                Unit LinksComposables$lambda$19$lambda$12$lambda$11;
                                LinksComposables$lambda$19$lambda$12$lambda$11 = TextLinkScope.LinksComposables$lambda$19$lambda$12$lambda$11((SemanticsPropertyReceiver) obj2);
                                return LinksComposables$lambda$19$lambda$12$lambda$11;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(HoverableKt.hoverable$default(textRange(SemanticsModifierKt.semantics$default(clipLink, false, (Function1) rememberedValue2, i4, (Object) null), range), mutableInteractionSource, false, 2, null), PointerIcon.INSTANCE.getHand(), false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 854706538, "CC(remember):TextLinkScope.kt#9igjgp");
                    boolean changedInstance = startRestartGroup.changedInstance(this) | startRestartGroup.changed(range) | startRestartGroup.changedInstance(uriHandler);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                        obj = rememberedValue3;
                    }
                    Object obj2 = new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit LinksComposables$lambda$19$lambda$14$lambda$13;
                            LinksComposables$lambda$19$lambda$14$lambda$13 = TextLinkScope.LinksComposables$lambda$19$lambda$14$lambda$13(TextLinkScope.this, range, uriHandler);
                            return LinksComposables$lambda$19$lambda$14$lambda$13;
                        }
                    };
                    startRestartGroup.updateRememberedValue(obj2);
                    obj = obj2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    m445combinedClickableauXiCPI = ClickableKt.m445combinedClickableauXiCPI(pointerHoverIcon$default, mutableInteractionSource, null, (r25 & 4) != 0, (r25 & 8) != 0 ? null : null, (r25 & 16) != 0 ? null : null, (r25 & 32) != 0 ? null : null, (r25 & 64) != 0 ? null : null, (r25 & Fields.SpotShadowColor) != 0 ? null : null, (r25 & Fields.RotationX) != 0, (Function0) obj);
                    BoxKt.Box(m445combinedClickableauXiCPI, startRestartGroup, 0);
                    isNullOrEmpty = TextLinkScopeKt.isNullOrEmpty(((LinkAnnotation) range.getItem()).getStyles());
                    if (!isNullOrEmpty) {
                        startRestartGroup.startReplaceGroup(726303039);
                        ComposerKt.sourceInformation(startRestartGroup, "243@10493L110,246@10645L51,246@10624L72,256@11137L1144,248@10718L1563");
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 854720882, "CC(remember):TextLinkScope.kt#9igjgp");
                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = new LinkStateInteractionSourceObserver(mutableInteractionSource);
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        final LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = (LinkStateInteractionSourceObserver) rememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 854725687, "CC(remember):TextLinkScope.kt#9igjgp");
                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = (Function2) new TextLinkScope$LinksComposables$1$3$1(linkStateInteractionSourceObserver, null);
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, startRestartGroup, 6);
                        Object[] objArr = new Object[7];
                        objArr[0] = Boolean.valueOf(linkStateInteractionSourceObserver.isHovered());
                        i3 = 1;
                        objArr[1] = Boolean.valueOf(linkStateInteractionSourceObserver.isFocused());
                        c = 2;
                        objArr[2] = Boolean.valueOf(linkStateInteractionSourceObserver.isPressed());
                        TextLinkStyles styles = ((LinkAnnotation) range.getItem()).getStyles();
                        objArr[3] = styles != null ? styles.getStyle() : null;
                        TextLinkStyles styles2 = ((LinkAnnotation) range.getItem()).getStyles();
                        objArr[4] = styles2 != null ? styles2.getFocusedStyle() : null;
                        TextLinkStyles styles3 = ((LinkAnnotation) range.getItem()).getStyles();
                        objArr[5] = styles3 != null ? styles3.getHoveredStyle() : null;
                        TextLinkStyles styles4 = ((LinkAnnotation) range.getItem()).getStyles();
                        objArr[6] = styles4 != null ? styles4.getPressedStyle() : null;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 854742524, "CC(remember):TextLinkScope.kt#9igjgp");
                        boolean changedInstance2 = startRestartGroup.changedInstance(this) | startRestartGroup.changed(range);
                        Object rememberedValue6 = startRestartGroup.rememberedValue();
                        if (changedInstance2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj3) {
                                    Unit LinksComposables$lambda$19$lambda$18$lambda$17;
                                    LinksComposables$lambda$19$lambda$18$lambda$17 = TextLinkScope.LinksComposables$lambda$19$lambda$18$lambda$17(TextLinkScope.this, range, linkStateInteractionSourceObserver, (TextAnnotatorScope) obj3);
                                    return LinksComposables$lambda$19$lambda$18$lambda$17;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        StyleAnnotation(objArr, (Function1) rememberedValue6, startRestartGroup, (i2 << 6) & 896);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        i3 = 1;
                        c = 2;
                        startRestartGroup.startReplaceGroup(728331710);
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                } else {
                    c = c2;
                    i3 = i4;
                    startRestartGroup.startReplaceGroup(728345598);
                    startRestartGroup.endReplaceGroup();
                }
                i5++;
                i4 = i3;
                c2 = c;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10
                public final Object invoke(Object obj3, Object obj4) {
                    Unit LinksComposables$lambda$20;
                    LinksComposables$lambda$20 = TextLinkScope.LinksComposables$lambda$20(TextLinkScope.this, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return LinksComposables$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinksComposables$lambda$19$lambda$12$lambda$11(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getLinkTestMarker(), Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinksComposables$lambda$19$lambda$14$lambda$13(TextLinkScope textLinkScope, AnnotatedString.Range range, UriHandler uriHandler) {
        textLinkScope.handleLink((LinkAnnotation) range.getItem(), uriHandler);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinksComposables$lambda$19$lambda$18$lambda$17(TextLinkScope textLinkScope, AnnotatedString.Range range, LinkStateInteractionSourceObserver linkStateInteractionSourceObserver, TextAnnotatorScope textAnnotatorScope) {
        TextLinkStyles styles;
        TextLinkStyles styles2;
        TextLinkStyles styles3;
        TextLinkStyles styles4 = ((LinkAnnotation) range.getItem()).getStyles();
        SpanStyle spanStyle = null;
        SpanStyle mergeOrUse = textLinkScope.mergeOrUse(textLinkScope.mergeOrUse(styles4 != null ? styles4.getStyle() : null, (!linkStateInteractionSourceObserver.isFocused() || (styles3 = ((LinkAnnotation) range.getItem()).getStyles()) == null) ? null : styles3.getFocusedStyle()), (!linkStateInteractionSourceObserver.isHovered() || (styles2 = ((LinkAnnotation) range.getItem()).getStyles()) == null) ? null : styles2.getHoveredStyle());
        if (linkStateInteractionSourceObserver.isPressed() && (styles = ((LinkAnnotation) range.getItem()).getStyles()) != null) {
            spanStyle = styles.getPressedStyle();
        }
        textAnnotatorScope.replaceStyle(range, textLinkScope.mergeOrUse(mergeOrUse, spanStyle));
        return Unit.INSTANCE;
    }

    private final SpanStyle mergeOrUse(SpanStyle spanStyle, SpanStyle spanStyle2) {
        SpanStyle merge;
        return (spanStyle == null || (merge = spanStyle.merge(spanStyle2)) == null) ? spanStyle2 : merge;
    }

    private final void handleLink(LinkAnnotation link, UriHandler uriHandler) {
        LinkInteractionListener linkInteractionListener;
        if (link instanceof LinkAnnotation.Url) {
            LinkInteractionListener linkInteractionListener2 = ((LinkAnnotation.Url) link).getLinkInteractionListener();
            if (linkInteractionListener2 != null) {
                linkInteractionListener2.onClick(link);
                return;
            } else {
                try {
                    uriHandler.openUri(((LinkAnnotation.Url) link).getUrl());
                    return;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
        if (!(link instanceof LinkAnnotation.Clickable) || (linkInteractionListener = ((LinkAnnotation.Clickable) link).getLinkInteractionListener()) == null) {
            return;
        }
        linkInteractionListener.onClick(link);
    }

    public final AnnotatedString applyAnnotators$foundation_release() {
        AnnotatedString styledText;
        if (this.annotators.isEmpty()) {
            styledText = this.text;
        } else {
            TextAnnotatorScope textAnnotatorScope = new TextAnnotatorScope(this.text);
            SnapshotStateList<Function1<TextAnnotatorScope, Unit>> snapshotStateList = this.annotators;
            int size = snapshotStateList.size();
            for (int i = 0; i < size; i++) {
                snapshotStateList.get(i).invoke(textAnnotatorScope);
            }
            styledText = textAnnotatorScope.getStyledText();
        }
        this.text = styledText;
        return styledText;
    }

    private final void StyleAnnotation(final Object[] objArr, final Function1<? super TextAnnotatorScope, Unit> function1, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2083052099);
        ComposerKt.sourceInformation(startRestartGroup, "C(StyleAnnotation)N(keys,block)316@13856L89,316@13825L120:TextLinkScope.kt#423gt5");
        int i2 = (i & 48) == 0 ? (startRestartGroup.changedInstance(function1) ? 32 : 16) | i : i;
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(this) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        startRestartGroup.startMovableGroup(-358305778, Integer.valueOf(objArr.length));
        int i3 = i2 | (startRestartGroup.changed(objArr.length) ? 4 : 0);
        for (Object obj : objArr) {
            i3 |= startRestartGroup.changedInstance(obj) ? 4 : 0;
        }
        startRestartGroup.endMovableGroup();
        if ((i3 & 14) == 0) {
            i3 |= 2;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2083052099, i3, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:315)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(function1);
            spreadBuilder.addSpread(objArr);
            Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -358302570, "CC(remember):TextLinkScope.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(this) | ((i3 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj2) {
                        DisposableEffectResult StyleAnnotation$lambda$24$lambda$23;
                        StyleAnnotation$lambda$24$lambda$23 = TextLinkScope.StyleAnnotation$lambda$24$lambda$23(TextLinkScope.this, function1, (DisposableEffectScope) obj2);
                        return StyleAnnotation$lambda$24$lambda$23;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(array, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2, Object obj3) {
                    Unit StyleAnnotation$lambda$25;
                    StyleAnnotation$lambda$25 = TextLinkScope.StyleAnnotation$lambda$25(TextLinkScope.this, objArr, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return StyleAnnotation$lambda$25;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult StyleAnnotation$lambda$24$lambda$23(final TextLinkScope textLinkScope, final Function1 function1, DisposableEffectScope disposableEffectScope) {
        textLinkScope.annotators.add(function1);
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$lambda$24$lambda$23$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                SnapshotStateList snapshotStateList;
                snapshotStateList = TextLinkScope.this.annotators;
                snapshotStateList.remove(function1);
            }
        };
    }
}
