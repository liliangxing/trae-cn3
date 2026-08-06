package com.bytedance.sync.p005v4.process;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.history.IHistoryMgr;
import com.bytedance.sync.p005v4.intf.IMsgHandler;
import com.bytedance.sync.p005v4.intf.IMsgHandlerWithMethod;
import com.bytedance.sync.p005v4.intf.IProtocolProcessor;
import com.bytedance.sync.p005v4.process.ctrl.AckPollCtrlHandler;
import com.bytedance.sync.p005v4.process.ctrl.HttpPollCtrlHandlerV4;
import com.bytedance.sync.p005v4.process.flag.DataMsgHandlerV4;
import com.bytedance.sync.p005v4.process.reason.InitAndSwitchMsgHandler;
import com.bytedance.sync.p005v4.protocal.BsyncHeader;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import com.bytedance.sync.p005v4.protocal.Ctrl;
import com.bytedance.sync.p005v4.protocal.Flag;
import com.bytedance.sync.p005v4.protocal.Reason;
import com.bytedance.sync.p005v4.protocal.Version;
import com.bytedance.sync.p005v4.upstream.UploadAckHandlerV4;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtocolProcessorV4.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0002J\u001a\u0010/\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0016\u0010\fR'\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00190\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001a\u0010\fR'\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001e\u0010\f¨\u00060"}, d2 = {"Lcom/bytedance/sync/v4/process/ProtocolProcessorV4;", "Lcom/bytedance/sync/v4/intf/IProtocolProcessor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "mCtrlMsgProcessors", "", "Lcom/bytedance/sync/v4/intf/IMsgHandler;", "Lcom/bytedance/sync/v4/protocal/Ctrl;", "getMCtrlMsgProcessors", "()Ljava/util/List;", "mCtrlMsgProcessors$delegate", "Lkotlin/Lazy;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "mMsgProcessors", "Lcom/bytedance/sync/v4/protocal/Flag;", "getMMsgProcessors", "mMsgProcessors$delegate", "mMsgProcessorsWithMethod", "Lcom/bytedance/sync/v4/intf/IMsgHandlerWithMethod;", "getMMsgProcessorsWithMethod", "mMsgProcessorsWithMethod$delegate", "mReasonMsgProcessors", "Lcom/bytedance/sync/v4/protocal/Reason;", "getMReasonMsgProcessors", "mReasonMsgProcessors$delegate", "dispatch", "", "method", "", "flag", "header", "Lcom/bytedance/sync/v4/protocal/BsyncHeader;", "sameFlagTopic", "", "Lcom/bytedance/sync/v4/protocal/BsyncTopic;", "dispatchByCtrl", "protocol", "Lcom/bytedance/sync/v4/protocal/BsyncProtocol;", "dispatchByFlag", "dispatchByReason", "process", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ProtocolProcessorV4 implements IProtocolProcessor {
    private final String TAG;
    private final Context context;

    /* renamed from: mCtrlMsgProcessors$delegate, reason: from kotlin metadata */
    private final Lazy mCtrlMsgProcessors;

    /* renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler;

    /* renamed from: mMsgProcessors$delegate, reason: from kotlin metadata */
    private final Lazy mMsgProcessors;

    /* renamed from: mMsgProcessorsWithMethod$delegate, reason: from kotlin metadata */
    private final Lazy mMsgProcessorsWithMethod;

    /* renamed from: mReasonMsgProcessors$delegate, reason: from kotlin metadata */
    private final Lazy mReasonMsgProcessors;

    public ProtocolProcessorV4(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.TAG = "[ProtocolProcessorV4] ";
        this.mMsgProcessors = LazyKt.lazy(new Function0<List<IMsgHandler<Flag>>>() { // from class: com.bytedance.sync.v4.process.ProtocolProcessorV4$mMsgProcessors$2
            public final List<IMsgHandler<Flag>> invoke() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new UploadAckHandlerV4());
                return arrayList;
            }
        });
        this.mMsgProcessorsWithMethod = LazyKt.lazy(new Function0<List<IMsgHandlerWithMethod<Flag>>>() { // from class: com.bytedance.sync.v4.process.ProtocolProcessorV4$mMsgProcessorsWithMethod$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final List<IMsgHandlerWithMethod<Flag>> invoke() {
                Context context2;
                ArrayList arrayList = new ArrayList();
                IMsgHandlerWithMethod<Flag> historyHandlerWithMethod = ((IHistoryMgr) UgBusFramework.getService(IHistoryMgr.class)).historyHandlerWithMethod();
                Intrinsics.checkNotNullExpressionValue(historyHandlerWithMethod, "getService(IHistoryMgr::…istoryHandlerWithMethod()");
                arrayList.add(historyHandlerWithMethod);
                context2 = ProtocolProcessorV4.this.context;
                arrayList.add(new DataMsgHandlerV4(context2));
                return arrayList;
            }
        });
        this.mCtrlMsgProcessors = LazyKt.lazy(new Function0<List<IMsgHandler<Ctrl>>>() { // from class: com.bytedance.sync.v4.process.ProtocolProcessorV4$mCtrlMsgProcessors$2
            public final List<IMsgHandler<Ctrl>> invoke() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new HttpPollCtrlHandlerV4());
                arrayList.add(new AckPollCtrlHandler());
                return arrayList;
            }
        });
        this.mReasonMsgProcessors = LazyKt.lazy(new Function0<List<IMsgHandler<Reason>>>() { // from class: com.bytedance.sync.v4.process.ProtocolProcessorV4$mReasonMsgProcessors$2
            public final List<IMsgHandler<Reason>> invoke() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new InitAndSwitchMsgHandler());
                return arrayList;
            }
        });
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.sync.v4.process.ProtocolProcessorV4$mHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m983invoke() {
                return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get());
            }
        });
    }

    private final List<IMsgHandler<Flag>> getMMsgProcessors() {
        return (List) this.mMsgProcessors.getValue();
    }

    private final List<IMsgHandlerWithMethod<Flag>> getMMsgProcessorsWithMethod() {
        return (List) this.mMsgProcessorsWithMethod.getValue();
    }

    private final List<IMsgHandler<Ctrl>> getMCtrlMsgProcessors() {
        return (List) this.mCtrlMsgProcessors.getValue();
    }

    private final List<IMsgHandler<Reason>> getMReasonMsgProcessors() {
        return (List) this.mReasonMsgProcessors.getValue();
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    @Override // com.bytedance.sync.p005v4.intf.IProtocolProcessor
    public void process(final int method, final BsyncProtocol protocol) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.sync.v4.process.ProtocolProcessorV4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ProtocolProcessorV4.m981process$lambda0(ProtocolProcessorV4.this, protocol, method);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), getMHandler().getLooper())) {
            runnable.run();
        } else {
            getMHandler().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: process$lambda-0, reason: not valid java name */
    public static final void m981process$lambda0(ProtocolProcessorV4 protocolProcessorV4, BsyncProtocol bsyncProtocol, int i) {
        Intrinsics.checkNotNullParameter(protocolProcessorV4, "this$0");
        LogUtils.m187i(protocolProcessorV4.TAG + "receive package -> " + bsyncProtocol);
        if (bsyncProtocol == null) {
            LogUtils.m187i(Intrinsics.stringPlus(protocolProcessorV4.TAG, "protocol is null"));
            return;
        }
        if (bsyncProtocol.header == null) {
            LogUtils.m186e(Intrinsics.stringPlus(protocolProcessorV4.TAG, "header is null"));
            return;
        }
        if (bsyncProtocol.header.version != Version.V4) {
            LogUtils.m186e(protocolProcessorV4.TAG + "version is " + bsyncProtocol.header.version + ", ignore");
            return;
        }
        if (bsyncProtocol.header.reason != null && bsyncProtocol.header.reason != Reason.Def) {
            protocolProcessorV4.dispatchByReason(bsyncProtocol);
        }
        if (bsyncProtocol.header.ctrl != null && bsyncProtocol.header.ctrl != Ctrl.Default) {
            protocolProcessorV4.dispatchByCtrl(bsyncProtocol);
            return;
        }
        List<BsyncTopic> list = bsyncProtocol.topics;
        if (list == null || list.isEmpty()) {
            LogUtils.m187i(Intrinsics.stringPlus(protocolProcessorV4.TAG, "topics is null"));
        } else {
            protocolProcessorV4.dispatchByFlag(i, bsyncProtocol);
        }
    }

    private final void dispatchByCtrl(BsyncProtocol protocol) {
        Iterator<T> it = getMCtrlMsgProcessors().iterator();
        while (it.hasNext()) {
            IMsgHandler iMsgHandler = (IMsgHandler) it.next();
            Ctrl ctrl = protocol.header.ctrl;
            Intrinsics.checkNotNullExpressionValue(ctrl, "protocol.header.ctrl");
            if (iMsgHandler.canHandle(ctrl)) {
                BsyncHeader bsyncHeader = protocol.header;
                Intrinsics.checkNotNullExpressionValue(bsyncHeader, "protocol.header");
                List<BsyncTopic> list = protocol.topics;
                Intrinsics.checkNotNullExpressionValue(list, "protocol.topics");
                iMsgHandler.handle(bsyncHeader, list);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void dispatchByReason(BsyncProtocol protocol) {
        try {
            for (Object obj : getMReasonMsgProcessors()) {
                Reason reason = protocol.header.reason;
                Intrinsics.checkNotNullExpressionValue(reason, "protocol.header.reason");
                if (((IMsgHandler) obj).canHandle(reason)) {
                    BsyncHeader bsyncHeader = protocol.header;
                    Intrinsics.checkNotNullExpressionValue(bsyncHeader, "protocol.header");
                    List<BsyncTopic> list = protocol.topics;
                    Intrinsics.checkNotNullExpressionValue(list, "protocol.topics");
                    ((IMsgHandler) obj).handle(bsyncHeader, list);
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (Throwable th) {
            LogUtils.m186e(Intrinsics.stringPlus("dispatch by reason err: ", th));
        }
    }

    private final void dispatchByFlag(int method, BsyncProtocol protocol) {
        ArrayList arrayList = new ArrayList();
        ArrayList<BsyncTopic> arrayList2 = new ArrayList();
        List<BsyncTopic> list = protocol.topics;
        Intrinsics.checkNotNullExpressionValue(list, "protocol.topics");
        for (BsyncTopic bsyncTopic : list) {
            if (bsyncTopic.flag == Flag.Sync) {
                Intrinsics.checkNotNullExpressionValue(bsyncTopic, "it");
                arrayList.add(bsyncTopic);
            } else {
                Intrinsics.checkNotNullExpressionValue(bsyncTopic, "it");
                arrayList2.add(bsyncTopic);
            }
        }
        if (!arrayList.isEmpty()) {
            Flag flag = ((BsyncTopic) CollectionsKt.first(arrayList)).flag;
            Intrinsics.checkNotNullExpressionValue(flag, "syncFlagTopic.first().flag");
            BsyncHeader bsyncHeader = protocol.header;
            Intrinsics.checkNotNullExpressionValue(bsyncHeader, "protocol.header");
            dispatch(method, flag, bsyncHeader, arrayList);
        }
        List<BsyncTopic> list2 = protocol.topics;
        Intrinsics.checkNotNullExpressionValue(list2, "protocol.topics");
        Flag flag2 = ((BsyncTopic) CollectionsKt.first(list2)).flag;
        ArrayList arrayList3 = new ArrayList();
        for (BsyncTopic bsyncTopic2 : arrayList2) {
            if (bsyncTopic2.flag == flag2) {
                arrayList3.add(bsyncTopic2);
            } else {
                if (flag2 != null && !arrayList3.isEmpty()) {
                    BsyncHeader bsyncHeader2 = protocol.header;
                    Intrinsics.checkNotNullExpressionValue(bsyncHeader2, "protocol.header");
                    dispatch(method, flag2, bsyncHeader2, arrayList3);
                }
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(bsyncTopic2);
                arrayList3 = arrayList4;
                flag2 = bsyncTopic2.flag;
            }
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNull(flag2);
        BsyncHeader bsyncHeader3 = protocol.header;
        Intrinsics.checkNotNullExpressionValue(bsyncHeader3, "protocol.header");
        dispatch(method, flag2, bsyncHeader3, arrayList3);
    }

    private final void dispatch(int method, Flag flag, BsyncHeader header, List<BsyncTopic> sameFlagTopic) {
        Iterator<IMsgHandler<Flag>> it = getMMsgProcessors().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IMsgHandler<Flag> next = it.next();
            if (next.canHandle(flag)) {
                next.handle(header, sameFlagTopic);
                break;
            }
        }
        for (IMsgHandlerWithMethod<Flag> iMsgHandlerWithMethod : getMMsgProcessorsWithMethod()) {
            if (iMsgHandlerWithMethod.canHandle(flag)) {
                iMsgHandlerWithMethod.handle(method, header, sameFlagTopic);
            }
        }
    }
}
