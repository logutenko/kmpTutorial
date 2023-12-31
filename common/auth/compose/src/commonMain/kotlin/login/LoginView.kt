package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.model.LoginEvent
import login.model.LoginViewState
import theme.Theme
import widget.CommonTextField

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Column(
        modifier = Modifier.padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Login Now",
            color = Theme.colors.thirdTextColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welcome back! Enter your email",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Theme.colors.hintTextColor
        )

        Spacer(modifier = Modifier.height(50.dp))

        CommonTextField(text = state.email, hint = "Your login", isEnabled = !state.isSending) {
            eventHandler.invoke(LoginEvent.EmailChanged(value = it))
        }

        Spacer(modifier = Modifier.height(24.dp))

        CommonTextField(
            text = state.password,
            hint = "Your password",
            isEnabled = !state.isSending,
            isSecure = state.passwordHidden,
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        eventHandler.invoke(LoginEvent.PasswordShowClick)
                    }, imageVector = if (state.passwordHidden) {
                        Icons.Outlined.Clear
                    } else {
                        Icons.Outlined.Lock
                    }, contentDescription = "Password hidden", tint = Theme.colors.hintTextColor
                )
            }
        ) {
            eventHandler.invoke(LoginEvent.PasswordChanged(value = it))
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.clickable { eventHandler.invoke(LoginEvent.ForgotClick) },
                text = "Forgot Password",
                color = Theme.colors.primaryAction,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryAction
            ),
            enabled = !state.isSending,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                eventHandler.invoke(LoginEvent.LoginClick)
            }) {
            Text(
                "Login Now",
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
