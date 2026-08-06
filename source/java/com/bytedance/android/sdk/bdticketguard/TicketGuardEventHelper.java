package com.bytedance.android.sdk.bdticketguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: TicketGuardEventHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001fH\u0007J\b\u0010$\u001a\u00020!H\u0007J\u001a\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010)\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001fH\u0007J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,JN\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u00020\r2\b\b\u0002\u00100\u001a\u00020\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\r2\u0012\b\u0002\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u000103J\"\u00104\u001a\u00020!2\u0006\u00100\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u001f2\u0006\u00105\u001a\u00020\u0004H\u0007J*\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020(H\u0007J:\u00109\u001a\u00020!2\u0006\u00100\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010:\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\rH\u0007J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\rH\u0007J*\u0010=\u001a\u00020!2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020(H\u0007J*\u0010>\u001a\u00020!2\u0006\u00100\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010:\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\rH\u0007J\u0010\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020AH\u0007J\u001e\u0010B\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\rJ\b\u0010E\u001a\u00020!H\u0007J\u0010\u0010F\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\rJ\u0006\u0010G\u001a\u00020!J\u000e\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\rJ\u0012\u0010J\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010K\u001a\u00020!H\u0007J\u0010\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020\rH\u0007J \u0010N\u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010O\u001a\u00020\r2\u0006\u0010<\u001a\u00020\rH\u0007J\u001a\u0010P\u001a\u00020!2\u0006\u00108\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\rH\u0007J2\u0010Q\u001a\u00020!2\u0006\u00108\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u001f2\u0006\u00105\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\rH\u0007J*\u0010R\u001a\u00020!2\u0006\u00108\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\rH\u0007J\u000e\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020UJ\\\u0010V\u001a\u00020!2\u0006\u00108\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\r2\b\u0010W\u001a\u0004\u0018\u00010\r2\u0006\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020\u00182\u0006\u0010[\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u0018H\u0007J\b\u0010]\u001a\u00020!H\u0007J2\u0010^\u001a\u00020!2\u0006\u00100\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020(2\u0006\u00105\u001a\u00020\u00042\u0006\u00107\u001a\u00020\rH\u0007J\u000e\u0010_\u001a\u00020!2\u0006\u0010I\u001a\u00020\rJ\u0010\u0010`\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0007J0\u0010`\u001a\u00020!2\u0006\u00107\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010a\u001a\u00020\r2\u0006\u0010b\u001a\u00020\r2\u0006\u0010c\u001a\u00020\rH\u0007J\u0018\u0010d\u001a\u00020!2\u0006\u0010e\u001a\u00020\r2\u0006\u0010f\u001a\u00020gH\u0007J\f\u0010h\u001a\u00020\u0004*\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006i"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardEventHelper;", "", "()V", "ERROR_CODE_GEN_CSR_GEN_CSR_ERROR", "", "ERROR_CODE_GEN_CSR_GET_PUBLIC_KEY_ERROR", "ERROR_CODE_SIGN_EMPTY_CERT", "ERROR_CODE_SIGN_EMPTY_SERVER_DATA", "ERROR_CODE_SIGN_SIGN_EMPTY_PRIVATE_KEY", "ERROR_CODE_SIGN_SIGN_ERROR", "ERROR_CODE_SUCCESS", "ERROR_CODE_UNKNOWN_ERROR", "ERROR_DESC_SIGN_EMPTY_CACHED_SERVER_DATA", "", "ERROR_DESC_SIGN_EMPTY_CLIENT_CERT", "ERROR_DESC_SIGN_EMPTY_PRIVATE_KEY", "SP_DID_REPORT", "didReportSp", "Landroid/content/SharedPreferences;", "getDidReportSp", "()Landroid/content/SharedPreferences;", "didReportSp$delegate", "Lkotlin/Lazy;", "enableFullPathTrack", "", "getEnableFullPathTrack", "()Z", "setEnableFullPathTrack", "(Z)V", "getErrorDesc", "throwable", "", "monitorContainsAliasError", "", "scene", "e", "monitorContainsAliasNotMatch", "monitorDecryptResult", InternalWatcher.PARAM_SPEC_ERROR_DESC, "duration", "", "monitorDeltaInsFail", "monitorFirstVerifyFail", "consumerResponseContent", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerResponseContent;", "monitorFullLog", "event_type", "ticket_name", "error_code", "extraInfo", "buildExtraInfo", "Lkotlin/Function0;", "monitorGenCsr", "attemptCount", "monitorGetConsumerHeaders", "path", "isSuccess", "monitorGetKeyPair", "isGen", "monitorGetPackageProcessNameError", "stacktrace", "monitorGetProviderHeaders", "monitorGetReeKeyPair", "monitorGetTicket", "providerResponseContent", "Lcom/bytedance/android/sdk/bdticketguard/ProviderResponseContent;", "monitorGetTicketResponse", "ticket", "ts_sign", "monitorKeyNotMatch", "monitorLoadLocalCertFail", "monitorLoadLocalCertStart", "monitorLoadLocalCertSuccess", "client_cert", "monitorLoadRemoteCertFail", "monitorLoadRemoteCertStart", "monitorLoadRemoteCertSuccess", "sn", "monitorParseJsonError", "originalText", "monitorParseServerCert", "monitorRealSign", "monitorReeRealSign", "monitorRemoveTicketData", "ticketDataBean", "Lcom/bytedance/android/sdk/bdticketguard/TicketDataBean;", "monitorRequestCert", "logid", "hasLocalClient", "hasLocalServer", "hasRemoteClient", "hasRemoteServer", "hasRemoteServerSn", "monitorSdkLaunch", "monitorSign", "monitorUpdateLocalCert", "monitorUseTicketFail", "local_error", "remote_error", TicketGuardProviderKt.PARAM_SIGN_TYPE, "onEvent", "event", "params", "Lorg/json/JSONObject;", "toEventInt", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardEventHelper {
    public static final int ERROR_CODE_GEN_CSR_GEN_CSR_ERROR = 3001;
    public static final int ERROR_CODE_GEN_CSR_GET_PUBLIC_KEY_ERROR = 3000;
    public static final int ERROR_CODE_SIGN_EMPTY_CERT = 4000;
    public static final int ERROR_CODE_SIGN_EMPTY_SERVER_DATA = 4001;
    public static final int ERROR_CODE_SIGN_SIGN_EMPTY_PRIVATE_KEY = 4002;
    public static final int ERROR_CODE_SIGN_SIGN_ERROR = 4003;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_UNKNOWN_ERROR = -1;
    public static final String ERROR_DESC_SIGN_EMPTY_CACHED_SERVER_DATA = "empty cached server_data";
    public static final String ERROR_DESC_SIGN_EMPTY_CLIENT_CERT = "empty client cert";
    public static final String ERROR_DESC_SIGN_EMPTY_PRIVATE_KEY = "empty private key";
    public static final String SP_DID_REPORT = "TicketGuardEventHelper_didReport";
    private static boolean enableFullPathTrack;
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TicketGuardEventHelper.class), "didReportSp", "getDidReportSp()Landroid/content/SharedPreferences;"))};
    public static final TicketGuardEventHelper INSTANCE = new TicketGuardEventHelper();

    /* renamed from: didReportSp$delegate, reason: from kotlin metadata */
    private static final Lazy didReportSp = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper$didReportSp$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences m401invoke() {
            TicketGuardInitParam ticketGuardInitParam;
            Context applicationContext;
            TicketGuardManager manager = TicketGuardInnerFrameWork.INSTANCE.getManager();
            if (manager == null || (ticketGuardInitParam = manager.getTicketGuardInitParam()) == null || (applicationContext = ticketGuardInitParam.getApplicationContext()) == null) {
                return null;
            }
            return applicationContext.getSharedPreferences(TicketGuardEventHelper.SP_DID_REPORT, 0);
        }
    });

    private final SharedPreferences getDidReportSp() {
        Lazy lazy = didReportSp;
        KProperty kProperty = $$delegatedProperties[0];
        return (SharedPreferences) lazy.getValue();
    }

    private final int toEventInt(boolean z) {
        return z ? 1 : 0;
    }

    private TicketGuardEventHelper() {
    }

    public final boolean getEnableFullPathTrack() {
        return enableFullPathTrack;
    }

    public final void setEnableFullPathTrack(boolean z) {
        enableFullPathTrack = z;
    }

    private final String getErrorDesc(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        String stackTraceString = Log.getStackTraceString(throwable);
        Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(throwable)");
        return stackTraceString;
    }

    @JvmStatic
    public static final void monitorSdkLaunch() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdk_aid", 31749);
        jSONObject.put("sdk_version", "2.1.15-rc.1.1-bugfix");
        onEvent("sdk_session_launch", jSONObject);
    }

    @JvmStatic
    public static final void monitorGetKeyPair(int error_code, Throwable error_desc, long duration, boolean isGen, int attemptCount, String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", error_code);
        TicketGuardEventHelper ticketGuardEventHelper = INSTANCE;
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, ticketGuardEventHelper.getErrorDesc(error_desc));
        jSONObject.put("duration", duration);
        jSONObject.put("is_first_generate", isGen ? 1 : 0);
        jSONObject.put("attempt_count", attemptCount);
        jSONObject.put("scene", scene);
        jSONObject.put("key_type", TicketGuardApiKt.INIT_STATUS_TEE);
        onEvent("bd_ticket_guard_get_private_key", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("attempt_count", attemptCount);
        jSONObject2.put("scene", scene);
        jSONObject2.put("duration", duration);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "JSONObject().apply {\n   …ion)\n        }.toString()");
        if (isGen) {
            monitorFullLog$default(ticketGuardEventHelper, "create_tee_private_key", null, error_code, ticketGuardEventHelper.getErrorDesc(error_desc), jSONObject3, null, 34, null);
        } else {
            monitorFullLog$default(ticketGuardEventHelper, "load_tee_private_key", null, error_code, ticketGuardEventHelper.getErrorDesc(error_desc), jSONObject3, null, 34, null);
        }
    }

    @JvmStatic
    public static final void monitorGetReeKeyPair(int error_code, String error_desc, boolean isGen, String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", error_code);
        if (error_desc != null) {
            jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, error_desc);
        }
        TicketGuardEventHelper ticketGuardEventHelper = INSTANCE;
        jSONObject.put("is_first_generate", ticketGuardEventHelper.toEventInt(isGen));
        jSONObject.put("scene", scene);
        jSONObject.put("key_type", TicketGuardApiKt.INIT_STATUS_REE);
        onEvent("bd_ticket_guard_get_private_key", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("scene", scene);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "JSONObject().apply {\n   …ene)\n        }.toString()");
        if (isGen) {
            monitorFullLog$default(ticketGuardEventHelper, "create_ree_private_key", null, error_code, error_desc, jSONObject3, null, 34, null);
        } else {
            monitorFullLog$default(ticketGuardEventHelper, "load_ree_private_key", null, error_code, error_desc, jSONObject3, null, 34, null);
        }
    }

    @JvmStatic
    public static final void monitorGenCsr(int error_code, Throwable error_desc, int attemptCount) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", error_code);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, INSTANCE.getErrorDesc(error_desc));
        jSONObject.put("attempt_count", attemptCount);
        onEvent("bd_ticket_guard_get_csr", jSONObject);
    }

    @JvmStatic
    public static final void monitorGetTicket(final ProviderResponseContent providerResponseContent) {
        String str;
        ProviderRequestContent requestContent;
        ProviderRequestContent requestContent2;
        ProviderRequestParam requestParam;
        ProviderRequestContent requestContent3;
        Intrinsics.checkParameterIsNotNull(providerResponseContent, "providerResponseContent");
        HandleProviderResponseParam responseParam = providerResponseContent.getResponseParam();
        String str2 = null;
        long longValue = (responseParam != null ? Long.valueOf(responseParam.getTiming()) : null).longValue();
        HandleProviderResponseParam responseParam2 = providerResponseContent.getResponseParam();
        long longValue2 = longValue - ((responseParam2 == null || (requestContent3 = responseParam2.getRequestContent()) == null) ? null : Long.valueOf(requestContent3.getTiming())).longValue();
        HandleProviderResponseParam responseParam3 = providerResponseContent.getResponseParam();
        if (responseParam3 == null || (requestContent2 = responseParam3.getRequestContent()) == null || (requestParam = requestContent2.getRequestParam()) == null || (str = requestParam.getPath()) == null) {
            str = "";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("duration", longValue2);
        HandleProviderResponseParam responseParam4 = providerResponseContent.getResponseParam();
        if (responseParam4 != null && (requestContent = responseParam4.getRequestContent()) != null) {
            str2 = requestContent.getRequestCert();
        }
        String str3 = str2;
        jSONObject.put("local_client_cert", ((str3 == null || str3.length() == 0) ? 1 : 0) ^ 1);
        String responseCert = providerResponseContent.getResponseCert();
        jSONObject.put("remote_client_cert", ((responseCert == null || responseCert.length() == 0) ? 1 : 0) ^ 1);
        jSONObject.put("path", str);
        jSONObject.put("server_data", providerResponseContent.getServerDataStr());
        jSONObject.put("logid", providerResponseContent.getLogid());
        onEvent("bd_ticket_guard_get_ticket", jSONObject);
        monitorFullLog$default(INSTANCE, "get_ticket_response", null, 0, null, null, new Function0<String>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper$monitorGetTicket$2
            public String invoke() {
                return TicketGuardApiKt.getGson().toJson(new GetTicketSnapshot(ProviderResponseContent.this));
            }
        }, 30, null);
    }

    @JvmStatic
    public static final void monitorSign(int error_code, String error_desc, long duration, int attemptCount, String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", error_code);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, error_desc);
        jSONObject.put("duration", duration);
        jSONObject.put("attempt_count", attemptCount);
        jSONObject.put("path", path);
        onEvent("bd_ticket_guard_sign_client_data", jSONObject);
    }

    @JvmStatic
    public static final void monitorRealSign(boolean isSuccess, Throwable error_desc, int attemptCount, long duration, String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", isSuccess ? 0 : -1);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, INSTANCE.getErrorDesc(error_desc));
        jSONObject.put("attempt_count", attemptCount);
        jSONObject.put("duration", duration);
        jSONObject.put("path", path);
        jSONObject.put("key_type", TicketGuardApiKt.INIT_STATUS_TEE);
        onEvent("bd_ticket_guard_create_signature", jSONObject);
    }

    @JvmStatic
    public static final void monitorReeRealSign(boolean isSuccess, String error_desc, long duration, String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", isSuccess ? 0 : -1);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, error_desc);
        jSONObject.put("duration", duration);
        jSONObject.put("path", path);
        jSONObject.put("key_type", TicketGuardApiKt.INIT_STATUS_REE);
        onEvent("bd_ticket_guard_create_signature", jSONObject);
    }

    @JvmStatic
    public static final void monitorKeyNotMatch() {
        onEvent("bd_ticket_guard_key_cert_not_match", new JSONObject());
    }

    @JvmStatic
    public static final void monitorRequestCert(boolean isSuccess, String error_desc, long duration, String scene, String logid, boolean hasLocalClient, boolean hasLocalServer, boolean hasRemoteClient, boolean hasRemoteServer, boolean hasRemoteServerSn) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", isSuccess ? 0 : -1);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, error_desc);
        jSONObject.put("duration", duration);
        jSONObject.put("scene", scene);
        jSONObject.put("logid", logid);
        TicketGuardEventHelper ticketGuardEventHelper = INSTANCE;
        jSONObject.put("local_client_cert", ticketGuardEventHelper.toEventInt(hasLocalClient));
        jSONObject.put("local_server_cert", ticketGuardEventHelper.toEventInt(hasLocalServer));
        jSONObject.put("local_server_cert_sn", ticketGuardEventHelper.toEventInt(hasLocalServer));
        jSONObject.put("remote_client_cert", ticketGuardEventHelper.toEventInt(hasRemoteClient));
        jSONObject.put("remote_server_cert", ticketGuardEventHelper.toEventInt(hasRemoteServer));
        jSONObject.put("remote_server_cert_sn", ticketGuardEventHelper.toEventInt(hasRemoteServerSn));
        onEvent("bd_ticket_guard_get_cert", jSONObject);
    }

    @JvmStatic
    public static final void monitorParseServerCert(boolean isSuccess, String error_desc) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", isSuccess ? 0 : -1);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, error_desc);
        onEvent("bd_ticket_guard_parse_server", jSONObject);
    }

    @JvmStatic
    public static final void monitorDecryptResult(Throwable error_desc, long duration) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error_code", error_desc == null ? 0 : -1);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, INSTANCE.getErrorDesc(error_desc));
        jSONObject.put("duration", duration);
        onEvent("bd_ticket_guard_decrypt_result", jSONObject);
    }

    @JvmStatic
    public static final void monitorGetProviderHeaders(String path, boolean isSuccess, String error_desc, long duration) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("path", path);
        jSONObject.put("error_code", isSuccess ? 0 : -1);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, error_desc);
        jSONObject.put("duration", duration);
        onEvent("bd_ticket_guard_add_get_ticket_headers", jSONObject);
    }

    @JvmStatic
    public static final void monitorGetConsumerHeaders(String path, boolean isSuccess, String error_desc, long duration) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("path", path);
        jSONObject.put("error_code", isSuccess ? 0 : -1);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, error_desc);
        jSONObject.put("duration", duration);
        onEvent("bd_ticket_guard_add_use_ticket_headers", jSONObject);
    }

    @JvmStatic
    public static final void monitorDeltaInsFail(Throwable e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, INSTANCE.getErrorDesc(e));
        onEvent("bd_ticket_guard_delta_instance_fail", jSONObject);
    }

    @JvmStatic
    public static final void monitorContainsAliasError(String scene, Throwable e) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(e, "e");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scene", scene);
        jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, INSTANCE.getErrorDesc(e));
        onEvent("bd_ticket_guard_contains_alias_error", jSONObject);
    }

    @JvmStatic
    public static final void monitorContainsAliasNotMatch() {
        onEvent("bd_ticket_guard_contains_alias_not_match", new JSONObject());
    }

    @JvmStatic
    public static final void monitorUseTicketFail(String path, String logid, String local_error, String remote_error, String sign_type) {
        String str;
        String reeCreateLog;
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(logid, "logid");
        Intrinsics.checkParameterIsNotNull(local_error, "local_error");
        Intrinsics.checkParameterIsNotNull(remote_error, "remote_error");
        Intrinsics.checkParameterIsNotNull(sign_type, TicketGuardProviderKt.PARAM_SIGN_TYPE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("path", path);
        jSONObject.put("logid", logid);
        jSONObject.put("local_error", local_error);
        jSONObject.put("remote_error", remote_error);
        jSONObject.put(TicketGuardProviderKt.PARAM_SIGN_TYPE, sign_type);
        TicketGuardManager manager = TicketGuardInnerFrameWork.INSTANCE.getManager();
        String str2 = "";
        if (manager == null || (str = manager.getTeeCreateLog()) == null) {
            str = "";
        }
        jSONObject.put("tee_private_key_create_log", str);
        TicketGuardManager manager2 = TicketGuardInnerFrameWork.INSTANCE.getManager();
        if (manager2 != null && (reeCreateLog = manager2.getReeCreateLog()) != null) {
            str2 = reeCreateLog;
        }
        jSONObject.put("ree_private_key_create_log", str2);
        onEvent("bd_ticket_guard_use_ticket_fail", jSONObject);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r1, "0")) != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void monitorUseTicketFail(ConsumerResponseContent consumerResponseContent) {
        String str;
        String str2;
        String str3;
        String reeCreateLog;
        ConsumerRequestContent requestContent;
        ConsumerRequestContent requestContent2;
        ConsumerRequestParam requestParam;
        ConsumerRequestContent requestContent3;
        Intrinsics.checkParameterIsNotNull(consumerResponseContent, "consumerResponseContent");
        HandleConsumerResponseParam responseParam = consumerResponseContent.getResponseParam();
        String errorDesc = (responseParam == null || (requestContent3 = responseParam.getRequestContent()) == null) ? null : requestContent3.getErrorDesc();
        String remoteError = consumerResponseContent.getRemoteError();
        String str4 = errorDesc;
        boolean z = false;
        if (str4 == null || str4.length() == 0) {
            if (remoteError.length() > 0) {
            }
            if (z) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            HandleConsumerResponseParam responseParam2 = consumerResponseContent.getResponseParam();
            String str5 = "";
            if (responseParam2 == null || (requestContent2 = responseParam2.getRequestContent()) == null || (requestParam = requestContent2.getRequestParam()) == null || (str = requestParam.getPath()) == null) {
                str = "";
            }
            jSONObject.put("path", str);
            jSONObject.put("logid", consumerResponseContent.getLogid());
            jSONObject.put("local_error", errorDesc);
            jSONObject.put("remote_error", remoteError);
            HandleConsumerResponseParam responseParam3 = consumerResponseContent.getResponseParam();
            if (responseParam3 == null || (requestContent = responseParam3.getRequestContent()) == null || (str2 = requestContent.getKeyType()) == null) {
                str2 = "";
            }
            jSONObject.put(TicketGuardProviderKt.PARAM_SIGN_TYPE, str2);
            TicketGuardManager manager = TicketGuardInnerFrameWork.INSTANCE.getManager();
            if (manager == null || (str3 = manager.getTeeCreateLog()) == null) {
                str3 = "";
            }
            jSONObject.put("tee_private_key_create_log", str3);
            TicketGuardManager manager2 = TicketGuardInnerFrameWork.INSTANCE.getManager();
            if (manager2 != null && (reeCreateLog = manager2.getReeCreateLog()) != null) {
                str5 = reeCreateLog;
            }
            jSONObject.put("ree_private_key_create_log", str5);
            onEvent("bd_ticket_guard_use_ticket_fail", jSONObject);
            INSTANCE.monitorFirstVerifyFail(consumerResponseContent);
            return;
        }
        z = true;
        if (z) {
        }
    }

    @JvmStatic
    public static final void monitorParseJsonError(String scene, String originalText, String stacktrace) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(originalText, "originalText");
        Intrinsics.checkParameterIsNotNull(stacktrace, "stacktrace");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scene", scene);
        jSONObject.put("original_text", originalText);
        jSONObject.put("stacktrace", stacktrace);
        onEvent("bd_ticket_guard_parse_json_error", jSONObject);
    }

    @JvmStatic
    public static final void monitorGetPackageProcessNameError(String stacktrace) {
        Intrinsics.checkParameterIsNotNull(stacktrace, "stacktrace");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("stacktrace", stacktrace);
        onEvent("bd_ticket_guard_get_package_process_name_error", jSONObject);
    }

    @JvmStatic
    public static final void monitorLoadRemoteCertStart() {
        monitorFullLog$default(INSTANCE, "load_remote_cert_start", null, 0, null, null, null, 62, null);
    }

    @JvmStatic
    public static final void monitorLoadRemoteCertSuccess(String sn) {
        Intrinsics.checkParameterIsNotNull(sn, "sn");
        TicketGuardEventHelper ticketGuardEventHelper = INSTANCE;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sn", SnapshotKt.mask(sn));
        monitorFullLog$default(ticketGuardEventHelper, "load_remote_cert_finish", null, 0, null, jSONObject.toString(), null, 46, null);
    }

    @JvmStatic
    public static final void monitorLoadRemoteCertFail(String error_desc) {
        monitorFullLog$default(INSTANCE, "load_remote_cert_finish", null, -1, error_desc, null, null, 50, null);
    }

    public final void monitorUpdateLocalCert(String client_cert) {
        Intrinsics.checkParameterIsNotNull(client_cert, "client_cert");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("client_cert", client_cert);
        monitorFullLog$default(this, "update_local_cert", null, 0, null, jSONObject.toString(), null, 46, null);
    }

    public final void monitorLoadLocalCertStart() {
        monitorFullLog$default(this, "load_local_cert_start", null, 0, null, null, null, 62, null);
    }

    public final void monitorLoadLocalCertSuccess(String client_cert) {
        Intrinsics.checkParameterIsNotNull(client_cert, "client_cert");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("client_cert", SnapshotKt.mask(client_cert));
        monitorFullLog$default(this, "load_local_cert_finish", null, 0, null, jSONObject.toString(), null, 46, null);
    }

    public final void monitorLoadLocalCertFail(String error_desc) {
        monitorFullLog$default(this, "load_local_cert_finish", null, -1, error_desc, null, null, 50, null);
    }

    public final void monitorGetTicketResponse(String ticket_name, String ticket, String ts_sign) {
        Intrinsics.checkParameterIsNotNull(ticket_name, "ticket_name");
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        Intrinsics.checkParameterIsNotNull(ts_sign, "ts_sign");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ticket", SnapshotKt.mask(ticket));
        jSONObject.put("ts_sign", SnapshotKt.mask(ts_sign));
        monitorFullLog$default(this, "ticket_sign_update", ticket_name, 0, null, jSONObject.toString(), null, 44, null);
    }

    public final void monitorFirstVerifyFail(final ConsumerResponseContent consumerResponseContent) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        Intrinsics.checkParameterIsNotNull(consumerResponseContent, "consumerResponseContent");
        boolean z = false;
        if (StringsKt.startsWith$default(consumerResponseContent.getRemoteError(), "12", false, 2, (Object) null)) {
            String target = consumerResponseContent.getResponseParam().getRequestContent().getRequestParam().getTarget();
            if (target.length() == 0) {
                return;
            }
            SharedPreferences didReportSp2 = getDidReportSp();
            if (didReportSp2 != null && didReportSp2.getBoolean(target, false)) {
                z = true;
            }
            if (z) {
                return;
            }
            SharedPreferences didReportSp3 = getDidReportSp();
            if (didReportSp3 != null && (edit = didReportSp3.edit()) != null && (putBoolean = edit.putBoolean(target, true)) != null) {
                putBoolean.apply();
            }
            monitorFullLog$default(this, "sign_verify_fail_info_update", consumerResponseContent.getResponseParam().getRequestContent().getRequestParam().getTicketName(), 0, null, null, new Function0<String>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper$monitorFirstVerifyFail$1
                public String invoke() {
                    String json = TicketGuardApiKt.getGson().toJson(new UseTicketSnapshot(ConsumerResponseContent.this));
                    Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(UseTicketSna…consumerResponseContent))");
                    return json;
                }
            }, 28, null);
        }
    }

    public final void monitorRemoveTicketData(TicketDataBean ticketDataBean) {
        Intrinsics.checkParameterIsNotNull(ticketDataBean, "ticketDataBean");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ticket", SnapshotKt.mask(ticketDataBean.getTicket()));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().apply {\n   …k())\n        }.toString()");
        monitorFullLog$default(this, "remove_ticket_data", ticketDataBean.getType(), 0, "cert not match key", jSONObject2, null, 36, null);
    }

    public static /* synthetic */ void monitorFullLog$default(TicketGuardEventHelper ticketGuardEventHelper, String str, String str2, int i, String str3, String str4, Function0 function0, int i2, Object obj) {
        String str5;
        String str6;
        Function0 function02;
        if ((i2 & 2) != 0) {
            str2 = WsChannelMultiProcessSharedProvider.ALL_TYPE;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i2 & 16) != 0) {
            str6 = null;
        } else {
            str6 = str4;
        }
        if ((i2 & 32) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        ticketGuardEventHelper.monitorFullLog(str, str7, i3, str5, str6, function02);
    }

    public final void monitorFullLog(String event_type, String ticket_name, int error_code, String error_desc, String extraInfo, Function0<String> buildExtraInfo) {
        Intrinsics.checkParameterIsNotNull(event_type, "event_type");
        Intrinsics.checkParameterIsNotNull(ticket_name, "ticket_name");
        if (enableFullPathTrack) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", event_type);
            jSONObject.put("ticket_name", ticket_name);
            jSONObject.put("error_code", error_code);
            jSONObject.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, error_desc);
            if (extraInfo == null) {
                extraInfo = buildExtraInfo != null ? (String) buildExtraInfo.invoke() : null;
            }
            jSONObject.put("extra_info", String.valueOf(extraInfo));
            onEvent("bd_ticket_guard_full_path", jSONObject);
        }
    }

    @JvmStatic
    public static final void onEvent(String event, JSONObject params) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        Intrinsics.checkParameterIsNotNull(params, "params");
        params.put("params_for_special", "uc_login");
        params.put("bd_ticket_sdk_version", "2.1.15-rc.1.1-bugfix");
        TicketGuardManager manager = TicketGuardInnerFrameWork.INSTANCE.getManager();
        if (manager != null) {
            manager.onEvent(event, params);
        }
    }
}
