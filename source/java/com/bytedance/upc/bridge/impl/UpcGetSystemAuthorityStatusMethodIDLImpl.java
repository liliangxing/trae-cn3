package com.bytedance.upc.bridge.impl;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.view.View;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IPrivacyService;
import com.bytedance.upc.bridge.abs.AbsUpcGetSystemAuthorityStatusMethodIDL;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.utils.ClipBoardUtils;
import com.bytedance.upc.common.utils.RomUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* compiled from: UpcGetSystemAuthorityStatusMethodIDLImpl.kt */
@XBridgeMethod(name = "upc.getSystemAuthorityStatus", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/upc/bridge/impl/UpcGetSystemAuthorityStatusMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL;", "()V", "SCHEME_FORMAT", "", "getPermissionStatus", "", "", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "authorityList", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList;", "handle", "", "params", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$UpcGetSystemAuthorityStatusParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$UpcGetSystemAuthorityStatusResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcGetSystemAuthorityStatusMethodIDLImpl extends AbsUpcGetSystemAuthorityStatusMethodIDL {
    private final String SCHEME_FORMAT = "upcsdk://upc.system?package=%s&action=%s&target=settings&permission=%s";

    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsUpcGetSystemAuthorityStatusMethodIDL.UpcGetSystemAuthorityStatusParamModel) xBaseParamModel, (CompletionBlock<AbsUpcGetSystemAuthorityStatusMethodIDL.UpcGetSystemAuthorityStatusResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsUpcGetSystemAuthorityStatusMethodIDL.UpcGetSystemAuthorityStatusParamModel params, CompletionBlock<AbsUpcGetSystemAuthorityStatusMethodIDL.UpcGetSystemAuthorityStatusResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            final List<Map<String, Object>> permissionStatus = getPermissionStatus(bridgeContext, params.getAuthorityList());
            CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsUpcGetSystemAuthorityStatusMethodIDL.UpcGetSystemAuthorityStatusResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcGetSystemAuthorityStatusMethodIDLImpl$handle$1
                @Override // com.bytedance.upc.bridge.abs.AbsUpcGetSystemAuthorityStatusMethodIDL.UpcGetSystemAuthorityStatusResultModel
                public void setAuthorityResultList(List<? extends AbsUpcGetSystemAuthorityStatusMethodIDL.XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList> list) {
                }

                @Override // com.bytedance.upc.bridge.abs.AbsUpcGetSystemAuthorityStatusMethodIDL.UpcGetSystemAuthorityStatusResultModel
                public List<AbsUpcGetSystemAuthorityStatusMethodIDL.XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList> getAuthorityResultList() {
                    return CollectionsKt.emptyList();
                }

                public Map<String, Object> convert() {
                    return MapsKt.mapOf(TuplesKt.to("authorityResultList", permissionStatus));
                }

                public JSONObject toJSON() {
                    return new JSONObject();
                }
            }, (String) null, 2, (Object) null);
        } catch (Throwable th) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -1, "get system authority error: " + th, (XBaseResultModel) null, 4, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<Map<String, Object>> getPermissionStatus(IBDXBridgeContext bridgeContext, List<? extends AbsUpcGetSystemAuthorityStatusMethodIDL.XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList> authorityList) {
        Context context;
        String str;
        int i;
        List<? extends AbsUpcGetSystemAuthorityStatusMethodIDL.XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList> list = authorityList;
        if (list == null || list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        View engineView = bridgeContext.getEngineView();
        if (engineView == null || (context = engineView.getContext()) == null) {
            return CollectionsKt.emptyList();
        }
        Configuration configuration = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        ArrayList arrayList = new ArrayList();
        for (AbsUpcGetSystemAuthorityStatusMethodIDL.XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList xBridgeBeanUpcGetSystemAuthorityStatusAuthorityList : authorityList) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, xBridgeBeanUpcGetSystemAuthorityStatusAuthorityList.getType());
            String type = xBridgeBeanUpcGetSystemAuthorityStatusAuthorityList.getType();
            str = "system";
            switch (type.hashCode()) {
                case -1953474717:
                    if (type.equals("OTHERS")) {
                        i = context.checkPermission("android.permission.READ_CONTACTS", Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "OTHERS"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format);
                        break;
                    }
                    break;
                case -1611296843:
                    if (type.equals("LOCATION")) {
                        i = (context.checkPermission("android.permission.ACCESS_COARSE_LOCATION", Process.myPid(), Process.myUid()) == 0 || context.checkPermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid()) == 0) ? 1 : 0;
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String format2 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "LOCATION"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format2);
                        break;
                    }
                    break;
                case -1354519578:
                    if (type.equals("ACCOUNTS")) {
                        i = context.checkPermission("android.permission.GET_ACCOUNTS", Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
                        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                        String format3 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "ACCOUNTS"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format3);
                        break;
                    }
                    break;
                case -1166291365:
                    if (type.equals("STORAGE")) {
                        i = (Build.VERSION.SDK_INT < 33 || context.getApplicationInfo().targetSdkVersion < 33 ? context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0 || context.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0 : context.checkPermission("android.permission.READ_MEDIA_AUDIO", Process.myPid(), Process.myUid()) == 0 || context.checkPermission("android.permission.READ_MEDIA_IMAGES", Process.myPid(), Process.myUid()) == 0 || context.checkPermission("android.permission.READ_LOGS", Process.myPid(), Process.myUid()) == 0) ? 1 : 0;
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                        String format4 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "STORAGE"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format4);
                        break;
                    }
                    break;
                case 62628790:
                    if (type.equals("AUDIO")) {
                        i = context.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
                        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                        String format5 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "AUDIO"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format5, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format5);
                        break;
                    }
                    break;
                case 76105038:
                    if (type.equals("PHONE")) {
                        i = context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
                        StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                        String format6 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "PHONE"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format6, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format6);
                        break;
                    }
                    break;
                case 215175251:
                    if (type.equals("CONTACTS")) {
                        i = context.checkPermission("android.permission.READ_CONTACTS", Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
                        StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
                        String format7 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "CONTACTS"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format7, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format7);
                        break;
                    }
                    break;
                case 604302142:
                    if (type.equals("CALENDAR")) {
                        i = (context.checkPermission("android.permission.WRITE_CALENDAR", Process.myPid(), Process.myUid()) == 0 || context.checkPermission("android.permission.READ_CALENDAR", Process.myPid(), Process.myUid()) == 0) ? 1 : 0;
                        StringCompanionObject stringCompanionObject8 = StringCompanionObject.INSTANCE;
                        String format8 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "CALENDAR"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format8, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format8);
                        break;
                    }
                    break;
                case 1186196854:
                    if (type.equals("CLIPBOARD")) {
                        RomUtils romUtils = RomUtils.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(romUtils, "RomUtils.getInstance()");
                        str = romUtils.isHigherMi12V2() ? "system" : "app";
                        RomUtils romUtils2 = RomUtils.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(romUtils2, "RomUtils.getInstance()");
                        if (romUtils2.isHigherMi12V2()) {
                            i = ClipBoardUtils.canReadClipMiuiV12();
                        } else {
                            IPrivacyService iPrivacyService = configuration.mIPrivacyService;
                            i = Intrinsics.areEqual(iPrivacyService != null ? IPrivacyService.DefaultImpls.getPrivacyStatus$default(iPrivacyService, "80", "off", 0, 4, (Object) null) : null, "on");
                        }
                        StringCompanionObject stringCompanionObject9 = StringCompanionObject.INSTANCE;
                        String format9 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "CLIPBOARD"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format9, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format9);
                        linkedHashMap.put("privacyType", "80");
                        break;
                    }
                    break;
                case 1980544805:
                    if (type.equals("CAMERA")) {
                        i = context.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
                        StringCompanionObject stringCompanionObject10 = StringCompanionObject.INSTANCE;
                        String format10 = String.format(this.SCHEME_FORMAT, Arrays.copyOf(new Object[]{context.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "CAMERA"}, 3));
                        Intrinsics.checkNotNullExpressionValue(format10, "java.lang.String.format(format, *args)");
                        linkedHashMap.put(StrategyConstants.SCHEMA, format10);
                        break;
                    }
                    break;
            }
            i = 0;
            linkedHashMap.put("status", Integer.valueOf(i));
            linkedHashMap.put("authorityType", str);
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }
}
