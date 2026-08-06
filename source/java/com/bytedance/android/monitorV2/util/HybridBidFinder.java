package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.util.AbsBidFinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridBidFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rJ\u001c\u0010\u0006\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0004j\b\u0012\u0004\u0012\u00020\u0001`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/monitorV2/util/HybridBidFinder;", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder;", "()V", "bidFinderList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "findBid", "", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "async", "", "resolve", "Lkotlin/Function1;", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder$BidMatchResult;", "url", "", "schema", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HybridBidFinder extends AbsBidFinder {
    public static final HybridBidFinder INSTANCE = new HybridBidFinder();
    private static final ArrayList<AbsBidFinder> bidFinderList;

    private HybridBidFinder() {
        super("default_bid");
    }

    static {
        bidFinderList = HostExperimentManager.INSTANCE.getDisableRegexList() ? CollectionsKt.arrayListOf(new AbsBidFinder[]{UriParamBidFinder.INSTANCE, DefaultBidFinder.INSTANCE}) : CollectionsKt.arrayListOf(new AbsBidFinder[]{UriParamBidFinder.INSTANCE, UriListBidFinder.INSTANCE, DefaultBidFinder.INSTANCE});
    }

    public final void findBid(final HybridEvent event, boolean async, final Function1<? super AbsBidFinder.BidMatchResult, Unit> resolve) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.util.HybridBidFinder$findBid$r$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m379invoke();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void m379invoke() {
                Object obj;
                AbsBidFinder.BidMatchResult findBid;
                boolean z;
                HybridBidFinder hybridBidFinder = HybridBidFinder.INSTANCE;
                HybridEvent hybridEvent = event;
                try {
                    Result.Companion companion = Result.Companion;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (hybridEvent instanceof CustomEvent) {
                    String bid = ((CustomEvent) hybridEvent).getCustomInfo().getBid();
                    if (bid != null && bid.length() != 0) {
                        z = false;
                        if (!z && !Intrinsics.areEqual(((CustomEvent) hybridEvent).getCustomInfo().getBid(), BidInfo.DEFAULT)) {
                            String bid2 = ((CustomEvent) hybridEvent).getCustomInfo().getBid();
                            Intrinsics.checkNotNullExpressionValue(bid2, "bid");
                            findBid = new AbsBidFinder.BidMatchResult(bid2, ReportConst.BidSourceInfo.CUSTOM_BID);
                            obj = Result.constructor-impl(findBid);
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                obj = HybridBidFinder.INSTANCE.getDefault();
                            }
                            resolve.invoke((AbsBidFinder.BidMatchResult) obj);
                        }
                    }
                    z = true;
                    if (!z) {
                        String bid22 = ((CustomEvent) hybridEvent).getCustomInfo().getBid();
                        Intrinsics.checkNotNullExpressionValue(bid22, "bid");
                        findBid = new AbsBidFinder.BidMatchResult(bid22, ReportConst.BidSourceInfo.CUSTOM_BID);
                        obj = Result.constructor-impl(findBid);
                        if (Result.exceptionOrNull-impl(obj) != null) {
                        }
                        resolve.invoke((AbsBidFinder.BidMatchResult) obj);
                    }
                }
                List<String> uriRegexInputList = hybridEvent.getUriRegexInputList();
                int size = uriRegexInputList.size();
                if (size == 1) {
                    findBid = hybridBidFinder.findBid(uriRegexInputList.get(0), "");
                } else if (size == 2) {
                    findBid = hybridBidFinder.findBid(uriRegexInputList.get(0), uriRegexInputList.get(1));
                } else {
                    findBid = hybridBidFinder.getDefault();
                }
                obj = Result.constructor-impl(findBid);
                if (Result.exceptionOrNull-impl(obj) != null) {
                }
                resolve.invoke((AbsBidFinder.BidMatchResult) obj);
            }
        };
        if (async) {
            HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.util.HybridBidFinder$findBid$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m378invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m378invoke() {
                    function0.invoke();
                }
            });
        } else {
            function0.invoke();
        }
    }

    @Override // com.bytedance.android.monitorV2.util.AbsBidFinder
    public AbsBidFinder.BidMatchResult findBid(String url, String schema) {
        Iterator<AbsBidFinder> it = bidFinderList.iterator();
        while (it.hasNext()) {
            AbsBidFinder.BidMatchResult findBid = it.next().findBid(url, schema);
            if (findBid.isSuccess()) {
                return findBid;
            }
        }
        return getDefault();
    }
}
