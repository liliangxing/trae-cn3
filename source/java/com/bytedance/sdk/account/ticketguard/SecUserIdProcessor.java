package com.bytedance.sdk.account.ticketguard;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.ConsumerRequestParamWithTsSign;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.ticketguard.AccountTicketGuardManager;
import com.bytedance.sdk.account.utils.Utils;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: AccountTicketGuardProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0013H\u0016J0\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0013H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/account/ticketguard/SecUserIdProcessor;", "Lcom/bytedance/sdk/account/ticketguard/AccountTicketGuardManager$Processor;", "()V", "bdAccount", "Lcom/bytedance/sdk/account/api/IBDAccount;", "getBdAccount", "()Lcom/bytedance/sdk/account/api/IBDAccount;", "bdAccount$delegate", "Lkotlin/Lazy;", "ticketName", "", "getTicketName", "()Ljava/lang/String;", "markGet", "Lcom/bytedance/sdk/account/ticketguard/AccountTicketGuardManager$MarkGetContent;", "uri", "Landroid/net/Uri;", "requestBody", "requestHeaders", "", "markUse", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParamWithTsSign;", "account-sdk-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SecUserIdProcessor implements AccountTicketGuardManager.Processor {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SecUserIdProcessor.class), "bdAccount", "getBdAccount()Lcom/bytedance/sdk/account/api/IBDAccount;"))};

    /* renamed from: bdAccount$delegate, reason: from kotlin metadata */
    private final Lazy bdAccount = LazyKt.lazy(new Function0<IBDAccount>() { // from class: com.bytedance.sdk.account.ticketguard.SecUserIdProcessor$bdAccount$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IBDAccount m883invoke() {
            return BDAccountDelegateInner.instance();
        }
    });
    private final String ticketName = AccountConstants.AccountShareCols.SEC_USER_ID;

    private final IBDAccount getBdAccount() {
        Lazy lazy = this.bdAccount;
        KProperty kProperty = $$delegatedProperties[0];
        return (IBDAccount) lazy.getValue();
    }

    public final String getTicketName() {
        return this.ticketName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if ((r3.length() > 0) != false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    @Override // com.bytedance.sdk.account.ticketguard.AccountTicketGuardManager.Processor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AccountTicketGuardManager.MarkGetContent markGet(Uri uri, String requestBody, Map<String, String> requestHeaders) {
        String path;
        boolean z;
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(requestHeaders, "requestHeaders");
        if (!SecUserIdGuardSettingManager.isEnable() || (path = uri.getPath()) == null) {
            return null;
        }
        if (StringsKt.startsWith$default(path, "/passport/", false, 2, (Object) null)) {
            if (getBdAccount().isLogin() && (Intrinsics.areEqual("/passport/account/info/v2/", path) || Intrinsics.areEqual("/passport/account/info/", path))) {
                String tsSign = TsSignCacheHelper.getTsSign(getBdAccount().getSecUserId());
                Intrinsics.checkExpressionValueIsNotNull(tsSign, "TsSignCacheHelper.getTsSign(bdAccount.secUserId)");
            }
            z = true;
            String str = this.ticketName + ',';
            if (!z) {
                return new AccountTicketGuardManager.MarkGetContent(str, str, true);
            }
            return new AccountTicketGuardManager.MarkGetContent(str, "", false);
        }
        z = false;
        String str2 = this.ticketName + ',';
        if (!z) {
        }
    }

    @Override // com.bytedance.sdk.account.ticketguard.AccountTicketGuardManager.Processor
    public ConsumerRequestParamWithTsSign markUse(Uri uri, String requestBody, Map<String, String> requestHeaders) {
        String str;
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(requestHeaders, "requestHeaders");
        if (SecUserIdGuardSettingManager.isEnable() && SecUserIdGuardSettingManager.isPathNeedGuard(uri.getPath())) {
            for (Pair<String, String> pair : Utils.parseRequestBody(requestBody)) {
                Object obj = pair.first;
                Intrinsics.checkExpressionValueIsNotNull(obj, "item.first");
                String str2 = (String) obj;
                Locale locale = Locale.getDefault();
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
                if (str2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str2.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(lowerCase, AccountConstants.AccountShareCols.SEC_USER_ID) || Intrinsics.areEqual(lowerCase, "last_sec_user_id")) {
                    str = (String) pair.second;
                    break;
                }
            }
            str = null;
            String str3 = str;
            if (!(str3 == null || str3.length() == 0)) {
                String tsSign = TsSignCacheHelper.getTsSign(str);
                Intrinsics.checkExpressionValueIsNotNull(tsSign, "TsSignCacheHelper.getTsSign(sUid)");
                String host = uri.getHost();
                String str4 = host != null ? host : "";
                String path = uri.getPath();
                return new ConsumerRequestParamWithTsSign(tsSign, str, str4, path != null ? path : "", AccountConstants.AccountShareCols.SEC_USER_ID, false, false, 96, (DefaultConstructorMarker) null);
            }
        }
        return null;
    }
}
