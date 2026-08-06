package com.bytedance.ies.bullet.p003ui.common.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.ies.bullet.container.utils.BdMediaFileUtils;
import com.bytedance.ies.bullet.container.utils.BdMediaItem;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.lang.ref.WeakReference;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ScreenCaptureUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 '2\u00020\u0001:\u0001'B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0012J\b\u0010%\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u001aH\u0016J\u001a\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u001a2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u001a2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/ScreenCaptureObserver;", "Landroid/database/ContentObserver;", "uri", "Landroid/net/Uri;", "appContext", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "(Landroid/net/Uri;Landroid/content/Context;Landroid/os/Handler;)V", "getAppContext", "()Landroid/content/Context;", "imageCount", "", "getImageCount", "()I", "setImageCount", "(I)V", ReportConst.KEY_TIMESTAMP, "", "getTimestamp", "()J", "setTimestamp", "(J)V", "getUri", "()Landroid/net/Uri;", "checkDateAdded", "", EventConstants.PARAM_SOURCE_INTERVAL, "checkInsert", RouterConstants.QUERY_KEY_FLAGS, "checkPath", "filePath", "", "dispatchScreenCapture", "", "relativePath", "dateAdded", "onChange", "selfChange", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ScreenCaptureObserver extends ContentObserver {
    private static final String HW_CAMERA_PATH = "/dcim/camera/";
    private static final long SCREENSHOT_INTERVAL = 5000;
    private final Context appContext;
    private int imageCount;
    private long timestamp;
    private final Uri uri;
    private static final String[] CAMERA_SNAPSHOT_KEYWORDS = {"tmp.png"};
    private static final String[] KEYWORDS = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏", "截屏录屏"};

    private final boolean checkDateAdded(long interval) {
        return interval < 5000;
    }

    private final boolean checkInsert(int flags) {
        return (flags & 4) == 4;
    }

    public /* synthetic */ ScreenCaptureObserver(Uri uri, Context context, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, context, (i & 4) != 0 ? null : handler);
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final Uri getUri() {
        return this.uri;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenCaptureObserver(Uri uri, Context context, Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(context, "appContext");
        this.uri = uri;
        this.appContext = context;
        this.timestamp = Long.MIN_VALUE;
        this.imageCount = -1;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final int getImageCount() {
        return this.imageCount;
    }

    public final void setImageCount(int i) {
        this.imageCount = i;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        onChange(selfChange, null);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        onChange(selfChange, uri, 4);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri, int flags) {
        if (ScreenCaptureUtils.INSTANCE.getIsAppInBackground()) {
            return;
        }
        if (IConditionCallKt.fixMultiMediaQuery() && Build.VERSION.SDK_INT >= 30 && !checkInsert(flags)) {
            BulletLogger.INSTANCE.printTridentLog("onUserCaptureScreen ScreenCaptureObserver.onChange, uri=" + uri + ", flags=" + flags, (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, "", (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        } else {
            onChange();
        }
    }

    public void onChange() {
        String relativePath;
        this.timestamp = System.currentTimeMillis();
        BulletLogger.INSTANCE.printTridentLog("onUserCaptureScreen ScreenCaptureObserver.onChange, timestamp=" + this.timestamp, (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, "", (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        List<BdMediaItem> images = BdMediaFileUtils.getImages(this.appContext, null, null, "date_added", -1, -1);
        BulletLogger.INSTANCE.printTridentLog("onUserCaptureScreen ScreenCaptureObserver.onChange，imageCount=" + this.imageCount + ", images.size=" + images.size(), (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, "", (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        if (this.imageCount >= images.size()) {
            this.imageCount = images.size();
            return;
        }
        this.imageCount = images.size();
        Intrinsics.checkNotNullExpressionValue(images, "images");
        List sortedWith = CollectionsKt.sortedWith(images, new Comparator<T>() { // from class: com.bytedance.ies.bullet.ui.common.utils.ScreenCaptureObserver$onChange$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((BdMediaItem) t2).getDateAdded()), Long.valueOf(((BdMediaItem) t).getDateAdded()));
            }
        });
        Intrinsics.checkNotNullExpressionValue(sortedWith, "images");
        BdMediaItem bdMediaItem = (BdMediaItem) CollectionsKt.firstOrNull(sortedWith);
        if (bdMediaItem == null || (relativePath = bdMediaItem.getRelativePath()) == null) {
            return;
        }
        dispatchScreenCapture(relativePath, bdMediaItem.getDateAdded());
    }

    public final void dispatchScreenCapture(String relativePath, long dateAdded) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("onUserCaptureScreen ScreenCaptureObserver.dispatchScreenCapture, timestamp=");
        long j = this.timestamp;
        long j2 = BytePatchException.ErrorCode.paramsError;
        bulletLogger.printTridentLog(sb.append(j / j2).append(", dateAdded=").append(dateAdded).toString(), (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, "", (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        boolean checkDateAdded = checkDateAdded(this.timestamp - (dateAdded * j2));
        boolean checkPath = checkPath(relativePath);
        BulletLogger.INSTANCE.printTridentLog("onUserCaptureScreen ScreenCaptureObserver.dispatchScreenCapture, matchDateAdded=" + checkDateAdded + ", matchPath=" + checkPath, (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, "", (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        int i = !checkDateAdded ? 1 : 0;
        if (!checkPath) {
            i |= 2;
        }
        Iterator<T> it = ScreenCaptureUtils.INSTANCE.getListeners$anniex_release().iterator();
        while (it.hasNext()) {
            OnScreenCaptureListener onScreenCaptureListener = (OnScreenCaptureListener) ((WeakReference) it.next()).get();
            if (onScreenCaptureListener != null) {
                onScreenCaptureListener.onCapture(i);
            }
        }
    }

    private final boolean checkPath(String filePath) {
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        if (filePath == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = filePath.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        for (String str : KEYWORDS) {
            if (StringsKt.contains$default(lowerCase, str, false, 2, (Object) null)) {
                return true;
            }
        }
        if (DeviceUtils.isHuawei() && StringsKt.contains$default(filePath, HW_CAMERA_PATH, false, 2, (Object) null)) {
            for (String str2 : CAMERA_SNAPSHOT_KEYWORDS) {
                if (StringsKt.contains$default(lowerCase, str2, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }
}
