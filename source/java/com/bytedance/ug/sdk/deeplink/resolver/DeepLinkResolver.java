package com.bytedance.ug.sdk.deeplink.resolver;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CBDInterfaceResolveUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.UriCacheHandler;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.bytedance.ug.sdk.deeplink.utils.UGLogger;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DeepLinkResolver implements IResolver {
    private static final int LINK_TYPE = 1;

    @Override // com.bytedance.ug.sdk.deeplink.resolver.IResolver
    public String tag() {
        return "DeepLinkResolver";
    }

    public static boolean isSingleScheme(Uri uri) {
        String str;
        if (uri == null) {
            return false;
        }
        try {
            str = uri.getQueryParameter(CommonConstants.ZLINK);
        } catch (Throwable th) {
            th.printStackTrace();
            str = null;
        }
        return !TextUtils.isEmpty(str);
    }

    public static boolean isMultiScheme(Uri uri) {
        if (uri == null) {
            return false;
        }
        return CommonConstants.ZLINK.equals(uri.getHost());
    }

    @Override // com.bytedance.ug.sdk.deeplink.resolver.IResolver
    public boolean isSelf(Uri uri) {
        return isMultiScheme(uri) || isSingleScheme(uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    @Override // com.bytedance.ug.sdk.deeplink.resolver.IResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void consume(Context context, Uri uri, boolean z, UGLogger.LogContext logContext) {
        String str;
        if (uri == null) {
            return;
        }
        GlobalContext.INSTANCE.setCallUri(uri, true);
        UriCacheHandler.cacheScheme(uri);
        UGZlinkLogger.onLinkInvokeEnd(1, uri.toString(), logContext);
        if (!isMultiScheme(uri)) {
            Logger.m449i(tag(), "非schema新方案");
            return;
        }
        String str2 = null;
        try {
            str = uri.getQueryParameter(CommonConstants.ZLINK_TOKEN);
        } catch (Exception e) {
            e = e;
            str = null;
        }
        try {
            str2 = uri.getQueryParameter(CommonConstants.KEY_DEFAULT_SCHEME);
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (TextUtils.isEmpty(str)) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            requestRemoteSchema(str, str2);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
            if (zlinkDepend != null) {
                Logger.m446d(tag(), "host deal result= " + zlinkDepend.dealWithSchema(str2));
                return;
            }
            return;
        }
        Logger.m447e(tag(), "please check!!! zLinkToken为空，兜底schema为空");
    }

    private void requestRemoteSchema(final String str, final String str2) {
        final IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend == null) {
            Logger.m447e(tag(), "unbelievable!!! IZlinkDepend is null");
        } else {
            ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.resolver.DeepLinkResolver.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    final String parseZLinkToken = CBDInterfaceResolveUtils.parseZLinkToken(str, jSONObject);
                    EventUtil.sendTokenVerifyEvent(jSONObject);
                    if (TextUtils.isEmpty(parseZLinkToken)) {
                        parseZLinkToken = str2;
                    }
                    Logger.m449i(DeepLinkResolver.this.tag(), "finalSchema: " + parseZLinkToken);
                    if (TextUtils.isEmpty(parseZLinkToken)) {
                        return;
                    }
                    ThreadUtils.runInMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.resolver.DeepLinkResolver.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.m446d(DeepLinkResolver.this.tag(), "host deal result= " + zlinkDepend.dealWithSchema(parseZLinkToken));
                        }
                    });
                }
            });
        }
    }
}
