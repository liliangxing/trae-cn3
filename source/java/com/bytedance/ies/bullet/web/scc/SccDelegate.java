package com.bytedance.ies.bullet.web.scc;

import android.webkit.WebResourceResponse;
import com.bytedance.ies.bullet.base.depend.INetworkDepend;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.lynx.scc.cloudservice.SccCloudService;
import com.bytedance.lynx.scc.cloudservice.SccCloudServiceManager;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.scc.cloudservice.network.DefaultNetAdapter;
import com.bytedance.lynx.scc.cloudservice.network.ISccNetworkFactory;
import com.bytedance.lynx.scc.cloudservice.reporter.ISccDataReportListener;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: SccDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/web/scc/SccDelegate;", "", "sccConfig", "Lcom/google/gson/JsonObject;", "networkDepend", "Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;", "(Lcom/google/gson/JsonObject;Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;)V", "cloudService", "Lcom/bytedance/lynx/scc/cloudservice/SccCloudService;", "doCheck", "", "url", "", "onUserAllow", "removeFragment", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "syncSecureLevel", "Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SccDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
    public static final String TAG = "SccDelegate";
    public static final String UTF_8_ENCODE = "UTF-8";
    private static boolean hasInit;
    private static Function2<? super String, ? super JSONObject, Unit> teaReporter;
    private final SccCloudService cloudService;

    /* compiled from: SccDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR2\u0010\r\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/web/scc/SccDelegate$Companion;", "", "()V", "MIMETYPE_TEXT_PLAIN", "", "TAG", "UTF_8_ENCODE", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "teaReporter", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "getTeaReporter", "()Lkotlin/jvm/functions/Function2;", "setTeaReporter", "(Lkotlin/jvm/functions/Function2;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getHasInit() {
            return SccDelegate.hasInit;
        }

        public final void setHasInit(boolean z) {
            SccDelegate.hasInit = z;
        }

        public final Function2<String, JSONObject, Unit> getTeaReporter() {
            return SccDelegate.teaReporter;
        }

        public final void setTeaReporter(Function2<? super String, ? super JSONObject, Unit> function2) {
            SccDelegate.teaReporter = function2;
        }
    }

    public SccDelegate(JsonObject jsonObject, final INetworkDepend iNetworkDepend) {
        Intrinsics.checkNotNullParameter(jsonObject, "sccConfig");
        Intrinsics.checkNotNullParameter(iNetworkDepend, "networkDepend");
        SccCloudService sccCloudService = new SccCloudService();
        this.cloudService = sccCloudService;
        if (!hasInit) {
            synchronized (SccDelegate.class) {
                if (!hasInit) {
                    final Method method = Class.forName("com.ss.android.common.lib.AppLogNewUtils").getMethod("onEventV3", String.class, JSONObject.class);
                    teaReporter = new Function2<String, JSONObject, Unit>() { // from class: com.bytedance.ies.bullet.web.scc.SccDelegate$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((String) obj, (JSONObject) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(String str, JSONObject jSONObject) {
                            try {
                                method.invoke(null, str, jSONObject);
                            } catch (Exception unused) {
                                HybridLogger.w$default(HybridLogger.INSTANCE, SccDelegate.TAG, "has no tea reporter.", null, null, 12, null);
                            }
                        }
                    };
                    if (SccCloudServiceManager.getNetAdapter() == null) {
                        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "set SccSDK NetAdapter", null, null, 12, null);
                        SccCloudServiceManager.setNetAdapter(new DefaultNetAdapter(new ISccNetworkFactory() { // from class: com.bytedance.ies.bullet.web.scc.SccDelegate$1$2
                            @Override // com.bytedance.lynx.scc.cloudservice.network.ISccNetworkFactory
                            public <T> T create(String baseUrl, Class<T> api) {
                                Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
                                Intrinsics.checkNotNullParameter(api, "api");
                                return (T) INetworkDepend.this.create(baseUrl, api);
                            }
                        }));
                    }
                    SccCloudServiceManager.registerDataReportListener(new ISccDataReportListener() { // from class: com.bytedance.ies.bullet.web.scc.SccDelegate$1$3
                        @Override // com.bytedance.lynx.scc.cloudservice.reporter.ISccDataReportListener
                        public final void onDataReport(String str, Map<String, String> map) {
                            JSONObject jSONObject = new JSONObject();
                            Intrinsics.checkNotNullExpressionValue(map, "map");
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                jSONObject.put(entry.getKey(), entry.getValue());
                            }
                            Function2<String, JSONObject, Unit> teaReporter2 = SccDelegate.INSTANCE.getTeaReporter();
                            if (teaReporter2 != null) {
                                teaReporter2.invoke(str, jSONObject);
                            }
                        }
                    });
                    hasInit = true;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        sccCloudService.setSettingsJsonConfig(jsonObject);
    }

    public final void doCheck(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.cloudService.doCheck(removeFragment(url));
    }

    public final WebResourceResponse shouldInterceptRequest(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String removeFragment = removeFragment(url);
        SccResult cloudServiceResponse = this.cloudService.getCloudServiceResponse(removeFragment);
        if (cloudServiceResponse == null) {
            return null;
        }
        String label = cloudServiceResponse.getLabel();
        if (label != null) {
            if (Intrinsics.areEqual("black", label) || Intrinsics.areEqual(SccResult.LABEL_NOTICE, label)) {
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "scc_sdk " + removeFragment + " is notice.", null, null, 12, null);
                this.cloudService.addNoticeUrls(removeFragment);
                return new WebResourceResponse(MIMETYPE_TEXT_PLAIN, "UTF-8", new ByteArrayInputStream(new byte[0]));
            }
            if (Intrinsics.areEqual(SccResult.LABEL_DENY, label)) {
                this.cloudService.addDenyUrl(removeFragment);
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "scc_sdk " + removeFragment + " is deny.", null, null, 12, null);
                return new WebResourceResponse(MIMETYPE_TEXT_PLAIN, "UTF-8", new ByteArrayInputStream(new byte[0]));
            }
        }
        return this.cloudService.tryGetPrefetchResponse(removeFragment);
    }

    public final SccConfig.SccLevel syncSecureLevel(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String removeFragment = removeFragment(url);
        return this.cloudService.isNoticeUrl(removeFragment) ? SccConfig.SccLevel.NOTICE : this.cloudService.isDenyUrl(removeFragment) ? SccConfig.SccLevel.DENY : SccConfig.SccLevel.SAFE;
    }

    public final void onUserAllow(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.cloudService.onUserAllow(removeFragment(url));
    }

    private final String removeFragment(String url) {
        return StringsKt.substringBefore$default(url, '#', (String) null, 2, (Object) null);
    }
}
