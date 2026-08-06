package com.bytedance.timon.upc.upc_adapter_api;

import android.app.Activity;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.timonbase.ITMBusinessService;
import com.bytedance.upc.IPrivacyChangeListener;
import com.bytedance.upc.IUpcDialog;
import com.bytedance.upc.IUpcPopupGuideCallback;
import com.bytedance.upc.IUpcPrivacyDialog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ss.android.pushmanager.PushCommonConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: IUpcBusinessService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0013H&J\b\u0010\u0014\u001a\u00020\rH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH&J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000bH&J\u001a\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\rH&J,\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0013H&J\"\u0010 \u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H&J*\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010*H&J&\u0010+\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020.0-H&¨\u0006/"}, d2 = {"Lcom/bytedance/timon/upc/upc_adapter_api/IUpcBusinessService;", "Lcom/bytedance/timonbase/ITMBusinessService;", "addPrivacyStatusChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/upc/IPrivacyChangeListener;", "clearPrivacyStatus", "", "syncService", "disMissDialog", "id", "", "getAllowStayDuration", "", "getPrivacyStatus", "key", "default", "getTeenModeEnable", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "getTeenModeEntryDuration", "load", "url", PushCommonConstants.VALUE_OPEN, "scheme", "setPrivacyStatus", "value", "setTeenModeAllowStayDuration", "duration", "setTeenModeEnable", "enable", "passwd", "showDialog", "activity", "Landroid/app/Activity;", "iUpcDialog", "Lcom/bytedance/upc/IUpcDialog;", "showPopup", "permission", "popupTitle", "popupContent", "iUpcPopupGuideCallback", "Lcom/bytedance/upc/IUpcPopupGuideCallback;", "tryCheckPrivacy", "config", "", "Lcom/bytedance/upc/IUpcPrivacyDialog;", "upc-adapter-api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface IUpcBusinessService extends ITMBusinessService {
    void addPrivacyStatusChangeListener(IPrivacyChangeListener listener);

    boolean clearPrivacyStatus(boolean syncService);

    void disMissDialog(String id);

    long getAllowStayDuration();

    String getPrivacyStatus(String key, String r2);

    void getTeenModeEnable(Function1<? super Boolean, Unit> callback);

    long getTeenModeEntryDuration();

    void load(String url);

    boolean open(String scheme);

    boolean setPrivacyStatus(String key, String value);

    void setTeenModeAllowStayDuration(long duration);

    void setTeenModeEnable(boolean enable, String passwd, Function1<? super Boolean, Unit> callback);

    boolean showDialog(String id, Activity activity, IUpcDialog iUpcDialog);

    void showPopup(String permission, String popupTitle, String popupContent, IUpcPopupGuideCallback iUpcPopupGuideCallback);

    void tryCheckPrivacy(Activity activity, Map<String, ? extends IUpcPrivacyDialog> config);
}
