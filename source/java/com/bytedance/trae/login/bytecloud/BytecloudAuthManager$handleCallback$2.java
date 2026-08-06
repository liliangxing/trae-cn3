package com.bytedance.trae.login.bytecloud;

import android.net.Uri;
import com.bytedance.push.settings.StatisticsSettings;
import com.bytedance.trae.login.bytecloud.CallbackResult;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.login.user.UserInfo;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BytecloudAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/login/bytecloud/CallbackResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudAuthManager$handleCallback$2", f = "BytecloudAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudAuthManager$handleCallback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CallbackResult>, Object> {
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytecloudAuthManager$handleCallback$2(Uri uri, Continuation<? super BytecloudAuthManager$handleCallback$2> continuation) {
        super(2, continuation);
        this.$uri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BytecloudAuthManager$handleCallback$2(this.$uri, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CallbackResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00f7 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:5:0x0018, B:11:0x0039, B:15:0x004b, B:20:0x005a, B:27:0x006c, B:28:0x0071, B:33:0x0086, B:37:0x0098, B:40:0x00a4, B:43:0x00bc, B:47:0x00d0, B:49:0x00eb, B:54:0x00f7, B:56:0x0107, B:58:0x010c, B:63:0x0118, B:65:0x0128, B:69:0x0144, B:71:0x0154), top: B:4:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0107 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:5:0x0018, B:11:0x0039, B:15:0x004b, B:20:0x005a, B:27:0x006c, B:28:0x0071, B:33:0x0086, B:37:0x0098, B:40:0x00a4, B:43:0x00bc, B:47:0x00d0, B:49:0x00eb, B:54:0x00f7, B:56:0x0107, B:58:0x010c, B:63:0x0118, B:65:0x0128, B:69:0x0144, B:71:0x0154), top: B:4:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0118 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:5:0x0018, B:11:0x0039, B:15:0x004b, B:20:0x005a, B:27:0x006c, B:28:0x0071, B:33:0x0086, B:37:0x0098, B:40:0x00a4, B:43:0x00bc, B:47:0x00d0, B:49:0x00eb, B:54:0x00f7, B:56:0x0107, B:58:0x010c, B:63:0x0118, B:65:0x0128, B:69:0x0144, B:71:0x0154), top: B:4:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0128 A[Catch: Exception -> 0x01bc, TryCatch #0 {Exception -> 0x01bc, blocks: (B:5:0x0018, B:11:0x0039, B:15:0x004b, B:20:0x005a, B:27:0x006c, B:28:0x0071, B:33:0x0086, B:37:0x0098, B:40:0x00a4, B:43:0x00bc, B:47:0x00d0, B:49:0x00eb, B:54:0x00f7, B:56:0x0107, B:58:0x010c, B:63:0x0118, B:65:0x0128, B:69:0x0144, B:71:0x0154), top: B:4:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        boolean z2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            String queryParameter = this.$uri.getQueryParameter("client_state");
            String bytecloudOAuthState = TraeAuthStorage.INSTANCE.getBytecloudOAuthState();
            boolean z3 = true;
            if (!(bytecloudOAuthState.length() > 0)) {
                bytecloudOAuthState = null;
            }
            long bytecloudOAuthStateTimestamp = TraeAuthStorage.INSTANCE.getBytecloudOAuthStateTimestamp();
            boolean z4 = bytecloudOAuthState != null && bytecloudOAuthStateTimestamp > 0 && System.currentTimeMillis() - bytecloudOAuthStateTimestamp <= StatisticsSettings.DEFAULT_STATS_INTERVAL;
            boolean z5 = z4 && queryParameter != null && Intrinsics.areEqual(queryParameter, bytecloudOAuthState);
            boolean z6 = (bytecloudOAuthState == null || z4) ? false : true;
            if (z6) {
                TraeAuthStorage.INSTANCE.clearBytecloudOAuthState();
            }
            if ((TraeAuthStorage.INSTANCE.getJwtToken().length() > 0) && !z5) {
                FLogger.INSTANCE.mo426e("BytecloudAuth", "已登录用户收到无效 state 的回调，拒绝处理");
                return new CallbackResult.Rejected("already_logged_in_no_valid_state");
            }
            if (!z5) {
                FLogger fLogger = FLogger.INSTANCE;
                StringBuilder append = new StringBuilder("回调 state 校验失败: hasPending=").append(z4).append(", callbackState=").append(queryParameter).append(", expired=");
                if (!z6) {
                    z3 = false;
                }
                fLogger.mo426e("BytecloudAuth", append.append(z3).toString());
                return new CallbackResult.Rejected("state_mismatch");
            }
            TraeAuthStorage.INSTANCE.clearBytecloudOAuthState();
            String queryParameter2 = this.$uri.getQueryParameter("IDEUserToken");
            String queryParameter3 = this.$uri.getQueryParameter("userInfo");
            String str = queryParameter2;
            if (str != null && str.length() != 0) {
                z = false;
                if (!z) {
                    FLogger.INSTANCE.mo426e("BytecloudAuth", "回调中无 IDEUserToken");
                    return new CallbackResult.Rejected("missing_token");
                }
                String str2 = queryParameter3;
                if (str2 != null && str2.length() != 0) {
                    z2 = false;
                    if (!z2) {
                        FLogger.INSTANCE.mo426e("BytecloudAuth", "回调中无 userInfo");
                        return new CallbackResult.Rejected("missing_user_info");
                    }
                    JSONObject jSONObject = new JSONObject(queryParameter3);
                    String optString = jSONObject.optString("username", "");
                    Intrinsics.checkNotNull(optString);
                    if (optString.length() != 0) {
                        z3 = false;
                    }
                    if (z3) {
                        FLogger.INSTANCE.mo426e("BytecloudAuth", "userInfo 中无 username");
                        return new CallbackResult.Rejected("missing_username");
                    }
                    String optString2 = jSONObject.optString("employee_id", "");
                    String optString3 = jSONObject.optString("avatar_url", "");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                    String optString4 = jSONObject.optString("email", "");
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(...)");
                    String optString5 = jSONObject.optString("ai_region", "");
                    Intrinsics.checkNotNullExpressionValue(optString5, "optString(...)");
                    Intrinsics.checkNotNull(optString2);
                    UserInfo userInfo = new UserInfo(optString, optString, optString3, null, optString4, null, null, null, 0, optString5, optString2, null, 2536, null);
                    TraeAuthStorage.INSTANCE.saveJwtToken(queryParameter2, null);
                    TraeAuthStorage.INSTANCE.saveUserInfo(userInfo);
                    TraeAuthStorage.INSTANCE.saveLoginPlatform("bytecloud");
                    FLogger.INSTANCE.mo428i("BytecloudAuth", "ByteCloud 登录成功: user=" + optString);
                    return CallbackResult.Success.INSTANCE;
                }
                z2 = true;
                if (!z2) {
                }
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e("BytecloudAuth", "处理回调异常: " + e.getMessage());
            return new CallbackResult.Rejected("exception: " + e.getMessage());
        }
    }
}
