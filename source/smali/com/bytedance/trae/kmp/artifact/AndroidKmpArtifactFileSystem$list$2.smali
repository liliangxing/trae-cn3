# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final synthetic Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "AndroidKmpArtifactIo.kt"

.implements Lkotlin/jvm/functions/Function1;

.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;->INSTANCE Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;
    return-void 
.end method

.method constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 1
    const-class v2, Ljava/io/File;
    const-string v3, "isFile"
    const-string v4, "isFile()Z"
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final invoke(java.io.File)java.lang.Boolean
    .registers 3
    # ins_size=2
    const-string/jumbo v0, p0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/io/File;->isFile()Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/io/File;
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;->invoke(Ljava/io/File;)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method
