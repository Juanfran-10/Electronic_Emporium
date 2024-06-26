package com.juanfran.electronic_emporium.di

import com.juanfran.electronic_emporium.data.dataSource.local.*
import com.juanfran.electronic_emporium.data.dataSource.local.dao.AddressDao
import com.juanfran.electronic_emporium.data.dataSource.local.datastore.AuthDatastore
import com.juanfran.electronic_emporium.data.dataSource.local.dao.CategoriesDao
import com.juanfran.electronic_emporium.data.dataSource.local.dao.ProductsDao
import com.juanfran.electronic_emporium.data.dataSource.local.dao.ShoppingBagDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource =
        CategoriesLocalDataSourceImpl(categoriesDao)

    @Provides
    fun provideProductsLocalDataSource(productsDao: ProductsDao): ProductsLocalDataSource =
        ProductsLocalDataSourceImpl(productsDao)

    @Provides
    fun provideShoppingBagLocalDataSource(shoppingBagDao: ShoppingBagDao): ShoppingBagLocalDataSource =
        ShoppingBagLocalDataSourceImpl(shoppingBagDao)

    @Provides
    fun provideAddressLocalDataSource(addressDao: AddressDao): AddressLocalDataSource =
        AddressLocalDataSourceImpl(addressDao)
}