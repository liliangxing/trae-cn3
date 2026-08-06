package com.bytedance.trae.utils.logger;

import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.notification.Constants;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import com.bytedance.ug.sdk.share.api.entity.ShareConstant;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FormatLogBuilder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/utils/logger/Logger;", "", Constants.NOTIFICATION_TAG, "", "<init>", "(Ljava/lang/String;)V", IFrontierMonitor.KEY_LOG, "", "level", "Lcom/bytedance/trae/utils/logger/LogLevel;", "content", "file", "function", ShareConstant.LINE, "", "getFormattedTime", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Logger {
    private final String tag;

    /* compiled from: FormatLogBuilder.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Logger(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.NOTIFICATION_TAG);
        this.tag = str;
    }

    public final void log(LogLevel level, String content, String file, String function, int line) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(function, "function");
        String str = content + " [" + (((String) CollectionsKt.last(StringsKt.split$default(file, new String[]{"/"}, false, 0, 6, (Object) null))) + StringListParam.SPLIT_DELIMITER + function + StringListParam.SPLIT_DELIMITER + line) + ']';
        int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i == 1) {
            FLogger.INSTANCE.mo425d(this.tag, str);
            return;
        }
        if (i == 2) {
            FLogger.INSTANCE.mo428i(this.tag, str);
        } else if (i == 3) {
            FLogger.INSTANCE.mo430w(this.tag, str);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            FLogger.INSTANCE.mo426e(this.tag, str);
        }
    }

    private final String getFormattedTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
        float offset = TimeZone.getDefault().getOffset(date.getTime()) / ((float) TimeUnit.HOURS.toMillis(1L));
        StringBuilder append = new StringBuilder().append(simpleDateFormat.format(date)).append(" +");
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(offset)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return append.append(format).append(' ').append(simpleDateFormat2.format(date)).toString();
    }
}
