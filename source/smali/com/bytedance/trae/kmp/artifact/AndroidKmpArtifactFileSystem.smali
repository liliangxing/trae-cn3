# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;
.super Ljava/lang/Object;
.source "AndroidKmpArtifactIo.kt"

.implements Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$Companion;
.field public static final ROOT_DIRECTORY_NAME:Ljava/lang/String;
.field private final root:Ljava/io/File;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->Companion Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->$stable I
    return-void 
.end method

.method public constructor <init>(java.io.File)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, root
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    invoke-virtual v2, Ljava/io/File;->isDirectory()Z
    move-result v0
    if-nez v0, +00bh
    invoke-virtual v2, Ljava/io/File;->mkdirs()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +005h
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->root Ljava/io/File;
    return-void 
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "Check failed."
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method

.method public static final synthetic access$reference(com.bytedance.trae.kmp.artifact.AndroidKmpArtifactFileSystem  java.io.File)com.bytedance.trae.kmp.artifact.KmpFileReference
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->reference(Ljava/io/File;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v0
    return-object v0
.end method

.method private final reference(java.io.File)com.bytedance.trae.kmp.artifact.KmpFileReference
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->root Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->getCanonicalFile()Ljava/io/File;
    move-result-object v0
    invoke-virtual v7, Ljava/io/File;->getCanonicalFile()Ljava/io/File;
    move-result-object v7
    invoke-virtual v7, Ljava/io/File;->getPath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, Ljava/io/File;->getPath()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +02bh
    invoke-virtual v7, Ljava/io/File;->getPath()Ljava/lang/String;
    move-result-object v1
    const-string v2, "getPath(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, Ljava/io/File;->getPath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v3, Ljava/io/File;->separator Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 0
    invoke-static v1, v2, v5, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    const/4 v5, 1
    if-eqz v5, +016h
    new-instance v1, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v7, v0, Lkotlin/io/FilesKt;->relativeTo(Ljava/io/File; Ljava/io/File;)Ljava/io/File;
    move-result-object v7
    invoke-static v7, Lkotlin/io/FilesKt;->getInvariantSeparatorsPath(Ljava/io/File;)Ljava/lang/String;
    move-result-object v7
    invoke-direct v1, v7, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;-><init>(Ljava/lang/String;)V
    return-object v1
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "File reference escaped managed root"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
.end method

.method private final resolve(com.bytedance.trae.kmp.artifact.KmpFileReference)java.io.File
    .registers 2
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifact/KmpFileReference;->getPath()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Ljava/lang/String;)Ljava/io/File;
    move-result-object v1
    return-object v1
.end method

.method private final resolve(java.lang.String)java.io.File
    .registers 8
    # ins_size=2
    new-instance v0, Ljava/io/File;
    iget-object v1, v6, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->root Ljava/io/File;
    const/4 v2, 1
    new-array v3, v2, [C
    const/16 v4, 47
    const/4 v5, 0
    aput-char v4, v3, v5
    invoke-static v7, v3, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v7
    invoke-direct v0, v1, v7, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/io/File;->getCanonicalFile()Ljava/io/File;
    move-result-object v7
    iget-object v0, v6, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->root Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->getCanonicalFile()Ljava/io/File;
    move-result-object v0
    invoke-virtual v7, Ljava/io/File;->getPath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, Ljava/io/File;->getPath()Ljava/lang/String;
    move-result-object v3
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +02ch
    invoke-virtual v7, Ljava/io/File;->getPath()Ljava/lang/String;
    move-result-object v1
    const-string v3, "getPath(...)"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, Ljava/io/File;->getPath()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    sget-object v3, Ljava/io/File;->separator Ljava/lang/String;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v1, v0, v5, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move v2, v5
    if-eqz v2, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v7
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "File reference escaped managed root"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
.end method

.method private final sanitize(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    check-cast v7, Ljava/lang/CharSequence;
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    check-cast v0, Ljava/lang/Appendable;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 0
    move v3, v2
    if-ge v3, v1, +020h
    invoke-interface v7, v3, Ljava/lang/CharSequence;->charAt(I)C
    move-result v4
    invoke-static v4, Ljava/lang/Character;->isLetterOrDigit(C)Z
    move-result v5
    if-nez v5, +00dh
    const/16 v5, 45
    if-eq v4, v5, +009h
    const/16 v5, 95
    if-ne v4, v5, +003h
    goto +3h
    move v5, v2
    goto +2h
    const/4 v5, 1
    if-eqz v5, +005h
    invoke-interface v0, v4, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;
    add-int/lit8 v3, v3, 1
    goto -1fh
    check-cast v0, Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    const-string v7, "artifact"
    check-cast v7, Ljava/lang/String;
    return-object v7
.end method

.method public atomicReplace(com.bytedance.trae.kmp.artifact.KmpFileReference  com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=4
    invoke-direct v6, v7, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v7
    invoke-direct v6, v8, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v1
    invoke-virtual v1, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v8
    if-eqz v8, +009h
    invoke-virtual v8, Ljava/io/File;->mkdirs()Z
    move-result v8
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/io/File;->exists()Z
    move-result v8
    if-eqz v8, +026h
    invoke-virtual v1, Ljava/io/File;->delete()Z
    move-result v8
    if-eqz v8, +003h
    goto +1eh
    new-instance v7, Ljava/lang/IllegalStateException;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "Failed to replace "
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-virtual v7, v1, Ljava/io/File;->renameTo(Ljava/io/File;)Z
    move-result v8
    if-nez v8, +02eh
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v7
    invoke-static/range v0 ... v5, Lkotlin/io/FilesKt;->copyTo$default(Ljava/io/File; Ljava/io/File; Z I I Ljava/lang/Object;)Ljava/io/File;
    invoke-virtual v7, Ljava/io/File;->delete()Z
    move-result v8
    if-eqz v8, +003h
    goto +1eh
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "Failed to delete "
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    new-instance v8, Ljava/lang/IllegalStateException;
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v8, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method public createTemporaryFile(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, ".tmp"
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->root Ljava/io/File;
    invoke-static v2, v3, v0, Ljava/io/File;->createTempFile(Ljava/lang/String; Ljava/lang/String; Ljava/io/File;)Ljava/io/File;
    move-result-object v2
    const-string v3, "createTempFile(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->reference(Ljava/io/File;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v2
    return-object v2
.end method

.method public delete(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v1
    invoke-virtual v1, Ljava/io/File;->exists()Z
    move-result v2
    if-eqz v2, +00bh
    invoke-virtual v1, Ljava/io/File;->delete()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method

.method public exists(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v1
    invoke-virtual v1, Ljava/io/File;->isFile()Z
    move-result v1
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method

.method public file(java.lang.String)com.bytedance.trae.kmp.artifact.KmpFileReference
    .registers 3
    # ins_size=2
    const-string/jumbo v0, relativePath
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Ljava/lang/String;)Ljava/io/File;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->reference(Ljava/io/File;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v2
    return-object v2
.end method

.method public list(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->root Ljava/io/File;
    invoke-static v2, Lkotlin/io/FilesKt;->walkTopDown(Ljava/io/File;)Lkotlin/io/FileTreeWalk;
    move-result-object v2
    check-cast v2, Lkotlin/sequences/Sequence;
    sget-object v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;->INSTANCE Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$2;
    check-cast v0, Lkotlin/jvm/functions/Function1;
    invoke-static v2, v0, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$3;
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$3;-><init>(Ljava/lang/Object;)V
    check-cast v0, Lkotlin/jvm/functions/Function1;
    invoke-static v2, v0, Lkotlin/sequences/SequencesKt;->map(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    invoke-static v2, Lkotlin/sequences/SequencesKt;->toList(Lkotlin/sequences/Sequence;)Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method public localUri(com.bytedance.trae.kmp.artifact.KmpFileReference)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "file"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v2
    invoke-virtual v2, Ljava/io/File;->toURI()Ljava/net/URI;
    move-result-object v2
    invoke-virtual v2, Ljava/net/URI;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toString(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public metadata(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    invoke-direct v4, v5, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v5
    invoke-virtual v5, Ljava/io/File;->isFile()Z
    move-result v6
    if-nez v6, +004h
    const/4 v5, 0
    return-object v5
    new-instance v6, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    invoke-virtual v5, Ljava/io/File;->length()J
    move-result-wide v0
    invoke-virtual v5, Ljava/io/File;->lastModified()J
    move-result-wide v2
    invoke-direct v6, v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;-><init>(J J)V
    return-object v6
.end method

.method public read(com.bytedance.trae.kmp.artifact.KmpFileReference  long  int  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=6
    invoke-direct v6, v7, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v7
    invoke-virtual v7, Ljava/io/File;->isFile()Z
    move-result v11
    if-eqz v11, +03ch
    if-gtz v10, +003h
    goto +38h
    new-instance v11, Ljava/io/RandomAccessFile;
    const-string/jumbo v0, r
    invoke-direct v11, v7, v0, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File; Ljava/lang/String;)V
    check-cast v11, Ljava/io/Closeable;
    move-object v7, v11
    check-cast v7, Ljava/io/RandomAccessFile;
    const-wide/16 v2, 0
    invoke-virtual v7, Ljava/io/RandomAccessFile;->length()J
    move-result-wide v4
    move-wide v0, v8
    invoke-static/range v0 ... v5, Lkotlin/ranges/RangesKt;->coerceIn(J J J)J
    move-result-wide v8
    invoke-virtual v7, v8, v9, Ljava/io/RandomAccessFile;->seek(J)V
    int-to-long v0, v10
    invoke-virtual v7, Ljava/io/RandomAccessFile;->length()J
    move-result-wide v2
    sub-long/2addr v2, v8
    invoke-static v0, v1, v2, v3, Ljava/lang/Math;->min(J J)J
    move-result-wide v8
    long-to-int v8, v8
    new-array v8, v8, [B
    invoke-virtual v7, v8, Ljava/io/RandomAccessFile;->readFully([B)V
    const/4 v7, 0
    invoke-static v11, v7, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v8
    move-exception v7
    throw v7
    move-exception v8
    invoke-static v11, v7, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v8
    const/4 v7, 0
    new-array v7, v7, [B
    return-object v7
    :try_start_0x17
    :try_start_0x3e
.end method

.method public touch(com.bytedance.trae.kmp.artifact.KmpFileReference  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v1
    invoke-virtual v1, v2, v3, Ljava/io/File;->setLastModified(J)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public write(com.bytedance.trae.kmp.artifact.KmpFileReference  byte[]  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->resolve(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)Ljava/io/File;
    move-result-object v1
    invoke-virtual v1, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v4
    if-eqz v4, +009h
    invoke-virtual v4, Ljava/io/File;->mkdirs()Z
    move-result v4
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    new-instance v4, Ljava/io/FileOutputStream;
    invoke-direct v4, v1, v3, Ljava/io/FileOutputStream;-><init>(Ljava/io/File; Z)V
    check-cast v4, Ljava/io/OutputStream;
    instance-of v1, v4, Ljava/io/BufferedOutputStream;
    if-eqz v1, +005h
    check-cast v4, Ljava/io/BufferedOutputStream;
    goto +9h
    new-instance v1, Ljava/io/BufferedOutputStream;
    const/16 v3, 8192
    invoke-direct v1, v4, v3, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream; I)V
    move-object v4, v1
    check-cast v4, Ljava/io/Closeable;
    move-object v1, v4
    check-cast v1, Ljava/io/BufferedOutputStream;
    invoke-virtual v1, v2, Ljava/io/BufferedOutputStream;->write([B)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v1, 0
    invoke-static v4, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    move-exception v1
    throw v1
    move-exception v2
    invoke-static v4, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v2
    :try_start_0x29
    :try_start_0x39
.end method
