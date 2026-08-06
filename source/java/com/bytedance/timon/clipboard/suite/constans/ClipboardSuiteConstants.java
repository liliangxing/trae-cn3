package com.bytedance.timon.clipboard.suite.constans;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: ClipboardSuiteConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/constans/ClipboardSuiteConstants;", "", "()V", "CLEAR_CLIPBOARD", "", "GET_CLIPBOARD_DESCRIPTION", "GET_PRIMARY_CLIP", "GET_TEXT", "ID_CLEAR_PRIMARY", "", "ID_GET_PRIMARY_CLIP", "ID_GET_PRIMARY_DESCRIPTION", "ID_GET_TEXT", "ID_SET_PRIMARY_CLIP", "ID_SET_TEXT", "ID_TO_METHOD_NAME", "", "getID_TO_METHOD_NAME", "()Ljava/util/Map;", "NAME_CLEAR_PRIMARY_CLIP", "NAME_GET_PRIMARY_CLIP", "NAME_GET_PRIMARY_CLIP_DESCRIPTION", "NAME_GET_TEXT", "NAME_SET_PRIMARY_CLIP", "NAME_SET_TEXT", "SET_PRIMARY_CLIP", "SET_TEXT", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ClipboardSuiteConstants {
    public static final String CLEAR_CLIPBOARD = "clipboard_clear";
    public static final String GET_CLIPBOARD_DESCRIPTION = "clipboard_getDescription";
    public static final String GET_PRIMARY_CLIP = "clipboard_getClip";
    public static final String GET_TEXT = "clipboard_getText";
    public static final String SET_PRIMARY_CLIP = "clipboard_setClip";
    public static final String SET_TEXT = "clipboard_setText";
    public static final ClipboardSuiteConstants INSTANCE = new ClipboardSuiteConstants();
    public static final int ID_GET_PRIMARY_CLIP = 101803;
    private static final String NAME_GET_PRIMARY_CLIP = "getPrimaryClip";
    public static final int ID_GET_TEXT = 101804;
    private static final String NAME_GET_TEXT = "getText";
    public static final int ID_SET_PRIMARY_CLIP = 101807;
    private static final String NAME_SET_PRIMARY_CLIP = "setPrimaryClip";
    public static final int ID_SET_TEXT = 101808;
    private static final String NAME_SET_TEXT = "setText";
    public static final int ID_GET_PRIMARY_DESCRIPTION = 101809;
    private static final String NAME_GET_PRIMARY_CLIP_DESCRIPTION = "getPrimaryClipDescription";
    public static final int ID_CLEAR_PRIMARY = 101800;
    private static final String NAME_CLEAR_PRIMARY_CLIP = "clearPrimaryClip";
    private static final Map<Integer, String> ID_TO_METHOD_NAME = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ID_GET_PRIMARY_CLIP), NAME_GET_PRIMARY_CLIP), TuplesKt.to(Integer.valueOf(ID_GET_TEXT), NAME_GET_TEXT), TuplesKt.to(Integer.valueOf(ID_SET_PRIMARY_CLIP), NAME_SET_PRIMARY_CLIP), TuplesKt.to(Integer.valueOf(ID_SET_TEXT), NAME_SET_TEXT), TuplesKt.to(Integer.valueOf(ID_GET_PRIMARY_DESCRIPTION), NAME_GET_PRIMARY_CLIP_DESCRIPTION), TuplesKt.to(Integer.valueOf(ID_CLEAR_PRIMARY), NAME_CLEAR_PRIMARY_CLIP)});

    private ClipboardSuiteConstants() {
    }

    public final Map<Integer, String> getID_TO_METHOD_NAME() {
        return ID_TO_METHOD_NAME;
    }
}
