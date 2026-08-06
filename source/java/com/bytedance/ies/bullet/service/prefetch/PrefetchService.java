package com.bytedance.ies.bullet.service.prefetch;

import android.net.Uri;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IPrefetchService;
import com.bytedance.ies.bullet.service.base.PrefetchV2Data;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.tools.prefetch.INetworkExecutor;
import com.bytedance.ies.tools.prefetch.IPrefetchProcessor;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.push.utils.RomVersionParamHelper;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PrefetchService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/service/prefetch/PrefetchService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/IPrefetchService;", "prefetchProcessor", "Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;", "bridgeName", "", "(Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;Ljava/lang/String;)V", "localCacheProcessor", "Lcom/bytedance/ies/bullet/service/prefetch/PrefetchService$LocalCacheProcessor;", "getLocalCacheProcessor", "()Lcom/bytedance/ies/bullet/service/prefetch/PrefetchService$LocalCacheProcessor;", "setLocalCacheProcessor", "(Lcom/bytedance/ies/bullet/service/prefetch/PrefetchService$LocalCacheProcessor;)V", "routerUriSet", "Ljava/util/HashSet;", "Landroid/net/Uri;", "Lkotlin/collections/HashSet;", "getCacheByScheme", "Lorg/json/JSONObject;", "url", "getCacheBySchemeV2", "", "Lcom/bytedance/ies/bullet/service/base/PrefetchV2Data;", "scheme", "getCacheFromPrefetch", "getLocalCacheByUrl", ErrorType.PREFETCH, "", "schema", "prefetchForRouter", "prefetchForView", "providePrefetchBridge", "", "providerFactory", "shouldInjectProps", "", "uri", "Companion", "LocalCacheProcessor", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PrefetchService extends BaseBulletService implements IPrefetchService {
    public static final String DEFAULT_BRIDGE_NAME = "__prefetch";
    private final String bridgeName;
    private LocalCacheProcessor localCacheProcessor;
    private final IPrefetchProcessor prefetchProcessor;
    private final HashSet<Uri> routerUriSet;

    /* compiled from: PrefetchService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/prefetch/PrefetchService$LocalCacheProcessor;", "", "handleKey", "Lorg/json/JSONObject;", "url", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface LocalCacheProcessor {
        JSONObject handleKey(String url);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchService
    @Deprecated(message = "已废弃")
    public boolean shouldInjectProps(Uri uri) {
        return false;
    }

    public /* synthetic */ PrefetchService(IPrefetchProcessor iPrefetchProcessor, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPrefetchProcessor, (i & 2) != 0 ? "__prefetch" : str);
    }

    public PrefetchService(IPrefetchProcessor iPrefetchProcessor, String str) {
        Intrinsics.checkNotNullParameter(iPrefetchProcessor, "prefetchProcessor");
        Intrinsics.checkNotNullParameter(str, "bridgeName");
        this.prefetchProcessor = iPrefetchProcessor;
        this.bridgeName = str;
        this.routerUriSet = new HashSet<>();
    }

    public final LocalCacheProcessor getLocalCacheProcessor() {
        return this.localCacheProcessor;
    }

    public final void setLocalCacheProcessor(LocalCacheProcessor localCacheProcessor) {
        this.localCacheProcessor = localCacheProcessor;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchService
    public Object providePrefetchBridge(Object providerFactory, String bridgeName) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        ContextProviderFactory contextProviderFactory = (ContextProviderFactory) providerFactory;
        contextProviderFactory.registerHolder(PrefetchService.class, this);
        contextProviderFactory.registerHolder(IPrefetchProcessor.class, this.prefetchProcessor);
        return new PrefetchBridge(contextProviderFactory);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchService
    public void prefetch(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.isBlank(url)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            IPrefetchProcessor processorByUrl = PrefetchProcessorManager.INSTANCE.getProcessorByUrl(url);
            if (processorByUrl == null) {
                processorByUrl = this.prefetchProcessor;
            }
            processorByUrl.prefetch(url);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "start prefetch:" + url + ", with time cost:" + (System.currentTimeMillis() - currentTimeMillis), null, null, 6, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x0235, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0215 A[Catch: Exception -> 0x0277, TryCatch #0 {Exception -> 0x0277, blocks: (B:3:0x000c, B:5:0x0012, B:7:0x0025, B:11:0x0034, B:18:0x005d, B:21:0x0068, B:24:0x0070, B:25:0x0085, B:27:0x008b, B:30:0x0097, B:35:0x009f, B:36:0x00a5, B:39:0x00af, B:42:0x00b7, B:44:0x00be, B:46:0x00ce, B:51:0x00da, B:53:0x00de, B:56:0x00e7, B:58:0x00f3, B:59:0x010b, B:61:0x0111, B:64:0x011d, B:67:0x0123, B:73:0x012b, B:75:0x0131, B:77:0x015b, B:79:0x0163, B:82:0x016e, B:85:0x0176, B:87:0x0183, B:92:0x018f, B:94:0x0194, B:97:0x019d, B:98:0x01b6, B:100:0x01bc, B:103:0x01c8, B:106:0x01ce, B:112:0x01d6, B:114:0x01db, B:115:0x020f, B:117:0x0215, B:120:0x0221, B:123:0x0227, B:129:0x022f, B:134:0x0236, B:147:0x002d), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da A[Catch: Exception -> 0x0277, TryCatch #0 {Exception -> 0x0277, blocks: (B:3:0x000c, B:5:0x0012, B:7:0x0025, B:11:0x0034, B:18:0x005d, B:21:0x0068, B:24:0x0070, B:25:0x0085, B:27:0x008b, B:30:0x0097, B:35:0x009f, B:36:0x00a5, B:39:0x00af, B:42:0x00b7, B:44:0x00be, B:46:0x00ce, B:51:0x00da, B:53:0x00de, B:56:0x00e7, B:58:0x00f3, B:59:0x010b, B:61:0x0111, B:64:0x011d, B:67:0x0123, B:73:0x012b, B:75:0x0131, B:77:0x015b, B:79:0x0163, B:82:0x016e, B:85:0x0176, B:87:0x0183, B:92:0x018f, B:94:0x0194, B:97:0x019d, B:98:0x01b6, B:100:0x01bc, B:103:0x01c8, B:106:0x01ce, B:112:0x01d6, B:114:0x01db, B:115:0x020f, B:117:0x0215, B:120:0x0221, B:123:0x0227, B:129:0x022f, B:134:0x0236, B:147:0x002d), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018f A[Catch: Exception -> 0x0277, TryCatch #0 {Exception -> 0x0277, blocks: (B:3:0x000c, B:5:0x0012, B:7:0x0025, B:11:0x0034, B:18:0x005d, B:21:0x0068, B:24:0x0070, B:25:0x0085, B:27:0x008b, B:30:0x0097, B:35:0x009f, B:36:0x00a5, B:39:0x00af, B:42:0x00b7, B:44:0x00be, B:46:0x00ce, B:51:0x00da, B:53:0x00de, B:56:0x00e7, B:58:0x00f3, B:59:0x010b, B:61:0x0111, B:64:0x011d, B:67:0x0123, B:73:0x012b, B:75:0x0131, B:77:0x015b, B:79:0x0163, B:82:0x016e, B:85:0x0176, B:87:0x0183, B:92:0x018f, B:94:0x0194, B:97:0x019d, B:98:0x01b6, B:100:0x01bc, B:103:0x01c8, B:106:0x01ce, B:112:0x01d6, B:114:0x01db, B:115:0x020f, B:117:0x0215, B:120:0x0221, B:123:0x0227, B:129:0x022f, B:134:0x0236, B:147:0x002d), top: B:2:0x000c }] */
    @Override // com.bytedance.ies.bullet.service.base.IPrefetchService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prefetch(Uri schema) {
        String authority;
        boolean z;
        String queryParameter;
        boolean z2;
        String queryParameter2;
        List split$default;
        Intrinsics.checkNotNullParameter(schema, "schema");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String authority2 = schema.getAuthority();
            if (authority2 == null || (split$default = StringsKt.split$default(authority2, new String[]{RomVersionParamHelper.SEPARATOR}, false, 0, 6, (Object) null)) == null || (authority = (String) CollectionsKt.firstOrNull(split$default)) == null) {
                authority = schema.getAuthority();
            }
            String str = null;
            if (authority != null) {
                int hashCode = authority.hashCode();
                if (hashCode != -1772600516) {
                    if (hashCode != -1377934078) {
                        if (hashCode == 1224424441 && authority.equals("webview") && (queryParameter2 = schema.getQueryParameter("url")) != null) {
                            Uri.Builder buildUpon = Uri.parse(queryParameter2).buildUpon();
                            Set<String> queryParameterNames = schema.getQueryParameterNames();
                            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "schema.queryParameterNames");
                            for (String str2 : queryParameterNames) {
                                if (!Intrinsics.areEqual(str2, "url")) {
                                    buildUpon.appendQueryParameter(str2, schema.getQueryParameter(str2));
                                }
                            }
                            str = buildUpon.toString();
                        }
                    } else if (authority.equals("bullet") && (queryParameter = schema.getQueryParameter("url")) != null) {
                        if (StringsKt.startsWith$default(queryParameter, "lynxview", false, 2, (Object) null)) {
                            Uri parse = Uri.parse(queryParameter);
                            String queryParameter3 = parse.getQueryParameter("channel");
                            String queryParameter4 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
                            String str3 = queryParameter3;
                            if (str3 != null && str3.length() != 0) {
                                z2 = false;
                                if (z2) {
                                    String str4 = queryParameter4;
                                    if (str4 == null || str4.length() == 0) {
                                        Intrinsics.checkNotNullExpressionValue(parse, "uri");
                                        String cDN$default = ExtKt.getCDN$default(parse, null, 1, null);
                                        if (cDN$default != null) {
                                            Uri.Builder buildUpon2 = Uri.parse(cDN$default).buildUpon();
                                            Set<String> queryParameterNames2 = parse.getQueryParameterNames();
                                            Intrinsics.checkNotNullExpressionValue(queryParameterNames2, "uri.queryParameterNames");
                                            for (String str5 : queryParameterNames2) {
                                                if (!Intrinsics.areEqual(str5, SchemaConstants.QUERY_KEY_SURL) && !Intrinsics.areEqual(str5, "url")) {
                                                    buildUpon2.appendQueryParameter(str5, parse.getQueryParameter(str5));
                                                }
                                            }
                                            str = buildUpon2.toString();
                                        }
                                    }
                                }
                                Uri.Builder buildUpon3 = parse.buildUpon();
                                buildUpon3.authority(ErrorType.PREFETCH).path(parse.getHost() + parse.getPath());
                                str = buildUpon3.toString();
                            }
                            z2 = true;
                            if (z2) {
                            }
                            Uri.Builder buildUpon32 = parse.buildUpon();
                            buildUpon32.authority(ErrorType.PREFETCH).path(parse.getHost() + parse.getPath());
                            str = buildUpon32.toString();
                        } else if (StringsKt.startsWith$default(queryParameter, "http", false, 2, (Object) null) || StringsKt.startsWith$default(queryParameter, "https", false, 2, (Object) null)) {
                            str = queryParameter;
                        }
                    }
                } else if (authority.equals("lynxview")) {
                    String queryParameter5 = schema.getQueryParameter("channel");
                    String queryParameter6 = schema.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
                    String str6 = queryParameter5;
                    if (str6 != null && str6.length() != 0) {
                        z = false;
                        if (z) {
                            String str7 = queryParameter6;
                            if (str7 == null || str7.length() == 0) {
                                Uri.Builder buildUpon4 = Uri.parse(ExtKt.getCDN$default(schema, null, 1, null)).buildUpon();
                                Set<String> queryParameterNames3 = schema.getQueryParameterNames();
                                Intrinsics.checkNotNullExpressionValue(queryParameterNames3, "schema.queryParameterNames");
                                for (String str8 : queryParameterNames3) {
                                    if (!Intrinsics.areEqual(str8, SchemaConstants.QUERY_KEY_SURL) && !Intrinsics.areEqual(str8, "url")) {
                                        buildUpon4.appendQueryParameter(str8, schema.getQueryParameter(str8));
                                    }
                                }
                                str = buildUpon4.toString();
                            }
                        }
                        Uri.Builder builder = new Uri.Builder();
                        builder.scheme("lynxview").authority(ErrorType.PREFETCH).path(queryParameter5 + '/' + queryParameter6);
                        Set<String> queryParameterNames4 = schema.getQueryParameterNames();
                        Intrinsics.checkNotNullExpressionValue(queryParameterNames4, "schema.queryParameterNames");
                        for (String str9 : queryParameterNames4) {
                            if (!Intrinsics.areEqual(str9, "channel") && !Intrinsics.areEqual(str9, SchemaConstants.QUERY_KEY_BUNDLE)) {
                                builder.appendQueryParameter(str9, schema.getQueryParameter(str9));
                            }
                        }
                        str = builder.toString();
                    }
                    z = true;
                    if (z) {
                    }
                    Uri.Builder builder2 = new Uri.Builder();
                    builder2.scheme("lynxview").authority(ErrorType.PREFETCH).path(queryParameter5 + '/' + queryParameter6);
                    Set<String> queryParameterNames42 = schema.getQueryParameterNames();
                    Intrinsics.checkNotNullExpressionValue(queryParameterNames42, "schema.queryParameterNames");
                    while (r3.hasNext()) {
                    }
                    str = builder2.toString();
                }
            }
            IPrefetchProcessor processorByUrl = PrefetchProcessorManager.INSTANCE.getProcessorByUrl(str);
            if (processorByUrl == null) {
                try {
                    processorByUrl = this.prefetchProcessor;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return;
                }
            }
            processorByUrl.prefetch(str);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "start prefetch:" + str + ", with time cost:" + (System.currentTimeMillis() - currentTimeMillis), null, null, 6, null);
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchService
    public void prefetchForRouter(Uri schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        this.routerUriSet.add(schema);
        prefetch(schema);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchService
    public void prefetchForView(Uri schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        if (this.routerUriSet.remove(schema)) {
            return;
        }
        prefetch(schema);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchService
    public JSONObject getCacheByScheme(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        JSONObject cacheFromPrefetch = getCacheFromPrefetch(url);
        return cacheFromPrefetch != null ? cacheFromPrefetch : getLocalCacheByUrl(String.valueOf(url));
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchService
    public Collection<PrefetchV2Data> getCacheBySchemeV2(Uri scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return CollectionsKt.emptyList();
    }

    public final JSONObject getLocalCacheByUrl(String url) {
        LocalCacheProcessor localCacheProcessor;
        Intrinsics.checkNotNullParameter(url, "url");
        if ((url.length() == 0) || (localCacheProcessor = this.localCacheProcessor) == null) {
            return null;
        }
        return localCacheProcessor.handleKey(url);
    }

    public final JSONObject getCacheFromPrefetch(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        JSONObject jSONObject = null;
        if (!Intrinsics.areEqual(url.getScheme(), "lynxview")) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("lynxview").authority(ErrorType.PREFETCH).path(url.getAuthority() + url.getPath());
        Set<String> queryParameterNames = url.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "url.queryParameterNames");
        for (String str : queryParameterNames) {
            builder.appendQueryParameter(str, url.getQueryParameter(str));
        }
        String builder2 = builder.toString();
        Intrinsics.checkNotNullExpressionValue(builder2, "Builder().apply {\n      …   }\n        }.toString()");
        IPrefetchProcessor processorByUrl = PrefetchProcessorManager.INSTANCE.getProcessorByUrl(builder2);
        if (processorByUrl == null) {
            processorByUrl = this.prefetchProcessor;
        }
        List<PrefetchProcess> cacheByScheme = processorByUrl.getCacheByScheme(builder2);
        if (cacheByScheme != null) {
            for (PrefetchProcess prefetchProcess : cacheByScheme) {
                if (prefetchProcess.getResponse() != null) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    String url2 = prefetchProcess.getRequest().getUrl();
                    INetworkExecutor.HttpResponse response = prefetchProcess.getResponse();
                    Intrinsics.checkNotNull(response);
                    jSONObject.put(url2, response.getFormattedJSONObject(false).getJSONObject("raw"));
                }
            }
        }
        return jSONObject;
    }
}
