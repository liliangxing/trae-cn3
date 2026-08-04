# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;
.super Ljava/lang/Object;
.source "KmpMediaLibrary.kt"

.implements Lcom/bytedance/trae/kmp/host/KmpMediaLibraryHandler;

.field public static final INSTANCE:Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;
    invoke-direct v0, Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;->INSTANCE Lcom/bytedance/trae/kmp/host/NoopKmpMediaLibraryHandler;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public saveLocalFile(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    new-instance v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    const/4 v2, 0
    const-string v3, "Media library handler is not configured"
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;-><init>(Z Ljava/lang/String;)V
    return-object v1
.end method
