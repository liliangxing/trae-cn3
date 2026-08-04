# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IGetSkillListApi;
.super Ljava/lang/Object;
.source "IGetSkillListApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetSkillListApi;->Companion Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;
    return-void 
.end method

.method public abstract listSkills(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract listSkillsFromHubRaw(java.util.Map  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
