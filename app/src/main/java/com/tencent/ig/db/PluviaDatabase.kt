package com.tencent.ig.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tencent.ig.data.ChangeNumbers
import com.tencent.ig.data.AppInfo
import com.tencent.ig.data.FileChangeLists
import com.tencent.ig.data.SteamApp
import com.tencent.ig.data.SteamLicense
import com.tencent.ig.data.CachedLicense
import com.tencent.ig.data.DownloadingAppInfo
import com.tencent.ig.data.EncryptedAppTicket
import com.tencent.ig.data.GOGGame
import com.tencent.ig.data.EpicGame
import com.tencent.ig.data.AmazonGame
import com.tencent.ig.db.converters.AppConverter
import com.tencent.ig.db.converters.ByteArrayConverter
import com.tencent.ig.db.converters.FriendConverter
import com.tencent.ig.db.converters.LicenseConverter
import com.tencent.ig.db.converters.PathTypeConverter
import com.tencent.ig.db.converters.UserFileInfoListConverter
import com.tencent.ig.db.converters.GOGConverter
import com.tencent.ig.db.dao.ChangeNumbersDao
import com.tencent.ig.db.dao.FileChangeListsDao
import com.tencent.ig.db.dao.SteamAppDao
import com.tencent.ig.db.dao.SteamLicenseDao
import com.tencent.ig.db.dao.AppInfoDao
import com.tencent.ig.db.dao.CachedLicenseDao
import com.tencent.ig.db.dao.DownloadingAppInfoDao
import com.tencent.ig.db.dao.EncryptedAppTicketDao
import com.tencent.ig.db.dao.GOGGameDao
import com.tencent.ig.db.dao.EpicGameDao
import com.tencent.ig.db.dao.AmazonGameDao

const val DATABASE_NAME = "pluvia.db"

@Database(
    entities = [
        AppInfo::class,
        CachedLicense::class,
        ChangeNumbers::class,
        EncryptedAppTicket::class,
        FileChangeLists::class,
        SteamApp::class,
        SteamLicense::class,
        GOGGame::class,
        EpicGame::class,
        AmazonGame::class,
        DownloadingAppInfo::class
    ],
    version = 13,
    // For db migration, visit https://developer.android.com/training/data-storage/room/migrating-db-versions for more information
    exportSchema = true, // It is better to handle db changes carefully, as GN is getting much more users.
    autoMigrations = [
        // For every version change, if it is automatic, please add a new migration here.
        AutoMigration(from = 8, to = 9),
        AutoMigration(from = 9, to = 10),
        AutoMigration(from = 10, to = 11),
        AutoMigration(from = 11, to = 12),
        AutoMigration(from = 12, to = 13), // Added amazon_games table
    ]
)
@TypeConverters(
    AppConverter::class,
    ByteArrayConverter::class,
    FriendConverter::class,
    LicenseConverter::class,
    PathTypeConverter::class,
    UserFileInfoListConverter::class,
    GOGConverter::class,
)
abstract class PluviaDatabase : RoomDatabase() {

    abstract fun steamLicenseDao(): SteamLicenseDao

    abstract fun steamAppDao(): SteamAppDao

    abstract fun appChangeNumbersDao(): ChangeNumbersDao

    abstract fun appFileChangeListsDao(): FileChangeListsDao

    abstract fun appInfoDao(): AppInfoDao

    abstract fun cachedLicenseDao(): CachedLicenseDao

    abstract fun encryptedAppTicketDao(): EncryptedAppTicketDao

    abstract fun gogGameDao(): GOGGameDao

    abstract fun epicGameDao(): EpicGameDao

    abstract fun amazonGameDao(): AmazonGameDao

    abstract fun downloadingAppInfoDao(): DownloadingAppInfoDao
}
