package com.bytedance.sdk.xbridge.cn.route;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.route.AbsXOpenMethodIDL;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: XOpenMethod.kt */
@XBridgeMethod(name = "x.open")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/route/XOpenMethod;", "Lcom/bytedance/sdk/xbridge/cn/route/AbsXOpenMethodIDL;", "()V", "whiteSchemas", "", "", "getRouterDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostRouterDepend;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/route/AbsXOpenMethodIDL$XOpenParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/route/AbsXOpenMethodIDL$XOpenResultModel;", "transformSchema", "schema", "sessionId", XBridgeInjectLogger.CALL_ID, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XOpenMethod extends AbsXOpenMethodIDL {
    private List<String> whiteSchemas = CollectionsKt.listOf(new String[]{"sslocal://lynxview", "sslocal://webview", "sslocal://lynxview_popup", "sslocal://webview_popup", "aweme://lynxview", "aweme://webview", "aweme://lynxview_popup", "aweme://webview_popup", "bullet://bullet", "sslocal://flower/lynxview", "sslocal://flower/webview", "sslocal://polaris/lynxview", "sslocal://polaris/webview", "sslocal://polaris/lynx", "sslocal://polaris/lynx_page", "sslocal://polaris/lynx_popup", "sslocal://polaris/lynxview_popup", "sslocal://polaris/webview", "sslocal://polaris/webview_popup", "sslocal://polaris/proxy"});

    /* JADX INFO: Access modifiers changed from: private */
    public final IHostRouterDepend getRouterDependInstance() {
        return XBaseRuntime.INSTANCE.getHostRouterDepend();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03ed  */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(final IBDXBridgeContext bridgeContext, AbsXOpenMethodIDL.XOpenParamModel params, CompletionBlock<AbsXOpenMethodIDL.XOpenResultModel> callback) {
        List<String> list;
        int i;
        String str;
        Object obj;
        Integer num;
        Object obj2;
        String str2;
        Object obj3;
        String str3;
        Object obj4;
        String str4;
        Object obj5;
        String str5;
        boolean z;
        String str6;
        final XOpenMethod xOpenMethod;
        Object obj6;
        String str7;
        CommonConfig commonConfig;
        Activity ownerActivity;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String schema = params.getSchema();
        boolean replace = params.getReplace();
        boolean useSysBrowser = params.getUseSysBrowser();
        Map<String, Object> extra = params.getExtra();
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage("session_id", bridgeContext.getContainerID());
        loggerContext.pushStage(XBridgeInjectLogger.CALL_ID, bridgeContext.getCallId());
        if (BulletEnv.Companion.getInstance().getDebuggable() && !useSysBrowser && StringsKt.startsWith$default(schema, "https://", false, 2, (Object) null) && (ownerActivity = bridgeContext.getOwnerActivity()) != null) {
            Toast.makeText(ownerActivity, "不支持以https开头的schema,请确认使用 \"sslocal://webview\" 或者 \"aweme://webview\" 格式schema", 1).show();
        }
        HybridLogger.INSTANCE.i("BridgeParam", "x.openParam", MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", schema), TuplesKt.to("replace", Boolean.valueOf(replace)), TuplesKt.to("useSysBrowser", Boolean.valueOf(useSysBrowser)), TuplesKt.to("replaceType", params.getReplaceType()), TuplesKt.to("starterSessionId", bridgeContext.getContainerID())}), loggerContext);
        if (schema.length() == 0) {
            HybridLogger.INSTANCE.e("BridgeParam", "schema should not be empty", MapsKt.mapOf(TuplesKt.to("schema", schema)), loggerContext);
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "schema should not be empty", null, 4, null);
            return;
        }
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (list = commonConfig.getXOpenWhiteSchemas()) == null) {
            list = this.whiteSchemas;
        }
        this.whiteSchemas = list;
        String transformSchema = transformSchema(schema, bridgeContext.getContainerID(), bridgeContext.getCallId());
        HybridLogger.INSTANCE.i("BridgeParam", "x.open transformSchema", MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", schema), TuplesKt.to("realSchema", transformSchema)}), loggerContext);
        Activity ownerActivity2 = bridgeContext.getOwnerActivity();
        if (ownerActivity2 == null) {
            num = 0;
            str = transformSchema;
            obj = "useSysBrowser";
            i = 2;
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            Unit unit = Unit.INSTANCE;
        } else {
            i = 2;
            str = transformSchema;
            obj = "useSysBrowser";
            num = 0;
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(obj, Boolean.valueOf(useSysBrowser));
        if (extra == null) {
            extra = MapsKt.emptyMap();
        }
        pairArr[1] = TuplesKt.to("extra", extra);
        pairArr[i] = TuplesKt.to("open_schema_with_replace", Boolean.valueOf(replace));
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(pairArr);
        if (!replace) {
            IHostRouterDepend routerDependInstance = getRouterDependInstance();
            boolean openSchema = routerDependInstance != null ? routerDependInstance.openSchema(bridgeContext, str, mapOf, ownerActivity2) : false;
            if (openSchema) {
                AbsXOpenMethodIDL.XOpenResultModel xOpenResultModel = (AbsXOpenMethodIDL.XOpenResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXOpenMethodIDL.XOpenResultModel.class));
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                Pair[] pairArr2 = new Pair[i];
                pairArr2[0] = TuplesKt.to("success", Boolean.valueOf(openSchema));
                pairArr2[1] = TuplesKt.to("bridgeCallBack", String.valueOf(xOpenResultModel.convert()));
                hybridLogger.e("BridgeResult", "x.openResult", MapsKt.mapOf(pairArr2), loggerContext);
                CompletionBlock.DefaultImpls.onSuccess$default(callback, xOpenResultModel, null, i, null);
                return;
            }
            HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
            Pair[] pairArr3 = new Pair[3];
            pairArr3[0] = TuplesKt.to("success", Boolean.valueOf(openSchema));
            pairArr3[1] = TuplesKt.to("code", num);
            pairArr3[i] = TuplesKt.to("message", "Failed to open schema: " + schema);
            hybridLogger2.e("BridgeResult", "x.openResult", MapsKt.mapOf(pairArr3), loggerContext);
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Failed to open schema: " + schema, null, 4, null);
            return;
        }
        Integer num2 = num;
        String str8 = str;
        String replaceType = params.getReplaceType();
        int hashCode = replaceType.hashCode();
        if (hashCode == -1465864472) {
            obj2 = "code";
            str2 = "BridgeResult";
            obj3 = "bridgeCallBack";
            str3 = "x.openResult";
            obj4 = "success";
            str4 = "Failed to open schema: ";
            obj5 = "message";
            if (replaceType.equals("onlyCloseAfterOpenSucceed")) {
                IHostRouterDepend routerDependInstance2 = getRouterDependInstance();
                if (routerDependInstance2 != null && routerDependInstance2.openSchema(bridgeContext, str8, mapOf, ownerActivity2)) {
                    if (AnnieXLiteUtilsKt.isLitePage(bridgeContext) != null && IConditionCallKt.annieXLitePageFixCloseAfterOpenSuccessInternal() > 0) {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.route.XOpenMethod$handle$success$2
                            @Override // java.lang.Runnable
                            public final void run() {
                                IHostRouterDepend routerDependInstance3;
                                routerDependInstance3 = XOpenMethod.this.getRouterDependInstance();
                                if (routerDependInstance3 != null) {
                                    IHostRouterDepend.DefaultImpls.closeView$default(routerDependInstance3, bridgeContext, null, false, 6, null);
                                }
                            }
                        }, IConditionCallKt.annieXLitePageFixCloseAfterOpenSuccessInternal());
                    } else {
                        IHostRouterDepend routerDependInstance3 = getRouterDependInstance();
                        if (routerDependInstance3 != null) {
                            str5 = str4;
                            IHostRouterDepend.DefaultImpls.closeView$default(routerDependInstance3, bridgeContext, null, false, 6, null);
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                    str5 = str4;
                    z = true;
                    if (!z) {
                    }
                }
            }
            str5 = str4;
            z = false;
            if (!z) {
            }
        } else if (hashCode == 169053298) {
            obj3 = "bridgeCallBack";
            str3 = "x.openResult";
            obj4 = "success";
            obj5 = "message";
            if (replaceType.equals("alwaysCloseBeforeOpen")) {
                IHostRouterDepend routerDependInstance4 = getRouterDependInstance();
                if (routerDependInstance4 != null) {
                    str2 = "BridgeResult";
                    str6 = "Failed to open schema: ";
                    obj2 = "code";
                    IHostRouterDepend.DefaultImpls.closeView$default(routerDependInstance4, bridgeContext, null, false, 6, null);
                } else {
                    str2 = "BridgeResult";
                    str6 = "Failed to open schema: ";
                    obj2 = "code";
                }
                IHostRouterDepend routerDependInstance5 = getRouterDependInstance();
                z = routerDependInstance5 != null ? routerDependInstance5.openSchema(bridgeContext, str8, mapOf, ownerActivity2) : false;
                str5 = str6;
                if (!z) {
                }
            } else {
                str2 = "BridgeResult";
                obj2 = "code";
                str4 = "Failed to open schema: ";
                str5 = str4;
                z = false;
                if (!z) {
                }
            }
        } else if (hashCode == 2116215581 && replaceType.equals("alwaysCloseAfterOpen")) {
            IHostRouterDepend routerDependInstance6 = getRouterDependInstance();
            boolean openSchema2 = routerDependInstance6 != null ? routerDependInstance6.openSchema(bridgeContext, str8, mapOf, ownerActivity2) : false;
            if (AnnieXLiteUtilsKt.isLitePage(bridgeContext) != null && IConditionCallKt.annieXLitePageFixCloseAfterOpenInternal() > 0) {
                xOpenMethod = this;
                obj3 = "bridgeCallBack";
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.route.XOpenMethod$handle$success$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        IHostRouterDepend routerDependInstance7;
                        routerDependInstance7 = XOpenMethod.this.getRouterDependInstance();
                        if (routerDependInstance7 != null) {
                            IHostRouterDepend.DefaultImpls.closeView$default(routerDependInstance7, bridgeContext, null, false, 6, null);
                        }
                    }
                }, IConditionCallKt.annieXLitePageFixCloseAfterOpenInternal());
            } else {
                xOpenMethod = this;
                obj3 = "bridgeCallBack";
                IHostRouterDepend routerDependInstance7 = getRouterDependInstance();
                if (routerDependInstance7 != null) {
                    str3 = "x.openResult";
                    obj4 = "success";
                    str5 = "Failed to open schema: ";
                    obj6 = "code";
                    str7 = "BridgeResult";
                    obj5 = "message";
                    IHostRouterDepend.DefaultImpls.closeView$default(routerDependInstance7, bridgeContext, null, false, 6, null);
                    z = openSchema2;
                    obj2 = obj6;
                    str2 = str7;
                    if (!z) {
                        AbsXOpenMethodIDL.XOpenResultModel xOpenResultModel2 = (AbsXOpenMethodIDL.XOpenResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXOpenMethodIDL.XOpenResultModel.class));
                        HybridLogger.INSTANCE.e(str2, str3, MapsKt.mapOf(new Pair[]{TuplesKt.to(obj4, Boolean.valueOf(z)), TuplesKt.to(obj3, String.valueOf(xOpenResultModel2.convert()))}), loggerContext);
                        CompletionBlock.DefaultImpls.onSuccess$default(callback, xOpenResultModel2, null, 2, null);
                        return;
                    } else {
                        HybridLogger.INSTANCE.e(str2, str3, MapsKt.mapOf(new Pair[]{TuplesKt.to(obj4, Boolean.valueOf(z)), TuplesKt.to(obj2, num2), TuplesKt.to(obj5, str5 + schema)}), loggerContext);
                        CompletionBlock.DefaultImpls.onFailure$default(callback, 0, str5 + schema, null, 4, null);
                        return;
                    }
                }
            }
            str5 = "Failed to open schema: ";
            obj6 = "code";
            str7 = "BridgeResult";
            str3 = "x.openResult";
            obj4 = "success";
            obj5 = "message";
            z = openSchema2;
            obj2 = obj6;
            str2 = str7;
            if (!z) {
            }
        } else {
            obj2 = "code";
            str2 = "BridgeResult";
            obj3 = "bridgeCallBack";
            str3 = "x.openResult";
            obj4 = "success";
            str4 = "Failed to open schema: ";
            obj5 = "message";
            str5 = str4;
            z = false;
            if (!z) {
            }
        }
    }

    private final String transformSchema(String schema, String sessionId, String callId) {
        Iterator<T> it = this.whiteSchemas.iterator();
        while (it.hasNext()) {
            if (StringsKt.startsWith$default(schema, (String) it.next(), false, 2, (Object) null)) {
                String uri = Uri.parse(schema).buildUpon().appendQueryParameter("__bullet_trident_starter_session_id", sessionId).appendQueryParameter("__bullet_trident_call_id", callId).build().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "builder\n                …              .toString()");
                return uri;
            }
        }
        return schema;
    }
}
