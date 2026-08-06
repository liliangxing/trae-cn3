package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.AlphaKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.geometry.SizeKt;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shadow;
import androidx.compose.p002ui.graphics.drawscope.DrawStyle;
import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.LayoutIdKt;
import androidx.compose.p002ui.layout.LayoutIdParentData;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0002\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b42\u0006\u00105\u001a\u0002062\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001¢\u0006\u0002\u0010I\u001a9\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u0012\u0010R\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u0012\u0010U\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u001c\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010A\u001a\u00020?2\u0006\u0010W\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007\"\u0016\u0010\u0011\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0016\u0010\u0013\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0019\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007\"\u000e\u0010\u001b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010 \u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b!\u0010\u0007\"\u000e\u0010\"\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010#\u001a\u00020$X\u0080\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006X"}, d2 = {"AnimationDuration", "", "ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "MinTextLineHeight", "getMinTextLineHeight", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "PrefixId", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "SuffixId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-KTwxG1Y", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String ContainerId = "Container";
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding;
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float HorizontalIconPadding = Dp.constructor-impl(12);
    private static final float SupportingTopPadding = Dp.constructor-impl(4);
    private static final float PrefixSuffixTextPadding = Dp.constructor-impl(2);
    private static final float MinTextLineHeight = Dp.constructor-impl(24);

    /* JADX WARN: Removed duplicated region for block: B:100:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CommonDecorationBox(final TextFieldType textFieldType, final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, boolean z, boolean z2, boolean z3, final InteractionSource interactionSource, final PaddingValues paddingValues, final TextFieldColors textFieldColors, final Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
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
        boolean z4;
        Object rememberedValue;
        InputPhase inputPhase;
        final boolean z5;
        Composer composer2;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final boolean z7;
        final boolean z8;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-947035500);
        ComposerKt.sourceInformation(startRestartGroup, "C(CommonDecorationBox)P(15,16,4,17,7,9,8,14,10,12,13,11,3,6,5,2)80@3145L105,84@3300L25,95@3684L10,102@4027L6900:TextFieldImpl.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(textFieldType) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i18 = i3 & 4;
        int i19 = Fields.RotationX;
        if (i18 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
            i5 = i3 & 8;
            int i20 = Fields.RotationZ;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(visualTransformation) ? Fields.CameraDistance : 1024;
            }
            i6 = i3 & 16;
            int i21 = Fields.Clip;
            if (i6 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
            }
            i7 = i3 & 32;
            if (i7 == 0) {
                i4 |= 196608;
            } else if ((i & 196608) == 0) {
                i4 |= startRestartGroup.changedInstance(function23) ? Fields.RenderEffect : 65536;
            }
            i8 = i3 & 64;
            if (i8 == 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i4 |= startRestartGroup.changedInstance(function24) ? 1048576 : Fields.BlendMode;
            }
            i9 = i3 & Fields.SpotShadowColor;
            if (i9 == 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i4 |= startRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
            }
            i10 = i3 & Fields.RotationX;
            if (i10 == 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i4 |= startRestartGroup.changedInstance(function26) ? 67108864 : 33554432;
            }
            i11 = i3 & Fields.RotationY;
            if (i11 == 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                i4 |= startRestartGroup.changedInstance(function27) ? 536870912 : 268435456;
            }
            i12 = i3 & Fields.RotationZ;
            if (i12 == 0) {
                i13 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                i13 = i2 | (startRestartGroup.changedInstance(function28) ? 4 : 2);
            } else {
                i13 = i2;
            }
            i14 = i3 & Fields.CameraDistance;
            if (i14 == 0) {
                i13 |= 48;
            } else if ((i2 & 48) == 0) {
                i13 |= startRestartGroup.changed(z) ? 32 : 16;
            }
            i15 = i13;
            i16 = i3 & Fields.TransformOrigin;
            if (i16 == 0) {
                i15 |= 384;
            } else if ((i2 & 384) == 0) {
                if (!startRestartGroup.changed(z2)) {
                    i19 = 128;
                }
                i15 |= i19;
                i17 = i3 & Fields.Shape;
                if (i17 != 0) {
                    i15 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    if (startRestartGroup.changed(z3)) {
                        i20 = Fields.CameraDistance;
                    }
                    i15 |= i20;
                    if ((i3 & Fields.Clip) == 0) {
                        i15 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        if (!startRestartGroup.changed(interactionSource)) {
                            i21 = 8192;
                        }
                        i15 |= i21;
                    }
                    if ((32768 & i3) == 0) {
                        i15 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i15 |= startRestartGroup.changed(paddingValues) ? Fields.RenderEffect : 65536;
                        if ((i3 & 65536) != 0) {
                            i15 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i15 |= startRestartGroup.changed(textFieldColors) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i3 & Fields.RenderEffect) != 0) {
                            i15 |= 12582912;
                        } else if ((i2 & 12582912) == 0) {
                            i15 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                        if ((i4 & 306783379) == 306783378 || (4793491 & i15) != 4793490 || !startRestartGroup.getSkipping()) {
                            Function2<? super Composer, ? super Integer, Unit> function216 = i7 != 0 ? null : function23;
                            Function2<? super Composer, ? super Integer, Unit> function217 = i8 != 0 ? null : function24;
                            Function2<? super Composer, ? super Integer, Unit> function218 = i9 != 0 ? null : function25;
                            Function2<? super Composer, ? super Integer, Unit> function219 = i10 != 0 ? null : function26;
                            Function2<? super Composer, ? super Integer, Unit> function220 = i11 != 0 ? null : function27;
                            Function2<? super Composer, ? super Integer, Unit> function221 = i12 == 0 ? function28 : null;
                            boolean z9 = i14 != 0 ? false : z;
                            final boolean z10 = i16 != 0 ? true : z2;
                            final boolean z11 = i17 != 0 ? false : z3;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i15, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:79)");
                            }
                            startRestartGroup.startReplaceableGroup(-646389284);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
                            z4 = ((i4 & 7168) == 2048) | ((i4 & 112) == 32);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = visualTransformation.filter(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final String text = ((TransformedText) rememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i15 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else {
                                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
                            }
                            InputPhase inputPhase2 = inputPhase;
                            Function3<InputPhase, Composer, Integer, Color> function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return Color.m4829boximpl(m3192invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
                                }

                                /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                                public final long m3192invokeXeAY9LY(InputPhase inputPhase3, Composer composer3, int i22) {
                                    composer3.startReplaceableGroup(-502832279);
                                    ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-502832279, i22, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                                    }
                                    long m4849unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceableGroup();
                                    return m4849unboximpl;
                                }
                            };
                            Typography typography = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                            final TextStyle bodyLarge = typography.getBodyLarge();
                            final TextStyle bodySmall = typography.getBodySmall();
                            z5 = !(Color.m4840equalsimpl0(bodyLarge.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU()) || Color.m4840equalsimpl0(bodySmall.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU())) || (!Color.m4840equalsimpl0(bodyLarge.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU()) && Color.m4840equalsimpl0(bodySmall.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU()));
                            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
                            startRestartGroup.startReplaceableGroup(-646388325);
                            ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
                            long j = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getColor-0d7_KjU();
                            startRestartGroup.startReplaceableGroup(-646388264);
                            ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
                            if (z5) {
                                if (!(j != Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
                                    j = ((Color) function3.invoke(inputPhase2, startRestartGroup, 0)).m4849unboximpl();
                                }
                            }
                            long j2 = j;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-646388132);
                            ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
                            long j3 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().getColor-0d7_KjU();
                            startRestartGroup.startReplaceableGroup(-646388071);
                            ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
                            if (z5) {
                                if (!(j3 != Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
                                    j3 = ((Color) function3.invoke(inputPhase2, startRestartGroup, 0)).m4849unboximpl();
                                }
                            }
                            long j4 = j3;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            final boolean z12 = z10;
                            final boolean z13 = z11;
                            final Function2<? super Composer, ? super Integer, Unit> function222 = function216;
                            boolean z14 = z10;
                            final Function2<? super Composer, ? super Integer, Unit> function223 = function219;
                            composer2 = startRestartGroup;
                            final Function2<? super Composer, ? super Integer, Unit> function224 = function220;
                            boolean z15 = z11;
                            final Function2<? super Composer, ? super Integer, Unit> function225 = function217;
                            final Function2<? super Composer, ? super Integer, Unit> function226 = function218;
                            final Function2<? super Composer, ? super Integer, Unit> function227 = function221;
                            final boolean z16 = z9;
                            textFieldTransitionScope.m3197TransitionDTcfvLk(inputPhase2, j2, j4, function3, function22 != null, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                                /* compiled from: TextFieldImpl.kt */
                                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                public /* synthetic */ class WhenMappings {
                                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                    static {
                                        int[] iArr = new int[TextFieldType.values().length];
                                        try {
                                            iArr[TextFieldType.Filled.ordinal()] = 1;
                                        } catch (NoSuchFieldError unused) {
                                        }
                                        try {
                                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                                        } catch (NoSuchFieldError unused2) {
                                        }
                                        $EnumSwitchMapping$0 = iArr;
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(7);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                                    m3190invokeeopBjH0(((Number) obj).floatValue(), ((Color) obj2).m4849unboximpl(), ((Color) obj3).m4849unboximpl(), ((Number) obj4).floatValue(), ((Number) obj5).floatValue(), (Composer) obj6, ((Number) obj7).intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:100:0x01dd  */
                                /* JADX WARN: Removed duplicated region for block: B:101:0x01a5  */
                                /* JADX WARN: Removed duplicated region for block: B:68:0x0195  */
                                /* JADX WARN: Removed duplicated region for block: B:71:0x01cd  */
                                /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
                                /* JADX WARN: Removed duplicated region for block: B:77:0x0226  */
                                /* JADX WARN: Removed duplicated region for block: B:82:0x0332  */
                                /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
                                /* JADX WARN: Removed duplicated region for block: B:98:0x02e2  */
                                /* JADX WARN: Removed duplicated region for block: B:99:0x0218  */
                                /* renamed from: invoke-eopBjH0, reason: not valid java name */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void m3190invokeeopBjH0(final float f, final long j5, final long j6, final float f2, final float f3, Composer composer3, int i22) {
                                    int i23;
                                    boolean z17;
                                    ComposableLambda composableLambda;
                                    ComposableLambda composableLambda2;
                                    ComposableLambda composableLambda3;
                                    ComposableLambda composableLambda4;
                                    final Function2<Composer, Integer, Unit> function228;
                                    ComposableLambda composableLambda5;
                                    int i24;
                                    ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                                    if ((i22 & 6) == 0) {
                                        i23 = (composer3.changed(f) ? 4 : 2) | i22;
                                    } else {
                                        i23 = i22;
                                    }
                                    if ((i22 & 48) == 0) {
                                        i23 |= composer3.changed(j5) ? 32 : 16;
                                    }
                                    if ((i22 & 384) == 0) {
                                        i23 |= composer3.changed(j6) ? Fields.RotationX : Fields.SpotShadowColor;
                                    }
                                    if ((i22 & 3072) == 0) {
                                        i23 |= composer3.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
                                    }
                                    if ((i22 & 24576) == 0) {
                                        i23 |= composer3.changed(f3) ? Fields.Clip : Fields.Shape;
                                    }
                                    int i25 = i23;
                                    if ((74899 & i25) != 74898 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1290853831, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                                        }
                                        final Function2<Composer, Integer, Unit> function229 = function22;
                                        if (function229 != null) {
                                            final boolean z18 = z5;
                                            z17 = true;
                                            composableLambda = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i26) {
                                                    ComposerKt.sourceInformation(composer4, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                                    if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-382297919, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                                        }
                                                        TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodySmall(), f);
                                                        TextFieldImplKt.m3189DecorationKTwxG1Y(j6, z18 ? TextStyle.copy-p1EtxEg$default(lerp, j5, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null) : lerp, function229, composer4, 0, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            });
                                        } else {
                                            z17 = true;
                                            composableLambda = null;
                                        }
                                        final long m4849unboximpl = textFieldColors.placeholderColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        if (function222 != null) {
                                            if ((text.length() == 0 ? z17 : false) && f2 > 0.0f) {
                                                final Function2<Composer, Integer, Unit> function230 = function222;
                                                composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -524658155, z17, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                        invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Modifier modifier, Composer composer4, int i26) {
                                                        ComposerKt.sourceInformation(composer4, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                                        if ((i26 & 6) == 0) {
                                                            i26 |= composer4.changed(modifier) ? 4 : 2;
                                                        }
                                                        if ((i26 & 19) != 18 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-524658155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                                            }
                                                            Modifier alpha = AlphaKt.alpha(modifier, f2);
                                                            long j7 = m4849unboximpl;
                                                            Function2<Composer, Integer, Unit> function231 = function230;
                                                            composer4.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                            composer4.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                            composer4.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer4, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                                            TextFieldImplKt.m3189DecorationKTwxG1Y(j7, MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), function231, composer4, 0, 0);
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                                            composer4.endReplaceableGroup();
                                                            composer4.endNode();
                                                            composer4.endReplaceableGroup();
                                                            composer4.endReplaceableGroup();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                });
                                                final long m4849unboximpl2 = textFieldColors.prefixColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                                if (function223 != null || f3 <= 0.0f) {
                                                    composableLambda3 = null;
                                                } else {
                                                    final TextStyle textStyle = bodyLarge;
                                                    final Function2<Composer, Integer, Unit> function231 = function223;
                                                    composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 1824482619, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i26) {
                                                            ComposerKt.sourceInformation(composer4, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1824482619, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                                                }
                                                                Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                                long j7 = m4849unboximpl2;
                                                                TextStyle textStyle2 = textStyle;
                                                                Function2<Composer, Integer, Unit> function232 = function231;
                                                                composer4.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                                composer4.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                }
                                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                                composer4.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                                                TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle2, function232, composer4, 0, 0);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                composer4.endReplaceableGroup();
                                                                composer4.endNode();
                                                                composer4.endReplaceableGroup();
                                                                composer4.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    });
                                                }
                                                final long m4849unboximpl3 = textFieldColors.suffixColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                                if (function224 != null || f3 <= 0.0f) {
                                                    composableLambda4 = null;
                                                } else {
                                                    final TextStyle textStyle2 = bodyLarge;
                                                    final Function2<Composer, Integer, Unit> function232 = function224;
                                                    composableLambda4 = ComposableLambdaKt.composableLambda(composer3, 907456412, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i26) {
                                                            ComposerKt.sourceInformation(composer4, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(907456412, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                                }
                                                                Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                                long j7 = m4849unboximpl3;
                                                                TextStyle textStyle3 = textStyle2;
                                                                Function2<Composer, Integer, Unit> function233 = function232;
                                                                composer4.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                                composer4.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                }
                                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                                composer4.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                                                TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle3, function233, composer4, 0, 0);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                composer4.endReplaceableGroup();
                                                                composer4.endNode();
                                                                composer4.endReplaceableGroup();
                                                                composer4.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    });
                                                }
                                                final long m4849unboximpl4 = textFieldColors.leadingIconColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                                final Function2<Composer, Integer, Unit> function233 = function225;
                                                ComposableLambda composableLambda6 = function233 == null ? ComposableLambdaKt.composableLambda(composer3, 90769583, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i26) {
                                                        ComposerKt.sourceInformation(composer4, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                                        if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(90769583, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                                        }
                                                        TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl4, null, function233, composer4, 0, 2);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }) : null;
                                                final long m4849unboximpl5 = textFieldColors.trailingIconColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                                final Function2<Composer, Integer, Unit> function234 = function226;
                                                ComposableLambda composableLambda7 = function234 == null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i26) {
                                                        ComposerKt.sourceInformation(composer4, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                                        if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2077796155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                                        }
                                                        TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl5, null, function234, composer4, 0, 2);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }) : null;
                                                final long m4849unboximpl6 = textFieldColors.supportingTextColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                                function228 = function227;
                                                if (function228 == null) {
                                                    final TextStyle textStyle3 = bodySmall;
                                                    composableLambda5 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i26) {
                                                            ComposerKt.sourceInformation(composer4, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                                            if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1531019900, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                                            }
                                                            TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl6, textStyle3, function228, composer4, 0, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    });
                                                } else {
                                                    composableLambda5 = null;
                                                }
                                                i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                                if (i24 != z17) {
                                                    composer3.startReplaceableGroup(404042583);
                                                    ComposerKt.sourceInformation(composer3, "204@8500L667");
                                                    final Function2<Composer, Integer, Unit> function235 = function29;
                                                    TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, composableLambda, composableLambda2, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z16, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i26) {
                                                            ComposerKt.sourceInformation(composer4, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-2124779163, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                                                }
                                                                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                                Function2<Composer, Integer, Unit> function236 = function235;
                                                                composer4.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                                composer4.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                }
                                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                                composer4.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                                                function236.invoke(composer4, 0);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                composer4.endReplaceableGroup();
                                                                composer4.endNode();
                                                                composer4.endReplaceableGroup();
                                                                composer4.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 6);
                                                    composer3.endReplaceableGroup();
                                                } else if (i24 == 2) {
                                                    composer3.startReplaceableGroup(404043576);
                                                    ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                                    composer3.startReplaceableGroup(404043645);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                                    Object rememberedValue2 = composer3.rememberedValue();
                                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m4650boximpl(Size.INSTANCE.m4671getZeroNHjbRc()), null, 2, null);
                                                        composer3.updateRememberedValue(rememberedValue2);
                                                    }
                                                    final MutableState mutableState = (MutableState) rememberedValue2;
                                                    composer3.endReplaceableGroup();
                                                    final PaddingValues paddingValues2 = paddingValues;
                                                    final Function2<Composer, Integer, Unit> function236 = function29;
                                                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i26) {
                                                            ComposerKt.sourceInformation(composer4, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1902535592, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                                                }
                                                                Modifier m2781outlineCutout12SF9DM = OutlinedTextFieldKt.m2781outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().m4667unboximpl(), paddingValues2);
                                                                Function2<Composer, Integer, Unit> function237 = function236;
                                                                composer4.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                                composer4.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2781outlineCutout12SF9DM);
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
                                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                }
                                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                                composer4.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                                                function237.invoke(composer4, 0);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                composer4.endReplaceableGroup();
                                                                composer4.endNode();
                                                                composer4.endReplaceableGroup();
                                                                composer4.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    });
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    Function2<Composer, Integer, Unit> function237 = function2;
                                                    boolean z19 = z16;
                                                    composer3.startReplaceableGroup(404044653);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                                    boolean z20 = (i25 & 14) == 4;
                                                    Object rememberedValue3 = composer3.rememberedValue();
                                                    if (z20 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                                m3191invokeuvyYCjk(((Size) obj).m4667unboximpl());
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                            public final void m3191invokeuvyYCjk(long j7) {
                                                                float m4662getWidthimpl = Size.m4662getWidthimpl(j7) * f;
                                                                float m4659getHeightimpl = Size.m4659getHeightimpl(j7) * f;
                                                                if (Size.m4662getWidthimpl(mutableState.getValue().m4667unboximpl()) == m4662getWidthimpl) {
                                                                    if (Size.m4659getHeightimpl(mutableState.getValue().m4667unboximpl()) == m4659getHeightimpl) {
                                                                        return;
                                                                    }
                                                                }
                                                                mutableState.setValue(Size.m4650boximpl(SizeKt.Size(m4662getWidthimpl, m4659getHeightimpl)));
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(rememberedValue3);
                                                    }
                                                    composer3.endReplaceableGroup();
                                                    OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function237, composableLambda2, composableLambda, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z19, f, (Function1) rememberedValue3, composableLambda8, composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 48);
                                                    composer3.endReplaceableGroup();
                                                } else {
                                                    composer3.startReplaceableGroup(404045277);
                                                    composer3.endReplaceableGroup();
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    return;
                                                }
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                        }
                                        composableLambda2 = null;
                                        final long m4849unboximpl22 = textFieldColors.prefixColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        if (function223 != null) {
                                        }
                                        composableLambda3 = null;
                                        final long m4849unboximpl32 = textFieldColors.suffixColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        if (function224 != null) {
                                        }
                                        composableLambda4 = null;
                                        final long m4849unboximpl42 = textFieldColors.leadingIconColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        final Function2<? super Composer, ? super Integer, Unit> function2332 = function225;
                                        if (function2332 == null) {
                                        }
                                        final long m4849unboximpl52 = textFieldColors.trailingIconColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        final Function2<? super Composer, ? super Integer, Unit> function2342 = function226;
                                        if (function2342 == null) {
                                        }
                                        final long m4849unboximpl62 = textFieldColors.supportingTextColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        function228 = function227;
                                        if (function228 == null) {
                                        }
                                        i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                        if (i24 != z17) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                    } else {
                                        composer3.skipToGroupEnd();
                                    }
                                }
                            }), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z15;
                            function210 = function221;
                            function211 = function216;
                            function212 = function217;
                            function213 = function218;
                            function214 = function219;
                            function215 = function220;
                            z7 = z9;
                            z8 = z14;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function211 = function23;
                            function212 = function24;
                            function213 = function25;
                            function214 = function26;
                            function215 = function27;
                            function210 = function28;
                            z7 = z;
                            z6 = z3;
                            composer2 = startRestartGroup;
                            z8 = z2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i22) {
                                    TextFieldImplKt.CommonDecorationBox(TextFieldType.this, str, function2, visualTransformation, function22, function211, function212, function213, function214, function215, function210, z7, z8, z6, interactionSource, paddingValues, textFieldColors, function29, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 65536) != 0) {
                    }
                    if ((i3 & Fields.RenderEffect) != 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-646389284);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    z4 = ((i4 & 7168) == 2048) | ((i4 & 112) == 32);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z4) {
                    }
                    rememberedValue = visualTransformation.filter(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    final String text2 = ((TransformedText) rememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i15 >> 12) & 14).getValue().booleanValue()) {
                    }
                    InputPhase inputPhase22 = inputPhase;
                    Function3<InputPhase, Composer, Integer, Color> function32 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return Color.m4829boximpl(m3192invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
                        }

                        /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                        public final long m3192invokeXeAY9LY(InputPhase inputPhase3, Composer composer3, int i22) {
                            composer3.startReplaceableGroup(-502832279);
                            ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-502832279, i22, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                            }
                            long m4849unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceableGroup();
                            return m4849unboximpl;
                        }
                    };
                    Typography typography2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    final TextStyle bodyLarge2 = typography2.getBodyLarge();
                    final TextStyle bodySmall2 = typography2.getBodySmall();
                    if (Color.m4840equalsimpl0(bodyLarge2.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope2 = TextFieldTransitionScope.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-646388325);
                    ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
                    long j5 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getColor-0d7_KjU();
                    startRestartGroup.startReplaceableGroup(-646388264);
                    ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
                    if (z5) {
                    }
                    long j22 = j5;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-646388132);
                    ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
                    long j32 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().getColor-0d7_KjU();
                    startRestartGroup.startReplaceableGroup(-646388071);
                    ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
                    if (z5) {
                    }
                    long j42 = j32;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    final boolean z122 = z10;
                    final boolean z132 = z11;
                    final Function2<? super Composer, ? super Integer, Unit> function2222 = function216;
                    boolean z142 = z10;
                    final Function2<? super Composer, ? super Integer, Unit> function2232 = function219;
                    composer2 = startRestartGroup;
                    final Function2<? super Composer, ? super Integer, Unit> function2242 = function220;
                    boolean z152 = z11;
                    final Function2<? super Composer, ? super Integer, Unit> function2252 = function217;
                    final Function2<? super Composer, ? super Integer, Unit> function2262 = function218;
                    final Function2<? super Composer, ? super Integer, Unit> function2272 = function221;
                    final boolean z162 = z9;
                    textFieldTransitionScope2.m3197TransitionDTcfvLk(inputPhase22, j22, j42, function32, function22 != null, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                        /* compiled from: TextFieldImpl.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[TextFieldType.values().length];
                                try {
                                    iArr[TextFieldType.Filled.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[TextFieldType.Outlined.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(7);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                            m3190invokeeopBjH0(((Number) obj).floatValue(), ((Color) obj2).m4849unboximpl(), ((Color) obj3).m4849unboximpl(), ((Number) obj4).floatValue(), ((Number) obj5).floatValue(), (Composer) obj6, ((Number) obj7).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:100:0x01dd  */
                        /* JADX WARN: Removed duplicated region for block: B:101:0x01a5  */
                        /* JADX WARN: Removed duplicated region for block: B:68:0x0195  */
                        /* JADX WARN: Removed duplicated region for block: B:71:0x01cd  */
                        /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
                        /* JADX WARN: Removed duplicated region for block: B:77:0x0226  */
                        /* JADX WARN: Removed duplicated region for block: B:82:0x0332  */
                        /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:98:0x02e2  */
                        /* JADX WARN: Removed duplicated region for block: B:99:0x0218  */
                        /* renamed from: invoke-eopBjH0, reason: not valid java name */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void m3190invokeeopBjH0(final float f, final long j52, final long j6, final float f2, final float f3, Composer composer3, int i22) {
                            int i23;
                            boolean z17;
                            ComposableLambda composableLambda;
                            ComposableLambda composableLambda2;
                            ComposableLambda composableLambda3;
                            ComposableLambda composableLambda4;
                            final Function2<? super Composer, ? super Integer, Unit> function228;
                            ComposableLambda composableLambda5;
                            int i24;
                            ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                            if ((i22 & 6) == 0) {
                                i23 = (composer3.changed(f) ? 4 : 2) | i22;
                            } else {
                                i23 = i22;
                            }
                            if ((i22 & 48) == 0) {
                                i23 |= composer3.changed(j52) ? 32 : 16;
                            }
                            if ((i22 & 384) == 0) {
                                i23 |= composer3.changed(j6) ? Fields.RotationX : Fields.SpotShadowColor;
                            }
                            if ((i22 & 3072) == 0) {
                                i23 |= composer3.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
                            }
                            if ((i22 & 24576) == 0) {
                                i23 |= composer3.changed(f3) ? Fields.Clip : Fields.Shape;
                            }
                            int i25 = i23;
                            if ((74899 & i25) != 74898 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1290853831, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function229 = function22;
                                if (function229 != null) {
                                    final boolean z18 = z5;
                                    z17 = true;
                                    composableLambda = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-382297919, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                                }
                                                TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodySmall(), f);
                                                TextFieldImplKt.m3189DecorationKTwxG1Y(j6, z18 ? TextStyle.copy-p1EtxEg$default(lerp, j52, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null) : lerp, function229, composer4, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    });
                                } else {
                                    z17 = true;
                                    composableLambda = null;
                                }
                                final long m4849unboximpl = textFieldColors.placeholderColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                if (function2222 != null) {
                                    if ((text2.length() == 0 ? z17 : false) && f2 > 0.0f) {
                                        final Function2<? super Composer, ? super Integer, Unit> function230 = function2222;
                                        composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -524658155, z17, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Modifier modifier, Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                                if ((i26 & 6) == 0) {
                                                    i26 |= composer4.changed(modifier) ? 4 : 2;
                                                }
                                                if ((i26 & 19) != 18 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-524658155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                                    }
                                                    Modifier alpha = AlphaKt.alpha(modifier, f2);
                                                    long j7 = m4849unboximpl;
                                                    Function2<Composer, Integer, Unit> function231 = function230;
                                                    composer4.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                                    TextFieldImplKt.m3189DecorationKTwxG1Y(j7, MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), function231, composer4, 0, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        });
                                        final long m4849unboximpl22 = textFieldColors.prefixColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        if (function2232 != null || f3 <= 0.0f) {
                                            composableLambda3 = null;
                                        } else {
                                            final TextStyle textStyle = bodyLarge2;
                                            final Function2<? super Composer, ? super Integer, Unit> function231 = function2232;
                                            composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 1824482619, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i26) {
                                                    ComposerKt.sourceInformation(composer4, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                                    if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1824482619, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                                        }
                                                        Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                        long j7 = m4849unboximpl22;
                                                        TextStyle textStyle2 = textStyle;
                                                        Function2<Composer, Integer, Unit> function232 = function231;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                        composer4.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                        composer4.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                                        TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle2, function232, composer4, 0, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endReplaceableGroup();
                                                        composer4.endNode();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            });
                                        }
                                        final long m4849unboximpl32 = textFieldColors.suffixColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        if (function2242 != null || f3 <= 0.0f) {
                                            composableLambda4 = null;
                                        } else {
                                            final TextStyle textStyle2 = bodyLarge2;
                                            final Function2<? super Composer, ? super Integer, Unit> function232 = function2242;
                                            composableLambda4 = ComposableLambdaKt.composableLambda(composer3, 907456412, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i26) {
                                                    ComposerKt.sourceInformation(composer4, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                                    if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(907456412, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                        }
                                                        Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                        long j7 = m4849unboximpl32;
                                                        TextStyle textStyle3 = textStyle2;
                                                        Function2<Composer, Integer, Unit> function233 = function232;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                        composer4.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                        composer4.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                                        TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle3, function233, composer4, 0, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endReplaceableGroup();
                                                        composer4.endNode();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            });
                                        }
                                        final long m4849unboximpl42 = textFieldColors.leadingIconColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        final Function2<? super Composer, ? super Integer, Unit> function2332 = function2252;
                                        ComposableLambda composableLambda6 = function2332 == null ? ComposableLambdaKt.composableLambda(composer3, 90769583, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                                if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(90769583, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                                }
                                                TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl42, null, function2332, composer4, 0, 2);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }) : null;
                                        final long m4849unboximpl52 = textFieldColors.trailingIconColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        final Function2<? super Composer, ? super Integer, Unit> function2342 = function2262;
                                        ComposableLambda composableLambda7 = function2342 == null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                                if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2077796155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                                }
                                                TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl52, null, function2342, composer4, 0, 2);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }) : null;
                                        final long m4849unboximpl62 = textFieldColors.supportingTextColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                        function228 = function2272;
                                        if (function228 == null) {
                                            final TextStyle textStyle3 = bodySmall2;
                                            composableLambda5 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i26) {
                                                    ComposerKt.sourceInformation(composer4, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                                    if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1531019900, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                                    }
                                                    TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl62, textStyle3, function228, composer4, 0, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                        } else {
                                            composableLambda5 = null;
                                        }
                                        i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                        if (i24 != z17) {
                                            composer3.startReplaceableGroup(404042583);
                                            ComposerKt.sourceInformation(composer3, "204@8500L667");
                                            final Function2<? super Composer, ? super Integer, Unit> function235 = function29;
                                            TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, composableLambda, composableLambda2, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z162, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i26) {
                                                    ComposerKt.sourceInformation(composer4, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                                    if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2124779163, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                                        }
                                                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                        Function2<Composer, Integer, Unit> function236 = function235;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                        composer4.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                        composer4.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                                        function236.invoke(composer4, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endReplaceableGroup();
                                                        composer4.endNode();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 6);
                                            composer3.endReplaceableGroup();
                                        } else if (i24 == 2) {
                                            composer3.startReplaceableGroup(404043576);
                                            ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                            composer3.startReplaceableGroup(404043645);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                            Object rememberedValue2 = composer3.rememberedValue();
                                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m4650boximpl(Size.INSTANCE.m4671getZeroNHjbRc()), null, 2, null);
                                                composer3.updateRememberedValue(rememberedValue2);
                                            }
                                            final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                            composer3.endReplaceableGroup();
                                            final PaddingValues paddingValues2 = paddingValues;
                                            final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                                            ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i26) {
                                                    ComposerKt.sourceInformation(composer4, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                                    if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1902535592, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                                        }
                                                        Modifier m2781outlineCutout12SF9DM = OutlinedTextFieldKt.m2781outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().m4667unboximpl(), paddingValues2);
                                                        Function2<Composer, Integer, Unit> function237 = function236;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                        composer4.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2781outlineCutout12SF9DM);
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
                                                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                        composer4.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                                        function237.invoke(composer4, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endReplaceableGroup();
                                                        composer4.endNode();
                                                        composer4.endReplaceableGroup();
                                                        composer4.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            });
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            Function2<Composer, Integer, Unit> function237 = function2;
                                            boolean z19 = z162;
                                            composer3.startReplaceableGroup(404044653);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                            boolean z20 = (i25 & 14) == 4;
                                            Object rememberedValue3 = composer3.rememberedValue();
                                            if (z20 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        m3191invokeuvyYCjk(((Size) obj).m4667unboximpl());
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                    public final void m3191invokeuvyYCjk(long j7) {
                                                        float m4662getWidthimpl = Size.m4662getWidthimpl(j7) * f;
                                                        float m4659getHeightimpl = Size.m4659getHeightimpl(j7) * f;
                                                        if (Size.m4662getWidthimpl(mutableState.getValue().m4667unboximpl()) == m4662getWidthimpl) {
                                                            if (Size.m4659getHeightimpl(mutableState.getValue().m4667unboximpl()) == m4659getHeightimpl) {
                                                                return;
                                                            }
                                                        }
                                                        mutableState.setValue(Size.m4650boximpl(SizeKt.Size(m4662getWidthimpl, m4659getHeightimpl)));
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue3);
                                            }
                                            composer3.endReplaceableGroup();
                                            OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function237, composableLambda2, composableLambda, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z19, f, (Function1) rememberedValue3, composableLambda8, composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 48);
                                            composer3.endReplaceableGroup();
                                        } else {
                                            composer3.startReplaceableGroup(404045277);
                                            composer3.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            return;
                                        }
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                }
                                composableLambda2 = null;
                                final long m4849unboximpl222 = textFieldColors.prefixColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                if (function2232 != null) {
                                }
                                composableLambda3 = null;
                                final long m4849unboximpl322 = textFieldColors.suffixColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                if (function2242 != null) {
                                }
                                composableLambda4 = null;
                                final long m4849unboximpl422 = textFieldColors.leadingIconColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function23322 = function2252;
                                if (function23322 == null) {
                                }
                                final long m4849unboximpl522 = textFieldColors.trailingIconColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function23422 = function2262;
                                if (function23422 == null) {
                                }
                                final long m4849unboximpl622 = textFieldColors.supportingTextColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                function228 = function2272;
                                if (function228 == null) {
                                }
                                i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                if (i24 != z17) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            } else {
                                composer3.skipToGroupEnd();
                            }
                        }
                    }), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z6 = z152;
                    function210 = function221;
                    function211 = function216;
                    function212 = function217;
                    function213 = function218;
                    function214 = function219;
                    function215 = function220;
                    z7 = z9;
                    z8 = z142;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i3 & Fields.Clip) == 0) {
                }
                if ((32768 & i3) == 0) {
                }
                if ((i3 & 65536) != 0) {
                }
                if ((i3 & Fields.RenderEffect) != 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 == 0) {
                }
                if (i14 != 0) {
                }
                if (i16 != 0) {
                }
                if (i17 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-646389284);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                z4 = ((i4 & 7168) == 2048) | ((i4 & 112) == 32);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z4) {
                }
                rememberedValue = visualTransformation.filter(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                final String text22 = ((TransformedText) rememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i15 >> 12) & 14).getValue().booleanValue()) {
                }
                InputPhase inputPhase222 = inputPhase;
                Function3<InputPhase, Composer, Integer, Color> function322 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return Color.m4829boximpl(m3192invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
                    }

                    /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                    public final long m3192invokeXeAY9LY(InputPhase inputPhase3, Composer composer3, int i22) {
                        composer3.startReplaceableGroup(-502832279);
                        ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-502832279, i22, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                        }
                        long m4849unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4849unboximpl();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceableGroup();
                        return m4849unboximpl;
                    }
                };
                Typography typography22 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                final TextStyle bodyLarge22 = typography22.getBodyLarge();
                final TextStyle bodySmall22 = typography22.getBodySmall();
                if (Color.m4840equalsimpl0(bodyLarge22.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope22 = TextFieldTransitionScope.INSTANCE;
                startRestartGroup.startReplaceableGroup(-646388325);
                ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
                long j52 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getColor-0d7_KjU();
                startRestartGroup.startReplaceableGroup(-646388264);
                ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
                if (z5) {
                }
                long j222 = j52;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-646388132);
                ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
                long j322 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().getColor-0d7_KjU();
                startRestartGroup.startReplaceableGroup(-646388071);
                ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
                if (z5) {
                }
                long j422 = j322;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                final boolean z1222 = z10;
                final boolean z1322 = z11;
                final Function2<? super Composer, ? super Integer, Unit> function22222 = function216;
                boolean z1422 = z10;
                final Function2<? super Composer, ? super Integer, Unit> function22322 = function219;
                composer2 = startRestartGroup;
                final Function2<? super Composer, ? super Integer, Unit> function22422 = function220;
                boolean z1522 = z11;
                final Function2<? super Composer, ? super Integer, Unit> function22522 = function217;
                final Function2<? super Composer, ? super Integer, Unit> function22622 = function218;
                final Function2<? super Composer, ? super Integer, Unit> function22722 = function221;
                final boolean z1622 = z9;
                textFieldTransitionScope22.m3197TransitionDTcfvLk(inputPhase222, j222, j422, function322, function22 != null, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                    /* compiled from: TextFieldImpl.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[TextFieldType.values().length];
                            try {
                                iArr[TextFieldType.Filled.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[TextFieldType.Outlined.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(7);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                        m3190invokeeopBjH0(((Number) obj).floatValue(), ((Color) obj2).m4849unboximpl(), ((Color) obj3).m4849unboximpl(), ((Number) obj4).floatValue(), ((Number) obj5).floatValue(), (Composer) obj6, ((Number) obj7).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:100:0x01dd  */
                    /* JADX WARN: Removed duplicated region for block: B:101:0x01a5  */
                    /* JADX WARN: Removed duplicated region for block: B:68:0x0195  */
                    /* JADX WARN: Removed duplicated region for block: B:71:0x01cd  */
                    /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
                    /* JADX WARN: Removed duplicated region for block: B:77:0x0226  */
                    /* JADX WARN: Removed duplicated region for block: B:82:0x0332  */
                    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:98:0x02e2  */
                    /* JADX WARN: Removed duplicated region for block: B:99:0x0218  */
                    /* renamed from: invoke-eopBjH0, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void m3190invokeeopBjH0(final float f, final long j522, final long j6, final float f2, final float f3, Composer composer3, int i22) {
                        int i23;
                        boolean z17;
                        ComposableLambda composableLambda;
                        ComposableLambda composableLambda2;
                        ComposableLambda composableLambda3;
                        ComposableLambda composableLambda4;
                        final Function2<? super Composer, ? super Integer, Unit> function228;
                        ComposableLambda composableLambda5;
                        int i24;
                        ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                        if ((i22 & 6) == 0) {
                            i23 = (composer3.changed(f) ? 4 : 2) | i22;
                        } else {
                            i23 = i22;
                        }
                        if ((i22 & 48) == 0) {
                            i23 |= composer3.changed(j522) ? 32 : 16;
                        }
                        if ((i22 & 384) == 0) {
                            i23 |= composer3.changed(j6) ? Fields.RotationX : Fields.SpotShadowColor;
                        }
                        if ((i22 & 3072) == 0) {
                            i23 |= composer3.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
                        }
                        if ((i22 & 24576) == 0) {
                            i23 |= composer3.changed(f3) ? Fields.Clip : Fields.Shape;
                        }
                        int i25 = i23;
                        if ((74899 & i25) != 74898 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1290853831, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function229 = function22;
                            if (function229 != null) {
                                final boolean z18 = z5;
                                z17 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-382297919, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                            }
                                            TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodySmall(), f);
                                            TextFieldImplKt.m3189DecorationKTwxG1Y(j6, z18 ? TextStyle.copy-p1EtxEg$default(lerp, j522, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null) : lerp, function229, composer4, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                });
                            } else {
                                z17 = true;
                                composableLambda = null;
                            }
                            final long m4849unboximpl = textFieldColors.placeholderColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            if (function22222 != null) {
                                if ((text22.length() == 0 ? z17 : false) && f2 > 0.0f) {
                                    final Function2<? super Composer, ? super Integer, Unit> function230 = function22222;
                                    composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -524658155, z17, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                            invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Modifier modifier, Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 6) == 0) {
                                                i26 |= composer4.changed(modifier) ? 4 : 2;
                                            }
                                            if ((i26 & 19) != 18 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-524658155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                                }
                                                Modifier alpha = AlphaKt.alpha(modifier, f2);
                                                long j7 = m4849unboximpl;
                                                Function2<Composer, Integer, Unit> function231 = function230;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                composer4.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                                TextFieldImplKt.m3189DecorationKTwxG1Y(j7, MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), function231, composer4, 0, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    });
                                    final long m4849unboximpl222 = textFieldColors.prefixColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                    if (function22322 != null || f3 <= 0.0f) {
                                        composableLambda3 = null;
                                    } else {
                                        final TextStyle textStyle = bodyLarge22;
                                        final Function2<? super Composer, ? super Integer, Unit> function231 = function22322;
                                        composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 1824482619, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                                if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1824482619, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                                    }
                                                    Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                    long j7 = m4849unboximpl222;
                                                    TextStyle textStyle2 = textStyle;
                                                    Function2<Composer, Integer, Unit> function232 = function231;
                                                    composer4.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                                    TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle2, function232, composer4, 0, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        });
                                    }
                                    final long m4849unboximpl322 = textFieldColors.suffixColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                    if (function22422 != null || f3 <= 0.0f) {
                                        composableLambda4 = null;
                                    } else {
                                        final TextStyle textStyle2 = bodyLarge22;
                                        final Function2<? super Composer, ? super Integer, Unit> function232 = function22422;
                                        composableLambda4 = ComposableLambdaKt.composableLambda(composer3, 907456412, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                                if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(907456412, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                    }
                                                    Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                    long j7 = m4849unboximpl322;
                                                    TextStyle textStyle3 = textStyle2;
                                                    Function2<Composer, Integer, Unit> function233 = function232;
                                                    composer4.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                                    TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle3, function233, composer4, 0, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        });
                                    }
                                    final long m4849unboximpl422 = textFieldColors.leadingIconColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function23322 = function22522;
                                    ComposableLambda composableLambda6 = function23322 == null ? ComposableLambdaKt.composableLambda(composer3, 90769583, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(90769583, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                            }
                                            TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl422, null, function23322, composer4, 0, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null;
                                    final long m4849unboximpl522 = textFieldColors.trailingIconColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function23422 = function22622;
                                    ComposableLambda composableLambda7 = function23422 == null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2077796155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                            }
                                            TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl522, null, function23422, composer4, 0, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : null;
                                    final long m4849unboximpl622 = textFieldColors.supportingTextColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                    function228 = function22722;
                                    if (function228 == null) {
                                        final TextStyle textStyle3 = bodySmall22;
                                        composableLambda5 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                                if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1531019900, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                                }
                                                TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl622, textStyle3, function228, composer4, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    } else {
                                        composableLambda5 = null;
                                    }
                                    i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                    if (i24 != z17) {
                                        composer3.startReplaceableGroup(404042583);
                                        ComposerKt.sourceInformation(composer3, "204@8500L667");
                                        final Function2<? super Composer, ? super Integer, Unit> function235 = function29;
                                        TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, composableLambda, composableLambda2, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z1622, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                                if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-2124779163, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                                    }
                                                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                    Function2<Composer, Integer, Unit> function236 = function235;
                                                    composer4.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                                    function236.invoke(composer4, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 6);
                                        composer3.endReplaceableGroup();
                                    } else if (i24 == 2) {
                                        composer3.startReplaceableGroup(404043576);
                                        ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                        composer3.startReplaceableGroup(404043645);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                        Object rememberedValue2 = composer3.rememberedValue();
                                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m4650boximpl(Size.INSTANCE.m4671getZeroNHjbRc()), null, 2, null);
                                            composer3.updateRememberedValue(rememberedValue2);
                                        }
                                        final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                        composer3.endReplaceableGroup();
                                        final PaddingValues paddingValues2 = paddingValues;
                                        final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                                        ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i26) {
                                                ComposerKt.sourceInformation(composer4, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                                if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1902535592, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                                    }
                                                    Modifier m2781outlineCutout12SF9DM = OutlinedTextFieldKt.m2781outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().m4667unboximpl(), paddingValues2);
                                                    Function2<Composer, Integer, Unit> function237 = function236;
                                                    composer4.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2781outlineCutout12SF9DM);
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
                                                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                                    function237.invoke(composer4, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        });
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        Function2<Composer, Integer, Unit> function237 = function2;
                                        boolean z19 = z1622;
                                        composer3.startReplaceableGroup(404044653);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                        boolean z20 = (i25 & 14) == 4;
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        if (z20 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    m3191invokeuvyYCjk(((Size) obj).m4667unboximpl());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                public final void m3191invokeuvyYCjk(long j7) {
                                                    float m4662getWidthimpl = Size.m4662getWidthimpl(j7) * f;
                                                    float m4659getHeightimpl = Size.m4659getHeightimpl(j7) * f;
                                                    if (Size.m4662getWidthimpl(mutableState.getValue().m4667unboximpl()) == m4662getWidthimpl) {
                                                        if (Size.m4659getHeightimpl(mutableState.getValue().m4667unboximpl()) == m4659getHeightimpl) {
                                                            return;
                                                        }
                                                    }
                                                    mutableState.setValue(Size.m4650boximpl(SizeKt.Size(m4662getWidthimpl, m4659getHeightimpl)));
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue3);
                                        }
                                        composer3.endReplaceableGroup();
                                        OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function237, composableLambda2, composableLambda, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z19, f, (Function1) rememberedValue3, composableLambda8, composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 48);
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3.startReplaceableGroup(404045277);
                                        composer3.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        return;
                                    }
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                            }
                            composableLambda2 = null;
                            final long m4849unboximpl2222 = textFieldColors.prefixColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            if (function22322 != null) {
                            }
                            composableLambda3 = null;
                            final long m4849unboximpl3222 = textFieldColors.suffixColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            if (function22422 != null) {
                            }
                            composableLambda4 = null;
                            final long m4849unboximpl4222 = textFieldColors.leadingIconColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function233222 = function22522;
                            if (function233222 == null) {
                            }
                            final long m4849unboximpl5222 = textFieldColors.trailingIconColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function234222 = function22622;
                            if (function234222 == null) {
                            }
                            final long m4849unboximpl6222 = textFieldColors.supportingTextColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            function228 = function22722;
                            if (function228 == null) {
                            }
                            i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                            if (i24 != z17) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        } else {
                            composer3.skipToGroupEnd();
                        }
                    }
                }), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                }
                z6 = z1522;
                function210 = function221;
                function211 = function216;
                function212 = function217;
                function213 = function218;
                function214 = function219;
                function215 = function220;
                z7 = z9;
                z8 = z1422;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i17 = i3 & Fields.Shape;
            if (i17 != 0) {
            }
            if ((i3 & Fields.Clip) == 0) {
            }
            if ((32768 & i3) == 0) {
            }
            if ((i3 & 65536) != 0) {
            }
            if ((i3 & Fields.RenderEffect) != 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 == 0) {
            }
            if (i14 != 0) {
            }
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-646389284);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
            if ((i4 & 112) == 32) {
            }
            z4 = ((i4 & 7168) == 2048) | ((i4 & 112) == 32);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z4) {
            }
            rememberedValue = visualTransformation.filter(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            final String text222 = ((TransformedText) rememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i15 >> 12) & 14).getValue().booleanValue()) {
            }
            InputPhase inputPhase2222 = inputPhase;
            Function3<InputPhase, Composer, Integer, Color> function3222 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return Color.m4829boximpl(m3192invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
                }

                /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m3192invokeXeAY9LY(InputPhase inputPhase3, Composer composer3, int i22) {
                    composer3.startReplaceableGroup(-502832279);
                    ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-502832279, i22, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                    }
                    long m4849unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4849unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return m4849unboximpl;
                }
            };
            Typography typography222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
            final TextStyle bodyLarge222 = typography222.getBodyLarge();
            final TextStyle bodySmall222 = typography222.getBodySmall();
            if (Color.m4840equalsimpl0(bodyLarge222.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
            }
            TextFieldTransitionScope textFieldTransitionScope222 = TextFieldTransitionScope.INSTANCE;
            startRestartGroup.startReplaceableGroup(-646388325);
            ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
            long j522 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getColor-0d7_KjU();
            startRestartGroup.startReplaceableGroup(-646388264);
            ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
            if (z5) {
            }
            long j2222 = j522;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-646388132);
            ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
            long j3222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().getColor-0d7_KjU();
            startRestartGroup.startReplaceableGroup(-646388071);
            ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
            if (z5) {
            }
            long j4222 = j3222;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            final boolean z12222 = z10;
            final boolean z13222 = z11;
            final Function2<? super Composer, ? super Integer, Unit> function222222 = function216;
            boolean z14222 = z10;
            final Function2<? super Composer, ? super Integer, Unit> function223222 = function219;
            composer2 = startRestartGroup;
            final Function2<? super Composer, ? super Integer, Unit> function224222 = function220;
            boolean z15222 = z11;
            final Function2<? super Composer, ? super Integer, Unit> function225222 = function217;
            final Function2<? super Composer, ? super Integer, Unit> function226222 = function218;
            final Function2<? super Composer, ? super Integer, Unit> function227222 = function221;
            final boolean z16222 = z9;
            textFieldTransitionScope222.m3197TransitionDTcfvLk(inputPhase2222, j2222, j4222, function3222, function22 != null, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                /* compiled from: TextFieldImpl.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        try {
                            iArr[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(7);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                    m3190invokeeopBjH0(((Number) obj).floatValue(), ((Color) obj2).m4849unboximpl(), ((Color) obj3).m4849unboximpl(), ((Number) obj4).floatValue(), ((Number) obj5).floatValue(), (Composer) obj6, ((Number) obj7).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:100:0x01dd  */
                /* JADX WARN: Removed duplicated region for block: B:101:0x01a5  */
                /* JADX WARN: Removed duplicated region for block: B:68:0x0195  */
                /* JADX WARN: Removed duplicated region for block: B:71:0x01cd  */
                /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
                /* JADX WARN: Removed duplicated region for block: B:77:0x0226  */
                /* JADX WARN: Removed duplicated region for block: B:82:0x0332  */
                /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:98:0x02e2  */
                /* JADX WARN: Removed duplicated region for block: B:99:0x0218  */
                /* renamed from: invoke-eopBjH0, reason: not valid java name */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void m3190invokeeopBjH0(final float f, final long j5222, final long j6, final float f2, final float f3, Composer composer3, int i22) {
                    int i23;
                    boolean z17;
                    ComposableLambda composableLambda;
                    ComposableLambda composableLambda2;
                    ComposableLambda composableLambda3;
                    ComposableLambda composableLambda4;
                    final Function2<? super Composer, ? super Integer, Unit> function228;
                    ComposableLambda composableLambda5;
                    int i24;
                    ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                    if ((i22 & 6) == 0) {
                        i23 = (composer3.changed(f) ? 4 : 2) | i22;
                    } else {
                        i23 = i22;
                    }
                    if ((i22 & 48) == 0) {
                        i23 |= composer3.changed(j5222) ? 32 : 16;
                    }
                    if ((i22 & 384) == 0) {
                        i23 |= composer3.changed(j6) ? Fields.RotationX : Fields.SpotShadowColor;
                    }
                    if ((i22 & 3072) == 0) {
                        i23 |= composer3.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
                    }
                    if ((i22 & 24576) == 0) {
                        i23 |= composer3.changed(f3) ? Fields.Clip : Fields.Shape;
                    }
                    int i25 = i23;
                    if ((74899 & i25) != 74898 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1290853831, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function229 = function22;
                        if (function229 != null) {
                            final boolean z18 = z5;
                            z17 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i26) {
                                    ComposerKt.sourceInformation(composer4, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                    if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-382297919, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                        }
                                        TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodySmall(), f);
                                        TextFieldImplKt.m3189DecorationKTwxG1Y(j6, z18 ? TextStyle.copy-p1EtxEg$default(lerp, j5222, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null) : lerp, function229, composer4, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                        } else {
                            z17 = true;
                            composableLambda = null;
                        }
                        final long m4849unboximpl = textFieldColors.placeholderColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                        if (function222222 != null) {
                            if ((text222.length() == 0 ? z17 : false) && f2 > 0.0f) {
                                final Function2<? super Composer, ? super Integer, Unit> function230 = function222222;
                                composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -524658155, z17, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Modifier modifier, Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 6) == 0) {
                                            i26 |= composer4.changed(modifier) ? 4 : 2;
                                        }
                                        if ((i26 & 19) != 18 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-524658155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                            }
                                            Modifier alpha = AlphaKt.alpha(modifier, f2);
                                            long j7 = m4849unboximpl;
                                            Function2<Composer, Integer, Unit> function231 = function230;
                                            composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                            TextFieldImplKt.m3189DecorationKTwxG1Y(j7, MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), function231, composer4, 0, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                });
                                final long m4849unboximpl2222 = textFieldColors.prefixColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                if (function223222 != null || f3 <= 0.0f) {
                                    composableLambda3 = null;
                                } else {
                                    final TextStyle textStyle = bodyLarge222;
                                    final Function2<? super Composer, ? super Integer, Unit> function231 = function223222;
                                    composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 1824482619, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1824482619, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                                }
                                                Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                long j7 = m4849unboximpl2222;
                                                TextStyle textStyle2 = textStyle;
                                                Function2<Composer, Integer, Unit> function232 = function231;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                composer4.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                                TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle2, function232, composer4, 0, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    });
                                }
                                final long m4849unboximpl3222 = textFieldColors.suffixColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                if (function224222 != null || f3 <= 0.0f) {
                                    composableLambda4 = null;
                                } else {
                                    final TextStyle textStyle2 = bodyLarge222;
                                    final Function2<? super Composer, ? super Integer, Unit> function232 = function224222;
                                    composableLambda4 = ComposableLambdaKt.composableLambda(composer3, 907456412, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(907456412, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                }
                                                Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                long j7 = m4849unboximpl3222;
                                                TextStyle textStyle3 = textStyle2;
                                                Function2<Composer, Integer, Unit> function233 = function232;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                composer4.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                                TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle3, function233, composer4, 0, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    });
                                }
                                final long m4849unboximpl4222 = textFieldColors.leadingIconColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function233222 = function225222;
                                ComposableLambda composableLambda6 = function233222 == null ? ComposableLambdaKt.composableLambda(composer3, 90769583, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(90769583, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                        }
                                        TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl4222, null, function233222, composer4, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                final long m4849unboximpl5222 = textFieldColors.trailingIconColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function234222 = function226222;
                                ComposableLambda composableLambda7 = function234222 == null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2077796155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                        }
                                        TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl5222, null, function234222, composer4, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                final long m4849unboximpl6222 = textFieldColors.supportingTextColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                                function228 = function227222;
                                if (function228 == null) {
                                    final TextStyle textStyle3 = bodySmall222;
                                    composableLambda5 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1531019900, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                            }
                                            TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl6222, textStyle3, function228, composer4, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                } else {
                                    composableLambda5 = null;
                                }
                                i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                if (i24 != z17) {
                                    composer3.startReplaceableGroup(404042583);
                                    ComposerKt.sourceInformation(composer3, "204@8500L667");
                                    final Function2<? super Composer, ? super Integer, Unit> function235 = function29;
                                    TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, composableLambda, composableLambda2, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z16222, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2124779163, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                                }
                                                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                Function2<Composer, Integer, Unit> function236 = function235;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                composer4.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                                function236.invoke(composer4, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 6);
                                    composer3.endReplaceableGroup();
                                } else if (i24 == 2) {
                                    composer3.startReplaceableGroup(404043576);
                                    ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                    composer3.startReplaceableGroup(404043645);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m4650boximpl(Size.INSTANCE.m4671getZeroNHjbRc()), null, 2, null);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                    composer3.endReplaceableGroup();
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i26) {
                                            ComposerKt.sourceInformation(composer4, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                            if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1902535592, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                                }
                                                Modifier m2781outlineCutout12SF9DM = OutlinedTextFieldKt.m2781outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().m4667unboximpl(), paddingValues2);
                                                Function2<Composer, Integer, Unit> function237 = function236;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2781outlineCutout12SF9DM);
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
                                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                composer4.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                                function237.invoke(composer4, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endReplaceableGroup();
                                                composer4.endNode();
                                                composer4.endReplaceableGroup();
                                                composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    });
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    Function2<Composer, Integer, Unit> function237 = function2;
                                    boolean z19 = z16222;
                                    composer3.startReplaceableGroup(404044653);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                    boolean z20 = (i25 & 14) == 4;
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (z20 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                m3191invokeuvyYCjk(((Size) obj).m4667unboximpl());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                            public final void m3191invokeuvyYCjk(long j7) {
                                                float m4662getWidthimpl = Size.m4662getWidthimpl(j7) * f;
                                                float m4659getHeightimpl = Size.m4659getHeightimpl(j7) * f;
                                                if (Size.m4662getWidthimpl(mutableState.getValue().m4667unboximpl()) == m4662getWidthimpl) {
                                                    if (Size.m4659getHeightimpl(mutableState.getValue().m4667unboximpl()) == m4659getHeightimpl) {
                                                        return;
                                                    }
                                                }
                                                mutableState.setValue(Size.m4650boximpl(SizeKt.Size(m4662getWidthimpl, m4659getHeightimpl)));
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function237, composableLambda2, composableLambda, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z19, f, (Function1) rememberedValue3, composableLambda8, composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 48);
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(404045277);
                                    composer3.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    return;
                                }
                                ComposerKt.traceEventEnd();
                                return;
                            }
                        }
                        composableLambda2 = null;
                        final long m4849unboximpl22222 = textFieldColors.prefixColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                        if (function223222 != null) {
                        }
                        composableLambda3 = null;
                        final long m4849unboximpl32222 = textFieldColors.suffixColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                        if (function224222 != null) {
                        }
                        composableLambda4 = null;
                        final long m4849unboximpl42222 = textFieldColors.leadingIconColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                        final Function2<? super Composer, ? super Integer, Unit> function2332222 = function225222;
                        if (function2332222 == null) {
                        }
                        final long m4849unboximpl52222 = textFieldColors.trailingIconColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                        final Function2<? super Composer, ? super Integer, Unit> function2342222 = function226222;
                        if (function2342222 == null) {
                        }
                        final long m4849unboximpl62222 = textFieldColors.supportingTextColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                        function228 = function227222;
                        if (function228 == null) {
                        }
                        i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                        if (i24 != z17) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    } else {
                        composer3.skipToGroupEnd();
                    }
                }
            }), composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
            }
            z6 = z15222;
            function210 = function221;
            function211 = function216;
            function212 = function217;
            function213 = function218;
            function214 = function219;
            function215 = function220;
            z7 = z9;
            z8 = z14222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 8;
        int i202 = Fields.RotationZ;
        if (i5 == 0) {
        }
        i6 = i3 & 16;
        int i212 = Fields.Clip;
        if (i6 == 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.SpotShadowColor;
        if (i9 == 0) {
        }
        i10 = i3 & Fields.RotationX;
        if (i10 == 0) {
        }
        i11 = i3 & Fields.RotationY;
        if (i11 == 0) {
        }
        i12 = i3 & Fields.RotationZ;
        if (i12 == 0) {
        }
        i14 = i3 & Fields.CameraDistance;
        if (i14 == 0) {
        }
        i15 = i13;
        i16 = i3 & Fields.TransformOrigin;
        if (i16 == 0) {
        }
        i17 = i3 & Fields.Shape;
        if (i17 != 0) {
        }
        if ((i3 & Fields.Clip) == 0) {
        }
        if ((32768 & i3) == 0) {
        }
        if ((i3 & 65536) != 0) {
        }
        if ((i3 & Fields.RenderEffect) != 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 == 0) {
        }
        if (i14 != 0) {
        }
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-646389284);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
        if ((i4 & 112) == 32) {
        }
        z4 = ((i4 & 7168) == 2048) | ((i4 & 112) == 32);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue = visualTransformation.filter(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        final String text2222 = ((TransformedText) rememberedValue).getText().getText();
        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i15 >> 12) & 14).getValue().booleanValue()) {
        }
        InputPhase inputPhase22222 = inputPhase;
        Function3<InputPhase, Composer, Integer, Color> function32222 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return Color.m4829boximpl(m3192invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
            }

            /* renamed from: invoke-XeAY9LY, reason: not valid java name */
            public final long m3192invokeXeAY9LY(InputPhase inputPhase3, Composer composer3, int i22) {
                composer3.startReplaceableGroup(-502832279);
                ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-502832279, i22, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                }
                long m4849unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4849unboximpl();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3.endReplaceableGroup();
                return m4849unboximpl;
            }
        };
        Typography typography2222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
        final TextStyle bodyLarge2222 = typography2222.getBodyLarge();
        final TextStyle bodySmall2222 = typography2222.getBodySmall();
        if (Color.m4840equalsimpl0(bodyLarge2222.getColor-0d7_KjU(), Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
        }
        TextFieldTransitionScope textFieldTransitionScope2222 = TextFieldTransitionScope.INSTANCE;
        startRestartGroup.startReplaceableGroup(-646388325);
        ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
        long j5222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getColor-0d7_KjU();
        startRestartGroup.startReplaceableGroup(-646388264);
        ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
        if (z5) {
        }
        long j22222 = j5222;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-646388132);
        ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
        long j32222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().getColor-0d7_KjU();
        startRestartGroup.startReplaceableGroup(-646388071);
        ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
        if (z5) {
        }
        long j42222 = j32222;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        final boolean z122222 = z10;
        final boolean z132222 = z11;
        final Function2<? super Composer, ? super Integer, Unit> function2222222 = function216;
        boolean z142222 = z10;
        final Function2<? super Composer, ? super Integer, Unit> function2232222 = function219;
        composer2 = startRestartGroup;
        final Function2<? super Composer, ? super Integer, Unit> function2242222 = function220;
        boolean z152222 = z11;
        final Function2<? super Composer, ? super Integer, Unit> function2252222 = function217;
        final Function2<? super Composer, ? super Integer, Unit> function2262222 = function218;
        final Function2<? super Composer, ? super Integer, Unit> function2272222 = function221;
        final boolean z162222 = z9;
        textFieldTransitionScope2222.m3197TransitionDTcfvLk(inputPhase22222, j22222, j42222, function32222, function22 != null, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

            /* compiled from: TextFieldImpl.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[TextFieldType.values().length];
                    try {
                        iArr[TextFieldType.Filled.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[TextFieldType.Outlined.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(7);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                m3190invokeeopBjH0(((Number) obj).floatValue(), ((Color) obj2).m4849unboximpl(), ((Color) obj3).m4849unboximpl(), ((Number) obj4).floatValue(), ((Number) obj5).floatValue(), (Composer) obj6, ((Number) obj7).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:100:0x01dd  */
            /* JADX WARN: Removed duplicated region for block: B:101:0x01a5  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0195  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x01cd  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
            /* JADX WARN: Removed duplicated region for block: B:77:0x0226  */
            /* JADX WARN: Removed duplicated region for block: B:82:0x0332  */
            /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:98:0x02e2  */
            /* JADX WARN: Removed duplicated region for block: B:99:0x0218  */
            /* renamed from: invoke-eopBjH0, reason: not valid java name */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void m3190invokeeopBjH0(final float f, final long j52222, final long j6, final float f2, final float f3, Composer composer3, int i22) {
                int i23;
                boolean z17;
                ComposableLambda composableLambda;
                ComposableLambda composableLambda2;
                ComposableLambda composableLambda3;
                ComposableLambda composableLambda4;
                final Function2<? super Composer, ? super Integer, Unit> function228;
                ComposableLambda composableLambda5;
                int i24;
                ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                if ((i22 & 6) == 0) {
                    i23 = (composer3.changed(f) ? 4 : 2) | i22;
                } else {
                    i23 = i22;
                }
                if ((i22 & 48) == 0) {
                    i23 |= composer3.changed(j52222) ? 32 : 16;
                }
                if ((i22 & 384) == 0) {
                    i23 |= composer3.changed(j6) ? Fields.RotationX : Fields.SpotShadowColor;
                }
                if ((i22 & 3072) == 0) {
                    i23 |= composer3.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
                }
                if ((i22 & 24576) == 0) {
                    i23 |= composer3.changed(f3) ? Fields.Clip : Fields.Shape;
                }
                int i25 = i23;
                if ((74899 & i25) != 74898 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1290853831, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function229 = function22;
                    if (function229 != null) {
                        final boolean z18 = z5;
                        z17 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i26) {
                                ComposerKt.sourceInformation(composer4, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-382297919, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                    }
                                    TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodySmall(), f);
                                    TextFieldImplKt.m3189DecorationKTwxG1Y(j6, z18 ? TextStyle.copy-p1EtxEg$default(lerp, j52222, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null) : lerp, function229, composer4, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        });
                    } else {
                        z17 = true;
                        composableLambda = null;
                    }
                    final long m4849unboximpl = textFieldColors.placeholderColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                    if (function2222222 != null) {
                        if ((text2222.length() == 0 ? z17 : false) && f2 > 0.0f) {
                            final Function2<? super Composer, ? super Integer, Unit> function230 = function2222222;
                            composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -524658155, z17, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Modifier modifier, Composer composer4, int i26) {
                                    ComposerKt.sourceInformation(composer4, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                    if ((i26 & 6) == 0) {
                                        i26 |= composer4.changed(modifier) ? 4 : 2;
                                    }
                                    if ((i26 & 19) != 18 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-524658155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                        }
                                        Modifier alpha = AlphaKt.alpha(modifier, f2);
                                        long j7 = m4849unboximpl;
                                        Function2<Composer, Integer, Unit> function231 = function230;
                                        composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                        TextFieldImplKt.m3189DecorationKTwxG1Y(j7, MaterialTheme.INSTANCE.getTypography(composer4, 6).getBodyLarge(), function231, composer4, 0, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            final long m4849unboximpl22222 = textFieldColors.prefixColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            if (function2232222 != null || f3 <= 0.0f) {
                                composableLambda3 = null;
                            } else {
                                final TextStyle textStyle = bodyLarge2222;
                                final Function2<? super Composer, ? super Integer, Unit> function231 = function2232222;
                                composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 1824482619, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1824482619, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                            }
                                            Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                            long j7 = m4849unboximpl22222;
                                            TextStyle textStyle2 = textStyle;
                                            Function2<Composer, Integer, Unit> function232 = function231;
                                            composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                            TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle2, function232, composer4, 0, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                });
                            }
                            final long m4849unboximpl32222 = textFieldColors.suffixColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            if (function2242222 != null || f3 <= 0.0f) {
                                composableLambda4 = null;
                            } else {
                                final TextStyle textStyle2 = bodyLarge2222;
                                final Function2<? super Composer, ? super Integer, Unit> function232 = function2242222;
                                composableLambda4 = ComposableLambdaKt.composableLambda(composer3, 907456412, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(907456412, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                            }
                                            Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                            long j7 = m4849unboximpl32222;
                                            TextStyle textStyle3 = textStyle2;
                                            Function2<Composer, Integer, Unit> function233 = function232;
                                            composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                            TextFieldImplKt.m3189DecorationKTwxG1Y(j7, textStyle3, function233, composer4, 0, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                });
                            }
                            final long m4849unboximpl42222 = textFieldColors.leadingIconColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function2332222 = function2252222;
                            ComposableLambda composableLambda6 = function2332222 == null ? ComposableLambdaKt.composableLambda(composer3, 90769583, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i26) {
                                    ComposerKt.sourceInformation(composer4, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                    if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(90769583, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                    }
                                    TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl42222, null, function2332222, composer4, 0, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : null;
                            final long m4849unboximpl52222 = textFieldColors.trailingIconColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function2342222 = function2262222;
                            ComposableLambda composableLambda7 = function2342222 == null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i26) {
                                    ComposerKt.sourceInformation(composer4, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                    if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2077796155, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                    }
                                    TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl52222, null, function2342222, composer4, 0, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : null;
                            final long m4849unboximpl62222 = textFieldColors.supportingTextColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                            function228 = function2272222;
                            if (function228 == null) {
                                final TextStyle textStyle3 = bodySmall2222;
                                composableLambda5 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1531019900, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                        }
                                        TextFieldImplKt.m3189DecorationKTwxG1Y(m4849unboximpl62222, textStyle3, function228, composer4, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                            } else {
                                composableLambda5 = null;
                            }
                            i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                            if (i24 != z17) {
                                composer3.startReplaceableGroup(404042583);
                                ComposerKt.sourceInformation(composer3, "204@8500L667");
                                final Function2<? super Composer, ? super Integer, Unit> function235 = function29;
                                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, composableLambda, composableLambda2, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z162222, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2124779163, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                            }
                                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                            Function2<Composer, Integer, Unit> function236 = function235;
                                            composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                            function236.invoke(composer4, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 6);
                                composer3.endReplaceableGroup();
                            } else if (i24 == 2) {
                                composer3.startReplaceableGroup(404043576);
                                ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                composer3.startReplaceableGroup(404043645);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m4650boximpl(Size.INSTANCE.m4671getZeroNHjbRc()), null, 2, null);
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                composer3.endReplaceableGroup();
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                                ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z17, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i26) {
                                        ComposerKt.sourceInformation(composer4, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                        if ((i26 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1902535592, i26, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                            }
                                            Modifier m2781outlineCutout12SF9DM = OutlinedTextFieldKt.m2781outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().m4667unboximpl(), paddingValues2);
                                            Function2<Composer, Integer, Unit> function237 = function236;
                                            composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer4, 48);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2781outlineCutout12SF9DM);
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
                                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                            function237.invoke(composer4, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                });
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Function2<Composer, Integer, Unit> function237 = function2;
                                boolean z19 = z162222;
                                composer3.startReplaceableGroup(404044653);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                boolean z20 = (i25 & 14) == 4;
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (z20 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            m3191invokeuvyYCjk(((Size) obj).m4667unboximpl());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                        public final void m3191invokeuvyYCjk(long j7) {
                                            float m4662getWidthimpl = Size.m4662getWidthimpl(j7) * f;
                                            float m4659getHeightimpl = Size.m4659getHeightimpl(j7) * f;
                                            if (Size.m4662getWidthimpl(mutableState.getValue().m4667unboximpl()) == m4662getWidthimpl) {
                                                if (Size.m4659getHeightimpl(mutableState.getValue().m4667unboximpl()) == m4659getHeightimpl) {
                                                    return;
                                                }
                                            }
                                            mutableState.setValue(Size.m4650boximpl(SizeKt.Size(m4662getWidthimpl, m4659getHeightimpl)));
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function237, composableLambda2, composableLambda, composableLambda6, composableLambda7, composableLambda3, composableLambda4, z19, f, (Function1) rememberedValue3, composableLambda8, composableLambda5, paddingValues, composer3, ((i25 << 27) & 1879048192) | 6, 48);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(404045277);
                                composer3.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                return;
                            }
                            ComposerKt.traceEventEnd();
                            return;
                        }
                    }
                    composableLambda2 = null;
                    final long m4849unboximpl222222 = textFieldColors.prefixColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                    if (function2232222 != null) {
                    }
                    composableLambda3 = null;
                    final long m4849unboximpl322222 = textFieldColors.suffixColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                    if (function2242222 != null) {
                    }
                    composableLambda4 = null;
                    final long m4849unboximpl422222 = textFieldColors.leadingIconColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                    final Function2<? super Composer, ? super Integer, Unit> function23322222 = function2252222;
                    if (function23322222 == null) {
                    }
                    final long m4849unboximpl522222 = textFieldColors.trailingIconColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                    final Function2<? super Composer, ? super Integer, Unit> function23422222 = function2262222;
                    if (function23422222 == null) {
                    }
                    final long m4849unboximpl622222 = textFieldColors.supportingTextColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4849unboximpl();
                    function228 = function2272222;
                    if (function228 == null) {
                    }
                    i24 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                    if (i24 != z17) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else {
                    composer3.skipToGroupEnd();
                }
            }
        }), composer2, 1769472);
        if (ComposerKt.isTraceInProgress()) {
        }
        z6 = z152222;
        function210 = function221;
        function211 = function216;
        function212 = function217;
        function213 = function218;
        function214 = function219;
        function215 = function220;
        z7 = z9;
        z8 = z142222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: Decoration-KTwxG1Y, reason: not valid java name */
    public static final void m3189DecorationKTwxG1Y(final long j, TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1520066345);
        ComposerKt.sourceInformation(startRestartGroup, "C(Decoration)P(1:c#ui.graphics.Color,2):TextFieldImpl.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                textStyle = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520066345, i3, -1, "androidx.compose.material3.Decoration (TextFieldImpl.kt:271)");
            }
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1449369305, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$Decoration$contentWithColor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C273@11220L118:TextFieldImpl.kt#uh7d8r");
                    if ((i5 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1449369305, i5, -1, "androidx.compose.material3.Decoration.<anonymous> (TextFieldImpl.kt:273)");
                        }
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j)), function2, composer2, ProvidedValue.$stable | 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            if (textStyle != null) {
                startRestartGroup.startReplaceableGroup(1830467586);
                ComposerKt.sourceInformation(startRestartGroup, "279@11381L63");
                ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896));
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(1830467667);
                ComposerKt.sourceInformation(startRestartGroup, "281@11462L18");
                composableLambda.invoke(startRestartGroup, 6);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final TextStyle textStyle2 = textStyle;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$Decoration$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    TextFieldImplKt.m3189DecorationKTwxG1Y(j, textStyle2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$defaultErrorSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
            }
        }, 1, (Object) null) : modifier;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = 16;
        TextFieldPadding = Dp.constructor-impl(f);
        MinFocusedLabelLineHeight = Dp.constructor-impl(f);
        MinSupportingTextLineHeight = Dp.constructor-impl(f);
        float f2 = 48;
        IconDefaultSizeModifier = androidx.compose.foundation.layout.SizeKt.m1104defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.constructor-impl(f2), Dp.constructor-impl(f2));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
