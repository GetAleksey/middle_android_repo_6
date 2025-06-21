package ru.yandexpraktikum.notekeeper

import android.app.Application
import ru.yandexpraktikum.notekeeper.di.ApplicationComponent
import ru.yandexpraktikum.notekeeper.di.DaggerApplicationComponent

class NoteKeeperApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.factory().create(this)
    }
}