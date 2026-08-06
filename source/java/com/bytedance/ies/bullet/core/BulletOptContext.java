package com.bytedance.ies.bullet.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletOptContext;", "", "()V", "asyncAdblockInit", "", "getAsyncAdblockInit", "()Z", "setAsyncAdblockInit", "(Z)V", "skipAnimation", "getSkipAnimation", "setSkipAnimation", "skipBizLogic", "getSkipBizLogic", "setSkipBizLogic", "skipPageProvideView", "getSkipPageProvideView", "setSkipPageProvideView", "init", "", "category", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BulletOptContext {
    private boolean asyncAdblockInit;
    private boolean skipAnimation;
    private boolean skipBizLogic;
    private boolean skipPageProvideView;

    public final boolean getSkipBizLogic() {
        return this.skipBizLogic;
    }

    public final void setSkipBizLogic(boolean z) {
        this.skipBizLogic = z;
    }

    public final boolean getAsyncAdblockInit() {
        return this.asyncAdblockInit;
    }

    public final void setAsyncAdblockInit(boolean z) {
        this.asyncAdblockInit = z;
    }

    public final boolean getSkipAnimation() {
        return this.skipAnimation;
    }

    public final void setSkipAnimation(boolean z) {
        this.skipAnimation = z;
    }

    public final boolean getSkipPageProvideView() {
        return this.skipPageProvideView;
    }

    public final void setSkipPageProvideView(boolean z) {
        this.skipPageProvideView = z;
    }

    public final void init(JSONObject category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.skipBizLogic = category.optBoolean("skipBizLogic", false);
        this.asyncAdblockInit = category.optBoolean("asyncAdblockInit", false);
        this.skipAnimation = category.optBoolean("skipAnimation", false);
        this.skipPageProvideView = category.optBoolean("skipPageProvideView", false);
    }
}
