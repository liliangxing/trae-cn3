package com.bytedance.trae.hotfix;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.common.util.NetworkUtils;
import com.ss.android.common.util.ToolUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HotPatchConfig.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ&\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/hotfix/HotPatchConfig;", "", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "enable", "", "getApplication", "getUpdateVersionCode", "", "getAppId", "getDeviceId", "getChannel", "executePatchRequest", "maxSize", "", IWeixinService.ResponseConstants.URL, "localPatchInfoBytes", "", "contentType", "buildUrlParameters", "isMainProcess", "getRequestInterval", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class HotPatchConfig {
    public static final int $stable = 8;
    private final Application application;

    public final boolean enable() {
        return true;
    }

    public final long getRequestInterval() {
        return SubTaskUiState.LONG_RUNNING_THRESHOLD_MS;
    }

    public HotPatchConfig(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final String getUpdateVersionCode() {
        return String.valueOf(AppHost.INSTANCE.getUpdateVersionCode());
    }

    public final String getAppId() {
        return String.valueOf(AppHost.INSTANCE.getAppId());
    }

    public final String getDeviceId() {
        return IApplog.INSTANCE.getDeviceId();
    }

    public final String getChannel() {
        return AppHost.INSTANCE.getBuildChannel();
    }

    public final String executePatchRequest(int maxSize, String url, byte[] localPatchInfoBytes, String contentType) {
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        Intrinsics.checkNotNullParameter(localPatchInfoBytes, "localPatchInfoBytes");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        String executePost = NetworkUtils.executePost(maxSize, buildUrlParameters(url), localPatchInfoBytes, NetworkUtils.CompressType.GZIP, contentType);
        Intrinsics.checkNotNullExpressionValue(executePost, "executePost(...)");
        return executePost;
    }

    private final String buildUrlParameters(String url) {
        Uri parse = Uri.parse(url);
        Uri.Builder buildUpon = parse.buildUpon();
        Intrinsics.checkNotNullExpressionValue(buildUpon, "buildUpon(...)");
        if (parse.getQueryParameter("device_id") == null) {
            buildUpon.appendQueryParameter("device_id", getDeviceId());
        }
        if (parse.getQueryParameter(Constant.KEY_CHANNEL) == null) {
            buildUpon.appendQueryParameter(Constant.KEY_CHANNEL, getChannel());
        }
        if (parse.getQueryParameter(Constant.KEY_AID) == null) {
            buildUpon.appendQueryParameter(Constant.KEY_AID, getAppId());
        }
        buildUpon.appendQueryParameter("device_platform", "android").appendQueryParameter(Constant.KEY_OS_API, String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter(Constant.KEY_UPDATE_VERSION_CODE, getUpdateVersionCode());
        try {
            String str = Build.VERSION.RELEASE;
            if (str != null && str.length() > 10) {
                str = str.substring(0, 10);
                Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
            }
            buildUpon.appendQueryParameter(Constant.KEY_OS_VERSION, str);
        } catch (Exception e) {
            FLogger.INSTANCE.e("hot patch", e.getMessage(), e);
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    public final boolean isMainProcess() {
        return ToolUtils.isMainProcess(this.application);
    }
}
