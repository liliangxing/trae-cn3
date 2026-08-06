package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetHtml;
import com.bytedance.trae.im.model.MessagePart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VoiceAttachmentIconResolver.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;", "", "<init>", "()V", "getFileIconRes", "", "fileName", "", "mimeType", "isImage", "", "normalizeFileName", "extensionCandidates", "", "resolveByMimeType", "FILENAME_ICON_MAP", "", "COMPOUND_EXTENSIONS", "EXTENSION_ICON_MAP", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceAttachmentIconResolver {
    public static final VoiceAttachmentIconResolver INSTANCE = new VoiceAttachmentIconResolver();
    private static final Map<String, Integer> FILENAME_ICON_MAP = MapsKt.mapOf(new Pair[]{TuplesKt.to("readme", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_markdown)), TuplesKt.to("license", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("dockerfile", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("makefile", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text))});
    private static final List<String> COMPOUND_EXTENSIONS = CollectionsKt.listOf(new String[]{"tar.gz", "tar.bz2", "tar.xz", "d.ts"});
    private static final Map<String, Integer> EXTENSION_ICON_MAP = MapsKt.mapOf(new Pair[]{TuplesKt.to("png", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("apng", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("gif", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("bmp", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("webp", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("heic", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("heif", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("tif", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("tiff", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("svg", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_png)), TuplesKt.to("jpg", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_jpg)), TuplesKt.to("jpeg", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_jpg)), TuplesKt.to("html", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_html)), TuplesKt.to("htm", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_html)), TuplesKt.to("zip", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("rar", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("7z", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("tar", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("gz", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("bz2", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("xz", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("tgz", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("tar.gz", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("tar.bz2", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("tar.xz", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_zip)), TuplesKt.to("json", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_json)), TuplesKt.to("jsonc", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_json)), TuplesKt.to("json5", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_json)), TuplesKt.to("md", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_markdown)), TuplesKt.to("markdown", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_markdown)), TuplesKt.to("mdx", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_markdown)), TuplesKt.to("pdf", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_pdf)), TuplesKt.to(MessagePart.TYPE_DOC, Integer.valueOf(C0637R.drawable.trae_ic_voice_file_word)), TuplesKt.to("docx", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_word)), TuplesKt.to("rtf", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_word)), TuplesKt.to("xls", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_excel)), TuplesKt.to("xlsx", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_excel)), TuplesKt.to("csv", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_excel)), TuplesKt.to("numbers", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_excel)), TuplesKt.to("ppt", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_ppt)), TuplesKt.to("pptx", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_ppt)), TuplesKt.to("key", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_ppt)), TuplesKt.to("mp4", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp4)), TuplesKt.to("mov", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp4)), TuplesKt.to("m4v", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp4)), TuplesKt.to("avi", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp4)), TuplesKt.to("mkv", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp4)), TuplesKt.to("webm", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp4)), TuplesKt.to("mp3", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp3)), TuplesKt.to("wav", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp3)), TuplesKt.to("m4a", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp3)), TuplesKt.to("aac", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp3)), TuplesKt.to("flac", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp3)), TuplesKt.to("ogg", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_mp3)), TuplesKt.to("diff", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_diff)), TuplesKt.to("patch", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_diff)), TuplesKt.to("fig", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_design)), TuplesKt.to(MessagePart.TYPE_FIGMA, Integer.valueOf(C0637R.drawable.trae_ic_voice_file_design)), TuplesKt.to("sketch", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_design)), TuplesKt.to("xd", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_design)), TuplesKt.to("skill", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_skill)), TuplesKt.to(MessagePart.TYPE_FOLDER, Integer.valueOf(C0637R.drawable.trae_ic_voice_file_folder)), TuplesKt.to("txt", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("text", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to(MessagePart.TYPE_LOG, Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("xml", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("yaml", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("yml", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("properties", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("gradle", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("js", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("jsx", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("ts", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("tsx", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("d.ts", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("java", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("kt", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("kts", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("py", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("go", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("rs", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("c", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("cpp", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("cc", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("cxx", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("h", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("hpp", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("css", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("scss", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("less", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("sh", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("bash", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text)), TuplesKt.to("zsh", Integer.valueOf(C0637R.drawable.trae_ic_voice_file_text))});

    private VoiceAttachmentIconResolver() {
    }

    public static /* synthetic */ int getFileIconRes$default(VoiceAttachmentIconResolver voiceAttachmentIconResolver, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return voiceAttachmentIconResolver.getFileIconRes(str, str2, z);
    }

    public final int getFileIconRes(String fileName, String mimeType, boolean isImage) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String normalizeFileName = normalizeFileName(fileName);
        Integer num = FILENAME_ICON_MAP.get(normalizeFileName);
        if (num != null) {
            return num.intValue();
        }
        Iterator<T> it = extensionCandidates(normalizeFileName).iterator();
        while (it.hasNext()) {
            Integer num2 = EXTENSION_ICON_MAP.get((String) it.next());
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return resolveByMimeType(mimeType, isImage);
    }

    private final String normalizeFileName(String fileName) {
        String obj = StringsKt.trim(StringsKt.substringAfterLast$default(StringsKt.replace$default(StringsKt.substringBefore$default(StringsKt.substringBefore$default(fileName, '?', (String) null, 2, (Object) null), '#', (String) null, 2, (Object) null), '\\', '/', false, 4, (Object) null), '/', (String) null, 2, (Object) null)).toString();
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final List<String> extensionCandidates(String fileName) {
        if (StringsKt.isBlank(fileName)) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = COMPOUND_EXTENSIONS.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (StringsKt.endsWith$default(fileName, "." + next, false, 2, (Object) null)) {
                arrayList.add(next);
                break;
            }
        }
        String substringAfterLast = StringsKt.substringAfterLast(fileName, '.', "");
        if ((!StringsKt.isBlank(substringAfterLast)) && !Intrinsics.areEqual(substringAfterLast, fileName)) {
            arrayList.add(substringAfterLast);
        }
        return CollectionsKt.distinct(arrayList);
    }

    private final int resolveByMimeType(String mimeType, boolean isImage) {
        String str;
        String substringBefore$default;
        String obj;
        if (mimeType == null || (substringBefore$default = StringsKt.substringBefore$default(mimeType, ';', (String) null, 2, (Object) null)) == null || (obj = StringsKt.trim(substringBefore$default).toString()) == null) {
            str = null;
        } else {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            str = obj.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        if (str == null) {
            str = "";
        }
        if (isImage || StringsKt.startsWith$default(str, "image/", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_png;
        }
        if (StringsKt.startsWith$default(str, "video/", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_mp4;
        }
        if (StringsKt.startsWith$default(str, "audio/", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_mp3;
        }
        if (Intrinsics.areEqual(str, "application/pdf")) {
            return C0637R.drawable.trae_ic_voice_file_pdf;
        }
        String str2 = str;
        if (StringsKt.contains$default(str2, "word", false, 2, (Object) null) || StringsKt.contains$default(str2, "msword", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_word;
        }
        if (StringsKt.contains$default(str2, "excel", false, 2, (Object) null) || StringsKt.contains$default(str2, "spreadsheet", false, 2, (Object) null) || StringsKt.contains$default(str2, "csv", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_excel;
        }
        if (StringsKt.contains$default(str2, "powerpoint", false, 2, (Object) null) || StringsKt.contains$default(str2, "presentation", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_ppt;
        }
        if (StringsKt.contains$default(str2, "json", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_json;
        }
        if (StringsKt.contains$default(str2, "markdown", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_markdown;
        }
        if (StringsKt.contains$default(str2, "zip", false, 2, (Object) null) || StringsKt.contains$default(str2, "compressed", false, 2, (Object) null) || StringsKt.contains$default(str2, "gzip", false, 2, (Object) null) || StringsKt.contains$default(str2, "tar", false, 2, (Object) null)) {
            return C0637R.drawable.trae_ic_voice_file_zip;
        }
        return Intrinsics.areEqual(str, PureShowWidgetHtml.MIME_TYPE) ? C0637R.drawable.trae_ic_voice_file_html : StringsKt.startsWith$default(str, "text/", false, 2, (Object) null) ? C0637R.drawable.trae_ic_voice_file_text : C0637R.drawable.trae_ic_voice_file_generic;
    }
}
