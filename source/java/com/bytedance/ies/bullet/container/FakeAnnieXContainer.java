package com.bytedance.ies.bullet.container;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.IWebKitViewService;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.push.interfaze.ISignalReportService;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FakeAnnieXContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0006\u0010\u0012\u001a\u00020\nJ\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020&0%H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010(\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0*H\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\nH\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u00020\u000fH\u0016J&\u00102\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\r2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000204\u0018\u00010%H\u0016J\b\u00105\u001a\u00020\nH\u0016J\u0012\u00106\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001f\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\rH\u0016J)\u0010>\u001a\u00020\n\"\u0004\b\u0000\u0010?2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002H?0A2\u0006\u0010B\u001a\u0002H?H\u0016¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020\nH\u0016J\u001e\u0010E\u001a\u00020\n2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000204\u0018\u00010%H\u0016J \u0010F\u001a\u00020\n2\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u000104\u0018\u00010%H\u0016J\u0010\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020\nH\u0016J\b\u0010L\u001a\u00020\nH\u0016J\u0010\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\rH\u0016J\u001c\u0010M\u001a\u00020\n2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002040%H\u0016J\u001c\u0010O\u001a\u00020\n2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002040%H\u0016J\u0018\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020SH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/bytedance/ies/bullet/container/FakeAnnieXContainer;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "()V", "activity", "Landroid/app/Activity;", "bulletContainerView", "Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "attach", "", "bindContainerId", "containerId", "", "canBackPress", "", "canGoBack", "close", "detach", "enterBackground", "enterForeground", "generateSchemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "schema", "getBDXLaunchMode", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXTag", "getBid", "getContainerId", "getContextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getCurrentUrl", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitView", "Landroid/view/View;", "getPerfMap", "", "", "getSchemaData", "getViewType", "getWeakContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "goBack", "hideError", "hideLoading", "interceptBackPress", "enable", "isVisibility", "loadSchema", "renderData", "", "observerKeyboardStatusChange", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onVisibleChange", "visible", "hasReadySendVisibleEvent", "(ZLjava/lang/Boolean;)V", "preloadSchema", "registerWeakHolder", "T", "clazz", "Ljava/lang/Class;", "item", "(Ljava/lang/Class;Ljava/lang/Object;)V", "release", "reload", "reloadTemplate", "templateData", "sendEvent", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "showError", "showLoading", "updateData", "data", "updateGlobalProps", "globalProps", "updateScreenMetrics", "width", "", "height", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FakeAnnieXContainer implements IContainer {
    private Activity activity;
    private BulletContainerView bulletContainerView;
    private BulletContext bulletContext;

    public void bindContainerId(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
    }

    public boolean canBackPress() {
        return false;
    }

    public boolean canGoBack() {
        return false;
    }

    public void enterBackground() {
    }

    public void enterForeground() {
    }

    public String getBDXTag() {
        return "";
    }

    public String getViewType() {
        return "page";
    }

    public void hideError() {
    }

    public void hideLoading() {
    }

    public void interceptBackPress(boolean enable) {
    }

    public boolean isVisibility() {
        return false;
    }

    public void loadSchema(String schema, Map<String, ? extends Object> renderData) {
        Intrinsics.checkNotNullParameter(schema, "schema");
    }

    public void observerKeyboardStatusChange() {
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onVisibleChange(boolean visible, Boolean hasReadySendVisibleEvent) {
    }

    public void preloadSchema(String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
    }

    public <T> void registerWeakHolder(Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
    }

    public void release() {
    }

    public void reloadTemplate(Map<String, ? extends Object> templateData) {
    }

    public void sendEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
    }

    public void showError() {
    }

    public void showLoading() {
    }

    public void updateData(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void updateGlobalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
    }

    public void updateScreenMetrics(int width, int height) {
    }

    public void finish() {
        IContainer.DefaultImpls.finish(this);
    }

    public ISchemaData getCurrentSchema() {
        return IContainer.DefaultImpls.getCurrentSchema(this);
    }

    public Context getSystemContext() {
        return IContainer.DefaultImpls.getSystemContext(this);
    }

    public void loadSchema(String str, Map<String, ? extends Object> map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle) {
        IContainer.DefaultImpls.loadSchema(this, str, map, contextProviderFactory, absAnnieXLifecycle);
    }

    public void onAttachToWindow() {
        IContainer.DefaultImpls.onAttachToWindow(this);
    }

    public void onEngineReady(ContextProviderFactory contextProviderFactory) {
        IContainer.DefaultImpls.onEngineReady(this, contextProviderFactory);
    }

    public final void attach(Activity activity, BulletContext bulletContext, BulletContainerView bulletContainerView) {
        this.activity = activity;
        this.bulletContext = bulletContext;
        this.bulletContainerView = bulletContainerView;
    }

    public final void detach() {
        this.activity = null;
        this.bulletContext = null;
        this.bulletContainerView = null;
    }

    public String getBid() {
        String bid;
        BulletContext bulletContext = this.bulletContext;
        return (bulletContext == null || (bid = bulletContext.getBid()) == null) ? "default_bid" : bid;
    }

    public String getContainerId() {
        String sessionId;
        BulletContext bulletContext = this.bulletContext;
        return (bulletContext == null || (sessionId = bulletContext.getSessionId()) == null) ? "" : sessionId;
    }

    public String getCurrentUrl() {
        String currentUrl;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        IKitViewService kitView = bulletContainerView != null ? bulletContainerView.getCurrentKitView() : null;
        IWebKitViewService iWebKitViewService = kitView instanceof IWebKitViewService ? (IWebKitViewService) kitView : null;
        return (iWebKitViewService == null || (currentUrl = iWebKitViewService.getCurrentUrl()) == null) ? "" : currentUrl;
    }

    public KitType getKitType() {
        return KitType.WEB;
    }

    public ISchemaData generateSchemaData(String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        SchemaService companion = SchemaService.INSTANCE.getInstance();
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        return companion.generateSchemaData("default_bid", uri);
    }

    public ISchemaData getSchemaData() {
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null) {
            return bulletContext.getSchemaData();
        }
        return null;
    }

    public void reload(Map<String, ? extends Object> renderData) {
        IKitViewService kitView;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView == null || (kitView = bulletContainerView.getCurrentKitView()) == null) {
            return;
        }
        kitView.reloadCurrentUrl();
    }

    public void goBack() {
        Activity activity;
        IKitViewService kitView;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        boolean z = false;
        if (bulletContainerView != null && (kitView = bulletContainerView.getCurrentKitView()) != null && kitView.onBackPressed()) {
            z = true;
        }
        if (z || (activity = this.activity) == null) {
            return;
        }
        activity.onBackPressed();
    }

    public void close() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.finish();
        }
    }

    public View getKitView() {
        IKitViewService kitView;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView == null || (kitView = bulletContainerView.getCurrentKitView()) == null) {
            return null;
        }
        return kitView.realView();
    }

    public ContextProviderFactory getContextProviderFactory() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return bulletContainerView.getProviderFactory();
        }
        return null;
    }

    public Map<String, Long> getPerfMap() {
        return MapsKt.emptyMap();
    }

    public WeakReference<Context> getWeakContext() {
        return new WeakReference<>(this.activity);
    }

    public LaunchMode getBDXLaunchMode() {
        return LaunchMode.MODE_UNSPECIFIED;
    }
}
