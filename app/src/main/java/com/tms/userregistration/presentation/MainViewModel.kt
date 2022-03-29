package com.tms.userregistration.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tms.userregistration.domain.UserInteractor
import com.tms.userregistration.domain.models.User
import kotlinx.coroutines.launch

class MainViewModel(private val interactor: UserInteractor) : ViewModel() {

    private val _submitButtonClicked = MutableLiveData<Boolean>()
    val submitButtonClicked: LiveData<Boolean> get() = _submitButtonClicked

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun onSubmitButtonClicked() {
        val value = _submitButtonClicked.value
        _submitButtonClicked.value = value?.let { !it } ?: false
    }

    fun createUser(login: String, password: String) {
        viewModelScope.launch {
            interactor.createUser(login, password)
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            _users.postValue(interactor.getUsers())
        }
    }
}