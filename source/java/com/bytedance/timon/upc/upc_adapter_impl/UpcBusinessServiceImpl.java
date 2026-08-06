package com.bytedance.timon.upc.upc_adapter_impl;

import android.app.Activity;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService;
import com.bytedance.upc.IPrivacyChangeListener;
import com.bytedance.upc.IUpcDialog;
import com.bytedance.upc.IUpcPopupGuideCallback;
import com.bytedance.upc.IUpcPrivacyDialog;
import com.bytedance.upc.Upc;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcBusinessServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J,\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0015H\u0016J\"\u0010\"\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J*\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002000/H\u0016¨\u00061"}, d2 = {"Lcom/bytedance/timon/upc/upc_adapter_impl/UpcBusinessServiceImpl;", "Lcom/bytedance/timon/upc/upc_adapter_api/IUpcBusinessService;", "()V", "addPrivacyStatusChangeListener", "", "listener", "Lcom/bytedance/upc/IPrivacyChangeListener;", "businessName", "", "clearPrivacyStatus", "", "syncService", "disMissDialog", "id", "getAllowStayDuration", "", "getPrivacyStatus", "key", "default", "getTeenModeEnable", "callback", "Lkotlin/Function1;", "getTeenModeEntryDuration", "load", IWeixinService.ResponseConstants.URL, "open", "scheme", "setPrivacyStatus", "value", "setTeenModeAllowStayDuration", ReportConstant.COMMON_INIT_DURATION, "setTeenModeEnable", "enable", "passwd", "showDialog", "activity", "Landroid/app/Activity;", "iUpcDialog", "Lcom/bytedance/upc/IUpcDialog;", "showPopup", "permission", "popupTitle", "popupContent", "iUpcPopupGuideCallback", "Lcom/bytedance/upc/IUpcPopupGuideCallback;", "tryCheckPrivacy", "config", "", "Lcom/bytedance/upc/IUpcPrivacyDialog;", "upc-adapter-impl_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UpcBusinessServiceImpl implements IUpcBusinessService {
    @Override // com.bytedance.timonbase.ITMBusinessService
    public String businessName() {
        return "upc";
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public void load(String url) {
        Intrinsics.checkParameterIsNotNull(url, IWeixinService.ResponseConstants.URL);
        Upc.inst().load(url);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public boolean open(String scheme) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        return Upc.inst().open(scheme);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public String getPrivacyStatus(String key, String r3) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return Upc.privacy().getPrivacyStatus(key, r3);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public boolean setPrivacyStatus(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return Upc.privacy().setPrivacyStatus(key, value);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public void addPrivacyStatusChangeListener(IPrivacyChangeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        Upc.privacy().addPrivacyStatusChangeListener(listener);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public boolean clearPrivacyStatus(boolean syncService) {
        return Upc.privacy().clearPrivacyStatus(syncService);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public boolean showDialog(String id, Activity activity, IUpcDialog iUpcDialog) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(iUpcDialog, "iUpcDialog");
        return Upc.dialog().showDialog(id, activity, iUpcDialog);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public void disMissDialog(String id) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Upc.dialog().disMissDialog(id);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public void tryCheckPrivacy(Activity activity, Map<String, ? extends IUpcPrivacyDialog> config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        Upc.dialog().tryCheckPrivacy(activity, config);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public void getTeenModeEnable(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Upc.teenMode().getTeenModeEnable(callback);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public void setTeenModeEnable(boolean enable, String passwd, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(passwd, "passwd");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Upc.teenMode().setTeenModeEnable(enable, passwd, callback);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public void setTeenModeAllowStayDuration(long duration) {
        Upc.teenMode().setTeenModeAllowStayDuration(duration);
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public long getAllowStayDuration() {
        return Upc.teenMode().getAllowStayDuration();
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public long getTeenModeEntryDuration() {
        return Upc.teenMode().getTeenModeEntryDuration();
    }

    @Override // com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService
    public void showPopup(String permission, String popupTitle, String popupContent, IUpcPopupGuideCallback iUpcPopupGuideCallback) {
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        Intrinsics.checkParameterIsNotNull(popupTitle, "popupTitle");
        Intrinsics.checkParameterIsNotNull(popupContent, "popupContent");
        Upc.popup().showPopup(permission, popupTitle, popupContent, iUpcPopupGuideCallback);
    }
}
