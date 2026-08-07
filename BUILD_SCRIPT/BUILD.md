# Build Notes — Extract Conversation Feature

This document describes the changes made to add the "Extract Conversation" feature
to the TRAE Android app (com.bytedance.trae.cn).

## Overview

Adds a new "Extract Conversation" menu item to the task context menu that:
1. Queries the SQLite database for user messages in the conversation
2. Assembles them into a Markdown document
3. Opens the preview in SimpleWebViewActivity
4. Pushes the file to the GitHub repository asynchronously with retry support

## Modified Files

### Layout
- `conversation_popup_menu.xml` — Added `menu_extract` LinearLayout at the top

### Smali Source Files

#### `com/bytedance/trae/conversation/widget/`

| File | Change |
|------|--------|
| `MenuPopupWindow$OnMenuClickListener.smali` | Added `onExtractClick()` abstract method |
| `MenuPopupWindow$$ExternalSyntheticLambda5.smali` | NEW - Click listener for extract button |
| `MenuPopupWindow.smali` | Added extract click handler in `init()`, added `lambda$init$5` |

#### `com/bytedance/trae/conversation/extract/` (NEW PACKAGE)

| File | Purpose |
|------|---------|
| `ExtractHelper.smali` | Main orchestrator class - extracts messages, builds Markdown, saves file, opens preview |
| `GitHubPusher.smali` | Handles GitHub REST API push with retry logic (10-minute intervals, max 10 retries) |

#### `com/bytedance/trae/conversation/`

| File | Change |
|------|--------|
| `BuildConfig.smali` | Added `GITHUB_TOKEN` field with the hardcoded token |
| `ConversationActivity$initTitleBar$3$1.smali` | Added `onExtractClick()` implementation that calls `ExtractHelper.start()` |

#### Other

| File | Purpose |
|------|---------|
| `conversation_popup_menu_modified.xml` | Documented reference layout |

## Build Instructions

To build the modified APK:

1. Navigate to the smali source directory
2. Use `smali assemble` to compile the smali files into a DEX file
3. Replace the DEX classes in the original APK
4. Repackage and re-sign the APK

```bash
# Example workflow:
smali assemble -o classes.dex source/smali/
cp classes.dex original.apk
apksigner sign --ks keystore.jks modified.apk
```

## Required Setup

### String Resources

Add the following string to `res/values/strings.xml`:

```xml
<string name="trae_conversation_menu_extract">提取对话</string>
```

### Layout IDs (R$id)

Ensure the following IDs exist in the R class:
- `menu_extract` - The extract LinearLayout
- `iv_menu_extract` - The extract icon ImageView
- `tv_menu_extract` - The extract text TextView
- `menu_divider_extract` - Divider view after extract item

### Build Configuration

The following BuildConfig field is added:

```java
public static final String GITHUB_TOKEN = "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";
```

## Feature Flow

1. User long-presses a conversation task
2. Context menu appears with new "Extract Conversation" option at top
3. User taps item, ExtractHelper.start() is called
4. ExtractHelper queries `chat_message` table filtering by `task_id` and `message_type = 'user'`
5. Messages are ordered by `message_index ASC`
6. Markdown is generated with format: `**[User]**: content\n\n`
7. File saved to `cacheDir/extracted/{title}.md`
8. SimpleWebViewActivity opens with the file URI
9. GitHubPusher launches coroutine to push file to `liliangxing/trae-cn3` repo at `docs/`
10. On failure, retry every 10 minutes up to 10 times using SharedPreferences for retry tracking

## Dependencies

- `com.bytedance.trae.im.database.DatabaseManager` - Singleton database access
- `com.bytedance.trae.im.database.ChatMessageDao` - Message queries
- `com.bytedance.trae.im.database.ChatMessageEntity` - Message entity
- `com.bytedance.trae.common.activity.SimpleWebViewActivity` - Markdown preview
- `com.bytedance.trae.conversation.tracker.InputTracker` - Analytics tracking
- `kotlinx.coroutines.*` - Async execution
