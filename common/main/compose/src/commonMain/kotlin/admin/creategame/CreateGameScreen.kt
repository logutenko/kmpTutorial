package admin.creategame

import admin.creategame.model.CreateGameAction
import admin.creategame.model.CreateGameEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import widget.ActionButton
import widget.CommonTextField

@Composable
fun CreateGameScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { CreateGameViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState().value
        val viewAction = viewModel.viewActions().observeAsState()

        Column(modifier = Modifier.padding(16.dp)) {
            CommonTextField(
                text = viewState.title,
                hint = "Game Title",
                isEnabled = !viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.TitleChanged(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(
                text = viewState.description,
                hint = "Game Description",
                isEnabled = !viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.DescriptionChanged(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(
                text = viewState.version,
                hint = "Game Version",
                isEnabled = !viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.VersionChanged(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(
                text = viewState.size,
                hint = "Game Size",
                isEnabled = !viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.SizeChanged(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            ActionButton(
                title = "Save Changes",
                isEnabled = !viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.SubmitClicked)
            }
        }


        when (viewAction.value) {
            is CreateGameAction.CloseScreen -> rootController.popBackStack()
            null -> {}
        }
    }
}