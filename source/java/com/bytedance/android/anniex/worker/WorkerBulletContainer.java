package com.bytedance.android.anniex.worker;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.container.IBulletActivityWrapper;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WorkerBulletContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J'\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\b\b\u0000\u0010\u001b*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001eH\u0016¢\u0006\u0002\u0010\u001fJ'\u0010 \u001a\u0004\u0018\u0001H\u001b\"\b\b\u0000\u0010\u001b*\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001eH\u0016¢\u0006\u0002\u0010#J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\n\u0010(\u001a\u0004\u0018\u00010%H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J6\u0010+\u001a\u0004\u0018\u00010*\"\b\b\u0000\u0010\u001b*\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010%2\b\u0010-\u001a\u0004\u0018\u00010.2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001eH\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J$\u00100\u001a\u00020\u00122\u0006\u0010,\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0012H\u0016J\b\u00107\u001a\u00020\u0012H\u0016J\u001c\u00108\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u00010\u00032\b\u00101\u001a\u0004\u0018\u000102H\u0016J8\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020>H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006C"}, d2 = {"Lcom/bytedance/android/anniex/worker/WorkerBulletContainer;", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "containerId", "", "JSWorkerBDXBridge", "Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;Ljava/lang/String;Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;)V", "activityWrapper", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "getActivityWrapper", "()Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "setActivityWrapper", "(Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;)V", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "addEventObserver", "", "actionType", StrategyConstants.NAME, "", "params", "Lorg/json/JSONObject;", "bind", "bid", "extraSchemaModelOfType", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getBulletService", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getCurrentUri", "Landroid/net/Uri;", "getKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "getProcessingUri", "getSchemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSchemaModelUnionBeforeLoad", "uri", "bundle", "Landroid/os/Bundle;", "getSessionId", "loadUri", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "onEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "reLoadUri", "release", "reload", "contextProviderFactory", "setLoadingView", "loadingView", "Landroid/view/View;", "gravity", "", "marginLeft", "marginTop", "marginRight", "marginBottom", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WorkerBulletContainer implements IBulletContainer {
    private final JSWorkerBDXBridge JSWorkerBDXBridge;
    private IBulletActivityWrapper activityWrapper;
    private final String containerId;
    private final ContextProviderFactory providerFactory;

    public void addEventObserver(String actionType, List<String> name, List<? extends JSONObject> params) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(name, StrategyConstants.NAME);
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public void bind(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
    }

    public <T extends ISchemaModel> T extraSchemaModelOfType(Class<T> type) {
        Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        return null;
    }

    public <T extends IBulletService> T getBulletService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return null;
    }

    public IKitViewService getKitView() {
        return null;
    }

    public Uri getProcessingUri() {
        return null;
    }

    public SchemaModelUnion getSchemaModelUnion() {
        return null;
    }

    public <T extends ISchemaModel> SchemaModelUnion getSchemaModelUnionBeforeLoad(Uri uri, Bundle bundle, Class<T> type) {
        Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        return null;
    }

    public void loadUri(Uri uri, Bundle bundle, IBulletLifeCycle lifeCycle) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    public void reLoadUri() {
    }

    public void release() {
    }

    public void reload(ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle) {
    }

    public void setLoadingView(View loadingView, int gravity, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
    }

    public WorkerBulletContainer(ContextProviderFactory contextProviderFactory, String str, JSWorkerBDXBridge jSWorkerBDXBridge) {
        Intrinsics.checkNotNullParameter(str, "containerId");
        this.containerId = str;
        this.JSWorkerBDXBridge = jSWorkerBDXBridge;
        this.providerFactory = contextProviderFactory;
    }

    public BulletContext getBulletContext() {
        return IBulletContainer.DefaultImpls.getBulletContext(this);
    }

    public void onEnterBackground() {
        IBulletContainer.DefaultImpls.onEnterBackground(this);
    }

    public void onEnterForeground() {
        IBulletContainer.DefaultImpls.onEnterForeground(this);
    }

    public ContextProviderFactory getProviderFactory() {
        return this.providerFactory;
    }

    public IBulletActivityWrapper getActivityWrapper() {
        return this.activityWrapper;
    }

    public void setActivityWrapper(IBulletActivityWrapper iBulletActivityWrapper) {
        this.activityWrapper = iBulletActivityWrapper;
    }

    public Uri getCurrentUri() {
        return Uri.parse("");
    }

    public void onEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        JSWorkerBDXBridge jSWorkerBDXBridge = this.JSWorkerBDXBridge;
        if (jSWorkerBDXBridge != null) {
            String name = event.getName();
            WorkerConvertUtils workerConvertUtils = WorkerConvertUtils.INSTANCE;
            Object params = event.getParams();
            Intrinsics.checkNotNull(params, "null cannot be cast to non-null type org.json.JSONObject");
            jSWorkerBDXBridge.sendJSEvent(name, workerConvertUtils.jsonToMap((JSONObject) params));
        }
    }

    /* renamed from: getSessionId, reason: from getter */
    public String getContainerId() {
        return this.containerId;
    }
}
