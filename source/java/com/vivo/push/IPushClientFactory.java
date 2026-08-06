package com.vivo.push;

import android.content.Intent;
import com.vivo.push.p017h.AbstractC1266ab;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IPushClientFactory {
    AbstractC1266ab createReceiveTask(AbstractC1400v abstractC1400v);

    AbstractC1400v createReceiverCommand(Intent intent);

    AbstractRunnableC1352s createTask(AbstractC1400v abstractC1400v);
}
