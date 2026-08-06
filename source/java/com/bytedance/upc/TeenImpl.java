package com.bytedance.upc;

import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J,\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/TeenImpl;", "Lcom/bytedance/upc/ITeenMode;", "getAllowStayDuration", "", "getTeenModeEnable", "", "callback", "Lkotlin/Function1;", "", "getTeenModeEntryDuration", "setTeenModeAllowStayDuration", "duration", "setTeenModeEnable", "enable", "passwd", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public interface TeenImpl extends ITeenMode {
    @Override // com.bytedance.upc.ITeenMode
    long getAllowStayDuration();

    @Override // com.bytedance.upc.ITeenMode
    void getTeenModeEnable(Function1<? super Boolean, Unit> callback);

    @Override // com.bytedance.upc.ITeenMode
    long getTeenModeEntryDuration();

    @Override // com.bytedance.upc.ITeenMode
    void setTeenModeAllowStayDuration(long duration);

    @Override // com.bytedance.upc.ITeenMode
    void setTeenModeEnable(boolean enable, String passwd, Function1<? super Boolean, Unit> callback);

    /* compiled from: UpcImpl.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class DefaultImpls {
        public static void getTeenModeEnable(TeenImpl teenImpl, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "callback");
            try {
                IUpcTeenModeService iUpcTeenModeService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIUpcTeenModeService;
                if (iUpcTeenModeService != null) {
                    iUpcTeenModeService.getTeenModeEnable(function1);
                }
            } catch (Throwable unused) {
            }
        }

        public static void setTeenModeEnable(TeenImpl teenImpl, boolean z, String str, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(str, "passwd");
            Intrinsics.checkParameterIsNotNull(function1, "callback");
            try {
                IUpcTeenModeService iUpcTeenModeService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIUpcTeenModeService;
                if (iUpcTeenModeService != null) {
                    iUpcTeenModeService.setTeenModeEnable(z, str, function1);
                }
            } catch (Throwable unused) {
            }
        }

        public static void setTeenModeAllowStayDuration(TeenImpl teenImpl, long j) {
            try {
                IUpcTeenModeService iUpcTeenModeService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIUpcTeenModeService;
                if (iUpcTeenModeService != null) {
                    iUpcTeenModeService.setAllowStayDuration(j);
                }
            } catch (Throwable unused) {
            }
        }

        public static long getAllowStayDuration(TeenImpl teenImpl) {
            try {
                IUpcTeenModeService iUpcTeenModeService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIUpcTeenModeService;
                if (iUpcTeenModeService != null) {
                    return iUpcTeenModeService.getAllowStayDuration();
                }
                return -1L;
            } catch (Throwable unused) {
                return -1L;
            }
        }

        public static long getTeenModeEntryDuration(TeenImpl teenImpl) {
            try {
                IUpcTeenModeService iUpcTeenModeService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIUpcTeenModeService;
                if (iUpcTeenModeService != null) {
                    return iUpcTeenModeService.getTeenModeEntryDuration();
                }
                return -1L;
            } catch (Throwable unused) {
                return -1L;
            }
        }
    }
}
