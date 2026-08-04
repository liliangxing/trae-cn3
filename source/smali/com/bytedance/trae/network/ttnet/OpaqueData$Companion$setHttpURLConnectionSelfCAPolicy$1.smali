# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "OpaqueData.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $certificateFactory:Ljava/security/cert/CertificateFactory;
.field final synthetic $certificateNumber:Lkotlin/jvm/internal/Ref$IntRef;
.field final synthetic $keyStore:Ljava/security/KeyStore;
.field final synthetic $opaqueDataList:Ljava/util/ArrayList;
.field  label:I


.method constructor <init>(java.util.ArrayList  java.security.cert.CertificateFactory  java.security.KeyStore  kotlin.jvm.internal.Ref$IntRef  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$opaqueDataList Ljava/util/ArrayList;
    iput-object v2, v0, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$certificateFactory Ljava/security/cert/CertificateFactory;
    iput-object v3, v0, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$keyStore Ljava/security/KeyStore;
    iput-object v4, v0, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$certificateNumber Lkotlin/jvm/internal/Ref$IntRef;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;
    iget-object v1, v6, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$opaqueDataList Ljava/util/ArrayList;
    iget-object v2, v6, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$certificateFactory Ljava/security/cert/CertificateFactory;
    iget-object v3, v6, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$keyStore Ljava/security/KeyStore;
    iget-object v4, v6, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$certificateNumber Lkotlin/jvm/internal/Ref$IntRef;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;-><init>(Ljava/util/ArrayList; Ljava/security/cert/CertificateFactory; Ljava/security/KeyStore; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->label I
    if-nez v0, +097h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$opaqueDataList Ljava/util/ArrayList;
    invoke-virtual v5, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v5
    const-string v0, "iterator(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +059h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "next(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, [B
    iget-object v1, v4, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$certificateFactory Ljava/security/cert/CertificateFactory;
    new-instance v2, Ljava/io/ByteArrayInputStream;
    invoke-direct v2, v0, Ljava/io/ByteArrayInputStream;-><init>([B)V
    check-cast v2, Ljava/io/InputStream;
    invoke-virtual v1, v2, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$keyStore Ljava/security/KeyStore;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    const-string v3, "CA-"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v4, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$certificateNumber Lkotlin/jvm/internal/Ref$IntRef;
    iget v3, v3, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, v0, Ljava/security/KeyStore;->setCertificateEntry(Ljava/lang/String; Ljava/security/cert/Certificate;)V
    iget-object v0, v4, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$certificateNumber Lkotlin/jvm/internal/Ref$IntRef;
    iget v1, v0, Lkotlin/jvm/internal/Ref$IntRef;->element I
    add-int/lit8 v1, v1, 1
    iput v1, v0, Lkotlin/jvm/internal/Ref$IntRef;->element I
    goto -42h
    move-exception v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "failed with "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "URLConn Init"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    move-result v0
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    goto -5ch
    invoke-static Ljavax/net/ssl/TrustManagerFactory;->getDefaultAlgorithm()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Ljavax/net/ssl/TrustManagerFactory;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    move-result-object v5
    iget-object v0, v4, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion$setHttpURLConnectionSelfCAPolicy$1;->$keyStore Ljava/security/KeyStore;
    invoke-virtual v5, v0, Ljavax/net/ssl/TrustManagerFactory;->init(Ljava/security/KeyStore;)V
    const-string v0, "TLS"
    invoke-static v0, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    move-result-object v0
    invoke-virtual v5, Ljavax/net/ssl/TrustManagerFactory;->getTrustManagers()[Ljavax/net/ssl/TrustManager;
    move-result-object v5
    new-instance v1, Ljava/security/SecureRandom;
    invoke-direct v1, Ljava/security/SecureRandom;-><init>()V
    const/4 v2, 0
    invoke-virtual v0, v2, v5, v1, Ljavax/net/ssl/SSLContext;->init([Ljavax/net/ssl/KeyManager; [Ljavax/net/ssl/TrustManager; Ljava/security/SecureRandom;)V
    invoke-virtual v0, Ljavax/net/ssl/SSLContext;->getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    move-result-object v5
    invoke-static v5, Ljavax/net/ssl/HttpsURLConnection;->setDefaultSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    :try_start_0x26
.end method
