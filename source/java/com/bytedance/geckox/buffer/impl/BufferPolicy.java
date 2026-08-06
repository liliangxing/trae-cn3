package com.bytedance.geckox.buffer.impl;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferPolicy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/BufferPolicy;", "", "()V", "create", "Lcom/bytedance/geckox/buffer/Buffer;", "swap", "Ljava/io/File;", "length", "", "innerCreate", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BufferPolicy {
    public static final BufferPolicy INSTANCE = new BufferPolicy();

    private BufferPolicy() {
    }

    public final Buffer create(File swap, long length) throws IOException {
        Intrinsics.checkParameterIsNotNull(swap, "swap");
        return innerCreate(swap, length);
    }

    private final Buffer innerCreate(File swap, long length) throws IOException {
        if (length <= 0) {
            try {
                return new FileBuffer(swap);
            } catch (Exception e) {
                throw new IOException("create FileBuffer failed! file:" + swap.getAbsolutePath() + " caused by:" + e.getMessage(), e);
            }
        }
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        if (globalConfig == null || globalConfig.isUseMMap()) {
            try {
                return new MMapBuffer(length, swap);
            } catch (Exception e2) {
                GeckoLogger.m300w("mmap failed: " + swap.exists() + '-' + swap.length() + '-' + length + '-' + e2.getMessage());
            }
        }
        try {
            return new RAFBuffer(length, swap);
        } catch (Exception e3) {
            throw new RuntimeException("RAFBuffer failed! file: " + swap.getAbsolutePath() + '-' + e3.getMessage(), e3);
        }
    }
}
