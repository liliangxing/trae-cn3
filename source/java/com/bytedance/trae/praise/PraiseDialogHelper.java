package com.bytedance.trae.praise;

import android.app.Activity;
import android.content.Context;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.praisedialoglib.manager.PraiseDialogCfgManager;
import com.bytedance.praisedialoglib.manager.PraiseDialogManager;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PraiseDialogHelper.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005J\r\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0017J*\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogHelper;", "", "<init>", "()V", "TAG", "", "settingsUpdateListener", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "registerSettingsListener", "", "registerCustomDialogCallback", "unregisterSettingsListener", "initSettings", "settingsJson", "Lorg/json/JSONObject;", "setHasTaskHistory", "hasTaskHistory", "", "onTaskDoneAndTryShow", "context", "Landroid/content/Context;", PraiseDialogConstant.FROM, "updateSdkSettings", "updateSdkSettings$praise_mainlandRelease", "tryShowDialog", "uid", "", "delayMillSec", "showDirectly", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialogHelper {
    private static final String TAG = "Praise";
    public static final PraiseDialogHelper INSTANCE = new PraiseDialogHelper();
    private static final SettingsUpdateListener settingsUpdateListener = new SettingsUpdateListener() { // from class: com.bytedance.trae.praise.PraiseDialogHelper$$ExternalSyntheticLambda0
        @Override // com.bytedance.news.common.settings.SettingsUpdateListener
        public final void onSettingsUpdate(SettingsData settingsData) {
            PraiseDialogHelper.settingsUpdateListener$lambda$0(settingsData);
        }
    };

    private PraiseDialogHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void settingsUpdateListener$lambda$0(SettingsData settingsData) {
        FLogger.INSTANCE.mo428i(TAG, "settings updated, refreshing SDK config");
        INSTANCE.updateSdkSettings$praise_mainlandRelease();
    }

    public final void registerSettingsListener() {
        SettingsManager.registerListener(settingsUpdateListener, true);
        FLogger.INSTANCE.mo428i(TAG, "registerSettingsListener");
        updateSdkSettings$praise_mainlandRelease();
        registerCustomDialogCallback();
    }

    private final void registerCustomDialogCallback() {
        PraiseDialogCfgManager.getInstance().setIPraiseDialogActionCallback(new PraiseDialogHelper$registerCustomDialogCallback$1());
        FLogger.INSTANCE.mo428i(TAG, "registerCustomDialogCallback: callback registered");
    }

    public final void unregisterSettingsListener() {
        SettingsManager.unregisterListener(settingsUpdateListener);
        FLogger.INSTANCE.mo428i(TAG, "unregisterSettingsListener");
    }

    public final void initSettings(JSONObject settingsJson) {
        Intrinsics.checkNotNullParameter(settingsJson, "settingsJson");
        PraiseDialogCfgManager.getInstance().setAppData(settingsJson);
    }

    public final void setHasTaskHistory(boolean hasTaskHistory) {
        PraiseDialogTrigger.INSTANCE.setOldUser(hasTaskHistory);
    }

    public final void onTaskDoneAndTryShow(Context context, String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, PraiseDialogConstant.FROM);
        boolean isEnabled = PraiseDialogTrigger.INSTANCE.isEnabled();
        FLogger.INSTANCE.mo428i(TAG, "onTaskDoneAndTryShow: enabled=" + isEnabled + ", from=" + from);
        if (isEnabled) {
            PraiseDialogTrigger.INSTANCE.onTaskDone();
            boolean shouldShow = PraiseDialogTrigger.INSTANCE.shouldShow();
            FLogger.INSTANCE.mo428i(TAG, "onTaskDoneAndTryShow: shouldShow=" + shouldShow);
            if (shouldShow) {
                try {
                    tryShowDialog$default(this, 0L, 1000L, context, from, 1, null);
                } catch (Throwable th) {
                    FLogger.INSTANCE.mo431w(TAG, "onTaskDoneAndTryShow: shouldShow=", th);
                }
            }
        }
    }

    public final void updateSdkSettings$praise_mainlandRelease() {
        String str;
        JsonElement jsonElement;
        String asString;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        try {
            Object obtain = SettingsManager.obtain(IPraiseSettings.class);
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain(...)");
            JsonObject androidAppRating = ((IPraiseSettings) obtain).getAndroidAppRating();
            boolean asBoolean = (androidAppRating == null || (jsonElement3 = androidAppRating.get("enable")) == null) ? false : jsonElement3.getAsBoolean();
            String str2 = "";
            if (androidAppRating == null || (jsonElement2 = androidAppRating.get("app_market_order")) == null || (str = jsonElement2.getAsString()) == null) {
                str = "";
            }
            if (androidAppRating != null && (jsonElement = androidAppRating.get("market_feedback_url")) != null && (asString = jsonElement.getAsString()) != null) {
                str2 = asString;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("market_feedback_dialog_enable", asBoolean);
            jSONObject.put("app_market_order", str);
            jSONObject.put("market_feedback_url", str2);
            initSettings(jSONObject);
            FLogger.INSTANCE.mo425d(TAG, "updateSdkSettings: enable=" + asBoolean + ", appMarketOrder=" + str + ", marketFeedbackUrl=" + str2);
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "updateSdkSettings: exception " + e.getMessage());
        }
    }

    public static /* synthetic */ void tryShowDialog$default(PraiseDialogHelper praiseDialogHelper, long j, long j2, Context context, String str, int i, Object obj) {
        praiseDialogHelper.tryShowDialog((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, context, str);
    }

    public final void tryShowDialog(long uid, long delayMillSec, Context context, String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, PraiseDialogConstant.FROM);
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity != null) {
            PraiseDialogManager.getInstance().tryShowDialog(uid, delayMillSec, currentActivity, from);
        } else {
            PraiseDialogManager.getInstance().tryShowDialog(uid, delayMillSec, context, from);
        }
    }

    public final void showDirectly(String from) {
        Intrinsics.checkNotNullParameter(from, PraiseDialogConstant.FROM);
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        PraiseDialogManager.getInstance().showPraiseDialogDirectly(currentActivity, from);
    }
}
