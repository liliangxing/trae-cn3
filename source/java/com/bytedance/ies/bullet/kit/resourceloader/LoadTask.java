package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.lynx.tasm.gesture.handler.GestureConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ResourceLoaderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0015B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/LoadTask;", "", "uri", "Landroid/net/Uri;", NotificationCompat.CATEGORY_PROGRESS, "", "updateListener", "Lcom/bytedance/ies/bullet/kit/resourceloader/LoadTask$OnTaskProgressUpdateListener;", "(Landroid/net/Uri;ILcom/bytedance/ies/bullet/kit/resourceloader/LoadTask$OnTaskProgressUpdateListener;)V", "getProgress", "()I", "setProgress", "(I)V", "getUpdateListener", "()Lcom/bytedance/ies/bullet/kit/resourceloader/LoadTask$OnTaskProgressUpdateListener;", "setUpdateListener", "(Lcom/bytedance/ies/bullet/kit/resourceloader/LoadTask$OnTaskProgressUpdateListener;)V", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "OnTaskProgressUpdateListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LoadTask {
    private int progress;
    private OnTaskProgressUpdateListener updateListener;
    private Uri uri;

    /* compiled from: ResourceLoaderService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/LoadTask$OnTaskProgressUpdateListener;", "", GestureConstants.ON_UPDATE, "", NotificationCompat.CATEGORY_PROGRESS, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnTaskProgressUpdateListener {
        void onUpdate(int progress);
    }

    public LoadTask() {
        this(null, 0, null, 7, null);
    }

    public LoadTask(Uri uri, int i, OnTaskProgressUpdateListener onTaskProgressUpdateListener) {
        this.uri = uri;
        this.progress = i;
        this.updateListener = onTaskProgressUpdateListener;
    }

    public /* synthetic */ LoadTask(Uri uri, int i, OnTaskProgressUpdateListener onTaskProgressUpdateListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : uri, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : onTaskProgressUpdateListener);
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri) {
        this.uri = uri;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final OnTaskProgressUpdateListener getUpdateListener() {
        return this.updateListener;
    }

    public final void setUpdateListener(OnTaskProgressUpdateListener onTaskProgressUpdateListener) {
        this.updateListener = onTaskProgressUpdateListener;
    }
}
