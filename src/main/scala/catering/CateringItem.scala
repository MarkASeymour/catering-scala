package catering

class CateringItem (var name: String, var price: Double, var itemId: String, var foodCat: String,var quantity: Int = 50){

  def decreaseQuant(amountToDecrease: Int): Int = {
    quantity = quantity - amountToDecrease
    quantity
  }

  def getQuantString(): String = {
    if (quantity == 0) {"SOLD OUT"}
    else {quantity.toString}
  }

  def isSoldOut(): Boolean = {
    if(quantity == 0) {true}
    else{false}
  }
  def getFoodCat(): String = {
    foodCat match {
      case "B" => "Beverage"
      case "A" => "Appetizer"
      case "E" => "Entree"
      case "D" => "Dessert"
    }
  }
  def getName: String = {
    name
  }


}
