package com.mihoyo.genshinimpact.di

import android.content.Context
import androidx.room.Room
import com.mihoyo.genshinimpact.db.DATABASE_NAME
import com.mihoyo.genshinimpact.db.PluviaDatabase
import com.mihoyo.genshinimpact.db.dao.AppInfoDao
import com.mihoyo.genshinimpact.db.dao.AmazonGameDao
import com.mihoyo.genshinimpact.db.dao.CachedLicenseDao
import com.mihoyo.genshinimpact.db.dao.DownloadingAppInfoDao
import com.mihoyo.genshinimpact.db.dao.EncryptedAppTicketDao
import com.mihoyo.genshinimpact.db.migration.ROOM_MIGRATION_V7_to_V8
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PluviaDatabase {
        // The db will be considered unstable during development.
        // Once stable we should add a (room) db migration
        return Room.databaseBuilder(context, PluviaDatabase::class.java, DATABASE_NAME)
            .addMigrations(ROOM_MIGRATION_V7_to_V8)
            .fallbackToDestructiveMigration(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideSteamLicenseDao(db: PluviaDatabase) = db.steamLicenseDao()

    @Provides
    @Singleton
    fun provideSteamAppDao(db: PluviaDatabase) = db.steamAppDao()

    @Provides
    @Singleton
    fun provideAppChangeNumbersDao(db: PluviaDatabase) = db.appChangeNumbersDao()

    @Provides
    @Singleton
    fun provideAppFileChangeListsDao(db: PluviaDatabase) = db.appFileChangeListsDao()

    @Provides
    @Singleton
    fun provideAppInfoDao(db: PluviaDatabase): AppInfoDao = db.appInfoDao()

    @Provides
    @Singleton
    fun provideCachedLicenseDao(db: PluviaDatabase): CachedLicenseDao = db.cachedLicenseDao()

    @Provides
    @Singleton
    fun provideEncryptedAppTicketDao(db: PluviaDatabase): EncryptedAppTicketDao = db.encryptedAppTicketDao()

    @Provides
    @Singleton
    fun provideGOGGameDao(db: PluviaDatabase) = db.gogGameDao()

    @Provides
    @Singleton
    fun provideEpicGameDao(db: PluviaDatabase) = db.epicGameDao()

    @Provides
    @Singleton
    fun provideAmazonGameDao(db: PluviaDatabase) = db.amazonGameDao()

    @Provides
    @Singleton
    fun provideDownloadingAppInfoDao(db: PluviaDatabase): DownloadingAppInfoDao = db.downloadingAppInfoDao()
}
