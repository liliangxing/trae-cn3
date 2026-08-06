package coil3.request;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* compiled from: RequestDelegate.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil3/request/BaseRequestDelegate;", "Lcoil3/request/RequestDelegate;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "dispose", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BaseRequestDelegate implements RequestDelegate {
    private final Job job;

    public BaseRequestDelegate(Job job) {
        this.job = job;
    }

    @Override // coil3.request.RequestDelegate
    public void dispose() {
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }
}
