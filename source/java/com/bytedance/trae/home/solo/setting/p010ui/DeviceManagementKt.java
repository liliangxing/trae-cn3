package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.design.compose.TraeAnimatedGuideImageKt;
import com.bytedance.trae.design.compose.TraeColors;
import com.bytedance.trae.design.compose.TraeContextMenuItem;
import com.bytedance.trae.design.compose.TraeContextMenuPopupKt;
import com.bytedance.trae.design.compose.TraeContextMenuPosition;
import com.bytedance.trae.design.compose.TraeContextMenuShadowPadding;
import com.bytedance.trae.design.compose.TraePressableIconKt;
import com.bytedance.trae.design.compose.TraeTheme;
import com.bytedance.trae.home.generated.resources.Drawable0_commonMainKt;
import com.bytedance.trae.home.generated.resources.Res;
import com.bytedance.trae.home.generated.resources.String0_commonMainKt;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice;
import com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuSource;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuState;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementUiState;
import com.bytedance.trae.kmp.ui.KmpClickHandler;
import com.bytedance.trae.kmp.ui.KmpStringResource_androidKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResources_androidKt;

/* compiled from: DeviceManagement.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a_\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u00192\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u0010\u001f\u001a9\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0019H\u0003¢\u0006\u0002\u0010%\u001a1\u0010&\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0019H\u0003¢\u0006\u0002\u0010'\u001a=\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017H\u0003¢\u0006\u0002\u0010,\u001a\f\u0010-\u001a\u00020.*\u00020\"H\u0000\u001a3\u0010/\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017H\u0001¢\u0006\u0002\u00101\u001aY\u00102\u001a\u00020\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010#\u001a\u00020$2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u0019H\u0003¢\u0006\u0002\u00106\u001aE\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u0002052\u0006\u0010#\u001a\u00020$2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u0019H\u0003¢\u0006\u0002\u00109\u001a\u001d\u0010:\u001a\u00020\u00112\u0006\u00108\u001a\u0002052\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010;\u001a#\u0010<\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010B\u001a\u001d\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010E\u001aE\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020\u00012\u0006\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020>2\u0006\u0010#\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017H\u0003¢\u0006\u0004\bK\u0010L\u001a3\u0010M\u001a\u00020\u00112\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010#\u001a\u00020$2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0019H\u0003¢\u0006\u0002\u0010P\u001a\r\u0010Q\u001a\u00020$H\u0001¢\u0006\u0002\u0010R\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\b\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S²\u0006\n\u0010T\u001a\u00020UX\u008a\u008e\u0002²\u0006\n\u0010V\u001a\u00020UX\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u00020UX\u008a\u008e\u0002"}, d2 = {"DeviceAddButtonBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "DeviceListScrollBottomPadding", "DeviceGuideHeroHeight", "getDeviceGuideHeroHeight", "()F", "DeviceGuideStepsGap", "getDeviceGuideStepsGap", "DeviceGuideStepsWidth", "DeviceActionMenuWidth", "DeviceActionMenuItemHeight", "DeviceActionMenuCornerRadius", "DeviceActionMenuElevation", "DeviceActionMenuShadowPadding", "Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;", "DeviceManagementContent", "", "state", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;", "displayUrl", "", "onAddDevice", "Lkotlin/Function0;", "onAction", "Lkotlin/Function1;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;", "onSwipeInteractionChanged", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "EmptyGuide", "selectedProduct", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;", "colors", "Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "GuideTabs", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "GuideTab", "title", "selected", "onClick", "(Ljava/lang/String;ZLcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "guideHeroResource", "Lorg/jetbrains/compose/resources/DrawableResource;", "GuideSteps", "onCopyUrl", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DeviceList", "devices", "", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "(Ljava/util/List;Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DeviceRow", "device", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DeviceIcon", "(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Landroidx/compose/runtime/Composer;I)V", "borderCompat", "color", "Landroidx/compose/ui/graphics/Color;", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "borderCompat-bw27NRU", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/shape/RoundedCornerShape;)Landroidx/compose/ui/Modifier;", "StatusChip", "online", "(ZLcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Landroidx/compose/runtime/Composer;I)V", "ActionCircle", "icon", "iconSize", "label", "background", "ActionCircle-LyZNIlQ", "(Lorg/jetbrains/compose/resources/DrawableResource;FLjava/lang/String;JLcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DeviceActionOverlay", "menu", "Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "deviceManagementPalette", "(Landroidx/compose/runtime/Composer;I)Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;", "impl_mainlandRelease", "offsetX", "", "rowAnchorX", "rowAnchorY"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceManagementKt {
    private static final TraeContextMenuShadowPadding DeviceActionMenuShadowPadding;
    private static final float DeviceAddButtonBottomPadding;
    private static final float DeviceListScrollBottomPadding = Dp.constructor-impl(76);
    private static final float DeviceGuideHeroHeight = Dp.constructor-impl(203);
    private static final float DeviceGuideStepsGap = Dp.constructor-impl(36);
    private static final float DeviceGuideStepsWidth = Dp.constructor-impl(288);
    private static final float DeviceActionMenuWidth = Dp.constructor-impl(200);
    private static final float DeviceActionMenuItemHeight = Dp.constructor-impl(44);
    private static final float DeviceActionMenuCornerRadius = Dp.constructor-impl(20);
    private static final float DeviceActionMenuElevation = Dp.constructor-impl(8);

    /* compiled from: DeviceManagement.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceManagementProduct.values().length];
            try {
                iArr[DeviceManagementProduct.Work.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceManagementProduct.Ide.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionCircle_LyZNIlQ$lambda$78(DrawableResource drawableResource, float f, String str, long j, DeviceManagementPalette deviceManagementPalette, Function0 function0, int i, Composer composer, int i2) {
        m2450ActionCircleLyZNIlQ(drawableResource, f, str, j, deviceManagementPalette, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceActionOverlay$lambda$79(DeviceManagementMenuState deviceManagementMenuState, DeviceManagementPalette deviceManagementPalette, Function1 function1, int i, Composer composer, int i2) {
        DeviceActionOverlay(deviceManagementMenuState, deviceManagementPalette, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceActionOverlay$lambda$92(DeviceManagementMenuState deviceManagementMenuState, DeviceManagementPalette deviceManagementPalette, Function1 function1, int i, Composer composer, int i2) {
        DeviceActionOverlay(deviceManagementMenuState, deviceManagementPalette, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceIcon$lambda$70(DeviceManagementDevice deviceManagementDevice, DeviceManagementPalette deviceManagementPalette, int i, Composer composer, int i2) {
        DeviceIcon(deviceManagementDevice, deviceManagementPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceList$lambda$39(List list, DeviceManagementPalette deviceManagementPalette, Function0 function0, Function1 function1, Function1 function12, int i, Composer composer, int i2) {
        DeviceList(list, deviceManagementPalette, function0, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceManagementContent$lambda$5(DeviceManagementUiState deviceManagementUiState, String str, Function0 function0, Function1 function1, Function1 function12, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DeviceManagementContent(deviceManagementUiState, str, function0, function1, function12, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceRow$lambda$68(DeviceManagementDevice deviceManagementDevice, DeviceManagementPalette deviceManagementPalette, Function1 function1, Function1 function12, int i, Composer composer, int i2) {
        DeviceRow(deviceManagementDevice, deviceManagementPalette, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyGuide$lambda$12(DeviceManagementProduct deviceManagementProduct, String str, DeviceManagementPalette deviceManagementPalette, Function1 function1, int i, Composer composer, int i2) {
        EmptyGuide(deviceManagementProduct, str, deviceManagementPalette, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideSteps$lambda$28(DeviceManagementProduct deviceManagementProduct, String str, DeviceManagementPalette deviceManagementPalette, Function0 function0, int i, Composer composer, int i2) {
        GuideSteps(deviceManagementProduct, str, deviceManagementPalette, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideTab$lambda$21(String str, boolean z, DeviceManagementPalette deviceManagementPalette, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        GuideTab(str, z, deviceManagementPalette, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideTabs$lambda$18(DeviceManagementProduct deviceManagementProduct, DeviceManagementPalette deviceManagementPalette, Function1 function1, int i, Composer composer, int i2) {
        GuideTabs(deviceManagementProduct, deviceManagementPalette, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatusChip$lambda$72(boolean z, DeviceManagementPalette deviceManagementPalette, int i, Composer composer, int i2) {
        StatusChip(z, deviceManagementPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final float getDeviceGuideHeroHeight() {
        return DeviceGuideHeroHeight;
    }

    public static final float getDeviceGuideStepsGap() {
        return DeviceGuideStepsGap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceManagementContent$lambda$1$lambda$0(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DeviceManagementContent(final DeviceManagementUiState deviceManagementUiState, final String str, final Function0<Unit> function0, final Function1<? super DeviceManagementAction, Unit> function1, Function1<? super Boolean, Unit> function12, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Function1<? super Boolean, Unit> function13;
        int i4;
        Modifier modifier2;
        int i5;
        Function1<? super Boolean, Unit> function14;
        Object rememberedValue;
        int hashCode;
        Composer composer2;
        DeviceManagementPalette deviceManagementPalette;
        int i6;
        Composer composer3;
        Function1<? super DeviceManagementAction, Unit> function15;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(deviceManagementUiState, "state");
        Intrinsics.checkNotNullParameter(str, "displayUrl");
        Intrinsics.checkNotNullParameter(function0, "onAddDevice");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer startRestartGroup = composer.startRestartGroup(-1938587617);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(deviceManagementUiState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        int i7 = i2 & 16;
        if (i7 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            function13 = function12;
            i3 |= startRestartGroup.changedInstance(function13) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= 196608;
            } else if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 131072 : 65536;
                i5 = i3;
                if ((74899 & i5) == 74898 || !startRestartGroup.getSkipping()) {
                    if (i7 != 0) {
                        startRestartGroup.startReplaceGroup(-1572471230);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda17
                                public final Object invoke(Object obj) {
                                    Unit DeviceManagementContent$lambda$1$lambda$0;
                                    DeviceManagementContent$lambda$1$lambda$0 = DeviceManagementKt.DeviceManagementContent$lambda$1$lambda$0(((Boolean) obj).booleanValue());
                                    return DeviceManagementContent$lambda$1$lambda$0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        function14 = (Function1) rememberedValue2;
                    } else {
                        function14 = function13;
                    }
                    Modifier modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1938587617, i5, -1, "com.bytedance.trae.home.solo.setting.ui.DeviceManagementContent (DeviceManagement.kt:123)");
                    }
                    DeviceManagementPalette deviceManagementPalette2 = deviceManagementPalette(startRestartGroup, 0);
                    Modifier modifier4 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), deviceManagementPalette2.m2472getBackground0d7_KjU(), (Shape) null, 2, (Object) null);
                    startRestartGroup.startReplaceGroup(-1572464267);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda18
                            public final Object invoke(Object obj) {
                                Unit DeviceManagementContent$lambda$3$lambda$2;
                                DeviceManagementContent$lambda$3$lambda$2 = DeviceManagementKt.DeviceManagementContent$lambda$3$lambda$2((SemanticsPropertyReceiver) obj);
                                return DeviceManagementContent$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) rememberedValue, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                    if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                        composer2.updateRememberedValue(Integer.valueOf(hashCode));
                        composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    if (deviceManagementUiState.isEmpty()) {
                        startRestartGroup.startReplaceGroup(465679429);
                        EmptyGuide(deviceManagementUiState.getSelectedGuideProduct(), str, deviceManagementPalette2, function1, startRestartGroup, (i5 & 112) | (i5 & 7168));
                        startRestartGroup.endReplaceGroup();
                        deviceManagementPalette = deviceManagementPalette2;
                        modifier2 = modifier3;
                        i6 = i5;
                        composer3 = startRestartGroup;
                        function15 = function1;
                    } else {
                        startRestartGroup.startReplaceGroup(465907217);
                        deviceManagementPalette = deviceManagementPalette2;
                        modifier2 = modifier3;
                        i6 = i5;
                        composer3 = startRestartGroup;
                        function15 = function1;
                        DeviceList(deviceManagementUiState.getDevices(), deviceManagementPalette2, function0, function1, function14, composer3, (i5 & 896) | (i5 & 7168) | (57344 & i5));
                        composer3.endReplaceGroup();
                    }
                    DeviceActionOverlay(deviceManagementUiState.getActionMenu(), deviceManagementPalette, function15, composer3, (i6 >> 3) & 896);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    function14 = function13;
                    composer3 = startRestartGroup;
                }
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Function1<? super Boolean, Unit> function16 = function14;
                    final Modifier modifier5 = modifier2;
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda19
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DeviceManagementContent$lambda$5;
                            DeviceManagementContent$lambda$5 = DeviceManagementKt.DeviceManagementContent$lambda$5(DeviceManagementUiState.this, str, function0, function1, function16, modifier5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return DeviceManagementContent$lambda$5;
                        }
                    });
                    return;
                }
                return;
            }
            modifier2 = modifier;
            i5 = i3;
            if ((74899 & i5) == 74898) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            DeviceManagementPalette deviceManagementPalette22 = deviceManagementPalette(startRestartGroup, 0);
            Modifier modifier42 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), deviceManagementPalette22.m2472getBackground0d7_KjU(), (Shape) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-1572464267);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default2 = SemanticsModifierKt.semantics$default(modifier42, false, (Function1) rememberedValue, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default2);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer2.getInserting()) {
            }
            composer2.updateRememberedValue(Integer.valueOf(hashCode));
            composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash2);
            Updater.set-impl(composer2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            if (deviceManagementUiState.isEmpty()) {
            }
            DeviceActionOverlay(deviceManagementUiState.getActionMenu(), deviceManagementPalette, function15, composer3, (i6 >> 3) & 896);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function13 = function12;
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i3;
        if ((74899 & i5) == 74898) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        DeviceManagementPalette deviceManagementPalette222 = deviceManagementPalette(startRestartGroup, 0);
        Modifier modifier422 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), deviceManagementPalette222.m2472getBackground0d7_KjU(), (Shape) null, 2, (Object) null);
        startRestartGroup.startReplaceGroup(-1572464267);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier semantics$default22 = SemanticsModifierKt.semantics$default(modifier422, false, (Function1) rememberedValue, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default22);
        Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        composer2 = Updater.constructor-impl(startRestartGroup);
        Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer2.getInserting()) {
        }
        composer2.updateRememberedValue(Integer.valueOf(hashCode));
        composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash22);
        Updater.set-impl(composer2, materializeModifier22, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
        if (deviceManagementUiState.isEmpty()) {
        }
        DeviceActionOverlay(deviceManagementUiState.getActionMenu(), deviceManagementPalette, function15, composer3, (i6 >> 3) & 896);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        composer3.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer3);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceManagementContent$lambda$3$lambda$2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "cmp_device_management_root");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0298, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void EmptyGuide(final DeviceManagementProduct deviceManagementProduct, final String str, final DeviceManagementPalette deviceManagementPalette, final Function1<? super DeviceManagementAction, Unit> function1, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-876856346);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(deviceManagementProduct) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-876856346, i2, -1, "com.bytedance.trae.home.solo.setting.ui.EmptyGuide (DeviceManagement.kt:161)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = i2 & 14;
            int i4 = i2 >> 3;
            GuideTabs(deviceManagementProduct, deviceManagementPalette, function1, startRestartGroup, (i4 & 896) | (i4 & 112) | i3);
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), Dp.constructor-impl(24), 0.0f, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-262797175);
            boolean z = i3 == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj2) {
                        Unit EmptyGuide$lambda$11$lambda$7$lambda$6;
                        EmptyGuide$lambda$11$lambda$7$lambda$6 = DeviceManagementKt.EmptyGuide$lambda$11$lambda$7$lambda$6(DeviceManagementProduct.this, (SemanticsPropertyReceiver) obj2);
                        return EmptyGuide$lambda$11$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer4, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(42)), startRestartGroup, 6);
            TraeAnimatedGuideImageKt.m1581TraeAnimatedGuideImage6a0pyJM(guideHeroResource(deviceManagementProduct), SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), DeviceGuideHeroHeight), 0.0f, startRestartGroup, 48, 4);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, DeviceGuideStepsGap), startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1977437666);
            boolean z2 = (i2 & 7168) == 2048;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z2) {
                obj = rememberedValue2;
            }
            Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda21
                public final Object invoke() {
                    Unit EmptyGuide$lambda$11$lambda$10$lambda$9$lambda$8;
                    EmptyGuide$lambda$11$lambda$10$lambda$9$lambda$8 = DeviceManagementKt.EmptyGuide$lambda$11$lambda$10$lambda$9$lambda$8(function1);
                    return EmptyGuide$lambda$11$lambda$10$lambda$9$lambda$8;
                }
            };
            startRestartGroup.updateRememberedValue(function0);
            obj = function0;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            GuideSteps(deviceManagementProduct, str, deviceManagementPalette, (Function0) obj, startRestartGroup, i3 | (i2 & 112) | (i2 & 896));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj2, Object obj3) {
                    Unit EmptyGuide$lambda$12;
                    EmptyGuide$lambda$12 = DeviceManagementKt.EmptyGuide$lambda$12(DeviceManagementProduct.this, str, deviceManagementPalette, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return EmptyGuide$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyGuide$lambda$11$lambda$7$lambda$6(DeviceManagementProduct deviceManagementProduct, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, deviceManagementProduct == DeviceManagementProduct.Ide ? "cmp_device_management_ide_guide" : "cmp_device_management_empty_guide");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyGuide$lambda$11$lambda$10$lambda$9$lambda$8(Function1 function1) {
        function1.invoke(DeviceManagementAction.CopyGuideUrl.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0164, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ca, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void GuideTabs(final DeviceManagementProduct deviceManagementProduct, final DeviceManagementPalette deviceManagementPalette, final Function1<? super DeviceManagementAction, Unit> function1, Composer composer, final int i) {
        int i2;
        Object obj;
        Object obj2;
        Composer startRestartGroup = composer.startRestartGroup(1504206030);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(deviceManagementProduct) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1504206030, i2, -1, "com.bytedance.trae.home.solo.setting.ui.GuideTabs (DeviceManagement.kt:201)");
            }
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(40));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_device_empty_tab_work(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            boolean z = deviceManagementProduct == DeviceManagementProduct.Work;
            Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            startRestartGroup.startReplaceGroup(1698020366);
            int i3 = i2 & 896;
            boolean z2 = i3 == 256;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (!z2) {
                obj = rememberedValue;
            }
            Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda33
                public final Object invoke() {
                    Unit GuideTabs$lambda$17$lambda$14$lambda$13;
                    GuideTabs$lambda$17$lambda$14$lambda$13 = DeviceManagementKt.GuideTabs$lambda$17$lambda$14$lambda$13(function1);
                    return GuideTabs$lambda$17$lambda$14$lambda$13;
                }
            };
            startRestartGroup.updateRememberedValue(function0);
            obj = function0;
            Function0 function02 = (Function0) obj;
            startRestartGroup.endReplaceGroup();
            int i4 = (i2 << 3) & 896;
            GuideTab(kmpStringResource, z, deviceManagementPalette, weight$default, function02, startRestartGroup, i4, 0);
            String kmpStringResource2 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_device_empty_tab_ide(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            boolean z3 = deviceManagementProduct == DeviceManagementProduct.Ide;
            Modifier weight$default2 = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            startRestartGroup.startReplaceGroup(1698032077);
            boolean z4 = i3 == 256;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z4) {
                obj2 = rememberedValue2;
            }
            Function0 function03 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit GuideTabs$lambda$17$lambda$16$lambda$15;
                    GuideTabs$lambda$17$lambda$16$lambda$15 = DeviceManagementKt.GuideTabs$lambda$17$lambda$16$lambda$15(function1);
                    return GuideTabs$lambda$17$lambda$16$lambda$15;
                }
            };
            startRestartGroup.updateRememberedValue(function03);
            obj2 = function03;
            startRestartGroup.endReplaceGroup();
            GuideTab(kmpStringResource2, z3, deviceManagementPalette, weight$default2, (Function0) obj2, startRestartGroup, i4, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), deviceManagementPalette.m2475getDivider0d7_KjU(), (Shape) null, 2, (Object) null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit GuideTabs$lambda$18;
                    GuideTabs$lambda$18 = DeviceManagementKt.GuideTabs$lambda$18(DeviceManagementProduct.this, deviceManagementPalette, function1, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return GuideTabs$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideTabs$lambda$17$lambda$14$lambda$13(Function1 function1) {
        function1.invoke(new DeviceManagementAction.SelectGuideProduct(DeviceManagementProduct.Work));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideTabs$lambda$17$lambda$16$lambda$15(Function1 function1) {
        function1.invoke(new DeviceManagementAction.SelectGuideProduct(DeviceManagementProduct.Ide));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void GuideTab(final String str, final boolean z, final DeviceManagementPalette deviceManagementPalette, Modifier modifier, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Object rememberedValue;
        int hashCode;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1627927740);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(deviceManagementPalette) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function0) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
            }
            if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? (Modifier) Modifier.Companion : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1627927740, i3, -1, "com.bytedance.trae.home.solo.setting.ui.GuideTab (DeviceManagement.kt:237)");
                }
                startRestartGroup.startReplaceGroup(-907117257);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier noRippleClickable = SettingsScaffoldKt.noRippleClickable(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(40)), (KmpClickHandler) rememberedValue, function0);
                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(bottom, centerHorizontally, startRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, noRippleClickable);
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                composer2 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                    composer2.updateRememberedValue(Integer.valueOf(hashCode));
                    composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i5 = i3 & 14;
                modifier3 = modifier4;
                TextKt.Text--4IGK_g(str, (Modifier) null, !z ? deviceManagementPalette.m2484getPrimaryText0d7_KjU() : deviceManagementPalette.m2487getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getBodyXs(), startRestartGroup, i5, 3120, 55290);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), startRestartGroup, 6);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(1)), 0.75f), !z ? deviceManagementPalette.m2484getPrimaryText0d7_KjU() : Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null), startRestartGroup, 0);
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
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj, Object obj2) {
                        Unit GuideTab$lambda$21;
                        GuideTab$lambda$21 = DeviceManagementKt.GuideTab$lambda$21(str, z, deviceManagementPalette, modifier3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return GuideTab$lambda$21;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 16) == 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        if (i4 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-907117257);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier noRippleClickable2 = SettingsScaffoldKt.noRippleClickable(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(40)), (KmpClickHandler) rememberedValue, function0);
        Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
        Arrangement.Vertical bottom2 = Arrangement.INSTANCE.getBottom();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(bottom2, centerHorizontally2, startRestartGroup, 54);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
        hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, noRippleClickable2);
        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        composer2 = Updater.constructor-impl(startRestartGroup);
        Updater.set-impl(composer2, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!composer2.getInserting()) {
        }
        composer2.updateRememberedValue(Integer.valueOf(hashCode));
        composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash2);
        Updater.set-impl(composer2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
        int i52 = i3 & 14;
        modifier3 = modifier4;
        TextKt.Text--4IGK_g(str, (Modifier) null, !z ? deviceManagementPalette.m2484getPrimaryText0d7_KjU() : deviceManagementPalette.m2487getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getBodyXs(), startRestartGroup, i52, 3120, 55290);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), startRestartGroup, 6);
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(1)), 0.75f), !z ? deviceManagementPalette.m2484getPrimaryText0d7_KjU() : Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null), startRestartGroup, 0);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final DrawableResource guideHeroResource(DeviceManagementProduct deviceManagementProduct) {
        Intrinsics.checkNotNullParameter(deviceManagementProduct, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[deviceManagementProduct.ordinal()];
        if (i == 1) {
            return Drawable0_commonMainKt.getCmp_device_guide_work_hero(Res.drawable.INSTANCE);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return Drawable0_commonMainKt.getCmp_device_guide_ide_hero(Res.drawable.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0305, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GuideSteps(final DeviceManagementProduct deviceManagementProduct, final String str, final DeviceManagementPalette deviceManagementPalette, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Object obj;
        String kmpStringResource;
        String kmpStringResource2;
        Intrinsics.checkNotNullParameter(deviceManagementProduct, "selectedProduct");
        Intrinsics.checkNotNullParameter(str, "displayUrl");
        Intrinsics.checkNotNullParameter(deviceManagementPalette, "colors");
        Intrinsics.checkNotNullParameter(function0, "onCopyUrl");
        Composer startRestartGroup = composer.startRestartGroup(-1986824247);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(deviceManagementProduct) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1986824247, i3, -1, "com.bytedance.trae.home.solo.setting.ui.GuideSteps (DeviceManagement.kt:276)");
            }
            startRestartGroup.startReplaceGroup(-513094679);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final KmpClickHandler kmpClickHandler = (KmpClickHandler) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, DeviceGuideStepsWidth, 1, (Object) null), 0.0f, 1, (Object) null);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            String kmpStringResource3 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_device_management_guide_step1(Res.string.INSTANCE), new Object[]{str}, startRestartGroup, 0);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer4, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            builder.append(kmpStringResource3);
            int indexOf$default = StringsKt.indexOf$default(kmpStringResource3, str, 0, false, 6, (Object) null);
            if (indexOf$default >= 0) {
                builder.addStyle(new SpanStyle(deviceManagementPalette.m2484getPrimaryText0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), indexOf$default, str.length() + indexOf$default);
            }
            composer2 = startRestartGroup;
            TextKt.Text-IbK3jfQ(builder.toAnnotatedString(), (Modifier) null, deviceManagementPalette.m2487getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, TraeTheme.INSTANCE.getTypography(composer2, TraeTheme.$stable).getBodyXs(), composer2, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), composer2, 6);
            DrawableResource cmp_ic_device_copy = Drawable0_commonMainKt.getCmp_ic_device_copy(Res.drawable.INSTANCE);
            composer2.startReplaceGroup(1031950322);
            boolean changedInstance = composer2.changedInstance(kmpClickHandler) | ((i3 & 7168) == 2048);
            Object rememberedValue2 = composer2.rememberedValue();
            if (!changedInstance) {
                obj = rememberedValue2;
            }
            Function0 function02 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit GuideSteps$lambda$27$lambda$26$lambda$25$lambda$24;
                    GuideSteps$lambda$27$lambda$26$lambda$25$lambda$24 = DeviceManagementKt.GuideSteps$lambda$27$lambda$26$lambda$25$lambda$24(kmpClickHandler, function0);
                    return GuideSteps$lambda$27$lambda$26$lambda$25$lambda$24;
                }
            };
            composer2.updateRememberedValue(function02);
            obj = function02;
            composer2.endReplaceGroup();
            TraePressableIconKt.m2261TraePressableIconvnKSRU(cmp_ic_device_copy, "cmp_device_management_copy_url", (Function0) obj, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), false, deviceManagementPalette.m2477getIconDefault0d7_KjU(), ColorKt.lerp-jxsXWHM(deviceManagementPalette.m2472getBackground0d7_KjU(), deviceManagementPalette.m2477getIconDefault0d7_KjU(), 0.3f), 0L, 0L, composer2, 3120, FConstants.DECOMPRESS_FAIL_CODE);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (deviceManagementProduct == DeviceManagementProduct.Work) {
                composer2.startReplaceGroup(-1324353388);
                kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_device_management_guide_work_step2(Res.string.INSTANCE), new Object[0], composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1324248267);
                kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_device_management_guide_ide_step2(Res.string.INSTANCE), new Object[0], composer2, 0);
                composer2.endReplaceGroup();
            }
            TextKt.Text--4IGK_g(kmpStringResource, (Modifier) null, deviceManagementPalette.m2487getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(composer2, TraeTheme.$stable).getBodyXs(), composer2, 0, 0, 65530);
            if (deviceManagementProduct == DeviceManagementProduct.Work) {
                composer2.startReplaceGroup(-1323963532);
                kmpStringResource2 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_device_management_guide_work_step3(Res.string.INSTANCE), new Object[0], composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1323858411);
                kmpStringResource2 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_device_management_guide_ide_step3(Res.string.INSTANCE), new Object[0], composer2, 0);
                composer2.endReplaceGroup();
            }
            TextKt.Text--4IGK_g(kmpStringResource2, (Modifier) null, deviceManagementPalette.m2487getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(composer2, TraeTheme.$stable).getBodyXs(), composer2, 0, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2, Object obj3) {
                    Unit GuideSteps$lambda$28;
                    GuideSteps$lambda$28 = DeviceManagementKt.GuideSteps$lambda$28(DeviceManagementProduct.this, str, deviceManagementPalette, function0, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return GuideSteps$lambda$28;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideSteps$lambda$27$lambda$26$lambda$25$lambda$24(KmpClickHandler kmpClickHandler, Function0 function0) {
        kmpClickHandler.tryHandle(function0);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0334, code lost:
    
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void DeviceList(final List<DeviceManagementDevice> list, final DeviceManagementPalette deviceManagementPalette, final Function0<Unit> function0, final Function1<? super DeviceManagementAction, Unit> function1, final Function1<? super Boolean, Unit> function12, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-1662596751);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
        }
        if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1662596751, i2, -1, "com.bytedance.trae.home.solo.setting.ui.DeviceList (DeviceManagement.kt:344)");
            }
            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.Companion, startRestartGroup, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()));
            String str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            String str2 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, windowInsetsPadding);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            float f = 16;
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), 0.0f, Dp.constructor-impl(f), 0.0f, DeviceListScrollBottomPadding, 5, (Object) null);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(18066278);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DeviceManagementDevice deviceManagementDevice = (DeviceManagementDevice) it.next();
                startRestartGroup.startMovableGroup(-1170712909, deviceManagementDevice);
                int i3 = i2 >> 3;
                DeviceRow(deviceManagementDevice, deviceManagementPalette, function1, function12, startRestartGroup, (i2 & 112) | (i3 & 896) | (i3 & 7168));
                startRestartGroup.endMovableGroup();
                str = str;
                str2 = str2;
                f = f;
                it = it;
                str3 = str3;
            }
            String str4 = str2;
            String str5 = str;
            float f2 = f;
            String str6 = str3;
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(1903422449);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final KmpClickHandler kmpClickHandler = (KmpClickHandler) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier modifier2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(boxScope.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.constructor-impl(f2), 0.0f, Dp.constructor-impl(f2), DeviceAddButtonBottomPadding, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(48)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(14))), deviceManagementPalette.m2482getPrimaryButtonBackground0d7_KjU(), (Shape) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(1903435706);
            boolean changedInstance = startRestartGroup.changedInstance(kmpClickHandler) | ((i2 & 896) == 256);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
                obj = rememberedValue2;
            }
            Function0 function02 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda24
                public final Object invoke() {
                    Unit DeviceList$lambda$38$lambda$33$lambda$32;
                    DeviceList$lambda$38$lambda$33$lambda$32 = DeviceManagementKt.DeviceList$lambda$38$lambda$33$lambda$32(kmpClickHandler, function0);
                    return DeviceList$lambda$38$lambda$33$lambda$32;
                }
            };
            startRestartGroup.updateRememberedValue(function02);
            obj = function02;
            startRestartGroup.endReplaceGroup();
            Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) obj, 15, (Object) null);
            startRestartGroup.startReplaceGroup(1903437870);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda25
                    public final Object invoke(Object obj2) {
                        Unit DeviceList$lambda$38$lambda$35$lambda$34;
                        DeviceList$lambda$38$lambda$35$lambda$34 = DeviceManagementKt.DeviceList$lambda$38$lambda$35$lambda$34((SemanticsPropertyReceiver) obj2);
                        return DeviceList$lambda$38$lambda$35$lambda$34;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier3, false, (Function1) rememberedValue3, 1, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, str5);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, str4);
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str6);
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
            Updater.set-impl(composer4, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode3))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode3));
                composer4.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier4 = Modifier.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, str4);
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str6);
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
            Updater.set-impl(composer5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(hashCode4))) {
                composer5.updateRememberedValue(Integer.valueOf(hashCode4));
                composer5.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
            }
            Updater.set-impl(composer5, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ImageKt.Image(ImageResources_androidKt.painterResource(Drawable0_commonMainKt.getCmp_ic_device_add(Res.drawable.INSTANCE), startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, deviceManagementPalette.m2483getPrimaryButtonText0d7_KjU(), 0, 2, (Object) null), startRestartGroup, 432, 56);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), startRestartGroup, 6);
            TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_add_device_title(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), (Modifier) null, deviceManagementPalette.m2483getPrimaryButtonText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getBodyBaseMd(), startRestartGroup, 0, 0, 65530);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj2, Object obj3) {
                    Unit DeviceList$lambda$39;
                    DeviceList$lambda$39 = DeviceManagementKt.DeviceList$lambda$39(list, deviceManagementPalette, function0, function1, function12, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return DeviceList$lambda$39;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceList$lambda$38$lambda$33$lambda$32(KmpClickHandler kmpClickHandler, Function0 function0) {
        kmpClickHandler.tryHandle(function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceList$lambda$38$lambda$35$lambda$34(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "cmp_device_management_add_device");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x008e, code lost:
    
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void DeviceRow(final DeviceManagementDevice deviceManagementDevice, final DeviceManagementPalette deviceManagementPalette, final Function1<? super DeviceManagementAction, Unit> function1, final Function1<? super Boolean, Unit> function12, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer composer2;
        MutableFloatState mutableFloatState;
        int i3;
        int i4;
        int i5;
        Function1<? super Boolean, Unit> function13;
        String str;
        Composer startRestartGroup = composer.startRestartGroup(1114140034);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(deviceManagementDevice) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        int i6 = i2;
        if ((i6 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1114140034, i6, -1, "com.bytedance.trae.home.solo.setting.ui.DeviceRow (DeviceManagement.kt:406)");
            }
            String id = deviceManagementDevice.getId();
            startRestartGroup.startReplaceGroup(-1319976045);
            boolean changed = startRestartGroup.changed(id);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
                obj = rememberedValue;
            }
            MutableFloatState mutableFloatStateOf = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
            startRestartGroup.updateRememberedValue(mutableFloatStateOf);
            obj = mutableFloatStateOf;
            final MutableFloatState mutableFloatState2 = (MutableFloatState) obj;
            startRestartGroup.endReplaceGroup();
            String id2 = deviceManagementDevice.getId();
            startRestartGroup.startReplaceGroup(-1319973805);
            boolean changed2 = startRestartGroup.changed(id2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableFloatState mutableFloatState3 = (MutableFloatState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            String id3 = deviceManagementDevice.getId();
            startRestartGroup.startReplaceGroup(-1319971565);
            boolean changed3 = startRestartGroup.changed(id3);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableFloatState mutableFloatState4 = (MutableFloatState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float f = -((Density) consume).toPx-0680j_4(Dp.constructor-impl(124));
            boolean z = DeviceRow$lambda$41(mutableFloatState2) < 0.0f;
            float f2 = 74;
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            boolean z2 = z;
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            float f3 = 16;
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceGroup(-596392387);
            int i7 = i6 & 14;
            boolean changed4 = (i7 == 4) | startRestartGroup.changed(mutableFloatState2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj2) {
                        Unit DeviceRow$lambda$67$lambda$51$lambda$50;
                        DeviceRow$lambda$67$lambda$51$lambda$50 = DeviceManagementKt.DeviceRow$lambda$67$lambda$51$lambda$50(DeviceManagementDevice.this, mutableFloatState2, (SemanticsPropertyReceiver) obj2);
                        return DeviceRow$lambda$67$lambda$51$lambda$50;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) rememberedValue4, 1, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer4, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer4.updateRememberedValue(Integer.valueOf(hashCode2));
                composer4.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            DrawableResource cmp_ic_device_action_rename = Drawable0_commonMainKt.getCmp_ic_device_action_rename(Res.drawable.INSTANCE);
            float f4 = Dp.constructor-impl(18);
            String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_context_menu_rename(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            long m2485getRenameActionBackground0d7_KjU = deviceManagementPalette.m2485getRenameActionBackground0d7_KjU();
            startRestartGroup.startReplaceGroup(-1579692253);
            int i8 = i6 & 7168;
            int i9 = i6 & 896;
            boolean changed5 = startRestartGroup.changed(mutableFloatState2) | (i8 == 2048) | (i9 == 256) | (i7 == 4);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit DeviceRow$lambda$67$lambda$56$lambda$53$lambda$52;
                        DeviceRow$lambda$67$lambda$56$lambda$53$lambda$52 = DeviceManagementKt.DeviceRow$lambda$67$lambda$56$lambda$53$lambda$52(function12, function1, deviceManagementDevice, mutableFloatState2);
                        return DeviceRow$lambda$67$lambda$56$lambda$53$lambda$52;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            int i10 = ((i6 << 9) & 57344) | 48;
            m2450ActionCircleLyZNIlQ(cmp_ic_device_action_rename, f4, kmpStringResource, m2485getRenameActionBackground0d7_KjU, deviceManagementPalette, (Function0) rememberedValue5, startRestartGroup, i10);
            DrawableResource cmp_ic_device_action_delete = Drawable0_commonMainKt.getCmp_ic_device_action_delete(Res.drawable.INSTANCE);
            float f5 = Dp.constructor-impl(20);
            String kmpStringResource2 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_context_menu_delete(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            long m2473getDeleteActionBackground0d7_KjU = deviceManagementPalette.m2473getDeleteActionBackground0d7_KjU();
            startRestartGroup.startReplaceGroup(-1579677085);
            boolean changed6 = startRestartGroup.changed(mutableFloatState2) | (i8 == 2048) | (i9 == 256) | (i7 == 4);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit DeviceRow$lambda$67$lambda$56$lambda$55$lambda$54;
                        DeviceRow$lambda$67$lambda$56$lambda$55$lambda$54 = DeviceManagementKt.DeviceRow$lambda$67$lambda$56$lambda$55$lambda$54(function12, function1, deviceManagementDevice, mutableFloatState2);
                        return DeviceRow$lambda$67$lambda$56$lambda$55$lambda$54;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            m2450ActionCircleLyZNIlQ(cmp_ic_device_action_delete, f5, kmpStringResource2, m2473getDeleteActionBackground0d7_KjU, deviceManagementPalette, (Function0) rememberedValue6, startRestartGroup, i10);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier modifier3 = Modifier.Companion;
            startRestartGroup.startReplaceGroup(-596348631);
            boolean changed7 = startRestartGroup.changed(mutableFloatState2);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj2) {
                        IntOffset DeviceRow$lambda$67$lambda$58$lambda$57;
                        DeviceRow$lambda$67$lambda$58$lambda$57 = DeviceManagementKt.DeviceRow$lambda$67$lambda$58$lambda$57(mutableFloatState2, (Density) obj2);
                        return DeviceRow$lambda$67$lambda$58$lambda$57;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(OffsetKt.offset(modifier3, (Function1) rememberedValue7), Dp.constructor-impl(f3), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(f2)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(f3))), deviceManagementPalette.m2486getSurface0d7_KjU(), (Shape) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-596339526);
            boolean changed8 = startRestartGroup.changed(mutableFloatState3) | startRestartGroup.changed(mutableFloatState4);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed8 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj2) {
                        Unit DeviceRow$lambda$67$lambda$60$lambda$59;
                        DeviceRow$lambda$67$lambda$60$lambda$59 = DeviceManagementKt.DeviceRow$lambda$67$lambda$60$lambda$59(mutableFloatState3, mutableFloatState4, (LayoutCoordinates) obj2);
                        return DeviceRow$lambda$67$lambda$60$lambda$59;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1) rememberedValue8);
            Boolean valueOf = Boolean.valueOf(z2);
            startRestartGroup.startReplaceGroup(-596329363);
            boolean changed9 = (i9 == 256) | startRestartGroup.changed(z2) | startRestartGroup.changed(mutableFloatState3) | startRestartGroup.changed(mutableFloatState4) | (i7 == 4);
            DeviceManagementKt$DeviceRow$1$5$1 rememberedValue9 = startRestartGroup.rememberedValue();
            if (changed9 || rememberedValue9 == Composer.Companion.getEmpty()) {
                composer2 = startRestartGroup;
                mutableFloatState = mutableFloatState2;
                i3 = 4;
                i4 = 2048;
                i5 = i7;
                function13 = function12;
                str = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
                rememberedValue9 = new DeviceManagementKt$DeviceRow$1$5$1(z2, function1, deviceManagementDevice, mutableFloatState3, mutableFloatState4);
                composer2.updateRememberedValue(rememberedValue9);
            } else {
                function13 = function12;
                mutableFloatState = mutableFloatState2;
                composer2 = startRestartGroup;
                i5 = i7;
                i3 = 4;
                i4 = 2048;
                str = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
            }
            composer2.endReplaceGroup();
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(onGloballyPositioned, deviceManagementDevice, valueOf, (PointerInputEventHandler) rememberedValue9);
            String id4 = deviceManagementDevice.getId();
            composer2.startReplaceGroup(-596301294);
            boolean changed10 = composer2.changed(mutableFloatState) | composer2.changed(f) | (i8 == i4);
            DeviceManagementKt$DeviceRow$1$6$1 rememberedValue10 = composer2.rememberedValue();
            if (changed10 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new DeviceManagementKt$DeviceRow$1$6$1(f, function13, mutableFloatState);
                composer2.updateRememberedValue(rememberedValue10);
            }
            composer2.endReplaceGroup();
            Modifier pointerInput2 = SuspendingPointerInputFilterKt.pointerInput(pointerInput, id4, (PointerInputEventHandler) rememberedValue10);
            composer2.startReplaceGroup(-596281018);
            int i11 = i5;
            boolean z3 = i11 == i3;
            Object rememberedValue11 = composer2.rememberedValue();
            if (z3 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj2) {
                        Unit DeviceRow$lambda$67$lambda$64$lambda$63;
                        DeviceRow$lambda$67$lambda$64$lambda$63 = DeviceManagementKt.DeviceRow$lambda$67$lambda$64$lambda$63(DeviceManagementDevice.this, (SemanticsPropertyReceiver) obj2);
                        return DeviceRow$lambda$67$lambda$64$lambda$63;
                    }
                };
                composer2.updateRememberedValue(rememberedValue11);
            }
            composer2.endReplaceGroup();
            Modifier semantics$default2 = SemanticsModifierKt.semantics$default(pointerInput2, false, (Function1) rememberedValue11, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str2);
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, semantics$default2);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer composer5 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer5, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(hashCode3))) {
                composer5.updateRememberedValue(Integer.valueOf(hashCode3));
                composer5.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer5, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f3), 0.0f, Dp.constructor-impl(f3), 0.0f, 10, (Object) null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str2);
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifier5);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer composer6 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer6, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(hashCode4))) {
                composer6.updateRememberedValue(Integer.valueOf(hashCode4));
                composer6.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
            }
            Updater.set-impl(composer6, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i12 = i6 & 112;
            DeviceIcon(deviceManagementDevice, deviceManagementPalette, composer2, i11 | i12);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), composer2, 6);
            startRestartGroup = composer2;
            TextKt.Text--4IGK_g(deviceManagementDevice.getName(), RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null), deviceManagementPalette.m2484getPrimaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(composer2, TraeTheme.$stable).getBodyBase(), startRestartGroup, 0, 3120, 55288);
            StatusChip(deviceManagementDevice.getOnline(), deviceManagementPalette, startRestartGroup, i12);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj2, Object obj3) {
                    Unit DeviceRow$lambda$68;
                    DeviceRow$lambda$68 = DeviceManagementKt.DeviceRow$lambda$68(DeviceManagementDevice.this, deviceManagementPalette, function1, function12, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return DeviceRow$lambda$68;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DeviceRow$lambda$41(MutableFloatState mutableFloatState) {
        return ((FloatState) mutableFloatState).getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DeviceRow$lambda$44(MutableFloatState mutableFloatState) {
        return ((FloatState) mutableFloatState).getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DeviceRow$lambda$47(MutableFloatState mutableFloatState) {
        return ((FloatState) mutableFloatState).getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceRow$lambda$67$lambda$51$lambda$50(DeviceManagementDevice deviceManagementDevice, MutableFloatState mutableFloatState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "cmp_device_management_swipe_actions_" + deviceManagementDevice.getName());
        if (DeviceRow$lambda$41(mutableFloatState) == 0.0f) {
            SemanticsPropertiesKt.invisibleToUser(semanticsPropertyReceiver);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceRow$lambda$67$lambda$56$lambda$53$lambda$52(Function1 function1, Function1 function12, DeviceManagementDevice deviceManagementDevice, MutableFloatState mutableFloatState) {
        mutableFloatState.setFloatValue(0.0f);
        function1.invoke(false);
        function12.invoke(new DeviceManagementAction.OpenRename(deviceManagementDevice));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceRow$lambda$67$lambda$56$lambda$55$lambda$54(Function1 function1, Function1 function12, DeviceManagementDevice deviceManagementDevice, MutableFloatState mutableFloatState) {
        mutableFloatState.setFloatValue(0.0f);
        function1.invoke(false);
        function12.invoke(new DeviceManagementAction.OpenDelete(deviceManagementDevice));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset DeviceRow$lambda$67$lambda$58$lambda$57(MutableFloatState mutableFloatState, Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        return IntOffset.box-impl(IntOffset.constructor-impl((MathKt.roundToInt(DeviceRow$lambda$41(mutableFloatState)) << 32) | (0 & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceRow$lambda$67$lambda$60$lambda$59(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
        mutableFloatState.setFloatValue(Float.intBitsToFloat((int) (positionInRoot >> 32)) + (((int) (layoutCoordinates.getSize-YbymL2g() >> 32)) / 2.0f));
        mutableFloatState2.setFloatValue(Float.intBitsToFloat((int) (positionInRoot & 4294967295L)) + (((int) (layoutCoordinates.getSize-YbymL2g() & 4294967295L)) / 2.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceRow$lambda$67$lambda$64$lambda$63(DeviceManagementDevice deviceManagementDevice, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "cmp_device_management_row_" + deviceManagementDevice.getName());
        return Unit.INSTANCE;
    }

    private static final void DeviceIcon(final DeviceManagementDevice deviceManagementDevice, final DeviceManagementPalette deviceManagementPalette, Composer composer, final int i) {
        int i2;
        DrawableResource cmp_ic_device_pc_offline;
        Composer startRestartGroup = composer.startRestartGroup(-946976735);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(deviceManagementDevice) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-946976735, i2, -1, "com.bytedance.trae.home.solo.setting.ui.DeviceIcon (DeviceManagement.kt:523)");
            }
            Modifier m2451borderCompatbw27NRU = m2451borderCompatbw27NRU(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(42)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null), deviceManagementPalette.m2476getIconContainerBorder0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(10)));
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m2451borderCompatbw27NRU);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            if (deviceManagementDevice.getOnline()) {
                cmp_ic_device_pc_offline = Drawable0_commonMainKt.getCmp_ic_device_pc(Res.drawable.INSTANCE);
            } else {
                cmp_ic_device_pc_offline = Drawable0_commonMainKt.getCmp_ic_device_pc_offline(Res.drawable.INSTANCE);
            }
            ImageKt.Image(ImageResources_androidKt.painterResource(cmp_ic_device_pc_offline, startRestartGroup, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, deviceManagementPalette.m2477getIconDefault0d7_KjU(), 0, 2, (Object) null), startRestartGroup, 432, 56);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeviceIcon$lambda$70;
                    DeviceIcon$lambda$70 = DeviceManagementKt.DeviceIcon$lambda$70(DeviceManagementDevice.this, deviceManagementPalette, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DeviceIcon$lambda$70;
                }
            });
        }
    }

    private static final void StatusChip(final boolean z, final DeviceManagementPalette deviceManagementPalette, Composer composer, final int i) {
        int i2;
        String kmpStringResource;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1503667309);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1503667309, i2, -1, "com.bytedance.trae.home.solo.setting.ui.StatusChip (DeviceManagement.kt:552)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), Dp.constructor-impl(52)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), z ? deviceManagementPalette.m2480getOnlineBackground0d7_KjU() : deviceManagementPalette.m2478getOfflineBackground0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            if (z) {
                startRestartGroup.startReplaceGroup(-751175061);
                kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_device_management_online(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-751079798);
                kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_device_management_offline(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            String str = kmpStringResource;
            composer2 = startRestartGroup;
            TextKt.Text--4IGK_g(str, (Modifier) null, z ? deviceManagementPalette.m2481getOnlineText0d7_KjU() : deviceManagementPalette.m2479getOfflineText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionXsStrong(), composer2, 0, 3072, 57338);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj, Object obj2) {
                    Unit StatusChip$lambda$72;
                    StatusChip$lambda$72 = DeviceManagementKt.StatusChip$lambda$72(z, deviceManagementPalette, i, (Composer) obj, ((Integer) obj2).intValue());
                    return StatusChip$lambda$72;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01c9, code lost:
    
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* renamed from: ActionCircle-LyZNIlQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m2450ActionCircleLyZNIlQ(final DrawableResource drawableResource, final float f, final String str, final long j, final DeviceManagementPalette deviceManagementPalette, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-1728347697);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(drawableResource) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1728347697, i2, -1, "com.bytedance.trae.home.solo.setting.ui.ActionCircle (DeviceManagement.kt:582)");
            }
            startRestartGroup.startReplaceGroup(1811084612);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final KmpClickHandler kmpClickHandler = (KmpClickHandler) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.set-impl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(hashCode))) {
                composer2.updateRememberedValue(Integer.valueOf(hashCode));
                composer2.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            Modifier modifier2 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(49)), RoundedCornerShapeKt.getCircleShape()), j, (Shape) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-1333035288);
            boolean changedInstance = startRestartGroup.changedInstance(kmpClickHandler) | ((458752 & i2) == 131072);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
                obj = rememberedValue2;
            }
            Function0 function02 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit ActionCircle_LyZNIlQ$lambda$77$lambda$75$lambda$74;
                    ActionCircle_LyZNIlQ$lambda$77$lambda$75$lambda$74 = DeviceManagementKt.ActionCircle_LyZNIlQ$lambda$77$lambda$75$lambda$74(kmpClickHandler, function0);
                    return ActionCircle_LyZNIlQ$lambda$77$lambda$75$lambda$74;
                }
            };
            startRestartGroup.updateRememberedValue(function02);
            obj = function02;
            startRestartGroup.endReplaceGroup();
            Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) obj, 15, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode2));
                composer3.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ImageKt.Image(ImageResources_androidKt.painterResource(drawableResource, startRestartGroup, i2 & 14), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, f), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, deviceManagementPalette.m2483getPrimaryButtonText0d7_KjU(), 0, 2, (Object) null), startRestartGroup, 48, 56);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), startRestartGroup, 6);
            TextKt.Text--4IGK_g(str, (Modifier) null, deviceManagementPalette.m2487getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getFootnote(), startRestartGroup, (i2 >> 6) & 14, 0, 65530);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ActionCircle_LyZNIlQ$lambda$78;
                    ActionCircle_LyZNIlQ$lambda$78 = DeviceManagementKt.ActionCircle_LyZNIlQ$lambda$78(drawableResource, f, str, j, deviceManagementPalette, function0, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return ActionCircle_LyZNIlQ$lambda$78;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionCircle_LyZNIlQ$lambda$77$lambda$75$lambda$74(KmpClickHandler kmpClickHandler, Function0 function0) {
        kmpClickHandler.tryHandle(function0);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0156, code lost:
    
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01cd, code lost:
    
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0225, code lost:
    
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void DeviceActionOverlay(final DeviceManagementMenuState deviceManagementMenuState, final DeviceManagementPalette deviceManagementPalette, final Function1<? super DeviceManagementAction, Unit> function1, Composer composer, final int i) {
        int i2;
        Object obj;
        Object obj2;
        Object obj3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-2004161797);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(deviceManagementMenuState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(deviceManagementPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2004161797, i2, -1, "com.bytedance.trae.home.solo.setting.ui.DeviceActionOverlay (DeviceManagement.kt:610)");
            }
            if (deviceManagementMenuState == null || deviceManagementMenuState.getSource() != DeviceManagementMenuSource.LongPress) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda28
                        public final Object invoke(Object obj4, Object obj5) {
                            Unit DeviceActionOverlay$lambda$79;
                            DeviceActionOverlay$lambda$79 = DeviceManagementKt.DeviceActionOverlay$lambda$79(DeviceManagementMenuState.this, deviceManagementPalette, function1, i, (Composer) obj4, ((Integer) obj5).intValue());
                            return DeviceActionOverlay$lambda$79;
                        }
                    });
                    return;
                }
                return;
            }
            String id = deviceManagementMenuState.getDevice().getId();
            startRestartGroup.startReplaceGroup(640490994);
            boolean changed = startRestartGroup.changed(id);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final KmpClickHandler kmpClickHandler = (KmpClickHandler) rememberedValue;
            startRestartGroup.endReplaceGroup();
            String id2 = deviceManagementMenuState.getDevice().getId();
            startRestartGroup.startReplaceGroup(640493426);
            boolean changed2 = startRestartGroup.changed(id2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final KmpClickHandler kmpClickHandler2 = (KmpClickHandler) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            String id3 = deviceManagementMenuState.getDevice().getId();
            startRestartGroup.startReplaceGroup(640495890);
            boolean changed3 = startRestartGroup.changed(id3);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final KmpClickHandler kmpClickHandler3 = (KmpClickHandler) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            TraeContextMenuItem[] traeContextMenuItemArr = new TraeContextMenuItem[2];
            String str = "rename_" + deviceManagementMenuState.getDevice().getId();
            DrawableResource cmp_ic_device_menu_rename = Drawable0_commonMainKt.getCmp_ic_device_menu_rename(Res.drawable.INSTANCE);
            String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_context_menu_rename(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            long m2484getPrimaryText0d7_KjU = deviceManagementPalette.m2484getPrimaryText0d7_KjU();
            startRestartGroup.startReplaceGroup(640508689);
            int i3 = i2 & 896;
            int i4 = i2 & 14;
            boolean changedInstance = startRestartGroup.changedInstance(kmpClickHandler) | (i3 == 256) | (i4 == 4);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
                obj = rememberedValue4;
            }
            Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda29
                public final Object invoke() {
                    Unit DeviceActionOverlay$lambda$85$lambda$84;
                    DeviceActionOverlay$lambda$85$lambda$84 = DeviceManagementKt.DeviceActionOverlay$lambda$85$lambda$84(kmpClickHandler, function1, deviceManagementMenuState);
                    return DeviceActionOverlay$lambda$85$lambda$84;
                }
            };
            startRestartGroup.updateRememberedValue(function0);
            obj = function0;
            startRestartGroup.endReplaceGroup();
            traeContextMenuItemArr[0] = new TraeContextMenuItem(str, kmpStringResource, (Function0) obj, cmp_ic_device_menu_rename, Color.box-impl(m2484getPrimaryText0d7_KjU), null, null, null, 224, null);
            String str2 = "delete_" + deviceManagementMenuState.getDevice().getId();
            DrawableResource cmp_ic_device_action_delete = Drawable0_commonMainKt.getCmp_ic_device_action_delete(Res.drawable.INSTANCE);
            String kmpStringResource2 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getSolo_context_menu_delete(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
            long m2474getDeleteText0d7_KjU = deviceManagementPalette.m2474getDeleteText0d7_KjU();
            startRestartGroup.startReplaceGroup(640524369);
            boolean changedInstance2 = (i4 == 4) | startRestartGroup.changedInstance(kmpClickHandler2) | (i3 == 256);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
                obj2 = rememberedValue5;
            }
            Function0 function02 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda30
                public final Object invoke() {
                    Unit DeviceActionOverlay$lambda$88$lambda$87;
                    DeviceActionOverlay$lambda$88$lambda$87 = DeviceManagementKt.DeviceActionOverlay$lambda$88$lambda$87(kmpClickHandler2, function1, deviceManagementMenuState);
                    return DeviceActionOverlay$lambda$88$lambda$87;
                }
            };
            startRestartGroup.updateRememberedValue(function02);
            obj2 = function02;
            startRestartGroup.endReplaceGroup();
            traeContextMenuItemArr[1] = new TraeContextMenuItem(str2, kmpStringResource2, (Function0) obj2, cmp_ic_device_action_delete, Color.box-impl(m2474getDeleteText0d7_KjU), null, null, null, 224, null);
            List listOf = CollectionsKt.listOf(traeContextMenuItemArr);
            TraeContextMenuPosition.Anchored anchored = new TraeContextMenuPosition.Anchored(deviceManagementMenuState.getAnchorX(), deviceManagementMenuState.getAnchorY());
            startRestartGroup.startReplaceGroup(640535972);
            boolean changedInstance3 = startRestartGroup.changedInstance(kmpClickHandler3) | (i3 == 256);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (!changedInstance3) {
                obj3 = rememberedValue6;
            }
            Function0 function03 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda31
                public final Object invoke() {
                    Unit DeviceActionOverlay$lambda$91$lambda$90;
                    DeviceActionOverlay$lambda$91$lambda$90 = DeviceManagementKt.DeviceActionOverlay$lambda$91$lambda$90(kmpClickHandler3, function1);
                    return DeviceActionOverlay$lambda$91$lambda$90;
                }
            };
            startRestartGroup.updateRememberedValue(function03);
            obj3 = function03;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            TraeContextMenuPopupKt.m1846TraeContextMenuPopup_G194Zc(listOf, anchored, (Function0) obj3, null, DeviceActionMenuWidth, DeviceActionMenuItemHeight, DeviceActionMenuCornerRadius, DeviceActionMenuElevation, 0.0f, false, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, DeviceActionMenuShadowPadding, 0L, deviceManagementPalette.m2484getPrimaryText0d7_KjU(), 0L, "cmp_device_management_long_press_menu", composer2, 819683328, 100663296, 384, 2882824);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda32
                public final Object invoke(Object obj4, Object obj5) {
                    Unit DeviceActionOverlay$lambda$92;
                    DeviceActionOverlay$lambda$92 = DeviceManagementKt.DeviceActionOverlay$lambda$92(DeviceManagementMenuState.this, deviceManagementPalette, function1, i, (Composer) obj4, ((Integer) obj5).intValue());
                    return DeviceActionOverlay$lambda$92;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceActionOverlay$lambda$85$lambda$84(KmpClickHandler kmpClickHandler, final Function1 function1, final DeviceManagementMenuState deviceManagementMenuState) {
        kmpClickHandler.tryHandle(new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda7
            public final Object invoke() {
                Unit DeviceActionOverlay$lambda$85$lambda$84$lambda$83;
                DeviceActionOverlay$lambda$85$lambda$84$lambda$83 = DeviceManagementKt.DeviceActionOverlay$lambda$85$lambda$84$lambda$83(function1, deviceManagementMenuState);
                return DeviceActionOverlay$lambda$85$lambda$84$lambda$83;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceActionOverlay$lambda$85$lambda$84$lambda$83(Function1 function1, DeviceManagementMenuState deviceManagementMenuState) {
        function1.invoke(new DeviceManagementAction.OpenRename(deviceManagementMenuState.getDevice()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceActionOverlay$lambda$88$lambda$87(KmpClickHandler kmpClickHandler, final Function1 function1, final DeviceManagementMenuState deviceManagementMenuState) {
        kmpClickHandler.tryHandle(new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit DeviceActionOverlay$lambda$88$lambda$87$lambda$86;
                DeviceActionOverlay$lambda$88$lambda$87$lambda$86 = DeviceManagementKt.DeviceActionOverlay$lambda$88$lambda$87$lambda$86(function1, deviceManagementMenuState);
                return DeviceActionOverlay$lambda$88$lambda$87$lambda$86;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceActionOverlay$lambda$88$lambda$87$lambda$86(Function1 function1, DeviceManagementMenuState deviceManagementMenuState) {
        function1.invoke(new DeviceManagementAction.OpenDelete(deviceManagementMenuState.getDevice()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceActionOverlay$lambda$91$lambda$90(KmpClickHandler kmpClickHandler, final Function1 function1) {
        kmpClickHandler.tryHandle(new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.DeviceManagementKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit DeviceActionOverlay$lambda$91$lambda$90$lambda$89;
                DeviceActionOverlay$lambda$91$lambda$90$lambda$89 = DeviceManagementKt.DeviceActionOverlay$lambda$91$lambda$90$lambda$89(function1);
                return DeviceActionOverlay$lambda$91$lambda$90$lambda$89;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeviceActionOverlay$lambda$91$lambda$90$lambda$89(Function1 function1) {
        function1.invoke(DeviceManagementAction.CloseMenu.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final DeviceManagementPalette deviceManagementPalette(Composer composer, int i) {
        composer.startReplaceGroup(1689645617);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1689645617, i, -1, "com.bytedance.trae.home.solo.setting.ui.deviceManagementPalette (DeviceManagement.kt:661)");
        }
        TraeColors colors = TraeTheme.INSTANCE.getColors(composer, TraeTheme.$stable);
        DeviceManagementPalette deviceManagementPalette = new DeviceManagementPalette(colors.mo1593getBgBgBaseSecondary0d7_KjU(), colors.mo1592getBgBgBaseDefault0d7_KjU(), colors.mo1806getTextTextDefault0d7_KjU(), colors.mo1813getTextTextTertiary0d7_KjU(), colors.mo1613getBorderBorderNeutralL10d7_KjU(), colors.mo1751getIconIconDefault0d7_KjU(), colors.mo1613getBorderBorderNeutralL10d7_KjU(), colors.mo1794getStatusSuccessDefault0d7_KjU(), colors.mo1773getSpecialWhite0d7_KjU(), colors.mo1606getBgBgOverlayL20d7_KjU(), colors.mo1811getTextTextSecondary0d7_KjU(), colors.mo1601getBgBgInvert0d7_KjU(), colors.mo1809getTextTextOnaccent0d7_KjU(), colors.mo1589getAccentAccentSlate0d7_KjU(), colors.mo1780getStatusErrorDefault0d7_KjU(), colors.mo1780getStatusErrorDefault0d7_KjU(), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return deviceManagementPalette;
    }

    /* renamed from: borderCompat-bw27NRU, reason: not valid java name */
    private static final Modifier m2451borderCompatbw27NRU(Modifier modifier, long j, RoundedCornerShape roundedCornerShape) {
        return BorderKt.border-xT4_qwU(modifier, Dp.constructor-impl(1), j, (Shape) roundedCornerShape);
    }

    static {
        float f = 12;
        DeviceAddButtonBottomPadding = Dp.constructor-impl(f);
        float f2 = 16;
        DeviceActionMenuShadowPadding = new TraeContextMenuShadowPadding(Dp.constructor-impl(f2), Dp.constructor-impl(f), Dp.constructor-impl(f2), Dp.constructor-impl(24), null);
    }
}
