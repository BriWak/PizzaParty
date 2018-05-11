object PizzaParty extends App {

  def apply(apprentices: Int, order: PizzaOrder) : String = {

    val orderAsDecimals = order.slices.map(x => x.head.asDigit.toDouble / x.last.asDigit.toDouble)
    val moreThanOne = if (apprentices > 1) "s" else ""
    val pizzas = orderAsDecimals.sum.ceil.toInt
    val multiPizzas = if (pizzas > 1) "s" else ""
    val remainder = ((pizzas - orderAsDecimals.sum) * 8).toInt
    val leftovers = if (remainder == 0 || remainder == 8) "no" else remainder
    val nonPizzaEaters = apprentices - order.slices.length
    val pizzaHaters = if (nonPizzaEaters <= 0) "" else s" There are $nonPizzaEaters apprentices that don't want pizza!"
    s"To feed $apprentices hungry apprentice$moreThanOne, I need $pizzas pizza$multiPizzas. I have $leftovers leftover slices!$pizzaHaters"
  }
}

case class PizzaOrder(slices: String*)

