package com.bytedance.ies.bullet.service.base.resourceloader.config;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: ResourceLoaderConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ICdnDownloadDepender;", "", CDNLoader.STEP_NAME_DOWNLOAD_RESOURCE_FILE, "", CDNLoader.DIAGNOSE_SOURCE_URL, "", "syncCall", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/RLDownloaderListener;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ICdnDownloadDepender {
    void downloadResourceFile(String sourceUrl, boolean syncCall, TaskConfig config, RLDownloaderListener listener);
}
