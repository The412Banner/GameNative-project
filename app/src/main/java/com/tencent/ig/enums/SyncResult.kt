package com.tencent.ig.enums

enum class SyncResult {
    Success,
    UpToDate,
    InProgress,
    PendingOperations,
    Conflict,
    UpdateFail,
    DownloadFail,
    UnknownFail,
}
