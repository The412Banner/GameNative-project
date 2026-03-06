package com.mihoyo.genshinimpact.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mihoyo.genshinimpact.data.ChangeNumbers
import com.mihoyo.genshinimpact.data.AppInfo
import com.mihoyo.genshinimpact.data.FileChangeLists
import com.mihoyo.genshinimpact.data.SteamApp
import com.mihoyo.genshinimpact.data.SteamLicense
import com.mihoyo.genshinimpact.data.CachedLicense
import com.mihoyo.genshinimpact.data.DownloadingAppInfo
import com.mihoyo.genshinimpact.data.EncryptedAppTicket
import com.mihoyo.genshinimpact.data.GOGGame
import com.mihoyo.genshinimpact.data.EpicGame
import com.mihoyo.genshinimpact.data.AmazonGame
import com.mihoyo.genshinimpact.db.converters.AppConverter
import com.mihoyo.genshinimpact.db.converters.ByteArrayConverter
import com.mihoyo.genshinimpact.db.converters.FriendConverter
import com.mihoyo.genshinimpact.db.converters.LicenseConverter
import com.mihoyo.genshinimpact.db.converters.PathTypeConverter
import com.mihoyo.genshinimpact.db.converters.UserFileInfoListConverter
import com.mihoyo.genshinimpact.db.converters.GOGConverter
import com.mihoyo.genshinimpact.db.dao.ChangeNumbersDao
import com.mihoyo.genshinimpact.db.dao.FileChangeListsDao
import com.mihoyo.genshinimpact.db.dao.SteamAppDao
import com.mihoyo.genshinimpact.db.dao.SteamLicenseDao
import com.mihoyo.genshinimpact.db.dao.AppInfoDao
import com.mihoyo.genshinimpact.db.dao.CachedLicenseDao
import com.mihoyo.genshinimpact.db.dao.DownloadingAppInfoDao
import com.mihoyo.genshinimpact.db.dao.EncryptedAppTicketDao
import com.mihoyo.genshinimpact.db.dao.GOGGameDao
import com.mihoyo.genshinimpact.db.dao.EpicGameDao
import com.mihoyo.genshinimpact.db.dao.AmazonGameDao

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
