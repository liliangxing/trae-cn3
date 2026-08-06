package com.bytedance.ies.bullet.service.receiver.headset;

import kotlin.Metadata;

/* compiled from: IHeadSetReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/receiver/headset/IHeadSetListener;", "", "onPlug", "", "isConnect", "", "type", "Lcom/bytedance/ies/bullet/service/receiver/headset/HeadSetType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHeadSetListener {
    void onPlug(boolean isConnect, HeadSetType type);
}
