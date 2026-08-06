package com.bytedance.trae.home.solo.setting.fragment;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bytedance.trae.conversation.ShareWebViewActivity;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.AboutWebUrlOpener;
import com.bytedance.trae.home.solo.setting.p010ui.SettingsAboutKt;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutDestination;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState;
import com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutStateFactory;
import com.bytedance.trae.kmp.cmp.TraeCmpSheetContentFragment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KFunction;

/* compiled from: CmpSettingsAboutFragment.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\b\u001a\u00020\tH\u0015¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;", "Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;", "<init>", "()V", "titleResId", "", "getTitleResId", "()I", "RenderCmpContent", "", "(Landroidx/compose/runtime/Composer;I)V", "handleItemClick", "item", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;", "title", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CmpSettingsAboutFragment extends TraeCmpSheetContentFragment {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int titleResId = C0820R.string.trae_setting_about;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenderCmpContent$lambda$1(CmpSettingsAboutFragment cmpSettingsAboutFragment, int i, Composer composer, int i2) {
        cmpSettingsAboutFragment.RenderCmpContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    protected int getTitleResId() {
        return this.titleResId;
    }

    protected void RenderCmpContent(Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1458829653);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1458829653, i2, -1, "com.bytedance.trae.home.solo.setting.fragment.CmpSettingsAboutFragment.RenderCmpContent (CmpSettingsAboutFragment.kt:16)");
            }
            SettingsAboutState build$default = SettingsAboutStateFactory.build$default(SettingsAboutStateFactory.INSTANCE, null, 1, null);
            startRestartGroup.startReplaceGroup(-1416797264);
            boolean z = (i2 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = (KFunction) new CmpSettingsAboutFragment$RenderCmpContent$1$1(this);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            SettingsAboutKt.SettingsAboutContent(build$default, null, (KFunction) rememberedValue, startRestartGroup, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.fragment.CmpSettingsAboutFragment$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit RenderCmpContent$lambda$1;
                    RenderCmpContent$lambda$1 = CmpSettingsAboutFragment.RenderCmpContent$lambda$1(CmpSettingsAboutFragment.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RenderCmpContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleItemClick(SettingsAboutItem item, String title) {
        Object obj;
        SettingsAboutDestination destination = item.getDestination();
        if (destination instanceof SettingsAboutDestination.WebUrl) {
            Context context = getContext();
            if (context == null) {
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                CmpSettingsAboutFragment cmpSettingsAboutFragment = this;
                AboutWebUrlOpener.INSTANCE.open(context, ((SettingsAboutDestination.WebUrl) destination).getUrl());
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Result.box-impl(obj);
            return;
        }
        if (!(destination instanceof SettingsAboutDestination.ExternalBrowser)) {
            throw new NoWhenBranchMatchedException();
        }
        Context context2 = getContext();
        if (context2 == null) {
            return;
        }
        ShareWebViewActivity.INSTANCE.startWithBrowser(context2, ((SettingsAboutDestination.ExternalBrowser) destination).getUrl(), (r13 & 4) != 0 ? null : title, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
    }

    /* compiled from: CmpSettingsAboutFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CmpSettingsAboutFragment newInstance() {
            return new CmpSettingsAboutFragment();
        }
    }
}
