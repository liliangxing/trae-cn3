# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
.super Ljava/lang/Exception;
.source "EnterpriseAuthManager.kt"

.field private final errorCode:I
.field private final failedStep:Ljava/lang/String;
.field private final message:Ljava/lang/String;
.field private final userMessage:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  int  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userMessage
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->message Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->userMessage Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->errorCode I
    iput-object v5, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->failedStep Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  int  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)V
    return-void 
.end method

.method public final getErrorCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->errorCode I
    return v0
.end method

.method public final getFailedStep()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->failedStep Ljava/lang/String;
    return-object v0
.end method

.method public getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getUserMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->userMessage Ljava/lang/String;
    return-object v0
.end method
