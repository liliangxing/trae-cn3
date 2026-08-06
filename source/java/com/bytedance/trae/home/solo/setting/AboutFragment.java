package com.bytedance.trae.home.solo.setting;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.ShareWebViewActivity;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.LocaleManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AboutFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AboutFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "baseDomain", "", "getBaseDomain", "()Ljava/lang/String;", "docsDomain", "getDocsDomain", "langParam", "getLangParam", "isEnterpriseLogin", "", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "openUrl", IWeixinService.ResponseConstants.URL, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AboutFragment extends Fragment {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ENTERPRISE_CONTACT_URL = "https://docs.trae.cn/enterprise_contact-us";

    private final String getBaseDomain() {
        return AppHost.INSTANCE.isOversea() ? "trae.ai" : "trae.cn";
    }

    private final String getDocsDomain() {
        return AppHost.INSTANCE.isOversea() ? "docs.trae.ai" : "docs.trae.cn";
    }

    private final String getLangParam() {
        String language = LocaleManager.INSTANCE.getAppLocale().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    private final boolean isEnterpriseLogin() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return ((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getAccountType()) == AccountType.TOB;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_about, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        PackageInfo packageInfo;
        String str;
        PackageManager packageManager;
        String str2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$1(AboutFragment.this, view2);
            }
        });
        TextView textView = (TextView) view.findViewById(C0820R.id.tv_version);
        try {
            Context context = getContext();
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                packageInfo = null;
            } else {
                Context context2 = getContext();
                if (context2 == null || (str2 = context2.getPackageName()) == null) {
                    str2 = "";
                }
                packageInfo = packageManager.getPackageInfo(str2, 0);
            }
            if (packageInfo == null || (str = packageInfo.versionName) == null) {
                str = "1.0.0";
            }
            textView.setText(getString(C0820R.string.trae_setting_about_version, new Object[]{str}));
        } catch (Exception e) {
            textView.setText(getString(C0820R.string.trae_setting_about_version, new Object[]{"1.0.0"}));
            e.printStackTrace();
        }
        view.findViewById(C0820R.id.btn_terms).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$3(AboutFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_privacy).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$5(AboutFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_opensource).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$7(AboutFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_help).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$9(AboutFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_contact).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$11(AboutFragment.this, view2);
            }
        });
        if (AppHost.INSTANCE.isOversea()) {
            return;
        }
        final View findViewById = view.findViewById(C0820R.id.btn_community);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$14$lambda$13(findViewById, this, view2);
            }
        });
        view.findViewById(C0820R.id.divider_community).setVisibility(0);
        view.findViewById(C0820R.id.divider_personal_info).setVisibility(0);
        View findViewById2 = view.findViewById(C0820R.id.btn_personal_info_list);
        findViewById2.setVisibility(0);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$17$lambda$16(AboutFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.divider_share_list).setVisibility(0);
        View findViewById3 = view.findViewById(C0820R.id.btn_share_list);
        findViewById3.setVisibility(0);
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$20$lambda$19(AboutFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.divider_license).setVisibility(0);
        View findViewById4 = view.findViewById(C0820R.id.btn_business_license);
        findViewById4.setVisibility(0);
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$23$lambda$22(AboutFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.divider_icp).setVisibility(0);
        View findViewById5 = view.findViewById(C0820R.id.btn_icp_filing);
        findViewById5.setVisibility(0);
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$26$lambda$25(AboutFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.divider_permission).setVisibility(0);
        View findViewById6 = view.findViewById(C0820R.id.btn_permission_usage);
        findViewById6.setVisibility(0);
        findViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutFragment.onViewCreated$lambda$29$lambda$28(AboutFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.onViewCreated$lambda$1$lambda$0(AboutFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(AboutFragment aboutFragment) {
        aboutFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.onViewCreated$lambda$3$lambda$2(AboutFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$2(AboutFragment aboutFragment) {
        aboutFragment.openUrl("https://www." + aboutFragment.getBaseDomain() + "/terms-of-service?_lang=" + aboutFragment.getLangParam() + "&platform=h5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.onViewCreated$lambda$5$lambda$4(AboutFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$4(AboutFragment aboutFragment) {
        aboutFragment.openUrl("https://www." + aboutFragment.getBaseDomain() + "/privacy-policy?_lang=" + aboutFragment.getLangParam() + "&platform=h5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.onViewCreated$lambda$7$lambda$6(AboutFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7$lambda$6(AboutFragment aboutFragment) {
        aboutFragment.openUrl("https://" + aboutFragment.getDocsDomain() + "/solo/open-source-software-notice-for-trae-solo-mobile-android?_lang=" + aboutFragment.getLangParam() + "&platform=h5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.onViewCreated$lambda$9$lambda$8(AboutFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$8(AboutFragment aboutFragment) {
        aboutFragment.openUrl("https://" + aboutFragment.getDocsDomain() + "/solo/what-is-trae-solo?_lang=" + aboutFragment.getLangParam() + "&platform=h5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.onViewCreated$lambda$11$lambda$10(AboutFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$lambda$10(AboutFragment aboutFragment) {
        aboutFragment.openUrl(aboutFragment.isEnterpriseLogin() ? ENTERPRISE_CONTACT_URL : "https://" + aboutFragment.getDocsDomain() + "/solo/support?_lang=" + aboutFragment.getLangParam() + "&platform=h5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$14$lambda$13(final View view, final AboutFragment aboutFragment, View view2) {
        view2.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.onViewCreated$lambda$14$lambda$13$lambda$12(view, aboutFragment);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$14$lambda$13$lambda$12(View view, AboutFragment aboutFragment) {
        Context context = view.getContext();
        if (context == null) {
            return;
        }
        ShareWebViewActivity.INSTANCE.startWithBrowser(context, "https://forum.trae.cn/", (r13 & 4) != 0 ? null : aboutFragment.getString(C0820R.string.trae_setting_about_community), (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$17$lambda$16(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.this.openUrl("https://www.trae.cn/h5/personal-collect");
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$20$lambda$19(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.this.openUrl("https://www.trae.cn/h5/share-list");
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$23$lambda$22(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.this.openUrl("https://www.trae.cn/h5/business-license");
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$26$lambda$25(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.this.openUrl("https://www.trae.cn/h5/icp-filing");
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$29$lambda$28(final AboutFragment aboutFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AboutFragment$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                AboutFragment.this.openUrl("https://www.trae.cn/h5/permission-usage-policy");
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(String url) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        try {
            AboutWebUrlOpener.INSTANCE.open(context, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* compiled from: AboutFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AboutFragment$Companion;", "", "<init>", "()V", "ENTERPRISE_CONTACT_URL", "", "newInstance", "Lcom/bytedance/trae/home/solo/setting/AboutFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AboutFragment newInstance() {
            return new AboutFragment();
        }
    }
}
