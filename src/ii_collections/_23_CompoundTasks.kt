package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return this.customers.filter { it -> it.orderedProducts.contains(product)}.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return this.orders.filter { it -> it.isDelivered }.flatMap { o -> o.products }.maxBy { p -> p.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return this.customers.flatMap { it -> it.orders }.flatMap { it -> it.products }.filter {it -> it == product}.count()
}
