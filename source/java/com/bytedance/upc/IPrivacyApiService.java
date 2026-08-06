package com.bytedance.upc;

import android.content.Context;
import kotlin.Metadata;

/* compiled from: IPrivacyApiService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\r"}, d2 = {"Lcom/bytedance/upc/IPrivacyApiService;", "", "active", "", "agreePrivacyPolicy", "boolean", "", "init", "context", "Landroid/content/Context;", "setOnlineStrategy", "useBasicMode", "useTeenagerMode", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IPrivacyApiService {
    void active();

    void agreePrivacyPolicy(boolean r1);

    void init(Context context);

    void setOnlineStrategy(boolean r1);

    void useBasicMode(boolean r1);

    void useTeenagerMode(boolean r1);
}
