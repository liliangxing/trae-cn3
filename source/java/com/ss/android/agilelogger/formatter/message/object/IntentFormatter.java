package com.ss.android.agilelogger.formatter.message.object;

import android.content.Intent;
import com.ss.android.agilelogger.utils.ObjectToStringUtils;

/* loaded from: classes7.dex */
public class IntentFormatter implements ObjectFormatter<Intent> {
    @Override // com.ss.android.agilelogger.formatter.Formatter
    public String format(Intent intent) {
        return ObjectToStringUtils.intentToString(intent);
    }
}
