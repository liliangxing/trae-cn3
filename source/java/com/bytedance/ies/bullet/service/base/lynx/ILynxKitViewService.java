package com.bytedance.ies.bullet.service.base.lynx;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.argus.api.interfaces.service.ArgusBaseBizService;
import com.bytedance.ies.bullet.IBulletKitViewService;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ILynxKitViewService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u001c\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\bH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitViewService;", "Lcom/bytedance/ies/bullet/IBulletKitViewService;", "listenPreserveDataChanged", "", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "", "onlyGetPreserveData", "", "load", "templateArray", "", "baseUrl", "", "registerSecureService", "service", "Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseBizService;", "reloadTemplate", "reloadTemplateWithGlobalProps", "globalProps", "", "resetData", "setPreCreate", GlobalPropertiesConstants.IS_PRE_CREATE, "updateScreenMetrics", "width", "", "height", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ILynxKitViewService extends IBulletKitViewService {
    void listenPreserveDataChanged(Function1<Object, Unit> callback, boolean onlyGetPreserveData);

    void load(byte[] templateArray, String baseUrl);

    void registerSecureService(ArgusBaseBizService service);

    void reloadTemplate();

    void reloadTemplateWithGlobalProps();

    void reloadTemplateWithGlobalProps(Map<String, ? extends Object> globalProps);

    void resetData();

    void setPreCreate(boolean isPreCreate);

    void updateScreenMetrics(int width, int height);

    /* compiled from: ILynxKitViewService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void registerSecureService(ILynxKitViewService iLynxKitViewService, ArgusBaseBizService service) {
            Intrinsics.checkNotNullParameter(service, "service");
        }

        public static boolean ensureViewCreated(ILynxKitViewService iLynxKitViewService, String schemaUrl) {
            Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
            return IBulletKitViewService.DefaultImpls.ensureViewCreated(iLynxKitViewService, schemaUrl);
        }
    }
}
