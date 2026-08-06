package com.bytedance.ies.bullet.service.schema.model;

import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.model.BDContainerModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.DoubleParam;
import com.bytedance.ies.bullet.service.sdk.param.FloatParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.LongParam;
import com.bytedance.ies.bullet.service.sdk.param.PercentParam;
import com.bytedance.ies.bullet.service.sdk.param.SecStrategy;
import com.bytedance.ies.bullet.service.sdk.param.SecStrategyParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXContainerModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u008d\u0001\u001a\u00030\u008e\u00012\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020:X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020:X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001a\u0010B\u001a\u00020CX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR\u001a\u0010K\u001a\u00020LX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020:X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010<\"\u0004\bS\u0010>R\u001a\u0010T\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR\u001a\u0010W\u001a\u00020:X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010<\"\u0004\bY\u0010>R\u001a\u0010Z\u001a\u00020[X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\f\"\u0004\bb\u0010\u000eR\u001a\u0010c\u001a\u00020dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020jX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\f\"\u0004\bq\u0010\u000eR\u001a\u0010r\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\f\"\u0004\bt\u0010\u000eR\u001a\u0010u\u001a\u00020dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010f\"\u0004\bw\u0010hR\u001a\u0010x\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\f\"\u0004\bz\u0010\u000eR\u001a\u0010{\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\f\"\u0004\b}\u0010\u000eR\u001b\u0010~\u001a\u00020\nX\u0086.¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\f\"\u0005\b\u0080\u0001\u0010\u000eR\u001d\u0010\u0081\u0001\u001a\u00020\nX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\f\"\u0005\b\u0083\u0001\u0010\u000eR\u001d\u0010\u0084\u0001\u001a\u00020\nX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\f\"\u0005\b\u0086\u0001\u0010\u000eR\u001d\u0010\u0087\u0001\u001a\u00020.X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u00100\"\u0005\b\u0089\u0001\u00102R\u001d\u0010\u008a\u0001\u001a\u00020\u0004X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\b¨\u0006\u0091\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "Lcom/bytedance/ies/bullet/service/sdk/model/BDContainerModel;", "()V", "bgColor", "Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "getBgColor", "()Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "setBgColor", "(Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;)V", "blockBackPress", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getBlockBackPress", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setBlockBackPress", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "closeAfterOpenSuccess", "getCloseAfterOpenSuccess", "setCloseAfterOpenSuccess", "containerBgColorOld", "getContainerBgColorOld", "setContainerBgColorOld", "disableInputScroll", "getDisableInputScroll", "setDisableInputScroll", "enableAccessToken", "getEnableAccessToken", "setEnableAccessToken", "enableEngineViewScroll", "getEnableEngineViewScroll", "setEnableEngineViewScroll", "enableFontScale", "getEnableFontScale", "setEnableFontScale", "enableLynxPredecode", "getEnableLynxPredecode", "setEnableLynxPredecode", "enableTriggerShowhide", "getEnableTriggerShowhide", "setEnableTriggerShowhide", "enableUrlInterceptor", "getEnableUrlInterceptor", "setEnableUrlInterceptor", "enableViewZoom", "getEnableViewZoom", "setEnableViewZoom", "fontScale", "Lcom/bytedance/ies/bullet/service/sdk/param/FloatParam;", "getFontScale", "()Lcom/bytedance/ies/bullet/service/sdk/param/FloatParam;", "setFontScale", "(Lcom/bytedance/ies/bullet/service/sdk/param/FloatParam;)V", "forceH5", "getForceH5", "setForceH5", "forestDelayPreload", "getForestDelayPreload", "setForestDelayPreload", "forestDownloadEngine", "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "getForestDownloadEngine", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "setForestDownloadEngine", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;)V", "forestPreloadScope", "getForestPreloadScope", "setForestPreloadScope", "heightPercent", "Lcom/bytedance/ies/bullet/service/sdk/param/PercentParam;", "getHeightPercent", "()Lcom/bytedance/ies/bullet/service/sdk/param/PercentParam;", "setHeightPercent", "(Lcom/bytedance/ies/bullet/service/sdk/param/PercentParam;)V", "hideStatusBar", "getHideStatusBar", "setHideStatusBar", "loadUrlDelayTime", "Lcom/bytedance/ies/bullet/service/sdk/param/LongParam;", "getLoadUrlDelayTime", "()Lcom/bytedance/ies/bullet/service/sdk/param/LongParam;", "setLoadUrlDelayTime", "(Lcom/bytedance/ies/bullet/service/sdk/param/LongParam;)V", "loaderName", "getLoaderName", "setLoaderName", "loadingBgColorOld", "getLoadingBgColorOld", "setLoadingBgColorOld", "openContainerID", "getOpenContainerID", "setOpenContainerID", "padRatio", "Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;", "getPadRatio", "()Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;", "setPadRatio", "(Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;)V", "pullDownClose", "getPullDownClose", "setPullDownClose", "sandbox", "Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "getSandbox", "()Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "setSandbox", "(Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;)V", "secStrategy", "Lcom/bytedance/ies/bullet/service/sdk/param/SecStrategyParam;", "getSecStrategy", "()Lcom/bytedance/ies/bullet/service/sdk/param/SecStrategyParam;", "setSecStrategy", "(Lcom/bytedance/ies/bullet/service/sdk/param/SecStrategyParam;)V", "showError", "getShowError", "setShowError", "showLoading", "getShowLoading", "setShowLoading", "softInputMode", "getSoftInputMode", "setSoftInputMode", "supportExchangeTheme", "getSupportExchangeTheme", "setSupportExchangeTheme", "transStatusBar", "getTransStatusBar", "setTransStatusBar", "useKtx2Transcoder", "getUseKtx2Transcoder", "setUseKtx2Transcoder", "useMotion", "getUseMotion", "setUseMotion", "useXBridge3", "getUseXBridge3", "setUseXBridge3", "viewZoom", "getViewZoom", "setViewZoom", "webBgColor", "getWebBgColor", "setWebBgColor", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDXContainerModel extends BDContainerModel {
    public UIColorParam bgColor;
    public BooleanParam blockBackPress;
    public BooleanParam closeAfterOpenSuccess;
    public UIColorParam containerBgColorOld;
    public BooleanParam disableInputScroll;
    public BooleanParam enableAccessToken;
    public BooleanParam enableEngineViewScroll;
    public BooleanParam enableFontScale;
    public BooleanParam enableLynxPredecode;
    public BooleanParam enableTriggerShowhide;
    public BooleanParam enableUrlInterceptor;
    public BooleanParam enableViewZoom;
    public FloatParam fontScale;
    public BooleanParam forceH5;
    public BooleanParam forestDelayPreload;
    public StringParam forestDownloadEngine;
    public StringParam forestPreloadScope;
    public PercentParam heightPercent;
    public BooleanParam hideStatusBar;
    public LongParam loadUrlDelayTime;
    public StringParam loaderName;
    public UIColorParam loadingBgColorOld;
    public StringParam openContainerID;
    public DoubleParam padRatio;
    public BooleanParam pullDownClose;
    public IntegerParam sandbox;
    public SecStrategyParam secStrategy;
    public BooleanParam showError;
    public BooleanParam showLoading;
    public IntegerParam softInputMode;
    public BooleanParam supportExchangeTheme;
    public BooleanParam transStatusBar;
    public BooleanParam useKtx2Transcoder;
    public BooleanParam useMotion;
    public BooleanParam useXBridge3;
    public FloatParam viewZoom;
    public UIColorParam webBgColor;

    public final UIColorParam getBgColor() {
        UIColorParam uIColorParam = this.bgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bgColor");
        return null;
    }

    public final void setBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.bgColor = uIColorParam;
    }

    public final BooleanParam getBlockBackPress() {
        BooleanParam booleanParam = this.blockBackPress;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blockBackPress");
        return null;
    }

    public final void setBlockBackPress(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.blockBackPress = booleanParam;
    }

    public final UIColorParam getContainerBgColorOld() {
        UIColorParam uIColorParam = this.containerBgColorOld;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("containerBgColorOld");
        return null;
    }

    public final void setContainerBgColorOld(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.containerBgColorOld = uIColorParam;
    }

    public final BooleanParam getEnableFontScale() {
        BooleanParam booleanParam = this.enableFontScale;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableFontScale");
        return null;
    }

    public final void setEnableFontScale(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableFontScale = booleanParam;
    }

    public final BooleanParam getEnableTriggerShowhide() {
        BooleanParam booleanParam = this.enableTriggerShowhide;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableTriggerShowhide");
        return null;
    }

    public final void setEnableTriggerShowhide(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableTriggerShowhide = booleanParam;
    }

    public final BooleanParam getEnableUrlInterceptor() {
        BooleanParam booleanParam = this.enableUrlInterceptor;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableUrlInterceptor");
        return null;
    }

    public final void setEnableUrlInterceptor(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableUrlInterceptor = booleanParam;
    }

    public final BooleanParam getEnableViewZoom() {
        BooleanParam booleanParam = this.enableViewZoom;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableViewZoom");
        return null;
    }

    public final void setEnableViewZoom(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableViewZoom = booleanParam;
    }

    public final FloatParam getFontScale() {
        FloatParam floatParam = this.fontScale;
        if (floatParam != null) {
            return floatParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontScale");
        return null;
    }

    public final void setFontScale(FloatParam floatParam) {
        Intrinsics.checkNotNullParameter(floatParam, "<set-?>");
        this.fontScale = floatParam;
    }

    public final BooleanParam getForceH5() {
        BooleanParam booleanParam = this.forceH5;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("forceH5");
        return null;
    }

    public final void setForceH5(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.forceH5 = booleanParam;
    }

    public final LongParam getLoadUrlDelayTime() {
        LongParam longParam = this.loadUrlDelayTime;
        if (longParam != null) {
            return longParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadUrlDelayTime");
        return null;
    }

    public final void setLoadUrlDelayTime(LongParam longParam) {
        Intrinsics.checkNotNullParameter(longParam, "<set-?>");
        this.loadUrlDelayTime = longParam;
    }

    public final UIColorParam getLoadingBgColorOld() {
        UIColorParam uIColorParam = this.loadingBgColorOld;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingBgColorOld");
        return null;
    }

    public final void setLoadingBgColorOld(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.loadingBgColorOld = uIColorParam;
    }

    public final IntegerParam getSandbox() {
        IntegerParam integerParam = this.sandbox;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sandbox");
        return null;
    }

    public final void setSandbox(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.sandbox = integerParam;
    }

    public final SecStrategyParam getSecStrategy() {
        SecStrategyParam secStrategyParam = this.secStrategy;
        if (secStrategyParam != null) {
            return secStrategyParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("secStrategy");
        return null;
    }

    public final void setSecStrategy(SecStrategyParam secStrategyParam) {
        Intrinsics.checkNotNullParameter(secStrategyParam, "<set-?>");
        this.secStrategy = secStrategyParam;
    }

    public final BooleanParam getShowError() {
        BooleanParam booleanParam = this.showError;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showError");
        return null;
    }

    public final void setShowError(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showError = booleanParam;
    }

    public final BooleanParam getShowLoading() {
        BooleanParam booleanParam = this.showLoading;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showLoading");
        return null;
    }

    public final void setShowLoading(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showLoading = booleanParam;
    }

    public final BooleanParam getSupportExchangeTheme() {
        BooleanParam booleanParam = this.supportExchangeTheme;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supportExchangeTheme");
        return null;
    }

    public final void setSupportExchangeTheme(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.supportExchangeTheme = booleanParam;
    }

    public final BooleanParam getUseXBridge3() {
        BooleanParam booleanParam = this.useXBridge3;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("useXBridge3");
        return null;
    }

    public final void setUseXBridge3(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useXBridge3 = booleanParam;
    }

    public final FloatParam getViewZoom() {
        FloatParam floatParam = this.viewZoom;
        if (floatParam != null) {
            return floatParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewZoom");
        return null;
    }

    public final void setViewZoom(FloatParam floatParam) {
        Intrinsics.checkNotNullParameter(floatParam, "<set-?>");
        this.viewZoom = floatParam;
    }

    public final UIColorParam getWebBgColor() {
        UIColorParam uIColorParam = this.webBgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webBgColor");
        return null;
    }

    public final void setWebBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.webBgColor = uIColorParam;
    }

    public final DoubleParam getPadRatio() {
        DoubleParam doubleParam = this.padRatio;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("padRatio");
        return null;
    }

    public final void setPadRatio(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.padRatio = doubleParam;
    }

    public final BooleanParam getUseMotion() {
        BooleanParam booleanParam = this.useMotion;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("useMotion");
        return null;
    }

    public final void setUseMotion(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useMotion = booleanParam;
    }

    public final StringParam getLoaderName() {
        StringParam stringParam = this.loaderName;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loaderName");
        return null;
    }

    public final void setLoaderName(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.loaderName = stringParam;
    }

    public final StringParam getForestPreloadScope() {
        StringParam stringParam = this.forestPreloadScope;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("forestPreloadScope");
        return null;
    }

    public final void setForestPreloadScope(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.forestPreloadScope = stringParam;
    }

    public final BooleanParam getForestDelayPreload() {
        BooleanParam booleanParam = this.forestDelayPreload;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("forestDelayPreload");
        return null;
    }

    public final void setForestDelayPreload(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.forestDelayPreload = booleanParam;
    }

    public final StringParam getForestDownloadEngine() {
        StringParam stringParam = this.forestDownloadEngine;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("forestDownloadEngine");
        return null;
    }

    public final void setForestDownloadEngine(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.forestDownloadEngine = stringParam;
    }

    public final BooleanParam getCloseAfterOpenSuccess() {
        BooleanParam booleanParam = this.closeAfterOpenSuccess;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeAfterOpenSuccess");
        return null;
    }

    public final void setCloseAfterOpenSuccess(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.closeAfterOpenSuccess = booleanParam;
    }

    public final StringParam getOpenContainerID() {
        StringParam stringParam = this.openContainerID;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("openContainerID");
        return null;
    }

    public final void setOpenContainerID(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.openContainerID = stringParam;
    }

    public final IntegerParam getSoftInputMode() {
        IntegerParam integerParam = this.softInputMode;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        return null;
    }

    public final void setSoftInputMode(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.softInputMode = integerParam;
    }

    public final BooleanParam getHideStatusBar() {
        BooleanParam booleanParam = this.hideStatusBar;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hideStatusBar");
        return null;
    }

    public final void setHideStatusBar(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.hideStatusBar = booleanParam;
    }

    public final BooleanParam getTransStatusBar() {
        BooleanParam booleanParam = this.transStatusBar;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transStatusBar");
        return null;
    }

    public final void setTransStatusBar(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.transStatusBar = booleanParam;
    }

    public final PercentParam getHeightPercent() {
        PercentParam percentParam = this.heightPercent;
        if (percentParam != null) {
            return percentParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("heightPercent");
        return null;
    }

    public final void setHeightPercent(PercentParam percentParam) {
        Intrinsics.checkNotNullParameter(percentParam, "<set-?>");
        this.heightPercent = percentParam;
    }

    public final BooleanParam getUseKtx2Transcoder() {
        BooleanParam booleanParam = this.useKtx2Transcoder;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("useKtx2Transcoder");
        return null;
    }

    public final void setUseKtx2Transcoder(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useKtx2Transcoder = booleanParam;
    }

    public final BooleanParam getEnableLynxPredecode() {
        BooleanParam booleanParam = this.enableLynxPredecode;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableLynxPredecode");
        return null;
    }

    public final void setEnableLynxPredecode(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableLynxPredecode = booleanParam;
    }

    public final BooleanParam getPullDownClose() {
        BooleanParam booleanParam = this.pullDownClose;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pullDownClose");
        return null;
    }

    public final void setPullDownClose(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.pullDownClose = booleanParam;
    }

    public final BooleanParam getEnableEngineViewScroll() {
        BooleanParam booleanParam = this.enableEngineViewScroll;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableEngineViewScroll");
        return null;
    }

    public final void setEnableEngineViewScroll(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableEngineViewScroll = booleanParam;
    }

    public final BooleanParam getDisableInputScroll() {
        BooleanParam booleanParam = this.disableInputScroll;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        return null;
    }

    public final void setDisableInputScroll(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableInputScroll = booleanParam;
    }

    public final BooleanParam getEnableAccessToken() {
        BooleanParam booleanParam = this.enableAccessToken;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableAccessToken");
        return null;
    }

    public final void setEnableAccessToken(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableAccessToken = booleanParam;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.model.BDContainerModel, com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        super.initWithData(schemaData);
        setBgColor(new UIColorParam(schemaData, "bg_color", null));
        setBlockBackPress(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_BLOCK_BACK_PRESS, false));
        setContainerBgColorOld(new UIColorParam(schemaData, "container_bgcolor", null));
        setEnableFontScale(new BooleanParam(schemaData, "enable_font_scale", false));
        setEnableTriggerShowhide(new BooleanParam(schemaData, "enable_trigger_showhide", true));
        setEnableUrlInterceptor(new BooleanParam(schemaData, "enable_xschema_interceptor", false));
        setEnableViewZoom(new BooleanParam(schemaData, "enable_view_zoom", false));
        setFontScale(new FloatParam(schemaData, "font_scale", Float.valueOf(0.0f)));
        setForceH5(new BooleanParam(schemaData, "force_h5", false));
        setLoadUrlDelayTime(new LongParam(schemaData, "load_url_delay_time", 0L));
        setLoadingBgColorOld(new UIColorParam(schemaData, "loading_bgcolor", null));
        setSandbox(new IntegerParam(schemaData, "sandbox", 0));
        setSecStrategy(new SecStrategyParam(schemaData, "sec_strategy", SecStrategy.NORMAL));
        setShowError(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOW_ERROR, true));
        setShowLoading(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOW_LOADING, true));
        setSupportExchangeTheme(new BooleanParam(schemaData, "support_exchange_theme", false));
        setUseXBridge3(new BooleanParam(schemaData, SchemaConstants.XBRIDGE_USE3, false));
        setViewZoom(new FloatParam(schemaData, "view_zoom", null));
        setWebBgColor(new UIColorParam(schemaData, "web_bg_color", null));
        setPadRatio(new DoubleParam(schemaData, SchemaConstants.QUERY_KEY_PAD_RATIO, null));
        setLoaderName(new StringParam(schemaData, SchemaConstants.LOADER_NAME, DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME));
        setForestPreloadScope(new StringParam(schemaData, "enable_preload", ForestLoader.PRELOAD_SCOPE_DISABLE));
        setForestDownloadEngine(new StringParam(schemaData, SchemaConstants.FOREST_DOWNLOAD_ENGINE, ForestLoader.DOWNLOAD_ENGINE_TTNET));
        setForestDelayPreload(new BooleanParam(schemaData, "delay_preload", false));
        setCloseAfterOpenSuccess(new BooleanParam(schemaData, "_close_after_open_success", false));
        setOpenContainerID(new StringParam(schemaData, "_open_container_id", ""));
        setSoftInputMode(new IntegerParam(schemaData, "android_soft_input_mode", -1));
        setHideStatusBar(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_HIDE_STATUS_BAR, false));
        setTransStatusBar(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_TRANS_STATUS_BAR, false));
        setUseMotion(new BooleanParam(schemaData, "use_motion", false));
        setHeightPercent(new PercentParam(schemaData, "height_percent", null));
        setUseKtx2Transcoder(new BooleanParam(schemaData, "use_ktx2_transcoder", false));
        setEnableLynxPredecode(new BooleanParam(schemaData, SchemaConstants.SCHEMA_LYNX_PRE_DECODE, false));
        setPullDownClose(new BooleanParam(schemaData, SchemaConstants.PULL_DOWN_CLOSE, false));
        setEnableEngineViewScroll(new BooleanParam(schemaData, "enable_engine_view_scroll", false));
        setDisableInputScroll(new BooleanParam(schemaData, "disable_input_scroll", false));
        setEnableAccessToken(new BooleanParam(schemaData, "enable_access_token", false));
    }
}
