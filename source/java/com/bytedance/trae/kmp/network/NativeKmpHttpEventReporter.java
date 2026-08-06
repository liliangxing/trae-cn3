package com.bytedance.trae.kmp.network;

import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.trae.network.TraeRequestEventReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKmpHttpClientFactory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0085\u0001\b\u0002\u0010\u0002\u001a\u007f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u008b\u0001\u0010\u0002\u001a\u007f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter;", "Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;", "reporter", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "path", "", "costTime", "code", "message", "", "headers", "", "<init>", "(Lkotlin/jvm/functions/Function5;)V", "report", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/trae/kmp/network/KmpHttpRequestEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NativeKmpHttpEventReporter implements KmpHttpEventReporter {
    public static final int $stable = 0;
    private final Function5<String, Long, Long, String, Map<String, String>, Unit> reporter;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NativeKmpHttpEventReporter() {
        this(r0, 1, r0);
        Function5 function5 = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeKmpHttpEventReporter(Function5<? super String, ? super Long, ? super Long, ? super String, ? super Map<String, String>, Unit> function5) {
        Intrinsics.checkNotNullParameter(function5, "reporter");
        this.reporter = function5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AndroidKmpHttpClientFactory.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.bytedance.trae.kmp.network.NativeKmpHttpEventReporter$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class C08141 extends FunctionReferenceImpl implements Function5<String, Long, Long, String, Map<String, ? extends String>, Unit> {
        C08141(Object obj) {
            super(5, obj, TraeRequestEventReporter.class, "report", "report(Ljava/lang/String;JJLjava/lang/String;Ljava/util/Map;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            invoke((String) obj, ((Number) obj2).longValue(), ((Number) obj3).longValue(), (String) obj4, (Map<String, String>) obj5);
            return Unit.INSTANCE;
        }

        public final void invoke(String str, long j, long j2, String str2, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str2, "p3");
            Intrinsics.checkNotNullParameter(map, "p4");
            ((TraeRequestEventReporter) this.receiver).report(str, j, j2, str2, map);
        }
    }

    public /* synthetic */ NativeKmpHttpEventReporter(C08141 c08141, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C08141(TraeRequestEventReporter.INSTANCE) : c08141);
    }

    @Override // com.bytedance.trae.kmp.network.KmpHttpEventReporter
    public void report(KmpHttpRequestEvent event) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        this.reporter.invoke(event.getPath(), Long.valueOf(event.getCostTimeMs()), Long.valueOf(event.getCode()), event.getMessage(), event.getHeaders());
    }
}
