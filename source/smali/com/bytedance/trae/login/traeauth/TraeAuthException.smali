# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeAuthException;
.super Ljava/lang/Exception;
.source "TraeAuthManager.kt"

.field private final cause:Ljava/lang/Throwable;
.field private final code:Ljava/lang/String;
.field private final httpCode:Ljava/lang/Integer;
.field private final isRetryable:Z
.field private logId:Ljava/lang/String;
.field private final message:Ljava/lang/String;
.field private step:Ljava/lang/String;
.field private final userFacingMessage:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  boolean  java.lang.Throwable  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String)void
    .registers 10
    # ins_size=9
    const-string v0, "message"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v5, Ljava/lang/Exception;-><init>(Ljava/lang/String; Ljava/lang/Throwable;)V
    iput-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->code Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->message Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->isRetryable Z
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->cause Ljava/lang/Throwable;
    iput-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->userFacingMessage Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->step Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->httpCode Ljava/lang/Integer;
    iput-object v9, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->logId Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  boolean  java.lang.Throwable  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 23
    # ins_size=11
    move/from16 v0, v21
    and-int/lit8 v1, v0, 4
    const/4 v2, 0
    if-eqz v1, +004h
    move v6, v2
    goto +2h
    move v6, v15
    and-int/lit8 v1, v0, 8
    const/4 v3, 0
    if-eqz v1, +004h
    move-object v7, v3
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v3
    goto +3h
    move-object/from16 v8, v17
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v3
    goto +3h
    move-object/from16 v9, v18
    and-int/lit8 v1, v0, 64
    if-eqz v1, +008h
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v19
    and-int/lit16 v0, v0, 128
    if-eqz v0, +004h
    move-object v11, v3
    goto +3h
    move-object/from16 v11, v20
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method public getCause()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->cause Ljava/lang/Throwable;
    return-object v0
.end method

.method public final getCode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->code Ljava/lang/String;
    return-object v0
.end method

.method public final getHttpCode()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->httpCode Ljava/lang/Integer;
    return-object v0
.end method

.method public final getLogId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->logId Ljava/lang/String;
    return-object v0
.end method

.method public getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getStep()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->step Ljava/lang/String;
    return-object v0
.end method

.method public final getUserFacingMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->userFacingMessage Ljava/lang/String;
    return-object v0
.end method

.method public final isRetryable()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->isRetryable Z
    return v0
.end method

.method public final setLogId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->logId Ljava/lang/String;
    return-void 
.end method

.method public final setStep(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->step Ljava/lang/String;
    return-void 
.end method
