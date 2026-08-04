# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/ICreateTaskCheck;
.super Ljava/lang/Object;
.source "ICreateTaskCheck.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/ICreateTaskCheck;->Companion Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;
    return-void 
.end method

.method public abstract createTaskCheckRaw(com.bytedance.trae.im.service.CreateTaskCheckRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
