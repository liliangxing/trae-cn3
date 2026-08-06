package com.bytedance.ies.bullet.service.router;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.LifeCycleManager;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IPopUpService;
import com.bytedance.ies.bullet.service.base.IRouterAbilityProvider;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.router.config.StackManager;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.service.sdk.param.LaunchModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.notification.Constants;
import com.bytedance.perf.monitor.ReportConst;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: NestingDollUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ2\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/service/router/NestingDollUtil;", "", "()V", "clearTopActivity", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "logContext", "Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "closeAffinity", "sessionId", "", "self", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", Constants.NOTIFICATION_TAG, ReportConst.KEY_STACK, "", "getLaunchMode", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchModeParam;", "context", "getLaunchModeTag", "getPendingClosedActivity", "Ljava/util/LinkedList;", "Landroid/app/Activity;", "targetActivity", "getTargetActivity", "sendClearTopEvent", "(Lcom/bytedance/ies/bullet/core/BulletContext;)Ljava/lang/Boolean;", "shouldClearPopup", "shouldCloseAffinityV2", "bid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NestingDollUtil {
    public static final NestingDollUtil INSTANCE = new NestingDollUtil();

    private NestingDollUtil() {
    }

    public final boolean shouldCloseAffinityV2(String bid, BulletContext bulletContext, IRouterAbilityProvider self) {
        String str;
        boolean z;
        LaunchMode value;
        boolean closeAffinity;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(self, "self");
        LaunchModeParam launchMode = getLaunchMode(bulletContext);
        LoggerContext loggerContext = new LoggerContext();
        if (bulletContext == null || (str = bulletContext.getSessionId()) == null) {
            str = "";
        }
        loggerContext.pushStage(XConstant.SESSION_ID, str);
        HybridLogger.INSTANCE.m7d("XRouter", "start shouldCloseAffinityV2 call", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", bid), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(self.getSchema())), TuplesKt.to("launchMode", String.valueOf(launchMode))}), loggerContext);
        if (launchMode == null || (value = launchMode.getValue()) == null || LaunchMode.REMOVE_SAME_PAGE != value) {
            z = false;
        } else {
            NestingDollUtil nestingDollUtil = INSTANCE;
            String launchModeTag = nestingDollUtil.getLaunchModeTag(bulletContext);
            HybridLogger.INSTANCE.m7d("XRouter", "shouldCloseAffinityV2 getLaunchModeTag", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", bid), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(self.getSchema())), TuplesKt.to("launchMode", launchMode.valueToString()), TuplesKt.to("launchModeTag", launchModeTag)}), loggerContext);
            String str2 = launchModeTag;
            if (str2 == null || str2.length() == 0) {
                HybridLogger.INSTANCE.m9e("XRouter", "close affinity fail", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", bid), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(self.getSchema())), TuplesKt.to("launchMode", launchMode.toString()), TuplesKt.to("result", false)}), loggerContext);
                return false;
            }
            AnnieXContainerManager.triggerNestingDoll$default(AnnieXContainerManager.INSTANCE, launchModeTag, value, (IContainer) null, 4, (Object) null);
            if (self instanceof Activity) {
                closeAffinity = nestingDollUtil.closeAffinity(bulletContext != null ? bulletContext.getSessionId() : null, self, launchModeTag, StackManager.INSTANCE.getInstance().getActivityList());
            } else {
                String sessionId = bulletContext != null ? bulletContext.getSessionId() : null;
                IPopUpService iPopUpService = (IPopUpService) ServiceCenter.INSTANCE.instance().get(bid, IPopUpService.class);
                closeAffinity = nestingDollUtil.closeAffinity(sessionId, self, launchModeTag, iPopUpService != null ? iPopUpService.getPopupStack() : null);
            }
            z = closeAffinity;
        }
        HybridLogger.INSTANCE.m7d("XRouter", "close affinity result", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", bid), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(self.getSchema())), TuplesKt.to("launchMode", String.valueOf(launchMode)), TuplesKt.to("result", Boolean.valueOf(z))}), loggerContext);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean closeAffinity(String sessionId, IRouterAbilityProvider self, String tag, List<? extends IRouterAbilityProvider> stack) {
        boolean z;
        boolean z2;
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage(XConstant.SESSION_ID, sessionId == null ? "" : sessionId);
        char c = 2;
        char c2 = 3;
        if (stack != null) {
            z = false;
            for (IRouterAbilityProvider iRouterAbilityProvider : stack) {
                String bulletTag = iRouterAbilityProvider.getBulletTag();
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                Pair[] pairArr = new Pair[5];
                pairArr[0] = TuplesKt.to("bid", iRouterAbilityProvider.getBid());
                pairArr[1] = TuplesKt.to("bulletTag", self.getBulletTag());
                pairArr[c] = TuplesKt.to("url", String.valueOf(self.getSchema()));
                pairArr[c2] = TuplesKt.to("RouterAbilityProvider", iRouterAbilityProvider);
                pairArr[4] = TuplesKt.to("bulletTag", bulletTag);
                hybridLogger.m11i("forEach closeAffinity", "XRouter", MapsKt.mapOf(pairArr), loggerContext);
                if (!Intrinsics.areEqual(iRouterAbilityProvider, self) && Intrinsics.areEqual(tag, bulletTag)) {
                    z2 = true;
                    if (!z2) {
                        iRouterAbilityProvider = null;
                    }
                    if (iRouterAbilityProvider == null) {
                        HybridLogger.INSTANCE.m11i("XRouter", "do closeAffinity", MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", iRouterAbilityProvider.getBid()), TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(self.getSchema())), TuplesKt.to("RouterAbilityProvider", iRouterAbilityProvider), TuplesKt.to("bulletTag", bulletTag)}), loggerContext);
                        iRouterAbilityProvider.close();
                        z = true;
                    }
                    c = 2;
                    c2 = 3;
                }
                z2 = false;
                if (!z2) {
                }
                if (iRouterAbilityProvider == null) {
                }
                c = 2;
                c2 = 3;
            }
        } else {
            z = false;
        }
        HybridLogger.INSTANCE.m11i("XRouter", "closeAffinity result", MapsKt.mapOf(new Pair[]{TuplesKt.to("bulletTag", self.getBulletTag()), TuplesKt.to("url", String.valueOf(self.getSchema())), TuplesKt.to("result", Boolean.valueOf(z))}), loggerContext);
        return z;
    }

    public final boolean clearTopActivity(BulletContext bulletContext, LoggerContext logContext) {
        String containerId;
        BulletContext context;
        IKitViewService viewService;
        String str;
        String str2;
        BulletLoadUriIdentifier uriIdentifier;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(logContext, "logContext");
        LaunchModeParam launchMode = getLaunchMode(bulletContext);
        HybridLogger.INSTANCE.m11i("XRouter", "clearTopActivity launch mode", MapsKt.mapOf(TuplesKt.to("launchMode", launchMode != null ? launchMode.valueToString() : null)), logContext);
        if (LaunchMode.CLEAR_TOP != (launchMode != null ? launchMode.getValue() : null)) {
            return false;
        }
        String launchModeTag = getLaunchModeTag(bulletContext);
        HybridLogger.INSTANCE.m11i("XRouter", "clearTopActivity show tag", MapsKt.mapOf(new Pair[]{TuplesKt.to("launchMode", launchMode.valueToString()), TuplesKt.to(Constants.NOTIFICATION_TAG, launchModeTag)}), logContext);
        String str3 = "";
        IRouterAbilityProvider iRouterAbilityProvider = null;
        for (IRouterAbilityProvider iRouterAbilityProvider2 : StackManager.INSTANCE.getInstance().getActivityList()) {
            if (Intrinsics.areEqual(iRouterAbilityProvider2.getBulletTag(), launchModeTag)) {
                HybridLogger.INSTANCE.m11i("XRouter", "clearTopActivity match target tag", MapsKt.mapOf(new Pair[]{TuplesKt.to("launchMode", launchMode.valueToString()), TuplesKt.to(Constants.NOTIFICATION_TAG, launchModeTag), TuplesKt.to("targetUrl", String.valueOf(iRouterAbilityProvider2.getSchema())), TuplesKt.to("bid", iRouterAbilityProvider2.getBid()), TuplesKt.to("containerId", iRouterAbilityProvider2.getContainerId())}), logContext);
                str3 = String.valueOf(iRouterAbilityProvider2.getSchema());
                iRouterAbilityProvider = iRouterAbilityProvider2;
            }
        }
        FragmentActivity targetActivity = getTargetActivity(iRouterAbilityProvider);
        HybridLogger.INSTANCE.m11i("XRouter", "clearTopActivity getTarget Activity", MapsKt.mapOf(new Pair[]{TuplesKt.to("launchMode", launchMode.valueToString()), TuplesKt.to(Constants.NOTIFICATION_TAG, launchModeTag), TuplesKt.to("targetActivity", String.valueOf(targetActivity))}), logContext);
        if (targetActivity == null) {
            return false;
        }
        Iterator<T> it = getPendingClosedActivity(targetActivity).iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            ((Activity) it.next()).finish();
        }
        if (shouldClearPopup(bulletContext)) {
            FragmentActivity fragmentActivity = targetActivity instanceof FragmentActivity ? targetActivity : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (Fragment fragment : supportFragmentManager.getFragments()) {
                    if (fragment.isAdded()) {
                        beginTransaction.remove(fragment);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
        }
        if (Intrinsics.areEqual(sendClearTopEvent(bulletContext), true) && iRouterAbilityProvider != null && (containerId = iRouterAbilityProvider.getContainerId()) != null && (context = BulletContextManager.INSTANCE.getInstance().getContext(containerId)) != null && (viewService = context.getViewService()) != null) {
            JSONObject jSONObject = new JSONObject();
            if (IConditionCallKt.enableClearTopEventNewUrlFix()) {
                if (bulletContext == null || (uriIdentifier = bulletContext.getUriIdentifier()) == null || (str2 = uriIdentifier.getFullUrl()) == null) {
                    str2 = "";
                }
                jSONObject.put("new_url", str2);
            } else {
                BulletLoadUriIdentifier uriIdentifier2 = context.getUriIdentifier();
                if (uriIdentifier2 == null || (str = uriIdentifier2.getFullUrl()) == null) {
                    str = "";
                }
                jSONObject.put("new_url", str);
            }
            Unit unit = Unit.INSTANCE;
            viewService.sendEvent("clearTopEvent", jSONObject);
        }
        HybridLogger.INSTANCE.m11i("XRouter", "clearTopActivity result", MapsKt.mapOf(new Pair[]{TuplesKt.to("launchMode", launchMode.valueToString()), TuplesKt.to(Constants.NOTIFICATION_TAG, launchModeTag), TuplesKt.to("targetActivity", targetActivity.toString()), TuplesKt.to("targetUrl", str3), TuplesKt.to("result", true), TuplesKt.to("closeActivityCount", Integer.valueOf(i))}), logContext);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Activity getTargetActivity(IRouterAbilityProvider self) {
        if (self == 0) {
            return null;
        }
        if (self instanceof Activity) {
            return (Activity) self;
        }
        if (self instanceof Fragment) {
            return ((Fragment) self).getActivity();
        }
        return null;
    }

    private final LinkedList<Activity> getPendingClosedActivity(Activity targetActivity) {
        if (targetActivity == null) {
            return new LinkedList<>();
        }
        LinkedList<Activity> linkedList = new LinkedList<>();
        Activity[] activityStack = LifeCycleManager.INSTANCE.getActivityStack();
        boolean z = true;
        if (activityStack != null) {
            if (!(activityStack.length == 0)) {
                z = false;
            }
        }
        if (z) {
            return linkedList;
        }
        Activity[] activityStack2 = LifeCycleManager.INSTANCE.getActivityStack();
        LinkedList linkedList2 = new LinkedList(activityStack2 != null ? ArraysKt.reversed(activityStack2) : null);
        for (Activity activity = (Activity) linkedList2.pop(); activity != null && !Intrinsics.areEqual(activity, targetActivity); activity = (Activity) linkedList2.pop()) {
            linkedList.add(activity);
        }
        return linkedList;
    }

    public final LaunchModeParam getLaunchMode(BulletContext context) {
        if (context != null) {
            return new LaunchModeParam(context.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_BDX_LAUNCH_MODE, LaunchMode.MODE_UNSPECIFIED);
        }
        return null;
    }

    private final String getLaunchModeTag(BulletContext context) {
        if (context != null) {
            return new StringParam(context.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_BDX_TAG, null).getValue();
        }
        return null;
    }

    private final boolean shouldClearPopup(BulletContext context) {
        return !(context != null ? Intrinsics.areEqual(new BooleanParam(context.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_DISABLE_CLEAR_POPUP, null).getValue(), true) : false);
    }

    private final Boolean sendClearTopEvent(BulletContext context) {
        if (context != null) {
            return new BooleanParam(context.getSchemaModelUnion().getSchemaData(), SchemaConstants.SEND_CLEAR_TOP_EVENT, false).getValue();
        }
        return null;
    }
}
