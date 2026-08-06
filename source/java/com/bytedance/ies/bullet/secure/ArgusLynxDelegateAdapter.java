package com.bytedance.ies.bullet.secure;

import android.view.View;
import com.bytedance.ies.argus.api.ArgusAPI;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.params.AboutToRequestLynxSSRUrlParams;
import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusLynxDelegateAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/secure/ArgusLynxDelegateAdapter;", "", "delegate", "Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;", "(Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;)V", "getDelegate", "()Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;", "attachView", "view", "Lcom/lynx/tasm/LynxView;", "inSSRUrlAllowList", "", "ssrUrl", "", "onLoadTemplate", "", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "isMainTemplate", "enterFrom", "onViewDestroy", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArgusLynxDelegateAdapter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ArgusLynxDelegate delegate;

    public /* synthetic */ ArgusLynxDelegateAdapter(ArgusLynxDelegate argusLynxDelegate, DefaultConstructorMarker defaultConstructorMarker) {
        this(argusLynxDelegate);
    }

    private ArgusLynxDelegateAdapter(ArgusLynxDelegate argusLynxDelegate) {
        this.delegate = argusLynxDelegate;
    }

    public final ArgusLynxDelegate getDelegate() {
        return this.delegate;
    }

    /* compiled from: ArgusLynxDelegateAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/secure/ArgusLynxDelegateAdapter$Companion;", "", "()V", "build", "Lcom/bytedance/ies/bullet/secure/ArgusLynxDelegateAdapter;", "providerFactory", "Lcom/bytedance/ies/bullet/secure/SecureProviderFactory;", "view", "Lcom/lynx/tasm/LynxView;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgusLynxDelegateAdapter build(SecureProviderFactory providerFactory, LynxView view) {
            ArgusContainerDelegate argusContainerDelegate;
            ArgusLynxDelegate initLynxDelegate;
            DefaultConstructorMarker defaultConstructorMarker = null;
            BulletContext context = providerFactory != null ? providerFactory.getContext() : null;
            if (context == null) {
                argusContainerDelegate = HybridSecureManager.INSTANCE.getInstance().initArgusSecureDelegate();
            } else {
                argusContainerDelegate = context.getArgusContainerDelegate();
            }
            if (argusContainerDelegate == null || (initLynxDelegate = ArgusAPI.INSTANCE.initLynxDelegate(argusContainerDelegate, view)) == null) {
                return null;
            }
            return new ArgusLynxDelegateAdapter(initLynxDelegate, defaultConstructorMarker);
        }
    }

    public final ArgusLynxDelegateAdapter attachView(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.delegate.attachView((View) view);
        return this;
    }

    public final void onLoadTemplate(ResourceInfo resourceInfo, boolean isMainTemplate, String enterFrom) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        this.delegate.monitorLoadTemplate(new LoadTemplateParams(isMainTemplate, resourceInfo != null ? ArgusLynxDelegateAdapterKt.getSecureInfo(resourceInfo) : null, enterFrom));
    }

    public final void onViewDestroy() {
        this.delegate.monitorViewDestroy();
    }

    public final boolean inSSRUrlAllowList(String ssrUrl) {
        Intrinsics.checkNotNullParameter(ssrUrl, "ssrUrl");
        return this.delegate.verifyAboutToRequestLynxSSRUrl(new AboutToRequestLynxSSRUrlParams(ssrUrl)).isPass();
    }
}
