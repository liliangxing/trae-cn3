package com.bytedance.trae.network.ttnet;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OpaqueData.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.ttnet.OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1", f = "OpaqueData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CertificateFactory $certificateFactory;
    final /* synthetic */ Ref.IntRef $certificateNumber;
    final /* synthetic */ KeyStore $keyStore;
    final /* synthetic */ ArrayList<byte[]> $opaqueDataList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1(ArrayList<byte[]> arrayList, CertificateFactory certificateFactory, KeyStore keyStore, Ref.IntRef intRef, Continuation<? super OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1> continuation) {
        super(2, continuation);
        this.$opaqueDataList = arrayList;
        this.$certificateFactory = certificateFactory;
        this.$keyStore = keyStore;
        this.$certificateNumber = intRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1(this.$opaqueDataList, this.$certificateFactory, this.$keyStore, this.$certificateNumber, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Iterator<byte[]> it = this.$opaqueDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            byte[] next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            try {
                this.$keyStore.setCertificateEntry("CA-" + this.$certificateNumber.element, this.$certificateFactory.generateCertificate(new ByteArrayInputStream(next)));
                this.$certificateNumber.element++;
            } catch (Exception e) {
                Boxing.boxInt(Log.d("URLConn Init", "failed with " + e));
            }
        }
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(this.$keyStore);
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        return Unit.INSTANCE;
    }
}
