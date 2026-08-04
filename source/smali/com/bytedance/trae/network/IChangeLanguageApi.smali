# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/network/IChangeLanguageApi;
.super Ljava/lang/Object;
.source "IChangeLanguageApi.kt"

.field public static final Companion:Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->$$INSTANCE Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
    sput-object v0, Lcom/bytedance/trae/network/IChangeLanguageApi;->Companion Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
    return-void 
.end method

.method public static syncLanguage()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/IChangeLanguageApi;->Companion Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->syncLanguage()V
    return-void 
.end method

.method public static syncLanguage(java.lang.String)void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/IChangeLanguageApi;->Companion Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->syncLanguage(Ljava/lang/String;)V
    return-void 
.end method

.method public abstract changeLanguage(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.network.ChangeLanguageRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
