package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.aspect.eventCenter.FeAuthConfig;
import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.ies.argus.bean.ArgusFeId;
import com.bytedance.ies.argus.bean.ArgusSwitch;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.plugin.SecLinkPluginHandler;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: WebLoadUrlParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 n2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001nBk\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010a\u001a\u00020\u0002H\u0016J\u0010\u0010b\u001a\u00020K2\u0006\u0010c\u001a\u00020dH\u0016J\u0012\u0010e\u001a\u0004\u0018\u00010K2\u0006\u0010c\u001a\u00020dH\u0016J\u0012\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010h\u001a\u00020\u0005H\u0016J)\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020`2\u0006\u0010l\u001a\u00020_2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@H\u0000¢\u0006\u0002\bmR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\"\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R$\u0010)\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\t\u0010#R\u001e\u0010-\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\u000b\u0010#R\u001b\u00100\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b0\u0010*R\u0014\u00103\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010(R\u0013\u00105\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b6\u0010(R\u0013\u00107\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b8\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010;\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u0011\u0010=\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001d\u0010E\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u00102\u001a\u0004\bF\u0010(R\"\u0010H\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010(R\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00102\u001a\u0004\bL\u0010MR\"\u0010O\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010(R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bT\u0010*R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010W\u001a\u0004\u0018\u00010X8F¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b[\u0010(R \u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020`0^0]X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlRewritePayload;", "Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "url", "", "secLinkScene", "schema", "Landroid/net/Uri;", "isForMainFrame", "", "isRedirect", "hasGesture", "method", "", "requestHeaders", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/CharSequence;Ljava/util/Map;)V", "containerType", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "getContainerType", "()Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "feAuthConfig", "Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "getFeAuthConfig", "()Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;", "setFeAuthConfig", "(Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfig;)V", "feId", "", "getFeId", "()J", "setFeId", "(J)V", "getHasGesture", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "<set-?>", "host", "getHost", "()Ljava/lang/String;", "isEntryUrl", "()Z", "setEntryUrl$anniex_release", "(Z)V", "isHttp", "isInnerHost", "isInnerHost$anniex_release", "isSecLinkPage", "isSecLinkPage$delegate", "Lkotlin/Lazy;", "loadUrl", "getLoadUrl", "loadUrlHost", "getLoadUrlHost", "loadUrlParentHost", "getLoadUrlParentHost", "getMethod", "()Ljava/lang/CharSequence;", "originSecLinkScene", "getOriginSecLinkScene", "originUrl", "getOriginUrl", "pageType", "Lcom/bytedance/ies/argus/api/params/WebLoadPageType;", "getPageType$anniex_release", "()Lcom/bytedance/ies/argus/api/params/WebLoadPageType;", "setPageType$anniex_release", "(Lcom/bytedance/ies/argus/api/params/WebLoadPageType;)V", "parentHost", "getParentHost", "parentHost$delegate", "path", "getPath", "printObj", "Lorg/json/JSONObject;", "getPrintObj", "()Lorg/json/JSONObject;", "printObj$delegate", "protocol", "getProtocol", "getRequestHeaders", "()Ljava/util/Map;", "reservedProtocol", "getReservedProtocol", "getSchema", "()Landroid/net/Uri;", "secLinkCheckMode", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "getSecLinkCheckMode", "()Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "getSecLinkScene", "webLoadVerifyRecord", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Pair;", "Lcom/bytedance/ies/argus/api/params/WebLoadRiskTag;", "Lcom/bytedance/ies/argus/api/params/WebLoadVerifySource;", "initRewritePayload", "toALogObject", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "ttmGetValue", "", Api.KEY_ENCRYPT_RESP_KEY, "updateWebLoadVerifyResult", "", DBHelper.BATTERY_COL_SOURCE, "riskTag", "updateWebLoadVerifyResult$anniex_release", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebLoadUrlParams extends BaseAspectParams<WebLoadUrlRewritePayload> implements IFePageInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> RESERVED_PROTOCOL = CollectionsKt.listOf(new String[]{"about", "bytedance"});
    private final ArgusContainerType containerType;
    private FeAuthConfig feAuthConfig;
    private long feId;
    private final Boolean hasGesture;
    private String host;
    private boolean isEntryUrl;
    private final Boolean isForMainFrame;
    private boolean isHttp;
    private final Boolean isRedirect;

    /* renamed from: isSecLinkPage$delegate, reason: from kotlin metadata */
    private final Lazy isSecLinkPage;
    private final CharSequence method;
    private final String originSecLinkScene;
    private final String originUrl;
    private WebLoadPageType pageType;

    /* renamed from: parentHost$delegate, reason: from kotlin metadata */
    private final Lazy parentHost;
    private String path;

    /* renamed from: printObj$delegate, reason: from kotlin metadata */
    private final Lazy printObj;
    private String protocol;
    private final Map<String, String> requestHeaders;
    private boolean reservedProtocol;
    private final Uri schema;
    private final ConcurrentLinkedDeque<Pair<WebLoadRiskTag, WebLoadVerifySource>> webLoadVerifyRecord;

    public /* synthetic */ WebLoadUrlParams(String str, String str2, Uri uri, Boolean bool, Boolean bool2, Boolean bool3, CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : uri, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : bool3, (i & 64) != 0 ? null : charSequence, (i & 128) != 0 ? null : map);
    }

    public final Uri getSchema() {
        return this.schema;
    }

    /* renamed from: isForMainFrame, reason: from getter */
    public final Boolean getIsForMainFrame() {
        return this.isForMainFrame;
    }

    /* renamed from: isRedirect, reason: from getter */
    public final Boolean getIsRedirect() {
        return this.isRedirect;
    }

    public final Boolean getHasGesture() {
        return this.hasGesture;
    }

    public final CharSequence getMethod() {
        return this.method;
    }

    public final Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public WebLoadUrlParams(String str, final String str2, Uri uri, Boolean bool, Boolean bool2, Boolean bool3, CharSequence charSequence, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.schema = uri;
        this.isForMainFrame = bool;
        this.isRedirect = bool2;
        this.hasGesture = bool3;
        this.method = charSequence;
        this.requestHeaders = map;
        this.originUrl = str;
        this.originSecLinkScene = str2;
        this.parentHost = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.argus.api.params.WebLoadUrlParams$parentHost$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                String host = WebLoadUrlParams.this.getHost();
                if (host != null) {
                    return CommonUtils.INSTANCE.getParentHostBaseHost(host);
                }
                return null;
            }
        });
        this.isSecLinkPage = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.ies.argus.api.params.WebLoadUrlParams$isSecLinkPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m591invoke() {
                return Boolean.valueOf(SecLinkPluginHandler.Companion.isSecLinkPage(WebLoadUrlParams.this.getOriginUrl()));
            }
        });
        this.feId = ArgusFeId.UNSET.getLongValue();
        this.containerType = ArgusContainerType.WEB;
        ConcurrentLinkedDeque<Pair<WebLoadRiskTag, WebLoadVerifySource>> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque.add(new Pair<>(WebLoadRiskTag.Default, WebLoadVerifySource.Inner));
        this.webLoadVerifyRecord = concurrentLinkedDeque;
        try {
            Iterator<String> it = RESERVED_PROTOCOL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (StringsKt.startsWith$default(str, it.next(), false, 2, (Object) null)) {
                    this.reservedProtocol = true;
                    break;
                }
            }
            if (!this.reservedProtocol) {
                URI uri2 = new URI(str);
                this.host = uri2.getHost();
                this.protocol = uri2.getScheme();
                this.path = uri2.getPath();
                if (uri2.getScheme() == null || Intrinsics.areEqual(uri2.getScheme(), "http") || Intrinsics.areEqual(uri2.getScheme(), "https")) {
                    this.isHttp = true;
                }
            }
        } catch (Exception unused) {
            if (StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
                this.isHttp = true;
            }
        }
        this.printObj = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.bytedance.ies.argus.api.params.WebLoadUrlParams$printObj$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final JSONObject invoke() {
                JSONObject jSONObject = new JSONObject();
                WebLoadUrlParams webLoadUrlParams = WebLoadUrlParams.this;
                String str3 = str2;
                JSONUtilsKt.safelyPutWithDefault(jSONObject, "origin_seclink_scene", webLoadUrlParams.getOriginSecLinkScene());
                JSONUtilsKt.safelyPutWithDefault(jSONObject, "seclink_scene", str3);
                JSONUtilsKt.safelyPut(jSONObject, "url", webLoadUrlParams.getOriginUrl());
                return jSONObject;
            }
        });
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getOriginSecLinkScene() {
        return this.originSecLinkScene;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getParentHost() {
        return (String) this.parentHost.getValue();
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final String getPath() {
        return this.path;
    }

    /* renamed from: isHttp, reason: from getter */
    public final boolean getIsHttp() {
        return this.isHttp;
    }

    public final boolean getReservedProtocol() {
        return this.reservedProtocol;
    }

    /* renamed from: isEntryUrl, reason: from getter */
    public final boolean getIsEntryUrl() {
        return this.isEntryUrl;
    }

    public final void setEntryUrl$anniex_release(boolean z) {
        this.isEntryUrl = z;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public String getLoadUrl() {
        String url;
        WebLoadUrlRewritePayload rewritePayload = getRewritePayload();
        return (rewritePayload == null || (url = rewritePayload.getUrl()) == null) ? this.originUrl : url;
    }

    public final String getSecLinkScene() {
        String secLinkScene;
        WebLoadUrlRewritePayload rewritePayload = getRewritePayload();
        return (rewritePayload == null || (secLinkScene = rewritePayload.getSecLinkScene()) == null) ? this.originSecLinkScene : secLinkScene;
    }

    public final ArgusSwitch getSecLinkCheckMode() {
        WebLoadUrlRewritePayload rewritePayload = getRewritePayload();
        if (rewritePayload != null) {
            return rewritePayload.getSecLinkMode();
        }
        return null;
    }

    public final String getLoadUrlHost() {
        return Intrinsics.areEqual(getLoadUrl(), this.originUrl) ? this.host : CommonUtils.INSTANCE.getHostByUrl(getLoadUrl());
    }

    public final String getLoadUrlParentHost() {
        return Intrinsics.areEqual(getLoadUrl(), this.originUrl) ? getParentHost() : CommonUtils.INSTANCE.getParentHostBaseUrl(getLoadUrl());
    }

    public final boolean isInnerHost$anniex_release() {
        return this.pageType == WebLoadPageType.WHITE_INNER;
    }

    /* renamed from: getPageType$anniex_release, reason: from getter */
    public final WebLoadPageType getPageType() {
        return this.pageType;
    }

    public final void setPageType$anniex_release(WebLoadPageType webLoadPageType) {
        this.pageType = webLoadPageType;
    }

    public final boolean isSecLinkPage() {
        return ((Boolean) this.isSecLinkPage.getValue()).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public WebLoadUrlRewritePayload initRewritePayload() {
        return new WebLoadUrlRewritePayload();
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public long getFeId() {
        return this.feId;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public void setFeId(long j) {
        this.feId = j;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public ArgusContainerType getContainerType() {
        return this.containerType;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public FeAuthConfig getFeAuthConfig() {
        return this.feAuthConfig;
    }

    @Override // com.bytedance.ies.argus.api.params.IFePageInfo
    public void setFeAuthConfig(FeAuthConfig feAuthConfig) {
        this.feAuthConfig = feAuthConfig;
    }

    public static /* synthetic */ void updateWebLoadVerifyResult$anniex_release$default(WebLoadUrlParams webLoadUrlParams, WebLoadVerifySource webLoadVerifySource, WebLoadRiskTag webLoadRiskTag, WebLoadPageType webLoadPageType, int i, Object obj) {
        if ((i & 4) != 0) {
            webLoadPageType = null;
        }
        webLoadUrlParams.updateWebLoadVerifyResult$anniex_release(webLoadVerifySource, webLoadRiskTag, webLoadPageType);
    }

    public final void updateWebLoadVerifyResult$anniex_release(WebLoadVerifySource source, WebLoadRiskTag riskTag, WebLoadPageType pageType) {
        Intrinsics.checkNotNullParameter(source, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(riskTag, "riskTag");
        this.webLoadVerifyRecord.add(new Pair<>(riskTag, source));
        if (pageType != null) {
            this.pageType = pageType;
        }
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public Object ttmGetValue(String key) {
        WebLoadPageType webLoadPageType;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        switch (key.hashCode()) {
            case -1418483864:
                if (key.equals("url_protocol")) {
                    return this.protocol;
                }
                return null;
            case -1166331866:
                if (key.equals("is_inner_host")) {
                    return Boolean.valueOf(isInnerHost$anniex_release());
                }
                return null;
            case -970525064:
                if (key.equals("url_host")) {
                    return this.host;
                }
                return null;
            case 116079:
                if (key.equals("url")) {
                    return getLoadUrl();
                }
                return null;
            case 111636765:
                if (key.equals("is_entry")) {
                    return Boolean.valueOf(this.isEntryUrl);
                }
                return null;
            case 294466741:
                if (key.equals("sec_link_scene")) {
                    return getSecLinkScene();
                }
                return null;
            case 795307910:
                if (key.equals("headers")) {
                    return this.requestHeaders;
                }
                return null;
            case 883893994:
                if (key.equals("page_type") && (webLoadPageType = this.pageType) != null) {
                    return webLoadPageType.getStrValue();
                }
                return null;
            default:
                return null;
        }
    }

    private final JSONObject getPrintObj() {
        return (JSONObject) this.printObj.getValue();
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject printObj = getPrintObj();
        JSONUtilsKt.safelyPut(printObj, "url_host", this.host);
        JSONUtilsKt.safelyPut(printObj, "url_protocol", this.protocol);
        Map<String, String> map = this.requestHeaders;
        JSONUtilsKt.safelyPut(printObj, "header_keys", map != null ? map.keySet() : null);
        JSONUtilsKt.safelyPut(printObj, "is_entry", Boolean.valueOf(this.isEntryUrl));
        JSONUtilsKt.safelyPut(printObj, "is_inner_host", Boolean.valueOf(isInnerHost$anniex_release()));
        JSONUtilsKt.safelyPut(printObj, "is_third", Boolean.valueOf(!isInnerHost$anniex_release()));
        JSONUtilsKt.safelyPut(printObj, "url_path", this.path);
        Pair pair = (Pair) CollectionsKt.last(this.webLoadVerifyRecord);
        WebLoadRiskTag webLoadRiskTag = (WebLoadRiskTag) pair.component1();
        WebLoadVerifySource webLoadVerifySource = (WebLoadVerifySource) pair.component2();
        JSONUtilsKt.safelyPut(printObj, "final_verify_type", webLoadRiskTag.getStrValue());
        JSONUtilsKt.safelyPut(printObj, "final_verify_source", webLoadVerifySource.getStrValue());
        JSONUtilsKt.safelyPut(printObj, "load_verify_record", CollectionsKt.joinToString$default(this.webLoadVerifyRecord, ">", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Pair<? extends WebLoadRiskTag, ? extends WebLoadVerifySource>, CharSequence>() { // from class: com.bytedance.ies.argus.api.params.WebLoadUrlParams$toMonitorObject$1$2
            public final CharSequence invoke(Pair<? extends WebLoadRiskTag, ? extends WebLoadVerifySource> pair2) {
                return ((WebLoadRiskTag) pair2.getFirst()).getStrValue() + '#' + ((WebLoadVerifySource) pair2.getSecond()).getStrValue();
            }
        }, 30, (Object) null));
        return printObj;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return getPrintObj();
    }

    /* compiled from: WebLoadUrlParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams$Companion;", "", "()V", "RESERVED_PROTOCOL", "", "", "getRESERVED_PROTOCOL", "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getRESERVED_PROTOCOL() {
            return WebLoadUrlParams.RESERVED_PROTOCOL;
        }
    }
}
