package com.bytedance.ies.bullet.kit.resourceloader.debugger;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import kotlin.Metadata;

/* compiled from: GlobalResourceInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H&J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/debugger/ResourceLoaderHooker;", "", "hookUrl", "Landroid/net/Uri;", "url", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "onLoadFailed", "", "resInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "taskConfig", "e", "", "onLoadStart", "onLoadSuccess", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ResourceLoaderHooker {
    Uri hookUrl(String url, TaskConfig config);

    void onLoadFailed(ResourceInfo resInfo, TaskConfig taskConfig, Throwable e);

    void onLoadStart(ResourceInfo resInfo, TaskConfig taskConfig);

    void onLoadSuccess(ResourceInfo resInfo, TaskConfig taskConfig);
}
