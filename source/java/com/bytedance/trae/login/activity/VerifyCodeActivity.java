package com.bytedance.trae.login.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.DeletionPendingDialogHelper;
import com.bytedance.trae.login.DeviceOverLimitDialog;
import com.bytedance.trae.login.databinding.TraeActivityVerifyCodeBinding;
import com.bytedance.trae.login.fragment.VerifyCodeViewModel;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: VerifyCodeActivity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/login/activity/VerifyCodeActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;", "viewModel", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;", "getViewModel", "()Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", "observeViewModel", "navigateToMainActivity", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VerifyCodeActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_PHONE_NUMBER = "extra_phone_number";
    private TraeActivityVerifyCodeBinding binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: com_bytedance_trae_login_activity_VerifyCodeActivity__onStop$___twin___ */
    public void m404xbc34ebf7() {
        super.onStop();
    }

    protected void onStop() {
        m403x2803c464(this);
    }

    public VerifyCodeActivity() {
        final ComponentActivity componentActivity = (ComponentActivity) this;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(VerifyCodeViewModel.class), new Function0<ViewModelStore>() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore m908invoke() {
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory m907invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        });
    }

    /* compiled from: VerifyCodeActivity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/login/activity/VerifyCodeActivity$Companion;", "", "<init>", "()V", "EXTRA_PHONE_NUMBER", "", TraeAuthManager.STAGE_START, "", "context", "Landroid/content/Context;", "phoneNumber", "createIntent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String phoneNumber) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            Intent intent = new Intent(context, (Class<?>) VerifyCodeActivity.class);
            intent.putExtra(VerifyCodeActivity.EXTRA_PHONE_NUMBER, phoneNumber);
            context.startActivity(intent);
        }

        public final Intent createIntent(Context context, String phoneNumber) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            Intent intent = new Intent(context, (Class<?>) VerifyCodeActivity.class);
            intent.putExtra(VerifyCodeActivity.EXTRA_PHONE_NUMBER, phoneNumber);
            return intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VerifyCodeViewModel getViewModel() {
        return (VerifyCodeViewModel) this.viewModel.getValue();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(5);
        TraeActivityVerifyCodeBinding inflate = TraeActivityVerifyCodeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        setupViews();
        observeViewModel();
        String stringExtra = getIntent().getStringExtra(EXTRA_PHONE_NUMBER);
        if (stringExtra == null) {
            stringExtra = "";
        }
        getViewModel().init(stringExtra);
    }

    private final void setupViews() {
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = this.binding;
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding2 = null;
        if (traeActivityVerifyCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityVerifyCodeBinding = null;
        }
        traeActivityVerifyCodeBinding.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyCodeActivity.this.finish();
            }
        });
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding3 = this.binding;
        if (traeActivityVerifyCodeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityVerifyCodeBinding3 = null;
        }
        traeActivityVerifyCodeBinding3.tvResend.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyCodeActivity.setupViews$lambda$1(VerifyCodeActivity.this, view);
            }
        });
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding4 = this.binding;
        if (traeActivityVerifyCodeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityVerifyCodeBinding4 = null;
        }
        traeActivityVerifyCodeBinding4.verifyCodeInput.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$setupViews$3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding5;
                traeActivityVerifyCodeBinding5 = VerifyCodeActivity.this.binding;
                if (traeActivityVerifyCodeBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityVerifyCodeBinding5 = null;
                }
                traeActivityVerifyCodeBinding5.verifyCodeInput.setError(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                VerifyCodeViewModel viewModel;
                viewModel = VerifyCodeActivity.this.getViewModel();
                String obj = s != null ? s.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                viewModel.onCodeChanged(obj);
            }
        });
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding5 = this.binding;
        if (traeActivityVerifyCodeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityVerifyCodeBinding5 = null;
        }
        traeActivityVerifyCodeBinding5.verifyCodeInput.requestFocus();
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding6 = this.binding;
        if (traeActivityVerifyCodeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityVerifyCodeBinding2 = traeActivityVerifyCodeBinding6;
        }
        traeActivityVerifyCodeBinding2.verifyCodeInput.post(new Runnable() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                VerifyCodeActivity.setupViews$lambda$2(VerifyCodeActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1(VerifyCodeActivity verifyCodeActivity, View view) {
        verifyCodeActivity.getViewModel().resendCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$2(VerifyCodeActivity verifyCodeActivity) {
        Object systemService = verifyCodeActivity.getSystemService("input_method");
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding2 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding2;
            }
            inputMethodManager.showSoftInput((View) traeActivityVerifyCodeBinding.verifyCodeInput, 1);
        }
    }

    private final void observeViewModel() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getViewModel().getMaskedPhone().observe(lifecycleOwner, new VerifyCodeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$3;
                observeViewModel$lambda$3 = VerifyCodeActivity.observeViewModel$lambda$3(VerifyCodeActivity.this, (String) obj);
                return observeViewModel$lambda$3;
            }
        }));
        getViewModel().getClearInputEvent().observe(lifecycleOwner, new VerifyCodeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$5;
                observeViewModel$lambda$5 = VerifyCodeActivity.observeViewModel$lambda$5(VerifyCodeActivity.this, (VerifyCodeViewModel.Event) obj);
                return observeViewModel$lambda$5;
            }
        }));
        getViewModel().getCountdownSeconds().observe(lifecycleOwner, new VerifyCodeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$6;
                observeViewModel$lambda$6 = VerifyCodeActivity.observeViewModel$lambda$6(VerifyCodeActivity.this, (Integer) obj);
                return observeViewModel$lambda$6;
            }
        }));
        getViewModel().isResendEnabled().observe(lifecycleOwner, new VerifyCodeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$7;
                observeViewModel$lambda$7 = VerifyCodeActivity.observeViewModel$lambda$7(VerifyCodeActivity.this, (Boolean) obj);
                return observeViewModel$lambda$7;
            }
        }));
        getViewModel().getLoginState().observe(lifecycleOwner, new VerifyCodeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$11;
                observeViewModel$lambda$11 = VerifyCodeActivity.observeViewModel$lambda$11(VerifyCodeActivity.this, (VerifyCodeViewModel.LoginState) obj);
                return observeViewModel$lambda$11;
            }
        }));
        getViewModel().getResendState().observe(lifecycleOwner, new VerifyCodeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit observeViewModel$lambda$12;
                observeViewModel$lambda$12 = VerifyCodeActivity.observeViewModel$lambda$12(VerifyCodeActivity.this, (VerifyCodeViewModel.ResendState) obj);
                return observeViewModel$lambda$12;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$3(VerifyCodeActivity verifyCodeActivity, String str) {
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = verifyCodeActivity.binding;
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding2 = null;
        if (traeActivityVerifyCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityVerifyCodeBinding = null;
        }
        traeActivityVerifyCodeBinding.tvSubtitle.setText(verifyCodeActivity.getString(C0882R.string.trae_verify_code_subtitle_prefix));
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding3 = verifyCodeActivity.binding;
        if (traeActivityVerifyCodeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityVerifyCodeBinding2 = traeActivityVerifyCodeBinding3;
        }
        traeActivityVerifyCodeBinding2.tvPhone.setText(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$5(VerifyCodeActivity verifyCodeActivity, VerifyCodeViewModel.Event event) {
        if (((Unit) event.getContentIfNotHandled()) != null) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = verifyCodeActivity.binding;
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding2 = null;
            if (traeActivityVerifyCodeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityVerifyCodeBinding = null;
            }
            traeActivityVerifyCodeBinding.verifyCodeInput.setText("");
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding3 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding2 = traeActivityVerifyCodeBinding3;
            }
            traeActivityVerifyCodeBinding2.verifyCodeInput.requestFocus();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$6(VerifyCodeActivity verifyCodeActivity, Integer num) {
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = null;
        if (num.intValue() > 0) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding2 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding2;
            }
            traeActivityVerifyCodeBinding.tvResend.setText(verifyCodeActivity.getString(C0882R.string.trae_verify_code_resend_phone, new Object[]{num}));
        } else {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding3 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding3;
            }
            traeActivityVerifyCodeBinding.tvResend.setText(verifyCodeActivity.getString(C0882R.string.trae_verify_code_resend_enabled));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$7(VerifyCodeActivity verifyCodeActivity, Boolean bool) {
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = verifyCodeActivity.binding;
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding2 = null;
        if (traeActivityVerifyCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityVerifyCodeBinding = null;
        }
        TextView textView = traeActivityVerifyCodeBinding.tvResend;
        Intrinsics.checkNotNull(bool);
        textView.setClickable(bool.booleanValue());
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding3 = verifyCodeActivity.binding;
        if (traeActivityVerifyCodeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityVerifyCodeBinding2 = traeActivityVerifyCodeBinding3;
        }
        traeActivityVerifyCodeBinding2.tvResend.setTextColor(verifyCodeActivity.getColor(bool.booleanValue() ? C0820R.color.trae_login_enable : C0820R.color.trae_login_disable));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit observeViewModel$lambda$11(final VerifyCodeActivity verifyCodeActivity, VerifyCodeViewModel.LoginState loginState) {
        TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = null;
        if (loginState instanceof VerifyCodeViewModel.LoginState.Idle) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding2 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityVerifyCodeBinding2 = null;
            }
            traeActivityVerifyCodeBinding2.loadingOverlay.setVisibility(8);
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding3 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding3;
            }
            traeActivityVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        } else if (loginState instanceof VerifyCodeViewModel.LoginState.Loading) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding4 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityVerifyCodeBinding4 = null;
            }
            traeActivityVerifyCodeBinding4.loadingOverlay.setVisibility(0);
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding5 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding5;
            }
            traeActivityVerifyCodeBinding.verifyCodeInput.setEnabled(false);
        } else if (loginState instanceof VerifyCodeViewModel.LoginState.Success) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding6 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding6;
            }
            traeActivityVerifyCodeBinding.loadingOverlay.setVisibility(8);
            verifyCodeActivity.navigateToMainActivity();
        } else if (loginState instanceof VerifyCodeViewModel.LoginState.DeletionPending) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding7 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityVerifyCodeBinding7 = null;
            }
            traeActivityVerifyCodeBinding7.loadingOverlay.setVisibility(8);
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding8 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding8;
            }
            traeActivityVerifyCodeBinding.verifyCodeInput.setEnabled(true);
            DeletionPendingDialogHelper.INSTANCE.show((Activity) verifyCodeActivity, ((VerifyCodeViewModel.LoginState.DeletionPending) loginState).getToken(), new Function0() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit observeViewModel$lambda$11$lambda$8;
                    observeViewModel$lambda$11$lambda$8 = VerifyCodeActivity.observeViewModel$lambda$11$lambda$8(VerifyCodeActivity.this);
                    return observeViewModel$lambda$11$lambda$8;
                }
            });
        } else if (loginState instanceof VerifyCodeViewModel.LoginState.DeviceOverLimit) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding9 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityVerifyCodeBinding9 = null;
            }
            traeActivityVerifyCodeBinding9.loadingOverlay.setVisibility(8);
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding10 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding10;
            }
            traeActivityVerifyCodeBinding.verifyCodeInput.setEnabled(true);
            DeviceOverLimitDialog.INSTANCE.show((Activity) verifyCodeActivity, ((VerifyCodeViewModel.LoginState.DeviceOverLimit) loginState).getResult(), DeviceOverLimitDialog.Scene.LOGIN, new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.activity.VerifyCodeActivity$$ExternalSyntheticLambda1
                @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
                public final void onResult(boolean z) {
                    VerifyCodeActivity.observeViewModel$lambda$11$lambda$10(VerifyCodeActivity.this, z);
                }
            });
        } else {
            if (!(loginState instanceof VerifyCodeViewModel.LoginState.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding11 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityVerifyCodeBinding11 = null;
            }
            traeActivityVerifyCodeBinding11.loadingOverlay.setVisibility(8);
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding12 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityVerifyCodeBinding12 = null;
            }
            traeActivityVerifyCodeBinding12.verifyCodeInput.setEnabled(true);
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding13 = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityVerifyCodeBinding = traeActivityVerifyCodeBinding13;
            }
            traeActivityVerifyCodeBinding.verifyCodeInput.setError(true);
            Context context = (Context) verifyCodeActivity;
            String errorMessage = ((VerifyCodeViewModel.LoginState.Error) loginState).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = verifyCodeActivity.getString(C0882R.string.trae_verify_code_login_failed);
                Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
            }
            Toast.makeText(context, errorMessage, 0).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$11$lambda$8(VerifyCodeActivity verifyCodeActivity) {
        verifyCodeActivity.navigateToMainActivity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void observeViewModel$lambda$11$lambda$10(VerifyCodeActivity verifyCodeActivity, boolean z) {
        if (z) {
            TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = verifyCodeActivity.binding;
            if (traeActivityVerifyCodeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityVerifyCodeBinding = null;
            }
            traeActivityVerifyCodeBinding.loadingOverlay.setVisibility(0);
            verifyCodeActivity.getViewModel().onDeviceLimitLoginContinue();
            return;
        }
        IApplog.Companion companion = IApplog.Companion;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ISignalReportConstants.KEY_REASON, "device_over_limit");
        jSONObject.put("login_platform", TraeAuthManager.PLATFORM_PHONE);
        Unit unit = Unit.INSTANCE;
        companion.reportEvent("icube_login_failure", jSONObject);
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, TraeAuthManager.PLATFORM_PHONE, null, "user_logout_error", "user_logout_device_is_little", null, null, null, null, null, null, 2020, null);
        Toast.makeText((Context) verifyCodeActivity, verifyCodeActivity.getString(C0882R.string.trae_device_over_limit), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit observeViewModel$lambda$12(VerifyCodeActivity verifyCodeActivity, VerifyCodeViewModel.ResendState resendState) {
        if (!(resendState instanceof VerifyCodeViewModel.ResendState.Loading)) {
            if (resendState instanceof VerifyCodeViewModel.ResendState.Success) {
                TraeActivityVerifyCodeBinding traeActivityVerifyCodeBinding = verifyCodeActivity.binding;
                if (traeActivityVerifyCodeBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityVerifyCodeBinding = null;
                }
                traeActivityVerifyCodeBinding.verifyCodeInput.setEnabled(true);
                Toast.makeText((Context) verifyCodeActivity, C0882R.string.trae_login_send_success, 0).show();
            } else {
                if (!(resendState instanceof VerifyCodeViewModel.ResendState.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                Context context = (Context) verifyCodeActivity;
                String errorMessage = ((VerifyCodeViewModel.ResendState.Error) resendState).getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = verifyCodeActivity.getString(C0882R.string.trae_login_send_failed);
                    Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
                }
                Toast.makeText(context, errorMessage, 0).show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void navigateToMainActivity() {
        Intent intent = new Intent();
        intent.setClassName((Context) this, "com.bytedance.trae.home.MainActivity");
        intent.setFlags(268468224);
        intent.putExtra("from_login_success", true);
        startActivity(intent);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_activity_VerifyCodeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m403x2803c464(VerifyCodeActivity verifyCodeActivity) {
        verifyCodeActivity.m404xbc34ebf7();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) verifyCodeActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
