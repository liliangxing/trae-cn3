# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;
.super Ljava/lang/Object;
.source "IDEProjectListPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;->INSTANCE Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final visibleProjects(java.util.List)java.util.List
    .registers 3
    # ins_size=2
    const-string v0, "projects"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method
