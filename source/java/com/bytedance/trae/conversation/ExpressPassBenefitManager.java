package com.bytedance.trae.conversation;

import com.bytedance.keva.Keva;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.settings.BusinessSettingsService;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.IMService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: ExpressPassBenefitManager.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;", "", "<init>", "()V", "KEY_EXPRESS_PASS_BENEFIT_CLOSE_TIME", "", "KEY_EXPRESS_PASS_ENABLED", "KEY_EXPRESS_PASS_ENABLE_FROM_AGENT", "KEY_EXPRESS_PASS_SWITCH_TIPS", "isInited", "", "benefitSwitchListeners", "", "Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;", "remainingChangedListeners", "Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;", "addBenefitSwitchListener", "", "listener", "removeBenefitSwitchListener", "addRemainingChangedListener", "notifyBenefitEnable", "removeRemainingChangedListener", "getKeva", "Lcom/bytedance/keva/Keva;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isFetching", "fetchUserPayIdentity", "isAutoUseExpress", "streamingMessageListener", "Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;", "init", "isOpenAutoUseExpressPass", "saveAutoUseExpressPass", "enable", "getNotifyInterval", "", "getNotifyCount", "OnBenefitSwitchListener", "OnRemainingChangedListener", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ExpressPassBenefitManager {
    public static final String KEY_EXPRESS_PASS_BENEFIT_CLOSE_TIME = "express_pass_benefit_close_time";
    public static final String KEY_EXPRESS_PASS_ENABLED = "express_pass_enabled";
    public static final String KEY_EXPRESS_PASS_ENABLE_FROM_AGENT = "express_pass_enable_from_agent";
    public static final String KEY_EXPRESS_PASS_SWITCH_TIPS = "express_pass_switch_tips";
    private static volatile boolean isFetching;
    private static boolean isInited;
    public static final ExpressPassBenefitManager INSTANCE = new ExpressPassBenefitManager();
    private static final List<OnBenefitSwitchListener> benefitSwitchListeners = new ArrayList();
    private static final List<OnRemainingChangedListener> remainingChangedListeners = new ArrayList();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static final IMService.StreamingMessageListener streamingMessageListener = new IMService.StreamingMessageListener() { // from class: com.bytedance.trae.conversation.ExpressPassBenefitManager$$ExternalSyntheticLambda0
        @Override // com.bytedance.trae.im.service.IMService.StreamingMessageListener
        public final void onStreamingMessage(ParsedChatMessage parsedChatMessage, boolean z) {
            ExpressPassBenefitManager.streamingMessageListener$lambda$1(parsedChatMessage, z);
        }
    };

    /* compiled from: ExpressPassBenefitManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;", "", "onBenefitSwitched", "", "enabled", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnBenefitSwitchListener {
        void onBenefitSwitched(boolean enabled);
    }

    /* compiled from: ExpressPassBenefitManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;", "", "onRemainingChanged", "", "total", "", "remaining", "infinite", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnRemainingChangedListener {
        void onRemainingChanged(long total, long remaining, boolean infinite);
    }

    private ExpressPassBenefitManager() {
    }

    public final void addBenefitSwitchListener(OnBenefitSwitchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<OnBenefitSwitchListener> list = benefitSwitchListeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    public final void removeBenefitSwitchListener(OnBenefitSwitchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        benefitSwitchListeners.remove(listener);
    }

    public final void addRemainingChangedListener(OnRemainingChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<OnRemainingChangedListener> list = remainingChangedListeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    public final void notifyBenefitEnable() {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            return;
        }
        Iterator<T> it = benefitSwitchListeners.iterator();
        while (it.hasNext()) {
            ((OnBenefitSwitchListener) it.next()).onBenefitSwitched(true);
        }
    }

    public final void removeRemainingChangedListener(OnRemainingChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        remainingChangedListeners.remove(listener);
    }

    public final Keva getKeva() {
        return AccountSettingsKeva.INSTANCE.getKeva();
    }

    public final void fetchUserPayIdentity() {
        if (TocCreditsPolicy.INSTANCE.isEnabled() || AppHost.INSTANCE.isOversea() || LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures() || isFetching) {
            return;
        }
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new ExpressPassBenefitManager$fetchUserPayIdentity$1(null), 3, (Object) null);
    }

    public final boolean isAutoUseExpress() {
        if (TocCreditsPolicy.INSTANCE.isEnabled() || LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()) {
            return false;
        }
        UserPayIdentityService.UsageQuotaData userUsageQuotaData = UserPayIdentityService.getUserUsageQuotaData();
        if (userUsageQuotaData.getInfinite() || (userUsageQuotaData.getTotal() > 0 && userUsageQuotaData.getRemaining() > 0)) {
            return isOpenAutoUseExpressPass();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void streamingMessageListener$lambda$1(ParsedChatMessage parsedChatMessage, boolean z) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "message");
        if (z) {
            INSTANCE.fetchUserPayIdentity();
        }
    }

    public final void init() {
        if (TocCreditsPolicy.INSTANCE.isEnabled() || AppHost.INSTANCE.isOversea() || LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures() || isInited) {
            return;
        }
        isInited = true;
        IMService.INSTANCE.addStreamingMessageListener(streamingMessageListener);
    }

    public final boolean isOpenAutoUseExpressPass() {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            return false;
        }
        return AccountSettingsKeva.INSTANCE.getKeva().getBoolean(KEY_EXPRESS_PASS_ENABLED, true);
    }

    public final void saveAutoUseExpressPass(boolean enable) {
        AccountSettingsKeva.INSTANCE.getKeva().storeBoolean(KEY_EXPRESS_PASS_ENABLED, enable);
    }

    public final long getNotifyInterval() {
        long j = 60;
        return BusinessSettingsService.INSTANCE.getSettings().getFastPassNotifyInterval() * j * j * 1000;
    }

    public final long getNotifyCount() {
        return BusinessSettingsService.INSTANCE.getSettings().getFastPassNotifyCount();
    }
}
