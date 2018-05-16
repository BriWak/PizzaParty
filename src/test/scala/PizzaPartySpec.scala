import org.scalatest.{MustMatchers, WordSpec}

class PizzaPartySpec extends WordSpec with MustMatchers {

  "PizzaParty" must {

    "return 1 pizza with no leftover slices' when given 1 Apprentice that eats 1 pizza" in {
      PizzaParty(1,PizzaOrder("1")) mustEqual "To feed 1 hungry apprentice, I need 1 pizza. I have no leftover slices!"
    }

    "return 1 pizza with no leftover slices' when given 2 Apprentice that eat 1/2 pizza each" in {
      PizzaParty(2,PizzaOrder("1/2","1/2")) mustEqual "To feed 2 hungry apprentices, I need 1 pizza. I have no leftover slices!"
    }

    "return 2 pizzas with no leftover slices' when given 2 Apprentice that eat 1 pizza each" in {
      PizzaParty(2,PizzaOrder("1","1")) mustEqual "To feed 2 hungry apprentices, I need 2 pizzas. I have no leftover slices!"
    }

    "return 1 pizza with 4 leftover slices' when given 1 Apprentice that eats 1/2 pizza" in {
      PizzaParty(1,PizzaOrder("1/2")) mustEqual "To feed 1 hungry apprentice, I need 1 pizza. I have 4 leftover slices!"
    }

    "return 1 pizza with 2 leftover slices' when given 1 Apprentice that eats 3/4 pizza" in {
      PizzaParty(1,PizzaOrder("3/4")) mustEqual "To feed 1 hungry apprentice, I need 1 pizza. I have 2 leftover slices!"
    }

    "return 2 pizzas with 4 leftover slices' when given 3 Apprentices that eat 1/2 pizza each" in {
      PizzaParty(3,PizzaOrder("1/2","1/2","1/2")) mustEqual "To feed 3 hungry apprentices, I need 2 pizzas. I have 4 leftover slices!"
    }

    "return 3 pizzas with no leftover slices' when given 3 Apprentices that eat 1/2, 3/4, and 3/4 pizza each" in {
      PizzaParty(3,PizzaOrder("1/2","3/4","3/4")) mustEqual "To feed 3 hungry apprentices, I need 2 pizzas. I have no leftover slices!"
    }

    "return 4 pizzas with 4 leftover slices' when given 7 Apprentices that eat 1/2, 3/4, 1/2, 1/4, 1/4, 1/2, and 3/4 pizza each" in {
      PizzaParty(7,PizzaOrder("1/2","3/4","1/2","1/4","1/4","1/2","3/4")) mustEqual "To feed 7 hungry apprentices, I need 4 pizzas. I have 4 leftover slices!"
    }
    "return 4 pizzas with 4 leftover slices' when given 8 Apprentices that eat 1/2, 3/4, 1/2, 1/4, 1/4, 1/2, and 3/4 pizza each, with one not eating" in {
      PizzaParty(8,PizzaOrder("1/2","3/4","1/2","1/4","1/4","1/2","3/4")) mustEqual "To feed 8 hungry apprentices, I need 4 pizzas. I have 4 leftover slices! There are 1 apprentices that don't want pizza!"
    }
  }
}
