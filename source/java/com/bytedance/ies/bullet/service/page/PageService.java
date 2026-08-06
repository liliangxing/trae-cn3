package com.bytedance.ies.bullet.service.page;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.IPageConfig;
import com.bytedance.ies.bullet.service.base.IPageService;
import com.bytedance.ies.bullet.service.base.api.UIShowConfig;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.pia.core.plugins.PiaPropsPlugin;
import com.bytedance.push.interfaze.IMessageCallbackService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PageService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/service/page/PageService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/IPageService;", "pageConfig", "Lcom/bytedance/ies/bullet/service/base/IPageConfig;", "(Lcom/bytedance/ies/bullet/service/base/IPageConfig;)V", PiaPropsPlugin.PROPS_NAME_PAGE_CONFIG, "()Lcom/bytedance/ies/bullet/service/base/IPageConfig;", "getFlag", "", "schema", "Landroid/net/Uri;", "(Landroid/net/Uri;)Ljava/lang/Integer;", IMessageCallbackService.EVENT_TYPE_SHOW, "", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PageService extends BaseBulletService implements IPageService {
    private final IPageConfig pageConfig;

    @Override // com.bytedance.ies.bullet.service.base.IPageService
    public IPageConfig getPageConfig() {
        return this.pageConfig;
    }

    public PageService(IPageConfig iPageConfig) {
        Intrinsics.checkNotNullParameter(iPageConfig, "pageConfig");
        this.pageConfig = iPageConfig;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IBulletUIService
    public boolean show(Context context, Uri schema, UIShowConfig config) {
        Integer requestCode;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(config, "config");
        Class<? extends Activity> activityClazz = getPageConfig().getActivityClazz();
        boolean z = false;
        if (activityClazz == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, activityClazz));
        intent.setData(schema);
        boolean z2 = context instanceof Activity;
        if (!z2) {
            intent.addFlags(268435456);
        }
        Integer flags = config.getFlags();
        if (flags != null) {
            intent.addFlags(flags.intValue());
        }
        Integer flag = getFlag(schema);
        if (flag != null) {
            intent.addFlags(flag.intValue());
        }
        intent.putExtras(config.getBundle());
        Unit unit2 = null;
        if (z2 && (requestCode = config.getRequestCode()) != null) {
            int intValue = requestCode.intValue();
            Bundle animationBundle = config.getAnimationBundle();
            if (animationBundle != null) {
                ((Activity) context).startActivityForResult(intent, intValue, animationBundle);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ((Activity) context).startActivityForResult(intent, intValue);
            }
            z = true;
        }
        if (!z) {
            Bundle animationBundle2 = config.getAnimationBundle();
            if (animationBundle2 != null) {
                context.startActivity(intent, animationBundle2);
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                context.startActivity(intent);
            }
        }
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Map<String, ? extends Object> mapOf = MapsKt.mapOf(TuplesKt.to("url", schema.toString()));
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(XConstant.SESSION_ID, config.getSessionId());
        loggerContext.pushStage(XConstant.CALL_ID, config.getCallId());
        Unit unit3 = Unit.INSTANCE;
        hybridLogger.m11i("XRouter", "create page container successfully", mapOf, loggerContext);
        return true;
    }

    private final Integer getFlag(Uri schema) {
        Object obj;
        Uri parse;
        try {
            Result.Companion companion = Result.Companion;
            String queryParameter = schema.getQueryParameter("url");
            obj = Result.constructor-impl((queryParameter == null || (parse = Uri.parse(queryParameter)) == null) ? null : parse.getQueryParameter("ug_campaign_launch_mode"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (Intrinsics.areEqual(str, "clear_top")) {
            return 67108864;
        }
        if (str != null) {
            return StringsKt.toIntOrNull(str);
        }
        return null;
    }
}
