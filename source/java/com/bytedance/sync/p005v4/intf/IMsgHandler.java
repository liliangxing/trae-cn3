package com.bytedance.sync.p005v4.intf;

import com.bytedance.sync.p005v4.protocal.BsyncHeader;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IMsgHandler.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sync/v4/intf/IMsgHandler;", "T", "", "canHandle", "", "obj", "(Ljava/lang/Object;)Z", "handle", "", "header", "Lcom/bytedance/sync/v4/protocal/BsyncHeader;", "topics", "", "Lcom/bytedance/sync/v4/protocal/BsyncTopic;", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IMsgHandler<T> {
    boolean canHandle(T obj);

    void handle(BsyncHeader header, List<BsyncTopic> topics);
}
