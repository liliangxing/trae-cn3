package com.bytedance.trae.home.zlink;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.privacy.PrivacyManager;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.ug.sdk.deeplink.CallBackForAppLink;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;
import com.bytedance.ug.sdk.deeplink.interfaces.IClipboard;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ZlinkSetup.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/zlink/ZlinkSetup;", "", "<init>", "()V", "TAG", "", "fetchExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "parseUrl", "Lkotlin/Pair;", IWeixinService.ResponseConstants.URL, "toHeaderList", "", "Lcom/bytedance/retrofit2/client/Header;", "headers", "", "buildDependAbility", "Lcom/bytedance/ug/sdk/deeplink/ZlinkDependAbility;", "application", "Landroid/app/Application;", "ZlinkNetApi", "ZlinkDependImpl", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ZlinkSetup {
    private static final String TAG = "ZlinkSetup";
    public static final ZlinkSetup INSTANCE = new ZlinkSetup();
    private static final ExecutorService fetchExecutor = Executors.newSingleThreadExecutor();
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ZlinkSetup.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H'J4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H'¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkNetApi;", "", ApiRequest.METHOD_GET, "Lcom/bytedance/retrofit2/Call;", "", "path", "headers", "", "Lcom/bytedance/retrofit2/client/Header;", ApiRequest.METHOD_POST, "body", "Lcom/bytedance/retrofit2/mime/TypedByteArray;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface ZlinkNetApi {
        @GET
        Call<String> get(@Url String path, @HeaderList List<Header> headers);

        @POST
        Call<String> post(@Url String path, @Body TypedByteArray body, @HeaderList List<Header> headers);
    }

    private ZlinkSetup() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, String> parseUrl(String url) {
        Uri parse = Uri.parse(url);
        String scheme = parse.getScheme();
        if (scheme == null) {
            scheme = "https";
        }
        String host = parse.getHost();
        if (host == null) {
            return TuplesKt.to(url, "/");
        }
        int port = parse.getPort();
        StringBuilder sb = new StringBuilder();
        sb.append(scheme).append("://").append(host);
        if (port > 0) {
            sb.append(':').append(port);
        }
        sb.append('/');
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        String encodedPath = parse.getEncodedPath();
        sb3.append(encodedPath != null ? encodedPath : "/");
        String encodedQuery = parse.getEncodedQuery();
        String str = encodedQuery;
        if (!(str == null || str.length() == 0)) {
            sb3.append('?').append(encodedQuery);
        }
        return TuplesKt.to(sb2, sb3.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Header> toHeaderList(Map<String, String> headers) {
        if (headers == null || headers.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(headers.size());
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public final ZlinkDependAbility buildDependAbility(final Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        ZlinkDependImpl zlinkDependImpl = new ZlinkDependImpl(application);
        ZlinkSetup$buildDependAbility$network$1 zlinkSetup$buildDependAbility$network$1 = new ZlinkSetup$buildDependAbility$network$1();
        ZlinkDependAbility build = new ZlinkDependAbility.Builder().withApplication(application).withZlinkDepend(zlinkDependImpl).withService(INetwork.class, zlinkSetup$buildDependAbility$network$1).withService(IClipboard.class, new TimonClipboardImpl()).withCallBackForAppLink(new CallBackForAppLink() { // from class: com.bytedance.trae.home.zlink.ZlinkSetup$buildDependAbility$appLinkCallback$1
            private volatile String lastHandledScheme;
            private long lastHandledTime;

            public boolean dealWithSchema(String schema) {
                Object obj;
                Log.i("ZlinkSetup", "dealWithSchema from AppLink: " + schema);
                String str = schema;
                if (str == null || str.length() == 0) {
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (Intrinsics.areEqual(schema, this.lastHandledScheme) && currentTimeMillis - this.lastHandledTime < 3000) {
                    return true;
                }
                this.lastHandledScheme = schema;
                this.lastHandledTime = currentTimeMillis;
                try {
                    Result.Companion companion = Result.Companion;
                    ZlinkSetup$buildDependAbility$appLinkCallback$1 zlinkSetup$buildDependAbility$appLinkCallback$1 = this;
                    obj = Result.constructor-impl(Uri.parse(schema));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                Uri uri = (Uri) obj;
                if (uri == null) {
                    return true;
                }
                ZlinkLaunchLog.INSTANCE.reportFromSchema(schema);
                Intent intent = new Intent(application, (Class<?>) ZlinkLinkEntryActivity.class);
                intent.setFlags(268435456);
                intent.setData(uri);
                intent.putExtra(ZlinkLinkEntryActivity.EXTRA_SOURCE, "applink");
                application.startActivity(intent);
                return true;
            }

            public List<String> getHostList() {
                String applink_host = ZlinkConfig.INSTANCE.getAPPLINK_HOST();
                return applink_host.length() > 0 ? CollectionsKt.listOf(applink_host) : CollectionsKt.emptyList();
            }
        }).withEnableClipboardOutside(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* compiled from: ZlinkSetup.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J.\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\nH\u0016J0\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u00112\b\u0010%\u001a\u0004\u0018\u00010\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010'\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/trae/home/zlink/ZlinkSetup$ZlinkDependImpl;", "Lcom/bytedance/ug/sdk/deeplink/IZlinkDepend;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getAppId", "", "getDeviceId", "getUpdateVersionCode", "", "isConfirmedPrivacy", "", "onEvent", "", "eventName", "jsonObject", "Lorg/json/JSONObject;", MessagePart.TYPE_LOG, "level", "", "tag", "msg", "throwable", "", "getSchemeList", "", "getDeepLinkActivities", "dealWithSchema", "schema", "dealWithClipboard", "isCheckedClipboard", "fromDevicePrint", "delayMillis", "monitorEvent", "serviceName", "category", "metric", "logExtr", "settingsRefactorEnable", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ZlinkDependImpl implements IZlinkDepend {
        private final Application application;

        public long delayMillis() {
            return 500L;
        }

        public boolean settingsRefactorEnable() {
            return true;
        }

        public ZlinkDependImpl(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            this.application = application;
        }

        public String getAppId() {
            return ZlinkConfig.INSTANCE.getAPP_ID();
        }

        public String getDeviceId() {
            try {
                return IApplog.INSTANCE.getDeviceId();
            } catch (Exception unused) {
                return "";
            }
        }

        public long getUpdateVersionCode() {
            return AppHost.INSTANCE.getUpdateVersionCode();
        }

        public boolean isConfirmedPrivacy() {
            return PrivacyManager.INSTANCE.checkAgreed();
        }

        public void onEvent(String eventName, JSONObject jsonObject) {
            Log.i(ZlinkSetup.TAG, "onEvent name=" + eventName + ", data=" + jsonObject);
            if (eventName != null) {
                try {
                    IApplog.INSTANCE.reportEvent(eventName, jsonObject);
                } catch (Exception e) {
                    Log.w(ZlinkSetup.TAG, "reportEvent failed", e);
                }
            }
        }

        public void log(int level, String tag, String msg, Throwable throwable) {
            if (tag == null) {
                tag = ZlinkSetup.TAG;
            }
            if (msg == null) {
                msg = "";
            }
            Log.println(level, tag, msg);
        }

        public List<String> getSchemeList() {
            return CollectionsKt.listOf(ZlinkConfig.INSTANCE.getSCHEME());
        }

        public List<String> getDeepLinkActivities() {
            return CollectionsKt.listOf("com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity");
        }

        public boolean dealWithSchema(String schema) {
            Log.i(ZlinkSetup.TAG, "dealWithSchema=" + schema);
            ZlinkLaunchLog.INSTANCE.reportFromSchema(schema);
            return true;
        }

        public boolean dealWithClipboard(boolean isCheckedClipboard, String schema, boolean fromDevicePrint) {
            Log.i(ZlinkSetup.TAG, "dealWithClipboard, isCheckedClipboard=" + isCheckedClipboard + ", fromDevicePrint=" + fromDevicePrint + ", raw=" + schema);
            String str = schema;
            if (str == null || str.length() == 0) {
                return false;
            }
            try {
                byte[] decode = Base64.decode(schema, 2);
                Intrinsics.checkNotNull(decode);
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
                schema = new String(decode, forName);
            } catch (IllegalArgumentException e) {
                Log.w(ZlinkSetup.TAG, "Clipboard content is not base64, use raw", e);
            }
            if (!StringsKt.startsWith$default(schema, ZlinkConfig.INSTANCE.getSCHEME() + "://", false, 2, (Object) null)) {
                Log.i(ZlinkSetup.TAG, "Clipboard content does not match scheme, ignore");
                return false;
            }
            ZlinkLaunchLog.INSTANCE.reportFromClipboard(schema, fromDevicePrint);
            Uri parse = Uri.parse(schema);
            String str2 = fromDevicePrint ? "clipboard_device_print" : "clipboard";
            Intent intent = new Intent(this.application, (Class<?>) ZlinkLinkEntryActivity.class);
            intent.setFlags(268435456);
            intent.setData(parse);
            intent.putExtra(ZlinkLinkEntryActivity.EXTRA_SOURCE, str2);
            this.application.startActivity(intent);
            ZlinkClipboardUtil.INSTANCE.clearClipboard(this.application);
            return false;
        }

        public void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject logExtr) {
            Log.i(ZlinkSetup.TAG, "monitorEvent service=" + serviceName + ", category=" + category + ", metric=" + metric);
            try {
                JSONObject jSONObject = new JSONObject();
                if (serviceName == null) {
                    serviceName = "";
                }
                jSONObject.put("service_name", serviceName);
                if (category != null) {
                    jSONObject.put("category", category);
                }
                if (metric != null) {
                    jSONObject.put("metric", metric);
                }
                if (logExtr != null) {
                    jSONObject.put("log_extr", logExtr);
                }
                IApplog.INSTANCE.reportEvent("zlink_monitor", jSONObject);
            } catch (Exception e) {
                Log.w(ZlinkSetup.TAG, "monitorEvent report failed", e);
            }
        }
    }
}
