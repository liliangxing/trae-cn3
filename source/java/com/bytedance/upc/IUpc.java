package com.bytedance.upc;

import android.content.Context;
import kotlin.Metadata;

/* compiled from: IUpc.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/upc/IUpc;", "", "init", "", "context", "Landroid/content/Context;", "configuration", "Lcom/bytedance/upc/Configuration;", "load", "", "scheme", "", "open", "start", "did", "uid", "updateSettings", "settings", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public interface IUpc {
    void init(Context context, Configuration configuration);

    boolean load(String scheme);

    boolean open(String scheme);

    void start(String did, String uid);

    void updateSettings(String settings);
}
