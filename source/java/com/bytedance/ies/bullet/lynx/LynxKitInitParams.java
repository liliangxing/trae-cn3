package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.forest.DownloadEngine;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.PreloadScope;
import com.bytedance.ies.bullet.lynx.init.LynxGroupHolder;
import com.bytedance.ies.bullet.lynx.model.LynxInitData;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxLoadMeta;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.component.DynamicComponentFetcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxKitInitParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0011\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000f\u0010\u00ad\u0001\u001a\u00020\u00122\u0006\u0010K\u001a\u00020MJ]\u0010®\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010¯\u0001\u001a\u0002082\u0007\u0010°\u0001\u001a\u00020\n2\u0007\u0010±\u0001\u001a\u00020\n2\u0010\u0010²\u0001\u001a\u000b\u0012\u0004\u0012\u000208\u0018\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020\n2\u0007\u0010µ\u0001\u001a\u00020\n2\u000b\b\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0003\u0010·\u0001J\f\u0010K\u001a\b\u0012\u0004\u0012\u00020M0LJ9\u0010R\u001a\u00020\u00122\u0007\u0010¯\u0001\u001a\u0002082\u0007\u0010°\u0001\u001a\u00020\n2\u0007\u0010±\u0001\u001a\u00020\n2\u0010\u0010²\u0001\u001a\u000b\u0012\u0004\u0012\u000208\u0018\u00010³\u0001¢\u0006\u0003\u0010¸\u0001JB\u0010R\u001a\u00020\u00122\u0007\u0010¯\u0001\u001a\u0002082\u0007\u0010°\u0001\u001a\u00020\n2\u0007\u0010±\u0001\u001a\u00020\n2\u0010\u0010²\u0001\u001a\u000b\u0012\u0004\u0012\u000208\u0018\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020\n¢\u0006\u0003\u0010¹\u0001Jc\u0010R\u001a\u00020\u00122\u0007\u0010¯\u0001\u001a\u0002082\u0007\u0010°\u0001\u001a\u00020\n2\u0007\u0010±\u0001\u001a\u00020\n2\u0010\u0010²\u0001\u001a\u000b\u0012\u0004\u0012\u000208\u0018\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020\n2\u0007\u0010µ\u0001\u001a\u00020\n2\t\b\u0002\u0010º\u0001\u001a\u00020\n2\u000b\b\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010»\u0001JX\u0010R\u001a\u00020\u00122\u0007\u0010¯\u0001\u001a\u0002082\u0007\u0010°\u0001\u001a\u00020\n2\u0007\u0010±\u0001\u001a\u00020\n2\u0010\u0010²\u0001\u001a\u000b\u0012\u0004\u0012\u000208\u0018\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020\n2\u0007\u0010µ\u0001\u001a\u00020\n2\u000b\b\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010¼\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR-\u0010\u000f\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010¢\u0006\u0002\b\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001e\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0002\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u0002\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020M0LX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010;\"\u0004\bV\u0010=R\u001e\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001e\u0010^\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\b_\u0010Z\"\u0004\b`\u0010\\R\u001e\u0010a\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bb\u0010Z\"\u0004\bc\u0010\\R\u001c\u0010d\u001a\u0004\u0018\u00010eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010j\u001a\u0004\u0018\u00010kX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001e\u0010p\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bq\u0010Z\"\u0004\br\u0010\\R\u001c\u0010s\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010;\"\u0004\bu\u0010=R\u001e\u0010v\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bw\u0010Z\"\u0004\bx\u0010\\R\u001e\u0010y\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\bz\u0010Z\"\u0004\b{\u0010\\R*\u0010|\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000208\u0018\u00010}X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010\u0082\u0001\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\f\"\u0005\b\u0084\u0001\u0010\u000eR\u001d\u0010\u0085\u0001\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\f\"\u0005\b\u0087\u0001\u0010\u000eR\u001f\u0010\u0088\u0001\u001a\u00020XX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001f\u0010\u008d\u0001\u001a\u00020XX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008a\u0001\"\u0006\b\u008f\u0001\u0010\u008c\u0001R\u001f\u0010\u0090\u0001\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010;\"\u0005\b\u0092\u0001\u0010=R\u001f\u0010\u0093\u0001\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010;\"\u0005\b\u0095\u0001\u0010=R\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\"\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R\u001d\u0010¢\u0001\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\f\"\u0005\b¤\u0001\u0010\u000eR!\u0010¥\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0012\n\u0002\u0010\u001d\u001a\u0005\b¦\u0001\u0010\u001a\"\u0005\b§\u0001\u0010\u001cR\u001f\u0010¨\u0001\u001a\u000201X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001¨\u0006½\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/LynxKitInitParams;", "", "()V", "asyncLayoutParam", "Lcom/bytedance/ies/bullet/lynx/LynxAsyncLayoutParam;", "getAsyncLayoutParam", "()Lcom/bytedance/ies/bullet/lynx/LynxAsyncLayoutParam;", "setAsyncLayoutParam", "(Lcom/bytedance/ies/bullet/lynx/LynxAsyncLayoutParam;)V", "createViewAsync", "", "getCreateViewAsync", "()Z", "setCreateViewAsync", "(Z)V", "customInit", "Lkotlin/Function1;", "Lcom/lynx/tasm/LynxViewBuilder;", "", "Lkotlin/ExtensionFunctionType;", "getCustomInit", "()Lkotlin/jvm/functions/Function1;", "setCustomInit", "(Lkotlin/jvm/functions/Function1;)V", "disableAutoExpose", "getDisableAutoExpose", "()Ljava/lang/Boolean;", "setDisableAutoExpose", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "dynamicComponentFetcher", "Lcom/lynx/tasm/component/DynamicComponentFetcher;", "getDynamicComponentFetcher", "()Lcom/lynx/tasm/component/DynamicComponentFetcher;", "setDynamicComponentFetcher", "(Lcom/lynx/tasm/component/DynamicComponentFetcher;)V", "enableLynxGenericFetcher", "getEnableLynxGenericFetcher", "setEnableLynxGenericFetcher", "enableLynxPredecode", "getEnableLynxPredecode", "setEnableLynxPredecode", "enableSyncFlush", "getEnableSyncFlush", "setEnableSyncFlush", "enableVSyncAlignedMessageLoop", "getEnableVSyncAlignedMessageLoop", "setEnableVSyncAlignedMessageLoop", "fontScale", "", "getFontScale", "()Ljava/lang/Float;", "setFontScale", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "forestDownloadEngine", "", "getForestDownloadEngine$annotations", "getForestDownloadEngine", "()Ljava/lang/String;", "setForestDownloadEngine", "(Ljava/lang/String;)V", "forestPreloadScope", "getForestPreloadScope$annotations", "getForestPreloadScope", "setForestPreloadScope", "initData", "Lcom/bytedance/ies/bullet/lynx/model/LynxInitData;", "getInitData", "()Lcom/bytedance/ies/bullet/lynx/model/LynxInitData;", "setInitData", "(Lcom/bytedance/ies/bullet/lynx/model/LynxInitData;)V", "lynxCdnCacheHttpUrl", "getLynxCdnCacheHttpUrl", "setLynxCdnCacheHttpUrl", "lynxClientDelegate", "", "Lcom/lynx/tasm/LynxViewClient;", "lynxGroup", "Lcom/lynx/tasm/LynxGroup;", "getLynxGroup", "()Lcom/lynx/tasm/LynxGroup;", "setLynxGroup", "(Lcom/lynx/tasm/LynxGroup;)V", "lynxGroupName", "getLynxGroupName", "setLynxGroupName", "lynxHeight", "", "getLynxHeight", "()Ljava/lang/Integer;", "setLynxHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lynxInitHeight", "getLynxInitHeight", "setLynxInitHeight", "lynxInitWidth", "getLynxInitWidth", "setLynxInitWidth", "lynxLoadMeta", "Lcom/lynx/tasm/LynxLoadMeta$Builder;", "getLynxLoadMeta", "()Lcom/lynx/tasm/LynxLoadMeta$Builder;", "setLynxLoadMeta", "(Lcom/lynx/tasm/LynxLoadMeta$Builder;)V", "lynxRouterCallback", "Lcom/bytedance/ies/bullet/lynx/LynxRouterCallback;", "getLynxRouterCallback", "()Lcom/bytedance/ies/bullet/lynx/LynxRouterCallback;", "setLynxRouterCallback", "(Lcom/bytedance/ies/bullet/lynx/LynxRouterCallback;)V", "lynxWidth", "getLynxWidth", "setLynxWidth", "preloadFonts", "getPreloadFonts", "setPreloadFonts", "presetHeightSpec", "getPresetHeightSpec", "setPresetHeightSpec", "presetWidthSpec", "getPresetWidthSpec", "setPresetWidthSpec", "queryMap", "", "getQueryMap", "()Ljava/util/Map;", "setQueryMap", "(Ljava/util/Map;)V", "readResourceInfoInMainThread", "getReadResourceInfoInMainThread", "setReadResourceInfoInMainThread", "renderTemplateInMainThread", "getRenderTemplateInMainThread", "setRenderTemplateInMainThread", "screenHeight", "getScreenHeight", "()I", "setScreenHeight", "(I)V", "screenWidth", "getScreenWidth", "setScreenWidth", "sessionId", "getSessionId", "setSessionId", "storageGroupName", "getStorageGroupName", "setStorageGroupName", "templateBundle", "Lcom/lynx/tasm/TemplateBundle;", "getTemplateBundle", "()Lcom/lynx/tasm/TemplateBundle;", "setTemplateBundle", "(Lcom/lynx/tasm/TemplateBundle;)V", "templateData", "Lcom/lynx/tasm/TemplateData;", "getTemplateData", "()Lcom/lynx/tasm/TemplateData;", "setTemplateData", "(Lcom/lynx/tasm/TemplateData;)V", "useForest", "getUseForest", "setUseForest", "useStorageGroup", "getUseStorageGroup", "setUseStorageGroup", "viewZoom", "getViewZoom", "()F", "setViewZoom", "(F)V", "addLynxClientDelegate", "createLynxGroup", "groupName", "shareGroup", "enableCanvas", "preloadJSPaths", "", "enableDynamicV8", "enableCanvasOptimization", "enableJsGroupThread", "(Ljava/lang/String;ZZ[Ljava/lang/String;ZZLjava/lang/Boolean;)Lcom/lynx/tasm/LynxGroup;", "(Ljava/lang/String;ZZ[Ljava/lang/String;)V", "(Ljava/lang/String;ZZ[Ljava/lang/String;Z)V", "storageGroup", "(Ljava/lang/String;ZZ[Ljava/lang/String;ZZZLjava/lang/Boolean;)V", "(Ljava/lang/String;ZZ[Ljava/lang/String;ZZLjava/lang/Boolean;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxKitInitParams {
    private LynxAsyncLayoutParam asyncLayoutParam;
    private boolean createViewAsync;
    private Function1<? super LynxViewBuilder, Unit> customInit;
    private Boolean disableAutoExpose;
    private DynamicComponentFetcher dynamicComponentFetcher;
    private Boolean enableLynxGenericFetcher;
    private boolean enableLynxPredecode;
    private boolean enableSyncFlush;
    private boolean enableVSyncAlignedMessageLoop;
    private Float fontScale;
    private LynxInitData initData;
    private boolean lynxCdnCacheHttpUrl;
    private LynxGroup lynxGroup;
    private String lynxGroupName;
    private Integer lynxHeight;
    private Integer lynxInitHeight;
    private Integer lynxInitWidth;
    private LynxLoadMeta.Builder lynxLoadMeta;
    private LynxRouterCallback lynxRouterCallback;
    private Integer lynxWidth;
    private String preloadFonts;
    private Integer presetHeightSpec;
    private Integer presetWidthSpec;
    private Map<String, String> queryMap;
    private boolean readResourceInfoInMainThread;
    private int screenHeight;
    private int screenWidth;
    private String sessionId;
    private String storageGroupName;
    private TemplateBundle templateBundle;
    private TemplateData templateData;
    private boolean useForest;
    private Boolean useStorageGroup;
    private boolean renderTemplateInMainThread = true;
    private float viewZoom = 1.0f;
    private String forestPreloadScope = ForestLoader.PRELOAD_SCOPE_DISABLE;
    private String forestDownloadEngine = ForestLoader.DOWNLOAD_ENGINE_TTNET;
    private List<LynxViewClient> lynxClientDelegate = new ArrayList();

    @DownloadEngine
    public static /* synthetic */ void getForestDownloadEngine$annotations() {
    }

    @PreloadScope
    public static /* synthetic */ void getForestPreloadScope$annotations() {
    }

    public final String getPreloadFonts() {
        return this.preloadFonts;
    }

    public final void setPreloadFonts(String str) {
        this.preloadFonts = str;
    }

    public final LynxAsyncLayoutParam getAsyncLayoutParam() {
        return this.asyncLayoutParam;
    }

    public final void setAsyncLayoutParam(LynxAsyncLayoutParam lynxAsyncLayoutParam) {
        this.asyncLayoutParam = lynxAsyncLayoutParam;
    }

    public final boolean getLynxCdnCacheHttpUrl() {
        return this.lynxCdnCacheHttpUrl;
    }

    public final void setLynxCdnCacheHttpUrl(boolean z) {
        this.lynxCdnCacheHttpUrl = z;
    }

    public final LynxGroup getLynxGroup() {
        return this.lynxGroup;
    }

    public final void setLynxGroup(LynxGroup lynxGroup) {
        this.lynxGroup = lynxGroup;
    }

    public final Boolean getUseStorageGroup() {
        return this.useStorageGroup;
    }

    public final void setUseStorageGroup(Boolean bool) {
        this.useStorageGroup = bool;
    }

    public final String getStorageGroupName() {
        return this.storageGroupName;
    }

    public final void setStorageGroupName(String str) {
        this.storageGroupName = str;
    }

    public final String getLynxGroupName() {
        return this.lynxGroupName;
    }

    public final void setLynxGroupName(String str) {
        this.lynxGroupName = str;
    }

    public final Integer getLynxWidth() {
        return this.lynxWidth;
    }

    public final void setLynxWidth(Integer num) {
        this.lynxWidth = num;
    }

    public final Integer getLynxHeight() {
        return this.lynxHeight;
    }

    public final void setLynxHeight(Integer num) {
        this.lynxHeight = num;
    }

    public final Integer getLynxInitWidth() {
        return this.lynxInitWidth;
    }

    public final void setLynxInitWidth(Integer num) {
        this.lynxInitWidth = num;
    }

    public final Integer getLynxInitHeight() {
        return this.lynxInitHeight;
    }

    public final void setLynxInitHeight(Integer num) {
        this.lynxInitHeight = num;
    }

    public final Integer getPresetHeightSpec() {
        return this.presetHeightSpec;
    }

    public final void setPresetHeightSpec(Integer num) {
        this.presetHeightSpec = num;
    }

    public final Integer getPresetWidthSpec() {
        return this.presetWidthSpec;
    }

    public final void setPresetWidthSpec(Integer num) {
        this.presetWidthSpec = num;
    }

    public final Float getFontScale() {
        return this.fontScale;
    }

    public final void setFontScale(Float f) {
        this.fontScale = f;
    }

    public final DynamicComponentFetcher getDynamicComponentFetcher() {
        return this.dynamicComponentFetcher;
    }

    public final void setDynamicComponentFetcher(DynamicComponentFetcher dynamicComponentFetcher) {
        this.dynamicComponentFetcher = dynamicComponentFetcher;
    }

    public final TemplateData getTemplateData() {
        return this.templateData;
    }

    public final void setTemplateData(TemplateData templateData) {
        this.templateData = templateData;
    }

    public final boolean getCreateViewAsync() {
        return this.createViewAsync;
    }

    public final void setCreateViewAsync(boolean z) {
        this.createViewAsync = z;
    }

    public final boolean getEnableSyncFlush() {
        return this.enableSyncFlush;
    }

    public final void setEnableSyncFlush(boolean z) {
        this.enableSyncFlush = z;
    }

    public final boolean getReadResourceInfoInMainThread() {
        return this.readResourceInfoInMainThread;
    }

    public final void setReadResourceInfoInMainThread(boolean z) {
        this.readResourceInfoInMainThread = z;
    }

    public final boolean getRenderTemplateInMainThread() {
        return this.renderTemplateInMainThread;
    }

    public final void setRenderTemplateInMainThread(boolean z) {
        this.renderTemplateInMainThread = z;
    }

    public final Function1<LynxViewBuilder, Unit> getCustomInit() {
        return this.customInit;
    }

    public final void setCustomInit(Function1<? super LynxViewBuilder, Unit> function1) {
        this.customInit = function1;
    }

    public final Map<String, String> getQueryMap() {
        return this.queryMap;
    }

    public final void setQueryMap(Map<String, String> map) {
        this.queryMap = map;
    }

    public final LynxRouterCallback getLynxRouterCallback() {
        return this.lynxRouterCallback;
    }

    public final void setLynxRouterCallback(LynxRouterCallback lynxRouterCallback) {
        this.lynxRouterCallback = lynxRouterCallback;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final Boolean getDisableAutoExpose() {
        return this.disableAutoExpose;
    }

    public final void setDisableAutoExpose(Boolean bool) {
        this.disableAutoExpose = bool;
    }

    public final LynxInitData getInitData() {
        return this.initData;
    }

    public final void setInitData(LynxInitData lynxInitData) {
        this.initData = lynxInitData;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final void setScreenWidth(int i) {
        this.screenWidth = i;
    }

    public final float getViewZoom() {
        return this.viewZoom;
    }

    public final void setViewZoom(float f) {
        this.viewZoom = f;
    }

    public final TemplateBundle getTemplateBundle() {
        return this.templateBundle;
    }

    public final void setTemplateBundle(TemplateBundle templateBundle) {
        this.templateBundle = templateBundle;
    }

    public final LynxLoadMeta.Builder getLynxLoadMeta() {
        return this.lynxLoadMeta;
    }

    public final void setLynxLoadMeta(LynxLoadMeta.Builder builder) {
        this.lynxLoadMeta = builder;
    }

    public final boolean getEnableVSyncAlignedMessageLoop() {
        return this.enableVSyncAlignedMessageLoop;
    }

    public final void setEnableVSyncAlignedMessageLoop(boolean z) {
        this.enableVSyncAlignedMessageLoop = z;
    }

    public final boolean getUseForest() {
        return this.useForest;
    }

    public final void setUseForest(boolean z) {
        this.useForest = z;
    }

    public final String getForestPreloadScope() {
        return this.forestPreloadScope;
    }

    public final void setForestPreloadScope(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.forestPreloadScope = str;
    }

    public final String getForestDownloadEngine() {
        return this.forestDownloadEngine;
    }

    public final void setForestDownloadEngine(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.forestDownloadEngine = str;
    }

    public final boolean getEnableLynxPredecode() {
        return this.enableLynxPredecode;
    }

    public final void setEnableLynxPredecode(boolean z) {
        this.enableLynxPredecode = z;
    }

    public final Boolean getEnableLynxGenericFetcher() {
        return this.enableLynxGenericFetcher;
    }

    public final void setEnableLynxGenericFetcher(Boolean bool) {
        this.enableLynxGenericFetcher = bool;
    }

    public final void setLynxGroup(String groupName, boolean shareGroup, boolean enableCanvas, String[] preloadJSPaths) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        setLynxGroup(groupName, shareGroup, enableCanvas, preloadJSPaths, false);
    }

    public final void setLynxGroup(String groupName, boolean shareGroup, boolean enableCanvas, String[] preloadJSPaths, boolean enableDynamicV8) {
        LynxGroup Create;
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        if (IConditionCallKt.enableFixedLynxGroup()) {
            this.lynxGroup = createLynxGroup$default(this, groupName, shareGroup, enableCanvas, preloadJSPaths, enableDynamicV8, false, null, 64, null);
            return;
        }
        this.lynxGroupName = groupName;
        if (Intrinsics.areEqual(groupName, "-1")) {
            this.lynxGroup = LynxGroup.Create(groupName, groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8);
            return;
        }
        if (shareGroup) {
            Create = LynxGroupHolder.INSTANCE.getOrCreateLynxGroup(groupName, preloadJSPaths, enableCanvas, enableDynamicV8);
        } else {
            Create = LynxGroup.Create(groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8);
        }
        this.lynxGroup = Create;
    }

    public final void setLynxGroup(String groupName, boolean shareGroup, boolean enableCanvas, String[] preloadJSPaths, boolean enableDynamicV8, boolean enableCanvasOptimization, Boolean enableJsGroupThread) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        setLynxGroup(groupName, shareGroup, enableCanvas, preloadJSPaths, enableDynamicV8, enableCanvasOptimization, false, enableJsGroupThread);
    }

    public final void setLynxGroup(String groupName, boolean shareGroup, boolean enableCanvas, String[] preloadJSPaths, boolean enableDynamicV8, boolean enableCanvasOptimization, boolean storageGroup, Boolean enableJsGroupThread) {
        LynxGroup Create;
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        if (storageGroup) {
            this.lynxGroup = LynxGroupHolder.INSTANCE.getOrCreateLynxGroup(groupName, preloadJSPaths, enableCanvas, enableDynamicV8, enableCanvasOptimization, true);
            return;
        }
        if (IConditionCallKt.enableFixedLynxGroup()) {
            this.lynxGroup = createLynxGroup(groupName, shareGroup, enableCanvas, preloadJSPaths, enableDynamicV8, enableCanvasOptimization, enableJsGroupThread);
            return;
        }
        this.lynxGroupName = groupName;
        if (Intrinsics.areEqual(groupName, "-1")) {
            this.lynxGroup = LynxGroup.Create(groupName, groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8, enableCanvasOptimization);
            return;
        }
        if (shareGroup) {
            Create = LynxGroupHolder.getOrCreateLynxGroup$default(LynxGroupHolder.INSTANCE, groupName, preloadJSPaths, enableCanvas, enableDynamicV8, enableCanvasOptimization, false, 32, null);
        } else {
            Create = LynxGroup.Create(groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8, enableCanvasOptimization);
        }
        this.lynxGroup = Create;
    }

    static /* synthetic */ LynxGroup createLynxGroup$default(LynxKitInitParams lynxKitInitParams, String str, boolean z, boolean z2, String[] strArr, boolean z3, boolean z4, Boolean bool, int i, Object obj) {
        return lynxKitInitParams.createLynxGroup(str, z, z2, strArr, z3, z4, (i & 64) != 0 ? false : bool);
    }

    private final LynxGroup createLynxGroup(String groupName, boolean shareGroup, boolean enableCanvas, String[] preloadJSPaths, boolean enableDynamicV8, boolean enableCanvasOptimization, Boolean enableJsGroupThread) {
        boolean z = true;
        if (Intrinsics.areEqual(enableJsGroupThread, true)) {
            LynxGroup.LynxGroupBuilder useProviderJsEnv = new LynxGroup.LynxGroupBuilder().setGroupName(groupName).setID(groupName).setPreloadJSPaths(preloadJSPaths).setUseProviderJsEnv(false);
            if (!enableCanvas && !enableCanvasOptimization) {
                z = false;
            }
            return useProviderJsEnv.setEnableCanvas(z).setEnableDynamicV8(enableDynamicV8).setEnableJSGroupThread(enableJsGroupThread).build();
        }
        if (shareGroup) {
            return LynxGroup.Create(groupName, groupName, preloadJSPaths, false, enableCanvas || enableCanvasOptimization, enableDynamicV8);
        }
        if (!enableCanvas && !enableCanvasOptimization) {
            z = false;
        }
        return LynxGroup.Create(groupName, preloadJSPaths, false, z, enableDynamicV8);
    }

    public final void addLynxClientDelegate(LynxViewClient lynxClientDelegate) {
        Intrinsics.checkNotNullParameter(lynxClientDelegate, "lynxClientDelegate");
        this.lynxClientDelegate.add(lynxClientDelegate);
    }

    public final List<LynxViewClient> lynxClientDelegate() {
        return this.lynxClientDelegate;
    }
}
