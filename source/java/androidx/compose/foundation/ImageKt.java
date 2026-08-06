package androidx.compose.foundation;

import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ClipKt;
import androidx.compose.p002ui.draw.PainterModifierKt;
import androidx.compose.p002ui.graphics.ColorFilter;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.FilterQuality;
import androidx.compose.p002ui.graphics.ImageBitmap;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.graphics.painter.BitmapPainter;
import androidx.compose.p002ui.graphics.painter.BitmapPainterKt;
import androidx.compose.p002ui.graphics.painter.Painter;
import androidx.compose.p002ui.graphics.vector.ImageVector;
import androidx.compose.p002ui.graphics.vector.VectorPainter;
import androidx.compose.p002ui.graphics.vector.VectorPainterKt;
import androidx.compose.p002ui.layout.ContentScale;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Image$lambda$4(Painter painter, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, int i2, Composer composer, int i3) {
        Image(painter, str, modifier, alignment, contentScale, f, colorFilter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2123228673, "C(Image)N(bitmap,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)99@4665L178:Image.kt#71ulvw");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, i, -1, "androidx.compose.foundation.Image (Image.kt:98)");
        }
        m472Image5hnEew(imageBitmap, str, modifier2, center, fit, f2, colorFilter2, FilterQuality.INSTANCE.m4940getLowfv9h1I(), composer, (i & 14) | (i & 112) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (i & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* renamed from: Image-5h-nEew, reason: not valid java name */
    public static final void m472Image5hnEew(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -1396260732, "C(Image)N(bitmap,contentDescription,modifier,alignment,contentScale,alpha,colorFilter,filterQuality:c#ui.graphics.FilterQuality)157@7327L73,158@7405L249:Image.kt#71ulvw");
        Modifier.Companion companion = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i3 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i3 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i3 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i3 & 64) != 0 ? null : colorFilter;
        int m5420getDefaultFilterQualityfv9h1I = (i3 & Fields.SpotShadowColor) != 0 ? DrawScope.INSTANCE.m5420getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396260732, i2, -1, "androidx.compose.foundation.Image (Image.kt:156)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1776754419, "CC(remember):Image.kt#9igjgp");
        boolean changed = composer.changed(imageBitmap);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = BitmapPainterKt.m5540BitmapPainterQZhYCtY$default(imageBitmap, 0L, 0L, m5420getDefaultFilterQualityfv9h1I, 6, null);
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Image((BitmapPainter) rememberedValue, str, companion, center, fit, f2, colorFilter2, composer, (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (i2 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void Image(ImageVector imageVector, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1595907091, "C(Image)N(imageVector,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)203@9457L34,202@9432L270:Image.kt#71ulvw");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, i, -1, "androidx.compose.foundation.Image (Image.kt:202)");
        }
        Image(VectorPainterKt.rememberVectorPainter(imageVector, composer, i & 14), str, modifier2, center, fit, f2, colorFilter2, composer, VectorPainter.$stable | (i & 112) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (i & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Image(final Painter painter, final String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Alignment alignment2;
        int i5;
        ContentScale contentScale2;
        int i6;
        float f2;
        int i7;
        final Modifier modifier3;
        final Alignment alignment3;
        final ContentScale contentScale3;
        final float f3;
        final ColorFilter colorFilter2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(1142754848);
        ComposerKt.sourceInformation(startRestartGroup, "C(Image)N(painter,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)271@12440L88,260@12135L393:Image.kt#71ulvw");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                alignment2 = alignment;
                i3 |= startRestartGroup.changed(alignment2) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    contentScale2 = contentScale;
                    i3 |= startRestartGroup.changed(contentScale2) ? Fields.Clip : Fields.Shape;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= 196608;
                    } else if ((196608 & i) == 0) {
                        f2 = f;
                        i3 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changed(colorFilter) ? 1048576 : Fields.BlendMode;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            alignment3 = alignment2;
                            contentScale3 = contentScale2;
                            f3 = f2;
                            colorFilter2 = colorFilter;
                        } else {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            Alignment center = i4 != 0 ? Alignment.INSTANCE.getCenter() : alignment2;
                            ContentScale fit = i5 != 0 ? ContentScale.INSTANCE.getFit() : contentScale2;
                            float f4 = i6 != 0 ? 1.0f : f2;
                            ColorFilter colorFilter3 = i7 != 0 ? null : colorFilter;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                            }
                            if (str != null) {
                                startRestartGroup.startReplaceGroup(1899234820);
                                ComposerKt.sourceInformation(startRestartGroup, "250@11847L115");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1324206669, "CC(remember):Image.kt#9igjgp");
                                boolean z = (i3 & 112) == 32;
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj) {
                                            Unit Image$lambda$2$lambda$1;
                                            Image$lambda$2$lambda$1 = ImageKt.Image$lambda$2$lambda$1(str, (SemanticsPropertyReceiver) obj);
                                            return Image$lambda$2$lambda$1;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                companion = SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, (Object) null);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(1899393602);
                                startRestartGroup.endReplaceGroup();
                                companion = Modifier.INSTANCE;
                            }
                            Modifier paint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(companion)), painter, false, center, fit, f4, colorFilter3, 2, null);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1324187720, "CC(remember):Image.kt#9igjgp");
                            ImageKt$Image$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = ImageKt$Image$1$1.INSTANCE;
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 544976794, "CC(Layout)P(1)122@4875L27,125@5041L333:Layout.kt#80mrfh");
                            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default);
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
                            Updater.m4116setimpl(m4109constructorimpl, measurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
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
                            alignment3 = center;
                            f3 = f4;
                            contentScale3 = fit;
                            modifier3 = modifier2;
                            colorFilter2 = colorFilter3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit Image$lambda$4;
                                    Image$lambda$4 = ImageKt.Image$lambda$4(Painter.this, str, modifier3, alignment3, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return Image$lambda$4;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    f2 = f;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                contentScale2 = contentScale;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                f2 = f;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            alignment2 = alignment;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            contentScale2 = contentScale;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            f2 = f;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        alignment2 = alignment;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        contentScale2 = contentScale;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        f2 = f;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Image$lambda$2$lambda$1(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getImage-o7Vup1c());
        return Unit.INSTANCE;
    }
}
