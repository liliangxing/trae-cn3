package com.bytedance.upc;

import android.content.Context;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;

/* compiled from: IUpcLifecycleService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/upc/IUpcLifecycleService;", "", "init", "", "context", "Landroid/content/Context;", "configuration", "Lcom/bytedance/upc/Configuration;", "priority", "", "start", CommonConstants.KEY_DEVICE_ID, "", "uid", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcLifecycleService {

    /* compiled from: IUpcLifecycleService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static int priority(IUpcLifecycleService iUpcLifecycleService) {
            return 1;
        }
    }

    void init(Context context, Configuration configuration);

    int priority();

    void start(String did, String uid);
}
