package com.bytedance.trae.design.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.design.compose.TraeContextMenuPosition;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResources_androidKt;

/* compiled from: TraeContextMenuPopup.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001aý\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0004\b#\u0010$\u001aA\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003¢\u0006\u0004\b+\u0010,\u001aO\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0003¢\u0006\u0004\b/\u00100\u001a\u0012\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\"H\u0002¨\u00063²\u0006\n\u0010'\u001a\u00020(X\u008a\u008e\u0002"}, d2 = {"TraeContextMenuPopup", "", "items", "", "Lcom/bytedance/trae/design/compose/TraeContextMenuItem;", NewTaskTracker.Param.POSITION, "Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "menuWidth", "Landroidx/compose/ui/unit/Dp;", "itemHeight", "cornerRadius", "elevation", "dividerHeight", "showDividers", "", "showLastDivider", "overlayDividers", "dividerHorizontalPadding", "horizontalPadding", "iconTextGap", "trailingIconSize", "trailingIconTextGap", "contentEndPadding", "shadowPadding", "Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;", "dividerColor", "Landroidx/compose/ui/graphics/Color;", "defaultTextColor", "backgroundColor", "contentDescription", "", "TraeContextMenuPopup-_G194Zc", "(Ljava/util/List;Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;FFFFFZZZFFFFFFLcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;JJJLjava/lang/String;Landroidx/compose/runtime/Composer;IIII)V", "calculateMenuOffset", "Landroidx/compose/ui/unit/IntOffset;", "rootSize", "Landroidx/compose/ui/unit/IntSize;", "itemCount", "", "calculateMenuOffset-7bnJ_2g", "(Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;JFFILcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/unit/IntOffset;", "TraeContextMenuRow", "item", "TraeContextMenuRow-oeDw4jE", "(Lcom/bytedance/trae/design/compose/TraeContextMenuItem;FFFFFFJLandroidx/compose/runtime/Composer;I)V", "contentDescriptionModifier", "description", "design-system-compose_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeContextMenuPopupKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraeContextMenuPopup__G194Zc$lambda$13(List list, TraeContextMenuPosition traeContextMenuPosition, Function0 function0, Modifier modifier, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, boolean z3, float f6, float f7, float f8, float f9, float f10, float f11, TraeContextMenuShadowPadding traeContextMenuShadowPadding, long j, long j2, long j3, String str, int i, int i2, int i3, int i4, Composer composer, int i5) {
        m1846TraeContextMenuPopup_G194Zc(list, traeContextMenuPosition, function0, modifier, f, f2, f3, f4, f5, z, z2, z3, f6, f7, f8, f9, f10, f11, traeContextMenuShadowPadding, j, j2, j3, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraeContextMenuRow_oeDw4jE$lambda$18(TraeContextMenuItem traeContextMenuItem, float f, float f2, float f3, float f4, float f5, float f6, long j, int i, Composer composer, int i2) {
        m1847TraeContextMenuRowoeDw4jE(traeContextMenuItem, f, f2, f3, f4, f5, f6, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0a6f  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0a40  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0a11  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02da  */
    /* renamed from: TraeContextMenuPopup-_G194Zc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1846TraeContextMenuPopup_G194Zc(final List<TraeContextMenuItem> list, final TraeContextMenuPosition traeContextMenuPosition, final Function0<Unit> function0, Modifier modifier, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, boolean z3, float f6, float f7, float f8, float f9, float f10, float f11, TraeContextMenuShadowPadding traeContextMenuShadowPadding, long j, long j2, long j3, String str, Composer composer, final int i, final int i2, final int i3, final int i4) {
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
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        float f12;
        float f13;
        boolean z4;
        long j4;
        long j5;
        long j6;
        float f14;
        float f15;
        String str2;
        int i27;
        long j7;
        int i28;
        long j8;
        Modifier modifier2;
        float f16;
        float f17;
        TraeContextMenuShadowPadding traeContextMenuShadowPadding2;
        float f18;
        long j9;
        float f19;
        float f20;
        float f21;
        boolean z5;
        boolean z6;
        float f22;
        int currentCompositeKeyHash;
        Composer composer2;
        Object rememberedValue;
        Object rememberedValue2;
        Object obj;
        Object rememberedValue3;
        int currentCompositeKeyHash2;
        Composer composer3;
        IntOffset m1848calculateMenuOffset7bnJ_2g;
        float f23;
        float f24;
        float f25;
        float f26;
        final boolean z7;
        final float f27;
        final float f28;
        final float f29;
        final float f30;
        final float f31;
        final float f32;
        final boolean z8;
        final float f33;
        final float f34;
        final float f35;
        final TraeContextMenuShadowPadding traeContextMenuShadowPadding3;
        final long j10;
        final long j11;
        final long j12;
        final String str3;
        final Modifier modifier3;
        final float f36;
        final boolean z9;
        final float f37;
        float f38;
        float f39;
        ScopeUpdateScope endRestartGroup;
        int i29;
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(traeContextMenuPosition, NewTaskTracker.Param.POSITION);
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Composer startRestartGroup = composer.startRestartGroup(671981591);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 6) == 0) {
            i5 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 48) == 0) {
            i5 |= startRestartGroup.changed(traeContextMenuPosition) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i & 384) == 0) {
            i5 |= startRestartGroup.changedInstance(function0) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        int i30 = i4 & 8;
        if (i30 != 0) {
            i5 |= 3072;
        } else if ((i & 3072) == 0) {
            i5 |= startRestartGroup.changed(modifier) ? 2048 : 1024;
            i6 = i4 & 16;
            if (i6 == 0) {
                i5 |= 24576;
            } else if ((i & 24576) == 0) {
                i5 |= startRestartGroup.changed(f) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= 196608;
                } else if ((i & 196608) == 0) {
                    i5 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                }
                i8 = i4 & 64;
                if (i8 != 0) {
                    i5 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i5 |= startRestartGroup.changed(f3) ? 1048576 : 524288;
                }
                i9 = i4 & 128;
                if (i9 != 0) {
                    i5 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i5 |= startRestartGroup.changed(f4) ? 8388608 : 4194304;
                }
                i10 = i4 & StatusBarUtils.FLAG_NOTCH_SUPPORT;
                if (i10 != 0) {
                    i5 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i5 |= startRestartGroup.changed(f5) ? 67108864 : 33554432;
                }
                i11 = i4 & StatusBarUtils.FLAG_NOTCH_PORTRAIT;
                if (i11 != 0) {
                    i5 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i5 |= startRestartGroup.changed(z) ? 536870912 : 268435456;
                }
                i12 = i4 & 1024;
                if (i12 != 0) {
                    i13 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    i13 = i2 | (startRestartGroup.changed(z2) ? 4 : 2);
                } else {
                    i13 = i2;
                }
                i14 = i4 & 2048;
                if (i14 != 0) {
                    i13 |= 48;
                } else if ((i2 & 48) == 0) {
                    i13 |= startRestartGroup.changed(z3) ? 32 : 16;
                }
                int i31 = i13;
                i15 = i4 & 4096;
                if (i15 != 0) {
                    i31 |= 384;
                } else if ((i2 & 384) == 0) {
                    i31 |= startRestartGroup.changed(f6) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
                    i16 = i4 & FConstants.DOWNLOAD_BUFFER_SIZE;
                    if (i16 == 0) {
                        i31 |= 3072;
                    } else if ((i2 & 3072) == 0) {
                        i31 |= startRestartGroup.changed(f7) ? 2048 : 1024;
                        i17 = i4 & 16384;
                        if (i17 != 0) {
                            i31 |= 24576;
                            i18 = i17;
                        } else {
                            i18 = i17;
                            if ((i2 & 24576) == 0) {
                                i31 |= startRestartGroup.changed(f8) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
                                i19 = i4 & 32768;
                                if (i19 == 0) {
                                    i31 |= 196608;
                                } else if ((i2 & 196608) == 0) {
                                    i31 |= startRestartGroup.changed(f9) ? 131072 : 65536;
                                }
                                i20 = i4 & 65536;
                                if (i20 == 0) {
                                    i31 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i31 |= startRestartGroup.changed(f10) ? 1048576 : 524288;
                                }
                                i21 = i4 & 131072;
                                if (i21 == 0) {
                                    i31 |= 12582912;
                                } else if ((i2 & 12582912) == 0) {
                                    i31 |= startRestartGroup.changed(f11) ? 8388608 : 4194304;
                                }
                                i22 = i4 & 262144;
                                if (i22 == 0) {
                                    i31 |= 100663296;
                                } else if ((i2 & 100663296) == 0) {
                                    i31 |= startRestartGroup.changed(traeContextMenuShadowPadding) ? 67108864 : 33554432;
                                }
                                if ((i2 & 805306368) != 0) {
                                    if ((i4 & FConstants.SLICE_SIZE) == 0) {
                                        i23 = i15;
                                        i24 = i16;
                                        if (startRestartGroup.changed(j)) {
                                            i29 = 536870912;
                                            i31 |= i29;
                                        }
                                    } else {
                                        i23 = i15;
                                        i24 = i16;
                                    }
                                    i29 = 268435456;
                                    i31 |= i29;
                                } else {
                                    i23 = i15;
                                    i24 = i16;
                                }
                                if ((i3 & 6) != 0) {
                                    i25 = i3 | (((i4 & 1048576) == 0 && startRestartGroup.changed(j2)) ? 4 : 2);
                                } else {
                                    i25 = i3;
                                }
                                if ((i3 & 48) == 0) {
                                    i25 |= ((i4 & 2097152) == 0 && startRestartGroup.changed(j3)) ? 32 : 16;
                                }
                                int i32 = i25;
                                i26 = i4 & 4194304;
                                if (i26 == 0) {
                                    i32 |= 384;
                                } else if ((i3 & 384) == 0) {
                                    i32 |= startRestartGroup.changed(str) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
                                    if ((306783379 & i5) == 306783378 || (306783379 & i31) != 306783378 || (i32 & 147) != 146 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            Modifier modifier4 = i30 != 0 ? (Modifier) Modifier.Companion : modifier;
                                            f12 = i6 != 0 ? Dp.constructor-impl(180) : f;
                                            f13 = i7 != 0 ? Dp.constructor-impl(44) : f2;
                                            Modifier modifier5 = modifier4;
                                            float f40 = i8 != 0 ? Dp.constructor-impl(20) : f3;
                                            float f41 = i9 != 0 ? Dp.constructor-impl(40) : f4;
                                            float f42 = f40;
                                            float f43 = i10 != 0 ? Dp.constructor-impl((float) 0.5d) : f5;
                                            boolean z10 = i11 != 0 ? true : z;
                                            boolean z11 = i12 != 0 ? false : z2;
                                            boolean z12 = i14 != 0 ? false : z3;
                                            float f44 = i23 != 0 ? Dp.constructor-impl(0) : f6;
                                            float f45 = i24 != 0 ? Dp.constructor-impl(16) : f7;
                                            float f46 = f43;
                                            float f47 = i18 != 0 ? Dp.constructor-impl(13) : f8;
                                            float f48 = i19 != 0 ? Dp.constructor-impl(18) : f9;
                                            float f49 = i20 != 0 ? Dp.constructor-impl(8) : f10;
                                            z4 = z10;
                                            float f50 = i21 != 0 ? Dp.constructor-impl(0) : f11;
                                            TraeContextMenuShadowPadding traeContextMenuShadowPadding4 = i22 != 0 ? new TraeContextMenuShadowPadding(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : traeContextMenuShadowPadding;
                                            if ((i4 & FConstants.SLICE_SIZE) != 0) {
                                                j4 = TraeTheme.INSTANCE.getColors(startRestartGroup, 6).mo1613getBorderBorderNeutralL10d7_KjU();
                                                i31 &= -1879048193;
                                            } else {
                                                j4 = j;
                                            }
                                            if ((i4 & 1048576) != 0) {
                                                j5 = TraeTheme.INSTANCE.getColors(startRestartGroup, 6).mo1806getTextTextDefault0d7_KjU();
                                                i32 &= -15;
                                            } else {
                                                j5 = j2;
                                            }
                                            if ((2097152 & i4) != 0) {
                                                j6 = TraeTheme.INSTANCE.getColors(startRestartGroup, 6).mo1592getBgBgBaseDefault0d7_KjU();
                                                i32 &= -113;
                                            } else {
                                                j6 = j3;
                                            }
                                            if (i26 != 0) {
                                                f14 = f47;
                                                f15 = f48;
                                                i27 = i32;
                                                j7 = j6;
                                                i28 = i31;
                                                j8 = j5;
                                                str2 = null;
                                            } else {
                                                f14 = f47;
                                                f15 = f48;
                                                str2 = str;
                                                i27 = i32;
                                                j7 = j6;
                                                i28 = i31;
                                                j8 = j5;
                                            }
                                            modifier2 = modifier5;
                                            f16 = f42;
                                            f17 = f41;
                                            traeContextMenuShadowPadding2 = traeContextMenuShadowPadding4;
                                            f18 = f45;
                                            j9 = j4;
                                            f19 = f49;
                                            f20 = f50;
                                            f21 = f44;
                                            z5 = z12;
                                            z6 = z11;
                                            f22 = f46;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i4 & FConstants.SLICE_SIZE) != 0) {
                                                i31 &= -1879048193;
                                            }
                                            if ((i4 & 1048576) != 0) {
                                                i32 &= -15;
                                            }
                                            if ((2097152 & i4) != 0) {
                                                i32 &= -113;
                                            }
                                            f12 = f;
                                            f13 = f2;
                                            f16 = f3;
                                            f17 = f4;
                                            f22 = f5;
                                            z4 = z;
                                            z6 = z2;
                                            z5 = z3;
                                            f21 = f6;
                                            f14 = f8;
                                            f15 = f9;
                                            f19 = f10;
                                            f20 = f11;
                                            traeContextMenuShadowPadding2 = traeContextMenuShadowPadding;
                                            j9 = j;
                                            j8 = j2;
                                            j7 = j3;
                                            str2 = str;
                                            i27 = i32;
                                            i28 = i31;
                                            modifier2 = modifier;
                                            f18 = f7;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(671981591, i5, i28, "com.bytedance.trae.design.compose.TraeContextMenuPopup (TraeContextMenuPopup.kt:95)");
                                        }
                                        float f51 = f22;
                                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                        Modifier modifier6 = modifier2;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        float f52 = f21;
                                        boolean z13 = z5;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        startRestartGroup.startReusableNode();
                                        if (startRestartGroup.getInserting()) {
                                            startRestartGroup.createNode(constructor);
                                        } else {
                                            startRestartGroup.useNode();
                                        }
                                        composer2 = Updater.constructor-impl(startRestartGroup);
                                        Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                        startRestartGroup.startReplaceGroup(-2027001546);
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (MutableInteractionSource) rememberedValue, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null), startRestartGroup, 0);
                                        startRestartGroup.startReplaceGroup(-2026990312);
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                            obj = null;
                                            rememberedValue2 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        } else {
                                            obj = null;
                                        }
                                        final MutableState mutableState = (MutableState) rememberedValue2;
                                        startRestartGroup.endReplaceGroup();
                                        Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, obj);
                                        startRestartGroup.startReplaceGroup(-2026985339);
                                        rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                            rememberedValue3 = new Function1() { // from class: com.bytedance.trae.design.compose.TraeContextMenuPopupKt$$ExternalSyntheticLambda0
                                                public final Object invoke(Object obj2) {
                                                    Unit TraeContextMenuPopup__G194Zc$lambda$12$lambda$5$lambda$4;
                                                    TraeContextMenuPopup__G194Zc$lambda$12$lambda$5$lambda$4 = TraeContextMenuPopupKt.TraeContextMenuPopup__G194Zc$lambda$12$lambda$5$lambda$4(mutableState, (LayoutCoordinates) obj2);
                                                    return TraeContextMenuPopup__G194Zc$lambda$12$lambda$5$lambda$4;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default2, (Function1) rememberedValue3);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
                                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                        float f53 = f18;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        startRestartGroup.startReusableNode();
                                        if (startRestartGroup.getInserting()) {
                                            startRestartGroup.createNode(constructor2);
                                        } else {
                                            startRestartGroup.useNode();
                                        }
                                        composer3 = Updater.constructor-impl(startRestartGroup);
                                        Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (!composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                        startRestartGroup.startReplaceGroup(-2021344511);
                                        int i33 = i5 >> 6;
                                        m1848calculateMenuOffset7bnJ_2g = m1848calculateMenuOffset7bnJ_2g(traeContextMenuPosition, TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(mutableState), f12, f13, list.size(), traeContextMenuShadowPadding2, startRestartGroup, ((i5 >> 3) & 14) | (i33 & 896) | (i33 & 7168) | ((i28 >> 9) & 458752));
                                        if (m1848calculateMenuOffset7bnJ_2g == null) {
                                            f23 = f16;
                                            f24 = f17;
                                            f25 = f51;
                                            f26 = f52;
                                            startRestartGroup.endReplaceGroup();
                                        } else {
                                            final long j13 = m1848calculateMenuOffset7bnJ_2g.unbox-impl();
                                            Modifier modifier7 = Modifier.Companion;
                                            startRestartGroup.startReplaceGroup(-342289832);
                                            boolean changed = startRestartGroup.changed(j13);
                                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                                            if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                                                rememberedValue4 = new Function1() { // from class: com.bytedance.trae.design.compose.TraeContextMenuPopupKt$$ExternalSyntheticLambda1
                                                    public final Object invoke(Object obj2) {
                                                        IntOffset m868x7894b940;
                                                        m868x7894b940 = TraeContextMenuPopupKt.m868x7894b940(j13, (Density) obj2);
                                                        return m868x7894b940;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            Modifier then = BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(PaddingKt.padding-qDBjuR0(SizeKt.width-3ABfNKs(OffsetKt.offset(modifier7, (Function1) rememberedValue4), Dp.constructor-impl(Dp.constructor-impl(traeContextMenuShadowPadding2.m1863getStartD9Ej5fM() + f12) + traeContextMenuShadowPadding2.m1862getEndD9Ej5fM())), traeContextMenuShadowPadding2.m1863getStartD9Ej5fM(), traeContextMenuShadowPadding2.m1864getTopD9Ej5fM(), traeContextMenuShadowPadding2.m1862getEndD9Ej5fM(), traeContextMenuShadowPadding2.m1861getBottomD9Ej5fM()), f17, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f16), false, 0L, 0L, 24, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f16)), j7, (Shape) null, 2, (Object) null).then(contentDescriptionModifier(str2));
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                                            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor3);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            Composer composer4 = Updater.constructor-impl(startRestartGroup);
                                            Updater.set-impl(composer4, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                composer4.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                            }
                                            Updater.set-impl(composer4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                            startRestartGroup.startReplaceGroup(1850697387);
                                            Iterator it = list.iterator();
                                            int i34 = 0;
                                            while (it.hasNext()) {
                                                Object next = it.next();
                                                int i35 = i34 + 1;
                                                if (i34 < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                TraeContextMenuItem traeContextMenuItem = (TraeContextMenuItem) next;
                                                boolean z14 = z4 && (z6 || i34 != CollectionsKt.getLastIndex(list));
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                Modifier modifier8 = Modifier.Companion;
                                                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                Iterator it2 = it;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier8);
                                                Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                                                float f54 = f16;
                                                float f55 = f17;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                startRestartGroup.startReusableNode();
                                                if (startRestartGroup.getInserting()) {
                                                    startRestartGroup.createNode(constructor4);
                                                } else {
                                                    startRestartGroup.useNode();
                                                }
                                                Composer composer5 = Updater.constructor-impl(startRestartGroup);
                                                Updater.set-impl(composer5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                    composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                    composer5.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                }
                                                Updater.set-impl(composer5, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                                                int i36 = i28 >> 3;
                                                m1847TraeContextMenuRowoeDw4jE(traeContextMenuItem, f13, f53, f14, f15, f19, f20, j8, startRestartGroup, ((i5 >> 12) & 112) | (i36 & 896) | (i36 & 7168) | (57344 & i36) | (458752 & i36) | (i36 & 3670016) | ((i27 << 21) & 29360128));
                                                startRestartGroup.startReplaceGroup(248891201);
                                                if (z14 && z13) {
                                                    f39 = f52;
                                                    f38 = f51;
                                                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(boxScope3.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), f39, 0.0f, 2, (Object) null), f38), j9, (Shape) null, 2, (Object) null), startRestartGroup, 0);
                                                } else {
                                                    f38 = f51;
                                                    f39 = f52;
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                startRestartGroup.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                startRestartGroup.startReplaceGroup(1850737793);
                                                if (z14 && !z13) {
                                                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), f39, 0.0f, 2, (Object) null), f38), j9, (Shape) null, 2, (Object) null), startRestartGroup, 0);
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                it = it2;
                                                f17 = f55;
                                                f51 = f38;
                                                f52 = f39;
                                                i34 = i35;
                                                f16 = f54;
                                            }
                                            f23 = f16;
                                            f24 = f17;
                                            f25 = f51;
                                            f26 = f52;
                                            startRestartGroup.endReplaceGroup();
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endReplaceGroup();
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        z7 = z13;
                                        f27 = f53;
                                        f28 = f24;
                                        f29 = f25;
                                        f30 = f26;
                                        f31 = f12;
                                        f32 = f14;
                                        z8 = z4;
                                        f33 = f15;
                                        f34 = f19;
                                        f35 = f20;
                                        traeContextMenuShadowPadding3 = traeContextMenuShadowPadding2;
                                        j10 = j9;
                                        j11 = j8;
                                        j12 = j7;
                                        str3 = str2;
                                        modifier3 = modifier6;
                                        f36 = f23;
                                        float f56 = f13;
                                        z9 = z6;
                                        f37 = f56;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        modifier3 = modifier;
                                        f31 = f;
                                        f37 = f2;
                                        f36 = f3;
                                        f28 = f4;
                                        f29 = f5;
                                        z8 = z;
                                        z9 = z2;
                                        z7 = z3;
                                        f30 = f6;
                                        f27 = f7;
                                        f32 = f8;
                                        f33 = f9;
                                        f34 = f10;
                                        f35 = f11;
                                        traeContextMenuShadowPadding3 = traeContextMenuShadowPadding;
                                        j10 = j;
                                        j11 = j2;
                                        j12 = j3;
                                        str3 = str;
                                    }
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.design.compose.TraeContextMenuPopupKt$$ExternalSyntheticLambda2
                                            public final Object invoke(Object obj2, Object obj3) {
                                                Unit TraeContextMenuPopup__G194Zc$lambda$13;
                                                TraeContextMenuPopup__G194Zc$lambda$13 = TraeContextMenuPopupKt.TraeContextMenuPopup__G194Zc$lambda$13(list, traeContextMenuPosition, function0, modifier3, f31, f37, f36, f28, f29, z8, z9, z7, f30, f27, f32, f33, f34, f35, traeContextMenuShadowPadding3, j10, j11, j12, str3, i, i2, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                                                return TraeContextMenuPopup__G194Zc$lambda$13;
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                if ((306783379 & i5) == 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0) {
                                }
                                if (i30 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 != 0) {
                                }
                                Modifier modifier52 = modifier4;
                                if (i8 != 0) {
                                }
                                float f412 = i9 != 0 ? Dp.constructor-impl(40) : f4;
                                float f422 = f40;
                                if (i10 != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i12 != 0) {
                                }
                                if (i14 != 0) {
                                }
                                if (i23 != 0) {
                                }
                                if (i24 != 0) {
                                }
                                float f462 = f43;
                                float f472 = i18 != 0 ? Dp.constructor-impl(13) : f8;
                                float f482 = i19 != 0 ? Dp.constructor-impl(18) : f9;
                                float f492 = i20 != 0 ? Dp.constructor-impl(8) : f10;
                                z4 = z10;
                                if (i21 != 0) {
                                }
                                float f502 = i21 != 0 ? Dp.constructor-impl(0) : f11;
                                TraeContextMenuShadowPadding traeContextMenuShadowPadding42 = i22 != 0 ? new TraeContextMenuShadowPadding(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : traeContextMenuShadowPadding;
                                if ((i4 & FConstants.SLICE_SIZE) != 0) {
                                }
                                if ((i4 & 1048576) != 0) {
                                }
                                if ((2097152 & i4) != 0) {
                                }
                                if (i26 != 0) {
                                }
                                modifier2 = modifier52;
                                f16 = f422;
                                f17 = f412;
                                traeContextMenuShadowPadding2 = traeContextMenuShadowPadding42;
                                f18 = f45;
                                j9 = j4;
                                f19 = f492;
                                f20 = f502;
                                f21 = f44;
                                z5 = z12;
                                z6 = z11;
                                f22 = f462;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                float f512 = f22;
                                Modifier fillMaxSize$default3 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                Modifier modifier62 = modifier2;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default3);
                                Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
                                float f522 = f21;
                                boolean z132 = z5;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                composer2 = Updater.constructor-impl(startRestartGroup);
                                Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer2, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer2.getInserting()) {
                                }
                                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash5);
                                Updater.set-impl(composer2, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                                startRestartGroup.startReplaceGroup(-2027001546);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                }
                                startRestartGroup.endReplaceGroup();
                                BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (MutableInteractionSource) rememberedValue, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null), startRestartGroup, 0);
                                startRestartGroup.startReplaceGroup(-2026990312);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                }
                                final MutableState mutableState2 = (MutableState) rememberedValue2;
                                startRestartGroup.endReplaceGroup();
                                Modifier fillMaxSize$default22 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, obj);
                                startRestartGroup.startReplaceGroup(-2026985339);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                }
                                startRestartGroup.endReplaceGroup();
                                Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default22, (Function1) rememberedValue3);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned2);
                                Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
                                float f532 = f18;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                composer3 = Updater.constructor-impl(startRestartGroup);
                                Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl(composer3, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!composer3.getInserting()) {
                                }
                                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                                Updater.set-impl(composer3, materializeModifier22, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                                startRestartGroup.startReplaceGroup(-2021344511);
                                int i332 = i5 >> 6;
                                m1848calculateMenuOffset7bnJ_2g = m1848calculateMenuOffset7bnJ_2g(traeContextMenuPosition, TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(mutableState2), f12, f13, list.size(), traeContextMenuShadowPadding2, startRestartGroup, ((i5 >> 3) & 14) | (i332 & 896) | (i332 & 7168) | ((i28 >> 9) & 458752));
                                if (m1848calculateMenuOffset7bnJ_2g == null) {
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                z7 = z132;
                                f27 = f532;
                                f28 = f24;
                                f29 = f25;
                                f30 = f26;
                                f31 = f12;
                                f32 = f14;
                                z8 = z4;
                                f33 = f15;
                                f34 = f19;
                                f35 = f20;
                                traeContextMenuShadowPadding3 = traeContextMenuShadowPadding2;
                                j10 = j9;
                                j11 = j8;
                                j12 = j7;
                                str3 = str2;
                                modifier3 = modifier62;
                                f36 = f23;
                                float f562 = f13;
                                z9 = z6;
                                f37 = f562;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                        }
                        i19 = i4 & 32768;
                        if (i19 == 0) {
                        }
                        i20 = i4 & 65536;
                        if (i20 == 0) {
                        }
                        i21 = i4 & 131072;
                        if (i21 == 0) {
                        }
                        i22 = i4 & 262144;
                        if (i22 == 0) {
                        }
                        if ((i2 & 805306368) != 0) {
                        }
                        if ((i3 & 6) != 0) {
                        }
                        if ((i3 & 48) == 0) {
                        }
                        int i322 = i25;
                        i26 = i4 & 4194304;
                        if (i26 == 0) {
                        }
                        if ((306783379 & i5) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i30 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        Modifier modifier522 = modifier4;
                        if (i8 != 0) {
                        }
                        float f4122 = i9 != 0 ? Dp.constructor-impl(40) : f4;
                        float f4222 = f40;
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i23 != 0) {
                        }
                        if (i24 != 0) {
                        }
                        float f4622 = f43;
                        float f4722 = i18 != 0 ? Dp.constructor-impl(13) : f8;
                        float f4822 = i19 != 0 ? Dp.constructor-impl(18) : f9;
                        float f4922 = i20 != 0 ? Dp.constructor-impl(8) : f10;
                        z4 = z10;
                        if (i21 != 0) {
                        }
                        float f5022 = i21 != 0 ? Dp.constructor-impl(0) : f11;
                        TraeContextMenuShadowPadding traeContextMenuShadowPadding422 = i22 != 0 ? new TraeContextMenuShadowPadding(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : traeContextMenuShadowPadding;
                        if ((i4 & FConstants.SLICE_SIZE) != 0) {
                        }
                        if ((i4 & 1048576) != 0) {
                        }
                        if ((2097152 & i4) != 0) {
                        }
                        if (i26 != 0) {
                        }
                        modifier2 = modifier522;
                        f16 = f4222;
                        f17 = f4122;
                        traeContextMenuShadowPadding2 = traeContextMenuShadowPadding422;
                        f18 = f45;
                        j9 = j4;
                        f19 = f4922;
                        f20 = f5022;
                        f21 = f44;
                        z5 = z12;
                        z6 = z11;
                        f22 = f4622;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        float f5122 = f22;
                        Modifier fillMaxSize$default32 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy42 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        Modifier modifier622 = modifier2;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap52 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier52 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default32);
                        Function0 constructor52 = ComposeUiNode.Companion.getConstructor();
                        float f5222 = f21;
                        boolean z1322 = z5;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        composer2 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy42, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash52 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                        }
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash52);
                        Updater.set-impl(composer2, materializeModifier52, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope42 = BoxScopeInstance.INSTANCE;
                        startRestartGroup.startReplaceGroup(-2027001546);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceGroup();
                        BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (MutableInteractionSource) rememberedValue, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null), startRestartGroup, 0);
                        startRestartGroup.startReplaceGroup(-2026990312);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        final MutableState mutableState22 = (MutableState) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        Modifier fillMaxSize$default222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, obj);
                        startRestartGroup.startReplaceGroup(-2026985339);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default222, (Function1) rememberedValue3);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned22);
                        Function0 constructor222 = ComposeUiNode.Companion.getConstructor();
                        float f5322 = f18;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        composer3 = Updater.constructor-impl(startRestartGroup);
                        Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy222, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer3, currentCompositionLocalMap222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer3.getInserting()) {
                        }
                        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                        Updater.set-impl(composer3, materializeModifier222, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope222 = BoxScopeInstance.INSTANCE;
                        startRestartGroup.startReplaceGroup(-2021344511);
                        int i3322 = i5 >> 6;
                        m1848calculateMenuOffset7bnJ_2g = m1848calculateMenuOffset7bnJ_2g(traeContextMenuPosition, TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(mutableState22), f12, f13, list.size(), traeContextMenuShadowPadding2, startRestartGroup, ((i5 >> 3) & 14) | (i3322 & 896) | (i3322 & 7168) | ((i28 >> 9) & 458752));
                        if (m1848calculateMenuOffset7bnJ_2g == null) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z7 = z1322;
                        f27 = f5322;
                        f28 = f24;
                        f29 = f25;
                        f30 = f26;
                        f31 = f12;
                        f32 = f14;
                        z8 = z4;
                        f33 = f15;
                        f34 = f19;
                        f35 = f20;
                        traeContextMenuShadowPadding3 = traeContextMenuShadowPadding2;
                        j10 = j9;
                        j11 = j8;
                        j12 = j7;
                        str3 = str2;
                        modifier3 = modifier622;
                        f36 = f23;
                        float f5622 = f13;
                        z9 = z6;
                        f37 = f5622;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i17 = i4 & 16384;
                    if (i17 != 0) {
                    }
                    i19 = i4 & 32768;
                    if (i19 == 0) {
                    }
                    i20 = i4 & 65536;
                    if (i20 == 0) {
                    }
                    i21 = i4 & 131072;
                    if (i21 == 0) {
                    }
                    i22 = i4 & 262144;
                    if (i22 == 0) {
                    }
                    if ((i2 & 805306368) != 0) {
                    }
                    if ((i3 & 6) != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    int i3222 = i25;
                    i26 = i4 & 4194304;
                    if (i26 == 0) {
                    }
                    if ((306783379 & i5) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i30 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    Modifier modifier5222 = modifier4;
                    if (i8 != 0) {
                    }
                    float f41222 = i9 != 0 ? Dp.constructor-impl(40) : f4;
                    float f42222 = f40;
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i23 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    float f46222 = f43;
                    float f47222 = i18 != 0 ? Dp.constructor-impl(13) : f8;
                    float f48222 = i19 != 0 ? Dp.constructor-impl(18) : f9;
                    float f49222 = i20 != 0 ? Dp.constructor-impl(8) : f10;
                    z4 = z10;
                    if (i21 != 0) {
                    }
                    float f50222 = i21 != 0 ? Dp.constructor-impl(0) : f11;
                    TraeContextMenuShadowPadding traeContextMenuShadowPadding4222 = i22 != 0 ? new TraeContextMenuShadowPadding(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : traeContextMenuShadowPadding;
                    if ((i4 & FConstants.SLICE_SIZE) != 0) {
                    }
                    if ((i4 & 1048576) != 0) {
                    }
                    if ((2097152 & i4) != 0) {
                    }
                    if (i26 != 0) {
                    }
                    modifier2 = modifier5222;
                    f16 = f42222;
                    f17 = f41222;
                    traeContextMenuShadowPadding2 = traeContextMenuShadowPadding4222;
                    f18 = f45;
                    j9 = j4;
                    f19 = f49222;
                    f20 = f50222;
                    f21 = f44;
                    z5 = z12;
                    z6 = z11;
                    f22 = f46222;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    float f51222 = f22;
                    Modifier fillMaxSize$default322 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy422 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    Modifier modifier6222 = modifier2;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap522 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier522 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default322);
                    Function0 constructor522 = ComposeUiNode.Companion.getConstructor();
                    float f52222 = f21;
                    boolean z13222 = z5;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    composer2 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy422, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap522, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash522 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                    }
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash522);
                    Updater.set-impl(composer2, materializeModifier522, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope422 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(-2027001546);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (MutableInteractionSource) rememberedValue, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null), startRestartGroup, 0);
                    startRestartGroup.startReplaceGroup(-2026990312);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    final MutableState mutableState222 = (MutableState) rememberedValue2;
                    startRestartGroup.endReplaceGroup();
                    Modifier fillMaxSize$default2222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, obj);
                    startRestartGroup.startReplaceGroup(-2026985339);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier onGloballyPositioned222 = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default2222, (Function1) rememberedValue3);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned222);
                    Function0 constructor2222 = ComposeUiNode.Companion.getConstructor();
                    float f53222 = f18;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    composer3 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy2222, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer3.getInserting()) {
                    }
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
                    Updater.set-impl(composer3, materializeModifier2222, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope2222 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(-2021344511);
                    int i33222 = i5 >> 6;
                    m1848calculateMenuOffset7bnJ_2g = m1848calculateMenuOffset7bnJ_2g(traeContextMenuPosition, TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(mutableState222), f12, f13, list.size(), traeContextMenuShadowPadding2, startRestartGroup, ((i5 >> 3) & 14) | (i33222 & 896) | (i33222 & 7168) | ((i28 >> 9) & 458752));
                    if (m1848calculateMenuOffset7bnJ_2g == null) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z7 = z13222;
                    f27 = f53222;
                    f28 = f24;
                    f29 = f25;
                    f30 = f26;
                    f31 = f12;
                    f32 = f14;
                    z8 = z4;
                    f33 = f15;
                    f34 = f19;
                    f35 = f20;
                    traeContextMenuShadowPadding3 = traeContextMenuShadowPadding2;
                    j10 = j9;
                    j11 = j8;
                    j12 = j7;
                    str3 = str2;
                    modifier3 = modifier6222;
                    f36 = f23;
                    float f56222 = f13;
                    z9 = z6;
                    f37 = f56222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i16 = i4 & FConstants.DOWNLOAD_BUFFER_SIZE;
                if (i16 == 0) {
                }
                i17 = i4 & 16384;
                if (i17 != 0) {
                }
                i19 = i4 & 32768;
                if (i19 == 0) {
                }
                i20 = i4 & 65536;
                if (i20 == 0) {
                }
                i21 = i4 & 131072;
                if (i21 == 0) {
                }
                i22 = i4 & 262144;
                if (i22 == 0) {
                }
                if ((i2 & 805306368) != 0) {
                }
                if ((i3 & 6) != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                int i32222 = i25;
                i26 = i4 & 4194304;
                if (i26 == 0) {
                }
                if ((306783379 & i5) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i30 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                Modifier modifier52222 = modifier4;
                if (i8 != 0) {
                }
                float f412222 = i9 != 0 ? Dp.constructor-impl(40) : f4;
                float f422222 = f40;
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 != 0) {
                }
                if (i23 != 0) {
                }
                if (i24 != 0) {
                }
                float f462222 = f43;
                float f472222 = i18 != 0 ? Dp.constructor-impl(13) : f8;
                float f482222 = i19 != 0 ? Dp.constructor-impl(18) : f9;
                float f492222 = i20 != 0 ? Dp.constructor-impl(8) : f10;
                z4 = z10;
                if (i21 != 0) {
                }
                float f502222 = i21 != 0 ? Dp.constructor-impl(0) : f11;
                TraeContextMenuShadowPadding traeContextMenuShadowPadding42222 = i22 != 0 ? new TraeContextMenuShadowPadding(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : traeContextMenuShadowPadding;
                if ((i4 & FConstants.SLICE_SIZE) != 0) {
                }
                if ((i4 & 1048576) != 0) {
                }
                if ((2097152 & i4) != 0) {
                }
                if (i26 != 0) {
                }
                modifier2 = modifier52222;
                f16 = f422222;
                f17 = f412222;
                traeContextMenuShadowPadding2 = traeContextMenuShadowPadding42222;
                f18 = f45;
                j9 = j4;
                f19 = f492222;
                f20 = f502222;
                f21 = f44;
                z5 = z12;
                z6 = z11;
                f22 = f462222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                float f512222 = f22;
                Modifier fillMaxSize$default3222 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy4222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                Modifier modifier62222 = modifier2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier5222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default3222);
                Function0 constructor5222 = ComposeUiNode.Companion.getConstructor();
                float f522222 = f21;
                boolean z132222 = z5;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                composer2 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy4222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap5222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                }
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash5222);
                Updater.set-impl(composer2, materializeModifier5222, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope4222 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-2027001546);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (MutableInteractionSource) rememberedValue, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null), startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(-2026990312);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                }
                final MutableState mutableState2222 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Modifier fillMaxSize$default22222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, obj);
                startRestartGroup.startReplaceGroup(-2026985339);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier onGloballyPositioned2222 = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default22222, (Function1) rememberedValue3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy22222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned2222);
                Function0 constructor22222 = ComposeUiNode.Companion.getConstructor();
                float f532222 = f18;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                composer3 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy22222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap22222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash22222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                }
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
                Updater.set-impl(composer3, materializeModifier22222, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope22222 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-2021344511);
                int i332222 = i5 >> 6;
                m1848calculateMenuOffset7bnJ_2g = m1848calculateMenuOffset7bnJ_2g(traeContextMenuPosition, TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(mutableState2222), f12, f13, list.size(), traeContextMenuShadowPadding2, startRestartGroup, ((i5 >> 3) & 14) | (i332222 & 896) | (i332222 & 7168) | ((i28 >> 9) & 458752));
                if (m1848calculateMenuOffset7bnJ_2g == null) {
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                z7 = z132222;
                f27 = f532222;
                f28 = f24;
                f29 = f25;
                f30 = f26;
                f31 = f12;
                f32 = f14;
                z8 = z4;
                f33 = f15;
                f34 = f19;
                f35 = f20;
                traeContextMenuShadowPadding3 = traeContextMenuShadowPadding2;
                j10 = j9;
                j11 = j8;
                j12 = j7;
                str3 = str2;
                modifier3 = modifier62222;
                f36 = f23;
                float f562222 = f13;
                z9 = z6;
                f37 = f562222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            i8 = i4 & 64;
            if (i8 != 0) {
            }
            i9 = i4 & 128;
            if (i9 != 0) {
            }
            i10 = i4 & StatusBarUtils.FLAG_NOTCH_SUPPORT;
            if (i10 != 0) {
            }
            i11 = i4 & StatusBarUtils.FLAG_NOTCH_PORTRAIT;
            if (i11 != 0) {
            }
            i12 = i4 & 1024;
            if (i12 != 0) {
            }
            i14 = i4 & 2048;
            if (i14 != 0) {
            }
            int i312 = i13;
            i15 = i4 & 4096;
            if (i15 != 0) {
            }
            i16 = i4 & FConstants.DOWNLOAD_BUFFER_SIZE;
            if (i16 == 0) {
            }
            i17 = i4 & 16384;
            if (i17 != 0) {
            }
            i19 = i4 & 32768;
            if (i19 == 0) {
            }
            i20 = i4 & 65536;
            if (i20 == 0) {
            }
            i21 = i4 & 131072;
            if (i21 == 0) {
            }
            i22 = i4 & 262144;
            if (i22 == 0) {
            }
            if ((i2 & 805306368) != 0) {
            }
            if ((i3 & 6) != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            int i322222 = i25;
            i26 = i4 & 4194304;
            if (i26 == 0) {
            }
            if ((306783379 & i5) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i30 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            Modifier modifier522222 = modifier4;
            if (i8 != 0) {
            }
            float f4122222 = i9 != 0 ? Dp.constructor-impl(40) : f4;
            float f4222222 = f40;
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 != 0) {
            }
            if (i23 != 0) {
            }
            if (i24 != 0) {
            }
            float f4622222 = f43;
            float f4722222 = i18 != 0 ? Dp.constructor-impl(13) : f8;
            float f4822222 = i19 != 0 ? Dp.constructor-impl(18) : f9;
            float f4922222 = i20 != 0 ? Dp.constructor-impl(8) : f10;
            z4 = z10;
            if (i21 != 0) {
            }
            float f5022222 = i21 != 0 ? Dp.constructor-impl(0) : f11;
            TraeContextMenuShadowPadding traeContextMenuShadowPadding422222 = i22 != 0 ? new TraeContextMenuShadowPadding(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : traeContextMenuShadowPadding;
            if ((i4 & FConstants.SLICE_SIZE) != 0) {
            }
            if ((i4 & 1048576) != 0) {
            }
            if ((2097152 & i4) != 0) {
            }
            if (i26 != 0) {
            }
            modifier2 = modifier522222;
            f16 = f4222222;
            f17 = f4122222;
            traeContextMenuShadowPadding2 = traeContextMenuShadowPadding422222;
            f18 = f45;
            j9 = j4;
            f19 = f4922222;
            f20 = f5022222;
            f21 = f44;
            z5 = z12;
            z6 = z11;
            f22 = f4622222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            float f5122222 = f22;
            Modifier fillMaxSize$default32222 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy42222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            Modifier modifier622222 = modifier2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap52222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier52222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default32222);
            Function0 constructor52222 = ComposeUiNode.Companion.getConstructor();
            float f5222222 = f21;
            boolean z1322222 = z5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy42222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap52222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash52222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer2.getInserting()) {
            }
            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash52222);
            Updater.set-impl(composer2, materializeModifier52222, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope42222 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-2027001546);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (MutableInteractionSource) rememberedValue, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null), startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-2026990312);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
            }
            final MutableState mutableState22222 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxSize$default222222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, obj);
            startRestartGroup.startReplaceGroup(-2026985339);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned22222 = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default222222, (Function1) rememberedValue3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy222222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222222 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned22222);
            Function0 constructor222222 = ComposeUiNode.Companion.getConstructor();
            float f5322222 = f18;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy222222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash222222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting()) {
            }
            composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222222);
            Updater.set-impl(composer3, materializeModifier222222, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope222222 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-2021344511);
            int i3322222 = i5 >> 6;
            m1848calculateMenuOffset7bnJ_2g = m1848calculateMenuOffset7bnJ_2g(traeContextMenuPosition, TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(mutableState22222), f12, f13, list.size(), traeContextMenuShadowPadding2, startRestartGroup, ((i5 >> 3) & 14) | (i3322222 & 896) | (i3322222 & 7168) | ((i28 >> 9) & 458752));
            if (m1848calculateMenuOffset7bnJ_2g == null) {
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
            }
            z7 = z1322222;
            f27 = f5322222;
            f28 = f24;
            f29 = f25;
            f30 = f26;
            f31 = f12;
            f32 = f14;
            z8 = z4;
            f33 = f15;
            f34 = f19;
            f35 = f20;
            traeContextMenuShadowPadding3 = traeContextMenuShadowPadding2;
            j10 = j9;
            j11 = j8;
            j12 = j7;
            str3 = str2;
            modifier3 = modifier622222;
            f36 = f23;
            float f5622222 = f13;
            z9 = z6;
            f37 = f5622222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i4 & 16;
        if (i6 == 0) {
        }
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        i8 = i4 & 64;
        if (i8 != 0) {
        }
        i9 = i4 & 128;
        if (i9 != 0) {
        }
        i10 = i4 & StatusBarUtils.FLAG_NOTCH_SUPPORT;
        if (i10 != 0) {
        }
        i11 = i4 & StatusBarUtils.FLAG_NOTCH_PORTRAIT;
        if (i11 != 0) {
        }
        i12 = i4 & 1024;
        if (i12 != 0) {
        }
        i14 = i4 & 2048;
        if (i14 != 0) {
        }
        int i3122 = i13;
        i15 = i4 & 4096;
        if (i15 != 0) {
        }
        i16 = i4 & FConstants.DOWNLOAD_BUFFER_SIZE;
        if (i16 == 0) {
        }
        i17 = i4 & 16384;
        if (i17 != 0) {
        }
        i19 = i4 & 32768;
        if (i19 == 0) {
        }
        i20 = i4 & 65536;
        if (i20 == 0) {
        }
        i21 = i4 & 131072;
        if (i21 == 0) {
        }
        i22 = i4 & 262144;
        if (i22 == 0) {
        }
        if ((i2 & 805306368) != 0) {
        }
        if ((i3 & 6) != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        int i3222222 = i25;
        i26 = i4 & 4194304;
        if (i26 == 0) {
        }
        if ((306783379 & i5) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i30 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        Modifier modifier5222222 = modifier4;
        if (i8 != 0) {
        }
        float f41222222 = i9 != 0 ? Dp.constructor-impl(40) : f4;
        float f42222222 = f40;
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 != 0) {
        }
        if (i23 != 0) {
        }
        if (i24 != 0) {
        }
        float f46222222 = f43;
        float f47222222 = i18 != 0 ? Dp.constructor-impl(13) : f8;
        float f48222222 = i19 != 0 ? Dp.constructor-impl(18) : f9;
        float f49222222 = i20 != 0 ? Dp.constructor-impl(8) : f10;
        z4 = z10;
        if (i21 != 0) {
        }
        float f50222222 = i21 != 0 ? Dp.constructor-impl(0) : f11;
        TraeContextMenuShadowPadding traeContextMenuShadowPadding4222222 = i22 != 0 ? new TraeContextMenuShadowPadding(0.0f, 0.0f, 0.0f, 0.0f, 15, null) : traeContextMenuShadowPadding;
        if ((i4 & FConstants.SLICE_SIZE) != 0) {
        }
        if ((i4 & 1048576) != 0) {
        }
        if ((2097152 & i4) != 0) {
        }
        if (i26 != 0) {
        }
        modifier2 = modifier5222222;
        f16 = f42222222;
        f17 = f41222222;
        traeContextMenuShadowPadding2 = traeContextMenuShadowPadding4222222;
        f18 = f45;
        j9 = j4;
        f19 = f49222222;
        f20 = f50222222;
        f21 = f44;
        z5 = z12;
        z6 = z11;
        f22 = f46222222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        float f51222222 = f22;
        Modifier fillMaxSize$default322222 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy422222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        Modifier modifier6222222 = modifier2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap522222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier522222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default322222);
        Function0 constructor522222 = ComposeUiNode.Companion.getConstructor();
        float f52222222 = f21;
        boolean z13222222 = z5;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        composer2 = Updater.constructor-impl(startRestartGroup);
        Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy422222, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap522222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash522222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer2.getInserting()) {
        }
        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash522222);
        Updater.set-impl(composer2, materializeModifier522222, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        BoxScope boxScope422222 = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-2027001546);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (MutableInteractionSource) rememberedValue, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null), startRestartGroup, 0);
        startRestartGroup.startReplaceGroup(-2026990312);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
        }
        final MutableState mutableState222222 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        Modifier fillMaxSize$default2222222 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, obj);
        startRestartGroup.startReplaceGroup(-2026985339);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier onGloballyPositioned222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default2222222, (Function1) rememberedValue3);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy2222222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222222 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned222222);
        Function0 constructor2222222 = ComposeUiNode.Companion.getConstructor();
        float f53222222 = f18;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        composer3 = Updater.constructor-impl(startRestartGroup);
        Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy2222222, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap2222222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2222222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer3.getInserting()) {
        }
        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222222);
        Updater.set-impl(composer3, materializeModifier2222222, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        BoxScope boxScope2222222 = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-2021344511);
        int i33222222 = i5 >> 6;
        m1848calculateMenuOffset7bnJ_2g = m1848calculateMenuOffset7bnJ_2g(traeContextMenuPosition, TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(mutableState222222), f12, f13, list.size(), traeContextMenuShadowPadding2, startRestartGroup, ((i5 >> 3) & 14) | (i33222222 & 896) | (i33222222 & 7168) | ((i28 >> 9) & 458752));
        if (m1848calculateMenuOffset7bnJ_2g == null) {
        }
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z13222222;
        f27 = f53222222;
        f28 = f24;
        f29 = f25;
        f30 = f26;
        f31 = f12;
        f32 = f14;
        z8 = z4;
        f33 = f15;
        f34 = f19;
        f35 = f20;
        traeContextMenuShadowPadding3 = traeContextMenuShadowPadding2;
        j10 = j9;
        j11 = j8;
        j12 = j7;
        str3 = str2;
        modifier3 = modifier6222222;
        f36 = f23;
        float f56222222 = f13;
        z9 = z6;
        f37 = f56222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final long TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(MutableState<IntSize> mutableState) {
        return ((IntSize) ((State) mutableState).getValue()).unbox-impl();
    }

    private static final void TraeContextMenuPopup__G194Zc$lambda$12$lambda$3(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.box-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraeContextMenuPopup__G194Zc$lambda$12$lambda$5$lambda$4(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        TraeContextMenuPopup__G194Zc$lambda$12$lambda$3(mutableState, layoutCoordinates.getSize-YbymL2g());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TraeContextMenuPopup__G194Zc$lambda$12$lambda$11$lambda$7$lambda$6 */
    public static final IntOffset m868x7894b940(long j, Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        return IntOffset.box-impl(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00e2  */
    /* renamed from: calculateMenuOffset-7bnJ_2g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final IntOffset m1848calculateMenuOffset7bnJ_2g(TraeContextMenuPosition traeContextMenuPosition, long j, float f, float f2, int i, TraeContextMenuShadowPadding traeContextMenuShadowPadding, Composer composer, int i2) {
        long j2;
        IntOffset intOffset;
        composer.startReplaceGroup(909711963);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(909711963, i2, -1, "com.bytedance.trae.design.compose.calculateMenuOffset (TraeContextMenuPopup.kt:191)");
        }
        CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        if (traeContextMenuPosition instanceof TraeContextMenuPosition.Fixed) {
            TraeContextMenuPosition.Fixed fixed = (TraeContextMenuPosition.Fixed) traeContextMenuPosition;
            j2 = IntOffset.constructor-impl((density.roundToPx-0680j_4(fixed.m1853getXD9Ej5fM()) << 32) | (density.roundToPx-0680j_4(fixed.m1854getYD9Ej5fM()) & 4294967295L));
        } else {
            if (!(traeContextMenuPosition instanceof TraeContextMenuPosition.Anchored)) {
                throw new NoWhenBranchMatchedException();
            }
            if (IntSize.equals-impl0(j, IntSize.Companion.getZero-YbymL2g())) {
                intOffset = null;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return intOffset;
            }
            float f3 = density.toPx-0680j_4(f);
            float f4 = density.toPx-0680j_4(f2) * i;
            float f5 = f3 + density.toPx-0680j_4(traeContextMenuShadowPadding.m1863getStartD9Ej5fM()) + density.toPx-0680j_4(traeContextMenuShadowPadding.m1862getEndD9Ej5fM());
            float f6 = density.toPx-0680j_4(traeContextMenuShadowPadding.m1864getTopD9Ej5fM()) + f4 + density.toPx-0680j_4(traeContextMenuShadowPadding.m1861getBottomD9Ej5fM());
            TraeContextMenuPosition.Anchored anchored = (TraeContextMenuPosition.Anchored) traeContextMenuPosition;
            float coerceIn = RangesKt.coerceIn(anchored.getAnchorX() - (f5 / 2.0f), 0.0f, RangesKt.coerceAtLeast(((int) (j >> 32)) - f5, 0.0f));
            float coerceIn2 = RangesKt.coerceIn((anchored.getAnchorY() - density.toPx-0680j_4(traeContextMenuShadowPadding.m1864getTopD9Ej5fM())) - (f4 / 2.0f), 0.0f, RangesKt.coerceAtLeast(((int) (j & 4294967295L)) - f6, 0.0f));
            j2 = IntOffset.constructor-impl((MathKt.roundToInt(coerceIn) << 32) | (MathKt.roundToInt(coerceIn2) & 4294967295L));
        }
        intOffset = IntOffset.box-impl(j2);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        return intOffset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f7, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /* renamed from: TraeContextMenuRow-oeDw4jE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1847TraeContextMenuRowoeDw4jE(final TraeContextMenuItem traeContextMenuItem, final float f, final float f2, final float f3, final float f4, final float f5, final float f6, final long j, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-680996092);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(traeContextMenuItem) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(f2) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(f3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(f4) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(f5) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(f6) ? 1048576 : FConstants.SLICE_SIZE;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(j) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-680996092, i2, -1, "com.bytedance.trae.design.compose.TraeContextMenuRow (TraeContextMenuPopup.kt:225)");
            }
            Color m1842getTextColorQN2ZGVo = traeContextMenuItem.m1842getTextColorQN2ZGVo();
            long j2 = m1842getTextColorQN2ZGVo != null ? m1842getTextColorQN2ZGVo.unbox-impl() : j;
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), f);
            String key = traeContextMenuItem.getKey();
            startRestartGroup.startReplaceGroup(-219829233);
            boolean changed = startRestartGroup.changed(key);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
                obj = rememberedValue;
            }
            MutableInteractionSource MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
            startRestartGroup.updateRememberedValue(MutableInteractionSource);
            obj = MutableInteractionSource;
            startRestartGroup.endReplaceGroup();
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(ClickableKt.clickable-O2vRcR0$default(modifier, (MutableInteractionSource) obj, (Indication) null, false, (String) null, (Role) null, traeContextMenuItem.getOnClick(), 28, (Object) null), f2, 0.0f, Dp.constructor-impl(f2 + f6), 0.0f, 10, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            DrawableResource icon = traeContextMenuItem.getIcon();
            startRestartGroup.startReplaceGroup(2101314016);
            if (icon != null) {
                Painter painterResource = ImageResources_androidKt.painterResource(icon, startRestartGroup, 0);
                Modifier modifier3 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20));
                ColorFilter.Companion companion = ColorFilter.Companion;
                Color m1841getIconTintQN2ZGVo = traeContextMenuItem.m1841getIconTintQN2ZGVo();
                ImageKt.Image(painterResource, (String) null, modifier3, (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(companion, m1841getIconTintQN2ZGVo != null ? m1841getIconTintQN2ZGVo.unbox-impl() : j2, 0, 2, (Object) null), startRestartGroup, 432, 56);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, f3), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.Text--4IGK_g(traeContextMenuItem.getText(), traeContextMenuItem.getTrailingIcon() == null ? (Modifier) Modifier.Companion : RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyBase(), startRestartGroup, 0, 3120, 55288);
            DrawableResource trailingIcon = traeContextMenuItem.getTrailingIcon();
            startRestartGroup.startReplaceGroup(2101334658);
            if (trailingIcon != null) {
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, f5), startRestartGroup, 0);
                Painter painterResource2 = ImageResources_androidKt.painterResource(trailingIcon, startRestartGroup, 0);
                Modifier modifier4 = SizeKt.size-3ABfNKs(Modifier.Companion, f4);
                Color m1843getTrailingIconTintQN2ZGVo = traeContextMenuItem.m1843getTrailingIconTintQN2ZGVo();
                ImageKt.Image(painterResource2, (String) null, modifier4, (Alignment) null, (ContentScale) null, 0.0f, m1843getTrailingIconTintQN2ZGVo != null ? ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, m1843getTrailingIconTintQN2ZGVo.unbox-impl(), 0, 2, (Object) null) : null, startRestartGroup, 48, 56);
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.design.compose.TraeContextMenuPopupKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TraeContextMenuRow_oeDw4jE$lambda$18;
                    TraeContextMenuRow_oeDw4jE$lambda$18 = TraeContextMenuPopupKt.TraeContextMenuRow_oeDw4jE$lambda$18(TraeContextMenuItem.this, f, f2, f3, f4, f5, f6, j, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return TraeContextMenuRow_oeDw4jE$lambda$18;
                }
            });
        }
    }

    private static final Modifier contentDescriptionModifier(final String str) {
        if (str == null) {
            return Modifier.Companion;
        }
        return SemanticsModifierKt.semantics$default(Modifier.Companion, false, new Function1() { // from class: com.bytedance.trae.design.compose.TraeContextMenuPopupKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit contentDescriptionModifier$lambda$19;
                contentDescriptionModifier$lambda$19 = TraeContextMenuPopupKt.contentDescriptionModifier$lambda$19(str, (SemanticsPropertyReceiver) obj);
                return contentDescriptionModifier$lambda$19;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contentDescriptionModifier$lambda$19(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }
}
