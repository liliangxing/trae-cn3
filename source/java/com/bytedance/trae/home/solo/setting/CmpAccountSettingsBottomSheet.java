package com.bytedance.trae.home.solo.setting;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment;
import com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CmpAccountSettingsBottomSheet.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;", "Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;", "<init>", "()V", "fragmentContainerId", "", "getFragmentContainerId", "()I", "navigator", "Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;", "getNavigator", "()Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;", "navigator$delegate", "Lkotlin/Lazy;", "createRootFragment", "Landroidx/fragment/app/Fragment;", "onBackPressed", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CmpAccountSettingsBottomSheet extends TraeCmpBottomSheetFragment {
    public static final String TAG = "CmpAccountSettingsBottomSheet";
    private final int fragmentContainerId = C0820R.id.settings_fragment_container;

    /* renamed from: navigator$delegate, reason: from kotlin metadata */
    private final Lazy navigator = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.home.solo.setting.CmpAccountSettingsBottomSheet$$ExternalSyntheticLambda0
        public final Object invoke() {
            CmpSettingsNavigator navigator_delegate$lambda$0;
            navigator_delegate$lambda$0 = CmpAccountSettingsBottomSheet.navigator_delegate$lambda$0(CmpAccountSettingsBottomSheet.this);
            return navigator_delegate$lambda$0;
        }
    });

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    protected int getFragmentContainerId() {
        return this.fragmentContainerId;
    }

    public final CmpSettingsNavigator getNavigator() {
        return (CmpSettingsNavigator) this.navigator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CmpSettingsNavigator navigator_delegate$lambda$0(CmpAccountSettingsBottomSheet cmpAccountSettingsBottomSheet) {
        FragmentManager childFragmentManager = cmpAccountSettingsBottomSheet.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        return new CmpSettingsNavigator(childFragmentManager);
    }

    protected Fragment createRootFragment() {
        return CmpSettingsEntryFragment.INSTANCE.newInstance();
    }

    protected boolean onBackPressed() {
        return getNavigator().pop();
    }

    /* compiled from: CmpAccountSettingsBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CmpAccountSettingsBottomSheet newInstance() {
            return new CmpAccountSettingsBottomSheet();
        }
    }
}
