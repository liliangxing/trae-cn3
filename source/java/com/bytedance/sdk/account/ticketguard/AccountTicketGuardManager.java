package com.bytedance.sdk.account.ticketguard;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.ConsumerRequestParamWithTsSign;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountTicketGuardManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J&\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/account/ticketguard/AccountTicketGuardManager;", "", "()V", "TAG", "", "list", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/sdk/account/ticketguard/AccountTicketGuardManager$Processor;", "getList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "register", "", "processor", "tryInit", "context", "Landroid/content/Context;", "initCallback", "Lkotlin/Function1;", "", MiPushClient.COMMAND_UNREGISTER, "MarkGetContent", "Processor", "tt-token-sdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class AccountTicketGuardManager {
    private static final String TAG = "AccountTicketGuardManag";
    public static final AccountTicketGuardManager INSTANCE = new AccountTicketGuardManager();
    private static final CopyOnWriteArrayList<Processor> list = new CopyOnWriteArrayList<>();

    /* compiled from: AccountTicketGuardManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&J0\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/account/ticketguard/AccountTicketGuardManager$Processor;", "", "markGet", "Lcom/bytedance/sdk/account/ticketguard/AccountTicketGuardManager$MarkGetContent;", "uri", "Landroid/net/Uri;", "requestBody", "", "requestHeaders", "", "markUse", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParamWithTsSign;", "tt-token-sdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public interface Processor {
        MarkGetContent markGet(Uri uri, String requestBody, Map<String, String> requestHeaders);

        ConsumerRequestParamWithTsSign markUse(Uri uri, String requestBody, Map<String, String> requestHeaders);
    }

    private AccountTicketGuardManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void tryInit$default(AccountTicketGuardManager accountTicketGuardManager, Context context, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        accountTicketGuardManager.tryInit(context, function1);
    }

    public final void tryInit(Context context, Function1<? super Boolean, Unit> initCallback) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            Class.forName("com.bytedance.sdk.account.ticketguard.AccountTicketGuardHelper").getDeclaredMethod("initTicketGuard", Context.class, Function1.class).invoke(null, context, initCallback);
        } catch (Exception e) {
            Log.d(TAG, "AccountTicketGuardManager.tryInit: fail for exception:" + Log.getStackTraceString(e));
            if (initCallback != null) {
                initCallback.invoke(false);
            }
        }
    }

    /* compiled from: AccountTicketGuardManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/account/ticketguard/AccountTicketGuardManager$MarkGetContent;", "", "settingsTag", "", "signTag", "isGet", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getSettingsTag", "()Ljava/lang/String;", "getSignTag", "tt-token-sdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class MarkGetContent {
        private final boolean isGet;
        private final String settingsTag;
        private final String signTag;

        public MarkGetContent(String settingsTag, String signTag, boolean z) {
            Intrinsics.checkParameterIsNotNull(settingsTag, "settingsTag");
            Intrinsics.checkParameterIsNotNull(signTag, "signTag");
            this.settingsTag = settingsTag;
            this.signTag = signTag;
            this.isGet = z;
        }

        public final String getSettingsTag() {
            return this.settingsTag;
        }

        public final String getSignTag() {
            return this.signTag;
        }

        /* renamed from: isGet, reason: from getter */
        public final boolean getIsGet() {
            return this.isGet;
        }
    }

    public final CopyOnWriteArrayList<Processor> getList() {
        return list;
    }

    public final void register(Processor processor) {
        Intrinsics.checkParameterIsNotNull(processor, "processor");
        list.add(processor);
    }

    public final void unregister(Processor processor) {
        Intrinsics.checkParameterIsNotNull(processor, "processor");
        list.remove(processor);
    }
}
