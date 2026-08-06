package com.bytedance.trae.conversation.billing;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.newfeature.HeroPromptBottomSheet;
import com.bytedance.trae.conversation.tracker.BillingPopupAction;
import com.bytedance.trae.conversation.tracker.TocCreditsObservation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BillingUpgradePromptBottomSheet.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;", "Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;", "<init>", "()V", "restoredInstance", "", "hasReportedShow", "hasReportedClick", "shownAtElapsedRealtime", "", "Ljava/lang/Long;", "ownerUserId", "", "getOwnerUserId$conversation_mainlandRelease", "()Ljava/lang/String;", "userState", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;", "getUserState", "()Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onStart", "reportClickAndDismiss", "action", "Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BillingUpgradePromptBottomSheet extends HeroPromptBottomSheet {
    private static final String ARG_OWNER_USER_ID = "arg_owner_user_id";
    private static final String ARG_USER_STATE = "arg_user_state";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "BillingUpgradePromptBottomSheet";
    private boolean hasReportedClick;
    private boolean hasReportedShow;
    private boolean restoredInstance;
    private Long shownAtElapsedRealtime;

    public final String getOwnerUserId$conversation_mainlandRelease() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_OWNER_USER_ID)) == null || !(!StringsKt.isBlank(string))) {
            return null;
        }
        return string;
    }

    private final BillingUpgradeUserState getUserState() {
        String string;
        Object obj;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(ARG_USER_STATE)) != null) {
            try {
                Result.Companion companion = Result.Companion;
                BillingUpgradePromptBottomSheet billingUpgradePromptBottomSheet = this;
                obj = Result.constructor-impl(BillingUpgradeUserState.valueOf(string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            BillingUpgradeUserState billingUpgradeUserState = (BillingUpgradeUserState) obj;
            if (billingUpgradeUserState != null) {
                return billingUpgradeUserState;
            }
        }
        return BillingUpgradeUserState.NoFastRequests;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.restoredInstance = savedInstanceState != null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int i = C0637R.drawable.trae_img_billing_upgrade_prompt_hero;
        String string = getString(C0637R.string.trae_billing_upgrade_prompt_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = string;
        String string2 = getString(C0637R.string.trae_billing_upgrade_prompt_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str2 = string2;
        String string3 = getString(C0637R.string.trae_billing_upgrade_prompt_start);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        bindHeroPrompt(view, i, str, str2, string3, new Function0() { // from class: com.bytedance.trae.conversation.billing.BillingUpgradePromptBottomSheet$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = BillingUpgradePromptBottomSheet.onViewCreated$lambda$3(BillingUpgradePromptBottomSheet.this);
                return onViewCreated$lambda$3;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.billing.BillingUpgradePromptBottomSheet$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onViewCreated$lambda$4;
                onViewCreated$lambda$4 = BillingUpgradePromptBottomSheet.onViewCreated$lambda$4(BillingUpgradePromptBottomSheet.this);
                return onViewCreated$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(BillingUpgradePromptBottomSheet billingUpgradePromptBottomSheet) {
        billingUpgradePromptBottomSheet.reportClickAndDismiss(BillingPopupAction.Close);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(BillingUpgradePromptBottomSheet billingUpgradePromptBottomSheet) {
        billingUpgradePromptBottomSheet.reportClickAndDismiss(BillingPopupAction.Primary);
        return Unit.INSTANCE;
    }

    public void onStart() {
        super.onStart();
        if (this.hasReportedShow) {
            return;
        }
        this.hasReportedShow = true;
        this.shownAtElapsedRealtime = Long.valueOf(SystemClock.elapsedRealtime());
        TocCreditsObservation.INSTANCE.trackBillingPopupShow(getUserState(), this.restoredInstance);
    }

    private final void reportClickAndDismiss(BillingPopupAction action) {
        long j;
        if (!this.hasReportedClick) {
            this.hasReportedClick = true;
            Long l = this.shownAtElapsedRealtime;
            if (l != null) {
                j = SystemClock.elapsedRealtime() - l.longValue();
            } else {
                j = 0;
            }
            TocCreditsObservation.INSTANCE.trackBillingPopupClick(action, getUserState(), j);
        }
        dismiss();
    }

    /* compiled from: BillingUpgradePromptBottomSheet.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_USER_STATE", "ARG_OWNER_USER_ID", "newInstance", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptBottomSheet;", "ownerUserId", "promptData", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BillingUpgradePromptBottomSheet newInstance(String ownerUserId, BillingUpgradePromptData promptData) {
            Intrinsics.checkNotNullParameter(ownerUserId, "ownerUserId");
            Intrinsics.checkNotNullParameter(promptData, "promptData");
            BillingUpgradePromptBottomSheet billingUpgradePromptBottomSheet = new BillingUpgradePromptBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(BillingUpgradePromptBottomSheet.ARG_OWNER_USER_ID, ownerUserId);
            bundle.putString(BillingUpgradePromptBottomSheet.ARG_USER_STATE, promptData.getUserState().name());
            billingUpgradePromptBottomSheet.setArguments(bundle);
            return billingUpgradePromptBottomSheet;
        }
    }
}
