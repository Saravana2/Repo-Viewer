package com.repo.viewer.presentation

import androidx.appcompat.app.AppCompatActivity
import com.repo.viewer.presentation.di.Injector

open class BaseActivity : AppCompatActivity() {
    fun getAppInjector() = application as Injector
}