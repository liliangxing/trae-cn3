package com.bytedance.trae.home.solo.task;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* compiled from: IFixCrashSettings.kt */
@Settings(storageKey = "fix_crash_settings")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/home/solo/task/IFixCrashSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getFixSuspendByPeerCrash", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IFixCrashSettings extends ISettings {
    String getFixSuspendByPeerCrash();
}
