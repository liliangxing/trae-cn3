package com.bytedance.trae.login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.trae.common.fragment.TraceFragment;
import com.bytedance.trae.common.widget.UrlSpanTextView;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.activity.AccountLoginActivity;
import com.bytedance.trae.login.activity.AgreementDialog;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.AgreementUrlOpener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginEntryFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0016\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/trae/login/fragment/LoginEntryFragment;", "Lcom/bytedance/trae/common/fragment/TraceFragment;", "Lcom/bytedance/trae/login/fragment/BytecloudSsoHost;", "<init>", "()V", "isAgreementChecked", "", "agreementDialog", "Lcom/bytedance/trae/login/activity/AgreementDialog;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupViews", "setupEnterpriseLogin", "tryShowBytecloudSso", "showBytecloudSso", "onSsoClick", "Lkotlin/Function0;", "openUrl", "url", "", "toggleAgreement", "ivAgreementCheck", "Landroid/widget/ImageView;", "onDestroyView", "autoLogEnterPage", "onSaveInstanceState", "outState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LoginEntryFragment extends TraceFragment implements BytecloudSsoHost {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_AGREEMENT_CHECKED = "key_agreement_checked";
    private AgreementDialog agreementDialog;
    private boolean isAgreementChecked;

    public boolean autoLogEnterPage() {
        return false;
    }

    /* compiled from: LoginEntryFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/login/fragment/LoginEntryFragment$Companion;", "", "<init>", "()V", "KEY_AGREEMENT_CHECKED", "", "newInstance", "Lcom/bytedance/trae/login/fragment/LoginEntryFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginEntryFragment newInstance() {
            return new LoginEntryFragment();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.isAgreementChecked = savedInstanceState != null ? savedInstanceState.getBoolean(KEY_AGREEMENT_CHECKED) : false;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.trae_fragment_login_entry, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViews(view);
        setupEnterpriseLogin(view);
        tryShowBytecloudSso();
    }

    private final void setupViews(final View view) {
        final ImageView imageView = (ImageView) view.findViewById(C0820R.id.iv_agreement_check);
        UrlSpanTextView findViewById = view.findViewById(C0820R.id.privacy_policy_text);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C0820R.id.btn_douyin_login);
        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(C0820R.id.btn_phone_login);
        imageView.setImageResource(this.isAgreementChecked ? C0820R.drawable.trae_ic_checkmark_circle_filled : C0820R.drawable.trae_ic_checkmark_circle_unchecked);
        String string = getString(C0882R.string.login_agreement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        findViewById.setUrlSpannedText(string);
        findViewById.setOnClickListener(new UrlSpanTextView.OnClickListener() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$setupViews$1
            public void onUrlClick(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                if (Intrinsics.areEqual(url, "url1")) {
                    LoginEntryFragment.this.openUrl("https://www.trae.cn/terms-of-service");
                } else if (Intrinsics.areEqual(url, "url2")) {
                    LoginEntryFragment.this.openUrl("https://www.trae.cn/privacy-policy");
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginEntryFragment.setupViews$lambda$0(LoginEntryFragment.this, imageView, view2);
            }
        });
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginEntryFragment.setupViews$lambda$4(LoginEntryFragment.this, view, view2);
            }
        });
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginEntryFragment.setupViews$lambda$5(LoginEntryFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$0(LoginEntryFragment loginEntryFragment, ImageView imageView, View view) {
        Intrinsics.checkNotNull(imageView);
        loginEntryFragment.toggleAgreement(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$4(final LoginEntryFragment loginEntryFragment, final View view, View view2) {
        Context context;
        LoginTracker.INSTANCE.trackLoginClick("douyin");
        AccountLoginActivity activity = loginEntryFragment.getActivity();
        final AccountLoginActivity accountLoginActivity = activity instanceof AccountLoginActivity ? activity : null;
        if (accountLoginActivity == null) {
            return;
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_BUTTON_CLICKED, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        if (!loginEntryFragment.isAgreementChecked) {
            AgreementDialog agreementDialog = loginEntryFragment.agreementDialog;
            boolean z = false;
            if (agreementDialog != null && agreementDialog.isShowing()) {
                z = true;
            }
            if (z || (context = loginEntryFragment.getContext()) == null) {
                return;
            }
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_DIALOG_SHOWN, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
            AgreementDialog agreementDialog2 = new AgreementDialog(context, new Function0() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit unit;
                    unit = LoginEntryFragment.setupViews$lambda$4$lambda$1(LoginEntryFragment.this, view, accountLoginActivity);
                    return unit;
                }
            }, new Function0() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit unit;
                    unit = LoginEntryFragment.setupViews$lambda$4$lambda$2();
                    return unit;
                }
            });
            agreementDialog2.show();
            loginEntryFragment.agreementDialog = agreementDialog2;
            return;
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_METHOD_SELECTED, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        accountLoginActivity.onDouyinLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViews$lambda$4$lambda$1(LoginEntryFragment loginEntryFragment, View view, AccountLoginActivity accountLoginActivity) {
        if (!loginEntryFragment.isAdded()) {
            return Unit.INSTANCE;
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_ACCEPTED, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        loginEntryFragment.isAgreementChecked = true;
        ((ImageView) view.findViewById(C0820R.id.iv_agreement_check)).setImageResource(C0820R.drawable.trae_ic_checkmark_circle_filled);
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_METHOD_SELECTED, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        accountLoginActivity.onDouyinLogin();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViews$lambda$4$lambda$2() {
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_REJECTED, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$5(LoginEntryFragment loginEntryFragment, View view) {
        LoginTracker.INSTANCE.trackLoginClick(TraeAuthManager.PLATFORM_PHONE);
        AccountLoginActivity activity = loginEntryFragment.getActivity();
        AccountLoginActivity accountLoginActivity = activity instanceof AccountLoginActivity ? activity : null;
        if (accountLoginActivity == null) {
            return;
        }
        accountLoginActivity.onPhoneLoginClicked(loginEntryFragment.isAgreementChecked);
    }

    private final void setupEnterpriseLogin(final View view) {
        TextView textView = (TextView) view.findViewById(C0820R.id.btn_enterprise_login);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginEntryFragment.setupEnterpriseLogin$lambda$8(LoginEntryFragment.this, view, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupEnterpriseLogin$lambda$8(final LoginEntryFragment loginEntryFragment, final View view, View view2) {
        Context context;
        LoginTracker.INSTANCE.trackLoginClick("enterprise");
        AccountLoginActivity activity = loginEntryFragment.getActivity();
        AccountLoginActivity accountLoginActivity = activity instanceof AccountLoginActivity ? activity : null;
        if (accountLoginActivity == null) {
            return;
        }
        if (!loginEntryFragment.isAgreementChecked) {
            AgreementDialog agreementDialog = loginEntryFragment.agreementDialog;
            boolean z = false;
            if (agreementDialog != null && agreementDialog.isShowing()) {
                z = true;
            }
            if (z || (context = loginEntryFragment.getContext()) == null) {
                return;
            }
            AgreementDialog agreementDialog2 = new AgreementDialog(context, new Function0() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit unit;
                    unit = LoginEntryFragment.setupEnterpriseLogin$lambda$8$lambda$6(LoginEntryFragment.this, view);
                    return unit;
                }
            }, null, 4, null);
            agreementDialog2.show();
            loginEntryFragment.agreementDialog = agreementDialog2;
            return;
        }
        accountLoginActivity.openEnterpriseLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEnterpriseLogin$lambda$8$lambda$6(LoginEntryFragment loginEntryFragment, View view) {
        if (!loginEntryFragment.isAdded()) {
            return Unit.INSTANCE;
        }
        loginEntryFragment.isAgreementChecked = true;
        ((ImageView) view.findViewById(C0820R.id.iv_agreement_check)).setImageResource(C0820R.drawable.trae_ic_checkmark_circle_filled);
        AccountLoginActivity activity = loginEntryFragment.getActivity();
        AccountLoginActivity accountLoginActivity = activity instanceof AccountLoginActivity ? activity : null;
        if (accountLoginActivity != null) {
            accountLoginActivity.openEnterpriseLogin();
        }
        return Unit.INSTANCE;
    }

    private final void tryShowBytecloudSso() {
        AccountLoginActivity activity = getActivity();
        final AccountLoginActivity accountLoginActivity = activity instanceof AccountLoginActivity ? activity : null;
        if (accountLoginActivity == null) {
            return;
        }
        if (accountLoginActivity.isBytedanceNetwork() || BytecloudAuthManager.INSTANCE.hasEverSeenIntranet()) {
            showBytecloudSso(new Function0() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit tryShowBytecloudSso$lambda$9;
                    tryShowBytecloudSso$lambda$9 = LoginEntryFragment.tryShowBytecloudSso$lambda$9(AccountLoginActivity.this);
                    return tryShowBytecloudSso$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryShowBytecloudSso$lambda$9(AccountLoginActivity accountLoginActivity) {
        accountLoginActivity.openBytecloudLogin();
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.login.fragment.BytecloudSsoHost
    public void showBytecloudSso(final Function0<Unit> onSsoClick) {
        TextView textView;
        View findViewById;
        TextView textView2;
        Intrinsics.checkNotNullParameter(onSsoClick, "onSsoClick");
        View view = getView();
        if (view != null && (textView2 = (TextView) view.findViewById(C0820R.id.btn_bytecloud_sso)) != null) {
            textView2.setVisibility(0);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.LoginEntryFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginEntryFragment.showBytecloudSso$lambda$11$lambda$10(onSsoClick, view2);
                }
            });
        }
        View view2 = getView();
        if (view2 != null && (findViewById = view2.findViewById(C0820R.id.divider_login_links)) != null) {
            findViewById.setVisibility(0);
        }
        View view3 = getView();
        if (view3 == null || (textView = (TextView) view3.findViewById(C0820R.id.btn_enterprise_login)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = null;
        LinearLayout.LayoutParams layoutParams3 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams3 != null) {
            layoutParams3.width = 0;
            layoutParams3.weight = 1.0f;
            layoutParams2 = layoutParams3;
        }
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(8388611);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBytecloudSso$lambda$11$lambda$10(Function0 function0, View view) {
        LoginTracker.INSTANCE.trackLoginClick("bytecloud");
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(String url) {
        try {
            AgreementUrlOpener agreementUrlOpener = AgreementUrlOpener.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            agreementUrlOpener.open(requireContext, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void toggleAgreement(ImageView ivAgreementCheck) {
        int i;
        boolean z = !this.isAgreementChecked;
        this.isAgreementChecked = z;
        if (z) {
            i = C0820R.drawable.trae_ic_checkmark_circle_filled;
        } else {
            i = C0820R.drawable.trae_ic_checkmark_circle_unchecked;
        }
        ivAgreementCheck.setImageResource(i);
    }

    public void onDestroyView() {
        super.onDestroyView();
        AgreementDialog agreementDialog = this.agreementDialog;
        if (agreementDialog != null) {
            agreementDialog.dismiss();
        }
        this.agreementDialog = null;
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_AGREEMENT_CHECKED, this.isAgreementChecked);
    }
}
