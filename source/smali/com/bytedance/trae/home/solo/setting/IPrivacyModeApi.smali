# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;
.super Ljava/lang/Object;
.source "PrivacyModeApi.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;->Companion Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;
    return-void 
.end method

.method public abstract operatePrivacyMode(com.bytedance.trae.home.solo.setting.PrivacyModeOperationRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract queryPrivacyMode(kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
