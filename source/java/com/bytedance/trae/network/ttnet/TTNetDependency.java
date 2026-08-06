package com.bytedance.trae.network.ttnet;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.util.SpringNetworkStrategyManager;
import com.bytedance.ttnet.ITTNetDepend;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: TTNetExt.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0016J#\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0 H\u0016¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0010H\u0016J \u0010%\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rH\u0016J \u0010(\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001aH\u0016J&\u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0014\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0002\b\u0003\u0018\u00010+H\u0016J\u0013\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0 H\u0016¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\rH\u0016J\n\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\b\u00100\u001a\u00020\rH\u0016J\u0016\u00101\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010+H\u0016J\n\u00102\u001a\u0004\u0018\u00010\rH\u0016J\b\u00103\u001a\u00020\nH\u0016J\u001c\u00104\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u000105j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`6H\u0016J\b\u00107\u001a\u00020\u001aH\u0016J\u0014\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0+H\u0016¨\u00069"}, d2 = {"Lcom/bytedance/trae/network/ttnet/TTNetDependency;", "Lcom/bytedance/ttnet/ITTNetDepend;", "<init>", "()V", "getContext", "Landroid/content/Context;", "isCronetPluginInstalled", "", "isPrivateApiAccessEnabled", "mobOnEvent", "", "context", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "labelName", "extraJson", "Lorg/json/JSONObject;", "onNetConfigUpdate", "config", "localData", "onAppConfigUpdated", "ext_json", "onShareCookieConfigUpdated", "shareCookieHosts", "executeGet", "maxLength", "", "url", "checkHttpRequestException", "tr", "", "remoteIp", "", "(Ljava/lang/Throwable;[Ljava/lang/String;)I", "monitorLogSend", "logType", "json", "getProviderString", "key", "defaultValue", "getProviderInt", "saveMapToProvider", "map", "", "getConfigServers", "()[Ljava/lang/String;", "getHostSuffix", "getApiIHostPrefix", "getCdnHostSuffix", "getHostReverseMap", "getShareCookieMainDomain", "onColdStartFinish", "getCookieFlushPathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAppId", "getTTNetServiceDomainMap", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TTNetDependency implements ITTNetDepend {
    public static final TTNetDependency INSTANCE = new TTNetDependency();

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int checkHttpRequestException(Throwable tr, String[] remoteIp) {
        Intrinsics.checkNotNullParameter(tr, "tr");
        Intrinsics.checkNotNullParameter(remoteIp, "remoteIp");
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String executeGet(int maxLength, String url) throws Exception {
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getApiIHostPrefix() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getCdnHostSuffix() {
        return "byteimg.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public ArrayList<String> getCookieFlushPathList() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map<String, String> getHostReverseMap() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getHostSuffix() {
        return "www.trae.cn";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getProviderInt(Context context, String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getProviderString(Context context, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return "";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getShareCookieMainDomain() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isCronetPluginInstalled() {
        return true;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isPrivateApiAccessEnabled() {
        return true;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void mobOnEvent(Context context, String eventName, String labelName, JSONObject extraJson) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(labelName, "labelName");
        Intrinsics.checkNotNullParameter(extraJson, "extraJson");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onColdStartFinish() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onNetConfigUpdate(JSONObject config, boolean localData) {
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void saveMapToProvider(Context context, Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private TTNetDependency() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Context getContext() {
        return AppHost.Companion.getApplication();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onAppConfigUpdated(Context context, JSONObject ext_json) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ext_json, "ext_json");
        SpringNetworkStrategyManager.INSTANCE.startAppState(SpringNetworkStrategyManager.SpringNetworkStrategy.CUSTOMER_SECOND_STRATEGY);
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onShareCookieConfigUpdated(String shareCookieHosts) {
        String str = shareCookieHosts;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(shareCookieHosts);
        List<String> split$default = StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null);
        if (!split$default.isEmpty()) {
            for (String str2 : split$default) {
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.length() > 1 && StringsKt.startsWith$default(str2, LibrarianImpl.Constants.DOT, false, 2, (Object) null)) {
                        String substring = str2.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        arrayList.add(substring);
                    } else {
                        arrayList.add(str2);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void monitorLogSend(String logType, JSONObject json) {
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullParameter(json, "json");
        ApmAgent.monitorCommonLog(logType, json);
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String[] getConfigServers() {
        return TTNetExt.INSTANCE.getConfigServersArray();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getAppId() {
        return AppHost.Companion.getAppId();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map<String, String> getTTNetServiceDomainMap() {
        return TTNetExt.INSTANCE.getServiceDomainMap();
    }
}
