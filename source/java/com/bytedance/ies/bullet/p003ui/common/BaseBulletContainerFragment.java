package com.bytedance.ies.bullet.p003ui.common;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.container.BulletActivityWrapper;
import com.bytedance.ies.bullet.core.container.IBulletActivityWrapper;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelTransformer;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.interceptor.BundleInterceptor;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.uikit.base.AbsFragment;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.trae.login.activity.PhoneBindActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BaseBulletContainerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u007fB\u0005¢\u0006\u0002\u0010\u0003J.\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00192\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190.2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000.H\u0016J\u0010\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\u0019H\u0016J'\u00103\u001a\u0004\u0018\u0001H4\"\b\b\u0000\u00104*\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H407H\u0016¢\u0006\u0002\u00108J\b\u00109\u001a\u0004\u0018\u00010\u0019J\n\u0010:\u001a\u0004\u0018\u00010;H\u0016J'\u0010<\u001a\u0004\u0018\u0001H4\"\b\b\u0000\u00104*\u00020=2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H407H\u0016¢\u0006\u0002\u0010?J\n\u0010@\u001a\u0004\u0018\u00010)H\u0016J\n\u0010A\u001a\u0004\u0018\u00010BH\u0016J\n\u0010C\u001a\u0004\u0018\u00010)H\u0016J\n\u0010D\u001a\u0004\u0018\u00010EH\u0016J6\u0010F\u001a\u0004\u0018\u00010E\"\b\b\u0000\u00104*\u0002052\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u00106\u001a\b\u0012\u0004\u0012\u0002H407H\u0016J\b\u0010G\u001a\u00020\u0019H\u0016J\u0006\u0010H\u001a\u00020IJ\u0012\u0010J\u001a\u0004\u0018\u00010\"2\u0006\u0010K\u001a\u00020LH\u0016J$\u0010M\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010N\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010O\u001a\u00020+2\b\u0010P\u001a\u0004\u0018\u00010\u0017H\u0016J\"\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020S2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010W\u001a\u00020+2\u0006\u0010X\u001a\u00020YH\u0016J\u0012\u0010Z\u001a\u00020+2\b\u0010P\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010[\u001a\u0004\u0018\u00010\"2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010P\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010`\u001a\u00020+H\u0016J\u0010\u0010a\u001a\u00020+2\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u00020+H\u0016J\b\u0010e\u001a\u00020+H\u0016J-\u0010f\u001a\u00020+2\u0006\u0010R\u001a\u00020S2\u000e\u0010g\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190h2\u0006\u0010i\u001a\u00020jH\u0016¢\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020+H\u0016J\b\u0010m\u001a\u00020+H\u0016J\b\u0010n\u001a\u00020+H\u0016J\b\u0010o\u001a\u00020+H\u0016J\b\u0010p\u001a\u00020+H\u0016J\b\u0010q\u001a\u00020+H\u0016J\u001c\u0010r\u001a\u00020+2\b\u0010s\u001a\u0004\u0018\u00010%2\b\u0010N\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010t\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0016\u0010u\u001a\u00020+2\u0006\u0010!\u001a\u00020\"2\u0006\u0010v\u001a\u00020wJ8\u0010u\u001a\u00020+2\u0006\u0010!\u001a\u00020\"2\u0006\u0010x\u001a\u00020S2\u0006\u0010y\u001a\u00020S2\u0006\u0010z\u001a\u00020S2\u0006\u0010{\u001a\u00020S2\u0006\u0010|\u001a\u00020SH\u0016J\u0006\u0010}\u001a\u00020IJ\b\u0010~\u001a\u00020+H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\u0004\u0018\u00010%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0080\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BaseBulletContainerFragment;", "Lcom/bytedance/ies/uikit/base/AbsFragment;", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "()V", "activityWrapper", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "getActivityWrapper", "()Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "setActivityWrapper", "(Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;)V", "bulletContainerView", "Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "getBulletContainerView", "()Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "setBulletContainerView", "(Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;)V", "bulletLifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "getBulletLifeCycle", "()Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "setBulletLifeCycle", "(Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;)V", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "containerPackageName", "", "getContainerPackageName", "()Ljava/lang/String;", "setContainerPackageName", "(Ljava/lang/String;)V", "createTimeStamp", "", "Ljava/lang/Long;", "loadingView", "Landroid/view/View;", "mBid", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "uri", "Landroid/net/Uri;", "addEventObserver", "", "actionType", "name", "", "params", "Lorg/json/JSONObject;", PhoneBindActivity.MODE_BIND, "bid", "extraSchemaModelOfType", "T", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getBid", "getBulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletService", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getCurrentUri", "getKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "getProcessingUri", "getSchemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSchemaModelUnionBeforeLoad", "getSessionId", "hideLoading", "", "initOuterContainer", "activity", "Landroidx/fragment/app/FragmentActivity;", "loadUri", "lifeCycle", "onActivityCreated", "savedInstanceState", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onEvent", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "onFragmentLoadUri", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "reCreateKitView", "reLoadUri", "release", "reload", "contextProviderFactory", "setLoadUri", "setLoadingView", "lp", "Landroid/widget/FrameLayout$LayoutParams;", SchemaConstants.QUERY_KEY_GRAVITY, "marginLeft", "marginTop", "marginRight", "marginBottom", "showLoading", "updateLoadingView", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseBulletContainerFragment extends AbsFragment implements IBulletContainer {
    private IBulletActivityWrapper activityWrapper;
    private BulletContainerView bulletContainerView;
    private IBulletLifeCycle bulletLifeCycle = new IBulletLifeCycle.Base() { // from class: com.bytedance.ies.bullet.ui.common.BaseBulletContainerFragment$bulletLifeCycle$1
        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadStart(Uri uri, IBulletContainer container) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "fragment onLoadStart", null, "XPage", 2, null);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "fragment onLoadSchemaModelSuccess", null, "XPage", 2, null);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onKitViewCreate(Uri uri, IKitViewService kitView) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "fragment onLoadKitInstanceSuccess", null, "XPage", 2, null);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "fragment onLoadUriSuccess", null, "XPage", 2, null);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle.Base, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadFail(Uri uri, Throwable e) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(e, "e");
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "fragment onLoadFail", null, "XPage", 2, null);
        }
    };
    private Bundle bundle;
    private String containerPackageName;
    private Long createTimeStamp;
    private View loadingView;
    private String mBid;
    private Uri uri;

    public View initOuterContainer(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return null;
    }

    public void onFragmentLoadUri() {
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void onEnterBackground() {
        IBulletContainer.DefaultImpls.onEnterBackground(this);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void onEnterForeground() {
        IBulletContainer.DefaultImpls.onEnterForeground(this);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public ContextProviderFactory getProviderFactory() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return bulletContainerView.getProviderFactory();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public IBulletActivityWrapper getActivityWrapper() {
        return this.activityWrapper;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void setActivityWrapper(IBulletActivityWrapper iBulletActivityWrapper) {
        this.activityWrapper = iBulletActivityWrapper;
    }

    public final String getContainerPackageName() {
        return this.containerPackageName;
    }

    public final void setContainerPackageName(String str) {
        this.containerPackageName = str;
    }

    public final IBulletLifeCycle getBulletLifeCycle() {
        return this.bulletLifeCycle;
    }

    public final void setBulletLifeCycle(IBulletLifeCycle iBulletLifeCycle) {
        this.bulletLifeCycle = iBulletLifeCycle;
    }

    public final BulletContainerView getBulletContainerView() {
        return this.bulletContainerView;
    }

    public final void setBulletContainerView(BulletContainerView bulletContainerView) {
        this.bulletContainerView = bulletContainerView;
    }

    /* renamed from: getBid, reason: from getter */
    public final String getMBid() {
        return this.mBid;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void bind(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        this.mBid = bid;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public Uri getCurrentUri() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return bulletContainerView.getCurrentUri();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public BulletContext getBulletContext() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return bulletContainerView.getBulletContext();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public Uri getProcessingUri() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return bulletContainerView.getProcessingUri();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public SchemaModelUnion getSchemaModelUnion() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return bulletContainerView.getSchemaModelUnion();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void addEventObserver(String actionType, List<String> name, List<? extends JSONObject> params) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.addEventObserver(actionType, name, params);
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void onEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.onEvent(event);
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public String getSessionId() {
        String sessionId;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        return (bulletContainerView == null || (sessionId = bulletContainerView.getSessionId()) == null) ? "" : sessionId;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    /* renamed from: getKitView */
    public IKitViewService getCurrentKitView() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return bulletContainerView.getCurrentKitView();
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public <T extends IBulletService> T getBulletService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return (T) bulletContainerView.getBulletService(clazz);
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public <T extends ISchemaModel> T extraSchemaModelOfType(Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            return (T) bulletContainerView.extraSchemaModelOfType(type);
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public <T extends ISchemaModel> SchemaModelUnion getSchemaModelUnionBeforeLoad(Uri uri, Bundle bundle, Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (uri == null) {
            return null;
        }
        if (bundle != null) {
            SchemaConfig schemaConfig = new SchemaConfig();
            schemaConfig.addInterceptor(new BundleInterceptor(bundle));
            SchemaService.INSTANCE.getInstance().bindConfig(uri, schemaConfig);
        }
        SchemaModelUnion schemaModelUnion = new SchemaModelUnion(SchemaService.INSTANCE.getInstance().generateSchemaData(null, uri));
        BDXContainerModel bDXContainerModel = (BDXContainerModel) SchemaService.INSTANCE.getInstance().generateSchemaModel(schemaModelUnion.getSchemaData(), BDXContainerModel.class);
        if (bDXContainerModel != null) {
            SchemaModelTransformer.INSTANCE.transform(bDXContainerModel);
        }
        BDXPageModel bDXPageModel = (BDXPageModel) SchemaService.INSTANCE.getInstance().generateSchemaModel(schemaModelUnion.getSchemaData(), BDXPageModel.class);
        if (bDXPageModel != null) {
            SchemaModelTransformer.INSTANCE.transform(bDXPageModel);
        }
        ISchemaModel generateSchemaModel = SchemaService.INSTANCE.getInstance().generateSchemaModel(schemaModelUnion.getSchemaData(), type);
        schemaModelUnion.setContainerModel(bDXContainerModel);
        schemaModelUnion.setUiModel(bDXPageModel);
        schemaModelUnion.setKitModel(generateSchemaModel);
        return schemaModelUnion;
    }

    public static /* synthetic */ void setLoadUri$default(BaseBulletContainerFragment baseBulletContainerFragment, Uri uri, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoadUri");
        }
        if ((i & 2) != 0) {
            bundle = null;
        }
        baseBulletContainerFragment.setLoadUri(uri, bundle);
    }

    public void setLoadUri(Uri uri, Bundle bundle) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.bundle = bundle;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void setLoadingView(View loadingView, int gravity, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = marginLeft;
        layoutParams.rightMargin = marginRight;
        layoutParams.topMargin = marginTop;
        layoutParams.bottomMargin = marginBottom;
        layoutParams.gravity = gravity;
        loadingView.setLayoutParams(layoutParams);
        this.loadingView = loadingView;
    }

    public final void setLoadingView(View loadingView, FrameLayout.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        Intrinsics.checkNotNullParameter(lp, "lp");
        loadingView.setLayoutParams(lp);
        this.loadingView = loadingView;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void loadUri(Uri uri, Bundle bundle, IBulletLifeCycle lifeCycle) {
        IBulletActivityWrapper activityWrapper;
        BulletContainerView bulletContainerView;
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.bulletLifeCycle = lifeCycle;
        String str = this.mBid;
        if (str == null || (activityWrapper = getActivityWrapper()) == null || (bulletContainerView = this.bulletContainerView) == null) {
            return;
        }
        onFragmentLoadUri();
        bulletContainerView.bind(str);
        setActivityWrapper(activityWrapper);
        bulletContainerView.loadUri(uri, bundle, bulletContainerView.getProviderFactory(), lifeCycle);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void reLoadUri() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.reLoadUri();
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.release();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.createTimeStamp = Long.valueOf(System.currentTimeMillis());
        Activity activity = getActivity();
        if (activity != null) {
            if (getActivityWrapper() == null) {
                setActivityWrapper(new BulletActivityWrapper(activity));
            }
            View initOuterContainer = initOuterContainer(activity);
            if (initOuterContainer != null) {
                updateLoadingView();
                return initOuterContainer;
            }
        }
        View inflate = inflater.inflate(R.layout.bullet_fragment_base_container, container, false);
        BulletContainerView bulletContainerView = (BulletContainerView) inflate.findViewById(R.id.bullet_container_view);
        this.bulletContainerView = bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.setMCurrentScene(Scenes.ContainerFragment);
        }
        BulletContainerView bulletContainerView2 = this.bulletContainerView;
        if (bulletContainerView2 != null) {
            bulletContainerView2.onBulletViewCreate();
        }
        updateLoadingView();
        return inflate;
    }

    private final void updateLoadingView() {
        BulletContainerView bulletContainerView;
        View view = this.loadingView;
        if (view == null || (bulletContainerView = this.bulletContainerView) == null) {
            return;
        }
        bulletContainerView.setLoadingViewInternal$anniex_release(view);
    }

    public final boolean showLoading() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView == null) {
            return true;
        }
        bulletContainerView.dispatchShowLoading();
        return true;
    }

    public final boolean hideLoading() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView == null) {
            return true;
        }
        bulletContainerView.dispatchHideLoading();
        return true;
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        IBulletActivityWrapper activityWrapper;
        super.onActivityCreated(savedInstanceState);
        Uri uri = this.uri;
        if (uri != null) {
            loadUri(uri, this.bundle, this.bulletLifeCycle);
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (activityWrapper = getActivityWrapper()) == null) {
            return;
        }
        activityWrapper.onCreate((Activity) activity, savedInstanceState);
    }

    public void onStart() {
        IBulletActivityWrapper activityWrapper;
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null || (activityWrapper = getActivityWrapper()) == null) {
            return;
        }
        activityWrapper.onStart((Activity) activity);
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment
    public void onResume() {
        IBulletActivityWrapper activityWrapper;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity != null && (activityWrapper = getActivityWrapper()) != null) {
            activityWrapper.onResume((Activity) activity);
        }
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.onOpen();
        }
        reCreateKitView();
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment
    public void onPause() {
        IBulletActivityWrapper activityWrapper;
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity != null && (activityWrapper = getActivityWrapper()) != null) {
            activityWrapper.onPause((Activity) activity);
        }
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.onClose();
        }
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment
    public void onStop() {
        IBulletActivityWrapper activityWrapper;
        super.onStop();
        FragmentActivity activity = getActivity();
        if (activity == null || (activityWrapper = getActivityWrapper()) == null) {
            return;
        }
        activityWrapper.onStop((Activity) activity);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        IBulletActivityWrapper activityWrapper;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        FragmentActivity activity = getActivity();
        if (activity == null || (activityWrapper = getActivityWrapper()) == null) {
            return;
        }
        activityWrapper.onConfigurationChanged((Activity) activity, newConfig);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        IBulletActivityWrapper activityWrapper;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        FragmentActivity activity = getActivity();
        if (activity == null || (activityWrapper = getActivityWrapper()) == null) {
            return;
        }
        activityWrapper.onRequestPermissionsResult((Activity) activity, requestCode, permissions, grantResults);
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment
    public void onDestroy() {
        IBulletActivityWrapper activityWrapper;
        super.onDestroy();
        FragmentActivity activity = getActivity();
        if (activity != null && (activityWrapper = getActivityWrapper()) != null) {
            activityWrapper.onDestroy((Activity) activity);
        }
        release();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IBulletActivityWrapper activityWrapper;
        FragmentActivity activity = getActivity();
        if (activity == null || (activityWrapper = getActivityWrapper()) == null) {
            return;
        }
        activityWrapper.onActivityResult((Activity) activity, requestCode, resultCode, data);
    }

    /* compiled from: BaseBulletContainerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BaseBulletContainerFragment$Builder;", "", "fragment", "Lcom/bytedance/ies/bullet/ui/common/BaseBulletContainerFragment;", "(Lcom/bytedance/ies/bullet/ui/common/BaseBulletContainerFragment;)V", "activityWrapper", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "getFragment", "()Lcom/bytedance/ies/bullet/ui/common/BaseBulletContainerFragment;", "mBid", "", "packageName", PhoneBindActivity.MODE_BIND, "bid", "build", "", "setActivityWrapper", "setContainerPackageName", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Builder {
        private IBulletActivityWrapper activityWrapper;
        private final BaseBulletContainerFragment fragment;
        private String mBid;
        private String packageName;

        public Builder(BaseBulletContainerFragment baseBulletContainerFragment) {
            Intrinsics.checkNotNullParameter(baseBulletContainerFragment, "fragment");
            this.fragment = baseBulletContainerFragment;
        }

        public final BaseBulletContainerFragment getFragment() {
            return this.fragment;
        }

        public final Builder bind(String bid) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            this.mBid = bid;
            this.fragment.bind(bid);
            return this;
        }

        public final Builder setActivityWrapper(IBulletActivityWrapper activityWrapper) {
            Intrinsics.checkNotNullParameter(activityWrapper, "activityWrapper");
            this.activityWrapper = activityWrapper;
            this.fragment.setActivityWrapper(activityWrapper);
            return this;
        }

        public final Builder setContainerPackageName(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.packageName = packageName;
            this.fragment.setContainerPackageName(packageName);
            return this;
        }

        public final void build() {
            if (this.mBid == null || this.activityWrapper == null || TextUtils.isEmpty(this.packageName)) {
                Log.e("bullet", "fragment init rootContainer failed!!!");
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletContainer
    public void reload(ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle) {
        this.bulletLifeCycle = lifeCycle;
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            bulletContainerView.reload(contextProviderFactory, lifeCycle);
        }
    }

    public void reCreateKitView() {
        BulletContainerView bulletContainerView = this.bulletContainerView;
        if (bulletContainerView != null) {
            if (!(!bulletContainerView.hasKitView() && bulletContainerView.isLoadSuccess())) {
                bulletContainerView = null;
            }
            if (bulletContainerView != null) {
                bulletContainerView.reLoadUri();
            }
        }
    }
}
