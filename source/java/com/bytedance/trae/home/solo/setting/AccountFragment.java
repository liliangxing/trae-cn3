package com.bytedance.trae.home.solo.setting;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.IDouyinLoginService;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.LocaleManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: AccountFragment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010,\u001a\u0004\u0018\u00010#2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u0002042\u0006\u00105\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00106\u001a\u000204H\u0016J\u0012\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u00020\fH\u0002J\u0010\u00109\u001a\u0002042\u0006\u00108\u001a\u00020\fH\u0002J\b\u0010:\u001a\u000204H\u0002J\b\u0010;\u001a\u000204H\u0002J\u0010\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\fH\u0002J\b\u0010>\u001a\u000204H\u0002J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u000204H\u0002J\b\u0010D\u001a\u000204H\u0002J\b\u0010E\u001a\u000204H\u0002J\u0010\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u000204H\u0002J\b\u0010J\u001a\u000204H\u0002J\b\u0010K\u001a\u000204H\u0002J\b\u0010L\u001a\u000204H\u0002J\b\u0010M\u001a\u000204H\u0002J\u001c\u0010N\u001a\u0002042\b\u0010O\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010P\u001a\u00020\fH\u0002J\b\u0010Q\u001a\u000204H\u0002J\b\u0010R\u001a\u000204H\u0016J\b\u0010S\u001a\u000204H\u0002J\b\u0010T\u001a\u000204H\u0002J\b\u0010U\u001a\u000204H\u0002J\u0010\u0010V\u001a\u0002042\u0006\u0010=\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AccountFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "switchPrivacyMode", "Landroidx/appcompat/widget/SwitchCompat;", "tvPrivacyDesc", "Landroid/widget/TextView;", "tvPrivacyDetails", "isSwitching", "", "hasResumedOnce", "loginService", "Lcom/bytedance/trae/login/api/ILoginService;", "getLoginService", "()Lcom/bytedance/trae/login/api/ILoginService;", "loginService$delegate", "Lkotlin/Lazy;", "douyinLoginService", "Lcom/bytedance/trae/login/api/IDouyinLoginService;", "getDouyinLoginService", "()Lcom/bytedance/trae/login/api/IDouyinLoginService;", "douyinLoginService$delegate", "isEnterpriseLogin", "()Z", "isBytecloudLogin", "hideLoginMethods", "getHideLoginMethods", "phoneBindLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "cardLoginMethods", "Landroid/view/View;", "tvPhoneSubtitle", "btnPhoneAction", "dividerPhone", "tvDouyinSubtitle", "btnDouyinAction", "cardDeleteAccount", "unbindDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "refreshAccountControlsForCurrentAccount", "loadProfileIfMissing", "refreshLoginMethodsForCurrentAccount", "refreshPrivacySectionForCurrentAccount", "setupPrivacyModeSwitch", "applyEnterprisePrivacyMode", "open", "updatePrivacyModeCopy", "buildEnterprisePrivacyDesc", "Landroid/text/SpannableString;", "getPrivacyModeDetailsUrl", "", "openPrivacyModeDetails", "restoreEditablePrivacyModeInteraction", "applyEditablePrivacyMode", "updateLoginMethods", IAppAuthService.Scope.PROFILE, "Lcom/bytedance/trae/home/solo/setting/UserProfileState;", "setupPhoneBinding", "setupDouyinBinding", "setupDeleteAccount", "updateDeleteAccountEntry", "refreshDouyinStatus", "applyBindingButtonStyle", "button", "primary", "showUnbindDialog", "onDestroyView", "performDouyinUnbind", "performDouyinBind", "fetchPrivacyModeStatus", "togglePrivacyMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountFragment extends Fragment {
    private static final float DIALOG_DIM_AMOUNT = 0.5f;
    private static final float DIALOG_WIDTH_RATIO = 0.8f;
    private static final int DOUYIN_BIND_CONFLICT_ERROR = 1030;
    private static final String ENTERPRISE_DATA_PROTECTION_URL = "https://docs.trae.cn/enterprise_general-settings-for-trae-enterprise#d6637bb7";
    private static final String PHONE_BIND_ACTIVITY_CLASS = "com.bytedance.trae.login.activity.PhoneBindActivity";
    private static final String PHONE_BIND_EXTRA_MODE = "extra_mode";
    private static final String PHONE_BIND_EXTRA_PHONE_MASKED = "extra_phone_masked";
    private static final String PHONE_BIND_EXTRA_SOURCE = "extra_source";
    private static final String PHONE_BIND_MODE_BIND = "bind";
    private static final String PHONE_BIND_MODE_CHANGE = "change";
    private static final String PHONE_BIND_SOURCE_SETTINGS = "settings";
    private TextView btnDouyinAction;
    private TextView btnPhoneAction;
    private View cardDeleteAccount;
    private View cardLoginMethods;
    private View dividerPhone;
    private boolean hasResumedOnce;
    private boolean isSwitching;
    private final ActivityResultLauncher<Intent> phoneBindLauncher;
    private SwitchCompat switchPrivacyMode;
    private TextView tvDouyinSubtitle;
    private TextView tvPhoneSubtitle;
    private TextView tvPrivacyDesc;
    private TextView tvPrivacyDetails;
    private Dialog unbindDialog;
    private SettingsViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: loginService$delegate, reason: from kotlin metadata */
    private final Lazy loginService = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda9
        public final Object invoke() {
            ILoginService loginService_delegate$lambda$0;
            loginService_delegate$lambda$0 = AccountFragment.loginService_delegate$lambda$0();
            return loginService_delegate$lambda$0;
        }
    });

    /* renamed from: douyinLoginService$delegate, reason: from kotlin metadata */
    private final Lazy douyinLoginService = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda10
        public final Object invoke() {
            IDouyinLoginService douyinLoginService_delegate$lambda$1;
            douyinLoginService_delegate$lambda$1 = AccountFragment.douyinLoginService_delegate$lambda$1();
            return douyinLoginService_delegate$lambda$1;
        }
    });

    public AccountFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda12
            public final void onActivityResult(Object obj) {
                AccountFragment.phoneBindLauncher$lambda$2(AccountFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.phoneBindLauncher = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginService getLoginService() {
        return (ILoginService) this.loginService.getValue();
    }

    private final IDouyinLoginService getDouyinLoginService() {
        return (IDouyinLoginService) this.douyinLoginService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEnterpriseLogin() {
        AccountInfo accountInfo;
        ILoginService loginService = getLoginService();
        return ((loginService == null || (accountInfo = loginService.getAccountInfo()) == null) ? null : accountInfo.getAccountType()) == AccountType.TOB;
    }

    private final boolean isBytecloudLogin() {
        AccountInfo accountInfo;
        ILoginService loginService = getLoginService();
        return Intrinsics.areEqual((loginService == null || (accountInfo = loginService.getAccountInfo()) == null) ? null : accountInfo.getLoginPlatform(), ThirdPartyTokenRepository.TYPE_BYTECLOUD);
    }

    private final boolean getHideLoginMethods() {
        return AppHost.INSTANCE.isOversea() || isEnterpriseLogin() || isBytecloudLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void phoneBindLauncher$lambda$2(AccountFragment accountFragment, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            SettingsViewModel settingsViewModel = null;
            String stringExtra = data != null ? data.getStringExtra("extra_new_phone") : null;
            String str = stringExtra;
            if (!(str == null || str.length() == 0)) {
                SettingsViewModel settingsViewModel2 = accountFragment.viewModel;
                if (settingsViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel2 = null;
                }
                settingsViewModel2.updatePhoneNumber(stringExtra);
            }
            SettingsViewModel settingsViewModel3 = accountFragment.viewModel;
            if (settingsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                settingsViewModel = settingsViewModel3;
            }
            settingsViewModel.loadUserInfo();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_account, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = new ViewModelProvider(requireActivity).get(SettingsViewModel.class);
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.onViewCreated$lambda$3(AccountFragment.this, view2);
            }
        });
        this.cardLoginMethods = view.findViewById(C0820R.id.card_login_methods);
        this.tvPhoneSubtitle = (TextView) view.findViewById(C0820R.id.tv_phone_subtitle);
        this.btnPhoneAction = (TextView) view.findViewById(C0820R.id.btn_phone_action);
        this.dividerPhone = view.findViewById(C0820R.id.divider_phone);
        this.tvDouyinSubtitle = (TextView) view.findViewById(C0820R.id.tv_douyin_subtitle);
        this.btnDouyinAction = (TextView) view.findViewById(C0820R.id.btn_douyin_action);
        this.cardDeleteAccount = view.findViewById(C0820R.id.card_delete_account);
        SwitchCompat findViewById = view.findViewById(C0820R.id.switch_privacy_mode);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        SwitchCompat switchCompat = findViewById;
        this.switchPrivacyMode = switchCompat;
        TextView textView = null;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat = null;
        }
        switchCompat.setVisibility(4);
        View findViewById2 = view.findViewById(C0820R.id.tv_privacy_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.tvPrivacyDesc = (TextView) findViewById2;
        View findViewById3 = view.findViewById(C0820R.id.tv_privacy_details);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.tvPrivacyDetails = (TextView) findViewById3;
        updatePrivacyModeCopy();
        SettingsViewModel settingsViewModel = this.viewModel;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        settingsViewModel.getUserProfile().observe(getViewLifecycleOwner(), new AccountFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$5;
                onViewCreated$lambda$5 = AccountFragment.onViewCreated$lambda$5(AccountFragment.this, (UserProfileState) obj);
                return onViewCreated$lambda$5;
            }
        }));
        setupPrivacyModeSwitch();
        setupPhoneBinding();
        setupDouyinBinding();
        setupDeleteAccount();
        refreshAccountControlsForCurrentAccount(false);
        SettingsViewModel settingsViewModel2 = this.viewModel;
        if (settingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel2 = null;
        }
        settingsViewModel2.loadUserInfo();
        TextView textView2 = this.tvPrivacyDetails;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDetails");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.this.openPrivacyModeDetails();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(AccountFragment accountFragment, View view) {
        accountFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(AccountFragment accountFragment, UserProfileState userProfileState) {
        if (userProfileState != null) {
            accountFragment.updateLoginMethods(userProfileState);
            accountFragment.updateDeleteAccountEntry();
            accountFragment.updatePrivacyModeCopy();
            if (accountFragment.isEnterpriseLogin()) {
                Boolean saasPrivacyMode = userProfileState.getSaasPrivacyMode();
                accountFragment.applyEnterprisePrivacyMode(saasPrivacyMode != null ? saasPrivacyMode.booleanValue() : true);
            }
        }
        return Unit.INSTANCE;
    }

    public void onResume() {
        super.onResume();
        if (!this.hasResumedOnce) {
            this.hasResumedOnce = true;
        } else {
            if (this.switchPrivacyMode == null || this.tvPrivacyDesc == null || this.tvPrivacyDetails == null) {
                return;
            }
            refreshAccountControlsForCurrentAccount$default(this, false, 1, null);
        }
    }

    static /* synthetic */ void refreshAccountControlsForCurrentAccount$default(AccountFragment accountFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        accountFragment.refreshAccountControlsForCurrentAccount(z);
    }

    private final void refreshAccountControlsForCurrentAccount(boolean loadProfileIfMissing) {
        refreshLoginMethodsForCurrentAccount(loadProfileIfMissing);
        updateDeleteAccountEntry();
        refreshPrivacySectionForCurrentAccount();
    }

    private final void refreshLoginMethodsForCurrentAccount(boolean loadProfileIfMissing) {
        if (getHideLoginMethods()) {
            View view = this.cardLoginMethods;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        SettingsViewModel settingsViewModel = this.viewModel;
        SettingsViewModel settingsViewModel2 = null;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        UserProfileState userProfileState = (UserProfileState) settingsViewModel.getUserProfile().getValue();
        if (userProfileState == null) {
            View view2 = this.cardLoginMethods;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            if (loadProfileIfMissing) {
                SettingsViewModel settingsViewModel3 = this.viewModel;
                if (settingsViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    settingsViewModel2 = settingsViewModel3;
                }
                settingsViewModel2.loadUserInfo();
                return;
            }
            return;
        }
        updateLoginMethods(userProfileState);
    }

    private final void refreshPrivacySectionForCurrentAccount() {
        AccountInfo accountInfo;
        Boolean saasPrivacyMode;
        updatePrivacyModeCopy();
        if (isEnterpriseLogin()) {
            ILoginService loginService = getLoginService();
            applyEnterprisePrivacyMode((loginService == null || (accountInfo = loginService.getAccountInfo()) == null || (saasPrivacyMode = accountInfo.getSaasPrivacyMode()) == null) ? true : saasPrivacyMode.booleanValue());
        } else {
            restoreEditablePrivacyModeInteraction();
            fetchPrivacyModeStatus();
        }
    }

    private final void setupPrivacyModeSwitch() {
        SwitchCompat switchCompat = this.switchPrivacyMode;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat = null;
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AccountFragment.setupPrivacyModeSwitch$lambda$7(AccountFragment.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPrivacyModeSwitch$lambda$7(AccountFragment accountFragment, CompoundButton compoundButton, boolean z) {
        if (accountFragment.isSwitching || accountFragment.isEnterpriseLogin()) {
            return;
        }
        accountFragment.togglePrivacyMode(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyEnterprisePrivacyMode(boolean open) {
        this.isSwitching = true;
        SwitchCompat switchCompat = this.switchPrivacyMode;
        SwitchCompat switchCompat2 = null;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat = null;
        }
        switchCompat.setChecked(open);
        SwitchCompat switchCompat3 = this.switchPrivacyMode;
        if (switchCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat3 = null;
        }
        switchCompat3.setEnabled(false);
        SwitchCompat switchCompat4 = this.switchPrivacyMode;
        if (switchCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat4 = null;
        }
        switchCompat4.setClickable(false);
        SwitchCompat switchCompat5 = this.switchPrivacyMode;
        if (switchCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat5 = null;
        }
        switchCompat5.setFocusable(false);
        SwitchCompat switchCompat6 = this.switchPrivacyMode;
        if (switchCompat6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat6 = null;
        }
        switchCompat6.jumpDrawablesToCurrentState();
        SwitchCompat switchCompat7 = this.switchPrivacyMode;
        if (switchCompat7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
        } else {
            switchCompat2 = switchCompat7;
        }
        switchCompat2.setVisibility(0);
        this.isSwitching = false;
    }

    private final void updatePrivacyModeCopy() {
        TextView textView = null;
        if (isEnterpriseLogin()) {
            TextView textView2 = this.tvPrivacyDesc;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDesc");
                textView2 = null;
            }
            textView2.setText(buildEnterprisePrivacyDesc());
            TextView textView3 = this.tvPrivacyDesc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDesc");
                textView3 = null;
            }
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView4 = this.tvPrivacyDesc;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDesc");
                textView4 = null;
            }
            textView4.setHighlightColor(0);
            TextView textView5 = this.tvPrivacyDetails;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDetails");
            } else {
                textView = textView5;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView6 = this.tvPrivacyDesc;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDesc");
            textView6 = null;
        }
        textView6.setText(C0820R.string.trae_setting_privacy_desc);
        TextView textView7 = this.tvPrivacyDesc;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDesc");
            textView7 = null;
        }
        textView7.setMovementMethod(null);
        TextView textView8 = this.tvPrivacyDetails;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDetails");
            textView8 = null;
        }
        textView8.setText(C0820R.string.trae_setting_privacy_details);
        TextView textView9 = this.tvPrivacyDetails;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyDetails");
        } else {
            textView = textView9;
        }
        textView.setVisibility(0);
    }

    private final SpannableString buildEnterprisePrivacyDesc() {
        String string = getString(R.string.trae_setting_enterprise_privacy_desc);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.trae_setting_enterprise_privacy_details);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.trae_setting_enterprise_privacy_link_separator);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String str = string + string3 + string2;
        int length = string.length() + string3.length();
        final int color = ContextCompat.getColor(requireContext(), C0820R.color.trae_setting_text_link);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$buildEnterprisePrivacyDesc$1$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                AccountFragment.this.openPrivacyModeDetails();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                ds.setColor(color);
                ds.setUnderlineText(false);
            }
        }, length, str.length(), 33);
        return spannableString;
    }

    private final String getPrivacyModeDetailsUrl() {
        if (isEnterpriseLogin()) {
            return ENTERPRISE_DATA_PROTECTION_URL;
        }
        return "https://" + (AppHost.INSTANCE.isOversea() ? "docs.trae.ai" : "docs.trae.cn") + "/ide/privacy-mode?_lang=" + LocaleManager.INSTANCE.getAppLocale().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPrivacyModeDetails() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getPrivacyModeDetailsUrl())));
        } catch (Exception unused) {
        }
    }

    private final void restoreEditablePrivacyModeInteraction() {
        SwitchCompat switchCompat = this.switchPrivacyMode;
        SwitchCompat switchCompat2 = null;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat = null;
        }
        switchCompat.setEnabled(true);
        SwitchCompat switchCompat3 = this.switchPrivacyMode;
        if (switchCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat3 = null;
        }
        switchCompat3.setClickable(true);
        SwitchCompat switchCompat4 = this.switchPrivacyMode;
        if (switchCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
        } else {
            switchCompat2 = switchCompat4;
        }
        switchCompat2.setFocusable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyEditablePrivacyMode() {
        restoreEditablePrivacyModeInteraction();
        SwitchCompat switchCompat = this.switchPrivacyMode;
        SwitchCompat switchCompat2 = null;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat = null;
        }
        switchCompat.jumpDrawablesToCurrentState();
        SwitchCompat switchCompat3 = this.switchPrivacyMode;
        if (switchCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
        } else {
            switchCompat2 = switchCompat3;
        }
        switchCompat2.setVisibility(0);
    }

    private final void updateLoginMethods(UserProfileState profile) {
        if (getHideLoginMethods()) {
            View view = this.cardLoginMethods;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.cardLoginMethods;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.dividerPhone;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        if (profile.getPhoneNumber().length() > 0) {
            TextView textView = this.tvPhoneSubtitle;
            if (textView != null) {
                textView.setText(profile.getPhoneNumber());
            }
            TextView textView2 = this.btnPhoneAction;
            if (textView2 != null) {
                textView2.setText(getString(C0820R.string.trae_setting_change_bind));
            }
            applyBindingButtonStyle$default(this, this.btnPhoneAction, false, 2, null);
        } else {
            TextView textView3 = this.tvPhoneSubtitle;
            if (textView3 != null) {
                textView3.setText(getString(C0820R.string.trae_setting_not_bound));
            }
            TextView textView4 = this.btnPhoneAction;
            if (textView4 != null) {
                textView4.setText(getString(C0820R.string.trae_setting_bind));
            }
            applyBindingButtonStyle(this.btnPhoneAction, true);
        }
        refreshDouyinStatus();
    }

    private final void setupPhoneBinding() {
        TextView textView = this.btnPhoneAction;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountFragment.setupPhoneBinding$lambda$11(AccountFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r0 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setupPhoneBinding$lambda$11(AccountFragment accountFragment, View view) {
        Context activity;
        String str;
        AccountInfo accountInfo;
        if (accountFragment.getHideLoginMethods() || (activity = accountFragment.getActivity()) == null) {
            return;
        }
        SettingsViewModel settingsViewModel = accountFragment.viewModel;
        String str2 = null;
        if (settingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel = null;
        }
        UserProfileState userProfileState = (UserProfileState) settingsViewModel.getUserProfile().getValue();
        if (userProfileState != null && (str = userProfileState.getPhoneNumber()) != null) {
            if (!(str.length() > 0)) {
                str = null;
            }
        }
        ILoginService loginService = accountFragment.getLoginService();
        if (loginService != null && (accountInfo = loginService.getAccountInfo()) != null) {
            str2 = accountInfo.getPhoneNumber();
        }
        str = str2 == null ? "" : str2;
        boolean z = str.length() > 0;
        String str3 = z ? "change" : "bind";
        String str4 = z ? "change" : "bind";
        SettingsTracker.INSTANCE.trackAccountBindingClick("phone", str4);
        try {
            Intent intent = new Intent();
            intent.setClassName(activity, PHONE_BIND_ACTIVITY_CLASS);
            intent.putExtra("extra_mode", str3);
            intent.putExtra(PHONE_BIND_EXTRA_SOURCE, PHONE_BIND_SOURCE_SETTINGS);
            if (z) {
                intent.putExtra(PHONE_BIND_EXTRA_PHONE_MASKED, str);
            }
            accountFragment.phoneBindLauncher.launch(intent);
        } catch (Exception unused) {
            SettingsTracker.INSTANCE.trackAccountBindingResult("phone", str4, "fail", (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : "activity_launch_failed");
            Toast.makeText(accountFragment.requireContext(), C0820R.string.trae_setting_douyin_operation_failed, 0).show();
        }
    }

    private final void setupDouyinBinding() {
        TextView textView = this.btnDouyinAction;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountFragment.setupDouyinBinding$lambda$12(AccountFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDouyinBinding$lambda$12(AccountFragment accountFragment, View view) {
        IDouyinLoginService douyinLoginService;
        if (accountFragment.getHideLoginMethods() || (douyinLoginService = accountFragment.getDouyinLoginService()) == null) {
            return;
        }
        if (douyinLoginService.isBound()) {
            accountFragment.showUnbindDialog();
        } else {
            accountFragment.performDouyinBind();
        }
    }

    private final void setupDeleteAccount() {
        View findViewById;
        View view = getView();
        if (view == null || (findViewById = view.findViewById(C0820R.id.btn_delete_account)) == null) {
            return;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.setupDeleteAccount$lambda$13(AccountFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDeleteAccount$lambda$13(AccountFragment accountFragment, View view) {
        if (accountFragment.isEnterpriseLogin()) {
            return;
        }
        accountFragment.getParentFragmentManager().beginTransaction().setCustomAnimations(C0820R.anim.trae_slide_in_right, C0820R.anim.trae_slide_out_left, C0820R.anim.trae_slide_in_left, C0820R.anim.trae_slide_out_right).replace(C0820R.id.settings_fragment_container, DeleteAccountFragment.INSTANCE.newInstance()).addToBackStack((String) null).commit();
    }

    private final void updateDeleteAccountEntry() {
        View view = this.cardDeleteAccount;
        if (view != null) {
            view.setVisibility(isEnterpriseLogin() ? 8 : 0);
        }
    }

    private final void refreshDouyinStatus() {
        if (getHideLoginMethods()) {
            return;
        }
        IDouyinLoginService douyinLoginService = getDouyinLoginService();
        if (douyinLoginService != null && douyinLoginService.isBound()) {
            IDouyinLoginService douyinLoginService2 = getDouyinLoginService();
            String douyinNickname = douyinLoginService2 != null ? douyinLoginService2.getDouyinNickname() : null;
            TextView textView = this.tvDouyinSubtitle;
            if (textView != null) {
                if (douyinNickname == null) {
                    douyinNickname = getString(C0820R.string.trae_setting_douyin_bound);
                    Intrinsics.checkNotNullExpressionValue(douyinNickname, "getString(...)");
                }
                textView.setText(douyinNickname);
            }
            TextView textView2 = this.btnDouyinAction;
            if (textView2 != null) {
                textView2.setText(getString(C0820R.string.trae_setting_unbind));
            }
            applyBindingButtonStyle(this.btnDouyinAction, false);
            return;
        }
        TextView textView3 = this.tvDouyinSubtitle;
        if (textView3 != null) {
            textView3.setText(getString(C0820R.string.trae_setting_not_bound));
        }
        TextView textView4 = this.btnDouyinAction;
        if (textView4 != null) {
            textView4.setText(getString(C0820R.string.trae_setting_bind));
        }
        applyBindingButtonStyle(this.btnDouyinAction, true);
    }

    static /* synthetic */ void applyBindingButtonStyle$default(AccountFragment accountFragment, TextView textView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        accountFragment.applyBindingButtonStyle(textView, z);
    }

    private final void applyBindingButtonStyle(TextView button, boolean primary) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (primary) {
            if (button != null) {
                button.setBackgroundResource(C0820R.drawable.bg_btn_binding_primary);
            }
            if (button != null) {
                button.setTextColor(-1);
                return;
            }
            return;
        }
        if (button != null) {
            button.setBackgroundResource(C0820R.drawable.bg_btn_binding_secondary);
        }
        if (button != null) {
            button.setTextColor(ContextCompat.getColor(context, C0820R.color.trae_setting_text_primary));
        }
    }

    private final void showUnbindDialog() {
        AccountInfo accountInfo;
        ILoginService loginService = getLoginService();
        if (loginService == null || (accountInfo = loginService.getAccountInfo()) == null) {
            return;
        }
        String phoneNumber = accountInfo.getPhoneNumber();
        if (phoneNumber == null || phoneNumber.length() == 0) {
            SettingsTracker.INSTANCE.trackAccountBindingClick(SettingsTracker.BINDING_TYPE_DOUYIN, SettingsTracker.BINDING_ACTION_UNBIND);
            SettingsTracker.INSTANCE.trackAccountBindingResult(SettingsTracker.BINDING_TYPE_DOUYIN, SettingsTracker.BINDING_ACTION_UNBIND, "fail", (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : "last_login_method");
            Toast.makeText(requireContext(), C0820R.string.trae_setting_douyin_last_method, 0).show();
            return;
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(C0820R.layout.trae_dialog_unbind_confirm);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout((int) (context.getResources().getDisplayMetrics().widthPixels * 0.8f), -2);
            window.setGravity(17);
            window.setDimAmount(DIALOG_DIM_AMOUNT);
        }
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AccountFragment.showUnbindDialog$lambda$15(AccountFragment.this, dialog, dialogInterface);
            }
        });
        this.unbindDialog = dialog;
        ((TextView) dialog.findViewById(C0820R.id.tv_dialog_title)).setText(getString(C0820R.string.trae_setting_douyin_unbind_title));
        ((TextView) dialog.findViewById(C0820R.id.tv_message)).setText(getString(C0820R.string.trae_setting_douyin_unbind_message));
        TextView textView = (TextView) dialog.findViewById(C0820R.id.btn_confirm);
        textView.setText(getString(C0820R.string.trae_setting_douyin_unbind_confirm));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.showUnbindDialog$lambda$17$lambda$16(dialog, this, view);
            }
        });
        TextView textView2 = (TextView) dialog.findViewById(C0820R.id.btn_cancel);
        textView2.setText(getString(C0820R.string.trae_setting_cancel));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUnbindDialog$lambda$15(AccountFragment accountFragment, Dialog dialog, DialogInterface dialogInterface) {
        if (accountFragment.unbindDialog == dialog) {
            accountFragment.unbindDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUnbindDialog$lambda$17$lambda$16(Dialog dialog, AccountFragment accountFragment, View view) {
        dialog.dismiss();
        SettingsTracker.INSTANCE.trackAccountBindingClick(SettingsTracker.BINDING_TYPE_DOUYIN, SettingsTracker.BINDING_ACTION_UNBIND);
        accountFragment.performDouyinUnbind();
    }

    public void onDestroyView() {
        Dialog dialog = this.unbindDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.unbindDialog = null;
        super.onDestroyView();
    }

    private final void performDouyinUnbind() {
        IDouyinLoginService douyinLoginService = getDouyinLoginService();
        if (douyinLoginService != null) {
            douyinLoginService.unbind(new Function0() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda20
                public final Object invoke() {
                    Unit performDouyinUnbind$lambda$21;
                    performDouyinUnbind$lambda$21 = AccountFragment.performDouyinUnbind$lambda$21(AccountFragment.this);
                    return performDouyinUnbind$lambda$21;
                }
            }, new Function2() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit performDouyinUnbind$lambda$23;
                    performDouyinUnbind$lambda$23 = AccountFragment.performDouyinUnbind$lambda$23(AccountFragment.this, ((Integer) obj).intValue(), (String) obj2);
                    return performDouyinUnbind$lambda$23;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit performDouyinUnbind$lambda$21(final AccountFragment accountFragment) {
        SettingsTracker.INSTANCE.trackAccountBindingResult(SettingsTracker.BINDING_TYPE_DOUYIN, SettingsTracker.BINDING_ACTION_UNBIND, "success", (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        FragmentActivity activity = accountFragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    AccountFragment.performDouyinUnbind$lambda$21$lambda$20(AccountFragment.this);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performDouyinUnbind$lambda$21$lambda$20(AccountFragment accountFragment) {
        if (accountFragment.isAdded()) {
            Toast.makeText(accountFragment.requireContext(), C0820R.string.trae_setting_douyin_unbind_success, 0).show();
            accountFragment.refreshDouyinStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit performDouyinUnbind$lambda$23(final AccountFragment accountFragment, int i, final String str) {
        SettingsTracker.INSTANCE.trackAccountBindingResult(SettingsTracker.BINDING_TYPE_DOUYIN, SettingsTracker.BINDING_ACTION_UNBIND, "fail", Integer.valueOf(i), str);
        FragmentActivity activity = accountFragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    AccountFragment.performDouyinUnbind$lambda$23$lambda$22(AccountFragment.this, str);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performDouyinUnbind$lambda$23$lambda$22(AccountFragment accountFragment, String str) {
        if (accountFragment.isAdded()) {
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                str = accountFragment.getString(C0820R.string.trae_setting_douyin_operation_failed);
                Intrinsics.checkNotNull(str);
            }
            Toast.makeText(accountFragment.requireContext(), str, 0).show();
        }
    }

    private final void performDouyinBind() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        SettingsTracker.INSTANCE.trackAccountBindingClick(SettingsTracker.BINDING_TYPE_DOUYIN, "bind");
        IDouyinLoginService douyinLoginService = getDouyinLoginService();
        if (douyinLoginService != null) {
            douyinLoginService.bindToAccount(activity, new Function0() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit performDouyinBind$lambda$25;
                    performDouyinBind$lambda$25 = AccountFragment.performDouyinBind$lambda$25(AccountFragment.this);
                    return performDouyinBind$lambda$25;
                }
            }, new Function2() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit performDouyinBind$lambda$27;
                    performDouyinBind$lambda$27 = AccountFragment.performDouyinBind$lambda$27(AccountFragment.this, ((Integer) obj).intValue(), (String) obj2);
                    return performDouyinBind$lambda$27;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit performDouyinBind$lambda$25(final AccountFragment accountFragment) {
        SettingsTracker.INSTANCE.trackAccountBindingResult(SettingsTracker.BINDING_TYPE_DOUYIN, "bind", "success", (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        FragmentActivity activity = accountFragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    AccountFragment.performDouyinBind$lambda$25$lambda$24(AccountFragment.this);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performDouyinBind$lambda$25$lambda$24(AccountFragment accountFragment) {
        if (accountFragment.isAdded()) {
            Toast.makeText(accountFragment.requireContext(), C0820R.string.trae_setting_douyin_bind_success, 0).show();
            accountFragment.refreshDouyinStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit performDouyinBind$lambda$27(final AccountFragment accountFragment, final int i, final String str) {
        SettingsTracker.INSTANCE.trackAccountBindingResult(SettingsTracker.BINDING_TYPE_DOUYIN, "bind", "fail", Integer.valueOf(i), str);
        FragmentActivity activity = accountFragment.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AccountFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    AccountFragment.performDouyinBind$lambda$27$lambda$26(AccountFragment.this, str, i);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performDouyinBind$lambda$27$lambda$26(AccountFragment accountFragment, String str, int i) {
        if (accountFragment.isAdded()) {
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                if (i == 1030) {
                    str = accountFragment.getString(C0820R.string.trae_setting_douyin_bind_conflict);
                    Intrinsics.checkNotNull(str);
                } else {
                    str = accountFragment.getString(C0820R.string.trae_setting_douyin_operation_failed);
                    Intrinsics.checkNotNull(str);
                }
            }
            Toast.makeText(accountFragment.requireContext(), str, 0).show();
        }
    }

    private final void fetchPrivacyModeStatus() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new AccountFragment$fetchPrivacyModeStatus$1(this, null), 3, (Object) null);
    }

    private final void togglePrivacyMode(boolean open) {
        if (this.isSwitching) {
            return;
        }
        this.isSwitching = true;
        SwitchCompat switchCompat = this.switchPrivacyMode;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
            switchCompat = null;
        }
        switchCompat.setEnabled(false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new AccountFragment$togglePrivacyMode$1(open, this, null), 3, (Object) null);
    }

    /* compiled from: AccountFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AccountFragment$Companion;", "", "<init>", "()V", "PHONE_BIND_ACTIVITY_CLASS", "", "PHONE_BIND_EXTRA_MODE", "PHONE_BIND_EXTRA_PHONE_MASKED", "PHONE_BIND_EXTRA_SOURCE", "PHONE_BIND_MODE_BIND", "PHONE_BIND_MODE_CHANGE", "PHONE_BIND_SOURCE_SETTINGS", "ENTERPRISE_DATA_PROTECTION_URL", "DOUYIN_BIND_CONFLICT_ERROR", "", "DIALOG_WIDTH_RATIO", "", "DIALOG_DIM_AMOUNT", "newInstance", "Lcom/bytedance/trae/home/solo/setting/AccountFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AccountFragment newInstance() {
            return new AccountFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginService loginService_delegate$lambda$0() {
        return (ILoginService) ServiceManager.get().getService(ILoginService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IDouyinLoginService douyinLoginService_delegate$lambda$1() {
        return (IDouyinLoginService) ServiceManager.get().getService(IDouyinLoginService.class);
    }
}
