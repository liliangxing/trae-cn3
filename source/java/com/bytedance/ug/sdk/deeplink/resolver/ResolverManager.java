package com.bytedance.ug.sdk.deeplink.resolver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.IZlinkInitCallback;
import com.bytedance.ug.sdk.deeplink.UgServiceManager;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import com.bytedance.ug.sdk.deeplink.api.internal.IFissionInternalApi;
import com.bytedance.ug.sdk.deeplink.callback.CallbackManager;
import com.bytedance.ug.sdk.deeplink.utils.CommonUtils;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.UGLogger;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ResolverManager {
    private static final String TAG = "ResolverManager";
    private final HashMap<ResolverType, IResolver> resolverHashMap;

    private ResolverManager() {
        HashMap<ResolverType, IResolver> hashMap = new HashMap<>();
        this.resolverHashMap = hashMap;
        hashMap.put(ResolverType.TYPE_APP_LINK, new AppLinkResolver());
        hashMap.put(ResolverType.TYPE_DEEP_LINK, new DeepLinkResolver());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class InstanceHolder {
        private static final ResolverManager MANAGER = new ResolverManager();

        private InstanceHolder() {
        }
    }

    public static ResolverManager instance() {
        return InstanceHolder.MANAGER;
    }

    public IResolver getResolver(ResolverType resolverType) {
        return this.resolverHashMap.get(resolverType);
    }

    public void parseIntent(final Context context, Intent intent) {
        Logger.m449i(TAG, "parse intent");
        Uri data = intent != null ? intent.getData() : null;
        final UGLogger.LogContext logContext = new UGLogger.LogContext();
        UGZlinkLogger.onLinkParseStart(data, logContext);
        if (data == null) {
            return;
        }
        if (ZlinkApi.INSTANCE.isInited()) {
            doAfterDeepLinkInit(context, data, logContext);
        } else {
            final Uri parse = Uri.parse(data.toString());
            CallbackManager.addZlinkInitCallback(new IZlinkInitCallback() { // from class: com.bytedance.ug.sdk.deeplink.resolver.ResolverManager.1
                @Override // com.bytedance.ug.sdk.deeplink.IZlinkInitCallback
                public void onInitialized() {
                    CallbackManager.removeZlinkInitCallback(this);
                    Context context2 = context;
                    if ((context2 instanceof Activity) && CommonUtils.isInWhiteList((Activity) context2)) {
                        ResolverManager.this.doAfterDeepLinkInit(GlobalContext.INSTANCE.getApplication(), parse, logContext);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterDeepLinkInit(Context context, Uri uri, UGLogger.LogContext logContext) {
        if (uri == null) {
            return;
        }
        Iterator<Map.Entry<ResolverType, IResolver>> it = this.resolverHashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<ResolverType, IResolver> next = it.next();
            String resolverType = next.getKey().toString();
            IResolver value = next.getValue();
            if (value.isSelf(uri)) {
                Logger.m449i(TAG, "resolver by " + resolverType);
                value.consume(context, uri, true, logContext);
                break;
            }
        }
        IFissionInternalApi iFissionInternalApi = (IFissionInternalApi) UgServiceManager.INSTANCE.getInternalApi(IFissionInternalApi.class);
        if (iFissionInternalApi != null) {
            iFissionInternalApi.parseIntentForFission(uri);
        }
    }
}
