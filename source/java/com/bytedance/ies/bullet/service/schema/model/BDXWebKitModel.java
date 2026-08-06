package com.bytedance.ies.bullet.service.schema.model;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.model.BDWebKitModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXWebKitModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u000201X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001a\u00109\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001a\u0010<\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001a\u0010?\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001a\u0010B\u001a\u00020CX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u000201X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u00105R\u001a\u0010K\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\u001a\u0010N\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001a\u0010Q\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\u001a\u0010T\u001a\u000201X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00103\"\u0004\bV\u00105¨\u0006["}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/model/BDXWebKitModel;", "Lcom/bytedance/ies/bullet/service/sdk/model/BDWebKitModel;", "()V", "adBlock", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getAdBlock", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setAdBlock", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "appendCommonParams", "getAppendCommonParams", "setAppendCommonParams", "appendGlobalProps", "Lcom/bytedance/ies/bullet/service/sdk/param/StringListParam;", "getAppendGlobalProps", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringListParam;", "setAppendGlobalProps", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringListParam;)V", "autoPlayBgm", "getAutoPlayBgm", "setAutoPlayBgm", "bundleEnableAppCache", "getBundleEnableAppCache", "setBundleEnableAppCache", "bundleLoadNoCache", "getBundleLoadNoCache", "setBundleLoadNoCache", "compactMode", "getCompactMode", "setCompactMode", "disableAllLocations", "getDisableAllLocations", "setDisableAllLocations", "disableHardwareAccelerate", "getDisableHardwareAccelerate", "setDisableHardwareAccelerate", "disableSaveImage", "getDisableSaveImage", "setDisableSaveImage", "disableWebviewSelectMenus", "getDisableWebviewSelectMenus", "setDisableWebviewSelectMenus", "enableVideoLandscape", "getEnableVideoLandscape", "setEnableVideoLandscape", "enableWebviewSelectSearch", "getEnableWebviewSelectSearch", "setEnableWebviewSelectSearch", "headStr", "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "getHeadStr", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "setHeadStr", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;)V", "hideSystemVideoPoster", "getHideSystemVideoPoster", "setHideSystemVideoPoster", "ignoreCachePolicy", "getIgnoreCachePolicy", "setIgnoreCachePolicy", "interceptRequest", "getInterceptRequest", "setInterceptRequest", "needContainerId", "getNeedContainerId", "setNeedContainerId", "overScrollModel", "Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "getOverScrollModel", "()Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "setOverScrollModel", "(Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;)V", "secureLinkScene", "getSecureLinkScene", "setSecureLinkScene", "skipIntercept", "getSkipIntercept", "setSkipIntercept", "statusBar", "getStatusBar", "setStatusBar", "useWebviewTitle", "getUseWebviewTitle", "setUseWebviewTitle", "webBgColor", "getWebBgColor", "setWebBgColor", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDXWebKitModel extends BDWebKitModel {
    public BooleanParam adBlock;
    public BooleanParam appendCommonParams;
    public StringListParam appendGlobalProps;
    public BooleanParam autoPlayBgm;
    public BooleanParam bundleEnableAppCache;
    public BooleanParam bundleLoadNoCache;
    public BooleanParam compactMode;
    public BooleanParam disableAllLocations;
    public BooleanParam disableHardwareAccelerate;
    public BooleanParam disableSaveImage;
    public BooleanParam disableWebviewSelectMenus;
    public BooleanParam enableVideoLandscape;
    public BooleanParam enableWebviewSelectSearch;
    public StringParam headStr;
    public BooleanParam hideSystemVideoPoster;
    public BooleanParam ignoreCachePolicy;
    public BooleanParam interceptRequest;
    public BooleanParam needContainerId;
    public IntegerParam overScrollModel;
    public StringParam secureLinkScene;
    public BooleanParam skipIntercept;
    public BooleanParam statusBar;
    public BooleanParam useWebviewTitle;
    public StringParam webBgColor;

    public final BooleanParam getAdBlock() {
        BooleanParam booleanParam = this.adBlock;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adBlock");
        return null;
    }

    public final void setAdBlock(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.adBlock = booleanParam;
    }

    public final BooleanParam getAutoPlayBgm() {
        BooleanParam booleanParam = this.autoPlayBgm;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("autoPlayBgm");
        return null;
    }

    public final void setAutoPlayBgm(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.autoPlayBgm = booleanParam;
    }

    public final BooleanParam getDisableAllLocations() {
        BooleanParam booleanParam = this.disableAllLocations;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableAllLocations");
        return null;
    }

    public final void setDisableAllLocations(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableAllLocations = booleanParam;
    }

    public final BooleanParam getDisableHardwareAccelerate() {
        BooleanParam booleanParam = this.disableHardwareAccelerate;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableHardwareAccelerate");
        return null;
    }

    public final void setDisableHardwareAccelerate(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableHardwareAccelerate = booleanParam;
    }

    public final BooleanParam getDisableSaveImage() {
        BooleanParam booleanParam = this.disableSaveImage;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableSaveImage");
        return null;
    }

    public final void setDisableSaveImage(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableSaveImage = booleanParam;
    }

    public final BooleanParam getEnableVideoLandscape() {
        BooleanParam booleanParam = this.enableVideoLandscape;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableVideoLandscape");
        return null;
    }

    public final void setEnableVideoLandscape(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableVideoLandscape = booleanParam;
    }

    public final BooleanParam getEnableWebviewSelectSearch() {
        BooleanParam booleanParam = this.enableWebviewSelectSearch;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableWebviewSelectSearch");
        return null;
    }

    public final void setEnableWebviewSelectSearch(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableWebviewSelectSearch = booleanParam;
    }

    public final BooleanParam getDisableWebviewSelectMenus() {
        BooleanParam booleanParam = this.disableWebviewSelectMenus;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableWebviewSelectMenus");
        return null;
    }

    public final void setDisableWebviewSelectMenus(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableWebviewSelectMenus = booleanParam;
    }

    public final BooleanParam getHideSystemVideoPoster() {
        BooleanParam booleanParam = this.hideSystemVideoPoster;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hideSystemVideoPoster");
        return null;
    }

    public final void setHideSystemVideoPoster(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.hideSystemVideoPoster = booleanParam;
    }

    public final BooleanParam getIgnoreCachePolicy() {
        BooleanParam booleanParam = this.ignoreCachePolicy;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ignoreCachePolicy");
        return null;
    }

    public final void setIgnoreCachePolicy(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.ignoreCachePolicy = booleanParam;
    }

    public final BooleanParam getInterceptRequest() {
        BooleanParam booleanParam = this.interceptRequest;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("interceptRequest");
        return null;
    }

    public final void setInterceptRequest(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.interceptRequest = booleanParam;
    }

    public final BooleanParam getNeedContainerId() {
        BooleanParam booleanParam = this.needContainerId;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("needContainerId");
        return null;
    }

    public final void setNeedContainerId(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.needContainerId = booleanParam;
    }

    public final StringParam getSecureLinkScene() {
        StringParam stringParam = this.secureLinkScene;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("secureLinkScene");
        return null;
    }

    public final void setSecureLinkScene(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.secureLinkScene = stringParam;
    }

    public final BooleanParam getStatusBar() {
        BooleanParam booleanParam = this.statusBar;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("statusBar");
        return null;
    }

    public final void setStatusBar(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.statusBar = booleanParam;
    }

    public final BooleanParam getUseWebviewTitle() {
        BooleanParam booleanParam = this.useWebviewTitle;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("useWebviewTitle");
        return null;
    }

    public final void setUseWebviewTitle(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useWebviewTitle = booleanParam;
    }

    public final BooleanParam getBundleEnableAppCache() {
        BooleanParam booleanParam = this.bundleEnableAppCache;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bundleEnableAppCache");
        return null;
    }

    public final void setBundleEnableAppCache(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.bundleEnableAppCache = booleanParam;
    }

    public final BooleanParam getBundleLoadNoCache() {
        BooleanParam booleanParam = this.bundleLoadNoCache;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bundleLoadNoCache");
        return null;
    }

    public final void setBundleLoadNoCache(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.bundleLoadNoCache = booleanParam;
    }

    public final StringParam getHeadStr() {
        StringParam stringParam = this.headStr;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("headStr");
        return null;
    }

    public final void setHeadStr(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.headStr = stringParam;
    }

    public final StringParam getWebBgColor() {
        StringParam stringParam = this.webBgColor;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webBgColor");
        return null;
    }

    public final void setWebBgColor(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.webBgColor = stringParam;
    }

    public final StringListParam getAppendGlobalProps() {
        StringListParam stringListParam = this.appendGlobalProps;
        if (stringListParam != null) {
            return stringListParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appendGlobalProps");
        return null;
    }

    public final void setAppendGlobalProps(StringListParam stringListParam) {
        Intrinsics.checkNotNullParameter(stringListParam, "<set-?>");
        this.appendGlobalProps = stringListParam;
    }

    public final BooleanParam getAppendCommonParams() {
        BooleanParam booleanParam = this.appendCommonParams;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appendCommonParams");
        return null;
    }

    public final void setAppendCommonParams(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.appendCommonParams = booleanParam;
    }

    public final BooleanParam getCompactMode() {
        BooleanParam booleanParam = this.compactMode;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("compactMode");
        return null;
    }

    public final void setCompactMode(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.compactMode = booleanParam;
    }

    public final IntegerParam getOverScrollModel() {
        IntegerParam integerParam = this.overScrollModel;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("overScrollModel");
        return null;
    }

    public final void setOverScrollModel(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.overScrollModel = integerParam;
    }

    public final BooleanParam getSkipIntercept() {
        BooleanParam booleanParam = this.skipIntercept;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("skipIntercept");
        return null;
    }

    public final void setSkipIntercept(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.skipIntercept = booleanParam;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.model.BDWebKitModel, com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        super.initWithData(schemaData);
        setAdBlock(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_AD_BLOCK, false));
        setAutoPlayBgm(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_AUTO_PLAY_BGM, false));
        setDisableAllLocations(new BooleanParam(schemaData, "disable_all_locations", false));
        setDisableHardwareAccelerate(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_NO_HW, false));
        setDisableSaveImage(new BooleanParam(schemaData, "disable_save_image", false));
        setEnableVideoLandscape(new BooleanParam(schemaData, "enable_video_landscape", false));
        setEnableWebviewSelectSearch(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_ENABLE_WEBVIEW_SELECT_SEARCH, false));
        setDisableWebviewSelectMenus(new BooleanParam(schemaData, "disable_webview_select_menus", false));
        setHideSystemVideoPoster(new BooleanParam(schemaData, SchemaConstants.HIDE_SYSTEM_VIDEO_POSTER, false));
        setIgnoreCachePolicy(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_IGNORE_CACHE_POLICY, false));
        setInterceptRequest(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_INTERCEPT_REQUEST, false));
        setNeedContainerId(new BooleanParam(schemaData, "_need_container_id", false));
        setSecureLinkScene(new StringParam(schemaData, SchemaConstants.QUERY_KEY_SEC_LINK_SCENE, null));
        setStatusBar(new BooleanParam(schemaData, "__status_bar", false));
        setUseWebviewTitle(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_USE_WEBVIEW_TITLE, true));
        setBundleEnableAppCache(new BooleanParam(schemaData, SchemaConstants.BUNDLE_ENABLE_APP_CACHE, false));
        setBundleLoadNoCache(new BooleanParam(schemaData, SchemaConstants.BUNDLE_LOAD_NO_CACHE, false));
        setHeadStr(new StringParam(schemaData, "head_str", null));
        setWebBgColor(new StringParam(schemaData, "web_bg_color", null));
        setAppendGlobalProps(new StringListParam(schemaData, SchemaConstants.APPEND_GLOBAL_PROPS, null));
        setAppendCommonParams(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_APPEND_COMMON_PARAMS, false));
        setCompactMode(new BooleanParam(schemaData, "compact_mode", true));
        setOverScrollModel(new IntegerParam(schemaData, SchemaConstants.WEB_OVER_SCROLL_MODE, 0));
        setSkipIntercept(new BooleanParam(schemaData, "skip_intercept", false));
    }
}
