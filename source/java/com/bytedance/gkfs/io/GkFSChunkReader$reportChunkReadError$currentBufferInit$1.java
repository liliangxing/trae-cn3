package com.bytedance.gkfs.io;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: chunk_reader.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final /* synthetic */ class GkFSChunkReader$reportChunkReadError$currentBufferInit$1 extends MutablePropertyReference0 {
    GkFSChunkReader$reportChunkReadError$currentBufferInit$1(GkFSChunkReader gkFSChunkReader) {
        super(gkFSChunkReader);
    }

    public String getName() {
        return "currentBuffer";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GkFSChunkReader.class);
    }

    public String getSignature() {
        return "getCurrentBuffer()Lcom/bytedance/gkfs/io/ChunkBuffer;";
    }

    public Object get() {
        return GkFSChunkReader.access$getCurrentBuffer$p((GkFSChunkReader) this.receiver);
    }

    public void set(Object obj) {
        ((GkFSChunkReader) this.receiver).currentBuffer = (ChunkBuffer) obj;
    }
}
