package com.bytedance.trae.conversation;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TocCreditsPolicy.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/TocCreditsPolicy;", "", "<init>", "()V", "isEnabled", "", "isLogin", "accountType", "Lcom/bytedance/trae/login/api/AccountType;", "isOversea", "shouldSkipTocCommercialFeatures", "resolveUseFastRequest", "requested", "autoUse", "creditsFeatureEnabled", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TocCreditsPolicy {
    public static final TocCreditsPolicy INSTANCE = new TocCreditsPolicy();

    public final boolean resolveUseFastRequest(boolean requested, boolean autoUse, boolean creditsFeatureEnabled) {
        if (creditsFeatureEnabled) {
            return false;
        }
        return requested || autoUse;
    }

    private TocCreditsPolicy() {
    }

    public final boolean isEnabled() {
        Object obj;
        AccountType accountType;
        Object obj2;
        Object obj3;
        try {
            Result.Companion companion = Result.Companion;
            TocCreditsPolicy tocCreditsPolicy = this;
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            obj = Result.constructor-impl(iLoginService != null ? iLoginService.getAccountInfo() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        AccountInfo accountInfo = (AccountInfo) (Result.isFailure-impl(obj) ? null : obj);
        boolean z = false;
        if (accountInfo != null && accountInfo.isLogin()) {
            z = true;
        }
        if (accountInfo == null || (accountType = accountInfo.getAccountType()) == null) {
            accountType = AccountType.UNKNOWN;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            TocCreditsPolicy tocCreditsPolicy2 = this;
            obj2 = Result.constructor-impl(Boolean.valueOf(AppHost.INSTANCE.isOversea()));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (Result.isFailure-impl(obj2)) {
            obj2 = true;
        }
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        try {
            Result.Companion companion5 = Result.Companion;
            TocCreditsPolicy tocCreditsPolicy3 = this;
            obj3 = Result.constructor-impl(Boolean.valueOf(LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()));
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.Companion;
            obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        if (Result.isFailure-impl(obj3)) {
            obj3 = true;
        }
        return isEnabled(z, accountType, booleanValue, ((Boolean) obj3).booleanValue());
    }

    public final boolean isEnabled(boolean isLogin, AccountType accountType, boolean isOversea, boolean shouldSkipTocCommercialFeatures) {
        Intrinsics.checkNotNullParameter(accountType, "accountType");
        return isLogin && accountType == AccountType.TOC && !isOversea && !shouldSkipTocCommercialFeatures;
    }

    public static /* synthetic */ boolean resolveUseFastRequest$default(TocCreditsPolicy tocCreditsPolicy, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = tocCreditsPolicy.isEnabled();
        }
        return tocCreditsPolicy.resolveUseFastRequest(z, z2, z3);
    }
}
