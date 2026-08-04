# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;
.super Ljava/lang/Object;
.source "TTNetExt.kt"

.implements Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;

.field public static final INSTANCE:Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;
.field public static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->INSTANCE Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final needTrace(java.lang.String)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 2
    const/4 v1, 0
    const-string v2, "https://log.snssdk.com"
    const/4 v3, 0
    invoke-static v5, v2, v3, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    xor-int/lit8 v5, v5, 1
    return v5
.end method

.method private final packageRequestParamters(com.bytedance.ttnet.http.HttpRequestInfo  org.json.JSONObject)void
    .registers 6
    # ins_size=3
    if-eqz v4, +146h
    if-nez v5, +004h
    goto/16 +142h
    const-string v0, "cronet_plugin_install"
    invoke-static Lcom/bytedance/ttnet/TTNetInit;->getTTNetDepend()Lcom/bytedance/ttnet/ITTNetDepend;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/ttnet/ITTNetDepend;->isCronetPluginInstalled()Z
    move-result v1
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    const-string v0, "networkType"
    sget-object v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getUserEsimNetworkInfo()Lcom/bytedance/trae/network/ttnet/NetInfo;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/NetInfo;->getNetworkType()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "isRoaming"
    sget-object v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getUserEsimNetworkInfo()Lcom/bytedance/trae/network/ttnet/NetInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/NetInfo;->isRoaming()Ljava/lang/Boolean;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, simCountry
    sget-object v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getUserEsimNetworkInfo()Lcom/bytedance/trae/network/ttnet/NetInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/NetInfo;->getSimCountry()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "netCountry"
    sget-object v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getUserEsimNetworkInfo()Lcom/bytedance/trae/network/ttnet/NetInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/NetInfo;->getNetCountry()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, simOperatorName
    sget-object v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getUserEsimNetworkInfo()Lcom/bytedance/trae/network/ttnet/NetInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/NetInfo;->getSimOperatorName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "netOperatorName"
    sget-object v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getUserEsimNetworkInfo()Lcom/bytedance/trae/network/ttnet/NetInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/NetInfo;->getNetOperatorName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "airplaneMode"
    sget-object v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getUserEsimNetworkInfo()Lcom/bytedance/trae/network/ttnet/NetInfo;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/network/ttnet/NetInfo;->getAirplaneMode()Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v5, v0, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "appLevelRequestStart"
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->appLevelRequestStart J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "beforeAllInterceptors"
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->beforeAllInterceptors J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, requestStart
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->requestStart J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, responseBack
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->responseBack J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "completeReadResponse"
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->completeReadResponse J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, requestEnd
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->requestEnd J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, recycleCount
    iget v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->recycleCount I
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    iget v0, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->httpClientType I
    if-nez v0, +062h
    const-string/jumbo v0, timing_dns
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->dnsTime J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_connect
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->connectTime J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_ssl
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->sslTime J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_send
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->sendTime J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_waiting
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->ttfbMs J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_receive
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->receiveTime J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_total
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->totalTime J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_isSocketReused
    iget-boolean v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->isSocketReused Z
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_totalSendBytes
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->sentByteCount J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_totalReceivedBytes
    iget-wide v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->receivedByteCount J
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v0, timing_remoteIP
    iget-object v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->remoteIp Ljava/lang/String;
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, request_log
    iget-object v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->requestLog Ljava/lang/String;
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v0, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->extraInfo Lorg/json/JSONObject;
    if-eqz v0, +00ah
    const-string/jumbo v0, req_info
    iget-object v1, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->extraInfo Lorg/json/JSONObject;
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, streaming
    iget-boolean v4, v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;->downloadFile Z
    invoke-virtual v5, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    return-void 
    :try_start_0x6
.end method

.method public bridge synthetic monitorApiError(long  long  java.lang.String  java.lang.String  com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo  java.lang.Throwable)void
    .registers 9
    # ins_size=9
    check-cast v7, Lcom/bytedance/ttnet/http/HttpRequestInfo;
    invoke-virtual/range v0 ... v8, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->monitorApiError(J J Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/ttnet/http/HttpRequestInfo; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public monitorApiError(long  long  java.lang.String  java.lang.String  com.bytedance.ttnet.http.HttpRequestInfo  java.lang.Throwable)void
    .registers 24
    # ins_size=9
    move-object v0, v15
    move-object/from16 v10, v20
    move-object/from16 v1, v22
    move-object/from16 v2, v23
    const/4 v3, 1
    new-array v11, v3, [Ljava/lang/String;
    invoke-static v2, v11, Lcom/bytedance/trae/network/ttnet/ConvertIOException;->ConvertIOExceptionToStatus(Ljava/lang/Throwable; [Ljava/lang/String;)I
    move-result v12
    new-instance v13, Lorg/json/JSONObject;
    invoke-direct v13, Lorg/json/JSONObject;-><init>()V
    if-eqz v2, +055h
    invoke-virtual/range v23, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/common/utility/StringUtils;->isEmpty(Ljava/lang/String;)Z
    move-result v4
    if-nez v4, +047h
    const-string v4, "ex_name"
    invoke-virtual/range v23, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v13, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-ne v12, v3, +00eh
    invoke-static Lcom/bytedance/apm/internal/ApmDelegate;->getInstance()Lcom/bytedance/apm/internal/ApmDelegate;
    move-result-object v3
    const-string v4, "ex_message_open"
    invoke-virtual v3, v4, Lcom/bytedance/apm/internal/ApmDelegate;->getLogTypeSwitch(Ljava/lang/String;)Z
    move-result v3
    if-nez v3, +00eh
    invoke-static Lcom/bytedance/apm/internal/ApmDelegate;->getInstance()Lcom/bytedance/apm/internal/ApmDelegate;
    move-result-object v3
    const-string v4, "debug_ex_message_open"
    invoke-virtual v3, v4, Lcom/bytedance/apm/internal/ApmDelegate;->getLogTypeSwitch(Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +020h
    invoke-static/range v23, Lcom/bytedance/ttnet/utils/TtnetUtil;->outputThrowableStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/common/utility/StringUtils;->isEmpty(Ljava/lang/String;)Z
    move-result v3
    if-nez v3, +007h
    const-string v3, "ex_message"
    invoke-virtual v13, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-static Lcom/bytedance/ttnet/HttpClient;->getCronetExceptionMessage()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/common/utility/StringUtils;->isEmpty(Ljava/lang/String;)Z
    move-result v3
    if-nez v3, +007h
    const-string v3, "cronet_init_ex_message"
    invoke-virtual v13, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const/4 v14, 0
    aget-object v2, v11, v14
    invoke-static v2, Lcom/bytedance/common/utility/StringUtils;->isEmpty(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +009h
    invoke-static/range v22, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/ttnet/http/HttpRequestInfo;->remoteIp Ljava/lang/String;
    aput-object v2, v11, v14
    invoke-direct v15, v1, v13, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->packageRequestParamters(Lcom/bytedance/ttnet/http/HttpRequestInfo; Lorg/json/JSONObject;)V
    aget-object v6, v11, v14
    move-wide/from16 v1, v16
    move-wide/from16 v3, v18
    move-object/from16 v5, v20
    move-object/from16 v7, v21
    move v8, v12
    move-object v9, v13
    invoke-static/range v1 ... v9, Lcom/bytedance/apm/ApmAgent;->monitorApiError(J J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lorg/json/JSONObject;)V
    aget-object v6, v11, v14
    move-wide/from16 v1, v16
    move-wide/from16 v3, v18
    move-object/from16 v5, v20
    move-object/from16 v7, v21
    move v8, v12
    move-object v9, v13
    invoke-static/range v1 ... v9, Lcom/bytedance/apm/ApmAgent;->monitorSLA(J J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lorg/json/JSONObject;)V
    if-eqz v10, +005h
    invoke-direct v15, v10, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->needTrace(Ljava/lang/String;)Z
    return-void 
    :try_start_0x8
.end method

.method public bridge synthetic monitorApiOk(long  long  java.lang.String  java.lang.String  com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo)void
    .registers 8
    # ins_size=8
    check-cast v7, Lcom/bytedance/ttnet/http/HttpRequestInfo;
    invoke-virtual/range v0 ... v7, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->monitorApiOk(J J Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/ttnet/http/HttpRequestInfo;)V
    return-void 
.end method

.method public monitorApiOk(long  long  java.lang.String  java.lang.String  com.bytedance.ttnet.http.HttpRequestInfo)void
    .registers 20
    # ins_size=8
    move-object v10, v12
    move-object/from16 v6, v17
    move-object/from16 v8, v19
    const/16 v1, 200
    if-eqz v8, +044h
    iget-object v0, v8, Lcom/bytedance/ttnet/http/HttpRequestInfo;->requestLog Ljava/lang/String;
    if-eqz v0, +040h
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string/jumbo v0, response
    invoke-virtual v2, v0, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v0
    if-eqz v0, +009h
    const-string v2, "code"
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->optInt(Ljava/lang/String; I)I
    move-result v0
    goto +2h
    move v0, v1
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move-object v0, v2
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    goto +2h
    move v0, v1
    const/4 v2, 1
    const/4 v3, 0
    if-gt v1, v0, +008h
    const/16 v1, 300
    if-ge v0, v1, +004h
    move v0, v2
    goto +2h
    move v0, v3
    if-nez v0, +010h
    const/4 v9, 0
    move-object v1, v12
    move-wide v2, v13
    move-wide v4, v15
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->monitorApiError(J J Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/ttnet/http/HttpRequestInfo; Ljava/lang/Throwable;)V
    return-void 
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;
    if-eqz v6, +008h
    invoke-direct v12, v6, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->needTrace(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +03eh
    if-eqz v8, +00ch
    iget-object v0, v8, Lcom/bytedance/ttnet/http/HttpRequestInfo;->responseHeaders Ljava/lang/String;
    if-eqz v0, +008h
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    goto +2h
    const/4 v1, 0
    if-eqz v1, +02fh
    invoke-virtual v1, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v0
    if-eqz v0, +029h
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +023h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v4, Ljava/lang/String;->toLowerCase()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v7, toLowerCase(...)
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v7, x-tt-logid
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -020h
    const-string v0, "Unknown"
    invoke-virtual v1, v4, v0, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    new-array v0, v2, [Ljava/lang/String;
    const/16 v9, 200
    new-instance v11, Lorg/json/JSONObject;
    invoke-direct v11, Lorg/json/JSONObject;-><init>()V
    aget-object v1, v0, v3
    invoke-static v1, Lcom/bytedance/common/utility/StringUtils;->isEmpty(Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +009h
    invoke-static/range v19, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v1, v8, Lcom/bytedance/ttnet/http/HttpRequestInfo;->remoteIp Ljava/lang/String;
    aput-object v1, v0, v3
    invoke-direct v12, v8, v11, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->packageRequestParamters(Lcom/bytedance/ttnet/http/HttpRequestInfo; Lorg/json/JSONObject;)V
    aget-object v0, v0, v3
    move-wide v1, v13
    move-wide v3, v15
    move-object/from16 v5, v17
    move-object v6, v0
    move-object/from16 v7, v18
    move v8, v9
    move-object v9, v11
    invoke-static/range v1 ... v9, Lcom/bytedance/apm/ApmAgent;->monitorSLA(J J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xd
    :try_start_0x67
    :try_start_0xc0
.end method
