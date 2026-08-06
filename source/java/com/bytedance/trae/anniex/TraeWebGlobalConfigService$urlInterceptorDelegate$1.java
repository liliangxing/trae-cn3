package com.bytedance.trae.anniex;

import android.webkit.WebView;
import com.bytedance.ies.bullet.kit.web.IWebViewLoadUrlInterceptorDelegate;
import com.bytedance.trae.network.TraeTTNet;
import com.bytedance.trae.platform.model.HttpEnvConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeWebGlobalConfigService.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0083\u0001\u0010\u0002\u001a}\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0012&\u0012$\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0003j$\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006`\n¢\u0006\u0002\b\tH\u0016¨\u0006\u000b"}, d2 = {"com/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1", "Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "provideWebViewLoadUrlInterceptor", "Lkotlin/Function4;", "Landroid/webkit/WebView;", "", "", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/bytedance/ies/bullet/kit/web/TwistInterceptor;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeWebGlobalConfigService$urlInterceptorDelegate$1 implements IWebViewLoadUrlInterceptorDelegate {
    public Function4<WebView, String, Map<String, String>, Function2<? super String, ? super Map<String, String>, Unit>, Unit> provideWebViewLoadUrlInterceptor() {
        return new Function4() { // from class: com.bytedance.trae.anniex.TraeWebGlobalConfigService$urlInterceptorDelegate$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit provideWebViewLoadUrlInterceptor$lambda$0;
                provideWebViewLoadUrlInterceptor$lambda$0 = TraeWebGlobalConfigService$urlInterceptorDelegate$1.provideWebViewLoadUrlInterceptor$lambda$0((WebView) obj, (String) obj2, (Map) obj3, (Function2) obj4);
                return provideWebViewLoadUrlInterceptor$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit provideWebViewLoadUrlInterceptor$lambda$0(WebView webView, String str, Map map, Function2 function2) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(function2, "next");
        if (map == null) {
            map = new LinkedHashMap();
        }
        HttpEnvConfig httpEnv = TraeTTNet.INSTANCE.getHttpEnv();
        if (httpEnv.getPpeEnable()) {
            map.put("x-use-ppe", "1");
            if (httpEnv.getPpeEnv().length() > 0) {
                map.put("x-tt-env", httpEnv.getPpeEnv());
            }
        } else if (httpEnv.getBoeEnable()) {
            map.put("x-use-boe", "1");
            if (httpEnv.getBoeEnv().length() > 0) {
                map.put("x-tt-env", httpEnv.getBoeEnv());
            }
        }
        function2.invoke(str, map);
        return Unit.INSTANCE;
    }
}
