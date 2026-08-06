package com.bytedance.trae.praise;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* compiled from: IPraiseSettings.kt */
@Settings(storageKey = "praise_settings")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/praise/IPraiseSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getAndroidAppRating", "Lcom/google/gson/JsonObject;", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IPraiseSettings extends ISettings {
    JsonObject getAndroidAppRating();
}
