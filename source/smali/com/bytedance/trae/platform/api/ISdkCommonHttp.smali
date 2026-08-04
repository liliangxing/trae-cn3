# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
.super Ljava/lang/Object;
.source "ISdkCommonHttp.kt"

.field public static final Companion:Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->$$INSTANCE Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    sput-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->Companion Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    return-void 
.end method

.method public abstract getBoeBaseUrl()java.lang.String
    # abstract or native
.end method

.method public abstract getBoeHost()java.lang.String
    # abstract or native
.end method

.method public abstract getCommonAppendHeaders()java.util.Map
    # abstract or native
.end method

.method public abstract getCommonParams()java.util.Map
    # abstract or native
.end method

.method public abstract getFrontierUserId()java.lang.String
    # abstract or native
.end method

.method public abstract getHttpEnvConfig()com.bytedance.trae.platform.model.HttpEnvConfig
    # abstract or native
.end method

.method public abstract getOnlineBaseUrl()java.lang.String
    # abstract or native
.end method

.method public abstract getOnlineHost()java.lang.String
    # abstract or native
.end method

.method public abstract getPluginVersion()int
    # abstract or native
.end method

.method public abstract getToken()java.lang.String
    # abstract or native
.end method
