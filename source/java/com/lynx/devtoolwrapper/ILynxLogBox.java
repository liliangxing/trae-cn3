package com.lynx.devtoolwrapper;

import android.content.Context;
import com.lynx.tasm.LynxError;

/* loaded from: classes6.dex */
public interface ILynxLogBox {
    void attachContext(Context context);

    void onLoadTemplate();

    void showLogMessage(LynxError lynxError);
}
