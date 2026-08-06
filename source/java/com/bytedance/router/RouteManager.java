package com.bytedance.router;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.router.interceptor.IInterceptor;
import com.bytedance.router.interceptor.RewriteManager;
import com.bytedance.router.listener.error.ErrorHandler;
import com.bytedance.router.listener.error.ErrorType;
import com.bytedance.router.plugin.Plugin;
import com.bytedance.router.plugin.SupportPluginCallback;
import com.bytedance.router.route.BaseRoute;
import com.bytedance.router.route.IRoute;
import com.bytedance.router.route.RouteFactory;
import com.bytedance.router.util.Logger;
import com.bytedance.router.util.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RouteManager {
    private static final String ERRORINTERCEPT = "buildIntent时被拦截器拦截";
    private static final String ERRORNOTFOUND = "当前传入的path找不到目标类";
    private static final String ERRORPARAMMSG = "参数或者url有误";
    private Context mContext;
    private InterceptManager mInterceptManager;
    private List<Plugin> mPluginsList;
    private RewriteManager mRewriteManager;
    private RouteMapper mRouteMapper;
    private RoutesConfig mRoutesConfig;
    private SupportPluginCallback mSupportPluginCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SingleBuilder {
        public static RouteManager sInstance = new RouteManager();

        private SingleBuilder() {
        }
    }

    private RouteManager() {
        this.mRoutesConfig = RoutesConfig.defaultConfig();
        this.mRouteMapper = new RouteMapper();
        this.mInterceptManager = new InterceptManager();
        this.mRewriteManager = new RewriteManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final RouteManager getInstance() {
        return SingleBuilder.sInstance;
    }

    public Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(Context context) {
        this.mContext = context;
        this.mRouteMapper.init(context);
        this.mInterceptManager.addInterceptor(this.mRewriteManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteMapper getRouterMapper() {
        return this.mRouteMapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConfig(RoutesConfig routesConfig) {
        this.mRoutesConfig = routesConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addInterceptor(IInterceptor iInterceptor) {
        this.mInterceptManager.addInterceptor(iInterceptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRewriteMap(Map<String, String> map) {
        this.mRewriteManager.setRewriteMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putRewriteValue(String str, String str2) {
        this.mRewriteManager.addRewriteValue(str, str2);
    }

    public void open(Context context, RouteIntent routeIntent) {
        if (!checkLegality(routeIntent)) {
            ErrorHandler.noticeError(ErrorType.PARAMERROR, routeIntent, ERRORPARAMMSG);
            return;
        }
        if (this.mInterceptManager.processRouteIntent(context, routeIntent)) {
            return;
        }
        RouteIntent processRouteIntent = processRouteIntent(routeIntent);
        if (processRouteIntent == null) {
            ErrorHandler.noticeError(ErrorType.PARAMERROR, routeIntent, ERRORPARAMMSG);
            return;
        }
        String targetClass = this.mRouteMapper.getTargetClass(processRouteIntent.getUrl());
        if (TextUtils.isEmpty(targetClass)) {
            if (!loadPluginsSchemas(processRouteIntent.getUrl())) {
                Logger.m358w("RouteManager#open cannot find the routeUri with " + processRouteIntent.getUrl());
                ErrorHandler.noticeError(ErrorType.NOTFOUND, routeIntent, ERRORNOTFOUND);
                return;
            }
            targetClass = this.mRouteMapper.getTargetClass(processRouteIntent.getUrl());
        }
        if (TextUtils.isEmpty(targetClass)) {
            ErrorHandler.noticeError(ErrorType.NOTFOUND, routeIntent, ERRORNOTFOUND);
        }
        IRoute route = getRoute(processRouteIntent, targetClass);
        if (route == null) {
            Logger.m352e("RouteManager#Not support the route with url：" + processRouteIntent.getUrl());
            ErrorHandler.noticeError(ErrorType.PARAMERROR, routeIntent, ERRORPARAMMSG);
            return;
        }
        try {
            route.open(context);
        } catch (Exception e) {
            Logger.m352e("Please check the scheme and its mapping class!!!");
            e.printStackTrace();
            ErrorHandler.noticeError(ErrorType.EXCEPTION, routeIntent, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canOpen(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.m358w("SmartRoute#url is null!!!");
            return false;
        }
        if (!Util.isLegalUrl(str)) {
            Logger.m358w("SmartRoute#url is illegal and url is " + str);
            return false;
        }
        String realRouteUrl = Util.getRealRouteUrl(str);
        String rewriteUrl = this.mRewriteManager.getRewriteUrl(realRouteUrl);
        if (!TextUtils.isEmpty(rewriteUrl)) {
            realRouteUrl = rewriteUrl;
        }
        String scheme = Uri.parse(realRouteUrl).getScheme();
        if (TextUtils.isEmpty(scheme)) {
            scheme = Uri.parse(str).getScheme();
        }
        if (!this.mRoutesConfig.supportScheme(scheme)) {
            Logger.m358w("SmartRouter not supports this scheme: " + scheme);
            return false;
        }
        if (!this.mRoutesConfig.supportScheme(scheme)) {
            Logger.m358w("SmartRouter not supports this scheme: " + scheme);
            return false;
        }
        String targetClass = this.mRouteMapper.getTargetClass(realRouteUrl);
        if (TextUtils.isEmpty(targetClass) && loadPluginsSchemas(realRouteUrl)) {
            targetClass = this.mRouteMapper.getTargetClass(realRouteUrl);
        }
        return !TextUtils.isEmpty(targetClass) || this.mInterceptManager.whetherIntercept(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent buildIntent(Context context, RouteIntent routeIntent) {
        if (!checkLegality(routeIntent)) {
            ErrorHandler.noticeError(ErrorType.PARAMERROR, routeIntent, ERRORPARAMMSG);
            return null;
        }
        if (this.mInterceptManager.processRouteIntent(context, routeIntent)) {
            ErrorHandler.noticeError(ErrorType.INTERCEPT, routeIntent, ERRORINTERCEPT);
            return null;
        }
        RouteIntent processRouteIntent = processRouteIntent(routeIntent);
        if (processRouteIntent == null) {
            ErrorHandler.noticeError(ErrorType.PARAMERROR, routeIntent, ERRORPARAMMSG);
            return null;
        }
        String targetClass = this.mRouteMapper.getTargetClass(processRouteIntent.getUrl());
        if (TextUtils.isEmpty(targetClass)) {
            if (!loadPluginsSchemas(processRouteIntent.getUrl())) {
                Logger.m358w("RouteManager#buildIntent cannot find the routeUri with " + processRouteIntent.getUrl());
                ErrorHandler.noticeError(ErrorType.NOTFOUND, routeIntent, ERRORNOTFOUND);
                return null;
            }
            targetClass = this.mRouteMapper.getTargetClass(processRouteIntent.getUrl());
        }
        if (TextUtils.isEmpty(targetClass)) {
            ErrorHandler.noticeError(ErrorType.NOTFOUND, routeIntent, ERRORNOTFOUND);
            return null;
        }
        processRouteIntent.getExtra().setComponent(new ComponentName(context.getPackageName(), targetClass));
        return processRouteIntent.getExtra();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportPluginCallback(SupportPluginCallback supportPluginCallback) {
        this.mSupportPluginCallback = supportPluginCallback;
    }

    private RouteIntent processRouteIntent(RouteIntent routeIntent) {
        String url = routeIntent.getUrl();
        if (!Util.isLegalUrl(url)) {
            Logger.m352e("RouteManager#RouteIntent-outputUrl is illegal and url is : " + url);
            return null;
        }
        routeIntent.setUrl(Util.completeUrl(this.mRoutesConfig.getScheme(), url));
        Logger.m350d("RouteManager#processRouteIntent originUlr: " + routeIntent.getOriginUrl());
        Logger.m350d("RouteManager#processRouteIntent outputUlr: " + routeIntent.getUrl());
        return routeIntent;
    }

    private boolean checkLegality(RouteIntent routeIntent) {
        String url = routeIntent.getUrl();
        if (Util.isLegalUrl(url, this.mRoutesConfig)) {
            return true;
        }
        Logger.m352e("RouteManager#checkLegality originUrl is illegal: " + url + ". \n" + this.mRoutesConfig.toString());
        return false;
    }

    private IRoute getRoute(RouteIntent routeIntent, String str) {
        BaseRoute createRoute = RouteFactory.createRoute(routeIntent.getUrl(), str, this.mRoutesConfig);
        if (createRoute != null) {
            createRoute.init(routeIntent, this.mRouteMapper);
        }
        return createRoute;
    }

    private synchronized boolean loadPluginsSchemas(String str) {
        SupportPluginCallback supportPluginCallback = this.mSupportPluginCallback;
        boolean z = false;
        if (supportPluginCallback == null) {
            Logger.m358w("if you use urls in plugins, you must set SupportPluginCallback to support plugins.");
            return false;
        }
        if (this.mPluginsList == null) {
            this.mPluginsList = supportPluginCallback.initPlugins();
        }
        List<Plugin> list = this.mPluginsList;
        if (list != null && list.size() != 0) {
            Iterator<Plugin> it = this.mPluginsList.iterator();
            while (it.hasNext()) {
                Plugin next = it.next();
                if (next.containsUrl(str)) {
                    this.mSupportPluginCallback.loadPlugin(next, str);
                    z = this.mRouteMapper.loadModuleMapping(next.getName(), this.mSupportPluginCallback.getClassLoader(next.getPackageName()));
                    it.remove();
                }
            }
            return z;
        }
        return false;
    }
}
