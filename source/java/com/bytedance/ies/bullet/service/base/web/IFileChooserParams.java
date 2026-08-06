package com.bytedance.ies.bullet.service.base.web;

import android.content.Intent;
import kotlin.Metadata;

/* compiled from: WebCompatDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0012\u0010\u000e\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/IFileChooserParams;", "", "acceptTypes", "", "", "getAcceptTypes", "()[Ljava/lang/String;", "filenameHint", "", "getFilenameHint", "()Ljava/lang/CharSequence;", "isCaptureEnabled", "", "()Z", "isMultiple", "mode", "", "getMode", "()I", "title", "getTitle", "createIntent", "Landroid/content/Intent;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IFileChooserParams {
    Intent createIntent();

    String[] getAcceptTypes();

    CharSequence getFilenameHint();

    int getMode();

    CharSequence getTitle();

    boolean isCaptureEnabled();

    boolean isMultiple();
}
