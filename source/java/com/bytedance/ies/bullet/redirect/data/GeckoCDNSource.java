package com.bytedance.ies.bullet.redirect.data;

import android.net.Uri;
import com.bytedance.ies.bullet.base.settings.AnnieXRedirectSettingsConfig;
import com.bytedance.ies.bullet.forest.ForestRequestInfoBuilderKt;
import com.bytedance.ies.bullet.settings.data.IBulletSettings;
import com.bytedance.news.common.settings.IndividualManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GeckoCDNSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/GeckoCDNSource;", "", "()V", "cdnSourceUrl", "", "getCdnSourceUrl", "()Ljava/lang/String;", "setCdnSourceUrl", "(Ljava/lang/String;)V", ErrorType.SETTINGS, "Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "getSettings", "()Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "settings$delegate", "Lkotlin/Lazy;", "getUrl", "provide", "Lio/reactivex/Observable;", "Lcom/bytedance/ies/bullet/redirect/data/RedirectSettingsData;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GeckoCDNSource {
    public static final String VERSION = "1";
    private String cdnSourceUrl;

    /* renamed from: settings$delegate, reason: from kotlin metadata */
    private final Lazy settings = LazyKt.lazy(new Function0<IBulletSettings>() { // from class: com.bytedance.ies.bullet.redirect.data.GeckoCDNSource$settings$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IBulletSettings m546invoke() {
            try {
                return (IBulletSettings) IndividualManager.obtainManager("Bullet").obtain(IBulletSettings.class);
            } catch (Exception unused) {
                return null;
            }
        }
    });

    public final String getCdnSourceUrl() {
        return this.cdnSourceUrl;
    }

    public final void setCdnSourceUrl(String str) {
        this.cdnSourceUrl = str;
    }

    public final IBulletSettings getSettings() {
        return (IBulletSettings) this.settings.getValue();
    }

    public final Observable<RedirectSettingsData> provide() {
        Observable<RedirectSettingsData> create = Observable.create(new ObservableOnSubscribe() { // from class: com.bytedance.ies.bullet.redirect.data.GeckoCDNSource$provide$1
            public final void subscribe(final ObservableEmitter<RedirectSettingsData> observableEmitter) {
                Object obj;
                String url;
                Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
                GeckoCDNSource geckoCDNSource = GeckoCDNSource.this;
                try {
                    Result.Companion companion = Result.Companion;
                    IResponseCallback iResponseCallback = new IResponseCallback() { // from class: com.bytedance.ies.bullet.redirect.data.GeckoCDNSource$provide$1$1$responseCallback$1
                        public Unit onParsingFailed(JSONObject jSONObject, LinkedHashMap<String, String> linkedHashMap, String str, Throwable th, Integer num, int i) {
                            return IResponseCallback.DefaultImpls.onParsingFailed(this, jSONObject, linkedHashMap, str, th, num, i);
                        }

                        public void onSuccess(JSONObject body, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode) {
                            Intrinsics.checkNotNullParameter(body, "body");
                            Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                            observableEmitter.onNext(RedirectSettingsData.INSTANCE.create(body.optJSONObject("redirect_rules"), body.optJSONObject("common_config"), responseHeader.get("x-gecko-proxy-pkgid"), System.currentTimeMillis()));
                            observableEmitter.onComplete();
                        }

                        public void onFailed(Integer errorCode, LinkedHashMap<String, String> responseHeader, Throwable throwable, int clientCode) {
                            Intrinsics.checkNotNullParameter(throwable, "throwable");
                            observableEmitter.onError(throwable);
                            observableEmitter.onComplete();
                        }
                    };
                    XBridgeAPIRequestUtils xBridgeAPIRequestUtils = XBridgeAPIRequestUtils.INSTANCE;
                    url = geckoCDNSource.getUrl();
                    IHostNetworkDepend hostNetworkDepend = XBaseRuntime.INSTANCE.getHostNetworkDepend();
                    Intrinsics.checkNotNull(hostNetworkDepend);
                    XBridgeAPIRequestUtils.get$default(xBridgeAPIRequestUtils, url, new LinkedHashMap(), iResponseCallback, hostNetworkDepend, true, false, 0, 64, (Object) null);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    observableEmitter.onError(th2);
                    observableEmitter.onComplete();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "fun provide(): Observabl…omplete()\n        }\n    }");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getUrl() {
        Object obj;
        String str;
        AnnieXRedirectSettingsConfig annieXRedirectConfig;
        try {
            Result.Companion companion = Result.Companion;
            IBulletSettings settings = getSettings();
            if ((settings == null || (annieXRedirectConfig = settings.getAnnieXRedirectConfig()) == null || (str = annieXRedirectConfig.getConfigUrl()) == null) && (str = this.cdnSourceUrl) == null) {
                str = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/cdn/api/scheme_config/api.roma.config.json";
            }
            String uri = Uri.parse(str).buildUpon().appendQueryParameter("sdkVersion", "1").build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
            obj = Result.constructor-impl(ForestRequestInfoBuilderKt.addEnvParamsForCDNMultiVersion(uri));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = "";
        }
        return (String) obj;
    }
}
