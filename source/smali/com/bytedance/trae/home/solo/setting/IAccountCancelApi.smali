# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;
.super Ljava/lang/Object;
.source "AccountCancelApi.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->Companion Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    return-void 
.end method

.method public abstract authVerify(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract cancelCheck(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract cancelConfirm(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract cancelLogin(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract cancelUserCheck(kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract deleteUserData(kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract emailSendCode(java.util.Map  int  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract emailVerify(java.util.Map  int  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract pwdVerify(com.bytedance.trae.home.solo.setting.PWDVerifyRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract smsSendCode(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract smsValidateCode(java.lang.String  int  int  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
