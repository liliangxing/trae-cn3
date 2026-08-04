# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/DiffViewerHelper;
.super Ljava/lang/Object;
.source "DiffViewerHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/DiffViewerHelper;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->INSTANCE Lcom/bytedance/trae/conversation/products/DiffViewerHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildDiffHtml(java.util.List  java.lang.String)java.lang.String
    .registers 9
    # ins_size=3
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v0
    move-object v1, v7
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    const/4 v3, 0
    move v4, v3
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +00eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/products/DiffFile;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->getInsertLineCount()I
    move-result v5
    add-int/2addr v4, v5
    goto -11h
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/products/DiffFile;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/DiffFile;->getDeleteLineCount()I
    move-result v2
    add-int/2addr v3, v2
    goto -11h
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->buildFileBlocksHtml(Ljava/util/List;)Ljava/lang/String;
    move-result-object v7
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/github.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/diff@5.2.0/dist/diff.min.js"></script>
<style>
* { margin: 0; padding: 0; box-sizing: border-box; }
body {
    background: #f6f8fa;
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif;
    -webkit-text-size-adjust: none;
}
.header {
    background: #fff;
    border-bottom: 1px solid #d0d7de;
    padding: 16px;
    position: sticky;
    top: 0;
    z-index: 100;
}
.task-name {
    font-size: 16px;
    font-weight: 600;
    color: #1f2328;
    word-break: break-all;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    overflow: hidden;
    text-overflow: ellipsis;
}
.summary {
    font-size: 13px;
    color: #656d76;
    margin-top: 4px;
}
.summary .add { color: #1a7f37; font-weight: 600; }
.summary .del { color: #cf222e; font-weight: 600; }
.files-container {
    padding: 12px;
    display: flex;
    flex-direction: column;
    gap: 12px;
}
.file-block {
    border: 1px solid #d0d7de;
    border-radius: 8px;
    background: #fff;
    overflow: hidden;
}
.file-block.collapsed .file-content { display: none; }
.file-block.collapsed .chevron { transform: rotate(-90deg); }
.file-header {
    display: flex;
    align-items: center;
    gap: 8px;
    padding: 8px 12px;
    background: #f6f8fa;
    border-bottom: 1px solid #d0d7de;
    cursor: pointer;
    position: sticky;
    top: 0;
    z-index: 10;
    -webkit-tap-highlight-color: transparent;
}
.file-block.collapsed .file-header {
    border-bottom: none;
}
.file-header-left {
    display: flex;
    align-items: center;
    gap: 8px;
    flex-shrink: 0;
}
.expand-btn {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 24px;
    height: 24px;
}
.chevron {
    transition: transform 0.15s ease;
}
.file-icon {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 28px;
    height: 28px;
    border-radius: 6px;
}
.file-info {
    display: flex;
    flex: 1;
    min-width: 0;
    align-items: center;
    gap: 6px;
    overflow: hidden;
}
.file-name {
    font-size: 13px;
    font-weight: 500;
    color: #1f2328;
    flex-shrink: 0;
}
.file-path {
    font-size: 12px;
    color: #656d76;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    direction: rtl;
    text-align: left;
}
.diff-stats {
    display: flex;
    align-items: center;
    gap: 6px;
    flex-shrink: 0;
}
.additions {
    font-family: 'SF Mono', 'Menlo', monospace;
    font-size: 12px;
    font-weight: 500;
    color: #1a7f37;
}
.deletions {
    font-family: 'SF Mono', 'Menlo', monospace;
    font-size: 12px;
    font-weight: 500;
    color: #cf222e;
}
.conflict-badge {
    font-size: 11px;
    font-weight: 500;
    color: #cf222e;
    background: rgba(248,81,73,0.12);
    border-radius: 4px;
    padding: 2px 6px;
}
.file-content {
    overflow-x: auto;
    -webkit-overflow-scrolling: touch;
}
.diff-wrapper {
    font-family: 'SF Mono', 'Menlo', 'Monaco', 'Inconsolata', monospace;
    font-size: 12px;
    line-height: 20px;
}
.diff-table {
    display: flex;
    flex-direction: column;
    width: 100%;
    min-width: fit-content;
}
.diff-line {
    display: flex;
    min-height: 20px;
}
.line-numbers {
    flex-shrink: 0;
    white-space: nowrap;
    user-select: none;
    -webkit-user-select: none;
}
.old-ln, .new-ln {
    display: inline-block;
    width: 36px;
    padding: 0 4px;
    text-align: right;
    color: #8c959f;
    font-size: 12px;
    line-height: 20px;
}
.line-content {
    flex: 1;
    min-width: 0;
    padding: 0 8px 0 4px;
    white-space: pre-wrap;
    overflow-wrap: break-word;
    color: #1f2328;
}
.line-sign {
    flex-shrink: 0;
    display: inline-block;
    width: 16px;
    text-align: center;
    font-family: 'SF Mono', 'Menlo', 'Monaco', monospace;
    font-size: 12px;
    line-height: 20px;
    user-select: none;
    -webkit-user-select: none;
}
.sign-add { color: #1a7f37; }
.sign-del { color: #cf222e; }
.line-content pre {
    margin: 0;
    padding: 0;
    font-family: inherit;
    font-size: inherit;
    line-height: inherit;
    white-space: pre-wrap;
    overflow-wrap: break-word;
    background: transparent;
}
.line-unchanged { background: #fff; }
.line-added { background: rgba(63,185,80,0.15); }
.line-removed { background: rgba(248,81,73,0.15); }
.collapsed-block {
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 32px;
    background: transparent;
    cursor: pointer;
    -webkit-tap-highlight-color: transparent;
}
.collapsed-dashed {
    flex: 1;
    height: 0;
    border-top: 1px dashed #d0d7de;
}
.collapsed-btn {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 24px;
    height: 24px;
    margin: 0 8px;
    background: #f6f8fa;
    border: 1px solid #d0d7de;
    border-radius: 4px;
}
.collapsed-btn svg { width: 16px; height: 16px; color: #656d76; }
.collapsed-text {
    margin-right: 8px;
    font-size: 12px;
    color: #8c959f;
    white-space: nowrap;
}
.diff-lines-data { display: none; }
</style>
</head>
<body>
<div class="header">
    <div class="task-name">"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v6, v8, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeHtml(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v1, "</div>
    <div class="summary">
        "
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v0, " Files Changed
        <span class="add">+"
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v0, "</span>
        <span class="del">-"
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v0, "</span>
    </div>
</div>
<div class="files-container">
"
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "
</div>
<script>
var CONTEXT_LINES = 3;

function computeDiffLines(oldContent, newContent) {
    var changes = Diff.diffLines(oldContent, newContent);
    var result = [];
    var oldLn = 1, newLn = 1;
    for (var i = 0; i < changes.length; i++) {
        var c = changes[i];
        var lines = c.value.split('\n');
        if (lines[lines.length - 1] === '') lines.pop();
        for (var j = 0; j < lines.length; j++) {
            if (c.added) {
                result.push({ type: 'added', content: lines[j], newLn: newLn++ });
            } else if (c.removed) {
                result.push({ type: 'removed', content: lines[j], oldLn: oldLn++ });
            } else {
                result.push({ type: 'unchanged', content: lines[j], oldLn: oldLn++, newLn: newLn++ });
            }
        }
    }
    return result;
}

function highlightCode(code, lang) {
    try {
        if (lang && lang !== 'plaintext' && hljs.getLanguage(lang)) {
            return hljs.highlight(code, { language: lang }).value;
        }
        return hljs.highlightAuto(code).value;
    } catch(e) {
        return code.replace(/</g, '&lt;').replace(/>/g, '&gt;');
    }
}

function createCollapsedBlocks(lines) {
    var result = [];
    var buf = [];
    function flush() {
        if (buf.length === 0) return;
        if (buf.length <= CONTEXT_LINES * 2 + 1) {
            for (var i = 0; i < buf.length; i++) result.push(buf[i]);
        } else {
            for (var i = 0; i < CONTEXT_LINES; i++) result.push(buf[i]);
            var collapsed = buf.slice(CONTEXT_LINES, buf.length - CONTEXT_LINES);
            result.push({ type: 'collapsed', count: collapsed.length, lines: collapsed });
            for (var i = buf.length - CONTEXT_LINES; i < buf.length; i++) result.push(buf[i]);
        }
        buf = [];
    }
    for (var i = 0; i < lines.length; i++) {
        if (lines[i].type === 'unchanged') {
            buf.push(lines[i]);
        } else {
            flush();
            result.push(lines[i]);
        }
    }
    flush();
    return result;
}

function renderDiffBlock(tableEl, blocks, lang) {
    var html = '';
    for (var i = 0; i < blocks.length; i++) {
        var b = blocks[i];
        if (b.type === 'collapsed') {
            html += '<div class="collapsed-block" data-index="' + i + '">';
            html += '<div class="collapsed-dashed"></div>';
            html += '<div class="collapsed-btn"><svg viewBox="0 0 16 16" fill="none"><path d="M3 6h10M3 10h10" stroke="currentColor" stroke-width="1.5" stroke-linecap="round"/></svg></div>';
            html += '<span class="collapsed-text">' + b.count + ' lines hidden</span>';
            html += '<div class="collapsed-dashed"></div>';
            html += '</div>';
        } else {
            var cls = b.type === 'added' ? 'line-added' : b.type === 'removed' ? 'line-removed' : 'line-unchanged';
            var oldLn = b.oldLn != null ? b.oldLn : '';
            var newLn = b.newLn != null ? b.newLn : '';
            var highlighted = highlightCode(b.content || '', lang);
            var sign = b.type === 'added' ? '<span class="line-sign sign-add">+</span>' : b.type === 'removed' ? '<span class="line-sign sign-del">-</span>' : '<span class="line-sign">&nbsp;</span>';
            html += '<div class="diff-line ' + cls + '">';
            html += '<div class="line-numbers"><span class="old-ln">' + oldLn + '</span><span class="new-ln">' + newLn + '</span></div>';
            html += sign;
            html += '<div class="line-content"><pre>' + (highlighted || '&nbsp;') + '</pre></div>';
            html += '</div>';
        }
    }
    tableEl.innerHTML = html;
}

function processAllDiffs() {
    var dataDivs = document.querySelectorAll('.diff-lines-data');
    for (var d = 0; d < dataDivs.length; d++) {
        var div = dataDivs[d];
        var tableEl = div.parentElement;
        var oldContent = div.getAttribute('data-old') || '';
        var newContent = div.getAttribute('data-new') || '';
        var lang = div.getAttribute('data-lang') || 'plaintext';

        try {
            oldContent = oldContent.replace(/\\`/g, '`').replace(/\\\$/g, '$').replace(/\\\\/g, '\\');
            newContent = newContent.replace(/\\`/g, '`').replace(/\\\$/g, '$').replace(/\\\\/g, '\\');
        } catch(e) {}

        var diffLines = computeDiffLines(oldContent, newContent);
        var blocks = createCollapsedBlocks(diffLines);

        tableEl._allDiffLines = diffLines;
        tableEl._blocks = blocks;
        tableEl._lang = lang;

        renderDiffBlock(tableEl, blocks, lang);

        (function(te) {
            te.addEventListener('click', function(e) {
                var collapsed = e.target.closest('.collapsed-block');
                if (!collapsed) return;
                var idx = parseInt(collapsed.getAttribute('data-index'));
                var block = te._blocks[idx];
                if (!block || block.type !== 'collapsed') return;
                var expanded = [];
                for (var i = 0; i < te._blocks.length; i++) {
                    if (i === idx) {
                        for (var j = 0; j < block.lines.length; j++) {
                            expanded.push(block.lines[j]);
                        }
                    } else {
                        expanded.push(te._blocks[i]);
                    }
                }
                te._blocks = expanded;
                renderDiffBlock(te, expanded, te._lang);
            });
        })(tableEl);
    }
}

function toggleFileBlock(headerEl) {
    var block = headerEl.parentElement;
    block.classList.toggle('collapsed');
}

function scrollToFile(filePath) {
    var blocks = document.querySelectorAll('.file-block');
    for (var i = 0; i < blocks.length; i++) {
        var fp = blocks[i].getAttribute('data-filepath');
        if (fp === filePath || fp.endsWith('/' + filePath) || filePath.endsWith('/' + fp)) {
            if (blocks[i].classList.contains('collapsed')) {
                blocks[i].classList.remove('collapsed');
            }
            blocks[i].scrollIntoView({ behavior: 'smooth', block: 'start' });
            blocks[i].style.boxShadow = '0 0 0 2px #0969da';
            setTimeout(function() { blocks[i].style.boxShadow = ''; }, 2000);
            return true;
        }
    }
    return false;
}

document.addEventListener('DOMContentLoaded', processAllDiffs);
</script>
</body>
</html>
"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lkotlin/text/StringsKt;->trimIndent(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    return-object v7
.end method

.method private final buildFileBlocksHtml(java.util.List)java.lang.String
    .registers 12
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-interface v11, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +1a5h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/DiffFile;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getNewPath()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 2
    const-string v4, "/"
    const/4 v5, 0
    invoke-static v2, v4, v5, v3, v5, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v5, ""
    invoke-static v2, v4, v5, Lkotlin/text/StringsKt;->substringBeforeLast(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->getFileAction(Lcom/bytedance/trae/conversation/products/DiffFile;)Ljava/lang/String;
    move-result-object v5
    invoke-direct v10, v5, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->getFileActionIcon(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-direct v10, v5, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->getFileActionBgColor(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "<div class="file-block" data-filepath=""
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v10, v2, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeHtml(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "">"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v7, "<div class="file-header" onclick="toggleFileBlock(this)"><div class="file-header-left"><span class="expand-btn"><svg class="chevron" width="16" height="16" viewBox="0 0 16 16" fill="none"><path d="M4 6l4 4 4-4" stroke="#656d76" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/></svg></span>"
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v9, "<span class="file-icon" style="background:"
    invoke-direct v7, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "</span>"
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v5, "</div><div class="file-info">"
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v7, "<span class="file-name">"
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v10, v3, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeHtml(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-object v3, v4
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v5, 1
    const/4 v7, 0
    if-lez v3, +004h
    move v3, v5
    goto +2h
    move v3, v7
    if-eqz v3, +01ch
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v9, "<span class="file-path">"
    invoke-direct v3, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v10, v4, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeHtml(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v3, "</div><div class="diff-stats">"
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict()Z
    move-result v3
    if-eqz v3, +008h
    const-string v3, "<span class="conflict-badge">Conflict</span>"
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto +35h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "<span class="additions">+"
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getInsertLineCount()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "<span class="deletions">-"
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getDeleteLineCount()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v3, "</div></div><div class="file-content"><div class="diff-wrapper"><div class="diff-table">"
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getOldContent()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +004h
    move v3, v5
    goto +2h
    move v3, v7
    if-eqz v3, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    goto +ah
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getOldContent()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->lines(Ljava/lang/CharSequence;)Ljava/util/List;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getNewContent()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +2h
    move v5, v7
    if-eqz v5, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    goto +ah
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getNewContent()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->lines(Ljava/lang/CharSequence;)Ljava/util/List;
    const-string v3, "<div class="diff-lines-data" "
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "data-old=""
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getOldContent()Ljava/lang/String;
    move-result-object v4
    invoke-direct v10, v4, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeJs(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v10, v4, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeHtml(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "" "
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "data-new=""
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getNewContent()Ljava/lang/String;
    move-result-object v1
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeJs(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeHtml(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "data-lang=""
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v10, v2, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->getLanguageFromPath(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v10, v2, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->escapeHtml(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v1, "</div></div></div></div></div>"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto/16 -1a7h
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v0, toString(...)
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v11
.end method

.method private final escapeHtml(java.lang.String)java.lang.String
    .registers 14
    # ins_size=2
    const-string v1, "&"
    const-string v2, "&amp;"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "<"
    const-string v8, "&lt;"
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v1, ">"
    const-string v2, "&gt;"
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, """
    const-string v8, "&quot;"
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "'"
    const-string v2, "&#39;"
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method private final escapeJs(java.lang.String)java.lang.String
    .registers 14
    # ins_size=2
    const-string v1, "\"
    const-string v2, "\\"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "`"
    const-string v8, "\`"
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "$"
    const-string v2, "\$"
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "</script>"
    const-string v8, "<\/script>"
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method private final getFileAction(com.bytedance.trae.conversation.products.DiffFile)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/DiffFile;->isNewFile()Z
    move-result v0
    if-eqz v0, +005h
    const-string v4, "added"
    goto +29h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/DiffFile;->getNewContent()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +015h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/DiffFile;->getOldContent()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +005h
    const-string v4, "deleted"
    goto +3h
    const-string v4, "modified"
    return-object v4
.end method

.method private final getFileActionBgColor(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "added"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v2, rgba(63,185,80,0.10)
    goto +10h
    const-string v0, "deleted"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    const-string/jumbo v2, rgba(248,81,73,0.10)
    goto +4h
    const-string/jumbo v2, rgba(154,103,0,0.10)
    return-object v2
.end method

.method private final getFileActionIcon(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "added"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const-string v2, "<svg width="16" height="16" viewBox="0 0 16 16" fill="none"><rect x="2" y="2" width="12" height="12" rx="2" fill="#1a7f37" fill-opacity="0.15"/><path d="M8 5v6M5 8h6" stroke="#1a7f37" stroke-width="1.5" stroke-linecap="round"/></svg>"
    goto +eh
    const-string v0, "deleted"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    const-string v2, "<svg width="16" height="16" viewBox="0 0 16 16" fill="none"><rect x="2" y="2" width="12" height="12" rx="2" fill="#cf222e" fill-opacity="0.15"/><path d="M5 8h6" stroke="#cf222e" stroke-width="1.5" stroke-linecap="round"/></svg>"
    goto +3h
    const-string v2, "<svg width="16" height="16" viewBox="0 0 16 16" fill="none"><rect x="2" y="2" width="12" height="12" rx="2" fill="#9a6700" fill-opacity="0.15"/><path d="M6 6.5h4M8 4.5v4" stroke="#1a7f37" stroke-width="1.5" stroke-linecap="round"/><path d="M6 11h4" stroke="#cf222e" stroke-width="1.5" stroke-linecap="round"/></svg>"
    return-object v2
.end method

.method private final getLanguageFromPath(java.lang.String)java.lang.String
    .registers 12
    # ins_size=2
    const-string v0, "."
    const-string v1, ""
    invoke-static v11, v0, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v11, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Ljava/lang/String;->hashCode()I
    move-result v0
    const-string v1, "javascript"
    const-string v2, "markdown"
    const-string/jumbo v3, yaml
    const-string/jumbo v4, scss
    const-string v5, "html"
    const-string v6, "bash"
    const-string v7, "cpp"
    const-string v8, "c"
    const-string/jumbo v9, xml
    sparse-switch v0, +00001c7h
    goto/16 +1c1h
    invoke-virtual v11, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +158h
    goto/16 +1b9h
    const-string/jumbo v1, swift
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +1b2h
    goto/16 +1aeh
    const-string/jumbo v1, scala
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +1a7h
    goto/16 +1a3h
    invoke-virtual v11, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +05eh
    goto/16 +19bh
    invoke-virtual v11, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +00fh
    goto/16 +193h
    const-string/jumbo v0, sass
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +188h
    move-object v1, v4
    goto/16 +187h
    const-string v1, "less"
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +17fh
    goto/16 +17bh
    const-string v1, "json"
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +175h
    goto/16 +171h
    const-string v1, "java"
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +16bh
    goto/16 +167h
    invoke-virtual v11, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +076h
    goto/16 +15fh
    invoke-virtual v11, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +0b2h
    goto/16 +157h
    const-string/jumbo v0, zsh
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +0a7h
    goto/16 +14ch
    const-string/jumbo v0, yml
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +141h
    move-object v1, v3
    goto/16 +140h
    invoke-virtual v11, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +136h
    goto/16 +136h
    const-string/jumbo v0, vue
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +12fh
    goto/16 +12bh
    const-string/jumbo v0, tsx
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +06bh
    goto/16 +120h
    const-string/jumbo v1, sql
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +119h
    goto/16 +115h
    const-string v1, "php"
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +10fh
    goto/16 +10bh
    const-string v0, "kts"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +0adh
    goto/16 +101h
    const-string v0, "jsx"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +0fbh
    goto/16 +0f7h
    const-string v0, "htm"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +0edh
    move-object v1, v5
    goto/16 +0ech
    const-string v0, "hpp"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +0b6h
    goto/16 +0e0h
    const-string v0, "cxx"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +0ach
    goto/16 +0d6h
    const-string v1, "css"
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +0d0h
    goto/16 +0cch
    invoke-virtual v11, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +09ah
    goto/16 +0c4h
    const-string/jumbo v0, ts
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +0b9h
    const-string/jumbo v1, typescript
    goto/16 +0b6h
    const-string/jumbo v0, sh
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +0a9h
    move-object v1, v6
    goto/16 +0a8h
    const-string/jumbo v0, rs
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +09bh
    const-string/jumbo v1, rust
    goto/16 +098h
    const-string v0, "rb"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +08ch
    const-string/jumbo v1, ruby
    goto/16 +089h
    const-string v0, "py"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +07dh
    const-string v1, "python"
    goto/16 +07bh
    const-string v0, "mm"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +050h
    goto/16 +06fh
    const-string v0, "md"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +065h
    move-object v1, v2
    goto/16 +064h
    const-string v0, "kt"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 +058h
    const-string v1, "kotlin"
    goto +56h
    const-string v0, "js"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +04fh
    goto +4bh
    const-string v1, "go"
    invoke-virtual v11, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +046h
    goto +42h
    const-string v0, "cs"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto +39h
    const-string v1, "csharp"
    goto +38h
    const-string v0, "cc"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto +2dh
    move-object v1, v7
    goto +2dh
    const-string v0, "m"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto +22h
    const-string v1, "objectivec"
    goto +21h
    const-string v0, "h"
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +00ah
    goto +16h
    invoke-virtual v11, v8, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto +fh
    move-object v1, v8
    goto +fh
    const-string/jumbo v0, svelte
    invoke-virtual v11, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto +3h
    move-object v1, v9
    goto +3h
    const-string v1, "plaintext"
    return-object v1
    sparse-switch-payload -35144dc5 63 68 6d c60 c70 ce8 d49 d69 d97 da0 e09 e30 e41 e55 e7f 181a3 18203 182a3 19468 194e1 19c4f 1a02a 1b178 1bdce 1c1d9 1c986 1d017 1d3d8 1d84f 2e06d4 3107ab 31aa22 31ece8 32a199 35c12e 35c8b0 387aa7 6830946 68c3e13 eb7fcef
.end method

.method public final showDiff(android.webkit.WebView  java.util.List  java.lang.String)void
    .registers 23
    # ins_size=4
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    const-string/jumbo v2, webView
    move-object/from16 v3, v20
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "diffFiles"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, taskName
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v2
    const/4 v4, 1
    invoke-virtual v2, v4, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v2, v4, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    const-string v5, "UTF-8"
    invoke-virtual v2, v5, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v0, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v2, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +077h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getBeforeContent()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    if-nez v6, +00ah
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getAfterContent()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +004h
    move v6, v4
    goto +2h
    move v6, v7
    new-instance v15, Lcom/bytedance/trae/conversation/products/DiffFile;
    const-string v8, ""
    if-eqz v6, +004h
    const/4 v6, 0
    goto +9h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    move-object v9, v8
    goto +2h
    move-object v9, v6
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    move-object v10, v8
    goto +2h
    move-object v10, v6
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getInsertLineCount()Ljava/lang/Integer;
    move-result-object v6
    if-eqz v6, +008h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v6
    move v11, v6
    goto +2h
    move v11, v7
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getDeleteLineCount()Ljava/lang/Integer;
    move-result-object v6
    if-eqz v6, +006h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v7
    move v12, v7
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getBeforeContent()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    move-object v13, v8
    goto +2h
    move-object v13, v6
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getAfterContent()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    move-object v14, v8
    goto +2h
    move-object v14, v6
    const/4 v6, 0
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->isConflict()Ljava/lang/Boolean;
    move-result-object v5
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v7
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v16
    const/16 v17, 64
    const/16 v18, 0
    move-object v8, v15
    move-object v5, v15
    move v15, v6
    invoke-direct/range v8 ... v18, Lcom/bytedance/trae/conversation/products/DiffFile;-><init>(Ljava/lang/String; Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -7ah
    check-cast v2, Ljava/util/List;
    move-object/from16 v0, v19
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->buildDiffHtml(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const-string v4, "https://localhost"
    const-string/jumbo v6, text/html
    const-string v7, "UTF-8"
    const/4 v8, 0
    move-object/from16 v3, v20
    invoke-virtual/range v3 ... v8, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
