# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public interface abstract Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;
.super Ljava/lang/Object;
.source "KmpArtifactIo.kt"


.method public abstract atomicReplace(com.bytedance.trae.kmp.artifact.KmpFileReference  com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract createTemporaryFile(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract delete(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract exists(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract file(java.lang.String)com.bytedance.trae.kmp.artifact.KmpFileReference
    # abstract or native
.end method

.method public abstract list(kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract localUri(com.bytedance.trae.kmp.artifact.KmpFileReference)java.lang.String
    # abstract or native
.end method

.method public abstract metadata(com.bytedance.trae.kmp.artifact.KmpFileReference  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract read(com.bytedance.trae.kmp.artifact.KmpFileReference  long  int  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract touch(com.bytedance.trae.kmp.artifact.KmpFileReference  long  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract write(com.bytedance.trae.kmp.artifact.KmpFileReference  byte[]  boolean  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
