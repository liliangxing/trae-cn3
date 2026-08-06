package com.bytedance.router.route;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.RouteIntent;
import com.bytedance.router.RouteMapper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class BaseRoute implements IRoute {
    private RouteIntent mRouteIntent;
    private RouteMapper mRouteMapper;
    private Uri mUri;
    private String mUrl;

    public void init(RouteIntent routeIntent, RouteMapper routeMapper) {
        this.mRouteIntent = routeIntent;
        String url = routeIntent.getUrl();
        this.mUrl = url;
        this.mUri = Uri.parse(url);
        this.mRouteMapper = routeMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteIntent getRouteIntent() {
        return this.mRouteIntent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTargetClass() {
        return this.mRouteMapper.getTargetClass(this.mUrl);
    }

    @Override // com.bytedance.router.route.IRoute
    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.bytedance.router.route.IRoute
    public String getScheme() {
        return this.mUri.getScheme();
    }

    @Override // com.bytedance.router.route.IRoute
    public String getHost() {
        return this.mUri.getHost();
    }

    @Override // com.bytedance.router.route.IRoute
    public String getPath() {
        return this.mUri.getPath();
    }

    @Override // com.bytedance.router.route.IRoute
    public Bundle getParams() {
        if (this.mRouteIntent.getExtra() != null) {
            return this.mRouteIntent.getExtra().getExtras();
        }
        return new Bundle();
    }
}
