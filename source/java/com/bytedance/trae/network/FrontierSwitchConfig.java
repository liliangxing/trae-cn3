package com.bytedance.trae.network;

import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.keva.Keva;
import com.bytedance.memory.event.EventUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: FrontierSwitchConfig.kt */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/network/FrontierSwitchConfig;", "", "<init>", "()V", "REPO_NAME", "", "KEY_DISABLED", "LOG_TYPE_KEY", "VALUE_DISABLED", "VALUE_ENABLED", "repo", "Lcom/bytedance/keva/Keva;", "getRepo", "()Lcom/bytedance/keva/Keva;", "repo$delegate", "Lkotlin/Lazy;", "disabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listenerRegistered", "configListener", "com/bytedance/trae/network/FrontierSwitchConfig$configListener$1", "Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;", "loadFromCache", "", "registerConfigListener", "isDisabled", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FrontierSwitchConfig {
    private static final String KEY_DISABLED = "disable_frontier_reconnect";
    private static final String LOG_TYPE_KEY = "disable_frontier_reconnect";
    private static final String REPO_NAME = "frontier_switch_config";
    private static final String VALUE_DISABLED = "1";
    private static final String VALUE_ENABLED = "0";
    public static final FrontierSwitchConfig INSTANCE = new FrontierSwitchConfig();

    /* renamed from: repo$delegate, reason: from kotlin metadata */
    private static final Lazy repo = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.network.FrontierSwitchConfig$$ExternalSyntheticLambda0
        public final Object invoke() {
            Keva repo_delegate$lambda$0;
            repo_delegate$lambda$0 = FrontierSwitchConfig.repo_delegate$lambda$0();
            return repo_delegate$lambda$0;
        }
    });
    private static final AtomicBoolean disabled = new AtomicBoolean(false);
    private static final AtomicBoolean listenerRegistered = new AtomicBoolean(false);
    private static final FrontierSwitchConfig$configListener$1 configListener = new IConfigListener() { // from class: com.bytedance.trae.network.FrontierSwitchConfig$configListener$1
        public void onRefresh(JSONObject config, boolean fromLocal) {
            Keva repo2;
            JSONObject optJSONObject;
            JSONObject optJSONObject2 = (config == null || (optJSONObject = config.optJSONObject(EventUtils.CUSTOM_EVENT_SETTINGS)) == null) ? null : optJSONObject.optJSONObject("allow_log_type");
            boolean z = false;
            if (optJSONObject2 != null && optJSONObject2.optInt("disable_frontier_reconnect", 0) == 1) {
                z = true;
            }
            try {
                Result.Companion companion = Result.Companion;
                FrontierSwitchConfig$configListener$1 frontierSwitchConfig$configListener$1 = this;
                repo2 = FrontierSwitchConfig.INSTANCE.getRepo();
                repo2.storeString("disable_frontier_reconnect", z ? "1" : ViewVisibleBridge.INVISIBLE);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }

        public void onReady() {
            Object obj;
            Keva repo2;
            try {
                Result.Companion companion = Result.Companion;
                FrontierSwitchConfig$configListener$1 frontierSwitchConfig$configListener$1 = this;
                obj = Result.constructor-impl(Boolean.valueOf(ApmDelegate.getInstance().getLogTypeSwitch("disable_frontier_reconnect")));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = false;
            }
            boolean booleanValue = ((Boolean) obj).booleanValue();
            try {
                Result.Companion companion3 = Result.Companion;
                FrontierSwitchConfig$configListener$1 frontierSwitchConfig$configListener$12 = this;
                repo2 = FrontierSwitchConfig.INSTANCE.getRepo();
                repo2.storeString("disable_frontier_reconnect", booleanValue ? "1" : ViewVisibleBridge.INVISIBLE);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
    };

    private FrontierSwitchConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Keva getRepo() {
        Object value = repo.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Keva) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keva repo_delegate$lambda$0() {
        return Keva.getRepo(REPO_NAME, 0);
    }

    public final void loadFromCache() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            FrontierSwitchConfig frontierSwitchConfig = this;
            obj = Result.constructor-impl(getRepo().getString("disable_frontier_reconnect", "0"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        disabled.set(Intrinsics.areEqual((String) (Result.isFailure-impl(obj) ? "0" : obj), "1"));
    }

    public final void registerConfigListener() {
        Object obj;
        AtomicBoolean atomicBoolean = listenerRegistered;
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.Companion;
                FrontierSwitchConfig frontierSwitchConfig = this;
                IConfigManager iConfigManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
                if (iConfigManager == null) {
                    atomicBoolean.set(false);
                } else {
                    iConfigManager.registerConfigListener(configListener);
                }
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                listenerRegistered.set(false);
            }
        }
    }

    public final boolean isDisabled() {
        return disabled.get();
    }
}
