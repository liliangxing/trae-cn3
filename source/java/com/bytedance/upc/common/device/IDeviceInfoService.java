package com.bytedance.upc.common.device;

import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.upc.BuildConfig;
import com.bytedance.upc.IUpcBusinessService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: IDeviceInfoService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&J-\u0010\u0005\u001a\u00020\u00062#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\bH&J&\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/common/device/IDeviceInfoService;", "Lcom/bytedance/upc/IUpcBusinessService;", "getDeviceInfo", "Lkotlin/Triple;", "", "registerDeviceLoadListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", CommonConstants.KEY_DEVICE_ID, "updateDeviceInfo", "deviceId", "userId", "installId", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes6.dex */
public interface IDeviceInfoService extends IUpcBusinessService {
    Triple<String, String, String> getDeviceInfo();

    void registerDeviceLoadListener(Function1<? super String, Unit> listener);

    void updateDeviceInfo(String deviceId, String userId, String installId);
}
