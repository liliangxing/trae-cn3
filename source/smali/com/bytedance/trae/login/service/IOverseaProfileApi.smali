# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/login/service/IOverseaProfileApi;
.super Ljava/lang/Object;
.source "OverseaProfileApi.kt"

.field public static final Companion:Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;->$$INSTANCE Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;
    sput-object v0, Lcom/bytedance/trae/login/service/IOverseaProfileApi;->Companion Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;
    return-void 
.end method

.method public abstract updateUserInfo(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract uploadAvatar(com.bytedance.retrofit2.mime.TypedFile  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
