package com.bytedance.ies.bullet.p003ui.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.container.util.ResUtil;
import com.bytedance.android.anniex.utils.AnnieXUrlExtKt;
import com.bytedance.ies.bullet.base.core.common.PadAdapterStyle;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.core.util.ContextUtil;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.DoubleParam;
import com.bytedance.ies.bullet.service.sdk.param.PercentParam;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BulletPadAdapterUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001fJG\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0002\u0010&J)\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010*J3\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010-J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020/J\u001a\u00105\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u0001072\b\u00102\u001a\u0004\u0018\u000103J\u001a\u00108\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u0001072\b\u00102\u001a\u0004\u0018\u000103J\u0010\u00109\u001a\u00020:2\b\u00106\u001a\u0004\u0018\u000107JP\u0010;\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040<2\b\u0010=\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020/JF\u0010A\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040<2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020/H\u0002JF\u0010B\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040<2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020/H\u0002J@\u0010C\u001a\u00020D2\b\u0010=\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006E"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/BulletPadAdapterUtil;", "", "()V", "ANNIE_TITLE_BAR_HEIGHT", "", "FOLD_SCREEN_WIDTH", "FOLD_SCREEN_WIDTH_PERCENT_DEFAULT", "", "PAD_WIDTH_PERCENT_DEFAULT", "STYLE_CHANNEL_STYLE", "", "STYLE_UNIFORM_STYLE", "STYLE_WIDTH_PERCENT", "TAG", "TITLE_BAR_HEIGHT", "padAdapterHeight", "getPadAdapterHeight", "()Ljava/lang/Integer;", "setPadAdapterHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "padAdapterWidth", "getPadAdapterWidth", "setPadAdapterWidth", "calculateHeightSize", "context", "Landroid/content/Context;", "schemeHeight", "percentHeight", "aspectRatio", "initWidth", "(Landroid/content/Context;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;)Ljava/lang/Integer;", "calculateHeightSizeForUniformStyle", "containerHeight", "(Landroid/content/Context;ILjava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;)Ljava/lang/Integer;", "calculateSize", "calculatedSchemeSize", "padRatioSize", "(Ljava/lang/Integer;I)I", "calculateWidthSize", "schemeWidth", "percentWidth", "(Landroid/content/Context;Ljava/lang/Double;Ljava/lang/Integer;)Ljava/lang/Integer;", "calculateWidthSizeForUniformStyle", "windowWidthDp", "(Landroid/content/Context;ILjava/lang/Double;Ljava/lang/Integer;)Ljava/lang/Integer;", "enableAdapterPad", "", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "scenes", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "isFromAnnieXContainer", "enablePageChannelStyle", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "enablePageUniformStyle", "getPadAdapterStyle", "Lcom/bytedance/ies/bullet/base/core/common/PadAdapterStyle;", "getPadKitViewInfo", "Lkotlin/Pair;", "bid", "configuration", "Landroid/content/res/Configuration;", "fromBullet", "getPadKitViewInfoChannel", "getPadKitViewInfoUniform", "logPadAdaption", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletPadAdapterUtil {
    private static final int ANNIE_TITLE_BAR_HEIGHT = 44;
    private static final int FOLD_SCREEN_WIDTH = 400;
    private static final double FOLD_SCREEN_WIDTH_PERCENT_DEFAULT = 0.8d;
    public static final BulletPadAdapterUtil INSTANCE = new BulletPadAdapterUtil();
    private static final double PAD_WIDTH_PERCENT_DEFAULT = 0.6d;
    private static final String STYLE_CHANNEL_STYLE = "channel_style";
    private static final String STYLE_UNIFORM_STYLE = "uniform_style";
    private static final String STYLE_WIDTH_PERCENT = "width_percent";
    private static final String TAG = "BulletPadAdapterUtil";
    private static final int TITLE_BAR_HEIGHT = 52;
    private static Integer padAdapterHeight;
    private static Integer padAdapterWidth;

    private BulletPadAdapterUtil() {
    }

    public final Integer getPadAdapterWidth() {
        return padAdapterWidth;
    }

    public final void setPadAdapterWidth(Integer num) {
        padAdapterWidth = num;
    }

    public final Integer getPadAdapterHeight() {
        return padAdapterHeight;
    }

    public final void setPadAdapterHeight(Integer num) {
        padAdapterHeight = num;
    }

    public final PadAdapterStyle getPadAdapterStyle(ISchemaData schemaData) {
        if (schemaData != null && ((AnnieXRuntime.INSTANCE.getDeviceDepend().isPad() || AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) && IConditionCallKt.enablePadPopupMigrationToUniformStyle(schemaData) && Intrinsics.areEqual(AnnieXUrlExtKt.getType(schemaData.getInnerOriginUrl()), RouterConstants.TYPE_POPUP))) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadAdapterStyle：popup migration To UNIFORM_STYLE", null, null, 12, null);
            return PadAdapterStyle.UNIFORM_STYLE;
        }
        String value = schemaData != null ? new StringParam(schemaData, "pad_adapter", null).getValue() : null;
        if (value != null) {
            int hashCode = value.hashCode();
            if (hashCode != -2126048564) {
                if (hashCode != 1779691381) {
                    if (hashCode == 1911047014 && value.equals(STYLE_UNIFORM_STYLE)) {
                        if (IConditionCallKt.enablePadAdapterUniformStyle()) {
                            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadAdapterStyle：UNIFORM_STYLE", null, null, 12, null);
                            return PadAdapterStyle.UNIFORM_STYLE;
                        }
                        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadAdapterStyle：disable UNIFORM_STYLE，replace to WIDTH_PERCENT", null, null, 12, null);
                        return PadAdapterStyle.WIDTH_PERCENT;
                    }
                } else if (value.equals(STYLE_CHANNEL_STYLE)) {
                    if (IConditionCallKt.enablePadAdapterChannelStyle()) {
                        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadAdapterStyle：CHANNEL_STYLE", null, null, 12, null);
                        return PadAdapterStyle.CHANNEL_STYLE;
                    }
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadAdapterStyle：disable CHANNEL_STYLE，replace to WIDTH_PERCENT", null, null, 12, null);
                    return PadAdapterStyle.NONE;
                }
            } else if (value.equals(STYLE_WIDTH_PERCENT)) {
                if (IConditionCallKt.enablePadAdapterMigrationToUniformStyle(schemaData)) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadAdapterStyle：migration To UNIFORM_STYLE", null, null, 12, null);
                    return PadAdapterStyle.UNIFORM_STYLE;
                }
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadAdapterStyle：WIDTH_PERCENT", null, null, 12, null);
                return PadAdapterStyle.WIDTH_PERCENT;
            }
        }
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadAdapterStyle：NONE", null, null, 12, null);
        return PadAdapterStyle.NONE;
    }

    public final boolean enablePageUniformStyle(ISchemaData schemaData, Scenes scenes) {
        return getPadAdapterStyle(schemaData) == PadAdapterStyle.UNIFORM_STYLE && scenes != Scenes.PopupFragment;
    }

    public final boolean enablePageChannelStyle(ISchemaData schemaData, Scenes scenes) {
        return getPadAdapterStyle(schemaData) == PadAdapterStyle.CHANNEL_STYLE && scenes != Scenes.PopupFragment;
    }

    public static /* synthetic */ void logPadAdaption$default(BulletPadAdapterUtil bulletPadAdapterUtil, String str, Context context, SchemaModelUnion schemaModelUnion, Scenes scenes, Configuration configuration, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        bulletPadAdapterUtil.logPadAdaption(str, context, schemaModelUnion, scenes, configuration, z);
    }

    public final void logPadAdaption(String bid, Context context, SchemaModelUnion schemaModelUnion, Scenes scenes, Configuration configuration, boolean fromBullet) {
        Function2<String, JSONObject, Unit> teaReporter;
        ISchemaData schemaData;
        MonitorConfig config;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(IMonitorReportService.class);
        if (iMonitorReportService == null || (config = iMonitorReportService.getConfig()) == null || (teaReporter = config.getTeaReporter()) == null) {
            teaReporter = MonitorReportService.INSTANCE.getFallbackDefault().getConfig().getTeaReporter();
        }
        if (teaReporter != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bid", bid);
            Uri uri = null;
            jSONObject.put("pad_adapter", INSTANCE.getPadAdapterStyle(schemaModelUnion != null ? schemaModelUnion.getSchemaData() : null).getStyle());
            if (schemaModelUnion != null && (schemaData = schemaModelUnion.getSchemaData()) != null) {
                uri = schemaData.getInnerOriginUrl();
            }
            jSONObject.put("schema", uri);
            jSONObject.put("from_bullet", fromBullet);
            Unit unit = Unit.INSTANCE;
            teaReporter.invoke("cross_container_pad_adaptation", jSONObject);
        }
    }

    public static /* synthetic */ Pair getPadKitViewInfo$default(BulletPadAdapterUtil bulletPadAdapterUtil, String str, Context context, SchemaModelUnion schemaModelUnion, Scenes scenes, Configuration configuration, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        return bulletPadAdapterUtil.getPadKitViewInfo(str, context, schemaModelUnion, scenes, configuration, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0420  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Integer, Integer> getPadKitViewInfo(String bid, Context context, SchemaModelUnion schemaModelUnion, Scenes scenes, Configuration configuration, boolean fromBullet) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        Integer num;
        Double d;
        Integer num2;
        Double d2;
        Boolean bool7;
        String str;
        Double d3;
        Boolean bool8;
        Integer num3;
        Integer num4;
        Integer valueOf;
        Integer valueOf2;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer valueOf3;
        Integer num8;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Integer num9;
        Integer num10;
        ISchemaData schemaData;
        ISchemaData schemaData2;
        ISchemaData schemaData3;
        ISchemaData schemaData4;
        ISchemaData schemaData5;
        ISchemaData schemaData6;
        ISchemaData schemaData7;
        ISchemaData schemaData8;
        ISchemaData schemaData9;
        ISchemaData schemaData10;
        ISchemaData schemaData11;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (enablePageUniformStyle(schemaModelUnion != null ? schemaModelUnion.getSchemaData() : null, scenes)) {
            return getPadKitViewInfoUniform(context, schemaModelUnion, scenes, configuration, fromBullet);
        }
        if (enablePageChannelStyle(schemaModelUnion != null ? schemaModelUnion.getSchemaData() : null, scenes)) {
            return getPadKitViewInfoChannel(context, schemaModelUnion, scenes, configuration, fromBullet);
        }
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfo：start", null, null, 12, null);
        Pair<Integer, Integer> screenInfo = context != null ? BulletDeviceUtils.INSTANCE.getScreenInfo(context) : null;
        Double value = (schemaModelUnion == null || (schemaData11 = schemaModelUnion.getSchemaData()) == null) ? null : new DoubleParam(schemaData11, "width", null).getValue();
        Integer value2 = (schemaModelUnion == null || (schemaData10 = schemaModelUnion.getSchemaData()) == null) ? null : new PercentParam(schemaData10, STYLE_WIDTH_PERCENT, null).getValue();
        Double value3 = (schemaModelUnion == null || (schemaData9 = schemaModelUnion.getSchemaData()) == null) ? null : new DoubleParam(schemaData9, "height", null).getValue();
        Integer value4 = (schemaModelUnion == null || (schemaData8 = schemaModelUnion.getSchemaData()) == null) ? null : new PercentParam(schemaData8, "height_percent", null).getValue();
        Double value5 = (schemaModelUnion == null || (schemaData7 = schemaModelUnion.getSchemaData()) == null) ? null : new DoubleParam(schemaData7, "aspect_ratio", null).getValue();
        Double value6 = (schemaModelUnion == null || (schemaData6 = schemaModelUnion.getSchemaData()) == null) ? null : new DoubleParam(schemaData6, SchemaConstants.QUERY_KEY_PAD_RATIO, null).getValue();
        String value7 = (schemaModelUnion == null || (schemaData5 = schemaModelUnion.getSchemaData()) == null) ? null : new StringParam(schemaData5, "pad_adapter", null).getValue();
        int i5 = 0;
        if (schemaModelUnion == null || (schemaData4 = schemaModelUnion.getSchemaData()) == null) {
            bool = null;
        } else {
            bool = new BooleanParam(schemaData4, SchemaConstants.QUERY_KEY_HIDE_NAV_BAR, Boolean.valueOf(scenes != Scenes.AbsActivity)).getValue();
        }
        Boolean value8 = (schemaModelUnion == null || (schemaData3 = schemaModelUnion.getSchemaData()) == null) ? null : new BooleanParam(schemaData3, SchemaConstants.QUERY_KEY_HIDE_STATUS_BAR, false).getValue();
        if (schemaModelUnion == null || (schemaData2 = schemaModelUnion.getSchemaData()) == null) {
            bool2 = bool;
            bool3 = null;
        } else {
            bool2 = bool;
            bool3 = new BooleanParam(schemaData2, SchemaConstants.QUERY_KEY_TRANS_STATUS_BAR, false).getValue();
        }
        if (schemaModelUnion == null || (schemaData = schemaModelUnion.getSchemaData()) == null) {
            bool4 = bool3;
            bool5 = null;
        } else {
            bool4 = bool3;
            bool5 = new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOULD_FULL_SCREEN, false).getValue();
        }
        Integer calculateWidthSize = context != null ? INSTANCE.calculateWidthSize(context, value, value2) : null;
        if (context != null) {
            num = calculateWidthSize;
            bool6 = bool2;
            d = value;
            bool7 = bool5;
            Integer num11 = value2;
            bool8 = bool4;
            num3 = num11;
            Integer num12 = value4;
            num2 = value4;
            str = value7;
            Double d4 = value5;
            d2 = value5;
            d3 = value6;
            num4 = INSTANCE.calculateHeightSize(context, value3, num12, d4, num);
        } else {
            bool6 = bool2;
            num = calculateWidthSize;
            d = value;
            num2 = value4;
            d2 = value5;
            bool7 = bool5;
            str = value7;
            d3 = value6;
            Integer num13 = value2;
            bool8 = bool4;
            num3 = num13;
            num4 = null;
        }
        if ((d3 == null && str == null) || screenInfo == null) {
            num7 = num;
            num8 = null;
            valueOf3 = null;
        } else {
            int intValue = ((Number) screenInfo.component1()).intValue();
            int intValue2 = ((Number) screenInfo.component2()).intValue();
            if (str != null) {
                if (Intrinsics.areEqual(str, STYLE_WIDTH_PERCENT)) {
                    if (context != null) {
                        Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(context);
                        i = context.getResources().getConfiguration().screenWidthDp;
                        i2 = context.getResources().getConfiguration().screenHeightDp;
                        z = ownerActivity != null ? ownerActivity.isInMultiWindowMode() : false;
                        i3 = Intrinsics.areEqual(bool6, false) ? UIUtils.dpToPx$anniex_release(52, context) : 0;
                        i4 = (Intrinsics.areEqual(value8, true) || Intrinsics.areEqual(bool7, true)) ? BulletDeviceUtils.INSTANCE.getStatusBarHeight(context) : 0;
                        num9 = Integer.valueOf((UIUtils.dpToPx$anniex_release(i2, context) - i3) + i4);
                    } else {
                        z = false;
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        num9 = null;
                    }
                    if (!z) {
                        if (!AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                            if (AnnieXRuntime.INSTANCE.getDeviceDepend().isPad()) {
                                Integer valueOf4 = Integer.valueOf((int) (intValue * PAD_WIDTH_PERCENT_DEFAULT));
                                if (context != null && UIUtils.px2dp$anniex_release(valueOf4.intValue(), context) < 375) {
                                    valueOf4 = Integer.valueOf(intValue);
                                }
                                num10 = valueOf4;
                            }
                            num10 = null;
                        } else if (i > 400) {
                            num10 = Integer.valueOf((int) (intValue * FOLD_SCREEN_WIDTH_PERCENT_DEFAULT));
                        } else {
                            num10 = Integer.valueOf(intValue);
                        }
                        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "contentWidthDp: " + i + "; contentHeightDp:" + i2 + "; navigationBarHeight: " + i3 + ";isInMultiWindowMode:" + z + "; statusBarHeight:" + i4, null, null, 12, null);
                        num5 = num10;
                        num6 = num9;
                        if (num6 != null) {
                        }
                        Integer valueOf5 = Integer.valueOf(intValue2);
                        if (num5 == null) {
                        }
                        valueOf3 = Integer.valueOf(intValue);
                        num8 = valueOf5;
                    } else {
                        if (context != null) {
                            if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                                num10 = Integer.valueOf(UIUtils.dpToPx$anniex_release(i, context));
                            } else {
                                if (320 <= i && i < 516) {
                                    num10 = Integer.valueOf(UIUtils.dpToPx$anniex_release(i, context));
                                } else {
                                    if (516 <= i && i < 768) {
                                        num10 = Integer.valueOf((int) (UIUtils.dpToPx$anniex_release(i, context) * FOLD_SCREEN_WIDTH_PERCENT_DEFAULT));
                                    } else if (i >= 768) {
                                        num10 = Integer.valueOf((int) (UIUtils.dpToPx$anniex_release(i, context) * PAD_WIDTH_PERCENT_DEFAULT));
                                    }
                                }
                            }
                            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "contentWidthDp: " + i + "; contentHeightDp:" + i2 + "; navigationBarHeight: " + i3 + ";isInMultiWindowMode:" + z + "; statusBarHeight:" + i4, null, null, 12, null);
                            num5 = num10;
                            num6 = num9;
                            if (num6 != null) {
                                intValue2 = INSTANCE.calculateSize(num4, num6.intValue());
                            }
                            Integer valueOf52 = Integer.valueOf(intValue2);
                            if (num5 == null) {
                                num7 = num;
                                intValue = INSTANCE.calculateSize(num7, num5.intValue());
                            } else {
                                num7 = num;
                            }
                            valueOf3 = Integer.valueOf(intValue);
                            num8 = valueOf52;
                        }
                        num10 = null;
                        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "contentWidthDp: " + i + "; contentHeightDp:" + i2 + "; navigationBarHeight: " + i3 + ";isInMultiWindowMode:" + z + "; statusBarHeight:" + i4, null, null, 12, null);
                        num5 = num10;
                        num6 = num9;
                        if (num6 != null) {
                        }
                        Integer valueOf522 = Integer.valueOf(intValue2);
                        if (num5 == null) {
                        }
                        valueOf3 = Integer.valueOf(intValue);
                        num8 = valueOf522;
                    }
                }
                num6 = null;
                num5 = null;
                if (num6 != null) {
                }
                Integer valueOf5222 = Integer.valueOf(intValue2);
                if (num5 == null) {
                }
                valueOf3 = Integer.valueOf(intValue);
                num8 = valueOf5222;
            } else {
                if (d3 != null) {
                    double d5 = intValue;
                    double d6 = intValue2;
                    double d7 = d5 / d6;
                    if (Intrinsics.areEqual(bid, BidConstants.WEBCAST)) {
                        if (context != null) {
                            int dp2Px = Intrinsics.areEqual(bool6, false) ? ResUtil.INSTANCE.dp2Px(44) : 0;
                            if (Intrinsics.areEqual(value8, false) && Intrinsics.areEqual(bool8, false)) {
                                i5 = BulletDeviceUtils.INSTANCE.getStatusBarHeight(context);
                            }
                            intValue2 = ((intValue2 - dp2Px) - i5) - UIUtils.INSTANCE.getRealNavigationBarHeight(context);
                        }
                        if (d7 > d3.doubleValue()) {
                            valueOf = Integer.valueOf((int) (intValue2 * d3.doubleValue()));
                            valueOf2 = Integer.valueOf(intValue2);
                        } else {
                            valueOf = Integer.valueOf(intValue);
                            valueOf2 = Integer.valueOf(intValue2);
                        }
                    } else if (d7 > d3.doubleValue()) {
                        valueOf = Integer.valueOf((int) (d6 * d3.doubleValue()));
                        valueOf2 = Integer.valueOf(intValue2);
                    } else {
                        valueOf = Integer.valueOf(intValue);
                        valueOf2 = Integer.valueOf((int) (d5 / d3.doubleValue()));
                    }
                    num5 = valueOf;
                    num6 = valueOf2;
                    if (num6 != null) {
                    }
                    Integer valueOf52222 = Integer.valueOf(intValue2);
                    if (num5 == null) {
                    }
                    valueOf3 = Integer.valueOf(intValue);
                    num8 = valueOf52222;
                }
                num6 = null;
                num5 = null;
                if (num6 != null) {
                }
                Integer valueOf522222 = Integer.valueOf(intValue2);
                if (num5 == null) {
                }
                valueOf3 = Integer.valueOf(intValue);
                num8 = valueOf522222;
            }
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "getPadKitViewInfo: screenInfo=" + screenInfo + ",padRatio=" + d3 + ",width=" + valueOf3 + ",height=" + num8 + ",schemeHeight=" + value3 + ",aspectRatio=" + d2 + ",percentHeight=" + num2 + ",calculatedSchemeHeight=" + num4 + ",schemeWidth=" + d + ",percentWidth=" + num3 + ",calculatedSchemeWidth=" + num7, null, null, 6, null);
        padAdapterWidth = valueOf3;
        padAdapterHeight = num8;
        return new Pair<>(valueOf3, num8);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Integer, Integer> getPadKitViewInfoUniform(Context context, SchemaModelUnion schemaModelUnion, Scenes scenes, Configuration configuration, boolean fromBullet) {
        boolean z;
        int i;
        ISchemaData schemaData;
        Boolean value;
        ISchemaData schemaData2;
        Boolean value2;
        ISchemaData schemaData3;
        ISchemaData schemaData4;
        ISchemaData schemaData5;
        ISchemaData schemaData6;
        ISchemaData schemaData7;
        ISchemaData schemaData8;
        Double d = null;
        if (context == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：context is null", null, null, 12, null);
            padAdapterWidth = null;
            padAdapterHeight = null;
            return new Pair<>((Object) null, (Object) null);
        }
        Double value3 = (schemaModelUnion == null || (schemaData8 = schemaModelUnion.getSchemaData()) == null) ? null : new DoubleParam(schemaData8, "width", null).getValue();
        Integer value4 = (schemaModelUnion == null || (schemaData7 = schemaModelUnion.getSchemaData()) == null) ? null : new PercentParam(schemaData7, STYLE_WIDTH_PERCENT, null).getValue();
        Double value5 = (schemaModelUnion == null || (schemaData6 = schemaModelUnion.getSchemaData()) == null) ? null : new DoubleParam(schemaData6, "height", null).getValue();
        Integer value6 = (schemaModelUnion == null || (schemaData5 = schemaModelUnion.getSchemaData()) == null) ? null : new PercentParam(schemaData5, "height_percent", null).getValue();
        if (schemaModelUnion != null && (schemaData4 = schemaModelUnion.getSchemaData()) != null) {
            d = new DoubleParam(schemaData4, "aspect_ratio", null).getValue();
        }
        Double d2 = d;
        if (schemaModelUnion != null && (schemaData3 = schemaModelUnion.getSchemaData()) != null) {
            Boolean value7 = new BooleanParam(schemaData3, SchemaConstants.QUERY_KEY_HIDE_NAV_BAR, Boolean.valueOf(scenes != Scenes.AbsActivity)).getValue();
            if (value7 != null) {
                z = value7.booleanValue();
                boolean booleanValue = (schemaModelUnion != null || (schemaData2 = schemaModelUnion.getSchemaData()) == null || (value2 = new BooleanParam(schemaData2, SchemaConstants.QUERY_KEY_HIDE_STATUS_BAR, false).getValue()) == null) ? false : value2.booleanValue();
                boolean booleanValue2 = (schemaModelUnion != null || (schemaData = schemaModelUnion.getSchemaData()) == null || (value = new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOULD_FULL_SCREEN, false).getValue()) == null) ? false : value.booleanValue();
                i = configuration.screenWidthDp;
                int i2 = configuration.screenHeightDp;
                int statusBarHeight = (!booleanValue || booleanValue2) ? BulletDeviceUtils.INSTANCE.getStatusBarHeight(context) : 0;
                int i3 = (!z || (booleanValue2 && fromBullet)) ? 0 : fromBullet ? 44 : 52;
                int dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(i2 - i3, context) + statusBarHeight;
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：statusBarHeight=" + UIUtils.px2dp$anniex_release(statusBarHeight, context) + ",titleBarHeight=" + i3 + ",containerHeight=" + UIUtils.px2dp$anniex_release(dpToPx$anniex_release, context), null, null, 12, null);
                if (i > 480) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：窗口尺寸(" + i + StringListParam.SPLIT_DELIMITER + i2 + ")，小于480dp全屏展示", null, null, 12, null);
                    padAdapterWidth = Integer.valueOf(UIUtils.dpToPx$anniex_release(i, context));
                    padAdapterHeight = Integer.valueOf(dpToPx$anniex_release);
                    return new Pair<>(-1, -1);
                }
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：窗口尺寸(" + i + StringListParam.SPLIT_DELIMITER + i2 + "), 容器高度=" + UIUtils.px2dp$anniex_release(dpToPx$anniex_release, context) + "，schema参数（width=" + value3 + "，width_percent=" + value4 + "，height=" + value5 + "，height_percent=" + value6 + "，aspect_ratio=" + d2 + (char) 65289, null, null, 12, null);
                Integer calculateWidthSizeForUniformStyle = calculateWidthSizeForUniformStyle(context, i, value3, value4);
                int intValue = calculateWidthSizeForUniformStyle != null ? calculateWidthSizeForUniformStyle.intValue() : 0;
                if (intValue > 0) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：使用自定义宽度，width=" + UIUtils.px2dp$anniex_release(intValue, context), null, null, 12, null);
                } else if (i <= 704) {
                    int i4 = (int) (i * FOLD_SCREEN_WIDTH_PERCENT_DEFAULT);
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：小于704断点，使用窗口宽度80%，width=" + i4, null, null, 12, null);
                    intValue = UIUtils.dpToPx$anniex_release(i4, context);
                } else {
                    int i5 = (int) (i * 0.65d);
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：大于704断点，使用窗口宽度65%，width=" + i5, null, null, 12, null);
                    intValue = UIUtils.dpToPx$anniex_release(i5, context);
                }
                int i6 = intValue;
                Integer calculateHeightSizeForUniformStyle = calculateHeightSizeForUniformStyle(context, dpToPx$anniex_release, value5, value6, d2, Integer.valueOf(i6));
                int intValue2 = calculateHeightSizeForUniformStyle != null ? calculateHeightSizeForUniformStyle.intValue() : 0;
                if (intValue2 > 0) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：使用自定义高度，height=" + UIUtils.px2dp$anniex_release(intValue2, context), null, null, 12, null);
                } else {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：高度全屏展示，height=" + UIUtils.px2dp$anniex_release(dpToPx$anniex_release, context), null, null, 12, null);
                    intValue2 = dpToPx$anniex_release;
                }
                padAdapterWidth = Integer.valueOf(i6);
                padAdapterHeight = Integer.valueOf(intValue2);
                return new Pair<>(Integer.valueOf(i6), Integer.valueOf(intValue2 != dpToPx$anniex_release ? intValue2 : -1));
            }
        }
        z = false;
        if (schemaModelUnion != null) {
        }
        if (schemaModelUnion != null) {
        }
        i = configuration.screenWidthDp;
        int i22 = configuration.screenHeightDp;
        if (booleanValue) {
        }
        if (z) {
        }
        int dpToPx$anniex_release2 = UIUtils.dpToPx$anniex_release(i22 - i3, context) + statusBarHeight;
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoUniform：statusBarHeight=" + UIUtils.px2dp$anniex_release(statusBarHeight, context) + ",titleBarHeight=" + i3 + ",containerHeight=" + UIUtils.px2dp$anniex_release(dpToPx$anniex_release2, context), null, null, 12, null);
        if (i > 480) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Integer, Integer> getPadKitViewInfoChannel(Context context, SchemaModelUnion schemaModelUnion, Scenes scenes, Configuration configuration, boolean fromBullet) {
        boolean z;
        int i;
        ISchemaData schemaData;
        Boolean value;
        ISchemaData schemaData2;
        Boolean value2;
        ISchemaData schemaData3;
        ISchemaData schemaData4;
        ISchemaData schemaData5;
        ISchemaData schemaData6;
        ISchemaData schemaData7;
        ISchemaData schemaData8;
        Double d = null;
        if (context == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：context is null", null, null, 12, null);
            padAdapterWidth = null;
            padAdapterHeight = null;
            return new Pair<>((Object) null, (Object) null);
        }
        Double value3 = (schemaModelUnion == null || (schemaData8 = schemaModelUnion.getSchemaData()) == null) ? null : new DoubleParam(schemaData8, "width", null).getValue();
        Integer value4 = (schemaModelUnion == null || (schemaData7 = schemaModelUnion.getSchemaData()) == null) ? null : new PercentParam(schemaData7, STYLE_WIDTH_PERCENT, null).getValue();
        Double value5 = (schemaModelUnion == null || (schemaData6 = schemaModelUnion.getSchemaData()) == null) ? null : new DoubleParam(schemaData6, "height", null).getValue();
        Integer value6 = (schemaModelUnion == null || (schemaData5 = schemaModelUnion.getSchemaData()) == null) ? null : new PercentParam(schemaData5, "height_percent", null).getValue();
        if (schemaModelUnion != null && (schemaData4 = schemaModelUnion.getSchemaData()) != null) {
            d = new DoubleParam(schemaData4, "aspect_ratio", null).getValue();
        }
        Double d2 = d;
        if (schemaModelUnion != null && (schemaData3 = schemaModelUnion.getSchemaData()) != null) {
            Boolean value7 = new BooleanParam(schemaData3, SchemaConstants.QUERY_KEY_HIDE_NAV_BAR, Boolean.valueOf(scenes != Scenes.AbsActivity)).getValue();
            if (value7 != null) {
                z = value7.booleanValue();
                boolean booleanValue = (schemaModelUnion != null || (schemaData2 = schemaModelUnion.getSchemaData()) == null || (value2 = new BooleanParam(schemaData2, SchemaConstants.QUERY_KEY_HIDE_STATUS_BAR, false).getValue()) == null) ? false : value2.booleanValue();
                boolean booleanValue2 = (schemaModelUnion != null || (schemaData = schemaModelUnion.getSchemaData()) == null || (value = new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOULD_FULL_SCREEN, false).getValue()) == null) ? false : value.booleanValue();
                i = configuration.screenWidthDp;
                int i2 = configuration.screenHeightDp;
                int statusBarHeight = ((!booleanValue || booleanValue2) ? BulletDeviceUtils.INSTANCE.getStatusBarHeight(context) : 0) + UIUtils.dpToPx$anniex_release(i2 - ((!z || (booleanValue2 && fromBullet)) ? 0 : fromBullet ? 44 : 52), context);
                HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：窗口尺寸(" + i + StringListParam.SPLIT_DELIMITER + i2 + "), 容器高度=" + UIUtils.px2dp$anniex_release(statusBarHeight, context) + "，schema参数（width=" + value3 + "，width_percent=" + value4 + "，height=" + value5 + "，height_percent=" + value6 + "，aspect_ratio=" + d2 + (char) 65289, null, null, 12, null);
                if (i > 480) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：窗口宽度小于480dp全屏展示", null, null, 12, null);
                    padAdapterWidth = Integer.valueOf(UIUtils.dpToPx$anniex_release(i, context));
                    padAdapterHeight = Integer.valueOf(statusBarHeight);
                    return new Pair<>(-1, -1);
                }
                Integer calculateWidthSizeForUniformStyle = calculateWidthSizeForUniformStyle(context, i, value3, value4);
                int intValue = calculateWidthSizeForUniformStyle != null ? calculateWidthSizeForUniformStyle.intValue() : 0;
                if (intValue > 0) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：使用自定义宽度，width=" + UIUtils.px2dp$anniex_release(intValue, context), null, null, 12, null);
                } else if (AnnieXRuntime.INSTANCE.getDeviceDepend().isPad()) {
                    if (configuration.orientation == 2) {
                        if (i <= 1024) {
                            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：Pad-LANDSCAPE-窗口宽度<=1024，width=390", null, null, 12, null);
                            intValue = UIUtils.dpToPx$anniex_release(390, context);
                        } else {
                            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：Pad-LANDSCAPE-窗口宽度>1024，width=540", null, null, 12, null);
                            intValue = UIUtils.dpToPx$anniex_release(540, context);
                        }
                    } else if (i <= 1024) {
                        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：Pad-PORTRAIT-窗口宽度<=1024，width=" + Math.min(i, 540), null, null, 12, null);
                        intValue = UIUtils.dpToPx$anniex_release(Math.min(i, 540), context);
                    } else {
                        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：Pad-PORTRAIT-窗口宽度>1024，width=" + Math.min(i, 620), null, null, 12, null);
                        intValue = UIUtils.dpToPx$anniex_release(Math.min(i, 620), context);
                    }
                } else if (!AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
                    intValue = UIUtils.dpToPx$anniex_release(i, context);
                } else if (i <= 480) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：Fold-窗口宽度<=480，width=窗口宽度", null, null, 12, null);
                    intValue = UIUtils.dpToPx$anniex_release(i, context);
                } else {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：Fold-窗口宽度>480，width=390", null, null, 12, null);
                    intValue = UIUtils.dpToPx$anniex_release(390, context);
                }
                int i3 = intValue;
                Integer calculateHeightSizeForUniformStyle = calculateHeightSizeForUniformStyle(context, statusBarHeight, value5, value6, d2, Integer.valueOf(i3));
                int intValue2 = calculateHeightSizeForUniformStyle != null ? calculateHeightSizeForUniformStyle.intValue() : 0;
                if (intValue2 > 0) {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：使用自定义高度，height=" + UIUtils.px2dp$anniex_release(intValue2, context), null, null, 12, null);
                } else {
                    HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：高度全屏展示", null, null, 12, null);
                    intValue2 = statusBarHeight;
                }
                padAdapterWidth = Integer.valueOf(i3);
                padAdapterHeight = Integer.valueOf(intValue2);
                return new Pair<>(Integer.valueOf(i3), Integer.valueOf(intValue2 != statusBarHeight ? intValue2 : -1));
            }
        }
        z = false;
        if (schemaModelUnion != null) {
        }
        if (schemaModelUnion != null) {
        }
        i = configuration.screenWidthDp;
        int i22 = configuration.screenHeightDp;
        int statusBarHeight2 = ((!booleanValue || booleanValue2) ? BulletDeviceUtils.INSTANCE.getStatusBarHeight(context) : 0) + UIUtils.dpToPx$anniex_release(i22 - ((!z || (booleanValue2 && fromBullet)) ? 0 : fromBullet ? 44 : 52), context);
        HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "getPadKitViewInfoChannel：窗口尺寸(" + i + StringListParam.SPLIT_DELIMITER + i22 + "), 容器高度=" + UIUtils.px2dp$anniex_release(statusBarHeight2, context) + "，schema参数（width=" + value3 + "，width_percent=" + value4 + "，height=" + value5 + "，height_percent=" + value6 + "，aspect_ratio=" + d2 + (char) 65289, null, null, 12, null);
        if (i > 480) {
        }
    }

    public final boolean enableAdapterPad(SchemaModelUnion schemaModelUnion, Scenes scenes, boolean isFromAnnieXContainer) {
        CommonConfig commonConfig;
        Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
        if (!AnnieXRuntime.INSTANCE.getDeviceDepend().isPad() && !AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
            return false;
        }
        String value = new StringParam(schemaModelUnion.getSchemaData(), "pad_adapter", null).getValue();
        if (enablePageUniformStyle(schemaModelUnion.getSchemaData(), scenes) || enablePageChannelStyle(schemaModelUnion.getSchemaData(), scenes)) {
            return true;
        }
        if (IConditionCallKt.disablePopupPadAdapter()) {
            if (Intrinsics.areEqual(value, STYLE_WIDTH_PERCENT) && scenes != Scenes.PopupFragment) {
                return true;
            }
        } else if (Intrinsics.areEqual(value, STYLE_WIDTH_PERCENT)) {
            return true;
        }
        if (IConditionCallKt.disableAnnieXPopupPadAdapter() && scenes == Scenes.PopupFragment && isFromAnnieXContainer) {
            return false;
        }
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        Boolean enableIpadAdapter = (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? null : commonConfig.getEnableIpadAdapter();
        Boolean value2 = new BooleanParam(schemaModelUnion.getSchemaData(), SchemaConstants.QUERY_KEY_PAD_ADAPTER, null).getValue();
        Double value3 = new DoubleParam(schemaModelUnion.getSchemaData(), SchemaConstants.QUERY_KEY_PAD_RATIO, null).getValue();
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "enableAdapterPad : enableIpadAdapter=" + enableIpadAdapter + ",schemeEnableIpadAdapter=" + value2 + ",padRatio=" + value3 + ",scenes=" + (scenes != null ? scenes.name() : null), null, null, 6, null);
        if (Intrinsics.areEqual(enableIpadAdapter, true) && Intrinsics.areEqual(value2, true) && value3 != null) {
            return scenes == Scenes.AbsActivity || scenes == Scenes.PopupFragment;
        }
        return false;
    }

    public final int calculateSize(Integer calculatedSchemeSize, int padRatioSize) {
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "calculateSize: calculatedSchemeSize=" + calculatedSchemeSize + ",padRatioSize=" + padRatioSize, null, null, 6, null);
        return (calculatedSchemeSize == null || calculatedSchemeSize.intValue() == 0) ? padRatioSize : Math.min(calculatedSchemeSize.intValue(), padRatioSize);
    }

    public final Integer calculateWidthSize(Context context, Double schemeWidth, Integer percentWidth) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (percentWidth != null && percentWidth.intValue() != 0) {
            return Integer.valueOf((percentWidth.intValue() * BulletDeviceUtils.INSTANCE.getScreenWidth(context)) / 100);
        }
        if (schemeWidth != null) {
            return Integer.valueOf((int) BulletDeviceUtils.INSTANCE.dip2Px(context, (float) schemeWidth.doubleValue()));
        }
        return null;
    }

    public final Integer calculateHeightSize(Context context, Double schemeHeight, Integer percentHeight, Double aspectRatio, Integer initWidth) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (percentHeight != null && percentHeight.intValue() != 0) {
            return Integer.valueOf((percentHeight.intValue() * BulletDeviceUtils.INSTANCE.getScreenHeight(context)) / 100);
        }
        if (schemeHeight != null) {
            return Integer.valueOf((int) BulletDeviceUtils.INSTANCE.dip2Px(context, (float) schemeHeight.doubleValue()));
        }
        if (aspectRatio == null || initWidth == null) {
            return null;
        }
        return Integer.valueOf((int) (aspectRatio.doubleValue() * initWidth.intValue()));
    }

    private final Integer calculateWidthSizeForUniformStyle(Context context, int windowWidthDp, Double schemeWidth, Integer percentWidth) {
        if (percentWidth != null && percentWidth.intValue() != 0) {
            return Integer.valueOf((percentWidth.intValue() * UIUtils.dpToPx$anniex_release(windowWidthDp, context)) / 100);
        }
        if (schemeWidth != null) {
            return Integer.valueOf((int) BulletDeviceUtils.INSTANCE.dip2Px(context, (float) schemeWidth.doubleValue()));
        }
        return null;
    }

    private final Integer calculateHeightSizeForUniformStyle(Context context, int containerHeight, Double schemeHeight, Integer percentHeight, Double aspectRatio, Integer initWidth) {
        if (percentHeight != null && percentHeight.intValue() != 0) {
            return Integer.valueOf((percentHeight.intValue() * containerHeight) / 100);
        }
        if (schemeHeight != null) {
            return Integer.valueOf((int) BulletDeviceUtils.INSTANCE.dip2Px(context, (float) schemeHeight.doubleValue()));
        }
        if (aspectRatio == null || initWidth == null) {
            return null;
        }
        return Integer.valueOf((int) (aspectRatio.doubleValue() * initWidth.intValue()));
    }
}
