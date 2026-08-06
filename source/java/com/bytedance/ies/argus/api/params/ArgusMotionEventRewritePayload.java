package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ArgusMotionEventParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusMotionEventRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "sceneTag", "", "(Ljava/lang/String;)V", "getSceneTag", "()Ljava/lang/String;", "setSceneTag", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusMotionEventRewritePayload extends BaseRewritePayload {
    private String sceneTag;

    /* JADX WARN: Multi-variable type inference failed */
    public ArgusMotionEventRewritePayload() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ArgusMotionEventRewritePayload(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getSceneTag() {
        return this.sceneTag;
    }

    public final void setSceneTag(String str) {
        this.sceneTag = str;
    }

    public ArgusMotionEventRewritePayload(String str) {
        this.sceneTag = str;
    }
}
