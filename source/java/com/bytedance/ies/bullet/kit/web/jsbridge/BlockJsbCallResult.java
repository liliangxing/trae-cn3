package com.bytedance.ies.bullet.kit.web.jsbridge;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IWebJsBridgeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/BlockJsbCallResult;", "", "shouldBlock", "", "msg", "", "(ZLjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getShouldBlock", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BlockJsbCallResult {
    private final String msg;
    private final boolean shouldBlock;

    public static /* synthetic */ BlockJsbCallResult copy$default(BlockJsbCallResult blockJsbCallResult, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = blockJsbCallResult.shouldBlock;
        }
        if ((i & 2) != 0) {
            str = blockJsbCallResult.msg;
        }
        return blockJsbCallResult.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShouldBlock() {
        return this.shouldBlock;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final BlockJsbCallResult copy(boolean shouldBlock, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return new BlockJsbCallResult(shouldBlock, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockJsbCallResult)) {
            return false;
        }
        BlockJsbCallResult blockJsbCallResult = (BlockJsbCallResult) other;
        return this.shouldBlock == blockJsbCallResult.shouldBlock && Intrinsics.areEqual(this.msg, blockJsbCallResult.msg);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.shouldBlock) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "BlockJsbCallResult(shouldBlock=" + this.shouldBlock + ", msg=" + this.msg + ')';
    }

    public BlockJsbCallResult(boolean z, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.shouldBlock = z;
        this.msg = msg;
    }

    public final boolean getShouldBlock() {
        return this.shouldBlock;
    }

    public final String getMsg() {
        return this.msg;
    }
}
