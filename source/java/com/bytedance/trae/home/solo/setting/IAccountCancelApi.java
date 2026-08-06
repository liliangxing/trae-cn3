package com.bytedance.trae.home.solo.setting;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.trae.home.solo.setting.IAccountCancelApi;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* compiled from: AccountCancelApi.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 ,2\u00020\u0001:\u0001,J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH§@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\bH§@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J.\u0010\u0014\u001a\u00020\u00152\u0014\b\u0001\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00172\b\b\u0003\u0010\u0018\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u001aJ.\u0010\u001b\u001a\u00020\u001c2\u0014\b\u0001\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00172\b\b\u0003\u0010\u0018\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u001aJ$\u0010\u001d\u001a\u00020\u001e2\u0014\b\u0001\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0017H§@¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u00020!2\u0014\b\u0001\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0017H§@¢\u0006\u0002\u0010\u001fJ,\u0010\"\u001a\u00020#2\b\b\u0001\u0010$\u001a\u00020\b2\b\b\u0003\u0010%\u001a\u00020\u00192\b\b\u0003\u0010&\u001a\u00020\u0019H§@¢\u0006\u0002\u0010'J$\u0010(\u001a\u00020)2\u0014\b\u0001\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0017H§@¢\u0006\u0002\u0010\u001fJ\u000e\u0010*\u001a\u00020+H§@¢\u0006\u0002\u0010\u0004¨\u0006-"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;", "", "cancelUserCheck", "Lcom/bytedance/trae/home/solo/setting/CancelUserCheckResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelCheck", "Lcom/bytedance/trae/home/solo/setting/CancelCheckResponse;", "valueTicket", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelConfirm", "Lcom/bytedance/trae/home/solo/setting/CancelConfirmResponse;", "token", "cancelTicket", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pwdVerify", "Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;", "body", "Lcom/bytedance/trae/home/solo/setting/PWDVerifyRequest;", "(Lcom/bytedance/trae/home/solo/setting/PWDVerifyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emailSendCode", "Lcom/bytedance/trae/home/solo/setting/EmailSendCodeResponse;", "params", "", "mixMode", "", "(Ljava/util/Map;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emailVerify", "Lcom/bytedance/trae/home/solo/setting/EmailVerifyResponse;", "authVerify", "Lcom/bytedance/trae/home/solo/setting/AuthVerifyResponse;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "smsSendCode", "Lcom/bytedance/trae/home/solo/setting/SmsSendCodeResponse;", "smsValidateCode", "Lcom/bytedance/trae/home/solo/setting/SmsValidateCodeResponse;", "code", DBData.FIELD_TYPE, "needTicket", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelLogin", "Lcom/bytedance/trae/home/solo/setting/CancelLoginResponse;", "deleteUserData", "Lcom/bytedance/trae/home/solo/setting/DeleteUserDataResponse;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IAccountCancelApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @FormUrlEncoded
    @POST("passport/auth/verify/")
    Object authVerify(@FieldMap Map<String, String> map, Continuation<? super AuthVerifyResponse> continuation);

    @GET("passport/cancel/check/")
    Object cancelCheck(@Query("value_ticket") String str, Continuation<? super CancelCheckResponse> continuation);

    @GET("passport/cancel/confirm/")
    Object cancelConfirm(@Query("value_ticket") String str, @Query("token") String str2, @Query("cancel_ticket") String str3, Continuation<? super CancelConfirmResponse> continuation);

    @FormUrlEncoded
    @POST("passport/cancel/login/")
    Object cancelLogin(@FieldMap Map<String, String> map, Continuation<? super CancelLoginResponse> continuation);

    @GET("passport/cancel/user_check/")
    Object cancelUserCheck(Continuation<? super CancelUserCheckResponse> continuation);

    @POST("cloudide/api/v3/trae/Delete")
    Object deleteUserData(Continuation<? super DeleteUserDataResponse> continuation);

    @FormUrlEncoded
    @POST("passport/email/send_code/")
    Object emailSendCode(@FieldMap Map<String, String> map, @Query("mix_mode") int i, Continuation<? super EmailSendCodeResponse> continuation);

    @FormUrlEncoded
    @POST("passport/email/verify/")
    Object emailVerify(@FieldMap Map<String, String> map, @Query("mix_mode") int i, Continuation<? super EmailVerifyResponse> continuation);

    @POST("passport/account/verify/")
    Object pwdVerify(@Body PWDVerifyRequest pWDVerifyRequest, Continuation<? super PWDVerifyResponse> continuation);

    @FormUrlEncoded
    @POST("passport/mobile/send_code/")
    Object smsSendCode(@FieldMap Map<String, String> map, Continuation<? super SmsSendCodeResponse> continuation);

    @GET("passport/mobile/validate_code/")
    Object smsValidateCode(@Query("code") String str, @Query("type") int i, @Query("need_ticket") int i2, Continuation<? super SmsValidateCodeResponse> continuation);

    /* compiled from: AccountCancelApi.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object emailSendCode$default(IAccountCancelApi iAccountCancelApi, Map map, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: emailSendCode");
            }
            if ((i2 & 2) != 0) {
                i = 1;
            }
            return iAccountCancelApi.emailSendCode(map, i, continuation);
        }

        public static /* synthetic */ Object emailVerify$default(IAccountCancelApi iAccountCancelApi, Map map, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: emailVerify");
            }
            if ((i2 & 2) != 0) {
                i = 1;
            }
            return iAccountCancelApi.emailVerify(map, i, continuation);
        }

        public static /* synthetic */ Object smsValidateCode$default(IAccountCancelApi iAccountCancelApi, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: smsValidateCode");
            }
            if ((i3 & 2) != 0) {
                i = 22;
            }
            if ((i3 & 4) != 0) {
                i2 = 1;
            }
            return iAccountCancelApi.smsValidateCode(str, i, i2, continuation);
        }
    }

    /* compiled from: AccountCancelApi.kt */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ.\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ$\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\"H\u0086@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010)\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010\t¨\u0006-"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;", "", "<init>", "()V", "createService", "Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;", "createTraeService", "userCheck", "Lcom/bytedance/trae/home/solo/setting/CancelUserCheckResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelCheck", "Lcom/bytedance/trae/home/solo/setting/CancelCheckResponse;", "valueTicket", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirm", "Lcom/bytedance/trae/home/solo/setting/CancelConfirmResponse;", "token", "cancelTicket", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pwdVerify", "Lcom/bytedance/trae/home/solo/setting/PWDVerifyResponse;", IGoogleService.ResponseKey.PASSWORD, "hexMix", "value", "sendEmailCode", "Lcom/bytedance/trae/home/solo/setting/EmailSendCodeResponse;", "email", "verifyEmailCode", "Lcom/bytedance/trae/home/solo/setting/EmailVerifyResponse;", "code", "authVerify", "Lcom/bytedance/trae/home/solo/setting/AuthVerifyResponse;", "params", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSmsCode", "Lcom/bytedance/trae/home/solo/setting/SmsSendCodeResponse;", "mobile", "verifySmsCode", "Lcom/bytedance/trae/home/solo/setting/SmsValidateCodeResponse;", "restoreAccount", "Lcom/bytedance/trae/home/solo/setting/CancelLoginResponse;", "deleteUserData", "Lcom/bytedance/trae/home/solo/setting/DeleteUserDataResponse;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final IAccountCancelApi createService() {
            return (IAccountCancelApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "account_cancel", IAccountCancelApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.ONLINE), (Map) null, false, 52, (Object) null);
        }

        private final IAccountCancelApi createTraeService() {
            String str = "";
            try {
                ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                if (xTToken != null) {
                    str = xTToken;
                }
            } catch (Exception unused) {
            }
            Map createMapBuilder = MapsKt.createMapBuilder();
            if (str.length() > 0) {
                createMapBuilder.put("X-Cloudide-Token", str);
            }
            return (IAccountCancelApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "account_cancel_trae", IAccountCancelApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.ONLINE), MapsKt.build(createMapBuilder), false, 36, (Object) null);
        }

        public final Object userCheck(Continuation<? super CancelUserCheckResponse> continuation) {
            return createService().cancelUserCheck(continuation);
        }

        public final Object cancelCheck(String str, Continuation<? super CancelCheckResponse> continuation) {
            return createService().cancelCheck(str, continuation);
        }

        public static /* synthetic */ Object confirm$default(Companion companion, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.confirm(str, str2, str3, continuation);
        }

        public final Object confirm(String str, String str2, String str3, Continuation<? super CancelConfirmResponse> continuation) {
            return createService().cancelConfirm(str, str2, str3, continuation);
        }

        public final Object pwdVerify(String str, Continuation<? super PWDVerifyResponse> continuation) {
            return createService().pwdVerify(new PWDVerifyRequest(str), continuation);
        }

        private final String hexMix(String value) {
            byte[] bytes = value.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return ArraysKt.joinToString$default(bytes, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.home.solo.setting.IAccountCancelApi$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    CharSequence hexMix$lambda$1;
                    hexMix$lambda$1 = IAccountCancelApi.Companion.hexMix$lambda$1(((Byte) obj).byteValue());
                    return hexMix$lambda$1;
                }
            }, 30, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence hexMix$lambda$1(byte b) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf((b ^ 5) & ReducerConstants.REQUEST_CODE)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }

        public final Object sendEmailCode(String str, Continuation<? super EmailSendCodeResponse> continuation) {
            return DefaultImpls.emailSendCode$default(createService(), MapsKt.mapOf(new Pair[]{TuplesKt.to("email", hexMix(str)), TuplesKt.to(DBData.FIELD_TYPE, hexMix("15")), TuplesKt.to(IGoogleService.ResponseKey.PASSWORD, hexMix(""))}), 0, continuation, 2, null);
        }

        public final Object verifyEmailCode(String str, Continuation<? super EmailVerifyResponse> continuation) {
            return DefaultImpls.emailVerify$default(createService(), MapsKt.mapOf(new Pair[]{TuplesKt.to(DBData.FIELD_TYPE, hexMix("15")), TuplesKt.to("code", hexMix(str))}), 0, continuation, 2, null);
        }

        public final Object authVerify(Map<String, String> map, Continuation<? super AuthVerifyResponse> continuation) {
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : entrySet) {
                if (((Map.Entry) obj).getValue() != null) {
                    arrayList.add(obj);
                }
            }
            ArrayList<Map.Entry> arrayList2 = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
            for (Map.Entry entry : arrayList2) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value);
                Pair pair = TuplesKt.to(key, value);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return createService().authVerify(linkedHashMap, continuation);
        }

        public final Object sendSmsCode(String str, Continuation<? super SmsSendCodeResponse> continuation) {
            return createService().smsSendCode(MapsKt.mapOf(new Pair[]{TuplesKt.to("mobile", str), TuplesKt.to(DBData.FIELD_TYPE, "22")}), continuation);
        }

        public final Object verifySmsCode(String str, Continuation<? super SmsValidateCodeResponse> continuation) {
            return DefaultImpls.smsValidateCode$default(createService(), str, 0, 0, continuation, 6, null);
        }

        public final Object restoreAccount(String str, Continuation<? super CancelLoginResponse> continuation) {
            return createService().cancelLogin(MapsKt.mapOf(new Pair[]{TuplesKt.to("token", str), TuplesKt.to("restoreType", "1")}), continuation);
        }

        public final Object deleteUserData(Continuation<? super DeleteUserDataResponse> continuation) {
            return createTraeService().deleteUserData(continuation);
        }
    }
}
