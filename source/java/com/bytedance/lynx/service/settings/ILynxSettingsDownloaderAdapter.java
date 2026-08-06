package com.bytedance.lynx.service.settings;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;

/* compiled from: ILynxSettingsDownloaderAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u009c\u0001\u0010\u0004\u001a\u00020\u00052\u0091\u0001\u0010\u0006\u001a\u008c\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/lynx/service/settings/ILynxSettingsDownloaderAdapter;", "", "enabled", "", "fetchSettings", "", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "succeed", "", "urlString", "", "errorCode", "errorMessage", "settingsString", "", "settingsTime", "initLynxSettingsDownloaderAdapter", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ILynxSettingsDownloaderAdapter {
    boolean enabled();

    void fetchSettings(Function6<? super Boolean, ? super String, ? super Integer, ? super String, ? super String, ? super Long, Unit> callback);

    void initLynxSettingsDownloaderAdapter(LynxServiceConfig lynxServiceConfig);
}
