package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.bdturing.methods.JsCallParser;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardNetworkHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardNetworkHelper;", "", "()V", "PATH_GET_CERT", "", "host", "getCert", "", TicketGuardProviderKt.COL_CSR, "needServer", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/sdk/bdticketguard/GetCertCallback;", "scene", "log", "msg", "(Ljava/lang/String;)Lkotlin/Unit;", "parseHeaders", "", "resp", "Lcom/bytedance/android/sdk/bdticketguard/TTResponse;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardNetworkHelper {
    public static final TicketGuardNetworkHelper INSTANCE = new TicketGuardNetworkHelper();
    public static final String PATH_GET_CERT = "/passport/ticket_guard/get_client_cert/";
    public static final String host = "security.snssdk.com";

    private TicketGuardNetworkHelper() {
    }

    @JvmStatic
    public static final void getCert(String csr, boolean needServer, GetCertCallback callback, String scene) {
        TicketGuardInitParam ticketGuardInitParam;
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        String str = csr;
        boolean z = str == null || str.length() == 0;
        boolean z2 = !needServer;
        if (z && z2) {
            INSTANCE.log("getCert, no need for any cert. callback");
            callback.onCallback(null, null);
            return;
        }
        TicketGuardManager manager = TicketGuardInnerFrameWork.INSTANCE.getManager();
        INetwork network = (manager == null || (ticketGuardInitParam = manager.getTicketGuardInitParam()) == null) ? null : ticketGuardInitParam.getNetwork();
        if (network == null) {
            INSTANCE.log("get cert fail, for no network implementation");
            callback.onCallback(null, null);
        } else {
            new Thread(new TicketGuardNetworkHelper$getCert$1(csr, needServer, scene, z, z2, callback, network)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> parseHeaders(TTResponse resp) {
        HashMap hashMap = new HashMap();
        if (resp.getHeaders() != null) {
            Intrinsics.checkExpressionValueIsNotNull(resp.getHeaders(), "resp.headers");
            if (!r1.isEmpty()) {
                for (TTHeader tTHeader : resp.getHeaders()) {
                    Intrinsics.checkExpressionValueIsNotNull(tTHeader, "header");
                    String name = tTHeader.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name, "header.name");
                    String value = tTHeader.getValue();
                    Intrinsics.checkExpressionValueIsNotNull(value, "header.value");
                    hashMap.put(name, value);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit log(String msg) {
        TicketGuardManager manager = TicketGuardInnerFrameWork.INSTANCE.getManager();
        if (manager == null) {
            return null;
        }
        manager.log(msg);
        return Unit.INSTANCE;
    }
}
