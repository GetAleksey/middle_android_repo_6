package ru.yandexpraktikum.notekeeper.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.yandexpraktikum.add_note.di.AddNoteComponent
import ru.yandexpraktikum.all_notes.di.AllNotesComponent
import ru.yandexpraktikum.core.di.CoreModule
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface ApplicationComponent {

    val addNoteComponentFactory: AddNoteComponent.Factory
    val allNotesComponentFactory: AllNotesComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}