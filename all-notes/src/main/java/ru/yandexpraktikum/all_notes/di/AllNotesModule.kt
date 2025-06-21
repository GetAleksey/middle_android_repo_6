package ru.yandexpraktikum.all_notes.di

import dagger.Binds
import dagger.Module
import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractor
import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractorImpl
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractor
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractorImpl

@Module
interface AllNotesModule {

    @Binds
    @AllNotesScope
    fun bindDeleteNoteInteractor(interactor: DeleteNoteInteractorImpl): DeleteNoteInteractor

    @Binds
    @AllNotesScope
    fun bindFetchAllNotesInteractor(interactor: FetchAllNotesInteractorImpl): FetchAllNotesInteractor
}