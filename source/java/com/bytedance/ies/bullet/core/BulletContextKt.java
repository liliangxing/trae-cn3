package com.bytedance.ies.bullet.core;

import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.bullet.core.kit.service.BaseBridgeService;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.secure.HybridSecureConfig;
import com.bytedance.ies.bullet.secure.HybridSecureManager;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.web.pia.IPIAParamsService;
import com.bytedance.ies.bullet.web.pia.PiaHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0004\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0004H\u0000\u001a\f\u0010\r\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0000\u001a\f\u0010\u0010\u001a\u00020\u0003*\u0004\u0018\u00010\u0004\u001a\f\u0010\u0011\u001a\u00020\u0003*\u0004\u0018\u00010\u0004\u001a\f\u0010\u0012\u001a\u00020\u0003*\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0013\u001a\u00020\u0003*\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u001a\f\u0010\u0016\u001a\u00020\u0003*\u0004\u0018\u00010\u0004¨\u0006\u0017"}, d2 = {"initArgusSecureDelegate", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "forceLifeCycleOnUiThread", "", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getPerfMetric", "", "key", "", "getPerfMetrics", "Lorg/json/JSONObject;", "getSecureConfig", "Lcom/bytedance/ies/bullet/secure/HybridSecureConfig;", "setupAnniePro", "setupPia", "bid", "usePiperData", "useWebXBridge3", "useXBride3", "useXBridge3", "type", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "useXBridge3BySchema", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletContextKt {

    /* compiled from: BulletContext.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KitType.values().length];
            try {
                iArr[KitType.LYNX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KitType.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long getPerfMetric(BulletContext bulletContext, String str) {
        Intrinsics.checkNotNullParameter(bulletContext, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return bulletContext.getMonitorCallback().getPerfMetric(str);
    }

    public static final JSONObject getPerfMetrics(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "<this>");
        return bulletContext.getMonitorCallback().getPerfMetrics();
    }

    public static final boolean useXBridge3(BulletContext bulletContext, KitType kitType) {
        int i = kitType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kitType.ordinal()];
        if (i == 1) {
            return useXBride3(bulletContext);
        }
        if (i != 2) {
            return false;
        }
        return useWebXBridge3(bulletContext);
    }

    public static final boolean useXBride3(BulletContext bulletContext) {
        boolean z;
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        Boolean value;
        String bid;
        if (bulletContext != null && (bid = bulletContext.getBid()) != null) {
            IBulletService iBulletService = ServiceCenter.INSTANCE.instance().get(bid, IBridgeService.class);
            BaseBridgeService baseBridgeService = iBulletService instanceof BaseBridgeService ? (BaseBridgeService) iBulletService : null;
            Boolean valueOf = baseBridgeService != null ? Boolean.valueOf(baseBridgeService.useXBridge3()) : null;
            if (valueOf != null) {
                z = valueOf.booleanValue();
                boolean booleanValue = (bulletContext != null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null || (value = new BooleanParam(schemaData, SchemaConstants.XBRIDGE_USE3, Boolean.valueOf(z)).getValue()) == null) ? z : value.booleanValue();
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContext.useXBride3: res=" + booleanValue + ", defaultVal=" + z, null, null, 6, null);
                return booleanValue;
            }
        }
        z = false;
        if (bulletContext != null) {
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContext.useXBride3: res=" + booleanValue + ", defaultVal=" + z, null, null, 6, null);
        return booleanValue;
    }

    public static final boolean usePiperData(BulletContext bulletContext) {
        boolean z;
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        Boolean value;
        String bid;
        if (bulletContext != null && (bid = bulletContext.getBid()) != null) {
            IBulletService iBulletService = ServiceCenter.INSTANCE.instance().get(bid, IBridgeService.class);
            BaseBridgeService baseBridgeService = iBulletService instanceof BaseBridgeService ? (BaseBridgeService) iBulletService : null;
            Boolean valueOf = baseBridgeService != null ? Boolean.valueOf(baseBridgeService.usePiperData()) : null;
            if (valueOf != null) {
                z = valueOf.booleanValue();
                boolean booleanValue = (bulletContext != null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null || (value = new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_USE_PIPER_DATA, Boolean.valueOf(z)).getValue()) == null) ? z : value.booleanValue();
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContext.usePiperData: res=" + booleanValue + ", defaultVal=" + z, null, null, 6, null);
                return booleanValue;
            }
        }
        z = false;
        if (bulletContext != null) {
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContext.usePiperData: res=" + booleanValue + ", defaultVal=" + z, null, null, 6, null);
        return booleanValue;
    }

    public static final boolean useWebXBridge3(BulletContext bulletContext) {
        boolean z;
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        Boolean value;
        String bid;
        if (bulletContext != null && (bid = bulletContext.getBid()) != null) {
            IBulletService iBulletService = ServiceCenter.INSTANCE.instance().get(bid, IBridgeService.class);
            BaseBridgeService baseBridgeService = iBulletService instanceof BaseBridgeService ? (BaseBridgeService) iBulletService : null;
            Boolean valueOf = baseBridgeService != null ? Boolean.valueOf(baseBridgeService.useWebXBridge3()) : null;
            if (valueOf != null) {
                z = valueOf.booleanValue();
                boolean booleanValue = (bulletContext != null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null || (value = new BooleanParam(schemaData, SchemaConstants.XBRIDGE_USE3, Boolean.valueOf(z)).getValue()) == null) ? z : value.booleanValue();
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContext.useXBride3: res=" + booleanValue + ", defaultVal=" + z, null, null, 6, null);
                return booleanValue;
            }
        }
        z = true;
        if (bulletContext != null) {
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContext.useXBride3: res=" + booleanValue + ", defaultVal=" + z, null, null, 6, null);
        return booleanValue;
    }

    public static final boolean useXBridge3BySchema(BulletContext bulletContext) {
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        Boolean value;
        boolean z = false;
        if (bulletContext != null && (schemaModelUnion = bulletContext.getSchemaModelUnion()) != null && (schemaData = schemaModelUnion.getSchemaData()) != null && (value = new BooleanParam(schemaData, SchemaConstants.XBRIDGE_USE3, false).getValue()) != null) {
            z = value.booleanValue();
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContext.useXBridge3BySchema: res=" + z, null, null, 6, null);
        return z;
    }

    public static final boolean forceLifeCycleOnUiThread(BulletContext bulletContext) {
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        Boolean value;
        if (bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null || (value = new BooleanParam(schemaData, "force_lifecycle_on_ui", false).getValue()) == null) {
            return false;
        }
        return value.booleanValue();
    }

    public static final boolean setupPia(BulletContext bulletContext, String str) {
        Intrinsics.checkNotNullParameter(bulletContext, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        ISchemaData schemaData = bulletContext.getSchemaData();
        if (schemaData == null || !Intrinsics.areEqual(new BooleanParam(schemaData, XConstant.PARAM_KEY_PIA, null).getValue(), true)) {
            return false;
        }
        bulletContext.getWebContext().setEnablePia(true);
        String value = new StringParam(schemaData, "url", null).getValue();
        if (value != null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContext.setupPia: url=" + value, null, null, 6, null);
            IPIAParamsService iPIAParamsService = (IPIAParamsService) ServiceCenter.INSTANCE.instance().get(str, IPIAParamsService.class);
            if (iPIAParamsService != null) {
                value = iPIAParamsService.processAndUpdateUrl(value);
            }
            PiaHelper.INSTANCE.warmup(value, str, bulletContext.getSessionId(), bulletContext.getSchemaModelUnion());
        }
        return true;
    }

    public static final boolean setupAnniePro(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "<this>");
        ISchemaData schemaData = bulletContext.getSchemaData();
        if (schemaData == null || !Intrinsics.areEqual(new BooleanParam(schemaData, XConstant.PARAM_KEY_ANNIE_PRO, null).getValue(), true)) {
            return false;
        }
        bulletContext.getContainerContext().setAnniePro(true);
        return true;
    }

    public static final HybridSecureConfig getSecureConfig(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "<this>");
        HybridSecureManager companion = HybridSecureManager.INSTANCE.getInstance();
        String bid = bulletContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        return companion.getSecureConfig$anniex_release(bid);
    }

    public static final ArgusContainerDelegate initArgusSecureDelegate() {
        return HybridSecureManager.INSTANCE.getInstance().initArgusSecureDelegate();
    }
}
