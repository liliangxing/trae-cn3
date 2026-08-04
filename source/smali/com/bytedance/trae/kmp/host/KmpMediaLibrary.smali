# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;
.super Ljava/lang/Object;
.source "KmpMediaLibrary.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;
.field private static handler:Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;
    invoke-direct v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;
    sget-object v0, Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;->INSTANCE Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;
    check-cast v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;
    sput-object v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->handler Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final configure(com.bytedance.trae.kmp.host.KmpMediaLibraryHandler)void
    .registers 3
    # ins_size=2
    const-string v0, "handler"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->handler Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;
    return-void 
.end method

.method public final saveLocalFile(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=5
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrary;->handler Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;
    invoke-interface v0, v2, v3, v4, v5, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;->saveLocalFile(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method
