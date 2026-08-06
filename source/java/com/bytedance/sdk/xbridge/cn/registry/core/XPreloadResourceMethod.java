package com.bytedance.sdk.xbridge.cn.registry.core;

import android.net.Uri;
import com.bytedance.android.anniex.web.api.AnnieXWebModelBuilderKt;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.TemplateBundleProcessor;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.ies.xbridge.model.results.XDefaultResultModel;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.AbsXPreloadResourceMethod;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: XPreloadResourceMethod.kt */
@XBridgeMethod(name = "x.preloadResource")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/XPreloadResourceMethod;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/AbsXPreloadResourceMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "dispose", "Lio/reactivex/disposables/Disposable;", "finishWithResult", "", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/AbsXPreloadResourceMethod$XPreloadResourceCallback;", "code", "", "msg", "", "getBid", "getSessionId", "handle", "params", "Lcom/bytedance/sdk/xbridge/cn/registry/core/XPreloadResourceParamModel;", DBData.FIELD_TYPE, "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XPreloadResourceMethod extends AbsXPreloadResourceMethod implements StatefulMethod {
    private Disposable dispose;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.AbsXPreloadResourceMethod
    public void handle(final XPreloadResourceParamModel params, final AbsXPreloadResourceMethod.XPreloadResourceCallback callback, XBridgePlatformType type) {
        final PreloadType preloadType;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        final String mainUrl = params.getMainUrl();
        String str = mainUrl;
        if (str == null || str.length() == 0) {
            if (Intrinsics.areEqual(params.getUsePreloadJson(), true)) {
                finishWithResult(callback, -3, "when usePreloadJson is true, mainUrl cannot be null");
                return;
            }
        } else if (!StringsKt.startsWith$default(mainUrl, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(mainUrl, "https://", false, 2, (Object) null)) {
            finishWithResult(callback, -3, "mainUrl must start with http(s) or null");
            return;
        }
        if (Intrinsics.areEqual(params.getContainerType(), "web")) {
            preloadType = PreloadType.WEB;
        } else {
            preloadType = PreloadType.LYNX;
        }
        this.dispose = Observable.just(1).subscribeOn(Schedulers.io()).map(new Function() { // from class: com.bytedance.sdk.xbridge.cn.registry.core.XPreloadResourceMethod$handle$1
            public final Integer apply(Integer num) {
                String sessionId;
                int preload;
                String sessionId2;
                String sessionId3;
                String sessionId4;
                Intrinsics.checkNotNullParameter(num, "it");
                if (Intrinsics.areEqual(XPreloadResourceParamModel.this.getUsePreloadJson(), true)) {
                    if (preloadType == PreloadType.LYNX && Intrinsics.areEqual(XPreloadResourceParamModel.this.getProcessType(), "templateBundle")) {
                        ForestLoader forestLoader = ForestLoader.INSTANCE;
                        String str2 = mainUrl;
                        Intrinsics.checkNotNull(str2);
                        sessionId4 = this.getSessionId();
                        PreloadType preloadType2 = PreloadType.LYNX;
                        TaskConfig taskConfig = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
                        taskConfig.setCustomMaxAge(XPreloadResourceParamModel.this.getMaxAge());
                        Uri parse = Uri.parse(XPreloadResourceParamModel.this.getMainUrl());
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(params.mainUrl)");
                        preload = ForestLoader.preloadWithProcessor$default(forestLoader, (Forest) null, str2, true, sessionId4, preloadType2, true, "jsb", taskConfig, true, new TemplateBundleProcessor(AnnieXWebModelBuilderKt.getIdentifierUrl(parse), false, 2, (DefaultConstructorMarker) null), (Function2) null, BaseApiResponse.API_EMAIL_REGISTER_VERIFY, (Object) null);
                    } else {
                        ForestLoader forestLoader2 = ForestLoader.INSTANCE;
                        Forest forest = ForestLoader.INSTANCE.getDefault();
                        String str3 = mainUrl;
                        Intrinsics.checkNotNull(str3);
                        sessionId3 = this.getSessionId();
                        PreloadType preloadType3 = preloadType;
                        TaskConfig taskConfig2 = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
                        taskConfig2.setCustomMaxAge(XPreloadResourceParamModel.this.getMaxAge());
                        Unit unit = Unit.INSTANCE;
                        preload = ForestLoader.preload$default(forestLoader2, forest, str3, true, sessionId3, preloadType3, true, "jsb", taskConfig2, true, (Function2) null, StatusBarUtils.FLAG_NOTCH_PORTRAIT, (Object) null);
                    }
                } else if (preloadType == PreloadType.LYNX && Intrinsics.areEqual(XPreloadResourceParamModel.this.getProcessType(), "templateBundle")) {
                    ForestLoader forestLoader3 = ForestLoader.INSTANCE;
                    Forest forest2 = ForestLoader.INSTANCE.getDefault();
                    String str4 = mainUrl;
                    Intrinsics.checkNotNull(str4);
                    Map<String, Object> subRes = XPreloadResourceParamModel.this.getSubRes();
                    JSONObject jSONObject = subRes != null ? new JSONObject(subRes) : null;
                    sessionId2 = this.getSessionId();
                    PreloadType preloadType4 = PreloadType.LYNX;
                    TaskConfig taskConfig3 = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
                    taskConfig3.setCustomMaxAge(XPreloadResourceParamModel.this.getMaxAge());
                    Unit unit2 = Unit.INSTANCE;
                    Uri parse2 = Uri.parse(mainUrl);
                    Intrinsics.checkNotNullExpressionValue(parse2, "parse(mainUrl)");
                    preload = ForestLoader.preloadWithProcessor$default(forestLoader3, forest2, str4, jSONObject, "jsb", sessionId2, preloadType4, taskConfig3, new TemplateBundleProcessor(AnnieXWebModelBuilderKt.getIdentifierUrl(parse2), false, 2, (DefaultConstructorMarker) null), false, StatusBarUtils.FLAG_NOTCH_SUPPORT, (Object) null);
                } else {
                    ForestLoader forestLoader4 = ForestLoader.INSTANCE;
                    Forest forest3 = ForestLoader.INSTANCE.getDefault();
                    String str5 = mainUrl;
                    Map<String, Object> subRes2 = XPreloadResourceParamModel.this.getSubRes();
                    JSONObject jSONObject2 = subRes2 != null ? new JSONObject(subRes2) : null;
                    sessionId = this.getSessionId();
                    PreloadType preloadType5 = preloadType;
                    TaskConfig taskConfig4 = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
                    taskConfig4.setCustomMaxAge(XPreloadResourceParamModel.this.getMaxAge());
                    Unit unit3 = Unit.INSTANCE;
                    preload = forestLoader4.preload(forest3, str5, jSONObject2, "jsb", sessionId, preloadType5, taskConfig4, true);
                }
                return Integer.valueOf(preload);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.bytedance.sdk.xbridge.cn.registry.core.XPreloadResourceMethod$handle$2
            public final void accept(Integer num) {
                Pair pair;
                if (num != null && num.intValue() == -1) {
                    pair = TuplesKt.to(0, "forest not init");
                } else {
                    pair = (num != null && num.intValue() == 0) ? TuplesKt.to(1, "") : TuplesKt.to(0, "unknown case");
                }
                XPreloadResourceMethod.this.finishWithResult(callback, ((Number) pair.component1()).intValue(), (String) pair.component2());
            }
        }, new Consumer() { // from class: com.bytedance.sdk.xbridge.cn.registry.core.XPreloadResourceMethod$handle$3
            public final void accept(Throwable th) {
                XPreloadResourceMethod xPreloadResourceMethod = XPreloadResourceMethod.this;
                AbsXPreloadResourceMethod.XPreloadResourceCallback xPreloadResourceCallback = callback;
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                xPreloadResourceMethod.finishWithResult(xPreloadResourceCallback, 0, message);
            }
        });
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod
    public void release() {
        Disposable disposable = this.dispose;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSessionId() {
        BulletContext bulletContext;
        String sessionId;
        XContextProviderFactory contextProviderFactory = getContextProviderFactory();
        return (contextProviderFactory == null || (bulletContext = (BulletContext) contextProviderFactory.provideInstance(BulletContext.class)) == null || (sessionId = bulletContext.getSessionId()) == null) ? "" : sessionId;
    }

    private final String getBid() {
        IBizKeyProvider iBizKeyProvider;
        String bizKey;
        XContextProviderFactory contextProviderFactory = getContextProviderFactory();
        return (contextProviderFactory == null || (iBizKeyProvider = (IBizKeyProvider) contextProviderFactory.provideInstance(IBizKeyProvider.class)) == null || (bizKey = iBizKeyProvider.getBizKey()) == null) ? "" : bizKey;
    }

    static /* synthetic */ void finishWithResult$default(XPreloadResourceMethod xPreloadResourceMethod, AbsXPreloadResourceMethod.XPreloadResourceCallback xPreloadResourceCallback, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        xPreloadResourceMethod.finishWithResult(xPreloadResourceCallback, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithResult(AbsXPreloadResourceMethod.XPreloadResourceCallback callback, int code, String msg) {
        if (code == 1) {
            callback.onSuccess(new XDefaultResultModel(), msg);
        } else {
            callback.onFailure(code, msg);
        }
    }
}
