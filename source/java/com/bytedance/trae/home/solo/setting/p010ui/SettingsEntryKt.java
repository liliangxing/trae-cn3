package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.design.compose.TraeTheme;
import com.bytedance.trae.design.compose.TraeTypography;
import com.bytedance.trae.home.generated.resources.Drawable0_commonMainKt;
import com.bytedance.trae.home.generated.resources.Res;
import com.bytedance.trae.home.generated.resources.String0_commonMainKt;
import com.bytedance.trae.home.solo.setting.p010ui.components.SettingsAvatarKt;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode;
import com.bytedance.trae.kmp.host.KmpHostDialogs;
import com.bytedance.trae.kmp.ui.KmpClickHandler;
import com.bytedance.trae.kmp.ui.KmpStringResource_androidKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResources_androidKt;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: SettingsEntry.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\u001a\u009d\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00110\u001bH\u0007¢\u0006\u0002\u0010#\u001a+\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0003¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010+\u001a%\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001aU\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u0010%\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00110\u001b2\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001106H\u0003¢\u0006\u0002\u00108\u001a\u001f\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010<\u001a'\u0010=\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010>\u001aQ\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020A2\u0006\u0010%\u001a\u00020&2\b\u0010B\u001a\u0004\u0018\u00010\u00012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\u0006\u0010D\u001a\u00020E2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00110\u001bH\u0003¢\u0006\u0002\u0010G\u001a\u001d\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020J2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010K\u001a\u0015\u0010L\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010M\u001a\u0015\u0010N\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010M\u001a\u001b\u0010O\u001a\u0004\u0018\u00010\u0001*\u00020A2\u0006\u0010P\u001a\u00020\"H\u0003¢\u0006\u0002\u0010Q\u001a\u0011\u0010R\u001a\u00020\u0001*\u00020\u0001H\u0003¢\u0006\u0002\u0010S\u001a\u0011\u0010T\u001a\u00020\u0001*\u00020\u0001H\u0003¢\u0006\u0002\u0010S\u001a\f\u0010U\u001a\u00020V*\u00020\u0001H\u0002\u001a\u001d\u0010W\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010X\u001a\f\u0010Y\u001a\u00020J*\u00020\"H\u0002\u001a\f\u0010Z\u001a\u00020J*\u00020\"H\u0002\u001a\f\u0010[\u001a\u00020V*\u00020\"H\u0002\u001a\f\u0010[\u001a\u00020V*\u00020\u001cH\u0002\u001a\f\u0010[\u001a\u00020V*\u00020*H\u0002\u001a\u0012\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001c0]*\u00020\u001cH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006^²\u0006\f\u0010_\u001a\u0004\u0018\u00010`X\u008a\u008e\u0002²\u0006\n\u0010a\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010b\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010c\u001a\u00020dX\u008a\u008e\u0002"}, d2 = {"LANGUAGE_EN", "", "LANGUAGE_ZH", "LANGUAGE_JA", "SettingsPopupWidth", "Landroidx/compose/ui/unit/Dp;", "F", "SettingsPopupItemHeight", "SettingsPopupCornerRadius", "SettingsPopupElevation", "SettingsPopupDividerHeight", "SettingsPopupEndMargin", "SettingsItemHeight", "SettingsPopupAnchorYOffset", "SettingsItemIconSlotSize", "SettingsItemIconSize", "SettingsEntryContent", "", "state", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentScrollState", "Landroidx/compose/foundation/ScrollState;", "onEditProfile", "Lkotlin/Function0;", "onThemeSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;", "onLanguageSelected", "onOpenAbout", "onOpenDeviceManagement", "onLogoutConfirmed", "onItemClick", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ProfileHeader", "colors", "Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EnterpriseBadge", "badge", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Landroidx/compose/runtime/Composer;I)V", "TextBadge", "text", "style", "Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;", "(Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;Landroidx/compose/runtime/Composer;I)V", "SettingsGroupView", "group", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;", "messageUnreadBadge", "onRowPositioned", "Lkotlin/Function2;", "", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SettingsFooter", "footer", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Landroidx/compose/runtime/Composer;I)V", "FooterText", "(Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SettingsRow", "item", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;", "unreadBadge", "onClick", "clickHandler", "Lcom/bytedance/trae/kmp/ui/KmpClickHandler;", "onPositioned", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/bytedance/trae/kmp/ui/KmpClickHandler;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SettingsItemIcon", "icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "(Lorg/jetbrains/compose/resources/DrawableResource;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Landroidx/compose/runtime/Composer;I)V", "UsageTrailing", "(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Landroidx/compose/runtime/Composer;I)V", "UpgradeButton", "trailingText", "key", "(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "themeDisplayName", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "languageDisplayName", "languageDisplayResource", "Lorg/jetbrains/compose/resources/StringResource;", "UnreadBadge", "(Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;Landroidx/compose/runtime/Composer;I)V", "iconResource", "trailingIconResource", "titleResource", "popupOptions", "", "impl_mainlandRelease", "popupType", "Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;", "themeAnchorTop", "languageAnchorTop", "logoutDialogVisible", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsEntryKt {
    private static final String LANGUAGE_EN = "en";
    private static final String LANGUAGE_JA = "ja";
    private static final String LANGUAGE_ZH = "zh";
    private static final float SettingsItemHeight;
    private static final float SettingsItemIconSize;
    private static final float SettingsItemIconSlotSize;
    private static final float SettingsPopupAnchorYOffset;
    private static final float SettingsPopupCornerRadius;
    private static final float SettingsPopupEndMargin;
    private static final float SettingsPopupWidth = Dp.constructor-impl(180);
    private static final float SettingsPopupItemHeight = Dp.constructor-impl(44);
    private static final float SettingsPopupElevation = Dp.constructor-impl(40);
    private static final float SettingsPopupDividerHeight = Dp.constructor-impl((float) 0.5d);

    /* compiled from: SettingsEntry.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[SettingsTextBadgeStyle.values().length];
            try {
                iArr[SettingsTextBadgeStyle.Free.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsTextBadgeStyle.PublicCloud.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingsTextBadgeStyle.Enterprise.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SettingsItemKey.values().length];
            try {
                iArr2[SettingsItemKey.Theme.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SettingsItemKey.Language.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SettingsItemKey.Debug.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SettingsItemKey.Subscribe.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SettingsItemKey.Usage.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SettingsItemKey.Account.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[SettingsItemKey.Message.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[SettingsItemKey.Points.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[SettingsItemKey.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[SettingsItemKey.DeviceManagement.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[SettingsItemKey.Connectors.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[SettingsItemKey.PrivacyPermission.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[SettingsItemKey.Update.ordinal()] = 13;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[SettingsItemKey.About.ordinal()] = 14;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[SettingsItemKey.Logout.ordinal()] = 15;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SettingsThemeMode.values().length];
            try {
                iArr3[SettingsThemeMode.Light.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr3[SettingsThemeMode.Dark.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr3[SettingsThemeMode.System.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[SettingsEnterpriseBadge.values().length];
            try {
                iArr4[SettingsEnterpriseBadge.Team.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr4[SettingsEnterpriseBadge.Enterprise.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnterpriseBadge$lambda$26(SettingsEnterpriseBadge settingsEnterpriseBadge, SettingsEntryPalette settingsEntryPalette, int i, Composer composer, int i2) {
        EnterpriseBadge(settingsEnterpriseBadge, settingsEntryPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FooterText$lambda$41(String str, SettingsEntryPalette settingsEntryPalette, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FooterText(str, settingsEntryPalette, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileHeader$lambda$25(SettingsEntryState settingsEntryState, SettingsEntryPalette settingsEntryPalette, Function0 function0, int i, Composer composer, int i2) {
        ProfileHeader(settingsEntryState, settingsEntryPalette, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsEntryContent$lambda$17(SettingsEntryState settingsEntryState, Modifier modifier, ScrollState scrollState, Function0 function0, Function1 function1, Function1 function12, Function0 function02, Function0 function03, Function0 function04, Function1 function13, int i, int i2, Composer composer, int i3) {
        SettingsEntryContent(settingsEntryState, modifier, scrollState, function0, function1, function12, function02, function03, function04, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsFooter$lambda$39(SettingsFooterState settingsFooterState, SettingsEntryPalette settingsEntryPalette, int i, Composer composer, int i2) {
        SettingsFooter(settingsFooterState, settingsEntryPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsFooter$lambda$40(SettingsFooterState settingsFooterState, SettingsEntryPalette settingsEntryPalette, int i, Composer composer, int i2) {
        SettingsFooter(settingsFooterState, settingsEntryPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsGroupView$lambda$29(SettingsGroup settingsGroup, SettingsEntryPalette settingsEntryPalette, String str, Function1 function1, Function2 function2, int i, Composer composer, int i2) {
        SettingsGroupView(settingsGroup, settingsEntryPalette, str, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsGroupView$lambda$38(SettingsGroup settingsGroup, SettingsEntryPalette settingsEntryPalette, String str, Function1 function1, Function2 function2, int i, Composer composer, int i2) {
        SettingsGroupView(settingsGroup, settingsEntryPalette, str, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsItemIcon$lambda$48(DrawableResource drawableResource, SettingsEntryPalette settingsEntryPalette, int i, Composer composer, int i2) {
        SettingsItemIcon(drawableResource, settingsEntryPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsRow$lambda$46(SettingsItem settingsItem, SettingsEntryPalette settingsEntryPalette, String str, Function0 function0, KmpClickHandler kmpClickHandler, Function1 function1, int i, Composer composer, int i2) {
        SettingsRow(settingsItem, settingsEntryPalette, str, function0, kmpClickHandler, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextBadge$lambda$28(String str, SettingsEntryPalette settingsEntryPalette, SettingsTextBadgeStyle settingsTextBadgeStyle, int i, Composer composer, int i2) {
        TextBadge(str, settingsEntryPalette, settingsTextBadgeStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnreadBadge$lambda$58(String str, SettingsEntryPalette settingsEntryPalette, int i, Composer composer, int i2) {
        UnreadBadge(str, settingsEntryPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpgradeButton$lambda$52(SettingsEntryPalette settingsEntryPalette, int i, Composer composer, int i2) {
        UpgradeButton(settingsEntryPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UsageTrailing$lambda$50(SettingsEntryPalette settingsEntryPalette, int i, Composer composer, int i2) {
        UsageTrailing(settingsEntryPalette, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SettingsEntryContent(final SettingsEntryState settingsEntryState, Modifier modifier, ScrollState scrollState, final Function0<Unit> function0, final Function1<? super SettingsThemeMode, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function1<? super SettingsItemKey, Unit> function13, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        ScrollState rememberScrollState;
        Object rememberedValue;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        Object rememberedValue5;
        Modifier modifier3;
        Boolean valueOf;
        boolean changed;
        SettingsEntryKt$SettingsEntryContent$1$1 rememberedValue6;
        Modifier modifier4;
        Composer composer2;
        Boolean bool;
        int i4;
        Object obj;
        Object rememberedValue7;
        Composer composer3;
        final Modifier modifier5;
        final ScrollState scrollState2;
        ScopeUpdateScope endRestartGroup;
        int i5;
        Intrinsics.checkNotNullParameter(settingsEntryState, "state");
        Intrinsics.checkNotNullParameter(function0, "onEditProfile");
        Intrinsics.checkNotNullParameter(function1, "onThemeSelected");
        Intrinsics.checkNotNullParameter(function12, "onLanguageSelected");
        Intrinsics.checkNotNullParameter(function02, "onOpenAbout");
        Intrinsics.checkNotNullParameter(function03, "onOpenDeviceManagement");
        Intrinsics.checkNotNullParameter(function04, "onLogoutConfirmed");
        Intrinsics.checkNotNullParameter(function13, "onItemClick");
        Composer startRestartGroup = composer.startRestartGroup(-203173739);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(settingsEntryState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0 && startRestartGroup.changed(scrollState)) {
                    i5 = StatusBarUtils.FLAG_NOTCH_SUPPORT;
                    i3 |= i5;
                }
                i5 = 128;
                i3 |= i5;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function1) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
            }
            if ((i2 & 32) == 0) {
                i3 |= 196608;
            } else if ((i & 196608) == 0) {
                i3 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 1048576 : FConstants.SLICE_SIZE;
            }
            if ((i2 & 128) == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= startRestartGroup.changedInstance(function03) ? 8388608 : 4194304;
            }
            if ((i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i3 |= startRestartGroup.changedInstance(function04) ? 67108864 : 33554432;
            }
            if ((i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) == 0) {
                i3 |= 805306368;
            } else if ((i & 805306368) == 0) {
                i3 |= startRestartGroup.changedInstance(function13) ? 536870912 : 268435456;
            }
            if ((306783379 & i3) == 306783378 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-203173739, i3, -1, "com.bytedance.trae.home.solo.setting.ui.SettingsEntryContent (SettingsEntry.kt:150)");
                        }
                        SettingsEntryPalette settingsEntryPalette = SettingsScaffoldKt.settingsEntryPalette(startRestartGroup, 0);
                        startRestartGroup.startReplaceGroup(-1878175265);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1878172725);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        MutableState mutableState2 = (MutableState) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1878170709);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        MutableState mutableState3 = (MutableState) rememberedValue3;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1878168628);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        MutableState mutableState4 = (MutableState) rememberedValue4;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1878166392);
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                        }
                        KmpClickHandler kmpClickHandler = (KmpClickHandler) rememberedValue5;
                        startRestartGroup.endReplaceGroup();
                        String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_logout(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                        String kmpStringResource2 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_logout_confirm_message(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                        modifier3 = modifier2;
                        String kmpStringResource3 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_cancel(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                        String kmpStringResource4 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_ok(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                        CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Density density = (Density) consume;
                        valueOf = Boolean.valueOf(SettingsEntryContent$lambda$10(mutableState4));
                        startRestartGroup.startReplaceGroup(-1878152726);
                        changed = startRestartGroup.changed(kmpStringResource) | startRestartGroup.changed(kmpStringResource2) | startRestartGroup.changed(kmpStringResource3) | startRestartGroup.changed(kmpStringResource4) | ((i3 & 234881024) == 67108864);
                        rememberedValue6 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue6 == Composer.Companion.getEmpty()) {
                            modifier4 = modifier3;
                            composer2 = startRestartGroup;
                            bool = valueOf;
                            i4 = 1;
                            obj = null;
                            rememberedValue6 = new SettingsEntryKt$SettingsEntryContent$1$1(kmpStringResource, kmpStringResource2, kmpStringResource3, kmpStringResource4, mutableState4, function04, null);
                            composer2.updateRememberedValue(rememberedValue6);
                        } else {
                            modifier4 = modifier3;
                            composer2 = startRestartGroup;
                            bool = valueOf;
                            obj = null;
                            i4 = 1;
                        }
                        composer2.endReplaceGroup();
                        EffectsKt.LaunchedEffect(bool, (Function2) rememberedValue6, composer2, 0);
                        Unit unit = Unit.INSTANCE;
                        composer2.startReplaceGroup(-1878134892);
                        rememberedValue7 = composer2.rememberedValue();
                        if (rememberedValue7 == Composer.Companion.getEmpty()) {
                            rememberedValue7 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj2) {
                                    DisposableEffectResult SettingsEntryContent$lambda$16$lambda$15;
                                    SettingsEntryContent$lambda$16$lambda$15 = SettingsEntryKt.SettingsEntryContent$lambda$16$lambda$15((DisposableEffectScope) obj2);
                                    return SettingsEntryContent$lambda$16$lambda$15;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue7);
                        }
                        composer2.endReplaceGroup();
                        EffectsKt.DisposableEffect(unit, (Function1) rememberedValue7, composer2, 54);
                        Modifier modifier6 = modifier4;
                        Modifier modifier7 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier6, 0.0f, i4, obj), settingsEntryPalette.m2527getBackground0d7_KjU(), (Shape) null, 2, (Object) null);
                        SettingsEntryKt$SettingsEntryContent$3 settingsEntryKt$SettingsEntryContent$3 = new SettingsEntryKt$SettingsEntryContent$3(rememberScrollState, settingsEntryState, settingsEntryPalette, function0, function02, function03, function13, density, mutableState, mutableState4, mutableState2, mutableState3, kmpClickHandler, function1, function12);
                        composer3 = composer2;
                        BoxWithConstraintsKt.BoxWithConstraints(modifier7, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-108097301, true, settingsEntryKt$SettingsEntryContent$3, composer3, 54), composer3, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier6;
                        scrollState2 = rememberScrollState;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                }
                rememberScrollState = scrollState;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                SettingsEntryPalette settingsEntryPalette2 = SettingsScaffoldKt.settingsEntryPalette(startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(-1878175265);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                MutableState mutableState5 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1878172725);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                }
                MutableState mutableState22 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1878170709);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                }
                MutableState mutableState32 = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1878168628);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                }
                MutableState mutableState42 = (MutableState) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1878166392);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                }
                KmpClickHandler kmpClickHandler2 = (KmpClickHandler) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                String kmpStringResource5 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_logout(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                String kmpStringResource22 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_logout_confirm_message(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                modifier3 = modifier2;
                String kmpStringResource32 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_cancel(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                String kmpStringResource42 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_ok(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
                CompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2 = (Density) consume2;
                valueOf = Boolean.valueOf(SettingsEntryContent$lambda$10(mutableState42));
                startRestartGroup.startReplaceGroup(-1878152726);
                changed = startRestartGroup.changed(kmpStringResource5) | startRestartGroup.changed(kmpStringResource22) | startRestartGroup.changed(kmpStringResource32) | startRestartGroup.changed(kmpStringResource42) | ((i3 & 234881024) == 67108864);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (changed) {
                }
                modifier4 = modifier3;
                composer2 = startRestartGroup;
                bool = valueOf;
                i4 = 1;
                obj = null;
                rememberedValue6 = new SettingsEntryKt$SettingsEntryContent$1$1(kmpStringResource5, kmpStringResource22, kmpStringResource32, kmpStringResource42, mutableState42, function04, null);
                composer2.updateRememberedValue(rememberedValue6);
                composer2.endReplaceGroup();
                EffectsKt.LaunchedEffect(bool, (Function2) rememberedValue6, composer2, 0);
                Unit unit2 = Unit.INSTANCE;
                composer2.startReplaceGroup(-1878134892);
                rememberedValue7 = composer2.rememberedValue();
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                }
                composer2.endReplaceGroup();
                EffectsKt.DisposableEffect(unit2, (Function1) rememberedValue7, composer2, 54);
                Modifier modifier62 = modifier4;
                Modifier modifier72 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier62, 0.0f, i4, obj), settingsEntryPalette2.m2527getBackground0d7_KjU(), (Shape) null, 2, (Object) null);
                SettingsEntryKt$SettingsEntryContent$3 settingsEntryKt$SettingsEntryContent$32 = new SettingsEntryKt$SettingsEntryContent$3(rememberScrollState, settingsEntryState, settingsEntryPalette2, function0, function02, function03, function13, density2, mutableState5, mutableState42, mutableState22, mutableState32, kmpClickHandler2, function1, function12);
                composer3 = composer2;
                BoxWithConstraintsKt.BoxWithConstraints(modifier72, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-108097301, true, settingsEntryKt$SettingsEntryContent$32, composer3, 54), composer3, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier5 = modifier62;
                scrollState2 = rememberScrollState;
            } else {
                startRestartGroup.skipToGroupEnd();
                scrollState2 = scrollState;
                modifier5 = modifier2;
                composer3 = startRestartGroup;
            }
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit SettingsEntryContent$lambda$17;
                        SettingsEntryContent$lambda$17 = SettingsEntryKt.SettingsEntryContent$lambda$17(SettingsEntryState.this, modifier5, scrollState2, function0, function1, function12, function02, function03, function04, function13, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        return SettingsEntryContent$lambda$17;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 384) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0) {
        }
        if ((i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) == 0) {
        }
        if ((306783379 & i3) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        rememberScrollState = scrollState;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        SettingsEntryPalette settingsEntryPalette22 = SettingsScaffoldKt.settingsEntryPalette(startRestartGroup, 0);
        startRestartGroup.startReplaceGroup(-1878175265);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        MutableState mutableState52 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1878172725);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
        }
        MutableState mutableState222 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1878170709);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
        }
        MutableState mutableState322 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1878168628);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
        }
        MutableState mutableState422 = (MutableState) rememberedValue4;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1878166392);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
        }
        KmpClickHandler kmpClickHandler22 = (KmpClickHandler) rememberedValue5;
        startRestartGroup.endReplaceGroup();
        String kmpStringResource52 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_logout(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
        String kmpStringResource222 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_logout_confirm_message(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
        modifier3 = modifier2;
        String kmpStringResource322 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_cancel(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
        String kmpStringResource422 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_ok(Res.string.INSTANCE), new Object[0], startRestartGroup, 0);
        CompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localDensity22);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density22 = (Density) consume22;
        valueOf = Boolean.valueOf(SettingsEntryContent$lambda$10(mutableState422));
        startRestartGroup.startReplaceGroup(-1878152726);
        changed = startRestartGroup.changed(kmpStringResource52) | startRestartGroup.changed(kmpStringResource222) | startRestartGroup.changed(kmpStringResource322) | startRestartGroup.changed(kmpStringResource422) | ((i3 & 234881024) == 67108864);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        modifier4 = modifier3;
        composer2 = startRestartGroup;
        bool = valueOf;
        i4 = 1;
        obj = null;
        rememberedValue6 = new SettingsEntryKt$SettingsEntryContent$1$1(kmpStringResource52, kmpStringResource222, kmpStringResource322, kmpStringResource422, mutableState422, function04, null);
        composer2.updateRememberedValue(rememberedValue6);
        composer2.endReplaceGroup();
        EffectsKt.LaunchedEffect(bool, (Function2) rememberedValue6, composer2, 0);
        Unit unit22 = Unit.INSTANCE;
        composer2.startReplaceGroup(-1878134892);
        rememberedValue7 = composer2.rememberedValue();
        if (rememberedValue7 == Composer.Companion.getEmpty()) {
        }
        composer2.endReplaceGroup();
        EffectsKt.DisposableEffect(unit22, (Function1) rememberedValue7, composer2, 54);
        Modifier modifier622 = modifier4;
        Modifier modifier722 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier622, 0.0f, i4, obj), settingsEntryPalette22.m2527getBackground0d7_KjU(), (Shape) null, 2, (Object) null);
        SettingsEntryKt$SettingsEntryContent$3 settingsEntryKt$SettingsEntryContent$322 = new SettingsEntryKt$SettingsEntryContent$3(rememberScrollState, settingsEntryState, settingsEntryPalette22, function0, function02, function03, function13, density22, mutableState52, mutableState422, mutableState222, mutableState322, kmpClickHandler22, function1, function12);
        composer3 = composer2;
        BoxWithConstraintsKt.BoxWithConstraints(modifier722, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-108097301, true, settingsEntryKt$SettingsEntryContent$322, composer3, 54), composer3, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier5 = modifier622;
        scrollState2 = rememberScrollState;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsPopupType SettingsEntryContent$lambda$1(MutableState<SettingsPopupType> mutableState) {
        return (SettingsPopupType) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SettingsEntryContent$lambda$4(MutableState<Dp> mutableState) {
        return ((Dp) ((State) mutableState).getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsEntryContent$lambda$5(MutableState<Dp> mutableState, float f) {
        mutableState.setValue(Dp.box-impl(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SettingsEntryContent$lambda$7(MutableState<Dp> mutableState) {
        return ((Dp) ((State) mutableState).getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsEntryContent$lambda$8(MutableState<Dp> mutableState, float f) {
        mutableState.setValue(Dp.box-impl(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SettingsEntryContent$lambda$10(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsEntryContent$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileHeader(final SettingsEntryState settingsEntryState, final SettingsEntryPalette settingsEntryPalette, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        String str;
        int i3;
        String str2;
        KmpClickHandler kmpClickHandler;
        float f;
        int i4;
        Composer composer2;
        int i5;
        boolean z;
        SettingsTextBadgeStyle settingsTextBadgeStyle;
        Composer composer3;
        Composer composer4;
        Composer startRestartGroup = composer.startRestartGroup(1666269811);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(settingsEntryState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        int i6 = i2;
        if ((i6 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1666269811, i6, -1, "com.bytedance.trae.home.solo.setting.ui.ProfileHeader (SettingsEntry.kt:297)");
            }
            TraeTypography typography = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
            startRestartGroup.startReplaceGroup(81851444);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new KmpClickHandler((Function0) null, 1, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            KmpClickHandler kmpClickHandler2 = (KmpClickHandler) rememberedValue;
            startRestartGroup.endReplaceGroup();
            String displayName = settingsEntryState.getDisplayName();
            String accountText = settingsEntryState.getAccountText();
            float f2 = 12;
            float f3 = 6;
            Modifier modifier = PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f3), Dp.constructor-impl(f2), Dp.constructor-impl(f3), Dp.constructor-impl(f2));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
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
            Composer composer5 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer5, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer5.getInserting() || !Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(hashCode))) {
                composer5.updateRememberedValue(Integer.valueOf(hashCode));
                composer5.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            Alignment bottomEnd = Alignment.Companion.getBottomEnd();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier2 = Modifier.Companion;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomEnd, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
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
            Composer composer6 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer6, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(hashCode2))) {
                composer6.updateRememberedValue(Integer.valueOf(hashCode2));
                composer6.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer6, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(80)), RoundedCornerShapeKt.getCircleShape());
            startRestartGroup.startReplaceGroup(-1030163838);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit ProfileHeader$lambda$24$lambda$22$lambda$20$lambda$19;
                        ProfileHeader$lambda$24$lambda$22$lambda$20$lambda$19 = SettingsEntryKt.ProfileHeader$lambda$24$lambda$22$lambda$20$lambda$19((SemanticsPropertyReceiver) obj);
                        return ProfileHeader$lambda$24$lambda$22$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(clip, false, (Function1) rememberedValue2, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer7 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer7, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer7, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer7.getInserting() || !Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(hashCode3))) {
                composer7.updateRememberedValue(Integer.valueOf(hashCode3));
                composer7.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
            }
            Updater.set-impl(composer7, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            SettingsAvatarKt.SettingsAvatar(settingsEntryState.getAvatarUrl(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), startRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-1030155705);
            if (settingsEntryState.getShowByteCloudBadge()) {
                str2 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                f = f2;
                kmpClickHandler = kmpClickHandler2;
                i3 = i6;
                i4 = 6;
                ImageKt.Image(ImageResources_androidKt.painterResource(Drawable0_commonMainKt.getCmp_trae_ic_bytecloud_badge(Res.drawable.INSTANCE), startRestartGroup, 0), KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_bytecloud_badge(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(28)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 384, 120);
            } else {
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                i3 = i6;
                str2 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
                kmpClickHandler = kmpClickHandler2;
                f = f2;
                i4 = 6;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), startRestartGroup, i4);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier3 = Modifier.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, str2);
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, str);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer composer8 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer8, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer8, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer8.getInserting() || !Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(hashCode4))) {
                composer8.updateRememberedValue(Integer.valueOf(hashCode4));
                composer8.apply(Integer.valueOf(hashCode4), setCompositeKeyHash4);
            }
            Updater.set-impl(composer8, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            TextKt.Text--4IGK_g(displayName, (Modifier) null, settingsEntryPalette.m2539getPrimaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, typography.getHeadingXlStrong(), startRestartGroup, 0, 3120, 55290);
            if (settingsEntryState.getEnterpriseBadge() != null) {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1869262677);
                i5 = 4;
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), composer2, i4);
                EnterpriseBadge(settingsEntryState.getEnterpriseBadge(), settingsEntryPalette, composer2, i3 & 112);
                composer2.endReplaceGroup();
                z = true;
            } else {
                composer2 = startRestartGroup;
                i5 = 4;
                if (settingsEntryState.getIdentityBadgeText() != null) {
                    composer2.startReplaceGroup(-1869038795);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), composer2, i4);
                    String identityBadgeText = settingsEntryState.getIdentityBadgeText();
                    z = true;
                    if (StringsKt.equals(settingsEntryState.getIdentityBadgeText(), "free", true)) {
                        settingsTextBadgeStyle = SettingsTextBadgeStyle.Free;
                    } else {
                        settingsTextBadgeStyle = SettingsTextBadgeStyle.PublicCloud;
                    }
                    TextBadge(identityBadgeText, settingsEntryPalette, settingsTextBadgeStyle, composer2, i3 & 112);
                    composer2.endReplaceGroup();
                } else {
                    z = true;
                    composer2.startReplaceGroup(-1868539602);
                    composer2.endReplaceGroup();
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.startReplaceGroup(-426493313);
            if (StringsKt.isBlank(accountText) ^ z) {
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(i5)), composer2, i4);
                composer3 = composer2;
                TextKt.Text--4IGK_g(accountText, (Modifier) null, settingsEntryPalette.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, typography.getBodyXs(), composer3, 0, 3120, 55290);
            } else {
                composer3 = composer2;
            }
            composer3.endReplaceGroup();
            Composer composer9 = composer3;
            composer9.startReplaceGroup(-426482208);
            if (settingsEntryState.getShowEditProfile()) {
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer9, i4);
                composer4 = composer9;
                TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_edit_profile(Res.string.INSTANCE), new Object[0], composer9, 0), PaddingKt.padding-VpY3zN4(SettingsScaffoldKt.noRippleClickable(BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(f))), settingsEntryPalette.m2531getEditButtonBackground0d7_KjU(), (Shape) null, 2, (Object) null), kmpClickHandler, function0), Dp.constructor-impl(f), Dp.constructor-impl(8)), settingsEntryPalette.m2539getPrimaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, typography.getBodyXs(), composer4, 0, 0, 65528);
            } else {
                composer4 = composer9;
            }
            composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer4 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileHeader$lambda$25;
                    ProfileHeader$lambda$25 = SettingsEntryKt.ProfileHeader$lambda$25(SettingsEntryState.this, settingsEntryPalette, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileHeader$lambda$25;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileHeader$lambda$24$lambda$22$lambda$20$lambda$19(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "cmp_settings_avatar");
        return Unit.INSTANCE;
    }

    private static final void EnterpriseBadge(final SettingsEnterpriseBadge settingsEnterpriseBadge, final SettingsEntryPalette settingsEntryPalette, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1965253816);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(settingsEnterpriseBadge) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1965253816, i2, -1, "com.bytedance.trae.home.solo.setting.ui.EnterpriseBadge (SettingsEntry.kt:387)");
            }
            TextBadge(KmpStringResource_androidKt.kmpStringResource(titleResource(settingsEnterpriseBadge), new Object[0], startRestartGroup, 0), settingsEntryPalette, SettingsTextBadgeStyle.Enterprise, startRestartGroup, (i2 & 112) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit EnterpriseBadge$lambda$26;
                    EnterpriseBadge$lambda$26 = SettingsEntryKt.EnterpriseBadge$lambda$26(SettingsEnterpriseBadge.this, settingsEntryPalette, i, (Composer) obj, ((Integer) obj2).intValue());
                    return EnterpriseBadge$lambda$26;
                }
            });
        }
    }

    private static final void TextBadge(final String str, final SettingsEntryPalette settingsEntryPalette, final SettingsTextBadgeStyle settingsTextBadgeStyle, Composer composer, final int i) {
        int i2;
        long m2534getFreeBadgeBackground0d7_KjU;
        long m2535getFreeBadgeText0d7_KjU;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1031772878);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(settingsTextBadgeStyle) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        int i3 = i2;
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1031772878, i3, -1, "com.bytedance.trae.home.solo.setting.ui.TextBadge (SettingsEntry.kt:406)");
            }
            TraeTypography typography = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
            boolean z = settingsTextBadgeStyle == SettingsTextBadgeStyle.Free;
            int i4 = WhenMappings.$EnumSwitchMapping$0[settingsTextBadgeStyle.ordinal()];
            if (i4 == 1) {
                m2534getFreeBadgeBackground0d7_KjU = settingsEntryPalette.m2534getFreeBadgeBackground0d7_KjU();
            } else if (i4 == 2) {
                m2534getFreeBadgeBackground0d7_KjU = settingsEntryPalette.m2528getBadgeBackground0d7_KjU();
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                m2534getFreeBadgeBackground0d7_KjU = settingsEntryPalette.m2532getEnterpriseBadgeBackground0d7_KjU();
            }
            long j = m2534getFreeBadgeBackground0d7_KjU;
            int i5 = WhenMappings.$EnumSwitchMapping$0[settingsTextBadgeStyle.ordinal()];
            if (i5 == 1) {
                m2535getFreeBadgeText0d7_KjU = settingsEntryPalette.m2535getFreeBadgeText0d7_KjU();
            } else if (i5 == 2) {
                m2535getFreeBadgeText0d7_KjU = settingsEntryPalette.m2529getBadgeText0d7_KjU();
            } else {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                m2535getFreeBadgeText0d7_KjU = settingsEntryPalette.m2533getEnterpriseBadgeText0d7_KjU();
            }
            long j2 = m2535getFreeBadgeText0d7_KjU;
            Modifier modifier = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(z ? 4 : 999))), j, (Shape) null, 2, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(2));
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
            composer2 = startRestartGroup;
            TextKt.Text--4IGK_g(str, (Modifier) null, j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, typography.getCaptionXsStrong(), composer2, i3 & 14, 0, 65530);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextBadge$lambda$28;
                    TextBadge$lambda$28 = SettingsEntryKt.TextBadge$lambda$28(str, settingsEntryPalette, settingsTextBadgeStyle, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextBadge$lambda$28;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda6, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v4 */
    public static final void SettingsGroupView(final SettingsGroup settingsGroup, final SettingsEntryPalette settingsEntryPalette, final String str, final Function1<? super SettingsItemKey, Unit> function1, final Function2<? super SettingsItemKey, ? super Float, Unit> function2, Composer composer, final int i) {
        String str2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(810577646);
        int i2 = (i & 6) == 0 ? (startRestartGroup.changedInstance(settingsGroup) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        String str3 = str;
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str3) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
        }
        int i3 = i2;
        if ((i3 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(810577646, i3, -1, "com.bytedance.trae.home.solo.setting.ui.SettingsGroupView (SettingsEntry.kt:441)");
            }
            if (settingsGroup.getItems().isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit SettingsGroupView$lambda$29;
                            SettingsGroupView$lambda$29 = SettingsEntryKt.SettingsGroupView$lambda$29(SettingsGroup.this, settingsEntryPalette, str, function1, function2, i, (Composer) obj2, ((Integer) obj3).intValue());
                            return SettingsGroupView$lambda$29;
                        }
                    });
                    return;
                }
                return;
            }
            int i4 = 1;
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16))), settingsEntryPalette.m2540getSurface0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
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
            startRestartGroup.startReplaceGroup(591589057);
            for (final SettingsItem settingsItem : settingsGroup.getItems()) {
                SettingsItemKey key = settingsItem.getKey();
                startRestartGroup.startReplaceGroup(1898173863);
                boolean changed = startRestartGroup.changed(key);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    str2 = null;
                    KmpClickHandler kmpClickHandler = new KmpClickHandler((Function0) null, i4, (DefaultConstructorMarker) null);
                    startRestartGroup.updateRememberedValue(kmpClickHandler);
                    obj = kmpClickHandler;
                } else {
                    str2 = null;
                    obj = rememberedValue;
                }
                KmpClickHandler kmpClickHandler2 = (KmpClickHandler) obj;
                startRestartGroup.endReplaceGroup();
                String str4 = (settingsItem.getKey() == SettingsItemKey.Message ? i4 : 0) != 0 ? str3 : str2;
                startRestartGroup.startReplaceGroup(1898181880);
                int i5 = ((i3 & 7168) == 2048 ? i4 : 0) | (startRestartGroup.changed(settingsItem) ? 1 : 0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (i5 != 0 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit SettingsGroupView$lambda$37$lambda$36$lambda$33$lambda$32;
                            SettingsGroupView$lambda$37$lambda$36$lambda$33$lambda$32 = SettingsEntryKt.SettingsGroupView$lambda$37$lambda$36$lambda$33$lambda$32(function1, settingsItem);
                            return SettingsGroupView$lambda$37$lambda$36$lambda$33$lambda$32;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function0 function0 = (Function0) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1898185324);
                int i6 = ((57344 & i3) == 16384 ? i4 : 0) | (startRestartGroup.changed(settingsItem) ? 1 : 0);
                Function1 rememberedValue3 = startRestartGroup.rememberedValue();
                if (i6 != 0 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj2) {
                            Unit SettingsGroupView$lambda$37$lambda$36$lambda$35$lambda$34;
                            SettingsGroupView$lambda$37$lambda$36$lambda$35$lambda$34 = SettingsEntryKt.SettingsGroupView$lambda$37$lambda$36$lambda$35$lambda$34(function2, settingsItem, ((Float) obj2).floatValue());
                            return SettingsGroupView$lambda$37$lambda$36$lambda$35$lambda$34;
                        }
                    };
                    startRestartGroup.updateRememberedValue((Object) rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                SettingsRow(settingsItem, settingsEntryPalette, str4, function0, kmpClickHandler2, rememberedValue3, startRestartGroup, (i3 & 112) | (KmpClickHandler.$stable << 12));
                str3 = str;
                i3 = i3;
                i4 = 1;
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
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SettingsGroupView$lambda$38;
                    SettingsGroupView$lambda$38 = SettingsEntryKt.SettingsGroupView$lambda$38(SettingsGroup.this, settingsEntryPalette, str, function1, function2, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return SettingsGroupView$lambda$38;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsGroupView$lambda$37$lambda$36$lambda$33$lambda$32(Function1 function1, SettingsItem settingsItem) {
        function1.invoke(settingsItem.getKey());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsGroupView$lambda$37$lambda$36$lambda$35$lambda$34(Function2 function2, SettingsItem settingsItem, float f) {
        function2.invoke(settingsItem.getKey(), Float.valueOf(f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsFooter(final SettingsFooterState settingsFooterState, final SettingsEntryPalette settingsEntryPalette, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-132772300);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(settingsFooterState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-132772300, i2, -1, "com.bytedance.trae.home.solo.setting.ui.SettingsFooter (SettingsEntry.kt:469)");
            }
            if (settingsFooterState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SettingsFooter$lambda$39;
                            SettingsFooter$lambda$39 = SettingsEntryKt.SettingsFooter$lambda$39(SettingsFooterState.this, settingsEntryPalette, i, (Composer) obj, ((Integer) obj2).intValue());
                            return SettingsFooter$lambda$39;
                        }
                    });
                    return;
                }
                return;
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), startRestartGroup, 6);
            int i3 = i2 & 112;
            FooterText(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_model_name(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), settingsEntryPalette, null, startRestartGroup, i3, 4);
            float f = 8;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), startRestartGroup, 6);
            FooterText(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_model_filing(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), settingsEntryPalette, null, startRestartGroup, i3, 4);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), startRestartGroup, 6);
            FooterText(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_icp_filing(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), settingsEntryPalette, null, startRestartGroup, i3, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsFooter$lambda$40;
                    SettingsFooter$lambda$40 = SettingsEntryKt.SettingsFooter$lambda$40(SettingsFooterState.this, settingsEntryPalette, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsFooter$lambda$40;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void FooterText(final String str, final SettingsEntryPalette settingsEntryPalette, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2099976551);
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
            i3 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
                if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                    Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2099976551, i3, -1, "com.bytedance.trae.home.solo.setting.ui.FooterText (SettingsEntry.kt:493)");
                    }
                    Modifier modifier5 = modifier4;
                    TextKt.Text--4IGK_g(str, SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), settingsEntryPalette.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionBase(), startRestartGroup, i3 & 14, 3120, 54776);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit FooterText$lambda$41;
                            FooterText$lambda$41 = SettingsEntryKt.FooterText$lambda$41(str, settingsEntryPalette, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return FooterText$lambda$41;
                        }
                    });
                    return;
                }
                return;
            }
            modifier2 = modifier;
            if ((i3 & 147) == 146) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifier52 = modifier4;
            TextKt.Text--4IGK_g(str, SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), settingsEntryPalette.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionBase(), startRestartGroup, i3 & 14, 3120, 54776);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier52;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier modifier522 = modifier4;
        TextKt.Text--4IGK_g(str, SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), settingsEntryPalette.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable).getCaptionBase(), startRestartGroup, i3 & 14, 3120, 54776);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier522;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final void SettingsRow(final SettingsItem settingsItem, final SettingsEntryPalette settingsEntryPalette, final String str, final Function0<Unit> function0, final KmpClickHandler kmpClickHandler, final Function1<? super Float, Unit> function1, Composer composer, final int i) {
        int i2;
        Modifier modifier;
        int i3;
        int i4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(369941886);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(settingsItem) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? startRestartGroup.changed(kmpClickHandler) : startRestartGroup.changedInstance(kmpClickHandler) ? 16384 : FConstants.DOWNLOAD_BUFFER_SIZE;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        int i5 = i2;
        if ((74899 & i5) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(369941886, i5, -1, "com.bytedance.trae.home.solo.setting.ui.SettingsRow (SettingsEntry.kt:513)");
            }
            TraeTypography typography = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
            Modifier modifier2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), SettingsItemHeight);
            startRestartGroup.startReplaceGroup(1428042622);
            boolean z = (458752 & i5) == 131072;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit SettingsRow$lambda$43$lambda$42;
                        SettingsRow$lambda$43$lambda$42 = SettingsEntryKt.SettingsRow$lambda$43$lambda$42(function1, (LayoutCoordinates) obj);
                        return SettingsRow$lambda$43$lambda$42;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) rememberedValue);
            if (settingsItem.getClickable()) {
                modifier = SettingsScaffoldKt.noRippleClickable(Modifier.Companion, kmpClickHandler, function0);
            } else {
                modifier = Modifier.Companion;
            }
            Modifier then = onGloballyPositioned.then(modifier);
            float f = 16;
            Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(then, Dp.constructor-impl(f), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
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
            Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-458697668);
            int i6 = i5 & 112;
            SettingsItemIcon(iconResource(settingsItem.getKey()), settingsEntryPalette, startRestartGroup, i6);
            float f2 = 8;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), startRestartGroup, 6);
            boolean z2 = true;
            TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(titleResource(settingsItem.getKey()), new Object[0], startRestartGroup, 0), RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null), settingsEntryPalette.m2539getPrimaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, typography.getBodyBase(), startRestartGroup, 0, 0, 65528);
            startRestartGroup.startReplaceGroup(-2092996242);
            if (settingsItem.getKey() == SettingsItemKey.Subscribe) {
                UpgradeButton(settingsEntryPalette, startRestartGroup, (i5 >> 3) & 14);
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-2092992089);
                if (settingsItem.getKey() == SettingsItemKey.Usage) {
                    UsageTrailing(settingsEntryPalette, startRestartGroup, (i5 >> 3) & 14);
                    i4 = 4;
                    i3 = 6;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), startRestartGroup, 6);
                } else {
                    i3 = 6;
                    i4 = 4;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-2092987148);
                String str2 = str;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    z2 = false;
                }
                if (!z2) {
                    UnreadBadge(str, settingsEntryPalette, startRestartGroup, i6 | ((i5 >> 6) & 14));
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), startRestartGroup, i3);
                }
                startRestartGroup.endReplaceGroup();
                String trailingText = trailingText(settingsItem, settingsItem.getKey(), startRestartGroup, i5 & 14);
                startRestartGroup.startReplaceGroup(-2092979460);
                if (trailingText == null) {
                    composer2 = startRestartGroup;
                } else {
                    TextKt.Text--4IGK_g(trailingText, (Modifier) null, settingsEntryPalette.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, typography.getBodyXs(), startRestartGroup, 0, 3120, 55290);
                    composer2 = startRestartGroup;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(i4)), composer2, i3);
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(-2092969729);
                if (!settingsItem.getDestructive() && settingsItem.getShowTrailingIcon()) {
                    ImageKt.Image(ImageResources_androidKt.painterResource(trailingIconResource(settingsItem.getKey()), composer2, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, settingsEntryPalette.m2537getIconTertiary0d7_KjU(), 0, 2, (Object) null), composer2, 432, 56);
                }
                composer2.endReplaceGroup();
                composer2.endReplaceGroup();
            }
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsRow$lambda$46;
                    SettingsRow$lambda$46 = SettingsEntryKt.SettingsRow$lambda$46(SettingsItem.this, settingsEntryPalette, str, function0, kmpClickHandler, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsRow$lambda$46;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsRow$lambda$43$lambda$42(Function1 function1, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        function1.invoke(Float.valueOf(Float.intBitsToFloat((int) (LayoutCoordinatesKt.positionInRoot(layoutCoordinates) & 4294967295L))));
        return Unit.INSTANCE;
    }

    private static final void SettingsItemIcon(final DrawableResource drawableResource, final SettingsEntryPalette settingsEntryPalette, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1153017164);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(drawableResource) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1153017164, i2, -1, "com.bytedance.trae.home.solo.setting.ui.SettingsItemIcon (SettingsEntry.kt:580)");
            }
            Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, SettingsItemIconSlotSize);
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
            ImageKt.Image(ImageResources_androidKt.painterResource(drawableResource, startRestartGroup, i2 & 14), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, SettingsItemIconSize), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, settingsEntryPalette.m2536getIconDefault0d7_KjU(), 0, 2, (Object) null), startRestartGroup, 25008, 40);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsItemIcon$lambda$48;
                    SettingsItemIcon$lambda$48 = SettingsEntryKt.SettingsItemIcon$lambda$48(drawableResource, settingsEntryPalette, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsItemIcon$lambda$48;
                }
            });
        }
    }

    private static final void UsageTrailing(final SettingsEntryPalette settingsEntryPalette, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(780215184);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(settingsEntryPalette) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(780215184, i2, -1, "com.bytedance.trae.home.solo.setting.ui.UsageTrailing (SettingsEntry.kt:596)");
            }
            TraeTypography typography = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            Updater.set-impl(composer3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(hashCode))) {
                composer3.updateRememberedValue(Integer.valueOf(hashCode));
                composer3.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_trae_setting_usage_price(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), (Modifier) null, settingsEntryPalette.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, typography.getBodyXs(), startRestartGroup, 0, 3072, 57338);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_trae_setting_bonus(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), (Modifier) null, settingsEntryPalette.m2541getTertiaryText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, typography.getBodyXs(), composer2, 0, 3072, 57338);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit UsageTrailing$lambda$50;
                    UsageTrailing$lambda$50 = SettingsEntryKt.UsageTrailing$lambda$50(SettingsEntryPalette.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UsageTrailing$lambda$50;
                }
            });
        }
    }

    private static final void UpgradeButton(final SettingsEntryPalette settingsEntryPalette, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1816518561);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(settingsEntryPalette) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1816518561, i2, -1, "com.bytedance.trae.home.solo.setting.ui.UpgradeButton (SettingsEntry.kt:616)");
            }
            TraeTypography typography = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
            float f = 12;
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(f))), settingsEntryPalette.m2544getUpgradeButtonBackground0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(f), 0.0f, 2, (Object) null);
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
            composer2 = startRestartGroup;
            TextKt.Text--4IGK_g(KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getCmp_trae_setting_upgrade(Res.string.INSTANCE), new Object[0], startRestartGroup, 0), (Modifier) null, settingsEntryPalette.m2545getUpgradeButtonText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, typography.getCaptionBase(), composer2, 0, 3072, 57338);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpgradeButton$lambda$52;
                    UpgradeButton$lambda$52 = SettingsEntryKt.UpgradeButton$lambda$52(SettingsEntryPalette.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UpgradeButton$lambda$52;
                }
            });
        }
    }

    private static final String trailingText(SettingsItem settingsItem, SettingsItemKey settingsItemKey, Composer composer, int i) {
        composer.startReplaceGroup(731139054);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(731139054, i, -1, "com.bytedance.trae.home.solo.setting.ui.trailingText (SettingsEntry.kt:636)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$1[settingsItemKey.ordinal()];
        if (i2 == 1) {
            composer.startReplaceGroup(-431169593);
            String trailingText = settingsItem.getTrailingText();
            r1 = trailingText != null ? themeDisplayName(trailingText, composer, 0) : null;
            composer.endReplaceGroup();
        } else if (i2 == 2) {
            composer.startReplaceGroup(-431101052);
            String trailingText2 = settingsItem.getTrailingText();
            r1 = trailingText2 != null ? languageDisplayName(trailingText2, composer, 0) : null;
            composer.endReplaceGroup();
        } else if (i2 == 3) {
            composer.startReplaceGroup(-431043423);
            String trailingText3 = settingsItem.getTrailingText();
            if (trailingText3 != null && (!StringsKt.isBlank(trailingText3))) {
                r1 = trailingText3;
            }
            if (r1 == null) {
                r1 = KmpStringResource_androidKt.kmpStringResource(String0_commonMainKt.getTrae_setting_debug_ppe_env_not_set(Res.string.INSTANCE), new Object[0], composer, 0);
            }
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-430896545);
            composer.endReplaceGroup();
            String trailingText4 = settingsItem.getTrailingText();
            if (trailingText4 != null && (!StringsKt.isBlank(trailingText4))) {
                r1 = trailingText4;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return r1;
    }

    private static final String themeDisplayName(String str, Composer composer, int i) {
        composer.startReplaceGroup(398732333);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(398732333, i, -1, "com.bytedance.trae.home.solo.setting.ui.themeDisplayName (SettingsEntry.kt:647)");
        }
        String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(titleResource(SettingsThemeMode.INSTANCE.fromValue(str)), new Object[0], composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return kmpStringResource;
    }

    private static final String languageDisplayName(String str, Composer composer, int i) {
        composer.startReplaceGroup(1803860352);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1803860352, i, -1, "com.bytedance.trae.home.solo.setting.ui.languageDisplayName (SettingsEntry.kt:652)");
        }
        String kmpStringResource = KmpStringResource_androidKt.kmpStringResource(languageDisplayResource(str), new Object[0], composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return kmpStringResource;
    }

    private static final StringResource languageDisplayResource(String str) {
        return Intrinsics.areEqual(str, LANGUAGE_ZH) ? String0_commonMainKt.getTrae_setting_lang_chinese(Res.string.INSTANCE) : Intrinsics.areEqual(str, LANGUAGE_JA) ? String0_commonMainKt.getTrae_setting_lang_japanese(Res.string.INSTANCE) : String0_commonMainKt.getTrae_setting_lang_english(Res.string.INSTANCE);
    }

    private static final void UnreadBadge(final String str, final SettingsEntryPalette settingsEntryPalette, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-452901904);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(settingsEntryPalette) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-452901904, i2, -1, "com.bytedance.trae.home.solo.setting.ui.UnreadBadge (SettingsEntry.kt:665)");
            }
            TraeTypography typography = TraeTheme.INSTANCE.getTypography(startRestartGroup, TraeTheme.$stable);
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), settingsEntryPalette.m2542getUnreadBadgeBackground0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(5), 0.0f, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-1990510117);
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda17
                    public final Object invoke(Object obj) {
                        Unit UnreadBadge$lambda$56$lambda$55;
                        UnreadBadge$lambda$56$lambda$55 = SettingsEntryKt.UnreadBadge$lambda$56$lambda$55(str, (SemanticsPropertyReceiver) obj);
                        return UnreadBadge$lambda$56$lambda$55;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
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
            composer2 = startRestartGroup;
            TextKt.Text--4IGK_g(str, (Modifier) null, settingsEntryPalette.m2543getUnreadBadgeText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, typography.getCaptionXsStrong(), composer2, i3, 0, 65530);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnreadBadge$lambda$58;
                    UnreadBadge$lambda$58 = SettingsEntryKt.UnreadBadge$lambda$58(str, settingsEntryPalette, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UnreadBadge$lambda$58;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnreadBadge$lambda$56$lambda$55(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "unread_" + str);
        return Unit.INSTANCE;
    }

    private static final DrawableResource iconResource(SettingsItemKey settingsItemKey) {
        switch (WhenMappings.$EnumSwitchMapping$1[settingsItemKey.ordinal()]) {
            case 1:
                return Drawable0_commonMainKt.getCmp_ic_setting_sun_day(Res.drawable.INSTANCE);
            case 2:
                return Drawable0_commonMainKt.getCmp_ic_setting_language(Res.drawable.INSTANCE);
            case 3:
                return Drawable0_commonMainKt.getCmp_ic_setting_debug(Res.drawable.INSTANCE);
            case 4:
                return Drawable0_commonMainKt.getCmp_ic_setting_subscription(Res.drawable.INSTANCE);
            case 5:
                return Drawable0_commonMainKt.getCmp_ic_setting_tokens(Res.drawable.INSTANCE);
            case 6:
                return Drawable0_commonMainKt.getCmp_ic_setting_user(Res.drawable.INSTANCE);
            case 7:
                return Drawable0_commonMainKt.getCmp_ic_setting_message(Res.drawable.INSTANCE);
            case 8:
                return Drawable0_commonMainKt.getCmp_ic_setting_points(Res.drawable.INSTANCE);
            case 9:
                return Drawable0_commonMainKt.getCmp_ic_setting_notification(Res.drawable.INSTANCE);
            case 10:
                return Drawable0_commonMainKt.getCmp_ic_setting_computer_screen(Res.drawable.INSTANCE);
            case 11:
                return Drawable0_commonMainKt.getCmp_ic_setting_connector_added(Res.drawable.INSTANCE);
            case 12:
                return Drawable0_commonMainKt.getCmp_ic_setting_privacy(Res.drawable.INSTANCE);
            case 13:
                return Drawable0_commonMainKt.getCmp_ic_setting_info_circle(Res.drawable.INSTANCE);
            case 14:
                return Drawable0_commonMainKt.getCmp_ic_setting_trae(Res.drawable.INSTANCE);
            case 15:
                return Drawable0_commonMainKt.getCmp_ic_setting_logout(Res.drawable.INSTANCE);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final DrawableResource trailingIconResource(SettingsItemKey settingsItemKey) {
        if (settingsItemKey == SettingsItemKey.Theme || settingsItemKey == SettingsItemKey.Language) {
            return Drawable0_commonMainKt.getCmp_ic_setting_selector_arrows(Res.drawable.INSTANCE);
        }
        return Drawable0_commonMainKt.getCmp_ic_setting_chevron_right(Res.drawable.INSTANCE);
    }

    private static final StringResource titleResource(SettingsItemKey settingsItemKey) {
        switch (WhenMappings.$EnumSwitchMapping$1[settingsItemKey.ordinal()]) {
            case 1:
                return String0_commonMainKt.getCmp_trae_setting_theme(Res.string.INSTANCE);
            case 2:
                return String0_commonMainKt.getTrae_setting_language(Res.string.INSTANCE);
            case 3:
                return String0_commonMainKt.getTrae_setting_debug(Res.string.INSTANCE);
            case 4:
                return String0_commonMainKt.getCmp_trae_setting_subscribe(Res.string.INSTANCE);
            case 5:
                return String0_commonMainKt.getCmp_trae_setting_usage(Res.string.INSTANCE);
            case 6:
                return String0_commonMainKt.getTrae_setting_account(Res.string.INSTANCE);
            case 7:
                return String0_commonMainKt.getTrae_setting_messages(Res.string.INSTANCE);
            case 8:
                return String0_commonMainKt.getCmp_trae_setting_points(Res.string.INSTANCE);
            case 9:
                return String0_commonMainKt.getTrae_setting_notification(Res.string.INSTANCE);
            case 10:
                return String0_commonMainKt.getTrae_setting_device_management(Res.string.INSTANCE);
            case 11:
                return String0_commonMainKt.getTrae_setting_connectors(Res.string.INSTANCE);
            case 12:
                return String0_commonMainKt.getTrae_setting_privacy_permission(Res.string.INSTANCE);
            case 13:
                return String0_commonMainKt.getTrae_setting_update(Res.string.INSTANCE);
            case 14:
                return String0_commonMainKt.getTrae_setting_about(Res.string.INSTANCE);
            case 15:
                return String0_commonMainKt.getTrae_setting_logout(Res.string.INSTANCE);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource titleResource(SettingsThemeMode settingsThemeMode) {
        int i = WhenMappings.$EnumSwitchMapping$2[settingsThemeMode.ordinal()];
        if (i == 1) {
            return String0_commonMainKt.getCmp_trae_setting_theme_light(Res.string.INSTANCE);
        }
        if (i == 2) {
            return String0_commonMainKt.getCmp_trae_setting_theme_dark(Res.string.INSTANCE);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return String0_commonMainKt.getCmp_trae_setting_theme_system(Res.string.INSTANCE);
    }

    private static final StringResource titleResource(SettingsEnterpriseBadge settingsEnterpriseBadge) {
        int i = WhenMappings.$EnumSwitchMapping$3[settingsEnterpriseBadge.ordinal()];
        if (i == 1) {
            return String0_commonMainKt.getTrae_setting_saas_team_group_badge(Res.string.INSTANCE);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return String0_commonMainKt.getTrae_setting_saas_team_flagship_badge(Res.string.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<SettingsThemeMode> popupOptions(SettingsThemeMode settingsThemeMode) {
        int i = WhenMappings.$EnumSwitchMapping$2[settingsThemeMode.ordinal()];
        if (i == 1) {
            return CollectionsKt.listOf(new SettingsThemeMode[]{SettingsThemeMode.Dark, SettingsThemeMode.System});
        }
        if (i == 2) {
            return CollectionsKt.listOf(new SettingsThemeMode[]{SettingsThemeMode.Light, SettingsThemeMode.System});
        }
        if (i == 3) {
            return CollectionsKt.listOf(new SettingsThemeMode[]{SettingsThemeMode.Light, SettingsThemeMode.Dark});
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SettingsEntryContent$lambda$16$lambda$15(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$lambda$16$lambda$15$$inlined$onDispose$1
            public void dispose() {
                KmpHostDialogs.INSTANCE.dismiss();
            }
        };
    }

    static {
        float f = 20;
        SettingsPopupCornerRadius = Dp.constructor-impl(f);
        float f2 = 24;
        SettingsPopupEndMargin = Dp.constructor-impl(f2);
        float f3 = Dp.constructor-impl(56);
        SettingsItemHeight = f3;
        SettingsPopupAnchorYOffset = f3;
        SettingsItemIconSlotSize = Dp.constructor-impl(f2);
        SettingsItemIconSize = Dp.constructor-impl(f);
    }
}
