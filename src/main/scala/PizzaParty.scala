object PizzaParty{

  def apply(apprentices: Int, order: PizzaOrder) : String = {

    val pizzas = order.wholePizzas
    val remainder = order.leftovers

    val addS = if (apprentices > 1) "s" else ""
    val pluralPizzas = if (pizzas > 1) "s" else ""
    val leftovers = if (remainder == 0) "no" else remainder
    val nonPizzaEaters = apprentices - order.slices.length
    val pizzaHaters = if (nonPizzaEaters <= 0) "" else s" There are $nonPizzaEaters apprentices that don't want pizza!"

    s"To feed $apprentices hungry apprentice$addS, I need $pizzas pizza$pluralPizzas. I have $leftovers leftover slices!$pizzaHaters"
  }
}

case class PizzaOrder(slices: String*) {

  def asDoubles: Seq[Double] = {
    slices.map(x =>  x.head.asDigit.toDouble / x.last.asDigit.toDouble)
  }

  def wholePizzas: Int = {
    this.asDoubles.sum.ceil.toInt
  }

  def leftovers: Int = {
    ((this.wholePizzas - this.asDoubles.sum) * 8).toInt
  }
}
