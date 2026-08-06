package com.bytedance.android.sdk.bdticketguard;

import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.bytedance.applog.throttle.CongestionController;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TicketGuardNetworkHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardNetworkHelper$getCert$1 implements Runnable {
    final /* synthetic */ GetCertCallback $callback;
    final /* synthetic */ String $csr;
    final /* synthetic */ boolean $hasClient;
    final /* synthetic */ boolean $hasServer;
    final /* synthetic */ boolean $needServer;
    final /* synthetic */ INetwork $network;
    final /* synthetic */ String $scene;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TicketGuardNetworkHelper$getCert$1(String str, boolean z, String str2, boolean z2, boolean z3, GetCertCallback getCertCallback, INetwork iNetwork) {
        this.$csr = str;
        this.$needServer = z;
        this.$scene = str2;
        this.$hasClient = z2;
        this.$hasServer = z3;
        this.$callback = getCertCallback;
        this.$network = iNetwork;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091 A[Catch: all -> 0x00a8, TryCatch #0 {all -> 0x00a8, blocks: (B:18:0x006e, B:20:0x007f, B:22:0x0085, B:27:0x0091, B:55:0x00a0), top: B:17:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121 A[Catch: Exception -> 0x0145, TryCatch #1 {Exception -> 0x0145, blocks: (B:30:0x00cb, B:32:0x00ee, B:35:0x00f5, B:38:0x0109, B:41:0x0116, B:43:0x0121, B:45:0x0139, B:49:0x013e), top: B:29:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139 A[Catch: Exception -> 0x0145, TryCatch #1 {Exception -> 0x0145, blocks: (B:30:0x00cb, B:32:0x00ee, B:35:0x00f5, B:38:0x0109, B:41:0x0116, B:43:0x0121, B:45:0x0139, B:49:0x013e), top: B:29:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0107  */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.bytedance.android.sdk.bdticketguard.TicketGuardNetworkHelper$getCert$1$2] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.bytedance.android.sdk.bdticketguard.TicketGuardNetworkHelper$getCert$1$1] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        ?? r1;
        TTResponse executePost;
        Map parseHeaders;
        String str;
        String body;
        JSONObject optJSONObject;
        Pair buildBDNetworkTag;
        Object[] objArr;
        HashMap hashMap = new HashMap();
        String str2 = this.$csr;
        if ((str2 == null || str2.length() == 0) == false) {
            String str3 = this.$csr;
            Charset charset = Charsets.UTF_8;
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str3.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            hashMap.put(TicketGuardProviderKt.COL_CSR, Base64.encodeToString(bytes, 2));
        }
        if (this.$needServer) {
            hashMap.put("server_data", "1");
        }
        TTHeader tTHeader = new TTHeader("x-tt-request-tag", "t=" + (!Intrinsics.areEqual(this.$scene, "init") ? 1 : 0) + ";n=1");
        try {
            buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardNetworkHelper$getCert$1$provider$1
                public int triggerType() {
                    return !Intrinsics.areEqual(TicketGuardNetworkHelper$getCert$1.this.$scene, "init") ? 1 : 0;
                }
            });
        } catch (Throwable th) {
            TicketGuardNetworkHelper.INSTANCE.log("get request tag from BDNetworkTagManager fail, " + th.getMessage());
        }
        try {
            if (buildBDNetworkTag != null) {
                CharSequence charSequence = (CharSequence) buildBDNetworkTag.second;
                if (charSequence != null && charSequence.length() != 0) {
                    objArr = false;
                    if (objArr == false) {
                        tTHeader = new TTHeader((String) buildBDNetworkTag.first, (String) buildBDNetworkTag.second);
                        ?? r5 = new Function5<Long, String, String, String, String, Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardNetworkHelper$getCert$1.1
                            {
                                super(5);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                                invoke(((Number) obj).longValue(), (String) obj2, (String) obj3, (String) obj4, (String) obj5);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long j, String str4, String str5, String str6, String str7) {
                                Intrinsics.checkParameterIsNotNull(str4, "logid");
                                String str8 = TicketGuardNetworkHelper$getCert$1.this.$scene;
                                boolean z = TicketGuardNetworkHelper$getCert$1.this.$hasClient;
                                boolean z2 = TicketGuardNetworkHelper$getCert$1.this.$hasServer;
                                String str9 = str5;
                                boolean z3 = !(str9 == null || str9.length() == 0);
                                String str10 = str6;
                                boolean z4 = !(str10 == null || str10.length() == 0);
                                String str11 = str7;
                                TicketGuardEventHelper.monitorRequestCert(true, null, j, str8, str4, z, z2, z3, z4, !(str11 == null || str11.length() == 0));
                                TicketGuardNetworkHelper$getCert$1.this.$callback.onCallback(str5, str6);
                            }
                        };
                        r1 = new Function1<String, Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardNetworkHelper$getCert$1.2
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((String) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(String str4) {
                                TicketGuardEventHelper.monitorRequestCert(false, str4, 0L, TicketGuardNetworkHelper$getCert$1.this.$scene, null, TicketGuardNetworkHelper$getCert$1.this.$hasClient, TicketGuardNetworkHelper$getCert$1.this.$hasServer, false, false, false);
                                TicketGuardNetworkHelper$getCert$1.this.$callback.onCallback(null, null);
                            }
                        };
                        long currentTimeMillis = System.currentTimeMillis();
                        executePost = this.$network.executePost(CongestionController.MAX_REQUEST_FREQUENCY_REALTIME, "https://security.snssdk.com/passport/ticket_guard/get_client_cert/", hashMap, CollectionsKt.arrayListOf(new TTHeader[]{tTHeader}));
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (executePost != null && executePost.getBody() != null) {
                            parseHeaders = TicketGuardNetworkHelper.INSTANCE.parseHeaders(executePost);
                            str = (String) parseHeaders.get("x-tt-logid");
                            if (str != null) {
                                str = "";
                            }
                            String str4 = str;
                            body = executePost.getBody();
                            if (body != null) {
                                body = "{}";
                            }
                            optJSONObject = new JSONObject(body).optJSONObject("data");
                            if (optJSONObject == null) {
                                r5.invoke(currentTimeMillis2, str4, optJSONObject.optString("cert"), optJSONObject.optString(TicketGuardProviderKt.PARAM_SERVER_CERT), optJSONObject.optString("server_sn"));
                                return;
                            } else {
                                r1.invoke(null);
                                return;
                            }
                        }
                        r1.invoke("resp or resp.body is null");
                        return;
                    }
                }
                objArr = true;
                if (objArr == false) {
                }
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            executePost = this.$network.executePost(CongestionController.MAX_REQUEST_FREQUENCY_REALTIME, "https://security.snssdk.com/passport/ticket_guard/get_client_cert/", hashMap, CollectionsKt.arrayListOf(new TTHeader[]{tTHeader}));
            long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis3;
            if (executePost != null) {
                parseHeaders = TicketGuardNetworkHelper.INSTANCE.parseHeaders(executePost);
                str = (String) parseHeaders.get("x-tt-logid");
                if (str != null) {
                }
                String str42 = str;
                body = executePost.getBody();
                if (body != null) {
                }
                optJSONObject = new JSONObject(body).optJSONObject("data");
                if (optJSONObject == null) {
                }
            }
            r1.invoke("resp or resp.body is null");
            return;
        } catch (Exception e) {
            Exception exc = e;
            TicketGuardNetworkHelper.INSTANCE.log("get cert exception, e=" + Log.getStackTraceString(exc));
            r1.invoke(Log.getStackTraceString(exc));
            return;
        }
        TicketGuardNetworkHelper.INSTANCE.log("get request tag from BDNetworkTagManager return empty");
        ?? r52 = new Function5<Long, String, String, String, String, Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardNetworkHelper$getCert$1.1
            {
                super(5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                invoke(((Number) obj).longValue(), (String) obj2, (String) obj3, (String) obj4, (String) obj5);
                return Unit.INSTANCE;
            }

            public final void invoke(long j, String str43, String str5, String str6, String str7) {
                Intrinsics.checkParameterIsNotNull(str43, "logid");
                String str8 = TicketGuardNetworkHelper$getCert$1.this.$scene;
                boolean z = TicketGuardNetworkHelper$getCert$1.this.$hasClient;
                boolean z2 = TicketGuardNetworkHelper$getCert$1.this.$hasServer;
                String str9 = str5;
                boolean z3 = !(str9 == null || str9.length() == 0);
                String str10 = str6;
                boolean z4 = !(str10 == null || str10.length() == 0);
                String str11 = str7;
                TicketGuardEventHelper.monitorRequestCert(true, null, j, str8, str43, z, z2, z3, z4, !(str11 == null || str11.length() == 0));
                TicketGuardNetworkHelper$getCert$1.this.$callback.onCallback(str5, str6);
            }
        };
        r1 = new Function1<String, Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.TicketGuardNetworkHelper$getCert$1.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str43) {
                TicketGuardEventHelper.monitorRequestCert(false, str43, 0L, TicketGuardNetworkHelper$getCert$1.this.$scene, null, TicketGuardNetworkHelper$getCert$1.this.$hasClient, TicketGuardNetworkHelper$getCert$1.this.$hasServer, false, false, false);
                TicketGuardNetworkHelper$getCert$1.this.$callback.onCallback(null, null);
            }
        };
    }
}
