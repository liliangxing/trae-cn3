package com.tt.skin.sdk.api;

import android.app.Activity;
import kotlin.Metadata;

/* compiled from: ISkinStatusInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/tt/skin/sdk/api/ISkinStatusInterceptor;", "", "inWhiteList", "", "activity", "Landroid/app/Activity;", "isCurPageNightMode", "isDarkMode", "isDetailPageCssReady", "isIgnoreActivity", "isJSReader", "api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface ISkinStatusInterceptor {
    boolean inWhiteList(Activity activity);

    boolean isCurPageNightMode(Activity activity);

    boolean isDarkMode();

    boolean isDetailPageCssReady();

    boolean isIgnoreActivity(Activity activity);

    boolean isJSReader();
}
