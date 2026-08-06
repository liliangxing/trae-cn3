package com.bytedance.lynx.service.markdownService;

import com.lynx.tasm.base.LLog;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;

/* compiled from: LynxMarkdownService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/lynx/service/markdownService/LynxMarkDownService;", "", "()V", "TAG", "", "sMarkDownClassName", "initialize", "", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxMarkDownService {
    public static final LynxMarkDownService INSTANCE = new LynxMarkDownService();
    public static final String TAG = "LynxMarkDownService";
    private static final String sMarkDownClassName = "com.bytedance.xelement.markdown.Markdown";

    private LynxMarkDownService() {
    }

    public final void initialize() {
        try {
            Class.forName(sMarkDownClassName).getDeclaredMethod("init", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            LLog.e(TAG, "LynxMarkDownService ClassNotFoundException");
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            LLog.e(TAG, "LynxMarkDownService IllegalAccessException");
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            LLog.e(TAG, "LynxMarkDownService NoSuchMethodException");
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            LLog.e(TAG, "LynxMarkDownService InvocationTargetException");
            e4.printStackTrace();
        }
    }
}
