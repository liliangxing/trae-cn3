package com.bytedance.trae.home.solo.setting.fragment;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.CmpAccountSettingsBottomSheet;
import com.bytedance.trae.home.solo.setting.CmpSettingsNavigator;
import com.bytedance.trae.home.solo.setting.p010ui.SettingsContentScreensKt;
import com.bytedance.trae.kmp.cmp.TraeCmpSheetContentFragment;
import com.bytedance.trae.kmp.network.AndroidKmpHttpClientFactory;
import com.bytedance.trae.kmp.network.KmpHttpClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: CmpDeviceManagementFragment.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\b\u001a\u00020\tH\u0015¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;", "Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;", "<init>", "()V", "titleResId", "", "getTitleResId", "()I", "RenderCmpContent", "", "(Landroidx/compose/runtime/Composer;I)V", "refreshDeviceCache", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CmpDeviceManagementFragment extends TraeCmpSheetContentFragment {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int titleResId = C0820R.string.trae_setting_device_management;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenderCmpContent$lambda$3(CmpDeviceManagementFragment cmpDeviceManagementFragment, int i, Composer composer, int i2) {
        cmpDeviceManagementFragment.RenderCmpContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    protected int getTitleResId() {
        return this.titleResId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void RenderCmpContent(Composer composer, final int i) {
        int i2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(1673377835);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1673377835, i2, -1, "com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment.RenderCmpContent (CmpDeviceManagementFragment.kt:16)");
            }
            KmpHttpClient kmpHttpClient = AndroidKmpHttpClientFactory.INSTANCE.get();
            startRestartGroup.startReplaceGroup(-574149969);
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
                obj = rememberedValue;
            }
            Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit RenderCmpContent$lambda$1$lambda$0;
                    RenderCmpContent$lambda$1$lambda$0 = CmpDeviceManagementFragment.RenderCmpContent$lambda$1$lambda$0(CmpDeviceManagementFragment.this);
                    return RenderCmpContent$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(function0);
            obj = function0;
            Function0 function02 = (Function0) obj;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-574143712);
            boolean z2 = i3 == 4;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (KFunction) new CmpDeviceManagementFragment$RenderCmpContent$2$1(this);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SettingsContentScreensKt.DeviceManagementScreen(kmpHttpClient, null, function02, (KFunction) rememberedValue2, null, null, startRestartGroup, 0, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2, Object obj3) {
                    Unit RenderCmpContent$lambda$3;
                    RenderCmpContent$lambda$3 = CmpDeviceManagementFragment.RenderCmpContent$lambda$3(CmpDeviceManagementFragment.this, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return RenderCmpContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenderCmpContent$lambda$1$lambda$0(CmpDeviceManagementFragment cmpDeviceManagementFragment) {
        CmpSettingsNavigator navigator;
        CmpAccountSettingsBottomSheet parentFragment = cmpDeviceManagementFragment.getParentFragment();
        CmpAccountSettingsBottomSheet cmpAccountSettingsBottomSheet = parentFragment instanceof CmpAccountSettingsBottomSheet ? parentFragment : null;
        if (cmpAccountSettingsBottomSheet != null && (navigator = cmpAccountSettingsBottomSheet.getNavigator()) != null) {
            navigator.openConnectComputerGuide();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshDeviceCache() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new CmpDeviceManagementFragment$refreshDeviceCache$1(null), 3, (Object) null);
    }

    /* compiled from: CmpDeviceManagementFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CmpDeviceManagementFragment newInstance() {
            return new CmpDeviceManagementFragment();
        }
    }
}
