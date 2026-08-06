package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.ColorProducer;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicText.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010 \u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0004\b!\u0010\"\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b#\u0010$\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b#\u0010%\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b\u001e\u0010&\u001a\u001e\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002\u001a@\u0010,\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e00H\u0002\u001aÉ\u0001\u00105\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\u0014\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09\u0018\u00010-2\u001c\u0010;\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010<0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bA\u0010B\u001a·\u0001\u0010C\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00182\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\bE\u0010F¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0018X\u008a\u008e\u0002"}, d2 = {"BasicText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "BasicText-RWo7tUw", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-CL7eQgs", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "BasicText-VhcvRP8", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "textModifier", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "textModifier-CL7eQgs", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;)Landroidx/compose/ui/Modifier;", "LayoutWithLinksAndInlineContent", "hasInlineContent", "LayoutWithLinksAndInlineContent-11Od_4g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "displayedText"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BasicTextKt {
    public static final Unit BasicText_4YKlhWE$lambda$16(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Map map, int i3, int i4, Composer composer, int i5) {
        m1511BasicText4YKlhWE(annotatedString, modifier, textStyle, function1, i, z, i2, map, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    public static final Unit BasicText_4YKlhWE$lambda$17(String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, int i4, int i5, Composer composer, int i6) {
        m1512BasicText4YKlhWE(str, modifier, textStyle, function1, i, z, i2, i3, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    public static final Unit BasicText_BpD7jsM$lambda$15(String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, int i4, Composer composer, int i5) {
        m1513BasicTextBpD7jsM(str, modifier, textStyle, function1, i, z, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    public static final Unit BasicText_CL7eQgs$lambda$12(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, ColorProducer colorProducer, TextAutoSize textAutoSize, int i4, int i5, int i6, Composer composer, int i7) {
        m1514BasicTextCL7eQgs(annotatedString, modifier, textStyle, function1, i, z, i2, i3, map, colorProducer, textAutoSize, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    public static final Unit BasicText_RWo7tUw$lambda$14(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, ColorProducer colorProducer, int i4, int i5, Composer composer, int i6) {
        m1515BasicTextRWo7tUw(annotatedString, modifier, textStyle, function1, i, z, i2, i3, map, colorProducer, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    public static final Unit BasicText_RWo7tUw$lambda$3(String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, TextAutoSize textAutoSize, int i4, int i5, Composer composer, int i6) {
        m1516BasicTextRWo7tUw(str, modifier, textStyle, (Function1<? super TextLayoutResult, Unit>) function1, i, z, i2, i3, colorProducer, textAutoSize, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    public static final Unit BasicText_VhcvRP8$lambda$13(String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, int i4, int i5, Composer composer, int i6) {
        m1518BasicTextVhcvRP8(str, modifier, textStyle, function1, i, z, i2, i3, colorProducer, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    public static final Unit BasicText_VhcvRP8$lambda$18(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, int i4, int i5, Composer composer, int i6) {
        m1517BasicTextVhcvRP8(annotatedString, modifier, textStyle, function1, i, z, i2, i3, map, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    public static final AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$27$lambda$26(AnnotatedString annotatedString) {
        return annotatedString;
    }

    public static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$43(Modifier modifier, AnnotatedString annotatedString, Function1 function1, boolean z, Map map, TextStyle textStyle, int i, boolean z2, int i2, int i3, FontFamily.Resolver resolver, SelectionController selectionController, ColorProducer colorProducer, Function1 function12, TextAutoSize textAutoSize, int i4, int i5, int i6, Composer composer, int i7) {
        m1519LayoutWithLinksAndInlineContent11Od_4g(modifier, annotatedString, function1, z, map, textStyle, i, z2, i2, i3, resolver, selectionController, colorProducer, function12, textAutoSize, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* renamed from: BasicText-RWo7tUw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1516BasicTextRWo7tUw(final String str, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, TextAutoSize textAutoSize, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        Function1<? super TextLayoutResult, Unit> function12;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        final Modifier modifier2;
        TextStyle textStyle2;
        boolean z2;
        int i16;
        final int i17;
        final ColorProducer colorProducer2;
        final TextAutoSize textAutoSize2;
        final Function1<? super TextLayoutResult, Unit> function13;
        final int i18;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        int i19;
        ColorProducer colorProducer3;
        int i20;
        boolean z3;
        SelectionController selectionController;
        Modifier modifier4;
        Modifier m1520textModifierCL7eQgs;
        Composer startRestartGroup = composer.startRestartGroup(-1040751001);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,color,autoSize)104@5458L7,119@6129L7,121@6142L94,154@7432L41:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i21 = i5 & 2;
        if (i21 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i4 & 384) == 0) {
                i6 |= startRestartGroup.changed(textStyle) ? Fields.RotationX : Fields.SpotShadowColor;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    function12 = function1;
                    i6 |= startRestartGroup.changedInstance(function12) ? Fields.CameraDistance : Fields.RotationZ;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i10 = i;
                        i6 |= startRestartGroup.changed(i10) ? Fields.Clip : Fields.Shape;
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            i6 |= startRestartGroup.changed(z) ? Fields.RenderEffect : 65536;
                        }
                        i12 = i5 & 64;
                        if (i12 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= startRestartGroup.changed(i2) ? 1048576 : Fields.BlendMode;
                        }
                        i13 = i5 & Fields.SpotShadowColor;
                        if (i13 != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                        }
                        i14 = i5 & Fields.RotationX;
                        if (i14 != 0) {
                            i6 |= 100663296;
                        } else if ((i4 & 100663296) == 0) {
                            i6 |= startRestartGroup.changedInstance(colorProducer) ? 67108864 : 33554432;
                        }
                        i15 = i5 & Fields.RotationY;
                        int i22 = 805306368;
                        if (i15 == 0) {
                            if ((i4 & 805306368) == 0) {
                                i22 = (i4 & 1073741824) == 0 ? startRestartGroup.changed(textAutoSize) : startRestartGroup.changedInstance(textAutoSize) ? 536870912 : 268435456;
                            }
                            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                textStyle2 = textStyle;
                                z2 = z;
                                i16 = i2;
                                i17 = i3;
                                colorProducer2 = colorProducer;
                                textAutoSize2 = textAutoSize;
                                function13 = function12;
                                i18 = i10;
                            } else {
                                Modifier.Companion companion = i21 != 0 ? Modifier.INSTANCE : modifier;
                                textStyle2 = i7 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                if (i8 != 0) {
                                    function12 = null;
                                }
                                int i23 = i9 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i10;
                                boolean z4 = i11 != 0 ? true : z;
                                int i24 = i12 != 0 ? Integer.MAX_VALUE : i2;
                                int i25 = i13 != 0 ? 1 : i3;
                                ColorProducer colorProducer4 = i14 != 0 ? null : colorProducer;
                                TextAutoSize textAutoSize3 = i15 != 0 ? null : textAutoSize;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1040751001, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:102)");
                                }
                                HeightInLinesModifierKt.validateMinMaxLines(i25, i24);
                                ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localSelectionRegistrar);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) consume;
                                if (selectionRegistrar != null) {
                                    startRestartGroup.startReplaceGroup(356434979);
                                    ComposerKt.sourceInformation(startRestartGroup, "107@5606L7,109@5760L77,109@5677L160,112@5850L180");
                                    ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(localTextSelectionColors);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    long backgroundColor = ((TextSelectionColors) consume2).getBackgroundColor();
                                    modifier3 = companion;
                                    Object[] objArr = {selectionRegistrar};
                                    colorProducer3 = colorProducer4;
                                    Saver<Long, Long> selectionIdSaver = selectionIdSaver(selectionRegistrar);
                                    i19 = i25;
                                    i16 = i24;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 565693972, "CC(remember):BasicText.kt#9igjgp");
                                    boolean changedInstance = startRestartGroup.changedInstance(selectionRegistrar);
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda4
                                            public final Object invoke() {
                                                long nextSelectableId;
                                                nextSelectableId = SelectionRegistrar.this.nextSelectableId();
                                                return Long.valueOf(nextSelectableId);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Number number = (Number) RememberSaveableKt.m4242rememberSaveable(objArr, (Saver) selectionIdSaver, (Function0) rememberedValue, startRestartGroup, 0);
                                    i20 = i23;
                                    z3 = z4;
                                    long longValue = number.longValue();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 565696955, "CC(remember):BasicText.kt#9igjgp");
                                    boolean changed = startRestartGroup.changed(longValue) | startRestartGroup.changed(selectionRegistrar) | startRestartGroup.changed(backgroundColor);
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new SelectionController(longValue, selectionRegistrar, backgroundColor, null, 8, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endReplaceGroup();
                                    selectionController = (SelectionController) rememberedValue2;
                                } else {
                                    modifier3 = companion;
                                    i19 = i25;
                                    colorProducer3 = colorProducer4;
                                    i20 = i23;
                                    z3 = z4;
                                    i16 = i24;
                                    startRestartGroup.startReplaceGroup(356926143);
                                    startRestartGroup.endReplaceGroup();
                                    selectionController = null;
                                }
                                ProvidableCompositionLocal localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume3 = startRestartGroup.consume(localFontFamilyResolver);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                FontFamily.Resolver resolver = (FontFamily.Resolver) consume3;
                                BasicText_androidKt.BackgroundTextMeasurement(str, textStyle2, resolver, startRestartGroup, ((i6 >> 3) & 112) | (i6 & 14));
                                if (selectionController != null || function12 != null || textAutoSize3 != null) {
                                    modifier4 = modifier3;
                                    startRestartGroup.startReplaceGroup(357244017);
                                    ComposerKt.sourceInformation(startRestartGroup, "133@6715L7");
                                    AnnotatedString annotatedString = new AnnotatedString(str, (List) null, 2, (DefaultConstructorMarker) null);
                                    ProvidableCompositionLocal localFontFamilyResolver2 = CompositionLocalsKt.getLocalFontFamilyResolver();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume4 = startRestartGroup.consume(localFontFamilyResolver2);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    m1520textModifierCL7eQgs = m1520textModifierCL7eQgs(modifier4, annotatedString, textStyle2, function12, i20, z3, i16, i19, (FontFamily.Resolver) consume4, null, null, selectionController, colorProducer3, null, textAutoSize3);
                                    startRestartGroup.endReplaceGroup();
                                } else {
                                    startRestartGroup.startReplaceGroup(357887763);
                                    startRestartGroup.endReplaceGroup();
                                    Modifier modifier5 = (Modifier) new TextStringSimpleElement(str, textStyle2, resolver, i20, z3, i16, i19, colorProducer3, null);
                                    modifier4 = modifier3;
                                    m1520textModifierCL7eQgs = modifier4.then(modifier5);
                                }
                                EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 544976794, "CC(Layout)P(1)122@4875L27,125@5041L333:Layout.kt#80mrfh");
                                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1520textModifierCL7eQgs);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(constructor);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                                Updater.m4116setimpl(m4109constructorimpl, emptyMeasurePolicy, (Function2<? super T, ? super EmptyMeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                                    m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                                }
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textAutoSize2 = textAutoSize3;
                                function13 = function12;
                                colorProducer2 = colorProducer3;
                                i17 = i19;
                                z2 = z3;
                                i18 = i20;
                                modifier2 = modifier4;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final TextStyle textStyle3 = textStyle2;
                                final boolean z5 = z2;
                                final int i26 = i16;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicText_RWo7tUw$lambda$3;
                                        BasicText_RWo7tUw$lambda$3 = BasicTextKt.BasicText_RWo7tUw$lambda$3(str, modifier2, textStyle3, function13, i18, z5, i26, i17, colorProducer2, textAutoSize2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicText_RWo7tUw$lambda$3;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i6 |= i22;
                        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 64;
                    if (i12 != 0) {
                    }
                    i13 = i5 & Fields.SpotShadowColor;
                    if (i13 != 0) {
                    }
                    i14 = i5 & Fields.RotationX;
                    if (i14 != 0) {
                    }
                    i15 = i5 & Fields.RotationY;
                    int i222 = 805306368;
                    if (i15 == 0) {
                    }
                    i6 |= i222;
                    if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                i12 = i5 & 64;
                if (i12 != 0) {
                }
                i13 = i5 & Fields.SpotShadowColor;
                if (i13 != 0) {
                }
                i14 = i5 & Fields.RotationX;
                if (i14 != 0) {
                }
                i15 = i5 & Fields.RotationY;
                int i2222 = 805306368;
                if (i15 == 0) {
                }
                i6 |= i2222;
                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 != 0) {
            }
            i13 = i5 & Fields.SpotShadowColor;
            if (i13 != 0) {
            }
            i14 = i5 & Fields.RotationX;
            if (i14 != 0) {
            }
            i15 = i5 & Fields.RotationY;
            int i22222 = 805306368;
            if (i15 == 0) {
            }
            i6 |= i22222;
            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 != 0) {
        }
        i13 = i5 & Fields.SpotShadowColor;
        if (i13 != 0) {
        }
        i14 = i5 & Fields.RotationX;
        if (i14 != 0) {
        }
        i15 = i5 & Fields.RotationY;
        int i222222 = 805306368;
        if (i15 == 0) {
        }
        i6 |= i222222;
        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x040d, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L426;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0176  */
    /* renamed from: BasicText-CL7eQgs */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1514BasicTextCL7eQgs(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, ColorProducer colorProducer, TextAutoSize textAutoSize, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        final Modifier modifier2;
        final TextStyle textStyle2;
        Function1<? super TextLayoutResult, Unit> function12;
        final int i19;
        final boolean z2;
        final int i20;
        final int i21;
        final Map<String, InlineTextContent> map2;
        final ColorProducer colorProducer2;
        final TextAutoSize textAutoSize2;
        Composer composer2;
        ScopeUpdateScope endRestartGroup;
        boolean z3;
        SelectionController selectionController;
        int i22;
        int i23;
        Object obj;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(-1343466571);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,color,autoSize)202@10280L7,219@11037L7:BasicText.kt#423gt5");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i24 = i6 & 2;
        if (i24 != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i4 & 384) == 0) {
                i7 |= startRestartGroup.changed(textStyle) ? Fields.RotationX : Fields.SpotShadowColor;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    i7 |= startRestartGroup.changedInstance(function1) ? Fields.CameraDistance : Fields.RotationZ;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i7 |= startRestartGroup.changed(i) ? Fields.Clip : Fields.Shape;
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                        } else if ((i4 & 196608) == 0) {
                            i7 |= startRestartGroup.changed(z) ? Fields.RenderEffect : 65536;
                        }
                        i12 = i6 & 64;
                        if (i12 != 0) {
                            i7 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i7 |= startRestartGroup.changed(i2) ? 1048576 : Fields.BlendMode;
                        }
                        i13 = i6 & Fields.SpotShadowColor;
                        if (i13 != 0) {
                            i7 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i7 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                        }
                        i14 = i6 & Fields.RotationX;
                        if (i14 != 0) {
                            i7 |= 100663296;
                        } else if ((i4 & 100663296) == 0) {
                            i7 |= startRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                        }
                        i15 = i6 & Fields.RotationY;
                        if (i15 != 0) {
                            i7 |= 805306368;
                        } else if ((i4 & 805306368) == 0) {
                            i7 |= startRestartGroup.changedInstance(colorProducer) ? 536870912 : 268435456;
                        }
                        i16 = i6 & Fields.RotationZ;
                        if (i16 != 0) {
                            i18 = i5 | 6;
                        } else {
                            if ((i5 & 6) != 0) {
                                i17 = i5;
                                if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i17 & 3) != 2, i7 & 1)) {
                                    Composer composer4 = startRestartGroup;
                                    composer4.skipToGroupEnd();
                                    modifier2 = modifier;
                                    textStyle2 = textStyle;
                                    function12 = function1;
                                    i19 = i;
                                    z2 = z;
                                    i20 = i2;
                                    i21 = i3;
                                    map2 = map;
                                    colorProducer2 = colorProducer;
                                    textAutoSize2 = textAutoSize;
                                    composer2 = composer4;
                                } else {
                                    Modifier modifier3 = i24 != 0 ? Modifier.INSTANCE : modifier;
                                    TextStyle textStyle3 = i8 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                    function12 = i9 != 0 ? null : function1;
                                    int i25 = i10 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i;
                                    boolean z4 = i11 != 0 ? true : z;
                                    int i26 = i12 != 0 ? Integer.MAX_VALUE : i2;
                                    int i27 = i13 != 0 ? 1 : i3;
                                    Map<String, InlineTextContent> emptyMap = i14 != 0 ? MapsKt.emptyMap() : map;
                                    ColorProducer colorProducer3 = i15 != 0 ? null : colorProducer;
                                    TextAutoSize textAutoSize3 = i16 != 0 ? null : textAutoSize;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1343466571, i7, i17, "androidx.compose.foundation.text.BasicText (BasicText.kt:200)");
                                    }
                                    HeightInLinesModifierKt.validateMinMaxLines(i27, i26);
                                    ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localSelectionRegistrar);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) consume;
                                    if (selectionRegistrar != null) {
                                        startRestartGroup.startReplaceGroup(1588280149);
                                        ComposerKt.sourceInformation(startRestartGroup, "205@10428L7,207@10582L77,207@10499L160,210@10672L180");
                                        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume2 = startRestartGroup.consume(localTextSelectionColors);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        long backgroundColor = ((TextSelectionColors) consume2).getBackgroundColor();
                                        Object[] objArr = {selectionRegistrar};
                                        Saver<Long, Long> selectionIdSaver = selectionIdSaver(selectionRegistrar);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1713809570, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changedInstance = startRestartGroup.changedInstance(selectionRegistrar);
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda9
                                                public final Object invoke() {
                                                    long nextSelectableId;
                                                    nextSelectableId = SelectionRegistrar.this.nextSelectableId();
                                                    return Long.valueOf(nextSelectableId);
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        z3 = false;
                                        long longValue = ((Number) RememberSaveableKt.m4242rememberSaveable(objArr, (Saver) selectionIdSaver, (Function0) rememberedValue, startRestartGroup, 0)).longValue();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1713812553, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changed = startRestartGroup.changed(longValue) | startRestartGroup.changed(selectionRegistrar) | startRestartGroup.changed(backgroundColor);
                                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new SelectionController(longValue, selectionRegistrar, backgroundColor, null, 8, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                        selectionController = (SelectionController) rememberedValue2;
                                    } else {
                                        z3 = false;
                                        startRestartGroup.startReplaceGroup(1588771313);
                                        startRestartGroup.endReplaceGroup();
                                        selectionController = null;
                                    }
                                    boolean hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
                                    boolean hasLinks = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
                                    ProvidableCompositionLocal localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume3 = startRestartGroup.consume(localFontFamilyResolver);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    FontFamily.Resolver resolver = (FontFamily.Resolver) consume3;
                                    if (!hasInlineContent && !hasLinks) {
                                        startRestartGroup.startReplaceGroup(1589018166);
                                        ComposerKt.sourceInformation(startRestartGroup, "222@11096L174,230@11349L746");
                                        BasicText_androidKt.BackgroundTextMeasurement(annotatedString, textStyle3, resolver, null, startRestartGroup, (i7 & 14) | 3072 | ((i7 >> 3) & 112));
                                        i22 = i27;
                                        i23 = i26;
                                        Modifier m1520textModifierCL7eQgs = m1520textModifierCL7eQgs(modifier3, annotatedString, textStyle3, function12, i25, z4, i26, i27, resolver, null, null, selectionController, colorProducer3, null, textAutoSize3);
                                        EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                        Composer composer5 = startRestartGroup;
                                        ComposerKt.sourceInformationMarkerStart(composer5, 544976794, "CC(Layout)P(1)122@4875L27,125@5041L333:Layout.kt#80mrfh");
                                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer5, 0));
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, m1520textModifierCL7eQgs);
                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer5, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                                        if (!(composer5.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer5.startReusableNode();
                                        if (composer5.getInserting()) {
                                            composer5.createNode(constructor);
                                        } else {
                                            composer5.useNode();
                                        }
                                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer5);
                                        Updater.m4116setimpl(m4109constructorimpl, emptyMeasurePolicy, (Function2<? super T, ? super EmptyMeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                                            m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                                        }
                                        composer5.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                        composer5.endReplaceGroup();
                                        composer3 = composer5;
                                    } else {
                                        boolean z5 = z3;
                                        i22 = i27;
                                        i23 = i26;
                                        Composer composer6 = startRestartGroup;
                                        composer6.startReplaceGroup(1590033974);
                                        ComposerKt.sourceInformation(composer6, "253@12268L39,269@12876L292,255@12317L895");
                                        ComposerKt.sourceInformationMarkerStart(composer6, 1713863484, "CC(remember):BasicText.kt#9igjgp");
                                        boolean z6 = (i7 & 14) == 4 ? true : z5;
                                        Object rememberedValue3 = composer6.rememberedValue();
                                        if (z6 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString, null, 2, null);
                                            composer6.updateRememberedValue(rememberedValue3);
                                        }
                                        final MutableState mutableState = (MutableState) rememberedValue3;
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        AnnotatedString BasicText_CL7eQgs$lambda$8 = BasicText_CL7eQgs$lambda$8(mutableState);
                                        ComposerKt.sourceInformationMarkerStart(composer6, 1713883193, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changed2 = composer6.changed(mutableState);
                                        Object rememberedValue4 = composer6.rememberedValue();
                                        if (!changed2) {
                                            obj = rememberedValue4;
                                        }
                                        Function1 function13 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                                            public final Object invoke(Object obj2) {
                                                Unit BasicText_CL7eQgs$lambda$11$lambda$10;
                                                BasicText_CL7eQgs$lambda$11$lambda$10 = BasicTextKt.BasicText_CL7eQgs$lambda$11$lambda$10(MutableState.this, (TextAnnotatedStringNode.TextSubstitutionValue) obj2);
                                                return BasicText_CL7eQgs$lambda$11$lambda$10;
                                            }
                                        };
                                        composer6.updateRememberedValue(function13);
                                        obj = function13;
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        int i28 = i7 >> 3;
                                        int i29 = i7 << 6;
                                        m1519LayoutWithLinksAndInlineContent11Od_4g(modifier3, BasicText_CL7eQgs$lambda$8, function12, hasInlineContent, emptyMap, textStyle3, i25, z4, i23, i22, resolver, selectionController, colorProducer3, (Function1) obj, textAutoSize3, composer6, (i28 & 896) | (i28 & 14) | ((i7 >> 12) & 57344) | ((i7 << 9) & 458752) | (3670016 & i29) | (29360128 & i29) | (234881024 & i29) | (i29 & 1879048192), ((i7 >> 21) & 896) | ((i17 << 12) & 57344), 0);
                                        composer6.endReplaceGroup();
                                        composer3 = composer6;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    textStyle2 = textStyle3;
                                    i19 = i25;
                                    z2 = z4;
                                    map2 = emptyMap;
                                    colorProducer2 = colorProducer3;
                                    textAutoSize2 = textAutoSize3;
                                    i21 = i22;
                                    i20 = i23;
                                    composer2 = composer3;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                    final Function1<? super TextLayoutResult, Unit> function14 = function12;
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda12
                                        public final Object invoke(Object obj2, Object obj3) {
                                            Unit BasicText_CL7eQgs$lambda$12;
                                            BasicText_CL7eQgs$lambda$12 = BasicTextKt.BasicText_CL7eQgs$lambda$12(annotatedString, modifier2, textStyle2, function14, i19, z2, i20, i21, map2, colorProducer2, textAutoSize2, i4, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                                            return BasicText_CL7eQgs$lambda$12;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i18 = i5 | ((i5 & 8) == 0 ? startRestartGroup.changed(textAutoSize) : startRestartGroup.changedInstance(textAutoSize) ? 4 : 2);
                        }
                        i17 = i18;
                        if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i17 & 3) != 2, i7 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 64;
                    if (i12 != 0) {
                    }
                    i13 = i6 & Fields.SpotShadowColor;
                    if (i13 != 0) {
                    }
                    i14 = i6 & Fields.RotationX;
                    if (i14 != 0) {
                    }
                    i15 = i6 & Fields.RotationY;
                    if (i15 != 0) {
                    }
                    i16 = i6 & Fields.RotationZ;
                    if (i16 != 0) {
                    }
                    i17 = i18;
                    if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i17 & 3) != 2, i7 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                }
                i13 = i6 & Fields.SpotShadowColor;
                if (i13 != 0) {
                }
                i14 = i6 & Fields.RotationX;
                if (i14 != 0) {
                }
                i15 = i6 & Fields.RotationY;
                if (i15 != 0) {
                }
                i16 = i6 & Fields.RotationZ;
                if (i16 != 0) {
                }
                i17 = i18;
                if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i17 & 3) != 2, i7 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i13 = i6 & Fields.SpotShadowColor;
            if (i13 != 0) {
            }
            i14 = i6 & Fields.RotationX;
            if (i14 != 0) {
            }
            i15 = i6 & Fields.RotationY;
            if (i15 != 0) {
            }
            i16 = i6 & Fields.RotationZ;
            if (i16 != 0) {
            }
            i17 = i18;
            if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i17 & 3) != 2, i7 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i13 = i6 & Fields.SpotShadowColor;
        if (i13 != 0) {
        }
        i14 = i6 & Fields.RotationX;
        if (i14 != 0) {
        }
        i15 = i6 & Fields.RotationY;
        if (i15 != 0) {
        }
        i16 = i6 & Fields.RotationZ;
        if (i16 != 0) {
        }
        i17 = i18;
        if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i17 & 3) != 2, i7 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final AnnotatedString BasicText_CL7eQgs$lambda$8(MutableState<AnnotatedString> mutableState) {
        return mutableState.getValue();
    }

    public static final Unit BasicText_CL7eQgs$lambda$11$lambda$10(MutableState mutableState, TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
        AnnotatedString original;
        if (textSubstitutionValue.isShowingSubstitution()) {
            original = textSubstitutionValue.getSubstitution();
        } else {
            original = textSubstitutionValue.getOriginal();
        }
        mutableState.setValue(original);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00a8  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-VhcvRP8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1518BasicTextVhcvRP8(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        Function1 function12;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final int i15;
        final int i16;
        final Function1 function13;
        final int i17;
        final boolean z3;
        final ColorProducer colorProducer2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1186827822);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,color)318@15279L93:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i18 = i5 & 2;
        if (i18 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i4 & 384) == 0) {
                i6 |= startRestartGroup.changed(textStyle) ? Fields.RotationX : Fields.SpotShadowColor;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    function12 = function1;
                    i6 |= startRestartGroup.changedInstance(function12) ? Fields.CameraDistance : Fields.RotationZ;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i10 = i;
                        i6 |= startRestartGroup.changed(i10) ? Fields.Clip : Fields.Shape;
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= 196608;
                        } else if ((196608 & i4) == 0) {
                            z2 = z;
                            i6 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                            i12 = i5 & 64;
                            if (i12 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(i2) ? 1048576 : Fields.BlendMode;
                            }
                            i13 = i5 & Fields.SpotShadowColor;
                            if (i13 == 0) {
                                i6 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                            }
                            i14 = i5 & Fields.RotationX;
                            if (i14 == 0) {
                                i6 |= 100663296;
                            } else if ((i4 & 100663296) == 0) {
                                i6 |= startRestartGroup.changedInstance(colorProducer) ? 67108864 : 33554432;
                            }
                            if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                textStyle2 = textStyle;
                                i15 = i2;
                                i16 = i3;
                                function13 = function12;
                                i17 = i10;
                                z3 = z2;
                                colorProducer2 = colorProducer;
                            } else {
                                Modifier.Companion companion = i18 != 0 ? Modifier.INSTANCE : modifier;
                                TextStyle textStyle3 = i7 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                if (i8 != 0) {
                                    function12 = null;
                                }
                                int i19 = i9 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i10;
                                boolean z4 = i11 != 0 ? true : z2;
                                int i20 = i12 != 0 ? Integer.MAX_VALUE : i2;
                                int i21 = i13 != 0 ? 1 : i3;
                                ColorProducer colorProducer3 = i14 == 0 ? colorProducer : null;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1186827822, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:317)");
                                }
                                m1516BasicTextRWo7tUw(str, companion, textStyle3, (Function1<? super TextLayoutResult, Unit>) function12, i19, z4, i20, i21, colorProducer3, (TextAutoSize) null, startRestartGroup, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (i6 & 234881024), Fields.RotationY);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = companion;
                                textStyle2 = textStyle3;
                                i17 = i19;
                                function13 = function12;
                                i15 = i20;
                                colorProducer2 = colorProducer3;
                                z3 = z4;
                                i16 = i21;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicText_VhcvRP8$lambda$13;
                                        BasicText_VhcvRP8$lambda$13 = BasicTextKt.BasicText_VhcvRP8$lambda$13(str, modifier2, textStyle2, function13, i17, z3, i15, i16, colorProducer2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicText_VhcvRP8$lambda$13;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z2 = z;
                        i12 = i5 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i5 & Fields.SpotShadowColor;
                        if (i13 == 0) {
                        }
                        i14 = i5 & Fields.RotationX;
                        if (i14 == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    z2 = z;
                    i12 = i5 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i5 & Fields.SpotShadowColor;
                    if (i13 == 0) {
                    }
                    i14 = i5 & Fields.RotationX;
                    if (i14 == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                z2 = z;
                i12 = i5 & 64;
                if (i12 == 0) {
                }
                i13 = i5 & Fields.SpotShadowColor;
                if (i13 == 0) {
                }
                i14 = i5 & Fields.RotationX;
                if (i14 == 0) {
                }
                if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            z2 = z;
            i12 = i5 & 64;
            if (i12 == 0) {
            }
            i13 = i5 & Fields.SpotShadowColor;
            if (i13 == 0) {
            }
            i14 = i5 & Fields.RotationX;
            if (i14 == 0) {
            }
            if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        z2 = z;
        i12 = i5 & 64;
        if (i12 == 0) {
        }
        i13 = i5 & Fields.SpotShadowColor;
        if (i13 == 0) {
        }
        i14 = i5 & Fields.RotationX;
        if (i14 == 0) {
        }
        if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e6  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-RWo7tUw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1515BasicTextRWo7tUw(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, ColorProducer colorProducer, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        int i15;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final Function1 function12;
        final int i16;
        final int i17;
        final Map map2;
        final ColorProducer colorProducer2;
        final int i18;
        final boolean z3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,color)360@17696L195:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i19 = i5 & 2;
        if (i19 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i4 & 384) == 0) {
                i6 |= startRestartGroup.changed(textStyle) ? Fields.RotationX : Fields.SpotShadowColor;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    i6 |= startRestartGroup.changedInstance(function1) ? Fields.CameraDistance : Fields.RotationZ;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i10 = i;
                        i6 |= startRestartGroup.changed(i10) ? Fields.Clip : Fields.Shape;
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= 196608;
                        } else if ((196608 & i4) == 0) {
                            z2 = z;
                            i6 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                            i12 = i5 & 64;
                            if (i12 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(i2) ? 1048576 : Fields.BlendMode;
                            }
                            i13 = i5 & Fields.SpotShadowColor;
                            if (i13 == 0) {
                                i6 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                            }
                            i14 = i5 & Fields.RotationX;
                            if (i14 == 0) {
                                i6 |= 100663296;
                            } else if ((i4 & 100663296) == 0) {
                                i6 |= startRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                            }
                            i15 = i5 & Fields.RotationY;
                            if (i15 == 0) {
                                i6 |= 805306368;
                            } else if ((i4 & 805306368) == 0) {
                                i6 |= startRestartGroup.changedInstance(colorProducer) ? 536870912 : 268435456;
                            }
                            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                textStyle2 = textStyle;
                                function12 = function1;
                                i16 = i2;
                                i17 = i3;
                                map2 = map;
                                colorProducer2 = colorProducer;
                                i18 = i10;
                                z3 = z2;
                            } else {
                                Modifier.Companion companion = i19 != 0 ? Modifier.INSTANCE : modifier;
                                TextStyle textStyle3 = i7 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                Function1 function13 = i8 != 0 ? null : function1;
                                int i20 = i9 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i10;
                                boolean z4 = i11 != 0 ? true : z2;
                                int i21 = i12 != 0 ? Integer.MAX_VALUE : i2;
                                int i22 = i13 != 0 ? 1 : i3;
                                Map emptyMap = i14 != 0 ? MapsKt.emptyMap() : map;
                                ColorProducer colorProducer3 = i15 == 0 ? colorProducer : null;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1064305212, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:359)");
                                }
                                m1514BasicTextCL7eQgs(annotatedString, companion, textStyle3, function13, i20, z4, i21, i22, emptyMap, colorProducer3, null, startRestartGroup, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), 0, Fields.RotationZ);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textStyle2 = textStyle3;
                                i18 = i20;
                                z3 = z4;
                                map2 = emptyMap;
                                modifier2 = companion;
                                colorProducer2 = colorProducer3;
                                function12 = function13;
                                i16 = i21;
                                i17 = i22;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda13
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicText_RWo7tUw$lambda$14;
                                        BasicText_RWo7tUw$lambda$14 = BasicTextKt.BasicText_RWo7tUw$lambda$14(annotatedString, modifier2, textStyle2, function12, i18, z3, i16, i17, map2, colorProducer2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicText_RWo7tUw$lambda$14;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z2 = z;
                        i12 = i5 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i5 & Fields.SpotShadowColor;
                        if (i13 == 0) {
                        }
                        i14 = i5 & Fields.RotationX;
                        if (i14 == 0) {
                        }
                        i15 = i5 & Fields.RotationY;
                        if (i15 == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    z2 = z;
                    i12 = i5 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i5 & Fields.SpotShadowColor;
                    if (i13 == 0) {
                    }
                    i14 = i5 & Fields.RotationX;
                    if (i14 == 0) {
                    }
                    i15 = i5 & Fields.RotationY;
                    if (i15 == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                z2 = z;
                i12 = i5 & 64;
                if (i12 == 0) {
                }
                i13 = i5 & Fields.SpotShadowColor;
                if (i13 == 0) {
                }
                i14 = i5 & Fields.RotationX;
                if (i14 == 0) {
                }
                i15 = i5 & Fields.RotationY;
                if (i15 == 0) {
                }
                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            z2 = z;
            i12 = i5 & 64;
            if (i12 == 0) {
            }
            i13 = i5 & Fields.SpotShadowColor;
            if (i13 == 0) {
            }
            i14 = i5 & Fields.RotationX;
            if (i14 == 0) {
            }
            i15 = i5 & Fields.RotationY;
            if (i15 == 0) {
            }
            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        z2 = z;
        i12 = i5 & 64;
        if (i12 == 0) {
        }
        i13 = i5 & Fields.SpotShadowColor;
        if (i13 == 0) {
        }
        i14 = i5 & Fields.RotationX;
        if (i14 == 0) {
        }
        i15 = i5 & Fields.RotationY;
        if (i15 == 0) {
        }
        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0051  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-BpD7jsM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1513BasicTextBpD7jsM(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        Function1 function12;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final int i12;
        final boolean z3;
        final int i13;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines)385@18278L235:BasicText.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i14 = i4 & 2;
        if (i14 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i3 & 384) == 0) {
                textStyle2 = textStyle;
                i5 |= startRestartGroup.changed(textStyle2) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    function12 = function1;
                    i5 |= startRestartGroup.changedInstance(function12) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                        } else if ((196608 & i3) == 0) {
                            z2 = z;
                            i5 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                            i11 = i4 & 64;
                            if (i11 == 0) {
                                i5 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(i2) ? 1048576 : Fields.BlendMode;
                            }
                            if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                textStyle3 = textStyle2;
                                function13 = function12;
                                i12 = i9;
                                z3 = z2;
                                i13 = i2;
                            } else {
                                Modifier.Companion companion = i14 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i6 != 0) {
                                    textStyle2 = TextStyle.Companion.getDefault();
                                }
                                Function1 function14 = i7 != 0 ? null : function12;
                                int i15 = i8 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i9;
                                boolean z4 = i10 != 0 ? true : z2;
                                int i16 = i11 != 0 ? Integer.MAX_VALUE : i2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1022429478, i5, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:384)");
                                }
                                m1516BasicTextRWo7tUw(str, companion, textStyle2, (Function1<? super TextLayoutResult, Unit>) function14, i15, z4, i16, 1, (ColorProducer) null, (TextAutoSize) null, startRestartGroup, (i5 & 14) | 12582912 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (i5 & 3670016), 768);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textStyle3 = textStyle2;
                                i13 = i16;
                                z3 = z4;
                                i12 = i15;
                                function13 = function14;
                                modifier3 = companion;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda14
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicText_BpD7jsM$lambda$15;
                                        BasicText_BpD7jsM$lambda$15 = BasicTextKt.BasicText_BpD7jsM$lambda$15(str, modifier3, textStyle3, function13, i12, z3, i13, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicText_BpD7jsM$lambda$15;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z2 = z;
                        i11 = i4 & 64;
                        if (i11 == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    z2 = z;
                    i11 = i4 & 64;
                    if (i11 == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function12 = function1;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                z2 = z;
                i11 = i4 & 64;
                if (i11 == 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            function12 = function1;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            z2 = z;
            i11 = i4 & 64;
            if (i11 == 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        textStyle2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        function12 = function1;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        z2 = z;
        i11 = i4 & 64;
        if (i11 == 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x006f  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-4YKlhWE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1511BasicText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Map map, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        TextStyle textStyle2;
        int i7;
        Function1 function12;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        final Modifier.Companion companion;
        final Map map2;
        final TextStyle textStyle3;
        final Function1 function13;
        final int i13;
        final boolean z3;
        final int i14;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,inlineContent)409@18970L274:BasicText.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i15 = i4 & 2;
        if (i15 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i3 & 384) == 0) {
                textStyle2 = textStyle;
                i5 |= startRestartGroup.changed(textStyle2) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    function12 = function1;
                    i5 |= startRestartGroup.changedInstance(function12) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                        } else if ((196608 & i3) == 0) {
                            z2 = z;
                            i5 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                            i11 = i4 & 64;
                            if (i11 == 0) {
                                i5 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(i2) ? 1048576 : Fields.BlendMode;
                            }
                            i12 = i4 & Fields.SpotShadowColor;
                            if (i12 == 0) {
                                i5 |= 12582912;
                            } else if ((i3 & 12582912) == 0) {
                                i5 |= startRestartGroup.changedInstance(map) ? 8388608 : 4194304;
                            }
                            if (startRestartGroup.shouldExecute((i5 & 4793491) == 4793490, i5 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                map2 = map;
                                textStyle3 = textStyle2;
                                function13 = function12;
                                i13 = i9;
                                z3 = z2;
                                i14 = i2;
                            } else {
                                companion = i15 != 0 ? Modifier.INSTANCE : modifier;
                                if (i6 != 0) {
                                    textStyle2 = TextStyle.Companion.getDefault();
                                }
                                function13 = i7 != 0 ? null : function12;
                                i13 = i8 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i9;
                                z3 = i10 != 0 ? true : z2;
                                int i16 = i11 != 0 ? Integer.MAX_VALUE : i2;
                                Map emptyMap = i12 != 0 ? MapsKt.emptyMap() : map;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-648605928, i5, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:408)");
                                }
                                m1514BasicTextCL7eQgs(annotatedString, companion, textStyle2, function13, i13, z3, i16, 1, emptyMap, null, null, startRestartGroup, (i5 & 14) | 12582912 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | ((i5 << 3) & 234881024), 0, 1536);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textStyle3 = textStyle2;
                                i14 = i16;
                                map2 = emptyMap;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda11
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicText_4YKlhWE$lambda$16;
                                        BasicText_4YKlhWE$lambda$16 = BasicTextKt.BasicText_4YKlhWE$lambda$16(annotatedString, companion, textStyle3, function13, i13, z3, i14, map2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicText_4YKlhWE$lambda$16;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z2 = z;
                        i11 = i4 & 64;
                        if (i11 == 0) {
                        }
                        i12 = i4 & Fields.SpotShadowColor;
                        if (i12 == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i5 & 4793491) == 4793490, i5 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    z2 = z;
                    i11 = i4 & 64;
                    if (i11 == 0) {
                    }
                    i12 = i4 & Fields.SpotShadowColor;
                    if (i12 == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 4793491) == 4793490, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function12 = function1;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                z2 = z;
                i11 = i4 & 64;
                if (i11 == 0) {
                }
                i12 = i4 & Fields.SpotShadowColor;
                if (i12 == 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 4793491) == 4793490, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            function12 = function1;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            z2 = z;
            i11 = i4 & 64;
            if (i11 == 0) {
            }
            i12 = i4 & Fields.SpotShadowColor;
            if (i12 == 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 4793491) == 4793490, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        textStyle2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        function12 = function1;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        z2 = z;
        i11 = i4 & 64;
        if (i11 == 0) {
        }
        i12 = i4 & Fields.SpotShadowColor;
        if (i12 == 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 4793491) == 4793490, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x006f  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-4YKlhWE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1512BasicText4YKlhWE(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        TextStyle textStyle2;
        int i8;
        Function1 function12;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13;
        final Modifier.Companion companion;
        final int i14;
        final TextStyle textStyle3;
        final Function1 function13;
        final int i15;
        final boolean z3;
        final int i16;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines)433@19643L86:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i17 = i5 & 2;
        if (i17 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i4 & 384) == 0) {
                textStyle2 = textStyle;
                i6 |= startRestartGroup.changed(textStyle2) ? Fields.RotationX : Fields.SpotShadowColor;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    function12 = function1;
                    i6 |= startRestartGroup.changedInstance(function12) ? Fields.CameraDistance : Fields.RotationZ;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i10 = i;
                        i6 |= startRestartGroup.changed(i10) ? Fields.Clip : Fields.Shape;
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= 196608;
                        } else if ((196608 & i4) == 0) {
                            z2 = z;
                            i6 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                            i12 = i5 & 64;
                            if (i12 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(i2) ? 1048576 : Fields.BlendMode;
                            }
                            i13 = i5 & Fields.SpotShadowColor;
                            if (i13 == 0) {
                                i6 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                            }
                            if (startRestartGroup.shouldExecute((i6 & 4793491) == 4793490, i6 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                i14 = i3;
                                textStyle3 = textStyle2;
                                function13 = function12;
                                i15 = i10;
                                z3 = z2;
                                i16 = i2;
                            } else {
                                companion = i17 != 0 ? Modifier.INSTANCE : modifier;
                                if (i7 != 0) {
                                    textStyle2 = TextStyle.Companion.getDefault();
                                }
                                function13 = i8 != 0 ? null : function12;
                                i15 = i9 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i10;
                                z3 = i11 != 0 ? true : z2;
                                int i18 = i12 != 0 ? Integer.MAX_VALUE : i2;
                                int i19 = i13 != 0 ? 1 : i3;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1542716361, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:433)");
                                }
                                m1516BasicTextRWo7tUw(str, companion, textStyle2, (Function1<? super TextLayoutResult, Unit>) function13, i15, z3, i18, i19, (ColorProducer) null, (TextAutoSize) null, startRestartGroup, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (i6 & 29360128), 768);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textStyle3 = textStyle2;
                                i16 = i18;
                                i14 = i19;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicText_4YKlhWE$lambda$17;
                                        BasicText_4YKlhWE$lambda$17 = BasicTextKt.BasicText_4YKlhWE$lambda$17(str, companion, textStyle3, function13, i15, z3, i16, i14, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicText_4YKlhWE$lambda$17;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z2 = z;
                        i12 = i5 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i5 & Fields.SpotShadowColor;
                        if (i13 == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i6 & 4793491) == 4793490, i6 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    z2 = z;
                    i12 = i5 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i5 & Fields.SpotShadowColor;
                    if (i13 == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i6 & 4793491) == 4793490, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                z2 = z;
                i12 = i5 & 64;
                if (i12 == 0) {
                }
                i13 = i5 & Fields.SpotShadowColor;
                if (i13 == 0) {
                }
                if (startRestartGroup.shouldExecute((i6 & 4793491) == 4793490, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            z2 = z;
            i12 = i5 & 64;
            if (i12 == 0) {
            }
            i13 = i5 & Fields.SpotShadowColor;
            if (i13 == 0) {
            }
            if (startRestartGroup.shouldExecute((i6 & 4793491) == 4793490, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        z2 = z;
        i12 = i5 & 64;
        if (i12 == 0) {
        }
        i13 = i5 & Fields.SpotShadowColor;
        if (i13 == 0) {
        }
        if (startRestartGroup.shouldExecute((i6 & 4793491) == 4793490, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00a8  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-VhcvRP8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1517BasicTextVhcvRP8(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        Function1 function12;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final int i15;
        final int i16;
        final Function1 function13;
        final int i17;
        final boolean z3;
        final Map map2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent)448@20200L281:BasicText.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i18 = i5 & 2;
        if (i18 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i4 & 384) == 0) {
                i6 |= startRestartGroup.changed(textStyle) ? Fields.RotationX : Fields.SpotShadowColor;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    function12 = function1;
                    i6 |= startRestartGroup.changedInstance(function12) ? Fields.CameraDistance : Fields.RotationZ;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        i10 = i;
                        i6 |= startRestartGroup.changed(i10) ? Fields.Clip : Fields.Shape;
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= 196608;
                        } else if ((196608 & i4) == 0) {
                            z2 = z;
                            i6 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                            i12 = i5 & 64;
                            if (i12 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(i2) ? 1048576 : Fields.BlendMode;
                            }
                            i13 = i5 & Fields.SpotShadowColor;
                            if (i13 == 0) {
                                i6 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                            }
                            i14 = i5 & Fields.RotationX;
                            if (i14 == 0) {
                                i6 |= 100663296;
                            } else if ((i4 & 100663296) == 0) {
                                i6 |= startRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                            }
                            if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                textStyle2 = textStyle;
                                i15 = i2;
                                i16 = i3;
                                function13 = function12;
                                i17 = i10;
                                z3 = z2;
                                map2 = map;
                            } else {
                                Modifier.Companion companion = i18 != 0 ? Modifier.INSTANCE : modifier;
                                TextStyle textStyle3 = i7 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                Function1 function14 = i8 != 0 ? null : function12;
                                int i19 = i9 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i10;
                                boolean z4 = i11 != 0 ? true : z2;
                                int i20 = i12 != 0 ? Integer.MAX_VALUE : i2;
                                int i21 = i13 != 0 ? 1 : i3;
                                Map emptyMap = i14 != 0 ? MapsKt.emptyMap() : map;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(851408699, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:448)");
                                }
                                m1514BasicTextCL7eQgs(annotatedString, companion, textStyle3, function14, i19, z4, i20, i21, emptyMap, null, null, startRestartGroup, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (i6 & 234881024), 0, 1536);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textStyle2 = textStyle3;
                                i17 = i19;
                                i15 = i20;
                                map2 = emptyMap;
                                modifier2 = companion;
                                function13 = function14;
                                z3 = z4;
                                i16 = i21;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicText_VhcvRP8$lambda$18;
                                        BasicText_VhcvRP8$lambda$18 = BasicTextKt.BasicText_VhcvRP8$lambda$18(annotatedString, modifier2, textStyle2, function13, i17, z3, i15, i16, map2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicText_VhcvRP8$lambda$18;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z2 = z;
                        i12 = i5 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i5 & Fields.SpotShadowColor;
                        if (i13 == 0) {
                        }
                        i14 = i5 & Fields.RotationX;
                        if (i14 == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    z2 = z;
                    i12 = i5 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i5 & Fields.SpotShadowColor;
                    if (i13 == 0) {
                    }
                    i14 = i5 & Fields.RotationX;
                    if (i14 == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                z2 = z;
                i12 = i5 & 64;
                if (i12 == 0) {
                }
                i13 = i5 & Fields.SpotShadowColor;
                if (i13 == 0) {
                }
                i14 = i5 & Fields.RotationX;
                if (i14 == 0) {
                }
                if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            z2 = z;
            i12 = i5 & 64;
            if (i12 == 0) {
            }
            i13 = i5 & Fields.SpotShadowColor;
            if (i13 == 0) {
            }
            i14 = i5 & Fields.RotationX;
            if (i14 == 0) {
            }
            if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        z2 = z;
        i12 = i5 & 64;
        if (i12 == 0) {
        }
        i13 = i5 & Fields.SpotShadowColor;
        if (i13 == 0) {
        }
        i14 = i5 & Fields.RotationX;
        if (i14 == 0) {
        }
        if (startRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                Long selectionIdSaver$lambda$19;
                selectionIdSaver$lambda$19 = BasicTextKt.selectionIdSaver$lambda$19(SelectionRegistrar.this, (SaverScope) obj, ((Long) obj2).longValue());
                return selectionIdSaver$lambda$19;
            }
        }, new Function1() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Long valueOf;
                valueOf = Long.valueOf(((Long) obj).longValue());
                return valueOf;
            }
        });
    }

    public static final Long selectionIdSaver$lambda$19(SelectionRegistrar selectionRegistrar, SaverScope saverScope, long j) {
        if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
            return Long.valueOf(j);
        }
        return null;
    }

    public static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> list, Function0<Boolean> function0) {
        if (!((Boolean) function0.invoke()).booleanValue()) {
            return null;
        }
        TextRangeLayoutMeasureScope textRangeLayoutMeasureScope = new TextRangeLayoutMeasureScope();
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            Object parentData = measurable.getParentData();
            Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
            TextRangeLayoutMeasureResult measure = ((TextRangeLayoutModifier) parentData).getMeasurePolicy().measure(textRangeLayoutMeasureScope);
            arrayList.add(new Pair(measurable.mo6318measureBRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(measure.getWidth(), measure.getWidth(), measure.getHeight(), measure.getHeight())), measure.getPlace()));
        }
        return arrayList;
    }

    /* renamed from: textModifier-CL7eQgs */
    private static final Modifier m1520textModifierCL7eQgs(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13, TextAutoSize textAutoSize) {
        if (selectionController == null) {
            return modifier.then(Modifier.INSTANCE).then((Modifier) new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, null, colorProducer, textAutoSize, function13, null));
        }
        return modifier.then(selectionController.getModifier()).then((Modifier) new SelectableTextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController, colorProducer, textAutoSize, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x03d0, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L532;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f4  */
    /* renamed from: LayoutWithLinksAndInlineContent-11Od_4g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1519LayoutWithLinksAndInlineContent11Od_4g(final Modifier modifier, final AnnotatedString annotatedString, final Function1<? super TextLayoutResult, Unit> function1, final boolean z, Map<String, InlineTextContent> map, final TextStyle textStyle, final int i, final boolean z2, final int i2, final int i3, final FontFamily.Resolver resolver, final SelectionController selectionController, final ColorProducer colorProducer, final Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function12, final TextAutoSize textAutoSize, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        final Map<String, InlineTextContent> map2;
        Composer composer2;
        ScopeUpdateScope endRestartGroup;
        final TextLinkScope textLinkScope;
        Function0 function0;
        Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> pair;
        Map<String, InlineTextContent> map3;
        Function1 function13;
        final MutableState mutableState;
        String str;
        Function1 function14;
        Object obj;
        TextMeasurePolicy textMeasurePolicy;
        Composer startRestartGroup = composer.startRestartGroup(-2118572703);
        ComposerKt.sourceInformation(startRestartGroup, "C(LayoutWithLinksAndInlineContent)N(modifier,text,onTextLayout,hasInlineContent,inlineContent,style,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,fontFamilyResolver,selectionController,color,onShowTranslation,autoSize)678@28236L162,694@28726L117,685@28404L1429:BasicText.kt#423gt5");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= startRestartGroup.changed(annotatedString) ? 32 : 16;
        }
        int i10 = i6 & 4;
        int i11 = Fields.SpotShadowColor;
        if (i10 != 0) {
            i7 |= 384;
        } else if ((i4 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? Fields.RotationX : 128;
        }
        int i12 = i6 & 8;
        int i13 = Fields.CameraDistance;
        if (i12 != 0) {
            i7 |= 3072;
        } else if ((i4 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        int i14 = i6 & 16;
        int i15 = Fields.Clip;
        if (i14 != 0) {
            i7 |= 24576;
        } else if ((i4 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(map) ? 16384 : 8192;
            if ((i6 & 32) == 0) {
                i7 |= 196608;
            } else if ((i4 & 196608) == 0) {
                i7 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
            }
            if ((i6 & 64) == 0) {
                i7 |= 1572864;
            } else if ((i4 & 1572864) == 0) {
                i7 |= startRestartGroup.changed(i) ? 1048576 : Fields.BlendMode;
            }
            if ((i6 & Fields.SpotShadowColor) == 0) {
                i7 |= 12582912;
            } else if ((12582912 & i4) == 0) {
                i7 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                if ((i6 & Fields.RotationX) != 0) {
                    i7 |= 100663296;
                } else if ((100663296 & i4) == 0) {
                    i7 |= startRestartGroup.changed(i2) ? 67108864 : 33554432;
                    if ((i6 & Fields.RotationY) == 0) {
                        i7 |= 805306368;
                    } else if ((805306368 & i4) == 0) {
                        i7 |= startRestartGroup.changed(i3) ? 536870912 : 268435456;
                        if ((i6 & Fields.RotationZ) != 0) {
                            i8 = i5 | 6;
                        } else if ((i5 & 6) == 0) {
                            i8 = i5 | (startRestartGroup.changedInstance(resolver) ? 4 : 2);
                        } else {
                            i8 = i5;
                        }
                        if ((i6 & Fields.CameraDistance) != 0) {
                            i8 |= 48;
                        } else if ((i5 & 48) == 0) {
                            i8 |= startRestartGroup.changedInstance(selectionController) ? 32 : 16;
                        }
                        i9 = i8;
                        if ((i6 & Fields.TransformOrigin) != 0) {
                            i9 |= 384;
                        } else if ((i5 & 384) == 0) {
                            if (startRestartGroup.changedInstance(colorProducer)) {
                                i11 = Fields.RotationX;
                            }
                            i9 |= i11;
                            if ((i6 & Fields.Shape) == 0) {
                                i9 |= 3072;
                            } else if ((i5 & 3072) == 0) {
                                if (!startRestartGroup.changedInstance(function12)) {
                                    i13 = 1024;
                                }
                                i9 |= i13;
                                if ((i6 & Fields.Clip) != 0) {
                                    i9 |= 24576;
                                } else if ((i5 & 24576) == 0) {
                                    if (!((32768 & i5) == 0 ? startRestartGroup.changed(textAutoSize) : startRestartGroup.changedInstance(textAutoSize))) {
                                        i15 = 8192;
                                    }
                                    i9 |= i15;
                                }
                                if (!startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
                                    Composer composer3 = startRestartGroup;
                                    composer3.skipToGroupEnd();
                                    map2 = map;
                                    composer2 = composer3;
                                } else {
                                    Map<String, InlineTextContent> emptyMap = i14 != 0 ? MapsKt.emptyMap() : map;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2118572703, i7, i9, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:646)");
                                    }
                                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                                        startRestartGroup.startReplaceGroup(145661411);
                                        ComposerKt.sourceInformation(startRestartGroup, "650@27301L38");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -133848153, "CC(remember):BasicText.kt#9igjgp");
                                        boolean z3 = (i7 & 112) == 32;
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new TextLinkScope(annotatedString);
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                        textLinkScope = (TextLinkScope) rememberedValue;
                                    } else {
                                        startRestartGroup.startReplaceGroup(145727068);
                                        startRestartGroup.endReplaceGroup();
                                        textLinkScope = null;
                                    }
                                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                                        startRestartGroup.startReplaceGroup(145925283);
                                        ComposerKt.sourceInformation(startRestartGroup, "657@27566L70");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -133839641, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changed = ((i7 & 112) == 32) | startRestartGroup.changed(textLinkScope);
                                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda15
                                                public final Object invoke() {
                                                    AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$25$lambda$24;
                                                    LayoutWithLinksAndInlineContent_11Od_4g$lambda$25$lambda$24 = BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$25$lambda$24(TextLinkScope.this, annotatedString);
                                                    return LayoutWithLinksAndInlineContent_11Od_4g$lambda$25$lambda$24;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        function0 = (Function0) rememberedValue2;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(146022561);
                                        ComposerKt.sourceInformation(startRestartGroup, "659@27666L8");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -133836503, "CC(remember):BasicText.kt#9igjgp");
                                        boolean z4 = (i7 & 112) == 32;
                                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (z4 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda16
                                                public final Object invoke() {
                                                    AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$27$lambda$26;
                                                    LayoutWithLinksAndInlineContent_11Od_4g$lambda$27$lambda$26 = BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$27$lambda$26(annotatedString);
                                                    return LayoutWithLinksAndInlineContent_11Od_4g$lambda$27$lambda$26;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        function0 = (Function0) rememberedValue3;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    Function0 function02 = function0;
                                    if (z) {
                                        pair = AnnotatedStringResolveInlineContentKt.resolveInlineContent(annotatedString, emptyMap);
                                    } else {
                                        pair = new Pair<>((Object) null, (Object) null);
                                    }
                                    List list = (List) pair.component1();
                                    List list2 = (List) pair.component2();
                                    if (z) {
                                        startRestartGroup.startReplaceGroup(146338668);
                                        ComposerKt.sourceInformation(startRestartGroup, "670@27983L61");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -133826306, "CC(remember):BasicText.kt#9igjgp");
                                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                                        map3 = emptyMap;
                                        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            function13 = null;
                                            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                        } else {
                                            function13 = null;
                                        }
                                        mutableState = (MutableState) rememberedValue4;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        map3 = emptyMap;
                                        function13 = null;
                                        startRestartGroup.startReplaceGroup(146426428);
                                        startRestartGroup.endReplaceGroup();
                                        mutableState = null;
                                    }
                                    if (z) {
                                        startRestartGroup.startReplaceGroup(146519677);
                                        ComposerKt.sourceInformation(startRestartGroup, "675@28166L44");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -133820467, "CC(remember):BasicText.kt#9igjgp");
                                        boolean changed2 = startRestartGroup.changed(mutableState);
                                        str = "CC(remember):BasicText.kt#9igjgp";
                                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                                        if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda17
                                                public final Object invoke(Object obj2) {
                                                    Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$30$lambda$29;
                                                    LayoutWithLinksAndInlineContent_11Od_4g$lambda$30$lambda$29 = BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$30$lambda$29(MutableState.this, (List) obj2);
                                                    return LayoutWithLinksAndInlineContent_11Od_4g$lambda$30$lambda$29;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue5);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                        function14 = (Function1) rememberedValue5;
                                    } else {
                                        str = "CC(remember):BasicText.kt#9igjgp";
                                        startRestartGroup.startReplaceGroup(146591100);
                                        startRestartGroup.endReplaceGroup();
                                        function14 = function13;
                                    }
                                    int i16 = (i7 >> 3) & 14;
                                    int i17 = i7;
                                    final MutableState mutableState2 = mutableState;
                                    String str2 = str;
                                    Map<String, InlineTextContent> map4 = map3;
                                    BasicText_androidKt.BackgroundTextMeasurement(annotatedString, textStyle, resolver, list, startRestartGroup, ((i7 >> 12) & 112) | i16 | ((i9 << 6) & 896));
                                    AnnotatedString annotatedString2 = (AnnotatedString) function02.invoke();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -133802474, str2);
                                    boolean changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i17 & 896) == 256);
                                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                                    if (!changedInstance) {
                                        obj = rememberedValue6;
                                    }
                                    Object obj2 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda18
                                        public final Object invoke(Object obj3) {
                                            Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$34$lambda$33;
                                            LayoutWithLinksAndInlineContent_11Od_4g$lambda$34$lambda$33 = BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$34$lambda$33(TextLinkScope.this, function1, (TextLayoutResult) obj3);
                                            return LayoutWithLinksAndInlineContent_11Od_4g$lambda$34$lambda$33;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(obj2);
                                    obj = obj2;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Composer composer4 = startRestartGroup;
                                    final TextLinkScope textLinkScope2 = textLinkScope;
                                    Modifier m1520textModifierCL7eQgs = m1520textModifierCL7eQgs(modifier, annotatedString2, textStyle, (Function1) obj, i, z2, i2, i3, resolver, list, function14, selectionController, colorProducer, function12, textAutoSize);
                                    if (!z) {
                                        composer4.startReplaceGroup(147770775);
                                        ComposerKt.sourceInformation(composer4, "713@29493L55");
                                        ComposerKt.sourceInformationMarkerStart(composer4, -133777992, str2);
                                        boolean changedInstance2 = composer4.changedInstance(textLinkScope2);
                                        Object rememberedValue7 = composer4.rememberedValue();
                                        if (changedInstance2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue7 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda19
                                                public final Object invoke() {
                                                    boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$37$lambda$36;
                                                    LayoutWithLinksAndInlineContent_11Od_4g$lambda$37$lambda$36 = BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$37$lambda$36(TextLinkScope.this);
                                                    return Boolean.valueOf(LayoutWithLinksAndInlineContent_11Od_4g$lambda$37$lambda$36);
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue7);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        LinksTextMeasurePolicy linksTextMeasurePolicy = new LinksTextMeasurePolicy((Function0) rememberedValue7);
                                        composer4.endReplaceGroup();
                                        textMeasurePolicy = linksTextMeasurePolicy;
                                    } else {
                                        composer4.startReplaceGroup(147947537);
                                        ComposerKt.sourceInformation(composer4, "717@29664L55,718@29754L39");
                                        ComposerKt.sourceInformationMarkerStart(composer4, -133772520, str2);
                                        boolean changedInstance3 = composer4.changedInstance(textLinkScope2);
                                        Object rememberedValue8 = composer4.rememberedValue();
                                        if (changedInstance3 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue8 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda20
                                                public final Object invoke() {
                                                    boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$40$lambda$39;
                                                    LayoutWithLinksAndInlineContent_11Od_4g$lambda$40$lambda$39 = BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$40$lambda$39(TextLinkScope.this);
                                                    return Boolean.valueOf(LayoutWithLinksAndInlineContent_11Od_4g$lambda$40$lambda$39);
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue8);
                                        }
                                        Function0 function03 = (Function0) rememberedValue8;
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -133769656, str2);
                                        boolean changed3 = composer4.changed(mutableState2);
                                        Object rememberedValue9 = composer4.rememberedValue();
                                        if (changed3 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda1
                                                public final Object invoke() {
                                                    List LayoutWithLinksAndInlineContent_11Od_4g$lambda$42$lambda$41;
                                                    LayoutWithLinksAndInlineContent_11Od_4g$lambda$42$lambda$41 = BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$42$lambda$41(MutableState.this);
                                                    return LayoutWithLinksAndInlineContent_11Od_4g$lambda$42$lambda$41;
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue9);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        TextMeasurePolicy textMeasurePolicy2 = new TextMeasurePolicy(function03, (Function0) rememberedValue9);
                                        composer4.endReplaceGroup();
                                        textMeasurePolicy = textMeasurePolicy2;
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                    int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, m1520textModifierCL7eQgs);
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer4);
                                    Updater.m4116setimpl(m4109constructorimpl, textMeasurePolicy, (Function2<? super T, ? super Object, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                                        m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                                    }
                                    Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer4, -433564842, "C:BasicText.kt#423gt5");
                                    if (textLinkScope2 == null) {
                                        composer4.startReplaceGroup(-433557001);
                                        composer4.endReplaceGroup();
                                    } else {
                                        composer4.startReplaceGroup(-291080374);
                                        ComposerKt.sourceInformation(composer4, "687@28455L18");
                                        textLinkScope2.LinksComposables(composer4, 0);
                                        composer4.endReplaceGroup();
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    if (list2 == null) {
                                        composer4.startReplaceGroup(-433506223);
                                        composer4.endReplaceGroup();
                                    } else {
                                        composer4.startReplaceGroup(-433506222);
                                        ComposerKt.sourceInformation(composer4, "*688@28511L48");
                                        AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString, list2, composer4, i16);
                                        Unit unit2 = Unit.INSTANCE;
                                        composer4.endReplaceGroup();
                                        Unit unit3 = Unit.INSTANCE;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    map2 = map4;
                                    composer2 = composer4;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj3, Object obj4) {
                                            Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$43;
                                            LayoutWithLinksAndInlineContent_11Od_4g$lambda$43 = BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$43(Modifier.this, annotatedString, function1, z, map2, textStyle, i, z2, i2, i3, resolver, selectionController, colorProducer, function12, textAutoSize, i4, i5, i6, (Composer) obj3, ((Integer) obj4).intValue());
                                            return LayoutWithLinksAndInlineContent_11Od_4g$lambda$43;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i6 & Fields.Clip) != 0) {
                            }
                            if (!startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i6 & Fields.Shape) == 0) {
                        }
                        if ((i6 & Fields.Clip) != 0) {
                        }
                        if (!startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i6 & Fields.RotationZ) != 0) {
                    }
                    if ((i6 & Fields.CameraDistance) != 0) {
                    }
                    i9 = i8;
                    if ((i6 & Fields.TransformOrigin) != 0) {
                    }
                    if ((i6 & Fields.Shape) == 0) {
                    }
                    if ((i6 & Fields.Clip) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i6 & Fields.RotationY) == 0) {
                }
                if ((i6 & Fields.RotationZ) != 0) {
                }
                if ((i6 & Fields.CameraDistance) != 0) {
                }
                i9 = i8;
                if ((i6 & Fields.TransformOrigin) != 0) {
                }
                if ((i6 & Fields.Shape) == 0) {
                }
                if ((i6 & Fields.Clip) != 0) {
                }
                if (!startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i6 & Fields.RotationX) != 0) {
            }
            if ((i6 & Fields.RotationY) == 0) {
            }
            if ((i6 & Fields.RotationZ) != 0) {
            }
            if ((i6 & Fields.CameraDistance) != 0) {
            }
            i9 = i8;
            if ((i6 & Fields.TransformOrigin) != 0) {
            }
            if ((i6 & Fields.Shape) == 0) {
            }
            if ((i6 & Fields.Clip) != 0) {
            }
            if (!startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i6 & 32) == 0) {
        }
        if ((i6 & 64) == 0) {
        }
        if ((i6 & Fields.SpotShadowColor) == 0) {
        }
        if ((i6 & Fields.RotationX) != 0) {
        }
        if ((i6 & Fields.RotationY) == 0) {
        }
        if ((i6 & Fields.RotationZ) != 0) {
        }
        if ((i6 & Fields.CameraDistance) != 0) {
        }
        i9 = i8;
        if ((i6 & Fields.TransformOrigin) != 0) {
        }
        if ((i6 & Fields.Shape) == 0) {
        }
        if ((i6 & Fields.Clip) != 0) {
        }
        if (!startRestartGroup.shouldExecute((306783379 & i7) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$25$lambda$24(TextLinkScope textLinkScope, AnnotatedString annotatedString) {
        AnnotatedString applyAnnotators$foundation_release;
        return (textLinkScope == null || (applyAnnotators$foundation_release = textLinkScope.applyAnnotators$foundation_release()) == null) ? annotatedString : applyAnnotators$foundation_release;
    }

    public static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$30$lambda$29(MutableState mutableState, List list) {
        if (mutableState != null) {
            mutableState.setValue(list);
        }
        return Unit.INSTANCE;
    }

    public static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$34$lambda$33(TextLinkScope textLinkScope, Function1 function1, TextLayoutResult textLayoutResult) {
        if (textLinkScope != null) {
            textLinkScope.setTextLayoutResult(textLayoutResult);
        }
        if (function1 != null) {
            function1.invoke(textLayoutResult);
        }
        return Unit.INSTANCE;
    }

    public static final boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$37$lambda$36(TextLinkScope textLinkScope) {
        if (textLinkScope != null) {
            return ((Boolean) textLinkScope.getShouldMeasureLinks().invoke()).booleanValue();
        }
        return false;
    }

    public static final boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$40$lambda$39(TextLinkScope textLinkScope) {
        if (textLinkScope != null) {
            return ((Boolean) textLinkScope.getShouldMeasureLinks().invoke()).booleanValue();
        }
        return false;
    }

    public static final List LayoutWithLinksAndInlineContent_11Od_4g$lambda$42$lambda$41(MutableState mutableState) {
        if (mutableState != null) {
            return (List) mutableState.getValue();
        }
        return null;
    }
}
