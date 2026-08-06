package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatePickerDialog.android.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u009a\u0001\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"DialogButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DialogButtonsMainAxisSpacing", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DatePickerDialog_androidKt {
    private static final float DialogButtonsCrossAxisSpacing = Dp.constructor-impl(12);
    private static final float DialogButtonsMainAxisSpacing;
    private static final PaddingValues DialogButtonsPadding;

    /* JADX WARN: Removed duplicated region for block: B:104:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00de  */
    /* renamed from: DatePickerDialog-GmEhDVc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2471DatePickerDialogGmEhDVc(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, float f, DatePickerColors datePickerColors, DialogProperties dialogProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Shape shape2;
        int i5;
        float f2;
        DatePickerColors datePickerColors2;
        int i6;
        Modifier.Companion companion;
        DialogProperties dialogProperties2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Shape shape3;
        final float f3;
        final DatePickerColors datePickerColors3;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-36517340);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerDialog)P(5,1,4,3,7,8:c#ui.unit.Dp!1,6)68@3428L5,70@3545L8,74@3697L1472:DatePickerDialog.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                function23 = function22;
                i3 |= startRestartGroup.changedInstance(function23) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i8 = Fields.Clip;
                            i3 |= i8;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i8 = Fields.Shape;
                    i3 |= i8;
                } else {
                    shape2 = shape;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            datePickerColors2 = datePickerColors;
                            if (startRestartGroup.changed(datePickerColors2)) {
                                i7 = 1048576;
                                i3 |= i7;
                            }
                        } else {
                            datePickerColors2 = datePickerColors;
                        }
                        i7 = Fields.BlendMode;
                        i3 |= i7;
                    } else {
                        datePickerColors2 = datePickerColors;
                    }
                    i6 = i2 & Fields.SpotShadowColor;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(dialogProperties) ? 8388608 : 4194304;
                    }
                    if ((i2 & Fields.RotationX) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                                if (i4 != 0) {
                                    function23 = null;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    shape2 = DatePickerDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                }
                                if (i5 != 0) {
                                    f2 = DatePickerDefaults.INSTANCE.m2470getTonalElevationD9Ej5fM();
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    datePickerColors2 = DatePickerDefaults.INSTANCE.colors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, false, false, 23, (DefaultConstructorMarker) null);
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                                    final Shape shape4 = shape2;
                                    final float f4 = f2;
                                    final DatePickerColors datePickerColors4 = datePickerColors2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:73)");
                                    }
                                    AndroidAlertDialog_androidKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(companion, null, false, 3, null), dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, -10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                                        public final void invoke(Composer composer2, int i10) {
                                            ComposerKt.sourceInformation(composer2, "C79@3857L1306:DatePickerDialog.android.kt#uh7d8r");
                                            if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:79)");
                                                }
                                                Modifier m1108heightInVpY3zN4$default = SizeKt.m1108heightInVpY3zN4$default(SizeKt.m1117requiredWidth3ABfNKs(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3541getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m3540getContainerHeightD9Ej5fM(), 1, null);
                                                Shape shape5 = Shape.this;
                                                long containerColor = datePickerColors4.getContainerColor();
                                                float f5 = f4;
                                                final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                                final Function2<Composer, Integer, Unit> function26 = function25;
                                                final Function2<Composer, Integer, Unit> function27 = function2;
                                                SurfaceKt.m3043SurfaceT9BRK9s(m1108heightInVpY3zN4$default, shape5, containerColor, 0L, f5, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i11) {
                                                        PaddingValues paddingValues;
                                                        ComposerKt.sourceInformation(composer3, "C87@4178L975:DatePickerDialog.android.kt#uh7d8r");
                                                        if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:87)");
                                                            }
                                                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                            final Function2<Composer, Integer, Unit> function28 = function26;
                                                            final Function2<Composer, Integer, Unit> function29 = function27;
                                                            composer3.startReplaceableGroup(-483455358);
                                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer3, 6);
                                                            composer3.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer3.startReusableNode();
                                                            if (composer3.getInserting()) {
                                                                composer3.createNode(constructor);
                                                            } else {
                                                                composer3.useNode();
                                                            }
                                                            Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                                                            Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                                            composer3.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 1146374327, "C88@4251L9,90@4304L835:DatePickerDialog.android.kt#uh7d8r");
                                                            function33.invoke(columnScopeInstance, composer3, 6);
                                                            Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                                            paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                                            Modifier padding = PaddingKt.padding(align, paddingValues);
                                                            composer3.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                            composer3.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(padding);
                                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer3.startReusableNode();
                                                            if (composer3.getInserting()) {
                                                                composer3.createNode(constructor2);
                                                            } else {
                                                                composer3.useNode();
                                                            }
                                                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                                            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                            }
                                                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                                            composer3.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -552861241, "C96@4593L5,98@4674L10,95@4490L631:DatePickerDialog.android.kt#uh7d8r");
                                                            ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), ComposableLambdaKt.composableLambda(composer3, 1174914401, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1
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

                                                                public final void invoke(Composer composer4, int i12) {
                                                                    float f6;
                                                                    float f7;
                                                                    ComposerKt.sourceInformation(composer4, "C100@4777L322:DatePickerDialog.android.kt#uh7d8r");
                                                                    if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1174914401, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:100)");
                                                                        }
                                                                        f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                                        f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                                        final Function2<Composer, Integer, Unit> function210 = function28;
                                                                        final Function2<Composer, Integer, Unit> function211 = function29;
                                                                        AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.composableLambda(composer4, -330605494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            public final void invoke(Composer composer5, int i13) {
                                                                                ComposerKt.sourceInformation(composer5, "C105@5058L15:DatePickerDialog.android.kt#uh7d8r");
                                                                                if ((i13 & 3) != 2 || !composer5.getSkipping()) {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-330605494, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:104)");
                                                                                    }
                                                                                    Function2<Composer, Integer, Unit> function212 = function210;
                                                                                    composer5.startReplaceableGroup(1914517404);
                                                                                    ComposerKt.sourceInformation(composer5, "104@5021L8");
                                                                                    if (function212 != null) {
                                                                                        function212.invoke(composer5, 0);
                                                                                        Unit unit = Unit.INSTANCE;
                                                                                    }
                                                                                    composer5.endReplaceableGroup();
                                                                                    function211.invoke(composer5, 0);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                composer5.skipToGroupEnd();
                                                                            }
                                                                        }), composer4, 438);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }), composer3, 384);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            composer3.endReplaceableGroup();
                                                            composer3.endNode();
                                                            composer3.endReplaceableGroup();
                                                            composer3.endReplaceableGroup();
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            composer3.endReplaceableGroup();
                                                            composer3.endNode();
                                                            composer3.endReplaceableGroup();
                                                            composer3.endReplaceableGroup();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }), composer2, 12582918, 104);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    }), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = companion;
                                    function24 = function25;
                                    shape3 = shape4;
                                    f3 = f4;
                                    datePickerColors3 = datePickerColors4;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                companion = modifier;
                            }
                            dialogProperties2 = dialogProperties;
                            final Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                            final Shape shape42 = shape2;
                            final float f42 = f2;
                            final DatePickerColors datePickerColors42 = datePickerColors2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            AndroidAlertDialog_androidKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(companion, null, false, 3, null), dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, -10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                                public final void invoke(Composer composer2, int i10) {
                                    ComposerKt.sourceInformation(composer2, "C79@3857L1306:DatePickerDialog.android.kt#uh7d8r");
                                    if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:79)");
                                        }
                                        Modifier m1108heightInVpY3zN4$default = SizeKt.m1108heightInVpY3zN4$default(SizeKt.m1117requiredWidth3ABfNKs(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3541getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m3540getContainerHeightD9Ej5fM(), 1, null);
                                        Shape shape5 = Shape.this;
                                        long containerColor = datePickerColors42.getContainerColor();
                                        float f5 = f42;
                                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                        final Function2<? super Composer, ? super Integer, Unit> function26 = function252;
                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function2;
                                        SurfaceKt.m3043SurfaceT9BRK9s(m1108heightInVpY3zN4$default, shape5, containerColor, 0L, f5, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i11) {
                                                PaddingValues paddingValues;
                                                ComposerKt.sourceInformation(composer3, "C87@4178L975:DatePickerDialog.android.kt#uh7d8r");
                                                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:87)");
                                                    }
                                                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                                    composer3.startReplaceableGroup(-483455358);
                                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer3, 6);
                                                    composer3.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                                    if (!(composer3.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer3.startReusableNode();
                                                    if (composer3.getInserting()) {
                                                        composer3.createNode(constructor);
                                                    } else {
                                                        composer3.useNode();
                                                    }
                                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                                                    Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                                    composer3.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 1146374327, "C88@4251L9,90@4304L835:DatePickerDialog.android.kt#uh7d8r");
                                                    function33.invoke(columnScopeInstance, composer3, 6);
                                                    Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                                    paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                                    Modifier padding = PaddingKt.padding(align, paddingValues);
                                                    composer3.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                    composer3.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(padding);
                                                    if (!(composer3.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer3.startReusableNode();
                                                    if (composer3.getInserting()) {
                                                        composer3.createNode(constructor2);
                                                    } else {
                                                        composer3.useNode();
                                                    }
                                                    Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                                    Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                                    composer3.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -552861241, "C96@4593L5,98@4674L10,95@4490L631:DatePickerDialog.android.kt#uh7d8r");
                                                    ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), ComposableLambdaKt.composableLambda(composer3, 1174914401, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1
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

                                                        public final void invoke(Composer composer4, int i12) {
                                                            float f6;
                                                            float f7;
                                                            ComposerKt.sourceInformation(composer4, "C100@4777L322:DatePickerDialog.android.kt#uh7d8r");
                                                            if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1174914401, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:100)");
                                                                }
                                                                f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                                f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                                final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                                final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                                                AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.composableLambda(composer4, -330605494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Composer composer5, int i13) {
                                                                        ComposerKt.sourceInformation(composer5, "C105@5058L15:DatePickerDialog.android.kt#uh7d8r");
                                                                        if ((i13 & 3) != 2 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-330605494, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:104)");
                                                                            }
                                                                            Function2<Composer, Integer, Unit> function212 = function210;
                                                                            composer5.startReplaceableGroup(1914517404);
                                                                            ComposerKt.sourceInformation(composer5, "104@5021L8");
                                                                            if (function212 != null) {
                                                                                function212.invoke(composer5, 0);
                                                                                Unit unit = Unit.INSTANCE;
                                                                            }
                                                                            composer5.endReplaceableGroup();
                                                                            function211.invoke(composer5, 0);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }), composer4, 438);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), composer3, 384);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    composer3.endReplaceableGroup();
                                                    composer3.endNode();
                                                    composer3.endReplaceableGroup();
                                                    composer3.endReplaceableGroup();
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    composer3.endReplaceableGroup();
                                                    composer3.endNode();
                                                    composer3.endReplaceableGroup();
                                                    composer3.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), composer2, 12582918, 104);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = companion;
                            function24 = function252;
                            shape3 = shape42;
                            f3 = f42;
                            datePickerColors3 = datePickerColors42;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            dialogProperties2 = dialogProperties;
                            function24 = function23;
                            shape3 = shape2;
                            f3 = f2;
                            datePickerColors3 = datePickerColors2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final DialogProperties dialogProperties3 = dialogProperties2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$2
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

                                public final void invoke(Composer composer2, int i10) {
                                    DatePickerDialog_androidKt.m2471DatePickerDialogGmEhDVc(function0, function2, modifier2, function24, shape3, f3, datePickerColors3, dialogProperties3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    dialogProperties2 = dialogProperties;
                    final Function2<? super Composer, ? super Integer, Unit> function2522 = function23;
                    final Shape shape422 = shape2;
                    final float f422 = f2;
                    final DatePickerColors datePickerColors422 = datePickerColors2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    AndroidAlertDialog_androidKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(companion, null, false, 3, null), dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, -10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                        public final void invoke(Composer composer2, int i10) {
                            ComposerKt.sourceInformation(composer2, "C79@3857L1306:DatePickerDialog.android.kt#uh7d8r");
                            if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:79)");
                                }
                                Modifier m1108heightInVpY3zN4$default = SizeKt.m1108heightInVpY3zN4$default(SizeKt.m1117requiredWidth3ABfNKs(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3541getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m3540getContainerHeightD9Ej5fM(), 1, null);
                                Shape shape5 = Shape.this;
                                long containerColor = datePickerColors422.getContainerColor();
                                float f5 = f422;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function2522;
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function2;
                                SurfaceKt.m3043SurfaceT9BRK9s(m1108heightInVpY3zN4$default, shape5, containerColor, 0L, f5, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i11) {
                                        PaddingValues paddingValues;
                                        ComposerKt.sourceInformation(composer3, "C87@4178L975:DatePickerDialog.android.kt#uh7d8r");
                                        if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:87)");
                                            }
                                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                            final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                            final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer3, 6);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                                            Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1146374327, "C88@4251L9,90@4304L835:DatePickerDialog.android.kt#uh7d8r");
                                            function33.invoke(columnScopeInstance, composer3, 6);
                                            Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                            paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                            Modifier padding = PaddingKt.padding(align, paddingValues);
                                            composer3.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(padding);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, -552861241, "C96@4593L5,98@4674L10,95@4490L631:DatePickerDialog.android.kt#uh7d8r");
                                            ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), ComposableLambdaKt.composableLambda(composer3, 1174914401, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1
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

                                                public final void invoke(Composer composer4, int i12) {
                                                    float f6;
                                                    float f7;
                                                    ComposerKt.sourceInformation(composer4, "C100@4777L322:DatePickerDialog.android.kt#uh7d8r");
                                                    if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1174914401, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:100)");
                                                        }
                                                        f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                        f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                        final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                        final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                                        AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.composableLambda(composer4, -330605494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer5, int i13) {
                                                                ComposerKt.sourceInformation(composer5, "C105@5058L15:DatePickerDialog.android.kt#uh7d8r");
                                                                if ((i13 & 3) != 2 || !composer5.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-330605494, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:104)");
                                                                    }
                                                                    Function2<Composer, Integer, Unit> function212 = function210;
                                                                    composer5.startReplaceableGroup(1914517404);
                                                                    ComposerKt.sourceInformation(composer5, "104@5021L8");
                                                                    if (function212 != null) {
                                                                        function212.invoke(composer5, 0);
                                                                        Unit unit = Unit.INSTANCE;
                                                                    }
                                                                    composer5.endReplaceableGroup();
                                                                    function211.invoke(composer5, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer5.skipToGroupEnd();
                                                            }
                                                        }), composer4, 438);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), composer3, 384);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, 12582918, 104);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = companion;
                    function24 = function2522;
                    shape3 = shape422;
                    f3 = f422;
                    datePickerColors3 = datePickerColors422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f2 = f;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 == 0) {
                }
                if ((i2 & Fields.RotationX) == 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if (i6 != 0) {
                }
                dialogProperties2 = dialogProperties;
                final Function2<? super Composer, ? super Integer, Unit> function25222 = function23;
                final Shape shape4222 = shape2;
                final float f4222 = f2;
                final DatePickerColors datePickerColors4222 = datePickerColors2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                AndroidAlertDialog_androidKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(companion, null, false, 3, null), dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, -10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                    public final void invoke(Composer composer2, int i10) {
                        ComposerKt.sourceInformation(composer2, "C79@3857L1306:DatePickerDialog.android.kt#uh7d8r");
                        if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:79)");
                            }
                            Modifier m1108heightInVpY3zN4$default = SizeKt.m1108heightInVpY3zN4$default(SizeKt.m1117requiredWidth3ABfNKs(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3541getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m3540getContainerHeightD9Ej5fM(), 1, null);
                            Shape shape5 = Shape.this;
                            long containerColor = datePickerColors4222.getContainerColor();
                            float f5 = f4222;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function25222;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function2;
                            SurfaceKt.m3043SurfaceT9BRK9s(m1108heightInVpY3zN4$default, shape5, containerColor, 0L, f5, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11) {
                                    PaddingValues paddingValues;
                                    ComposerKt.sourceInformation(composer3, "C87@4178L975:DatePickerDialog.android.kt#uh7d8r");
                                    if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:87)");
                                        }
                                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                        final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                        final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                        composer3.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer3, 6);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                                        Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 1146374327, "C88@4251L9,90@4304L835:DatePickerDialog.android.kt#uh7d8r");
                                        function33.invoke(columnScopeInstance, composer3, 6);
                                        Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                        paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                        Modifier padding = PaddingKt.padding(align, paddingValues);
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(padding);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                        Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -552861241, "C96@4593L5,98@4674L10,95@4490L631:DatePickerDialog.android.kt#uh7d8r");
                                        ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), ComposableLambdaKt.composableLambda(composer3, 1174914401, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1
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

                                            public final void invoke(Composer composer4, int i12) {
                                                float f6;
                                                float f7;
                                                ComposerKt.sourceInformation(composer4, "C100@4777L322:DatePickerDialog.android.kt#uh7d8r");
                                                if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1174914401, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:100)");
                                                    }
                                                    f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                    f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                    final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                                    AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.composableLambda(composer4, -330605494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer5, int i13) {
                                                            ComposerKt.sourceInformation(composer5, "C105@5058L15:DatePickerDialog.android.kt#uh7d8r");
                                                            if ((i13 & 3) != 2 || !composer5.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-330605494, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:104)");
                                                                }
                                                                Function2<Composer, Integer, Unit> function212 = function210;
                                                                composer5.startReplaceableGroup(1914517404);
                                                                ComposerKt.sourceInformation(composer5, "104@5021L8");
                                                                if (function212 != null) {
                                                                    function212.invoke(composer5, 0);
                                                                    Unit unit = Unit.INSTANCE;
                                                                }
                                                                composer5.endReplaceableGroup();
                                                                function211.invoke(composer5, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer5.skipToGroupEnd();
                                                        }
                                                    }), composer4, 438);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 384);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, 12582918, 104);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = companion;
                function24 = function25222;
                shape3 = shape4222;
                f3 = f4222;
                datePickerColors3 = datePickerColors4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function23 = function22;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 == 0) {
            }
            if ((i2 & Fields.RotationX) == 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i6 != 0) {
            }
            dialogProperties2 = dialogProperties;
            final Function2<? super Composer, ? super Integer, Unit> function252222 = function23;
            final Shape shape42222 = shape2;
            final float f42222 = f2;
            final DatePickerColors datePickerColors42222 = datePickerColors2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            AndroidAlertDialog_androidKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(companion, null, false, 3, null), dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, -10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                public final void invoke(Composer composer2, int i10) {
                    ComposerKt.sourceInformation(composer2, "C79@3857L1306:DatePickerDialog.android.kt#uh7d8r");
                    if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:79)");
                        }
                        Modifier m1108heightInVpY3zN4$default = SizeKt.m1108heightInVpY3zN4$default(SizeKt.m1117requiredWidth3ABfNKs(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3541getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m3540getContainerHeightD9Ej5fM(), 1, null);
                        Shape shape5 = Shape.this;
                        long containerColor = datePickerColors42222.getContainerColor();
                        float f5 = f42222;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function252222;
                        final Function2<? super Composer, ? super Integer, Unit> function27 = function2;
                        SurfaceKt.m3043SurfaceT9BRK9s(m1108heightInVpY3zN4$default, shape5, containerColor, 0L, f5, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i11) {
                                PaddingValues paddingValues;
                                ComposerKt.sourceInformation(composer3, "C87@4178L975:DatePickerDialog.android.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:87)");
                                    }
                                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer3, 6);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                                    Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1146374327, "C88@4251L9,90@4304L835:DatePickerDialog.android.kt#uh7d8r");
                                    function33.invoke(columnScopeInstance, composer3, 6);
                                    Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                    paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                    Modifier padding = PaddingKt.padding(align, paddingValues);
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(padding);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                    Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -552861241, "C96@4593L5,98@4674L10,95@4490L631:DatePickerDialog.android.kt#uh7d8r");
                                    ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), ComposableLambdaKt.composableLambda(composer3, 1174914401, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1
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

                                        public final void invoke(Composer composer4, int i12) {
                                            float f6;
                                            float f7;
                                            ComposerKt.sourceInformation(composer4, "C100@4777L322:DatePickerDialog.android.kt#uh7d8r");
                                            if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1174914401, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:100)");
                                                }
                                                f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                                AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.composableLambda(composer4, -330605494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i13) {
                                                        ComposerKt.sourceInformation(composer5, "C105@5058L15:DatePickerDialog.android.kt#uh7d8r");
                                                        if ((i13 & 3) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-330605494, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:104)");
                                                            }
                                                            Function2<Composer, Integer, Unit> function212 = function210;
                                                            composer5.startReplaceableGroup(1914517404);
                                                            ComposerKt.sourceInformation(composer5, "104@5021L8");
                                                            if (function212 != null) {
                                                                function212.invoke(composer5, 0);
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            function211.invoke(composer5, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 438);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 384);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 12582918, 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = companion;
            function24 = function252222;
            shape3 = shape42222;
            f3 = f42222;
            datePickerColors3 = datePickerColors42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function23 = function22;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        if ((i2 & Fields.RotationX) == 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i6 != 0) {
        }
        dialogProperties2 = dialogProperties;
        final Function2<? super Composer, ? super Integer, Unit> function2522222 = function23;
        final Shape shape422222 = shape2;
        final float f422222 = f2;
        final DatePickerColors datePickerColors422222 = datePickerColors2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        AndroidAlertDialog_androidKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(companion, null, false, 3, null), dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, -10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

            public final void invoke(Composer composer2, int i10) {
                ComposerKt.sourceInformation(composer2, "C79@3857L1306:DatePickerDialog.android.kt#uh7d8r");
                if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:79)");
                    }
                    Modifier m1108heightInVpY3zN4$default = SizeKt.m1108heightInVpY3zN4$default(SizeKt.m1117requiredWidth3ABfNKs(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3541getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m3540getContainerHeightD9Ej5fM(), 1, null);
                    Shape shape5 = Shape.this;
                    long containerColor = datePickerColors422222.getContainerColor();
                    float f5 = f422222;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function2522222;
                    final Function2<? super Composer, ? super Integer, Unit> function27 = function2;
                    SurfaceKt.m3043SurfaceT9BRK9s(m1108heightInVpY3zN4$default, shape5, containerColor, 0L, f5, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i11) {
                            PaddingValues paddingValues;
                            ComposerKt.sourceInformation(composer3, "C87@4178L975:DatePickerDialog.android.kt#uh7d8r");
                            if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:87)");
                                }
                                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer3, 6);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                                Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1146374327, "C88@4251L9,90@4304L835:DatePickerDialog.android.kt#uh7d8r");
                                function33.invoke(columnScopeInstance, composer3, 6);
                                Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
                                paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                Modifier padding = PaddingKt.padding(align, paddingValues);
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(padding);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -552861241, "C96@4593L5,98@4674L10,95@4490L631:DatePickerDialog.android.kt#uh7d8r");
                                ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer3, 6), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), DialogTokens.INSTANCE.getActionLabelTextFont()), ComposableLambdaKt.composableLambda(composer3, 1174914401, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1
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

                                    public final void invoke(Composer composer4, int i12) {
                                        float f6;
                                        float f7;
                                        ComposerKt.sourceInformation(composer4, "C100@4777L322:DatePickerDialog.android.kt#uh7d8r");
                                        if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1174914401, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:100)");
                                            }
                                            f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                            f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                            final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                            final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                            AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.composableLambda(composer4, -330605494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i13) {
                                                    ComposerKt.sourceInformation(composer5, "C105@5058L15:DatePickerDialog.android.kt#uh7d8r");
                                                    if ((i13 & 3) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-330605494, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:104)");
                                                        }
                                                        Function2<Composer, Integer, Unit> function212 = function210;
                                                        composer5.startReplaceableGroup(1914517404);
                                                        ComposerKt.sourceInformation(composer5, "104@5021L8");
                                                        if (function212 != null) {
                                                            function212.invoke(composer5, 0);
                                                            Unit unit = Unit.INSTANCE;
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        function211.invoke(composer5, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 438);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 384);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, 12582918, 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        function24 = function2522222;
        shape3 = shape422222;
        f3 = f422222;
        datePickerColors3 = datePickerColors422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    static {
        float f = 8;
        DialogButtonsPadding = PaddingKt.m1061PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.constructor-impl(6), Dp.constructor-impl(f), 3, null);
        DialogButtonsMainAxisSpacing = Dp.constructor-impl(f);
    }
}
