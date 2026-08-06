package com.bytedance.ies.bullet.service.base.router.config;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.service.base.IViewService;
import com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener;
import com.bytedance.ies.bullet.service.base.router.config.IRouterOpenListener;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R<\u0010'\u001a$\u0012\u0004\u0012\u00020)\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010*j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`+\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u00106\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R&\u00109\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u0002\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006L"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/router/config/RouterOpenConfig;", "", "()V", "animationBundle", "Landroid/os/Bundle;", "getAnimationBundle", "()Landroid/os/Bundle;", "setAnimationBundle", "(Landroid/os/Bundle;)V", SchemaConstants.QUERY_KEY_BUNDLE, "getBundle", "setBundle", RouterConstants.QUERY_KEY_FLAGS, "", "getFlags", "()Ljava/lang/Integer;", "setFlags", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "globalProps", "", "", "getGlobalProps", "()Ljava/util/Map;", "setGlobalProps", "(Ljava/util/Map;)V", "interceptors", "", "Lcom/bytedance/ies/bullet/service/schema/ISchemaInterceptor;", "getInterceptors", "()Ljava/util/List;", "setInterceptors", "(Ljava/util/List;)V", "lynxInitData", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "getLynxInitData", "()Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "setLynxInitData", "(Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;)V", "lynxPreloadJsFileProvider", "Lkotlin/Function1;", "Landroid/net/Uri;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLynxPreloadJsFileProvider", "()Lkotlin/jvm/functions/Function1;", "setLynxPreloadJsFileProvider", "(Lkotlin/jvm/functions/Function1;)V", "openListener", "Lcom/bytedance/ies/bullet/service/base/router/config/IRouterOpenListener;", "getOpenListener", "()Lcom/bytedance/ies/bullet/service/base/router/config/IRouterOpenListener;", "setOpenListener", "(Lcom/bytedance/ies/bullet/service/base/router/config/IRouterOpenListener;)V", "packageNames", "getPackageNames", "setPackageNames", "titleBarProvider", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "getTitleBarProvider$annotations", "getTitleBarProvider", "()Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "setTitleBarProvider", "(Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;)V", "uiLifecycleListener", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;", "getUiLifecycleListener", "()Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;", "setUiLifecycleListener", "(Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;)V", "viewService", "Lcom/bytedance/ies/bullet/service/base/IViewService;", "getViewService", "()Lcom/bytedance/ies/bullet/service/base/IViewService;", "setViewService", "(Lcom/bytedance/ies/bullet/service/base/IViewService;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RouterOpenConfig {
    private Bundle animationBundle;
    private Integer flags;
    private Map<String, ? extends Object> globalProps;
    private List<? extends ISchemaInterceptor> interceptors;
    private LynxInitDataWrapper lynxInitData;
    private Function1<? super Uri, ? extends ArrayList<String>> lynxPreloadJsFileProvider;
    private IBulletViewProvider.IBulletTitleBarProvider titleBarProvider;
    private IViewService viewService;
    private Bundle bundle = new Bundle();
    private List<String> packageNames = new ArrayList();
    private IRouterOpenListener openListener = new IRouterOpenListener.Base();
    private IBulletUILifecycleListener uiLifecycleListener = new IBulletUILifecycleListener.Base();

    @Deprecated(message = "使用 viewService 代替")
    public static /* synthetic */ void getTitleBarProvider$annotations() {
    }

    public final Integer getFlags() {
        return this.flags;
    }

    public final void setFlags(Integer num) {
        this.flags = num;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final void setBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.bundle = bundle;
    }

    public final Bundle getAnimationBundle() {
        return this.animationBundle;
    }

    public final void setAnimationBundle(Bundle bundle) {
        this.animationBundle = bundle;
    }

    public final List<String> getPackageNames() {
        return this.packageNames;
    }

    public final void setPackageNames(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.packageNames = list;
    }

    public final List<ISchemaInterceptor> getInterceptors() {
        return this.interceptors;
    }

    public final void setInterceptors(List<? extends ISchemaInterceptor> list) {
        this.interceptors = list;
    }

    public final IRouterOpenListener getOpenListener() {
        return this.openListener;
    }

    public final void setOpenListener(IRouterOpenListener iRouterOpenListener) {
        Intrinsics.checkNotNullParameter(iRouterOpenListener, "<set-?>");
        this.openListener = iRouterOpenListener;
    }

    public final IBulletUILifecycleListener getUiLifecycleListener() {
        return this.uiLifecycleListener;
    }

    public final void setUiLifecycleListener(IBulletUILifecycleListener iBulletUILifecycleListener) {
        Intrinsics.checkNotNullParameter(iBulletUILifecycleListener, "<set-?>");
        this.uiLifecycleListener = iBulletUILifecycleListener;
    }

    public final LynxInitDataWrapper getLynxInitData() {
        return this.lynxInitData;
    }

    public final void setLynxInitData(LynxInitDataWrapper lynxInitDataWrapper) {
        this.lynxInitData = lynxInitDataWrapper;
    }

    public final Map<String, Object> getGlobalProps() {
        return this.globalProps;
    }

    public final void setGlobalProps(Map<String, ? extends Object> map) {
        this.globalProps = map;
    }

    public final IBulletViewProvider.IBulletTitleBarProvider getTitleBarProvider() {
        return this.titleBarProvider;
    }

    public final void setTitleBarProvider(IBulletViewProvider.IBulletTitleBarProvider iBulletTitleBarProvider) {
        this.titleBarProvider = iBulletTitleBarProvider;
    }

    public final IViewService getViewService() {
        return this.viewService;
    }

    public final void setViewService(IViewService iViewService) {
        this.viewService = iViewService;
    }

    public final Function1<Uri, ArrayList<String>> getLynxPreloadJsFileProvider() {
        return this.lynxPreloadJsFileProvider;
    }

    public final void setLynxPreloadJsFileProvider(Function1<? super Uri, ? extends ArrayList<String>> function1) {
        this.lynxPreloadJsFileProvider = function1;
    }
}
