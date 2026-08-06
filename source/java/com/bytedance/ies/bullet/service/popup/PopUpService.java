package com.bytedance.ies.bullet.service.popup;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IBulletPopupFragment;
import com.bytedance.ies.bullet.service.base.IPopUpService;
import com.bytedance.ies.bullet.service.base.IPopupConfig;
import com.bytedance.ies.bullet.service.base.IPreRenderCallback;
import com.bytedance.ies.bullet.service.base.IPreRenderService;
import com.bytedance.ies.bullet.service.base.IPreRenderServiceWithBundle;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupFragment;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupTriggerType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.interfaze.IMessageCallbackService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopUpService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016JI\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2)\u0010\u0016\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017j\u0004\u0018\u0001`\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020 H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J \u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010*\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/PopUpService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/IPopUpService;", "popupConfig", "Lcom/bytedance/ies/bullet/service/base/IPopupConfig;", "(Lcom/bytedance/ies/bullet/service/base/IPopupConfig;)V", "activityLifeCycleCallBacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "config", "Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "getPopupConfig", "()Lcom/bytedance/ies/bullet/service/base/IPopupConfig;", "popupFragmentConfig", "Lcom/bytedance/ies/bullet/service/popup/PopupFragmentConfig;", "showNext", "", "adjustHeight", "heightPercent", "", "animated", "draggable", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Lcom/bytedance/ies/bullet/service/base/DragPopupCallback;", "appendViewCacheKeyIfNeed", "Landroid/net/Uri;", "schema", "sessionId", "", "dismiss", "containerId", "getPopupStack", "", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", IMessageCallbackService.EVENT_TYPE_SHOW, "context", "Landroid/content/Context;", "schemaOrigin", "showInner", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PopUpService extends BaseBulletService implements IPopUpService {
    private static final String POPUP_CREATE_FAILED_MSG = "create popup container failed";
    private static final String POPUP_CREATE_SUCCESS_MSG = "create popup container successfully";
    private Application.ActivityLifecycleCallbacks activityLifeCycleCallBacks;
    private volatile UIShowConfig config;
    private final IPopupConfig popupConfig;
    private volatile PopupFragmentConfig popupFragmentConfig;
    private volatile boolean showNext;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PopUpService";
    private static final String EVENT_PAGE_READY = "pageReady";
    private static final List<AbsPopupFragment> popupsStack = new ArrayList();
    private static final List<AbsPopupFragment> pendingDestroyPopupsStack = new ArrayList();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PopUpService() {
        this(r0, 1, r0);
        IPopupConfig iPopupConfig = null;
    }

    public /* synthetic */ PopUpService(IPopupConfig iPopupConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iPopupConfig);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPopUpService
    public IPopupConfig getPopupConfig() {
        return this.popupConfig;
    }

    public PopUpService(IPopupConfig iPopupConfig) {
        this.popupConfig = iPopupConfig;
    }

    /* compiled from: PopUpService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\nJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0004J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/PopUpService$Companion;", "", "()V", "EVENT_PAGE_READY", "", "POPUP_CREATE_FAILED_MSG", "POPUP_CREATE_SUCCESS_MSG", "TAG", "pendingDestroyPopupsStack", "", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "popupsStack", "createBulletPopup", "", "popup", "sessionId", "destroyBulletPopup", "", "destroyBulletPopupThoroughly", "getBulletPopup", "containerId", "getBulletPopupPendingDestroy", "getPopupsStack", "", "isTop", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ boolean createBulletPopup$default(Companion companion, AbsPopupFragment absPopupFragment, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "";
            }
            return companion.createBulletPopup(absPopupFragment, str);
        }

        public final boolean createBulletPopup(AbsPopupFragment popup, String sessionId) {
            ISchemaData schemaData;
            Intrinsics.checkNotNullParameter(popup, "popup");
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            Pair[] pairArr = new Pair[2];
            BulletContext bulletContext = popup.getBulletContext();
            pairArr[0] = TuplesKt.to("popup url", String.valueOf((bulletContext == null || (schemaData = bulletContext.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl()));
            pairArr[1] = TuplesKt.to("bid", popup.getBid());
            Map<String, ? extends Object> mapOf = MapsKt.mapOf(pairArr);
            LoggerContext loggerContext = new LoggerContext();
            if (sessionId == null) {
                sessionId = "";
            }
            loggerContext.pushStage(XConstant.SESSION_ID, sessionId);
            Unit unit = Unit.INSTANCE;
            hybridLogger.m11i("XPopup", "createBulletPopup", mapOf, loggerContext);
            return PopUpService.popupsStack.add(popup);
        }

        public final boolean createBulletPopup(AbsPopupFragment popup) {
            Intrinsics.checkNotNullParameter(popup, "popup");
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "createBulletPopup:" + popup + ",popupStack:" + PopUpService.popupsStack, null, "XPopup", 2, null);
            return PopUpService.popupsStack.add(popup);
        }

        public static /* synthetic */ void destroyBulletPopup$default(Companion companion, AbsPopupFragment absPopupFragment, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "";
            }
            companion.destroyBulletPopup(absPopupFragment, str);
        }

        public final void destroyBulletPopup(AbsPopupFragment popup, String sessionId) {
            AbsPopupMode popupMode;
            ISchemaData schemaData;
            Intrinsics.checkNotNullParameter(popup, "popup");
            PopUpService.popupsStack.remove(popup);
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            Pair[] pairArr = new Pair[2];
            BulletContext bulletContext = popup.getBulletContext();
            pairArr[0] = TuplesKt.to("popup url", String.valueOf((bulletContext == null || (schemaData = bulletContext.getSchemaData()) == null) ? null : schemaData.getInnerOriginUrl()));
            pairArr[1] = TuplesKt.to("bid", popup.getBid());
            Map<String, ? extends Object> mapOf = MapsKt.mapOf(pairArr);
            LoggerContext loggerContext = new LoggerContext();
            if (sessionId == null) {
                sessionId = "";
            }
            loggerContext.pushStage(XConstant.SESSION_ID, sessionId);
            Unit unit = Unit.INSTANCE;
            hybridLogger.m11i("XPopup", "createBulletPopup", mapOf, loggerContext);
            AbsPopupFragment absPopupFragment = (AbsPopupFragment) CollectionsKt.lastOrNull(PopUpService.popupsStack);
            if (absPopupFragment != null && absPopupFragment.getConfig().getTriggerOrigin() == PopupTriggerType.HIDE && (popupMode = absPopupFragment.getPopupMode()) != null) {
                popupMode.resumeWhenBack();
            }
            PopUpService.pendingDestroyPopupsStack.add(popup);
        }

        public final void destroyBulletPopup(AbsPopupFragment popup) {
            AbsPopupMode popupMode;
            Intrinsics.checkNotNullParameter(popup, "popup");
            PopUpService.popupsStack.remove(popup);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "destroyBulletPopup:" + popup + ",popupStack:" + PopUpService.popupsStack, null, "XPopup", 2, null);
            AbsPopupFragment absPopupFragment = (AbsPopupFragment) CollectionsKt.lastOrNull(PopUpService.popupsStack);
            if (absPopupFragment != null && absPopupFragment.getConfig().getTriggerOrigin() == PopupTriggerType.HIDE && (popupMode = absPopupFragment.getPopupMode()) != null) {
                popupMode.resumeWhenBack();
            }
            PopUpService.pendingDestroyPopupsStack.add(popup);
        }

        public final boolean destroyBulletPopupThoroughly(AbsPopupFragment popup) {
            Intrinsics.checkNotNullParameter(popup, "popup");
            return PopUpService.pendingDestroyPopupsStack.remove(popup);
        }

        public final AbsPopupFragment getBulletPopup(String containerId) {
            Object obj;
            Intrinsics.checkNotNullParameter(containerId, "containerId");
            Iterator it = PopUpService.popupsStack.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((AbsPopupFragment) obj).getContainerId(), containerId)) {
                    break;
                }
            }
            return (AbsPopupFragment) obj;
        }

        public final AbsPopupFragment getBulletPopupPendingDestroy(String containerId) {
            Object obj;
            Intrinsics.checkNotNullParameter(containerId, "containerId");
            Iterator it = PopUpService.pendingDestroyPopupsStack.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((AbsPopupFragment) obj).getContainerId(), containerId)) {
                    break;
                }
            }
            return (AbsPopupFragment) obj;
        }

        public final List<AbsPopupFragment> getPopupsStack() {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "getPopupsStack:" + PopUpService.popupsStack, null, "XPopup", 2, null);
            return CollectionsKt.reversed(PopUpService.popupsStack);
        }

        public final boolean isTop(String containerId) {
            Intrinsics.checkNotNullParameter(containerId, "containerId");
            AbsPopupFragment absPopupFragment = (AbsPopupFragment) CollectionsKt.lastOrNull(PopUpService.popupsStack);
            return Intrinsics.areEqual(absPopupFragment != null ? absPopupFragment.getContainerId() : null, containerId);
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IBulletUIService
    public boolean show(final Context context, Uri schemaOrigin, final UIShowConfig config) {
        IPreRenderService iPreRenderService;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemaOrigin, "schemaOrigin");
        Intrinsics.checkNotNullParameter(config, "config");
        final Uri appendViewCacheKeyIfNeed = appendViewCacheKeyIfNeed(schemaOrigin, config.getSessionId());
        final PopupFragmentConfig popupFragmentConfig = new PopupFragmentConfig(getBid(), appendViewCacheKeyIfNeed, config.getBundle(), context);
        final LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(XConstant.SESSION_ID, config.getSessionId());
        loggerContext.pushStage(XConstant.CALL_ID, config.getCallId());
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("isScanOpen", Boolean.valueOf(popupFragmentConfig.isScanOpen()));
        pairArr[1] = TuplesKt.to("isDelayOpen", Boolean.valueOf(popupFragmentConfig.isDelayOpen()));
        boolean z = context instanceof Activity;
        Activity activity = z ? (Activity) context : null;
        pairArr[2] = TuplesKt.to("isActivityFinish", Boolean.valueOf(activity != null && activity.isFinishing()));
        pairArr[3] = TuplesKt.to("isShowOnSuccess", Boolean.valueOf(popupFragmentConfig.showOnSuccess()));
        hybridLogger.m11i("XPopup", "popup service show", MapsKt.mapOf(pairArr), loggerContext);
        if (!popupFragmentConfig.isScanOpen() && !popupFragmentConfig.isDelayOpen()) {
            Activity activity2 = z ? (Activity) context : null;
            if (!(activity2 != null && activity2.isFinishing())) {
                if (popupFragmentConfig.showOnSuccess() && (iPreRenderService = (IPreRenderService) StandardServiceManager.INSTANCE.get(getBid(), IPreRenderService.class)) != null) {
                    IPreRenderServiceWithBundle iPreRenderServiceWithBundle = iPreRenderService instanceof IPreRenderServiceWithBundle ? (IPreRenderServiceWithBundle) iPreRenderService : null;
                    if (iPreRenderServiceWithBundle == null) {
                        IBulletUILifecycleListener lifecycleListener = config.getLifecycleListener();
                        if (lifecycleListener != null) {
                            lifecycleListener.onLoadFailed(null, new RuntimeException("invalid IPreRenderServiceWithBundle"));
                        }
                        return false;
                    }
                    HybridLogger.INSTANCE.m11i("XRouter", "popup with show_on_success, start preRender", MapsKt.mapOf(TuplesKt.to("schema", appendViewCacheKeyIfNeed.toString())), loggerContext);
                    iPreRenderServiceWithBundle.preRender(appendViewCacheKeyIfNeed, config.getBundle(), context, new IPreRenderCallback() { // from class: com.bytedance.ies.bullet.service.popup.PopUpService$show$2$1
                        @Override // com.bytedance.ies.bullet.service.base.IPreRenderCallback
                        public void onSuccess(String sessinId) {
                            String str;
                            Intrinsics.checkNotNullParameter(sessinId, "sessinId");
                            HybridLogger.INSTANCE.m11i("XRouter", "popup with show_on_success, preRender success", MapsKt.mapOf(TuplesKt.to("schema", appendViewCacheKeyIfNeed.toString())), loggerContext);
                            Context context2 = context;
                            Activity activity3 = context2 instanceof Activity ? (Activity) context2 : null;
                            boolean z2 = false;
                            if (activity3 != null && activity3.isFinishing()) {
                                z2 = true;
                            }
                            if (!z2) {
                                str = PopUpService.EVENT_PAGE_READY;
                                final Uri uri = appendViewCacheKeyIfNeed;
                                final LoggerContext loggerContext2 = loggerContext;
                                final PopupFragmentConfig popupFragmentConfig2 = popupFragmentConfig;
                                final PopUpService popUpService = this;
                                final Context context3 = context;
                                final UIShowConfig uIShowConfig = config;
                                EventCenter.registerJsEventSubscriber(str, new JsEventSubscriber() { // from class: com.bytedance.ies.bullet.service.popup.PopUpService$show$2$1$onSuccess$2
                                    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
                                    public void onReceiveJsEvent(Js2NativeEvent jsEvent) {
                                        String str2;
                                        String str3;
                                        Intrinsics.checkNotNullParameter(jsEvent, "jsEvent");
                                        XReadableMap params = jsEvent.getParams();
                                        if (params == null || (str2 = params.getString("code")) == null) {
                                            str2 = ViewVisibleBridge.INVISIBLE;
                                        }
                                        HybridLogger.INSTANCE.m11i("XRouter", "popup with show_on_success, receive pageReady event", MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", uri.toString()), TuplesKt.to("code", str2)}), loggerContext2);
                                        if (Intrinsics.areEqual("1", str2)) {
                                            popupFragmentConfig2.getBundle().putString(SchemaConstants.QUERY_KEY_PRERENDER, "1");
                                            popUpService.showInner(context3, uri, uIShowConfig, popupFragmentConfig2);
                                        }
                                        str3 = PopUpService.EVENT_PAGE_READY;
                                        EventCenter.unregisterJsEventSubscriber(str3, this);
                                    }
                                }, sessinId);
                                return;
                            }
                            IBulletUILifecycleListener lifecycleListener2 = config.getLifecycleListener();
                            if (lifecycleListener2 != null) {
                                lifecycleListener2.onLoadFailed(null, new ActivityFinishedException());
                            }
                        }

                        @Override // com.bytedance.ies.bullet.service.base.IPreRenderCallback
                        public void onFailed(PoolResult result, String errorMsg) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
                            Pair[] pairArr2 = new Pair[2];
                            pairArr2[0] = TuplesKt.to("errorMsg", errorMsg == null ? "" : errorMsg);
                            pairArr2[1] = TuplesKt.to("schema", appendViewCacheKeyIfNeed.toString());
                            hybridLogger2.m11i("XRouter", "popup with show_on_success, preRender failed", MapsKt.mapOf(pairArr2), loggerContext);
                            IBulletUILifecycleListener lifecycleListener2 = config.getLifecycleListener();
                            if (lifecycleListener2 != null) {
                                lifecycleListener2.onLoadFailed(null, new PreRenderFailedException(errorMsg));
                            }
                        }
                    });
                    return true;
                }
                return showInner(context, appendViewCacheKeyIfNeed, config, popupFragmentConfig);
            }
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "lazy show " + appendViewCacheKeyIfNeed, null, "XPopup", 2, null);
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            HybridLogger.INSTANCE.m9e("XRouter", POPUP_CREATE_FAILED_MSG, MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, "application is null"), TuplesKt.to("schema", appendViewCacheKeyIfNeed.toString())}), loggerContext);
            return false;
        }
        this.showNext = true;
        this.popupFragmentConfig = popupFragmentConfig;
        this.config = config;
        if (this.activityLifeCycleCallBacks == null) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.ies.bullet.service.popup.PopUpService$show$1$1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity3, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity3) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity3) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity3, Bundle outState) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity3) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity3) {
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity3) {
                    boolean z2;
                    PopupFragmentConfig popupFragmentConfig2;
                    UIShowConfig uIShowConfig;
                    Intrinsics.checkNotNullParameter(activity3, "activity");
                    z2 = PopUpService.this.showNext;
                    if (z2) {
                        popupFragmentConfig2 = PopUpService.this.popupFragmentConfig;
                        if (popupFragmentConfig2 != null) {
                            PopUpService popUpService = PopUpService.this;
                            Uri uri = appendViewCacheKeyIfNeed;
                            Activity activity4 = activity3;
                            popupFragmentConfig2.updateWithContext(activity4);
                            uIShowConfig = popUpService.config;
                            if (uIShowConfig != null) {
                                popUpService.showInner(activity4, uri, uIShowConfig, popupFragmentConfig2);
                            }
                        }
                        PopUpService.this.showNext = false;
                        PopUpService.this.popupFragmentConfig = null;
                        PopUpService.this.config = null;
                    }
                }
            };
            this.activityLifeCycleCallBacks = activityLifecycleCallbacks;
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        HybridLogger.INSTANCE.m11i("XRouter", POPUP_CREATE_SUCCESS_MSG, MapsKt.mapOf(TuplesKt.to("schema", appendViewCacheKeyIfNeed.toString())), loggerContext);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean showInner(final Context context, Uri schema, UIShowConfig config, PopupFragmentConfig popupFragmentConfig) {
        Object obj;
        AbsPopupFragment createFragment$default;
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(XConstant.SESSION_ID, config.getSessionId());
        loggerContext.pushStage(XConstant.CALL_ID, config.getCallId());
        HybridLogger.INSTANCE.m11i("XPopup", "PopUpService showInner", MapsKt.mapOf(TuplesKt.to("schema", schema.toString())), loggerContext);
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity == null) {
            HybridLogger.INSTANCE.m11i("XPopup", POPUP_CREATE_FAILED_MSG, MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, "fragmentActivity is null"), TuplesKt.to("schema", schema.toString())}), loggerContext);
            IBulletUILifecycleListener lifecycleListener = config.getLifecycleListener();
            if (lifecycleListener != null) {
                lifecycleListener.onLoadFailed(null, new NonFragmentActivityException());
            }
            if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ies.bullet.service.popup.PopUpService$showInner$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(context, "popup show with non-act", 0).show();
                    }
                });
            }
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            IPopupConfig popupConfig = getPopupConfig();
            Class<? extends IBulletPopupFragment> fragmentClazz = popupConfig != null ? popupConfig.getFragmentClazz() : null;
            if (fragmentClazz != null) {
                if (!AbsPopupFragment.class.isAssignableFrom(fragmentClazz)) {
                    return false;
                }
                createFragment$default = AbsPopupFragment.INSTANCE.createFragment(popupFragmentConfig, config.getLifecycleListener(), fragmentClazz);
            } else {
                createFragment$default = AbsPopupFragment.Companion.createFragment$default(AbsPopupFragment.INSTANCE, popupFragmentConfig, config.getLifecycleListener(), null, 4, null);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (createFragment$default != null) {
            createFragment$default.show(fragmentActivity.getSupportFragmentManager(), "BulletPopUp");
            HybridLogger.INSTANCE.m11i("XPopup", POPUP_CREATE_SUCCESS_MSG, MapsKt.mapOf(TuplesKt.to("schema", schema.toString())), loggerContext);
            if (createFragment$default != null) {
                obj = Result.constructor-impl(createFragment$default);
                return Result.isSuccess-impl(obj);
            }
        }
        PopUpService popUpService = this;
        HybridLogger.INSTANCE.m11i("XPopup", POPUP_CREATE_FAILED_MSG, MapsKt.mapOf(new Pair[]{TuplesKt.to(ISignalReportConstants.KEY_REASON, "fragment is null"), TuplesKt.to("schema", schema.toString())}), loggerContext);
        return false;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPopUpService
    public boolean adjustHeight(int heightPercent, boolean animated, boolean draggable) {
        if (getPopupStack().isEmpty()) {
            return false;
        }
        return getPopupStack().get(CollectionsKt.getLastIndex(getPopupStack())).adjustHeight(heightPercent, animated, draggable);
    }

    public final void adjustHeight(int heightPercent, boolean animated, boolean draggable, Function1<? super Boolean, Unit> callback) {
        if (!getPopupStack().isEmpty()) {
            getPopupStack().get(CollectionsKt.getLastIndex(getPopupStack())).adjustHeight(heightPercent, animated, draggable, callback);
        } else if (callback != null) {
            callback.invoke(false);
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IPopUpService
    public List<AbsPopupFragment> getPopupStack() {
        return INSTANCE.getPopupsStack();
    }

    @Override // com.bytedance.ies.bullet.service.base.IPopUpService
    public boolean dismiss(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Companion companion = INSTANCE;
        AbsPopupFragment bulletPopup = companion.getBulletPopup(containerId);
        if (bulletPopup == null) {
            bulletPopup = companion.getBulletPopupPendingDestroy(containerId);
        }
        if (bulletPopup == null) {
            return false;
        }
        bulletPopup.dismissAllowingStateLoss();
        return true;
    }

    private final Uri appendViewCacheKeyIfNeed(Uri schema, String sessionId) {
        BulletContext context = BulletContextManager.INSTANCE.getInstance().getContext(sessionId);
        if (context == null || !Intrinsics.areEqual(new BooleanParam(context.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_SHOW_ON_SUCCESS, false).getValue(), true) || SchemaUtilsKt.getQueryParameterSafely(schema, "view_cache_key") != null) {
            return schema;
        }
        Uri build = schema.buildUpon().appendQueryParameter("view_cache_key", UUID.randomUUID().toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "schema.buildUpon()\n     …                 .build()");
        return build;
    }
}
