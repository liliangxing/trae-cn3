package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.prompt.ManagedPromptCandidate;
import com.bytedance.trae.conversation.prompt.ManagedPromptType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: NewFeaturePromptPolicy.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0005J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;", "", "<init>", "()V", "MIN_LOGIN_AGE_MILLIS", "", "MIN_PROMPT_INTERVAL_MILLIS", "CAMPAIGN_ID_PREFIX", "", "choosePrompt", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptDecision;", "state", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;", "config", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;", "nowMillis", "managedCandidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "managedCandidate$conversation_mainlandRelease", "passesBaseEligibility", "", "isWithinMinInterval", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NewFeaturePromptPolicy {
    private static final String CAMPAIGN_ID_PREFIX = "mobile_ide_guide_";
    public static final NewFeaturePromptPolicy INSTANCE = new NewFeaturePromptPolicy();
    public static final long MIN_LOGIN_AGE_MILLIS = 86400000;
    public static final long MIN_PROMPT_INTERVAL_MILLIS = 86400000;

    private NewFeaturePromptPolicy() {
    }

    public static /* synthetic */ NewFeaturePromptDecision choosePrompt$default(NewFeaturePromptPolicy newFeaturePromptPolicy, NewFeaturePromptState newFeaturePromptState, NewFeaturePromptConfig newFeaturePromptConfig, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            newFeaturePromptConfig = new NewFeaturePromptConfig(false, 0, null, 0L, 15, null);
        }
        if ((i & 4) != 0) {
            j = System.currentTimeMillis();
        }
        return newFeaturePromptPolicy.choosePrompt(newFeaturePromptState, newFeaturePromptConfig, j);
    }

    public final NewFeaturePromptDecision choosePrompt(NewFeaturePromptState state, NewFeaturePromptConfig config, long nowMillis) {
        Object obj;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(config, "config");
        if (!config.getEnable() || !passesBaseEligibility(state, nowMillis) || isWithinMinInterval(state, config, nowMillis)) {
            return null;
        }
        List<DeviceProductType> distinct = CollectionsKt.distinct(config.getPriority());
        if (distinct.isEmpty()) {
            distinct = NewFeaturePromptConfig.INSTANCE.getDEFAULT_PRIORITY();
        }
        Iterator<T> it = distinct.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            DeviceProductType deviceProductType = (DeviceProductType) obj;
            boolean z = false;
            if (state.getEligibleProductTypes().contains(deviceProductType) && state.getHighestShownVersions().getOrDefault(deviceProductType, 0).intValue() < config.getVersion() && !state.getRegisteredProductTypes().contains(deviceProductType)) {
                z = true;
            }
        }
        DeviceProductType deviceProductType2 = (DeviceProductType) obj;
        if (deviceProductType2 == null) {
            return null;
        }
        return new NewFeaturePromptDecision(deviceProductType2);
    }

    public final ManagedPromptCandidate managedCandidate$conversation_mainlandRelease(DeviceProductType productType, NewFeaturePromptConfig config) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(config, "config");
        return new ManagedPromptCandidate(ManagedPromptType.MobileIdeGuide, CAMPAIGN_ID_PREFIX + productType.name(), config.getVersion());
    }

    private final boolean passesBaseEligibility(NewFeaturePromptState state, long nowMillis) {
        if (!state.getHasConversation()) {
            return false;
        }
        long firstLoginObservedAtMillis = state.getFirstLoginObservedAtMillis();
        return firstLoginObservedAtMillis > 0 && nowMillis >= firstLoginObservedAtMillis && nowMillis - firstLoginObservedAtMillis >= 86400000;
    }

    private final boolean isWithinMinInterval(NewFeaturePromptState state, NewFeaturePromptConfig config, long nowMillis) {
        long lastShownAtMillis = state.getLastShownAtMillis();
        if (lastShownAtMillis <= 0) {
            return false;
        }
        return nowMillis < lastShownAtMillis || nowMillis - lastShownAtMillis < Math.max(86400000L, RangesKt.coerceAtLeast(config.getMinIntervalMillis(), 0L));
    }
}
