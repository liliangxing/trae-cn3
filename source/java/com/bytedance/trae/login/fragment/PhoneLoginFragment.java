package com.bytedance.trae.login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.trae.common.fragment.TraceFragment;
import com.bytedance.trae.common.widget.UrlSpanTextView;
import com.bytedance.trae.login.activity.AccountLoginActivity;
import com.bytedance.trae.login.activity.AgreementDialog;
import com.bytedance.trae.login.activity.VerifyCodeActivity;
import com.bytedance.trae.login.databinding.TraeFragmentLoginPhoneBinding;
import com.bytedance.trae.login.fragment.PhoneLoginViewModel;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.AgreementUrlOpener;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: PhoneLoginFragment.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;", "Lcom/bytedance/trae/common/fragment/TraceFragment;", "<init>", "()V", "_binding", "Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;", "binding", "getBinding", "()Lcom/bytedance/trae/login/databinding/TraeFragmentLoginPhoneBinding;", "viewModel", "Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;", "getViewModel", "()Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "isAgreementChecked", "", "onViewCreated", "", "view", "setupViews", "doSendCode", "updateClearButtonVisibility", TraeAuthManager.PLATFORM_PHONE, "", "observeViewModel", "onDestroyView", "openUrl", "url", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneLoginFragment extends TraceFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MainlandLoginFragment";
    private TraeFragmentLoginPhoneBinding _binding;
    private boolean isAgreementChecked;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public boolean autoLogEnterPage() {
        return false;
    }

    public PhoneLoginFragment() {
        final Fragment fragment = (Fragment) this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m948invoke() {
                return fragment;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(PhoneLoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m949invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory m950invoke() {
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

    /* compiled from: PhoneLoginFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PhoneLoginFragment newInstance() {
            return new PhoneLoginFragment();
        }
    }

    /* renamed from: getBinding, reason: from getter */
    private final TraeFragmentLoginPhoneBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhoneLoginViewModel getViewModel() {
        return (PhoneLoginViewModel) this.viewModel.getValue();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        TraeFragmentLoginPhoneBinding inflate = TraeFragmentLoginPhoneBinding.inflate(inflater, container, false);
        this._binding = inflate;
        return inflate != null ? inflate.getRoot() : null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        final EditText editText;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AccountLoginActivity activity = getActivity();
        AccountLoginActivity accountLoginActivity = activity instanceof AccountLoginActivity ? activity : null;
        this.isAgreementChecked = accountLoginActivity != null ? accountLoginActivity.isPhoneLoginAgreementChecked() : false;
        setupViews();
        observeViewModel();
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding = get_binding();
        if (traeFragmentLoginPhoneBinding == null || (editText = traeFragmentLoginPhoneBinding.etPhone) == null) {
            return;
        }
        editText.requestFocus();
        editText.post(new Runnable() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                PhoneLoginFragment.onViewCreated$lambda$1$lambda$0(PhoneLoginFragment.this, editText);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(PhoneLoginFragment phoneLoginFragment, EditText editText) {
        Object systemService = phoneLoginFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    private final void setupViews() {
        Button button;
        ImageView imageView;
        EditText editText;
        EditText editText2;
        Button button2;
        Button button3;
        UrlSpanTextView urlSpanTextView;
        UrlSpanTextView urlSpanTextView2;
        CheckBox checkBox;
        CheckBox checkBox2;
        ImageView imageView2;
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding = get_binding();
        if (traeFragmentLoginPhoneBinding != null && (imageView2 = traeFragmentLoginPhoneBinding.btnBack) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhoneLoginFragment.setupViews$lambda$2(PhoneLoginFragment.this, view);
                }
            });
        }
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding2 = get_binding();
        if (traeFragmentLoginPhoneBinding2 != null && (checkBox2 = traeFragmentLoginPhoneBinding2.cbAgreement) != null) {
            checkBox2.setChecked(this.isAgreementChecked);
        }
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding3 = get_binding();
        if (traeFragmentLoginPhoneBinding3 != null && (checkBox = traeFragmentLoginPhoneBinding3.cbAgreement) != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PhoneLoginFragment.this.isAgreementChecked = z;
                }
            });
        }
        String string = getString(C0882R.string.login_agreement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding4 = get_binding();
        if (traeFragmentLoginPhoneBinding4 != null && (urlSpanTextView2 = traeFragmentLoginPhoneBinding4.privacyPolicyText) != null) {
            urlSpanTextView2.setUrlSpannedText(string);
        }
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding5 = get_binding();
        if (traeFragmentLoginPhoneBinding5 != null && (urlSpanTextView = traeFragmentLoginPhoneBinding5.privacyPolicyText) != null) {
            urlSpanTextView.setOnClickListener(new UrlSpanTextView.OnClickListener() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$setupViews$3
                public void onUrlClick(String url) {
                    Intrinsics.checkNotNullParameter(url, "url");
                    if (Intrinsics.areEqual(url, "url1")) {
                        PhoneLoginFragment.this.openUrl("https://www.trae.cn/terms-of-service");
                    } else if (Intrinsics.areEqual(url, "url2")) {
                        PhoneLoginFragment.this.openUrl("https://www.trae.cn/privacy-policy");
                    }
                }
            });
        }
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding6 = get_binding();
        if (traeFragmentLoginPhoneBinding6 != null && (button3 = traeFragmentLoginPhoneBinding6.btnGetCode) != null) {
            button3.setText(getString(C0882R.string.trae_login_get_code));
        }
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding7 = get_binding();
        if (traeFragmentLoginPhoneBinding7 != null && (button2 = traeFragmentLoginPhoneBinding7.btnGetCode) != null) {
            button2.setEnabled(false);
        }
        InputFilter inputFilter = new InputFilter() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda4
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                CharSequence charSequence2;
                charSequence2 = PhoneLoginFragment.setupViews$lambda$4(charSequence, i, i2, spanned, i3, i4);
                return charSequence2;
            }
        };
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding8 = get_binding();
        if (traeFragmentLoginPhoneBinding8 != null && (editText2 = traeFragmentLoginPhoneBinding8.etPhone) != null) {
            editText2.setFilters(new InputFilter[]{inputFilter, new InputFilter.LengthFilter(11)});
        }
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding9 = get_binding();
        if (traeFragmentLoginPhoneBinding9 != null && (editText = traeFragmentLoginPhoneBinding9.etPhone) != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$setupViews$4
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    PhoneLoginViewModel viewModel;
                    String obj = s != null ? s.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    viewModel = PhoneLoginFragment.this.getViewModel();
                    viewModel.onPhoneNumberChanged(obj);
                    PhoneLoginFragment.this.updateClearButtonVisibility(obj);
                }
            });
        }
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding10 = get_binding();
        if (traeFragmentLoginPhoneBinding10 != null && (imageView = traeFragmentLoginPhoneBinding10.ivClear) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhoneLoginFragment.setupViews$lambda$5(PhoneLoginFragment.this, view);
                }
            });
        }
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding11 = get_binding();
        if (traeFragmentLoginPhoneBinding11 == null || (button = traeFragmentLoginPhoneBinding11.btnGetCode) == null) {
            return;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneLoginFragment.setupViews$lambda$8(PhoneLoginFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$2(PhoneLoginFragment phoneLoginFragment, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        FragmentActivity activity = phoneLoginFragment.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence setupViews$lambda$4(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = i; i5 < i2; i5++) {
            if (Character.isDigit(charSequence.charAt(i5))) {
                sb.append(charSequence.charAt(i5));
            }
        }
        if (sb.length() == i2 - i) {
            return null;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$5(PhoneLoginFragment phoneLoginFragment, View view) {
        EditText editText;
        Editable text;
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding = phoneLoginFragment.get_binding();
        if (traeFragmentLoginPhoneBinding == null || (editText = traeFragmentLoginPhoneBinding.etPhone) == null || (text = editText.getText()) == null) {
            return;
        }
        text.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$8(final PhoneLoginFragment phoneLoginFragment, View view) {
        if (!phoneLoginFragment.isAgreementChecked) {
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_DIALOG_SHOWN, TraeAuthManager.PLATFORM_PHONE, null, null, null, null, null, null, null, null, null, 2044, null);
            Context requireContext = phoneLoginFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            new AgreementDialog(requireContext, new Function0() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = PhoneLoginFragment.setupViews$lambda$8$lambda$6(PhoneLoginFragment.this);
                    return unit;
                }
            }, new Function0() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit unit;
                    unit = PhoneLoginFragment.setupViews$lambda$8$lambda$7();
                    return unit;
                }
            }).show();
            return;
        }
        phoneLoginFragment.doSendCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViews$lambda$8$lambda$6(PhoneLoginFragment phoneLoginFragment) {
        CheckBox checkBox;
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_ACCEPTED, TraeAuthManager.PLATFORM_PHONE, null, null, null, null, null, null, null, null, null, 2044, null);
        phoneLoginFragment.isAgreementChecked = true;
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding = phoneLoginFragment.get_binding();
        if (traeFragmentLoginPhoneBinding != null && (checkBox = traeFragmentLoginPhoneBinding.cbAgreement) != null) {
            checkBox.setChecked(true);
        }
        phoneLoginFragment.doSendCode();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViews$lambda$8$lambda$7() {
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_AGREEMENT_REJECTED, TraeAuthManager.PLATFORM_PHONE, null, null, null, null, null, null, null, null, null, 2044, null);
        return Unit.INSTANCE;
    }

    private final void doSendCode() {
        LoginTracker.INSTANCE.trackLoginClick(TraeAuthManager.PLATFORM_PHONE);
        AccountLoginActivity activity = getActivity();
        AccountLoginActivity accountLoginActivity = activity instanceof AccountLoginActivity ? activity : null;
        if (accountLoginActivity != null) {
            accountLoginActivity.notifyLoginClicked(TraeAuthManager.PLATFORM_PHONE);
        }
        getViewModel().sendVerificationCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateClearButtonVisibility(String phone) {
        ImageView imageView;
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding = get_binding();
        if (traeFragmentLoginPhoneBinding == null || (imageView = traeFragmentLoginPhoneBinding.ivClear) == null) {
            return;
        }
        imageView.setVisibility(phone.length() > 0 ? 0 : 8);
    }

    private final void observeViewModel() {
        getViewModel().isButtonEnabled().observe(getViewLifecycleOwner(), new PhoneLoginFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$9;
                observeViewModel$lambda$9 = PhoneLoginFragment.observeViewModel$lambda$9(PhoneLoginFragment.this, (Boolean) obj);
                return observeViewModel$lambda$9;
            }
        }));
        getViewModel().getSendCodeState().observe(getViewLifecycleOwner(), new PhoneLoginFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.fragment.PhoneLoginFragment$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$10;
                observeViewModel$lambda$10 = PhoneLoginFragment.observeViewModel$lambda$10(PhoneLoginFragment.this, (PhoneLoginViewModel.SendCodeState) obj);
                return observeViewModel$lambda$10;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$9(PhoneLoginFragment phoneLoginFragment, Boolean bool) {
        Button button;
        TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding = phoneLoginFragment.get_binding();
        if (traeFragmentLoginPhoneBinding != null && (button = traeFragmentLoginPhoneBinding.btnGetCode) != null) {
            Intrinsics.checkNotNull(bool);
            button.setEnabled(bool.booleanValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$10(PhoneLoginFragment phoneLoginFragment, PhoneLoginViewModel.SendCodeState sendCodeState) {
        ProgressBar progressBar;
        Button button;
        Button button2;
        ProgressBar progressBar2;
        Button button3;
        Button button4;
        ProgressBar progressBar3;
        Button button5;
        Button button6;
        if (sendCodeState instanceof PhoneLoginViewModel.SendCodeState.Loading) {
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding != null && (button6 = traeFragmentLoginPhoneBinding.btnGetCode) != null) {
                button6.setEnabled(false);
            }
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding2 = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding2 != null && (button5 = traeFragmentLoginPhoneBinding2.btnGetCode) != null) {
                button5.setText("");
            }
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding3 = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding3 != null && (progressBar3 = traeFragmentLoginPhoneBinding3.pbLoading) != null) {
                progressBar3.setVisibility(0);
            }
        } else if (sendCodeState instanceof PhoneLoginViewModel.SendCodeState.Success) {
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding4 = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding4 != null && (button4 = traeFragmentLoginPhoneBinding4.btnGetCode) != null) {
                button4.setEnabled(true);
            }
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding5 = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding5 != null && (button3 = traeFragmentLoginPhoneBinding5.btnGetCode) != null) {
                button3.setText(phoneLoginFragment.getString(C0882R.string.trae_login_get_code));
            }
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding6 = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding6 != null && (progressBar2 = traeFragmentLoginPhoneBinding6.pbLoading) != null) {
                progressBar2.setVisibility(8);
            }
            Toast.makeText(phoneLoginFragment.requireContext(), C0882R.string.trae_login_send_success, 0).show();
            String str = (String) phoneLoginFragment.getViewModel().getPhoneNumber().getValue();
            String str2 = str != null ? str : "";
            AccountLoginActivity activity = phoneLoginFragment.getActivity();
            AccountLoginActivity accountLoginActivity = activity instanceof AccountLoginActivity ? activity : null;
            if (accountLoginActivity != null) {
                accountLoginActivity.notifyVerifyCodeNavigation();
            }
            VerifyCodeActivity.Companion companion = VerifyCodeActivity.INSTANCE;
            Context requireContext = phoneLoginFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.start(requireContext, str2);
        } else {
            if (!(sendCodeState instanceof PhoneLoginViewModel.SendCodeState.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding7 = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding7 != null && (button2 = traeFragmentLoginPhoneBinding7.btnGetCode) != null) {
                button2.setEnabled(true);
            }
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding8 = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding8 != null && (button = traeFragmentLoginPhoneBinding8.btnGetCode) != null) {
                button.setText(phoneLoginFragment.getString(C0882R.string.trae_login_get_code));
            }
            TraeFragmentLoginPhoneBinding traeFragmentLoginPhoneBinding9 = phoneLoginFragment.get_binding();
            if (traeFragmentLoginPhoneBinding9 != null && (progressBar = traeFragmentLoginPhoneBinding9.pbLoading) != null) {
                progressBar.setVisibility(8);
            }
            Context requireContext2 = phoneLoginFragment.requireContext();
            String errorMessage = ((PhoneLoginViewModel.SendCodeState.Error) sendCodeState).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = phoneLoginFragment.getString(C0882R.string.trae_login_send_failed);
                Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
            }
            Toast.makeText(requireContext2, errorMessage, 0).show();
        }
        return Unit.INSTANCE;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(String url) {
        try {
            AgreementUrlOpener agreementUrlOpener = AgreementUrlOpener.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            agreementUrlOpener.open(requireContext, url);
        } catch (Exception unused) {
        }
    }
}
