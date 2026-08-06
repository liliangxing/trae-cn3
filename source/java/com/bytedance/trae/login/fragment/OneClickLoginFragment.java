package com.bytedance.trae.login.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.trae.common.fragment.TraceFragment;
import com.bytedance.trae.common.widget.UrlSpanTextView;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.DeviceOverLimitDialog;
import com.bytedance.trae.login.PhoneOneKeyPlatform;
import com.bytedance.trae.login.activity.AgreementDialog;
import com.bytedance.trae.login.databinding.TraeFragmentOneClickLoginBinding;
import com.bytedance.trae.login.fragment.OneClickLoginViewModel;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.ListDevicesResult;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.AgreementUrlOpener;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* compiled from: OneClickLoginFragment.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0016\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0016J\b\u0010!\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010(\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\b\u0010)\u001a\u00020\u0013H\u0002J+\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010$¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0013J$\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u0002042\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u000207\u0018\u000106J\b\u00108\u001a\u00020\u0013H\u0016J\b\u00109\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;", "Lcom/bytedance/trae/common/fragment/TraceFragment;", "Lcom/bytedance/trae/login/fragment/BytecloudSsoHost;", "<init>", "()V", "_binding", "Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;", "binding", "getBinding", "()Lcom/bytedance/trae/login/databinding/TraeFragmentOneClickLoginBinding;", "viewModel", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;", "getViewModel", "()Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "callback", "Lcom/bytedance/trae/login/fragment/OneClickLoginCallback;", "setOneClickLoginCallback", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showBytecloudSso", "onSsoClick", "Lkotlin/Function0;", "setupViews", "openUrl", "url", "", "getCarrierAgreementUrl", "carrier", "Lcom/bytedance/trae/login/PhoneOneKeyPlatform;", "getCarrierAgreementName", "observeViewModel", "notifyLoginResult", "success", "", "errorCode", "", "errorMessage", "(ZLjava/lang/Integer;Ljava/lang/String;)V", "resetLoginLoadingState", "notifyDeviceOffline", "result", "Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", "map", "", "Ljava/lang/Object;", "onDestroyView", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class OneClickLoginFragment extends TraceFragment implements BytecloudSsoHost {
    private static final String ARG_CARRIER = "arg_carrier";
    private static final String ARG_MASKED_PHONE = "arg_masked_phone";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String URL_CARRIER_MOBILE = "https://wap.cmpassport.com/resources/html/contract.html";
    private static final String URL_CARRIER_TELECOM = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
    private static final String URL_CARRIER_UNICOM = "https://msv6.wosms.cn/html/oauth/protocol2.html";
    private TraeFragmentOneClickLoginBinding _binding;
    private OneClickLoginCallback callback;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: OneClickLoginFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PhoneOneKeyPlatform.values().length];
            try {
                iArr[PhoneOneKeyPlatform.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PhoneOneKeyPlatform.UNICOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PhoneOneKeyPlatform.TELECOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean autoLogEnterPage() {
        return false;
    }

    @Override // com.bytedance.trae.login.fragment.BytecloudSsoHost
    public void showBytecloudSso(Function0<Unit> onSsoClick) {
        Intrinsics.checkNotNullParameter(onSsoClick, "onSsoClick");
    }

    public OneClickLoginFragment() {
        final Fragment fragment = (Fragment) this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m942invoke() {
                return fragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OneClickLoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m943invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory m944invoke() {
                Object invoke = function0.invoke();
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = invoke instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) invoke : null;
                ViewModelProvider.Factory defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* compiled from: OneClickLoginFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$Companion;", "", "<init>", "()V", "ARG_MASKED_PHONE", "", "ARG_CARRIER", "URL_CARRIER_MOBILE", "URL_CARRIER_UNICOM", "URL_CARRIER_TELECOM", "newInstance", "Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;", "maskedPhone", "carrier", "Lcom/bytedance/trae/login/PhoneOneKeyPlatform;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OneClickLoginFragment newInstance(String maskedPhone, PhoneOneKeyPlatform carrier) {
            Intrinsics.checkNotNullParameter(maskedPhone, "maskedPhone");
            OneClickLoginFragment oneClickLoginFragment = new OneClickLoginFragment();
            Bundle bundle = new Bundle();
            bundle.putString(OneClickLoginFragment.ARG_MASKED_PHONE, maskedPhone);
            bundle.putString(OneClickLoginFragment.ARG_CARRIER, carrier != null ? carrier.name() : null);
            oneClickLoginFragment.setArguments(bundle);
            return oneClickLoginFragment;
        }
    }

    /* renamed from: getBinding, reason: from getter */
    private final TraeFragmentOneClickLoginBinding get_binding() {
        return this._binding;
    }

    private final OneClickLoginViewModel getViewModel() {
        return (OneClickLoginViewModel) this.viewModel.getValue();
    }

    public final void setOneClickLoginCallback(OneClickLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        TraeFragmentOneClickLoginBinding inflate = TraeFragmentOneClickLoginBinding.inflate(inflater, container, false);
        this._binding = inflate;
        return inflate != null ? inflate.getRoot() : null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViews();
        observeViewModel();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_MASKED_PHONE) : null;
        if (string == null) {
            string = "";
        }
        getViewModel().init(string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupViews() {
        String string;
        Button button;
        ImageView imageView;
        TextView textView;
        UrlSpanTextView urlSpanTextView;
        UrlSpanTextView urlSpanTextView2;
        String string2;
        PhoneOneKeyPlatform phoneOneKeyPlatform;
        Bundle arguments = getArguments();
        if (arguments != null && (string2 = arguments.getString(ARG_CARRIER)) != null) {
            try {
                Result.Companion companion = Result.Companion;
                OneClickLoginFragment oneClickLoginFragment = this;
                phoneOneKeyPlatform = Result.constructor-impl(PhoneOneKeyPlatform.valueOf(string2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                phoneOneKeyPlatform = Result.constructor-impl(ResultKt.createFailure(th));
            }
            r1 = Result.isFailure-impl(phoneOneKeyPlatform) ? null : phoneOneKeyPlatform;
        }
        final String carrierAgreementUrl = getCarrierAgreementUrl(r1);
        if (carrierAgreementUrl != null) {
            string = getString(C0882R.string.login_agreement_with_carrier, new Object[]{getCarrierAgreementName(r1)});
        } else {
            string = getString(C0882R.string.login_agreement);
        }
        Intrinsics.checkNotNull(string);
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding = get_binding();
        if (traeFragmentOneClickLoginBinding != null && (urlSpanTextView2 = traeFragmentOneClickLoginBinding.privacyPolicyText) != null) {
            urlSpanTextView2.setUrlSpannedText(string);
        }
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding2 = get_binding();
        if (traeFragmentOneClickLoginBinding2 != null && (urlSpanTextView = traeFragmentOneClickLoginBinding2.privacyPolicyText) != null) {
            urlSpanTextView.setOnClickListener(new UrlSpanTextView.OnClickListener() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$setupViews$1
                public void onUrlClick(String url) {
                    String str;
                    Intrinsics.checkNotNullParameter(url, "url");
                    switch (url.hashCode()) {
                        case 3598498:
                            if (url.equals("url1")) {
                                this.openUrl("https://www.trae.cn/terms-of-service");
                                return;
                            }
                            return;
                        case 3598499:
                            if (url.equals("url2")) {
                                this.openUrl("https://www.trae.cn/privacy-policy");
                                return;
                            }
                            return;
                        case 263416872:
                            if (!url.equals("url_carrier") || (str = carrierAgreementUrl) == null) {
                                return;
                            }
                            this.openUrl(str);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding3 = get_binding();
        if (traeFragmentOneClickLoginBinding3 != null && (textView = traeFragmentOneClickLoginBinding3.tvSwitch) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneClickLoginFragment.setupViews$lambda$2(OneClickLoginFragment.this, view);
                }
            });
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding4 = get_binding();
        if (traeFragmentOneClickLoginBinding4 != null && (imageView = traeFragmentOneClickLoginBinding4.ivAgreementCheck) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OneClickLoginFragment.setupViews$lambda$3(booleanRef, this, view);
                }
            });
        }
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding5 = get_binding();
        if (traeFragmentOneClickLoginBinding5 == null || (button = traeFragmentOneClickLoginBinding5.btnOneClickLogin) == null) {
            return;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OneClickLoginFragment.setupViews$lambda$6(booleanRef, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$2(OneClickLoginFragment oneClickLoginFragment, View view) {
        OneClickLoginCallback oneClickLoginCallback = oneClickLoginFragment.callback;
        if (oneClickLoginCallback != null) {
            oneClickLoginCallback.onSwitchAccount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$3(Ref.BooleanRef booleanRef, OneClickLoginFragment oneClickLoginFragment, View view) {
        ImageView imageView;
        ImageView imageView2;
        booleanRef.element = !booleanRef.element;
        if (booleanRef.element) {
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding != null && (imageView2 = traeFragmentOneClickLoginBinding.ivAgreementCheck) != null) {
                imageView2.setImageResource(C0820R.drawable.trae_ic_checkmark_circle_filled);
            }
        } else {
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding2 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding2 != null && (imageView = traeFragmentOneClickLoginBinding2.ivAgreementCheck) != null) {
                imageView.setImageResource(C0820R.drawable.trae_ic_checkmark_circle_unchecked);
            }
        }
        oneClickLoginFragment.getViewModel().onAgreementCheckedChanged(booleanRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$6(final Ref.BooleanRef booleanRef, final OneClickLoginFragment oneClickLoginFragment, View view) {
        LoginTracker.INSTANCE.trackLoginClick("phone_oneclick");
        if (!booleanRef.element) {
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_DIALOG_SHOWN, TraeAuthManager.PLATFORM_ONE_CLICK, null, null, null, null, null, null, null, null, null, 2044, null);
            Context requireContext = oneClickLoginFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            new AgreementDialog(requireContext, new Function0() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit unit;
                    unit = OneClickLoginFragment.setupViews$lambda$6$lambda$4(booleanRef, oneClickLoginFragment);
                    return unit;
                }
            }, new Function0() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit unit;
                    unit = OneClickLoginFragment.setupViews$lambda$6$lambda$5();
                    return unit;
                }
            }).show();
            return;
        }
        oneClickLoginFragment.getViewModel().onOneClickLogin();
        OneClickLoginCallback oneClickLoginCallback = oneClickLoginFragment.callback;
        if (oneClickLoginCallback != null) {
            oneClickLoginCallback.onOneClickLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViews$lambda$6$lambda$4(Ref.BooleanRef booleanRef, OneClickLoginFragment oneClickLoginFragment) {
        ImageView imageView;
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_ACCEPTED, TraeAuthManager.PLATFORM_ONE_CLICK, null, null, null, null, null, null, null, null, null, 2044, null);
        booleanRef.element = true;
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding = oneClickLoginFragment.get_binding();
        if (traeFragmentOneClickLoginBinding != null && (imageView = traeFragmentOneClickLoginBinding.ivAgreementCheck) != null) {
            imageView.setImageResource(C0820R.drawable.trae_ic_checkmark_circle_filled);
        }
        oneClickLoginFragment.getViewModel().onAgreementCheckedChanged(true);
        oneClickLoginFragment.getViewModel().onOneClickLogin();
        OneClickLoginCallback oneClickLoginCallback = oneClickLoginFragment.callback;
        if (oneClickLoginCallback != null) {
            oneClickLoginCallback.onOneClickLogin();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViews$lambda$6$lambda$5() {
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_REJECTED, TraeAuthManager.PLATFORM_ONE_CLICK, null, null, null, null, null, null, null, null, null, 2044, null);
        return Unit.INSTANCE;
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

    private final String getCarrierAgreementUrl(PhoneOneKeyPlatform carrier) {
        int i = carrier == null ? -1 : WhenMappings.$EnumSwitchMapping$0[carrier.ordinal()];
        if (i == 1) {
            return URL_CARRIER_MOBILE;
        }
        if (i == 2) {
            return URL_CARRIER_UNICOM;
        }
        if (i != 3) {
            return null;
        }
        return URL_CARRIER_TELECOM;
    }

    private final String getCarrierAgreementName(PhoneOneKeyPlatform carrier) {
        int i;
        int i2 = carrier == null ? -1 : WhenMappings.$EnumSwitchMapping$0[carrier.ordinal()];
        if (i2 == 1) {
            i = C0882R.string.trae_carrier_agreement_mobile;
        } else if (i2 == 2) {
            i = C0882R.string.trae_carrier_agreement_unicom;
        } else if (i2 == 3) {
            i = C0882R.string.trae_carrier_agreement_telecom;
        } else {
            i = C0882R.string.trae_carrier_agreement_mobile;
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final void observeViewModel() {
        getViewModel().getMaskedPhone().observe(getViewLifecycleOwner(), new OneClickLoginFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$7;
                observeViewModel$lambda$7 = OneClickLoginFragment.observeViewModel$lambda$7(OneClickLoginFragment.this, (String) obj);
                return observeViewModel$lambda$7;
            }
        }));
        getViewModel().getLoginState().observe(getViewLifecycleOwner(), new OneClickLoginFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$8;
                observeViewModel$lambda$8 = OneClickLoginFragment.observeViewModel$lambda$8(OneClickLoginFragment.this, (OneClickLoginViewModel.LoginState) obj);
                return observeViewModel$lambda$8;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$7(OneClickLoginFragment oneClickLoginFragment, String str) {
        TextView textView;
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding = oneClickLoginFragment.get_binding();
        if (traeFragmentOneClickLoginBinding != null && (textView = traeFragmentOneClickLoginBinding.tvMaskedPhone) != null) {
            textView.setText(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$8(OneClickLoginFragment oneClickLoginFragment, OneClickLoginViewModel.LoginState loginState) {
        ProgressBar progressBar;
        Button button;
        Button button2;
        ProgressBar progressBar2;
        Button button3;
        Button button4;
        ProgressBar progressBar3;
        Button button5;
        Button button6;
        if (loginState instanceof OneClickLoginViewModel.LoginState.Idle) {
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding != null && (button6 = traeFragmentOneClickLoginBinding.btnOneClickLogin) != null) {
                button6.setEnabled(true);
            }
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding2 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding2 != null && (button5 = traeFragmentOneClickLoginBinding2.btnOneClickLogin) != null) {
                button5.setText(oneClickLoginFragment.getString(C0882R.string.trae_one_click_login));
            }
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding3 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding3 != null && (progressBar3 = traeFragmentOneClickLoginBinding3.pbLoading) != null) {
                progressBar3.setVisibility(8);
            }
        } else if (loginState instanceof OneClickLoginViewModel.LoginState.Loading) {
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding4 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding4 != null && (button4 = traeFragmentOneClickLoginBinding4.btnOneClickLogin) != null) {
                button4.setEnabled(false);
            }
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding5 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding5 != null && (button3 = traeFragmentOneClickLoginBinding5.btnOneClickLogin) != null) {
                button3.setText("");
            }
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding6 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding6 != null && (progressBar2 = traeFragmentOneClickLoginBinding6.pbLoading) != null) {
                progressBar2.setVisibility(0);
            }
        } else if (loginState instanceof OneClickLoginViewModel.LoginState.Success) {
            OneClickLoginCallback oneClickLoginCallback = oneClickLoginFragment.callback;
            if (oneClickLoginCallback != null) {
                oneClickLoginCallback.onLoginSuccess();
            }
        } else {
            if (!(loginState instanceof OneClickLoginViewModel.LoginState.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding7 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding7 != null && (button2 = traeFragmentOneClickLoginBinding7.btnOneClickLogin) != null) {
                button2.setEnabled(true);
            }
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding8 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding8 != null && (button = traeFragmentOneClickLoginBinding8.btnOneClickLogin) != null) {
                button.setText(oneClickLoginFragment.getString(C0882R.string.trae_one_click_login));
            }
            TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding9 = oneClickLoginFragment.get_binding();
            if (traeFragmentOneClickLoginBinding9 != null && (progressBar = traeFragmentOneClickLoginBinding9.pbLoading) != null) {
                progressBar.setVisibility(8);
            }
            Context requireContext = oneClickLoginFragment.requireContext();
            String errorMessage = ((OneClickLoginViewModel.LoginState.Error) loginState).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = oneClickLoginFragment.getString(C0882R.string.trae_one_click_login_failed);
                Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
            }
            Toast.makeText(requireContext, errorMessage, 0).show();
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void notifyLoginResult$default(OneClickLoginFragment oneClickLoginFragment, boolean z, Integer num, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        oneClickLoginFragment.notifyLoginResult(z, num, str);
    }

    public final void notifyLoginResult(boolean success, Integer errorCode, String errorMessage) {
        getViewModel().onLoginResult(success, errorCode, errorMessage);
    }

    public final void resetLoginLoadingState() {
        getViewModel().resetToIdle();
    }

    public final void notifyDeviceOffline(ListDevicesResult result, final Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(result, "result");
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        DeviceOverLimitDialog.INSTANCE.show(activity, result, DeviceOverLimitDialog.Scene.LOGIN, new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.fragment.OneClickLoginFragment$$ExternalSyntheticLambda4
            @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
            public final void onResult(boolean z) {
                OneClickLoginFragment.notifyDeviceOffline$lambda$9(OneClickLoginFragment.this, map, activity, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyDeviceOffline$lambda$9(OneClickLoginFragment oneClickLoginFragment, Map map, FragmentActivity fragmentActivity, boolean z) {
        ProgressBar progressBar;
        Button button;
        Button button2;
        if (z) {
            oneClickLoginFragment.getViewModel().onDeviceLimitLoginContinue();
            OneClickLoginCallback oneClickLoginCallback = oneClickLoginFragment.callback;
            if (oneClickLoginCallback != null) {
                oneClickLoginCallback.onDeviceLimitLoginContinue(map, TraeAuthManager.PLATFORM_ONE_CLICK);
                return;
            }
            return;
        }
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding = oneClickLoginFragment.get_binding();
        if (traeFragmentOneClickLoginBinding != null && (button2 = traeFragmentOneClickLoginBinding.btnOneClickLogin) != null) {
            button2.setEnabled(true);
        }
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding2 = oneClickLoginFragment.get_binding();
        if (traeFragmentOneClickLoginBinding2 != null && (button = traeFragmentOneClickLoginBinding2.btnOneClickLogin) != null) {
            button.setText(oneClickLoginFragment.getString(C0882R.string.trae_one_click_login));
        }
        TraeFragmentOneClickLoginBinding traeFragmentOneClickLoginBinding3 = oneClickLoginFragment.get_binding();
        if (traeFragmentOneClickLoginBinding3 != null && (progressBar = traeFragmentOneClickLoginBinding3.pbLoading) != null) {
            progressBar.setVisibility(8);
        }
        Toast.makeText((Context) fragmentActivity, oneClickLoginFragment.getString(C0882R.string.trae_device_over_limit), 0).show();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
