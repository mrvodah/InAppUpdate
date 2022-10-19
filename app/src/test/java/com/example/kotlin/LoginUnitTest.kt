package com.example.kotlin

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginUnitTest {

    @Mock
    private lateinit var context: Context

    @Before
    fun init() {
        context = ApplicationProvider.getApplicationContext()
    }

    @After
    fun release() {

    }

    @Test
    fun checkString_isTheSame_ReturnsTrue() {
        val actualValue = context.getString(R.string.app_name)
        val expectValue = "Hello World"

        Assert.assertEquals(expectValue, actualValue)
    }

    @Test
    fun isLoginOk_userNameEmpty_ReturnsTrue() {

    }

}