package com.bytedance.trae.home.solo.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.git.GitHubConnectorManager;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.GitHubOAuthActivity;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ConnectorsFragment.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "connectorManager", "Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;", "switchGithub", "Landroidx/appcompat/widget/SwitchCompat;", "cardGithub", "Landroid/widget/LinearLayout;", "cardManageGithub", "isOperating", "", "connectLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "modifyLauncher", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshGitHubStatus", "onGitHubCardTapped", "connect", "disconnect", "onManageGitHubTapped", "setInteractionEnabled", "enabled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConnectorsFragment extends Fragment {
    private LinearLayout cardGithub;
    private LinearLayout cardManageGithub;
    private final ActivityResultLauncher<Intent> connectLauncher;
    private GitHubConnectorManager connectorManager;
    private boolean isOperating;
    private final ActivityResultLauncher<Intent> modifyLauncher;
    private SwitchCompat switchGithub;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ConnectorsFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.home.solo.setting.ConnectorsFragment$$ExternalSyntheticLambda3
            public final void onActivityResult(Object obj) {
                ConnectorsFragment.connectLauncher$lambda$0(ConnectorsFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.connectLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.home.solo.setting.ConnectorsFragment$$ExternalSyntheticLambda4
            public final void onActivityResult(Object obj) {
                ConnectorsFragment.this.refreshGitHubStatus();
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.modifyLauncher = registerForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectLauncher$lambda$0(ConnectorsFragment connectorsFragment, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            connectorsFragment.refreshGitHubStatus();
        }
        connectorsFragment.setInteractionEnabled(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_connectors, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        AccountInfo accountInfo;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.ConnectorsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectorsFragment.onViewCreated$lambda$2(ConnectorsFragment.this, view2);
            }
        });
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        LinearLayout linearLayout = null;
        if (Intrinsics.areEqual((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getLoginPlatform(), ThirdPartyTokenRepository.TYPE_BYTECLOUD)) {
            ((LinearLayout) view.findViewById(C0820R.id.card_github)).setVisibility(8);
            View findViewById = view.findViewById(C0820R.id.divider_github);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            ((LinearLayout) view.findViewById(C0820R.id.card_manage_github)).setVisibility(8);
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.connectorManager = new GitHubConnectorManager(requireContext, null, 2, null);
        SwitchCompat findViewById2 = view.findViewById(C0820R.id.switch_github);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.switchGithub = findViewById2;
        View findViewById3 = view.findViewById(C0820R.id.card_github);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.cardGithub = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(C0820R.id.card_manage_github);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.cardManageGithub = (LinearLayout) findViewById4;
        SwitchCompat switchCompat = this.switchGithub;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchGithub");
            switchCompat = null;
        }
        switchCompat.setVisibility(4);
        LinearLayout linearLayout2 = this.cardManageGithub;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardManageGithub");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = this.cardGithub;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardGithub");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.ConnectorsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectorsFragment.this.onGitHubCardTapped();
            }
        });
        LinearLayout linearLayout4 = this.cardManageGithub;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardManageGithub");
        } else {
            linearLayout = linearLayout4;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.ConnectorsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectorsFragment.this.onManageGitHubTapped();
            }
        });
        refreshGitHubStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ConnectorsFragment connectorsFragment, View view) {
        connectorsFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshGitHubStatus() {
        if (this.isOperating) {
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConnectorsFragment$refreshGitHubStatus$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGitHubCardTapped() {
        if (this.isOperating) {
            return;
        }
        SwitchCompat switchCompat = this.switchGithub;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchGithub");
            switchCompat = null;
        }
        if (!switchCompat.isChecked()) {
            connect();
        } else {
            disconnect();
        }
    }

    private final void connect() {
        setInteractionEnabled(false);
        ActivityResultLauncher<Intent> activityResultLauncher = this.connectLauncher;
        GitHubOAuthActivity.Companion companion = GitHubOAuthActivity.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        activityResultLauncher.launch(companion.newConnectIntent(requireContext));
    }

    private final void disconnect() {
        this.isOperating = true;
        setInteractionEnabled(false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConnectorsFragment$disconnect$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onManageGitHubTapped() {
        ActivityResultLauncher<Intent> activityResultLauncher = this.modifyLauncher;
        GitHubOAuthActivity.Companion companion = GitHubOAuthActivity.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        activityResultLauncher.launch(companion.newModifyIntent(requireContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInteractionEnabled(boolean enabled) {
        LinearLayout linearLayout = this.cardGithub;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardGithub");
            linearLayout = null;
        }
        linearLayout.setClickable(enabled);
        LinearLayout linearLayout3 = this.cardGithub;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardGithub");
            linearLayout3 = null;
        }
        linearLayout3.setFocusable(enabled);
        LinearLayout linearLayout4 = this.cardManageGithub;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardManageGithub");
            linearLayout4 = null;
        }
        linearLayout4.setClickable(enabled);
        LinearLayout linearLayout5 = this.cardManageGithub;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardManageGithub");
        } else {
            linearLayout2 = linearLayout5;
        }
        linearLayout2.setFocusable(enabled);
    }

    /* compiled from: ConnectorsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectorsFragment newInstance() {
            return new ConnectorsFragment();
        }
    }
}
