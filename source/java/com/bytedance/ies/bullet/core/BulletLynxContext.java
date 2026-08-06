package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import com.lynx.tasm.LynxViewClient;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R<\u0010\u001a\u001a$\u0012\u0004\u0012\u00020\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u001e\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletLynxContext;", "", "()V", "initDataWrapper", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "getInitDataWrapper", "()Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "setInitDataWrapper", "(Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;)V", "isLynxEngineReady", "", "()Z", "setLynxEngineReady", "(Z)V", "lynxFailReason", "", "getLynxFailReason", "()Ljava/lang/String;", "setLynxFailReason", "(Ljava/lang/String;)V", "lynxGlobalConfig", "Lcom/bytedance/ies/bullet/core/IEngineGlobalConfig;", "getLynxGlobalConfig", "()Lcom/bytedance/ies/bullet/core/IEngineGlobalConfig;", "setLynxGlobalConfig", "(Lcom/bytedance/ies/bullet/core/IEngineGlobalConfig;)V", "lynxPreloadJsFileProvider", "Lkotlin/Function1;", "Landroid/net/Uri;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLynxPreloadJsFileProvider", "()Lkotlin/jvm/functions/Function1;", "setLynxPreloadJsFileProvider", "(Lkotlin/jvm/functions/Function1;)V", "lynxViewClient", "Lcom/lynx/tasm/LynxViewClient;", "getLynxViewClient", "()Lcom/lynx/tasm/LynxViewClient;", "setLynxViewClient", "(Lcom/lynx/tasm/LynxViewClient;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BulletLynxContext {
    private LynxInitDataWrapper initDataWrapper;
    private boolean isLynxEngineReady;
    private String lynxFailReason;
    private IEngineGlobalConfig lynxGlobalConfig;
    private Function1<? super Uri, ? extends ArrayList<String>> lynxPreloadJsFileProvider;
    private LynxViewClient lynxViewClient;

    public final IEngineGlobalConfig getLynxGlobalConfig() {
        return this.lynxGlobalConfig;
    }

    public final void setLynxGlobalConfig(IEngineGlobalConfig iEngineGlobalConfig) {
        this.lynxGlobalConfig = iEngineGlobalConfig;
    }

    public final LynxInitDataWrapper getInitDataWrapper() {
        return this.initDataWrapper;
    }

    public final void setInitDataWrapper(LynxInitDataWrapper lynxInitDataWrapper) {
        this.initDataWrapper = lynxInitDataWrapper;
    }

    public final String getLynxFailReason() {
        return this.lynxFailReason;
    }

    public final void setLynxFailReason(String str) {
        this.lynxFailReason = str;
    }

    /* renamed from: isLynxEngineReady, reason: from getter */
    public final boolean getIsLynxEngineReady() {
        return this.isLynxEngineReady;
    }

    public final void setLynxEngineReady(boolean z) {
        this.isLynxEngineReady = z;
    }

    public final LynxViewClient getLynxViewClient() {
        return this.lynxViewClient;
    }

    public final void setLynxViewClient(LynxViewClient lynxViewClient) {
        this.lynxViewClient = lynxViewClient;
    }

    public final Function1<Uri, ArrayList<String>> getLynxPreloadJsFileProvider() {
        return this.lynxPreloadJsFileProvider;
    }

    public final void setLynxPreloadJsFileProvider(Function1<? super Uri, ? extends ArrayList<String>> function1) {
        this.lynxPreloadJsFileProvider = function1;
    }
}
