package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"CLIENT_DATA_REQ_CONTENT", "", "CLIENT_DATA_REQ_SIGN", "CLIENT_DATA_REQ_SIGN_REE", "CLIENT_DATA_TIMESTAMP", "CLIENT_DATA_TS_SIGN", "CLIENT_DATA_TS_SIGN_REE", "HEADER_CLIENT_CERT", "HEADER_CLIENT_CSR", "HEADER_CLIENT_DATA", "HEADER_ITERATION_VERSION", "HEADER_LOGID", "HEADER_REE_PUBLIC_KEY", "HEADER_SERVER_CERT", "HEADER_SERVER_CERT_SN", "HEADER_SERVER_DATA", "HEADER_TAG", "HEADER_TARGET", "HEADER_TEE_STATUS", "HEADER_VERIFY_RESULT", "HEADER_VERSION", "INIT_STATUS_ENCRYPTION", "INIT_STATUS_REE", "INIT_STATUS_TEE", "SERVER_DATA_CLIENT_CERT", "SERVER_DATA_TICKET", "SERVER_DATA_TICKETS", "SERVER_DATA_TS_SIGN", "SERVER_DATA_TS_SIGN_REE", "TICKET_GUARD_ITERATION_VERSION", "TICKET_GUARD_VERSION", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "bd_ticket_guard_api_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardApiKt {
    public static final String CLIENT_DATA_REQ_CONTENT = "req_content";
    public static final String CLIENT_DATA_REQ_SIGN = "req_sign";
    public static final String CLIENT_DATA_REQ_SIGN_REE = "req_sign_ree";
    public static final String CLIENT_DATA_TIMESTAMP = "timestamp";
    public static final String CLIENT_DATA_TS_SIGN = "ts_sign";
    public static final String CLIENT_DATA_TS_SIGN_REE = "ts_sign_ree";
    public static final String HEADER_CLIENT_CERT = "bd-ticket-guard-client-cert";
    public static final String HEADER_CLIENT_CSR = "bd-ticket-guard-client-csr";
    public static final String HEADER_CLIENT_DATA = "bd-ticket-guard-client-data";
    public static final String HEADER_ITERATION_VERSION = "bd-ticket-guard-iteration-version";
    public static final String HEADER_LOGID = "X-Tt-Logid";
    public static final String HEADER_REE_PUBLIC_KEY = "bd-ticket-guard-ree-public-key";
    public static final String HEADER_SERVER_CERT = "Bd-Ticket-Guard-Server-Cert";
    public static final String HEADER_SERVER_CERT_SN = "bd-ticket-guard-server-cert-sn";
    public static final String HEADER_SERVER_DATA = "Bd-Ticket-Guard-Server-Data";
    public static final String HEADER_TAG = "bd-ticket-guard-tag";
    public static final String HEADER_TARGET = "bd-ticket-guard-target";
    public static final String HEADER_TEE_STATUS = "bd-ticket-guard-tee-status";
    public static final String HEADER_VERIFY_RESULT = "bd-ticket-guard-result";
    public static final String HEADER_VERSION = "bd-ticket-guard-version";
    public static final String INIT_STATUS_ENCRYPTION = "encryption";
    public static final String INIT_STATUS_REE = "ree";
    public static final String INIT_STATUS_TEE = "tee";
    public static final String SERVER_DATA_CLIENT_CERT = "client_cert";
    public static final String SERVER_DATA_TICKET = "ticket";
    public static final String SERVER_DATA_TICKETS = "tickets";
    public static final String SERVER_DATA_TS_SIGN = "ts_sign";
    public static final String SERVER_DATA_TS_SIGN_REE = "ts_sign_ree";
    public static final String TICKET_GUARD_ITERATION_VERSION = "2";
    public static final String TICKET_GUARD_VERSION = "3";
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(TicketGuardApiKt.class, "bd_ticket_guard_api_release"), "gson", "getGson()Lcom/google/gson/Gson;"))};
    private static final Lazy gson$delegate = LazyKt.lazy(new Function0<Gson>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardApiKt$gson$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m400invoke() {
            return new Gson();
        }
    });

    public static final Gson getGson() {
        Lazy lazy = gson$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Gson) lazy.getValue();
    }
}
