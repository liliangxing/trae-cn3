package com.bytedance.trae.home.solo.setting.fragment;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.p010ui.SettingsContentScreensKt;
import com.bytedance.trae.kmp.cmp.TraeCmpSheetContentFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CmpConnectComputerGuideFragment.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\b\u001a\u00020\tH\u0015¢\u0006\u0002\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;", "Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;", "<init>", "()V", "titleResId", "", "getTitleResId", "()I", "RenderCmpContent", "", "(Landroidx/compose/runtime/Composer;I)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CmpConnectComputerGuideFragment extends TraeCmpSheetContentFragment {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int titleResId = C0820R.string.trae_setting_add_device_title;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenderCmpContent$lambda$0(CmpConnectComputerGuideFragment cmpConnectComputerGuideFragment, int i, Composer composer, int i2) {
        cmpConnectComputerGuideFragment.RenderCmpContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    protected int getTitleResId() {
        return this.titleResId;
    }

    protected void RenderCmpContent(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1565142123);
        if ((i & 1) != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1565142123, i, -1, "com.bytedance.trae.home.solo.setting.fragment.CmpConnectComputerGuideFragment.RenderCmpContent (CmpConnectComputerGuideFragment.kt:11)");
            }
            SettingsContentScreensKt.ConnectComputerGuideScreen(null, null, startRestartGroup, 0, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpConnectComputerGuideFragment$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit RenderCmpContent$lambda$0;
                    RenderCmpContent$lambda$0 = CmpConnectComputerGuideFragment.RenderCmpContent$lambda$0(CmpConnectComputerGuideFragment.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RenderCmpContent$lambda$0;
                }
            });
        }
    }

    /* compiled from: CmpConnectComputerGuideFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CmpConnectComputerGuideFragment newInstance() {
            return new CmpConnectComputerGuideFragment();
        }
    }
}
