package com.bytedance.android.anniex.ability.service;

import com.bytedance.android.anniex.base.service.IAnnieXService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXAccountService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXAccountService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "accessTokenForAuthPlatform", "", "getBindState", "", "accountAuthType", "Lcom/bytedance/android/anniex/ability/service/AccountAuthType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXAccountService extends IAnnieXService {
    public static final String AnnieXAccessTokenKey = "Authorization";
    public static final String AnnieXAccessTokenSourceKey = "X-Tt-Sass-Auth";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: IAnnieXAccountService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static String accessTokenForAuthPlatform(IAnnieXAccountService iAnnieXAccountService) {
            return null;
        }
    }

    String accessTokenForAuthPlatform();

    boolean getBindState(AccountAuthType accountAuthType);

    /* compiled from: IAnnieXAccountService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXAccountService$Companion;", "", "()V", "AnnieXAccessTokenKey", "", "AnnieXAccessTokenSourceKey", "platformAppId", "getPlatformAppId", "()Ljava/lang/String;", "setPlatformAppId", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final String AnnieXAccessTokenKey = "Authorization";
        public static final String AnnieXAccessTokenSourceKey = "X-Tt-Sass-Auth";
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static String platformAppId = "";

        private Companion() {
        }

        public final String getPlatformAppId() {
            return platformAppId;
        }

        public final void setPlatformAppId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            platformAppId = str;
        }
    }
}
