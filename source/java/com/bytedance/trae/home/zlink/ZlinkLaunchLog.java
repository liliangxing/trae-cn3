package com.bytedance.trae.home.zlink;

import android.net.Uri;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.bytedance.ug.sdk.deeplink.LaunchLogManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ZlinkLaunchLog.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;", "", "<init>", "()V", "TAG", "", "reportFromUri", "", TimonPipeline.KEY_SOURCE, "uri", "Landroid/net/Uri;", "reportFromSchema", "schema", "reportFromClipboard", "decodedSchema", "fromDevicePrint", "", "detectLinkType", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ZlinkLaunchLog {
    public static final int $stable = 0;
    public static final ZlinkLaunchLog INSTANCE = new ZlinkLaunchLog();
    private static final String TAG = "ZlinkLaunchLog";

    private ZlinkLaunchLog() {
    }

    public final void reportFromUri(String source, Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Object obj;
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        try {
            LaunchLogManager.getInstance().reportLaunchLogEvent(source, uri, (String) null, MapsKt.mapOf(new Pair[]{TuplesKt.to("link_type", detectLinkType(source, uri)), TuplesKt.to(Constant.KEY_CHANNEL, AppHost.INSTANCE.getBuildChannel())}));
        } catch (Exception e) {
            TraeLogUtil.INSTANCE.w(TAG, "reportLaunchLogEvent to Zlink failed", e);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TimonPipeline.KEY_SOURCE, source);
        if (uri == null || (str = uri.getQueryParameter("gd_label")) == null) {
            str = "";
        }
        jSONObject.put("gd_label", str);
        if (uri == null || (str2 = uri.getQueryParameter("item_id")) == null) {
            str2 = "";
        }
        jSONObject.put("item_id", str2);
        jSONObject.put("link_type", INSTANCE.detectLinkType(source, uri));
        if (uri == null || (str3 = uri.getScheme()) == null) {
            str3 = "";
        }
        jSONObject.put("scheme", str3);
        if (uri == null || (str4 = uri.getHost()) == null) {
            str4 = "";
        }
        jSONObject.put(PermissionConfigParser.WEBCAST_HOST_NAMESPACE, str4);
        if (uri == null || (str5 = uri.getPath()) == null) {
            str5 = "";
        }
        jSONObject.put("path", str5);
        if (uri == null || (str6 = uri.getQuery()) == null) {
            str6 = "";
        }
        jSONObject.put("query", str6);
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(IApplog.INSTANCE.getDeviceId());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        jSONObject.put("device_id", Result.isFailure-impl(obj) ? "" : obj);
        jSONObject.put(Constant.KEY_CHANNEL, AppHost.INSTANCE.getBuildChannel());
        TraeLogUtil.INSTANCE.i(TAG, "launch_log: " + jSONObject);
        try {
            IApplog.INSTANCE.reportEvent("launch_log", jSONObject);
        } catch (Exception e2) {
            TraeLogUtil.INSTANCE.w(TAG, "reportEvent to AppLog failed", e2);
        }
    }

    public final void reportFromSchema(String schema) {
        Object obj;
        String str = schema;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            ZlinkLaunchLog zlinkLaunchLog = this;
            obj = Result.constructor-impl(Uri.parse(schema));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        reportFromUri("sdk_schema", (Uri) obj);
    }

    public final void reportFromClipboard(String decodedSchema, boolean fromDevicePrint) {
        Object obj;
        Intrinsics.checkNotNullParameter(decodedSchema, "decodedSchema");
        try {
            Result.Companion companion = Result.Companion;
            ZlinkLaunchLog zlinkLaunchLog = this;
            obj = Result.constructor-impl(Uri.parse(decodedSchema));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        reportFromUri(fromDevicePrint ? "clipboard_device_print" : "clipboard", (Uri) obj);
    }

    private final String detectLinkType(String source, Uri uri) {
        if (StringsKt.startsWith$default(source, "clipboard", false, 2, (Object) null)) {
            return "clipboard";
        }
        if (!Intrinsics.areEqual(uri != null ? uri.getScheme() : null, "https")) {
            if (!Intrinsics.areEqual(uri != null ? uri.getScheme() : null, "http")) {
                String scheme = uri != null ? uri.getScheme() : null;
                return !(scheme == null || scheme.length() == 0) ? NewTaskTracker.EnterFrom.DEEPLINK : "unknown";
            }
        }
        return "applink";
    }
}
