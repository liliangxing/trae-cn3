package com.bytedance.trae.praise;

import android.content.SharedPreferences;
import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PraiseDialogTrigger.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010 \u001a\u00020\u0012*\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012H\u0002J\u001c\u0010$\u001a\u00020\r*\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\rH\u0002J\u001c\u0010%\u001a\u00020\u0010*\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0006\u0010&\u001a\u00020\u0012J\u0006\u0010'\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0012J\u0006\u0010+\u001a\u00020\u0012J\b\u0010*\u001a\u00020\u0012H\u0002J\u0006\u0010,\u001a\u00020)J\u0006\u0010-\u001a\u00020\u0012J\u0006\u0010.\u001a\u00020)J\u0006\u0010/\u001a\u00020)J\u0006\u00100\u001a\u00020)J\u0018\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00064"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogTrigger;", "", "<init>", "()V", "TAG", "", "SP_NAME", "KEY_TASK_DONE_COUNT", "KEY_SHOW_COUNT", "KEY_LAST_SHOW_DATE", "KEY_LATER_TIMESTAMP", "KEY_IS_OLD_USER", "DEFAULT_MAX_SHOW_COUNT", "", "DEFAULT_TASK_THRESHOLD", "DEFAULT_REFUSE_BLOCK_TIME_HOURS", "", "DEFAULT_ENABLE", "", "DEFAULT_IGNORE_UG_RULE", "ONE_HOUR_MILLIS", "ONE_DAY_MILLIS", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "config", "Lcom/bytedance/trae/praise/PraiseRatingConfig;", "getConfig", "()Lcom/bytedance/trae/praise/PraiseRatingConfig;", "getBoolean", "Lcom/google/gson/JsonObject;", "key", DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME, "getInt", "getLong", "isEnabled", "isIgnoreUgRule", "setOldUser", "", "isOldUser", "isOldUserDetermined", "onTaskDone", "shouldShow", "onDialogShown", "onLaterClicked", "onRateClicked", "isSameDay", "time1", "time2", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialogTrigger {
    public static final boolean DEFAULT_ENABLE = false;
    public static final boolean DEFAULT_IGNORE_UG_RULE = true;
    public static final int DEFAULT_MAX_SHOW_COUNT = 2;
    public static final long DEFAULT_REFUSE_BLOCK_TIME_HOURS = 168;
    public static final int DEFAULT_TASK_THRESHOLD = 3;
    private static final String KEY_IS_OLD_USER = "is_old_user";
    private static final String KEY_LAST_SHOW_DATE = "last_show_date";
    private static final String KEY_LATER_TIMESTAMP = "later_timestamp";
    private static final String KEY_SHOW_COUNT = "show_count";
    private static final String KEY_TASK_DONE_COUNT = "task_done_count";
    private static final long ONE_DAY_MILLIS = 86400000;
    private static final long ONE_HOUR_MILLIS = 3600000;
    private static final String SP_NAME = "trae_praise_dialog";
    private static final String TAG = "Praise";
    public static final PraiseDialogTrigger INSTANCE = new PraiseDialogTrigger();

    /* renamed from: sp$delegate, reason: from kotlin metadata */
    private static final Lazy sp = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.praise.PraiseDialogTrigger$$ExternalSyntheticLambda0
        public final Object invoke() {
            SharedPreferences sp_delegate$lambda$0;
            sp_delegate$lambda$0 = PraiseDialogTrigger.sp_delegate$lambda$0();
            return sp_delegate$lambda$0;
        }
    });

    private PraiseDialogTrigger() {
    }

    private final SharedPreferences getSp() {
        Object value = sp.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences sp_delegate$lambda$0() {
        return AppHost.Companion.getApplication().getSharedPreferences(SP_NAME, 0);
    }

    private final PraiseRatingConfig getConfig() {
        PraiseRatingConfig praiseRatingConfig;
        try {
            Object obtain = SettingsManager.obtain(IPraiseSettings.class);
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain(...)");
            JsonObject androidAppRating = ((IPraiseSettings) obtain).getAndroidAppRating();
            if (androidAppRating != null) {
                praiseRatingConfig = new PraiseRatingConfig(getBoolean(androidAppRating, "enable", false), getInt(androidAppRating, "least_chat_times_before_trigger", 3), getInt(androidAppRating, "max_count", 2), getLong(androidAppRating, "refuse_block_time_hours", 168L), getBoolean(androidAppRating, "ignore_ug_rule", true));
                FLogger.INSTANCE.mo425d(TAG, "config loaded: " + praiseRatingConfig);
            } else {
                FLogger.INSTANCE.mo430w(TAG, "config: android_app_rating_v1 is null, using DEFAULT");
                praiseRatingConfig = PraiseRatingConfig.INSTANCE.getDEFAULT();
            }
            return praiseRatingConfig;
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "config: exception " + e.getMessage());
            return PraiseRatingConfig.INSTANCE.getDEFAULT();
        }
    }

    private final boolean getBoolean(JsonObject jsonObject, String str, boolean z) {
        JsonElement jsonElement = jsonObject.get(str);
        return jsonElement != null ? jsonElement.getAsBoolean() : z;
    }

    private final int getInt(JsonObject jsonObject, String str, int i) {
        JsonElement jsonElement = jsonObject.get(str);
        return jsonElement != null ? jsonElement.getAsInt() : i;
    }

    private final long getLong(JsonObject jsonObject, String str, long j) {
        JsonElement jsonElement = jsonObject.get(str);
        return jsonElement != null ? jsonElement.getAsLong() : j;
    }

    public final boolean isEnabled() {
        return getConfig().getEnable();
    }

    public final boolean isIgnoreUgRule() {
        return getConfig().getIgnoreUgRule();
    }

    public final void setOldUser(boolean isOldUser) {
        getSp().edit().putBoolean(KEY_IS_OLD_USER, isOldUser).apply();
        FLogger.INSTANCE.mo425d(TAG, "setOldUser: " + isOldUser);
    }

    public final boolean isOldUserDetermined() {
        return getSp().contains(KEY_IS_OLD_USER);
    }

    private final boolean isOldUser() {
        return getSp().getBoolean(KEY_IS_OLD_USER, false);
    }

    public final void onTaskDone() {
        getSp().edit().putInt(KEY_TASK_DONE_COUNT, getSp().getInt(KEY_TASK_DONE_COUNT, 0) + 1).apply();
    }

    public final boolean shouldShow() {
        PraiseRatingConfig config = getConfig();
        boolean z = false;
        if (!config.getEnable()) {
            FLogger.INSTANCE.mo425d(TAG, "shouldShow: NO - disabled by config");
            return false;
        }
        int i = getSp().getInt(KEY_SHOW_COUNT, 0);
        if (i >= config.getMaxCount()) {
            FLogger.INSTANCE.mo425d(TAG, "shouldShow: NO - showCount(" + i + ") >= maxCount(" + config.getMaxCount() + ')');
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = getSp().getLong(KEY_LATER_TIMESTAMP, 0L);
        if (j > 0) {
            long j2 = currentTimeMillis - j;
            if (j2 < config.getRefuseBlockTimeHours() * 3600000) {
                FLogger.INSTANCE.mo425d(TAG, "shouldShow: NO - in cooldown, elapsed=" + (j2 / 3600000) + "h, need=" + config.getRefuseBlockTimeHours() + 'h');
                return false;
            }
        }
        if (isSameDay(getSp().getLong(KEY_LAST_SHOW_DATE, 0L), currentTimeMillis)) {
            FLogger.INSTANCE.mo425d(TAG, "shouldShow: NO - already shown today");
            return false;
        }
        int i2 = getSp().getInt(KEY_TASK_DONE_COUNT, 0);
        boolean isOldUser = isOldUser();
        if (!isOldUser ? i2 >= config.getLeastChatTimesBeforeTrigger() : i2 >= 1) {
            z = true;
        }
        if (!z) {
            FLogger.INSTANCE.mo425d(TAG, "shouldShow: NO - taskDoneCount=" + i2 + ", oldUser=" + isOldUser + ", threshold=" + (isOldUser ? 1 : config.getLeastChatTimesBeforeTrigger()));
        } else {
            FLogger.INSTANCE.mo425d(TAG, "shouldShow: YES - taskDoneCount=" + i2 + ", oldUser=" + isOldUser + ", showCount=" + i);
        }
        return z;
    }

    public final void onDialogShown() {
        getSp().edit().putInt(KEY_SHOW_COUNT, getSp().getInt(KEY_SHOW_COUNT, 0) + 1).putLong(KEY_LAST_SHOW_DATE, System.currentTimeMillis()).apply();
    }

    public final void onLaterClicked() {
        getSp().edit().putLong(KEY_LATER_TIMESTAMP, System.currentTimeMillis()).apply();
    }

    public final void onRateClicked() {
        getSp().edit().putInt(KEY_SHOW_COUNT, getConfig().getMaxCount()).apply();
    }

    private final boolean isSameDay(long time1, long time2) {
        return time1 != 0 && time1 / 86400000 == time2 / 86400000;
    }
}
