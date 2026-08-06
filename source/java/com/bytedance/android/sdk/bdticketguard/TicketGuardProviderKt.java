package com.bytedance.android.sdk.bdticketguard;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0015\u0010N\u001a\u00020\u00012\b\u0010O\u001a\u0004\u0018\u00010P¢\u0006\u0002\u0010Q\u001a\u0012\u0010R\u001a\u00020\u00152\b\u0010S\u001a\u0004\u0018\u00010TH\u0002\u001a\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0015H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010?\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010@\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010C\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010D\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010E\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010F\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010L\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010M\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"CODE_CLEAR_SERVER_CERT", "", "CODE_DECRYPT", "CODE_DELTA_PUBLIC_KEY", "CODE_ENCRYPT", "CODE_QUERY_CLIENT_CERT", "CODE_QUERY_CSR", "CODE_QUERY_LOAD", "CODE_QUERY_NEED_REE", "CODE_QUERY_REE_CREATE_LOG", "CODE_QUERY_SERVER_CERT", "CODE_QUERY_TEE_CREATE_LOG", "CODE_QUERY_TEE_EVER_FAIL", "CODE_QUERY_TEE_PUB", "CODE_QUERY_TICKET_DATA", "CODE_REE_PUB_KEY", "CODE_SIGN", "CODE_UPDATE_CERT", "CODE_UPDATE_TEE_EVER_FAIL", "CODE_UPDATE_TICKET_DATA", "COL_BASE64_SIGNED", "", "COL_CERT", "COL_CLIENT_CERT", "COL_CSR", "COL_DECRYPTED", "COL_DELTA_PUBLIC_KEY", "COL_ENCRYPTED", "COL_EXCEPTION_MESSAGE", "COL_NEED_REE", "COL_PUBLIC_KEY", "COL_REE_CREATE_LOG", "COL_REE_PUB_KEY", "COL_SERIAL_NUMBER", "COL_SERVER_CERT_STRING", "COL_TEE_CREATE_LOG", "COL_TEE_EVER_FAIL", "COL_TEE_PUB", "COL_TS_SIGN", "COL_TS_SIGN_REE", "COL_TYPE", "NOTIFY_PATH_LOAD_RESULT", "PARAM_CERT", "PARAM_CLIENT_CERT", "PARAM_CONTENT", "PARAM_ID", "PARAM_PATH", "PARAM_RESULT", "PARAM_SCENE", "PARAM_SERVER_CERT", "PARAM_SIGN_TYPE", "PARAM_TEE_FAIL_REASON", "PARAM_TICKET", "PARAM_TS_SIGN", "PARAM_TS_SIGN_REE", "PARAM_TYPE", "PARAM_UNSIGNED", "PATH_CLEAR_SERVER_CERT", "PATH_DECRYPT", "PATH_DELTA_PUBLIC_KEY", "PATH_ENCRYPT", "PATH_QUERY_CLIENT_CERT", "PATH_QUERY_CSR", "PATH_QUERY_LOAD", "PATH_QUERY_NEED_REE", "PATH_QUERY_REE_CREATE_LOG", "PATH_QUERY_SERVER_CERT", "PATH_QUERY_TEE_CREATE_LOG", "PATH_QUERY_TEE_EVER_FAIL", "PATH_QUERY_TEE_PUB", "PATH_QUERY_TICKET_DATA", "PATH_REE_PUB_KEY", "PATH_SIGN", "PATH_UPDATE_CERT", "PATH_UPDATE_TEE_EVER_FAIL", "PATH_UPDATE_TICKET_DATA", "VALUE_SIGN_TYPE_REE", "VALUE_SIGN_TYPE_TEE", "boolToInt", "bool", "", "(Ljava/lang/Boolean;)I", "getProviderAuthority", "context", "Landroid/content/Context;", "log", "", "msg", "bd_ticket_guard_core_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class TicketGuardProviderKt {
    public static final int CODE_CLEAR_SERVER_CERT = 202;
    public static final int CODE_DECRYPT = 107;
    public static final int CODE_DELTA_PUBLIC_KEY = 108;
    public static final int CODE_ENCRYPT = 106;
    public static final int CODE_QUERY_CLIENT_CERT = 102;
    public static final int CODE_QUERY_CSR = 101;
    public static final int CODE_QUERY_LOAD = 115;
    public static final int CODE_QUERY_NEED_REE = 110;
    public static final int CODE_QUERY_REE_CREATE_LOG = 112;
    public static final int CODE_QUERY_SERVER_CERT = 103;
    public static final int CODE_QUERY_TEE_CREATE_LOG = 111;
    public static final int CODE_QUERY_TEE_EVER_FAIL = 113;
    public static final int CODE_QUERY_TEE_PUB = 114;
    public static final int CODE_QUERY_TICKET_DATA = 104;
    public static final int CODE_REE_PUB_KEY = 109;
    public static final int CODE_SIGN = 105;
    public static final int CODE_UPDATE_CERT = 201;
    public static final int CODE_UPDATE_TEE_EVER_FAIL = 203;
    public static final int CODE_UPDATE_TICKET_DATA = 200;
    public static final String COL_BASE64_SIGNED = "encoded_signed";
    public static final String COL_CERT = "cert";
    public static final String COL_CLIENT_CERT = "client_cert";
    public static final String COL_CSR = "csr";
    public static final String COL_DECRYPTED = "decrypted";
    public static final String COL_DELTA_PUBLIC_KEY = "delta_public_key";
    public static final String COL_ENCRYPTED = "encrypted";
    public static final String COL_EXCEPTION_MESSAGE = "exception_message";
    public static final String COL_NEED_REE = "need_ree";
    public static final String COL_PUBLIC_KEY = "public_key";
    public static final String COL_REE_CREATE_LOG = "ree_create_log";
    public static final String COL_REE_PUB_KEY = "ree_public_key";
    public static final String COL_SERIAL_NUMBER = "serial_number";
    public static final String COL_SERVER_CERT_STRING = "server_cert_string";
    public static final String COL_TEE_CREATE_LOG = "tee_create_log";
    public static final String COL_TEE_EVER_FAIL = "TEE_EVER_FAIL";
    public static final String COL_TEE_PUB = "TEE_PUB";
    public static final String COL_TS_SIGN = "ts_sign";
    public static final String COL_TS_SIGN_REE = "ts_sign_ree";
    public static final String COL_TYPE = "type";
    public static final String NOTIFY_PATH_LOAD_RESULT = "load_result";
    public static final String PARAM_CERT = "cert";
    public static final String PARAM_CLIENT_CERT = "client_cert";
    public static final String PARAM_CONTENT = "content";
    public static final String PARAM_ID = "id";
    public static final String PARAM_PATH = "path";
    public static final String PARAM_RESULT = "result";
    public static final String PARAM_SCENE = "scene";
    public static final String PARAM_SERVER_CERT = "server_cert";
    public static final String PARAM_SIGN_TYPE = "sign_type";
    public static final String PARAM_TEE_FAIL_REASON = "tee_fail_reason";
    public static final String PARAM_TICKET = "ticket";
    public static final String PARAM_TS_SIGN = "ts_sign";
    public static final String PARAM_TS_SIGN_REE = "ts_sign_ree";
    public static final String PARAM_TYPE = "type";
    public static final String PARAM_UNSIGNED = "unsigned";
    public static final String PATH_CLEAR_SERVER_CERT = "clear_server_cert";
    public static final String PATH_DECRYPT = "decrypt";
    public static final String PATH_DELTA_PUBLIC_KEY = "delta_public_key";
    public static final String PATH_ENCRYPT = "encrypt";
    public static final String PATH_QUERY_CLIENT_CERT = "query_client_cert";
    public static final String PATH_QUERY_CSR = "query_csr";
    public static final String PATH_QUERY_LOAD = "query_load";
    public static final String PATH_QUERY_NEED_REE = "query_need_ree";
    public static final String PATH_QUERY_REE_CREATE_LOG = "query_ree_create_log";
    public static final String PATH_QUERY_SERVER_CERT = "query_server_cert";
    public static final String PATH_QUERY_TEE_CREATE_LOG = "query_tee_create_log";
    public static final String PATH_QUERY_TEE_EVER_FAIL = "QUERY_TEE_EVER_FAIL";
    public static final String PATH_QUERY_TEE_PUB = "QUERY_TEE_PUB";
    public static final String PATH_QUERY_TICKET_DATA = "ticket_data";
    public static final String PATH_REE_PUB_KEY = "query_ree_public_key";
    public static final String PATH_SIGN = "sign";
    public static final String PATH_UPDATE_CERT = "update_cert";
    public static final String PATH_UPDATE_TEE_EVER_FAIL = "update_tee_ever_fail";
    public static final String PATH_UPDATE_TICKET_DATA = "update_ticket_data";
    public static final String VALUE_SIGN_TYPE_REE = "sign_type_ree";
    public static final String VALUE_SIGN_TYPE_TEE = "sign_type_tee";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(String str) {
        TicketGuardInnerFrameWork.log(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        r0 = r5.authority;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getProviderAuthority(Context context) {
        if (context == null) {
            return "";
        }
        String str = null;
        try {
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
            int length = providerInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                ProviderInfo providerInfo = providerInfoArr[i];
                if (TextUtils.equals(providerInfo.name, "com.bytedance.android.sdk.bdticketguard.TicketGuardProvider")) {
                    break;
                }
                i++;
            }
        } catch (Exception e) {
            log("get authority failed, e=" + Log.getStackTraceString(e));
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = context.getPackageName() + ".TicketGuardProvider";
        }
        log("getProviderAuthority, authority=" + str);
        return str;
    }

    public static final int boolToInt(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : -1;
    }
}
