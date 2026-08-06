package com.bytedance.trae.conversation.products;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetHtml;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.bytedance.trae.im.model.MessagePart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DiffViewerHelper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0016\u0010\u0016\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u001e\u0010\u0019\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/products/DiffViewerHelper;", "", "<init>", "()V", "showDiff", "", "webView", "Landroid/webkit/WebView;", "diffFiles", "", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "taskName", "", "escapeHtml", "text", "escapeJs", "getFileAction", MessagePart.TYPE_FILE, "Lcom/bytedance/trae/conversation/products/DiffFile;", "getFileActionIcon", "action", "getFileActionBgColor", "buildFileBlocksHtml", "getLanguageFromPath", "filePath", "buildDiffHtml", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DiffViewerHelper {
    public static final DiffViewerHelper INSTANCE = new DiffViewerHelper();

    private DiffViewerHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showDiff(WebView webView, List<FileDiffInfo> diffFiles, String taskName) {
        String filePath;
        String str;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(diffFiles, "diffFiles");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        List<FileDiffInfo> list = diffFiles;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (FileDiffInfo fileDiffInfo : list) {
            if (fileDiffInfo.getBeforeContent() == null && fileDiffInfo.getAfterContent() != null) {
                filePath = null;
            } else {
                filePath = fileDiffInfo.getFilePath();
                if (filePath == null) {
                    str = "";
                    String filePath2 = fileDiffInfo.getFilePath();
                    String str2 = filePath2 != null ? "" : filePath2;
                    Integer insertLineCount = fileDiffInfo.getInsertLineCount();
                    int intValue = insertLineCount == null ? insertLineCount.intValue() : 0;
                    Integer deleteLineCount = fileDiffInfo.getDeleteLineCount();
                    int intValue2 = deleteLineCount != null ? deleteLineCount.intValue() : 0;
                    String beforeContent = fileDiffInfo.getBeforeContent();
                    String str3 = beforeContent != null ? "" : beforeContent;
                    String afterContent = fileDiffInfo.getAfterContent();
                    arrayList.add(new DiffFile(str, str2, intValue, intValue2, str3, afterContent != null ? "" : afterContent, false, Intrinsics.areEqual(fileDiffInfo.isConflict(), true), 64, null));
                }
            }
            str = filePath;
            String filePath22 = fileDiffInfo.getFilePath();
            if (filePath22 != null) {
            }
            Integer insertLineCount2 = fileDiffInfo.getInsertLineCount();
            if (insertLineCount2 == null) {
            }
            Integer deleteLineCount2 = fileDiffInfo.getDeleteLineCount();
            int intValue22 = deleteLineCount2 != null ? deleteLineCount2.intValue() : 0;
            String beforeContent2 = fileDiffInfo.getBeforeContent();
            if (beforeContent2 != null) {
            }
            String afterContent2 = fileDiffInfo.getAfterContent();
            arrayList.add(new DiffFile(str, str2, intValue, intValue22, str3, afterContent2 != null ? "" : afterContent2, false, Intrinsics.areEqual(fileDiffInfo.isConflict(), true), 64, null));
        }
        webView.loadDataWithBaseURL("https://localhost", buildDiffHtml(arrayList, taskName), PureShowWidgetHtml.MIME_TYPE, "UTF-8", null);
    }

    private final String escapeHtml(String text) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text, "&", "&amp;", false, 4, (Object) null), "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null), "\"", "&quot;", false, 4, (Object) null), "'", "&#39;", false, 4, (Object) null);
    }

    private final String escapeJs(String text) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text, "\\", "\\\\", false, 4, (Object) null), "`", "\\`", false, 4, (Object) null), "$", "\\$", false, 4, (Object) null), "</script>", "<\\/script>", false, 4, (Object) null);
    }

    private final String getFileAction(DiffFile file) {
        if (file.isNewFile()) {
            return "added";
        }
        if (file.getNewContent().length() == 0) {
            if (file.getOldContent().length() > 0) {
                return "deleted";
            }
        }
        return "modified";
    }

    private final String getFileActionIcon(String action) {
        return Intrinsics.areEqual(action, "added") ? "<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" fill=\"none\"><rect x=\"2\" y=\"2\" width=\"12\" height=\"12\" rx=\"2\" fill=\"#1a7f37\" fill-opacity=\"0.15\"/><path d=\"M8 5v6M5 8h6\" stroke=\"#1a7f37\" stroke-width=\"1.5\" stroke-linecap=\"round\"/></svg>" : Intrinsics.areEqual(action, "deleted") ? "<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" fill=\"none\"><rect x=\"2\" y=\"2\" width=\"12\" height=\"12\" rx=\"2\" fill=\"#cf222e\" fill-opacity=\"0.15\"/><path d=\"M5 8h6\" stroke=\"#cf222e\" stroke-width=\"1.5\" stroke-linecap=\"round\"/></svg>" : "<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" fill=\"none\"><rect x=\"2\" y=\"2\" width=\"12\" height=\"12\" rx=\"2\" fill=\"#9a6700\" fill-opacity=\"0.15\"/><path d=\"M6 6.5h4M8 4.5v4\" stroke=\"#1a7f37\" stroke-width=\"1.5\" stroke-linecap=\"round\"/><path d=\"M6 11h4\" stroke=\"#cf222e\" stroke-width=\"1.5\" stroke-linecap=\"round\"/></svg>";
    }

    private final String getFileActionBgColor(String action) {
        return Intrinsics.areEqual(action, "added") ? "rgba(63,185,80,0.10)" : Intrinsics.areEqual(action, "deleted") ? "rgba(248,81,73,0.10)" : "rgba(154,103,0,0.10)";
    }

    private final String buildFileBlocksHtml(List<DiffFile> diffFiles) {
        StringBuilder sb = new StringBuilder();
        for (DiffFile diffFile : diffFiles) {
            String newPath = diffFile.getNewPath();
            String substringAfterLast$default = StringsKt.substringAfterLast$default(newPath, "/", (String) null, 2, (Object) null);
            String substringBeforeLast = StringsKt.substringBeforeLast(newPath, "/", "");
            String fileAction = getFileAction(diffFile);
            String fileActionIcon = getFileActionIcon(fileAction);
            String fileActionBgColor = getFileActionBgColor(fileAction);
            sb.append("<div class=\"file-block\" data-filepath=\"" + escapeHtml(newPath) + "\">");
            sb.append("<div class=\"file-header\" onclick=\"toggleFileBlock(this)\"><div class=\"file-header-left\"><span class=\"expand-btn\"><svg class=\"chevron\" width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" fill=\"none\"><path d=\"M4 6l4 4 4-4\" stroke=\"#656d76\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg></span>");
            sb.append("<span class=\"file-icon\" style=\"background:" + fileActionBgColor + "\">" + fileActionIcon + "</span>");
            sb.append("</div><div class=\"file-info\">");
            sb.append("<span class=\"file-name\">" + escapeHtml(substringAfterLast$default) + "</span>");
            if (substringBeforeLast.length() > 0) {
                sb.append("<span class=\"file-path\">" + escapeHtml(substringBeforeLast) + "</span>");
            }
            sb.append("</div><div class=\"diff-stats\">");
            if (diffFile.isConflict()) {
                sb.append("<span class=\"conflict-badge\">Conflict</span>");
            } else {
                sb.append("<span class=\"additions\">+" + diffFile.getInsertLineCount() + "</span>");
                sb.append("<span class=\"deletions\">-" + diffFile.getDeleteLineCount() + "</span>");
            }
            sb.append("</div></div><div class=\"file-content\"><div class=\"diff-wrapper\"><div class=\"diff-table\">");
            if (diffFile.getOldContent().length() == 0) {
                CollectionsKt.emptyList();
            } else {
                StringsKt.lines(diffFile.getOldContent());
            }
            if (diffFile.getNewContent().length() == 0) {
                CollectionsKt.emptyList();
            } else {
                StringsKt.lines(diffFile.getNewContent());
            }
            sb.append("<div class=\"diff-lines-data\" ");
            sb.append("data-old=\"" + escapeHtml(escapeJs(diffFile.getOldContent())) + "\" ");
            sb.append("data-new=\"" + escapeHtml(escapeJs(diffFile.getNewContent())) + "\" ");
            sb.append("data-lang=\"" + escapeHtml(getLanguageFromPath(newPath)) + "\">");
            sb.append("</div></div></div></div></div>");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01c2, code lost:
    
        if (r11.equals("cc") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01d9, code lost:
    
        if (r11.equals("h") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:?, code lost:
    
        return "c";
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01e0, code lost:
    
        if (r11.equals("c") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01ec, code lost:
    
        if (r11.equals("svelte") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        if (r11.equals("yaml") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return "yaml";
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        if (r11.equals("scss") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return "scss";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if (r11.equals("sass") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0090, code lost:
    
        if (r11.equals("html") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return "html";
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        if (r11.equals("bash") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return "bash";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a3, code lost:
    
        if (r11.equals("zsh") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
    
        if (r11.equals("yml") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b9, code lost:
    
        if (r11.equals("xml") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        return "xml";
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0036, code lost:
    
        if (r11.equals("markdown") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0102, code lost:
    
        if (r11.equals("htm") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return "markdown";
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x010f, code lost:
    
        if (r11.equals("hpp") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
    
        return "cpp";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0119, code lost:
    
        if (r11.equals("cxx") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012b, code lost:
    
        if (r11.equals("cpp") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0146, code lost:
    
        if (r11.equals("sh") == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x018a, code lost:
    
        if (r11.equals("md") == false) goto L143;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x002d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f1 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d0 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getLanguageFromPath(String filePath) {
        String lowerCase = StringsKt.substringAfterLast(filePath, ".", "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -890523077:
                break;
            case 99:
                break;
            case 104:
                break;
            case 109:
                return !lowerCase.equals("m") ? "plaintext" : "objectivec";
            case 3168:
                break;
            case 3184:
                if (lowerCase.equals("cs")) {
                    return "csharp";
                }
                break;
            case 3304:
                if (lowerCase.equals("go")) {
                    return "go";
                }
                break;
            case 3401:
                if (lowerCase.equals("js")) {
                    return "javascript";
                }
                break;
            case 3433:
                if (lowerCase.equals("kt")) {
                    return "kotlin";
                }
                break;
            case 3479:
                break;
            case 3488:
                if (!lowerCase.equals("mm")) {
                }
                break;
            case 3593:
                if (lowerCase.equals("py")) {
                    return "python";
                }
                break;
            case 3632:
                if (lowerCase.equals("rb")) {
                    return "ruby";
                }
                break;
            case 3649:
                if (lowerCase.equals("rs")) {
                    return "rust";
                }
                break;
            case 3669:
                break;
            case 3711:
                if (lowerCase.equals("ts")) {
                    return "typescript";
                }
                break;
            case 98723:
                break;
            case 98819:
                if (lowerCase.equals("css")) {
                    return "css";
                }
                break;
            case 98979:
                break;
            case 103528:
                break;
            case 103649:
                break;
            case 105551:
                if (lowerCase.equals("jsx")) {
                    return "javascript";
                }
                break;
            case 106538:
                if (!lowerCase.equals("kts")) {
                }
                break;
            case 110968:
                if (lowerCase.equals("php")) {
                    return "php";
                }
                break;
            case 114126:
                if (lowerCase.equals("sql")) {
                    return "sql";
                }
                break;
            case 115161:
                if (!lowerCase.equals("tsx")) {
                }
                break;
            case 117126:
                if (lowerCase.equals("vue")) {
                    return "javascript";
                }
                break;
            case 118807:
                break;
            case 119768:
                break;
            case 120911:
                break;
            case 3016404:
                break;
            case 3213227:
                break;
            case 3254818:
                if (lowerCase.equals("java")) {
                    return "java";
                }
                break;
            case 3271912:
                if (lowerCase.equals("json")) {
                    return "json";
                }
                break;
            case 3318169:
                if (lowerCase.equals("less")) {
                    return "less";
                }
                break;
            case 3522862:
                break;
            case 3524784:
                break;
            case 3701415:
                break;
            case 109250886:
                if (lowerCase.equals("scala")) {
                    return "scala";
                }
                break;
            case 109854227:
                if (lowerCase.equals("swift")) {
                    return "swift";
                }
                break;
            case 246938863:
                break;
        }
    }

    private final String buildDiffHtml(List<DiffFile> diffFiles, String taskName) {
        int size = diffFiles.size();
        List<DiffFile> list = diffFiles;
        Iterator<T> it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i2 += ((DiffFile) it.next()).getInsertLineCount();
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            i += ((DiffFile) it2.next()).getDeleteLineCount();
        }
        return StringsKt.trimIndent("\n<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/github.min.css\">\n<script src=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js\"></script>\n<script src=\"https://cdn.jsdelivr.net/npm/diff@5.2.0/dist/diff.min.js\"></script>\n<style>\n* { margin: 0; padding: 0; box-sizing: border-box; }\nbody {\n    background: #f6f8fa;\n    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif;\n    -webkit-text-size-adjust: none;\n}\n.header {\n    background: #fff;\n    border-bottom: 1px solid #d0d7de;\n    padding: 16px;\n    position: sticky;\n    top: 0;\n    z-index: 100;\n}\n.task-name {\n    font-size: 16px;\n    font-weight: 600;\n    color: #1f2328;\n    word-break: break-all;\n    display: -webkit-box;\n    -webkit-line-clamp: 2;\n    -webkit-box-orient: vertical;\n    overflow: hidden;\n    text-overflow: ellipsis;\n}\n.summary {\n    font-size: 13px;\n    color: #656d76;\n    margin-top: 4px;\n}\n.summary .add { color: #1a7f37; font-weight: 600; }\n.summary .del { color: #cf222e; font-weight: 600; }\n.files-container {\n    padding: 12px;\n    display: flex;\n    flex-direction: column;\n    gap: 12px;\n}\n.file-block {\n    border: 1px solid #d0d7de;\n    border-radius: 8px;\n    background: #fff;\n    overflow: hidden;\n}\n.file-block.collapsed .file-content { display: none; }\n.file-block.collapsed .chevron { transform: rotate(-90deg); }\n.file-header {\n    display: flex;\n    align-items: center;\n    gap: 8px;\n    padding: 8px 12px;\n    background: #f6f8fa;\n    border-bottom: 1px solid #d0d7de;\n    cursor: pointer;\n    position: sticky;\n    top: 0;\n    z-index: 10;\n    -webkit-tap-highlight-color: transparent;\n}\n.file-block.collapsed .file-header {\n    border-bottom: none;\n}\n.file-header-left {\n    display: flex;\n    align-items: center;\n    gap: 8px;\n    flex-shrink: 0;\n}\n.expand-btn {\n    display: flex;\n    align-items: center;\n    justify-content: center;\n    width: 24px;\n    height: 24px;\n}\n.chevron {\n    transition: transform 0.15s ease;\n}\n.file-icon {\n    display: flex;\n    align-items: center;\n    justify-content: center;\n    width: 28px;\n    height: 28px;\n    border-radius: 6px;\n}\n.file-info {\n    display: flex;\n    flex: 1;\n    min-width: 0;\n    align-items: center;\n    gap: 6px;\n    overflow: hidden;\n}\n.file-name {\n    font-size: 13px;\n    font-weight: 500;\n    color: #1f2328;\n    flex-shrink: 0;\n}\n.file-path {\n    font-size: 12px;\n    color: #656d76;\n    overflow: hidden;\n    text-overflow: ellipsis;\n    white-space: nowrap;\n    direction: rtl;\n    text-align: left;\n}\n.diff-stats {\n    display: flex;\n    align-items: center;\n    gap: 6px;\n    flex-shrink: 0;\n}\n.additions {\n    font-family: 'SF Mono', 'Menlo', monospace;\n    font-size: 12px;\n    font-weight: 500;\n    color: #1a7f37;\n}\n.deletions {\n    font-family: 'SF Mono', 'Menlo', monospace;\n    font-size: 12px;\n    font-weight: 500;\n    color: #cf222e;\n}\n.conflict-badge {\n    font-size: 11px;\n    font-weight: 500;\n    color: #cf222e;\n    background: rgba(248,81,73,0.12);\n    border-radius: 4px;\n    padding: 2px 6px;\n}\n.file-content {\n    overflow-x: auto;\n    -webkit-overflow-scrolling: touch;\n}\n.diff-wrapper {\n    font-family: 'SF Mono', 'Menlo', 'Monaco', 'Inconsolata', monospace;\n    font-size: 12px;\n    line-height: 20px;\n}\n.diff-table {\n    display: flex;\n    flex-direction: column;\n    width: 100%;\n    min-width: fit-content;\n}\n.diff-line {\n    display: flex;\n    min-height: 20px;\n}\n.line-numbers {\n    flex-shrink: 0;\n    white-space: nowrap;\n    user-select: none;\n    -webkit-user-select: none;\n}\n.old-ln, .new-ln {\n    display: inline-block;\n    width: 36px;\n    padding: 0 4px;\n    text-align: right;\n    color: #8c959f;\n    font-size: 12px;\n    line-height: 20px;\n}\n.line-content {\n    flex: 1;\n    min-width: 0;\n    padding: 0 8px 0 4px;\n    white-space: pre-wrap;\n    overflow-wrap: break-word;\n    color: #1f2328;\n}\n.line-sign {\n    flex-shrink: 0;\n    display: inline-block;\n    width: 16px;\n    text-align: center;\n    font-family: 'SF Mono', 'Menlo', 'Monaco', monospace;\n    font-size: 12px;\n    line-height: 20px;\n    user-select: none;\n    -webkit-user-select: none;\n}\n.sign-add { color: #1a7f37; }\n.sign-del { color: #cf222e; }\n.line-content pre {\n    margin: 0;\n    padding: 0;\n    font-family: inherit;\n    font-size: inherit;\n    line-height: inherit;\n    white-space: pre-wrap;\n    overflow-wrap: break-word;\n    background: transparent;\n}\n.line-unchanged { background: #fff; }\n.line-added { background: rgba(63,185,80,0.15); }\n.line-removed { background: rgba(248,81,73,0.15); }\n.collapsed-block {\n    display: flex;\n    align-items: center;\n    justify-content: center;\n    min-height: 32px;\n    background: transparent;\n    cursor: pointer;\n    -webkit-tap-highlight-color: transparent;\n}\n.collapsed-dashed {\n    flex: 1;\n    height: 0;\n    border-top: 1px dashed #d0d7de;\n}\n.collapsed-btn {\n    display: flex;\n    align-items: center;\n    justify-content: center;\n    width: 24px;\n    height: 24px;\n    margin: 0 8px;\n    background: #f6f8fa;\n    border: 1px solid #d0d7de;\n    border-radius: 4px;\n}\n.collapsed-btn svg { width: 16px; height: 16px; color: #656d76; }\n.collapsed-text {\n    margin-right: 8px;\n    font-size: 12px;\n    color: #8c959f;\n    white-space: nowrap;\n}\n.diff-lines-data { display: none; }\n</style>\n</head>\n<body>\n<div class=\"header\">\n    <div class=\"task-name\">" + escapeHtml(taskName) + "</div>\n    <div class=\"summary\">\n        " + size + " Files Changed\n        <span class=\"add\">+" + i2 + "</span>\n        <span class=\"del\">-" + i + "</span>\n    </div>\n</div>\n<div class=\"files-container\">\n" + buildFileBlocksHtml(diffFiles) + "\n</div>\n<script>\nvar CONTEXT_LINES = 3;\n\nfunction computeDiffLines(oldContent, newContent) {\n    var changes = Diff.diffLines(oldContent, newContent);\n    var result = [];\n    var oldLn = 1, newLn = 1;\n    for (var i = 0; i < changes.length; i++) {\n        var c = changes[i];\n        var lines = c.value.split('\\n');\n        if (lines[lines.length - 1] === '') lines.pop();\n        for (var j = 0; j < lines.length; j++) {\n            if (c.added) {\n                result.push({ type: 'added', content: lines[j], newLn: newLn++ });\n            } else if (c.removed) {\n                result.push({ type: 'removed', content: lines[j], oldLn: oldLn++ });\n            } else {\n                result.push({ type: 'unchanged', content: lines[j], oldLn: oldLn++, newLn: newLn++ });\n            }\n        }\n    }\n    return result;\n}\n\nfunction highlightCode(code, lang) {\n    try {\n        if (lang && lang !== 'plaintext' && hljs.getLanguage(lang)) {\n            return hljs.highlight(code, { language: lang }).value;\n        }\n        return hljs.highlightAuto(code).value;\n    } catch(e) {\n        return code.replace(/</g, '&lt;').replace(/>/g, '&gt;');\n    }\n}\n\nfunction createCollapsedBlocks(lines) {\n    var result = [];\n    var buf = [];\n    function flush() {\n        if (buf.length === 0) return;\n        if (buf.length <= CONTEXT_LINES * 2 + 1) {\n            for (var i = 0; i < buf.length; i++) result.push(buf[i]);\n        } else {\n            for (var i = 0; i < CONTEXT_LINES; i++) result.push(buf[i]);\n            var collapsed = buf.slice(CONTEXT_LINES, buf.length - CONTEXT_LINES);\n            result.push({ type: 'collapsed', count: collapsed.length, lines: collapsed });\n            for (var i = buf.length - CONTEXT_LINES; i < buf.length; i++) result.push(buf[i]);\n        }\n        buf = [];\n    }\n    for (var i = 0; i < lines.length; i++) {\n        if (lines[i].type === 'unchanged') {\n            buf.push(lines[i]);\n        } else {\n            flush();\n            result.push(lines[i]);\n        }\n    }\n    flush();\n    return result;\n}\n\nfunction renderDiffBlock(tableEl, blocks, lang) {\n    var html = '';\n    for (var i = 0; i < blocks.length; i++) {\n        var b = blocks[i];\n        if (b.type === 'collapsed') {\n            html += '<div class=\"collapsed-block\" data-index=\"' + i + '\">';\n            html += '<div class=\"collapsed-dashed\"></div>';\n            html += '<div class=\"collapsed-btn\"><svg viewBox=\"0 0 16 16\" fill=\"none\"><path d=\"M3 6h10M3 10h10\" stroke=\"currentColor\" stroke-width=\"1.5\" stroke-linecap=\"round\"/></svg></div>';\n            html += '<span class=\"collapsed-text\">' + b.count + ' lines hidden</span>';\n            html += '<div class=\"collapsed-dashed\"></div>';\n            html += '</div>';\n        } else {\n            var cls = b.type === 'added' ? 'line-added' : b.type === 'removed' ? 'line-removed' : 'line-unchanged';\n            var oldLn = b.oldLn != null ? b.oldLn : '';\n            var newLn = b.newLn != null ? b.newLn : '';\n            var highlighted = highlightCode(b.content || '', lang);\n            var sign = b.type === 'added' ? '<span class=\"line-sign sign-add\">+</span>' : b.type === 'removed' ? '<span class=\"line-sign sign-del\">-</span>' : '<span class=\"line-sign\">&nbsp;</span>';\n            html += '<div class=\"diff-line ' + cls + '\">';\n            html += '<div class=\"line-numbers\"><span class=\"old-ln\">' + oldLn + '</span><span class=\"new-ln\">' + newLn + '</span></div>';\n            html += sign;\n            html += '<div class=\"line-content\"><pre>' + (highlighted || '&nbsp;') + '</pre></div>';\n            html += '</div>';\n        }\n    }\n    tableEl.innerHTML = html;\n}\n\nfunction processAllDiffs() {\n    var dataDivs = document.querySelectorAll('.diff-lines-data');\n    for (var d = 0; d < dataDivs.length; d++) {\n        var div = dataDivs[d];\n        var tableEl = div.parentElement;\n        var oldContent = div.getAttribute('data-old') || '';\n        var newContent = div.getAttribute('data-new') || '';\n        var lang = div.getAttribute('data-lang') || 'plaintext';\n\n        try {\n            oldContent = oldContent.replace(/\\\\`/g, '`').replace(/\\\\\\$/g, '$').replace(/\\\\\\\\/g, '\\\\');\n            newContent = newContent.replace(/\\\\`/g, '`').replace(/\\\\\\$/g, '$').replace(/\\\\\\\\/g, '\\\\');\n        } catch(e) {}\n\n        var diffLines = computeDiffLines(oldContent, newContent);\n        var blocks = createCollapsedBlocks(diffLines);\n\n        tableEl._allDiffLines = diffLines;\n        tableEl._blocks = blocks;\n        tableEl._lang = lang;\n\n        renderDiffBlock(tableEl, blocks, lang);\n\n        (function(te) {\n            te.addEventListener('click', function(e) {\n                var collapsed = e.target.closest('.collapsed-block');\n                if (!collapsed) return;\n                var idx = parseInt(collapsed.getAttribute('data-index'));\n                var block = te._blocks[idx];\n                if (!block || block.type !== 'collapsed') return;\n                var expanded = [];\n                for (var i = 0; i < te._blocks.length; i++) {\n                    if (i === idx) {\n                        for (var j = 0; j < block.lines.length; j++) {\n                            expanded.push(block.lines[j]);\n                        }\n                    } else {\n                        expanded.push(te._blocks[i]);\n                    }\n                }\n                te._blocks = expanded;\n                renderDiffBlock(te, expanded, te._lang);\n            });\n        })(tableEl);\n    }\n}\n\nfunction toggleFileBlock(headerEl) {\n    var block = headerEl.parentElement;\n    block.classList.toggle('collapsed');\n}\n\nfunction scrollToFile(filePath) {\n    var blocks = document.querySelectorAll('.file-block');\n    for (var i = 0; i < blocks.length; i++) {\n        var fp = blocks[i].getAttribute('data-filepath');\n        if (fp === filePath || fp.endsWith('/' + filePath) || filePath.endsWith('/' + fp)) {\n            if (blocks[i].classList.contains('collapsed')) {\n                blocks[i].classList.remove('collapsed');\n            }\n            blocks[i].scrollIntoView({ behavior: 'smooth', block: 'start' });\n            blocks[i].style.boxShadow = '0 0 0 2px #0969da';\n            setTimeout(function() { blocks[i].style.boxShadow = ''; }, 2000);\n            return true;\n        }\n    }\n    return false;\n}\n\ndocument.addEventListener('DOMContentLoaded', processAllDiffs);\n</script>\n</body>\n</html>\n");
    }
}
