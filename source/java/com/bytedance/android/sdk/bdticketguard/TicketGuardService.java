package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.bdturing.methods.JsCallParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u0007H&J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0018H&J\u001a\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H&J\u0012\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&H&J\u001a\u0010'\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H&J&\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010+H&J\u001a\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\b\u0010%\u001a\u0004\u0018\u00010-H&J\u001a\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\b\u0010%\u001a\u0004\u0018\u00010-H&J\u001a\u0010/\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\b\u0010%\u001a\u0004\u0018\u00010-H&J\u001c\u00100\u001a\u00020\u00182\b\u00101\u001a\u0004\u0018\u00010\u00072\b\u00102\u001a\u0004\u0018\u00010\u0007H&¨\u00063"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardService;", "", TicketGuardProviderKt.PATH_DECRYPT, "", "content", TicketGuardProviderKt.PATH_ENCRYPT, "getClientCert", "", "getConsumerRequestContent", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestContent;", "consumerRequestParam", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerRequestParam;", "getDeltaPublicKey", "getInitResult", "", "type", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getProviderContent", "Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestContent;", "params", "Lcom/bytedance/android/sdk/bdticketguard/ProviderRequestParam;", "getServerCert", "Lcom/bytedance/android/sdk/bdticketguard/ServerCert;", "handleConsumerResponse", "", "handleConsumerResponseParam", "Lcom/bytedance/android/sdk/bdticketguard/HandleConsumerResponseParam;", "handleProviderResponse", "", "Lcom/bytedance/android/sdk/bdticketguard/TicketData;", "handleProviderResponseParams", "Lcom/bytedance/android/sdk/bdticketguard/HandleProviderResponseParam;", "invalidServerCert", "reeSign", TicketGuardProviderKt.PARAM_UNSIGNED, "path", "requestCert", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/sdk/bdticketguard/GetCertCallback;", TicketGuardProviderKt.PATH_SIGN, "tryInit", "ticketGuardInitParam", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardInitParam;", "Lkotlin/Function1;", "tryInitEncryption", "Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;", "tryInitRee", "tryInitTee", "updateLocalCert", "resClientCert", "resServerCert", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface TicketGuardService {
    byte[] decrypt(byte[] content) throws Exception;

    byte[] encrypt(byte[] content) throws Exception;

    String getClientCert();

    ConsumerRequestContent getConsumerRequestContent(ConsumerRequestParam consumerRequestParam);

    String getDeltaPublicKey() throws Exception;

    Boolean getInitResult(String type);

    ProviderRequestContent getProviderContent(ProviderRequestParam params);

    ServerCert getServerCert();

    void handleConsumerResponse(HandleConsumerResponseParam handleConsumerResponseParam);

    List<TicketData> handleProviderResponse(HandleProviderResponseParam handleProviderResponseParams);

    void invalidServerCert();

    String reeSign(String unsigned, String path);

    void requestCert(GetCertCallback callback);

    String sign(String unsigned, String path);

    void tryInit(TicketGuardInitParam ticketGuardInitParam, Function1<? super Boolean, Unit> callback);

    void tryInitEncryption(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback callback);

    void tryInitRee(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback callback);

    void tryInitTee(TicketGuardInitParam ticketGuardInitParam, TicketInitCallback callback);

    void updateLocalCert(String resClientCert, String resServerCert);
}
