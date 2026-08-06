package com.bytedance.ies.bullet.p003ui.common.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenCaptureUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/InternalScreenCaptureObserver;", "Lcom/bytedance/ies/bullet/ui/common/utils/ScreenCaptureObserver;", "uri", "Landroid/net/Uri;", "appContext", "Landroid/content/Context;", "(Landroid/net/Uri;Landroid/content/Context;)V", "onChange", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InternalScreenCaptureObserver extends ScreenCaptureObserver {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalScreenCaptureObserver(Uri uri, Context context) {
        super(uri, context, null, 4, null);
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(context, "appContext");
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.utils.ScreenCaptureObserver
    public void onChange() {
        setTimestamp(System.currentTimeMillis());
        BulletLogger.INSTANCE.printTridentLog("onUserCaptureScreen InternalScreenCaptureObserver.onChange, timestamp=" + getTimestamp(), (r17 & 2) != 0 ? null : null, (r17 & 4) != 0 ? LogLevel.I : null, (r17 & 8) != 0 ? "" : null, "", (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
        Cursor query = getAppContext().getContentResolver().query(getUri(), new String[]{"_data", "date_added"}, null, null, "date_modified desc");
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                int count = cursor2.getCount();
                if (getImageCount() >= count) {
                    setImageCount(count);
                } else {
                    setImageCount(count);
                    if (cursor2.moveToFirst()) {
                        int columnIndex = cursor2.getColumnIndex("date_added");
                        int columnIndex2 = cursor2.getColumnIndex("_data");
                        long j = cursor2.getLong(columnIndex);
                        String string = cursor2.getString(columnIndex2);
                        Intrinsics.checkNotNullExpressionValue(string, "relativePath");
                        dispatchScreenCapture(string, j);
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
    }
}
