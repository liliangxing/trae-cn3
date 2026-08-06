package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.Forest;
import com.bytedance.forest.interceptor.ForestMonitor;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestPreloadMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J>\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000ej\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0017J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestPreloadMonitor;", "Lcom/bytedance/forest/interceptor/ForestMonitor;", "()V", "listeners", "Lcom/bytedance/ies/bullet/forest/ForestContainerCache;", "", "Lcom/bytedance/ies/bullet/forest/ForestPreloadOperation;", "clear", "", "containerId", "listen", "requestInfo", "Lcom/bytedance/ies/bullet/forest/ForestRequestInfo;", "callback", "Lkotlin/Function2;", "Lcom/bytedance/forest/model/Response;", "Lcom/bytedance/ies/bullet/forest/ForestPreloadCallback;", "forest", "Lcom/bytedance/forest/Forest;", "onLoadFinished", "response", "onLoadStart", "url", "requestParams", "Lcom/bytedance/forest/model/RequestParams;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestPreloadMonitor implements ForestMonitor {
    private final ForestContainerCache<String, ForestPreloadOperation> listeners = new ForestContainerCache<>();

    public void onLoadStart(String url, RequestParams requestParams) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
    }

    public final void listen(String containerId, ForestRequestInfo requestInfo, Function2<? super Response, ? super ForestRequestInfo, Unit> callback, Forest forest) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(forest, "forest");
        this.listeners.putToCache(containerId, requestInfo.generateForestUrl(forest), new ForestPreloadOperation(callback, requestInfo));
    }

    public final void clear(String containerId) {
        this.listeners.clear(containerId);
    }

    public void onLoadFinished(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isPreloaded()) {
            Response response2 = response.isSucceed() && response.getRequest().getScene() == Scene.LYNX_IMAGE && LoaderUtils.INSTANCE.isNotNullOrEmpty(response.getFilePath()) ? response : null;
            if (response2 != null) {
                String key = new ForestPreloadKey(response.getRequest().getOriginUrl()).getKey();
                RedirectManager redirectManager = RedirectManager.INSTANCE;
                RedirectManager redirectManager2 = RedirectManager.INSTANCE;
                String filePath = response2.getFilePath();
                Intrinsics.checkNotNull(filePath);
                ResourceFrom from = response.getFrom();
                if (!(from != ResourceFrom.MEMORY)) {
                    from = null;
                }
                if (from == null) {
                    from = response.getOriginFrom();
                }
                redirectManager.putRedirectPath(key, redirectManager2.wrapRedirectPath(filePath, from));
            }
            Object obj = response.getRequest().getCustomParams().get("rl_container_uuid");
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                str = response.getRequest().getGroupId();
            }
            ForestPreloadOperation fetchCache = this.listeners.fetchCache(str, response.getRequest().getOriginUrl());
            if (fetchCache != null) {
                fetchCache.getCallback().invoke(response, fetchCache.getRequestInfo());
            }
        }
    }
}
