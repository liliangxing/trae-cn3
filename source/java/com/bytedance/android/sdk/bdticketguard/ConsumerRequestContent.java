package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiConsumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestContent;", "Lcom/bytedance/android/sdk/bdticketguard/RequestContent;", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParam;", "consumerRequestParam", "headers", "", "Landroid/util/Pair;", "", "errorDesc", "keyType", "clientData", "Lcom/bytedance/android/sdk/bdticketguard/ClientData;", "clientDataBase64", "(Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParam;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/sdk/bdticketguard/ClientData;Ljava/lang/String;)V", "getClientData", "()Lcom/bytedance/android/sdk/bdticketguard/ClientData;", "getClientDataBase64", "()Ljava/lang/String;", "getErrorDesc", "getKeyType", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ConsumerRequestContent extends RequestContent<ConsumerRequestParam> {
    private final ClientData clientData;
    private final String clientDataBase64;
    private final String errorDesc;
    private final String keyType;

    public final String getErrorDesc() {
        return this.errorDesc;
    }

    public final String getKeyType() {
        return this.keyType;
    }

    public final ClientData getClientData() {
        return this.clientData;
    }

    public final String getClientDataBase64() {
        return this.clientDataBase64;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerRequestContent(ConsumerRequestParam consumerRequestParam, List<? extends Pair<String, String>> list, String str, String str2, ClientData clientData, String str3) {
        super(consumerRequestParam, list, 0L, 4, null);
        Intrinsics.checkParameterIsNotNull(consumerRequestParam, "consumerRequestParam");
        Intrinsics.checkParameterIsNotNull(list, "headers");
        Intrinsics.checkParameterIsNotNull(str, "errorDesc");
        Intrinsics.checkParameterIsNotNull(str2, "keyType");
        Intrinsics.checkParameterIsNotNull(clientData, "clientData");
        Intrinsics.checkParameterIsNotNull(str3, "clientDataBase64");
        this.errorDesc = str;
        this.keyType = str2;
        this.clientData = clientData;
        this.clientDataBase64 = str3;
    }
}
