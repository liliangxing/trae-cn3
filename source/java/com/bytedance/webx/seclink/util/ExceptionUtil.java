package com.bytedance.webx.seclink.util;

import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.base.IExceptionHandler;

/* loaded from: classes6.dex */
public class ExceptionUtil {
    public static void handleException(Exception exc) {
        IExceptionHandler exceptionHandler = SecLinkFacade.getExceptionHandler();
        if (exceptionHandler != null) {
            exceptionHandler.handleException(exc);
        }
    }
}
