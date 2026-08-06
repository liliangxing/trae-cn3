package com.bytedance.ies.bullet.service.schema.model;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXLynxKitModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\bn\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0099\u0001\u001a\u00030\u009a\u00012\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010$\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u001a\u00103\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R\u001a\u00106\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R\u001a\u00109\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u001a\u0010<\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R\u001a\u0010?\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u001a\u0010B\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u001a\u0010E\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014R\u001a\u0010H\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\u001a\u0010K\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014R\u001a\u0010N\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000eR\u001a\u0010Q\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\f\"\u0004\bS\u0010\u000eR\u001a\u0010T\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010-\"\u0004\bV\u0010/R\u001a\u0010W\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010-\"\u0004\bY\u0010/R\u001a\u0010Z\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010/R\u001a\u0010]\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010-\"\u0004\b_\u0010/R\u001a\u0010`\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010-\"\u0004\bb\u0010/R\u001a\u0010c\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010-\"\u0004\be\u0010/R\u001a\u0010f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\u001a\u0010i\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\f\"\u0004\bk\u0010\u000eR\u001a\u0010l\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\f\"\u0004\bn\u0010\u000eR\u001a\u0010o\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010-\"\u0004\bq\u0010/R\u001a\u0010r\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0012\"\u0004\bt\u0010\u0014R\u001a\u0010u\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010-\"\u0004\bw\u0010/R\u001a\u0010x\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0012\"\u0004\bz\u0010\u0014R\u001a\u0010{\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0012\"\u0004\b}\u0010\u0014R\u001b\u0010~\u001a\u00020\u0004X\u0086.¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0006\"\u0005\b\u0080\u0001\u0010\bR\u001d\u0010\u0081\u0001\u001a\u00020\u0010X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0012\"\u0005\b\u0083\u0001\u0010\u0014R\u001d\u0010\u0084\u0001\u001a\u00020\u0004X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR\u001d\u0010\u0087\u0001\u001a\u00020+X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010-\"\u0005\b\u0089\u0001\u0010/R\u001d\u0010\u008a\u0001\u001a\u00020\u0010X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0012\"\u0005\b\u008c\u0001\u0010\u0014R\u001d\u0010\u008d\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u0012\"\u0005\b\u008f\u0001\u0010\u0014R\u001d\u0010\u0090\u0001\u001a\u00020\u0010X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u0012\"\u0005\b\u0092\u0001\u0010\u0014R\u001d\u0010\u0093\u0001\u001a\u00020\u0010X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0012\"\u0005\b\u0095\u0001\u0010\u0014R\u001d\u0010\u0096\u0001\u001a\u00020\u0010X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0012\"\u0005\b\u0098\u0001\u0010\u0014¨\u0006\u009d\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/model/BDXLynxKitModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "aSurl", "Lcom/bytedance/ies/bullet/service/sdk/param/UrlParam;", "getASurl", "()Lcom/bytedance/ies/bullet/service/sdk/param/UrlParam;", "setASurl", "(Lcom/bytedance/ies/bullet/service/sdk/param/UrlParam;)V", "bundlePath", "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "getBundlePath", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "setBundlePath", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;)V", "cacheScript", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getCacheScript", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setCacheScript", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "channel", "getChannel", "setChannel", "closeByBack", "getCloseByBack", "setCloseByBack", "createViewAsync", "getCreateViewAsync", "setCreateViewAsync", "decodeScriptSync", "getDecodeScriptSync", "setDecodeScriptSync", "disableAutoExpose", "getDisableAutoExpose", "setDisableAutoExpose", "disableJsCtxShare", "getDisableJsCtxShare", "setDisableJsCtxShare", "durl", "getDurl", "setDurl", "dynamic", "Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "getDynamic", "()Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "setDynamic", "(Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;)V", "enableAnimaX", "getEnableAnimaX", "setEnableAnimaX", "enableCanvas", "getEnableCanvas", "setEnableCanvas", "enableCanvasOptimization", "getEnableCanvasOptimization", "setEnableCanvasOptimization", "enableDynamicV8", "getEnableDynamicV8", "setEnableDynamicV8", "enableLynxAir", "getEnableLynxAir", "setEnableLynxAir", "enableLynxGenericFetcher", "getEnableLynxGenericFetcher", "setEnableLynxGenericFetcher", "enablePendingJsTask", "getEnablePendingJsTask", "setEnablePendingJsTask", "enableRadonCompatible", "getEnableRadonCompatible", "setEnableRadonCompatible", "enableSyncFlush", "getEnableSyncFlush", "setEnableSyncFlush", "enableVSyncAlignedMessageLoop", "getEnableVSyncAlignedMessageLoop", "setEnableVSyncAlignedMessageLoop", "group", "getGroup", "setGroup", "initData", "getInitData", "setInitData", "lynxInitHeight", "getLynxInitHeight", "setLynxInitHeight", "lynxInitWidth", "getLynxInitWidth", "setLynxInitWidth", "lynxPresetHeight", "getLynxPresetHeight", "setLynxPresetHeight", "lynxPresetHeightSpec", "getLynxPresetHeightSpec", "setLynxPresetHeightSpec", "lynxPresetWidth", "getLynxPresetWidth", "setLynxPresetWidth", "lynxPresetWidthSpec", "getLynxPresetWidthSpec", "setLynxPresetWidthSpec", "postUrl", "getPostUrl", "setPostUrl", "predefine", "getPredefine", "setPredefine", "preloadFonts", "getPreloadFonts", "setPreloadFonts", "presetHeight", "getPresetHeight", "setPresetHeight", "presetSafePoint", "getPresetSafePoint", "setPresetSafePoint", "presetWidth", "getPresetWidth", "setPresetWidth", "readResInfoInMain", "getReadResInfoInMain", "setReadResInfoInMain", "renderTempInMain", "getRenderTempInMain", "setRenderTempInMain", "resUrl", "getResUrl", "setResUrl", "shareGroup", "getShareGroup", "setShareGroup", SchemaConstants.QUERY_KEY_SURL, "getSurl", "setSurl", "threadStrategy", "getThreadStrategy", "setThreadStrategy", "uiRunningMode", "getUiRunningMode", "setUiRunningMode", "useCodeCache", "getUseCodeCache", "setUseCodeCache", "useGeckoFirst", "getUseGeckoFirst", "setUseGeckoFirst", "usePiperData", "getUsePiperData", "setUsePiperData", "useStorageGroup", "getUseStorageGroup", "setUseStorageGroup", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDXLynxKitModel implements ISchemaModel {
    public UrlParam aSurl;
    public StringParam bundlePath;
    public BooleanParam cacheScript;
    public StringParam channel;
    public BooleanParam closeByBack;
    public BooleanParam createViewAsync;
    public BooleanParam decodeScriptSync;
    public BooleanParam disableAutoExpose;
    public BooleanParam disableJsCtxShare;
    public UrlParam durl;
    public IntegerParam dynamic;
    public BooleanParam enableAnimaX;
    public BooleanParam enableCanvas;
    public BooleanParam enableCanvasOptimization;
    public BooleanParam enableDynamicV8;
    public BooleanParam enableLynxAir;
    public BooleanParam enableLynxGenericFetcher;
    public BooleanParam enablePendingJsTask;
    public BooleanParam enableRadonCompatible;
    public BooleanParam enableSyncFlush;
    public BooleanParam enableVSyncAlignedMessageLoop;
    public StringParam group;
    public StringParam initData;
    public IntegerParam lynxInitHeight;
    public IntegerParam lynxInitWidth;
    public IntegerParam lynxPresetHeight;
    public IntegerParam lynxPresetHeightSpec;
    public IntegerParam lynxPresetWidth;
    public IntegerParam lynxPresetWidthSpec;
    public UrlParam postUrl;
    public StringParam predefine;
    public StringParam preloadFonts;
    public IntegerParam presetHeight;
    public BooleanParam presetSafePoint;
    public IntegerParam presetWidth;
    public BooleanParam readResInfoInMain;
    public BooleanParam renderTempInMain;
    public UrlParam resUrl;
    public BooleanParam shareGroup;
    public UrlParam surl;
    public IntegerParam threadStrategy;
    public BooleanParam uiRunningMode;
    private BooleanParam useCodeCache = new BooleanParam(false);
    public BooleanParam useGeckoFirst;
    public BooleanParam usePiperData;
    public BooleanParam useStorageGroup;

    public final UrlParam getASurl() {
        UrlParam urlParam = this.aSurl;
        if (urlParam != null) {
            return urlParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aSurl");
        return null;
    }

    public final void setASurl(UrlParam urlParam) {
        Intrinsics.checkNotNullParameter(urlParam, "<set-?>");
        this.aSurl = urlParam;
    }

    public final StringParam getBundlePath() {
        StringParam stringParam = this.bundlePath;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bundlePath");
        return null;
    }

    public final void setBundlePath(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.bundlePath = stringParam;
    }

    public final BooleanParam getCacheScript() {
        BooleanParam booleanParam = this.cacheScript;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cacheScript");
        return null;
    }

    public final void setCacheScript(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.cacheScript = booleanParam;
    }

    public final StringParam getChannel() {
        StringParam stringParam = this.channel;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channel");
        return null;
    }

    public final void setChannel(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.channel = stringParam;
    }

    public final BooleanParam getCloseByBack() {
        BooleanParam booleanParam = this.closeByBack;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeByBack");
        return null;
    }

    public final void setCloseByBack(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.closeByBack = booleanParam;
    }

    public final BooleanParam getCreateViewAsync() {
        BooleanParam booleanParam = this.createViewAsync;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("createViewAsync");
        return null;
    }

    public final void setCreateViewAsync(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.createViewAsync = booleanParam;
    }

    public final BooleanParam getEnableSyncFlush() {
        BooleanParam booleanParam = this.enableSyncFlush;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableSyncFlush");
        return null;
    }

    public final void setEnableSyncFlush(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableSyncFlush = booleanParam;
    }

    public final UrlParam getDurl() {
        UrlParam urlParam = this.durl;
        if (urlParam != null) {
            return urlParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("durl");
        return null;
    }

    public final void setDurl(UrlParam urlParam) {
        Intrinsics.checkNotNullParameter(urlParam, "<set-?>");
        this.durl = urlParam;
    }

    public final BooleanParam getDecodeScriptSync() {
        BooleanParam booleanParam = this.decodeScriptSync;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("decodeScriptSync");
        return null;
    }

    public final void setDecodeScriptSync(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.decodeScriptSync = booleanParam;
    }

    public final BooleanParam getDisableAutoExpose() {
        BooleanParam booleanParam = this.disableAutoExpose;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableAutoExpose");
        return null;
    }

    public final void setDisableAutoExpose(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableAutoExpose = booleanParam;
    }

    public final BooleanParam getDisableJsCtxShare() {
        BooleanParam booleanParam = this.disableJsCtxShare;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableJsCtxShare");
        return null;
    }

    public final void setDisableJsCtxShare(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableJsCtxShare = booleanParam;
    }

    public final IntegerParam getDynamic() {
        IntegerParam integerParam = this.dynamic;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dynamic");
        return null;
    }

    public final void setDynamic(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.dynamic = integerParam;
    }

    public final BooleanParam getEnableCanvas() {
        BooleanParam booleanParam = this.enableCanvas;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableCanvas");
        return null;
    }

    public final void setEnableCanvas(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableCanvas = booleanParam;
    }

    public final BooleanParam getEnableAnimaX() {
        BooleanParam booleanParam = this.enableAnimaX;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableAnimaX");
        return null;
    }

    public final void setEnableAnimaX(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableAnimaX = booleanParam;
    }

    public final BooleanParam getEnableDynamicV8() {
        BooleanParam booleanParam = this.enableDynamicV8;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableDynamicV8");
        return null;
    }

    public final void setEnableDynamicV8(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableDynamicV8 = booleanParam;
    }

    public final BooleanParam getEnableCanvasOptimization() {
        BooleanParam booleanParam = this.enableCanvasOptimization;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableCanvasOptimization");
        return null;
    }

    public final void setEnableCanvasOptimization(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableCanvasOptimization = booleanParam;
    }

    public final BooleanParam getEnableRadonCompatible() {
        BooleanParam booleanParam = this.enableRadonCompatible;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableRadonCompatible");
        return null;
    }

    public final void setEnableRadonCompatible(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableRadonCompatible = booleanParam;
    }

    public final StringParam getGroup() {
        StringParam stringParam = this.group;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("group");
        return null;
    }

    public final void setGroup(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.group = stringParam;
    }

    public final BooleanParam getUseStorageGroup() {
        BooleanParam booleanParam = this.useStorageGroup;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("useStorageGroup");
        return null;
    }

    public final void setUseStorageGroup(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useStorageGroup = booleanParam;
    }

    public final StringParam getInitData() {
        StringParam stringParam = this.initData;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initData");
        return null;
    }

    public final void setInitData(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.initData = stringParam;
    }

    public final IntegerParam getLynxPresetHeight() {
        IntegerParam integerParam = this.lynxPresetHeight;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lynxPresetHeight");
        return null;
    }

    public final void setLynxPresetHeight(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.lynxPresetHeight = integerParam;
    }

    public final IntegerParam getLynxInitHeight() {
        IntegerParam integerParam = this.lynxInitHeight;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lynxInitHeight");
        return null;
    }

    public final void setLynxInitHeight(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.lynxInitHeight = integerParam;
    }

    public final IntegerParam getLynxPresetHeightSpec() {
        IntegerParam integerParam = this.lynxPresetHeightSpec;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lynxPresetHeightSpec");
        return null;
    }

    public final void setLynxPresetHeightSpec(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.lynxPresetHeightSpec = integerParam;
    }

    public final IntegerParam getLynxPresetWidth() {
        IntegerParam integerParam = this.lynxPresetWidth;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lynxPresetWidth");
        return null;
    }

    public final void setLynxPresetWidth(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.lynxPresetWidth = integerParam;
    }

    public final IntegerParam getLynxInitWidth() {
        IntegerParam integerParam = this.lynxInitWidth;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lynxInitWidth");
        return null;
    }

    public final void setLynxInitWidth(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.lynxInitWidth = integerParam;
    }

    public final IntegerParam getLynxPresetWidthSpec() {
        IntegerParam integerParam = this.lynxPresetWidthSpec;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lynxPresetWidthSpec");
        return null;
    }

    public final void setLynxPresetWidthSpec(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.lynxPresetWidthSpec = integerParam;
    }

    public final UrlParam getPostUrl() {
        UrlParam urlParam = this.postUrl;
        if (urlParam != null) {
            return urlParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("postUrl");
        return null;
    }

    public final void setPostUrl(UrlParam urlParam) {
        Intrinsics.checkNotNullParameter(urlParam, "<set-?>");
        this.postUrl = urlParam;
    }

    public final StringParam getPreloadFonts() {
        StringParam stringParam = this.preloadFonts;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("preloadFonts");
        return null;
    }

    public final void setPreloadFonts(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.preloadFonts = stringParam;
    }

    public final IntegerParam getPresetHeight() {
        IntegerParam integerParam = this.presetHeight;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presetHeight");
        return null;
    }

    public final void setPresetHeight(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.presetHeight = integerParam;
    }

    public final IntegerParam getPresetWidth() {
        IntegerParam integerParam = this.presetWidth;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presetWidth");
        return null;
    }

    public final void setPresetWidth(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.presetWidth = integerParam;
    }

    public final BooleanParam getPresetSafePoint() {
        BooleanParam booleanParam = this.presetSafePoint;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presetSafePoint");
        return null;
    }

    public final void setPresetSafePoint(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.presetSafePoint = booleanParam;
    }

    public final BooleanParam getReadResInfoInMain() {
        BooleanParam booleanParam = this.readResInfoInMain;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("readResInfoInMain");
        return null;
    }

    public final void setReadResInfoInMain(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.readResInfoInMain = booleanParam;
    }

    public final BooleanParam getRenderTempInMain() {
        BooleanParam booleanParam = this.renderTempInMain;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("renderTempInMain");
        return null;
    }

    public final void setRenderTempInMain(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.renderTempInMain = booleanParam;
    }

    public final UrlParam getResUrl() {
        UrlParam urlParam = this.resUrl;
        if (urlParam != null) {
            return urlParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resUrl");
        return null;
    }

    public final void setResUrl(UrlParam urlParam) {
        Intrinsics.checkNotNullParameter(urlParam, "<set-?>");
        this.resUrl = urlParam;
    }

    public final BooleanParam getShareGroup() {
        BooleanParam booleanParam = this.shareGroup;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareGroup");
        return null;
    }

    public final void setShareGroup(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.shareGroup = booleanParam;
    }

    public final UrlParam getSurl() {
        UrlParam urlParam = this.surl;
        if (urlParam != null) {
            return urlParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException(SchemaConstants.QUERY_KEY_SURL);
        return null;
    }

    public final void setSurl(UrlParam urlParam) {
        Intrinsics.checkNotNullParameter(urlParam, "<set-?>");
        this.surl = urlParam;
    }

    public final IntegerParam getThreadStrategy() {
        IntegerParam integerParam = this.threadStrategy;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("threadStrategy");
        return null;
    }

    public final void setThreadStrategy(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.threadStrategy = integerParam;
    }

    public final BooleanParam getUiRunningMode() {
        BooleanParam booleanParam = this.uiRunningMode;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiRunningMode");
        return null;
    }

    public final void setUiRunningMode(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.uiRunningMode = booleanParam;
    }

    public final BooleanParam getUseGeckoFirst() {
        BooleanParam booleanParam = this.useGeckoFirst;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("useGeckoFirst");
        return null;
    }

    public final void setUseGeckoFirst(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useGeckoFirst = booleanParam;
    }

    public final BooleanParam getEnablePendingJsTask() {
        BooleanParam booleanParam = this.enablePendingJsTask;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enablePendingJsTask");
        return null;
    }

    public final void setEnablePendingJsTask(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enablePendingJsTask = booleanParam;
    }

    public final BooleanParam getUsePiperData() {
        BooleanParam booleanParam = this.usePiperData;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("usePiperData");
        return null;
    }

    public final void setUsePiperData(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.usePiperData = booleanParam;
    }

    public final BooleanParam getEnableVSyncAlignedMessageLoop() {
        BooleanParam booleanParam = this.enableVSyncAlignedMessageLoop;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableVSyncAlignedMessageLoop");
        return null;
    }

    public final void setEnableVSyncAlignedMessageLoop(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableVSyncAlignedMessageLoop = booleanParam;
    }

    public final BooleanParam getEnableLynxAir() {
        BooleanParam booleanParam = this.enableLynxAir;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableLynxAir");
        return null;
    }

    public final void setEnableLynxAir(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableLynxAir = booleanParam;
    }

    public final StringParam getPredefine() {
        StringParam stringParam = this.predefine;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("predefine");
        return null;
    }

    public final void setPredefine(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.predefine = stringParam;
    }

    public final BooleanParam getUseCodeCache() {
        return this.useCodeCache;
    }

    public final void setUseCodeCache(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useCodeCache = booleanParam;
    }

    public final BooleanParam getEnableLynxGenericFetcher() {
        BooleanParam booleanParam = this.enableLynxGenericFetcher;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableLynxGenericFetcher");
        return null;
    }

    public final void setEnableLynxGenericFetcher(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableLynxGenericFetcher = booleanParam;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        setASurl(new UrlParam(schemaData, "a_surl", null));
        setBundlePath(new StringParam(schemaData, SchemaConstants.QUERY_KEY_BUNDLE, null));
        setCacheScript(new BooleanParam(schemaData, "cache_script", true));
        setChannel(new StringParam(schemaData, "channel", null));
        setCloseByBack(new BooleanParam(schemaData, "close_by_back", true));
        setCreateViewAsync(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_CREATE_VIEW_ASYNC, false));
        setEnableSyncFlush(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_ENABLE_SYNC_FLUSH, false));
        setDurl(new UrlParam(schemaData, "durl", null));
        setDecodeScriptSync(new BooleanParam(schemaData, "decode_script_sync", true));
        setDisableAutoExpose(new BooleanParam(schemaData, "disable_auto_expose", false));
        setDisableJsCtxShare(new BooleanParam(schemaData, "disable_js_ctx_share", false));
        setDynamic(new IntegerParam(schemaData, "dynamic", 0));
        setEnableCanvas(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_ENABLE_CANVAS, false));
        setEnableAnimaX(new BooleanParam(schemaData, "enable_animax", false));
        setEnableDynamicV8(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_ENABLE_DYNAMIC_V8, false));
        setEnableCanvasOptimization(new BooleanParam(schemaData, "enable_canvas_optimize", false));
        setEnableRadonCompatible(new BooleanParam(schemaData, "enable_radon_compatible", false));
        setGroup(new StringParam(schemaData, "group", "default_lynx_group"));
        setUseStorageGroup(new BooleanParam(schemaData, "use_storage_group", false));
        setInitData(new StringParam(schemaData, "initial_data", null));
        setLynxPresetHeight(new IntegerParam(schemaData, SchemaConstants.QUERY_KEY_LYNX_PRESET_HEIGHT, 0));
        setLynxInitWidth(new IntegerParam(schemaData, "lynx_init_width", null));
        setLynxInitHeight(new IntegerParam(schemaData, "lynx_init_height", null));
        setLynxPresetHeightSpec(new IntegerParam(schemaData, SchemaConstants.QUERY_KEY_LYNX_PRESET_HEIGHT_SPEC, 0));
        setLynxPresetWidth(new IntegerParam(schemaData, SchemaConstants.QUERY_KEY_LYNX_PRESET_WIDTH, 0));
        setLynxPresetWidthSpec(new IntegerParam(schemaData, SchemaConstants.QUERY_KEY_LYNX_PRESET_WIDTH_SPEC, 0));
        setPostUrl(new UrlParam(schemaData, "post_url", null));
        setPreloadFonts(new StringParam(schemaData, "preloadFonts", null));
        setPresetHeight(new IntegerParam(schemaData, "preset_height", 0));
        setPresetWidth(new IntegerParam(schemaData, "preset_width", 0));
        setPresetSafePoint(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_PRESET_SAFE_POINT, false));
        setReadResInfoInMain(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_READ_RES_INFO_IN_MAIN, true));
        setRenderTempInMain(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_RENDER_TEMP_IN_MAIN, true));
        setResUrl(new UrlParam(schemaData, SchemaConstants.QUERY_KEY_RES_URL, null));
        setShareGroup(new BooleanParam(schemaData, "share_group", true));
        setSurl(new UrlParam(schemaData, SchemaConstants.QUERY_KEY_SURL, null));
        setThreadStrategy(new IntegerParam(schemaData, SchemaConstants.QUERY_KEY_THREAD_STRATEGY, 0));
        setUiRunningMode(new BooleanParam(schemaData, "ui_running_mode", true));
        setUseGeckoFirst(new BooleanParam(schemaData, "use_gecko_first", false));
        this.useCodeCache = new BooleanParam(schemaData, "enable_code_cache", false);
        setEnablePendingJsTask(new BooleanParam(schemaData, "enable_pending_js_task", false));
        setUsePiperData(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_USE_PIPER_DATA, false));
        setEnableVSyncAlignedMessageLoop(new BooleanParam(schemaData, "enable_vsync_aligned_message_loop", false));
        setEnableLynxAir(new BooleanParam(schemaData, "air_strict_mode", false));
        setPredefine(new StringParam(schemaData, "predefine", ""));
        setEnableLynxGenericFetcher(new BooleanParam(schemaData, "enable_lynx_generic_fetcher", false));
    }
}
