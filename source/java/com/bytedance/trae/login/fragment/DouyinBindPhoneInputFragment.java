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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.fragment.TraceFragment;
import com.bytedance.trae.common_ui.R;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.databinding.TraeFragmentDouyinBindPhoneInputBinding;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: DouyinBindPhoneInputFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0016\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;", "Lcom/bytedance/trae/common/fragment/TraceFragment;", "<init>", "()V", "_binding", "Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;", "binding", "getBinding", "()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;", "phoneNumber", "", "isSendingCode", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupViews", "digitFilter", "Landroid/text/InputFilter;", "sendCode", "runOnUiThread", "block", "Lkotlin/Function0;", "updateSendButton", "onDestroyView", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinBindPhoneInputFragment extends TraceFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex PHONE_REGEX = new Regex("^1\\d{10}$");
    private TraeFragmentDouyinBindPhoneInputBinding _binding;
    private boolean isSendingCode;
    private String phoneNumber = "";

    public boolean autoLogEnterPage() {
        return false;
    }

    /* compiled from: DouyinBindPhoneInputFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$Companion;", "", "<init>", "()V", "PHONE_REGEX", "Lkotlin/text/Regex;", "newInstance", "Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DouyinBindPhoneInputFragment newInstance() {
            return new DouyinBindPhoneInputFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final TraeFragmentDouyinBindPhoneInputBinding get_binding() {
        return this._binding;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TraeFragmentDouyinBindPhoneInputBinding.inflate(inflater, container, false);
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding = get_binding();
        return traeFragmentDouyinBindPhoneInputBinding != null ? traeFragmentDouyinBindPhoneInputBinding.getRoot() : null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViews();
    }

    private final void setupViews() {
        TextView textView;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding != null && (editText4 = traeFragmentDouyinBindPhoneInputBinding.etPhone) != null) {
            editText4.setFilters(new InputFilter[]{digitFilter(), new InputFilter.LengthFilter(11)});
        }
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding2 = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding2 != null && (editText3 = traeFragmentDouyinBindPhoneInputBinding2.etPhone) != null) {
            editText3.setText(this.phoneNumber);
        }
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding3 = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding3 != null && (editText2 = traeFragmentDouyinBindPhoneInputBinding3.etPhone) != null) {
            editText2.setSelection(this.phoneNumber.length());
        }
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding4 = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding4 != null && (editText = traeFragmentDouyinBindPhoneInputBinding4.etPhone) != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment$setupViews$1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    DouyinBindPhoneInputFragment douyinBindPhoneInputFragment = DouyinBindPhoneInputFragment.this;
                    String obj = s != null ? s.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    douyinBindPhoneInputFragment.phoneNumber = obj;
                    DouyinBindPhoneInputFragment.this.updateSendButton();
                }
            });
        }
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding5 = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding5 != null && (textView = traeFragmentDouyinBindPhoneInputBinding5.btnSendCode) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DouyinBindPhoneInputFragment.this.sendCode();
                }
            });
        }
        updateSendButton();
    }

    private final InputFilter digitFilter() {
        return new InputFilter() { // from class: com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment$$ExternalSyntheticLambda2
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                CharSequence digitFilter$lambda$1;
                digitFilter$lambda$1 = DouyinBindPhoneInputFragment.digitFilter$lambda$1(charSequence, i, i2, spanned, i3, i4);
                return digitFilter$lambda$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence digitFilter$lambda$1(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
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
    public final void sendCode() {
        String obj = StringsKt.trim(this.phoneNumber).toString();
        if (!PHONE_REGEX.matches(obj)) {
            Toast.makeText(requireContext(), C0820R.string.trae_phone_invalid, 0).show();
            return;
        }
        if (this.isSendingCode) {
            return;
        }
        this.isSendingCode = true;
        updateSendButton();
        LoginTracker.INSTANCE.trackDouyinBindPhoneSendCodeClick();
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_SEND_CODE, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is6Digits", "1");
        linkedHashMap.put("app_name", AppHost.Companion.getAppName());
        BDAccountAPIV3Impl.instance().sendCode2(obj, 24, linkedHashMap, new DouyinBindPhoneInputFragment$sendCode$1(this, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runOnUiThread(final Function0<Unit> block) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DouyinBindPhoneInputFragment.runOnUiThread$lambda$2(DouyinBindPhoneInputFragment.this, activity, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnUiThread$lambda$2(DouyinBindPhoneInputFragment douyinBindPhoneInputFragment, FragmentActivity fragmentActivity, Function0 function0) {
        if (!douyinBindPhoneInputFragment.isAdded() || fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
            return;
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSendButton() {
        ProgressBar progressBar;
        TextView textView;
        int i;
        TextView textView2;
        TextView textView3;
        boolean z = (this.phoneNumber.length() >= 11) && !this.isSendingCode;
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding != null && (textView3 = traeFragmentDouyinBindPhoneInputBinding.btnSendCode) != null) {
            textView3.setEnabled(z);
        }
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding2 = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding2 != null && (textView2 = traeFragmentDouyinBindPhoneInputBinding2.btnSendCode) != null) {
            textView2.setText(getString(this.isSendingCode ? C0820R.string.trae_douyin_bind_sending_code : C0820R.string.trae_douyin_bind_get_code));
        }
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding3 = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding3 != null && (textView = traeFragmentDouyinBindPhoneInputBinding3.btnSendCode) != null) {
            Context requireContext = requireContext();
            if (z || this.isSendingCode) {
                i = R.color.trae_text_text_onaccent;
            } else {
                i = R.color.trae_text_text_disabled;
            }
            textView.setTextColor(ContextCompat.getColor(requireContext, i));
        }
        TraeFragmentDouyinBindPhoneInputBinding traeFragmentDouyinBindPhoneInputBinding4 = get_binding();
        if (traeFragmentDouyinBindPhoneInputBinding4 == null || (progressBar = traeFragmentDouyinBindPhoneInputBinding4.pbLoading) == null) {
            return;
        }
        progressBar.setVisibility(this.isSendingCode ? 0 : 8);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
