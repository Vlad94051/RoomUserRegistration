package com.tms.userregistration.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tms.userregistration.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initObservers()
    }

    private fun initViews() {
        submitBtn.setOnClickListener {
            viewModel.onSubmitButtonClicked()
        }
    }

    private fun initObservers() {
        viewModel.submitButtonClicked.observe(this) {
            viewModel.createUser(
                login = login.text.toString(),
                password = password.text.toString()
            )
            viewModel.getUsers()
        }

        viewModel.users.observe(this) { users ->
            Log.e("!!!: ", users.toString())
        }
    }
}
