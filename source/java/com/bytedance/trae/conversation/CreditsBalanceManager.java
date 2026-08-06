package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: CreditsBalanceManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/CreditsBalanceManager;", "", "<init>", "()V", "TAG", "", "KEY_LOW_BALANCE_CLOSE_TIME", "scope", "Lkotlinx/coroutines/CoroutineScope;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/bytedance/trae/conversation/CreditsBalanceManager$OnBalanceChangedListener;", "isFetching", "Ljava/util/concurrent/atomic/AtomicBoolean;", "refreshPending", "isInitialized", "streamingMessageListener", "Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;", "init", "", "addListener", "listener", "removeListener", "refresh", "belongsToCurrentUser", "", "balance", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;", "OnBalanceChangedListener", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CreditsBalanceManager {
    public static final String KEY_LOW_BALANCE_CLOSE_TIME = "credits_low_balance_close_time";
    private static final String TAG = "CreditsBalanceManager";
    public static final CreditsBalanceManager INSTANCE = new CreditsBalanceManager();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static final CopyOnWriteArraySet<OnBalanceChangedListener> listeners = new CopyOnWriteArraySet<>();
    private static final AtomicBoolean isFetching = new AtomicBoolean(false);
    private static final AtomicBoolean refreshPending = new AtomicBoolean(false);
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static final IMService.StreamingMessageListener streamingMessageListener = new IMService.StreamingMessageListener() { // from class: com.bytedance.trae.conversation.CreditsBalanceManager$$ExternalSyntheticLambda0
        @Override // com.bytedance.trae.im.service.IMService.StreamingMessageListener
        public final void onStreamingMessage(ParsedChatMessage parsedChatMessage, boolean z) {
            CreditsBalanceManager.streamingMessageListener$lambda$0(parsedChatMessage, z);
        }
    };

    /* compiled from: CreditsBalanceManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/CreditsBalanceManager$OnBalanceChangedListener;", "", "onBalanceChanged", "", "balance", "Lcom/bytedance/trae/conversation/chat/UserPayIdentityService$CreditsBalanceData;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnBalanceChangedListener {
        void onBalanceChanged(UserPayIdentityService.CreditsBalanceData balance);
    }

    private CreditsBalanceManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void streamingMessageListener$lambda$0(ParsedChatMessage parsedChatMessage, boolean z) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "<unused var>");
        if (z) {
            INSTANCE.refresh();
        }
    }

    public final void init() {
        if (TocCreditsPolicy.INSTANCE.isEnabled() && isInitialized.compareAndSet(false, true)) {
            IMService.INSTANCE.addStreamingMessageListener(streamingMessageListener);
        }
    }

    public final void addListener(OnBalanceChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
        UserPayIdentityService.CreditsBalanceData creditsBalanceData = UserPayIdentityService.getCreditsBalanceData();
        if (creditsBalanceData != null) {
            if (!belongsToCurrentUser(creditsBalanceData)) {
                creditsBalanceData = null;
            }
            if (creditsBalanceData != null) {
                listener.onBalanceChanged(creditsBalanceData);
            }
        }
    }

    public final void removeListener(OnBalanceChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final void refresh() {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            init();
            if (!isFetching.compareAndSet(false, true)) {
                refreshPending.set(true);
            } else {
                BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new CreditsBalanceManager$refresh$1(null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean belongsToCurrentUser(UserPayIdentityService.CreditsBalanceData balance) {
        Object obj;
        AccountInfo accountInfo;
        try {
            Result.Companion companion = Result.Companion;
            CreditsBalanceManager creditsBalanceManager = this;
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            obj = Result.constructor-impl((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return CreditsBalancePolicy.INSTANCE.belongsToCurrentUser(balance.getUserId(), (String) (Result.isFailure-impl(obj) ? null : obj), TocCreditsPolicy.INSTANCE.isEnabled());
    }
}
