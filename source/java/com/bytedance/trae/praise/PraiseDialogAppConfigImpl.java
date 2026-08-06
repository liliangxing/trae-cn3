package com.bytedance.trae.praise;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig;
import com.bytedance.praisedialoglib.utils.EventReportUtil;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PraiseDialogAppConfigImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogAppConfigImpl;", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogAppConfig;", "<init>", "()V", "getHost", "", "getAppId", "getDeviceId", "getPackageName", "onEvent", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "Lorg/json/JSONObject;", "goToFeedback", "context", "Landroid/content/Context;", "feedbackUrl", "needShowDefaultDialog", "", "handleNoAppMarket", "getHuaWeiAppId", "getTopActivity", "Landroid/app/Activity;", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialogAppConfigImpl implements IPraiseDialogAppConfig {
    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public String getHuaWeiAppId() {
        return "117273863";
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public void goToFeedback(Context context, String feedbackUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedbackUrl, "feedbackUrl");
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public boolean handleNoAppMarket() {
        return false;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public boolean needShowDefaultDialog() {
        return false;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public String getHost() {
        return StringsKt.trimEnd(HostResolver.INSTANCE.getBaseUrl(HostType.PRAISE), new char[]{'/'});
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public String getAppId() {
        return String.valueOf(AppHost.Companion.getAppId());
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public String getDeviceId() {
        return IApplog.Companion.getDeviceId();
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public String getPackageName() {
        String packageName = AppHost.Companion.getApplication().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return packageName;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public void onEvent(String eventName, JSONObject params) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(params, "params");
        IApplog.Companion.reportEvent(eventName, params);
        int hashCode = eventName.hashCode();
        if (hashCode == 319288017) {
            if (eventName.equals(EventReportUtil.EVENT_NAME_POP_GOOD)) {
                PraiseDialogTrigger.INSTANCE.onRateClicked();
            }
        } else if (hashCode == 319638801) {
            if (eventName.equals(EventReportUtil.EVENT_NAME_POP_SHOW)) {
                PraiseDialogTrigger.INSTANCE.onDialogShown();
            }
        } else if (hashCode == 841578353 && eventName.equals(EventReportUtil.EVENT_NAME_POP_BAD)) {
            PraiseDialogTrigger.INSTANCE.onLaterClicked();
        }
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    public Activity getTopActivity() {
        return AppHost.Companion.getActivityStackManager().getCurrentActivity();
    }
}
