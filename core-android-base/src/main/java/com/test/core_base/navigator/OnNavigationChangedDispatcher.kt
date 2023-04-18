package com.test.core_base.navigator

interface OnNavigationChangedDispatcher {

    suspend fun handleOnChanged(): Boolean
}