package com.bytedance.trae.home.solo.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.sdk.account.api.AccountDef;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.conversation.CreditsBalance;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.MainActivity;
import com.bytedance.trae.home.solo.setting.CNIdentityBadgePresentation;
import com.bytedance.trae.home.solo.setting.SettingsPointsBalancePresentation;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageTracker;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.IChangeLanguageApi;
import com.bytedance.trae.push.api.IPushService;
import com.bytedance.trae.update.AppUpdateChecker;
import com.bytedance.trae.utils.LocaleManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: SettingsMainFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J7\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0001H\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0002J(\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;", "tvDebugPpeValue", "Landroid/widget/TextView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "showNotificationConfirmDialog", "showLogoutConfirmDialog", "performLogout", "dismissAfterLogout", "showPopup", "anchorView", "items", "", "", "onSelected", "Lkotlin/Function1;", "(Landroid/view/View;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getLanguageDisplayName", "languageCode", "navigateTo", "fragment", "getSaaSProductTypeLabel", "productType", "", "renderCNIdentityBadge", "presentation", "Lcom/bytedance/trae/home/solo/setting/CNIdentityBadgePresentation;", "tvTierBadge", "tvFreeBadge", "imgIdentity", "Landroid/widget/ImageView;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsMainFragment extends Fragment {
    private TextView tvDebugPpeValue;
    private SettingsViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_settings_main, container, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x034b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        int i;
        SettingsViewModel settingsViewModel;
        SettingsViewModel settingsViewModel2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = new ViewModelProvider(requireActivity).get(SettingsViewModel.class);
        SettingsTracker.trackSettingsPageView$default(SettingsTracker.INSTANCE, null, 1, null);
        final SimpleDraweeView findViewById = view.findViewById(C0820R.id.iv_avatar);
        ImageView imageView = (ImageView) view.findViewById(C0820R.id.iv_bytecloud_badge);
        final TextView textView = (TextView) view.findViewById(C0820R.id.tv_name);
        final TextView textView2 = (TextView) view.findViewById(C0820R.id.tv_email);
        final TextView textView3 = (TextView) view.findViewById(C0820R.id.tv_pro_badge);
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        boolean areEqual = Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, ThirdPartyTokenRepository.TYPE_BYTECLOUD);
        boolean z = (accountInfo != null ? accountInfo.getAccountType() : null) == AccountType.TOB;
        String userId = accountInfo != null ? accountInfo.getUserId() : null;
        if (userId == null) {
            userId = "";
        }
        final String str = userId;
        imageView.setVisibility(areEqual ? 0 : 8);
        SettingsViewModel settingsViewModel3 = this.viewModel;
        if (settingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel3 = null;
        }
        final boolean z2 = z;
        settingsViewModel3.getUserProfile().observe(getViewLifecycleOwner(), new SettingsMainFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$0;
                onViewCreated$lambda$0 = SettingsMainFragment.onViewCreated$lambda$0(textView, findViewById, z2, textView2, textView3, this, (UserProfileState) obj);
                return onViewCreated$lambda$0;
            }
        }));
        SettingsViewModel settingsViewModel4 = this.viewModel;
        if (settingsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            settingsViewModel4 = null;
        }
        settingsViewModel4.loadUserInfo();
        if (z) {
            TextView textView4 = (TextView) view.findViewById(C0820R.id.tv_cn_free_badge);
            ImageView imageView2 = (ImageView) view.findViewById(C0820R.id.img_cn_identity);
            textView3.setText(getSaaSProductTypeLabel(accountInfo != null ? accountInfo.getProductType() : 0));
            textView3.setVisibility(0);
            i = 8;
            textView4.setVisibility(8);
            imageView2.setVisibility(8);
        } else {
            i = 8;
            if (AppHost.INSTANCE.isOversea()) {
                final TextView textView5 = (TextView) view.findViewById(C0820R.id.tv_pro_badge);
                SettingsViewModel settingsViewModel5 = this.viewModel;
                if (settingsViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel5 = null;
                }
                settingsViewModel5.fetchUserPayStatus();
                SettingsViewModel settingsViewModel6 = this.viewModel;
                if (settingsViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel6 = null;
                }
                settingsViewModel6.getUserPayStatus().observe(getViewLifecycleOwner(), new SettingsMainFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit onViewCreated$lambda$1;
                        onViewCreated$lambda$1 = SettingsMainFragment.onViewCreated$lambda$1(textView5, (UserPayStatusData) obj);
                        return onViewCreated$lambda$1;
                    }
                }));
            } else if (TocCreditsPolicy.INSTANCE.isEnabled()) {
                final TextView textView6 = (TextView) view.findViewById(C0820R.id.tv_cn_free_badge);
                final TextView textView7 = (TextView) view.findViewById(C0820R.id.tv_cn_tier_badge);
                final ImageView imageView3 = (ImageView) view.findViewById(C0820R.id.img_cn_identity);
                CNIdentityBadgePresentation.Hidden hidden = CNIdentityBadgePresentation.Hidden.INSTANCE;
                Intrinsics.checkNotNull(textView7);
                Intrinsics.checkNotNull(textView6);
                Intrinsics.checkNotNull(imageView3);
                renderCNIdentityBadge(hidden, textView7, textView6, imageView3);
                SettingsViewModel settingsViewModel7 = this.viewModel;
                if (settingsViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel7 = null;
                }
                settingsViewModel7.fetchUserPayStatus();
                SettingsViewModel settingsViewModel8 = this.viewModel;
                if (settingsViewModel8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel8 = null;
                }
                settingsViewModel8.getUserCNPayStatus().observe(getViewLifecycleOwner(), new SettingsMainFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit onViewCreated$lambda$2;
                        onViewCreated$lambda$2 = SettingsMainFragment.onViewCreated$lambda$2(str, this, textView7, textView6, imageView3, (CNUserPayStatusData) obj);
                        return onViewCreated$lambda$2;
                    }
                }));
            } else {
                final TextView textView8 = (TextView) view.findViewById(C0820R.id.tv_cn_free_badge);
                final ImageView imageView4 = (ImageView) view.findViewById(C0820R.id.img_cn_identity);
                SettingsViewModel settingsViewModel9 = this.viewModel;
                if (settingsViewModel9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel9 = null;
                }
                settingsViewModel9.fetchUserPayStatus();
                SettingsViewModel settingsViewModel10 = this.viewModel;
                if (settingsViewModel10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel10 = null;
                }
                settingsViewModel10.getUserCNPayStatus().observe(getViewLifecycleOwner(), new SettingsMainFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit onViewCreated$lambda$3;
                        onViewCreated$lambda$3 = SettingsMainFragment.onViewCreated$lambda$3(textView8, this, imageView4, (CNUserPayStatusData) obj);
                        return onViewCreated$lambda$3;
                    }
                }));
            }
        }
        view.findViewById(C0820R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsMainFragment.onViewCreated$lambda$4(SettingsMainFragment.this, view2);
            }
        });
        TextView textView9 = (TextView) view.findViewById(C0820R.id.btn_edit_profile);
        if (areEqual) {
            textView9.setVisibility(i);
        } else {
            textView9.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$5(SettingsMainFragment.this, view2);
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C0820R.id.btn_account);
        if (areEqual) {
            ((LinearLayout) view.findViewById(C0820R.id.group_account_messages)).setVisibility(i);
        } else {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$7(SettingsMainFragment.this, view2);
                }
            });
        }
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C0820R.id.btn_messages);
        TextView textView10 = (TextView) view.findViewById(C0820R.id.tv_message_badge);
        if (z) {
            linearLayout2.setVisibility(i);
        } else if (!areEqual) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$9(SettingsMainFragment.this, view2);
                }
            });
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            settingsViewModel = null;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new SettingsMainFragment$onViewCreated$9(textView10, null), 3, (Object) null);
            SiteMessageRepository.INSTANCE.refreshUnreadCount();
            final LinearLayout linearLayout3 = (LinearLayout) view.findViewById(C0820R.id.row_points);
            final TextView textView11 = (TextView) view.findViewById(C0820R.id.tv_points_balance);
            if (TocCreditsPolicy.INSTANCE.isEnabled()) {
                SettingsViewModel settingsViewModel11 = this.viewModel;
                if (settingsViewModel11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel11 = settingsViewModel;
                }
                settingsViewModel11.getCreditsBalanceSnapshot().observe(getViewLifecycleOwner(), new SettingsMainFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Unit onViewCreated$lambda$10;
                        onViewCreated$lambda$10 = SettingsMainFragment.onViewCreated$lambda$10(textView11, linearLayout3, (CreditsBalanceSnapshot) obj);
                        return onViewCreated$lambda$10;
                    }
                }));
                SettingsViewModel settingsViewModel12 = this.viewModel;
                if (settingsViewModel12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    settingsViewModel2 = settingsViewModel;
                } else {
                    settingsViewModel2 = settingsViewModel12;
                }
                settingsViewModel2.fetchCreditsBalance();
            }
            ((LinearLayout) view.findViewById(C0820R.id.btn_theme)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$11(view2);
                }
            });
            final LinearLayout linearLayout4 = (LinearLayout) view.findViewById(C0820R.id.btn_language);
            TextView textView12 = (TextView) view.findViewById(C0820R.id.tv_language_value);
            String language = LocaleManager.INSTANCE.getAppLocale().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            textView12.setText(getLanguageDisplayName(language));
            final String[] strArr = {"zh", "en", "ja"};
            final String[] strArr2 = {getString(C0820R.string.trae_setting_lang_chinese), getString(C0820R.string.trae_setting_lang_english), getString(C0820R.string.trae_setting_lang_japanese)};
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$13(SettingsMainFragment.this, linearLayout4, strArr2, strArr, view2);
                }
            });
            ((LinearLayout) view.findViewById(C0820R.id.btn_device_management)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda21
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$14(SettingsMainFragment.this, view2);
                }
            });
            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(C0820R.id.btn_connectors);
            if (!areEqual) {
                linearLayout5.setVisibility(i);
                view.findViewById(C0820R.id.divider_connectors).setVisibility(i);
            } else {
                linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda22
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SettingsMainFragment.onViewCreated$lambda$15(SettingsMainFragment.this, view2);
                    }
                });
            }
            ((LinearLayout) view.findViewById(C0820R.id.btn_privacy_permission)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda23
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$17(SettingsMainFragment.this, view2);
                }
            });
            ((LinearLayout) view.findViewById(C0820R.id.btn_notification)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda24
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$18(SettingsMainFragment.this, view2);
                }
            });
            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(C0820R.id.btn_update);
            if (!AppHost.INSTANCE.isOversea()) {
                linearLayout6.setVisibility(i);
                view.findViewById(C0820R.id.divider_update_about).setVisibility(i);
            } else {
                linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda25
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SettingsMainFragment.onViewCreated$lambda$19(view2);
                    }
                });
            }
            ((LinearLayout) view.findViewById(C0820R.id.btn_about)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda26
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$21(SettingsMainFragment.this, view2);
                }
            });
            if (AppHost.INSTANCE.isDebug()) {
                LinearLayout linearLayout7 = (LinearLayout) view.findViewById(C0820R.id.btn_debug);
                this.tvDebugPpeValue = (TextView) view.findViewById(C0820R.id.tv_debug_ppe_value);
                linearLayout7.setVisibility(0);
                String ppeEnv = DebugSettings.INSTANCE.getPpeEnv();
                TextView textView13 = this.tvDebugPpeValue;
                if (textView13 != null) {
                    String str2 = ppeEnv;
                    if (str2.length() == 0) {
                        str2 = getString(C0820R.string.trae_setting_debug_ppe_env_not_set);
                        Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                    }
                    textView13.setText(str2);
                }
                linearLayout7.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda27
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SettingsMainFragment.onViewCreated$lambda$24(SettingsMainFragment.this, view2);
                    }
                });
            }
            ((LinearLayout) view.findViewById(C0820R.id.btn_logout)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsMainFragment.onViewCreated$lambda$25(SettingsMainFragment.this, view2);
                }
            });
            if (AppHost.INSTANCE.isOversea()) {
                ((TextView) view.findViewById(C0820R.id.tv_model_name)).setVisibility(0);
                ((TextView) view.findViewById(C0820R.id.tv_model_filing)).setVisibility(0);
                TextView textView14 = (TextView) view.findViewById(C0820R.id.tv_icp_filing);
                textView14.setVisibility(0);
                textView14.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SettingsMainFragment.onViewCreated$lambda$26(SettingsMainFragment.this, view2);
                    }
                });
                return;
            }
            return;
        }
        settingsViewModel = null;
        final LinearLayout linearLayout32 = (LinearLayout) view.findViewById(C0820R.id.row_points);
        final TextView textView112 = (TextView) view.findViewById(C0820R.id.tv_points_balance);
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
        }
        ((LinearLayout) view.findViewById(C0820R.id.btn_theme)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsMainFragment.onViewCreated$lambda$11(view2);
            }
        });
        final LinearLayout linearLayout42 = (LinearLayout) view.findViewById(C0820R.id.btn_language);
        TextView textView122 = (TextView) view.findViewById(C0820R.id.tv_language_value);
        String language2 = LocaleManager.INSTANCE.getAppLocale().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language2, "getLanguage(...)");
        textView122.setText(getLanguageDisplayName(language2));
        final String[] strArr3 = {"zh", "en", "ja"};
        final String[] strArr22 = {getString(C0820R.string.trae_setting_lang_chinese), getString(C0820R.string.trae_setting_lang_english), getString(C0820R.string.trae_setting_lang_japanese)};
        linearLayout42.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsMainFragment.onViewCreated$lambda$13(SettingsMainFragment.this, linearLayout42, strArr22, strArr3, view2);
            }
        });
        ((LinearLayout) view.findViewById(C0820R.id.btn_device_management)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsMainFragment.onViewCreated$lambda$14(SettingsMainFragment.this, view2);
            }
        });
        LinearLayout linearLayout52 = (LinearLayout) view.findViewById(C0820R.id.btn_connectors);
        if (!areEqual) {
        }
        ((LinearLayout) view.findViewById(C0820R.id.btn_privacy_permission)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsMainFragment.onViewCreated$lambda$17(SettingsMainFragment.this, view2);
            }
        });
        ((LinearLayout) view.findViewById(C0820R.id.btn_notification)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsMainFragment.onViewCreated$lambda$18(SettingsMainFragment.this, view2);
            }
        });
        LinearLayout linearLayout62 = (LinearLayout) view.findViewById(C0820R.id.btn_update);
        if (!AppHost.INSTANCE.isOversea()) {
        }
        ((LinearLayout) view.findViewById(C0820R.id.btn_about)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsMainFragment.onViewCreated$lambda$21(SettingsMainFragment.this, view2);
            }
        });
        if (AppHost.INSTANCE.isDebug()) {
        }
        ((LinearLayout) view.findViewById(C0820R.id.btn_logout)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsMainFragment.onViewCreated$lambda$25(SettingsMainFragment.this, view2);
            }
        });
        if (AppHost.INSTANCE.isOversea()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(TextView textView, SimpleDraweeView simpleDraweeView, boolean z, TextView textView2, TextView textView3, SettingsMainFragment settingsMainFragment, UserProfileState userProfileState) {
        String email;
        if (userProfileState != null) {
            if (userProfileState.getScreenName().length() > 0) {
                textView.setText(userProfileState.getScreenName());
            }
            if (userProfileState.getAvatarUrl().length() > 0) {
                simpleDraweeView.setImageURI(Uri.parse(userProfileState.getAvatarUrl()));
            } else {
                simpleDraweeView.setActualImageResource(C0820R.drawable.trae_default_avatar);
            }
            if (AppHost.INSTANCE.isOversea() || z) {
                email = userProfileState.getEmail();
            } else {
                email = userProfileState.getPhoneNumber();
            }
            String str = email;
            if (str.length() > 0) {
                textView2.setText(str);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            if (z) {
                textView3.setText(settingsMainFragment.getSaaSProductTypeLabel(userProfileState.getProductType()));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(TextView textView, UserPayStatusData userPayStatusData) {
        if (userPayStatusData != null) {
            textView.setText(userPayStatusData.getIdentity().getDisplayText());
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(String str, SettingsMainFragment settingsMainFragment, TextView textView, TextView textView2, ImageView imageView, CNUserPayStatusData cNUserPayStatusData) {
        CNIdentityBadgePresentation.Hidden hidden;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
        if (userId == null) {
            userId = "";
        }
        if (CNIdentityBadgePresentation.INSTANCE.canRenderForUser(str, userId, TocCreditsPolicy.INSTANCE.isEnabled())) {
            hidden = CNIdentityBadgePresentation.INSTANCE.from(cNUserPayStatusData);
        } else {
            hidden = CNIdentityBadgePresentation.Hidden.INSTANCE;
        }
        Intrinsics.checkNotNull(textView);
        Intrinsics.checkNotNull(textView2);
        Intrinsics.checkNotNull(imageView);
        settingsMainFragment.renderCNIdentityBadge(hidden, textView, textView2, imageView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(TextView textView, SettingsMainFragment settingsMainFragment, ImageView imageView, CNUserPayStatusData cNUserPayStatusData) {
        if (cNUserPayStatusData != null) {
            if (cNUserPayStatusData.getIdentity() == CNUserPayIdentity.FREE) {
                textView.setText(settingsMainFragment.getString(R.string.trae_badge_cn_free));
                textView.setVisibility(0);
                imageView.setVisibility(8);
            } else if (cNUserPayStatusData.getIdentity() == CNUserPayIdentity.CN_EXPRESS) {
                textView.setVisibility(8);
                imageView.setVisibility(0);
                imageView.setImageResource(C0820R.drawable.ic_identity_l4);
            } else {
                textView.setVisibility(8);
                imageView.setVisibility(0);
                imageView.setImageResource(C0820R.drawable.ic_identity_pay);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(SettingsMainFragment settingsMainFragment, View view) {
        AccountSettingsBottomSheet parentFragment = settingsMainFragment.getParentFragment();
        AccountSettingsBottomSheet accountSettingsBottomSheet = parentFragment instanceof AccountSettingsBottomSheet ? parentFragment : null;
        if (accountSettingsBottomSheet != null) {
            accountSettingsBottomSheet.dismissSafely();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(SettingsMainFragment settingsMainFragment, View view) {
        settingsMainFragment.navigateTo(EditProfileFragment.INSTANCE.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(final SettingsMainFragment settingsMainFragment, View view) {
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_ACCOUNT);
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                SettingsMainFragment.onViewCreated$lambda$7$lambda$6(SettingsMainFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7$lambda$6(SettingsMainFragment settingsMainFragment) {
        settingsMainFragment.navigateTo(AccountFragment.INSTANCE.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9(final SettingsMainFragment settingsMainFragment, View view) {
        SiteMessageTracker.INSTANCE.trackEntryClick(((Number) SiteMessageRepository.INSTANCE.getUnreadCount().getValue()).intValue() > 0);
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                SettingsMainFragment.onViewCreated$lambda$9$lambda$8(SettingsMainFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$8(SettingsMainFragment settingsMainFragment) {
        settingsMainFragment.navigateTo(SiteMessageListFragment.INSTANCE.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        if (r10.getInfinite() == true) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onViewCreated$lambda$10(TextView textView, LinearLayout linearLayout, CreditsBalanceSnapshot creditsBalanceSnapshot) {
        boolean z;
        CreditsBalance balance;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
        SettingsPointsBalancePresentation.Companion companion = SettingsPointsBalancePresentation.INSTANCE;
        String userId2 = creditsBalanceSnapshot != null ? creditsBalanceSnapshot.getUserId() : null;
        Long valueOf = (creditsBalanceSnapshot == null || (balance = creditsBalanceSnapshot.getBalance()) == null) ? null : Long.valueOf(balance.getRemaining());
        if (creditsBalanceSnapshot != null && (r10 = creditsBalanceSnapshot.getBalance()) != null) {
            z = true;
        }
        z = false;
        SettingsPointsBalancePresentation from = companion.from(userId2, userId, valueOf, z, TocCreditsPolicy.INSTANCE.isEnabled());
        if (Intrinsics.areEqual(from, SettingsPointsBalancePresentation.Hidden.INSTANCE)) {
            textView.setText((CharSequence) null);
            linearLayout.setVisibility(8);
        } else {
            if (!(from instanceof SettingsPointsBalancePresentation.Visible)) {
                throw new NoWhenBranchMatchedException();
            }
            textView.setText(((SettingsPointsBalancePresentation.Visible) from).getBalanceText());
            linearLayout.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11(View view) {
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_THEME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$13(final SettingsMainFragment settingsMainFragment, LinearLayout linearLayout, final String[] strArr, final String[] strArr2, View view) {
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_LANGUAGE);
        Intrinsics.checkNotNull(linearLayout);
        settingsMainFragment.showPopup(linearLayout, strArr, new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$13$lambda$12;
                onViewCreated$lambda$13$lambda$12 = SettingsMainFragment.onViewCreated$lambda$13$lambda$12(strArr, strArr2, settingsMainFragment, (String) obj);
                return onViewCreated$lambda$13$lambda$12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$13$lambda$12(String[] strArr, String[] strArr2, SettingsMainFragment settingsMainFragment, String str) {
        Intent intent;
        Intrinsics.checkNotNullParameter(str, "selected");
        int indexOf = ArraysKt.indexOf(strArr, str);
        if (indexOf >= 0) {
            String str2 = strArr2[indexOf];
            Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
            if (!Intrinsics.areEqual(str2, LocaleManager.INSTANCE.getCurrentLanguage())) {
                SettingsTracker.INSTANCE.trackLanguageSwitchClick(str2);
                LocaleManager.INSTANCE.setLanguage(str2);
                IChangeLanguageApi.Companion.syncLanguage(str2);
                AccountSettingsBottomSheet parentFragment = settingsMainFragment.getParentFragment();
                AccountSettingsBottomSheet accountSettingsBottomSheet = parentFragment instanceof AccountSettingsBottomSheet ? parentFragment : null;
                if (accountSettingsBottomSheet != null) {
                    accountSettingsBottomSheet.dismissAllowingStateLoss();
                }
                FragmentActivity activity = settingsMainFragment.getActivity();
                if (activity != null && (intent = activity.getIntent()) != null) {
                    intent.putExtra(MainActivity.EXTRA_FROM_LANGUAGE_SWITCH, true);
                }
                FragmentActivity activity2 = settingsMainFragment.getActivity();
                if (activity2 != null) {
                    activity2.recreate();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$14(SettingsMainFragment settingsMainFragment, View view) {
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_DEVICE_MANAGEMENT);
        settingsMainFragment.navigateTo(DeviceManagementFragment.INSTANCE.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$15(SettingsMainFragment settingsMainFragment, View view) {
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_CONNECTORS);
        settingsMainFragment.navigateTo(ConnectorsFragment.INSTANCE.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$17(final SettingsMainFragment settingsMainFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                SettingsMainFragment.onViewCreated$lambda$17$lambda$16(SettingsMainFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$17$lambda$16(SettingsMainFragment settingsMainFragment) {
        settingsMainFragment.navigateTo(PrivacyPermissionFragment.INSTANCE.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$18(SettingsMainFragment settingsMainFragment, View view) {
        SettingsTracker.INSTANCE.trackSettingsClick("notification");
        settingsMainFragment.showNotificationConfirmDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$19(View view) {
        AppUpdateChecker.INSTANCE.checkUpdate(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$21(final SettingsMainFragment settingsMainFragment, View view) {
        SettingsTracker.INSTANCE.trackSettingsClick(SettingsTracker.TYPE_ABOUT);
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                SettingsMainFragment.onViewCreated$lambda$21$lambda$20(SettingsMainFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$21$lambda$20(SettingsMainFragment settingsMainFragment) {
        settingsMainFragment.navigateTo(AboutFragment.INSTANCE.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$24(final SettingsMainFragment settingsMainFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                SettingsMainFragment.onViewCreated$lambda$24$lambda$23(SettingsMainFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$24$lambda$23(SettingsMainFragment settingsMainFragment) {
        settingsMainFragment.navigateTo(DebugSettingsFragment.INSTANCE.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$25(SettingsMainFragment settingsMainFragment, View view) {
        SettingsTracker.INSTANCE.trackLogoutClick();
        settingsMainFragment.showLogoutConfirmDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$26(SettingsMainFragment settingsMainFragment, View view) {
        settingsMainFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://beian.miit.gov.cn")));
    }

    public void onResume() {
        super.onResume();
        if (AppHost.INSTANCE.isDebug()) {
            String ppeEnv = DebugSettings.INSTANCE.getPpeEnv();
            TextView textView = this.tvDebugPpeValue;
            if (textView != null) {
                String str = ppeEnv;
                if (str.length() == 0) {
                    str = getString(C0820R.string.trae_setting_debug_ppe_env_not_set);
                    Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                }
                textView.setText(str);
            }
        }
    }

    private final void showNotificationConfirmDialog() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String string = getString(C0820R.string.trae_setting_notification_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0820R.string.trae_setting_notification_dialog_message);
        String string3 = getString(C0820R.string.trae_setting_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0820R.string.trae_setting_notification_dialog_confirm);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        new CustomConfirmDialog(context, new CustomConfirmDialog.Config(string, string2, null, null, string3, string4, null, 0.0f, null, null, null, null, 0, 0, 0, null, null, null, false, new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                Unit showNotificationConfirmDialog$lambda$28;
                showNotificationConfirmDialog$lambda$28 = SettingsMainFragment.showNotificationConfirmDialog$lambda$28((String) obj);
                return showNotificationConfirmDialog$lambda$28;
            }
        }, null, 1572812, null)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNotificationConfirmDialog$lambda$28(String str) {
        IPushService.Companion.openSystemNotificationSetting();
        return Unit.INSTANCE;
    }

    private final void showLogoutConfirmDialog() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String string = getString(C0820R.string.trae_setting_logout);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0820R.string.trae_setting_logout_confirm_message);
        String string3 = getString(C0820R.string.trae_setting_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0820R.string.trae_setting_ok);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        new CustomConfirmDialog(context, new CustomConfirmDialog.Config(string, string2, null, null, string3, string4, null, 0.0f, null, null, null, null, 0, 0, 0, null, null, null, false, new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                Unit showLogoutConfirmDialog$lambda$29;
                showLogoutConfirmDialog$lambda$29 = SettingsMainFragment.showLogoutConfirmDialog$lambda$29(SettingsMainFragment.this, (String) obj);
                return showLogoutConfirmDialog$lambda$29;
            }
        }, null, 1572812, null)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showLogoutConfirmDialog$lambda$29(SettingsMainFragment settingsMainFragment, String str) {
        settingsMainFragment.performLogout();
        return Unit.INSTANCE;
    }

    private final void performLogout() {
        DatabaseManager.INSTANCE.onUserLogout();
        final ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            return;
        }
        iLoginService.logout(false, new IAccountCallback() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$performLogout$1
            public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
            }

            public void onSuccess(LoginPlatform platform, String businessScene, Boolean isNewUserLogin) {
                SettingsMainFragment.this.dismissAfterLogout();
            }

            public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
                ILoginService iLoginService2 = iLoginService;
                final SettingsMainFragment settingsMainFragment = SettingsMainFragment.this;
                iLoginService2.logout(true, new IAccountCallback() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$performLogout$1$onFailed$1
                    public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
                    }

                    public void onSuccess(LoginPlatform platform2, String businessScene2, Boolean isNewUserLogin) {
                        SettingsMainFragment.this.dismissAfterLogout();
                    }

                    public void onFailed(LoginPlatform platform2, int errorCode2, String errorMessage2, String businessScene2, Throwable throwable2, String profileKey2, Integer originErrorCode2, String originErrorMessage2, Map<String, Object> ext2) {
                        SettingsMainFragment.this.dismissAfterLogout();
                    }
                }, AccountDef.LogoutScene.USER_LOGOUT);
            }
        }, AccountDef.LogoutScene.USER_LOGOUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissAfterLogout() {
        AccountSettingsBottomSheet parentFragment = getParentFragment();
        AccountSettingsBottomSheet accountSettingsBottomSheet = parentFragment instanceof AccountSettingsBottomSheet ? parentFragment : null;
        if (accountSettingsBottomSheet != null) {
            accountSettingsBottomSheet.dismissSafely();
        }
    }

    private final void showPopup(View anchorView, final String[] items, final Function1<? super String, Unit> onSelected) {
        final ListPopupWindow listPopupWindow = new ListPopupWindow(requireContext());
        listPopupWindow.setAnchorView(anchorView);
        listPopupWindow.setAdapter(new ArrayAdapter(requireContext(), C0820R.layout.item_popup_menu, C0820R.id.tv_popup_item, items));
        listPopupWindow.setWidth(getResources().getDimensionPixelSize(C0820R.dimen.trae_setting_popup_width));
        listPopupWindow.setModal(true);
        listPopupWindow.setBackgroundDrawable(getResources().getDrawable(C0820R.drawable.bg_popup_language, null));
        listPopupWindow.setHorizontalOffset(anchorView.getWidth() - listPopupWindow.getWidth());
        listPopupWindow.setVerticalOffset(0);
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.trae.home.solo.setting.SettingsMainFragment$$ExternalSyntheticLambda16
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                SettingsMainFragment.showPopup$lambda$30(onSelected, items, listPopupWindow, adapterView, view, i, j);
            }
        });
        listPopupWindow.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopup$lambda$30(Function1 function1, String[] strArr, ListPopupWindow listPopupWindow, AdapterView adapterView, View view, int i, long j) {
        String str = strArr[i];
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        function1.invoke(str);
        listPopupWindow.dismiss();
    }

    private final String getLanguageDisplayName(String languageCode) {
        if (Intrinsics.areEqual(languageCode, "zh")) {
            String string = getString(C0820R.string.trae_setting_lang_chinese);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (Intrinsics.areEqual(languageCode, "ja")) {
            String string2 = getString(C0820R.string.trae_setting_lang_japanese);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        String string3 = getString(C0820R.string.trae_setting_lang_english);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    private final void navigateTo(Fragment fragment) {
        getParentFragmentManager().beginTransaction().setCustomAnimations(C0820R.anim.trae_slide_in_right, C0820R.anim.trae_slide_out_left, C0820R.anim.trae_slide_in_left, C0820R.anim.trae_slide_out_right).replace(C0820R.id.settings_fragment_container, fragment).addToBackStack((String) null).commit();
    }

    private final String getSaaSProductTypeLabel(int productType) {
        int i;
        if (productType == SaaSProductType.TeamGroup.getValue() || productType == SaaSProductType.TeamGroupV2.getValue()) {
            i = C0820R.string.trae_setting_saas_team_group_badge;
        } else if (productType == SaaSProductType.TeamFlagship.getValue() || productType == SaaSProductType.TeamFlagshipV2.getValue()) {
            i = C0820R.string.trae_setting_saas_team_flagship_badge;
        } else {
            i = C0820R.string.trae_setting_saas_team_flagship_badge;
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final void renderCNIdentityBadge(CNIdentityBadgePresentation presentation, TextView tvTierBadge, TextView tvFreeBadge, ImageView imgIdentity) {
        tvTierBadge.setVisibility(8);
        tvFreeBadge.setVisibility(8);
        imgIdentity.setVisibility(8);
        if (Intrinsics.areEqual(presentation, CNIdentityBadgePresentation.Hidden.INSTANCE)) {
            return;
        }
        if (presentation instanceof CNIdentityBadgePresentation.Free) {
            tvFreeBadge.setText(((CNIdentityBadgePresentation.Free) presentation).getLabel());
            tvFreeBadge.setVisibility(0);
        } else {
            if (!(presentation instanceof CNIdentityBadgePresentation.Tier)) {
                throw new NoWhenBranchMatchedException();
            }
            tvTierBadge.setText(((CNIdentityBadgePresentation.Tier) presentation).getLabel());
            tvTierBadge.setVisibility(0);
        }
    }

    /* compiled from: SettingsMainFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingsMainFragment newInstance() {
            return new SettingsMainFragment();
        }
    }
}
