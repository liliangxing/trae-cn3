package com.bytedance.trae.conversation.tracker;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.billing.BillingUpgradePreparationMode;
import com.bytedance.trae.conversation.billing.BillingUpgradeUserState;
import com.bytedance.trae.platform.service.ApmService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TocCreditsObservation.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017JB\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0017J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0002J\u0016\u0010$\u001a\u00020%*\f\u0012\u0004\u0012\u00020\u0017\u0012\u0002\b\u00030&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation;", "", "<init>", "()V", "credits4008Gate", "Lcom/bytedance/trae/conversation/tracker/Credits4008ObservationGate;", "trackBillingPopupShow", "", "userState", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;", "restored", "", "trackBillingPopupClick", "action", "Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;", "stayDurationMs", "", "trackBillingSwitchResult", "succeeded", "preparationMode", "Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;", "durationMs", AccountMonitorConstants.CommonParameter.ERROR, "", "trackCredits4008Hit", "sessionId", "messageId", "creditsFeatureEnabled", "codeSource", "Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource;", "isHistory", "cliType", "chatMode", "report", Fields.EVENT, "Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;", "toJsonObject", "Lorg/json/JSONObject;", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TocCreditsObservation {
    public static final TocCreditsObservation INSTANCE = new TocCreditsObservation();
    private static final Credits4008ObservationGate credits4008Gate = new Credits4008ObservationGate(StatusBarUtils.FLAG_NOTCH_PORTRAIT);

    /* compiled from: TocCreditsObservation.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BillingUpgradePreparationMode.values().length];
            try {
                iArr[BillingUpgradePreparationMode.PromptEligible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BillingUpgradePreparationMode.SilentRecovery.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TocCreditsObservationChannel.values().length];
            try {
                iArr2[TocCreditsObservationChannel.Tea.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[TocCreditsObservationChannel.Slardar.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private TocCreditsObservation() {
    }

    public final void trackBillingPopupShow(BillingUpgradeUserState userState, boolean restored) {
        BillingPopupShowSource billingPopupShowSource;
        Intrinsics.checkNotNullParameter(userState, "userState");
        TocCreditsObservationEventFactory tocCreditsObservationEventFactory = TocCreditsObservationEventFactory.INSTANCE;
        if (restored) {
            billingPopupShowSource = BillingPopupShowSource.Restored;
        } else {
            billingPopupShowSource = BillingPopupShowSource.Normal;
        }
        report(tocCreditsObservationEventFactory.billingPopupShow(userState, billingPopupShowSource));
    }

    public final void trackBillingPopupClick(BillingPopupAction action, BillingUpgradeUserState userState, long stayDurationMs) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(userState, "userState");
        report(TocCreditsObservationEventFactory.INSTANCE.billingPopupClick(action, userState, stayDurationMs));
    }

    public final void trackBillingSwitchResult(boolean succeeded, BillingUpgradePreparationMode preparationMode, long durationMs, String errorCode) {
        BillingSwitchPreparationMode billingSwitchPreparationMode;
        Intrinsics.checkNotNullParameter(preparationMode, "preparationMode");
        TocCreditsObservationEventFactory tocCreditsObservationEventFactory = TocCreditsObservationEventFactory.INSTANCE;
        int i = WhenMappings.$EnumSwitchMapping$0[preparationMode.ordinal()];
        if (i == 1) {
            billingSwitchPreparationMode = BillingSwitchPreparationMode.PromptEligible;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            billingSwitchPreparationMode = BillingSwitchPreparationMode.SilentRecovery;
        }
        report(tocCreditsObservationEventFactory.billingSwitchResult(succeeded, billingSwitchPreparationMode, durationMs, errorCode));
    }

    public final void trackCredits4008Hit(String sessionId, String messageId, boolean creditsFeatureEnabled, Credits4008CodeSource codeSource, boolean isHistory, String cliType, String chatMode) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(codeSource, "codeSource");
        if (credits4008Gate.tryAcquire(sessionId, messageId)) {
            report(TocCreditsObservationEventFactory.INSTANCE.credits4008Hit(creditsFeatureEnabled, codeSource, isHistory, cliType, chatMode));
        }
    }

    private final void report(TocCreditsObservationEvent event) {
        try {
            Result.Companion companion = Result.Companion;
            TocCreditsObservation tocCreditsObservation = this;
            JSONObject jsonObject = toJsonObject(event.getCategory());
            int i = WhenMappings.$EnumSwitchMapping$1[event.getChannel().ordinal()];
            if (i == 1) {
                IApplog.INSTANCE.reportEvent(event.getName(), jsonObject);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                ApmService apmService = ApmService.INSTANCE;
                String name = event.getName();
                Map<String, Number> metric = event.getMetric();
                if (!(true ^ metric.isEmpty())) {
                    metric = null;
                }
                apmService.monitorEventForSlardar(name, jsonObject, metric != null ? toJsonObject(metric) : null, (JSONObject) null);
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final JSONObject toJsonObject(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }
}
