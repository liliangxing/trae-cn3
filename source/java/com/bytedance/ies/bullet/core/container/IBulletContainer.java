package com.bytedance.ies.bullet.core.container;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IReleasable;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.webx.core.webview.WebViewContainer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IBulletContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001BJ.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011H&J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000fH&J'\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u001aH&¢\u0006\u0002\u0010\u001bJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J'\u0010\u001e\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00170\u001aH&¢\u0006\u0002\u0010!J\n\u0010\"\u001a\u0004\u0018\u00010#H&J\n\u0010$\u001a\u0004\u0018\u00010%H&J\n\u0010&\u001a\u0004\u0018\u00010#H&J\n\u0010'\u001a\u0004\u0018\u00010(H&J6\u0010)\u001a\u0004\u0018\u00010(\"\b\b\u0000\u0010\u0017*\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010#2\b\u0010+\u001a\u0004\u0018\u00010,2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u001aH&J\b\u0010-\u001a\u00020\u000fH&J(\u0010.\u001a\u00020\r2\u0006\u0010*\u001a\u00020#2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H&J\b\u00101\u001a\u00020\rH\u0016J\b\u00102\u001a\u00020\rH\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u00104\u001a\u000205H&J\b\u00106\u001a\u00020\rH&J\u001c\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u000100H&JB\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=2\b\b\u0002\u0010A\u001a\u00020=H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006C"}, d2 = {"Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "Lcom/bytedance/ies/bullet/service/base/IReleasable;", "activityWrapper", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "getActivityWrapper", "()Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "setActivityWrapper", "(Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;)V", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "addEventObserver", "", ReportConstant.COMMON_ACTION_TYPE, "", "name", "", "params", "Lorg/json/JSONObject;", "bind", "bid", "extraSchemaModelOfType", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getBulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletService", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getCurrentUri", "Landroid/net/Uri;", "getKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "getProcessingUri", "getSchemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSchemaModelUnionBeforeLoad", "uri", "bundle", "Landroid/os/Bundle;", "getSessionId", "loadUri", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "onEnterBackground", "onEnterForeground", "onEvent", "event", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "reLoadUri", WebViewContainer.EVENT_reload, "contextProviderFactory", "setLoadingView", "loadingView", "Landroid/view/View;", SchemaConstants.QUERY_KEY_GRAVITY, "", "marginLeft", "marginTop", "marginRight", "marginBottom", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletContainer extends IReleasable {
    void addEventObserver(String actionType, List<String> name, List<? extends JSONObject> params);

    void bind(String bid);

    <T extends ISchemaModel> T extraSchemaModelOfType(Class<T> type);

    IBulletActivityWrapper getActivityWrapper();

    BulletContext getBulletContext();

    <T extends IBulletService> T getBulletService(Class<T> clazz);

    Uri getCurrentUri();

    IKitViewService getKitView();

    Uri getProcessingUri();

    ContextProviderFactory getProviderFactory();

    SchemaModelUnion getSchemaModelUnion();

    <T extends ISchemaModel> SchemaModelUnion getSchemaModelUnionBeforeLoad(Uri uri, Bundle bundle, Class<T> type);

    String getSessionId();

    void loadUri(Uri uri, Bundle bundle, IBulletLifeCycle lifeCycle);

    void onEnterBackground();

    void onEnterForeground();

    void onEvent(IEvent event);

    void reLoadUri();

    void reload(ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle);

    void setActivityWrapper(IBulletActivityWrapper iBulletActivityWrapper);

    void setLoadingView(View loadingView, int gravity, int marginLeft, int marginTop, int marginRight, int marginBottom);

    /* compiled from: IBulletContainer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static BulletContext getBulletContext(IBulletContainer iBulletContainer) {
            return null;
        }

        public static void onEnterBackground(IBulletContainer iBulletContainer) {
        }

        public static void onEnterForeground(IBulletContainer iBulletContainer) {
        }

        public static /* synthetic */ void setLoadingView$default(IBulletContainer iBulletContainer, View view, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoadingView");
            }
            if ((i6 & 2) != 0) {
                i = 17;
            }
            iBulletContainer.setLoadingView(view, i, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? 0 : i3, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) != 0 ? 0 : i5);
        }

        public static /* synthetic */ void loadUri$default(IBulletContainer iBulletContainer, Uri uri, Bundle bundle, IBulletLifeCycle iBulletLifeCycle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadUri");
            }
            if ((i & 2) != 0) {
                bundle = null;
            }
            if ((i & 4) != 0) {
                iBulletLifeCycle = null;
            }
            iBulletContainer.loadUri(uri, bundle, iBulletLifeCycle);
        }
    }

    /* compiled from: IBulletContainer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J'\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016¢\u0006\u0002\u0010\u001cJ'\u0010\u001d\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016¢\u0006\u0002\u0010 J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J6\u0010(\u001a\u0004\u0018\u00010'\"\b\b\u0000\u0010\u0018*\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\"2\b\u0010*\u001a\u0004\u0018\u00010+2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J$\u0010-\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u000eH\u0016J\b\u00104\u001a\u00020\u000eH\u0016J\u001c\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\n2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J8\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020;H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006@"}, d2 = {"Lcom/bytedance/ies/bullet/core/container/IBulletContainer$Base;", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "()V", "activityWrapper", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "getActivityWrapper", "()Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "setActivityWrapper", "(Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;)V", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "addEventObserver", "", ReportConstant.COMMON_ACTION_TYPE, "", "name", "", "params", "Lorg/json/JSONObject;", "bind", "bid", "extraSchemaModelOfType", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getBulletService", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getCurrentUri", "Landroid/net/Uri;", "getKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "getProcessingUri", "getSchemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSchemaModelUnionBeforeLoad", "uri", "bundle", "Landroid/os/Bundle;", "getSessionId", "loadUri", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "onEvent", "event", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "reLoadUri", "release", WebViewContainer.EVENT_reload, "contextProviderFactory", "setLoadingView", "loadingView", "Landroid/view/View;", SchemaConstants.QUERY_KEY_GRAVITY, "", "marginLeft", "marginTop", "marginRight", "marginBottom", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static class Base implements IBulletContainer {
        private IBulletActivityWrapper activityWrapper;
        private final ContextProviderFactory providerFactory;

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void addEventObserver(String actionType, List<String> name, List<? extends JSONObject> params) {
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(params, "params");
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void bind(String bid) {
            Intrinsics.checkNotNullParameter(bid, "bid");
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public <T extends ISchemaModel> T extraSchemaModelOfType(Class<T> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public <T extends IBulletService> T getBulletService(Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public Uri getCurrentUri() {
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public IKitViewService getKitView() {
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public Uri getProcessingUri() {
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public SchemaModelUnion getSchemaModelUnion() {
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public <T extends ISchemaModel> SchemaModelUnion getSchemaModelUnionBeforeLoad(Uri uri, Bundle bundle, Class<T> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return null;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public String getSessionId() {
            return "";
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void loadUri(Uri uri, Bundle bundle, IBulletLifeCycle lifeCycle) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void onEvent(IEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void reLoadUri() {
        }

        @Override // com.bytedance.ies.bullet.service.base.IReleasable
        public void release() {
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void reload(ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle) {
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void setLoadingView(View loadingView, int gravity, int marginLeft, int marginTop, int marginRight, int marginBottom) {
            Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public BulletContext getBulletContext() {
            return DefaultImpls.getBulletContext(this);
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void onEnterBackground() {
            DefaultImpls.onEnterBackground(this);
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void onEnterForeground() {
            DefaultImpls.onEnterForeground(this);
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public ContextProviderFactory getProviderFactory() {
            return this.providerFactory;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public IBulletActivityWrapper getActivityWrapper() {
            return this.activityWrapper;
        }

        @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
        public void setActivityWrapper(IBulletActivityWrapper iBulletActivityWrapper) {
            this.activityWrapper = iBulletActivityWrapper;
        }
    }
}
