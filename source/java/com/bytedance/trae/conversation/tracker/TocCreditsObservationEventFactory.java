package com.bytedance.trae.conversation.tracker;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.trae.conversation.billing.BillingUpgradeUserState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: TocCreditsObservation.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J2\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016J\f\u0010\u001e\u001a\u00020\u0016*\u00020\u0007H\u0002J\u000e\u0010\u001f\u001a\u00020\u0016*\u0004\u0018\u00010\u0016H\u0002J\f\u0010 \u001a\u00020!*\u00020\u0011H\u0002R\u000e\u0010\"\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEventFactory;", "", "<init>", "()V", "billingPopupShow", "Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;", "userState", "Lcom/bytedance/trae/conversation/billing/BillingUpgradeUserState;", "showSource", "Lcom/bytedance/trae/conversation/tracker/BillingPopupShowSource;", "billingPopupClick", "action", "Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;", "stayDurationMs", "", "billingSwitchResult", "succeeded", "", "preparationMode", "Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;", "durationMs", AccountMonitorConstants.CommonParameter.ERROR, "", "credits4008Hit", "creditsFeatureEnabled", "codeSource", "Lcom/bytedance/trae/conversation/tracker/Credits4008CodeSource;", "isHistory", "cliType", "chatMode", "trackValue", "orStableUnknown", "toInt", "", "EVENT_BILLING_POPUP_SHOW", "EVENT_BILLING_POPUP_CLICK", "EVENT_BILLING_SWITCH_RESULT", "EVENT_CREDITS_4008_HIT", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TocCreditsObservationEventFactory {
    private static final String EVENT_BILLING_POPUP_CLICK = "toc_billing_upgrade_popup_click";
    private static final String EVENT_BILLING_POPUP_SHOW = "toc_billing_upgrade_popup_show";
    private static final String EVENT_BILLING_SWITCH_RESULT = "toc_billing_switch_result";
    private static final String EVENT_CREDITS_4008_HIT = "toc_credits_4008_hit";
    public static final TocCreditsObservationEventFactory INSTANCE = new TocCreditsObservationEventFactory();

    /* compiled from: TocCreditsObservation.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BillingUpgradeUserState.values().length];
            try {
                iArr[BillingUpgradeUserState.NoFastRequests.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BillingUpgradeUserState.HasFastRequests.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BillingUpgradeUserState.Express.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    private TocCreditsObservationEventFactory() {
    }

    public final TocCreditsObservationEvent billingPopupShow(BillingUpgradeUserState userState, BillingPopupShowSource showSource) {
        Intrinsics.checkNotNullParameter(userState, "userState");
        Intrinsics.checkNotNullParameter(showSource, "showSource");
        return new TocCreditsObservationEvent(TocCreditsObservationChannel.Tea, EVENT_BILLING_POPUP_SHOW, MapsKt.mapOf(new Pair[]{TuplesKt.to("user_state", trackValue(userState)), TuplesKt.to("conversion_version", 2), TuplesKt.to("show_source", showSource.getValue())}), null, 8, null);
    }

    public final TocCreditsObservationEvent billingPopupClick(BillingPopupAction action, BillingUpgradeUserState userState, long stayDurationMs) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(userState, "userState");
        return new TocCreditsObservationEvent(TocCreditsObservationChannel.Tea, EVENT_BILLING_POPUP_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("action", action.getValue()), TuplesKt.to("user_state", trackValue(userState)), TuplesKt.to("conversion_version", 2), TuplesKt.to("stay_duration_ms", Long.valueOf(RangesKt.coerceAtLeast(stayDurationMs, 0L)))}), null, 8, null);
    }

    public final TocCreditsObservationEvent billingSwitchResult(boolean succeeded, BillingSwitchPreparationMode preparationMode, long durationMs, String errorCode) {
        Intrinsics.checkNotNullParameter(preparationMode, "preparationMode");
        TocCreditsObservationChannel tocCreditsObservationChannel = TocCreditsObservationChannel.Slardar;
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("result", succeeded ? "success" : "failure");
        createMapBuilder.put("preparation_mode", preparationMode.getValue());
        if (errorCode != null) {
            if (!(!StringsKt.isBlank(errorCode))) {
                errorCode = null;
            }
            if (errorCode != null) {
                createMapBuilder.put("error_code", errorCode);
            }
        }
        Unit unit = Unit.INSTANCE;
        return new TocCreditsObservationEvent(tocCreditsObservationChannel, EVENT_BILLING_SWITCH_RESULT, MapsKt.build(createMapBuilder), MapsKt.mapOf(TuplesKt.to("duration_ms", Long.valueOf(RangesKt.coerceAtLeast(durationMs, 0L)))));
    }

    public final TocCreditsObservationEvent credits4008Hit(boolean creditsFeatureEnabled, Credits4008CodeSource codeSource, boolean isHistory, String cliType, String chatMode) {
        Intrinsics.checkNotNullParameter(codeSource, "codeSource");
        TocCreditsObservationChannel tocCreditsObservationChannel = TocCreditsObservationChannel.Slardar;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("credits_feature_enabled", Integer.valueOf(toInt(creditsFeatureEnabled)));
        pairArr[1] = TuplesKt.to("code_source", codeSource.getValue());
        pairArr[2] = TuplesKt.to("render_variant", creditsFeatureEnabled ? "credits_exhausted" : "legacy_usage_limit");
        pairArr[3] = TuplesKt.to("is_history", Integer.valueOf(toInt(isHistory)));
        pairArr[4] = TuplesKt.to("cli_type", orStableUnknown(cliType));
        pairArr[5] = TuplesKt.to("chat_mode", orStableUnknown(chatMode));
        return new TocCreditsObservationEvent(tocCreditsObservationChannel, EVENT_CREDITS_4008_HIT, MapsKt.mapOf(pairArr), null, 8, null);
    }

    private final String trackValue(BillingUpgradeUserState billingUpgradeUserState) {
        int i = WhenMappings.$EnumSwitchMapping$0[billingUpgradeUserState.ordinal()];
        if (i == 1) {
            return "no_fast_requests";
        }
        if (i == 2) {
            return "has_fast_requests";
        }
        if (i == 3) {
            return "express";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String orStableUnknown(String str) {
        if (str != null) {
            if (!(!StringsKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        return "unknown";
    }
}
