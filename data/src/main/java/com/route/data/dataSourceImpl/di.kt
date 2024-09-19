package com.route.data.dataSourceImpl

import com.route.data.dataSourcesContract.AuthOnlineDataSource
import com.route.data.dataSourcesContract.CategoriesOnlineDataSource
import com.route.data.dataSourcesContract.ProductsOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceBinder{

    @Binds
    abstract fun bindOnlineDataSource(
        categoriesOnlineDataSourceImpl: CategoriesOnlineDataSourceImpl
    ): CategoriesOnlineDataSource

    @Binds
    abstract fun bindAuthDataSource(
        datasourceImpl: AuthOnlineDataSourceImpl
    ): AuthOnlineDataSource

    @Binds
    abstract fun bindProductsDataSource(
        datasourceImpl: ProductsOnlineDataSourceImpl
    ): ProductsOnlineDataSource
}