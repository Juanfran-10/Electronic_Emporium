package com.juanfran.electronic_emporium.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juanfran.electronic_emporium.data.dataSource.local.dao.AddressDao
import com.juanfran.electronic_emporium.data.dataSource.local.dao.CategoriesDao
import com.juanfran.electronic_emporium.data.dataSource.local.dao.ProductsDao
import com.juanfran.electronic_emporium.data.dataSource.local.dao.ShoppingBagDao
import com.juanfran.electronic_emporium.data.dataSource.local.entity.AddressEntity
import com.juanfran.electronic_emporium.data.dataSource.local.entity.CategoryEntity
import com.juanfran.electronic_emporium.data.dataSource.local.entity.ProductEntity
import com.juanfran.electronic_emporium.data.dataSource.local.entity.ShoppingBagProductEntity

@Database(
    entities = [CategoryEntity::class, ProductEntity::class, ShoppingBagProductEntity::class, AddressEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EcommerceDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao // DATA ACCESS OBJECT
    abstract fun productsDao(): ProductsDao
    abstract fun shoppingBagDao(): ShoppingBagDao
    abstract fun addressDao(): AddressDao
}