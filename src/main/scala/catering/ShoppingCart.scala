package catering

import java.text.DecimalFormat
import scala.math._

class ShoppingCart (var cart: Map[String, Int] = Map.empty, var balance: Double = 0){

  def addToCart(itemId: String, quantity: Int): Unit = {
    if(!cart.contains(itemId)) {
      cart += (itemId -> quantity)
    } else {
      cart += (itemId -> (cart(itemId) + quantity))
    }
  }

  def addToBalance(money: Double): Unit = {
    balance += money
    balance
  }

  def subtractFromBalance(money: Double): Unit = {
    balance -= money
    balance
  }

  def getAmountOwed(inventoryOne: Inventory): Double = {
    var totalOwed: Double = 0
    for(key <- cart.keys) {
      val price: Double = inventoryOne.inventoryMap(key).price
      val quantity = cart(key)
      totalOwed += price * quantity
    }
    totalOwed
  }

  def getTotalPrice(inventoryOne: Inventory, id: String, quantity: Int): Double = {
    val price = inventoryOne.inventoryMap(id).price
    val totalPrice = price * quantity
    totalPrice
  }

  def finalBill(inventory: Inventory): List[String] = {
     val format: DecimalFormat = new DecimalFormat("##.00")
     var billList: List[String] = List.empty
    for((k,v) <- cart) {
      val itemType = inventory.inventoryMap(k).foodCat
      val name = inventory.inventoryMap(k).name
      val unitPrice = "$" + format.format(inventory.inventoryMap(k).price)
      val totalUnitPrice = "$" + format.format(getTotalPrice(inventory, k, v))
      billList :+ "%-3s  %-10s  %-20s  %-8s  %-8s".format(v, itemType, name, unitPrice, totalUnitPrice)

    }
    billList
  }

}
