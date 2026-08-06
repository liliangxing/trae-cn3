package com.ss.android.agilelogger.formatter.message;

import com.ss.android.agilelogger.formatter.Formatter;
import java.util.Date;

/* loaded from: classes7.dex */
public class DefaultDateFormatter implements Formatter<String> {
    private Date date;

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public String format(String str) {
        return str;
    }

    public DefaultDateFormatter() {
        this("MM-dd HH:mm:ss");
    }

    public DefaultDateFormatter(String str) {
        this.date = new Date();
    }
}
