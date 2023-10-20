package login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.model.LoginEvent
import theme.Theme

@Composable
fun LoginScreen() {
    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()

        Column(
            modifier = Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Login Now", color = Theme.colors.thirdTextColor,
                fontSize = 24.sp, fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = "Welcome back! Enter your email",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Theme.colors.hintTextColor
            )

            TextField(value = state.value.email, onValueChange = {
                viewModel.obtainEvent(LoginEvent.EmailChanged(value = it))
            })

        }
    }
}