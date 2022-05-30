package com.example.csu_android_brewery.presentation.DI.Modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.csu_android_brewery.presentation.VM.*
import com.example.csu_android_brewery.presentation.VM.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AbstractMainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AbstractDetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AbstractFavViewModel::class)
    abstract fun bindFav(favViewModel: FavsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AbstractSearchViewModel::class)
    abstract fun bindSearch(vm: SearchViewModel) : ViewModel
}