package com.bytedance.trae;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;

/* compiled from: ILauncher.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/ILauncher;", "", "beforeAttachBaseContext", "", "context", "Landroid/content/Context;", "afterAttachBaseContext", "beforeOnCreate", "application", "Landroid/app/Application;", "afterOnCreate", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ILauncher {
    void afterAttachBaseContext(Context context);

    void afterOnCreate(Application application);

    void beforeAttachBaseContext(Context context);

    void beforeOnCreate(Application application);
}
