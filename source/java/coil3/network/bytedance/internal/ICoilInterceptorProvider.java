package coil3.network.bytedance.internal;

import com.bytedance.kmp.spi.IKmpService;
import java.util.List;
import kotlin.Metadata;

/* compiled from: utils.common.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcoil3/network/bytedance/internal/ICoilInterceptorProvider;", "Lcom/bytedance/kmp/spi/IKmpService;", "providerInterceptors", "", "Lcoil3/network/bytedance/internal/CoilInterceptor;", "coil_network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICoilInterceptorProvider extends IKmpService {
    List<CoilInterceptor> providerInterceptors();
}
