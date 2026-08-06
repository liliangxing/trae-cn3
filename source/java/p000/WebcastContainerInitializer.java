package p000;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.service.BaseBridgeService;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IEventHandler;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.service.IContainerInstance;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebcastContainerInitializer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002JZ\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u0014J0\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ2\u0010\u001c\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 J2\u0010!\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 ¨\u0006\""}, d2 = {"LWebcastContainerInitializer;", "", "()V", "getContextProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXContextProvider;", "bid", "", "initializeCommon", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "view", "Landroid/view/View;", "bridge", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "sessionId", "uri", "Landroid/net/Uri;", "sendEvent", "Lkotlin/Function2;", "initializeWithAnnieXWebModelInWeb", "annieXWebModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "webBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBDXBridge;", "annieXWebKit", "Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "initializeWithBulletContextInLynx", "lynxBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "eventHandler", "Lcom/bytedance/ies/bullet/service/base/IEventHandler;", "initializeWithBulletContextInWeb", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WebcastContainerInitializer {
    public final void initializeWithBulletContextInLynx(BulletContext bulletContext, final View view, LynxBDXBridge lynxBDXBridge, ContextProviderFactory providerFactory, final IEventHandler eventHandler) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        initializeCommon$default(this, bulletContext, view, lynxBDXBridge, providerFactory, null, null, new Function2<String, Object, Unit>() { // from class: WebcastContainerInitializer$initializeWithBulletContextInLynx$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, Object obj) {
                Intrinsics.checkNotNullParameter(str, "eventName");
                try {
                    eventHandler.sendEvent(str, obj, view);
                } catch (Exception e) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, "WebcastContainerInitializer", "Error converting params: " + e.getMessage() + " params: " + obj, (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
        }, 48, null);
    }

    public final void initializeWithBulletContextInWeb(BulletContext bulletContext, final View view, WebBDXBridge webBDXBridge, ContextProviderFactory providerFactory, final IEventHandler eventHandler) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        initializeCommon$default(this, bulletContext, view, webBDXBridge, providerFactory, null, null, new Function2<String, Object, Unit>() { // from class: WebcastContainerInitializer$initializeWithBulletContextInWeb$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, Object obj) {
                Intrinsics.checkNotNullParameter(str, "eventName");
                try {
                    eventHandler.sendEvent(str, obj, view);
                } catch (Exception e) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, "WebcastContainerInitializer", "Error converting params: " + e.getMessage() + " params: " + obj, (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
        }, 48, null);
    }

    public final void initializeWithAnnieXWebModelInWeb(AnnieXWebModel annieXWebModel, View view, WebBDXBridge webBDXBridge, ContextProviderFactory providerFactory, final AnnieXWebKit annieXWebKit) {
        Intrinsics.checkNotNullParameter(annieXWebModel, "annieXWebModel");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        Intrinsics.checkNotNullParameter(annieXWebKit, "annieXWebKit");
        initializeCommon(null, view, webBDXBridge, providerFactory, annieXWebModel.getSessionId(), annieXWebModel.getOriginalUri(), new Function2<String, Object, Unit>() { // from class: WebcastContainerInitializer$initializeWithAnnieXWebModelInWeb$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, Object obj) {
                Intrinsics.checkNotNullParameter(str, "eventName");
                try {
                    AnnieXWebKit.this.sendEvent(str, obj);
                } catch (Exception e) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, "WebcastContainerInitializer", "Error converting params: " + e.getMessage() + " params: " + obj, (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
        });
    }

    public static /* synthetic */ void initializeCommon$default(WebcastContainerInitializer webcastContainerInitializer, BulletContext bulletContext, View view, Object obj, ContextProviderFactory contextProviderFactory, String str, Uri uri, Function2 function2, int i, Object obj2) {
        String str2;
        Uri uri2;
        Uri uri3;
        ISchemaData schemaData;
        if ((i & 16) != 0) {
            String sessionId = bulletContext != null ? bulletContext.getSessionId() : null;
            if (sessionId == null) {
                sessionId = "";
            }
            str2 = sessionId;
        } else {
            str2 = str;
        }
        if ((i & 32) != 0) {
            if (bulletContext == null || (schemaData = bulletContext.getSchemaData()) == null || (uri3 = schemaData.getOriginUrl()) == null) {
                uri3 = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(uri3, "EMPTY");
            }
            uri2 = uri3;
        } else {
            uri2 = uri;
        }
        webcastContainerInitializer.initializeCommon(bulletContext, view, obj, contextProviderFactory, str2, uri2, function2);
    }

    public final void initializeCommon(BulletContext bulletContext, final View view, Object bridge, ContextProviderFactory providerFactory, final String sessionId, final Uri uri, final Function2<? super String, Object, Unit> sendEvent) {
        Context context;
        MethodFinder createEndMethodFinder;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        BaseBridgeService baseBridgeService = (IBridgeService) ServiceCenter.Companion.instance().get("default_bid", IBridgeService.class);
        if (baseBridgeService != null && (baseBridgeService instanceof BaseBridgeService) && (createEndMethodFinder = baseBridgeService.createEndMethodFinder(providerFactory)) != null) {
            LynxBDXBridge lynxBDXBridge = bridge instanceof LynxBDXBridge ? (LynxBDXBridge) bridge : null;
            if (lynxBDXBridge != null) {
                lynxBDXBridge.addCustomMethodFinder(createEndMethodFinder);
            }
            WebBDXBridge webBDXBridge = bridge instanceof WebBDXBridge ? (WebBDXBridge) bridge : null;
            if (webBDXBridge != null) {
                webBDXBridge.addCustomMethodFinder(createEndMethodFinder);
            }
        }
        final String str = "webcast";
        boolean z = bridge instanceof LynxBDXBridge;
        LynxBDXBridge lynxBDXBridge2 = z ? (LynxBDXBridge) bridge : null;
        if (lynxBDXBridge2 == null || (context = lynxBDXBridge2.getContext()) == null) {
            WebBDXBridge webBDXBridge2 = bridge instanceof WebBDXBridge ? (WebBDXBridge) bridge : null;
            context = webBDXBridge2 != null ? webBDXBridge2.getContext() : view.getContext();
        }
        final Context context2 = context;
        IContainerInstance iContainerInstance = new IContainerInstance() { // from class: WebcastContainerInitializer$initializeCommon$containerInstance$1
            /* renamed from: sessionId, reason: from getter */
            public String get$sessionId() {
                return sessionId;
            }

            /* renamed from: bid, reason: from getter */
            public String get$bid() {
                return str;
            }

            /* renamed from: context, reason: from getter */
            public Context get$context() {
                return context2;
            }

            /* renamed from: view, reason: from getter */
            public View get$view() {
                return view;
            }

            /* renamed from: uri, reason: from getter */
            public Uri get$uri() {
                return uri;
            }

            public void sendEvent(String eventName, Object params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                sendEvent.invoke(eventName, params);
            }
        };
        LynxBDXBridge lynxBDXBridge3 = z ? (LynxBDXBridge) bridge : null;
        if (lynxBDXBridge3 != null) {
            lynxBDXBridge3.registerService(IContainerInstance.class, iContainerInstance);
        }
        WebBDXBridge webBDXBridge3 = bridge instanceof WebBDXBridge ? (WebBDXBridge) bridge : null;
        if (webBDXBridge3 != null) {
            webBDXBridge3.registerService(IContainerInstance.class, iContainerInstance);
        }
        providerFactory.registerWeakHolder(IContainerInstance.class, iContainerInstance);
        if (IConditionCallKt.enableCardBidParamRegister()) {
            providerFactory.registerHolder(ContainerBidParam.class, new ContainerBidParam("webcast"));
        }
        IAnnieXContextProvider contextProvider = getContextProvider("webcast");
        if (contextProvider != null) {
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            contextProvider.completeContextProvider(iContainerInstance, context2, providerFactory);
            contextProvider.initAnnieXCardBizEnv("webcast");
        }
    }

    private final IAnnieXContextProvider getContextProvider(String bid) {
        if (AnnieXSettings.INSTANCE.getOptimizeBulletInit()) {
            return (IAnnieXContextProvider) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        }
        IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        return iAnnieXContextProvider == null ? (IAnnieXContextProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXContextProvider.class) : iAnnieXContextProvider;
    }
}
