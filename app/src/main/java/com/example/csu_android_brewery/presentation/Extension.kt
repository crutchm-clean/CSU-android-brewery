package com.example.csu_android_brewery.presentation

import android.content.Context

val Context.factory get() = (applicationContext as App).appComponent.factory()