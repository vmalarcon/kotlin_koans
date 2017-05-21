package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer whose order count is the highest among all customers
    return this.customers.maxBy { it -> it.orders.size }
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    return this.orderedProducts.maxBy { it -> it.price }
}
