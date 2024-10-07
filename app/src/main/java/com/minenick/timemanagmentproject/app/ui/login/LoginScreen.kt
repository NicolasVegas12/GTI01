package com.minenick.timemanagmentproject.app.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.minenick.timemanagmentproject.R
import com.minenick.timemanagmentproject.app.components.button.TimeManagementButton
import com.minenick.timemanagmentproject.app.components.inputs.OutlinedTextInput
import com.minenick.timemanagmentproject.app.components.inputs.PasswordOutlinedTextInput
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme

@Composable
fun LoginScreen(
    login: () -> Unit,
) {
    val (email, password) = FocusRequester.createRefs()
    var toRegisterClicked by remember { mutableStateOf(false) }
    var toForgotPasswordClicked by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(20.dp)
                .imePadding()
                .fillMaxSize()
        ) {
            val (header, body, footer) = createRefs()

            Box(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(header) {
                    top.linkTo(parent.top)
                }) {

            }

            Column(
                modifier = Modifier.constrainAs(body) {
                    top.linkTo(header.bottom)
                    bottom.linkTo(footer.top)
                },
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                androidx.compose.material.Text(
                    text = stringResource(id = R.string.txt_sign_in_title),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                OutlinedTextInput(
                    modifier = Modifier
                        .focusRequester(email)
                        .focusProperties { next = password },
                    name = stringResource(id = R.string.txt_sign_in_email_input),
                    text = "",
                    onTextFieldChanged = { }
                )
                PasswordOutlinedTextInput(
                    modifier = Modifier
                        .focusRequester(password)
                        .focusProperties { previous = email },
                    name = stringResource(id = R.string.txt_sign_in_password_input),
                    text = "",
                    onTextFieldChanged = { }
                )
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                    Spacer(modifier = Modifier.height(7.dp))
                    androidx.compose.material.Text(
                        text = stringResource(id = R.string.txt_sign_in_forgot_password),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.clickable {
                            toForgotPasswordClicked = true
                        }
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.constrainAs(footer) {
                    bottom.linkTo(parent.bottom)
                }) {
                TimeManagementButton(
                    modifier = Modifier.testTag("LoginButton"),
                    text = stringResource(id = R.string.txt_sign_in_enter_button),
                    onClick = login
                )
                Row (verticalAlignment = Alignment.CenterVertically){
                    androidx.compose.material.Text(
                        text = stringResource(id = R.string.txt_sign_in_dont_have_account),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    androidx.compose.material.Text(
                        text = stringResource(id = R.string.txt_sign_in_register),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.clickable {
                            toRegisterClicked = true
                        }
                    )
                }
            }
        }
    }
}

@Preview(name = "LightMode")
@Preview(name = "NightMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewLoginScreen() {
    TimeManagmentProjectTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            LoginScreen {}
        }
    }
}