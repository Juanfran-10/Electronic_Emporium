package com.juanfran.electronic_emporium.di

import com.juanfran.electronic_emporium.domain.repository.*
import com.juanfran.electronic_emporium.domain.useCase.address.AddressUseCase
import com.juanfran.electronic_emporium.domain.useCase.address.CreateAddressUseCase
import com.juanfran.electronic_emporium.domain.useCase.address.FindByUserAddressUseCase
import com.juanfran.electronic_emporium.domain.useCase.auth.*
import com.juanfran.electronic_emporium.domain.useCase.categories.*
import com.juanfran.electronic_emporium.domain.useCase.mercado_pago.*
import com.juanfran.electronic_emporium.domain.useCase.orders.FindAllOrdersUseCase
import com.juanfran.electronic_emporium.domain.useCase.orders.FindByClientOrdersUseCase
import com.juanfran.electronic_emporium.domain.useCase.orders.OrdersUseCase
import com.juanfran.electronic_emporium.domain.useCase.orders.UpdateStatusOrdersUseCase
import com.juanfran.electronic_emporium.domain.useCase.products.*
import com.juanfran.electronic_emporium.domain.useCase.shopping_bag.*
import com.juanfran.electronic_emporium.domain.useCase.users.UpdateUserUseCase
import com.juanfran.electronic_emporium.domain.useCase.users.UpdateUserWithImageUseCase
import com.juanfran.electronic_emporium.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )

    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository) = CategoriesUseCase(
        createCategory = CreateCategoryUseCase(categoriesRepository),
        getCategories = GetCategoriesUseCase(categoriesRepository),
        updateCategory = UpdateCategoryUseCase(categoriesRepository),
        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoriesRepository),
        deleteCategory = DeleteCategoryUseCase(categoriesRepository)
    )

    @Provides
    fun provideProductsUseCase(productsRepository: ProductsRepository) = ProductsUseCase(
        createProduct = CreateProductUseCase(productsRepository),
        findByCategory = FindByCategoryUseCase(productsRepository),
        findAll = FindAllUseCase(productsRepository),
        updateProduct = UpdateProductUseCase(productsRepository),
        updateProductWithImage = UpdateProductWithImageUseCase(productsRepository),
        deleteProduct = DeleteProductUseCase(productsRepository),
        findByName = FindByNameUseCase(productsRepository)
    )

    @Provides
    fun provideShoppingBagUseCase(shoppingBagRepository: ShoppingBagRepository) = ShoppingBagUseCase(
        add = AddUseCase(shoppingBagRepository),
        delete = DeleteUseCase(shoppingBagRepository),
        findAll = FindAllShoppingBagUseCase(shoppingBagRepository),
        findById = FindByIdShoppingBagUseCase(shoppingBagRepository),
        getTotal = GetTotalUseCase(shoppingBagRepository)
    )

    @Provides
    fun provideAddressUseCase(addressRepository: AddressRepository) = AddressUseCase(
        createAddress = CreateAddressUseCase(addressRepository),
        findByUserAddress = FindByUserAddressUseCase(addressRepository)
    )

    @Provides
    fun provideMercadoPagoUseCase(mercadoPagoRepository: MercadoPagoRepository) = MercadoPagoUseCase(
        getIdentificationType = GetIdentificationTypeUseCase(mercadoPagoRepository),
        getInstallments = GetInstallmentsUseCase(mercadoPagoRepository),
        createCardToken = CreateCardTokenUseCase(mercadoPagoRepository),
        createPayment = CreatePaymentUseCase(mercadoPagoRepository),
    )

    @Provides
    fun provideOrdersUseCase(ordersRepository: OrdersRepository) = OrdersUseCase(
        findAllOrders = FindAllOrdersUseCase(ordersRepository),
        findByClientOrders = FindByClientOrdersUseCase(ordersRepository),
        updateStatusOrders = UpdateStatusOrdersUseCase(ordersRepository)
    )
}