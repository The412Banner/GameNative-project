package com.antutu.ABenchMark.data

data class UserFilesUploadResult(
    val uploadBatchSuccess: Boolean,
    val appChangeNumber: Long,
    val filesUploaded: Int,
    val bytesUploaded: Long,
)
