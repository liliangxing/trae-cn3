package com.bytedance.android.anniex.scene.core;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.LruCache;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.ability.service.AttachScene;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.core.AViewSignalBuffer;
import com.bytedance.android.anniex.scene.core.SceneFingerprint;
import com.bytedance.android.anniex.scene.data.SceneDbManager;
import com.bytedance.android.anniex.scene.data.SceneQueryInfo;
import com.bytedance.android.anniex.scene.listener.AppPageStackMonitor;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.android.anniex.scene.utils.CompressionUtils;
import com.bytedance.android.anniex.scene.utils.SceneLoggerUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: SceneManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020!H\u0003J\n\u0010<\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010=\u001a\u0004\u0018\u00010>H\u0002J\n\u0010?\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001f0AJ\u0010\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0003J\u0010\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u001fH\u0003J\b\u0010G\u001a\u00020:H\u0002J\b\u0010H\u001a\u00020:H\u0002J\u0006\u0010I\u001a\u00020:J\u001c\u0010J\u001a\u00020\u001c2\b\u0010K\u001a\u0004\u0018\u00010\u00052\b\u0010L\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010M\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u00020\u001cH\u0002J\u0016\u0010P\u001a\u00020:2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\b\u0010R\u001a\u00020:H\u0003J\b\u0010S\u001a\u00020:H\u0003J\u000e\u0010T\u001a\u00020:2\u0006\u0010N\u001a\u00020\u0005J\u001a\u0010U\u001a\u00020:2\b\u0010K\u001a\u0004\u0018\u00010\u00052\b\u0010L\u001a\u0004\u0018\u00010\u0005R)\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\n\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b3\u00104R'\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\n\u001a\u0004\b7\u0010\u0015¨\u0006W"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/SceneManager;", "", "()V", "aViewHotMapByScene", "", "", "Lcom/bytedance/android/anniex/scene/core/HotUrlCache;", "getAViewHotMapByScene", "()Ljava/util/Map;", "aViewHotMapByScene$delegate", "Lkotlin/Lazy;", "attachScene", "Lcom/bytedance/android/anniex/ability/service/AttachScene;", "behaviorModel", "Lcom/bytedance/android/anniex/scene/core/BehaviorModel;", "getBehaviorModel", "()Lcom/bytedance/android/anniex/scene/core/BehaviorModel;", "behaviorModel$delegate", "clientComponentMap", "Landroid/util/LruCache;", "getClientComponentMap", "()Landroid/util/LruCache;", "clientComponentMap$delegate", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "isHandlerReady", "", "isPageListenerReady", "lastRecognizedScene", "Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "lastSceneInfoCollection", "Lcom/bytedance/android/anniex/scene/core/SceneInfoCollection;", "pageSignalBuffer", "Lcom/bytedance/android/anniex/scene/core/PageSignalBuffer;", "getPageSignalBuffer", "()Lcom/bytedance/android/anniex/scene/core/PageSignalBuffer;", "pageSignalBuffer$delegate", "sceneDbHelper", "Lcom/bytedance/android/anniex/scene/data/SceneDbManager;", "getSceneDbHelper", "()Lcom/bytedance/android/anniex/scene/data/SceneDbManager;", "sceneDbHelper$delegate", "signalBuffer", "Lcom/bytedance/android/anniex/scene/core/AViewSignalBuffer;", "getSignalBuffer", "()Lcom/bytedance/android/anniex/scene/core/AViewSignalBuffer;", "signalBuffer$delegate", "timeline", "Lcom/bytedance/android/anniex/scene/core/RecentSceneLruCache;", "getTimeline", "()Lcom/bytedance/android/anniex/scene/core/RecentSceneLruCache;", "timeline$delegate", "viewEventBuffer", "getViewEventBuffer", "viewEventBuffer$delegate", "dealWithSceneSwitch", "", "currentSceneInfo", "getAttachScene", "getBcmChain", "Lorg/json/JSONObject;", "getCurrentHotMap", "getSceneTimeLine", "", "handleLifecycleResumeEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/android/anniex/scene/core/PageAttachEvent;", "handleSceneFingerprint", "current", "initHandlerThread", "initPageStackListener", "initPageStackSubscribe", "isInputLegal", "sessionId", StreamTrafficObservable.STREAM_URL, "isPageEventAllowed", "pageName", "isSceneRecognizedEnable", "markSceneType", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "receiveAViewSignal", "receivePageSignal", "sendPageAttachEvent", "sendViewLoadEvent", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SceneManager {
    private static final int EVENT_ON_PAGE_ATTACH = 2;
    private static final int EVENT_ON_VIEW_ATTACH = 1;
    private static final int EVENT_START_PAGE_STACK_SUBSCRIBE = 3;
    private static SceneManager instance;
    private AttachScene attachScene;
    private Handler handler;
    private HandlerThread handlerThread;
    private boolean isHandlerReady;
    private boolean isPageListenerReady;
    private SceneFingerprint lastRecognizedScene;
    private SceneInfoCollection lastSceneInfoCollection;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "AnnieXSceneManager";

    /* renamed from: viewEventBuffer$delegate, reason: from kotlin metadata */
    private final Lazy viewEventBuffer = LazyKt.lazy(new Function0<LruCache<String, String>>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$viewEventBuffer$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LruCache<String, String> m3423invoke() {
            return new LruCache<>(5);
        }
    });

    /* renamed from: timeline$delegate, reason: from kotlin metadata */
    private final Lazy timeline = LazyKt.lazy(new Function0<RecentSceneLruCache>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$timeline$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RecentSceneLruCache m3422invoke() {
            return new RecentSceneLruCache(SwitchCenter.INSTANCE.getRecentSceneLruCacheMaxSize());
        }
    });

    /* renamed from: aViewHotMapByScene$delegate, reason: from kotlin metadata */
    private final Lazy aViewHotMapByScene = LazyKt.lazy(new Function0<Map<String, HotUrlCache>>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$aViewHotMapByScene$2
        public final Map<String, HotUrlCache> invoke() {
            return new LinkedHashMap();
        }
    });

    /* renamed from: signalBuffer$delegate, reason: from kotlin metadata */
    private final Lazy signalBuffer = LazyKt.lazy(new Function0<AViewSignalBuffer>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$signalBuffer$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AViewSignalBuffer m3421invoke() {
            return new AViewSignalBuffer();
        }
    });

    /* renamed from: pageSignalBuffer$delegate, reason: from kotlin metadata */
    private final Lazy pageSignalBuffer = LazyKt.lazy(new Function0<PageSignalBuffer>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$pageSignalBuffer$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PageSignalBuffer m3417invoke() {
            return new PageSignalBuffer();
        }
    });

    /* renamed from: behaviorModel$delegate, reason: from kotlin metadata */
    private final Lazy behaviorModel = LazyKt.lazy(new Function0<BehaviorModel>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$behaviorModel$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BehaviorModel m3405invoke() {
            return new BehaviorModel();
        }
    });

    /* renamed from: sceneDbHelper$delegate, reason: from kotlin metadata */
    private final Lazy sceneDbHelper = LazyKt.lazy(new Function0<SceneDbManager>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$sceneDbHelper$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SceneDbManager m3420invoke() {
            Application application = BulletEnv.Companion.getInstance().getApplication();
            if (application != null) {
                return new SceneDbManager(application);
            }
            return null;
        }
    });

    /* renamed from: clientComponentMap$delegate, reason: from kotlin metadata */
    private final Lazy clientComponentMap = LazyKt.lazy(new Function0<LruCache<String, String>>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$clientComponentMap$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LruCache<String, String> m3406invoke() {
            return new LruCache<>(5);
        }
    });

    /* compiled from: SceneManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/SceneManager$Companion;", "", "()V", "EVENT_ON_PAGE_ATTACH", "", "EVENT_ON_VIEW_ATTACH", "EVENT_START_PAGE_STACK_SUBSCRIBE", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/bytedance/android/anniex/scene/core/SceneManager;", "getInstance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return SceneManager.TAG;
        }

        public final SceneManager getInstance() {
            if (SceneManager.instance == null) {
                SceneManager.instance = new SceneManager();
            }
            SceneManager sceneManager = SceneManager.instance;
            Intrinsics.checkNotNull(sceneManager);
            return sceneManager;
        }
    }

    private final LruCache<String, String> getViewEventBuffer() {
        return (LruCache) this.viewEventBuffer.getValue();
    }

    private final RecentSceneLruCache getTimeline() {
        return (RecentSceneLruCache) this.timeline.getValue();
    }

    private final Map<String, HotUrlCache> getAViewHotMapByScene() {
        return (Map) this.aViewHotMapByScene.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AViewSignalBuffer getSignalBuffer() {
        return (AViewSignalBuffer) this.signalBuffer.getValue();
    }

    private final PageSignalBuffer getPageSignalBuffer() {
        return (PageSignalBuffer) this.pageSignalBuffer.getValue();
    }

    private final BehaviorModel getBehaviorModel() {
        return (BehaviorModel) this.behaviorModel.getValue();
    }

    private final SceneDbManager getSceneDbHelper() {
        return (SceneDbManager) this.sceneDbHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LruCache<String, String> getClientComponentMap() {
        return (LruCache) this.clientComponentMap.getValue();
    }

    private final boolean isSceneRecognizedEnable() {
        return SwitchCenter.INSTANCE.getEnableScene();
    }

    private final void initHandlerThread() {
        if (!isSceneRecognizedEnable() || Build.VERSION.SDK_INT < 26 || this.isHandlerReady) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread(TAG, 0);
        this.handlerThread = handlerThread;
        handlerThread.start();
        new Handler(handlerThread.getLooper());
        final Looper looper = handlerThread.getLooper();
        this.handler = new Handler(looper) { // from class: com.bytedance.android.anniex.scene.core.SceneManager$initHandlerThread$1$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
                int i = msg.what;
                if (i == 1) {
                    SceneManager.this.receiveAViewSignal();
                } else if (i == 2) {
                    SceneManager.this.receivePageSignal();
                } else {
                    if (i != 3) {
                        return;
                    }
                    SceneManager.this.initPageStackListener();
                }
            }
        };
        this.isHandlerReady = true;
    }

    public final void markSceneType(final String sessionId, final String type) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (this.handler == null && !this.isHandlerReady) {
            initHandlerThread();
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$markSceneType$1
                @Override // java.lang.Runnable
                public final void run() {
                    LruCache clientComponentMap;
                    clientComponentMap = SceneManager.this.getClientComponentMap();
                    clientComponentMap.put(sessionId, type);
                }
            });
        }
    }

    public final void initPageStackSubscribe() {
        if (SwitchCenter.INSTANCE.getEnableNaStackStore()) {
            if (!this.isHandlerReady) {
                initHandlerThread();
            }
            Handler handler = this.handler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(3, SwitchCenter.INSTANCE.getPageStackSubscribeDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPageStackListener() {
        Application application = BulletEnv.Companion.getInstance().getApplication();
        if (application != null) {
            AppPageStackMonitor.INSTANCE.getInstance().init(application);
            this.isPageListenerReady = true;
        }
    }

    public final void sendPageAttachEvent(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (isSceneRecognizedEnable() && isPageEventAllowed(pageName)) {
            if (!this.isHandlerReady) {
                initHandlerThread();
            }
            PageAttachEvent pageAttachEvent = new PageAttachEvent(pageName, System.currentTimeMillis());
            getPageSignalBuffer().receive(pageAttachEvent);
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeMessages(2);
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = pageAttachEvent;
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.sendMessageDelayed(obtain, SwitchCenter.INSTANCE.getPageStackWindowDurationMs());
            }
        }
    }

    public final void sendViewLoadEvent(String sessionId, String url) {
        Handler handler;
        if (isSceneRecognizedEnable()) {
            if (!this.isHandlerReady) {
                initHandlerThread();
            }
            if (SwitchCenter.INSTANCE.getEnableNaStackStore() && !this.isPageListenerReady && (handler = this.handler) != null) {
                Message message = new Message();
                message.what = 3;
                handler.sendMessage(message);
            }
            if (isInputLegal(sessionId, url) && url != null && getViewEventBuffer().get(sessionId) == null) {
                Uri parse = Uri.parse(url);
                String str = parse.getHost() + parse.getPath();
                ViewAttachEvent viewAttachEvent = new ViewAttachEvent(str, System.currentTimeMillis(), sessionId);
                getSignalBuffer().receive(viewAttachEvent);
                HotUrlCache currentHotMap = getCurrentHotMap();
                if (currentHotMap != null) {
                    currentHotMap.record(str);
                }
                getPageSignalBuffer().clear();
                Handler handler2 = this.handler;
                if (handler2 != null) {
                    handler2.removeMessages(2);
                }
                Handler handler3 = this.handler;
                if (handler3 != null) {
                    handler3.removeMessages(1);
                }
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = viewAttachEvent;
                Handler handler4 = this.handler;
                if (handler4 != null) {
                    handler4.sendMessageDelayed(obtain, SwitchCenter.INSTANCE.getHybridViewWindowDurationMs());
                }
                getViewEventBuffer().put(sessionId, str);
            }
        }
    }

    private final boolean isInputLegal(String sessionId, String url) {
        return LoaderUtil.INSTANCE.isNotNullOrEmpty(sessionId) && LoaderUtil.INSTANCE.isNotNullOrEmpty(url) && !Intrinsics.areEqual(sessionId, "unknown") && !Intrinsics.areEqual(url, "null");
    }

    private final boolean isPageEventAllowed(String pageName) {
        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(pageName)) {
            Set<String> pageStackBlackList = SwitchCenter.INSTANCE.getPageStackBlackList();
            if (pageStackBlackList != null && pageStackBlackList.contains(pageName)) {
                return false;
            }
            if (SwitchCenter.INSTANCE.getEnableNaStackStore()) {
                return true;
            }
            Set<String> pageStackWhiteList = SwitchCenter.INSTANCE.getPageStackWhiteList();
            if (pageStackWhiteList != null && pageStackWhiteList.contains(pageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void receiveAViewSignal() {
        String str;
        ViewAttachEvent viewAttachEvent;
        String sessionId;
        String str2;
        SceneLoggerUtils sceneLoggerUtils = SceneLoggerUtils.INSTANCE;
        String str3 = TAG;
        sceneLoggerUtils.debugLog(str3, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$receiveAViewSignal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                AViewSignalBuffer signalBuffer;
                StringBuilder sb = new StringBuilder(" 卡片上屏信号收集 shouldCollectNow = ");
                signalBuffer = SceneManager.this.getSignalBuffer();
                return sb.append(signalBuffer.shouldCollectNow()).toString();
            }
        });
        if (getSignalBuffer().shouldCollectNow()) {
            AViewSignalBuffer.RowViewAttachInfo collectCurrentUrls = getSignalBuffer().collectCurrentUrls();
            if (!collectCurrentUrls.getAttachEvent().isEmpty()) {
                HashSet hashSet = CollectionsKt.toHashSet(collectCurrentUrls.getAttachEvent());
                ViewAttachEvent viewAttachEvent2 = (ViewAttachEvent) CollectionsKt.firstOrNull(collectCurrentUrls.getAttachEvent());
                long timestamp = viewAttachEvent2 != null ? viewAttachEvent2.getTimestamp() : System.currentTimeMillis();
                SceneOrigin sceneOrigin = SceneOrigin.HYBRID;
                AttachScene attachScene = getAttachScene();
                if (attachScene == null || (str = attachScene.getScene()) == null) {
                    str = "";
                }
                SceneFingerprint.Builder builder = new SceneFingerprint.Builder(hashSet, timestamp, sceneOrigin, str);
                if (collectCurrentUrls.getAttachEvent().size() == 1 && (viewAttachEvent = (ViewAttachEvent) CollectionsKt.firstOrNull(collectCurrentUrls.getAttachEvent())) != null && (sessionId = viewAttachEvent.getSessionId()) != null && (str2 = getClientComponentMap().get(sessionId)) != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "get(_sessionId)");
                    builder.setClientComponent(str2);
                }
                builder.setViewCount(collectCurrentUrls.getViewCount());
                if (SwitchCenter.INSTANCE.getEnableSceneBcmChainInfo()) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    final JSONObject bcmChain = getBcmChain();
                    if (bcmChain != null) {
                        builder.setBcmChain(bcmChain);
                        SceneLoggerUtils.INSTANCE.debugLog(str3, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$receiveAViewSignal$current$1$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "场景 BCM Info = " + bcmChain + ", cost：" + (System.currentTimeMillis() - currentTimeMillis);
                            }
                        });
                    }
                }
                handleSceneFingerprint(builder.build());
            }
        }
    }

    private final JSONObject getBcmChain() {
        IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService("default_bid", IAnnieXContextProvider.class);
        if (iAnnieXContextProvider != null) {
            return iAnnieXContextProvider.getBcmChainByFinder(null, SwitchCenter.INSTANCE.getBcmChainLength(), SwitchCenter.INSTANCE.getDomainStandard());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AttachScene getAttachScene() {
        IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService("default_bid", IAnnieXContextProvider.class);
        if (iAnnieXContextProvider != null) {
            return iAnnieXContextProvider.getAttachScene();
        }
        return null;
    }

    private final HotUrlCache getCurrentHotMap() {
        String str;
        Map<String, HotUrlCache> aViewHotMapByScene = getAViewHotMapByScene();
        if (aViewHotMapByScene == null) {
            return null;
        }
        AttachScene attachScene = this.attachScene;
        if (attachScene == null || (str = attachScene.getScene()) == null) {
            str = "";
        }
        return aViewHotMapByScene.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void receivePageSignal() {
        PageAttachEvent collectLatestPage;
        if (!getPageSignalBuffer().shouldCollectNow() || (collectLatestPage = getPageSignalBuffer().collectLatestPage()) == null) {
            return;
        }
        handleLifecycleResumeEvent(collectLatestPage);
    }

    private final void handleLifecycleResumeEvent(final PageAttachEvent event) {
        String str;
        final AttachScene attachScene = getAttachScene();
        AttachScene attachScene2 = this.attachScene;
        if (attachScene2 != null) {
            if (Intrinsics.areEqual(attachScene2 != null ? attachScene2.getScene() : null, attachScene != null ? attachScene.getScene() : null)) {
                return;
            }
        }
        this.attachScene = attachScene;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        long timestamp = event.getTimestamp();
        SceneOrigin sceneOrigin = SceneOrigin.NA_PAGE;
        if (attachScene == null || (str = attachScene.getScene()) == null) {
            str = "";
        }
        SceneFingerprint.Builder builder = new SceneFingerprint.Builder(linkedHashSet, timestamp, sceneOrigin, str);
        builder.sceneId(event.getName());
        final SceneFingerprint build = builder.build();
        this.lastRecognizedScene = null;
        SceneLoggerUtils sceneLoggerUtils = SceneLoggerUtils.INSTANCE;
        String str2 = TAG;
        sceneLoggerUtils.debugLog(str2, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleLifecycleResumeEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                StringBuilder append = new StringBuilder("【场景识别】全页场景：").append(PageAttachEvent.this.getName()).append(", 上屏场景：");
                AttachScene attachScene3 = attachScene;
                return append.append(attachScene3 != null ? attachScene3.getScene() : null).toString();
            }
        });
        if (SwitchCenter.INSTANCE.getEnableNaStackStore()) {
            SceneDbManager sceneDbHelper = getSceneDbHelper();
            final SceneQueryInfo saveSceneAndGetStats$default = sceneDbHelper != null ? SceneDbManager.saveSceneAndGetStats$default(sceneDbHelper, build, null, 0L, 4, null) : null;
            if (saveSceneAndGetStats$default != null) {
                SceneConnectCenter.INSTANCE.sendSceneFeature(build, saveSceneAndGetStats$default);
                SceneConnectCenter.INSTANCE.sendSceneFeatureEvent(build, saveSceneAndGetStats$default);
                dealWithSceneSwitch(new SceneInfoCollection(build, saveSceneAndGetStats$default));
            }
            SceneLoggerUtils.INSTANCE.debugLog(str2, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleLifecycleResumeEvent$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    StringBuilder append = new StringBuilder("【场景信息】").append(CompressionUtils.INSTANCE.decompressSceneId(SceneFingerprint.this.getSceneId())).append(" pv：");
                    SceneQueryInfo sceneQueryInfo = saveSceneAndGetStats$default;
                    return append.append(sceneQueryInfo != null ? Integer.valueOf(sceneQueryInfo.getCurrentCount()) : null).toString();
                }
            });
            SceneLoggerUtils.INSTANCE.debugLog(str2, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleLifecycleResumeEvent$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    StringBuilder sb = new StringBuilder("【概率数据】下一跳数据：");
                    SceneQueryInfo sceneQueryInfo = SceneQueryInfo.this;
                    return sb.append(sceneQueryInfo != null ? sceneQueryInfo.getTransitions() : null).toString();
                }
            });
            getTimeline().addSceneFingerprint(build);
        }
    }

    private final void handleSceneFingerprint(final SceneFingerprint current) {
        HotUrlCache currentHotMap = getCurrentHotMap();
        final Map<String, Double> weightMap = currentHotMap != null ? currentHotMap.getWeightMap() : null;
        SceneLoggerUtils sceneLoggerUtils = SceneLoggerUtils.INSTANCE;
        String str = TAG;
        sceneLoggerUtils.debugLog(str, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleSceneFingerprint$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                return " 当前运行时热力图 = " + weightMap;
            }
        });
        SceneFingerprint sceneFingerprint = this.lastRecognizedScene;
        if (sceneFingerprint != null) {
            final double jaccard = sceneFingerprint.jaccard(current);
            final double cosine = sceneFingerprint.cosine(current, weightMap);
            SceneLoggerUtils.INSTANCE.debugLog(str, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleSceneFingerprint$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return " 相似度对比 jacquard = " + jaccard + ", cosine = " + cosine;
                }
            });
            if (jaccard >= SwitchCenter.INSTANCE.getJaccardThreshold() || cosine >= SwitchCenter.INSTANCE.getCosineThreshold()) {
                SceneLoggerUtils.INSTANCE.debugLog(str, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleSceneFingerprint$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        AttachScene attachScene;
                        StringBuilder append = new StringBuilder("【场景识别】【重复】跨端场景：").append(CompressionUtils.INSTANCE.decompressSceneId(SceneFingerprint.this.getSceneId())).append(", 上屏场景：");
                        attachScene = this.getAttachScene();
                        return append.append(attachScene != null ? attachScene.getScene() : null).toString();
                    }
                });
                return;
            }
        }
        current.getSceneId();
        getBehaviorModel().recordScene(current);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (getTimeline().size() > 0) {
            final SceneFingerprint recent = getTimeline().getRecent();
            if (recent != null) {
                final long timestamp = current.getTimestamp() - recent.getTimestamp();
                getBehaviorModel().recordTransition(recent.getSceneId(), current.getSceneId());
                SceneDbManager sceneDbHelper = getSceneDbHelper();
                objectRef.element = sceneDbHelper != null ? sceneDbHelper.saveSceneAndGetStats(current, recent.getSceneId(), timestamp) : null;
                SceneLoggerUtils.INSTANCE.debugLog(str, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleSceneFingerprint$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "【信息收集】上一跳数据收集 from：" + CompressionUtils.INSTANCE.decompressSceneId(SceneFingerprint.this.getSceneId()) + " to:" + CompressionUtils.INSTANCE.decompressSceneId(current.getSceneId()) + ", duration:" + timestamp;
                    }
                });
            }
        } else {
            SceneDbManager sceneDbHelper2 = getSceneDbHelper();
            objectRef.element = sceneDbHelper2 != null ? SceneDbManager.saveSceneAndGetStats$default(sceneDbHelper2, current, null, 0L, 4, null) : null;
        }
        SceneQueryInfo sceneQueryInfo = (SceneQueryInfo) objectRef.element;
        if (sceneQueryInfo != null) {
            SceneConnectCenter.INSTANCE.sendSceneFeature(current, sceneQueryInfo);
            SceneConnectCenter.INSTANCE.sendSceneFeatureEvent(current, sceneQueryInfo);
            dealWithSceneSwitch(new SceneInfoCollection(current, sceneQueryInfo));
        }
        SceneLoggerUtils.INSTANCE.debugLog(str, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleSceneFingerprint$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                AttachScene attachScene;
                String scene;
                StringBuilder append = new StringBuilder("【场景识别】【新增】跨端场景：").append(CompressionUtils.INSTANCE.decompressSceneId(SceneFingerprint.this.getSceneId())).append(", 上屏场景：");
                attachScene = this.getAttachScene();
                return append.append((attachScene == null || (scene = attachScene.getScene()) == null) ? null : CompressionUtils.INSTANCE.decompressSceneId(scene)).toString();
            }
        });
        SceneLoggerUtils.INSTANCE.debugLog(str, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleSceneFingerprint$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                StringBuilder append = new StringBuilder("【场景信息】").append(CompressionUtils.INSTANCE.decompressSceneId(SceneFingerprint.this.getSceneId())).append(" pv：");
                SceneQueryInfo sceneQueryInfo2 = (SceneQueryInfo) objectRef.element;
                return append.append(sceneQueryInfo2 != null ? Integer.valueOf(sceneQueryInfo2.getCurrentCount()) : null).toString();
            }
        });
        SceneLoggerUtils.INSTANCE.debugLog(str, new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.SceneManager$handleSceneFingerprint$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                StringBuilder sb = new StringBuilder("【概率数据】下一跳数据：");
                SceneQueryInfo sceneQueryInfo2 = (SceneQueryInfo) objectRef.element;
                return sb.append(sceneQueryInfo2 != null ? sceneQueryInfo2.getTransitions() : null).toString();
            }
        });
        getTimeline().addSceneFingerprint(current);
        this.lastRecognizedScene = current;
    }

    private final void dealWithSceneSwitch(SceneInfoCollection currentSceneInfo) {
        SceneInfoCollection sceneInfoCollection = this.lastSceneInfoCollection;
        if (sceneInfoCollection != null) {
            SceneConnectCenter.INSTANCE.sendSceneGotoFeature(sceneInfoCollection.getSceneFingerprint(), currentSceneInfo.getSceneFingerprint(), sceneInfoCollection.getQueryInfo());
        }
        this.lastSceneInfoCollection = currentSceneInfo;
    }

    public final List<SceneFingerprint> getSceneTimeLine() {
        return CollectionsKt.toList(getTimeline().snapshot().values());
    }
}
