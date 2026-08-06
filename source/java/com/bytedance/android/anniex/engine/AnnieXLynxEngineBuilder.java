package com.bytedance.android.anniex.engine;

import android.content.MutableContextWrapper;
import com.bytedance.android.anniex.config.LynxEngineConfig;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.tasm.LynxEngineBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxEngineBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/engine/AnnieXLynxEngineBuilder;", "", "lynxBdxBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "lynxViewProvider", "Lcom/bytedance/android/monitorV2/lynx/jsb/LynxViewProvider;", "config", "Lcom/bytedance/android/anniex/config/LynxEngineConfig;", "(Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;Lcom/bytedance/android/monitorV2/lynx/jsb/LynxViewProvider;Lcom/bytedance/android/anniex/config/LynxEngineConfig;)V", "build", "Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;", "bid", "", "contextWrapper", "Landroid/content/MutableContextWrapper;", "builder", "Lcom/lynx/tasm/LynxEngineBuilder;", "sessionId", "setConfig", "setLynxBdxBridge", "setLynxViewProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxEngineBuilder {
    private LynxEngineConfig config;
    private LynxBDXBridge lynxBdxBridge;
    private LynxViewProvider lynxViewProvider;

    public AnnieXLynxEngineBuilder() {
        this(null, null, null, 7, null);
    }

    public AnnieXLynxEngineBuilder(LynxBDXBridge lynxBDXBridge, LynxViewProvider lynxViewProvider, LynxEngineConfig lynxEngineConfig) {
        this.lynxBdxBridge = lynxBDXBridge;
        this.lynxViewProvider = lynxViewProvider;
        this.config = lynxEngineConfig;
    }

    public /* synthetic */ AnnieXLynxEngineBuilder(LynxBDXBridge lynxBDXBridge, LynxViewProvider lynxViewProvider, LynxEngineConfig lynxEngineConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lynxBDXBridge, (i & 2) != 0 ? null : lynxViewProvider, (i & 4) != 0 ? null : lynxEngineConfig);
    }

    public final AnnieXLynxEngineBuilder setLynxBdxBridge(LynxBDXBridge lynxBdxBridge) {
        if (lynxBdxBridge != null) {
            this.lynxBdxBridge = lynxBdxBridge;
        }
        return this;
    }

    public final AnnieXLynxEngineBuilder setLynxViewProvider(LynxViewProvider lynxViewProvider) {
        if (lynxViewProvider != null) {
            this.lynxViewProvider = lynxViewProvider;
        }
        return this;
    }

    public final AnnieXLynxEngineBuilder setConfig(LynxEngineConfig config) {
        if (config != null) {
            this.config = config;
        }
        return this;
    }

    public final AnnieXLynxEngine build(String bid, MutableContextWrapper contextWrapper, LynxEngineBuilder builder, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(contextWrapper, "contextWrapper");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        AnnieXLynxEngine annieXLynxEngine = new AnnieXLynxEngine(bid, contextWrapper, builder, sessionId);
        LynxBDXBridge lynxBDXBridge = this.lynxBdxBridge;
        if (lynxBDXBridge != null) {
            annieXLynxEngine.setLynxBdxBridge$anniex_release(lynxBDXBridge);
        }
        LynxViewProvider lynxViewProvider = this.lynxViewProvider;
        if (lynxViewProvider != null) {
            annieXLynxEngine.setLynxViewProvider$anniex_release(lynxViewProvider);
        }
        LynxEngineConfig lynxEngineConfig = this.config;
        if (lynxEngineConfig != null) {
            annieXLynxEngine.setConfig$anniex_release(lynxEngineConfig);
        }
        annieXLynxEngine.setExpirationTimeAndCacheNumber$anniex_release();
        return annieXLynxEngine;
    }
}
