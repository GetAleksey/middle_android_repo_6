package ru.yandexpraktikum.notekeeper.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.yandexpraktikum.add_note.di.AddNoteComponent
import ru.yandexpraktikum.add_note.presentation.AddNoteScreen
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModel
import ru.yandexpraktikum.all_notes.di.AllNotesComponent
import ru.yandexpraktikum.all_notes.presentation.AllNotesScreen
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModel
import ru.yandexpraktikum.notekeeper.di.ApplicationComponent

@Composable
fun NoteKeeperNavHost(
    applicationComponent: ApplicationComponent,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AllNotes.route
    ) {
        composable(route = Screen.AllNotes.route) {
            var allNotesComponent by remember { mutableStateOf<AllNotesComponent?>(null) }

            DisposableEffect(Unit) {
                allNotesComponent = applicationComponent.allNotesComponentFactory.create()

                onDispose {
                    allNotesComponent = null
                }
            }

            val vm: AllNotesViewModel = viewModel(
                factory = applicationComponent.allNotesComponentFactory.create().viewModelFactory
            )

            AllNotesScreen(
                viewModel = vm,
                onAddNoteClick = {
                    navController.navigate(Screen.AddNote.route)
                }
            )
        }

        composable(route = Screen.AddNote.route) {
            var addNoteComponent by remember { mutableStateOf<AddNoteComponent?>(null) }

            DisposableEffect(Unit) {
                addNoteComponent = applicationComponent.addNoteComponentFactory.create()

                onDispose {
                    addNoteComponent = null
                }
            }

            val vm: AddNoteViewModel = viewModel(
                factory = applicationComponent.addNoteComponentFactory.create().viewModelFactory
            )

            AddNoteScreen(
                viewModel = vm,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}