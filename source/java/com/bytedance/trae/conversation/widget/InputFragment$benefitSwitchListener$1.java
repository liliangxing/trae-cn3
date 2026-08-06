package com.bytedance.trae.conversation.widget;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.ExpressPassBenefitManager;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.databinding.TraeFragmentInputBinding;
import com.facebook.common.logging.FLog;
import kotlin.Metadata;

/* compiled from: InputFragment.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1", "Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;", "onBenefitSwitched", "", "enabled", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputFragment$benefitSwitchListener$1 implements ExpressPassBenefitManager.OnBenefitSwitchListener {
    final /* synthetic */ InputFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputFragment$benefitSwitchListener$1(InputFragment inputFragment) {
        this.this$0 = inputFragment;
    }

    @Override // com.bytedance.trae.conversation.ExpressPassBenefitManager.OnBenefitSwitchListener
    public void onBenefitSwitched(final boolean enabled) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            final InputFragment inputFragment = this.this$0;
            activity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.conversation.widget.InputFragment$benefitSwitchListener$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InputFragment$benefitSwitchListener$1.onBenefitSwitched$lambda$0(InputFragment.this, enabled);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBenefitSwitched$lambda$0(InputFragment inputFragment, boolean z) {
        TraeFragmentInputBinding traeFragmentInputBinding;
        TraeFragmentInputBinding binding;
        TraeFragmentInputBinding binding2;
        boolean z2;
        TraeFragmentInputBinding binding3;
        TraeFragmentInputBinding binding4;
        TraeFragmentInputBinding binding5;
        try {
            traeFragmentInputBinding = inputFragment._binding;
            if (traeFragmentInputBinding == null) {
                return;
            }
            if (TocCreditsPolicy.INSTANCE.isEnabled()) {
                inputFragment.isExpressPassVisible = false;
                binding5 = inputFragment.getBinding();
                binding5.btnExpressPass.setVisibility(8);
                return;
            }
            if (!ExpressPassBenefitManager.INSTANCE.getKeva().getBoolean(ExpressPassBenefitManager.KEY_EXPRESS_PASS_ENABLE_FROM_AGENT, false)) {
                ExpressPassBenefitManager.INSTANCE.getKeva().storeBoolean(ExpressPassBenefitManager.KEY_EXPRESS_PASS_ENABLE_FROM_AGENT, true);
                inputFragment.showExpressPassPopWindow();
            }
            ExpressPassBenefitManager.INSTANCE.saveAutoUseExpressPass(true);
            FLog.d("ExpressPassBenefitManager", "showExpressPassPopWindow:" + z);
            binding = inputFragment.getBinding();
            binding.btnExpressPass.setVisibility(0);
            if (z) {
                z2 = inputFragment.infinite;
                if (z2) {
                    binding4 = inputFragment.getBinding();
                    binding4.btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_express_999);
                    return;
                } else {
                    binding3 = inputFragment.getBinding();
                    binding3.btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_use_express_pass);
                    return;
                }
            }
            binding2 = inputFragment.getBinding();
            binding2.btnExpressPass.setImageResource(C0637R.drawable.ic_input_bar_no_use_express_pass);
        } catch (Throwable unused) {
        }
    }
}
