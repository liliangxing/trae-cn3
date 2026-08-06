package com.bytedance.ies.bullet.core;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.base.lynx.LynxError;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.transform.Transformer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PoolBulletLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001aH\u0016J\u0014\u0010)\u001a\u00020#2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010+J\u001a\u0010,\u001a\u00020#2\u0006\u0010'\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010.\u001a\u00020#2\u0006\u0010'\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u001c2\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u00100\u001a\u00020#2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001aH\u0016J\"\u00101\u001a\u00020#2\u0006\u0010'\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u00020\u001fH\u0016J\u001a\u00103\u001a\u00020#2\u0006\u0010'\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u00105\u001a\u00020#2\u0006\u0010'\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u00106\u001a\u00020#H\u0016J\u001a\u00107\u001a\u00020#2\u0006\u0010'\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ies/bullet/core/PoolBulletLifeCycle;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "()V", "flagBulletViewCreate", "", "flagFallback", "flagKitViewCreate", "flagLoadFail", "flagLoadParamsSuccess", "flagLoadStart", "flagLoadUriSuccess", "flagOpen", "flagRuntimeReady", "hasCallback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getHasCallback", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lynxClient", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClient", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "setLynxClient", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;)V", "savedContainer", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "savedFallbackThrowable", "", "savedKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "savedLoadFailThrowable", "savedParams", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "savedUri", "Landroid/net/Uri;", "onBulletViewCreate", "", "onBulletViewRelease", "onClose", "onFallback", "uri", "e", "onFetchFromPreRenderPool", "lifeCycles", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "onKitViewCreate", "kitView", "onKitViewDestroy", "throwable", "onLoadFail", "onLoadModelSuccess", "schemaModelUnion", "onLoadStart", "container", "onLoadUriSuccess", "onOpen", "onRuntimeReady", "PoolLynxClientDelegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PoolBulletLifeCycle implements IBulletLifeCycle {
    private boolean flagBulletViewCreate;
    private boolean flagFallback;
    private boolean flagKitViewCreate;
    private boolean flagLoadFail;
    private boolean flagLoadParamsSuccess;
    private boolean flagLoadStart;
    private boolean flagLoadUriSuccess;
    private boolean flagOpen;
    private boolean flagRuntimeReady;
    private final AtomicBoolean hasCallback = new AtomicBoolean(false);
    private ILynxClientDelegate lynxClient = new PoolLynxClientDelegate() { // from class: com.bytedance.ies.bullet.core.PoolBulletLifeCycle$lynxClient$1
        private boolean flagFirstLoadPerf;
        private boolean flagFirstScreen;
        private boolean flagLoadFailed;
        private boolean flagLoadSuccess;
        private boolean flagPageStart;
        private boolean flagPageUpdate;
        private boolean flagReceivedError;
        private boolean flagReceivedLynxError;
        private boolean flagRuntimeReady;
        private boolean flagUpdatePerf;
        private IKitViewService savedKitView;
        private String savedLoadFailedError;
        private JSONObject savedPerf;
        private String savedReceivedErrorMsg;
        private LynxError savedReceivedLynxError;
        private JSONObject savedUpdatePerf;
        private String savedUrl;

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void loadImage(IKitViewService viewService, Context context, String cacheKey, String src, float width, float height, Transformer transformer, Function2<Object, ? super Throwable, Unit> handler) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(handler, "handler");
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public String shouldRedirectImageUrl(String url) {
            return null;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onPageStart(IKitViewService viewService, String url) {
            this.flagPageStart = true;
            this.savedKitView = viewService;
            this.savedUrl = url;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onLoadSuccess(IKitViewService viewService) {
            this.flagLoadSuccess = true;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onFirstScreen(IKitViewService viewService) {
            this.flagFirstScreen = true;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onPageUpdate(IKitViewService viewService) {
            this.flagPageUpdate = true;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onLoadFailed(IKitViewService viewService, String errorMsg) {
            this.flagLoadFailed = true;
            this.savedLoadFailedError = errorMsg;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onReceivedError(IKitViewService viewService, String errorMsg) {
            this.flagReceivedError = true;
            this.savedReceivedErrorMsg = errorMsg;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onReceivedError(IKitViewService viewService, LynxError error) {
            this.flagReceivedLynxError = true;
            this.savedReceivedLynxError = error;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onFirstLoadPerfReady(IKitViewService viewService, JSONObject pref) {
            this.flagFirstLoadPerf = true;
            this.savedPerf = pref;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onUpdatePerfReady(IKitViewService viewService, JSONObject pref) {
            this.flagUpdatePerf = true;
            this.savedUpdatePerf = pref;
        }

        @Override // com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate.Base, com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate
        public void onRuntimeReady(IKitViewService viewService) {
            this.flagRuntimeReady = true;
        }

        @Override // com.bytedance.ies.bullet.core.PoolBulletLifeCycle.PoolLynxClientDelegate
        public void onFetchFromPreRenderPool(ConcurrentLinkedQueue<IBulletLifeCycle> lifeCycles) {
            IBulletLifeCycle expectPool;
            ILynxClientDelegate lynxClient;
            IBulletLifeCycle expectPool2;
            ILynxClientDelegate lynxClient2;
            IBulletLifeCycle expectPool3;
            ILynxClientDelegate lynxClient3;
            IBulletLifeCycle expectPool4;
            ILynxClientDelegate lynxClient4;
            IBulletLifeCycle expectPool5;
            ILynxClientDelegate lynxClient5;
            IBulletLifeCycle expectPool6;
            ILynxClientDelegate lynxClient6;
            IBulletLifeCycle expectPool7;
            ILynxClientDelegate lynxClient7;
            IBulletLifeCycle expectPool8;
            ILynxClientDelegate lynxClient8;
            IBulletLifeCycle expectPool9;
            ILynxClientDelegate lynxClient9;
            IBulletLifeCycle expectPool10;
            ILynxClientDelegate lynxClient10;
            Intrinsics.checkNotNullParameter(lifeCycles, "lifeCycles");
            if (this.flagPageStart) {
                for (IBulletLifeCycle iBulletLifeCycle : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                    expectPool10 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle);
                    if (expectPool10 != null && (lynxClient10 = expectPool10.getLynxClient()) != null) {
                        lynxClient10.onPageStart(this.savedKitView, this.savedUrl);
                    }
                }
            }
            if (this.flagLoadSuccess) {
                for (IBulletLifeCycle iBulletLifeCycle2 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle2, "it");
                    expectPool9 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle2);
                    if (expectPool9 != null && (lynxClient9 = expectPool9.getLynxClient()) != null) {
                        lynxClient9.onLoadSuccess(this.savedKitView);
                    }
                }
            }
            if (this.flagFirstScreen) {
                for (IBulletLifeCycle iBulletLifeCycle3 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle3, "it");
                    expectPool8 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle3);
                    if (expectPool8 != null && (lynxClient8 = expectPool8.getLynxClient()) != null) {
                        lynxClient8.onFirstScreen(this.savedKitView);
                    }
                }
            }
            if (this.flagPageUpdate) {
                for (IBulletLifeCycle iBulletLifeCycle4 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle4, "it");
                    expectPool7 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle4);
                    if (expectPool7 != null && (lynxClient7 = expectPool7.getLynxClient()) != null) {
                        lynxClient7.onPageUpdate(this.savedKitView);
                    }
                }
            }
            if (this.flagLoadFailed) {
                for (IBulletLifeCycle iBulletLifeCycle5 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle5, "it");
                    expectPool6 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle5);
                    if (expectPool6 != null && (lynxClient6 = expectPool6.getLynxClient()) != null) {
                        lynxClient6.onLoadFailed(this.savedKitView, this.savedLoadFailedError);
                    }
                }
                this.savedLoadFailedError = null;
            }
            if (this.flagReceivedError) {
                for (IBulletLifeCycle iBulletLifeCycle6 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle6, "it");
                    expectPool5 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle6);
                    if (expectPool5 != null && (lynxClient5 = expectPool5.getLynxClient()) != null) {
                        lynxClient5.onReceivedError(this.savedKitView, this.savedReceivedErrorMsg);
                    }
                }
                this.savedReceivedErrorMsg = null;
            }
            if (this.flagReceivedLynxError) {
                for (IBulletLifeCycle iBulletLifeCycle7 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle7, "it");
                    expectPool4 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle7);
                    if (expectPool4 != null && (lynxClient4 = expectPool4.getLynxClient()) != null) {
                        lynxClient4.onReceivedError(this.savedKitView, this.savedReceivedLynxError);
                    }
                }
                this.savedReceivedLynxError = null;
            }
            if (this.flagFirstLoadPerf) {
                for (IBulletLifeCycle iBulletLifeCycle8 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle8, "it");
                    expectPool3 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle8);
                    if (expectPool3 != null && (lynxClient3 = expectPool3.getLynxClient()) != null) {
                        lynxClient3.onFirstLoadPerfReady(this.savedKitView, this.savedPerf);
                    }
                }
                this.savedPerf = null;
            }
            if (this.flagUpdatePerf) {
                for (IBulletLifeCycle iBulletLifeCycle9 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle9, "it");
                    expectPool2 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle9);
                    if (expectPool2 != null && (lynxClient2 = expectPool2.getLynxClient()) != null) {
                        lynxClient2.onUpdatePerfReady(this.savedKitView, this.savedUpdatePerf);
                    }
                }
                this.savedUpdatePerf = null;
            }
            if (this.flagRuntimeReady) {
                for (IBulletLifeCycle iBulletLifeCycle10 : lifeCycles) {
                    Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle10, "it");
                    expectPool = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle10);
                    if (expectPool != null && (lynxClient = expectPool.getLynxClient()) != null) {
                        lynxClient.onRuntimeReady(this.savedKitView);
                    }
                }
            }
            this.savedKitView = null;
            this.savedUrl = null;
        }
    };
    private IBulletContainer savedContainer;
    private Throwable savedFallbackThrowable;
    private IKitViewService savedKitView;
    private Throwable savedLoadFailThrowable;
    private SchemaModelUnion savedParams;
    private Uri savedUri;

    /* compiled from: PoolBulletLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/core/PoolBulletLifeCycle$PoolLynxClientDelegate;", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate$Base;", "()V", "onFetchFromPreRenderPool", "", "lifeCycles", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class PoolLynxClientDelegate extends ILynxClientDelegate.Base {
        public void onFetchFromPreRenderPool(ConcurrentLinkedQueue<IBulletLifeCycle> lifeCycles) {
            Intrinsics.checkNotNullParameter(lifeCycles, "lifeCycles");
        }
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewRelease() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onClose() {
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewDestroy(Uri uri, IKitViewService kitView, Throwable throwable) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    public final AtomicBoolean getHasCallback() {
        return this.hasCallback;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public ILynxClientDelegate getLynxClient() {
        return this.lynxClient;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void setLynxClient(ILynxClientDelegate iLynxClientDelegate) {
        this.lynxClient = iLynxClientDelegate;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewCreate() {
        this.flagBulletViewCreate = true;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadStart(Uri uri, IBulletContainer container) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.flagLoadStart = true;
        this.savedUri = uri;
        this.savedContainer = container;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
        this.flagLoadParamsSuccess = true;
        this.savedParams = schemaModelUnion;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewCreate(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.flagKitViewCreate = true;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onOpen() {
        this.flagOpen = true;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onRuntimeReady(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.flagRuntimeReady = true;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.flagLoadUriSuccess = true;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadFail(Uri uri, Throwable e) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        this.flagLoadFail = true;
        this.savedLoadFailThrowable = e;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onFallback(Uri uri, Throwable e) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        this.flagFallback = true;
        this.savedFallbackThrowable = e;
    }

    public final void onFetchFromPreRenderPool(ConcurrentLinkedQueue<IBulletLifeCycle> lifeCycles) {
        IBulletLifeCycle expectPool;
        IBulletLifeCycle expectPool2;
        IBulletLifeCycle expectPool3;
        IBulletLifeCycle expectPool4;
        IBulletLifeCycle expectPool5;
        IBulletLifeCycle expectPool6;
        IBulletLifeCycle expectPool7;
        IBulletLifeCycle expectPool8;
        IBulletLifeCycle expectPool9;
        Intrinsics.checkNotNullParameter(lifeCycles, "lifeCycles");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "onFetchFromPreRenderPool", null, "XView", 2, null);
        if (this.flagBulletViewCreate) {
            for (IBulletLifeCycle iBulletLifeCycle : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle, "it");
                expectPool9 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle);
                if (expectPool9 != null) {
                    expectPool9.onBulletViewCreate();
                }
            }
        }
        if (this.flagLoadStart && this.savedUri != null) {
            for (IBulletLifeCycle iBulletLifeCycle2 : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle2, "it");
                expectPool8 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle2);
                if (expectPool8 != null) {
                    Uri uri = this.savedUri;
                    Intrinsics.checkNotNull(uri);
                    expectPool8.onLoadStart(uri, this.savedContainer);
                }
            }
            this.savedContainer = null;
        }
        if (this.flagLoadParamsSuccess && this.savedUri != null && this.savedParams != null) {
            for (IBulletLifeCycle iBulletLifeCycle3 : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle3, "it");
                expectPool7 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle3);
                if (expectPool7 != null) {
                    Uri uri2 = this.savedUri;
                    Intrinsics.checkNotNull(uri2);
                    IKitViewService iKitViewService = this.savedKitView;
                    SchemaModelUnion schemaModelUnion = this.savedParams;
                    Intrinsics.checkNotNull(schemaModelUnion);
                    expectPool7.onLoadModelSuccess(uri2, iKitViewService, schemaModelUnion);
                }
            }
            this.savedParams = null;
        }
        if (this.flagKitViewCreate && this.savedUri != null) {
            for (IBulletLifeCycle iBulletLifeCycle4 : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle4, "it");
                expectPool6 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle4);
                if (expectPool6 != null) {
                    Uri uri3 = this.savedUri;
                    Intrinsics.checkNotNull(uri3);
                    expectPool6.onKitViewCreate(uri3, this.savedKitView);
                }
            }
        }
        if (this.flagOpen) {
            for (IBulletLifeCycle iBulletLifeCycle5 : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle5, "it");
                expectPool5 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle5);
                if (expectPool5 != null) {
                    expectPool5.onOpen();
                }
            }
        }
        if (this.flagRuntimeReady && this.savedUri != null) {
            for (IBulletLifeCycle iBulletLifeCycle6 : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle6, "it");
                expectPool4 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle6);
                if (expectPool4 != null) {
                    Uri uri4 = this.savedUri;
                    Intrinsics.checkNotNull(uri4);
                    expectPool4.onRuntimeReady(uri4, this.savedKitView);
                }
            }
        }
        if (this.flagLoadUriSuccess && this.savedUri != null) {
            for (IBulletLifeCycle iBulletLifeCycle7 : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle7, "it");
                expectPool3 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle7);
                if (expectPool3 != null) {
                    Uri uri5 = this.savedUri;
                    Intrinsics.checkNotNull(uri5);
                    expectPool3.onLoadUriSuccess(uri5, this.savedKitView);
                }
            }
        }
        if (this.flagLoadFail && this.savedUri != null && this.savedLoadFailThrowable != null) {
            for (IBulletLifeCycle iBulletLifeCycle8 : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle8, "it");
                expectPool2 = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle8);
                if (expectPool2 != null) {
                    Uri uri6 = this.savedUri;
                    Intrinsics.checkNotNull(uri6);
                    Throwable th = this.savedLoadFailThrowable;
                    Intrinsics.checkNotNull(th);
                    expectPool2.onLoadFail(uri6, th);
                }
            }
        }
        if (this.flagFallback && this.savedUri != null && this.savedFallbackThrowable != null) {
            for (IBulletLifeCycle iBulletLifeCycle9 : lifeCycles) {
                Intrinsics.checkNotNullExpressionValue(iBulletLifeCycle9, "it");
                expectPool = PoolBulletLifeCycleKt.expectPool(iBulletLifeCycle9);
                if (expectPool != null) {
                    Uri uri7 = this.savedUri;
                    Intrinsics.checkNotNull(uri7);
                    Throwable th2 = this.savedFallbackThrowable;
                    Intrinsics.checkNotNull(th2);
                    expectPool.onLoadFail(uri7, th2);
                }
            }
        }
        this.savedUri = null;
        this.savedKitView = null;
        ILynxClientDelegate lynxClient = getLynxClient();
        if (lynxClient != null) {
            PoolLynxClientDelegate poolLynxClientDelegate = lynxClient instanceof PoolLynxClientDelegate ? (PoolLynxClientDelegate) lynxClient : null;
            if (poolLynxClientDelegate != null) {
                poolLynxClientDelegate.onFetchFromPreRenderPool(lifeCycles);
            }
        }
    }
}
